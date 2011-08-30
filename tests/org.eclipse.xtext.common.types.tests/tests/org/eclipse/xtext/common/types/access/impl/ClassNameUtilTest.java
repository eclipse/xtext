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
public class ClassNameUtilTest extends TestCase {

	private ClassNameUtil classNameUtil;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		classNameUtil = new ClassNameUtil();
	}
	
	public void testNormalizeClassName_01() {
		String name = String.class.getName();
		assertEquals(name, classNameUtil.normalizeClassName(name));
	}
	
	public void testNormalizeClassName_02() {
		String name = String[].class.getName();
		assertEquals(name, classNameUtil.normalizeClassName(name));
	}
	
	public void testNormalizeClassName_03() {
		String name = int.class.getName();
		assertEquals(name, classNameUtil.normalizeClassName(name));
	}
	
	public void testNormalizeClassName_04() {
		String name = int[].class.getName();
		assertEquals(name, classNameUtil.normalizeClassName(name));
	}
	
	public void testNormalizeClassName_05() {
		String name = String[].class.getName();
		assertEquals(name, classNameUtil.normalizeClassName(String.class.getName() + "[]"));
	}
	
	public void testNormalizeClassName_06() {
		String name = int[].class.getName();
		assertEquals(name, classNameUtil.normalizeClassName(int.class.getName() + "[]"));
	}
	
	public void testNormalizeClassName_07() {
		Class<?>[] allArrayTypes = {
				boolean[].class,
				int[].class,
				float[].class,
				byte[].class,
				char[].class,
				double[].class,
				short[].class,
				long[].class,
				String[].class
		};
		for(Class<?> arrayType: allArrayTypes) {
			Class<?> componentType = arrayType.getComponentType();
			String name = componentType.getName() + "[]";
			String expectedName = arrayType.getName();
			assertEquals(expectedName, classNameUtil.normalizeClassName(name));
		}
	}
}
