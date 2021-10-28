import syntaxtree.Node;
import visitor.TreeDumper;

public class Main {
    public static void main(String[] args) {
        String[] files = {"test1.c"};
        for (String file :
                files) {
            System.out.println(Main.genDNA(file));
        }
    }

    public static String genDNA(String file) {
        CParser parser;
        try {
            parser = new CParser(new java.io.FileInputStream(file));
        } catch (java.io.FileNotFoundException e) {
            System.err.println("File " + file + " not found.");
            return null;
        }

//        StringBuilder dna = new StringBuilder();

        try {
            Node root = parser.TranslationUnit();
            root.accept(new TreeDumper());
        } catch (ParseException e) {
            System.out.println("Encountered errors during parse.");
            e.printStackTrace();
        }
        return null;
//        return dna.toString();
    }
}
