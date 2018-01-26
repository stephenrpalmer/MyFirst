package com.sap.hybris.productreview.data;

import com.sap.hybris.productreview.ProductSummary;

public interface ProductDao {

	/**
	 * For internal use only -ids should not be exposed to users ofthe service
	 *
	 * @param productId
	 * @return
	 */
	ProductSummary getProductById(String productId);

	/**
	 *
	 * @param productCode
	 * @return
	 */
	ProductSummary getProductByCode(String productCode);

	/**
	 *
	 * @param productSummary
	 * @return
	 */
	ProductSummary addProductSummary(ProductSummary productSummary);

}
