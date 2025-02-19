// Generated from GrammarGyh.g4 by ANTLR 4.7.2

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarGyhParser}.
 */
public interface GrammarGyhListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarGyhParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(GrammarGyhParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGyhParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(GrammarGyhParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGyhParser#listaDeclaracoes}.
	 * @param ctx the parse tree
	 */
	void enterListaDeclaracoes(GrammarGyhParser.ListaDeclaracoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGyhParser#listaDeclaracoes}.
	 * @param ctx the parse tree
	 */
	void exitListaDeclaracoes(GrammarGyhParser.ListaDeclaracoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGyhParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao(GrammarGyhParser.DeclaracaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGyhParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao(GrammarGyhParser.DeclaracaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGyhParser#tipoVar}.
	 * @param ctx the parse tree
	 */
	void enterTipoVar(GrammarGyhParser.TipoVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGyhParser#tipoVar}.
	 * @param ctx the parse tree
	 */
	void exitTipoVar(GrammarGyhParser.TipoVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGyhParser#expressaoAritmetica}.
	 * @param ctx the parse tree
	 */
	void enterExpressaoAritmetica(GrammarGyhParser.ExpressaoAritmeticaContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGyhParser#expressaoAritmetica}.
	 * @param ctx the parse tree
	 */
	void exitExpressaoAritmetica(GrammarGyhParser.ExpressaoAritmeticaContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGyhParser#expressaoAritmeticaCount}.
	 * @param ctx the parse tree
	 */
	void enterExpressaoAritmeticaCount(GrammarGyhParser.ExpressaoAritmeticaCountContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGyhParser#expressaoAritmeticaCount}.
	 * @param ctx the parse tree
	 */
	void exitExpressaoAritmeticaCount(GrammarGyhParser.ExpressaoAritmeticaCountContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGyhParser#termoAritmetico}.
	 * @param ctx the parse tree
	 */
	void enterTermoAritmetico(GrammarGyhParser.TermoAritmeticoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGyhParser#termoAritmetico}.
	 * @param ctx the parse tree
	 */
	void exitTermoAritmetico(GrammarGyhParser.TermoAritmeticoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGyhParser#termoAritmeticoCount}.
	 * @param ctx the parse tree
	 */
	void enterTermoAritmeticoCount(GrammarGyhParser.TermoAritmeticoCountContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGyhParser#termoAritmeticoCount}.
	 * @param ctx the parse tree
	 */
	void exitTermoAritmeticoCount(GrammarGyhParser.TermoAritmeticoCountContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGyhParser#fatorAritmetico}.
	 * @param ctx the parse tree
	 */
	void enterFatorAritmetico(GrammarGyhParser.FatorAritmeticoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGyhParser#fatorAritmetico}.
	 * @param ctx the parse tree
	 */
	void exitFatorAritmetico(GrammarGyhParser.FatorAritmeticoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGyhParser#expressaoRelacional}.
	 * @param ctx the parse tree
	 */
	void enterExpressaoRelacional(GrammarGyhParser.ExpressaoRelacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGyhParser#expressaoRelacional}.
	 * @param ctx the parse tree
	 */
	void exitExpressaoRelacional(GrammarGyhParser.ExpressaoRelacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGyhParser#expressaoRelacionalCount}.
	 * @param ctx the parse tree
	 */
	void enterExpressaoRelacionalCount(GrammarGyhParser.ExpressaoRelacionalCountContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGyhParser#expressaoRelacionalCount}.
	 * @param ctx the parse tree
	 */
	void exitExpressaoRelacionalCount(GrammarGyhParser.ExpressaoRelacionalCountContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGyhParser#termoRelacional}.
	 * @param ctx the parse tree
	 */
	void enterTermoRelacional(GrammarGyhParser.TermoRelacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGyhParser#termoRelacional}.
	 * @param ctx the parse tree
	 */
	void exitTermoRelacional(GrammarGyhParser.TermoRelacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGyhParser#operadorBooleano}.
	 * @param ctx the parse tree
	 */
	void enterOperadorBooleano(GrammarGyhParser.OperadorBooleanoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGyhParser#operadorBooleano}.
	 * @param ctx the parse tree
	 */
	void exitOperadorBooleano(GrammarGyhParser.OperadorBooleanoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGyhParser#listaComandos}.
	 * @param ctx the parse tree
	 */
	void enterListaComandos(GrammarGyhParser.ListaComandosContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGyhParser#listaComandos}.
	 * @param ctx the parse tree
	 */
	void exitListaComandos(GrammarGyhParser.ListaComandosContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGyhParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterComando(GrammarGyhParser.ComandoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGyhParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitComando(GrammarGyhParser.ComandoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGyhParser#comandoAtribuicao}.
	 * @param ctx the parse tree
	 */
	void enterComandoAtribuicao(GrammarGyhParser.ComandoAtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGyhParser#comandoAtribuicao}.
	 * @param ctx the parse tree
	 */
	void exitComandoAtribuicao(GrammarGyhParser.ComandoAtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGyhParser#comandoEntrada}.
	 * @param ctx the parse tree
	 */
	void enterComandoEntrada(GrammarGyhParser.ComandoEntradaContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGyhParser#comandoEntrada}.
	 * @param ctx the parse tree
	 */
	void exitComandoEntrada(GrammarGyhParser.ComandoEntradaContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGyhParser#comandoSaida}.
	 * @param ctx the parse tree
	 */
	void enterComandoSaida(GrammarGyhParser.ComandoSaidaContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGyhParser#comandoSaida}.
	 * @param ctx the parse tree
	 */
	void exitComandoSaida(GrammarGyhParser.ComandoSaidaContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGyhParser#comandoCondicao}.
	 * @param ctx the parse tree
	 */
	void enterComandoCondicao(GrammarGyhParser.ComandoCondicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGyhParser#comandoCondicao}.
	 * @param ctx the parse tree
	 */
	void exitComandoCondicao(GrammarGyhParser.ComandoCondicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGyhParser#comandoRepeticao}.
	 * @param ctx the parse tree
	 */
	void enterComandoRepeticao(GrammarGyhParser.ComandoRepeticaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGyhParser#comandoRepeticao}.
	 * @param ctx the parse tree
	 */
	void exitComandoRepeticao(GrammarGyhParser.ComandoRepeticaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGyhParser#subAlgoritmo}.
	 * @param ctx the parse tree
	 */
	void enterSubAlgoritmo(GrammarGyhParser.SubAlgoritmoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGyhParser#subAlgoritmo}.
	 * @param ctx the parse tree
	 */
	void exitSubAlgoritmo(GrammarGyhParser.SubAlgoritmoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGyhParser#opRel}.
	 * @param ctx the parse tree
	 */
	void enterOpRel(GrammarGyhParser.OpRelContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGyhParser#opRel}.
	 * @param ctx the parse tree
	 */
	void exitOpRel(GrammarGyhParser.OpRelContext ctx);
}