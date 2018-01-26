package com.sap.hybris.productreview.data;

public class NoSuchObjectException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4615214124937067563L;

	/**
	 * @param message
	 * @param cause
	 */
	public NoSuchObjectException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public NoSuchObjectException(String message) {
		super(message);
	}

}
