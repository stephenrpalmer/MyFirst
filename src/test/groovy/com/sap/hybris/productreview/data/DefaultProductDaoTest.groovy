package com.sap.hybris.productreview.data

import static com.sap.hybris.productreview.data.MongoJSONImport.importJSON

import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

import com.sap.hybris.productreview.ProductReviewApp

import spock.lang.Specification

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductReviewApp.class)
class DefaultProductDaoTest extends Specification {

	@Autowired
	ProductDao dao

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
		importJSON("resources/testProducts.jsn", MongoDatabaseFactory.getInstance().getCollection("products") );
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
	def "getting a product by code"() {

		when:
		def productSummary = dao.getProductByCode("testProduct1Code")

		then:
		productSummary.productCode == "testProduct1Code"
	}

	@Test
	def "getting a product by id"() {

		when:
		def productSummary = dao.getProductById("testProduct1Id")

		then:
		productSummary.id == "testProduct1Id"
	}

	@Test
	def "not finding product review by id"() {

		when:
		def productReview = dao.getProductById("notanid")

		then:
		thrown(NoSuchObjectException)
	}



	@Test
	def "finding mulitple product reviews with same code"() {

		when:
		def productReview = dao.getProductByCode("duplicatedCode")

		then:
		thrown(DuplicateObjectException)
	}
}