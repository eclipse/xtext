/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClassFinderTest extends TestCase {

	private ClassFinder classFinder;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		classFinder = new ClassFinder(getClass().getClassLoader());
	}
	
	@Override
	protected void tearDown() throws Exception {
		classFinder = null;
		super.tearDown();
	}
	
	public void testVoid() throws ClassNotFoundException {
		assertSame(Void.TYPE, classFinder.forName("void"));
	}
	
	public void testInt() throws ClassNotFoundException {
		assertSame(Integer.TYPE, classFinder.forName("int"));
	}
	
	public void testIntArray_01() throws ClassNotFoundException {
		assertSame(int[].class, classFinder.forName("int[]"));
	}
	
	public void testIntArray_02() throws ClassNotFoundException {
		assertSame(int[].class, classFinder.forName(int[].class.getName()));
	}
	
	public void testObject() throws ClassNotFoundException {
		assertSame(Object.class, classFinder.forName("java.lang.Object"));
	}
	
	public void testObjectArray_01() throws ClassNotFoundException {
		assertSame(Object[].class, classFinder.forName("java.lang.Object[]"));
	}
	
	public void testObjectArray_02() throws ClassNotFoundException {
		assertSame(Object[].class, classFinder.forName(Object[].class.getName()));
	}
	
}
