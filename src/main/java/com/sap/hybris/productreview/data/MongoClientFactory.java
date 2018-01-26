package com.sap.hybris.productreview.data;

import java.net.UnknownHostException;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * Dodgy singleton class to get hold of client
 * 
 * Not thread safe and throwing low-level exception, yuck 
 * 
 * replace with spring bean because that is what spring is good for
 */
public class MongoClientFactory {

	private static final String MONGODB = "mongodb://localhost:27017";

	/**
	 * private constructor to avoid multiple instances being created
	 */
	private MongoClientFactory() {
		super();
	}

	private static MongoClient mongoClient = null;

	public static MongoClient getInstance() throws UnknownHostException {
		if (mongoClient == null) {
			mongoClient = new MongoClient(new MongoClientURI(MONGODB));
		}
		return mongoClient;
	}
	
	/**
	 * 
	 * @return
	 */
	public static String getMongoServerURL() {
		return MONGODB;
	}
}
