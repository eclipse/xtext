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

import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
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
	
	@Test public void testZip() {
		Iterator<Pair<String, Integer>> result = IteratorExtensions.zip(newArrayList("foo", "bar").iterator(), newArrayList(1, 2, 3).iterator());
		assertEquals(new Pair<String, Integer>("foo", 1), result.next());
		assertEquals(new Pair<String, Integer>("bar", 2), result.next());
		assertFalse(result.hasNext());
	}
	
	@Test public void testZipWithIndex() {
		Iterator<Pair<String, Integer>> result = IteratorExtensions.zipWithIndex(newArrayList("foo", "bar").iterator());
		assertEquals(new Pair<String, Integer>("foo", 0), result.next());
		assertEquals(new Pair<String, Integer>("bar", 1), result.next());
		assertFalse(result.hasNext());
	}
}
