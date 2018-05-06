import Checker.CheckerSB;
import generated.*;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileReader;
import textpademo.ThrowingErrorListener;

import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;

/**
 * Created by oviquez on 28/2/2018.
 */

public class Main {
    public static void main(String[] args){
        ScannerSS4 inst = null;
    ParserUI parser = null;

    ANTLRInputStream input=null;
    CommonTokenStream tokens = null;
        try {
        input = new ANTLRInputStream(new FileReader("gg.txt"));
        inst = new ScannerSS4(input);
        inst.removeErrorListeners();
        inst.addErrorListener(ThrowingErrorListener.INSTANCE);
        tokens = new CommonTokenStream(inst);
        parser = new ParserUI(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);

        //java.util.concurrent.Future <JFrame> treeGUI = org.antlr.v4.gui.Trees.inspect(tree,parser);
        //treeGUI.get().setVisible(true);
    }
        catch(Exception e){System.out.println("No hay archivo");}

        try {
            ParseTree tree = parser.program();
            CheckerSB v = new CheckerSB();
            int state = (int)v.visit(tree);
            //System.out.println(state);
            if(state != -1) {
                System.out.println("Compilacion Exitosa!!\n");
                TreeViewer viewr = new TreeViewer(Arrays.asList(parser.getRuleNames()),tree);
                viewr.open();
            }else{
                System.out.println("Compilacion Fallida");
            }
    }
        catch(RecognitionException e){
        System.out.println("Compilacion Fallida!!");
    }
}

}
