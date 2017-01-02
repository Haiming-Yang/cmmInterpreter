package core;

import antlr.cmmBaseVisitor;
import antlr.cmmParser;
import org.antlr.v4.runtime.Token;

/**
 * Created by steveyyy on 2016/12/29.
 */
public class ExprComputeVisitor extends cmmBaseVisitor<ExprReturnVal> {

    Scope currentScope;
    private IOInterface io;
    private Arith arith;

    public ExprComputeVisitor(Scope currentScope, IOInterface io) {
        this.currentScope = currentScope;
        this.io = io;
    }

    @Override
    public ExprReturnVal visitMulDivExpr(cmmParser.MulDivExprContext ctx) {
        Token op = ctx.MulDivMod().getSymbol(); // 操作符
        ExprReturnVal leftValue = visit(ctx.expr(0)); // 左值
        ExprReturnVal rightValue = visit(ctx.expr(1)); // 右值
        // 运算时做类型检查
        ExprReturnVal returnVal = new ExprReturnVal();
        if(leftValue.getType() == Type.tReal && rightValue.getType() == Type.tInt){
            returnVal.setType(Type.tReal);
            Integer iRv = (Integer)rightValue.getValue();
            Double dRv = iRv.doubleValue();
            Double dLv = (Double)leftValue.getValue();
            if(op.getText().equals("*")){
                returnVal.setValue(arith.mul(dLv,dRv));
            }else if(op.getText().equals("/")){
                if((Integer)rightValue.getValue() == 0){
                    io.output("ERROR: divide zero"
                            + " in line "
                            + op.getLine()
                            +":"
                            + op.getCharPositionInLine());
                    return null;
                }
                returnVal.setValue(arith.div(dLv,dRv));
            }
        }else if(leftValue.getType() == Type.tInt && rightValue.getType() == Type.tReal){
            returnVal.setType(Type.tReal);
            Integer iLv = (Integer)leftValue.getValue();
            Double dLv = iLv.doubleValue();
            Double dRv = (Double)rightValue.getValue();
            if(op.getText().equals("*")){
                returnVal.setValue(arith.mul(dLv,dRv));
            }else if(op.getText().equals("/")){
                if(dRv == 0){
                    io.output("ERROR: divide zero"
                            + " in line "
                            + op.getLine()
                            +":"
                            + op.getCharPositionInLine());
                    return null;
                }
                returnVal.setValue(arith.div(dLv,dRv));
            }
        }else if(leftValue.getType() == Type.tReal && rightValue.getType() == Type.tReal){
            returnVal.setType(Type.tReal);
            if(op.getText().equals("*")){
                returnVal.setValue(arith.mul((Double)leftValue.getValue(),(Double) rightValue.getValue()));
            }else if(op.getText().equals("/")){
                returnVal.setValue(arith.div((Double)leftValue.getValue(),(Double) rightValue.getValue()));
            }
        }else if(leftValue.getType() == Type.tInt && rightValue.getType() == Type.tInt){
            returnVal.setType(Type.tInt);
            if(op.getText().equals("*")){
                returnVal.setValue((Integer)leftValue.getValue() * (Integer) rightValue.getValue());
            }else if(op.getText().equals("/")){
                if((Integer)rightValue.getValue() == 0){
                    io.output("ERROR: divide zero"
                            + " in line "
                            + op.getLine()
                            +":"
                            + op.getCharPositionInLine());
                    return null;
                }
                returnVal.setValue((Integer)leftValue.getValue() / (Integer) rightValue.getValue());
            }
        }else{
            io.output("ERROR: unmatched or uncast type on two side of <"
                    + op.getText()
                    + "> in line "
                    + op.getLine()
                    +":"
                    + op.getCharPositionInLine());
        }

        return returnVal;
    }

