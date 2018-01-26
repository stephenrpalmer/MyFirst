package com.sap.hybris.productreview

import static com.sap.hybris.productreview.data.MongoJSONImport.importJSON

import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

import com.sap.hybris.productreview.data.DuplicateObjectException
import com.sap.hybris.productreview.data.MongoDatabaseFactory
import com.sap.hybris.productreview.data.NoSuchObjectException

import spock.lang.Specification

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductReviewApp.class)
class ProductReviewServiceTest extends Specification {

	@Autowired
	ProductReviewService service

	/**
	 * run before every feature method
	 */
	def setup() {
	}

	/**
	 *
	 */
	def cleanup() {
	}

	/**
	 *  run before the first feature method
	 */
	def setupSpec() {
		MongoDatabaseFactory.getInstance().drop()
		importJSON("resources/testReviews.jsn", MongoDatabaseFactory.getInstance().getCollection("reviews") );
	}

	/**
	 * run after the last feature method
	 */
	def cleanupSpec() {
		MongoDatabaseFactory.getInstance().drop()
	}


	/**
	 * feature (test) methods
	 */
	@Test
	def "getting a product review by code"() {

		when:
		def productReview = service.getProductReviewByCode("testcode1516371346969")

		then:
		productReview.code == "testcode1516371346969"
	}

	@Test
	def "not finding product review by code"() {

		when:
		def productReview = service.getProductReviewByCode("notacode")

		then:
		thrown(NoSuchObjectException)
	}

	@Test
	def "finding mulitple product reviews with same code"() {

		when:
		def productReview = service.getProductReviewByCode("testcode1516371347298")

		then:
		thrown(DuplicateObjectException)
	}

	/**
	 @Test def "should return review summary for product for specific context and all dates"() {
	 }
	 @Test def "should return review summary for product for specific context since specified dates"() {
	 }
	 @Test def "should not return review summary when product parameter is invalid"() {
	 }
	 @Test def "should not return review summary when subscriber parameter is invalid"() {
	 }
	 */
}