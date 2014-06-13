package com.afengzi.website.dao.technology.impl;

import com.afengzi.website.dao.BaseDao;
import com.afengzi.website.dao.technology.TechnologyDao;
import com.afengzi.website.domain.site.techonlogy.Technology;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-11
 * Time: ÏÂÎç8:21
 * To change this template use File | Settings | File Templates.
 */
public class TechnologyDaoImpl extends BaseDao implements TechnologyDao {
    @Override
    public void insert(DBObject dbObject) {
        persist(dbObject);
    }

    @Override
    public DBCursor queryTechnologyList(DBObject dbObject) {
        return query(dbObject);
    }
}
