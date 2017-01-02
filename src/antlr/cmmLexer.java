// Generated from /Users/steveyyy/Programming/cmmInterpreter/src/antlr/cmm.g4 by ANTLR 4.6
package antlr;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class cmmLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		If=1, Else=2, While=3, Read=4, Write=5, Int=6, Real=7, Break=8, BooleanConstant=9, 
		Ident=10, IntConstant=11, RealConstant=12, CompOp=13, MulDivMod=14, AddMin=15, 
		LBracket=16, RBracket=17, LBigBracket=18, RBigBracket=19, LMidBracket=20, 
		RMidBracket=21, Assign=22, LineEnd=23, Comma=24, WS=25, SL_COMMENT=26, 
		MUL_COMMENT=27;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"If", "Else", "While", "Read", "Write", "Int", "Real", "Break", "BooleanConstant", 
		"Ident", "IntConstant", "RealConstant", "CompOp", "MulDivMod", "AddMin", 
		"LBracket", "RBracket", "LBigBracket", "RBigBracket", "LMidBracket", "RMidBracket", 
		"Assign", "LineEnd", "Comma", "WS", "SL_COMMENT", "MUL_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'else'", "'while'", "'read'", "'write'", "'int'", "'real'", 
		"'break'", null, null, null, null, null, null, null, "'('", "')'", "'{'", 
		"'}'", "'['", "']'", "'='", "';'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "If", "Else", "While", "Read", "Write", "Int", "Real", "Break", 
		"BooleanConstant", "Ident", "IntConstant", "RealConstant", "CompOp", "MulDivMod", 
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


	public cmmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "cmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\35\u00c9\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\5\nk\n\n\3\13\3\13\7\13o\n\13\f\13\16\13r\13\13"+
		"\3\f\3\f\3\f\7\fw\n\f\f\f\16\fz\13\f\5\f|\n\f\3\r\3\r\3\r\6\r\u0081\n"+
		"\r\r\r\16\r\u0082\5\r\u0085\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\5\16\u0092\n\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31"+
		"\3\32\6\32\u00ab\n\32\r\32\16\32\u00ac\3\32\3\32\3\33\3\33\3\33\3\33\7"+
		"\33\u00b5\n\33\f\33\16\33\u00b8\13\33\3\33\3\33\3\34\3\34\3\34\3\34\7"+
		"\34\u00c0\n\34\f\34\16\34\u00c3\13\34\3\34\3\34\3\34\3\34\3\34\3\u00c1"+
		"\2\35\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\35\3\2"+
		"\13\4\2C\\c|\6\2\62;C\\aac|\3\2\63;\3\2\62;\4\2>>@@\5\2\'\',,\61\61\4"+
		"\2--//\6\2\13\f\17\17\"\"))\4\2\f\f\17\17\u00d6\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\39\3\2\2\2\5<\3\2\2\2\7A\3\2\2\2\tG\3"+
		"\2\2\2\13L\3\2\2\2\rR\3\2\2\2\17V\3\2\2\2\21[\3\2\2\2\23j\3\2\2\2\25l"+
		"\3\2\2\2\27{\3\2\2\2\31}\3\2\2\2\33\u0091\3\2\2\2\35\u0093\3\2\2\2\37"+
		"\u0095\3\2\2\2!\u0097\3\2\2\2#\u0099\3\2\2\2%\u009b\3\2\2\2\'\u009d\3"+
		"\2\2\2)\u009f\3\2\2\2+\u00a1\3\2\2\2-\u00a3\3\2\2\2/\u00a5\3\2\2\2\61"+
		"\u00a7\3\2\2\2\63\u00aa\3\2\2\2\65\u00b0\3\2\2\2\67\u00bb\3\2\2\29:\7"+
		"k\2\2:;\7h\2\2;\4\3\2\2\2<=\7g\2\2=>\7n\2\2>?\7u\2\2?@\7g\2\2@\6\3\2\2"+
		"\2AB\7y\2\2BC\7j\2\2CD\7k\2\2DE\7n\2\2EF\7g\2\2F\b\3\2\2\2GH\7t\2\2HI"+
		"\7g\2\2IJ\7c\2\2JK\7f\2\2K\n\3\2\2\2LM\7y\2\2MN\7t\2\2NO\7k\2\2OP\7v\2"+
		"\2PQ\7g\2\2Q\f\3\2\2\2RS\7k\2\2ST\7p\2\2TU\7v\2\2U\16\3\2\2\2VW\7t\2\2"+
		"WX\7g\2\2XY\7c\2\2YZ\7n\2\2Z\20\3\2\2\2[\\\7d\2\2\\]\7t\2\2]^\7g\2\2^"+
		"_\7c\2\2_`\7m\2\2`\22\3\2\2\2ab\7v\2\2bc\7t\2\2cd\7w\2\2dk\7g\2\2ef\7"+
		"h\2\2fg\7c\2\2gh\7n\2\2hi\7u\2\2ik\7g\2\2ja\3\2\2\2je\3\2\2\2k\24\3\2"+
		"\2\2lp\t\2\2\2mo\t\3\2\2nm\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2q\26\3"+
		"\2\2\2rp\3\2\2\2s|\7\62\2\2tx\t\4\2\2uw\t\5\2\2vu\3\2\2\2wz\3\2\2\2xv"+
		"\3\2\2\2xy\3\2\2\2y|\3\2\2\2zx\3\2\2\2{s\3\2\2\2{t\3\2\2\2|\30\3\2\2\2"+
		"}~\5\27\f\2~\u0084\7\60\2\2\177\u0081\t\5\2\2\u0080\177\3\2\2\2\u0081"+
		"\u0082\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0085\3\2"+
		"\2\2\u0084\u0080\3\2\2\2\u0084\u0085\3\2\2\2\u0085\32\3\2\2\2\u0086\u0087"+
		"\7>\2\2\u0087\u0092\7?\2\2\u0088\u0089\7@\2\2\u0089\u0092\7?\2\2\u008a"+
		"\u0092\t\6\2\2\u008b\u008c\7#\2\2\u008c\u0092\7?\2\2\u008d\u008e\7?\2"+
		"\2\u008e\u0092\7?\2\2\u008f\u0090\7>\2\2\u0090\u0092\7@\2\2\u0091\u0086"+
		"\3\2\2\2\u0091\u0088\3\2\2\2\u0091\u008a\3\2\2\2\u0091\u008b\3\2\2\2\u0091"+
		"\u008d\3\2\2\2\u0091\u008f\3\2\2\2\u0092\34\3\2\2\2\u0093\u0094\t\7\2"+
		"\2\u0094\36\3\2\2\2\u0095\u0096\t\b\2\2\u0096 \3\2\2\2\u0097\u0098\7*"+
		"\2\2\u0098\"\3\2\2\2\u0099\u009a\7+\2\2\u009a$\3\2\2\2\u009b\u009c\7}"+
		"\2\2\u009c&\3\2\2\2\u009d\u009e\7\177\2\2\u009e(\3\2\2\2\u009f\u00a0\7"+
		"]\2\2\u00a0*\3\2\2\2\u00a1\u00a2\7_\2\2\u00a2,\3\2\2\2\u00a3\u00a4\7?"+
		"\2\2\u00a4.\3\2\2\2\u00a5\u00a6\7=\2\2\u00a6\60\3\2\2\2\u00a7\u00a8\7"+
		".\2\2\u00a8\62\3\2\2\2\u00a9\u00ab\t\t\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ac"+
		"\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae"+
		"\u00af\b\32\2\2\u00af\64\3\2\2\2\u00b0\u00b1\7\61\2\2\u00b1\u00b2\7\61"+
		"\2\2\u00b2\u00b6\3\2\2\2\u00b3\u00b5\n\n\2\2\u00b4\u00b3\3\2\2\2\u00b5"+
		"\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\3\2"+
		"\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\b\33\2\2\u00ba\66\3\2\2\2\u00bb\u00bc"+
		"\7\61\2\2\u00bc\u00bd\7,\2\2\u00bd\u00c1\3\2\2\2\u00be\u00c0\13\2\2\2"+
		"\u00bf\u00be\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c1\u00bf"+
		"\3\2\2\2\u00c2\u00c4\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00c5\7,\2\2\u00c5"+
		"\u00c6\7\61\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\b\34\2\2\u00c88\3\2\2"+
		"\2\16\2jnpx{\u0082\u0084\u0091\u00ac\u00b6\u00c1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}