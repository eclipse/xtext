/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClassNameUtilTest extends Assert {

	private ClassNameUtil classNameUtil;

	@Before
	public void setUp() throws Exception {
		classNameUtil = new ClassNameUtil();
	}
	
	@Test public void testNormalizeClassName_01() {
		String name = String.class.getName();
		assertEquals(name, classNameUtil.normalizeClassName(name));
	}
	
	@Test public void testNormalizeClassName_02() {
		String name = String[].class.getName();
		assertEquals(name, classNameUtil.normalizeClassName(name));
	}
	
	@Test public void testNormalizeClassName_03() {
		String name = int.class.getName();
		assertEquals(name, classNameUtil.normalizeClassName(name));
	}
	
	@Test public void testNormalizeClassName_04() {
		String name = int[].class.getName();
		assertEquals(name, classNameUtil.normalizeClassName(name));
	}
	
	@Test public void testNormalizeClassName_05() {
		String name = String[].class.getName();
		assertEquals(name, classNameUtil.normalizeClassName(String.class.getName() + "[]"));
	}
	
	@Test public void testNormalizeClassName_06() {
		String name = int[].class.getName();
		assertEquals(name, classNameUtil.normalizeClassName(int.class.getName() + "[]"));
	}
	
	@Test public void testNormalizeClassName_07() {
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
