package com.sap.hybris.productreview.data;

import com.sap.hybris.productreview.ProductReview;

/**
 * 
 * 
 *
 */
public interface ProductReviewDao {
	/**
	 * 
	 * @param productReview
	 * @return
	 */
	ProductReview insertNewProductReview(ProductReview productReview);
	
	/**
	 * 
	 * @param code
	 * @return
	 * @throws NoSuchObjectException
	 * @throws DuplicateObjectException
	 */
	ProductReview getProductReviewByCode(String code);
}
