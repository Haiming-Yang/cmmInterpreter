// Generated from /Users/steveyyy/Programming/cmmInterpreter/src/antlr/cmmLexer.g4 by ANTLR 4.6
package antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class cmmLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"If", "Else", "While", "Read", "Write", "Int", "Double", "Break", "BooleanConstant", 
		"Ident", "CompOp", "MulDivMod", "AddMin", "IntConstant", "DoubleConstant", 
		"HexIntConstant", "HexDoubleConstant", "LBracket", "RBracket", "LBigBracket", 
		"RBigBracket", "LMidBracket", "RMidBracket", "Assign", "LineEnd", "Comma", 
		"WS", "SL_COMMENT", "MUL_COMMENT"
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


	public cmmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "cmmLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\37\u00fb\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nq\n\n\3\13\3\13"+
		"\3\13\7\13v\n\13\f\13\16\13y\13\13\3\13\5\13|\n\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0089\n\f\3\r\3\r\3\16\3\16\3\17\3\17\7\17"+
		"\u0091\n\17\f\17\16\17\u0094\13\17\3\17\3\17\3\17\3\17\7\17\u009a\n\17"+
		"\f\17\16\17\u009d\13\17\5\17\u009f\n\17\3\20\3\20\3\20\5\20\u00a4\n\20"+
		"\3\20\3\20\6\20\u00a8\n\20\r\20\16\20\u00a9\5\20\u00ac\n\20\3\21\3\21"+
		"\3\21\3\21\5\21\u00b2\n\21\3\21\6\21\u00b5\n\21\r\21\16\21\u00b6\3\22"+
		"\3\22\3\22\3\22\5\22\u00bd\n\22\3\22\6\22\u00c0\n\22\r\22\16\22\u00c1"+
		"\3\22\3\22\6\22\u00c6\n\22\r\22\16\22\u00c7\3\23\3\23\3\24\3\24\3\25\3"+
		"\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\6"+
		"\34\u00dd\n\34\r\34\16\34\u00de\3\34\3\34\3\35\3\35\3\35\3\35\7\35\u00e7"+
		"\n\35\f\35\16\35\u00ea\13\35\3\35\3\35\3\36\3\36\3\36\3\36\7\36\u00f2"+
		"\n\36\f\36\16\36\u00f5\13\36\3\36\3\36\3\36\3\36\3\36\3\u00f3\2\37\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37\3\2"+
		"\r\4\2C\\c|\5\2C\\aac|\6\2\62;C\\aac|\5\2\62;C\\c|\4\2>>@@\4\2,,\61\61"+
		"\4\2--//\3\2\62;\5\2\62;CHch\6\2\13\f\17\17\"\"))\4\2\f\f\17\17\u0111"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\3=\3\2\2\2\5@\3\2\2\2\7E\3\2\2\2\tK\3\2\2\2\13P\3\2\2\2\rV\3\2"+
		"\2\2\17Z\3\2\2\2\21a\3\2\2\2\23p\3\2\2\2\25{\3\2\2\2\27\u0088\3\2\2\2"+
		"\31\u008a\3\2\2\2\33\u008c\3\2\2\2\35\u009e\3\2\2\2\37\u00a3\3\2\2\2!"+
		"\u00b1\3\2\2\2#\u00bc\3\2\2\2%\u00c9\3\2\2\2\'\u00cb\3\2\2\2)\u00cd\3"+
		"\2\2\2+\u00cf\3\2\2\2-\u00d1\3\2\2\2/\u00d3\3\2\2\2\61\u00d5\3\2\2\2\63"+
		"\u00d7\3\2\2\2\65\u00d9\3\2\2\2\67\u00dc\3\2\2\29\u00e2\3\2\2\2;\u00ed"+
		"\3\2\2\2=>\7k\2\2>?\7h\2\2?\4\3\2\2\2@A\7g\2\2AB\7n\2\2BC\7u\2\2CD\7g"+
		"\2\2D\6\3\2\2\2EF\7y\2\2FG\7j\2\2GH\7k\2\2HI\7n\2\2IJ\7g\2\2J\b\3\2\2"+
		"\2KL\7t\2\2LM\7g\2\2MN\7c\2\2NO\7f\2\2O\n\3\2\2\2PQ\7y\2\2QR\7t\2\2RS"+
		"\7k\2\2ST\7v\2\2TU\7g\2\2U\f\3\2\2\2VW\7k\2\2WX\7p\2\2XY\7v\2\2Y\16\3"+
		"\2\2\2Z[\7f\2\2[\\\7q\2\2\\]\7w\2\2]^\7d\2\2^_\7n\2\2_`\7g\2\2`\20\3\2"+
		"\2\2ab\7d\2\2bc\7t\2\2cd\7g\2\2de\7c\2\2ef\7m\2\2f\22\3\2\2\2gh\7v\2\2"+
		"hi\7t\2\2ij\7w\2\2jq\7g\2\2kl\7h\2\2lm\7c\2\2mn\7n\2\2no\7u\2\2oq\7g\2"+
		"\2pg\3\2\2\2pk\3\2\2\2q\24\3\2\2\2r|\t\2\2\2sw\t\3\2\2tv\t\4\2\2ut\3\2"+
		"\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2xz\3\2\2\2yw\3\2\2\2z|\t\5\2\2{r\3\2"+
		"\2\2{s\3\2\2\2|\26\3\2\2\2}~\7>\2\2~\u0089\7?\2\2\177\u0080\7@\2\2\u0080"+
		"\u0089\7?\2\2\u0081\u0089\t\6\2\2\u0082\u0083\7#\2\2\u0083\u0089\7?\2"+
		"\2\u0084\u0085\7?\2\2\u0085\u0089\7?\2\2\u0086\u0087\7>\2\2\u0087\u0089"+
		"\7@\2\2\u0088}\3\2\2\2\u0088\177\3\2\2\2\u0088\u0081\3\2\2\2\u0088\u0082"+
		"\3\2\2\2\u0088\u0084\3\2\2\2\u0088\u0086\3\2\2\2\u0089\30\3\2\2\2\u008a"+
		"\u008b\t\7\2\2\u008b\32\3\2\2\2\u008c\u008d\t\b\2\2\u008d\34\3\2\2\2\u008e"+
		"\u0092\4\63;\2\u008f\u0091\4\62;\2\u0090\u008f\3\2\2\2\u0091\u0094\3\2"+
		"\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u009f\3\2\2\2\u0094"+
		"\u0092\3\2\2\2\u0095\u009f\7\62\2\2\u0096\u0097\7/\2\2\u0097\u009b\4\63"+
		";\2\u0098\u009a\4\62;\2\u0099\u0098\3\2\2\2\u009a\u009d\3\2\2\2\u009b"+
		"\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2"+
		"\2\2\u009e\u008e\3\2\2\2\u009e\u0095\3\2\2\2\u009e\u0096\3\2\2\2\u009f"+
		"\36\3\2\2\2\u00a0\u00a4\5\35\17\2\u00a1\u00a2\7/\2\2\u00a2\u00a4\7\62"+
		"\2\2\u00a3\u00a0\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"\u00ab\7\60\2\2\u00a6\u00a8\t\t\2\2\u00a7\u00a6\3\2\2\2\u00a8\u00a9\3"+
		"\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab"+
		"\u00a7\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac \3\2\2\2\u00ad\u00ae\7\62\2\2"+
		"\u00ae\u00b2\7z\2\2\u00af\u00b0\7\62\2\2\u00b0\u00b2\7Z\2\2\u00b1\u00ad"+
		"\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b4\3\2\2\2\u00b3\u00b5\t\n\2\2\u00b4"+
		"\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2"+
		"\2\2\u00b7\"\3\2\2\2\u00b8\u00b9\7\62\2\2\u00b9\u00bd\7z\2\2\u00ba\u00bb"+
		"\7\62\2\2\u00bb\u00bd\7Z\2\2\u00bc\u00b8\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd"+
		"\u00bf\3\2\2\2\u00be\u00c0\t\n\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c1\3\2"+
		"\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3"+
		"\u00c5\7\60\2\2\u00c4\u00c6\t\n\2\2\u00c5\u00c4\3\2\2\2\u00c6\u00c7\3"+
		"\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8$\3\2\2\2\u00c9\u00ca"+
		"\7*\2\2\u00ca&\3\2\2\2\u00cb\u00cc\7+\2\2\u00cc(\3\2\2\2\u00cd\u00ce\7"+
		"}\2\2\u00ce*\3\2\2\2\u00cf\u00d0\7\177\2\2\u00d0,\3\2\2\2\u00d1\u00d2"+
		"\7]\2\2\u00d2.\3\2\2\2\u00d3\u00d4\7_\2\2\u00d4\60\3\2\2\2\u00d5\u00d6"+
		"\7?\2\2\u00d6\62\3\2\2\2\u00d7\u00d8\7=\2\2\u00d8\64\3\2\2\2\u00d9\u00da"+
		"\7.\2\2\u00da\66\3\2\2\2\u00db\u00dd\t\13\2\2\u00dc\u00db\3\2\2\2\u00dd"+
		"\u00de\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\3\2"+
		"\2\2\u00e0\u00e1\b\34\2\2\u00e18\3\2\2\2\u00e2\u00e3\7\61\2\2\u00e3\u00e4"+
		"\7\61\2\2\u00e4\u00e8\3\2\2\2\u00e5\u00e7\n\f\2\2\u00e6\u00e5\3\2\2\2"+
		"\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00eb"+
		"\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00ec\b\35\2\2\u00ec:\3\2\2\2\u00ed"+
		"\u00ee\7\61\2\2\u00ee\u00ef\7,\2\2\u00ef\u00f3\3\2\2\2\u00f0\u00f2\13"+
		"\2\2\2\u00f1\u00f0\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f3"+
		"\u00f1\3\2\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6\u00f7\7,"+
		"\2\2\u00f7\u00f8\7\61\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\b\36\2\2\u00fa"+
		"<\3\2\2\2\30\2pw{\u0088\u0092\u009b\u009e\u00a3\u00a9\u00ab\u00b1\u00b4"+
		"\u00b6\u00bc\u00bf\u00c1\u00c5\u00c7\u00de\u00e8\u00f3\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}