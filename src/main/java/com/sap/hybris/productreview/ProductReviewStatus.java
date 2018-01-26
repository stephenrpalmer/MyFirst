package com.sap.hybris.productreview;

import java.util.Date;

public class ProductReviewStatus {
	
	/** a unique id for the status - required */
	private String id;

	/** the time stamp that the status was assigned to the product review - required */
	private Date date;
	
	/** the optional reason that the status was assigned to the product review - optional*/	
	private String reason;
	
	/** the user that made the status assignment - required */ 
	private String user;

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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
}
