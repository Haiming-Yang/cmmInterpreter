package core;

import antlr.cmmBaseVisitor;
import antlr.cmmParser;
import org.antlr.v4.runtime.Token;

/**
 * Created by steveyyy on 2016/12/29.
 */
public class ComputeVisitor extends cmmBaseVisitor<ReturnVal> {

    SymbolList currentSymbolList;
    private IOInterface io;
    private Arith arith;

    public ComputeVisitor(SymbolList currentSymbolList, IOInterface io) {
        this.currentSymbolList = currentSymbolList;
        this.io = io;
    }

    @Override
    public ReturnVal visitMulDivExpr(cmmParser.MulDivExprContext ctx) {
        Token op = ctx.MulDivMod().getSymbol(); // 操作符
        ReturnVal leftValue = visit(ctx.expr(0)); // 左值
        ReturnVal rightValue = visit(ctx.expr(1)); // 右值
        // 运算时做类型检查
        ReturnVal returnVal = new ReturnVal();
        if (leftValue.getType() == Type.tDouble && rightValue.getType() == Type.tInt) {
            returnVal.setType(Type.tDouble);
            Integer iRv = (Integer) rightValue.getValue();
            Double dRv = iRv.doubleValue();
            Double dLv = (Double) leftValue.getValue();
            if (op.getText().equals("*")) {
                returnVal.setValue(arith.mul(dLv, dRv));
            } else if (op.getText().equals("/")) {
                if ((Integer) rightValue.getValue() == 0) {
                    io.output("ERROR: divide zero"
                            + " in line "
                            + op.getLine()
                            + ":"
                            + op.getCharPositionInLine());
                    return null;
                }
                returnVal.setValue(arith.div(dLv, dRv));
            }
        } else if (leftValue.getType() == Type.tInt && rightValue.getType() == Type.tDouble) {
            returnVal.setType(Type.tDouble);
            Integer iLv = (Integer) leftValue.getValue();
            Double dLv = iLv.doubleValue();
            Double dRv = (Double) rightValue.getValue();
            if (op.getText().equals("*")) {
                returnVal.setValue(arith.mul(dLv, dRv));
            } else if (op.getText().equals("/")) {
                if (dRv == 0) {
                    io.output("ERROR: divide zero"
                            + " in line "
                            + op.getLine()
                            + ":"
                            + op.getCharPositionInLine());
                    return null;
                }
                returnVal.setValue(arith.div(dLv, dRv));
            }
        } else if (leftValue.getType() == Type.tDouble && rightValue.getType() == Type.tDouble) {
            returnVal.setType(Type.tDouble);
            if (op.getText().equals("*")) {
                returnVal.setValue(arith.mul((Double) leftValue.getValue(), (Double) rightValue.getValue()));
            } else if (op.getText().equals("/")) {
                returnVal.setValue(arith.div((Double) leftValue.getValue(), (Double) rightValue.getValue()));
            }
        } else if (leftValue.getType() == Type.tInt && rightValue.getType() == Type.tInt) {
            returnVal.setType(Type.tInt);
            if (op.getText().equals("*")) {
                returnVal.setValue((Integer) leftValue.getValue() * (Integer) rightValue.getValue());
            } else if (op.getText().equals("/")) {
                if ((Integer) rightValue.getValue() == 0) {
                    io.output("ERROR: divide zero"
                            + " in line "
                            + op.getLine()
                            + ":"
                            + op.getCharPositionInLine());
                    return null;
                }
                returnVal.setValue((Integer) leftValue.getValue() / (Integer) rightValue.getValue());
            }
        } else {
            io.output("ERROR: unmatched or uncast type on two side of <"
                    + op.getText()
                    + "> in line "
                    + op.getLine()
                    + ":"
                    + op.getCharPositionInLine());
        }

        return returnVal;
    }

