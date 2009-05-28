/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FilteringIteratorTest extends TestCase implements Predicate<String> {

	private String matchMe;

	private List<String> list;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		matchMe = "matchMe";
		list = new ArrayList<String>();
	}

	public boolean apply(String param) {
		return param.equals(matchMe);
	}

	public void testEmptyList() {
		Iterator<String> iter = Iterators.filter(list.iterator(), this);
		assertFalse(iter.hasNext());
	}

	public void testConcurrentModificationException() {
		Iterator<String> iter = Iterators.filter(list.iterator(), this);
		list.add("null");
		try {
			iter.hasNext();
			fail("expected exception");
		} catch (ConcurrentModificationException ex) {
		}
	}

	public void testRemove() {
		list.add(matchMe);
		Iterator<String> iter = Iterators.filter(list.iterator(), this);
		iter.next();
		try {
			iter.remove();
			fail("expected exception");
		} catch (UnsupportedOperationException ex) {
		}
	}

	public void testHasNext() {
		list.add("null");
		list.add(matchMe);
		list.add("null");
		Iterator<String> iter = Iterators.filter(list.iterator(), this);
		assertTrue(iter.hasNext());
		assertTrue(iter.hasNext());
		assertEquals(matchMe, iter.next());
		assertFalse(iter.hasNext());
	}

	public void testNext() {
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

	public void testNextCallsHasNext() {
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
