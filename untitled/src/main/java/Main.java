import syntaxtree.Node;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> test = new HashMap<String, String>();
        test.put("test1.c", "IEZHIEZICIIQIPRI");
        test.put("test2.c", "IEZHIEZICIIQIPRIARI");
        test.put("test3.c", "HIEZICIIPWIERIARI");

        for (String filename : test.keySet()
        ) {
            String dna = Main.genDNA(filename);
            System.out.println(dna.equals(test.get(filename)) + "\t" + dna);
        }
    }

    public static String genDNA(String file) {
        Parser parser;
        try {
            parser = new Parser(new java.io.FileInputStream(file));
        } catch (java.io.FileNotFoundException e) {
            System.err.println("File " + file + " not found.");
            return null;
        }

        try {
            Node root = parser.TranslationUnit();
//            root.accept(new TreeDumper());
            TreeTransformB transA = new TreeTransformB();
            root.accept(transA);
            return transA.getDNA();
        } catch (ParseException e) {
            System.out.println("Encountered errors during parse.");
            e.printStackTrace();
        }
        return null;
//        return dna.toString();
    }
}
