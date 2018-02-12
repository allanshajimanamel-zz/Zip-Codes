package com.allan.zipcodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.allan.zipcodes.dto.ZipCodeInterval;

/**
 * This class is an utility class for {@link ZipCodeInterval} which performs the
 * union of a {@link List} of {@link ZipCodeInterval}.
 *<p>
 * EXAMPLES:
 * </br>
 * If the input = [94133,94133] [94200,94299] [94600,94699] Then the
 * output would be = [94133,94133] [94200,94299] [94600,94699]
 *</br>
 * If the input = [94133,94133] [94200,94299] [94226,94399] Then the output
 * would be = [94133,94133] [94200,94399]
 *</p>
 * @author ALLAN SHAJI MANAMEL
 *
 */
public class ZipCodesIntervalUnion {

	public static void main(String[] args) {
		List<ZipCodeInterval> zipCodeIntervals = new ArrayList<>();
		zipCodeIntervals.add(new ZipCodeInterval(94133, 94133));
		zipCodeIntervals.add(new ZipCodeInterval(94200, 94299));
		zipCodeIntervals.add(new ZipCodeInterval(94600, 94699));
		List<ZipCodeInterval> result = ZipCodesIntervalUnion.union(zipCodeIntervals);
		for(ZipCodeInterval interval : result) {
			System.out.println(interval);
		}
	}

	/**
	 * The method performs a union of the input zip code intervals.
	 *
	 * @param zipCodeIntervals
	 *            {@link List} of {@link ZipCodeInterval} to perform the union
	 *            on.
	 * @return {@link List} of {@link ZipCodeInterval}.
	 */
	public static List<ZipCodeInterval> union(
			List<ZipCodeInterval> zipCodeIntervals) {

		//if zipCodeIntervals is null or empty return an empty list.
		if (CollectionUtils.isEmpty(zipCodeIntervals)) {
			return Collections.emptyList();
		}

		// if zipCodeIntervals has only 1 element then return the list.
		if (zipCodeIntervals.size() == 1) {
			return zipCodeIntervals;
		}

		List<ZipCodeInterval> result = new ArrayList<>();
		Collections.sort(zipCodeIntervals);
		ZipCodeInterval previous = zipCodeIntervals.get(0);

		for (int i = 1; i < zipCodeIntervals.size(); i++) {
			ZipCodeInterval current = zipCodeIntervals.get(i);
			if (current.getLower() <= previous.getUpper()) { // Zip code interval ranges overlap
				previous = new ZipCodeInterval(previous.getLower(), Math.max(
						previous.getUpper(), current.getUpper()));
			} else {
				result.add(previous);
				previous = current;
			}
		}
		result.add(previous);
		return result;
	}
}
