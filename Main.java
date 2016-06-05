import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class Main {
    public static int minLat;
    public static int minLon;
    public static int maxLat;
    public static int maxLon;

    public static void main(String[] args) {
        try {
            CharStream input = new ANTLRFileStream(args[0]);
            OSMLexer lex = new OSMLexer(input);

            CommonTokenStream tokens = new CommonTokenStream(lex);
            OSMParser parser = new OSMParser(tokens);
            OSMParser.document_return root = parser.document();
            CommonTree root_tree = (CommonTree) root.tree;
            walkTree(root_tree, 0);
        } catch (Throwable t) {
            System.out.println("exception: " + t);
            t.printStackTrace();
        }
    }

    public static void walkTree(CommonTree t, int indent) {
        if (t != null) {
            StringBuffer sb = new StringBuffer(indent);

            for (int i = 0; i < t.getChildCount(); i++) {
                Tree child = t.getChild(i);
                if (child.getChildCount() == 0) continue;

                if (!isAttribute(child)) {
                    if (isBounds(child))
                        handleBounds(child);
                    else if (isNode(child))
                        handleNode(child);
                    else if (isWay(child))
                        handleWay(child);
                    else
                        System.out.println(child.toString());
                }
            }
        }
    }

    public static boolean isAttribute(Tree t) {
      return t.getText().toString().equals("ATTRIBUTE");
    }

    public static boolean isWay(Tree t) {
      return t.getChild(0).getText().toString().equals("way");
    }

    public static boolean isNode(Tree t) {
      return t.getChild(0).getText().toString().equals("node");
    }

    public static boolean isBounds(Tree t) {
      return t.getChild(0).getText().toString().equals("bounds");
    }

    public static void handleWay(Tree t) {
      System.out.println("\nI'm handling a way:");
      System.out.println(t.toStringTree());
    }

    public static void handleNode(Tree t) {
      System.out.println("\nI'm handling a node:");
      System.out.println(t.toStringTree());
    }

    public static void handleBounds(Tree t) {
      System.out.println("\nI'm handling bounds:");
      System.out.println(t.toStringTree());
    }
}
