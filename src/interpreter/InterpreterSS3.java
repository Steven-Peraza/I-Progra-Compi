package interpreter;

import Checker.IDTableKaio;
import generated.ParserUI;
import generated.ParserUIBaseVisitor;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


public class InterpreterSS3 extends ParserUIBaseVisitor{
    private DataStorage dataS = null;
    private EvaluationStack evalStack=null;
    public IDTableKaio tablaIDs = null;
    public static final int T_NULL = 0, T_ERROR = -1, T_INT = 1, T_STRING = 2, T_BOOLEAN = 3, T_ARRAY = 4, T_HASH = 5, T_RESER = 6, T_FUNC = 7,T_NEUTRO=8;

    public static final String
            ERROR_NON_COMPATIBLE_TYPES = "Operacion Invalida: Tipos incompatibles encontrados",
            CONTEXT_ERROR = "Error de Contexto",
            ERROR_IVALID_OPERATION = "Operacion Invalida"
                    ;

    public int param = 0;
    public int fReturnType = T_RESER;
    public HashMap<Object,Object> hash = new HashMap<Object, Object>();

    public InterpreterSS3(){
        this.dataS=new DataStorage();
        this.evalStack = new EvaluationStack();
        tablaIDs = new IDTableKaio();
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
        tablaIDs.imprimir();
        tablaIDs.closeScope();
        return state;
    }

