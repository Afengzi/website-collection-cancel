package com.afengzi.website.util;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoOptions;
import org.springframework.stereotype.Component;

/**
 * <title>MongoDataSource</title>
 * 
 * <project>website-collection</project>
 * 
 * <package>com.afengzi.website.dao</package>
 * 
 * <file>MongoDataSource.java</file>
 * 
 * <date>2014年6月10日 下午11:12:18</date>
 * 
 * <brief>mongodb驱动数据源
 * connectionsPerHost：每个主机的连接数
 * threadsAllowedToBlockForConnectionMultiplier：线程队列数，
 * 	它以上面connectionsPerHost值相乘的结果就是线程队列最大值。如果连接线程排满了队列就会抛出“Out of semaphores to
 * 	get db”错误。 maxWaitTime:最大等待连接的线程阻塞时间 
 * connectTimeout：连接超时的毫秒。0是默认和无限
 * socketTimeout：socket超时。0是默认和无限
 * autoConnectRetry：这个控制是否在一个连接时，系统会自动重试
 * </brief>
 * 
 * @author klov
 * 
 */
public class MongoDataSource {

	private int poolSize;
	private boolean autoConnectRetry;
	private int maxWaitTime;

	protected Mongo mongo;

	private String host;
	private int port;
	private String databaseName; 

	public MongoDataSource(int poolSize, boolean autoConnectRetry, int maxWaitTime, String host,
			int port,String databaseName) {
		super();
		this.poolSize = poolSize;
		this.autoConnectRetry = autoConnectRetry;
		this.maxWaitTime = maxWaitTime;
		this.host = host;
		this.port = port;
		this.databaseName=databaseName;

		initMongo();
	}

	protected void initMongo() {
		try {
			mongo = new Mongo(host, port);
		} catch (UnknownHostException e) {
			throw new RuntimeException("can not connection mongodb host", e);
		}
		MongoOptions option = mongo.getMongoOptions();
		option.setAutoConnectRetry(autoConnectRetry);
		option.setConnectionsPerHost(poolSize);
		option.setMaxWaitTime(maxWaitTime);

	}

	/**
	 * 获取mongodb
	 * @return
	 */
	public Mongo getMongo() {
		return mongo;
	}
	/**
	 * 获取DB
	 * @return
	 */
	public DB getDb(){
		return mongo.getDB(databaseName);
	}

	public int getPoolSize() {
		return poolSize;
	}

	public void setPoolSize(int poolSize) {
		this.poolSize = poolSize;
	}

	public boolean isAutoConnectRetry() {
		return autoConnectRetry;
	}

	public void setAutoConnectRetry(boolean autoConnectRetry) {
		this.autoConnectRetry = autoConnectRetry;
	}

	public int getMaxWaitTime() {
		return maxWaitTime;
	}

	public void setMaxWaitTime(int maxWaitTime) {
		this.maxWaitTime = maxWaitTime;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setMongo(Mongo mongo) {
		this.mongo = mongo;
	}

}
