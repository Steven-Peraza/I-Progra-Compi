package interpreter;

import java.util.Stack;


public class EvaluationStack {
    private Stack<Object> evalStack;

    public EvaluationStack(){
        this.evalStack= new Stack<Object>();
    }

    public void pushValue(Object elem){
        this.evalStack.push(elem);
    }

    public Object popValue(){
        return this.evalStack.pop();
    }
}
