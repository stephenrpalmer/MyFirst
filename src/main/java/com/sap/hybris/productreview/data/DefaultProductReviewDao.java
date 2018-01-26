package com.sap.hybris.productreview.data;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.Map;

import org.bson.Document;
import org.springframework.stereotype.Repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.sap.hybris.productreview.ProductReview;

/**
 *
 */
@Repository
public class DefaultProductReviewDao implements ProductReviewDao {

	/** keys for mongodb attributes of a product review */
	private static final String ID = "_id";
	private static final String ORDER = "order";
	private static final String REVIEWER = "reviewer";
	private static final String LANGUAGE = "language";
	private static final String TEXT = "text";
	private static final String RATING = "rating";
	private static final String CONTEXT = "context";
	private static final String PRODUCT = "product";
	private static final String PRIORITY = "priority";
	private static final String STATUS = "status";
	private static final String CREATED = "created";
	private static final String CODE = "code";
	private static final String SUBSCRIBER = "subscriber";

	/** mongodb collection that holds product reviews */
	private static final String PRODUCT_REVIEW_COLLECTION = "reviews";

	/**
	 * successful insert will add unique id to product review domain object
	 */
	@Override
	public ProductReview insertNewProductReview(ProductReview productReview) {
		try {
			MongoDatabase database = MongoDatabaseFactory.getInstance();
			MongoCollection<Document> reviews = database.getCollection(PRODUCT_REVIEW_COLLECTION);

			String id = createUniqueId(productReview);
			Document dbReview = new Document(ID, id).append(SUBSCRIBER, productReview.getServiceSubscriber())
					.append(CODE, productReview.getCode()).append(CREATED, productReview.getCreated())
					.append(STATUS, productReview.getStatus()).append(PRIORITY, productReview.getPriority())
					.append(PRODUCT, productReview.getProduct()).append(CONTEXT, productReview.getContext())
					.append(RATING, productReview.getRating()).append(TEXT, productReview.getText())
					.append(LANGUAGE, productReview.getLanguage()).append(REVIEWER, productReview.getReviewer())
					.append(ORDER, productReview.getOrder());

			// add tags as additional attributes in db object
			for (String tag : productReview.getTags().keySet()) {
				dbReview.append(tag, productReview.getTags().get(tag));
			}

			reviews.insertOne(dbReview);
			productReview.setId(id);
		} catch (UnknownHostException e) {
			e.printStackTrace(); // add logging
		}
		return productReview;
	}

	/**
	 *
	 * @param code
	 * @return
	 */
	@Override
	public ProductReview getProductReviewByCode(String code) {

		ProductReview productReview = null;
		try {
			MongoDatabase database = MongoDatabaseFactory.getInstance();
			MongoCollection<Document> reviews = database.getCollection(PRODUCT_REVIEW_COLLECTION);

			Document query = new Document(CODE, code);
			Document result = null;
			for (Document dbReview : reviews.find(query)) {
				if (result != null) {
					throw new DuplicateObjectException("Multiple reviews found for code " + code);
				}
				result = dbReview;
			}

			if (result == null) {
				throw new NoSuchObjectException("Review not found for code " + code);
			}
			productReview = toProductReview(result);
		} catch (UnknownHostException e) {
			e.printStackTrace(); // add logging
		}
		return productReview;
	}

	/**
	 *
	 * @param dbReview
	 * @return
	 */
	public static ProductReview toProductReview(Document dbReview) {

		ProductReview productReview = new ProductReview();
		for (Map.Entry<String, Object> entry : dbReview.entrySet()) {
			switch (entry.getKey()) {
			case ID:
				productReview.setId((String) entry.getValue());
				break;
			case CODE:
				productReview.setCode((String) entry.getValue());
				break;
			case CONTEXT:
				productReview.setContext((String) entry.getValue());
				break;
			case CREATED:
				productReview.setCreated((Date) entry.getValue());
				break;
			case LANGUAGE:
				productReview.setLanguage((String) entry.getValue());
				break;
			case ORDER:
				productReview.setOrder((String) entry.getValue());
				break;
			case PRIORITY:
				productReview.setPriority((String) entry.getValue());
				break;
			case PRODUCT:
				productReview.setProduct((String) entry.getValue());
				break;
			case RATING:
				productReview.setRating((Integer) entry.getValue());
				break;
			case REVIEWER:
				productReview.setReviewer((String) entry.getValue());
				break;
			case STATUS:
				productReview.setStatus((String) entry.getValue());
				break;
			case SUBSCRIBER:
				productReview.setServiceSubscriber((String) entry.getValue());
				break;
			case TEXT:
				productReview.setText((String) entry.getValue());
				break;
			default:
				productReview.getTags().put(entry.getKey(), (String) entry.getValue());
				break;
			}
		}
		return productReview;
	}

	/**
	 * accessor for collection name used to store reviews
	 *
	 * @return
	 */
	public static String getCollectionName() {
		return PRODUCT_REVIEW_COLLECTION;
	}

	/**
	 * generate a globally unique id for a product review
	 *
	 * @param productReview
	 *            the product review that needs a unique id
	 * @return globally unique id for the specified product review
	 */
	protected static String createUniqueId(ProductReview productReview) {
		return "PR" + new Date().getTime();
	}

}
