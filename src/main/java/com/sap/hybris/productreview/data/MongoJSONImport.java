package com.sap.hybris.productreview.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public class MongoJSONImport {

	public static void importJSON(String inputFilename, MongoCollection<Document> collection) {

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(inputFilename));

			String json;

			while ((json = reader.readLine()) != null) {
				collection.insertOne(Document.parse(json));
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
