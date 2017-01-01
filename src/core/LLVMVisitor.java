package core;

import IO.LLVMIO;
import antlr.cmmBaseVisitor;
import antlr.cmmParser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Created by steveyyy on 2016/12/31.
 */
public class LLVMVisitor extends cmmBaseVisitor<ExprReturnVal> {
    private IOInterface io;
    private LLVMIO llvmIO;

    ParseTreeProperty<Scope> scopes;
    GlobalScope globals;
    Scope currentScope;
    public LLVMIO getLlvmIO(){
        return llvmIO;
    }

    public LLVMVisitor(GlobalScope globals, ParseTreeProperty<Scope> scopes, IOInterface io, LLVMIO llvmIO) {
        this.io = io;
        this.globals = globals;
        this.scopes = scopes;
        this.llvmIO = llvmIO;
    }

    @Override
    public ExprReturnVal visitProgram(cmmParser.ProgramContext ctx) {
        currentScope = globals;
        super.visitProgram(ctx);
        if(Constant.LLVM) {
            llvmIO.output("ret i32 0\n" +
                    "}" );
            llvmIO.output(0,"define i32 @main() #0 {\n"+
                    "%1 = alloca i32, align 4\n" +
                    "store i32 0, i32* %1, align 4");
        }
        if(llvmIO.getWriteOrNot()){
            llvmIO.output(0,"@.str = private unnamed_addr constant [4 x i8] c\"%d\\0A\\00\", align 1");
            llvmIO.output("declare i32 @printf(i8*, ...) #1");

        }
        return null;
    }

