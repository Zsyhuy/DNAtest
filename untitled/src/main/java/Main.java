import syntaxtree.Node;

public class Main {
    public static void main(String[] args) {
        String[] files = {
                "test1.c",
                "test2.c",
                "test3.c"
        };
        String[] answer = {
                "IEZHIEZICIIQIPRI",
                "IEZHIEZICIIQIPRIARI",
                "HIEZICIIPWIERIARI"
        };
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            String dna = Main.genDNA(file);
            System.out.printf("%b\t%s\n", dna.equals(answer[i]), dna);
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
