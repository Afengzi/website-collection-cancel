package com.afengzi.data.importdb;

import com.afengzi.website.util.StringUtil;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-7-12
 * Time: 下午1:15
 * To change this template use File | Settings | File Templates.
 */
public class ImportExecuter extends MongoBase {

    private static final String path ="scriptpath" ;
    private static final String COLLECTION_NAME ="collection.name" ;

    public static void main(String[] args){
        ImportExecuter executer = new ImportExecuter();
        executer.execute() ;
    }

    private boolean execute(){
        Map<String,List<DBObject>> dbObjectMap = new HashMap<String, List<DBObject>>() ;
        Map<String,List<String>> scriptNameAndContent = ScriptReader.reader(path) ;
        if (scriptNameAndContent==null || scriptNameAndContent.isEmpty()){
            System.out.println("there is no content...");
        }
        Set<Map.Entry<String,List<String>>> entrySet = scriptNameAndContent.entrySet() ;
        for (Map.Entry<String,List<String>> entry : entrySet){
            batchSave(string2DbObject(entry.getValue()), entry.getKey());
            System.out.println("**************import end.save collection " +entry.getKey()+" , size : "+entry.getValue().size());
        }

        return true ;
    }

    private void insert(DBObject dbObject,String collectionName){
        System.out.println("************begin insert collection: "+collectionName+"*************");
        System.out.println("************script : "+dbObject.toString());
        save(dbObject, collectionName);

    }
    private List<DBObject> string2DbObject(List<String> strings){
        List<DBObject> dbObjects = new ArrayList<DBObject>() ;
        if (CollectionUtils.isEmpty(strings)){
            return dbObjects ;
        }
        DBObject dbObject = null ;
        for (String string : strings){
            if (StringUtils.isBlank(string)){
                continue;
            }
            dbObject = (DBObject)JSON.parse(string) ;
            dbObjects.add(dbObject) ;
        }
        return dbObjects ;
    }
}