    @Override
    public ExprReturnVal visitStmt_block(cmmParser.Stmt_blockContext ctx) {
        currentScope = scopes.get(ctx);
        super.visitStmt_block(ctx);
        currentScope = currentScope.getEnclosingScope();
        return null;
    }
    @Override public ExprReturnVal visitVarlist(cmmParser.VarlistContext ctx) {
        super.visitVarlist(ctx);
        String typeStr = ctx.getParent().getChild(0).getText();
        for(cmmParser.ArrayContext arrayContext: ctx.array()){
            String name = arrayContext.Ident().getSymbol().getText();
            int size = Integer.parseInt(arrayContext.IntConstant().getText());

             //在当前作用域内定义，名称，类型，值

                /**
                 * 数组只声明不赋值的情况下，生成IR Code
                 */
                if(Constant.LLVM){
                    if(typeStr.equals("int")) {
                        llvmIO.selfAddSSA();
                        llvmIO.output("%" + llvmIO.getSSA() + " = alloca [" + size + "x i32], align 16");
                        llvmIO.varMap.put(name,llvmIO.getSSA());
                    }
                    else if (typeStr.equals("real")){
                        llvmIO.selfAddSSA();
                        llvmIO.output("%" + llvmIO.getSSA() + " = alloca [" + size + "x double], align 16");
                        llvmIO.varMap.put(name,llvmIO.getSSA());
                    }
                }


        }

        // 普通变量声明
        for(TerminalNode node : ctx.getTokens(cmmParser.Ident)){


            //IR生成 普通变量声明
            if(Constant.LLVM){
                if(typeStr.equals("int")) {
                    llvmIO.selfAddSSA();
                    llvmIO.output(
                            "%" + llvmIO.getSSA() + " = " + "alloca i32, align 4");
                    llvmIO.varMap.put(node.getSymbol().getText(),llvmIO.getSSA());
                }
                else if(typeStr.equals("real")){
                    llvmIO.selfAddSSA();
                    llvmIO.output(
                            "%" + llvmIO.getSSA() + " = " + "alloca double, align 8");
                    llvmIO.varMap.put(node.getSymbol().getText(),llvmIO.getSSA());
                }
                else {
                    io.output("llvm wrong");
                }
            }
        }

        // 普通变量在声明时赋值
        for(cmmParser.Decl_assignContext decl_assignContext : ctx.decl_assign()){
            Token token = decl_assignContext.Ident().getSymbol();
            ExprComputeVisitor exprComputeVisitor = new ExprComputeVisitor(currentScope, io);
            ExprReturnVal value = exprComputeVisitor.visit(decl_assignContext.expr());


            // 在当前作用域内定义，这里往符号表里只是添加了变量名和类型，没有值


                if(Constant.LLVM){
                    if(typeStr.equals("int")) {
                        llvmIO.selfAddSSA();
                        llvmIO.output(
                                "%"
                                        + llvmIO.getSSA()
                                        + "="
                                        + "alloca i32, align 4\n"
                                        + "store i32 "
                                        + value.getValue()
                                        + ", i32* %" + llvmIO.getSSA() + ", align 4");
                        llvmIO.varMap.put(token.getText(),llvmIO.getSSA());
                    }
                    else {
                        llvmIO.selfAddSSA();
                        llvmIO.output(
                                "%"
                                        + llvmIO.getSSA()
                                        + "="
                                        + "double, align 8\n"
                                        + "store double "
                                        + value.getValue()
                                        + ", i32* %" + llvmIO.getSSA() + ", align 4");
                        llvmIO.varMap.put(token.getText(),llvmIO.getSSA());
                    }
                }
            }


        return null;
    }
    @Override
    public ExprReturnVal visitAssign_stmt(cmmParser.Assign_stmtContext ctx) {
        super.visitAssign_stmt(ctx);

        if(ctx.value().Ident() == null){ // 数组
            Token token = ctx.value().array().Ident().getSymbol();
            String varName = token.getText();
            Var var = currentScope.resolve(varName);
            if(var == null){
                io.output("LLVMERROR: no such variable <"
                        + varName
                        + "> in line "
                        + token.getLine()
                        + ":" + token.getCharPositionInLine());
                return null;
            }else{
                ExprComputeVisitor exprComputeVisitor = new ExprComputeVisitor(currentScope, io);
                ExprReturnVal value = exprComputeVisitor.visit(ctx.expr()); // 右边表达式计算得到的值
                int varIndex;
                if(ctx.value().array().IntConstant() != null){ // 索引为int常量
                    varIndex = Integer.parseInt(ctx.value().array().IntConstant().getText());
                }else{ // 索引为表达式
                    ExprComputeVisitor indexComputeVisitor = new ExprComputeVisitor(currentScope, io);
                    ExprReturnVal indexValue = indexComputeVisitor.visit(ctx.value().array().expr());
                    if(indexValue.getType() != Type.tInt){
                        io.output(" LLVMERROR: invalid index for <"
                                + varName
                                + "> in line "
                                + token.getLine()
                                + ":" + token.getCharPositionInLine());
                        return null;
                    }
                    varIndex = (Integer) indexValue.getValue();
                }
                if(var.getType() == Type.tIntArray){ // int数组
                    int[] varArray = (int[]) var.getValue();
                    // 数组越界检查
                    if(0 <= varIndex && varIndex < varArray.length){
                        if(value.getValue() instanceof  Integer){
                            varArray[varIndex] = (Integer) value.getValue();
                            if(Constant.LLVM){
                                int arraySSACode = llvmIO.varMap.get(varName);
                                int size = varArray.length;
                                llvmIO.selfAddSSA();
                                llvmIO.output("%"+llvmIO.getSSA()+" = getelementptr inbounds ["+
                                        size+" x i32], ["+size+" x i32]* %"+
                                        +arraySSACode+", i64 0, i64 "+varIndex);
                                llvmIO.output("store i32 "+ value.getValue()+" , i32* %"+llvmIO.getSSA()+", align 4");
                                //llvmIO.print(llvmIO);
                            }
                        }else{
                            io.output("LLVMERROR: unmatched or uncast type during assignment of <"
                                    + varName
                                    + "> in line "
                                    + token.getLine()
                                    +":"
                                    + token.getCharPositionInLine());
                            return null;
                        }
                    }else{
                        io.output("LLVMERROR: index out of boundary of array <"
                                + varName
                                + "> in line "
                                + token.getLine()
                                + ":" + token.getCharPositionInLine());
                        return null;
                    }

                }else{ // double数组
                    double[] varArray = (double[]) var.getValue();
                    // 数组越界检查
                    if(0 <= varIndex && varIndex < varArray.length){
                        if(value.getValue() instanceof  Double){
                            varArray[varIndex] = (Double) value.getValue();
                            if(Constant.LLVM){
                                int arraySSACode = llvmIO.varMap.get(varName);
                                int size = varArray.length;
                                llvmIO.selfAddSSA();
                                llvmIO.output("%"+llvmIO.getSSA()+" = getelementptr inbounds ["+
                                        size+" x double], ["+size+" x double]* %"+
                                        +arraySSACode+", i64 0, i64 "+varIndex);
                                llvmIO.output("store double "+ value.getValue()+" , double* %"+llvmIO.getSSA()+", align 8");
                                //llvmIO.print(llvmIO);
                            }
                        }else if(value.getValue() instanceof  Integer){
                            varArray[varIndex] = (Integer) value.getValue();
                            if(Constant.LLVM){
                                int arraySSACode = llvmIO.varMap.get(varName);
                                int size = varArray.length;
                                llvmIO.selfAddSSA();
                                llvmIO.output("%"+llvmIO.getSSA()+" = getelementptr inbounds ["+
                                        size+" x double], ["+size+" x double]* %"+
                                        +arraySSACode+", i64 0, i64 "+varIndex);
                                llvmIO.output("store double "+ value.getValue()+".000000e+00 , double* %"+llvmIO.getSSA()+", align 8");
                                //llvmIO.print(llvmIO);
                            }

                        }else{
                            io.output("LLVMERROR: unmatched or uncast type during assignment of <"
                                    + varName
                                    + "> in line "
                                    + token.getLine()
                                    +":"
                                    + token.getCharPositionInLine());
                            return null;
                        }
                    }else{
                        io.output("LLVMERROR: index out of boundary of array <"
                                + varName
                                + "> in line "
                                + token.getLine()
                                + ":" + token.getCharPositionInLine());
                        return null;
                    }

                }
            }
        }else{ // 普通变量
            Token token = ctx.value().Ident().getSymbol();
            String varName = token.getText();
            Var var = currentScope.resolve(varName);
            if(var == null){
                io.output("LLVMERROR: no such variable <"
                        + varName
                        + "> in line "
                        + token.getLine()
                        + ":" + token.getCharPositionInLine());
                return null;
            }else{ // 变量存在
                ExprComputeVisitor exprComputeVisitor = new ExprComputeVisitor(currentScope, io);
                ExprReturnVal value = exprComputeVisitor.visit(ctx.expr());

                if(var.getType() != value.getType()){
                    Token assign = ctx.Assign().getSymbol(); // 找到等号方便定位错误
                    io.output("LLVMERROR: unmatched type on two side of <"
                            + assign.getText()
                            + "> in line "
                            + assign.getLine()
                            +":"
                            + assign.getCharPositionInLine());
                    return null;
                }else{ // 新值覆盖旧值
                    var.setValue(value.getValue());
                    if(Constant.LLVM){
                        int varSSACode = llvmIO.varMap.get(varName);
                        //int size = varArray.length;
                        if(var.getType() == Type.tInt){
                            llvmIO.output("store i32 "+ value.getValue()+" , i32* %"+llvmIO.getSSA()+", align 4");
                           // llvmIO.print(llvmIO);
                            }
                        else if(var.getType() == Type.tReal){
                            if(value.getValue() instanceof  Double){
                                llvmIO.output("store double "+ value.getValue()+" , double* %"+llvmIO.getSSA()+", align 8");
                                //llvmIO.print(llvmIO);
                                }
                            else{
                                llvmIO.output("store double "+ value.getValue()+" .000000e+00, double* %"+llvmIO.getSSA()+", align 8");
                                //llvmIO.print(llvmIO);
                                }
                        }
                    }
                }
            }
        }


        return null;
    }

