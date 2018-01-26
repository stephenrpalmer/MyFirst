package com.sap.hybris.productreview.data;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.net.UnknownHostException;

import org.bson.Document;
import org.junit.Test;

import com.mongodb.MongoClient;

public class MangoClientFactoryTest {
	@Test
	public void shouldCreateANewMongoClientConnectedToLocalhost() throws Exception {
		// When
		MongoClient mongoClient = MongoClientFactory.getInstance();

		// Then
		assertThat(mongoClient, is(notNullValue()));
	}

	@Test(expected = Exception.class)
	public void shouldNotBeAbleToUseMongoClientAfterItHasBeenClosed() throws UnknownHostException {
		// Given
		MongoClient mongoClient = MongoClientFactory.getInstance();

		// When
		mongoClient.close();

		// Then
		mongoClient.getDatabase("SomeDatabase").getCollection("coll").insertOne(new Document("field", "value"));
	}

}
