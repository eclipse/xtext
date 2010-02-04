/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import junit.framework.TestCase;

import com.google.common.base.Function;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SimpleCacheTest extends TestCase implements Function<String, String>{

	private SimpleCache<String, String> cache;

	private String expectedParam;

	private int callCount;

	@Override
	protected void setUp() throws Exception {
		this.cache = new SimpleCache<String, String>(this);
		expectedParam = null;
		callCount = 0;
	}

	public String apply(String param) {
		assertEquals(expectedParam, param);
		callCount++;
		return param + param;
	}

	public void testInitial() {
		assertEquals(0, cache.getSize());
	}

	public void testGet() {
		expectedParam = new String("param"); // is not interned
		String cached = cache.get(expectedParam);
		assertEquals("paramparam", cached);
		assertEquals(1, callCount);
		assertEquals(1, cache.getSize());
		assertSame(cached, cache.get(new String(expectedParam)));
		assertEquals(1, callCount);
		assertEquals(1, cache.getSize());
	}

	public void testDiscard() {
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

	public void testClear() {
		expectedParam = new String("param"); // is not interned
		cache.get(expectedParam);
		assertEquals(1, cache.getSize());
		cache.clear();
		assertEquals(0, cache.getSize());
	}

}
