// Generated from /Users/steveyyy/Programming/cmmInterpreter/src/antlr/cmm.g4 by ANTLR 4.6
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link cmmParser}.
 */
public interface cmmListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link cmmParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(cmmParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(cmmParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(cmmParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(cmmParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmParser#stmt_block}.
	 * @param ctx the parse tree
	 */
	void enterStmt_block(cmmParser.Stmt_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmParser#stmt_block}.
	 * @param ctx the parse tree
	 */
	void exitStmt_block(cmmParser.Stmt_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl(cmmParser.Var_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl(cmmParser.Var_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(cmmParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(cmmParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmParser#varlist}.
	 * @param ctx the parse tree
	 */
	void enterVarlist(cmmParser.VarlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmParser#varlist}.
	 * @param ctx the parse tree
	 */
	void exitVarlist(cmmParser.VarlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmParser#decl_assign}.
	 * @param ctx the parse tree
	 */
	void enterDecl_assign(cmmParser.Decl_assignContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmParser#decl_assign}.
	 * @param ctx the parse tree
	 */
	void exitDecl_assign(cmmParser.Decl_assignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code I_S}
	 * labeled alternative in {@link cmmParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterI_S(cmmParser.I_SContext ctx);
	/**
	 * Exit a parse tree produced by the {@code I_S}
	 * labeled alternative in {@link cmmParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitI_S(cmmParser.I_SContext ctx);
	/**
	 * Enter a parse tree produced by the {@code I_SB}
	 * labeled alternative in {@link cmmParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterI_SB(cmmParser.I_SBContext ctx);
	/**
	 * Exit a parse tree produced by the {@code I_SB}
	 * labeled alternative in {@link cmmParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitI_SB(cmmParser.I_SBContext ctx);
	/**
	 * Enter a parse tree produced by the {@code I_S_E_S}
	 * labeled alternative in {@link cmmParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterI_S_E_S(cmmParser.I_S_E_SContext ctx);
	/**
	 * Exit a parse tree produced by the {@code I_S_E_S}
	 * labeled alternative in {@link cmmParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitI_S_E_S(cmmParser.I_S_E_SContext ctx);
	/**
	 * Enter a parse tree produced by the {@code I_S_E_SB}
	 * labeled alternative in {@link cmmParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterI_S_E_SB(cmmParser.I_S_E_SBContext ctx);
	/**
	 * Exit a parse tree produced by the {@code I_S_E_SB}
	 * labeled alternative in {@link cmmParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitI_S_E_SB(cmmParser.I_S_E_SBContext ctx);
	/**
	 * Enter a parse tree produced by the {@code I_SB_E_S}
	 * labeled alternative in {@link cmmParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterI_SB_E_S(cmmParser.I_SB_E_SContext ctx);
	/**
	 * Exit a parse tree produced by the {@code I_SB_E_S}
	 * labeled alternative in {@link cmmParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitI_SB_E_S(cmmParser.I_SB_E_SContext ctx);
	/**
	 * Enter a parse tree produced by the {@code I_SB_E_SB}
	 * labeled alternative in {@link cmmParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterI_SB_E_SB(cmmParser.I_SB_E_SBContext ctx);
	/**
	 * Exit a parse tree produced by the {@code I_SB_E_SB}
	 * labeled alternative in {@link cmmParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitI_SB_E_SB(cmmParser.I_SB_E_SBContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(cmmParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(cmmParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmParser#break_stmt}.
	 * @param ctx the parse tree
	 */
	void enterBreak_stmt(cmmParser.Break_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmParser#break_stmt}.
	 * @param ctx the parse tree
	 */
	void exitBreak_stmt(cmmParser.Break_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmParser#read_stmt}.
	 * @param ctx the parse tree
	 */
	void enterRead_stmt(cmmParser.Read_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmParser#read_stmt}.
	 * @param ctx the parse tree
	 */
	void exitRead_stmt(cmmParser.Read_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmParser#write_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWrite_stmt(cmmParser.Write_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmParser#write_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWrite_stmt(cmmParser.Write_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign_stmt(cmmParser.Assign_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign_stmt(cmmParser.Assign_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(cmmParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(cmmParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(cmmParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(cmmParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(cmmParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(cmmParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link cmmParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(cmmParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link cmmParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(cmmParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueExpr}
	 * labeled alternative in {@link cmmParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterValueExpr(cmmParser.ValueExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueExpr}
	 * labeled alternative in {@link cmmParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitValueExpr(cmmParser.ValueExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolExpr}
	 * labeled alternative in {@link cmmParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(cmmParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolExpr}
	 * labeled alternative in {@link cmmParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(cmmParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDivExpr}
	 * labeled alternative in {@link cmmParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDivExpr(cmmParser.MulDivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDivExpr}
	 * labeled alternative in {@link cmmParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDivExpr(cmmParser.MulDivExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddMinExpr}
	 * labeled alternative in {@link cmmParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddMinExpr(cmmParser.AddMinExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddMinExpr}
	 * labeled alternative in {@link cmmParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddMinExpr(cmmParser.AddMinExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompareExpr}
	 * labeled alternative in {@link cmmParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCompareExpr(cmmParser.CompareExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompareExpr}
	 * labeled alternative in {@link cmmParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCompareExpr(cmmParser.CompareExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarExpr}
	 * labeled alternative in {@link cmmParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVarExpr(cmmParser.VarExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarExpr}
	 * labeled alternative in {@link cmmParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVarExpr(cmmParser.VarExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesesExpr}
	 * labeled alternative in {@link cmmParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenthesesExpr(cmmParser.ParenthesesExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesesExpr}
	 * labeled alternative in {@link cmmParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenthesesExpr(cmmParser.ParenthesesExprContext ctx);
}