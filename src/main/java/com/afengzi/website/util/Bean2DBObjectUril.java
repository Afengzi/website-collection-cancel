package com.afengzi.website.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * <title>Bean2DBObjectUril</title>
 * 
 * <project>website-collection</project>
 * 
 * <package>com.afengzi.website.util</package>
 * 
 * <file>Bean2DBObjectUril.java</file>
 * 
 * <date>2014年6月10日 下午11:40:57</date>
 * 
 * <brief></brief>
 * 
 * @author klov
 * 
 */
public class Bean2DBObjectUril {

	/**
	 * 
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
	 * 
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
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

		}
		return dbObj;

	}
}
