package core;

import IO.LLVMIO;
import antlr.cmmBaseVisitor;
import antlr.cmmParser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

/**
 * Created by steveyyy on 2016/12/29.
 */
public class RuntimeVisitor extends cmmBaseVisitor<ReturnVal> {

    private IOInterface io;
    private LLVMIO llvmIO;
    public  boolean runSucOrNot = true;
    ParseTreeProperty<SymbolList> symbolList;
    GlobalSymbolList globals;
    SymbolList currentSymbolList;

    public RuntimeVisitor(GlobalSymbolList globals, ParseTreeProperty<SymbolList> symbolList, IOInterface io, LLVMIO llvmIO) {
        this.io = io;
        this.globals = globals;
        this.symbolList = symbolList;
        this.llvmIO = llvmIO;
    }

    @Override
    public ReturnVal visitProgram(cmmParser.ProgramContext ctx) {
        currentSymbolList = globals;
        super.visitProgram(ctx);
        //runSucOrNot = true;
        return null;
    }

    @Override
    public ReturnVal visitStmt_block(cmmParser.Stmt_blockContext ctx) {
        currentSymbolList = symbolList.get(ctx);
        super.visitStmt_block(ctx);
        currentSymbolList = currentSymbolList.getEnclosingSymbolList();
        return null;
    }

    @Override
    public ReturnVal visitDecl_assign(cmmParser.Decl_assignContext ctx) {
        Token token = ctx.Ident().getSymbol();
        String varName = token.getText();
        Symbol symbol = currentSymbolList.resolve(varName);
        if(symbol == null){
            runSucOrNot = false;
            io.output("ERROR: no such variable <"
                    + varName
                    + "> in line "
                    + token.getLine()
                    + ":" + token.getCharPositionInLine());
            return null;
        }else{ // 变量存在
            ComputeVisitor computeVisitor = new ComputeVisitor(currentSymbolList, io);
            ReturnVal value = computeVisitor.visit(ctx.expr());

            if( !(value.getType()== Type.tInt || value.getType() == Type.tDouble)){
                runSucOrNot = false;
                Token assign = ctx.Assign().getSymbol(); // 找到等号方便定位错误
                io.output("ERROR: unmatched type on two side of <"
                        + assign.getText()
                        + "> in line "
                        + assign.getLine()
                        +":"
                        + assign.getCharPositionInLine());
                return null;
            }else{ // 新值覆盖旧值
                if(symbol.getType() == Type.tInt){
                    if(value.getValue() instanceof  Integer){
                        symbol.setValue(value.getValue());
                    }
                    else{
                        Double n = (Double) value.getValue();
                        symbol.setValue(n.intValue());
                    }
                }
                else{
                    if(value.getValue() instanceof Integer){
                        Integer n = (Integer) value.getValue();
                        Double dn = n.doubleValue();
                        symbol.setValue(dn);
                    }
                    else{
                        Double n = (Double)value.getValue();
                        symbol.setValue(n);
                    }
                }

            }
        }

        return visitChildren(ctx);
    }

