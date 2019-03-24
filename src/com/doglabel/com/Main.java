package com.doglabel.com;

import java.io.File;

public class Main {

    static File file1 = new File("src/binSearch.java");

    public static void main(String[] args) {

        Reader reader = new Reader();
        String toAnalyze = reader.fileToString(file1);
        String analyzed = reader.analyze(toAnalyze);
        reader.writeToFile(analyzed);

    }

}
