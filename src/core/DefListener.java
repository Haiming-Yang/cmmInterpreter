package core;

import IO.LLVMIO;
import antlr.cmmBaseListener;
import antlr.cmmParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Created by steveyyy on 2016/12/29.
 */
public class DefListener extends cmmBaseListener {


    private IOInterface io;
    private LLVMIO llvmIO;


    public DefListener(IOInterface io, LLVMIO llvmIO){

        this.io = io;
        this.llvmIO = llvmIO;
    }

    // 是一个IdentityHashMap<ParseTree,T>
    ParseTreeProperty<SymbolList> symbolList = new ParseTreeProperty<SymbolList>();
    GlobalSymbolList globals;
    SymbolList currentSymbolList;
    public boolean defSucOrNot = true;

    public void saveSymbolList(ParserRuleContext ctx, SymbolList symbolList){
        this.symbolList.put(ctx, symbolList);
    }

    @Override
    public void enterProgram(cmmParser.ProgramContext ctx) {
        super.enterProgram(ctx);
        globals = new GlobalSymbolList(null);
        currentSymbolList = globals;

    }

    @Override
    public void exitProgram(cmmParser.ProgramContext ctx) {
        super.exitProgram(ctx);
        //defSucOrNot = true;

    }

    @Override
    public void enterStmt_block(cmmParser.Stmt_blockContext ctx) {
        super.enterStmt_block(ctx);
        currentSymbolList = new LocalSymbolList(currentSymbolList);
        saveSymbolList(ctx, currentSymbolList);
    }

    @Override
    public void exitStmt_block(cmmParser.Stmt_blockContext ctx) {
        super.exitStmt_block(ctx);
        currentSymbolList = currentSymbolList.getEnclosingSymbolList();
    }

    @Override
    public void enterVarlist(cmmParser.VarlistContext ctx) {
        super.enterVarlist(ctx);

        String typeStr = ctx.getParent().getChild(0).getText();

        // 数组声明，数组不支持声明时赋值
        for(cmmParser.ArrayContext arrayContext: ctx.array()){
            String name = arrayContext.Ident().getSymbol().getText();
            //if(ctx.array())

            int size = Integer.parseInt(arrayContext.IntConstant().getText());
            if(size <= 0 ){
                defSucOrNot = false;
                io.output("ERROR: invaild array index <"
                        + name
                        + "> in line "
                        + arrayContext.Ident().getSymbol().getLine()
                        + ":"
                        + arrayContext.Ident().getSymbol().getCharPositionInLine());
                return;
            }

            else if(currentSymbolList.redundant(name)){
                defSucOrNot = false;
                io.output("ERROR: redundant definition of <"
                        + name
                        + "> in same symbolList in line "
                        + arrayContext.Ident().getSymbol().getLine()
                        + ":"
                        + arrayContext.Ident().getSymbol().getCharPositionInLine());
                return;
            }
            else{
                if(typeStr.equals("int")){
                    currentSymbolList.define(new Symbol(name, Type.tIntArray, new int[size]));
                }else{
                    currentSymbolList.define(new Symbol(name, Type.tRealArray, new double[size]));
                }
            }

        }

        // 普通变量声明
        for(TerminalNode node : ctx.getTokens(cmmParser.Ident)){

            // 在当前作用域内定义，这里往符号表里只是添加了变量名和类型，没有值
            if(currentSymbolList.redundant(node.getSymbol().getText())){
                defSucOrNot = false;
                io.output("ERROR: redundant definition of <"
                        + node.getSymbol().getText()
                        + "> in same symbolList in line "
                        + node.getSymbol().getLine()
                        + ":"
                        + node.getSymbol().getCharPositionInLine());
                return;
            }else{
                currentSymbolList.define(new Symbol(node.getSymbol().getText(),
                        typeStr.equals("int")? Type.tInt : Type.tDouble));
            }

        }

        // 普通变量在声明时赋值
        for(cmmParser.Decl_assignContext decl_assignContext : ctx.decl_assign()){
            Token token = decl_assignContext.Ident().getSymbol();
            ComputeVisitor computeVisitor = new ComputeVisitor(currentSymbolList, io);
            ReturnVal value = computeVisitor.visit(decl_assignContext.expr());
//            if(value.getType() != (typeStr.equals("int")? Type.tInt : Type.tReal)){
//                io.output("ERROR: unmatched type on two side of <"
//                        + token.getText()
//                        + "> in line "
//                        + token.getLine()
//                        +":"
//                        + token.getCharPositionInLine());
//                return;
//            }

            // 在当前作用域内定义，这里往符号表里只是添加了变量名和类型，没有值
            if(currentSymbolList.redundant(token.getText())){
                defSucOrNot = false;
                io.output("ERROR: redundant definition of <"
                        + token.getText()
                        + "> in same symbolList in line "
                        + token.getLine()
                        + ":"
                        + token.getCharPositionInLine());
                return;
            }else{
                if(typeStr.equals("int")){
                    if(value.getValue() instanceof Integer){
                        currentSymbolList.define(new Symbol(token.getText(),
                                Type.tInt ,
                                value.getValue()));

                    }
                    else{
                        Double d =(Double)value.getValue();
                        Integer i = d.intValue();
                        currentSymbolList.define(new Symbol(token.getText(),
                                Type.tInt, i));
                        io.output("WARNING: 精度衰减 <"
                                + token.getText()
                                + "> in same symbolList in line "
                                + token.getLine()
                                + ":"
                                + token.getCharPositionInLine());

                    }
                }
                else {
                    if(typeStr.equals("double")){
                        currentSymbolList.define(new Symbol(token.getText(),
                                Type.tDouble,
                                value.getValue()));

                    }
                    else {
                        Integer i = (Integer)value.getValue();
                        Double d = i.doubleValue();
                        currentSymbolList.define(new Symbol(token.getText(),
                                Type.tDouble,
                                i));
                        io.output("WARNING: 隐式转换 <"
                                + token.getText()
                                + "> in same symbolList in line "
                                + token.getLine()
                                + ":"
                                + token.getCharPositionInLine());

                    }
                }
                currentSymbolList.define(new Symbol(token.getText(),
                        typeStr.equals("int")? Type.tInt : Type.tDouble,
                        value.getValue()));

            }
        }

    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        super.visitErrorNode(node);
        defSucOrNot = false;
        io.output("ERROR: " + node.getText()
                +" in line " + node.getSymbol().getLine()
                +":" +node.getSymbol().getCharPositionInLine());
    }

}
