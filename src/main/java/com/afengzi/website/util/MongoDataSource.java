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
 * <date>2014��6��10�� ����11:12:18</date>
 * 
 * <brief>mongodb��������Դ
 * connectionsPerHost��ÿ��������������
 * threadsAllowedToBlockForConnectionMultiplier���̶߳�������
 * 	��������connectionsPerHostֵ��˵Ľ�������̶߳������ֵ����������߳������˶��оͻ��׳���Out of semaphores to
 * 	get db������ maxWaitTime:���ȴ����ӵ��߳�����ʱ�� 
 * connectTimeout�����ӳ�ʱ�ĺ��롣0��Ĭ�Ϻ�����
 * socketTimeout��socket��ʱ��0��Ĭ�Ϻ�����
 * autoConnectRetry����������Ƿ���һ������ʱ��ϵͳ���Զ�����
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
	 * ��ȡmongodb
	 * @return
	 */
	public Mongo getMongo() {
		return mongo;
	}
	/**
	 * ��ȡDB
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