    @Override
    public ReturnVal visitAssign_stmt(cmmParser.Assign_stmtContext ctx) {
        super.visitAssign_stmt(ctx);

        if(ctx.var().Ident() == null){ // 数组
            Token token = ctx.var().array().Ident().getSymbol();
            String varName = token.getText();
            Symbol symbol = currentSymbolList.resolve(varName);
            if(symbol == null){
                runSucOrNot = false;
                io.output("ERROR: no such variable <"
                        + varName
                        + "> in line "
                        + token.getLine()
                        + ":" + token.getCharPositionInLine());
                return null;
            }else{
                ComputeVisitor computeVisitor = new ComputeVisitor(currentSymbolList, io);
                ReturnVal value = computeVisitor.visit(ctx.expr()); // 右边表达式计算得到的值
                int varIndex;
                if(ctx.var().array().IntConstant() != null){ // 索引为int常量
                    varIndex = Integer.parseInt(ctx.var().array().IntConstant().getText());
                }else{ // 索引为表达式

                    ComputeVisitor indexComputeVisitor = new ComputeVisitor(currentSymbolList, io);
                   // if(ctx.var().array().expr().getText())
                    ReturnVal indexValue = indexComputeVisitor.visit(ctx.var().array().expr());
                    if(indexValue.getType() != Type.tInt){
                        runSucOrNot =false;
                        io.output("ERROR: invalid index for <"
                                + varName
                                + "> in line "
                                + token.getLine()
                                + ":" + token.getCharPositionInLine());
                        return null;
                    }
                    varIndex = (Integer) indexValue.getValue();
                }
                if(symbol.getType() == Type.tIntArray){ // int数组
                    int[] varArray = (int[]) symbol.getValue();
                    // 数组越界检查
                    if(0 <= varIndex && varIndex < varArray.length){
                        //这地方的判断感觉没用，强制转成int就行了
                        if((value.getValue() instanceof  Integer)||((value.getValue() instanceof  Double))){
                            if(value.getValue() instanceof Integer) {
                                varArray[varIndex] = (int)value.getValue();
                            }
                            else{
                                Double n = (Double) value.getValue();
                                varArray[varIndex] = n.intValue();
                                io.output("WARNING: 精度衰减 <"
                                        + token.getText()
                                        + "> in line "
                                        + token.getLine()
                                        +":"
                                        + token.getCharPositionInLine());
                            }

                        }else{
                            runSucOrNot = false;
                            io.output("ERROR: unmatched or uncast type during assignment of <"
                                    + varName
                                    + "> in line "
                                    + token.getLine()
                                    +":"
                                    + token.getCharPositionInLine());
                            return null;
                        }
                    }else{
                        runSucOrNot = false;
                        io.output("ERROR: index out of boundary of array <"
                                + varName
                                + "> in line "
                                + token.getLine()
                                + ":" + token.getCharPositionInLine());
                        return null;
                    }

                }else{ // double数组
                    double[] varArray = (double[]) symbol.getValue();
                    // 数组越界检查
                    if(0 <= varIndex && varIndex < varArray.length){
                        if(value.getValue() instanceof  Double||value.getValue() instanceof  Integer){
                            if(value.getValue() instanceof Double) {
                                varArray[varIndex] = (Double) value.getValue();
                            }
                            else{
                                int n = (Integer) value.getValue();
                                varArray[varIndex] = n;
                                io.output("WARNING: 隐式转换 <"
                                        + token.getText()
                                        + "> in line "
                                        + token.getLine()
                                        +":"
                                        + token.getCharPositionInLine());
                            }

                        }else{
                            runSucOrNot = false;
                            io.output("ERROR: unmatched or uncast type during assignment of <"
                                    + varName
                                    + "> in line "
                                    + token.getLine()
                                    +":"
                                    + token.getCharPositionInLine());
                            return null;
                        }
                    }else{
                        runSucOrNot = false;
                        io.output("ERROR: index out of boundary of array <"
                                + varName
                                + "> in line "
                                + token.getLine()
                                + ":" + token.getCharPositionInLine());
                        return null;
                    }

                }
            }
        }else{ // 普通变量
            Token token = ctx.var().Ident().getSymbol();
            String varName = token.getText();
            Symbol symbol = currentSymbolList.resolve(varName);
            if(symbol == null){
                runSucOrNot = false;
                io.output("ERROR: no such variable <"
                        + varName
                        + "> in line "
                        + token.getLine()
                        + ":" + token.getCharPositionInLine());
                return null;
            }else{ // 变量存在
                ComputeVisitor computeVisitor = new ComputeVisitor(currentSymbolList, io);
                ReturnVal value = computeVisitor.visit(ctx.expr());

                if( !(value.getType()== Type.tInt || value.getType() == Type.tDouble)){
                    runSucOrNot = false;
                    Token assign = ctx.Assign().getSymbol(); // 找到等号方便定位错误
                    io.output("ERROR: wrong value <"
                            + assign.getText()
                            + "> in line "
                            + assign.getLine()
                            +":"
                            + assign.getCharPositionInLine());
                    return null;
                }else{ // 新值覆盖旧值
                    if(symbol.getType() == Type.tInt){
                        if(value.getValue() instanceof  Integer){
                            symbol.setValue(value.getValue());
                        }
                        else{
                            Double n = (Double) value.getValue();
                            symbol.setValue(n.intValue());
                            io.output("WARNING: 精度衰减 <"
                                    + token.getText()
                                    + "> in line "
                                    + token.getLine()
                                    +":"
                                    + token.getCharPositionInLine());
                        }
                    }
                    else{
                            if(value.getValue() instanceof Integer){
                                Integer n = (Integer) value.getValue();
                                Double dn = n.doubleValue();
                                symbol.setValue(dn);
                                io.output("WARNING: 隐式转换 <"
                                        + token.getText()
                                        + "> in line "
                                        + token.getLine()
                                        +":"
                                        + token.getCharPositionInLine());
                            }
                            else{
                                Double n = (Double)value.getValue();
                                symbol.setValue(n);
                            }
                    }

                    }
                }
            }


        return null;
    }

