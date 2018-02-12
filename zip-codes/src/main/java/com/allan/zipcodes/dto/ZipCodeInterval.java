package com.allan.zipcodes.dto;

import java.util.Comparator;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.allan.zipcodes.exception.InvalidZipCodeException;
import com.allan.zipcodes.exception.InvalidZipCodeIntervalBoundsException;

/**
 * This class represents a zip code interval with lower and upper bounds which
 * are <strong>inclusive</strong>.
 *
 * A zip code should be non negetive and should have 5 digits in it.
 *
 * @author ALLAN SHAJI MANAMEL
 *
 */
public class ZipCodeInterval implements Comparable<ZipCodeInterval> {
	private static final String INVALID_ZIP_CODE = "Value for a zip code cannot be negative and should have 5 digits";

	private static final String INCORRECT_VALUES_MESSAGE = "Incorrect values for lower and upper bound of zip code intervals. "
			+ "Upper bound for a zip code interval should be greater than or equal to the lower bound. "
			+ "The current value entered are lower = {} and upper = {}.";

	private static final Logger LOG = LoggerFactory
			.getLogger(ZipCodeInterval.class);

	/**
	 * Comparator for natural ordering of {@link ZipCodeInterval} class.
	 */
	private static final Comparator<ZipCodeInterval> NATURAL = Comparator
			.comparingInt(ZipCodeInterval::getLower).thenComparingInt(
					ZipCodeInterval::getUpper);
	/**
	 * Lower value of interval.
	 */
	private final int lower;

	/**
	 * Upper value of interval.
	 */
	private final int upper;

	/**
	 * Constructor
	 *
	 * @param lower
	 *            Lower value of interval.
	 * @param upper
	 *            Upper value of interval.
	 */
	public ZipCodeInterval(int lower, int upper) {
		this.lower = lower;
		this.upper = upper;
		validate();
	}

	/**
	 * @return the lower
	 */
	public int getLower() {
		return lower;
	}

	/**
	 * @return the upper
	 */
	public int getUpper() {
		return upper;
	}

	@Override
	public int compareTo(ZipCodeInterval other) {
		return NATURAL.compare(this, other);
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof ZipCodeInterval
				&& new EqualsBuilder()
		.append(this.lower, ((ZipCodeInterval) other).lower)
		.append(this.upper, ((ZipCodeInterval) other).upper)
		.build();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(lower).append(upper).build();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}

	/**
	 * Method to validate the values for lower and upper bounds for the zip code
	 * interval.
	 */
	private void validate() {
		if (lower < 0 || (int) (Math.log10(lower) + 1) != 5) {
			LOG.error(INVALID_ZIP_CODE);
			throw new InvalidZipCodeException("Incorrect zip code");
		}

		if (upper < 0 || (int) (Math.log10(upper) + 1) != 5) {
			LOG.error(INVALID_ZIP_CODE);
			throw new InvalidZipCodeException("Incorrect zip code");
		}

		if (upper < lower) {
			LOG.error(INCORRECT_VALUES_MESSAGE, lower, upper);
			throw new InvalidZipCodeIntervalBoundsException(
					"Incorrect values for lower and upper bound of zip code intervals.");
		}
	}
}
