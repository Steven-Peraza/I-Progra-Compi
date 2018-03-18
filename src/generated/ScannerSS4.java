// Generated from C:/Users/Steven/Progra Compi/I-Progra-Compi\ScannerSS4.g4 by ANTLR 4.7
package generated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ScannerSS4 extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PyCOMA=1, COMA=2, ASSIGN=3, PIZQ=4, PDER=5, DPTS=6, RDC=7, SUM=8, SUB=9, 
		MUL=10, DIV=11, MAYOR=12, MENOR=13, MAYOREQ=14, MENOREQ=15, EQU=16, PCI=17, 
		PCD=18, LLIZQ=19, LLDER=20, DOBSLA=21, INICOME=22, FINCOME=23, IF=24, 
		LET=25, ELSE=26, TRUE=27, FALSE=28, LEN=29, FIRST=30, LAST=31, REST=32, 
		PUSH=33, FUN=34, PUTS=35, ID=36, NUM=37, RETURN=38, STRING=39, BOOL=40, 
		CHAR=41, WS=42;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"PyCOMA", "COMA", "ASSIGN", "PIZQ", "PDER", "DPTS", "RDC", "SUM", "SUB", 
		"MUL", "DIV", "MAYOR", "MENOR", "MAYOREQ", "MENOREQ", "EQU", "PCI", "PCD", 
		"LLIZQ", "LLDER", "DOBSLA", "INICOME", "FINCOME", "IF", "LET", "ELSE", 
		"TRUE", "FALSE", "LEN", "FIRST", "LAST", "REST", "PUSH", "FUN", "PUTS", 
		"ID", "NUM", "RETURN", "STRING", "BOOL", "CHAR", "LETTER", "DIGIT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "','", "'='", "'('", "')'", "':'", "'~'", "'+'", "'-'", "'*'", 
		"'/'", "'>'", "'<'", "'>='", "'<='", "'=='", "'['", "']'", "'{'", "'}'", 
		"'//'", "'/*'", "'*/'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PyCOMA", "COMA", "ASSIGN", "PIZQ", "PDER", "DPTS", "RDC", "SUM", 
		"SUB", "MUL", "DIV", "MAYOR", "MENOR", "MAYOREQ", "MENOREQ", "EQU", "PCI", 
		"PCD", "LLIZQ", "LLDER", "DOBSLA", "INICOME", "FINCOME", "IF", "LET", 
		"ELSE", "TRUE", "FALSE", "LEN", "FIRST", "LAST", "REST", "PUSH", "FUN", 
		"PUTS", "ID", "NUM", "RETURN", "STRING", "BOOL", "CHAR", "WS"
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


	public ScannerSS4(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ScannerSS4.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2,\u013a\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3"+
		"\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\5\31\u0094"+
		"\n\31\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u009c\n\32\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\5\33\u00a6\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\5\34\u00b0\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\5\35\u00bc\n\35\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u00c4\n\36\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u00d0\n\37\3 \3 \3 \3"+
		" \3 \3 \3 \3 \5 \u00da\n \3!\3!\3!\3!\3!\3!\3!\3!\5!\u00e4\n!\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u00ee\n\"\3#\3#\3#\3#\3#\3#\5#\u00f6\n#\3"+
		"$\3$\3$\3$\3$\3$\3$\3$\5$\u0100\n$\3%\3%\3%\7%\u0105\n%\f%\16%\u0108\13"+
		"%\3&\3&\7&\u010c\n&\f&\16&\u010f\13&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\5\'\u011d\n\'\3(\3(\7(\u0121\n(\f(\16(\u0124\13(\3(\3("+
		"\3)\3)\5)\u012a\n)\3*\3*\5*\u012e\n*\3+\3+\3,\3,\3-\6-\u0135\n-\r-\16"+
		"-\u0136\3-\3-\3\u0122\2.\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U\2W\2Y,\3\2\4\5\2C\\"+
		"aac|\5\2\13\f\17\17\"\"\2\u014b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2Y\3\2\2\2\3[\3\2\2\2\5]\3\2\2\2\7_\3\2"+
		"\2\2\ta\3\2\2\2\13c\3\2\2\2\re\3\2\2\2\17g\3\2\2\2\21i\3\2\2\2\23k\3\2"+
		"\2\2\25m\3\2\2\2\27o\3\2\2\2\31q\3\2\2\2\33s\3\2\2\2\35u\3\2\2\2\37x\3"+
		"\2\2\2!{\3\2\2\2#~\3\2\2\2%\u0080\3\2\2\2\'\u0082\3\2\2\2)\u0084\3\2\2"+
		"\2+\u0086\3\2\2\2-\u0089\3\2\2\2/\u008c\3\2\2\2\61\u0093\3\2\2\2\63\u009b"+
		"\3\2\2\2\65\u00a5\3\2\2\2\67\u00af\3\2\2\29\u00bb\3\2\2\2;\u00c3\3\2\2"+
		"\2=\u00cf\3\2\2\2?\u00d9\3\2\2\2A\u00e3\3\2\2\2C\u00ed\3\2\2\2E\u00f5"+
		"\3\2\2\2G\u00ff\3\2\2\2I\u0101\3\2\2\2K\u0109\3\2\2\2M\u011c\3\2\2\2O"+
		"\u011e\3\2\2\2Q\u0129\3\2\2\2S\u012d\3\2\2\2U\u012f\3\2\2\2W\u0131\3\2"+
		"\2\2Y\u0134\3\2\2\2[\\\7=\2\2\\\4\3\2\2\2]^\7.\2\2^\6\3\2\2\2_`\7?\2\2"+
		"`\b\3\2\2\2ab\7*\2\2b\n\3\2\2\2cd\7+\2\2d\f\3\2\2\2ef\7<\2\2f\16\3\2\2"+
		"\2gh\7\u0080\2\2h\20\3\2\2\2ij\7-\2\2j\22\3\2\2\2kl\7/\2\2l\24\3\2\2\2"+
		"mn\7,\2\2n\26\3\2\2\2op\7\61\2\2p\30\3\2\2\2qr\7@\2\2r\32\3\2\2\2st\7"+
		">\2\2t\34\3\2\2\2uv\7@\2\2vw\7?\2\2w\36\3\2\2\2xy\7>\2\2yz\7?\2\2z \3"+
		"\2\2\2{|\7?\2\2|}\7?\2\2}\"\3\2\2\2~\177\7]\2\2\177$\3\2\2\2\u0080\u0081"+
		"\7_\2\2\u0081&\3\2\2\2\u0082\u0083\7}\2\2\u0083(\3\2\2\2\u0084\u0085\7"+
		"\177\2\2\u0085*\3\2\2\2\u0086\u0087\7\61\2\2\u0087\u0088\7\61\2\2\u0088"+
		",\3\2\2\2\u0089\u008a\7\61\2\2\u008a\u008b\7,\2\2\u008b.\3\2\2\2\u008c"+
		"\u008d\7,\2\2\u008d\u008e\7\61\2\2\u008e\60\3\2\2\2\u008f\u0090\7k\2\2"+
		"\u0090\u0094\7h\2\2\u0091\u0092\7K\2\2\u0092\u0094\7H\2\2\u0093\u008f"+
		"\3\2\2\2\u0093\u0091\3\2\2\2\u0094\62\3\2\2\2\u0095\u0096\7n\2\2\u0096"+
		"\u0097\7g\2\2\u0097\u009c\7v\2\2\u0098\u0099\7N\2\2\u0099\u009a\7G\2\2"+
		"\u009a\u009c\7V\2\2\u009b\u0095\3\2\2\2\u009b\u0098\3\2\2\2\u009c\64\3"+
		"\2\2\2\u009d\u009e\7g\2\2\u009e\u009f\7n\2\2\u009f\u00a0\7u\2\2\u00a0"+
		"\u00a6\7g\2\2\u00a1\u00a2\7G\2\2\u00a2\u00a3\7N\2\2\u00a3\u00a4\7U\2\2"+
		"\u00a4\u00a6\7G\2\2\u00a5\u009d\3\2\2\2\u00a5\u00a1\3\2\2\2\u00a6\66\3"+
		"\2\2\2\u00a7\u00a8\7v\2\2\u00a8\u00a9\7t\2\2\u00a9\u00aa\7w\2\2\u00aa"+
		"\u00b0\7g\2\2\u00ab\u00ac\7V\2\2\u00ac\u00ad\7T\2\2\u00ad\u00ae\7W\2\2"+
		"\u00ae\u00b0\7G\2\2\u00af\u00a7\3\2\2\2\u00af\u00ab\3\2\2\2\u00b08\3\2"+
		"\2\2\u00b1\u00b2\7h\2\2\u00b2\u00b3\7c\2\2\u00b3\u00b4\7n\2\2\u00b4\u00b5"+
		"\7u\2\2\u00b5\u00bc\7g\2\2\u00b6\u00b7\7H\2\2\u00b7\u00b8\7C\2\2\u00b8"+
		"\u00b9\7N\2\2\u00b9\u00ba\7U\2\2\u00ba\u00bc\7G\2\2\u00bb\u00b1\3\2\2"+
		"\2\u00bb\u00b6\3\2\2\2\u00bc:\3\2\2\2\u00bd\u00be\7n\2\2\u00be\u00bf\7"+
		"g\2\2\u00bf\u00c4\7p\2\2\u00c0\u00c1\7N\2\2\u00c1\u00c2\7G\2\2\u00c2\u00c4"+
		"\7P\2\2\u00c3\u00bd\3\2\2\2\u00c3\u00c0\3\2\2\2\u00c4<\3\2\2\2\u00c5\u00c6"+
		"\7h\2\2\u00c6\u00c7\7k\2\2\u00c7\u00c8\7t\2\2\u00c8\u00c9\7u\2\2\u00c9"+
		"\u00d0\7v\2\2\u00ca\u00cb\7H\2\2\u00cb\u00cc\7K\2\2\u00cc\u00cd\7T\2\2"+
		"\u00cd\u00ce\7U\2\2\u00ce\u00d0\7V\2\2\u00cf\u00c5\3\2\2\2\u00cf\u00ca"+
		"\3\2\2\2\u00d0>\3\2\2\2\u00d1\u00d2\7n\2\2\u00d2\u00d3\7c\2\2\u00d3\u00d4"+
		"\7u\2\2\u00d4\u00da\7v\2\2\u00d5\u00d6\7N\2\2\u00d6\u00d7\7C\2\2\u00d7"+
		"\u00d8\7U\2\2\u00d8\u00da\7V\2\2\u00d9\u00d1\3\2\2\2\u00d9\u00d5\3\2\2"+
		"\2\u00da@\3\2\2\2\u00db\u00dc\7t\2\2\u00dc\u00dd\7g\2\2\u00dd\u00de\7"+
		"u\2\2\u00de\u00e4\7v\2\2\u00df\u00e0\7T\2\2\u00e0\u00e1\7G\2\2\u00e1\u00e2"+
		"\7U\2\2\u00e2\u00e4\7V\2\2\u00e3\u00db\3\2\2\2\u00e3\u00df\3\2\2\2\u00e4"+
		"B\3\2\2\2\u00e5\u00e6\7r\2\2\u00e6\u00e7\7w\2\2\u00e7\u00e8\7u\2\2\u00e8"+
		"\u00ee\7j\2\2\u00e9\u00ea\7R\2\2\u00ea\u00eb\7W\2\2\u00eb\u00ec\7U\2\2"+
		"\u00ec\u00ee\7J\2\2\u00ed\u00e5\3\2\2\2\u00ed\u00e9\3\2\2\2\u00eeD\3\2"+
		"\2\2\u00ef\u00f0\7h\2\2\u00f0\u00f1\7w\2\2\u00f1\u00f6\7p\2\2\u00f2\u00f3"+
		"\7H\2\2\u00f3\u00f4\7W\2\2\u00f4\u00f6\7P\2\2\u00f5\u00ef\3\2\2\2\u00f5"+
		"\u00f2\3\2\2\2\u00f6F\3\2\2\2\u00f7\u00f8\7r\2\2\u00f8\u00f9\7w\2\2\u00f9"+
		"\u00fa\7v\2\2\u00fa\u0100\7u\2\2\u00fb\u00fc\7R\2\2\u00fc\u00fd\7W\2\2"+
		"\u00fd\u00fe\7V\2\2\u00fe\u0100\7U\2\2\u00ff\u00f7\3\2\2\2\u00ff\u00fb"+
		"\3\2\2\2\u0100H\3\2\2\2\u0101\u0106\5U+\2\u0102\u0105\5U+\2\u0103\u0105"+
		"\5W,\2\u0104\u0102\3\2\2\2\u0104\u0103\3\2\2\2\u0105\u0108\3\2\2\2\u0106"+
		"\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107J\3\2\2\2\u0108\u0106\3\2\2\2"+
		"\u0109\u010d\5W,\2\u010a\u010c\5W,\2\u010b\u010a\3\2\2\2\u010c\u010f\3"+
		"\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010eL\3\2\2\2\u010f\u010d"+
		"\3\2\2\2\u0110\u0111\7t\2\2\u0111\u0112\7g\2\2\u0112\u0113\7v\2\2\u0113"+
		"\u0114\7w\2\2\u0114\u0115\7t\2\2\u0115\u011d\7p\2\2\u0116\u0117\7T\2\2"+
		"\u0117\u0118\7G\2\2\u0118\u0119\7V\2\2\u0119\u011a\7W\2\2\u011a\u011b"+
		"\7T\2\2\u011b\u011d\7P\2\2\u011c\u0110\3\2\2\2\u011c\u0116\3\2\2\2\u011d"+
		"N\3\2\2\2\u011e\u0122\7$\2\2\u011f\u0121\5S*\2\u0120\u011f\3\2\2\2\u0121"+
		"\u0124\3\2\2\2\u0122\u0123\3\2\2\2\u0122\u0120\3\2\2\2\u0123\u0125\3\2"+
		"\2\2\u0124\u0122\3\2\2\2\u0125\u0126\7$\2\2\u0126P\3\2\2\2\u0127\u012a"+
		"\5\67\34\2\u0128\u012a\59\35\2\u0129\u0127\3\2\2\2\u0129\u0128\3\2\2\2"+
		"\u012aR\3\2\2\2\u012b\u012e\5U+\2\u012c\u012e\5W,\2\u012d\u012b\3\2\2"+
		"\2\u012d\u012c\3\2\2\2\u012eT\3\2\2\2\u012f\u0130\t\2\2\2\u0130V\3\2\2"+
		"\2\u0131\u0132\4\62;\2\u0132X\3\2\2\2\u0133\u0135\t\3\2\2\u0134\u0133"+
		"\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137"+
		"\u0138\3\2\2\2\u0138\u0139\b-\2\2\u0139Z\3\2\2\2\27\2\u0093\u009b\u00a5"+
		"\u00af\u00bb\u00c3\u00cf\u00d9\u00e3\u00ed\u00f5\u00ff\u0104\u0106\u010d"+
		"\u011c\u0122\u0129\u012d\u0136\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}