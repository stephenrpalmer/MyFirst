package com.sap.hybris.productreview.data;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.bson.Document;
import org.junit.Test;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDatabaseFactoryTest {
	@Test
	public void shouldGetADatabaseFromTheMongoClient() throws Exception {

		// When
		MongoDatabase database = MongoDatabaseFactory.getInstance();

		// Then
		assertThat(database, is(notNullValue()));
	}

	@Test
	public void shouldGetACollectionFromTheDatabase() throws Exception {
		// Given
		MongoDatabase database = MongoDatabaseFactory.getInstance();

		// When
		MongoCollection<Document> collection = database.getCollection("TheCollectionName");

		// Then
		assertThat(collection, is(notNullValue()));
	}

}
