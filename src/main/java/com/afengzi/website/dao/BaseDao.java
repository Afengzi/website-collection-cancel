package com.afengzi.website.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;

/**
 * <title>BaseDao</title>
 * <p/>
 * <project>website-collection</project>
 * <p/>
 * <package>com.afengzi.website.dao</package>
 * <p/>
 * <file>BaseDao.java</file>
 * <p/>
 * <date>2014年6月10日 下午10:53:16</date>
 * <p/>
 * <brief> </brief>
 *
 * @author klov
 */
public class BaseDao {

    private static final Logger logger = Logger.getLogger("BaseDao");

    protected DBObject convertWebsiteBean(Object website) {
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
                if (value != null) {
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
