/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Function;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SimpleCacheTest extends Assert implements Function<String, String>{

	private SimpleCache<String, String> cache;

	private String expectedParam;

	private int callCount;

	@Before
	public void setUp() throws Exception {
		this.cache = new SimpleCache<String, String>(this);
		expectedParam = null;
		callCount = 0;
	}

	@Override
	public String apply(String param) {
		assertEquals(expectedParam, param);
		callCount++;
		return param + param;
	}

	@Test public void testInitial() {
		assertEquals(0, cache.getSize());
	}

	@Test public void testGet() {
		expectedParam = new String("param"); // is not interned
		String cached = cache.get(expectedParam);
		assertEquals("paramparam", cached);
		assertEquals(1, callCount);
		assertEquals(1, cache.getSize());
		assertSame(cached, cache.get(new String(expectedParam)));
		assertEquals(1, callCount);
		assertEquals(1, cache.getSize());
	}

	@Test public void testDiscard() {
		String first = new String("first"); // is not interned
		expectedParam = first;
		cache.get(expectedParam);
		String second = new String("second"); // is not interned
		expectedParam = second;
		cache.get(expectedParam);
		assertEquals(2, cache.getSize());
		cache.discard(expectedParam);
		assertEquals(1, cache.getSize());
		assertFalse(cache.hasCachedValue(expectedParam));
	}

	@Test public void testClear() {
		expectedParam = new String("param"); // is not interned
		cache.get(expectedParam);
		assertEquals(1, cache.getSize());
		cache.clear();
		assertEquals(0, cache.getSize());
	}

}