    @Override
    public Object visitStatementLET(ParserUI.StatementLETContext ctx) {

        int state = (int)visit(ctx.letStatement());
        tablaIDs.imprimir();

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
        ctx.storageIndex = dataS.getActualStorageIndex();
;
        int tipo = (Integer) visit(ctx.expression());
        if (tipo == T_INT){
            Integer num = (Integer) this.evalStack.popValue();
            System.out.println("Pila NUM "+num);
            this.dataS.addData(ctx.identifier().getText(),num,tipo);
            tablaIDs.insertar(idToken.getSymbol(),tipo,ctx,param,fReturnType,num);
        }
        else if (tipo == T_STRING){
            String str = (String) this.evalStack.popValue();
            System.out.println("Pila STR "+str);
            this.dataS.addData(ctx.identifier().getText(),str,tipo);
            tablaIDs.insertar(idToken.getSymbol(),tipo,ctx,param,fReturnType,str);

        }
        else if(tipo == T_FUNC) {
            IDTableKaio.Function fun = (IDTableKaio.Function) evalStack.popValue();
            tablaIDs.insertar(idToken.getSymbol(), tipo, ctx, param, fReturnType, fun);
        }

        else if (tipo == T_BOOLEAN){
            Boolean bol = (Boolean) this.evalStack.popValue();
            System.out.println("Pila Bool "+bol);
            this.dataS.addData(ctx.identifier().getText(),bol,tipo);
            tablaIDs.insertar(idToken.getSymbol(),tipo,ctx,param,fReturnType,bol);

        }
        else if (tipo == T_ARRAY){
            //String arr = (String) this.evalStack.popValue();
            LinkedList<Integer> arr = (LinkedList<Integer>) this.evalStack.popValue();
            System.out.println("Pila Arr "+arr);
            this.dataS.addData(ctx.identifier().getText(),arr,tipo);
            tablaIDs.insertar(idToken.getSymbol(),tipo,ctx,param,fReturnType,arr);


        }
        else if (tipo == T_HASH){
            HashMap<Object,Object> ha = (HashMap<Object,Object>) this.evalStack.popValue();
            System.out.println("Pila Hash "+ha);
            this.dataS.addData(ctx.identifier().getText(),ha,tipo);
            tablaIDs.insertar(idToken.getSymbol(),tipo,ctx,param,fReturnType,ha);
            this.hash.clear();

        }
        else if (tipo == T_RESER){
            this.dataS.addData(ctx.identifier().getText(),ctx.expression().getText(),tipo);
            tablaIDs.insertar(idToken.getSymbol(),tipo,ctx,param,fReturnType,null);
            evalStack.pushValue(ctx.expression().getText());
        }
        System.out.println(this.dataS.toString());
        return tipo;
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

            else if (type1 == type2 && type1 == T_INT){
                Integer v3 = (Integer) this.evalStack.popValue();
                Integer v2 = (Integer) this.evalStack.popValue();
                Integer v1 = (Integer) this.evalStack.popValue();
                this.evalStack.pushValue(evaluarCOMPINT(v1,v2,ctx));
            }
            else if (type1 == type2 && (type1 == T_STRING) && isAssignation){
                String v3 = (String) this.evalStack.popValue();
                String v2 = (String) this.evalStack.popValue();
                String v1 = (String) this.evalStack.popValue();
                this.evalStack.pushValue(evaluarCOMPEQU(v1,v2,ctx));

            }
            else if (type1 == type2 && type1 == T_ARRAY && isAssignation){
                LinkedList<Integer> v3 = (LinkedList<Integer>) this.evalStack.popValue();
                System.out.println("Comparison3 "+v3);
                LinkedList<Integer> v2 = (LinkedList<Integer>) this.evalStack.popValue();
                LinkedList<Integer> v1 = (LinkedList<Integer>) this.evalStack.popValue();
                this.evalStack.pushValue(evaluarCOMPEQU(v1,v2,ctx));

            }
            else if (type1 == type2 && type1 == T_HASH && isAssignation){
                HashMap<Object,Object> v3 = (HashMap<Object,Object>) this.evalStack.popValue();
                HashMap<Object,Object> v2 = (HashMap<Object,Object>) this.evalStack.popValue();
                HashMap<Object,Object> v1 = (HashMap<Object,Object>) this.evalStack.popValue();
                this.evalStack.pushValue(evaluarCOMPEQU(v1,v2,ctx));

            }
            else if (type1 == type2 && type1 == T_BOOLEAN && isAssignation){
                boolean v3 = (boolean) this.evalStack.popValue();
                boolean v2 = (boolean) this.evalStack.popValue();
                boolean v1 = (boolean) this.evalStack.popValue();
                this.evalStack.pushValue(evaluarCOMPEQU(v1,v2,ctx));

            }

            else{
                imprimirError(ERROR_IVALID_OPERATION, ctx.start.getLine(),ctx.start.getCharPositionInLine());
                return T_ERROR;}

        }
        return type1;
    }

    private Boolean evaluarCOMPEQU(Object v1, Object v2, ParserUI.ComparisonASTContext op){
        Boolean res=new Boolean(true);
        System.out.println(v1);
        System.out.println(v2);
        if (!op.EQU().isEmpty()){
            res = v1.equals(v2);
        }
        System.out.println("EQUAL = "+res);
        return res;
    }

    private Boolean evaluarCOMPINT(Integer v1, Integer v2, ParserUI.ComparisonASTContext op){
        Boolean res=new Boolean(true);
        if (!op.EQU().isEmpty()){
            res = v1 == v2;
        }
        else if (!op.MAYOR().isEmpty()){
            res = v1 > v2;
        }
        else if (!op.MAYOREQ().isEmpty()){
            res = v1 >= v2;
        }
        else if (!op.MENOR().isEmpty()){
            res = v1 < v2;
        }
        else if (!op.MENOREQ().isEmpty()){
            res = v1 <= v2;
        }
        System.out.println("EQUAL INT = "+res);
        return res;
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
            Integer v3 = (Integer) this.evalStack.popValue();
            Integer v2 = (Integer) this.evalStack.popValue();
            Integer v1 = (Integer) this.evalStack.popValue();

            if (temp != temp2 && temp == T_INT) {
                imprimirError(ERROR_NON_COMPATIBLE_TYPES, ctx.start.getLine(),ctx.start.getCharPositionInLine());
                return T_ERROR;
            }
            this.evalStack.pushValue(evaluarSUM_RES(v1,v2,ctx));
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
        for (ParserUI.ElementExpressionContext i: ctx.elementExpression()) {
            temp2 = (int)visit(i);
            Integer v3 = (Integer) this.evalStack.popValue();
            Integer v2 = (Integer) this.evalStack.popValue();
            Integer v1 = (Integer) this.evalStack.popValue();
            if (temp != temp2 && temp == T_INT) {
                imprimirError(ERROR_NON_COMPATIBLE_TYPES, ctx.start.getLine(),ctx.start.getCharPositionInLine());
                return T_ERROR;
            }
            this.evalStack.pushValue(evaluarMUL_DIV(v1,v2,ctx));
            //System.out.println(this.evalStack.popValue());
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
                //System.out.println("Se está tratando de accesar a un tipo que no es Array o Hash");
                return T_ERROR;
            }
        }
        else if ((ctx.elementAccess() != null) && (res == null))
        {
            imprimirError("Operacion Invalida: Variable no Encontrada", ctx.start.getLine(),ctx.start.getCharPositionInLine());
        }
        if ((ctx.callExpression() != null) && (res != null)){
            visit(ctx.callExpression());
            IDTableKaio.Function func = (IDTableKaio.Function) evalStack.popValue();
            visit(func.instructions);
            return func.returnType;

        }
        else if ((ctx.callExpression() != null) && (res == null))
        {
            imprimirError("Operacion Invalida: Funcion no definida ", ctx.start.getLine(),ctx.start.getCharPositionInLine());
            return T_ERROR;
        }


        return i;
    }

    private Integer evaluarSUM_RES(Integer v1, Integer v2, ParserUI.AddfactorASTContext op){
        Integer res=new Integer(0);
        System.out.println(op.getText());
        if (!op.SUM().isEmpty())
            res = v1 + v2;
        else if (!op.SUB().isEmpty())
            res = v1 - v2;
        System.out.println("Resultado de la SUM/RES "+ res);
        return res;
    }
    private Integer evaluarMUL_DIV(Integer v1, Integer v2, ParserUI.MultifactorASTContext op){
        Integer res=new Integer(0);
        if (!op.MUL().isEmpty())
            res = v1 * v2;
        else if (!op.DIV().isEmpty())
            res = v1 / v2;
        System.out.println("Resultado de la MUL/DIV "+ res);
        return res;
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
        visit(ctx.expressionList());
        return T_RESER;
    }

    @Override
    public Object visitPExpNUM(ParserUI.PExpNUMContext ctx) {

        this.evalStack.pushValue((Integer.parseInt(ctx.NUM().getText())));
        return T_INT;
    }

    @Override
    public Object visitPExpSTRING(ParserUI.PExpSTRINGContext ctx) {

        this.evalStack.pushValue(ctx.STRING().getText());
        this.evalStack.pushValue(ctx.STRING().getText());
        return T_STRING;
    }

    @Override
    public Object visitPExpID(ParserUI.PExpIDContext ctx) {
        //DataStorage.Value temp = dataS.getData(ctx.identifier().getText());
        IDTableKaio.Ident temp = tablaIDs.buscar(ctx.identifier().getText());
        if (temp.type == T_INT){
            this.evalStack.pushValue((Integer) temp.value);
            //System.out.println("asd"+evalStack.popValue());
            return T_INT;}
        else if (temp.type == T_STRING){
            this.evalStack.pushValue((String) temp.value);
            return T_STRING;}
        else if(temp.type == T_FUNC){
            evalStack.pushValue(temp.value);
            return T_FUNC;
        }
        return -1;
    }

    @Override
    public Object visitIdAST(ParserUI.IdASTContext ctx) {
        return ctx.ID();
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
        //System.out.println(ctx.arrayLiteral().getText());
        int tt =(Integer) visit(ctx.arrayLiteral());
        return tt;
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
        int tt = (Integer) visit(ctx.hashLiteral());
        this.evalStack.pushValue(this.hash);
        return tt;
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
        LinkedList<Object>  tipo =  (LinkedList<Object> )visit(ctx.expressionList());
        this.evalStack.pushValue(tipo);
        //System.out.println("Array Verdad "+tipo);
        return T_ARRAY;
    }

    @Override
    public Object visitFunctionLiteralAST(ParserUI.FunctionLiteralASTContext ctx) {
        tablaIDs.openScope();
        visit(ctx.functionParameters());
        LinkedList<String>parameters = (LinkedList<String>)evalStack.popValue();
        System.out.println(parameters);
        int state = (int)visit(ctx.blockStatement());
        tablaIDs.closeScope();
        if(state == T_ERROR)
            return T_ERROR;
        if(state != T_RESER){
            fReturnType = state;
        }
        IDTableKaio.Function newFunction = new IDTableKaio.Function(parameters,ctx.blockStatement(),param,fReturnType);
        evalStack.pushValue(newFunction);
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
            int type = (int)visit(ctx.moreIdentifiers());
            LinkedList<String> parameters = (LinkedList<String>)evalStack.popValue();
            parameters.add(ctx.ID().getText());
            System.out.println(parameters);
            evalStack.pushValue(parameters);
            //tablaIDs.insertar(ctx.ID().getSymbol(),T_NEUTRO,ctx);
        }
        return T_RESER;
    }

    @Override
    public Object visitMoreIdentifiersAST(ParserUI.MoreIdentifiersASTContext ctx) {
        IDTableKaio.Ident id;
        LinkedList<String>parameters = new LinkedList<>();
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
                parameters.add(ele.getText());
                //tablaIDs.insertar(ele.getSymbol(), T_NEUTRO, ctx);
            }
        }
        evalStack.pushValue(parameters);
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
        LinkedList<Object> paramList = new LinkedList<Object>();
        int t1 = (int)visit(ctx.expression());
        paramList.add(this.evalStack.popValue());
        Object[] val = (Object[]) visit(ctx.moreExpressions());
        for (Object aVal : val) {
            paramList.add(aVal);
        }

        return paramList;
    }

    @Override
    public Object visitExpressionListNULLAST(ParserUI.ExpressionListNULLASTContext ctx) {
        return T_NULL;
    }

    @Override
    public Object visitMoreExpressionsAST(ParserUI.MoreExpressionsASTContext ctx) {
        LinkedList<Object> paramList2 = new LinkedList<Object>();
        for( ParserUI.ExpressionContext ele : ctx.expression()) {
            int valor = (int) visit(ele);
            paramList2.addLast(this.evalStack.popValue());
        }
        Object[] val2 = new Object[paramList2.size()];
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
            System.out.println("Si se imprime la var: "+ctx.getText().substring(5,ctx.getText().length()-1)+" con el valor de "+res.value);
            return tipo;
        }
    }

    @Override
    public Object visitIfExpressionAST(ParserUI.IfExpressionASTContext ctx) {
        int bool = (int)visit(ctx.expression());
        int state = -1;
        Boolean resultadoComp = (Boolean) this.evalStack.popValue();
        if((bool ==T_BOOLEAN) || ((bool==T_NEUTRO))) {
            if (resultadoComp){
                //tablaIDs.openScope();
                state = (int)visit(ctx.blockStatement(0));
                //tablaIDs.closeScope();
            }
            else{
                if(ctx.ELSE() != null){
                    //tablaIDs.openScope();
                    state = (int)visit(ctx.blockStatement(1));
                    //tablaIDs.closeScope();
                }
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
