import Checker.CheckerSB;
import generated.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileReader;
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
        input = new ANTLRInputStream(new FileReader("victory.txt"));
        inst = new ScannerSS4(input);
        tokens = new CommonTokenStream(inst);
        parser = new ParserUI(tokens);
        ParseTree tree = parser.program();
        java.util.concurrent.Future <JFrame> treeGUI = org.antlr.v4.gui.Trees.inspect(tree,parser);
        treeGUI.get().setVisible(true);
    }
        catch(Exception e){System.out.println("No hay archivo");}


        try {
        ParseTree tree = parser.program();
        CheckerSB v=new CheckerSB();
        v.visit(tree);
        System.out.println("Compilación Exitosa!!\n");
    }
        catch(RecognitionException e){
        System.out.println("Compilación Fallida!!");
    }
}

}
