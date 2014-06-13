package com.afengzi.website.util;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * <title>Bean2DBObjectUril</title>
 * <p/>
 * <project>website-collection</project>
 * <p/>
 * <package>com.afengzi.website.util</package>
 * <p/>
 * <file>Bean2DBObjectUril.java</file>
 * <p/>
 * <date>2014年6月10日 下午11:40:57</date>
 * <p/>
 * <brief></brief>
 *
 * @author klov
 */
public class Bean2DBObjectUril {

    private static final Logger logger = Logger.getLogger("Bean2DBObjectUril");
     /**
     * @param objList
     * @return
     */
    public static List<DBObject> convertLisr(List<Object> objList) {
        List<DBObject> dbObjList = new ArrayList<DBObject>();
        if (objList == null || objList.isEmpty()) {
            return dbObjList;
        }
        for (Object obj : objList) {
            if (obj == null) {
                continue;
            }
            dbObjList.add(convertObject(obj));
        }
        return dbObjList;

    }

    /**
     * @param obj
     * @return
     */
    public static DBObject convertObject(Object obj) {
        DBObject dbObj = new BasicDBObject();
        if (obj == null) {
            return dbObj;
        }
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field == null) {
                continue;
            }
            field.setAccessible(true);
            String key = field.getName();
            try {
                Object value = field.get(obj);
                dbObj.put(key, value);
            } catch (IllegalArgumentException e) {
                logger.error(e);
            } catch (IllegalAccessException e) {
               logger.error(e);
            }

        }
        return dbObj;

    }

    public static <T> T convertDbobject(DBObject dbObject, T object) {
        if (dbObject == null || object == null) {
            return object;
        }
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            try {
                field.set(object, dbObject.get(fieldName));
            } catch (IllegalAccessException e) {
                logger.error("convert Object T to DBObject error",e);
            }
        }
        return object;
    }


}
