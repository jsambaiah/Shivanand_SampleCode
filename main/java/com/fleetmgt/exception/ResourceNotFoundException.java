/**
 * 
 */
package com.fleetmgt.exception;

/**
 * @author Shivanand Amalyal
 *
 */
public class ResourceNotFoundException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1237834934L;

	public ResourceNotFoundException() {

	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

	public ResourceNotFoundException(Throwable cause) {
		super(cause);
	}

	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
