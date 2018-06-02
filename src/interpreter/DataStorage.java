package interpreter;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.util.LinkedList;


public class DataStorage {

    private LinkedList<Value> data;
    private int actualIndex;

    public class Value{
        String name;
        Object value;
        int index;
        int tipo;

        public Value(String n, Object v, int i,int tipo) {
            this.name = new String(n);
            this.value = v;
            this.index = i;
            this.tipo = tipo;
        }
    }

    public DataStorage()
    {
        this.actualIndex = 0;
        this.data = new LinkedList<Value>();
    }

    public void addData(String nombre, Object value,int tipo)
    {
        Value v = new Value(nombre,value,this.actualIndex,tipo);
        this.data.add(v);
        this.actualIndex++;
    }

    public Value getData(int index) {
        return this.data.get(index);
    }

    public Value getData(String name) {
        //se debe buscar en la tabla pero por nombre
        for(Value element:data){
            if(element.name.equals(name)){
                return element;
            }
        }
        return null;
    }

    public void cleanData(){
        while (this.data.size()!=0)
            this.data.pop();
        this.actualIndex=0;
    }

    public String toString() {
        String message = new String("");
        message += "****** ESTADO DE DATA STORAGE ******\n";
        if (!this.data.isEmpty()) {
            for (Value i : this.data) {
                message += i.name + " --> " + i.value.toString() + "\n";
            }
            message += "------------------------------------------";
        } else
            message += "Data Storage is Empty!!";
        return message;
    }

    public int getActualStorageIndex(){
        return this.actualIndex;
    }
    public LinkedList<Value> getData() {
        return this.data;
    }

}
