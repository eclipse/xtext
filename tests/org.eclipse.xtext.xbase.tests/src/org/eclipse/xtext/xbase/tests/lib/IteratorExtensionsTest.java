/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.lib;

import static com.google.common.collect.Lists.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Iterators;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class IteratorExtensionsTest extends BaseIterablesIteratorsTest<Iterator<Integer>> {
	
	@Test public void testToIterable() throws Exception {
		ArrayList<String> list = newArrayList("A","B");
		for (String s : IteratorExtensions.toIterable(list.iterator())) {
			assertTrue(list.contains(s));
		}
	}
	
	@Override
	protected boolean canIterateTwice() {
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Iterator<Integer>[] testData(Integer... elements) {
		return new Iterator[] { Iterators.forArray(elements) };
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected Iterator<Integer>[] nullableTestData(Integer... elements) {
		return new Iterator[] { Iterators.forArray(elements) };
	}

	@Override
	protected Iterator<Integer> dummy() {
		return Collections.<Integer>emptyList().iterator();
	}

	@Override
	protected boolean is(Iterator<Integer> input, Integer... elements) {
		return Iterators.elementsEqual(input, Iterators.forArray(elements));
	}

	@Override
	protected Iterator<Integer> operator_plus(Iterator<Integer> first, Iterator<Integer> second) {
		return IteratorExtensions.operator_plus(first, second);
	}

	@Override
	protected Integer findFirst(Iterator<Integer> input, Function1<Integer, Boolean> filter) {
		return IteratorExtensions.findFirst(input, filter);
	}

	@Override
	protected Integer findLast(Iterator<Integer> input, Function1<Integer, Boolean> filter) {
		return IteratorExtensions.findLast(input, filter);
	}

	@Override
	protected Integer last(Iterator<Integer> input) {
		return IteratorExtensions.last(input);
	}

	@Override
	protected Integer head(Iterator<Integer> input) {
		return IteratorExtensions.head(input);
	}
	
	@Override
	protected void forEach(Iterator<Integer> input, Procedure2<Integer, Integer> proc) {
		IteratorExtensions.forEach(input, proc);
	}
	
	@Override
	protected Iterator<Integer> takeWhile(Iterator<Integer> input, Function1<Integer, Boolean> filter) {
		return IteratorExtensions.takeWhile(input, filter);
	}
	
	@Override
	protected Iterator<Integer> dropWhile(Iterator<Integer> input, Function1<Integer, Boolean> filter) {
		return IteratorExtensions.dropWhile(input, filter);
	}
	
	@Override
	protected Integer max(Iterator<Integer> input) {
		return IteratorExtensions.max(input);
	}
	
	@Override
	protected Integer max(Iterator<Integer> input, Comparator<? super Integer> comparator) {
		return IteratorExtensions.max(input, comparator);
	}
	
	@Override
	protected Integer maxBy(Iterator<Integer> input, Function1<? super Integer, String> compareBy) {
		return IteratorExtensions.maxBy(input, compareBy);
	}
	
	@Override
	protected Integer min(Iterator<Integer> input) {
		return IteratorExtensions.min(input);
	}
	
	@Override
	protected Integer min(Iterator<Integer> input, Comparator<? super Integer> comparator) {
		return IteratorExtensions.min(input, comparator);
	}
	
	@Override
	protected Integer minBy(Iterator<Integer> input, Function1<? super Integer, String> compareBy) {
		return IteratorExtensions.minBy(input, compareBy);
	}
	
	@Test public void testIndexed() {
		Iterator<Pair<Integer, String>> result = IteratorExtensions.indexed(newArrayList("foo", "bar").iterator());
		assertEquals(new Pair<Integer, String>(0, "foo"), result.next());
		assertEquals(new Pair<Integer, String>(1, "bar"), result.next());
		assertFalse(result.hasNext());
	}
	
	@Test
	public void testToMap() {
		List<Pair<Integer, String>> pairs = new ArrayList<Pair<Integer, String>>();
		pairs.add(new Pair<Integer, String>(1, "A"));
		pairs.add(new Pair<Integer, String>(1, "a"));
		pairs.add(new Pair<Integer, String>(2, "B"));
		pairs.add(new Pair<Integer, String>(2, "b"));
		Function1<Pair<Integer, String>, Integer> computeKeys = new Function1<Pair<Integer, String>, Integer>() {

			@Override
			public Integer apply(Pair<Integer, String> p) {
				return p.getKey();
			}
		};
		Map<Integer, Pair<Integer, String>> map = IteratorExtensions.toMap(pairs.iterator(), computeKeys);
		Assert.assertEquals("Expected grouped map size", 2, map.size());
		Assert.assertTrue("Contains 1 as key", map.keySet().contains(1));
		Assert.assertEquals("Contains entry 1->a for key 1", map.get(1), new Pair<Integer, String>(1, "a"));
		Assert.assertTrue("Contains 2 as key", map.keySet().contains(2));
		Assert.assertEquals("Contains entry 2->b for key 2", map.get(2), new Pair<Integer, String>(2, "b"));
	}

	@Test
	public void testToMap__WhenEmptyList() {
		List<Pair<Integer, String>> pairs = new ArrayList<Pair<Integer, String>>();
		Function1<Pair<Integer, String>, Integer> computeKeys = new Function1<Pair<Integer, String>, Integer>() {

			@Override
			public Integer apply(Pair<Integer, String> p) {
				return p.getKey();
			}
		};
		Map<Integer, Pair<Integer, String>> map = IteratorExtensions.toMap(pairs.iterator(), computeKeys);
		Assert.assertEquals("Expected grouped map size", 0, map.size());
	}

	@Test
	public void testToMap__WhenCalculatedKeyNull() {
		List<String> names = new ArrayList<String>();
		names.add("Mueller");
		names.add("Schneider");
		names.add("Schmidt");
		names.add("Koch");
		Function1<String, String> computeKeys = new Function1<String, String>() {

			@Override
			public String apply(String p) {
				return p.contains("y") ? "y" : null;
			}
		};
		Map<String, String> map = IteratorExtensions.toMap(names.iterator(), computeKeys);
		Assert.assertEquals("Expected grouped map size", 1, map.size());
		Assert.assertTrue("Contains null as key", map.keySet().contains(null));
		Assert.assertEquals("Contains entry Koch for key null", "Koch", map.get(null));
	}

	@Test
	public void testToMap__WhenNoValuesForKey() {
		List<String> names = new ArrayList<String>();
		names.add("Mueller");
		names.add("Schneider");
		names.add("Schmidt");
		names.add("Koch");
		Function1<String, Boolean> computeKeys = new Function1<String, Boolean>() {

			@Override
			public Boolean apply(String p) {
				return p.contains("y");
			}
		};
		Map<Boolean, String> map = IteratorExtensions.toMap(names.iterator(), computeKeys);
		Assert.assertEquals("Expected grouped map size", 1, map.size());
		Assert.assertTrue("Contains FALSE as key", map.keySet().contains(Boolean.FALSE));
		Assert.assertTrue("Contains entry Mueller for key FALSE", map.get(Boolean.FALSE).equals("Koch"));
		Assert.assertNull("Contains no entry for key Boolean.TRUE", map.get(Boolean.TRUE));
	}

	@Test(expected = NullPointerException.class)
	public void testToMap__WhenFunctionNull() {
		List<Pair<Integer, String>> pairs = new ArrayList<Pair<Integer, String>>();
		Function1<Pair<Integer, String>, Integer> computeKeys = null;
		IteratorExtensions.toMap(pairs.iterator(), computeKeys);
	}	
	
	@Test
	public void testGroupBy() {
		List<Pair<Integer, String>> pairs = new ArrayList<Pair<Integer, String>>();
		pairs.add(new Pair<Integer, String>(1, "A"));
		pairs.add(new Pair<Integer, String>(1, "a"));
		pairs.add(new Pair<Integer, String>(2, "B"));
		pairs.add(new Pair<Integer, String>(2, "b"));
		Function1<Pair<Integer, String>, Integer> computeKeys = new Function1<Pair<Integer, String>, Integer>() {

			@Override
			public Integer apply(Pair<Integer, String> p) {
				return p.getKey();
			}
		};
		Map<Integer, List<Pair<Integer, String>>> map = IteratorExtensions.groupBy(pairs.iterator(), computeKeys);
		Assert.assertEquals("Expected grouped map size", 2, map.size());
		Assert.assertTrue("Contains 1 as key", map.keySet().contains(1));
		Assert.assertEquals("Contains 2 entries for key 1", 2, map.get(1).size());
		Assert.assertEquals("Contains entry 1->A for key 1", new Pair<Integer, String>(1, "A"), map.get(1).get(0));
		Assert.assertEquals("Contains entry 1->a for key 1", new Pair<Integer, String>(1, "a"), map.get(1).get(1));
		Assert.assertTrue("Contains 2 as key", map.keySet().contains(2));
		Assert.assertEquals("Contains 2 entries for key 2", 2, map.get(2).size());
		Assert.assertEquals("Contains entry 2->B for key 2", new Pair<Integer, String>(2, "B"), map.get(2).get(0));
		Assert.assertEquals("Contains entry 2->b for key 2", new Pair<Integer, String>(2, "b"), map.get(2).get(1));
	}

	@Test
	public void testGroupBy__WhenEmptyList() {
		List<Pair<Integer, String>> pairs = new ArrayList<Pair<Integer, String>>();
		Function1<Pair<Integer, String>, Integer> computeKeys = new Function1<Pair<Integer, String>, Integer>() {

			@Override
			public Integer apply(Pair<Integer, String> p) {
				return p.getKey();
			}
		};
		Map<Integer, List<Pair<Integer, String>>> map = IteratorExtensions.groupBy(pairs.iterator(), computeKeys);
		Assert.assertEquals("Expected grouped map size", 0, map.size());
	}

	@Test
	public void testGroupBy__WhenCalculatedKeyNull() {
		List<String> names = new ArrayList<String>();
		names.add("Mueller");
		names.add("Schneider");
		names.add("Schmidt");
		names.add("Koch");
		Function1<String, String> computeKeys = new Function1<String, String>() {

			@Override
			public String apply(String p) {
				return p.contains("y") ? "y" : null;
			}
		};
		Map<String, List<String>> map = IteratorExtensions.groupBy(names.iterator(), computeKeys);
		Assert.assertEquals("Expected grouped map size", 1, map.size());
		Assert.assertTrue("Contains null as key", map.keySet().contains(null));
		Assert.assertEquals("Contains 4 entries for key null", 4, map.get(null).size());
	}

	@Test
	public void testGroupBy__WhenNoValuesForKey() {
		List<String> names = new ArrayList<String>();
		names.add("Mueller");
		names.add("Schneider");
		names.add("Schmidt");
		names.add("Koch");
		Function1<String, Boolean> computeKeys = new Function1<String, Boolean>() {

			@Override
			public Boolean apply(String p) {
				return p.contains("y");
			}
		};
		Map<Boolean, List<String>> map = IteratorExtensions.groupBy(names.iterator(), computeKeys);
		Assert.assertEquals("Expected grouped map size", 1, map.size());
		Assert.assertTrue("Contains FALSE as key", map.keySet().contains(Boolean.FALSE));
		Assert.assertEquals("Contains 4 entries for key Boolean.FALSE", 4, map.get(Boolean.FALSE).size());
		Assert.assertTrue("Contains entry Mueller for key FALSE", map.get(Boolean.FALSE).contains("Mueller"));
		Assert.assertNull("Contains no entry for key Boolean.TRUE", map.get(Boolean.TRUE));
	}

	@Test(expected = NullPointerException.class)
	public void testGroupBy__WhenFunctionNull() {
		List<Pair<Integer, String>> pairs = new ArrayList<Pair<Integer, String>>();
		Function1<Pair<Integer, String>, Integer> computeKeys = null;
		IteratorExtensions.groupBy(pairs.iterator(), computeKeys);
	}	
}
