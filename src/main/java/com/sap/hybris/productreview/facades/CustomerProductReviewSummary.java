package com.sap.hybris.productreview.facades;

import java.util.HashMap;
import java.util.Map;

public class CustomerProductReviewSummary {

	/** */
	private String productId;

	/** */
	private String productName;

	/** */
	private String productThumbnail;

	/** aggregate rating */
	private double rating;

	/** number of reviews per rating */
	Map<String, Integer> numberOfReviews = new HashMap<>();

	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
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
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}

	/**
	 * @return the numberOfReviews
	 */
	public Map<String, Integer> getNumberOfReviews() {
		return numberOfReviews;
	}

	/**
	 * @param numberOfReviews
	 *            the numberOfReviews to set
	 */
	public void setNumberOfReviews(Map<String, Integer> numberOfReviews) {
		this.numberOfReviews = numberOfReviews;
	}

}
