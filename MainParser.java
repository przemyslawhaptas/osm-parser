import  org.antlr.runtime.*;
import  org.antlr.runtime.tree.*;

public  class MainParser {
    public static void main(String[] args)  {
     try {
           CharStream input = new ANTLRFileStream(args[0]);
           OSMLexer lex = new OSMLexer(input);
           CommonTokenStream tokens = new  CommonTokenStream(lex);

           OSMParser parser = new OSMParser(tokens);
           parser.document();
       }  catch(Throwable t) {
           System.out.println("exception: " + t);
           t.printStackTrace();
       }
    }
}
