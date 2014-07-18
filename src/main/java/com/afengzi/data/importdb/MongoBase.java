package com.afengzi.data.importdb;

import com.afengzi.website.delete.MongoDataSource;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-26
 * Time: ????9:47
 * To change this template use File | Settings | File Templates.
 */
public class MongoBase {
    private static final Logger logger = Logger.getLogger("MongoBase");
    private static final int poolSize = 20;
    private static final boolean autoConnectRetry = true;
    private static final int maxWaitTime = 2000;
    private static final String host = "127.0.0.1";
    private static final int port = 27017;
    private static final String databaseName = "website";
    protected DB db;
    private MongoDataSource dataSource;

    public MongoBase() {
        dataSource = new MongoDataSource(poolSize, autoConnectRetry, maxWaitTime, host, port, databaseName);
        db = dataSource.getDb();
    }

    public void save(DBObject dbObject, String collectionName) {
        db.getCollection(collectionName).insert(dbObject);

    }

    public void save(Object obj, String collectionName) {
        JSONObject jsonObject = JSONObject.fromObject(obj);
        DBObject dbObject = (DBObject) JSON.parse(jsonObject.toString());
        save(dbObject, collectionName);
    }

    public void batchSave(List<DBObject> dbObjects, String collectionName) {
        for (DBObject dbObject : dbObjects) {
            DBCollection dbCollection = db.getCollection(collectionName);
            try {
                dbCollection.insert(dbObject);
            }catch (Exception e){
                e.printStackTrace();//when _id duplicate ignore
            }

            System.out.println("*********batch insert data£º" + dbObject.toString());
        }
    }

    public List<DBObject> query(String collectionName) {
        List<DBObject> dbObjects = new ArrayList<DBObject>();
        DBCursor cursor = db.getCollection(collectionName).find();
        if (cursor.hasNext()) {
            dbObjects.add(cursor.next());
        }
        return dbObjects;
    }

    public void update(String collectionName, DBObject query, DBObject update, boolean upset, boolean multi) {
        DBCursor cursor = db.getCollection(collectionName).find(query);
        if (cursor.hasNext()) {
            System.out.println(cursor.hasNext());
        }
        db.getCollection(collectionName).update(query, update, upset, multi);
    }

    public void add2Set(String collectionName, DBObject query, DBObject update) {
        System.out.println("***************query : " + query);
        System.out.println("***************update : " + update);
        db.getCollection(collectionName).update(query, update);
    }

    public DBCursor find(String collectionName) {
        return db.getCollection(collectionName).find();
    }

    public List<String> findAndGetStrings(String collectionName) {
        List<String> list = new ArrayList<String>();
        DBCursor cursor = find(collectionName);
        if (cursor.hasNext()) {
            list.add(cursor.next().toString());
        }

        return list;
    }

    public <T> T findObject(String collectionName, Class<T> clazz) {
        DBCursor cursor = find(collectionName);
        if (cursor.hasNext()) {
            DBObject dbObject = cursor.next();
            String dbObjectStr = JSON.serialize(dbObject);
            logger.info("dbObjectStr : " + dbObjectStr);
            return (T) JSONObject.toBean(JSONObject.fromObject(dbObjectStr), clazz);
        }
        return null;
    }
}
