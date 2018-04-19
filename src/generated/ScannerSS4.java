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
		CHAR=41, CARAC=42, COMMENT=43, LINE_COMMENT=44, WS=45;
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
		"ID", "NUM", "RETURN", "STRING", "BOOL", "CHAR", "CARAC", "COMMENT", "LINE_COMMENT", 
		"LETTER", "DIGIT", "WS"
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
		"PUTS", "ID", "NUM", "RETURN", "STRING", "BOOL", "CHAR", "CARAC", "COMMENT", 
		"LINE_COMMENT", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2/\u015e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3"+
		"\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\31\5\31\u009a\n\31\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u00a2\n"+
		"\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u00ac\n\33\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u00b6\n\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\5\35\u00c2\n\35\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\5\36\u00ca\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37"+
		"\u00d6\n\37\3 \3 \3 \3 \3 \3 \3 \3 \5 \u00e0\n \3!\3!\3!\3!\3!\3!\3!\3"+
		"!\5!\u00ea\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u00f4\n\"\3#\3#\3#\3"+
		"#\3#\3#\5#\u00fc\n#\3$\3$\3$\3$\3$\3$\3$\3$\5$\u0106\n$\3%\3%\3%\7%\u010b"+
		"\n%\f%\16%\u010e\13%\3&\3&\7&\u0112\n&\f&\16&\u0115\13&\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u0123\n\'\3(\3(\7(\u0127\n(\f("+
		"\16(\u012a\13(\3(\3(\3)\3)\5)\u0130\n)\3*\3*\3*\5*\u0135\n*\3*\3*\3+\3"+
		"+\5+\u013b\n+\3,\3,\3,\7,\u0140\n,\f,\16,\u0143\13,\3,\3,\3,\3,\3-\3-"+
		"\7-\u014b\n-\f-\16-\u014e\13-\3-\3-\3-\3-\3.\3.\3/\3/\3\60\6\60\u0159"+
		"\n\60\r\60\16\60\u015a\3\60\3\60\5\u0128\u0141\u014c\2\61\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S+U,W-Y.[\2]\2_/\3\2\4\5\2C\\aac|\5\2\13\f\17\17\"\"\2\u0173"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2_\3\2\2\2\3a\3\2\2\2\5c\3\2\2\2\7e\3"+
		"\2\2\2\tg\3\2\2\2\13i\3\2\2\2\rk\3\2\2\2\17m\3\2\2\2\21o\3\2\2\2\23q\3"+
		"\2\2\2\25s\3\2\2\2\27u\3\2\2\2\31w\3\2\2\2\33y\3\2\2\2\35{\3\2\2\2\37"+
		"~\3\2\2\2!\u0081\3\2\2\2#\u0084\3\2\2\2%\u0086\3\2\2\2\'\u0088\3\2\2\2"+
		")\u008a\3\2\2\2+\u008c\3\2\2\2-\u008f\3\2\2\2/\u0092\3\2\2\2\61\u0099"+
		"\3\2\2\2\63\u00a1\3\2\2\2\65\u00ab\3\2\2\2\67\u00b5\3\2\2\29\u00c1\3\2"+
		"\2\2;\u00c9\3\2\2\2=\u00d5\3\2\2\2?\u00df\3\2\2\2A\u00e9\3\2\2\2C\u00f3"+
		"\3\2\2\2E\u00fb\3\2\2\2G\u0105\3\2\2\2I\u0107\3\2\2\2K\u010f\3\2\2\2M"+
		"\u0122\3\2\2\2O\u0124\3\2\2\2Q\u012f\3\2\2\2S\u0131\3\2\2\2U\u013a\3\2"+
		"\2\2W\u013c\3\2\2\2Y\u0148\3\2\2\2[\u0153\3\2\2\2]\u0155\3\2\2\2_\u0158"+
		"\3\2\2\2ab\7=\2\2b\4\3\2\2\2cd\7.\2\2d\6\3\2\2\2ef\7?\2\2f\b\3\2\2\2g"+
		"h\7*\2\2h\n\3\2\2\2ij\7+\2\2j\f\3\2\2\2kl\7<\2\2l\16\3\2\2\2mn\7\u0080"+
		"\2\2n\20\3\2\2\2op\7-\2\2p\22\3\2\2\2qr\7/\2\2r\24\3\2\2\2st\7,\2\2t\26"+
		"\3\2\2\2uv\7\61\2\2v\30\3\2\2\2wx\7@\2\2x\32\3\2\2\2yz\7>\2\2z\34\3\2"+
		"\2\2{|\7@\2\2|}\7?\2\2}\36\3\2\2\2~\177\7>\2\2\177\u0080\7?\2\2\u0080"+
		" \3\2\2\2\u0081\u0082\7?\2\2\u0082\u0083\7?\2\2\u0083\"\3\2\2\2\u0084"+
		"\u0085\7]\2\2\u0085$\3\2\2\2\u0086\u0087\7_\2\2\u0087&\3\2\2\2\u0088\u0089"+
		"\7}\2\2\u0089(\3\2\2\2\u008a\u008b\7\177\2\2\u008b*\3\2\2\2\u008c\u008d"+
		"\7\61\2\2\u008d\u008e\7\61\2\2\u008e,\3\2\2\2\u008f\u0090\7\61\2\2\u0090"+
		"\u0091\7,\2\2\u0091.\3\2\2\2\u0092\u0093\7,\2\2\u0093\u0094\7\61\2\2\u0094"+
		"\60\3\2\2\2\u0095\u0096\7k\2\2\u0096\u009a\7h\2\2\u0097\u0098\7K\2\2\u0098"+
		"\u009a\7H\2\2\u0099\u0095\3\2\2\2\u0099\u0097\3\2\2\2\u009a\62\3\2\2\2"+
		"\u009b\u009c\7n\2\2\u009c\u009d\7g\2\2\u009d\u00a2\7v\2\2\u009e\u009f"+
		"\7N\2\2\u009f\u00a0\7G\2\2\u00a0\u00a2\7V\2\2\u00a1\u009b\3\2\2\2\u00a1"+
		"\u009e\3\2\2\2\u00a2\64\3\2\2\2\u00a3\u00a4\7g\2\2\u00a4\u00a5\7n\2\2"+
		"\u00a5\u00a6\7u\2\2\u00a6\u00ac\7g\2\2\u00a7\u00a8\7G\2\2\u00a8\u00a9"+
		"\7N\2\2\u00a9\u00aa\7U\2\2\u00aa\u00ac\7G\2\2\u00ab\u00a3\3\2\2\2\u00ab"+
		"\u00a7\3\2\2\2\u00ac\66\3\2\2\2\u00ad\u00ae\7v\2\2\u00ae\u00af\7t\2\2"+
		"\u00af\u00b0\7w\2\2\u00b0\u00b6\7g\2\2\u00b1\u00b2\7V\2\2\u00b2\u00b3"+
		"\7T\2\2\u00b3\u00b4\7W\2\2\u00b4\u00b6\7G\2\2\u00b5\u00ad\3\2\2\2\u00b5"+
		"\u00b1\3\2\2\2\u00b68\3\2\2\2\u00b7\u00b8\7h\2\2\u00b8\u00b9\7c\2\2\u00b9"+
		"\u00ba\7n\2\2\u00ba\u00bb\7u\2\2\u00bb\u00c2\7g\2\2\u00bc\u00bd\7H\2\2"+
		"\u00bd\u00be\7C\2\2\u00be\u00bf\7N\2\2\u00bf\u00c0\7U\2\2\u00c0\u00c2"+
		"\7G\2\2\u00c1\u00b7\3\2\2\2\u00c1\u00bc\3\2\2\2\u00c2:\3\2\2\2\u00c3\u00c4"+
		"\7n\2\2\u00c4\u00c5\7g\2\2\u00c5\u00ca\7p\2\2\u00c6\u00c7\7N\2\2\u00c7"+
		"\u00c8\7G\2\2\u00c8\u00ca\7P\2\2\u00c9\u00c3\3\2\2\2\u00c9\u00c6\3\2\2"+
		"\2\u00ca<\3\2\2\2\u00cb\u00cc\7h\2\2\u00cc\u00cd\7k\2\2\u00cd\u00ce\7"+
		"t\2\2\u00ce\u00cf\7u\2\2\u00cf\u00d6\7v\2\2\u00d0\u00d1\7H\2\2\u00d1\u00d2"+
		"\7K\2\2\u00d2\u00d3\7T\2\2\u00d3\u00d4\7U\2\2\u00d4\u00d6\7V\2\2\u00d5"+
		"\u00cb\3\2\2\2\u00d5\u00d0\3\2\2\2\u00d6>\3\2\2\2\u00d7\u00d8\7n\2\2\u00d8"+
		"\u00d9\7c\2\2\u00d9\u00da\7u\2\2\u00da\u00e0\7v\2\2\u00db\u00dc\7N\2\2"+
		"\u00dc\u00dd\7C\2\2\u00dd\u00de\7U\2\2\u00de\u00e0\7V\2\2\u00df\u00d7"+
		"\3\2\2\2\u00df\u00db\3\2\2\2\u00e0@\3\2\2\2\u00e1\u00e2\7t\2\2\u00e2\u00e3"+
		"\7g\2\2\u00e3\u00e4\7u\2\2\u00e4\u00ea\7v\2\2\u00e5\u00e6\7T\2\2\u00e6"+
		"\u00e7\7G\2\2\u00e7\u00e8\7U\2\2\u00e8\u00ea\7V\2\2\u00e9\u00e1\3\2\2"+
		"\2\u00e9\u00e5\3\2\2\2\u00eaB\3\2\2\2\u00eb\u00ec\7r\2\2\u00ec\u00ed\7"+
		"w\2\2\u00ed\u00ee\7u\2\2\u00ee\u00f4\7j\2\2\u00ef\u00f0\7R\2\2\u00f0\u00f1"+
		"\7W\2\2\u00f1\u00f2\7U\2\2\u00f2\u00f4\7J\2\2\u00f3\u00eb\3\2\2\2\u00f3"+
		"\u00ef\3\2\2\2\u00f4D\3\2\2\2\u00f5\u00f6\7h\2\2\u00f6\u00f7\7w\2\2\u00f7"+
		"\u00fc\7p\2\2\u00f8\u00f9\7H\2\2\u00f9\u00fa\7W\2\2\u00fa\u00fc\7P\2\2"+
		"\u00fb\u00f5\3\2\2\2\u00fb\u00f8\3\2\2\2\u00fcF\3\2\2\2\u00fd\u00fe\7"+
		"r\2\2\u00fe\u00ff\7w\2\2\u00ff\u0100\7v\2\2\u0100\u0106\7u\2\2\u0101\u0102"+
		"\7R\2\2\u0102\u0103\7W\2\2\u0103\u0104\7V\2\2\u0104\u0106\7U\2\2\u0105"+
		"\u00fd\3\2\2\2\u0105\u0101\3\2\2\2\u0106H\3\2\2\2\u0107\u010c\5[.\2\u0108"+
		"\u010b\5[.\2\u0109\u010b\5]/\2\u010a\u0108\3\2\2\2\u010a\u0109\3\2\2\2"+
		"\u010b\u010e\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010dJ\3"+
		"\2\2\2\u010e\u010c\3\2\2\2\u010f\u0113\5]/\2\u0110\u0112\5]/\2\u0111\u0110"+
		"\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114"+
		"L\3\2\2\2\u0115\u0113\3\2\2\2\u0116\u0117\7t\2\2\u0117\u0118\7g\2\2\u0118"+
		"\u0119\7v\2\2\u0119\u011a\7w\2\2\u011a\u011b\7t\2\2\u011b\u0123\7p\2\2"+
		"\u011c\u011d\7T\2\2\u011d\u011e\7G\2\2\u011e\u011f\7V\2\2\u011f\u0120"+
		"\7W\2\2\u0120\u0121\7T\2\2\u0121\u0123\7P\2\2\u0122\u0116\3\2\2\2\u0122"+
		"\u011c\3\2\2\2\u0123N\3\2\2\2\u0124\u0128\7$\2\2\u0125\u0127\5U+\2\u0126"+
		"\u0125\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u0129\3\2\2\2\u0128\u0126\3\2"+
		"\2\2\u0129\u012b\3\2\2\2\u012a\u0128\3\2\2\2\u012b\u012c\7$\2\2\u012c"+
		"P\3\2\2\2\u012d\u0130\5\67\34\2\u012e\u0130\59\35\2\u012f\u012d\3\2\2"+
		"\2\u012f\u012e\3\2\2\2\u0130R\3\2\2\2\u0131\u0134\7)\2\2\u0132\u0135\5"+
		"[.\2\u0133\u0135\5]/\2\u0134\u0132\3\2\2\2\u0134\u0133\3\2\2\2\u0135\u0136"+
		"\3\2\2\2\u0136\u0137\7)\2\2\u0137T\3\2\2\2\u0138\u013b\5[.\2\u0139\u013b"+
		"\5]/\2\u013a\u0138\3\2\2\2\u013a\u0139\3\2\2\2\u013bV\3\2\2\2\u013c\u0141"+
		"\5-\27\2\u013d\u0140\5W,\2\u013e\u0140\13\2\2\2\u013f\u013d\3\2\2\2\u013f"+
		"\u013e\3\2\2\2\u0140\u0143\3\2\2\2\u0141\u0142\3\2\2\2\u0141\u013f\3\2"+
		"\2\2\u0142\u0144\3\2\2\2\u0143\u0141\3\2\2\2\u0144\u0145\5/\30\2\u0145"+
		"\u0146\3\2\2\2\u0146\u0147\b,\2\2\u0147X\3\2\2\2\u0148\u014c\5+\26\2\u0149"+
		"\u014b\13\2\2\2\u014a\u0149\3\2\2\2\u014b\u014e\3\2\2\2\u014c\u014d\3"+
		"\2\2\2\u014c\u014a\3\2\2\2\u014d\u014f\3\2\2\2\u014e\u014c\3\2\2\2\u014f"+
		"\u0150\7\f\2\2\u0150\u0151\3\2\2\2\u0151\u0152\b-\2\2\u0152Z\3\2\2\2\u0153"+
		"\u0154\t\2\2\2\u0154\\\3\2\2\2\u0155\u0156\4\62;\2\u0156^\3\2\2\2\u0157"+
		"\u0159\t\3\2\2\u0158\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u0158\3\2"+
		"\2\2\u015a\u015b\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015d\b\60\3\2\u015d"+
		"`\3\2\2\2\33\2\u0099\u00a1\u00ab\u00b5\u00c1\u00c9\u00d5\u00df\u00e9\u00f3"+
		"\u00fb\u0105\u010a\u010c\u0113\u0122\u0128\u012f\u0134\u013a\u013f\u0141"+
		"\u014c\u015a\4\2\3\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}