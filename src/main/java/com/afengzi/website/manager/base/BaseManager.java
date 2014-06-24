package com.afengzi.website.manager.base;

import com.afengzi.website.domain.site.ModuleVo;
import com.afengzi.website.domain.site.Website;
import com.afengzi.website.domain.site.WebsiteVo;
import com.afengzi.website.domain.typeenum.CategoryTypeEnum;
import com.afengzi.website.domain.typeenum.TechnologyModuleKindEnum;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

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
    protected ModuleVo convert2ModuleVo(List<Website> websiteList,int kindEnum){
        ModuleVo moduleVo = new ModuleVo();
        List<WebsiteVo> WebsiteVoList = new ArrayList<WebsiteVo>() ;
        WebsiteVo websiteVo = null ;
        for (Website website : websiteList){
            if(website==null){
                continue;
            }
            if (kindEnum==CategoryTypeEnum.TECHNOLOGY.getValue()){
                for (TechnologyModuleKindEnum technologyModuleKindEnum : TechnologyModuleKindEnum.values()){
                    if (website.getModuleKind()== technologyModuleKindEnum.getValue()){
                        websiteVo = convert2WebsiteVo(website);
                        WebsiteVoList.add(websiteVo);
                    }
                }

            }
//            if (kindEnum == CategoryTypeEnum.LIFE.getValue())

        }
        moduleVo.setWebsiteVoList(WebsiteVoList);
        return moduleVo;
    }

    protected List<ModuleVo> getModuleVoList(DBCursor cursor, int categoryType) {

        List<Website> websiteList = new ArrayList<Website>();
        if (cursor == null) {
            return null;
        }
        Website website = null;
        while (cursor.hasNext()) {
            website = new Website();
            convertDBObject(cursor.next(), website);
            if (website != null) {
                websiteList.add(website);
            }
        }
        List<ModuleVo> moduleVoList = new ArrayList<ModuleVo>();
        ModuleVo moduleVo = null;

        moduleVo = convert2ModuleVo(websiteList, categoryType);
        if (moduleVo != null) {
            moduleVoList.add(moduleVo);
        }
        return moduleVoList;

    }


    private WebsiteVo convert2WebsiteVo(Website website){
        WebsiteVo websiteVo = new WebsiteVo();
        websiteVo.setId(website.getId());
        websiteVo.setDescription(website.getDescription());
        websiteVo.setModuleKine(website.getModuleKind());
        websiteVo.setTitle(website.getTitle());
        websiteVo.setUrl(website.getUrl());
        return websiteVo;
    }

}
