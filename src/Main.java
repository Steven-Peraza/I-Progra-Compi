import generated.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileReader;
import java.util.List;

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
            input = new ANTLRInputStream(new FileReader("text.txt"));
            inst = new ScannerSS4(input);
            tokens = new CommonTokenStream(inst);
            parser = new ParserUI(tokens);
        }
        catch(Exception e){System.out.println("No hay archivo");}

        /*List<Token> lista = (List<Token>) inst.getAllTokens();

        for (Token t : lista)

            System.out.println(t.getType() + ":" + t.getText() + "\n");

        inst = new Scanner(input);
        //inst.reset();*/

        try {
            ParseTree tree = parser.program();
            System.out.println("Compilación Exitosa!!\n");
        }
        catch(RecognitionException e){
            System.out.println("Compilación Fallida!!");
        }
    }

}