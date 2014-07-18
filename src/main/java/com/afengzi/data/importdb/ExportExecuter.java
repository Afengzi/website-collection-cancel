package com.afengzi.data.importdb;

import org.apache.commons.collections.CollectionUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-7-17
 * Time: 下午5:06
 * 导出执行器
 */
public class ExportExecuter extends MongoBase {

    private static final String WEBSITE_DIRECTORY = "website.directory" ;
    private static final String WEBSITE_SEQUENCE_VALUE = "website.sequence_value" ;
    private static final String WEBSITE_SITES = "website.sites" ;

    private static final String BASE_PATH = "D:\\website.data\\" ;

    public static void main(String[] args){
        ExportExecuter executer = new ExportExecuter();
        executer.executer() ;
    }

    private void executer(){
        exportData(WEBSITE_DIRECTORY) ;
        exportData(WEBSITE_SEQUENCE_VALUE) ;
        exportData(WEBSITE_SITES) ;
    }

    private boolean exportData(String collection){
        List<String> directorys = findAndGetStrings(collection) ;
        if (CollectionUtils.isEmpty(directorys)){
            System.out.println("read records size from db is 0.collection : "+collection);
            return false ;
        }
        String path = createDirAndGetPath(collection) ;
        ScriptWriter.writeContent(directorys,path);
        return true ;
    }



    private String createDirAndGetPath(String collection){
        StringBuilder path = new StringBuilder(BASE_PATH) ;
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss") ;
        String today = format.format(new Date()) ;
        path.append(today);
        File dir = new File(path.toString()) ;
        if (!dir.exists()){
            if (!dir.mkdirs()){
                System.out.println("the directory is no exist,but create fail.path : " + path);
                return "" ;
            }
        }
        path.append(File.separator).append(collection) ;
        return path.toString() ;
    }

}
