import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class Main {
    public static void main(String[] args) {
     try {
         CharStream input = new ANTLRFileStream(args[0]);
         OSMLexer lex = new OSMLexer(input);

         CommonTokenStream tokens = new CommonTokenStream(lex);
         OSMParser parser = new OSMParser(tokens);
         OSMParser.document_return root = parser.document();
         System.out.println("tree="+((Tree)root.tree).toStringTree());

         CommonTreeNodeStream nodes = new CommonTreeNodeStream((Tree)root.tree);
         OSMTreeParser walker = new OSMTreeParser(nodes);
         walker.document();
     } catch(Throwable t) {
         System.out.println("exception: "+t);
         t.printStackTrace();
     }
    }
}
