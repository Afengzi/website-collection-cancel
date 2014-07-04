package com.afengzi.website.manager.base;

import com.afengzi.website.domain.BaseDomain;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
* Created with IntelliJ IDEA.
* User: lixiuhai
* Date: 14-6-11
* Time: ÏÂÎç8:09
* To change this template use File | Settings | File Templates.
*/
public class BaseManager {
    private static final Logger logger = Logger.getLogger("BaseManager");

    /**
     * ×ª»»³ÉDBobject
     * @param website
     * @return
     */
    protected DBObject convertWebsiteBean(Object website){
        DBObject dbObj = new BasicDBObject();
        if (website == null) {
            return dbObj;
        }
        Field[] fields = website.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field == null) {
                continue;
            }
            field.setAccessible(true);
            String key = field.getName();
            try {
                Object value = field.get(website);
                if(value!=null){
                    dbObj.put(key, value);
                }
            } catch (IllegalArgumentException e) {
                logger.error(e);
            } catch (IllegalAccessException e) {
                logger.error(e);
            }

        }

        return dbObj;
    }

    protected <T> T convertDBObject(DBObject dbObject,Object obj){
        if(dbObject==null||obj==null){
            return null ;
        }
        Field[] fields = obj.getClass().getDeclaredFields();
        for(Field field : fields){
            if(field==null){
                return null ;
            }
            field.setAccessible(true);
            Object value = dbObject.get(field.getName());
            try {
                field.set(obj,value);
            } catch (IllegalAccessException e) {
                logger.error(e);
            }
        }
        return (T)obj;
    }

    protected <T> List<T> convertDBCursor(DBCursor dbCursor){
        List list = new ArrayList() ;
        if(dbCursor==null){
            return list ;
        }
        Object obj = new Object();
        while (dbCursor.hasNext()){
            Object obj2 = convertDBObject(dbCursor.next(),obj);
            if(obj2!=null){
                list.add(obj) ;
            }
        }
        return list ;

    }

//    protected <T> List<T> sort(List<T> tList){
//        if (CollectionUtils.isEmpty(tList)){
//            return tList ;
//        }
//
//        List<T> result = new LinkedList<T>();
//
//    }


}
