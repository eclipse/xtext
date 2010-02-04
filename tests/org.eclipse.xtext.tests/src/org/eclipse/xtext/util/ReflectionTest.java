/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.lang.reflect.Method;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ReflectionTest extends TestCase {
	
	private static class MyClass {
		@SuppressWarnings("unused")
		private String getString() {
			return "string";
		}
	}
	
	public void testGetMethodGivesCopy() throws Exception {
		Class<MyClass> clazz = MyClass.class;
		Method declaredMethod = clazz.getDeclaredMethod("getString");
		assertNotNull("declaredMethod", declaredMethod);
		assertFalse("isAccessible", declaredMethod.isAccessible());
		declaredMethod.setAccessible(true);
		assertTrue("isAccessible", declaredMethod.isAccessible());
		Method secondMethod = clazz.getDeclaredMethod("getString");
		assertNotSame(declaredMethod, secondMethod);
		assertFalse("isAccessible", secondMethod.isAccessible());
	}

}
