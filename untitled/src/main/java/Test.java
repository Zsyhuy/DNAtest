import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<String, String> test = new HashMap<String, String>();
        test.put("test1.c", "IEZHIEZICIIQIPRI");
        test.put("test2.c", "IEZHIEZICIIQIPRIARI");
        test.put("test3.c", "HIEZICIIPWIERIARI");

        for (String filename : test.keySet()
        ) {
            String dna;
            try {
                dna = DNAReq.genDNA(filename);
            } catch (ParseException e) {
                System.err.println("Encountered errors during parse.");
                e.printStackTrace();
                return;
            } catch (java.io.FileNotFoundException e) {
                System.err.println("File " + filename + " not found.");
                e.printStackTrace();
                return;
            }
            System.out.println(dna.equals(test.get(filename)) + "\t" + dna);
        }

        test2 String[]
    }
}
