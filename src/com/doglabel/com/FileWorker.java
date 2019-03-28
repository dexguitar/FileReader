// FileWorker

package com.doglabel.com;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String keywords = "\\s?abstract\\s|\\s?assert\\s|\\s?boolean\\s|\\s?break\\s?|\\s?byte\\s|\\s?case\\s|" +
                "\\s?catch\\s|\\s?char\\s|\\s?class\\s|\\s?continue\\s|\\s?default\\s" +
                "|\\s?do\\s|\\s?double\\s|\\s?else\\s|\\s?enum\\s|\\s?extends\\s|\\s?final\\s|" +
                "\\s?finally\\s|\\s?float\\s|\\s?for\\s|\\s?if\\s|\\s?implements\\s|\\s?import\\s|\\s?instanceof\\s" +
                "|\\s?int\\s?|\\s?interface\\s|\\s?long\\s|\\s?native\\s|\\s?new\\s|\\s?null\\s|" +
                "\\s?package\\s|\\s?private\\s|\\s?protected\\s|\\s?public\\s|\\s?return\\s|\\s?short\\s" +
                "|\\s?static\\s|\\s?strictfp\\s|\\s?super\\s|\\s?switch\\s|\\s?synchronized\\s|\\s?this\\s|" +
                "\\s?throw\\s|\\s?throws\\s|\\s?transient\\s|\\s?try\\s|\\s?void\\s|\\s?volatile\\s|\\s?while\\s";

        Pattern p = Pattern.compile(keywords);
        Matcher m = p.matcher(str);

        StringBuilder sb = new StringBuilder();

        while (m.find()) {
            sb.append(m.group().trim() + "\n");
            count++;
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