    @Override
    public ExprReturnVal visitRead_stmt(cmmParser.Read_stmtContext ctx) {
        super.visitRead_stmt(ctx);
        Token token = null;
        if(ctx.Ident() == null){ // 数组
            token = ctx.array().Ident().getSymbol();
            String varName = token.getText();
            Var var = currentScope.resolve(varName);
            if(var == null){
                io.output("LLVMERROR: no such variable <"
                        + varName
                        + "> in line "
                        + token.getLine()
                        + ":" + token.getCharPositionInLine());
                return null;
            }
            int varIndex = Integer.parseInt(ctx.array().IntConstant().getText());
            if(var.getType() == Type.tIntArray){ // int数组

                int[] varArray = (int[]) var.getValue();

                // 数组越界检查
                if(0 <= varIndex && varIndex < varArray.length){
                    int in = Integer.parseInt(llvmIO.getInput());
                    varArray[varIndex] = in;
                }else{
                    io.output("LLVMERROR: index out of boundary of array <"
                            + varName
                            + "> in line "
                            + token.getLine()
                            + ":" + token.getCharPositionInLine());
                }

            }else{ // double数组

                double[] varArray = (double[]) var.getValue();

                // 数组越界检查
                if(0 <= varIndex && varIndex < varArray.length){
                    Double in = Double.parseDouble(llvmIO.getInput());
                    varArray[varIndex] = in;
                }else{
                    io.output("LLVMERROR: index out of boundary of array <"
                            + varName
                            + "> in line "
                            + token.getLine()
                            + ":" + token.getCharPositionInLine());
                }

            }
        }else{ // 普通变量
            token = ctx.Ident().getSymbol();
            String varName = token.getText();
            Var var = currentScope.resolve(varName);
            if(var == null){
                io.output("LLVMERROR: no such variable <"
                        + varName
                        + "> in line "
                        + token.getLine()
                        + ":" + token.getCharPositionInLine());
                return null;
            }
            if(var.getType() == Type.tInt){
                int in = Integer.parseInt(llvmIO.getInput());
                var.setValue(in);
            }else{
                Double in = Double.parseDouble(llvmIO.getInput());
                var.setValue(in);
            }

        }
        return null;
    }

