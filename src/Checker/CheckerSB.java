package Checker;

import generated.ParserUIBaseVisitor;
import generated.ParserUI;

public class CheckerSB extends ParserUIBaseVisitor{
    private IDTableKaio tablaIDs = null;
    public CheckerSB(){
        this.tablaIDs=new IDTableKaio();
    }

    @Override
    public Object visitProgramAST(ParserUI.ProgramASTContext ctx) {
        for( ParserUI.StatementContext ele : ctx.statement())
            visit(ele);
        return null;
    }

    @Override
    public Object visitStatementLET(ParserUI.StatementLETContext ctx) {
        visit(ctx.letStatement());
        return null;
    }

    @Override
    public Object visitStatementRETURN(ParserUI.StatementRETURNContext ctx) {
        visit(ctx.returnStatement());
        return null;
    }

    @Override
    public Object visitStatementEXPRESSION(ParserUI.StatementEXPRESSIONContext ctx) {
        visit(ctx.expressionStatement());
        return null;
    }

    @Override
    public Object visitLetAST(ParserUI.LetASTContext ctx) {
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitReturnAST(ParserUI.ReturnASTContext ctx) {
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitExpressionStatementAST(ParserUI.ExpressionStatementASTContext ctx) {
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitExpressionAST(ParserUI.ExpressionASTContext ctx) {
        visit(ctx.additionExpression());
        visit(ctx.comparison());
        return null;
    }

    @Override
    public Object visitComparisonAST(ParserUI.ComparisonASTContext ctx) {
        for( ParserUI.AdditionExpressionContext ele : ctx.additionExpression())
            visit(ele);
        return null;
    }

    @Override
    public Object visitAdditionExpressionAST(ParserUI.AdditionExpressionASTContext ctx) {
        visit(ctx.multiplicationExpression());
        visit(ctx.additionFactor());
        return null;
    }

    @Override
    public Object visitAddfactorAST(ParserUI.AddfactorASTContext ctx) {
        for( ParserUI.MultiplicationExpressionContext ele : ctx.multiplicationExpression())
            visit(ele);
        return null;
    }

    @Override
    public Object visitMultiplicationExpressionAST(ParserUI.MultiplicationExpressionASTContext ctx) {
        visit(ctx.elementExpression());
        visit(ctx.multiplicationFactor());
        return null;
    }

    @Override
    public Object visitMultifactorAST(ParserUI.MultifactorASTContext ctx) {
        for( ParserUI.ElementExpressionContext ele : ctx.elementExpression())
            visit(ele);
        return null;
    }

    @Override
    public Object visitElementExpressionAST(ParserUI.ElementExpressionASTContext ctx) {
        visit(ctx.primitiveExpression());
        //hacer los if de los otros 2 casos
        return null;
    }

    @Override
    public Object visitElementAccessAST(ParserUI.ElementAccessASTContext ctx) {
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitCallExpressionAST(ParserUI.CallExpressionASTContext ctx) {
        visit(ctx.expressionList());
        return null;
    }

    @Override
    public Object visitPExpNUM(ParserUI.PExpNUMContext ctx) {
        return 1;
    }

    @Override
    public Object visitPExpSTRING(ParserUI.PExpSTRINGContext ctx) {
        return 2;
    }

    @Override
    public Object visitPExpID(ParserUI.PExpIDContext ctx) {
        IDTableKaio.Ident res = tablaIDs.buscar(ctx.ID().getText());
        if (res != null){
            return res.type;
        }
        else
            return -1;
    }

    @Override
    public Object visitPExpTRUE(ParserUI.PExpTRUEContext ctx) {
        return 3;
    }

    @Override
    public Object visitPExpFALSE(ParserUI.PExpFALSEContext ctx) {
        return 4;
    }

    @Override
    public Object visitPExpEXPRESSION(ParserUI.PExpEXPRESSIONContext ctx) {
        return (Integer) visit(ctx.expression());
    }

    @Override
    public Object visitPExpARRAYLITE(ParserUI.PExpARRAYLITEContext ctx) {
        visit(ctx.arrayLiteral());
        return null;
    }

    @Override
    public Object visitPExpARRAYFUNC(ParserUI.PExpARRAYFUNCContext ctx) {
        int asd;
        visit(ctx.arrayFunctions());
        asd = (Integer) visit(ctx.expressionList());
        return null;
    }

    @Override
    public Object visitPExpFUNCLITE(ParserUI.PExpFUNCLITEContext ctx) {
        visit(ctx.functionLiteral());
        return null;
    }

    @Override
    public Object visitPExpHASHLITE(ParserUI.PExpHASHLITEContext ctx) {
        visit(ctx.hashLiteral());
        return null;
    }

    @Override
    public Object visitPExpPRINT(ParserUI.PExpPRINTContext ctx) {
        visit(ctx.printExpression());
        return null;
    }

    @Override
    public Object visitPExpIF(ParserUI.PExpIFContext ctx) {
        visit(ctx.ifExpression());
        return null;
    }

    @Override
    public Object visitArrfunLEN(ParserUI.ArrfunLENContext ctx) {
        return null;
    }

    @Override
    public Object visitArrfunFIRST(ParserUI.ArrfunFIRSTContext ctx) {
        return null;
    }

    @Override
    public Object visitArrfunLAST(ParserUI.ArrfunLASTContext ctx) {
        return null;
    }

    @Override
    public Object visitArrfunREST(ParserUI.ArrfunRESTContext ctx) {
        return null;
    }

    @Override
    public Object visitArrfunPUSH(ParserUI.ArrfunPUSHContext ctx) {
        return null;
    }

    @Override
    public Object visitArrayLiteralAST(ParserUI.ArrayLiteralASTContext ctx) {
        visit(ctx.expressionList());
        return null;
    }

    @Override
    public Object visitFunctionLiteralAST(ParserUI.FunctionLiteralASTContext ctx) {
        visit(ctx.functionParameters());
        visit(ctx.blockStatement());
        return null;
    }

    @Override
    public Object visitFunctionParametersAST(ParserUI.FunctionParametersASTContext ctx) {
        visit(ctx.moreIdentifiers());
        return null;
    }

    @Override
    public Object visitMoreIdentifiersAST(ParserUI.MoreIdentifiersASTContext ctx) {
        /*for( ParserUI.PExpIDContext ele : ctx)
            visit(ele);*/
        return null;
    }

    @Override
    public Object visitHashLiteralAST(ParserUI.HashLiteralASTContext ctx) {
        visit(ctx.LLIZQ());
        visit(ctx.hashContent());
        visit(ctx.moreHashContent());
        visit(ctx.LLDER());
        return null;
    }

    @Override
    public Object visitHashContentAST(ParserUI.HashContentASTContext ctx) {
        //visit(ctx.expression());
        visit(ctx.DPTS());
        //visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitMoreHashContentAST(ParserUI.MoreHashContentASTContext ctx) {
        /*for( ParserUI.MoreHashContentContext ele : ctx.)
            visit(ele);*/
        return null;
    }

    @Override
    public Object visitExpressionListAST(ParserUI.ExpressionListASTContext ctx) {
        visit(ctx.expression());
        visit(ctx.moreExpressions());
        return null;
    }

    @Override
    public Object visitExpressionListNULLAST(ParserUI.ExpressionListNULLASTContext ctx) {
        //visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitMoreExpressionsAST(ParserUI.MoreExpressionsASTContext ctx) {
        /*for( ParserUI.MoreExpressionsContext ele : ctx.multiplicationExpression())
            visit(ele);*/
        return null;
    }

    @Override
    public Object visitPrintExpressionAST(ParserUI.PrintExpressionASTContext ctx) {
        visit(ctx.PUTS());
        visit(ctx.PIZQ());
        visit(ctx.expression());
        visit(ctx.PDER());
        return null;
    }

    @Override
    public Object visitIfExpressionAST(ParserUI.IfExpressionASTContext ctx) {
        visit(ctx.expression());
        //visit(ctx.blockStatement());
        return null;
    }

    @Override
    public Object visitBlockStatementAST(ParserUI.BlockStatementASTContext ctx) {
        for( ParserUI.StatementContext ele : ctx.statement())
            visit(ele);
        return null;
    }
}
