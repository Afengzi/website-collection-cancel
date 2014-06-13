package com.afengzi.website.dao.technology;

import com.afengzi.website.domain.site.techonlogy.Technology;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-11
 * Time: 下午5:13
 * To change this template use File | Settings | File Templates.
 */
public interface TechnologyDao {
    /**
     * 插入一条技术站点
     * @param dbObject
     */
    public void insert(DBObject dbObject);

    /**
     * 获取技术站点
     * @param dbObject
     * @return
     */
    public DBCursor queryTechnologyList(DBObject dbObject);
}
