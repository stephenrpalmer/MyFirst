package com.sap.hybris.productreview.data;

import java.net.UnknownHostException;

import com.mongodb.client.MongoDatabase;

/**
 * Dodgy singleton class to get hold of database
 *
 * Not thread safe and throwing low-level exception, yuck
 *
 * replace with spring bean because that is what spring is good for
 */
public class MongoDatabaseFactory {

	private static MongoDatabase db = null;

	/**
	 * private constructor to avoid multiple instances being created
	 */
	private MongoDatabaseFactory() {
		super();
	}

	public static MongoDatabase getInstance() throws UnknownHostException {
		if (db == null) {
			db = MongoClientFactory.getInstance().getDatabase("Reviews");
		}
		return db;

	}

}
