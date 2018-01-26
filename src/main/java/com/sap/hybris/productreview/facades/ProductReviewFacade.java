package com.sap.hybris.productreview.facades;

import com.sap.hybris.productreview.data.DuplicateObjectException;
import com.sap.hybris.productreview.data.NoSuchObjectException;

/**
 *
 *
 *
 */
public interface ProductReviewFacade {

	/**
	 *
	 * @param productReview
	 * @return
	 */
	ProductReviewDTO addProductReview(ProductReviewDTO productReviewDTO);

	/**
	 *
	 * @param code
	 * @return
	 * @throws NoSuchObjectException
	 * @throws DuplicateObjectException
	 */
	ProductReviewDTO getProductReviewByCode(String code);

}
