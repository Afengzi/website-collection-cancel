package com.afengzi.data.importdb;

import com.mongodb.DBObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-7-17
 * Time: ÏÂÎç5:23
 * To change this template use File | Settings | File Templates.
 */
public class ScriptWriter {

    public static void writeContent(List<String > contents, String fileName) {
        if (CollectionUtils.isEmpty(contents)) {
            return;
        }
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName);
            for (String content : contents) {
                if (StringUtils.isBlank(content)) {
                    continue;
                }
                writer.write(content.toString());
            }
            writer.flush();
            writer.close();
            System.out.println("*********export end .content size£º" + contents.size() + " ,fileName : " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
