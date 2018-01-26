package com.sap.hybris.productreview;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sap.hybris.productreview.data.ProductDao;
import com.sap.hybris.productreview.data.ProductReviewDao;

/**
 *
 *
 */
@Service
public class DefaultProductReviewService implements ProductReviewService {

	@Resource
	private ProductReviewDao productReviewDao;

	@Resource
	private ProductDao productDao;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.sap.hybris.productreview.ProductReviewService#addProductReview(com.sap.
	 * hybris.productreview.ProductReview)
	 */
	@Override
	public ProductReview addProductReview(ProductReview productReview) {
		return productReviewDao.insertNewProductReview(productReview);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.sap.hybris.productreview.ProductReviewService#getProductReviewByCode(java
	 * .lang.String)
	 */
	@Override
	public ProductReview getProductReviewByCode(String code) {
		return productReviewDao.getProductReviewByCode(code);
	}

	@Override
	public ProductReviewSummary getProductReviewSummary(ProductSummary productSummary, String subscriberService,
			String context, Date sinceDate) {

		// check parameter values are valid

		// delegate to dao to return reviews meeting criteria

		// create and populate review summary
		ProductReviewSummary productReviewSummary = new ProductReviewSummary();
		productReviewSummary.setProduct(productSummary);

		return productReviewSummary;
	}

}
