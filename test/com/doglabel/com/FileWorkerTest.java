package com.doglabel.com;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class FileWorkerTest {

    @Test
    public void analyzeShouldReturn32KeywordsFromFile() {
        File file1 = new File("src/flashCard.java");
        String toAnalyze = FileWorker.fileToString(file1);

        assertEquals("class\n" +
                "private\n" + "private\n" + "public\n" + "public\n" + "return\n" +
                "public\n" + "void\n" + "public\n" + "return\n" + "public\n" +
                "void\n" + "\n" + "total: 12", FileWorker.analyze(toAnalyze));
    }

    @Test
    public void analyzeShouldReturn2KeywordsFromFile() {
        File file2 = new File("src/testFile.java");
        String toAnalyze = FileWorker.fileToString(file2);

        assertEquals("public\n" + "class\n" + "\n" +
                "total: 2", FileWorker.analyze(toAnalyze));
    }

    @Test
    public void analyzeShouldReturnNullOnEmptyInput() {
        String toAnalyze = "";

        assertEquals("" + "\n" + "total: 0", FileWorker.analyze(toAnalyze));
    }

    @Test
    public void analyzeShouldReturn2KeywordsFromCorruptFile() {
        File file3 = new File("src/corruptFile.java");
        String toAnalyze = FileWorker.fileToString(file3);

        assertEquals("public\n" + "class\n" + "\n" +
                "total: 2", FileWorker.analyze(toAnalyze));
    }
}