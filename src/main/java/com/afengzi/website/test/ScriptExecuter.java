package com.afengzi.website.test;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-7-12
 * Time: 下午1:15
 * To change this template use File | Settings | File Templates.
 */
public class ScriptExecuter extends MongoBase {

    private static final String path ="com.afengzi.website.test.scriptpath" ;
    private static final String COLLECTION_NAME ="collection.name" ;

    public static void main(String[] args){
        ScriptExecuter executer = new ScriptExecuter();
        executer.execute() ;
    }

    private boolean execute(){
        List<DBObject> dbObjects = getScript() ;
        for (DBObject dbObject : dbObjects){
            String collectionName = dbObject.get(COLLECTION_NAME).toString() ;
            dbObject.removeField(COLLECTION_NAME) ;
            insert(dbObject, collectionName) ;
        }
        System.out.println("**************执行完成.save size : "+dbObjects.size());
        return true ;
    }

    private void insert(DBObject dbObject,String collectionName){
        System.out.println("************begin insert collection: "+collectionName+"*************");
        System.out.println("************script : "+dbObject.toString());
        save(dbObject, collectionName);

    }

    private List<DBObject> getScript(){
        List<String> scriptList = ScriptReader.reader(path) ;
        if (scriptList==null || scriptList.isEmpty()){
            System.out.println("未读取到的脚本内容");
        }

        List<DBObject> dbObjects = new ArrayList<DBObject>() ;
        DBObject dbObject = null ;
        for (String script : scriptList){
            if (script==null||script.isEmpty()){
                continue;
            }
            dbObject = (DBObject)JSON.parse(script) ;
            dbObjects.add(dbObject) ;
        }
        return dbObjects ;
    }
}
