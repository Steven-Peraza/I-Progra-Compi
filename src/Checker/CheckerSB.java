package Checker;

import generated.ParserUIBaseVisitor;
import generated.ParserUI;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.runtime.EarlyExitException;
import java.util.LinkedList;

public class CheckerSB extends ParserUIBaseVisitor{
    private IDTableKaio tablaIDs = null;
    public static final int T_NULL = 0, T_ERROR = -1, T_INT = 1, T_STRING = 2, T_BOOLEAN = 3, T_ARRAY = 4, T_HASH = 5, T_RESER = 6, T_FUNC = 7,T_NEUTRO=8;

    public static final String
            ERROR_NON_COMPATIBLE_TYPES = "Operacion Invalida: Tipos incompatibles encontrados",
            CONTEXT_ERROR = "Error de Contexto",
            ERROR_IVALID_OPERATION = "Operacion Invalida"
    ;

    public int param = 0;
    public int fReturnType = T_RESER;
    public CheckerSB(){
        this.tablaIDs=new IDTableKaio();
    }


    @Override
    public Object visitProgramAST(ParserUI.ProgramASTContext ctx) {
        int state = -1;
        tablaIDs.openScope();
        for( ParserUI.StatementContext ele : ctx.statement()){
           state = (int)visit(ele);
            //System.out.println("Statement: "+state);
           if(state == T_ERROR) {
               return T_ERROR;
           }
            }
        tablaIDs.closeScope();
        return state;
    }

    @Override
    public Object visitStatementLET(ParserUI.StatementLETContext ctx) {

        int state = (int)visit(ctx.letStatement());
        //tablaIDs.imprimir();


        return state;
    }

    @Override
    public Object visitStatementRETURN(ParserUI.StatementRETURNContext ctx) {

        int state = (int)visit(ctx.returnStatement());
        //System.out.println(ctx.returnStatement().toStringTree());
        return state;
    }

    @Override
    public Object visitStatementEXPRESSION(ParserUI.StatementEXPRESSIONContext ctx) {
        int state = (int)visit(ctx.expressionStatement());
        return state;
    }

    @Override
    public Object visitLetAST(ParserUI.LetASTContext ctx) {
        TerminalNode idToken = (TerminalNode) visit(ctx.identifier());
        int tipo = -1;
        fReturnType = T_RESER;
        if(ctx.identifier()!=null) {
            tipo = (int) visit(ctx.expression());
            if(tipo == T_ERROR){
                return T_ERROR;
            }
        }
        else{
            //System.out.println("No hay ID");
            imprimirError("Se esperaba un ID y no se encontro", ctx.start.getLine(),ctx.start.getCharPositionInLine());
            return T_ERROR;
        }
        // al igual que con las vars se debe buscar en la tabla de IDs para comprobar si la const ya existe
        IDTableKaio.Ident res = tablaIDs.buscar(idToken.getText());
        if(tipo == T_RESER){
            //System.out.println();
            imprimirError("No puede asignarle a una variable una funcion sin retorno", ctx.start.getLine(),ctx.start.getCharPositionInLine());
            return T_ERROR;
        }
        if (res == null){
            tablaIDs.insertar(idToken.getSymbol(),tipo,ctx,param,fReturnType);
            return T_RESER;
        }
        else{
            //System.out.println("Lo sentimos, la var/fun "+ctx.ID().getSymbol().getText()+" ya esta definida");
            if(res.type == T_FUNC){
                imprimirError("No se puede cambiar el valor a una funcion",ctx.start.getLine(),ctx.start.getCharPositionInLine());
            }else{
                res.type = tipo;
            }
            return T_RESER;
        }
    }

    @Override
    public Object visitReturnAST(ParserUI.ReturnASTContext ctx) {
        //System.out.println(ctx.expression().parent.getParent().getParent().getParent().getText());
        if ((ctx.expression().parent.getParent().getParent().getParent() != null) &&(ctx.expression().parent.getParent().getParent().getParent().getText().contains("fn"))){
            return visit(ctx.expression());
        }
        else{
            imprimirError("Return fuera de funcion",ctx.start.getLine(),ctx.start.getCharPositionInLine());
            return T_ERROR;
        }
    }

    @Override
    public Object visitExpressionStatementAST(ParserUI.ExpressionStatementASTContext ctx) {

        return (int)visit(ctx.expression());
    }

