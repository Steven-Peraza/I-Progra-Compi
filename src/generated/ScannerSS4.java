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
		CHAR=41, COMMENT=42, LINE_COMMENT=43, WS=44;
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
		"ID", "NUM", "RETURN", "STRING", "BOOL", "CHAR", "COMMENT", "LINE_COMMENT", 
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
		"PUTS", "ID", "NUM", "RETURN", "STRING", "BOOL", "CHAR", "COMMENT", "LINE_COMMENT", 
		"WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2.\u0155\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31"+
		"\5\31\u0098\n\31\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u00a0\n\32\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u00aa\n\33\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\5\34\u00b4\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\5\35\u00c0\n\35\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u00c8"+
		"\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u00d4\n\37"+
		"\3 \3 \3 \3 \3 \3 \3 \3 \5 \u00de\n \3!\3!\3!\3!\3!\3!\3!\3!\5!\u00e8"+
		"\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u00f2\n\"\3#\3#\3#\3#\3#\3#\5"+
		"#\u00fa\n#\3$\3$\3$\3$\3$\3$\3$\3$\5$\u0104\n$\3%\3%\3%\7%\u0109\n%\f"+
		"%\16%\u010c\13%\3&\3&\7&\u0110\n&\f&\16&\u0113\13&\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u0121\n\'\3(\3(\7(\u0125\n(\f(\16(\u0128"+
		"\13(\3(\3(\3)\3)\5)\u012e\n)\3*\3*\5*\u0132\n*\3+\3+\3+\7+\u0137\n+\f"+
		"+\16+\u013a\13+\3+\3+\3+\3+\3,\3,\7,\u0142\n,\f,\16,\u0145\13,\3,\3,\3"+
		",\3,\3-\3-\3.\3.\3/\6/\u0150\n/\r/\16/\u0151\3/\3/\5\u0126\u0138\u0143"+
		"\2\60\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y\2[\2].\3\2\4\5\2C\\aac|\5\2\13\f\17"+
		"\17\"\"\2\u0169\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3"+
		"\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2"+
		"\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2]\3\2\2\2\3_\3\2\2\2\5a\3\2\2\2\7"+
		"c\3\2\2\2\te\3\2\2\2\13g\3\2\2\2\ri\3\2\2\2\17k\3\2\2\2\21m\3\2\2\2\23"+
		"o\3\2\2\2\25q\3\2\2\2\27s\3\2\2\2\31u\3\2\2\2\33w\3\2\2\2\35y\3\2\2\2"+
		"\37|\3\2\2\2!\177\3\2\2\2#\u0082\3\2\2\2%\u0084\3\2\2\2\'\u0086\3\2\2"+
		"\2)\u0088\3\2\2\2+\u008a\3\2\2\2-\u008d\3\2\2\2/\u0090\3\2\2\2\61\u0097"+
		"\3\2\2\2\63\u009f\3\2\2\2\65\u00a9\3\2\2\2\67\u00b3\3\2\2\29\u00bf\3\2"+
		"\2\2;\u00c7\3\2\2\2=\u00d3\3\2\2\2?\u00dd\3\2\2\2A\u00e7\3\2\2\2C\u00f1"+
		"\3\2\2\2E\u00f9\3\2\2\2G\u0103\3\2\2\2I\u0105\3\2\2\2K\u010d\3\2\2\2M"+
		"\u0120\3\2\2\2O\u0122\3\2\2\2Q\u012d\3\2\2\2S\u0131\3\2\2\2U\u0133\3\2"+
		"\2\2W\u013f\3\2\2\2Y\u014a\3\2\2\2[\u014c\3\2\2\2]\u014f\3\2\2\2_`\7="+
		"\2\2`\4\3\2\2\2ab\7.\2\2b\6\3\2\2\2cd\7?\2\2d\b\3\2\2\2ef\7*\2\2f\n\3"+
		"\2\2\2gh\7+\2\2h\f\3\2\2\2ij\7<\2\2j\16\3\2\2\2kl\7\u0080\2\2l\20\3\2"+
		"\2\2mn\7-\2\2n\22\3\2\2\2op\7/\2\2p\24\3\2\2\2qr\7,\2\2r\26\3\2\2\2st"+
		"\7\61\2\2t\30\3\2\2\2uv\7@\2\2v\32\3\2\2\2wx\7>\2\2x\34\3\2\2\2yz\7@\2"+
		"\2z{\7?\2\2{\36\3\2\2\2|}\7>\2\2}~\7?\2\2~ \3\2\2\2\177\u0080\7?\2\2\u0080"+
		"\u0081\7?\2\2\u0081\"\3\2\2\2\u0082\u0083\7]\2\2\u0083$\3\2\2\2\u0084"+
		"\u0085\7_\2\2\u0085&\3\2\2\2\u0086\u0087\7}\2\2\u0087(\3\2\2\2\u0088\u0089"+
		"\7\177\2\2\u0089*\3\2\2\2\u008a\u008b\7\61\2\2\u008b\u008c\7\61\2\2\u008c"+
		",\3\2\2\2\u008d\u008e\7\61\2\2\u008e\u008f\7,\2\2\u008f.\3\2\2\2\u0090"+
		"\u0091\7,\2\2\u0091\u0092\7\61\2\2\u0092\60\3\2\2\2\u0093\u0094\7k\2\2"+
		"\u0094\u0098\7h\2\2\u0095\u0096\7K\2\2\u0096\u0098\7H\2\2\u0097\u0093"+
		"\3\2\2\2\u0097\u0095\3\2\2\2\u0098\62\3\2\2\2\u0099\u009a\7n\2\2\u009a"+
		"\u009b\7g\2\2\u009b\u00a0\7v\2\2\u009c\u009d\7N\2\2\u009d\u009e\7G\2\2"+
		"\u009e\u00a0\7V\2\2\u009f\u0099\3\2\2\2\u009f\u009c\3\2\2\2\u00a0\64\3"+
		"\2\2\2\u00a1\u00a2\7g\2\2\u00a2\u00a3\7n\2\2\u00a3\u00a4\7u\2\2\u00a4"+
		"\u00aa\7g\2\2\u00a5\u00a6\7G\2\2\u00a6\u00a7\7N\2\2\u00a7\u00a8\7U\2\2"+
		"\u00a8\u00aa\7G\2\2\u00a9\u00a1\3\2\2\2\u00a9\u00a5\3\2\2\2\u00aa\66\3"+
		"\2\2\2\u00ab\u00ac\7v\2\2\u00ac\u00ad\7t\2\2\u00ad\u00ae\7w\2\2\u00ae"+
		"\u00b4\7g\2\2\u00af\u00b0\7V\2\2\u00b0\u00b1\7T\2\2\u00b1\u00b2\7W\2\2"+
		"\u00b2\u00b4\7G\2\2\u00b3\u00ab\3\2\2\2\u00b3\u00af\3\2\2\2\u00b48\3\2"+
		"\2\2\u00b5\u00b6\7h\2\2\u00b6\u00b7\7c\2\2\u00b7\u00b8\7n\2\2\u00b8\u00b9"+
		"\7u\2\2\u00b9\u00c0\7g\2\2\u00ba\u00bb\7H\2\2\u00bb\u00bc\7C\2\2\u00bc"+
		"\u00bd\7N\2\2\u00bd\u00be\7U\2\2\u00be\u00c0\7G\2\2\u00bf\u00b5\3\2\2"+
		"\2\u00bf\u00ba\3\2\2\2\u00c0:\3\2\2\2\u00c1\u00c2\7n\2\2\u00c2\u00c3\7"+
		"g\2\2\u00c3\u00c8\7p\2\2\u00c4\u00c5\7N\2\2\u00c5\u00c6\7G\2\2\u00c6\u00c8"+
		"\7P\2\2\u00c7\u00c1\3\2\2\2\u00c7\u00c4\3\2\2\2\u00c8<\3\2\2\2\u00c9\u00ca"+
		"\7h\2\2\u00ca\u00cb\7k\2\2\u00cb\u00cc\7t\2\2\u00cc\u00cd\7u\2\2\u00cd"+
		"\u00d4\7v\2\2\u00ce\u00cf\7H\2\2\u00cf\u00d0\7K\2\2\u00d0\u00d1\7T\2\2"+
		"\u00d1\u00d2\7U\2\2\u00d2\u00d4\7V\2\2\u00d3\u00c9\3\2\2\2\u00d3\u00ce"+
		"\3\2\2\2\u00d4>\3\2\2\2\u00d5\u00d6\7n\2\2\u00d6\u00d7\7c\2\2\u00d7\u00d8"+
		"\7u\2\2\u00d8\u00de\7v\2\2\u00d9\u00da\7N\2\2\u00da\u00db\7C\2\2\u00db"+
		"\u00dc\7U\2\2\u00dc\u00de\7V\2\2\u00dd\u00d5\3\2\2\2\u00dd\u00d9\3\2\2"+
		"\2\u00de@\3\2\2\2\u00df\u00e0\7t\2\2\u00e0\u00e1\7g\2\2\u00e1\u00e2\7"+
		"u\2\2\u00e2\u00e8\7v\2\2\u00e3\u00e4\7T\2\2\u00e4\u00e5\7G\2\2\u00e5\u00e6"+
		"\7U\2\2\u00e6\u00e8\7V\2\2\u00e7\u00df\3\2\2\2\u00e7\u00e3\3\2\2\2\u00e8"+
		"B\3\2\2\2\u00e9\u00ea\7r\2\2\u00ea\u00eb\7w\2\2\u00eb\u00ec\7u\2\2\u00ec"+
		"\u00f2\7j\2\2\u00ed\u00ee\7R\2\2\u00ee\u00ef\7W\2\2\u00ef\u00f0\7U\2\2"+
		"\u00f0\u00f2\7J\2\2\u00f1\u00e9\3\2\2\2\u00f1\u00ed\3\2\2\2\u00f2D\3\2"+
		"\2\2\u00f3\u00f4\7h\2\2\u00f4\u00f5\7w\2\2\u00f5\u00fa\7p\2\2\u00f6\u00f7"+
		"\7H\2\2\u00f7\u00f8\7W\2\2\u00f8\u00fa\7P\2\2\u00f9\u00f3\3\2\2\2\u00f9"+
		"\u00f6\3\2\2\2\u00faF\3\2\2\2\u00fb\u00fc\7r\2\2\u00fc\u00fd\7w\2\2\u00fd"+
		"\u00fe\7v\2\2\u00fe\u0104\7u\2\2\u00ff\u0100\7R\2\2\u0100\u0101\7W\2\2"+
		"\u0101\u0102\7V\2\2\u0102\u0104\7U\2\2\u0103\u00fb\3\2\2\2\u0103\u00ff"+
		"\3\2\2\2\u0104H\3\2\2\2\u0105\u010a\5Y-\2\u0106\u0109\5Y-\2\u0107\u0109"+
		"\5[.\2\u0108\u0106\3\2\2\2\u0108\u0107\3\2\2\2\u0109\u010c\3\2\2\2\u010a"+
		"\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010bJ\3\2\2\2\u010c\u010a\3\2\2\2"+
		"\u010d\u0111\5[.\2\u010e\u0110\5[.\2\u010f\u010e\3\2\2\2\u0110\u0113\3"+
		"\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112L\3\2\2\2\u0113\u0111"+
		"\3\2\2\2\u0114\u0115\7t\2\2\u0115\u0116\7g\2\2\u0116\u0117\7v\2\2\u0117"+
		"\u0118\7w\2\2\u0118\u0119\7t\2\2\u0119\u0121\7p\2\2\u011a\u011b\7T\2\2"+
		"\u011b\u011c\7G\2\2\u011c\u011d\7V\2\2\u011d\u011e\7W\2\2\u011e\u011f"+
		"\7T\2\2\u011f\u0121\7P\2\2\u0120\u0114\3\2\2\2\u0120\u011a\3\2\2\2\u0121"+
		"N\3\2\2\2\u0122\u0126\7$\2\2\u0123\u0125\5S*\2\u0124\u0123\3\2\2\2\u0125"+
		"\u0128\3\2\2\2\u0126\u0127\3\2\2\2\u0126\u0124\3\2\2\2\u0127\u0129\3\2"+
		"\2\2\u0128\u0126\3\2\2\2\u0129\u012a\7$\2\2\u012aP\3\2\2\2\u012b\u012e"+
		"\5\67\34\2\u012c\u012e\59\35\2\u012d\u012b\3\2\2\2\u012d\u012c\3\2\2\2"+
		"\u012eR\3\2\2\2\u012f\u0132\5Y-\2\u0130\u0132\5[.\2\u0131\u012f\3\2\2"+
		"\2\u0131\u0130\3\2\2\2\u0132T\3\2\2\2\u0133\u0138\5-\27\2\u0134\u0137"+
		"\5U+\2\u0135\u0137\13\2\2\2\u0136\u0134\3\2\2\2\u0136\u0135\3\2\2\2\u0137"+
		"\u013a\3\2\2\2\u0138\u0139\3\2\2\2\u0138\u0136\3\2\2\2\u0139\u013b\3\2"+
		"\2\2\u013a\u0138\3\2\2\2\u013b\u013c\5/\30\2\u013c\u013d\3\2\2\2\u013d"+
		"\u013e\b+\2\2\u013eV\3\2\2\2\u013f\u0143\5+\26\2\u0140\u0142\13\2\2\2"+
		"\u0141\u0140\3\2\2\2\u0142\u0145\3\2\2\2\u0143\u0144\3\2\2\2\u0143\u0141"+
		"\3\2\2\2\u0144\u0146\3\2\2\2\u0145\u0143\3\2\2\2\u0146\u0147\7\f\2\2\u0147"+
		"\u0148\3\2\2\2\u0148\u0149\b,\2\2\u0149X\3\2\2\2\u014a\u014b\t\2\2\2\u014b"+
		"Z\3\2\2\2\u014c\u014d\4\62;\2\u014d\\\3\2\2\2\u014e\u0150\t\3\2\2\u014f"+
		"\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0152\3\2"+
		"\2\2\u0152\u0153\3\2\2\2\u0153\u0154\b/\3\2\u0154^\3\2\2\2\32\2\u0097"+
		"\u009f\u00a9\u00b3\u00bf\u00c7\u00d3\u00dd\u00e7\u00f1\u00f9\u0103\u0108"+
		"\u010a\u0111\u0120\u0126\u012d\u0131\u0136\u0138\u0143\u0151\4\2\3\2\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}