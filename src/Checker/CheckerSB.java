package Checker;

import generated.ParserUIBaseVisitor;
import generated.ParserUI;
import org.antlr.v4.runtime.tree.TerminalNode;

public class CheckerSB extends ParserUIBaseVisitor{
    private IDTableKaio tablaIDs = null;
    public static final int T_NULL = 0, T_ERROR = -1, T_INT = 1, T_STRING = 2, T_BOOLEAN = 3, T_ARRAY = 4, T_HASH = 5;
    public CheckerSB(){
        this.tablaIDs=new IDTableKaio();
    }

    @Override
    public Object visitProgramAST(ParserUI.ProgramASTContext ctx) {
        tablaIDs.openScope();
        //System.out.println("Jafeth + "+ ctx.statement().size());
        for( ParserUI.StatementContext ele : ctx.statement()){

            visit(ele);
            }
        tablaIDs.closeScope();
        return null;
    }

    @Override
    public Object visitStatementLET(ParserUI.StatementLETContext ctx) {
        //System.out.println("asdakhsd");
        //System.out.println("LET + "+ ctx.getText());

        visit(ctx.letStatement());
        tablaIDs.imprimir();


        return null;
    }

    @Override
    public Object visitStatementRETURN(ParserUI.StatementRETURNContext ctx) {
        visit(ctx.returnStatement());
        return null;
        // Preguntar!!!!
        /*int tipo = (int) visit(ctx.returnStatement());
        return tipo; */
    }

    @Override
    public Object visitStatementEXPRESSION(ParserUI.StatementEXPRESSIONContext ctx) {
        visit(ctx.expressionStatement());
        return null;
    }

    @Override
    public Object visitLetAST(ParserUI.LetASTContext ctx) {
        int tipo;
        //System.out.println("Aqui pase... XD");
        tipo = (int) visit(ctx.expression());
        // al igual que con las vars se debe buscar en la tabla de IDs para comprobar si la const ya existe
        IDTableKaio.Ident res = tablaIDs.buscar(ctx.ID().getText());
        if(tipo == 4){
            System.out.println("Suave papu, palabra "+ctx.ID().getSymbol().getText()+" reservada");
            return null;
        }
        if (res == null){
            //si no es así, se inserta en la tabla de IDs

            tablaIDs.insertar(ctx.ID().getSymbol(),tipo,ctx);
            //visit(ctx.expression());
            return null;
        }
        else{
            System.out.println("Lo sentimos, la var/fun "+ctx.ID().getSymbol().getText()+" ya esta definida");
            return null;
        }
    }

    @Override
    public Object visitReturnAST(ParserUI.ReturnASTContext ctx) {
        /*int tipo;
        //System.out.println("Aqui pase... XD");
        tipo = (int) visit(ctx.expression());
         ESTO POR SI ACASO...
        return tipo;*/
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

        System.out.println("Texto en el expresion:"+ctx.getText());
        int temp2 = (int)visit(ctx.comparison());

        if(temp2 == T_NULL)
            return temp;
        else if(temp == T_ERROR || temp2== T_ERROR){
            System.out.println("Que cansado2");
            return T_ERROR;
        }

        else if(temp != temp2){
            System.out.println("Tipos de operación incompatibles");
            return T_ERROR;
        }


        else if (temp == temp2)
            return temp;
        else {
            System.out.println("Que cansado");
            return T_ERROR;
        }
    }

    @Override
    public Object visitComparisonAST(ParserUI.ComparisonASTContext ctx) {
        if(ctx.additionExpression().size()==0) {
            return T_NULL;
        }
        int type1 = (int)visit(ctx.additionExpression(0));
        boolean isAssignation = ctx.additionExpression().size() == ctx.EQU().size();
            for(ParserUI.AdditionExpressionContext ele: ctx.additionExpression()){
                int type2 = (int)visit(ele);
                if(type2 == T_ERROR){
                    return T_ERROR;
                }
                else if(type2 != type1 || (!isAssignation && type1 != T_INT))
                    System.out.println("Tipos no Comparables");
                    return T_ERROR;
            }
            return T_BOOLEAN;
    }

