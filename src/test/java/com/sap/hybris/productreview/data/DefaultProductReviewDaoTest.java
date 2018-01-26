package com.sap.hybris.productreview.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.bson.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.sap.hybris.productreview.ProductReview;
import com.sap.hybris.productreview.ProductReviewApp;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductReviewApp.class)
public class DefaultProductReviewDaoTest {

	@Resource
	private ProductReviewDao dao;

	private String id1 = "testid1";
	private String id2 = "testid2";
	private String id3 = "testid3";
	private String serviceSubscriber = "testsubscriber";
	private String code = "testcode" + new Date().getTime();
	private Date created = new Date();
	private String status = "teststatus";
	private String priority = "testpriority";
	private String product = "testproduct";
	private String context = "testcontext";
	private int rating = 3;
	private String text = "testtext";
	private String reviewer = "testreviewer";
	private String language = "testlanguage";
	private String order = "testorder";
	private String tag1 = "testtag1";
	private String tag2 = "testtag2";
	private String tag3 = "testtag3";
	private String tag4 = "testtag4";

	@Before
	public void setup() throws UnknownHostException {
		MongoDatabaseFactory.getInstance().drop();
	}

	@After
	public void teardown() throws UnknownHostException {
		MongoDatabaseFactory.getInstance().drop();
	}

	@Test
	public void shouldInsertNewProductReview() {

		ProductReview testProductReview = new ProductReview();
		testProductReview.setCode(code);
		testProductReview.setServiceSubscriber(serviceSubscriber);
		testProductReview.setCreated(created);
		testProductReview.setStatus(status);
		testProductReview.setPriority(priority);
		testProductReview.setProduct(product);
		testProductReview.setContext(context);
		testProductReview.setRating(rating);
		testProductReview.setText(text);
		testProductReview.setReviewer(reviewer);
		testProductReview.setLanguage(language);
		testProductReview.setOrder(order);
		Map<String, String> tags = testProductReview.getTags();
		tags.put(tag1, tag1 + "value");
		tags.put(tag2, tag2 + "value");
		tags.put(tag3, tag3 + "value");
		tags.put(tag4, tag4 + "value");

		testProductReview = dao.insertNewProductReview(testProductReview);
		id1 = testProductReview.getId();

		testProductReview = dao.getProductReviewByCode(code);

		assertNotNull("id is null", id1);
		checkProductReview(testProductReview);
	}

	@Test(expected = NoSuchObjectException.class)
	public void shouldNotFindProductReview() {
		@SuppressWarnings("unused")
		ProductReview testProductReview = dao.getProductReviewByCode("notacode");
	}

	@Test(expected = DuplicateObjectException.class)
	public void shouldFindMulitpleProductReview() {
		Document dbReview1 = new Document("_id", id2).append("code", code).append("created", created);
		Document dbReview2 = new Document("_id", id3).append("code", code).append("created", created);

		MongoDatabase database;
		try {
			database = MongoDatabaseFactory.getInstance();
			MongoCollection<Document> reviews = database.getCollection(DefaultProductReviewDao.getCollectionName());
			reviews.insertOne(dbReview1);
			reviews.insertOne(dbReview2);

			@SuppressWarnings("unused")
			ProductReview testProductReview = dao.getProductReviewByCode(code);

		} catch (UnknownHostException e) {
			e.printStackTrace(); // replace with logger
		}
	}

	@Test
	public void shouldConvertDBObjectIntoProductReview() {

		Document dbReview = new Document("_id", id1).append("subscriber", serviceSubscriber).append("code", code)
				.append("created", created).append("status", status).append("priority", priority)
				.append("product", product).append("context", context).append("rating", rating).append("text", text)
				.append("language", language).append("reviewer", reviewer).append("order", order);

		ProductReview testProductReview = DefaultProductReviewDao.toProductReview(dbReview);

		checkProductReview(testProductReview);
	}

	private void checkProductReview(ProductReview productReview) {
		assertEquals("subscriber", serviceSubscriber, productReview.getServiceSubscriber());
		assertEquals("code", code, productReview.getCode());
		assertEquals("created", created, productReview.getCreated());
		assertEquals("status", status, productReview.getStatus());
		assertEquals("priority", priority, productReview.getPriority());
		assertEquals("product", product, productReview.getProduct());
		assertEquals("context", context, productReview.getContext());
		assertEquals("rating", rating, productReview.getRating());
		assertEquals("text", text, productReview.getText());
		assertEquals("language", language, productReview.getLanguage());
		assertEquals("reviewer", reviewer, productReview.getReviewer());
		assertEquals("order", order, productReview.getOrder());
	}

}
