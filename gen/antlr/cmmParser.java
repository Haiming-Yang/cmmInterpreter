// Generated from /Users/steveyyy/Programming/cmmInterpreter/src/antlr/cmm.g4 by ANTLR 4.5.3
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class cmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		If=1, Else=2, While=3, Read=4, Write=5, Int=6, Real=7, Break=8, Ident=9, 
		IntConstant=10, RealConstant=11, BooleanConstant=12, CompOp=13, MulDivMod=14, 
		AddMin=15, LBracket=16, RBracket=17, LBigBracket=18, RBigBracket=19, LMidBracket=20, 
		RMidBracket=21, Assign=22, LineEnd=23, Comma=24, WS=25, SL_COMMENT=26, 
		MUL_COMMENT=27;
	public static final int
		RULE_program = 0, RULE_stmt = 1, RULE_stmt_block = 2, RULE_var_decl = 3, 
		RULE_type = 4, RULE_varlist = 5, RULE_decl_assign = 6, RULE_if_stmt = 7, 
		RULE_while_stmt = 8, RULE_break_stmt = 9, RULE_read_stmt = 10, RULE_write_stmt = 11, 
		RULE_assign_stmt = 12, RULE_value = 13, RULE_array = 14, RULE_constant = 15, 
		RULE_expr = 16;
	public static final String[] ruleNames = {
		"program", "stmt", "stmt_block", "var_decl", "type", "varlist", "decl_assign", 
		"if_stmt", "while_stmt", "break_stmt", "read_stmt", "write_stmt", "assign_stmt", 
		"value", "array", "constant", "expr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'else'", "'while'", "'read'", "'write'", "'int'", "'real'", 
		"'break'", null, null, null, null, null, null, null, "'('", "')'", "'{'", 
		"'}'", "'['", "']'", "'='", "';'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "If", "Else", "While", "Read", "Write", "Int", "Real", "Break", 
		"Ident", "IntConstant", "RealConstant", "BooleanConstant", "CompOp", "MulDivMod", 
		"AddMin", "LBracket", "RBracket", "LBigBracket", "RBigBracket", "LMidBracket", 
		"RMidBracket", "Assign", "LineEnd", "Comma", "WS", "SL_COMMENT", "MUL_COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "cmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public cmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34);
				stmt();
				}
				}
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << If) | (1L << While) | (1L << Read) | (1L << Write) | (1L << Int) | (1L << Real) | (1L << Break) | (1L << Ident) | (1L << IntConstant) | (1L << RealConstant) | (1L << LBigBracket))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public Break_stmtContext break_stmt() {
			return getRuleContext(Break_stmtContext.class,0);
		}
		public Assign_stmtContext assign_stmt() {
			return getRuleContext(Assign_stmtContext.class,0);
		}
		public Read_stmtContext read_stmt() {
			return getRuleContext(Read_stmtContext.class,0);
		}
		public Write_stmtContext write_stmt() {
			return getRuleContext(Write_stmtContext.class,0);
		}
		public Stmt_blockContext stmt_block() {
			return getRuleContext(Stmt_blockContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmt);
		try {
			setState(47);
			switch (_input.LA(1)) {
			case Int:
			case Real:
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				var_decl();
				}
				break;
			case If:
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				if_stmt();
				}
				break;
			case While:
				enterOuterAlt(_localctx, 3);
				{
				setState(41);
				while_stmt();
				}
				break;
			case Break:
				enterOuterAlt(_localctx, 4);
				{
				setState(42);
				break_stmt();
				}
				break;
			case Ident:
			case IntConstant:
			case RealConstant:
				enterOuterAlt(_localctx, 5);
				{
				setState(43);
				assign_stmt();
				}
				break;
			case Read:
				enterOuterAlt(_localctx, 6);
				{
				setState(44);
				read_stmt();
				}
				break;
			case Write:
				enterOuterAlt(_localctx, 7);
				{
				setState(45);
				write_stmt();
				}
				break;
			case LBigBracket:
				enterOuterAlt(_localctx, 8);
				{
				setState(46);
				stmt_block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Stmt_blockContext extends ParserRuleContext {
		public TerminalNode LBigBracket() { return getToken(cmmParser.LBigBracket, 0); }
		public TerminalNode RBigBracket() { return getToken(cmmParser.RBigBracket, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public Stmt_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterStmt_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitStmt_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitStmt_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stmt_blockContext stmt_block() throws RecognitionException {
		Stmt_blockContext _localctx = new Stmt_blockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stmt_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(LBigBracket);
			setState(51); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(50);
				stmt();
				}
				}
				setState(53); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << If) | (1L << While) | (1L << Read) | (1L << Write) | (1L << Int) | (1L << Real) | (1L << Break) | (1L << Ident) | (1L << IntConstant) | (1L << RealConstant) | (1L << LBigBracket))) != 0) );
			setState(55);
			match(RBigBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_declContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarlistContext varlist() {
			return getRuleContext(VarlistContext.class,0);
		}
		public TerminalNode LineEnd() { return getToken(cmmParser.LineEnd, 0); }
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterVar_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitVar_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitVar_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_var_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			type();
			setState(58);
			varlist();
			setState(59);
			match(LineEnd);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode Int() { return getToken(cmmParser.Int, 0); }
		public TerminalNode Real() { return getToken(cmmParser.Real, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_la = _input.LA(1);
			if ( !(_la==Int || _la==Real) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarlistContext extends ParserRuleContext {
		public List<TerminalNode> Ident() { return getTokens(cmmParser.Ident); }
		public TerminalNode Ident(int i) {
			return getToken(cmmParser.Ident, i);
		}
		public List<Decl_assignContext> decl_assign() {
			return getRuleContexts(Decl_assignContext.class);
		}
		public Decl_assignContext decl_assign(int i) {
			return getRuleContext(Decl_assignContext.class,i);
		}
		public List<ArrayContext> array() {
			return getRuleContexts(ArrayContext.class);
		}
		public ArrayContext array(int i) {
			return getRuleContext(ArrayContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(cmmParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(cmmParser.Comma, i);
		}
		public VarlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterVarlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitVarlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitVarlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarlistContext varlist() throws RecognitionException {
		VarlistContext _localctx = new VarlistContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(63);
				match(Ident);
				}
				break;
			case 2:
				{
				setState(64);
				decl_assign();
				}
				break;
			case 3:
				{
				setState(65);
				array();
				}
				break;
			}
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(68);
				match(Comma);
				setState(72);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(69);
					match(Ident);
					}
					break;
				case 2:
					{
					setState(70);
					decl_assign();
					}
					break;
				case 3:
					{
					setState(71);
					array();
					}
					break;
				}
				}
				}
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Decl_assignContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(cmmParser.Ident, 0); }
		public TerminalNode Assign() { return getToken(cmmParser.Assign, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Decl_assignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterDecl_assign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitDecl_assign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitDecl_assign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Decl_assignContext decl_assign() throws RecognitionException {
		Decl_assignContext _localctx = new Decl_assignContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_decl_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(Ident);
			setState(80);
			match(Assign);
			setState(81);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_stmtContext extends ParserRuleContext {
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
	 
		public If_stmtContext() { }
		public void copyFrom(If_stmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class I_SB_E_SBContext extends If_stmtContext {
		public TerminalNode If() { return getToken(cmmParser.If, 0); }
		public TerminalNode LBracket() { return getToken(cmmParser.LBracket, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBracket() { return getToken(cmmParser.RBracket, 0); }
		public List<Stmt_blockContext> stmt_block() {
			return getRuleContexts(Stmt_blockContext.class);
		}
		public Stmt_blockContext stmt_block(int i) {
			return getRuleContext(Stmt_blockContext.class,i);
		}
		public TerminalNode Else() { return getToken(cmmParser.Else, 0); }
		public I_SB_E_SBContext(If_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterI_SB_E_SB(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitI_SB_E_SB(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitI_SB_E_SB(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class I_S_E_SContext extends If_stmtContext {
		public TerminalNode If() { return getToken(cmmParser.If, 0); }
		public TerminalNode LBracket() { return getToken(cmmParser.LBracket, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBracket() { return getToken(cmmParser.RBracket, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode Else() { return getToken(cmmParser.Else, 0); }
		public I_S_E_SContext(If_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterI_S_E_S(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitI_S_E_S(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitI_S_E_S(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class I_SBContext extends If_stmtContext {
		public TerminalNode If() { return getToken(cmmParser.If, 0); }
		public TerminalNode LBracket() { return getToken(cmmParser.LBracket, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBracket() { return getToken(cmmParser.RBracket, 0); }
		public Stmt_blockContext stmt_block() {
			return getRuleContext(Stmt_blockContext.class,0);
		}
		public I_SBContext(If_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterI_SB(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitI_SB(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitI_SB(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class I_S_E_SBContext extends If_stmtContext {
		public TerminalNode If() { return getToken(cmmParser.If, 0); }
		public TerminalNode LBracket() { return getToken(cmmParser.LBracket, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBracket() { return getToken(cmmParser.RBracket, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public TerminalNode Else() { return getToken(cmmParser.Else, 0); }
		public Stmt_blockContext stmt_block() {
			return getRuleContext(Stmt_blockContext.class,0);
		}
		public I_S_E_SBContext(If_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterI_S_E_SB(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitI_S_E_SB(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitI_S_E_SB(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class I_SB_E_SContext extends If_stmtContext {
		public TerminalNode If() { return getToken(cmmParser.If, 0); }
		public TerminalNode LBracket() { return getToken(cmmParser.LBracket, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBracket() { return getToken(cmmParser.RBracket, 0); }
		public Stmt_blockContext stmt_block() {
			return getRuleContext(Stmt_blockContext.class,0);
		}
		public TerminalNode Else() { return getToken(cmmParser.Else, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public I_SB_E_SContext(If_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterI_SB_E_S(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitI_SB_E_S(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitI_SB_E_S(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class I_SContext extends If_stmtContext {
		public TerminalNode If() { return getToken(cmmParser.If, 0); }
		public TerminalNode LBracket() { return getToken(cmmParser.LBracket, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBracket() { return getToken(cmmParser.RBracket, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public I_SContext(If_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterI_S(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitI_S(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitI_S(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_if_stmt);
		try {
			setState(127);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new I_SContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				match(If);
				setState(84);
				match(LBracket);
				setState(85);
				expr(0);
				setState(86);
				match(RBracket);
				setState(87);
				stmt();
				}
				break;
			case 2:
				_localctx = new I_SBContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				match(If);
				setState(90);
				match(LBracket);
				setState(91);
				expr(0);
				setState(92);
				match(RBracket);
				setState(93);
				stmt_block();
				}
				break;
			case 3:
				_localctx = new I_S_E_SContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(95);
				match(If);
				setState(96);
				match(LBracket);
				setState(97);
				expr(0);
				setState(98);
				match(RBracket);
				setState(99);
				stmt();
				setState(100);
				match(Else);
				setState(101);
				stmt();
				}
				break;
			case 4:
				_localctx = new I_S_E_SBContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(103);
				match(If);
				setState(104);
				match(LBracket);
				setState(105);
				expr(0);
				setState(106);
				match(RBracket);
				setState(107);
				stmt();
				setState(108);
				match(Else);
				setState(109);
				stmt_block();
				}
				break;
			case 5:
				_localctx = new I_SB_E_SContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(111);
				match(If);
				setState(112);
				match(LBracket);
				setState(113);
				expr(0);
				setState(114);
				match(RBracket);
				setState(115);
				stmt_block();
				setState(116);
				match(Else);
				setState(117);
				stmt();
				}
				break;
			case 6:
				_localctx = new I_SB_E_SBContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(119);
				match(If);
				setState(120);
				match(LBracket);
				setState(121);
				expr(0);
				setState(122);
				match(RBracket);
				setState(123);
				stmt_block();
				setState(124);
				match(Else);
				setState(125);
				stmt_block();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class While_stmtContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(cmmParser.While, 0); }
		public TerminalNode LBracket() { return getToken(cmmParser.LBracket, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBracket() { return getToken(cmmParser.RBracket, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public Stmt_blockContext stmt_block() {
			return getRuleContext(Stmt_blockContext.class,0);
		}
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterWhile_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitWhile_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitWhile_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(While);
			setState(130);
			match(LBracket);
			setState(131);
			expr(0);
			setState(132);
			match(RBracket);
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(133);
				stmt();
				}
				break;
			case 2:
				{
				setState(134);
				stmt_block();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Break_stmtContext extends ParserRuleContext {
		public TerminalNode Break() { return getToken(cmmParser.Break, 0); }
		public TerminalNode LineEnd() { return getToken(cmmParser.LineEnd, 0); }
		public Break_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_break_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterBreak_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitBreak_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitBreak_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Break_stmtContext break_stmt() throws RecognitionException {
		Break_stmtContext _localctx = new Break_stmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_break_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(Break);
			setState(138);
			match(LineEnd);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Read_stmtContext extends ParserRuleContext {
		public TerminalNode Read() { return getToken(cmmParser.Read, 0); }
		public TerminalNode LBracket() { return getToken(cmmParser.LBracket, 0); }
		public TerminalNode RBracket() { return getToken(cmmParser.RBracket, 0); }
		public TerminalNode LineEnd() { return getToken(cmmParser.LineEnd, 0); }
		public TerminalNode Ident() { return getToken(cmmParser.Ident, 0); }
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public Read_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterRead_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitRead_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitRead_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Read_stmtContext read_stmt() throws RecognitionException {
		Read_stmtContext _localctx = new Read_stmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_read_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(Read);
			setState(141);
			match(LBracket);
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(142);
				match(Ident);
				}
				break;
			case 2:
				{
				setState(143);
				array();
				}
				break;
			}
			setState(146);
			match(RBracket);
			setState(147);
			match(LineEnd);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Write_stmtContext extends ParserRuleContext {
		public TerminalNode Write() { return getToken(cmmParser.Write, 0); }
		public TerminalNode LBracket() { return getToken(cmmParser.LBracket, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBracket() { return getToken(cmmParser.RBracket, 0); }
		public TerminalNode LineEnd() { return getToken(cmmParser.LineEnd, 0); }
		public Write_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_write_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterWrite_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitWrite_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitWrite_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Write_stmtContext write_stmt() throws RecognitionException {
		Write_stmtContext _localctx = new Write_stmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_write_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(Write);
			setState(150);
			match(LBracket);
			setState(151);
			expr(0);
			setState(152);
			match(RBracket);
			setState(153);
			match(LineEnd);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_stmtContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode Assign() { return getToken(cmmParser.Assign, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LineEnd() { return getToken(cmmParser.LineEnd, 0); }
		public Assign_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterAssign_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitAssign_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitAssign_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_stmtContext assign_stmt() throws RecognitionException {
		Assign_stmtContext _localctx = new Assign_stmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_assign_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			value();
			setState(156);
			match(Assign);
			setState(157);
			expr(0);
			setState(158);
			match(LineEnd);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(cmmParser.Ident, 0); }
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_value);
		try {
			setState(163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				match(Ident);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				array();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(162);
				constant();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(cmmParser.Ident, 0); }
		public TerminalNode LMidBracket() { return getToken(cmmParser.LMidBracket, 0); }
		public TerminalNode RMidBracket() { return getToken(cmmParser.RMidBracket, 0); }
		public TerminalNode IntConstant() { return getToken(cmmParser.IntConstant, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(Ident);
			setState(166);
			match(LMidBracket);
			setState(169);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(167);
				match(IntConstant);
				}
				break;
			case 2:
				{
				setState(168);
				expr(0);
				}
				break;
			}
			setState(171);
			match(RMidBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode IntConstant() { return getToken(cmmParser.IntConstant, 0); }
		public TerminalNode RealConstant() { return getToken(cmmParser.RealConstant, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			_la = _input.LA(1);
			if ( !(_la==IntConstant || _la==RealConstant) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SignExprContext extends ExprContext {
		public TerminalNode AddMin() { return getToken(cmmParser.AddMin, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SignExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterSignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitSignExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitSignExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValueExprContext extends ExprContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ValueExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterValueExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitValueExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitValueExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulDivExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MulDivMod() { return getToken(cmmParser.MulDivMod, 0); }
		public MulDivExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterMulDivExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitMulDivExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitMulDivExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddMinExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AddMin() { return getToken(cmmParser.AddMin, 0); }
		public AddMinExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterAddMinExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitAddMinExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitAddMinExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompareExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CompOp() { return getToken(cmmParser.CompOp, 0); }
		public CompareExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterCompareExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitCompareExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitCompareExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesesExprContext extends ExprContext {
		public TerminalNode LBracket() { return getToken(cmmParser.LBracket, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBracket() { return getToken(cmmParser.RBracket, 0); }
		public ParenthesesExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterParenthesesExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitParenthesesExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitParenthesesExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			switch (_input.LA(1)) {
			case LBracket:
				{
				_localctx = new ParenthesesExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(176);
				match(LBracket);
				setState(177);
				expr(0);
				setState(178);
				match(RBracket);
				}
				break;
			case Ident:
			case IntConstant:
			case RealConstant:
				{
				_localctx = new ValueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(180);
				value();
				}
				break;
			case AddMin:
				{
				_localctx = new SignExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(181);
				match(AddMin);
				setState(182);
				expr(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(196);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(194);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(185);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(186);
						match(MulDivMod);
						setState(187);
						expr(7);
						}
						break;
					case 2:
						{
						_localctx = new AddMinExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(188);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(189);
						match(AddMin);
						setState(190);
						expr(6);
						}
						break;
					case 3:
						{
						_localctx = new CompareExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(191);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(192);
						match(CompOp);
						setState(193);
						expr(5);
						}
						break;
					}
					} 
				}
				setState(198);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 16:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\35\u00ca\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\6\2&\n\2\r\2\16\2\'\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\62\n\3\3"+
		"\4\3\4\6\4\66\n\4\r\4\16\4\67\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7"+
		"\3\7\5\7E\n\7\3\7\3\7\3\7\3\7\5\7K\n\7\7\7M\n\7\f\7\16\7P\13\7\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0082\n\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\5\n\u008a\n\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\5\f\u0093\n"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3"+
		"\17\3\17\5\17\u00a6\n\17\3\20\3\20\3\20\3\20\5\20\u00ac\n\20\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00ba\n\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u00c5\n\22\f\22\16\22\u00c8"+
		"\13\22\3\22\2\3\"\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\4\3\2"+
		"\b\t\3\2\f\r\u00d5\2%\3\2\2\2\4\61\3\2\2\2\6\63\3\2\2\2\b;\3\2\2\2\n?"+
		"\3\2\2\2\fD\3\2\2\2\16Q\3\2\2\2\20\u0081\3\2\2\2\22\u0083\3\2\2\2\24\u008b"+
		"\3\2\2\2\26\u008e\3\2\2\2\30\u0097\3\2\2\2\32\u009d\3\2\2\2\34\u00a5\3"+
		"\2\2\2\36\u00a7\3\2\2\2 \u00af\3\2\2\2\"\u00b9\3\2\2\2$&\5\4\3\2%$\3\2"+
		"\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\3\3\2\2\2)\62\5\b\5\2*\62\5\20"+
		"\t\2+\62\5\22\n\2,\62\5\24\13\2-\62\5\32\16\2.\62\5\26\f\2/\62\5\30\r"+
		"\2\60\62\5\6\4\2\61)\3\2\2\2\61*\3\2\2\2\61+\3\2\2\2\61,\3\2\2\2\61-\3"+
		"\2\2\2\61.\3\2\2\2\61/\3\2\2\2\61\60\3\2\2\2\62\5\3\2\2\2\63\65\7\24\2"+
		"\2\64\66\5\4\3\2\65\64\3\2\2\2\66\67\3\2\2\2\67\65\3\2\2\2\678\3\2\2\2"+
		"89\3\2\2\29:\7\25\2\2:\7\3\2\2\2;<\5\n\6\2<=\5\f\7\2=>\7\31\2\2>\t\3\2"+
		"\2\2?@\t\2\2\2@\13\3\2\2\2AE\7\13\2\2BE\5\16\b\2CE\5\36\20\2DA\3\2\2\2"+
		"DB\3\2\2\2DC\3\2\2\2EN\3\2\2\2FJ\7\32\2\2GK\7\13\2\2HK\5\16\b\2IK\5\36"+
		"\20\2JG\3\2\2\2JH\3\2\2\2JI\3\2\2\2KM\3\2\2\2LF\3\2\2\2MP\3\2\2\2NL\3"+
		"\2\2\2NO\3\2\2\2O\r\3\2\2\2PN\3\2\2\2QR\7\13\2\2RS\7\30\2\2ST\5\"\22\2"+
		"T\17\3\2\2\2UV\7\3\2\2VW\7\22\2\2WX\5\"\22\2XY\7\23\2\2YZ\5\4\3\2Z\u0082"+
		"\3\2\2\2[\\\7\3\2\2\\]\7\22\2\2]^\5\"\22\2^_\7\23\2\2_`\5\6\4\2`\u0082"+
		"\3\2\2\2ab\7\3\2\2bc\7\22\2\2cd\5\"\22\2de\7\23\2\2ef\5\4\3\2fg\7\4\2"+
		"\2gh\5\4\3\2h\u0082\3\2\2\2ij\7\3\2\2jk\7\22\2\2kl\5\"\22\2lm\7\23\2\2"+
		"mn\5\4\3\2no\7\4\2\2op\5\6\4\2p\u0082\3\2\2\2qr\7\3\2\2rs\7\22\2\2st\5"+
		"\"\22\2tu\7\23\2\2uv\5\6\4\2vw\7\4\2\2wx\5\4\3\2x\u0082\3\2\2\2yz\7\3"+
		"\2\2z{\7\22\2\2{|\5\"\22\2|}\7\23\2\2}~\5\6\4\2~\177\7\4\2\2\177\u0080"+
		"\5\6\4\2\u0080\u0082\3\2\2\2\u0081U\3\2\2\2\u0081[\3\2\2\2\u0081a\3\2"+
		"\2\2\u0081i\3\2\2\2\u0081q\3\2\2\2\u0081y\3\2\2\2\u0082\21\3\2\2\2\u0083"+
		"\u0084\7\5\2\2\u0084\u0085\7\22\2\2\u0085\u0086\5\"\22\2\u0086\u0089\7"+
		"\23\2\2\u0087\u008a\5\4\3\2\u0088\u008a\5\6\4\2\u0089\u0087\3\2\2\2\u0089"+
		"\u0088\3\2\2\2\u008a\23\3\2\2\2\u008b\u008c\7\n\2\2\u008c\u008d\7\31\2"+
		"\2\u008d\25\3\2\2\2\u008e\u008f\7\6\2\2\u008f\u0092\7\22\2\2\u0090\u0093"+
		"\7\13\2\2\u0091\u0093\5\36\20\2\u0092\u0090\3\2\2\2\u0092\u0091\3\2\2"+
		"\2\u0093\u0094\3\2\2\2\u0094\u0095\7\23\2\2\u0095\u0096\7\31\2\2\u0096"+
		"\27\3\2\2\2\u0097\u0098\7\7\2\2\u0098\u0099\7\22\2\2\u0099\u009a\5\"\22"+
		"\2\u009a\u009b\7\23\2\2\u009b\u009c\7\31\2\2\u009c\31\3\2\2\2\u009d\u009e"+
		"\5\34\17\2\u009e\u009f\7\30\2\2\u009f\u00a0\5\"\22\2\u00a0\u00a1\7\31"+
		"\2\2\u00a1\33\3\2\2\2\u00a2\u00a6\7\13\2\2\u00a3\u00a6\5\36\20\2\u00a4"+
		"\u00a6\5 \21\2\u00a5\u00a2\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a4\3\2"+
		"\2\2\u00a6\35\3\2\2\2\u00a7\u00a8\7\13\2\2\u00a8\u00ab\7\26\2\2\u00a9"+
		"\u00ac\7\f\2\2\u00aa\u00ac\5\"\22\2\u00ab\u00a9\3\2\2\2\u00ab\u00aa\3"+
		"\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\7\27\2\2\u00ae\37\3\2\2\2\u00af"+
		"\u00b0\t\3\2\2\u00b0!\3\2\2\2\u00b1\u00b2\b\22\1\2\u00b2\u00b3\7\22\2"+
		"\2\u00b3\u00b4\5\"\22\2\u00b4\u00b5\7\23\2\2\u00b5\u00ba\3\2\2\2\u00b6"+
		"\u00ba\5\34\17\2\u00b7\u00b8\7\21\2\2\u00b8\u00ba\5\"\22\3\u00b9\u00b1"+
		"\3\2\2\2\u00b9\u00b6\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00c6\3\2\2\2\u00bb"+
		"\u00bc\f\b\2\2\u00bc\u00bd\7\20\2\2\u00bd\u00c5\5\"\22\t\u00be\u00bf\f"+
		"\7\2\2\u00bf\u00c0\7\21\2\2\u00c0\u00c5\5\"\22\b\u00c1\u00c2\f\6\2\2\u00c2"+
		"\u00c3\7\17\2\2\u00c3\u00c5\5\"\22\7\u00c4\u00bb\3\2\2\2\u00c4\u00be\3"+
		"\2\2\2\u00c4\u00c1\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6"+
		"\u00c7\3\2\2\2\u00c7#\3\2\2\2\u00c8\u00c6\3\2\2\2\20\'\61\67DJN\u0081"+
		"\u0089\u0092\u00a5\u00ab\u00b9\u00c4\u00c6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}