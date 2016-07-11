/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.lib;

import java.util.Comparator;
import java.util.NoSuchElementException;

import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Procedures;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Ordering;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class BaseIterablesIteratorsTest<IterableOrIterator> extends Assert {

	protected Integer first = Integer.valueOf(1);
	protected Integer second = Integer.valueOf(2);
	protected Integer third = Integer.valueOf(3);
	protected Integer forth = Integer.valueOf(4);
	protected Integer fifth = Integer.valueOf(5);
	
	protected abstract IterableOrIterator[] testData(Integer... elements);
	protected abstract IterableOrIterator[] nullableTestData(Integer... elements);
	protected abstract IterableOrIterator dummy();
	protected abstract boolean is(IterableOrIterator input, Integer... elements);

	protected abstract IterableOrIterator operator_plus(IterableOrIterator first, IterableOrIterator second);
	protected boolean canIterateTwice() {
		return true;
	}
	
	@Test public void testOperatorPlus_Same() {
		IterableOrIterator[] data = testData(first, second);
		for(int i = 0;i < data.length; i++) {
			if (canIterateTwice())
				assertTrue(is(operator_plus(data[i], data[i]), first, second, first, second));
			else
				assertTrue(is(operator_plus(data[i], data[i]), first, second));
		}
	}
	
	@Test public void testOperatorPlus() {
		IterableOrIterator[] firstData = testData(first, second);
		IterableOrIterator[] secondData = testData(third, forth);
		for(int i = 0;i < firstData.length; i++) {
			assertTrue(is(operator_plus(firstData[i], secondData[i]), first, second, third, forth));
		}
	}
	
	@Test public void testOperatorPlus_NPE_left() {
		try {
			operator_plus(null, dummy());
			fail("expected NullPointerException");
		} catch(NullPointerException npe) {
			// expected
		}
	}
	
	@Test public void testOperatorPlus_NPE_right() {
		try {
			operator_plus(dummy(), null);
			fail("expected NullPointerException");
		} catch(NullPointerException npe) {
			// expected
		}
	}
	
	protected abstract Integer findFirst(IterableOrIterator input, Functions.Function1<Integer, Boolean> filter);
	
	@Test public void testFindFirst_empty() {
		Function1<Integer, Boolean> filter = new Functions.Function1<Integer, Boolean>() {
			@Override
			public Boolean apply(Integer p) {
				return true;
			}
		};
		for(IterableOrIterator testMe: testData()) {
			Integer last = findFirst(testMe, filter);
			assertNull("empty input yields null", last);
		}
	}
	
	@Test public void testFindFirst_noMatch() {
		Function1<Integer, Boolean> filter = new Functions.Function1<Integer, Boolean>() {
			@Override
			public Boolean apply(Integer p) {
				return false;
			}
		};
		for(IterableOrIterator testMe: testData(first, second, third)) {
			Integer last = findFirst(testMe, filter);
			assertNull("unmatched input yields null", last);
		}
	}
	
	@Test public void testFindFirst_allMatches() {
		Function1<Integer, Boolean> filter = new Functions.Function1<Integer, Boolean>() {
			@Override
			public Boolean apply(Integer p) {
				return true;
			}
		};
		for(IterableOrIterator testMe: testData(first, second, third)) {
			Integer last = findFirst(testMe, filter);
			assertEquals(first, last);
		}
	}
	
	@Test public void testFindFirst_oneMatch() {
		Function1<Integer, Boolean> filter = new Functions.Function1<Integer, Boolean>() {
			@Override
			public Boolean apply(Integer p) {
				return second.equals(p);
			}
		};
		for(IterableOrIterator testMe: testData(first, second, third)) {
			Integer last = findFirst(testMe, filter);
			assertEquals(second, last);
		}
	}

	@Test public void testFindFirst_exceptionInFilter() {
		final RuntimeException expectedException = new RuntimeException();
		Function1<Integer, Boolean> filter = new Functions.Function1<Integer, Boolean>() {
			@Override
			public Boolean apply(Integer p) {
				throw expectedException;
			}
		};
		for(IterableOrIterator testMe: testData(first, second, third)) {
			try {
				findFirst(testMe, filter);
				fail("expected exception");
			} catch(RuntimeException e) {
				assertSame(expectedException, e);
			}
		}
	}
	
	@Test public void testFindFirst_exceptionInFilter_emptyInput() {
		final RuntimeException expectedException = new RuntimeException();
		Function1<Integer, Boolean> filter = new Functions.Function1<Integer, Boolean>() {
			@Override
			public Boolean apply(Integer p) {
				throw expectedException;
			}
		};
		for(IterableOrIterator testMe: testData()) {
			assertNull(findFirst(testMe, filter));
		}
	}
	
	@Test public void testFindFirst_NPE_noFilter() {
		for(IterableOrIterator testMe: testData()) {
			try {
				findFirst(testMe, null);
				fail("Expected NPE");
			} catch(NullPointerException npe) {
				// expected
			}
		}
	}
	
	@Test public void testFindFirst_NPE_noInput() {
		try {
			findLast(null, new Functions.Function1<Integer, Boolean>() {
				@Override
				public Boolean apply(Integer p) {
					return true;
				}
			});
			fail("Expected NPE");
		} catch(NullPointerException npe) {
			// expected
		}
	}
	
	protected abstract Integer findLast(IterableOrIterator input, Functions.Function1<Integer, Boolean> filter);
	
	@Test public void testFindLast_empty() {
		Function1<Integer, Boolean> filter = new Functions.Function1<Integer, Boolean>() {
			@Override
			public Boolean apply(Integer p) {
				return true;
			}
		};
		for(IterableOrIterator testMe: testData()) {
			Integer last = findLast(testMe, filter);
			assertNull("empty input yields null", last);
		}
	}
	
	@Test public void testFindLast_noMatch() {
		Function1<Integer, Boolean> filter = new Functions.Function1<Integer, Boolean>() {
			@Override
			public Boolean apply(Integer p) {
				return false;
			}
		};
		for(IterableOrIterator testMe: testData(first, second, third)) {
			Integer last = findLast(testMe, filter);
			assertNull("unmatched input yields null", last);
		}
	}
	
	@Test public void testFindLast_allMatches() {
		Function1<Integer, Boolean> filter = new Functions.Function1<Integer, Boolean>() {
			@Override
			public Boolean apply(Integer p) {
				return true;
			}
		};
		for(IterableOrIterator testMe: testData(first, second, third)) {
			Integer last = findLast(testMe, filter);
			assertEquals(third, last);
		}
	}
	
	@Test public void testFindLast_oneMatch() {
		Function1<Integer, Boolean> filter = new Functions.Function1<Integer, Boolean>() {
			@Override
			public Boolean apply(Integer p) {
				return second.equals(p);
			}
		};
		for(IterableOrIterator testMe: testData(first, second, third)) {
			Integer last = findLast(testMe, filter);
			assertEquals(second, last);
		}
	}

	@Test public void testFindLast_exceptionInFilter() {
		final RuntimeException expectedException = new RuntimeException();
		Function1<Integer, Boolean> filter = new Functions.Function1<Integer, Boolean>() {
			@Override
			public Boolean apply(Integer p) {
				throw expectedException;
			}
		};
		for(IterableOrIterator testMe: testData(first, second, third)) {
			try {
				findLast(testMe, filter);
				fail("expected exception");
			} catch(RuntimeException e) {
				assertSame(expectedException, e);
			}
		}
	}
	
	@Test public void testFindLast_exceptionInFilter_emptyInput() {
		final RuntimeException expectedException = new RuntimeException();
		Function1<Integer, Boolean> filter = new Functions.Function1<Integer, Boolean>() {
			@Override
			public Boolean apply(Integer p) {
				throw expectedException;
			}
		};
		for(IterableOrIterator testMe: testData()) {
			Integer last = findLast(testMe, filter);
			assertEquals(null, last);
		}
	}
	
	@Test public void testFindLast_NPE_noFilter() {
		for(IterableOrIterator testMe: testData()) {
			try {
				findLast(testMe, null);
				fail("Expected NPE");
			} catch(NullPointerException npe) {
				// expected
			}
		}
	}
	
	@Test public void testFindLast_NPE_noInput() {
		try {
			findLast(null, new Functions.Function1<Integer, Boolean>() {
				@Override
				public Boolean apply(Integer p) {
					return true;
				}
			});
			fail("Expected NPE");
		} catch(NullPointerException npe) {
			// expected
		}
	}
	
	protected abstract Integer last(IterableOrIterator input);
	
	@Test public void testLast_empty() {
		for(IterableOrIterator testMe: testData()) {
			Integer last = last(testMe);
			assertNull("empty input yields null", last);
		}
	}
	
	@Test public void testLast_oneEntry() {
		for(IterableOrIterator testMe: testData(first)) {
			Integer last = last(testMe);
			assertEquals(first, last);
		}
	}
	
	@Test public void testLast_entryIsNull() {
		for(IterableOrIterator testMe: nullableTestData((Integer)null)) {
			Integer last = last(testMe);
			assertEquals(null, last);
		}
	}
	
	@Test public void testLast_moreEntries() {
		for(IterableOrIterator testMe: testData(first, second, third)) {
			Integer last = last(testMe);
			assertEquals(third, last);
		}
	}
	
	@Test public void testLast_NPE() {
		try {
			last(null);
			fail("expeced NPE");
		} catch(NullPointerException npe) {
			// expected
		}
	}
	
	protected abstract Integer head(IterableOrIterator input);
	
	@Test public void testHead_empty() {
		for(IterableOrIterator testMe: testData()) {
			Integer head = head(testMe);
			assertNull("empty input yields null", head);
		}
	}
	
	@Test public void testHead_oneEntry() {
		for(IterableOrIterator testMe: testData(first)) {
			Integer head = head(testMe);
			assertEquals(first, head);
		}
	}
	
	@Test public void testHead_entryIsNull() {
		for(IterableOrIterator testMe: nullableTestData((Integer)null)) {
			Integer head = head(testMe);
			assertEquals(null, head);
		}
	}
	
	@Test public void testHead_moreEntries() {
		for(IterableOrIterator testMe: testData(first, second, third)) {
			Integer head = head(testMe);
			assertEquals(first, head);
		}
	}
	
	@Test public void testHead_NPE() {
		try {
			head(null);
			fail("expeced NPE");
		} catch(NullPointerException npe) {
			// expected
		}
	}
	
	protected abstract void forEach(IterableOrIterator input, Procedures.Procedure2<Integer, Integer> proc);
	
	static class ForEachLoopCounter implements Procedures.Procedure2<Integer, Integer> {

		private int expectedIndex = 0;
		private final Integer[] values;
		
		ForEachLoopCounter(Integer... values) {
			this.values = values;
		}
		
		@Override
		public void apply(Integer value, Integer index) {
			assertEquals(expectedIndex, index.intValue());
			assertEquals(values[expectedIndex], value);
			expectedIndex++;
		}
		
	}
	
	@Test public void testForEachWithIndex_empty() {
		for(IterableOrIterator testMe: testData()) {
			ForEachLoopCounter counter = new ForEachLoopCounter();
			forEach(testMe, counter);
			assertEquals(0, counter.expectedIndex);
		}
	}
	
	@Test public void testForEachWithIndex_empty_noProcedure() {
		for(IterableOrIterator testMe: testData()) {
			try {
				forEach(testMe, null);
				fail("expeced NPE");
			} catch(NullPointerException e) {
				// expected
			}
		}
	}
	
	@Test public void testForEachWithIndex_oneEntry() {
		for(IterableOrIterator testMe: testData(first)) {
			ForEachLoopCounter counter = new ForEachLoopCounter(first);
			forEach(testMe, counter);
			assertEquals(1, counter.expectedIndex);
		}
	}
	
	@Test public void testForEachWithIndex_entryIsNull() {
		for(IterableOrIterator testMe: nullableTestData((Integer)null)) {
			ForEachLoopCounter counter = new ForEachLoopCounter((Integer)null);
			forEach(testMe, counter);
			assertEquals(1, counter.expectedIndex);
		}
	}
	
	@Test public void testForEachWithIndex_moreEntries() {
		for(IterableOrIterator testMe: testData(first, second, forth)) {
			ForEachLoopCounter counter = new ForEachLoopCounter(first, second, forth);
			forEach(testMe, counter);
			assertEquals(3, counter.expectedIndex);
		}
	}
	
	@Test public void testForEachWithIndex_NPE() {
		try {
			forEach(null, new ForEachLoopCounter());
			fail("expeced NPE");
		} catch(NullPointerException npe) {
			// expected
		}
	}
	
	protected abstract IterableOrIterator takeWhile(IterableOrIterator input, Functions.Function1<Integer, Boolean> filter);
	protected abstract IterableOrIterator dropWhile(IterableOrIterator input, Functions.Function1<Integer, Boolean> filter);
	protected abstract Integer min(IterableOrIterator input);
	protected abstract Integer max(IterableOrIterator input);
	protected abstract Integer min(IterableOrIterator input, Comparator<? super Integer> comparator);
	protected abstract Integer max(IterableOrIterator input, Comparator<? super Integer> comparator);
	protected abstract Integer minBy(IterableOrIterator input, Functions.Function1<? super Integer, String> compareBy);
	protected abstract Integer maxBy(IterableOrIterator input, Functions.Function1<? super Integer, String> compareBy);
	
	@Test public void testTakeWhile() {
		for (IterableOrIterator testMe : testData(first, second, third, forth, fifth)) {
			IterableOrIterator taken = takeWhile(testMe, new Function1<Integer, Boolean>() {
				@Override
				public Boolean apply(Integer p) {
					return p <= 3;
				}
			});
			assertTrue(is(taken, first, second, third));
		}
	}
	
	@Test public void testDropWhile() {
		for (IterableOrIterator testMe : testData(first, second, third, forth, fifth)) {
			IterableOrIterator tail = dropWhile(testMe, new Function1<Integer, Boolean>() {
				@Override
				public Boolean apply(Integer p) {
					return p <= 3;
				}
			});
			assertTrue(is(tail, forth, fifth));
		}
	}
	
	@Test public void testMinComparable() {
		for (IterableOrIterator testMe : testData(first, second, third, forth, fifth)) {
			Integer min = min(testMe);
			assertEquals(first, min);
		}
	}
	
	@Test public void testMaxComparable() {
		for (IterableOrIterator testMe : testData(first, second, third, forth, fifth)) {
			Integer max = max(testMe);
			assertEquals(fifth, max);
		}
	}
	
	@Test(expected = NoSuchElementException.class) 
	public void testMinEmpty() {
		for (IterableOrIterator testMe : testData()) {
			min(testMe);
		}
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testMaxEmpty() {
		for (IterableOrIterator testMe : testData()) {
			max(testMe);
		}
	}
	
	@Test public void testMinComparator() {
		for (IterableOrIterator testMe : testData(first, second, third, forth, fifth)) {
			Integer min = min(testMe, Ordering.natural().reverse());
			assertEquals(fifth, min);
		}
	}
	
	@Test public void testMaxComparator() {
		for (IterableOrIterator testMe : testData(first, second, third, forth, fifth)) {
			Integer max = max(testMe, Ordering.natural().reverse());
			assertEquals(first, max);
		}
	}
	
	@Test public void testMinBy() {
		for (IterableOrIterator testMe : testData(first, second, third, forth, fifth)) {
			Integer min = minBy(testMe, new Function1<Integer, String>() {
				@Override
				public String apply(Integer p) {
					return Integer.toBinaryString(p);
				}
			});
			assertEquals(first, min);
		}
	}
	
	@Test public void testMaxBy() {
		for (IterableOrIterator testMe : testData(first, second, third, forth, fifth)) {
			Integer max = maxBy(testMe, new Function1<Integer, String>() {
				@Override
				public String apply(Integer p) {
					return Integer.toBinaryString(p);
				}
			});
			assertEquals(third, max);
		}
	}
}
