// Generated from GrammarGyh.g4 by ANTLR 4.7.2

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarGyhParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Delim=1, OpRelMaior=2, OpRelMenor=3, OpRelIgual=4, OpRelDiferente=5, OpRelMaiorIgual=6, 
		OpRelMenorIgual=7, Terminal=8, OpBoolE=9, OpBoolOU=10, PCDec=11, PCInt=12, 
		PCProg=13, PCReal=14, PCSe=15, PCEntao=16, PCSenao=17, PCEnqto=18, PCIni=19, 
		PCFim=20, PCImprimir=21, PCLer=22, Atrib=23, AbrePar=24, FechaPar=25, 
		OpAritSom=26, OpAritSub=27, OpAritMult=28, OpAritDiv=29, Var=30, Cadeia=31, 
		NumInt=32, NumReal=33, Coment=34, EspBranco=35;
	public static final int
		RULE_programa = 0, RULE_listaDeclaracoes = 1, RULE_declaracao = 2, RULE_tipoVar = 3, 
		RULE_expressaoAritmetica = 4, RULE_expressaoAritmeticaCount = 5, RULE_termoAritmetico = 6, 
		RULE_termoAritmeticoCount = 7, RULE_fatorAritmetico = 8, RULE_expressaoRelacional = 9, 
		RULE_expressaoRelacionalCount = 10, RULE_termoRelacional = 11, RULE_operadorBooleano = 12, 
		RULE_listaComandos = 13, RULE_comando = 14, RULE_comandoAtribuicao = 15, 
		RULE_comandoEntrada = 16, RULE_comandoSaida = 17, RULE_comandoCondicao = 18, 
		RULE_comandoRepeticao = 19, RULE_subAlgoritmo = 20, RULE_opRel = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "listaDeclaracoes", "declaracao", "tipoVar", "expressaoAritmetica", 
			"expressaoAritmeticaCount", "termoAritmetico", "termoAritmeticoCount", 
			"fatorAritmetico", "expressaoRelacional", "expressaoRelacionalCount", 
			"termoRelacional", "operadorBooleano", "listaComandos", "comando", "comandoAtribuicao", 
			"comandoEntrada", "comandoSaida", "comandoCondicao", "comandoRepeticao", 
			"subAlgoritmo", "opRel"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'>'", "'<'", "'=='", "'!='", "'>='", "'<='", "';'", "'E'", 
			"'OU'", "'DEC'", "'INT'", "'PROG'", "'REAL'", "'SE'", "'ENTAO'", "'SENAO'", 
			"'ENQTO'", "'INI'", "'FIM'", "'IMPRIMIR'", "'LER'", "':='", "'('", "')'", 
			"'+'", "'-'", "'*'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Delim", "OpRelMaior", "OpRelMenor", "OpRelIgual", "OpRelDiferente", 
			"OpRelMaiorIgual", "OpRelMenorIgual", "Terminal", "OpBoolE", "OpBoolOU", 
			"PCDec", "PCInt", "PCProg", "PCReal", "PCSe", "PCEntao", "PCSenao", "PCEnqto", 
			"PCIni", "PCFim", "PCImprimir", "PCLer", "Atrib", "AbrePar", "FechaPar", 
			"OpAritSom", "OpAritSub", "OpAritMult", "OpAritDiv", "Var", "Cadeia", 
			"NumInt", "NumReal", "Coment", "EspBranco"
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
	public String getGrammarFileName() { return "GrammarGyh.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private String _varName;
	    private String _varType;
	    private String _varValue;
	    private String _varExp = "";
	    private String _conditional = "";
	    private String _conditionalIf = "";
	    private String _conditionalWhile = "";


	    private ProgramGeneratorGyh program = new ProgramGeneratorGyh();
	    private Symbol _varSymbol;
	    private SymbolTable tableSymbol = new SymbolTable();


	    private ArrayList<Comando> cmdList = new ArrayList<Comando>();
	    private ArrayList<Comando> auxList = new ArrayList<Comando>();
	    private ArrayList<Comando> listTrue = new ArrayList<Comando>();
	    private ArrayList<Comando> listFalse = new ArrayList<Comando>();
	    private ArrayList<Comando> listIf = new ArrayList<Comando>();
	    private ArrayList<Comando> listWhile = new ArrayList<Comando>();
	    private ArrayList<Comando> listElse = new ArrayList<Comando>();


	    public void generateComando(){
	        program.generateTarget();
	    }

	    public SymbolTable getTableSymbol(){
	        return tableSymbol;
	    }

	    public void verificaVariavel(String varName) {
	        if (!tableSymbol.contains(varName)) {
	            throw new RuntimeException("Variável " + varName + " não declarada.");
	        }
	    }

	public GrammarGyhParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramaContext extends ParserRuleContext {
		public List<TerminalNode> Delim() { return getTokens(GrammarGyhParser.Delim); }
		public TerminalNode Delim(int i) {
			return getToken(GrammarGyhParser.Delim, i);
		}
		public TerminalNode PCDec() { return getToken(GrammarGyhParser.PCDec, 0); }
		public ListaDeclaracoesContext listaDeclaracoes() {
			return getRuleContext(ListaDeclaracoesContext.class,0);
		}
		public TerminalNode PCProg() { return getToken(GrammarGyhParser.PCProg, 0); }
		public ListaComandosContext listaComandos() {
			return getRuleContext(ListaComandosContext.class,0);
		}
		public TerminalNode EOF() { return getToken(GrammarGyhParser.EOF, 0); }
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(Delim);
			setState(45);
			match(PCDec);
			setState(46);
			listaDeclaracoes();
			setState(47);
			match(Delim);
			setState(48);
			match(PCProg);
			System.out.println("passeido prog");
			setState(50);
			listaComandos();
			System.out.println("tonalista");
			program.setVarTable(tableSymbol);
			          System.out.println("Programa --->>> VarTabe");
			          program.setComandos(cmdList);
			          System.out.println("Programa --->>> Comandos");
			          program.generateTarget();
			          
			setState(53);
			match(EOF);
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

	public static class ListaDeclaracoesContext extends ParserRuleContext {
		public DeclaracaoContext declaracao() {
			return getRuleContext(DeclaracaoContext.class,0);
		}
		public ListaDeclaracoesContext listaDeclaracoes() {
			return getRuleContext(ListaDeclaracoesContext.class,0);
		}
		public ListaDeclaracoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaDeclaracoes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).enterListaDeclaracoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).exitListaDeclaracoes(this);
		}
	}

	public final ListaDeclaracoesContext listaDeclaracoes() throws RecognitionException {
		ListaDeclaracoesContext _localctx = new ListaDeclaracoesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_listaDeclaracoes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			declaracao();
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Var) {
				{
				setState(56);
				listaDeclaracoes();
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

	public static class DeclaracaoContext extends ParserRuleContext {
		public TerminalNode Var() { return getToken(GrammarGyhParser.Var, 0); }
		public TerminalNode Delim() { return getToken(GrammarGyhParser.Delim, 0); }
		public TipoVarContext tipoVar() {
			return getRuleContext(TipoVarContext.class,0);
		}
		public DeclaracaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).enterDeclaracao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).exitDeclaracao(this);
		}
	}

	public final DeclaracaoContext declaracao() throws RecognitionException {
		DeclaracaoContext _localctx = new DeclaracaoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaracao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(Var);
			setState(60);
			match(Delim);
			setState(61);
			tipoVar();

			             _varName = _input.LT(-3).getText();
			             _varType = _input.LT(-1).getText();
			             _varValue = null;
			             _varSymbol = new Symbol(_varName, _varType, _varValue);
			             if (!tableSymbol.contains(_varName)){
			                    tableSymbol.add(_varSymbol);
			                    System.out.println("Símbolo adicionado " + _varSymbol);
			            } else {
			                    System.out.println("Variável já declarada anteriormente: " + _varName);
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

	public static class TipoVarContext extends ParserRuleContext {
		public TerminalNode PCInt() { return getToken(GrammarGyhParser.PCInt, 0); }
		public TerminalNode PCReal() { return getToken(GrammarGyhParser.PCReal, 0); }
		public TipoVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipoVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).enterTipoVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).exitTipoVar(this);
		}
	}

	public final TipoVarContext tipoVar() throws RecognitionException {
		TipoVarContext _localctx = new TipoVarContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipoVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_la = _input.LA(1);
			if ( !(_la==PCInt || _la==PCReal) ) {
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

	public static class ExpressaoAritmeticaContext extends ParserRuleContext {
		public TermoAritmeticoContext termoAritmetico() {
			return getRuleContext(TermoAritmeticoContext.class,0);
		}
		public ExpressaoAritmeticaCountContext expressaoAritmeticaCount() {
			return getRuleContext(ExpressaoAritmeticaCountContext.class,0);
		}
		public ExpressaoAritmeticaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoAritmetica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).enterExpressaoAritmetica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).exitExpressaoAritmetica(this);
		}
	}

	public final ExpressaoAritmeticaContext expressaoAritmetica() throws RecognitionException {
		ExpressaoAritmeticaContext _localctx = new ExpressaoAritmeticaContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expressaoAritmetica);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			termoAritmetico();
			setState(67);
			expressaoAritmeticaCount();
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

	public static class ExpressaoAritmeticaCountContext extends ParserRuleContext {
		public TerminalNode OpAritSom() { return getToken(GrammarGyhParser.OpAritSom, 0); }
		public TermoAritmeticoContext termoAritmetico() {
			return getRuleContext(TermoAritmeticoContext.class,0);
		}
		public ExpressaoAritmeticaCountContext expressaoAritmeticaCount() {
			return getRuleContext(ExpressaoAritmeticaCountContext.class,0);
		}
		public TerminalNode OpAritSub() { return getToken(GrammarGyhParser.OpAritSub, 0); }
		public ExpressaoAritmeticaCountContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoAritmeticaCount; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).enterExpressaoAritmeticaCount(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).exitExpressaoAritmeticaCount(this);
		}
	}

	public final ExpressaoAritmeticaCountContext expressaoAritmeticaCount() throws RecognitionException {
		ExpressaoAritmeticaCountContext _localctx = new ExpressaoAritmeticaCountContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expressaoAritmeticaCount);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OpAritSom:
				{
				setState(69);
				match(OpAritSom);
				 if (!_varExp.isEmpty()) _varExp += "+"; 
				setState(71);
				termoAritmetico();
				setState(72);
				expressaoAritmeticaCount();
				}
				break;
			case OpAritSub:
				{
				setState(74);
				match(OpAritSub);
				 if (!_varExp.isEmpty()) _varExp += "-"; 
				setState(76);
				termoAritmetico();
				setState(77);
				expressaoAritmeticaCount();
				}
				break;
			case EOF:
			case OpRelMaior:
			case OpRelMenor:
			case OpRelIgual:
			case OpRelDiferente:
			case OpRelMaiorIgual:
			case OpRelMenorIgual:
			case OpBoolE:
			case OpBoolOU:
			case PCSe:
			case PCEntao:
			case PCSenao:
			case PCEnqto:
			case PCIni:
			case PCFim:
			case PCImprimir:
			case PCLer:
			case FechaPar:
			case Var:
				break;
			default:
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

	public static class TermoAritmeticoContext extends ParserRuleContext {
		public FatorAritmeticoContext fatorAritmetico() {
			return getRuleContext(FatorAritmeticoContext.class,0);
		}
		public TermoAritmeticoCountContext termoAritmeticoCount() {
			return getRuleContext(TermoAritmeticoCountContext.class,0);
		}
		public TermoAritmeticoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termoAritmetico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).enterTermoAritmetico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).exitTermoAritmetico(this);
		}
	}

	public final TermoAritmeticoContext termoAritmetico() throws RecognitionException {
		TermoAritmeticoContext _localctx = new TermoAritmeticoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_termoAritmetico);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			fatorAritmetico();
			setState(82);
			termoAritmeticoCount();
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

	public static class TermoAritmeticoCountContext extends ParserRuleContext {
		public TerminalNode OpAritMult() { return getToken(GrammarGyhParser.OpAritMult, 0); }
		public FatorAritmeticoContext fatorAritmetico() {
			return getRuleContext(FatorAritmeticoContext.class,0);
		}
		public TermoAritmeticoCountContext termoAritmeticoCount() {
			return getRuleContext(TermoAritmeticoCountContext.class,0);
		}
		public TerminalNode OpAritDiv() { return getToken(GrammarGyhParser.OpAritDiv, 0); }
		public TermoAritmeticoCountContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termoAritmeticoCount; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).enterTermoAritmeticoCount(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).exitTermoAritmeticoCount(this);
		}
	}

	public final TermoAritmeticoCountContext termoAritmeticoCount() throws RecognitionException {
		TermoAritmeticoCountContext _localctx = new TermoAritmeticoCountContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_termoAritmeticoCount);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OpAritMult:
				{
				setState(84);
				match(OpAritMult);
				  if (!_varExp.isEmpty()) _varExp += "*"; 
				setState(86);
				fatorAritmetico();
				setState(87);
				termoAritmeticoCount();
				}
				break;
			case OpAritDiv:
				{
				setState(89);
				match(OpAritDiv);
				  if (!_varExp.isEmpty()) _varExp += "/"; 
				setState(91);
				fatorAritmetico();
				setState(92);
				termoAritmeticoCount();
				}
				break;
			case EOF:
			case OpRelMaior:
			case OpRelMenor:
			case OpRelIgual:
			case OpRelDiferente:
			case OpRelMaiorIgual:
			case OpRelMenorIgual:
			case OpBoolE:
			case OpBoolOU:
			case PCSe:
			case PCEntao:
			case PCSenao:
			case PCEnqto:
			case PCIni:
			case PCFim:
			case PCImprimir:
			case PCLer:
			case FechaPar:
			case OpAritSom:
			case OpAritSub:
			case Var:
				break;
			default:
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

	public static class FatorAritmeticoContext extends ParserRuleContext {
		public TerminalNode NumInt() { return getToken(GrammarGyhParser.NumInt, 0); }
		public TerminalNode NumReal() { return getToken(GrammarGyhParser.NumReal, 0); }
		public TerminalNode Var() { return getToken(GrammarGyhParser.Var, 0); }
		public TerminalNode AbrePar() { return getToken(GrammarGyhParser.AbrePar, 0); }
		public ExpressaoAritmeticaContext expressaoAritmetica() {
			return getRuleContext(ExpressaoAritmeticaContext.class,0);
		}
		public TerminalNode FechaPar() { return getToken(GrammarGyhParser.FechaPar, 0); }
		public FatorAritmeticoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fatorAritmetico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).enterFatorAritmetico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).exitFatorAritmetico(this);
		}
	}

	public final FatorAritmeticoContext fatorAritmetico() throws RecognitionException {
		FatorAritmeticoContext _localctx = new FatorAritmeticoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_fatorAritmetico);
		try {
			setState(108);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NumInt:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				match(NumInt);
				 _varExp += _input.LT(-1).getText();
				}
				break;
			case NumReal:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				match(NumReal);
				 _varExp += _input.LT(-1).getText();
				}
				break;
			case Var:
				enterOuterAlt(_localctx, 3);
				{
				setState(100);
				match(Var);
				 verificaVariavel(_input.LT(-1).getText()); _varExp += _input.LT(-1).getText(); 
				}
				break;
			case AbrePar:
				enterOuterAlt(_localctx, 4);
				{
				setState(102);
				match(AbrePar);
				 _varExp += "("; 
				setState(104);
				expressaoAritmetica();
				 _varExp += ")"; 
				setState(106);
				match(FechaPar);
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

	public static class ExpressaoRelacionalContext extends ParserRuleContext {
		public TermoRelacionalContext termoRelacional() {
			return getRuleContext(TermoRelacionalContext.class,0);
		}
		public ExpressaoRelacionalCountContext expressaoRelacionalCount() {
			return getRuleContext(ExpressaoRelacionalCountContext.class,0);
		}
		public ExpressaoRelacionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoRelacional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).enterExpressaoRelacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).exitExpressaoRelacional(this);
		}
	}

	public final ExpressaoRelacionalContext expressaoRelacional() throws RecognitionException {
		ExpressaoRelacionalContext _localctx = new ExpressaoRelacionalContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expressaoRelacional);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			termoRelacional();
			setState(111);
			expressaoRelacionalCount();
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

	public static class ExpressaoRelacionalCountContext extends ParserRuleContext {
		public OperadorBooleanoContext operadorBooleano() {
			return getRuleContext(OperadorBooleanoContext.class,0);
		}
		public TermoRelacionalContext termoRelacional() {
			return getRuleContext(TermoRelacionalContext.class,0);
		}
		public ExpressaoRelacionalCountContext expressaoRelacionalCount() {
			return getRuleContext(ExpressaoRelacionalCountContext.class,0);
		}
		public ExpressaoRelacionalCountContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoRelacionalCount; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).enterExpressaoRelacionalCount(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).exitExpressaoRelacionalCount(this);
		}
	}

	public final ExpressaoRelacionalCountContext expressaoRelacionalCount() throws RecognitionException {
		ExpressaoRelacionalCountContext _localctx = new ExpressaoRelacionalCountContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expressaoRelacionalCount);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OpBoolE || _la==OpBoolOU) {
				{
				setState(113);
				operadorBooleano();

				    if (_input.LT(-1).getText().equals("E")) {
				        _conditional += " && ";
				    } else {
				        _conditional += " || ";
				    }

				setState(115);
				termoRelacional();
				setState(116);
				expressaoRelacionalCount();
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

	public static class TermoRelacionalContext extends ParserRuleContext {
		public List<ExpressaoAritmeticaContext> expressaoAritmetica() {
			return getRuleContexts(ExpressaoAritmeticaContext.class);
		}
		public ExpressaoAritmeticaContext expressaoAritmetica(int i) {
			return getRuleContext(ExpressaoAritmeticaContext.class,i);
		}
		public OpRelContext opRel() {
			return getRuleContext(OpRelContext.class,0);
		}
		public TerminalNode AbrePar() { return getToken(GrammarGyhParser.AbrePar, 0); }
		public ExpressaoRelacionalContext expressaoRelacional() {
			return getRuleContext(ExpressaoRelacionalContext.class,0);
		}
		public TerminalNode FechaPar() { return getToken(GrammarGyhParser.FechaPar, 0); }
		public TermoRelacionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termoRelacional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).enterTermoRelacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).exitTermoRelacional(this);
		}
	}

	public final TermoRelacionalContext termoRelacional() throws RecognitionException {
		TermoRelacionalContext _localctx = new TermoRelacionalContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_termoRelacional);
		try {
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				_varExp = "";
				setState(121);
				expressaoAritmetica();
				_conditional += _varExp;
				                                    _varExp = "";
				                                    
				setState(123);
				opRel();
				if(_input.LT(-1).getText().equals(">")){ _conditional += " > "; }
				                       else if(_input.LT(-1).getText().equals("<")){ _conditional += " < "; }
				                       else if(_input.LT(-1).getText().equals("==")){ _conditional += " == "; }
				                       else if(_input.LT(-1).getText().equals("!=")){ _conditional += " != "; }
				                       else if(_input.LT(-1).getText().equals(">=")){ _conditional += " >= "; }
				                       else if(_input.LT(-1).getText().equals("<=")){ _conditional += " <= "; }
				                      
				setState(125);
				expressaoAritmetica();
				_conditional += _varExp;
				                                    _varExp = "";
				                                    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				match(AbrePar);

				                                    _conditional += "(";
				setState(130);
				expressaoRelacional();
				_conditional += ")";
				setState(132);
				match(FechaPar);
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

	public static class OperadorBooleanoContext extends ParserRuleContext {
		public TerminalNode OpBoolE() { return getToken(GrammarGyhParser.OpBoolE, 0); }
		public TerminalNode OpBoolOU() { return getToken(GrammarGyhParser.OpBoolOU, 0); }
		public OperadorBooleanoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operadorBooleano; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).enterOperadorBooleano(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).exitOperadorBooleano(this);
		}
	}

	public final OperadorBooleanoContext operadorBooleano() throws RecognitionException {
		OperadorBooleanoContext _localctx = new OperadorBooleanoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_operadorBooleano);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			_la = _input.LA(1);
			if ( !(_la==OpBoolE || _la==OpBoolOU) ) {
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

	public static class ListaComandosContext extends ParserRuleContext {
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public ListaComandosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaComandos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).enterListaComandos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).exitListaComandos(this);
		}
	}

	public final ListaComandosContext listaComandos() throws RecognitionException {
		ListaComandosContext _localctx = new ListaComandosContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_listaComandos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(138);
				comando();
				 cmdList.addAll(auxList);auxList.clear();
				}
				}
				setState(143); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PCSe) | (1L << PCEnqto) | (1L << PCIni) | (1L << PCImprimir) | (1L << PCLer) | (1L << Var))) != 0) );
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

	public static class ComandoContext extends ParserRuleContext {
		public ComandoAtribuicaoContext comandoAtribuicao() {
			return getRuleContext(ComandoAtribuicaoContext.class,0);
		}
		public ComandoEntradaContext comandoEntrada() {
			return getRuleContext(ComandoEntradaContext.class,0);
		}
		public ComandoSaidaContext comandoSaida() {
			return getRuleContext(ComandoSaidaContext.class,0);
		}
		public ComandoCondicaoContext comandoCondicao() {
			return getRuleContext(ComandoCondicaoContext.class,0);
		}
		public ComandoRepeticaoContext comandoRepeticao() {
			return getRuleContext(ComandoRepeticaoContext.class,0);
		}
		public SubAlgoritmoContext subAlgoritmo() {
			return getRuleContext(SubAlgoritmoContext.class,0);
		}
		public ComandoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comando; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).enterComando(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).exitComando(this);
		}
	}

	public final ComandoContext comando() throws RecognitionException {
		ComandoContext _localctx = new ComandoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_comando);
		try {
			setState(151);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Var:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				comandoAtribuicao();
				}
				break;
			case PCLer:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				comandoEntrada();
				}
				break;
			case PCImprimir:
				enterOuterAlt(_localctx, 3);
				{
				setState(147);
				comandoSaida();
				}
				break;
			case PCSe:
				enterOuterAlt(_localctx, 4);
				{
				setState(148);
				comandoCondicao();
				}
				break;
			case PCEnqto:
				enterOuterAlt(_localctx, 5);
				{
				setState(149);
				comandoRepeticao();
				}
				break;
			case PCIni:
				enterOuterAlt(_localctx, 6);
				{
				setState(150);
				subAlgoritmo();
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

	public static class ComandoAtribuicaoContext extends ParserRuleContext {
		public TerminalNode Var() { return getToken(GrammarGyhParser.Var, 0); }
		public TerminalNode Atrib() { return getToken(GrammarGyhParser.Atrib, 0); }
		public ExpressaoAritmeticaContext expressaoAritmetica() {
			return getRuleContext(ExpressaoAritmeticaContext.class,0);
		}
		public ComandoAtribuicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoAtribuicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).enterComandoAtribuicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).exitComandoAtribuicao(this);
		}
	}

	public final ComandoAtribuicaoContext comandoAtribuicao() throws RecognitionException {
		ComandoAtribuicaoContext _localctx = new ComandoAtribuicaoContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_comandoAtribuicao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			_conditional += _varExp;
			                     _varExp = "";
			                    
			setState(154);
			match(Var);
			_varName = _input.LT(-1).getText();
			                    
			setState(156);
			match(Atrib);
			setState(157);
			expressaoAritmetica();

			                        verificaVariavel(_varName);

			                        Symbol varSymbol = tableSymbol.get(_varName);
			                        String expectedType = varSymbol.getType();

			                        String expressionType = (_varExp.contains(".") ? "REAL" : "INT");

			                        if (!expectedType.equals(expressionType)) {
			                            throw new RuntimeException("Erro semântico: Tipos incompatíveis na atribuição de " + _varExp + " para " + _varName + " (" + expectedType + ").");
			                        }
			                        AtribuicaoCommand cmd = new AtribuicaoCommand(_varName,_varExp);
			                        auxList.add(cmd);
			                    
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

	public static class ComandoEntradaContext extends ParserRuleContext {
		public TerminalNode PCLer() { return getToken(GrammarGyhParser.PCLer, 0); }
		public TerminalNode Var() { return getToken(GrammarGyhParser.Var, 0); }
		public ComandoEntradaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoEntrada; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).enterComandoEntrada(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).exitComandoEntrada(this);
		}
	}

	public final ComandoEntradaContext comandoEntrada() throws RecognitionException {
		ComandoEntradaContext _localctx = new ComandoEntradaContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_comandoEntrada);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(PCLer);
			setState(161);
			match(Var);

			        _varName = _input.LT(-1).getText();
			        ReadCommand cmd = new ReadCommand(_varName,_varType);
			        auxList.add(cmd);
			        System.out.println("Comando de leitura: " + cmd);

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

	public static class ComandoSaidaContext extends ParserRuleContext {
		public TerminalNode PCImprimir() { return getToken(GrammarGyhParser.PCImprimir, 0); }
		public TerminalNode Var() { return getToken(GrammarGyhParser.Var, 0); }
		public TerminalNode Cadeia() { return getToken(GrammarGyhParser.Cadeia, 0); }
		public ComandoSaidaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoSaida; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).enterComandoSaida(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).exitComandoSaida(this);
		}
	}

	public final ComandoSaidaContext comandoSaida() throws RecognitionException {
		ComandoSaidaContext _localctx = new ComandoSaidaContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_comandoSaida);
		try {
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				match(PCImprimir);
				setState(165);
				match(Var);

				                             _varName = _input.LT(-1).getText();
				                             WriteCommand cmd = new WriteCommand(_varName,_varType);
				                             auxList.add(cmd);
				                             System.out.println("Comando de escrita: " + cmd);
				                            
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				match(PCImprimir);
				setState(168);
				match(Cadeia);

				            _varType = "Cadeia";
				            _varName = _input.LT(-1).getText();
				            WriteCommand cmd = new WriteCommand(_varName,_varType);
				            System.out.println("Comando de escrita: " + cmd);
				            auxList.add(cmd);
				            
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

	public static class ComandoCondicaoContext extends ParserRuleContext {
		public TerminalNode PCSe() { return getToken(GrammarGyhParser.PCSe, 0); }
		public ExpressaoRelacionalContext expressaoRelacional() {
			return getRuleContext(ExpressaoRelacionalContext.class,0);
		}
		public TerminalNode PCEntao() { return getToken(GrammarGyhParser.PCEntao, 0); }
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public TerminalNode PCSenao() { return getToken(GrammarGyhParser.PCSenao, 0); }
		public ComandoCondicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoCondicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).enterComandoCondicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).exitComandoCondicao(this);
		}
	}

	public final ComandoCondicaoContext comandoCondicao() throws RecognitionException {
		ComandoCondicaoContext _localctx = new ComandoCondicaoContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_comandoCondicao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(PCSe);

			                     String oldConditional = _conditional;  // ✅ Salva condição externa
			                     _conditional = "";  // Reseta apenas para a condição do SE
			                     listTrue.clear();
			                     listFalse.clear();
			                 
			setState(174);
			expressaoRelacional();

			                     _conditionalIf = _conditional;
			                     _conditional = oldConditional;  // ✅ Restaura condição externa
			                 
			setState(176);
			match(PCEntao);
			setState(177);
			comando();

			                     listTrue.addAll(auxList);
			                     auxList.clear();
			                 
			setState(183);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(179);
				match(PCSenao);
				setState(180);
				comando();

				                     listFalse.addAll(auxList);
				                     auxList.clear();
				                 
				}
				break;
			}

			                     ConditionalCommand cmd = new ConditionalCommand(_conditionalIf, new ArrayList<>(listTrue), new ArrayList<>(listFalse));
			                     auxList.add(cmd);
			                 
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

	public static class ComandoRepeticaoContext extends ParserRuleContext {
		public TerminalNode PCEnqto() { return getToken(GrammarGyhParser.PCEnqto, 0); }
		public ExpressaoRelacionalContext expressaoRelacional() {
			return getRuleContext(ExpressaoRelacionalContext.class,0);
		}
		public ComandoContext comando() {
			return getRuleContext(ComandoContext.class,0);
		}
		public ComandoRepeticaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoRepeticao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).enterComandoRepeticao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).exitComandoRepeticao(this);
		}
	}

	public final ComandoRepeticaoContext comandoRepeticao() throws RecognitionException {
		ComandoRepeticaoContext _localctx = new ComandoRepeticaoContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_comandoRepeticao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(PCEnqto);

			                     String oldConditional = _conditional;  // ✅ Salva condição externa
			                     _conditional = "";  // Reinicia apenas para o ENQTO
			                     listWhile.clear();
			                 
			setState(189);
			expressaoRelacional();

			                     _conditionalWhile = _conditional;
			                     _conditional = oldConditional;  // ✅ Restaura condição externa
			                 
			setState(191);
			comando();

			                     listWhile.addAll(auxList);
			                     auxList.clear();
			                 

			                     LoopCommand cmd = new LoopCommand(_conditionalWhile, new ArrayList<>(listWhile));
			                     auxList.add(cmd);
			                 
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

	public static class SubAlgoritmoContext extends ParserRuleContext {
		public TerminalNode PCIni() { return getToken(GrammarGyhParser.PCIni, 0); }
		public TerminalNode PCFim() { return getToken(GrammarGyhParser.PCFim, 0); }
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public SubAlgoritmoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subAlgoritmo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).enterSubAlgoritmo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).exitSubAlgoritmo(this);
		}
	}

	public final SubAlgoritmoContext subAlgoritmo() throws RecognitionException {
		SubAlgoritmoContext _localctx = new SubAlgoritmoContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_subAlgoritmo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(PCIni);
			setState(197); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(196);
				comando();
				}
				}
				setState(199); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PCSe) | (1L << PCEnqto) | (1L << PCIni) | (1L << PCImprimir) | (1L << PCLer) | (1L << Var))) != 0) );
			setState(201);
			match(PCFim);
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

	public static class OpRelContext extends ParserRuleContext {
		public TerminalNode OpRelMaior() { return getToken(GrammarGyhParser.OpRelMaior, 0); }
		public TerminalNode OpRelMenor() { return getToken(GrammarGyhParser.OpRelMenor, 0); }
		public TerminalNode OpRelIgual() { return getToken(GrammarGyhParser.OpRelIgual, 0); }
		public TerminalNode OpRelDiferente() { return getToken(GrammarGyhParser.OpRelDiferente, 0); }
		public TerminalNode OpRelMaiorIgual() { return getToken(GrammarGyhParser.OpRelMaiorIgual, 0); }
		public TerminalNode OpRelMenorIgual() { return getToken(GrammarGyhParser.OpRelMenorIgual, 0); }
		public OpRelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opRel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).enterOpRel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGyhListener ) ((GrammarGyhListener)listener).exitOpRel(this);
		}
	}

	public final OpRelContext opRel() throws RecognitionException {
		OpRelContext _localctx = new OpRelContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_opRel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OpRelMaior) | (1L << OpRelMenor) | (1L << OpRelIgual) | (1L << OpRelDiferente) | (1L << OpRelMaiorIgual) | (1L << OpRelMenorIgual))) != 0)) ) {
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%\u00d0\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\5\3<\n\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7R\n\7\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\ta\n\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\no\n\n\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\5\fy\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\5\r\u0089\n\r\3\16\3\16\3\17\3\17\3\17\6\17\u0090\n\17\r\17\16\17\u0091"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u009a\n\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00ad"+
		"\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00ba"+
		"\n\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\6\26"+
		"\u00c8\n\26\r\26\16\26\u00c9\3\26\3\26\3\27\3\27\3\27\2\2\30\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\5\4\2\16\16\20\20\3\2\13\f\3\2"+
		"\4\t\2\u00cc\2.\3\2\2\2\49\3\2\2\2\6=\3\2\2\2\bB\3\2\2\2\nD\3\2\2\2\f"+
		"Q\3\2\2\2\16S\3\2\2\2\20`\3\2\2\2\22n\3\2\2\2\24p\3\2\2\2\26x\3\2\2\2"+
		"\30\u0088\3\2\2\2\32\u008a\3\2\2\2\34\u008f\3\2\2\2\36\u0099\3\2\2\2 "+
		"\u009b\3\2\2\2\"\u00a2\3\2\2\2$\u00ac\3\2\2\2&\u00ae\3\2\2\2(\u00bd\3"+
		"\2\2\2*\u00c5\3\2\2\2,\u00cd\3\2\2\2./\7\3\2\2/\60\7\r\2\2\60\61\5\4\3"+
		"\2\61\62\7\3\2\2\62\63\7\17\2\2\63\64\b\2\1\2\64\65\5\34\17\2\65\66\b"+
		"\2\1\2\66\67\b\2\1\2\678\7\2\2\38\3\3\2\2\29;\5\6\4\2:<\5\4\3\2;:\3\2"+
		"\2\2;<\3\2\2\2<\5\3\2\2\2=>\7 \2\2>?\7\3\2\2?@\5\b\5\2@A\b\4\1\2A\7\3"+
		"\2\2\2BC\t\2\2\2C\t\3\2\2\2DE\5\16\b\2EF\5\f\7\2F\13\3\2\2\2GH\7\34\2"+
		"\2HI\b\7\1\2IJ\5\16\b\2JK\5\f\7\2KR\3\2\2\2LM\7\35\2\2MN\b\7\1\2NO\5\16"+
		"\b\2OP\5\f\7\2PR\3\2\2\2QG\3\2\2\2QL\3\2\2\2QR\3\2\2\2R\r\3\2\2\2ST\5"+
		"\22\n\2TU\5\20\t\2U\17\3\2\2\2VW\7\36\2\2WX\b\t\1\2XY\5\22\n\2YZ\5\20"+
		"\t\2Za\3\2\2\2[\\\7\37\2\2\\]\b\t\1\2]^\5\22\n\2^_\5\20\t\2_a\3\2\2\2"+
		"`V\3\2\2\2`[\3\2\2\2`a\3\2\2\2a\21\3\2\2\2bc\7\"\2\2co\b\n\1\2de\7#\2"+
		"\2eo\b\n\1\2fg\7 \2\2go\b\n\1\2hi\7\32\2\2ij\b\n\1\2jk\5\n\6\2kl\b\n\1"+
		"\2lm\7\33\2\2mo\3\2\2\2nb\3\2\2\2nd\3\2\2\2nf\3\2\2\2nh\3\2\2\2o\23\3"+
		"\2\2\2pq\5\30\r\2qr\5\26\f\2r\25\3\2\2\2st\5\32\16\2tu\b\f\1\2uv\5\30"+
		"\r\2vw\5\26\f\2wy\3\2\2\2xs\3\2\2\2xy\3\2\2\2y\27\3\2\2\2z{\b\r\1\2{|"+
		"\5\n\6\2|}\b\r\1\2}~\5,\27\2~\177\b\r\1\2\177\u0080\5\n\6\2\u0080\u0081"+
		"\b\r\1\2\u0081\u0089\3\2\2\2\u0082\u0083\7\32\2\2\u0083\u0084\b\r\1\2"+
		"\u0084\u0085\5\24\13\2\u0085\u0086\b\r\1\2\u0086\u0087\7\33\2\2\u0087"+
		"\u0089\3\2\2\2\u0088z\3\2\2\2\u0088\u0082\3\2\2\2\u0089\31\3\2\2\2\u008a"+
		"\u008b\t\3\2\2\u008b\33\3\2\2\2\u008c\u008d\5\36\20\2\u008d\u008e\b\17"+
		"\1\2\u008e\u0090\3\2\2\2\u008f\u008c\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\35\3\2\2\2\u0093\u009a\5 \21"+
		"\2\u0094\u009a\5\"\22\2\u0095\u009a\5$\23\2\u0096\u009a\5&\24\2\u0097"+
		"\u009a\5(\25\2\u0098\u009a\5*\26\2\u0099\u0093\3\2\2\2\u0099\u0094\3\2"+
		"\2\2\u0099\u0095\3\2\2\2\u0099\u0096\3\2\2\2\u0099\u0097\3\2\2\2\u0099"+
		"\u0098\3\2\2\2\u009a\37\3\2\2\2\u009b\u009c\b\21\1\2\u009c\u009d\7 \2"+
		"\2\u009d\u009e\b\21\1\2\u009e\u009f\7\31\2\2\u009f\u00a0\5\n\6\2\u00a0"+
		"\u00a1\b\21\1\2\u00a1!\3\2\2\2\u00a2\u00a3\7\30\2\2\u00a3\u00a4\7 \2\2"+
		"\u00a4\u00a5\b\22\1\2\u00a5#\3\2\2\2\u00a6\u00a7\7\27\2\2\u00a7\u00a8"+
		"\7 \2\2\u00a8\u00ad\b\23\1\2\u00a9\u00aa\7\27\2\2\u00aa\u00ab\7!\2\2\u00ab"+
		"\u00ad\b\23\1\2\u00ac\u00a6\3\2\2\2\u00ac\u00a9\3\2\2\2\u00ad%\3\2\2\2"+
		"\u00ae\u00af\7\21\2\2\u00af\u00b0\b\24\1\2\u00b0\u00b1\5\24\13\2\u00b1"+
		"\u00b2\b\24\1\2\u00b2\u00b3\7\22\2\2\u00b3\u00b4\5\36\20\2\u00b4\u00b9"+
		"\b\24\1\2\u00b5\u00b6\7\23\2\2\u00b6\u00b7\5\36\20\2\u00b7\u00b8\b\24"+
		"\1\2\u00b8\u00ba\3\2\2\2\u00b9\u00b5\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba"+
		"\u00bb\3\2\2\2\u00bb\u00bc\b\24\1\2\u00bc\'\3\2\2\2\u00bd\u00be\7\24\2"+
		"\2\u00be\u00bf\b\25\1\2\u00bf\u00c0\5\24\13\2\u00c0\u00c1\b\25\1\2\u00c1"+
		"\u00c2\5\36\20\2\u00c2\u00c3\b\25\1\2\u00c3\u00c4\b\25\1\2\u00c4)\3\2"+
		"\2\2\u00c5\u00c7\7\25\2\2\u00c6\u00c8\5\36\20\2\u00c7\u00c6\3\2\2\2\u00c8"+
		"\u00c9\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\3\2"+
		"\2\2\u00cb\u00cc\7\26\2\2\u00cc+\3\2\2\2\u00cd\u00ce\t\4\2\2\u00ce-\3"+
		"\2\2\2\r;Q`nx\u0088\u0091\u0099\u00ac\u00b9\u00c9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}