// Generated from /Users/steveyyy/Programming/cmmInterpreter/src/antlr/cmm.g4 by ANTLR 4.6
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link cmmParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface cmmVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link cmmParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(cmmParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(cmmParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmParser#stmt_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt_block(cmmParser.Stmt_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmParser#var_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_decl(cmmParser.Var_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(cmmParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmParser#varlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarlist(cmmParser.VarlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmParser#decl_assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl_assign(cmmParser.Decl_assignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code I_S}
	 * labeled alternative in {@link cmmParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitI_S(cmmParser.I_SContext ctx);
	/**
	 * Visit a parse tree produced by the {@code I_SB}
	 * labeled alternative in {@link cmmParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitI_SB(cmmParser.I_SBContext ctx);
	/**
	 * Visit a parse tree produced by the {@code I_S_E_S}
	 * labeled alternative in {@link cmmParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitI_S_E_S(cmmParser.I_S_E_SContext ctx);
	/**
	 * Visit a parse tree produced by the {@code I_S_E_SB}
	 * labeled alternative in {@link cmmParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitI_S_E_SB(cmmParser.I_S_E_SBContext ctx);
	/**
	 * Visit a parse tree produced by the {@code I_SB_E_S}
	 * labeled alternative in {@link cmmParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitI_SB_E_S(cmmParser.I_SB_E_SContext ctx);
	/**
	 * Visit a parse tree produced by the {@code I_SB_E_SB}
	 * labeled alternative in {@link cmmParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitI_SB_E_SB(cmmParser.I_SB_E_SBContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmParser#while_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stmt(cmmParser.While_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmParser#break_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak_stmt(cmmParser.Break_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmParser#read_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead_stmt(cmmParser.Read_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmParser#write_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWrite_stmt(cmmParser.Write_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmParser#assign_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_stmt(cmmParser.Assign_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(cmmParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(cmmParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link cmmParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(cmmParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SignExpr}
	 * labeled alternative in {@link cmmParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignExpr(cmmParser.SignExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueExpr}
	 * labeled alternative in {@link cmmParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueExpr(cmmParser.ValueExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDivExpr}
	 * labeled alternative in {@link cmmParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivExpr(cmmParser.MulDivExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddMinExpr}
	 * labeled alternative in {@link cmmParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddMinExpr(cmmParser.AddMinExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompareExpr}
	 * labeled alternative in {@link cmmParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExpr(cmmParser.CompareExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesesExpr}
	 * labeled alternative in {@link cmmParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesesExpr(cmmParser.ParenthesesExprContext ctx);
}