    @Override
    public ExprReturnVal visitAddMinExpr(cmmParser.AddMinExprContext ctx) {

        Token op = ctx.AddMin().getSymbol(); // 操作符
        ExprReturnVal leftValue = visit(ctx.expr(0)); // 左值
        ExprReturnVal rightValue = visit(ctx.expr(1)); // 右值
        ExprReturnVal returnVal = new ExprReturnVal();
        // 运算时做类型检查
        if(leftValue.getType() == Type.tReal && rightValue.getType() == Type.tInt){
            returnVal.setType(Type.tReal);
            Integer iRv = (Integer)rightValue.getValue();
            Double dRv = iRv.doubleValue();
            Double dLv = (Double)leftValue.getValue();
            if(op.getText().equals("+")){
                returnVal.setValue(arith.add(dLv,dRv));
            }else{
                returnVal.setValue(arith.sub(dLv,dRv));
            }
        }else if(leftValue.getType() == Type.tInt && rightValue.getType() == Type.tReal){
            returnVal.setType(Type.tReal);
            Integer iLv = (Integer)leftValue.getValue();
            Double dLv = iLv.doubleValue();
            Double dRv = (Double)rightValue.getValue();
            if(op.getText().equals("+")){
                returnVal.setValue(arith.add(dLv,dRv));
            }else{
                returnVal.setValue(arith.sub(dLv,dRv));
            }
        }else if(leftValue.getType() == Type.tReal && rightValue.getType() == Type.tReal){
            returnVal.setType(Type.tReal);
            if(op.getText().equals("+")){
                returnVal.setValue(arith.add((Double)leftValue.getValue(),(Double) rightValue.getValue()));
            }else{
                returnVal.setValue(arith.sub((Double)leftValue.getValue(),(Double) rightValue.getValue()));
            }
        }else if(leftValue.getType() == Type.tInt && rightValue.getType() == Type.tInt){
            returnVal.setType(Type.tInt);
            if(op.getText().equals("+")){
                returnVal.setValue((Integer)leftValue.getValue() + (Integer)rightValue.getValue());
            }else{
                returnVal.setValue((Integer)leftValue.getValue() - (Integer)rightValue.getValue());
            }
        }else{
            io.output("ERROR: unmatched or uncast type on two side of <"
                    + op.getText()
                    + "> in line "
                    + op.getLine()
                    +":"
                    + op.getCharPositionInLine());
        }
        return returnVal;
    }

    @Override
    public ExprReturnVal visitCompareExpr(cmmParser.CompareExprContext ctx) {
        Token op = ctx.CompOp().getSymbol(); // 比较符
        ExprReturnVal leftValue = visit(ctx.expr(0)); // 左值
        ExprReturnVal rightValue = visit(ctx.expr(1)); // 右值
        // 运算时做类型检查
        if(leftValue.getType() != rightValue.getType()){
            io.output("ERROR: unmatched type on two side of <"
                    + op.getText()
                    + "> in line "
                    + op.getLine()
                    +":"
                    + op.getCharPositionInLine());
            return null;
        }
        ExprReturnVal returnVal = new ExprReturnVal();
        returnVal.setType(Type.tBool);
        if(op.getText().equals(">")){
            if(leftValue.getType() == Type.tInt){
                returnVal.setValue((Integer)leftValue.getValue() > (Integer)rightValue.getValue());
            }else {
                returnVal.setValue((Double)leftValue.getValue() > (Double) rightValue.getValue());
            }
        }else if(op.getText().equals("<")){
            if(leftValue.getType() == Type.tInt){
                returnVal.setValue((Integer)leftValue.getValue() < (Integer)rightValue.getValue());
            }else {
                returnVal.setValue((Double)leftValue.getValue() < (Double) rightValue.getValue());
            }
        }else if(op.getText().equals(">=")){
            if(leftValue.getType() == Type.tInt){
                returnVal.setValue((Integer)leftValue.getValue() >= (Integer)rightValue.getValue());
            }else {
                returnVal.setValue((Double)leftValue.getValue() >= (Double) rightValue.getValue());
            }
        }else if(op.getText().equals("<=")){
            if(leftValue.getType() == Type.tInt){
                returnVal.setValue((Integer)leftValue.getValue() <= (Integer)rightValue.getValue());
            }else {
                returnVal.setValue((Double)leftValue.getValue() <= (Double) rightValue.getValue());
            }
        }else if(op.getText().equals("==")){
            //returnVal.setValue(leftValue.getValue() == rightValue.getValue());
            if(leftValue.getType() == Type.tInt){
                returnVal.setValue((Integer)leftValue.getValue() == (Integer)rightValue.getValue());
            }else {
                returnVal.setValue(((Double)leftValue.getValue()).equals((Double)rightValue.getValue()));
            }
        }else if(op.getText().equals("!=") || op.getText().equals("<>")){
            //returnVal.setValue(leftValue.getValue() != rightValue.getValue());
            if(leftValue.getType() == Type.tInt){
                returnVal.setValue((Integer)leftValue.getValue() != (Integer)rightValue.getValue());
            }else {
                returnVal.setValue(!(((Double)leftValue.getValue()).equals((Double) rightValue.getValue())));
            }
        }

        return returnVal;
    }

