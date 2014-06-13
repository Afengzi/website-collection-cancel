package com.afengzi.website.manager.base;

import com.afengzi.website.domain.base.Website;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import java.lang.reflect.Field;
import org.apache.log4j.Logger;

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
}
