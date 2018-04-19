package Checker;

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
        int type; //forma simple de identificar un tipo del lenguaje [0--> Entero] NO ES TAN CECESARIO EN ESTE LENGUAJE ALPHA PUESTO QUE SOLO ACEPTA NUMEROS
        ParserRuleContext decl; //por si fuera necesario saber más acerca del contexto del identificador en el árbol

        public Ident(int n, Token t, int ty, ParserRuleContext d) {
            nivel = n;
            tok = t;
            type = ty;
            decl = d;
        }

        public String toString(){
            return this.tok.getText() + "," + this.nivel;
        }
    }

    public IDTableKaio()
    {
        this.nivelActual = 0;
        this.tabla = new LinkedList<Ident>();
    }

    public Ident insertar(String nombre, int tipo, ParserRuleContext declaracion)
    {
        Token token = new CommonToken(0,nombre);
        Ident i = new Ident(nivelActual,token,tipo,declaracion);
        int j = 0;
        while (j < this.tabla.size() && this.tabla.get(j).nivel == nivelActual) {
            if (this.tabla.get(j).tok.getText().equals(nombre)) {
                System.out.println("El identificador \"" + nombre + "\" ya ha sido declarado!!!");
                return null;
            }
            j++;
        }
        this.tabla.push(i); //deben ser una tabla estilo pila
        return this.tabla.get(0);
    }

    public Ident insertar(Token token, int tipo, ParserRuleContext declaracion)
    {
        Ident i = new Ident(nivelActual,token,tipo,declaracion);
        int j = 0;
        while (j < this.tabla.size() && this.tabla.get(j).nivel == nivelActual) {
            if (this.tabla.get(j).tok.getText().equals(token.getText())) {
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
            if (id.tok.getText().equals(nombre)) {
                temp = id;
                break;
            }
        return temp;
    }

    public void imprimir() {
        System.out.println("****** ESTADO DE TABLA DE SÍMBOLOS ******");
        if (!this.tabla.isEmpty()) {
            for (Ident i : this.tabla) {
                String nivel = "";
                for (int j = 0; j < i.nivel; j++) {
                    nivel += "\t";
                }
                System.out.println(nivel + "Nombre: " + i.tok.getText() + " - Nivel: " + i.nivel);
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
