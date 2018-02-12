package com.allan.zipcodes;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;

import com.allan.zipcodes.ZipCodesIntervalUnion;
import com.allan.zipcodes.dto.ZipCodeInterval;
import com.allan.zipcodes.exception.InvalidZipCodeException;
import com.allan.zipcodes.exception.InvalidZipCodeIntervalBoundsException;

/**
 * Test class for {@link ZipCodesIntervalUnion}
 *
 * @author ALLAN SHAJI MANAMEL
 */
public class ZipCodesIntervalUnionTest {
	/**
	 * Test creation of {@link ZipCodeInterval}
	 */
	@Test (expected = InvalidZipCodeException.class)
	public void testIntervalCreation_1() {
		new ZipCodeInterval(-94299, -94200);
	}

	/**
	 * Test creation of {@link ZipCodeInterval}
	 */
	@Test (expected = InvalidZipCodeException.class)
	public void testIntervalCreation_2() {
		new ZipCodeInterval(94, 94200);
	}

	/**
	 * Test creation of {@link ZipCodeInterval}
	 */
	@Test (expected = InvalidZipCodeException.class)
	public void testIntervalCreation_3() {
		new ZipCodeInterval(94299, 94);
	}

	/**
	 * Test creation of {@link ZipCodeInterval}
	 */
	@Test (expected = InvalidZipCodeIntervalBoundsException.class)
	public void testIntervalCreation_4() {
		new ZipCodeInterval(94299, 94200);
	}

	/**
	 * Test method for
	 * {@link com.allan.zipcodes.ZipCodesIntervalUnion#union(java.util.List)}.
	 */
	@Test
	public void testUnionEmptyList() {
		List<ZipCodeInterval> zipCodeIntervals = ZipCodesIntervalUnion
				.union(new ArrayList<ZipCodeInterval>());
		Assert.assertTrue(CollectionUtils.isEmpty(zipCodeIntervals));
	}

	/**
	 * Test method for
	 * {@link com.allan.zipcodes.ZipCodesIntervalUnion#union(java.util.List)}.
	 */
	@Test
	public void testUnionSingleElementList() {
		List<ZipCodeInterval> zipCodeIntervals = new ArrayList<>();
		zipCodeIntervals.add(new ZipCodeInterval(94133, 94133));
		List<ZipCodeInterval> result = ZipCodesIntervalUnion.union(zipCodeIntervals);
		Assert.assertEquals(1, result.size());
		Assert.assertEquals(zipCodeIntervals, result);
	}

	/**
	 * Test method for
	 * {@link com.allan.zipcodes.ZipCodesIntervalUnion#union(java.util.List)}.
	 */
	@Test
	public void testUnion_1() {
		List<ZipCodeInterval> zipCodeIntervals = new ArrayList<>();
		zipCodeIntervals.add(new ZipCodeInterval(94133, 94133));
		zipCodeIntervals.add(new ZipCodeInterval(94200, 94299));
		zipCodeIntervals.add(new ZipCodeInterval(94226, 94399));
		List<ZipCodeInterval> result = ZipCodesIntervalUnion.union(zipCodeIntervals);
		Assert.assertEquals(2, result.size());
		Assert.assertEquals(94133, result.get(0).getLower());
		Assert.assertEquals(94133, result.get(0).getUpper());
		Assert.assertEquals(94200, result.get(1).getLower());
		Assert.assertEquals(94399, result.get(1).getUpper());
	}

	/**
	 * Test method for
	 * {@link com.allan.zipcodes.ZipCodesIntervalUnion#union(java.util.List)}.
	 */
	@Test
	public void testUnion_2() {
		List<ZipCodeInterval> zipCodeIntervals = new ArrayList<>();
		zipCodeIntervals.add(new ZipCodeInterval(94200, 94299));
		zipCodeIntervals.add(new ZipCodeInterval(94133, 94133));
		zipCodeIntervals.add(new ZipCodeInterval(94526, 94599));
		zipCodeIntervals.add(new ZipCodeInterval(94326, 94499));
		zipCodeIntervals.add(new ZipCodeInterval(94226, 94399));
		List<ZipCodeInterval> result = ZipCodesIntervalUnion.union(zipCodeIntervals);
		Assert.assertEquals(3, result.size());
		Assert.assertEquals(94133, result.get(0).getLower());
		Assert.assertEquals(94133, result.get(0).getUpper());
		Assert.assertEquals(94200, result.get(1).getLower());
		Assert.assertEquals(94499, result.get(1).getUpper());
		Assert.assertEquals(94526, result.get(2).getLower());
		Assert.assertEquals(94599, result.get(2).getUpper());
	}

	/**
	 * Test method for
	 * {@link com.allan.zipcodes.ZipCodesIntervalUnion#union(java.util.List)}.
	 */
	@Test
	public void testUnion_3() {
		List<ZipCodeInterval> zipCodeIntervals = new ArrayList<>();
		zipCodeIntervals.add(new ZipCodeInterval(94133, 94133));
		zipCodeIntervals.add(new ZipCodeInterval(94200, 94299));
		zipCodeIntervals.add(new ZipCodeInterval(94200, 94399));
		List<ZipCodeInterval> result = ZipCodesIntervalUnion.union(zipCodeIntervals);
		Assert.assertEquals(2, result.size());
		Assert.assertEquals(94133, result.get(0).getLower());
		Assert.assertEquals(94133, result.get(0).getUpper());
		Assert.assertEquals(94200, result.get(1).getLower());
		Assert.assertEquals(94399, result.get(1).getUpper());
	}

	/**
	 * Test method for
	 * {@link com.allan.zipcodes.ZipCodesIntervalUnion#union(java.util.List)}.
	 */
	@Test
	public void testUnion_4() {
		List<ZipCodeInterval> zipCodeIntervals = new ArrayList<>();
		zipCodeIntervals.add(new ZipCodeInterval(94133, 94133));
		zipCodeIntervals.add(new ZipCodeInterval(94200, 94299));
		zipCodeIntervals.add(new ZipCodeInterval(94299, 94399));
		List<ZipCodeInterval> result = ZipCodesIntervalUnion.union(zipCodeIntervals);
		Assert.assertEquals(2, result.size());
		Assert.assertEquals(94133, result.get(0).getLower());
		Assert.assertEquals(94133, result.get(0).getUpper());
		Assert.assertEquals(94200, result.get(1).getLower());
		Assert.assertEquals(94399, result.get(1).getUpper());
	}

	/**
	 * Test method for
	 * {@link com.allan.zipcodes.ZipCodesIntervalUnion#union(java.util.List)}.
	 */
	@Test
	public void testUnion_5() {
		List<ZipCodeInterval> zipCodeIntervals = new ArrayList<>();
		zipCodeIntervals.add(new ZipCodeInterval(94133, 94133));
		zipCodeIntervals.add(new ZipCodeInterval(94200, 94299));
		zipCodeIntervals.add(new ZipCodeInterval(94600, 94699));
		List<ZipCodeInterval> result = ZipCodesIntervalUnion.union(zipCodeIntervals);
		Assert.assertEquals(3, result.size());
		Assert.assertEquals(94133, result.get(0).getLower());
		Assert.assertEquals(94133, result.get(0).getUpper());
		Assert.assertEquals(94200, result.get(1).getLower());
		Assert.assertEquals(94299, result.get(1).getUpper());
		Assert.assertEquals(94600, result.get(2).getLower());
		Assert.assertEquals(94699, result.get(2).getUpper());
	}

}
