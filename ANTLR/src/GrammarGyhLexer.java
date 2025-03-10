// Generated from GrammarGyh.g4 by ANTLR 4.7.2

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarGyhLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"Delim", "OpRelMaior", "OpRelMenor", "OpRelIgual", "OpRelDiferente", 
			"OpRelMaiorIgual", "OpRelMenorIgual", "Terminal", "OpBoolE", "OpBoolOU", 
			"PCDec", "PCInt", "PCProg", "PCReal", "PCSe", "PCEntao", "PCSenao", "PCEnqto", 
			"PCIni", "PCFim", "PCImprimir", "PCLer", "Atrib", "AbrePar", "FechaPar", 
			"OpAritSom", "OpAritSub", "OpAritMult", "OpAritDiv", "Var", "Cadeia", 
			"NumInt", "NumReal", "Coment", "EspBranco"
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


	public GrammarGyhLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GrammarGyh.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2%\u00dd\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3"+
		"\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3"+
		"\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3"+
		"\35\3\36\3\36\3\37\3\37\7\37\u00b2\n\37\f\37\16\37\u00b5\13\37\3 \3 \7"+
		" \u00b9\n \f \16 \u00bc\13 \3 \3 \3!\6!\u00c1\n!\r!\16!\u00c2\3\"\6\""+
		"\u00c6\n\"\r\"\16\"\u00c7\3\"\3\"\7\"\u00cc\n\"\f\"\16\"\u00cf\13\"\3"+
		"#\3#\7#\u00d3\n#\f#\16#\u00d6\13#\3#\3#\3$\3$\3$\3$\2\2%\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%\3\2\b\3\2c|\5\2\62;C\\c|\7\2\"#((\62;C\\c|\3\2\62;\4\2\f\f\17\17\5\2"+
		"\13\f\17\17\"\"\2\u00e2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\3I\3\2\2\2\5K\3\2\2\2\7M\3\2\2\2\tO\3\2\2\2\13"+
		"R\3\2\2\2\rU\3\2\2\2\17X\3\2\2\2\21[\3\2\2\2\23_\3\2\2\2\25a\3\2\2\2\27"+
		"d\3\2\2\2\31h\3\2\2\2\33l\3\2\2\2\35q\3\2\2\2\37v\3\2\2\2!y\3\2\2\2#\177"+
		"\3\2\2\2%\u0085\3\2\2\2\'\u008b\3\2\2\2)\u008f\3\2\2\2+\u0093\3\2\2\2"+
		"-\u009c\3\2\2\2/\u00a0\3\2\2\2\61\u00a3\3\2\2\2\63\u00a5\3\2\2\2\65\u00a7"+
		"\3\2\2\2\67\u00a9\3\2\2\29\u00ab\3\2\2\2;\u00ad\3\2\2\2=\u00af\3\2\2\2"+
		"?\u00b6\3\2\2\2A\u00c0\3\2\2\2C\u00c5\3\2\2\2E\u00d0\3\2\2\2G\u00d9\3"+
		"\2\2\2IJ\7<\2\2J\4\3\2\2\2KL\7@\2\2L\6\3\2\2\2MN\7>\2\2N\b\3\2\2\2OP\7"+
		"?\2\2PQ\7?\2\2Q\n\3\2\2\2RS\7#\2\2ST\7?\2\2T\f\3\2\2\2UV\7@\2\2VW\7?\2"+
		"\2W\16\3\2\2\2XY\7>\2\2YZ\7?\2\2Z\20\3\2\2\2[\\\7=\2\2\\]\3\2\2\2]^\b"+
		"\t\2\2^\22\3\2\2\2_`\7G\2\2`\24\3\2\2\2ab\7Q\2\2bc\7W\2\2c\26\3\2\2\2"+
		"de\7F\2\2ef\7G\2\2fg\7E\2\2g\30\3\2\2\2hi\7K\2\2ij\7P\2\2jk\7V\2\2k\32"+
		"\3\2\2\2lm\7R\2\2mn\7T\2\2no\7Q\2\2op\7I\2\2p\34\3\2\2\2qr\7T\2\2rs\7"+
		"G\2\2st\7C\2\2tu\7N\2\2u\36\3\2\2\2vw\7U\2\2wx\7G\2\2x \3\2\2\2yz\7G\2"+
		"\2z{\7P\2\2{|\7V\2\2|}\7C\2\2}~\7Q\2\2~\"\3\2\2\2\177\u0080\7U\2\2\u0080"+
		"\u0081\7G\2\2\u0081\u0082\7P\2\2\u0082\u0083\7C\2\2\u0083\u0084\7Q\2\2"+
		"\u0084$\3\2\2\2\u0085\u0086\7G\2\2\u0086\u0087\7P\2\2\u0087\u0088\7S\2"+
		"\2\u0088\u0089\7V\2\2\u0089\u008a\7Q\2\2\u008a&\3\2\2\2\u008b\u008c\7"+
		"K\2\2\u008c\u008d\7P\2\2\u008d\u008e\7K\2\2\u008e(\3\2\2\2\u008f\u0090"+
		"\7H\2\2\u0090\u0091\7K\2\2\u0091\u0092\7O\2\2\u0092*\3\2\2\2\u0093\u0094"+
		"\7K\2\2\u0094\u0095\7O\2\2\u0095\u0096\7R\2\2\u0096\u0097\7T\2\2\u0097"+
		"\u0098\7K\2\2\u0098\u0099\7O\2\2\u0099\u009a\7K\2\2\u009a\u009b\7T\2\2"+
		"\u009b,\3\2\2\2\u009c\u009d\7N\2\2\u009d\u009e\7G\2\2\u009e\u009f\7T\2"+
		"\2\u009f.\3\2\2\2\u00a0\u00a1\7<\2\2\u00a1\u00a2\7?\2\2\u00a2\60\3\2\2"+
		"\2\u00a3\u00a4\7*\2\2\u00a4\62\3\2\2\2\u00a5\u00a6\7+\2\2\u00a6\64\3\2"+
		"\2\2\u00a7\u00a8\7-\2\2\u00a8\66\3\2\2\2\u00a9\u00aa\7/\2\2\u00aa8\3\2"+
		"\2\2\u00ab\u00ac\7,\2\2\u00ac:\3\2\2\2\u00ad\u00ae\7\61\2\2\u00ae<\3\2"+
		"\2\2\u00af\u00b3\t\2\2\2\u00b0\u00b2\t\3\2\2\u00b1\u00b0\3\2\2\2\u00b2"+
		"\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4>\3\2\2\2"+
		"\u00b5\u00b3\3\2\2\2\u00b6\u00ba\7$\2\2\u00b7\u00b9\t\4\2\2\u00b8\u00b7"+
		"\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb"+
		"\u00bd\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00be\7$\2\2\u00be@\3\2\2\2\u00bf"+
		"\u00c1\t\5\2\2\u00c0\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c0\3\2"+
		"\2\2\u00c2\u00c3\3\2\2\2\u00c3B\3\2\2\2\u00c4\u00c6\t\5\2\2\u00c5\u00c4"+
		"\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8"+
		"\u00c9\3\2\2\2\u00c9\u00cd\7\60\2\2\u00ca\u00cc\t\5\2\2\u00cb\u00ca\3"+
		"\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce"+
		"D\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d4\7%\2\2\u00d1\u00d3\n\6\2\2\u00d2"+
		"\u00d1\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2"+
		"\2\2\u00d5\u00d7\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00d8\b#\2\2\u00d8"+
		"F\3\2\2\2\u00d9\u00da\t\7\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\b$\2\2\u00dc"+
		"H\3\2\2\2\13\2\u00b1\u00b3\u00b8\u00ba\u00c2\u00c7\u00cd\u00d4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}