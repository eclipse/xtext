/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.eclipse.xtext.common.types.access.binary.BinaryClassFinder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BinaryClassFinderTest extends Assert {

	private BinaryClassFinder classFinder;

	@Before
	public void setUp() throws Exception {
		classFinder = new BinaryClassFinder(getClass().getClassLoader());
	}
	
	@After
	public void tearDown() throws Exception {
		classFinder = null;
	}
	
	@Test public void testVoid() throws ClassNotFoundException {
		assertEquals(Void.TYPE.getName(), classFinder.forName("void").getName());
	}
	
	@Test public void testInt() throws ClassNotFoundException {
		assertEquals(Integer.TYPE.getName(), classFinder.forName("int").getName());
	}
	
	@Test public void testIntArray_01() throws ClassNotFoundException {
		assertEquals(int[].class.getName(), classFinder.forName("int[]").getName());
	}
	
	@Test public void testIntArray_02() throws ClassNotFoundException {
		assertEquals(int[].class.getName(), classFinder.forName(int[].class.getName()).getName());
	}
	
	@Test public void testObject() throws ClassNotFoundException {
		assertEquals(Object.class.getName(), classFinder.forName("java.lang.Object").getName());
	}
	
	@Test public void testObjectArray_01() throws ClassNotFoundException {
		assertEquals(Object[].class.getName(), classFinder.forName("java.lang.Object[]").getName());
	}
	
	@Test public void testObjectArray_02() throws ClassNotFoundException {
		assertEquals(Object[].class.getName(), classFinder.forName(Object[].class.getName()).getName());
	}
	
}
