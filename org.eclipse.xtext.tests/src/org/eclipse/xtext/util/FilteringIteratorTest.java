/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FilteringIteratorTest extends Assert implements Predicate<String> {

	private String matchMe;

	private List<String> list;

	@Before
	public void setUp() throws Exception {
		matchMe = "matchMe";
		list = new ArrayList<String>();
	}

	@Override
	public boolean apply(String param) {
		return param.equals(matchMe);
	}

	@Test public void testEmptyList() {
		Iterator<String> iter = Iterators.filter(list.iterator(), this);
		assertFalse(iter.hasNext());
	}

	@Test public void testConcurrentModificationException() {
		Iterator<String> iter = Iterators.filter(list.iterator(), this);
		list.add("null");
		try {
			iter.hasNext();
			fail("expected exception");
		} catch (ConcurrentModificationException ex) {
		}
	}

	@Test public void testRemove() {
		list.add(matchMe);
		Iterator<String> iter = Iterators.filter(list.iterator(), this);
		iter.next();
		try {
			iter.remove();
			fail("expected exception");
		} catch (UnsupportedOperationException ex) {
		}
	}

	@Test public void testHasNext() {
		list.add("null");
		list.add(matchMe);
		list.add("null");
		Iterator<String> iter = Iterators.filter(list.iterator(), this);
		assertTrue(iter.hasNext());
		assertTrue(iter.hasNext());
		assertEquals(matchMe, iter.next());
		assertFalse(iter.hasNext());
	}

	@Test public void testNext() {
		list.add("null");
		list.add(matchMe);
		list.add("null");
		list.add(matchMe);
		Iterator<String> iter = Iterators.filter(list.iterator(), this);
		assertTrue(iter.hasNext());
		assertEquals(matchMe, iter.next());
		assertTrue(iter.hasNext());
		assertEquals(matchMe, iter.next());
		assertFalse(iter.hasNext());
	}

	@Test public void testNextCallsHasNext() {
		list.add("null");
		list.add(matchMe);
		list.add("null");
		list.add(matchMe);
		Iterator<String> iter = Iterators.filter(list.iterator(), this);
		assertEquals(matchMe, iter.next());
		assertEquals(matchMe, iter.next());
		assertFalse(iter.hasNext());
	}

}
