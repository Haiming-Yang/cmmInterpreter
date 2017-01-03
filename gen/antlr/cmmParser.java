// Generated from /Users/steveyyy/Programming/cmmInterpreter/src/antlr/cmm.g4 by ANTLR 4.6
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
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		If=1, Else=2, While=3, Read=4, Write=5, Int=6, Double=7, Break=8, BooleanConstant=9, 
		Ident=10, CompOp=11, MulDivMod=12, AddMin=13, IntConstant=14, DoubleConstant=15, 
		HexIntConstant=16, HexDoubleConstant=17, LBracket=18, RBracket=19, LBigBracket=20, 
		RBigBracket=21, LMidBracket=22, RMidBracket=23, Assign=24, LineEnd=25, 
		Comma=26, WS=27, SL_COMMENT=28, MUL_COMMENT=29;
	public static final int
		RULE_program = 0, RULE_stmt = 1, RULE_stmt_block = 2, RULE_var_decl = 3, 
		RULE_type = 4, RULE_varlist = 5, RULE_decl_assign = 6, RULE_if_stmt = 7, 
		RULE_while_stmt = 8, RULE_break_stmt = 9, RULE_read_stmt = 10, RULE_write_stmt = 11, 
		RULE_assign_stmt = 12, RULE_var = 13, RULE_bool = 14, RULE_array = 15, 
		RULE_value = 16, RULE_expr = 17;
	public static final String[] ruleNames = {
		"program", "stmt", "stmt_block", "var_decl", "type", "varlist", "decl_assign", 
		"if_stmt", "while_stmt", "break_stmt", "read_stmt", "write_stmt", "assign_stmt", 
		"var", "bool", "array", "value", "expr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'else'", "'while'", "'read'", "'write'", "'int'", "'double'", 
		"'break'", null, null, null, null, null, null, null, null, null, "'('", 
		"')'", "'{'", "'}'", "'['", "']'", "'='", "';'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "If", "Else", "While", "Read", "Write", "Int", "Double", "Break", 
		"BooleanConstant", "Ident", "CompOp", "MulDivMod", "AddMin", "IntConstant", 
		"DoubleConstant", "HexIntConstant", "HexDoubleConstant", "LBracket", "RBracket", 
		"LBigBracket", "RBigBracket", "LMidBracket", "RMidBracket", "Assign", 
		"LineEnd", "Comma", "WS", "SL_COMMENT", "MUL_COMMENT"
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
			setState(37); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(36);
				stmt();
				}
				}
				setState(39); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << If) | (1L << While) | (1L << Read) | (1L << Write) | (1L << Int) | (1L << Double) | (1L << Break) | (1L << Ident) | (1L << LBigBracket))) != 0) );
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
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Int:
			case Double:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				var_decl();
				}
				break;
			case If:
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				if_stmt();
				}
				break;
			case While:
				enterOuterAlt(_localctx, 3);
				{
				setState(43);
				while_stmt();
				}
				break;
			case Break:
				enterOuterAlt(_localctx, 4);
				{
				setState(44);
				break_stmt();
				}
				break;
			case Ident:
				enterOuterAlt(_localctx, 5);
				{
				setState(45);
				assign_stmt();
				}
				break;
			case Read:
				enterOuterAlt(_localctx, 6);
				{
				setState(46);
				read_stmt();
				}
				break;
			case Write:
				enterOuterAlt(_localctx, 7);
				{
				setState(47);
				write_stmt();
				}
				break;
			case LBigBracket:
				enterOuterAlt(_localctx, 8);
				{
				setState(48);
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
			setState(51);
			match(LBigBracket);
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << If) | (1L << While) | (1L << Read) | (1L << Write) | (1L << Int) | (1L << Double) | (1L << Break) | (1L << Ident) | (1L << LBigBracket))) != 0)) {
				{
				{
				setState(52);
				stmt();
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(58);
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
			setState(60);
			type();
			setState(61);
			varlist();
			setState(62);
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
		public TerminalNode Double() { return getToken(cmmParser.Double, 0); }
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
			setState(64);
			_la = _input.LA(1);
			if ( !(_la==Int || _la==Double) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(66);
				match(Ident);
				}
				break;
			case 2:
				{
				setState(67);
				decl_assign();
				}
				break;
			case 3:
				{
				setState(68);
				array();
				}
				break;
			}
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(71);
				match(Comma);
				setState(75);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(72);
					match(Ident);
					}
					break;
				case 2:
					{
					setState(73);
					decl_assign();
					}
					break;
				case 3:
					{
					setState(74);
					array();
					}
					break;
				}
				}
				}
				setState(81);
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
			setState(82);
			match(Ident);
			setState(83);
			match(Assign);
			setState(84);
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
			setState(130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new I_SContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				match(If);
				setState(87);
				match(LBracket);
				setState(88);
				expr(0);
				setState(89);
				match(RBracket);
				setState(90);
				stmt();
				}
				break;
			case 2:
				_localctx = new I_SBContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				match(If);
				setState(93);
				match(LBracket);
				setState(94);
				expr(0);
				setState(95);
				match(RBracket);
				setState(96);
				stmt_block();
				}
				break;
			case 3:
				_localctx = new I_S_E_SContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(98);
				match(If);
				setState(99);
				match(LBracket);
				setState(100);
				expr(0);
				setState(101);
				match(RBracket);
				setState(102);
				stmt();
				setState(103);
				match(Else);
				setState(104);
				stmt();
				}
				break;
			case 4:
				_localctx = new I_S_E_SBContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(106);
				match(If);
				setState(107);
				match(LBracket);
				setState(108);
				expr(0);
				setState(109);
				match(RBracket);
				setState(110);
				stmt();
				setState(111);
				match(Else);
				setState(112);
				stmt_block();
				}
				break;
			case 5:
				_localctx = new I_SB_E_SContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(114);
				match(If);
				setState(115);
				match(LBracket);
				setState(116);
				expr(0);
				setState(117);
				match(RBracket);
				setState(118);
				stmt_block();
				setState(119);
				match(Else);
				setState(120);
				stmt();
				}
				break;
			case 6:
				_localctx = new I_SB_E_SBContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(122);
				match(If);
				setState(123);
				match(LBracket);
				setState(124);
				expr(0);
				setState(125);
				match(RBracket);
				setState(126);
				stmt_block();
				setState(127);
				match(Else);
				setState(128);
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
			setState(132);
			match(While);
			setState(133);
			match(LBracket);
			setState(134);
			expr(0);
			setState(135);
			match(RBracket);
			setState(138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(136);
				stmt();
				}
				break;
			case 2:
				{
				setState(137);
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
			setState(140);
			match(Break);
			setState(141);
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
			setState(143);
			match(Read);
			setState(144);
			match(LBracket);
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(145);
				match(Ident);
				}
				break;
			case 2:
				{
				setState(146);
				array();
				}
				break;
			}
			setState(149);
			match(RBracket);
			setState(150);
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
			setState(152);
			match(Write);
			setState(153);
			match(LBracket);
			setState(154);
			expr(0);
			setState(155);
			match(RBracket);
			setState(156);
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
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
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
			setState(158);
			var();
			setState(159);
			match(Assign);
			setState(160);
			expr(0);
			setState(161);
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

	public static class VarContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(cmmParser.Ident, 0); }
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_var);
		try {
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				match(Ident);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				array();
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

	public static class BoolContext extends ParserRuleContext {
		public TerminalNode BooleanConstant() { return getToken(cmmParser.BooleanConstant, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_bool);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(BooleanConstant);
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
		enterRule(_localctx, 30, RULE_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(Ident);
			setState(170);
			match(LMidBracket);
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(171);
				match(IntConstant);
				}
				break;
			case 2:
				{
				setState(172);
				expr(0);
				}
				break;
			}
			setState(175);
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode IntConstant() { return getToken(cmmParser.IntConstant, 0); }
		public TerminalNode DoubleConstant() { return getToken(cmmParser.DoubleConstant, 0); }
		public TerminalNode HexDoubleConstant() { return getToken(cmmParser.HexDoubleConstant, 0); }
		public TerminalNode HexIntConstant() { return getToken(cmmParser.HexIntConstant, 0); }
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
		enterRule(_localctx, 32, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntConstant) | (1L << DoubleConstant) | (1L << HexIntConstant) | (1L << HexDoubleConstant))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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
	public static class BoolExprContext extends ExprContext {
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public BoolExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterBoolExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitBoolExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitBoolExpr(this);
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
	public static class VarExprContext extends ExprContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public VarExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).enterVarExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cmmListener ) ((cmmListener)listener).exitVarExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cmmVisitor ) return ((cmmVisitor<? extends T>)visitor).visitVarExpr(this);
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
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBracket:
				{
				_localctx = new ParenthesesExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(180);
				match(LBracket);
				setState(181);
				expr(0);
				setState(182);
				match(RBracket);
				}
				break;
			case IntConstant:
			case DoubleConstant:
			case HexIntConstant:
			case HexDoubleConstant:
				{
				_localctx = new ValueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(184);
				value();
				}
				break;
			case Ident:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(185);
				var();
				}
				break;
			case BooleanConstant:
				{
				_localctx = new BoolExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(186);
				bool();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(200);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(198);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(189);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(190);
						match(MulDivMod);
						setState(191);
						expr(8);
						}
						break;
					case 2:
						{
						_localctx = new AddMinExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(192);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(193);
						match(AddMin);
						setState(194);
						expr(7);
						}
						break;
					case 3:
						{
						_localctx = new CompareExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(195);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(196);
						match(CompOp);
						setState(197);
						expr(6);
						}
						break;
					}
					} 
				}
				setState(202);
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
		case 17:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\37\u00ce\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\6\2(\n\2\r\2\16\2)\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3"+
		"\64\n\3\3\4\3\4\7\48\n\4\f\4\16\4;\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\7\3\7\3\7\5\7H\n\7\3\7\3\7\3\7\3\7\5\7N\n\7\7\7P\n\7\f\7\16\7S\13"+
		"\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0085\n\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\5\n\u008d\n\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\5"+
		"\f\u0096\n\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\17\3\17\5\17\u00a8\n\17\3\20\3\20\3\21\3\21\3\21\3\21\5\21\u00b0"+
		"\n\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23"+
		"\u00be\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u00c9\n"+
		"\23\f\23\16\23\u00cc\13\23\3\23\2\3$\24\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$\2\4\3\2\b\t\3\2\20\23\u00d8\2\'\3\2\2\2\4\63\3\2\2\2\6\65"+
		"\3\2\2\2\b>\3\2\2\2\nB\3\2\2\2\fG\3\2\2\2\16T\3\2\2\2\20\u0084\3\2\2\2"+
		"\22\u0086\3\2\2\2\24\u008e\3\2\2\2\26\u0091\3\2\2\2\30\u009a\3\2\2\2\32"+
		"\u00a0\3\2\2\2\34\u00a7\3\2\2\2\36\u00a9\3\2\2\2 \u00ab\3\2\2\2\"\u00b3"+
		"\3\2\2\2$\u00bd\3\2\2\2&(\5\4\3\2\'&\3\2\2\2()\3\2\2\2)\'\3\2\2\2)*\3"+
		"\2\2\2*\3\3\2\2\2+\64\5\b\5\2,\64\5\20\t\2-\64\5\22\n\2.\64\5\24\13\2"+
		"/\64\5\32\16\2\60\64\5\26\f\2\61\64\5\30\r\2\62\64\5\6\4\2\63+\3\2\2\2"+
		"\63,\3\2\2\2\63-\3\2\2\2\63.\3\2\2\2\63/\3\2\2\2\63\60\3\2\2\2\63\61\3"+
		"\2\2\2\63\62\3\2\2\2\64\5\3\2\2\2\659\7\26\2\2\668\5\4\3\2\67\66\3\2\2"+
		"\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3\2\2\2;9\3\2\2\2<=\7\27\2\2=\7\3"+
		"\2\2\2>?\5\n\6\2?@\5\f\7\2@A\7\33\2\2A\t\3\2\2\2BC\t\2\2\2C\13\3\2\2\2"+
		"DH\7\f\2\2EH\5\16\b\2FH\5 \21\2GD\3\2\2\2GE\3\2\2\2GF\3\2\2\2HQ\3\2\2"+
		"\2IM\7\34\2\2JN\7\f\2\2KN\5\16\b\2LN\5 \21\2MJ\3\2\2\2MK\3\2\2\2ML\3\2"+
		"\2\2NP\3\2\2\2OI\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2R\r\3\2\2\2SQ\3"+
		"\2\2\2TU\7\f\2\2UV\7\32\2\2VW\5$\23\2W\17\3\2\2\2XY\7\3\2\2YZ\7\24\2\2"+
		"Z[\5$\23\2[\\\7\25\2\2\\]\5\4\3\2]\u0085\3\2\2\2^_\7\3\2\2_`\7\24\2\2"+
		"`a\5$\23\2ab\7\25\2\2bc\5\6\4\2c\u0085\3\2\2\2de\7\3\2\2ef\7\24\2\2fg"+
		"\5$\23\2gh\7\25\2\2hi\5\4\3\2ij\7\4\2\2jk\5\4\3\2k\u0085\3\2\2\2lm\7\3"+
		"\2\2mn\7\24\2\2no\5$\23\2op\7\25\2\2pq\5\4\3\2qr\7\4\2\2rs\5\6\4\2s\u0085"+
		"\3\2\2\2tu\7\3\2\2uv\7\24\2\2vw\5$\23\2wx\7\25\2\2xy\5\6\4\2yz\7\4\2\2"+
		"z{\5\4\3\2{\u0085\3\2\2\2|}\7\3\2\2}~\7\24\2\2~\177\5$\23\2\177\u0080"+
		"\7\25\2\2\u0080\u0081\5\6\4\2\u0081\u0082\7\4\2\2\u0082\u0083\5\6\4\2"+
		"\u0083\u0085\3\2\2\2\u0084X\3\2\2\2\u0084^\3\2\2\2\u0084d\3\2\2\2\u0084"+
		"l\3\2\2\2\u0084t\3\2\2\2\u0084|\3\2\2\2\u0085\21\3\2\2\2\u0086\u0087\7"+
		"\5\2\2\u0087\u0088\7\24\2\2\u0088\u0089\5$\23\2\u0089\u008c\7\25\2\2\u008a"+
		"\u008d\5\4\3\2\u008b\u008d\5\6\4\2\u008c\u008a\3\2\2\2\u008c\u008b\3\2"+
		"\2\2\u008d\23\3\2\2\2\u008e\u008f\7\n\2\2\u008f\u0090\7\33\2\2\u0090\25"+
		"\3\2\2\2\u0091\u0092\7\6\2\2\u0092\u0095\7\24\2\2\u0093\u0096\7\f\2\2"+
		"\u0094\u0096\5 \21\2\u0095\u0093\3\2\2\2\u0095\u0094\3\2\2\2\u0096\u0097"+
		"\3\2\2\2\u0097\u0098\7\25\2\2\u0098\u0099\7\33\2\2\u0099\27\3\2\2\2\u009a"+
		"\u009b\7\7\2\2\u009b\u009c\7\24\2\2\u009c\u009d\5$\23\2\u009d\u009e\7"+
		"\25\2\2\u009e\u009f\7\33\2\2\u009f\31\3\2\2\2\u00a0\u00a1\5\34\17\2\u00a1"+
		"\u00a2\7\32\2\2\u00a2\u00a3\5$\23\2\u00a3\u00a4\7\33\2\2\u00a4\33\3\2"+
		"\2\2\u00a5\u00a8\7\f\2\2\u00a6\u00a8\5 \21\2\u00a7\u00a5\3\2\2\2\u00a7"+
		"\u00a6\3\2\2\2\u00a8\35\3\2\2\2\u00a9\u00aa\7\13\2\2\u00aa\37\3\2\2\2"+
		"\u00ab\u00ac\7\f\2\2\u00ac\u00af\7\30\2\2\u00ad\u00b0\7\20\2\2\u00ae\u00b0"+
		"\5$\23\2\u00af\u00ad\3\2\2\2\u00af\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1"+
		"\u00b2\7\31\2\2\u00b2!\3\2\2\2\u00b3\u00b4\t\3\2\2\u00b4#\3\2\2\2\u00b5"+
		"\u00b6\b\23\1\2\u00b6\u00b7\7\24\2\2\u00b7\u00b8\5$\23\2\u00b8\u00b9\7"+
		"\25\2\2\u00b9\u00be\3\2\2\2\u00ba\u00be\5\"\22\2\u00bb\u00be\5\34\17\2"+
		"\u00bc\u00be\5\36\20\2\u00bd\u00b5\3\2\2\2\u00bd\u00ba\3\2\2\2\u00bd\u00bb"+
		"\3\2\2\2\u00bd\u00bc\3\2\2\2\u00be\u00ca\3\2\2\2\u00bf\u00c0\f\t\2\2\u00c0"+
		"\u00c1\7\16\2\2\u00c1\u00c9\5$\23\n\u00c2\u00c3\f\b\2\2\u00c3\u00c4\7"+
		"\17\2\2\u00c4\u00c9\5$\23\t\u00c5\u00c6\f\7\2\2\u00c6\u00c7\7\r\2\2\u00c7"+
		"\u00c9\5$\23\b\u00c8\u00bf\3\2\2\2\u00c8\u00c2\3\2\2\2\u00c8\u00c5\3\2"+
		"\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb"+
		"%\3\2\2\2\u00cc\u00ca\3\2\2\2\20)\639GMQ\u0084\u008c\u0095\u00a7\u00af"+
		"\u00bd\u00c8\u00ca";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}