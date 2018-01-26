package com.sap.hybris.productreview.facades;

import static org.junit.Assert.assertEquals;

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
import com.sap.hybris.productreview.ProductReviewApp;
import com.sap.hybris.productreview.data.DefaultProductReviewDao;
import com.sap.hybris.productreview.data.DuplicateObjectException;
import com.sap.hybris.productreview.data.MongoDatabaseFactory;
import com.sap.hybris.productreview.data.NoSuchObjectException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductReviewApp.class)
public class ProductReviewFacadeTest {

	@Resource
	private ProductReviewFacade productReviewFacade;

	private String id2 = "testid2";
	private String id3 = "testid3";
	private String code = "testcode" + new Date().getTime();
	private Date created = new Date();
	private String product = "testproduct";
	private String context = "testcontext";
	private int rating = 3;
	private String text = "testtext";
	private String reviewer = "testreviewer";
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
	public void shouldAddProductReview() {

		ProductReviewDTO testProductRevieDTO = new ProductReviewDTO();
		testProductRevieDTO.setCode(code);
		testProductRevieDTO.setCreated(created);
		testProductRevieDTO.setProduct(product);
		testProductRevieDTO.setContext(context);
		testProductRevieDTO.setRating(rating);
		testProductRevieDTO.setText(text);
		testProductRevieDTO.setReviewer(reviewer);
		Map<String, String> tags = testProductRevieDTO.getTags();
		tags.put(tag1, tag1 + "value");
		tags.put(tag2, tag2 + "value");
		tags.put(tag3, tag3 + "value");
		tags.put(tag4, tag4 + "value");

		productReviewFacade.addProductReview(testProductRevieDTO);
		testProductRevieDTO = productReviewFacade.getProductReviewByCode(code);

		checkProductReview(testProductRevieDTO);
	}

	@Test(expected = NoSuchObjectException.class)
	public void shouldNotFindProductReview() {
		@SuppressWarnings("unused")
		ProductReviewDTO testProductReviewDTO = productReviewFacade.getProductReviewByCode("notacode");
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
			ProductReviewDTO testProductReviewDTO = productReviewFacade.getProductReviewByCode(code);

		} catch (UnknownHostException e) {
			e.printStackTrace(); // replace with logger
		}
	}

	private void checkProductReview(ProductReviewDTO testProductRevieDTO) {
		assertEquals("code", code, testProductRevieDTO.getCode());
		assertEquals("created", created, testProductRevieDTO.getCreated());
		assertEquals("product", product, testProductRevieDTO.getProduct());
		assertEquals("context", context, testProductRevieDTO.getContext());
		assertEquals("rating", rating, testProductRevieDTO.getRating());
		assertEquals("text", text, testProductRevieDTO.getText());
		assertEquals("reviewer", reviewer, testProductRevieDTO.getReviewer());
	}
}
