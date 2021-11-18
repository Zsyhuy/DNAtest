package dna;

import dna.ast.syntaxtree.Node;
import dna.ast.ParseException;
import dna.ast.Parser;
import dna.TreeTransformB;

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

    public static List<String> genDNA(List<String> fileList) throws ParseException, FileNotFoundException {
        ArrayList<String> dnaList = new ArrayList<>(fileList.size());
        for (String file : fileList) {
            dnaList.add(DNAReq.genDNA(file));
        }
        return dnaList;
    }
}
