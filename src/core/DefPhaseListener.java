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
    private boolean writeOrNot = false;
    private boolean readOrNot = false;

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
//        if(Constant.LLVM) {
//            llvmIO.output("define i32 @main() #0 {");
//            llvmIO.output("%1 = alloca i32, align 4\n" +
//                    "store i32 0, i32* %1, align 4");
//        }
    }

    @Override
    public void exitProgram(cmmParser.ProgramContext ctx) {
        super.exitProgram(ctx);
////        if(Constant.LLVM) {
////            llvmIO.output("ret i32 0");
////            llvmIO.output("}");
////            if(readOrNot){
////               // llvmIO.output("declare i32 @getchar() #1");
////            }
////            if (writeOrNot){
//////                llvmIO.output("declare i32 @printf(i8*, ...) #1");
//////                llvmIO.output("declare i32 @putchar(i32) #1");
//////                llvmIO.output(0,"@.str = private unnamed_addr constant [2 x i8] c\"\\0A\\00\", align 1");
////            }
////            //llvmIO.print(llvmIO);
//        }
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
            /**
             * 数组只声明不赋值的情况下，生成IR Code
             */
//            if(Constant.LLVM){
//                if(typeStr.equals("int")) {
//                    llvmIO.selfAddSSA();
//                    llvmIO.output("%" + llvmIO.getSSA() + " = alloca [" + size + "x i32], align 16");
//                    llvmIO.varMap.put(name,llvmIO.getSSA());
//                }
//                else if (typeStr.equals("real")){
//                    llvmIO.selfAddSSA();
//                    llvmIO.output("%" + llvmIO.getSSA() + " = alloca [" + size + "x double], align 16");
//                    llvmIO.varMap.put(name,llvmIO.getSSA());
//                }
//            }
            // 在当前作用域内定义，名称，类型，值
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
                    currentScope.define(new Var(name, Type.tIntArray, new int[size]));
                }else{
                    currentScope.define(new Var(name, Type.tRealArray, new double[size]));
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
                currentScope.define(new Var(node.getSymbol().getText(),
                        typeStr.equals("int")? Type.tInt : Type.tReal));
            }
            //IR生成 普通变量声明
//            if(Constant.LLVM){
//                if(typeStr.equals("int")) {
//                    llvmIO.selfAddSSA();
//                    llvmIO.output(
//                            "%" + llvmIO.getSSA() + " = " + "alloca i32, align 4");
//                    llvmIO.varMap.put(node.getSymbol().getText(),llvmIO.getSSA());
//                }
//                else if(typeStr.equals("real")){
//                    llvmIO.selfAddSSA();
//                    llvmIO.output(
//                            "%" + llvmIO.getSSA() + " = " + "alloca double, align 8");
//                    llvmIO.varMap.put(node.getSymbol().getText(),llvmIO.getSSA());
//                }
//                else {
//                    io.output("llvm wrong");
//                }
//            }
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
                currentScope.define(new Var(token.getText(),
                        typeStr.equals("int")? Type.tInt : Type.tReal,
                        value.getValue()));
//                if(Constant.LLVM){
//                    if(typeStr.equals("int")) {
//                        llvmIO.selfAddSSA();
//                        llvmIO.output(
//                                "%"
//                                        + llvmIO.getSSA()
//                                        + "="
//                                        + "alloca i32, align 4\n"
//                                        + "store i32 "
//                                        + value.getValue()
//                                        + ", i32* %" + llvmIO.getSSA() + ", align 4");
//                        llvmIO.varMap.put(token.getText(),llvmIO.getSSA());
//                    }
//                    else {
//                        llvmIO.selfAddSSA();
//                        llvmIO.output(
//                                "%"
//                                        + llvmIO.getSSA()
//                                        + "="
//                                        + "double, align 8\n"
//                                        + "store double "
//                                        + value.getValue()
//                                        + ", i32* %" + llvmIO.getSSA() + ", align 4");
//                        llvmIO.varMap.put(token.getText(),llvmIO.getSSA());
//                    }
//                }
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
