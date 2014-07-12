package com.afengzi.website.test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-7-12
 * Time: 下午1:18
 * To change this template use File | Settings | File Templates.
 */
public class ScriptReader {
    private static final String STARTLINE = "---start";
    private static final String ENDLINE = "---end";

    public static List<String> reader(String properName) {
        ResourceBundle bundle = ResourceBundle.getBundle(properName) ;
        Object filePath = bundle.getString("db.script.path");
        if (filePath == null) {
            throw new IllegalArgumentException("脚本不存在.");
        }

        try {
            FileReader fr = new FileReader(filePath.toString());
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            StringBuilder builder = null;
            List<StringBuilder> builders = new ArrayList<StringBuilder>();
            while ((line = br.readLine()) != null) {
                if (line.startsWith(STARTLINE)) {
                    builder = new StringBuilder();
                    builders.add(builder);
                }
                line = br.readLine();
                if (line != null && line.length() > 0 && !line.endsWith(ENDLINE)) {
                    builder.append(line);
                }
            }
            return readContent(builders);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    private static List<String> readContent(List<StringBuilder> builders) {
        List<String> strings = new ArrayList<String>(builders.size());
        for (StringBuilder builder : builders) {
            if (builder == null) {
                continue;
            }
            strings.add(builder.toString());
        }
        return strings;
    }


    public static void main(String[] args) {
        InputStream inputStream = ScriptReader.class.getResourceAsStream("src/main/java/com/afengzi/website/scriptpath.properties") ;
        try {
            System.out.println(inputStream.available());
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        InputStream inputStream2 = ClassLoader.getSystemResourceAsStream("main/java/com/afengzi/website/scriptpath.properties") ;
        try {
            System.out.println(inputStream2.available());
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        ResourceBundle bundle = ResourceBundle.getBundle("com.afengzi.website.test.scriptpath");
        System.out.println(bundle.getString("db.script.path"));
    }

}