    @Override
    public ReturnVal visitAddMinExpr(cmmParser.AddMinExprContext ctx) {

        Token op = ctx.AddMin().getSymbol(); // 操作符
        ReturnVal leftValue = visit(ctx.expr(0)); // 左值
        ReturnVal rightValue = visit(ctx.expr(1)); // 右值
        ReturnVal returnVal = new ReturnVal();
        // 运算时做类型检查
        if (leftValue.getType() == Type.tDouble && rightValue.getType() == Type.tInt) {
            returnVal.setType(Type.tDouble);
            Integer iRv = (Integer) rightValue.getValue();
            Double dRv = iRv.doubleValue();
            Double dLv = (Double) leftValue.getValue();
            if (op.getText().equals("+")) {
                returnVal.setValue(arith.add(dLv, dRv));
            } else {
                returnVal.setValue(arith.sub(dLv, dRv));
            }
        } else if (leftValue.getType() == Type.tInt && rightValue.getType() == Type.tDouble) {
            returnVal.setType(Type.tDouble);
            Integer iLv = (Integer) leftValue.getValue();
            Double dLv = iLv.doubleValue();
            Double dRv = (Double) rightValue.getValue();
            if (op.getText().equals("+")) {
                returnVal.setValue(arith.add(dLv, dRv));
            } else {
                returnVal.setValue(arith.sub(dLv, dRv));
            }
        } else if (leftValue.getType() == Type.tDouble && rightValue.getType() == Type.tDouble) {
            returnVal.setType(Type.tDouble);
            if (op.getText().equals("+")) {
                returnVal.setValue(arith.add((Double) leftValue.getValue(), (Double) rightValue.getValue()));
            } else {
                returnVal.setValue(arith.sub((Double) leftValue.getValue(), (Double) rightValue.getValue()));
            }
        } else if (leftValue.getType() == Type.tInt && rightValue.getType() == Type.tInt) {
            returnVal.setType(Type.tInt);
            if (op.getText().equals("+")) {
                returnVal.setValue((Integer) leftValue.getValue() + (Integer) rightValue.getValue());
            } else {
                returnVal.setValue((Integer) leftValue.getValue() - (Integer) rightValue.getValue());
            }
        } else {
            io.output("ERROR: unmatched or uncast type on two side of <"
                    + op.getText()
                    + "> in line "
                    + op.getLine()
                    + ":"
                    + op.getCharPositionInLine());
        }
        return returnVal;
    }

    @Override
    public ReturnVal visitCompareExpr(cmmParser.CompareExprContext ctx) {
        Token op = ctx.CompOp().getSymbol(); // 比较符
        ReturnVal leftValue = visit(ctx.expr(0)); // 左值
        ReturnVal rightValue = visit(ctx.expr(1)); // 右值
        Double dLv;
        Double dRv;
        if (leftValue.getValue() instanceof Integer) {
            if (rightValue.getValue() instanceof Integer) {
                Integer iLv = (Integer) leftValue.getValue();
                dLv = iLv.doubleValue();
                Integer iRv = (Integer) rightValue.getValue();
                dRv = iRv.doubleValue();
            } else {
                Integer iLv = (Integer) leftValue.getValue();
                dLv = iLv.doubleValue();
                dRv = (Double) rightValue.getValue();
            }
        } else {
            if (rightValue.getValue() instanceof Double) {
                //Integer iLv = (Integer)leftValue.getValue();
                dLv = (Double) leftValue.getValue();
                //Integer iRv = (Integer)rightValue.getValue();
                dRv = (Double) rightValue.getValue();
            } else {
                //Integer iLv = (Integer)leftValue.getValue();
                dLv = (Double) leftValue.getValue();
                Integer iRv = (Integer) rightValue.getValue();
                dRv = iRv.doubleValue();
            }
        }
        ReturnVal returnVal = new ReturnVal();
        returnVal.setType(Type.tBool);
        if (op.getText().equals(">")) {
            returnVal.setValue(dLv > dRv);
        } else if (op.getText().equals("<")) {
            returnVal.setValue(dLv < dRv);
        } else if (op.getText().equals(">=")) {
            returnVal.setValue(dLv >= dRv);
        } else if (op.getText().equals("<=")) {
            returnVal.setValue(dLv <= dRv);
        } else if (op.getText().equals("==")) {
            //returnVal.setValue(leftValue.getValue() == rightValue.getValue());
            returnVal.setValue(dLv.equals(dRv));
        } else if (op.getText().equals("!=") || op.getText().equals("<>")) {
            //returnVal.setValue(leftValue.getValue() != rightValue.getValue());
            returnVal.setValue(!dLv.equals(dRv));
        }

        return returnVal;
    }

