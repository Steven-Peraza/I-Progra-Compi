package Checker;

import generated.ParserUIBaseVisitor;
import generated.ParserUI;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.LinkedList;

public class CheckerSB extends ParserUIBaseVisitor{
    private IDTableKaio tablaIDs = null;
    public static final int T_NULL = 0, T_ERROR = -1, T_INT = 1, T_STRING = 2, T_BOOLEAN = 3, T_ARRAY = 4, T_HASH = 5, T_RESER = 6, T_FUNC = 7;
    public CheckerSB(){
        this.tablaIDs=new IDTableKaio();
    }


    @Override
    public Object visitProgramAST(ParserUI.ProgramASTContext ctx) {
        tablaIDs.openScope();
        System.out.println("Jafeth + "+ ctx.statement().size());
        for( ParserUI.StatementContext ele : ctx.statement()){

            visit(ele);
            }
        tablaIDs.closeScope();
        return null;
    }

    @Override
    public Object visitStatementLET(ParserUI.StatementLETContext ctx) {
        //System.out.println("asdakhsd");
        System.out.println("LET + "+ ctx.getText());

        visit(ctx.letStatement());
        tablaIDs.imprimir();


        return null;
    }

    @Override
    public Object visitStatementRETURN(ParserUI.StatementRETURNContext ctx) {
        System.out.println("RETURN + "+ctx.getText());
        visit(ctx.returnStatement());
        return null;
        // Preguntar!!!!
        /*int tipo = (int) visit(ctx.returnStatement());
        return tipo;*/
    }

