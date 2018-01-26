package com.sap.hybris.productreview.data;

public class DuplicateObjectException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7153109184032912725L;

	/**
	 * @param message
	 * @param cause
	 */
	public DuplicateObjectException(String message, Throwable cause) {
		super(message, cause);		
	}

	/**
	 * @param message
	 */
	public DuplicateObjectException(String message) {
		super(message);
	}

}