    @Override
    public ReturnVal visitRead_stmt(cmmParser.Read_stmtContext ctx) {
        super.visitRead_stmt(ctx);
        Token token = null;
        if(ctx.Ident() == null){ // 数组
            token = ctx.array().Ident().getSymbol();
            String varName = token.getText();
            Symbol symbol = currentSymbolList.resolve(varName);
            if(symbol == null){
                runSucOrNot = false;
                io.output("ERROR: no such variable <"
                        + varName
                        + "> in line "
                        + token.getLine()
                        + ":" + token.getCharPositionInLine());
                return null;
            }
            int varIndex = Integer.parseInt(ctx.array().IntConstant().getText());
            if(symbol.getType() == Type.tIntArray){ // int数组

                int[] varArray = (int[]) symbol.getValue();

                // 数组越界检查
                if(0 <= varIndex && varIndex < varArray.length){
                    String inS = io.input();
                    int in = Integer.parseInt(inS);
                    llvmIO.addInputList(inS);
                    varArray[varIndex] = in;
                }else{
                    runSucOrNot = false;
                    io.output("ERROR: index out of boundary of array <"
                            + varName
                            + "> in line "
                            + token.getLine()
                            + ":" + token.getCharPositionInLine());
                }

            }else{ // double数组

                double[] varArray = (double[]) symbol.getValue();

                // 数组越界检查
                if(0 <= varIndex && varIndex < varArray.length){
                    String inS = io.input();
                    Double in = Double.parseDouble(inS);
                    llvmIO.addInputList(inS);
                    varArray[varIndex] = in;
                }else{
                    runSucOrNot = false;
                    io.output("ERROR: index out of boundary of array <"
                            + varName
                            + "> in line "
                            + token.getLine()
                            + ":" + token.getCharPositionInLine());
                }

            }
        }else{ // 普通变量
            token = ctx.Ident().getSymbol();
            String varName = token.getText();
            Symbol symbol = currentSymbolList.resolve(varName);
            if(symbol == null){
                runSucOrNot = false;
                io.output("ERROR: no such variable <"
                        + varName
                        + "> in line "
                        + token.getLine()
                        + ":" + token.getCharPositionInLine());
                return null;
            }
            if(symbol.getType() == Type.tInt){
                String inS =  io.input();
                int in = Integer.parseInt(inS);
                llvmIO.addInputList(inS);
                symbol.setValue(in);
            }else{
                String inS = io.input();
                Double in = Double.parseDouble(inS);
                llvmIO.addInputList(inS);
                symbol.setValue(in);
            }

        }
        return null;
    }

    @Override
    public ReturnVal visitWrite_stmt(cmmParser.Write_stmtContext ctx) {
        super.visitWrite_stmt(ctx);
        ComputeVisitor computeVisitor = new ComputeVisitor(currentSymbolList, io);
        Object value = computeVisitor.visit(ctx.expr()).getValue();
        io.output(value);
        return null;
    }

    // ==========下面是if else的各种变种，为了减少判断，特地在文法了进行了拆分

    @Override
    public ReturnVal visitI_S(cmmParser.I_SContext ctx) { // if stmt
        if(isExprTrue(ctx.expr())){
            visit(ctx.stmt());
        }
        return null;
    }

    @Override
    public ReturnVal visitI_SB(cmmParser.I_SBContext ctx) {
        if(isExprTrue(ctx.expr())){
            visit(ctx.stmt_block());
        }
        return null;
    }

    @Override
    public ReturnVal visitI_S_E_S(cmmParser.I_S_E_SContext ctx) {
        if(isExprTrue(ctx.expr())){
            visit(ctx.stmt(0));
        }else{
            visit(ctx.stmt(1));
        }
        return null;
    }

    @Override
    public ReturnVal visitI_S_E_SB(cmmParser.I_S_E_SBContext ctx) {
        if(isExprTrue(ctx.expr())){
            visit(ctx.stmt());
        }else{
            visit(ctx.stmt_block());
        }
        return null;
    }

    @Override
    public ReturnVal visitI_SB_E_S(cmmParser.I_SB_E_SContext ctx) {
        if(isExprTrue(ctx.expr())){
            visit(ctx.stmt_block());
        }else{
            visit(ctx.stmt());
        }
        return null;
    }

    @Override
    public ReturnVal visitI_SB_E_SB(cmmParser.I_SB_E_SBContext ctx) {
        if(isExprTrue(ctx.expr())){
            visit(ctx.stmt_block(0));
        }else{
            visit(ctx.stmt_block(1));
        }
        return null;
    }

    private boolean isExprTrue(cmmParser.ExprContext ctx){
        ComputeVisitor computeVisitor = new ComputeVisitor(currentSymbolList, io);
        ReturnVal value = computeVisitor.visit(ctx);
        if(value.getType() == Type.tBool){
            return (Boolean) value.getValue();
        }else{
            return (Double) value.getValue() > 0;
        }
    }

    // ============================= end if else ==========================

    @Override
    public ReturnVal visitWhile_stmt(cmmParser.While_stmtContext ctx) {

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
    public ReturnVal visitBreak_stmt(cmmParser.Break_stmtContext ctx) {
        return super.visitBreak_stmt(ctx);
    }


}
