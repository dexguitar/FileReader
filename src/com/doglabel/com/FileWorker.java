package com.doglabel.com;

import javax.lang.model.SourceVersion;
import java.io.*;

public class FileWorker {

    public static String fileToString(File file) {
        String line;
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ( (line = br.readLine()) != null ) {
                if (line == "") {
                    continue;
                } else {
                    sb.append(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public static String analyze(String str) {
        int count = 0;

        String[] splitStr = str.split(" ");

        StringBuilder sb = new StringBuilder();

        for (String string: splitStr) {
            if (SourceVersion.isKeyword(string)) {
                sb.append(string + "\n");
                count++;
            }
        }

        return sb.toString() + "\n" + "total: " + String.valueOf(count);
    }

    public static void writeToFile(String str, String filePath) {
        File output = new File(filePath);

        try (BufferedWriter os = new BufferedWriter(new FileWriter(output))) {
            os.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
