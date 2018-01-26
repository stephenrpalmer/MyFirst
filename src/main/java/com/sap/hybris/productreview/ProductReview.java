package com.sap.hybris.productreview;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ProductReview {

	/** internal unique identifier */
	private String id;

	/** internal unique identifier */
	private String serviceSubscriber;

	/** external unique identifier */
	private String code;

	/** date that the review was written */
	private Date created;

	/**
	 * review status - needs to become status a list of subsequent interactions each
	 * comprising value, status setter, date, and optional reason category and text
	 */
	private String status;

	/**
	 * how important is this review - determined by submitting agent based on
	 * reviewer, product, location, tags, etc
	 */
	private String priority;

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
	 * language that the review is provided in - probably ISO language code
	 */
	private String language;
	
	/**
	 * links off to a reviewer profile that might provide more info about the reviewer to help readers assess value/trustworthiness/bias of the review (think professional reviewers, verified purchases, etc)
	 */
	private String reviewer;
	
	/**
	 * if review can be linked to a specific order so can assess verified purchase etc. - optional
	 */
	private String order;

	/**
	 * for categorisation that I have not thought off
	 */
	private Map<String, String> tags = new HashMap<>(); 
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the serviceSubscriber
	 */
	public String getServiceSubscriber() {
		return serviceSubscriber;
	}

	/**
	 * @param serviceSubscriber the serviceSubscriber to set
	 */
	public void setServiceSubscriber(String serviceSubscriber) {
		this.serviceSubscriber = serviceSubscriber;
	}

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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
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
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
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
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
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
}
