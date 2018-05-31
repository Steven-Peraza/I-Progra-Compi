package textpademo;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.util.concurrent.CancellationException;


public class ThrowingErrorListener extends BaseErrorListener{
    public static final ThrowingErrorListener INSTANCE = new ThrowingErrorListener();

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e)
                throws ParseCancellationException {
            String msg2;
            if(msg.contains("mismatched")){
                msg2 = "Error de Sintaxis ";
            }
            else{
                msg2 = "falta una expresion";
            }
            System.err.println("Error \""+msg2+"\" en la linea " + line+" y en la posicion "+charPositionInLine+"\n\n\n");

            throw new ParseCancellationException("line " + line + ":" + charPositionInLine + " " + msg);
        }


        }