import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class MainLexer {
    public static void main(String[] args) {
        try {
           CharStream input = new ANTLRFileStream(args[0]);
           OSMLexer lexer = new OSMLexer(input);
           Token token;
           while ((token = lexer.nextToken()).getText() != "<EOF>") {
          //  while ((token = lexer.nextToken())!=Token.EOF_TOKEN) {
             System.out.println("Token: "+token.getText());
           }
        } catch(Throwable t) {
           System.out.println("Exception: "+t);
           t.printStackTrace();
        }
    }
}
