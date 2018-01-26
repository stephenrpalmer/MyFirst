package com.sap.hybris.productreview;

import java.util.HashMap;
import java.util.Map;

public class ProductSummary {

	/** internal unique identifier */
	private String id;

	/** product code */
	private String productCode;

	/** product name */
	private String productName;

	/** product thumbnail */
	private String productThumbnail;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * for categorisation that I have not thought off
	 */
	private Map<String, String> tags = new HashMap<>();

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productCode;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(String productId) {
		this.productCode = productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productThumbnail
	 */
	public String getProductThumbnail() {
		return productThumbnail;
	}

	/**
	 * @param productThumbnail
	 *            the productThumbnail to set
	 */
	public void setProductThumbnail(String productThumbnail) {
		this.productThumbnail = productThumbnail;
	}

	/**
	 * @return the tags
	 */
	public Map<String, String> getTags() {
		return tags;
	}

	/**
	 * @param tags
	 *            the tags to set
	 */
	public void setTags(Map<String, String> tags) {
		this.tags = tags;
	}

}
