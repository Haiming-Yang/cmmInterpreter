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
public class DefPhaseListener extends cmmBaseListener {


    private IOInterface io;
    private LLVMIO llvmIO;


    public DefPhaseListener(IOInterface io, LLVMIO llvmIO){

        this.io = io;
        this.llvmIO = llvmIO;
    }

    // 是一个IdentityHashMap<ParseTree,T>
    ParseTreeProperty<Scope> scopes = new ParseTreeProperty<Scope>();
    GlobalScope globals;
    Scope currentScope;

    public void saveScope(ParserRuleContext ctx, Scope scope){
        scopes.put(ctx, scope);
    }

    @Override
    public void enterProgram(cmmParser.ProgramContext ctx) {
        super.enterProgram(ctx);
        globals = new GlobalScope(null);
        currentScope = globals;

    }

    @Override
    public void exitProgram(cmmParser.ProgramContext ctx) {
        super.exitProgram(ctx);

    }

    @Override
    public void enterStmt_block(cmmParser.Stmt_blockContext ctx) {
        super.enterStmt_block(ctx);
        currentScope = new LocalScope(currentScope);
        saveScope(ctx, currentScope);
    }

    @Override
    public void exitStmt_block(cmmParser.Stmt_blockContext ctx) {
        super.exitStmt_block(ctx);
        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void enterVarlist(cmmParser.VarlistContext ctx) {
        super.enterVarlist(ctx);

        // 变量类型，变量列表里的变量类型都是相同的
        String typeStr = ctx.getParent().getChild(0).getText();

        // 数组声明，数组不支持声明时赋值
        for(cmmParser.ArrayContext arrayContext: ctx.array()){
            String name = arrayContext.Ident().getSymbol().getText();
            int size = Integer.parseInt(arrayContext.IntConstant().getText());

            if(currentScope.redundant(name)){
                io.output("ERROR: redundant definition of <"
                        + name
                        + "> in same scope in line "
                        + arrayContext.Ident().getSymbol().getLine()
                        + ":"
                        + arrayContext.Ident().getSymbol().getCharPositionInLine());
                return;
            }else{
                if(typeStr.equals("int")){
                    currentScope.define(new Symbol(name, Type.tIntArray, new int[size]));
                }else{
                    currentScope.define(new Symbol(name, Type.tRealArray, new double[size]));
                }
            }

        }

        // 普通变量声明
        for(TerminalNode node : ctx.getTokens(cmmParser.Ident)){

            // 在当前作用域内定义，这里往符号表里只是添加了变量名和类型，没有值
            if(currentScope.redundant(node.getSymbol().getText())){
                io.output("ERROR: redundant definition of <"
                        + node.getSymbol().getText()
                        + "> in same scope in line "
                        + node.getSymbol().getLine()
                        + ":"
                        + node.getSymbol().getCharPositionInLine());
                return;
            }else{
                currentScope.define(new Symbol(node.getSymbol().getText(),
                        typeStr.equals("int")? Type.tInt : Type.tReal));
            }

        }

        // 普通变量在声明时赋值
        for(cmmParser.Decl_assignContext decl_assignContext : ctx.decl_assign()){
            Token token = decl_assignContext.Ident().getSymbol();
            ExprComputeVisitor exprComputeVisitor = new ExprComputeVisitor(currentScope, io);
            ExprReturnVal value = exprComputeVisitor.visit(decl_assignContext.expr());
            if(value.getType() != (typeStr.equals("int")? Type.tInt : Type.tReal)){
                io.output("ERROR: unmatched type on two side of <"
                        + token.getText()
                        + "> in line "
                        + token.getLine()
                        +":"
                        + token.getCharPositionInLine());
                return;
            }

            // 在当前作用域内定义，这里往符号表里只是添加了变量名和类型，没有值
            if(currentScope.redundant(token.getText())){
                io.output("ERROR: redundant definition of <"
                        + token.getText()
                        + "> in same scope in line "
                        + token.getLine()
                        + ":"
                        + token.getCharPositionInLine());
                return;
            }else{
                currentScope.define(new Symbol(token.getText(),
                        typeStr.equals("int")? Type.tInt : Type.tReal,
                        value.getValue()));

            }
        }

    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        super.visitErrorNode(node);
        io.output("ERROR: " + node.getText()
                +" in line " + node.getSymbol().getLine()
                +":" +node.getSymbol().getCharPositionInLine());
    }

}
