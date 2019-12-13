// Generated from Enquestes.g by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EnquestesLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUM=1, P=2, R=3, I=4, A=5, E=6, IS=7, TO=8, PREGUNTA=9, RESPOSTA=10, ITEM=11, 
		ALTERNATIVA=12, ENQUESTA=13, CAPITAL=14, WORD=15, INTERROGANTE=16, POINTCOMA=17, 
		COMA=18, OPENCLAUDATOR=19, CLOSECLAUDATOR=20, OPENPARENT=21, CLOSEPARENT=22, 
		WS=23, NL=24, END=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NUM", "P", "R", "I", "A", "E", "IS", "TO", "PREGUNTA", "RESPOSTA", "ITEM", 
			"ALTERNATIVA", "ENQUESTA", "CAPITAL", "WORD", "INTERROGANTE", "POINTCOMA", 
			"COMA", "OPENCLAUDATOR", "CLOSECLAUDATOR", "OPENPARENT", "CLOSEPARENT", 
			"WS", "NL", "END"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'E'", "':'", "'->'", "'PREGUNTA'", 
			"'RESPOSTA'", "'ITEM'", "'ALTERNATIVA'", "'ENQUESTA'", null, null, "'?'", 
			"';'", "','", "'['", "']'", "'('", "')'", "' '", "'\n'", "'END'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NUM", "P", "R", "I", "A", "E", "IS", "TO", "PREGUNTA", "RESPOSTA", 
			"ITEM", "ALTERNATIVA", "ENQUESTA", "CAPITAL", "WORD", "INTERROGANTE", 
			"POINTCOMA", "COMA", "OPENCLAUDATOR", "CLOSECLAUDATOR", "OPENPARENT", 
			"CLOSEPARENT", "WS", "NL", "END"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public EnquestesLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Enquestes.g"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\33\u00a2\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\6\2\67\n\2\r\2\16\28\3\3\3\3\6\3=\n\3\r\3\16\3>\3"+
		"\4\3\4\6\4C\n\4\r\4\16\4D\3\5\3\5\6\5I\n\5\r\5\16\5J\3\6\3\6\6\6O\n\6"+
		"\r\6\16\6P\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20\6\20\u0089\n\20\r\20\16\20\u008a"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\2\2\33\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\3\2\5\3\2\62;\3\2C\\\3\2c|\2\u00a7\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\3\66\3\2\2\2\5:\3\2\2\2\7@\3\2\2\2\tF\3\2\2\2\13"+
		"L\3\2\2\2\rR\3\2\2\2\17T\3\2\2\2\21V\3\2\2\2\23Y\3\2\2\2\25b\3\2\2\2\27"+
		"k\3\2\2\2\31p\3\2\2\2\33|\3\2\2\2\35\u0085\3\2\2\2\37\u0088\3\2\2\2!\u008c"+
		"\3\2\2\2#\u008e\3\2\2\2%\u0090\3\2\2\2\'\u0092\3\2\2\2)\u0094\3\2\2\2"+
		"+\u0096\3\2\2\2-\u0098\3\2\2\2/\u009a\3\2\2\2\61\u009c\3\2\2\2\63\u009e"+
		"\3\2\2\2\65\67\t\2\2\2\66\65\3\2\2\2\678\3\2\2\28\66\3\2\2\289\3\2\2\2"+
		"9\4\3\2\2\2:<\7R\2\2;=\t\2\2\2<;\3\2\2\2=>\3\2\2\2><\3\2\2\2>?\3\2\2\2"+
		"?\6\3\2\2\2@B\7T\2\2AC\t\2\2\2BA\3\2\2\2CD\3\2\2\2DB\3\2\2\2DE\3\2\2\2"+
		"E\b\3\2\2\2FH\7K\2\2GI\t\2\2\2HG\3\2\2\2IJ\3\2\2\2JH\3\2\2\2JK\3\2\2\2"+
		"K\n\3\2\2\2LN\7C\2\2MO\t\2\2\2NM\3\2\2\2OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2"+
		"Q\f\3\2\2\2RS\7G\2\2S\16\3\2\2\2TU\7<\2\2U\20\3\2\2\2VW\7/\2\2WX\7@\2"+
		"\2X\22\3\2\2\2YZ\7R\2\2Z[\7T\2\2[\\\7G\2\2\\]\7I\2\2]^\7W\2\2^_\7P\2\2"+
		"_`\7V\2\2`a\7C\2\2a\24\3\2\2\2bc\7T\2\2cd\7G\2\2de\7U\2\2ef\7R\2\2fg\7"+
		"Q\2\2gh\7U\2\2hi\7V\2\2ij\7C\2\2j\26\3\2\2\2kl\7K\2\2lm\7V\2\2mn\7G\2"+
		"\2no\7O\2\2o\30\3\2\2\2pq\7C\2\2qr\7N\2\2rs\7V\2\2st\7G\2\2tu\7T\2\2u"+
		"v\7P\2\2vw\7C\2\2wx\7V\2\2xy\7K\2\2yz\7X\2\2z{\7C\2\2{\32\3\2\2\2|}\7"+
		"G\2\2}~\7P\2\2~\177\7S\2\2\177\u0080\7W\2\2\u0080\u0081\7G\2\2\u0081\u0082"+
		"\7U\2\2\u0082\u0083\7V\2\2\u0083\u0084\7C\2\2\u0084\34\3\2\2\2\u0085\u0086"+
		"\t\3\2\2\u0086\36\3\2\2\2\u0087\u0089\t\4\2\2\u0088\u0087\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b \3\2\2\2"+
		"\u008c\u008d\7A\2\2\u008d\"\3\2\2\2\u008e\u008f\7=\2\2\u008f$\3\2\2\2"+
		"\u0090\u0091\7.\2\2\u0091&\3\2\2\2\u0092\u0093\7]\2\2\u0093(\3\2\2\2\u0094"+
		"\u0095\7_\2\2\u0095*\3\2\2\2\u0096\u0097\7*\2\2\u0097,\3\2\2\2\u0098\u0099"+
		"\7+\2\2\u0099.\3\2\2\2\u009a\u009b\7\"\2\2\u009b\60\3\2\2\2\u009c\u009d"+
		"\7\f\2\2\u009d\62\3\2\2\2\u009e\u009f\7G\2\2\u009f\u00a0\7P\2\2\u00a0"+
		"\u00a1\7F\2\2\u00a1\64\3\2\2\2\t\28>DJP\u008a\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}