    @Override
    public Object visitExpressionAST(ParserUI.ExpressionASTContext ctx) {

        int temp = (int)visit(ctx.additionExpression());


        int temp2 = (int)visit(ctx.comparison());

        if(temp2 == T_NULL)
            return temp;
        else if(temp == T_ERROR || temp2== T_ERROR){
            //System.out.println("Error de tipos en el comparison o el addition expression");
            imprimirError(CONTEXT_ERROR, ctx.start.getLine(),ctx.start.getCharPositionInLine());

            return T_ERROR;
        }
        else if(temp != temp2){
            imprimirError(ERROR_NON_COMPATIBLE_TYPES, ctx.start.getLine(),ctx.start.getCharPositionInLine());
            return T_ERROR;
        }
        else
            return T_BOOLEAN;
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
                    imprimirError(CONTEXT_ERROR, ctx.start.getLine(),ctx.start.getCharPositionInLine());
                    return T_ERROR;
                }
                else if(type2 != type1 || (!isAssignation && type1 != T_INT)){
                    imprimirError(ERROR_IVALID_OPERATION, ctx.start.getLine(),ctx.start.getCharPositionInLine());
                    return T_ERROR;}
            }
        return type1;
    }

    @Override
    public Object visitAdditionExpressionAST(ParserUI.AdditionExpressionASTContext ctx) {

        int t1 = (int)visit(ctx.multiplicationExpression());

        int t2 = (int)visit(ctx.additionFactor());

        if(t2==T_NULL){
            return t1;
        }

        if(t1 == T_NEUTRO) {
            t1 = T_INT;
        }
        if(t2 == T_NEUTRO)
            t2 = T_INT;


        if (t1 != t2){
            //System.out.println("Tipos incompatibles al realizar la OP de "+ctx.additionFactor().getText());
            imprimirError(ERROR_NON_COMPATIBLE_TYPES,ctx.start.getLine(),ctx.start.getCharPositionInLine());
            return T_ERROR;
        }
        else
            if (t1 == T_INT){
                return  t1;
            }
            else{
                imprimirError(ERROR_NON_COMPATIBLE_TYPES, ctx.start.getLine(),ctx.start.getCharPositionInLine());
                return T_ERROR;}

    }

    @Override
    public Object visitAddfactorAST(ParserUI.AddfactorASTContext ctx) {
        if (ctx.multiplicationExpression().size() == 0)
            return T_NULL;
        int temp = (int)visit(ctx.multiplicationExpression(0)), temp2;
        for (ParserUI.MultiplicationExpressionContext i:
                ctx.multiplicationExpression()) {
            temp2 = (int)visit(i);
            if (temp != temp2) {
                imprimirError(ERROR_NON_COMPATIBLE_TYPES, ctx.start.getLine(),ctx.start.getCharPositionInLine());
                return T_ERROR;
            }
        }
        return temp;


    }

    @Override
    public Object visitMultiplicationExpressionAST(ParserUI.MultiplicationExpressionASTContext ctx) {

        int t1 = (int)visit(ctx.elementExpression());

        int t2 = (int)visit(ctx.multiplicationFactor());



        if ((t1 != t2) && (t2 != T_NULL)){
            imprimirError(ERROR_NON_COMPATIBLE_TYPES, ctx.start.getLine(),ctx.start.getCharPositionInLine());
            return T_ERROR;
        }
        else {
            if ((t1 == T_INT) || (t2 == T_NULL)) {
                return t1;
            } else {
                imprimirError(ERROR_NON_COMPATIBLE_TYPES, ctx.start.getLine(),ctx.start.getCharPositionInLine());
                return T_ERROR;
            }
        }
    }

    @Override
    public Object visitMultifactorAST(ParserUI.MultifactorASTContext ctx) {
        if (ctx.elementExpression().size() == 0)
            return T_NULL;
        int temp = (int)visit(ctx.elementExpression(0)), temp2;
        for (ParserUI.ElementExpressionContext i:
                ctx.elementExpression()) {
            temp2 = (int)visit(i);
            if (temp != temp2) {
                imprimirError(ERROR_NON_COMPATIBLE_TYPES, ctx.start.getLine(),ctx.start.getCharPositionInLine());
                return T_ERROR;
            }
        }
        return temp;
    }

    @Override
    public Object visitElementExpressionAST(ParserUI.ElementExpressionASTContext ctx) {

        IDTableKaio.Ident res = tablaIDs.buscarAcceso(ctx.primitiveExpression().getText());
        int i = (int) visit(ctx.primitiveExpression());

        int p = T_NULL ,o = T_NULL;
        if ((ctx.elementAccess() != null) && (res != null)){
            p = (int) visit(ctx.elementAccess());
            if (i == T_HASH || i== T_NEUTRO){
                if(p != T_ERROR)
                    return T_NEUTRO;
                else{
                    imprimirError("Indice no valido para el hash...", ctx.start.getLine(),ctx.start.getCharPositionInLine());
                    return T_ERROR;
                }
            }
            else if (i == T_ARRAY  ){
                if(p == T_INT)
                    return T_NEUTRO;
                else{
                    imprimirError("Se requiere un tipo Integer para realizar indexaciones en arrays", ctx.start.getLine(),ctx.start.getCharPositionInLine());
                    return T_ERROR;
                }
            }
            else{
                imprimirError("Se esta tratando de accesar a un tipo que no es Array o Hash", ctx.start.getLine(),ctx.start.getCharPositionInLine());
                return T_ERROR;
            }
        }
        else if ((ctx.elementAccess() != null) && (res == null))
        {
            imprimirError("Operacion Invalida: Variable no Encontrada", ctx.start.getLine(),ctx.start.getCharPositionInLine());
        }
        if ((ctx.callExpression() != null) && (res != null)){
            o = (int) visit(ctx.callExpression());
            if (res.type == T_FUNC || res.type == T_NEUTRO) {
                //System.out.println(res.type);
                if (o == res.param || res.type == T_NEUTRO) {
                    if (i == T_FUNC) {
                        return res.returnType;
                    }
                }
                else {
                    imprimirError("Cantidad de parametros incorrecta, se esperaban "+res.param+" parametros y se encontraron "+o+ " argumentos", ctx.start.getLine(),ctx.start.getCharPositionInLine());
                    return T_ERROR;
                }
            }
            else{
                imprimirError("Operacion Invalida: Esta variable no es una funcion ", ctx.start.getLine(),ctx.start.getCharPositionInLine());
                return T_ERROR;
            }
        }
        else if ((ctx.callExpression() != null) && (res == null))
        {
            imprimirError("Operacion Invalida: Funcion no definida ", ctx.start.getLine(),ctx.start.getCharPositionInLine());
            return T_ERROR;
        }


        return i;
    }

    @Override
    public Object visitElementAccessAST(ParserUI.ElementAccessASTContext ctx) {

        Object temp = visit(ctx.expression());

        if (temp == null) {
            return T_NULL;
        }
        int tipo = (int)temp;
        return tipo;
    }

    @Override
    public Object visitCallExpressionAST(ParserUI.CallExpressionASTContext ctx) {
        LinkedList<Integer> tipo = (LinkedList<Integer> )visit(ctx.expressionList());
        if(tipo != null)
            return tipo.size();
        imprimirError(CONTEXT_ERROR, ctx.start.getLine(),ctx.start.getCharPositionInLine());
        return T_ERROR;
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
        TerminalNode idToken = (TerminalNode) visit(ctx.identifier());
        IDTableKaio.Ident res = tablaIDs.buscarAcceso(idToken.getText());
        if (res != null){
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
        return visit(ctx.arrayLiteral());
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
        return visit(ctx.functionLiteral());
    }

    @Override
    public Object visitPExpHASHLITE(ParserUI.PExpHASHLITEContext ctx) {
        return visit(ctx.hashLiteral());
    }

    @Override
    public Object visitPExpPRINT(ParserUI.PExpPRINTContext ctx) {
        int tipo = (int)visit(ctx.printExpression());
        return tipo;
    }

    @Override
    public Object visitPExpIF(ParserUI.PExpIFContext ctx) {

        return visit(ctx.ifExpression());
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
        if(ctx.expressionList().children == null){
            return T_ARRAY;
        }
        LinkedList<Integer>  tipo =  (LinkedList<Integer> )visit(ctx.expressionList());
        if (tipo.getFirst() != T_ERROR)
            return T_ARRAY;
        return T_ERROR;
    }

    @Override
    public Object visitFunctionLiteralAST(ParserUI.FunctionLiteralASTContext ctx) {
        tablaIDs.openScope();
        visit(ctx.functionParameters());

        int state = (int)visit(ctx.blockStatement());
        tablaIDs.closeScope();
        if(state == T_ERROR)
            return T_ERROR;
        if(state != T_RESER){
            fReturnType = state;
        }
        return T_FUNC;
    }

    @Override
    public Object visitFunctionParametersAST(ParserUI.FunctionParametersASTContext ctx) {
        param++;
        IDTableKaio.Ident id = tablaIDs.buscar(ctx.ID().getText());
        if(id != null){
            if(id.type == T_RESER){
                imprimirError("Parametro con identificador invalido, palabra reservada", ctx.start.getLine(),ctx.start.getCharPositionInLine());
            }
            imprimirError("Parametro Invalido: Esta variable ya Existe en este Contexto ", ctx.start.getLine(),ctx.start.getCharPositionInLine());
            return T_ERROR;
        }
        else{
            tablaIDs.insertar(ctx.ID().getSymbol(),T_NEUTRO,ctx);
        }
        return visit(ctx.moreIdentifiers());
    }

    @Override
    public Object visitIdAST(ParserUI.IdASTContext ctx) {
        return ctx.ID();
    }

    @Override
    public Object visitMoreIdentifiersAST(ParserUI.MoreIdentifiersASTContext ctx) {
        IDTableKaio.Ident id;
        for( TerminalNode ele : ctx.ID()) {
            param++;
            id = tablaIDs.buscar(ele.getText());
            if (id != null) {
                if (id.type == T_RESER) {
                    imprimirError("Parametro con identificador invalido, palabra reservada", ctx.start.getLine(),ctx.start.getCharPositionInLine());
                }
                imprimirError("Parametro Invalido: Esta variable ya Existe en este Contexto ", ctx.start.getLine(),ctx.start.getCharPositionInLine());
                return T_ERROR;
            } else {
                tablaIDs.insertar(ele.getSymbol(), T_NEUTRO, ctx);
            }
        }
        return T_RESER;
    }

    @Override
    public Object visitHashLiteralAST(ParserUI.HashLiteralASTContext ctx) {
        int t1 = (int) visit(ctx.hashContent());
        int t2 = (int)visit(ctx.moreHashContent());
        if ((t1 == T_HASH) && (t2 == T_HASH))
            return T_HASH;
        imprimirError(ERROR_NON_COMPATIBLE_TYPES, ctx.start.getLine(),ctx.start.getCharPositionInLine());
        return T_ERROR;
    }

    @Override
    public Object visitHashContentAST(ParserUI.HashContentASTContext ctx) {
        int tipo;
        for( ParserUI.ExpressionContext ele : ctx.expression()){
            tipo = (int)visit(ele);
            if (tipo == T_ERROR) {
                imprimirError(ERROR_NON_COMPATIBLE_TYPES, ctx.start.getLine(),ctx.start.getCharPositionInLine());
                return T_ERROR;
            }
        }
        return T_HASH;
    }

    @Override
    public Object visitMoreHashContentAST(ParserUI.MoreHashContentASTContext ctx) {
        int tipo = T_HASH;
        for( ParserUI.HashContentContext ele : ctx.hashContent()) {
            tipo = (int) visit(ele);
            if (tipo == T_ERROR) {
                imprimirError(ERROR_NON_COMPATIBLE_TYPES, ctx.start.getLine(),ctx.start.getCharPositionInLine());
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
        else{
            paramList.addFirst(T_ERROR);
            return paramList;}
        for (Integer aVal : val) {
            if (aVal == T_ERROR) {
                paramList.addFirst(T_ERROR);
                return paramList;
            }
            paramList.add(aVal);
        }

        //ESTO POR SI SE OCUPA LA VAR GLOBAL DE LOS ELEMENTOS DE UN ARRAY...
        /*Integer[] listaelementos = new Integer[paramList.size()];
        listaelementos = paramList.toArray(listaelementos);
        expressionList = listaelementos;
        */
        return paramList;
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
        IDTableKaio.Ident res = tablaIDs.buscarAcceso(ctx.getText().substring(5,ctx.getText().length()-1));
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
        if((bool ==T_BOOLEAN) || ((bool==T_NEUTRO))) {
            int state = (int)visit(ctx.blockStatement(0));

            if(ctx.ELSE() != null){
                 state = (int)visit(ctx.blockStatement(1));
            }
            if(state == T_ERROR)
                return T_ERROR;
        }else{
            imprimirError(ERROR_NON_COMPATIBLE_TYPES + ": Se esperaba boolean", ctx.start.getLine(),ctx.start.getCharPositionInLine());
        return T_ERROR;
        }
        return T_RESER;
    }

    @Override
    public Object visitBlockStatementAST(ParserUI.BlockStatementASTContext ctx) {
        int state = -1;
        int returnType = T_RESER;
        for( ParserUI.StatementContext ele : ctx.statement()){
            state = (int)visit(ele);
            if(ele.getChild(0).getText().toLowerCase().contains("return")){
                returnType = state;
            }
            if(state == T_ERROR)
                return T_ERROR;
        }
        //tablaIDs.imprimir();
        return returnType;
    }


    public void imprimirError(String msg, int line, int position){

        System.err.println(msg + " en la linea "+line+" en la posicion "+position);

    }



}
