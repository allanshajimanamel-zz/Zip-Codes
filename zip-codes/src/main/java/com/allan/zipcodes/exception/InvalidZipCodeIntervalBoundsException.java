package com.allan.zipcodes.exception;

import com.allan.zipcodes.dto.ZipCodeInterval;

/**
 * Exception thrown if zip code value for upper bound of {@link ZipCodeInterval}
 * is lower than the value for lower bound of {@link ZipCodeInterval}.
 *
 * @author ALLAN SHAJI MANAMEL
 */
public class InvalidZipCodeIntervalBoundsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidZipCodeIntervalBoundsException() {
	}

	public InvalidZipCodeIntervalBoundsException(String message) {
		super(message);
	}
}
