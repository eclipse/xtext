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

import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IterableExtensionsTest extends BaseIterablesIteratorsTest<Iterable<Integer>> {

	@Override
	protected Iterable<Integer>[] testData(Integer... elements) {
		@SuppressWarnings("unchecked")
		Iterable<Integer>[] result = new Iterable[] {
			Lists.newArrayList(elements),
			Lists.newLinkedList(Lists.newArrayList(elements)),
			Sets.newLinkedHashSet(Lists.newArrayList(elements)),
			Sets.newTreeSet(Lists.newArrayList(elements))
		};
		return result;
	}
	
	@Override
	protected Iterable<Integer>[] nullableTestData(Integer... elements) {
		@SuppressWarnings("unchecked")
		Iterable<Integer>[] result = new Iterable[] {
			Lists.newArrayList(elements),
			Lists.newLinkedList(Lists.newArrayList(elements)),
			Sets.newLinkedHashSet(Lists.newArrayList(elements)),
//			Sets.newTreeSet(Lists.newArrayList(elements)) null is not allowed
		};
		return result;
	}

	@Override
	protected Iterable<Integer> dummy() {
		return Collections.emptyList();
	}

	@Override
	protected boolean is(Iterable<Integer> input, Integer... elements) {
		return Iterables.elementsEqual(input, Lists.newArrayList(elements));
	}

	@Override
	protected Iterable<Integer> operator_plus(Iterable<Integer> first, Iterable<Integer> second) {
		return IterableExtensions.operator_plus(first, second);
	}

	@Override
	protected Integer findFirst(Iterable<Integer> input, Function1<Integer, Boolean> filter) {
		return IterableExtensions.findFirst(input, filter);
	}

	@Override
	protected Integer findLast(Iterable<Integer> input, Function1<Integer, Boolean> filter) {
		return IterableExtensions.findLast(input, filter);
	}

	@Override
	protected Integer last(Iterable<Integer> input) {
		return IterableExtensions.last(input);
	}

	@Override
	protected Integer head(Iterable<Integer> input) {
		return IterableExtensions.head(input);
	}
	
	@Override
	protected void forEach(Iterable<Integer> input, Procedure2<Integer, Integer> proc) {
		IterableExtensions.forEach(input, proc);
	}
	
	@Override
	protected Iterable<Integer> takeWhile(Iterable<Integer> input, Function1<Integer, Boolean> filter) {
		return IterableExtensions.takeWhile(input, filter);
	}
	
	@Override
	protected Iterable<Integer> dropWhile(Iterable<Integer> input, Function1<Integer, Boolean> filter) {
		return IterableExtensions.dropWhile(input, filter);
	}
	
	@Override
	protected Integer max(Iterable<Integer> input) {
		return IterableExtensions.max(input);
	}
	
	@Override
	protected Integer max(Iterable<Integer> input, Comparator<? super Integer> comparator) {
		return IterableExtensions.max(input, comparator);
	}
	
	@Override
	protected Integer maxBy(Iterable<Integer> input, Function1<? super Integer, String> compareBy) {
		return IterableExtensions.maxBy(input, compareBy);
	}
	
	@Override
	protected Integer min(Iterable<Integer> input) {
		return IterableExtensions.min(input);
	}
	
	@Override
	protected Integer min(Iterable<Integer> input, Comparator<? super Integer> comparator) {
		return IterableExtensions.min(input, comparator);
	}
	
	@Override
	protected Integer minBy(Iterable<Integer> input, Function1<? super Integer, String> compareBy) {
		return IterableExtensions.minBy(input, compareBy);
	}
	
	@Test public void testJoinWithNull() {
		List<String> list = Lists.newArrayList("a", null, "c");
		String string = IterableExtensions.join(list, ",");
		assertEquals("a,null,c", string);
	}
	
	@Test public void testSortBy() throws Exception {
		List<? extends CharSequence> list = newArrayList("foo","bar","baz");
		List<? extends CharSequence> sorted = IterableExtensions.sortBy(list, new Functions.Function1<CharSequence, String>() {
			@Override
			public String apply(CharSequence p) {
				return p.toString();
			}
		});
		assertNotSame(list, sorted);
		assertEquals(sorted, newArrayList("bar","baz","foo"));
	}
	
	@Test public void testFilterNull() throws Exception {
		Iterator<String> iter = IterableExtensions.filterNull(newArrayList("foo", null, "bar")).iterator();
		assertEquals("foo", iter.next());
		assertEquals("bar", iter.next());
		assertFalse(iter.hasNext());
	}
	
	@Test public void testJoinWithBeforeAndAfter() throws Exception {
		ArrayList<String> list = newArrayList("foo", "bar");
		ArrayList<String> singletonList = newArrayList("foo");
		ArrayList<String> emptylist = new ArrayList<String>();
		
		final Functions.Function1<String, String> function = new Functions.Function1<String, String>() {
			@Override
			public String apply(String p) {
				return p;
			}
		};
		assertEquals("<foo,bar>", IterableExtensions.join(list, "<", ",", ">", function));
		assertEquals("<foo>", IterableExtensions.join(singletonList, "<", ",", ">", function));
		assertEquals("", IterableExtensions.join(emptylist, "<", ",", ">", function));
		
		assertEquals("foo,bar>", IterableExtensions.join(list, null, ",", ">", function));
		assertEquals("foo>", IterableExtensions.join(singletonList, null, ",", ">", function));
		assertEquals("", IterableExtensions.join(emptylist, null, ",", ">", function));
		
		assertEquals("<foobar>", IterableExtensions.join(list, "<", null, ">", function));
		assertEquals("<foo>", IterableExtensions.join(singletonList, "<", null, ">", function));
		assertEquals("", IterableExtensions.join(emptylist, "<", null, ">", function));
		
		assertEquals("<foo,bar", IterableExtensions.join(list, "<", ",", null, function));
		assertEquals("<foo", IterableExtensions.join(singletonList, "<", ",", null, function));
		assertEquals("", IterableExtensions.join(emptylist, "<", ",", null, function));
	}
	
	@Test public void testIndexed() {
		Iterator<Pair<Integer, String>> result = IterableExtensions.indexed(newArrayList("foo", "bar")).iterator();
		assertEquals(new Pair<Integer, String>(0, "foo"), result.next());
		assertEquals(new Pair<Integer, String>(1, "bar"), result.next());
		assertFalse(result.hasNext());
	}

	
}
