package com.afengzi.website.dao;

import com.afengzi.website.util.MongoDataSource;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.apache.log4j.Logger;

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
public abstract class BaseDao {

    private static final Logger logger = Logger.getLogger("BaseDao");
    //    @Autowired
    protected MongoDataSource dataSource;

    protected void persist(DBObject dbObject) {
        getDbCollection().insert(dbObject);
    }

    protected DBCursor query(DBObject dbObject) {
        return getDbCollection().find(dbObject);
    }

    public abstract String getCollectionName();

    /**
     * *************getter and setter************************
     */

    public DBCollection getDbCollection() {
        return dataSource.getDb().getCollection(getCollectionName());
    }

    public MongoDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(MongoDataSource dataSource) {
        this.dataSource = dataSource;
    }


}
