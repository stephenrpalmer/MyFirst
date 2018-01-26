package com.sap.hybris.productreview;

import java.util.HashMap;
import java.util.Map;

public class ProductReviewSummary {

	/** unique id */
	private String id;

	/** product being reviewed */
	private ProductSummary product;

	/** aggregate rating */
	private double rating;

	/** number of reviews per rating */
	Map<String, Integer> numberOfReviews = new HashMap<>();

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the product
	 */
	public ProductSummary getProduct() {
		return product;
	}

	/**
	 * @param product
	 *            the product to set
	 */
	public void setProduct(ProductSummary product) {
		this.product = product;
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
