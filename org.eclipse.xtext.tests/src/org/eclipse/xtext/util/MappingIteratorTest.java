/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.collect.Iterators;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class MappingIteratorTest extends Assert implements Function<String, String> {

	@Override
	public String apply(String param) {
		return param + "->" + param;
	}
	
	@Test public void testEmptyIter() {
		Iterator<String> iter = createMappingIterator(new String[]{});
		assertFalse(iter.hasNext());
	}
	
	@Test public void testSingleElementIter() {
		Iterator<String> iter = createMappingIterator("a");
		assertTrue(iter.hasNext());
		assertEquals("a->a", iter.next());
		assertFalse(iter.hasNext());
	}
	
	@Test public void testMultiElementIter() {
		Iterator<String> iter = createMappingIterator("a", "b", "c");
		assertEquals("a->a", iter.next());
		assertEquals("b->b", iter.next());
		assertEquals("c->c", iter.next());
		assertFalse(iter.hasNext());
	}
	
	@Test public void testNullIter() {
		try {
			Iterators.transform(null, this);
			fail("NPE expected");
		} catch(NullPointerException e) {
			// expected
		}
	}
	
	@Test public void testNullFunction() {
		try {
			Iterators.transform(createMappingIterator("a"), null);
		} catch(NullPointerException e) {
			// expected
		}
	}
	
	private Iterator<String> createMappingIterator(String ...strings) {
		return Iterators.transform(Arrays.asList(strings).iterator(), this);
	}

}