    @Override
    public ReturnVal visitParenthesesExpr(cmmParser.ParenthesesExprContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public ReturnVal visitValueExpr(cmmParser.ValueExprContext ctx) {

        if (ctx.value() != null) { // 直接是字面值的运算
            if (ctx.value().IntConstant() != null) {
                return new ReturnVal(Type.tInt,
                        Integer.valueOf(ctx.value().IntConstant().getText()));
            }
            else if (ctx.value().DoubleConstant() != null) {
                return new ReturnVal(Type.tDouble,
                        Double.valueOf(ctx.value().DoubleConstant().getText()));
            }
            else if (ctx.value().HexIntConstant() != null) {
                String hexIntS = ctx.value().HexIntConstant().getText().substring(2);
                int value = Integer.parseInt(hexIntS,16);
                return new ReturnVal(Type.tInt,
                        value);
            }
            else {
                String hexDoubleS = ctx.value().HexDoubleConstant().getText()+"p0";
                Double value = Double.valueOf(hexDoubleS);
                return new ReturnVal(Type.tDouble,
                       value);
            }
        }
        else{
            return  null;
        }

    }

    @Override
    public ReturnVal visitVarExpr(cmmParser.VarExprContext ctx){
        if (ctx.var().Ident() != null) { // 表达式里包含变量
            Token varToken = ctx.var().Ident().getSymbol();
            String name = varToken.getText();
            Symbol symbolSymbol = currentSymbolList.resolve(name);
            if (symbolSymbol != null) {
                return new ReturnVal(symbolSymbol.getType(), symbolSymbol.getValue());
            } else {
                io.output("ERROR: no such variable <"
                        + name
                        + "> in line "
                        + varToken.getLine()
                        + ":" + varToken.getCharPositionInLine());
                return null;
            }
        } else { // 表达式里面包含数组
            Token varToken = ctx.var().array().Ident().getSymbol();
            String name = varToken.getText();
            int varIndex;
            if (ctx.var().array().IntConstant() != null) { // 索引为int常量
                varIndex = Integer.parseInt(ctx.var().array().IntConstant().getText());
            } else { // 索引为表达式
                ComputeVisitor indexComputeVisitor = new ComputeVisitor(currentSymbolList, io);
                ReturnVal indexValue = indexComputeVisitor.visit(ctx.var().array().expr());
                varIndex = (Integer) indexValue.getValue();
            }
            Symbol symbolSymbol = currentSymbolList.resolve(name);
            if (symbolSymbol != null) {
                if (symbolSymbol.getType() == Type.tIntArray) { // int数组

                    int[] varArray = (int[]) symbolSymbol.getValue();

                    // 数组越界检查
                    if (varIndex < varArray.length) {
                        return new ReturnVal(Type.tInt, varArray[varIndex]);
                    } else {
                        io.output("ERROR: index out of boundary of array <"
                                + name
                                + "> in line "
                                + varToken.getLine()
                                + ":" + varToken.getCharPositionInLine());
                        return null;
                    }

                } else { // double数组

                    double[] varArray = (double[]) symbolSymbol.getValue();

                    // 数组越界检查
                    if (varIndex < varArray.length) {
                        return new ReturnVal(Type.tDouble, varArray[varIndex]);
                    } else {
                        io.output("ERROR: index out of boundary of array <"
                                + name
                                + "> in line "
                                + varToken.getLine()
                                + ":" + varToken.getCharPositionInLine());
                        return null;
                    }

                }
            } else {
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
    public ReturnVal visitBoolExpr(cmmParser.BoolExprContext ctx){
        ReturnVal returnVal = new ReturnVal();
        returnVal.setType(Type.tBool);
        if(ctx.bool().BooleanConstant().toString().equals("true")){
            returnVal.setValue(true);

        }
        else{
            returnVal.setValue(false);
        }
        return  returnVal;
    }


}
