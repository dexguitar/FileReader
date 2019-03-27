// Reader

package com.doglabel.com;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {

    public String fileToString(File file) {
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

    public String analyze(String str) {
        int count = 0;
        String keywords = "abstract|assert|boolean|break|byte|case|catch|char|class|continue|default" +
                "|do|double|else|enum|extends|final|finally|float|for|if|implements|import|instanceof" +
                "|int|interface|long|native|new|null|package|private|protected|public|return|short" +
                "|static|strictfp|super|switch|synchronized|this|throw|throws|transient|try|void|volatile|while";

        Pattern p = Pattern.compile(keywords);
        Matcher m = p.matcher(str);

        StringBuilder sb = new StringBuilder();

        while (m.find()) {
            sb.append(m.group() + "\n");
            count++;
        }

        return sb.toString() + "\n" + "total: " + String.valueOf(count);
    }

    public void writeToFile(String str) {
        File output = new File("src/test1.txt");

        try (BufferedWriter os = new BufferedWriter(new FileWriter(output))) {
            os.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