    @Override
    public Object visitAdditionExpressionAST(ParserUI.AdditionExpressionASTContext ctx) {

        int t1 = (int)visit(ctx.multiplicationExpression());

        int t2 = (int)visit(ctx.additionFactor());
        //System.out.println("T1="+t1);
        //System.out.println("T2="+t2);
        if ((t1 != t2) && (t2 != T_NULL)){
            System.out.println("Tipos incompatibles al realizar la OP de "+ctx.additionFactor().getText());
            return T_ERROR;
        }
        else
            if ((t1 == 1) || (t2 == T_NULL)){
                return  t1;
            }
            else{
                System.out.println("Son del mismo tipo, pero no son INTEGERS");
                return T_ERROR;}

    }

    @Override
    public Object visitAddfactorAST(ParserUI.AddfactorASTContext ctx) {
        //System.out.println("hola?"+ctx.multiplicationExpression().size());
        if (ctx.multiplicationExpression().size() == 0)
            return T_NULL;
        int temp = (int)visit(ctx.multiplicationExpression(0)), temp2;
        //System.out.println("AF="+temp);
        for (ParserUI.MultiplicationExpressionContext i:
                ctx.multiplicationExpression()) {
            temp2 = (int)visit(i);
            //System.out.println("AF2="+temp2);
            if (temp != temp2) {
                return T_ERROR;
            }
        }
        return temp;


    }

    @Override
    public Object visitMultiplicationExpressionAST(ParserUI.MultiplicationExpressionASTContext ctx) {

        int t1 = (int)visit(ctx.elementExpression());

        int t2 = (int)visit(ctx.multiplicationFactor());

        //System.out.println("asd"+t1);
        //System.out.println("dsa"+t2);

        if ((t1 != t2) && (t2 != T_NULL)){
            System.out.println("Tipos incompatibles al realizar la OP de "+ctx.multiplicationFactor().getText());
            return T_ERROR;
        }
        else
            if ((t1 == 1) || (t2 == T_NULL)){
                return  t1;
            }
            else{
                System.out.println("Son del mismo tipo, pero no son INTEGERS");
                return T_ERROR;}

    }

    @Override
    public Object visitMultifactorAST(ParserUI.MultifactorASTContext ctx) {
       // System.out.println("hola2?"+ctx.elementExpression().size());
        if (ctx.elementExpression().size() == 0)
            return T_NULL;
        int temp = (int)visit(ctx.elementExpression(0)), temp2;
        //System.out.println("MF="+temp);
        for (ParserUI.ElementExpressionContext i:
                ctx.elementExpression()) {
            temp2 = (int)visit(i);
            //System.out.println("MF2="+temp2);
            if (temp != temp2) {
                return T_ERROR;
            }
        }
        return temp;
    }

    @Override
    public Object visitElementExpressionAST(ParserUI.ElementExpressionASTContext ctx) {
        //System.out.println("Primitive expression "+ctx.primitiveExpression());
        //System.out.println(ctx.primitiveExpression().getText());
        int i = (int) visit(ctx.primitiveExpression());
        //System.out.println("PE = "+i);
        //hacer los if de los otros 2 casos
        return i;
    }

