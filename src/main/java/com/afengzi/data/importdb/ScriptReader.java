package com.afengzi.data.importdb;

import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.util.*;

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

    public static Map<String,List<String>> reader(String properName) {
        ResourceBundle bundle = ResourceBundle.getBundle(properName, Locale.CHINA);
        Object filePath = bundle.getString("db.import.script.directory.path");
        if (filePath == null) {
            throw new IllegalArgumentException("the script is no exist.");
        }
//        return readerScript(filePath.toString()) ;
        return getScriptAndCollection(filePath.toString()) ;
    }

    private static Map<String,List<String>> getScriptAndCollection(String path){
        Map<String,List<String>> stringListMap = new HashMap<String, List<String>>() ;
        File dir = new File(path) ;
        if (!dir.isDirectory()){
            throw new IllegalArgumentException(path+" is not a directory...") ;
        }
        File[] files = dir.listFiles() ;
        for (File file : files){
            stringListMap.put(file.getName(),readerFormatScript(file)) ;
            System.out.println("read file end . fileName : "+file.getName());
        }
        return stringListMap ;
    }

    private static List<String> readerFormatScript(File file) {
        List<String> strings = new ArrayList<String>();

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                strings.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

    private static List<String> readerScript(File file){
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            StringBuilder builder = null;
            List<StringBuilder> builders = new ArrayList<StringBuilder>();
            while (line != null) {
                if (line.startsWith(STARTLINE)) {
                    builder = new StringBuilder();
                    builders.add(builder);
                }

                if (line != null && line.trim().length() > 0 && !line.endsWith(STARTLINE) && !line.endsWith(ENDLINE)) {
                    builder.append(line);
                }
                line = br.readLine();
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

//        System.out.println(com.afengzi.website.test.ScriptExecuter.class.getResource("/"));
//        System.out.println(com.afengzi.website.test.ScriptExecuter.class.getResource(""));
//        System.out.println(com.afengzi.website.test.ScriptExecuter.class.getClassLoader().getResource("/"));
//        System.out.println(com.afengzi.website.test.ScriptExecuter.class.getClassLoader().getResource(""));
//
//
//        InputStream inputStream = ScriptReader.class.getResourceAsStream("/scriptpath.properties");
//        try {
//            System.out.println(inputStream.available());
//        } catch (Exception e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }
//
//        InputStream inputStream2 = ClassLoader.getSystemResourceAsStream("main/java/com/afengzi/website/scriptpath.properties") ;
//        try {
//            System.out.println(inputStream2.available());
//        } catch (Exception e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }
//
        ResourceBundle bundle = ResourceBundle.getBundle("scriptpath");
        System.out.println(bundle.getString("db.script.path"));
    }

}
