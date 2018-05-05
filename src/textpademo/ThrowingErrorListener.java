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
            if(msg.contains("mismatched")){
                msg = "Se encontro algo inesperado";
            }
            else{
                msg = "falta una expresion";
            }
            System.err.println("Error \""+msg+"\" en la linea " + line+" y en la posicion "+charPositionInLine);
            throw new ParseCancellationException("line " + line + ":" + charPositionInLine + " " + msg);
        }


        }