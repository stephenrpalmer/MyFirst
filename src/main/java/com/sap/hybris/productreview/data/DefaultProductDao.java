package com.sap.hybris.productreview.data;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.Map;

import org.bson.Document;
import org.springframework.stereotype.Repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.sap.hybris.productreview.ProductSummary;

/**
 *
 *
 */
@Repository
public class DefaultProductDao implements ProductDao {

	/** keys for mongodb attributes of a product review */
	private static final String ID = "_id";
	private static final String CODE = "code";
	private static final String NAME = "name";
	private static final String THUMBNAIL = "thumbnail";

	/** mongodb collection that holds product summaries */
	private static final String PRODUCT_SUMMARY_COLLECTION = "products";

	@Override
	public ProductSummary getProductByCode(String code) {

		ProductSummary productSummary = null;
		try {
			MongoDatabase database = MongoDatabaseFactory.getInstance();
			MongoCollection<Document> reviews = database.getCollection(PRODUCT_SUMMARY_COLLECTION);

			Document query = new Document(CODE, code);
			Document result = null;
			for (Document dbReview : reviews.find(query)) {
				if (result != null) {
					throw new DuplicateObjectException("Multiple products found for code " + code);
				}
				result = dbReview;
			}

			if (result == null) {
				throw new NoSuchObjectException("Product not found for code " + code);
			}
			productSummary = toProductSummary(result);
		} catch (UnknownHostException e) {
			e.printStackTrace(); // add logging
		}
		return productSummary;
	}

	@Override
	public ProductSummary getProductById(String productId) {
		ProductSummary productSummary = null;
		try {
			MongoDatabase database = MongoDatabaseFactory.getInstance();
			MongoCollection<Document> reviews = database.getCollection(PRODUCT_SUMMARY_COLLECTION);

			Document query = new Document(ID, productId);
			Document result = null;
			for (Document dbReview : reviews.find(query)) {
				if (result != null) {
					throw new DuplicateObjectException("Multiple products found for id " + productId);
				}
				result = dbReview;
			}

			if (result == null) {
				throw new NoSuchObjectException("Product not found for id " + productId);
			}
			productSummary = toProductSummary(result);
		} catch (UnknownHostException e) {
			e.printStackTrace(); // add logging
		}
		return productSummary;
	}

	@Override
	public ProductSummary addProductSummary(ProductSummary productSummary) {
		try {
			MongoDatabase database = MongoDatabaseFactory.getInstance();
			MongoCollection<Document> reviews = database.getCollection(PRODUCT_SUMMARY_COLLECTION);

			String id = createUniqueId(productSummary);
			Document dbReview = new Document(ID, id).append(CODE, productSummary.getProductId())
					.append(NAME, productSummary.getProductName())
					.append(THUMBNAIL, productSummary.getProductThumbnail());

			// add tags as additional attributes in db object
			for (String tag : productSummary.getTags().keySet()) {
				dbReview.append(tag, productSummary.getTags().get(tag));
			}

			reviews.insertOne(dbReview);
			productSummary.setId(id);
		} catch (UnknownHostException e) {
			e.printStackTrace(); // add logging
		}
		return productSummary;
	}

	/**
	 *
	 * @param dbReview
	 * @return
	 */
	public static ProductSummary toProductSummary(Document dbProduct) {

		ProductSummary productSummary = new ProductSummary();
		for (Map.Entry<String, Object> entry : dbProduct.entrySet()) {
			switch (entry.getKey()) {
			case ID:
				productSummary.setId((String) entry.getValue());
				break;
			case CODE:
				productSummary.setProductId((String) entry.getValue());
				break;
			case NAME:
				productSummary.setProductName((String) entry.getValue());
				break;
			case THUMBNAIL:
				productSummary.setProductThumbnail((String) entry.getValue());
				break;
			default:
				productSummary.getTags().put(entry.getKey(), (String) entry.getValue());
				break;
			}
		}
		return productSummary;
	}

	/**
	 * accessor for collection name used to store reviews
	 *
	 * @return
	 */
	public static String getCollectionName() {
		return PRODUCT_SUMMARY_COLLECTION;
	}

	/**
	 * generate a globally unique id for a product review
	 *
	 * @param productReview
	 *            the product review that needs a unique id
	 * @return globally unique id for the specified product review
	 */
	protected static String createUniqueId(ProductSummary productSummary) {
		return "PR" + new Date().getTime();
	}

}