    @Override
    public ExprReturnVal visitParenthesesExpr(cmmParser.ParenthesesExprContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public ExprReturnVal visitValueExpr(cmmParser.ValueExprContext ctx) {

        if(ctx.value().constant() != null){ // 直接是字面值的运算
            if(ctx.value().constant().IntConstant() != null){
                return new ExprReturnVal(Type.tInt,
                        Integer.valueOf(ctx.value().constant().IntConstant().getText()));
            }else{
                return new ExprReturnVal(Type.tReal,
                        Double.valueOf(ctx.value().constant().RealConstant().getText()));
            }
        }else if(ctx.value().Ident() != null){ // 表达式里包含变量
            Token varToken = ctx.value().Ident().getSymbol();
            String name = varToken.getText();
            Symbol symbolSymbol = currentScope.resolve(name);
            if(symbolSymbol != null ){
                return new ExprReturnVal(symbolSymbol.getType(), symbolSymbol.getValue());
            }else{
                io.output("ERROR: no such variable <"
                        + name
                        + "> in line "
                        + varToken.getLine()
                        + ":" + varToken.getCharPositionInLine());
                return null;
            }
        }else{ // 表达式里面包含数组
            Token varToken = ctx.value().array().Ident().getSymbol();
            String name = varToken.getText();
            int varIndex;
            if(ctx.value().array().IntConstant() != null){ // 索引为int常量
                varIndex = Integer.parseInt(ctx.value().array().IntConstant().getText());
            }else{ // 索引为表达式
                ExprComputeVisitor indexComputeVisitor = new ExprComputeVisitor(currentScope, io);
                ExprReturnVal indexValue = indexComputeVisitor.visit(ctx.value().array().expr());
                varIndex = (Integer) indexValue.getValue();
            }
            Symbol symbolSymbol = currentScope.resolve(name);
            if(symbolSymbol != null ){
                if(symbolSymbol.getType() == Type.tIntArray){ // int数组

                    int[] varArray = (int[]) symbolSymbol.getValue();

                    // 数组越界检查
                    if(varIndex < varArray.length){
                        return new ExprReturnVal(Type.tInt, varArray[varIndex]);
                    }else{
                        io.output("ERROR: index out of boundary of array <"
                                + name
                                + "> in line "
                                + varToken.getLine()
                                + ":" + varToken.getCharPositionInLine());
                        return null;
                    }

                }else{ // double数组

                    double[] varArray = (double[]) symbolSymbol.getValue();

                    // 数组越界检查
                    if(varIndex < varArray.length){
                        return new ExprReturnVal(Type.tReal, varArray[varIndex]);
                    }else{
                        io.output("ERROR: index out of boundary of array <"
                                + name
                                + "> in line "
                                + varToken.getLine()
                                + ":" + varToken.getCharPositionInLine());
                        return null;
                    }

                }
            }else{
                io.output("ERROR: no such variable <"
                        + name
                        + "> in line "
                        + varToken.getLine()
                        + ":" + varToken.getCharPositionInLine());
                return null;
            }
        }

    }

    @Override
    public ExprReturnVal visitSignExpr(cmmParser.SignExprContext ctx) {
        String sign = ctx.AddMin().getSymbol().getText();
        if(sign.equals("+")){
            return visit(ctx.expr());
        }else{
            ExprReturnVal value = visit(ctx.expr());
            if(value.getType() == Type.tInt){
                return new ExprReturnVal(value.getType(), -(Integer)value.getValue());
            }else{
                return new ExprReturnVal(value.getType(), -(Double)value.getValue());
            }

        }
    }
}
