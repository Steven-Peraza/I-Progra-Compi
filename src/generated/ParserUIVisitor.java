// Generated from /Users/jafethvasquez/proyectosPersonales/PrograCompi/ParserUI.g4 by ANTLR 4.7
package generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ParserUI}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ParserUIVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code programAST}
	 * labeled alternative in {@link ParserUI#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramAST(ParserUI.ProgramASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementLET}
	 * labeled alternative in {@link ParserUI#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementLET(ParserUI.StatementLETContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementRETURN}
	 * labeled alternative in {@link ParserUI#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementRETURN(ParserUI.StatementRETURNContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementEXPRESSION}
	 * labeled alternative in {@link ParserUI#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementEXPRESSION(ParserUI.StatementEXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code letAST}
	 * labeled alternative in {@link ParserUI#letStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetAST(ParserUI.LetASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnAST}
	 * labeled alternative in {@link ParserUI#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnAST(ParserUI.ReturnASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionStatementAST}
	 * labeled alternative in {@link ParserUI#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatementAST(ParserUI.ExpressionStatementASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionAST}
	 * labeled alternative in {@link ParserUI#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAST(ParserUI.ExpressionASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparisonAST}
	 * labeled alternative in {@link ParserUI#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonAST(ParserUI.ComparisonASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code additionExpressionAST}
	 * labeled alternative in {@link ParserUI#additionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionExpressionAST(ParserUI.AdditionExpressionASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addfactorAST}
	 * labeled alternative in {@link ParserUI#additionFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddfactorAST(ParserUI.AddfactorASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplicationExpressionAST}
	 * labeled alternative in {@link ParserUI#multiplicationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpressionAST(ParserUI.MultiplicationExpressionASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multifactorAST}
	 * labeled alternative in {@link ParserUI#multiplicationFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultifactorAST(ParserUI.MultifactorASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code elementExpressionAST}
	 * labeled alternative in {@link ParserUI#elementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementExpressionAST(ParserUI.ElementExpressionASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code elementAccessAST}
	 * labeled alternative in {@link ParserUI#elementAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementAccessAST(ParserUI.ElementAccessASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callExpressionAST}
	 * labeled alternative in {@link ParserUI#callExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpressionAST(ParserUI.CallExpressionASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pExpNUM}
	 * labeled alternative in {@link ParserUI#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPExpNUM(ParserUI.PExpNUMContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pExpSTRING}
	 * labeled alternative in {@link ParserUI#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPExpSTRING(ParserUI.PExpSTRINGContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pExpID}
	 * labeled alternative in {@link ParserUI#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPExpID(ParserUI.PExpIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pExpTRUE}
	 * labeled alternative in {@link ParserUI#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPExpTRUE(ParserUI.PExpTRUEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pExpFALSE}
	 * labeled alternative in {@link ParserUI#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPExpFALSE(ParserUI.PExpFALSEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pExpEXPRESSION}
	 * labeled alternative in {@link ParserUI#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPExpEXPRESSION(ParserUI.PExpEXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pExpARRAYLITE}
	 * labeled alternative in {@link ParserUI#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPExpARRAYLITE(ParserUI.PExpARRAYLITEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pExpARRAYFUNC}
	 * labeled alternative in {@link ParserUI#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPExpARRAYFUNC(ParserUI.PExpARRAYFUNCContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pExpFUNCLITE}
	 * labeled alternative in {@link ParserUI#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPExpFUNCLITE(ParserUI.PExpFUNCLITEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pExpHASHLITE}
	 * labeled alternative in {@link ParserUI#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPExpHASHLITE(ParserUI.PExpHASHLITEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pExpPRINT}
	 * labeled alternative in {@link ParserUI#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPExpPRINT(ParserUI.PExpPRINTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pExpIF}
	 * labeled alternative in {@link ParserUI#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPExpIF(ParserUI.PExpIFContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrfunLEN}
	 * labeled alternative in {@link ParserUI#arrayFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrfunLEN(ParserUI.ArrfunLENContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrfunFIRST}
	 * labeled alternative in {@link ParserUI#arrayFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrfunFIRST(ParserUI.ArrfunFIRSTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrfunLAST}
	 * labeled alternative in {@link ParserUI#arrayFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrfunLAST(ParserUI.ArrfunLASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrfunREST}
	 * labeled alternative in {@link ParserUI#arrayFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrfunREST(ParserUI.ArrfunRESTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrfunPUSH}
	 * labeled alternative in {@link ParserUI#arrayFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrfunPUSH(ParserUI.ArrfunPUSHContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayLiteralAST}
	 * labeled alternative in {@link ParserUI#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteralAST(ParserUI.ArrayLiteralASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionLiteralAST}
	 * labeled alternative in {@link ParserUI#functionLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionLiteralAST(ParserUI.FunctionLiteralASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionParametersAST}
	 * labeled alternative in {@link ParserUI#functionParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParametersAST(ParserUI.FunctionParametersASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code moreIdentifiersAST}
	 * labeled alternative in {@link ParserUI#moreIdentifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoreIdentifiersAST(ParserUI.MoreIdentifiersASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code hashLiteralAST}
	 * labeled alternative in {@link ParserUI#hashLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHashLiteralAST(ParserUI.HashLiteralASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code hashContentAST}
	 * labeled alternative in {@link ParserUI#hashContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHashContentAST(ParserUI.HashContentASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code moreHashContentAST}
	 * labeled alternative in {@link ParserUI#moreHashContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoreHashContentAST(ParserUI.MoreHashContentASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionListAST}
	 * labeled alternative in {@link ParserUI#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionListAST(ParserUI.ExpressionListASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionListNULLAST}
	 * labeled alternative in {@link ParserUI#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionListNULLAST(ParserUI.ExpressionListNULLASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code moreExpressionsAST}
	 * labeled alternative in {@link ParserUI#moreExpressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoreExpressionsAST(ParserUI.MoreExpressionsASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printExpressionAST}
	 * labeled alternative in {@link ParserUI#printExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintExpressionAST(ParserUI.PrintExpressionASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifExpressionAST}
	 * labeled alternative in {@link ParserUI#ifExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExpressionAST(ParserUI.IfExpressionASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockStatementAST}
	 * labeled alternative in {@link ParserUI#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatementAST(ParserUI.BlockStatementASTContext ctx);
}