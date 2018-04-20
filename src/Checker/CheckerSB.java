package Checker;

import generated.ParserUIBaseVisitor;
import generated.ParserUI;
import org.antlr.v4.runtime.tree.TerminalNode;

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
        tablaIDs.openScope();
        visit(ctx.letStatement());
        tablaIDs.closeScope();
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
        int tipo=-1;
        tipo = (Integer) visit(ctx.expression());
        // al igual que con las vars se debe buscar en la tabla de IDs para comprobar si la const ya existe
        IDTableKaio.Ident res = tablaIDs.buscar(ctx.ID().getText());
        if(tipo == 4){
            System.out.println("Suave papu, palabra "+ctx.ID().getSymbol().getText()+" reservada");
            return null;
        }
        if (res == null){
            //si no es así, se inserta en la tabla de IDs

            tablaIDs.insertar(ctx.ID().getSymbol(),tipo,ctx);
            return null;
        }
        else{
            System.out.println("Lo sentimos, la var/fun "+ctx.ID().getSymbol().getText()+" ya esta definida");
            return null;
        }
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

        int temp = (int)visit(ctx.additionExpression());


        int temp2 = (int)visit(ctx.comparison());



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

        int t1 = (int)visit(ctx.multiplicationExpression());

        int t2 = (int)visit(ctx.additionFactor());

        if (t1 != t2){
            System.out.println("Tipos incompatibles al realizar la OP de "+ctx.additionFactor().getText());
            return -1;
        }
        else
            if (t1 == 1){
                return  t1;
            }
            else{
                System.out.println("Son del mismo tipo, pero no son INTEGERS");
                return -1;}

    }

    @Override
    public Object visitAddfactorAST(ParserUI.AddfactorASTContext ctx) {
        for( ParserUI.MultiplicationExpressionContext ele : ctx.multiplicationExpression())
            visit(ele);
        return null;


    }

    @Override
    public Object visitMultiplicationExpressionAST(ParserUI.MultiplicationExpressionASTContext ctx) {

        int t1 = (int)visit(ctx.elementExpression());

        int t2 = (int)visit(ctx.multiplicationFactor());

        if (t1 != t2){
            System.out.println("Tipos incompatibles al realizar la OP de "+ctx.multiplicationFactor().getText());
            return -1;
        }
        else
        if (t1 == 1){
            return  t1;
        }
        else{
            System.out.println("Son del mismo tipo, pero no son INTEGERS");
            return -1;}

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
        return 3;
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

        return 4;
    }

    @Override
    public Object visitArrfunFIRST(ParserUI.ArrfunFIRSTContext ctx) {

        return 4;
    }

    @Override
    public Object visitArrfunLAST(ParserUI.ArrfunLASTContext ctx) {

        return 4;
    }

    @Override
    public Object visitArrfunREST(ParserUI.ArrfunRESTContext ctx) {

        return 4;
    }

    @Override
    public Object visitArrfunPUSH(ParserUI.ArrfunPUSHContext ctx) {

        return 4;
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
        for( TerminalNode ele : ctx.ID())
            visit(ele);
        return null;
    }

    @Override
    public Object visitHashLiteralAST(ParserUI.HashLiteralASTContext ctx) {
        visit(ctx.hashContent());
        visit(ctx.moreHashContent());
        return null;
    }

    @Override
    public Object visitHashContentAST(ParserUI.HashContentASTContext ctx) {
        for( ParserUI.ExpressionContext ele : ctx.expression())
            visit(ele);
        return null;
    }

    @Override
    public Object visitMoreHashContentAST(ParserUI.MoreHashContentASTContext ctx) {
        for( ParserUI.HashContentContext ele : ctx.hashContent())
            visit(ele);
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
        visit(ctx.expression());
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
