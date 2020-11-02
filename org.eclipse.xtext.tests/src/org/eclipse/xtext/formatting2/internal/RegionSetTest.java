/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.internal.TextSegment;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Functions;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class RegionSetTest {
	private void test(CharSequence expectation, Procedure1<? super TestableTextSegmentSet> test) {
		TestableTextSegmentSet set = new TestableTextSegmentSet(new ArrayListTextSegmentSet<ITextSegment>(
				Functions.identity(), Functions.toStringFunction(), true));
		try {
			test.apply(set);
		} catch (Throwable t) {
			t.printStackTrace();
			Assert.fail();
		}
		Assert.assertEquals(expectation.toString(), set.toString());
	}

	@Test
	public void testAddValid() {
		String expectation =
			"issues=\n" +
			"set=[[10,0], [10,1], [11,1], [12,1], [99,1], [100,0]]\n";
		test(expectation, (TestableTextSegmentSet it) -> {
			it.add(new TextSegment(null, 10, 0));
			it.add(new TextSegment(null, 11, 1));
			it.add(new TextSegment(null, 99, 1));
			it.add(new TextSegment(null, 10, 1));
			it.add(new TextSegment(null, 100, 0));
			it.add(new TextSegment(null, 12, 1));
		});
	}

	@Test
	public void testNoMergeConflic1() {
		String expectation =
			"issues=\n" +
			"set=[[20,0], [20,1]]\n";
		test(expectation, (TestableTextSegmentSet it) -> {
			it.add(new TextSegment(null, 20, 0));
			it.add(new TextSegment(null, 20, 1));
		});
	}

	@Test
	public void testNoMergeConflic2() {
		String expectation =
			"issues=\n" +
			"set=[[20,0], [20,1]]\n";
		test(expectation, (TestableTextSegmentSet it) -> {
			it.add(new TextSegment(null, 20, 1));
			it.add(new TextSegment(null, 20, 0));
		});
	}

	@Test
	public void testMergeConflic1() {
		String expectation =
			"issues=mergeConflict:[20,0]<>[20,0]\n" +
			"set=[]\n";
		test(expectation, (TestableTextSegmentSet it) -> {
			it.add(new TextSegment(null, 20, 0));
			it.add(new TextSegment(null, 20, 0));
		});
	}

	@Test
	public void testMergeConflic2() {
		String expectation =
			"issues=mergeConflict:[21,0]<>[20,2]\n" +
			"set=[[20,2]]\n";
		test(expectation, (TestableTextSegmentSet it) -> {
			it.add(new TextSegment(null, 20, 2));
			it.add(new TextSegment(null, 21, 0));
		});
	}

	@Test
	public void testMergeConflic3() {
		String expectation =
			"issues=mergeConflict:[20,2]<>[21,0]\n" +
			"set=[[20,2]]\n";
		test(expectation, (TestableTextSegmentSet it) -> {
			it.add(new TextSegment(null, 21, 0));
			it.add(new TextSegment(null, 20, 2));
		});
	}

	@Test
	public void testMergeConflic4() {
		String expectation =
			"issues=mergeConflict:[20,2]<>[21,5]\n" +
			"set=[[21,5]]\n";
		test(expectation, (TestableTextSegmentSet it) -> {
			it.add(new TextSegment(null, 21, 5));
			it.add(new TextSegment(null, 20, 2));
		});
	}

	@Test
	public void testMergeConflic5() {
		String expectation =
			"issues=mergeConflict:[20,2]<>[21,5]\n" +
			"set=[[21,5]]\n";
		test(expectation, (TestableTextSegmentSet it) -> {
			it.add(new TextSegment(null, 21, 5));
			it.add(new TextSegment(null, 20, 2));
		});
	}
}
