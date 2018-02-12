package com.allan.zipcodes.exception;

import com.allan.zipcodes.dto.ZipCodeInterval;

/**
 * Exception thrown if zip code entered for lower or upper bounds of
 * {@link ZipCodeInterval} is invalid.
 *
 * @author ALLAN SHAJI MANAMEL
 */
public class InvalidZipCodeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidZipCodeException() {
	}

	public InvalidZipCodeException(String message) {
		super(message);
	}
}
