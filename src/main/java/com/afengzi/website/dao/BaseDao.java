package com.afengzi.website.dao;

import com.afengzi.website.domain.base.Website;
import com.afengzi.website.domain.site.techonlogy.Technology;
import com.afengzi.website.util.Bean2DBObjectUril;
import com.afengzi.website.util.MongoDataSource;
import com.afengzi.website.util.StringUtil;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <title>BaseDao</title>
 * 
 * <project>website-collection</project>
 * 
 * <package>com.afengzi.website.dao</package>
 * 
 * <file>BaseDao.java</file>
 * 
 * <date>2014年6月10日 下午10:53:16</date>
 * 
 * <brief> </brief>
 * 
 * @author klov
 * 
 */
public class BaseDao {

    private static final Logger logger = Logger.getLogger("BaseDao");

	private String collectionName;
	protected DBCollection dbCollection;
    @Autowired
	protected MongoDataSource dataSource;

	
	public BaseDao() {
		super();
	}

	public BaseDao(String collectionName) {
		super();
		this.collectionName = collectionName;
		dbCollection = dataSource.getDb().getCollection(this.collectionName);
	}

	protected void persist(DBObject dbObject){
		dbCollection.insert(dbObject);
	}

    protected DBCursor query(DBObject dbObject){
        return dbCollection.find(dbObject);
    }

	/****************getter and setter*************************/
	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public DBCollection getDbCollection() {
		return dbCollection;
	}

	public void setDbCollection(DBCollection dbCollection) {
		this.dbCollection = dbCollection;
	}

	public MongoDataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(MongoDataSource dataSource) {
		this.dataSource = dataSource;
	}

}
