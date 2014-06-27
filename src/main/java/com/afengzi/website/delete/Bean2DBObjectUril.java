package com.afengzi.website.delete;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        DBObject dbObject = new BasicDBObject();
        if (obj == null) {
            return dbObject;
        }
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field == null) {
                continue;
            }
            field.setAccessible(true);
            String varName = field.getName();
            try {
                Object param = field.get(obj);

                if (param == null) {
                    continue;
                } else if (param instanceof Integer) {//判断变量的类型
                    int value = ((Integer) param).intValue();
                    dbObject.put(varName, value);
                } else if (param instanceof String) {
                    String value = (String) param;
                    dbObject.put(varName, value);
                } else if (param instanceof Double) {
                    double value = ((Double) param).doubleValue();
                    dbObject.put(varName, value);
                } else if (param instanceof Float) {
                    float value = ((Float) param).floatValue();
                    dbObject.put(varName, value);
                } else if (param instanceof Long) {
                    long value = ((Long) param).longValue();
                    dbObject.put(varName, value);
                } else if (param instanceof Boolean) {
                    boolean value = ((Boolean) param).booleanValue();
                    dbObject.put(varName, value);
                } else if (param instanceof Date) {
                    Date value = (Date) param;
                    dbObject.put(varName, value);
                } else if(param instanceof List) {
                    List paramList = (List) param;
                    for (Object beanObj : paramList) {
                        dbObject.put(varName, convertObject(beanObj));
                    }

                }

            } catch (IllegalArgumentException e) {
                logger.error(e);
            } catch (IllegalAccessException e) {
                logger.error(e);
            }

        }
        return dbObject;

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
                logger.error("convert Object T to DBObject error", e);
            }
        }
        return object;
    }


}
