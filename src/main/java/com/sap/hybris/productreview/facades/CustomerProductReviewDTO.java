package com.sap.hybris.productreview.facades;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Use for reviews being looked at by a potential customer of a product
 * Status is not important because they should only see approved reviews
 * Priority is not important because all reviews are equally important to the customer
 * Product is important for scenarios where a review might be for a particular variant or version of a product
 * Context is important if reviews come from a different related website e.g. amazon.co.uk vs amazon.com
 * Language is not important because all reviews should be returned in the languages requested by the requester
 * Rating is important obviously, as is text
 * Reviewer is important but only nickname and id
 * Order is not relevant in this context
 */
public class CustomerProductReviewDTO {
	
	/** external unique identifier */
	private String code;

	/** date that the review was written */
	private Date created;

	/** uniquely identifies the product being reviewed */
	private String product;

	/**
	 * product bought where? store? website? over phone? chat robot? submitted via
	 * email, survey site, over phone (audio)? => location context for review, nest
	 * contexts to retrieve reviews by wider or narrower context
	 */
	private String context;
	
	/**
	 * generally 5 'stars' but could end up with upto 10 or 11 as per some survey sites - generally one rating but could be extended for multiple ratings as per customer feedback survey
	 */
	private int rating;
	
	/**
	 * traditional customer review, but could be extended to include images, submit review details as video, audio - again traditionally one but one per rating if extended to survey scenarios
	 */
	private String text;
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * @return the product
	 */
	public String getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(String product) {
		this.product = product;
	}

	/**
	 * @return the context
	 */
	public String getContext() {
		return context;
	}

	/**
	 * @param context the context to set
	 */
	public void setContext(String context) {
		this.context = context;
	}

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the reviewer
	 */
	public String getReviewer() {
		return reviewer;
	}

	/**
	 * @param reviewer the reviewer to set
	 */
	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	/**
	 * @return the tags
	 */
	public Map<String, String> getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(Map<String, String> tags) {
		this.tags = tags;
	}

	/**
	 * links off to a reviewer profile that might provide more info about the reviewer to help readers assess value/trustworthiness/bias of the review (think professional reviewers, verified purchases, etc)
	 */
	private String reviewer;

	/**
	 * for categorisation that I have not thought off
	 */
	private Map<String, String> tags = new HashMap<String, String>(); 

}
