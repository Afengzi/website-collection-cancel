package com.afengzi.website.dao;

import java.net.UnknownHostException;

import javax.management.RuntimeErrorException;

import com.afengzi.website.domain.site.technology.Technology;
import com.afengzi.website.util.Bean2DBObjectUril;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoOptions;

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
public abstract class BaseDao {

	private String collectionName;
	protected DBCollection dbCollection;
	protected MongoDataSource dataSource;

	
	public BaseDao() {
		super();
	}

	public BaseDao(String collectionName) {
		super();
		this.collectionName = collectionName;
		dbCollection = dataSource.getDb().getCollection(this.collectionName);
	}

	protected void insert(Technology technology){
		DBObject dbObj = Bean2DBObjectUril.convertObject(technology);
		dbCollection.insert(dbObj);
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
