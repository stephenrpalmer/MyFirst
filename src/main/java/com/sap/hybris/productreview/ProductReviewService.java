package com.sap.hybris.productreview;

import java.util.Date;

import com.sap.hybris.productreview.data.DuplicateObjectException;
import com.sap.hybris.productreview.data.NoSuchObjectException;

public interface ProductReviewService {

	/**
	 *
	 * @param productReview
	 * @return
	 */
	ProductReview addProductReview(ProductReview productReview);

	/**
	 *
	 * @param code
	 * @return
	 * @throws NoSuchObjectException
	 * @throws DuplicateObjectException
	 */
	ProductReview getProductReviewByCode(String code);

	/**
	 *
	 * @param product
	 *            id of product to return the reviews for, required
	 * @param subscriberService
	 *            id of subscriber service to return reviews for, required
	 * @param context
	 *            id of the context to return reviews for, optional, defaults to all
	 *            contexts available to subscriber
	 * @param sinceDate
	 *            only return reviews newer than this date and time, optional,
	 *            defaults to reviews for all dates
	 * @return
	 * @throws NoSuchObjectException
	 * @throws DuplicateObjectException
	 */
	ProductReviewSummary getProductReviewSummary(ProductSummary product, String subscriberService, String context,
			Date sinceDate);

}