    @Override
    public Object visitStatementEXPRESSION(ParserUI.StatementEXPRESSIONContext ctx) {
        System.out.println("EXP STATE + "+ ctx.getText());
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
        if(tipo == T_RESER){
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
         //ESTO POR SI ACASO...
        return tipo;*/
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitExpressionStatementAST(ParserUI.ExpressionStatementASTContext ctx) {

        return visit(ctx.expression());
    }

    @Override
    public Object visitExpressionAST(ParserUI.ExpressionASTContext ctx) {

        int temp = (int)visit(ctx.additionExpression());

        //System.out.println("Texto en el expresion:"+ctx.getText());
        int temp2 = (int)visit(ctx.comparison());
        System.out.println(temp);
        System.out.println(temp2);
        if(temp2 == T_NULL)
            return temp;
        else if(temp == T_ERROR || temp2== T_ERROR){
            System.out.println("Que cansado2");
            return T_ERROR;
        }
        else if (temp2 == T_BOOLEAN)
            return T_BOOLEAN;
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
        //System.out.println("C1="+type1);
        boolean isAssignation = ctx.additionExpression().size() == ctx.EQU().size();
        //System.out.println("ASS="+isAssignation);
        for(ParserUI.AdditionExpressionContext ele: ctx.additionExpression()){
                int type2 = (int)visit(ele);
                System.out.println("C2="+type2);
                if(type2 == T_ERROR){
                    return T_ERROR;
                }
                else if(type2 != type1 || (!isAssignation && type1 != T_INT)){
                    System.out.println("Tipos no Comparables");
                    return T_ERROR;}
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

        IDTableKaio.Ident res = tablaIDs.buscar(ctx.primitiveExpression().getText());
        int i = (int) visit(ctx.primitiveExpression());
        System.out.println("gg wp "+i);
        System.out.println("res "+res);
        int p = T_NULL ,o = T_NULL;
        if ((ctx.elementAccess() != null) && (res != null)){
            System.out.println("gasf "+ctx.getText());
            p = (int) visit(ctx.elementAccess());
            if (p == T_INT){
                if ((i == T_ARRAY) || (i == T_HASH)){
                    System.out.println("Lo hice?");
                    return T_NULL;
                }
                else
                {
                    System.out.println("Se está tratando de accesar a un tipo que no es Array");
                    return T_ERROR;
                }
            }
            else if (p != T_NULL){
                System.out.println("Se requiere un tipo Integer para realizar indexaciones");
                return T_ERROR;
            }
        }
        else if ((ctx.elementAccess() != null) && (res == null))
        {
            System.out.println("Estais tratando de acceder a una variable no definida...");
        }
        if ((ctx.callExpression() != null) && (res != null)){
            o = (int) visit(ctx.callExpression());
            if (o == 8){
                System.out.println("Lo hice?");
                return T_NULL;
            }
            else
            {
                System.out.println("Se está tratando de accesar a un tipo que no es Array");
                return T_ERROR;
            }


        }
        else if ((ctx.callExpression() != null) && (res == null))
        {
            System.out.println("Estais tratando de acceder a una funcion no definida...");
        }


        return i;
    }

    @Override
    public Object visitElementAccessAST(ParserUI.ElementAccessASTContext ctx) {
        System.out.println("HOLA?");
        Object temp = visit(ctx.expression());

        if (temp == null) {
            return T_NULL;
        }
        int tipo = (int)temp;
        return tipo;
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
        /*if (ctx.getRuleContext().toStringTree().contains("push")){
            System.out.println("OOOOLLEEEE TORO!");
            return T_ERROR;}*/
        System.out.println("ID + "+ ctx.getText());
        IDTableKaio.Ident res = tablaIDs.buscar(ctx.ID().getText());
        if (res != null){
            System.out.println("tipo del primary expression "+res.type);
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
        int tipo = (int)visit(ctx.arrayLiteral());
        return tipo;
    }

    @Override
    public Object visitPExpARRAYFUNC(ParserUI.PExpARRAYFUNCContext ctx) {
        int asd;
        int reser = (int)visit(ctx.arrayFunctions());
        if (reser == T_RESER)
            return T_ARRAY;
        asd = (int) visit(ctx.expressionList());
        return T_ERROR;
    }

    @Override
    public Object visitPExpFUNCLITE(ParserUI.PExpFUNCLITEContext ctx) {
        System.out.println("Yo?");
        return (int) visit(ctx.functionLiteral());
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

        return T_RESER;
    }

    @Override
    public Object visitArrfunFIRST(ParserUI.ArrfunFIRSTContext ctx) {

        return T_RESER;
    }

    @Override
    public Object visitArrfunLAST(ParserUI.ArrfunLASTContext ctx) {

        return T_RESER;
    }

    @Override
    public Object visitArrfunREST(ParserUI.ArrfunRESTContext ctx) {

        return T_RESER;
    }

    @Override
    public Object visitArrfunPUSH(ParserUI.ArrfunPUSHContext ctx) {

        return T_RESER;
    }

    @Override
    public Object visitArrayLiteralAST(ParserUI.ArrayLiteralASTContext ctx) {
        int tipo = (int) visit(ctx.expressionList());
        if (tipo != T_ERROR)
            return T_ARRAY;
        return T_ERROR;
    }

    @Override
    public Object visitFunctionLiteralAST(ParserUI.FunctionLiteralASTContext ctx) {
        System.out.println("Hi?");
        visit(ctx.functionParameters());


        visit(ctx.blockStatement());
        return T_FUNC;
    }

    @Override
    public Object visitFunctionParametersAST(ParserUI.FunctionParametersASTContext ctx) {

        return visit(ctx.moreIdentifiers());
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
        LinkedList<Integer> paramList = new LinkedList<Integer>();
        int t1 = (int)visit(ctx.expression());
        Integer[] val = (Integer[]) visit(ctx.moreExpressions());
        if(t1 != T_ERROR)
            paramList.add(t1);
        else
            return T_ERROR;
        for (int i = 0; i < val.length-1; i++) {
            if (val[i] == T_ERROR)
                return T_ERROR;
            paramList.add(val[i]);
        }

        //ESTO POR SI SE OCUPA LA VAR GLOBAL DE LOS ELEMENTOS DE UN ARRAY...
        /*Integer[] listaelementos = new Integer[paramList.size()];
        listaelementos = paramList.toArray(listaelementos);
        expressionList = listaelementos;
        */
        return T_ARRAY;
    }

    @Override
    public Object visitExpressionListNULLAST(ParserUI.ExpressionListNULLASTContext ctx) {
        return T_NULL;
    }

    @Override
    public Object visitMoreExpressionsAST(ParserUI.MoreExpressionsASTContext ctx) {
        LinkedList<Integer> paramList2 = new LinkedList<Integer>();
        for( ParserUI.ExpressionContext ele : ctx.expression()) {
            int valor = (int) visit(ele);
            paramList2.addLast(valor);
        }
        Integer[] val2 = new Integer[paramList2.size()];
        val2 = paramList2.toArray(val2);
        return val2;
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
        int bool = (int)visit(ctx.expression());
        if((bool ==T_BOOLEAN) || ((bool==T_NULL))) {
            if ((ctx.expression().toStringTree().contains("TRUE")) || (ctx.expression().toStringTree().contains("true"))){
                System.out.println("Joder!");
                return visit(ctx.blockStatement(0));
            }
            else{
                System.out.println("Demonios!");
                return visit(ctx.blockStatement(1));
            }
        }else System.out.println("Boolean expression expected");
        return T_ERROR;
    }

    @Override
    public Object visitBlockStatementAST(ParserUI.BlockStatementASTContext ctx) {
        System.out.println("GG IZI");
        tablaIDs.openScope();
        for( ParserUI.StatementContext ele : ctx.statement()){
            visit(ele);}
        System.out.println("dentro del scope");
        tablaIDs.imprimir();
        tablaIDs.closeScope();
        return null;
    }


}