    @Override
    public ExprReturnVal visitWrite_stmt(cmmParser.Write_stmtContext ctx) {
        super.visitWrite_stmt(ctx);
        boolean flag = true;
        llvmIO.setWriteOrNot(flag);
        ExprComputeVisitor exprComputeVisitor = new ExprComputeVisitor(currentScope, io);
        Object value = exprComputeVisitor.visit(ctx.expr()).getValue();
       // io.output(value);
        if(Constant.LLVM){
            if(value instanceof  Integer) {
                llvmIO.selfAddSSA();
                llvmIO.output(
                        "%"
                                + llvmIO.getSSA()
                                + "="
                                + "alloca i32, align 4\n"
                                + "store i32 "
                                + value
                                + ", i32* %" + llvmIO.getSSA() + ", align 4");
                // llvmIO.varMap.put(node.getSymbol().getText(),llvmIO.getSSA());
                llvmIO.selfAddSSA();
                llvmIO.output("%"+llvmIO.getSSA()+" = load i32, i32* %"+(llvmIO.getSSA()-1)+", align 4");
                llvmIO.selfAddSSA();
                llvmIO.output("%"+llvmIO.getSSA()+" = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str, i32 0, i32 0), i32 %"+(llvmIO.getSSA()-1)+")");
            }
            else {
                llvmIO.selfAddSSA();
                llvmIO.output(
                        "%"
                                + llvmIO.getSSA()
                                + "="
                                + " alloca double, align 8\n"
                                + "store double "
                                + value
                                + ", double* %" + llvmIO.getSSA() + ", align 8");
                //llvmIO.print(llvmIO);
            }
        }
        return null;
    }

    // ==========下面是if else的各种变种，为了减少判断，特地在文法了进行了拆分

    @Override
    public ExprReturnVal visitI_S(cmmParser.I_SContext ctx) { // if stmt
        if(isExprTrue(ctx.expr())){
            visit(ctx.stmt());
        }
        return null;
    }

    @Override
    public ExprReturnVal visitI_SB(cmmParser.I_SBContext ctx) {
        if(isExprTrue(ctx.expr())){
            visit(ctx.stmt_block());
        }
        return null;
    }

    @Override
    public ExprReturnVal visitI_S_E_S(cmmParser.I_S_E_SContext ctx) {
        if(isExprTrue(ctx.expr())){
            visit(ctx.stmt(0));
        }else{
            visit(ctx.stmt(1));
        }
        return null;
    }

    @Override
    public ExprReturnVal visitI_S_E_SB(cmmParser.I_S_E_SBContext ctx) {
        if(isExprTrue(ctx.expr())){
            visit(ctx.stmt());
        }else{
            visit(ctx.stmt_block());
        }
        return null;
    }

    @Override
    public ExprReturnVal visitI_SB_E_S(cmmParser.I_SB_E_SContext ctx) {
        if(isExprTrue(ctx.expr())){
            visit(ctx.stmt_block());
        }else{
            visit(ctx.stmt());
        }
        return null;
    }

    @Override
    public ExprReturnVal visitI_SB_E_SB(cmmParser.I_SB_E_SBContext ctx) {
        if(isExprTrue(ctx.expr())){
            visit(ctx.stmt_block(0));
        }else{
            visit(ctx.stmt_block(1));
        }
        return null;
    }

    private boolean isExprTrue(cmmParser.ExprContext ctx){
        ExprComputeVisitor exprComputeVisitor = new ExprComputeVisitor(currentScope, io);
        ExprReturnVal value = exprComputeVisitor.visit(ctx);
        if(value.getType() == Type.tBool){
            return (Boolean) value.getValue();
        }else{
            return (Double) value.getValue() > 0;
        }
    }

    // ============================= end if else ==========================

    @Override
    public ExprReturnVal visitWhile_stmt(cmmParser.While_stmtContext ctx) {

        while (isExprTrue(ctx.expr())) {
            if(ctx.stmt() != null){ // while后面紧跟stmt
                visit(ctx.stmt());
            }else{ // while后面紧跟stmt_block
                visit(ctx.stmt_block());
            }
        }

        return null;
    }

    @Override
    public ExprReturnVal visitBreak_stmt(cmmParser.Break_stmtContext ctx) {
        return super.visitBreak_stmt(ctx);
    }


}
