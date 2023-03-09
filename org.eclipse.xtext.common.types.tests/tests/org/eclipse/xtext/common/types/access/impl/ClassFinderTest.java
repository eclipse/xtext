/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClassFinderTest extends Assert {

	private ClassFinder classFinder;

	@Before
	public void setUp() throws Exception {
		classFinder = new ClassFinder(getClass().getClassLoader());
	}
	
	@After
	public void tearDown() throws Exception {
		classFinder = null;
	}
	
	@Test public void testVoid() throws ClassNotFoundException {
		assertSame(Void.TYPE, classFinder.forName("void"));
	}
	
	@Test public void testInt() throws ClassNotFoundException {
		assertSame(Integer.TYPE, classFinder.forName("int"));
	}
	
	@Test public void testIntArray_01() throws ClassNotFoundException {
		assertSame(int[].class, classFinder.forName("int[]"));
	}
	
	@Test public void testIntArray_02() throws ClassNotFoundException {
		assertSame(int[].class, classFinder.forName(int[].class.getName()));
	}
	
	@Test public void testObject() throws ClassNotFoundException {
		assertSame(Object.class, classFinder.forName("java.lang.Object"));
	}
	
	@Test public void testObjectArray_01() throws ClassNotFoundException {
		assertSame(Object[].class, classFinder.forName("java.lang.Object[]"));
	}
	
	@Test public void testObjectArray_02() throws ClassNotFoundException {
		assertSame(Object[].class, classFinder.forName(Object[].class.getName()));
	}
	
}
