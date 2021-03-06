package Checker;

import generated.ParserUI;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.util.LinkedList;

public class IDTableKaio {

    private LinkedList<Ident> tabla;
    private int nivelActual;

    public class Ident{
        int nivel;
        Token tok;
        public int type; //forma simple de identificar un tipo del lenguaje [0--> Entero] NO ES TAN CECESARIO EN ESTE LENGUAJE ALPHA PUESTO QUE SOLO ACEPTA NUMEROS
        public ParserRuleContext decl; //por si fuera necesario saber más acerca del contexto del identificador en el árbol
        public int param;
        public int returnType;
        public Object value;

        public Ident(int n, Token t, int ty, ParserRuleContext d, int p, int returnType, Object v) {
            nivel = n;
            value = v;
            tok = t;
            type = ty;
            decl = d;
            param = p;
            this.returnType = returnType;

        }



        public String toString(){
            return this.tok.getText() + "," + this.nivel;
        }
    }

    public static  class Function{
        public LinkedList<String> parameters;
        public ParserUI.BlockStatementContext instructions;
        public int param;
        public int returnType;

        public Function(LinkedList<String> parameters, ParserUI.BlockStatementContext instructions, int param, int returnType) {
            this.parameters = parameters;
            this.instructions = instructions;
            this.param = param;
            this.returnType = returnType;
        }

        @Override
        public String toString() {
            return "Function{" +
                    "parameters=" + parameters +
                    ", instructions=" + instructions +
                    ", param=" + param +
                    ", returnType=" + returnType +
                    '}';
        }
    }

    public static class ExpressionContainer{
        public int type;
        public Object value;

        public ExpressionContainer(int type, Object value) {
            this.type = type;
            this.value = value;
        }
    }



    public IDTableKaio()
    {
        this.nivelActual = 0;
        this.tabla = new LinkedList<Ident>();
    }

    public Ident insertar(String nombre, int tipo, ParserRuleContext declaracion, Object value)
    {
        Ident newVar = buscar(nombre);
        if(newVar == null){
            Token token = new CommonToken(0,nombre);
            Ident i = new Ident(nivelActual,token,tipo,declaracion,0,6, value);
            int j = 0;
            this.tabla.push(newVar);
        }else{
            newVar.value = value;
        }
         //deben ser una tabla estilo pila
        return newVar;
    }

    public Ident insertar(Token token, int tipo, ParserRuleContext declaracion)
    {
        Ident i = new Ident(nivelActual,token,tipo,declaracion,0,6,null);
        int j = 0;
        while (j < this.tabla.size() && this.tabla.get(j).nivel == nivelActual) {
            if (this.tabla.get(j).tok.getText().equals(token.getText())&& (nivelActual == tabla.get(j).nivel)) {
                System.out.println("El identificador \"" + token.getText() + "\" ya ha sido declarado. Line " + token.getLine() + ":" + token.getCharPositionInLine());
                return null;
            }
            j++;
        }
        tabla.push(i); //deben ser una tabla estilo pila
        return this.tabla.get(0);

    }

    public Ident insertar(Token token, int tipo, ParserRuleContext declaracion,int parametros,int returnType,Object value)
    {
        Ident i = new Ident(nivelActual,token,tipo,declaracion,parametros, returnType,value);
        int j = 0;
        while (j < this.tabla.size() && this.tabla.get(j).nivel == nivelActual) {
            if (this.tabla.get(j).tok.getText().equals(token.getText())&& (nivelActual == tabla.get(j).nivel)) {
                System.out.println("El identificador \"" + token.getText() + "\" ya ha sido declarado. Line " + token.getLine() + ":" + token.getCharPositionInLine());
                return null;
            }
            j++;
        }
        tabla.push(i); //deben ser una tabla estilo pila
        return this.tabla.get(0);

    }

    public void openScope(){
        this.nivelActual++;
    }

    public void closeScope(){
        Ident element = this.tabla.get(0);
        while (element != null && element.nivel == nivelActual){
            tabla.pop();
            if(!this.tabla.isEmpty())
                element = this.tabla.get(0);
            else
                element= null;
        }
        this.nivelActual--;
    }

    public Ident buscar(String nombre)
    {
        Ident temp=null;
        for(Ident id : this.tabla)
            if (id.tok.getText().equals(nombre)&& id.nivel==nivelActual) {
                temp = id;
                break;
            }
        return temp;
    }

    public Ident buscarAcceso(String nombre)
    {
        Ident scopeActual = null;
        Ident scopeGlobal = null;
        for(Ident id : this.tabla) {
            if (id.tok.getText().equals(nombre) && id.nivel == nivelActual) {
                scopeActual = id;
                break;
            } else if (id.tok.getText().equals(nombre) && id.nivel == 1) {
                scopeGlobal = id;
            }
        }
        if(scopeActual != null){
            return scopeActual;
        }
        else{
            return scopeGlobal;
        }
    }

    public void imprimir() {
        System.out.println("****** ESTADO DE TABLA DE SÍMBOLOS ******");
        if (!this.tabla.isEmpty()) {
            for (Ident i : this.tabla) {
                String nivel = "";
                for (int j = 0; j < i.nivel; j++) {
                    nivel += "\t";
                }
                System.out.println(nivel + "Nombre: " + i.tok.getText() + " - Nivel: " + i.nivel + "------> "+ i.value);
            }
            System.out.println("------------------------------------------");
        }
        else
            System.out.println("Tabla vacía");
    }

    public LinkedList<Ident> getTabla() {
        return this.tabla;
    }
}
