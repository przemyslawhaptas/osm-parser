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
            CommonTree root_tree = (CommonTree) root.tree;
            printTree(root_tree, 0);
            // System.out.println("tree=" + (root_tree).toStringTree());
            // CommonTreeNodeStream nodes = new CommonTreeNodeStream((Tree)root.tree);
            // OSMTreeParser walker = new OSMTreeParser(nodes);
            // walker.document();
        } catch (Throwable t) {
            System.out.println("exception: " + t);
            t.printStackTrace();
        }
    }

    public static void printTree(CommonTree t, int indent) {
        if (t != null) {
            StringBuffer sb = new StringBuffer(indent);

            if (t.getParent() == null) {
                System.out.println(sb.toString() + t.getText().toString());
            }
            for (int i = 0; i < indent; i++)
                sb = sb.append("   ");
            for (int i = 0; i < t.getChildCount(); i++) {
                System.out.println(sb.toString() + t.getChild(i).toString());
                printTree((CommonTree) t.getChild(i), indent + 1);
            }
        }
    }
}
