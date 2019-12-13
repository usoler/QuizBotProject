// Generated from Enquestes.g by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EnquestesParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EnquestesVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EnquestesParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoot(EnquestesParser.RootContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnquestesParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(EnquestesParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnquestesParser#pregunta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPregunta(EnquestesParser.PreguntaContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnquestesParser#phrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhrase(EnquestesParser.PhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnquestesParser#resposta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResposta(EnquestesParser.RespostaContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnquestesParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption(EnquestesParser.OptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnquestesParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem(EnquestesParser.ItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnquestesParser#alternativa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlternativa(EnquestesParser.AlternativaContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnquestesParser#detour}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDetour(EnquestesParser.DetourContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnquestesParser#enquesta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnquesta(EnquestesParser.EnquestaContext ctx);
}