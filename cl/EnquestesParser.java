// Generated from Enquestes.g by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EnquestesParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUM=1, P=2, R=3, I=4, A=5, E=6, IS=7, TO=8, PREGUNTA=9, RESPOSTA=10, ITEM=11, 
		ALTERNATIVA=12, ENQUESTA=13, CAPITAL=14, WORD=15, INTERROGANTE=16, POINTCOMA=17, 
		COMA=18, OPENCLAUDATOR=19, CLOSECLAUDATOR=20, OPENPARENT=21, CLOSEPARENT=22, 
		WS=23, NL=24, END=25;
	public static final int
		RULE_root = 0, RULE_statement = 1, RULE_pregunta = 2, RULE_phrase = 3, 
		RULE_resposta = 4, RULE_option = 5, RULE_item = 6, RULE_alternativa = 7, 
		RULE_detour = 8, RULE_enquesta = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "statement", "pregunta", "phrase", "resposta", "option", "item", 
			"alternativa", "detour", "enquesta"
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

	@Override
	public String getGrammarFileName() { return "Enquestes.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EnquestesParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class RootContext extends ParserRuleContext {
		public TerminalNode END() { return getToken(EnquestesParser.END, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnquestesVisitor ) return ((EnquestesVisitor<? extends T>)visitor).visitRoot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << P) | (1L << R) | (1L << I) | (1L << A) | (1L << E))) != 0)) {
				{
				{
				setState(20);
				statement();
				}
				}
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(26);
			match(END);
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

	public static class StatementContext extends ParserRuleContext {
		public PreguntaContext pregunta() {
			return getRuleContext(PreguntaContext.class,0);
		}
		public RespostaContext resposta() {
			return getRuleContext(RespostaContext.class,0);
		}
		public ItemContext item() {
			return getRuleContext(ItemContext.class,0);
		}
		public AlternativaContext alternativa() {
			return getRuleContext(AlternativaContext.class,0);
		}
		public EnquestaContext enquesta() {
			return getRuleContext(EnquestaContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnquestesVisitor ) return ((EnquestesVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case P:
				{
				setState(28);
				pregunta();
				}
				break;
			case R:
				{
				setState(29);
				resposta();
				}
				break;
			case I:
				{
				setState(30);
				item();
				}
				break;
			case A:
				{
				setState(31);
				alternativa();
				}
				break;
			case E:
				{
				setState(32);
				enquesta();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class PreguntaContext extends ParserRuleContext {
		public TerminalNode P() { return getToken(EnquestesParser.P, 0); }
		public TerminalNode IS() { return getToken(EnquestesParser.IS, 0); }
		public TerminalNode WS() { return getToken(EnquestesParser.WS, 0); }
		public TerminalNode PREGUNTA() { return getToken(EnquestesParser.PREGUNTA, 0); }
		public List<TerminalNode> NL() { return getTokens(EnquestesParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(EnquestesParser.NL, i);
		}
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public PreguntaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pregunta; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnquestesVisitor ) return ((EnquestesVisitor<? extends T>)visitor).visitPregunta(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreguntaContext pregunta() throws RecognitionException {
		PreguntaContext _localctx = new PreguntaContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pregunta);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(P);
			setState(36);
			match(IS);
			setState(37);
			match(WS);
			setState(38);
			match(PREGUNTA);
			setState(39);
			match(NL);
			setState(40);
			phrase();
			setState(41);
			match(NL);
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

	public static class PhraseContext extends ParserRuleContext {
		public TerminalNode CAPITAL() { return getToken(EnquestesParser.CAPITAL, 0); }
		public List<TerminalNode> WORD() { return getTokens(EnquestesParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(EnquestesParser.WORD, i);
		}
		public List<TerminalNode> WS() { return getTokens(EnquestesParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(EnquestesParser.WS, i);
		}
		public List<TerminalNode> INTERROGANTE() { return getTokens(EnquestesParser.INTERROGANTE); }
		public TerminalNode INTERROGANTE(int i) {
			return getToken(EnquestesParser.INTERROGANTE, i);
		}
		public PhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phrase; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnquestesVisitor ) return ((EnquestesVisitor<? extends T>)visitor).visitPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PhraseContext phrase() throws RecognitionException {
		PhraseContext _localctx = new PhraseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_phrase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CAPITAL) {
				{
				setState(43);
				match(CAPITAL);
				}
			}

			setState(48); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(46);
				match(WORD);
				setState(47);
				_la = _input.LA(1);
				if ( !(_la==INTERROGANTE || _la==WS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(50); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WORD );
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

	public static class RespostaContext extends ParserRuleContext {
		public TerminalNode R() { return getToken(EnquestesParser.R, 0); }
		public TerminalNode IS() { return getToken(EnquestesParser.IS, 0); }
		public TerminalNode WS() { return getToken(EnquestesParser.WS, 0); }
		public TerminalNode RESPOSTA() { return getToken(EnquestesParser.RESPOSTA, 0); }
		public TerminalNode NL() { return getToken(EnquestesParser.NL, 0); }
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public RespostaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resposta; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnquestesVisitor ) return ((EnquestesVisitor<? extends T>)visitor).visitResposta(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RespostaContext resposta() throws RecognitionException {
		RespostaContext _localctx = new RespostaContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_resposta);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(R);
			setState(53);
			match(IS);
			setState(54);
			match(WS);
			setState(55);
			match(RESPOSTA);
			setState(56);
			match(NL);
			setState(58); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(57);
				option();
				}
				}
				setState(60); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUM );
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

	public static class OptionContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(EnquestesParser.NUM, 0); }
		public TerminalNode IS() { return getToken(EnquestesParser.IS, 0); }
		public List<TerminalNode> WS() { return getTokens(EnquestesParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(EnquestesParser.WS, i);
		}
		public TerminalNode POINTCOMA() { return getToken(EnquestesParser.POINTCOMA, 0); }
		public TerminalNode NL() { return getToken(EnquestesParser.NL, 0); }
		public List<TerminalNode> WORD() { return getTokens(EnquestesParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(EnquestesParser.WORD, i);
		}
		public List<TerminalNode> CAPITAL() { return getTokens(EnquestesParser.CAPITAL); }
		public TerminalNode CAPITAL(int i) {
			return getToken(EnquestesParser.CAPITAL, i);
		}
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnquestesVisitor ) return ((EnquestesVisitor<? extends T>)visitor).visitOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_option);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(NUM);
			setState(63);
			match(IS);
			setState(64);
			match(WS);
			setState(70); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CAPITAL) {
					{
					setState(65);
					match(CAPITAL);
					}
				}

				setState(68);
				match(WORD);
				setState(69);
				match(WS);
				}
				}
				setState(72); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CAPITAL || _la==WORD );
			setState(74);
			match(POINTCOMA);
			setState(75);
			match(NL);
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

	public static class ItemContext extends ParserRuleContext {
		public TerminalNode I() { return getToken(EnquestesParser.I, 0); }
		public TerminalNode IS() { return getToken(EnquestesParser.IS, 0); }
		public List<TerminalNode> WS() { return getTokens(EnquestesParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(EnquestesParser.WS, i);
		}
		public TerminalNode ITEM() { return getToken(EnquestesParser.ITEM, 0); }
		public List<TerminalNode> NL() { return getTokens(EnquestesParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(EnquestesParser.NL, i);
		}
		public TerminalNode P() { return getToken(EnquestesParser.P, 0); }
		public TerminalNode TO() { return getToken(EnquestesParser.TO, 0); }
		public TerminalNode R() { return getToken(EnquestesParser.R, 0); }
		public ItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnquestesVisitor ) return ((EnquestesVisitor<? extends T>)visitor).visitItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemContext item() throws RecognitionException {
		ItemContext _localctx = new ItemContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_item);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(I);
			setState(78);
			match(IS);
			setState(79);
			match(WS);
			setState(80);
			match(ITEM);
			setState(81);
			match(NL);
			setState(82);
			match(P);
			setState(83);
			match(WS);
			setState(84);
			match(TO);
			setState(85);
			match(WS);
			setState(86);
			match(R);
			setState(87);
			match(NL);
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

	public static class AlternativaContext extends ParserRuleContext {
		public TerminalNode A() { return getToken(EnquestesParser.A, 0); }
		public TerminalNode IS() { return getToken(EnquestesParser.IS, 0); }
		public List<TerminalNode> WS() { return getTokens(EnquestesParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(EnquestesParser.WS, i);
		}
		public TerminalNode ALTERNATIVA() { return getToken(EnquestesParser.ALTERNATIVA, 0); }
		public List<TerminalNode> NL() { return getTokens(EnquestesParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(EnquestesParser.NL, i);
		}
		public TerminalNode I() { return getToken(EnquestesParser.I, 0); }
		public TerminalNode OPENCLAUDATOR() { return getToken(EnquestesParser.OPENCLAUDATOR, 0); }
		public TerminalNode CLOSECLAUDATOR() { return getToken(EnquestesParser.CLOSECLAUDATOR, 0); }
		public List<DetourContext> detour() {
			return getRuleContexts(DetourContext.class);
		}
		public DetourContext detour(int i) {
			return getRuleContext(DetourContext.class,i);
		}
		public AlternativaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alternativa; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnquestesVisitor ) return ((EnquestesVisitor<? extends T>)visitor).visitAlternativa(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlternativaContext alternativa() throws RecognitionException {
		AlternativaContext _localctx = new AlternativaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_alternativa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(A);
			setState(90);
			match(IS);
			setState(91);
			match(WS);
			setState(92);
			match(ALTERNATIVA);
			setState(93);
			match(NL);
			setState(94);
			match(I);
			setState(95);
			match(WS);
			setState(96);
			match(OPENCLAUDATOR);
			setState(98); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(97);
				detour();
				}
				}
				setState(100); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OPENPARENT );
			setState(102);
			match(CLOSECLAUDATOR);
			setState(103);
			match(NL);
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

	public static class DetourContext extends ParserRuleContext {
		public TerminalNode OPENPARENT() { return getToken(EnquestesParser.OPENPARENT, 0); }
		public TerminalNode NUM() { return getToken(EnquestesParser.NUM, 0); }
		public List<TerminalNode> COMA() { return getTokens(EnquestesParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(EnquestesParser.COMA, i);
		}
		public TerminalNode I() { return getToken(EnquestesParser.I, 0); }
		public TerminalNode CLOSEPARENT() { return getToken(EnquestesParser.CLOSEPARENT, 0); }
		public DetourContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_detour; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnquestesVisitor ) return ((EnquestesVisitor<? extends T>)visitor).visitDetour(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DetourContext detour() throws RecognitionException {
		DetourContext _localctx = new DetourContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_detour);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(OPENPARENT);
			setState(106);
			match(NUM);
			setState(107);
			match(COMA);
			setState(108);
			match(I);
			setState(109);
			match(CLOSEPARENT);
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMA) {
				{
				setState(110);
				match(COMA);
				}
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

	public static class EnquestaContext extends ParserRuleContext {
		public TerminalNode E() { return getToken(EnquestesParser.E, 0); }
		public TerminalNode IS() { return getToken(EnquestesParser.IS, 0); }
		public List<TerminalNode> WS() { return getTokens(EnquestesParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(EnquestesParser.WS, i);
		}
		public TerminalNode ENQUESTA() { return getToken(EnquestesParser.ENQUESTA, 0); }
		public List<TerminalNode> NL() { return getTokens(EnquestesParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(EnquestesParser.NL, i);
		}
		public List<TerminalNode> I() { return getTokens(EnquestesParser.I); }
		public TerminalNode I(int i) {
			return getToken(EnquestesParser.I, i);
		}
		public EnquestaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enquesta; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnquestesVisitor ) return ((EnquestesVisitor<? extends T>)visitor).visitEnquesta(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnquestaContext enquesta() throws RecognitionException {
		EnquestaContext _localctx = new EnquestaContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_enquesta);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(E);
			setState(114);
			match(IS);
			setState(115);
			match(WS);
			setState(116);
			match(ENQUESTA);
			setState(117);
			match(NL);
			setState(122); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(118);
				match(I);
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WS) {
					{
					setState(119);
					match(WS);
					}
				}

				}
				}
				setState(124); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==I );
			setState(126);
			match(NL);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\33\u0083\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\7\2\30\n\2\f\2\16\2\33\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3"+
		"$\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\5\5/\n\5\3\5\3\5\6\5\63\n\5"+
		"\r\5\16\5\64\3\6\3\6\3\6\3\6\3\6\3\6\6\6=\n\6\r\6\16\6>\3\7\3\7\3\7\3"+
		"\7\5\7E\n\7\3\7\3\7\6\7I\n\7\r\7\16\7J\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\6\te"+
		"\n\t\r\t\16\tf\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\5\nr\n\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13{\n\13\6\13}\n\13\r\13\16\13~\3\13\3\13"+
		"\3\13\2\2\f\2\4\6\b\n\f\16\20\22\24\2\3\4\2\22\22\31\31\2\u0086\2\31\3"+
		"\2\2\2\4#\3\2\2\2\6%\3\2\2\2\b.\3\2\2\2\n\66\3\2\2\2\f@\3\2\2\2\16O\3"+
		"\2\2\2\20[\3\2\2\2\22k\3\2\2\2\24s\3\2\2\2\26\30\5\4\3\2\27\26\3\2\2\2"+
		"\30\33\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\34\3\2\2\2\33\31\3\2\2\2"+
		"\34\35\7\33\2\2\35\3\3\2\2\2\36$\5\6\4\2\37$\5\n\6\2 $\5\16\b\2!$\5\20"+
		"\t\2\"$\5\24\13\2#\36\3\2\2\2#\37\3\2\2\2# \3\2\2\2#!\3\2\2\2#\"\3\2\2"+
		"\2$\5\3\2\2\2%&\7\4\2\2&\'\7\t\2\2\'(\7\31\2\2()\7\13\2\2)*\7\32\2\2*"+
		"+\5\b\5\2+,\7\32\2\2,\7\3\2\2\2-/\7\20\2\2.-\3\2\2\2./\3\2\2\2/\62\3\2"+
		"\2\2\60\61\7\21\2\2\61\63\t\2\2\2\62\60\3\2\2\2\63\64\3\2\2\2\64\62\3"+
		"\2\2\2\64\65\3\2\2\2\65\t\3\2\2\2\66\67\7\5\2\2\678\7\t\2\289\7\31\2\2"+
		"9:\7\f\2\2:<\7\32\2\2;=\5\f\7\2<;\3\2\2\2=>\3\2\2\2><\3\2\2\2>?\3\2\2"+
		"\2?\13\3\2\2\2@A\7\3\2\2AB\7\t\2\2BH\7\31\2\2CE\7\20\2\2DC\3\2\2\2DE\3"+
		"\2\2\2EF\3\2\2\2FG\7\21\2\2GI\7\31\2\2HD\3\2\2\2IJ\3\2\2\2JH\3\2\2\2J"+
		"K\3\2\2\2KL\3\2\2\2LM\7\23\2\2MN\7\32\2\2N\r\3\2\2\2OP\7\6\2\2PQ\7\t\2"+
		"\2QR\7\31\2\2RS\7\r\2\2ST\7\32\2\2TU\7\4\2\2UV\7\31\2\2VW\7\n\2\2WX\7"+
		"\31\2\2XY\7\5\2\2YZ\7\32\2\2Z\17\3\2\2\2[\\\7\7\2\2\\]\7\t\2\2]^\7\31"+
		"\2\2^_\7\16\2\2_`\7\32\2\2`a\7\6\2\2ab\7\31\2\2bd\7\25\2\2ce\5\22\n\2"+
		"dc\3\2\2\2ef\3\2\2\2fd\3\2\2\2fg\3\2\2\2gh\3\2\2\2hi\7\26\2\2ij\7\32\2"+
		"\2j\21\3\2\2\2kl\7\27\2\2lm\7\3\2\2mn\7\24\2\2no\7\6\2\2oq\7\30\2\2pr"+
		"\7\24\2\2qp\3\2\2\2qr\3\2\2\2r\23\3\2\2\2st\7\b\2\2tu\7\t\2\2uv\7\31\2"+
		"\2vw\7\17\2\2w|\7\32\2\2xz\7\6\2\2y{\7\31\2\2zy\3\2\2\2z{\3\2\2\2{}\3"+
		"\2\2\2|x\3\2\2\2}~\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080"+
		"\u0081\7\32\2\2\u0081\25\3\2\2\2\r\31#.\64>DJfqz~";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}