    @Override
    public Object visitElementAccessAST(ParserUI.ElementAccessASTContext ctx) {
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitCallExpressionAST(ParserUI.CallExpressionASTContext ctx) {
        visit(ctx.expressionList());
        return T_NULL;
    }

    @Override
    public Object visitPExpNUM(ParserUI.PExpNUMContext ctx) {
        return T_INT;
    }

    @Override
    public Object visitPExpSTRING(ParserUI.PExpSTRINGContext ctx) {
        return T_STRING;
    }

    @Override
    public Object visitPExpID(ParserUI.PExpIDContext ctx) {
        IDTableKaio.Ident res = tablaIDs.buscar(ctx.ID().getText());
        if (res != null){
            //System.out.println("tipo del primary expression "+res.type);
            return res.type;
        }
        else
            return T_NULL;
    }

    @Override
    public Object visitPExpTRUE(ParserUI.PExpTRUEContext ctx) {
        return T_BOOLEAN;
    }

    @Override
    public Object visitPExpFALSE(ParserUI.PExpFALSEContext ctx) {
        return T_BOOLEAN;
    }

    @Override
    public Object visitPExpEXPRESSION(ParserUI.PExpEXPRESSIONContext ctx) {
        return visit(ctx.expression());
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
        int tipo = (int)visit(ctx.hashLiteral());
        return tipo;
    }

    @Override
    public Object visitPExpPRINT(ParserUI.PExpPRINTContext ctx) {
        int tipo = (int)visit(ctx.printExpression());
        return tipo;
    }

    @Override
    public Object visitPExpIF(ParserUI.PExpIFContext ctx) {
        visit(ctx.ifExpression());
        return T_NULL;
    }

    @Override
    public Object visitArrfunLEN(ParserUI.ArrfunLENContext ctx) {

        return T_ARRAY;
    }

    @Override
    public Object visitArrfunFIRST(ParserUI.ArrfunFIRSTContext ctx) {

        return T_ARRAY;
    }

    @Override
    public Object visitArrfunLAST(ParserUI.ArrfunLASTContext ctx) {

        return T_ARRAY;
    }

    @Override
    public Object visitArrfunREST(ParserUI.ArrfunRESTContext ctx) {

        return T_ARRAY;
    }

    @Override
    public Object visitArrfunPUSH(ParserUI.ArrfunPUSHContext ctx) {

        return T_ARRAY;
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
        int t1 = (int) visit(ctx.hashContent());
        int t2 = (int)visit(ctx.moreHashContent());
        if ((t1 == T_HASH) && (t2 == T_HASH))
            return T_HASH;
        return T_ERROR;
    }

    @Override
    public Object visitHashContentAST(ParserUI.HashContentASTContext ctx) {
        int tipo;
        for( ParserUI.ExpressionContext ele : ctx.expression()){
            tipo = (int)visit(ele);
            if (tipo == T_ERROR) {
                System.out.println("Tipo no valido en el hash");
                return T_ERROR;
            }
        }
        return T_HASH;
    }

    @Override
    public Object visitMoreHashContentAST(ParserUI.MoreHashContentASTContext ctx) {
        int tipo = T_NULL;
        for( ParserUI.HashContentContext ele : ctx.hashContent()) {
            tipo = (int) visit(ele);
            if (tipo == T_ERROR) {
                System.out.println("Tipo no valido en el hash");
                return T_ERROR;
            }
        }
        return tipo;
    }

    @Override
    public Object visitExpressionListAST(ParserUI.ExpressionListASTContext ctx) {
        visit(ctx.expression());
        visit(ctx.moreExpressions());
        return null;
    }

    @Override
    public Object visitExpressionListNULLAST(ParserUI.ExpressionListNULLASTContext ctx) {
        return T_NULL;
    }

    @Override
    public Object visitMoreExpressionsAST(ParserUI.MoreExpressionsASTContext ctx) {
        for( ParserUI.ExpressionContext ele : ctx.expression()) {
            visit(ele);
        }
        return null;
    }

    @Override
    public Object visitPrintExpressionAST(ParserUI.PrintExpressionASTContext ctx) {
        //REVISAR TABLA IDS PARA VER SI ESTA DEFINIDA LA VARA!!!
        //O ES UN TIPO SIMPLE!!!
        IDTableKaio.Ident res = tablaIDs.buscar(ctx.getText().substring(5,ctx.getText().length()-1));
        int tipo = (int) visit(ctx.expression());
        if (res == null){
            //si no es así, se inserta en la tabla de IDs

            if(tipo > 0){
                System.out.println("Si se imprime la expresion simple: "+ctx.getText().substring(5,ctx.getText().length()-1));
                return tipo;
            }
            System.out.println("Tipo no valido O Var no definida para imprimir");
            return T_ERROR;
        }
        else{
            System.out.println("Si se imprime la var: "+ctx.getText().substring(5,ctx.getText().length()-1));
            return tipo;
        }
    }

    @Override
    public Object visitIfExpressionAST(ParserUI.IfExpressionASTContext ctx) {
        if(((int)visit(ctx.expression())==T_BOOLEAN) || (((int)visit(ctx.expression())==T_NULL))) {
            if ((ctx.expression().toStringTree().contains("TRUE")) || (ctx.expression().toStringTree().contains("true"))){
                System.out.println("Joder!");
                return visit(ctx.blockStatement(0));
            }
            else{
                System.out.println("Demonios!");
                return visit(ctx.blockStatement(1));
            }
        }else System.out.println("Boolean expression expected");
        return null;
    }

    @Override
    public Object visitBlockStatementAST(ParserUI.BlockStatementASTContext ctx) {
        for( ParserUI.StatementContext ele : ctx.statement())
            visit(ele);
        return null;
    }
}
