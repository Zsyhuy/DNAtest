import syntaxtree.Node;

import java.util.ArrayList;
import java.io.*;
import java.util.List;

public class DNAReq {
    public static String genDNA(String file) throws ParseException, FileNotFoundException {
        Parser parser;

        parser = new Parser(new FileInputStream(file));

        Node root = parser.TranslationUnit();
        TreeTransformB transA = new TreeTransformB();
        root.accept(transA);
        return transA.getDNA();
    }

    public static List genDNA(List<String> fileList) throws ParseException, FileNotFoundException {
        ArrayList<String> dnaList = new ArrayList<>(fileList.size());
        for (String file : fileList) {
            dnaList.add(DNAReq.genDNA(file));
        }
        return dnaList;
    }
}
