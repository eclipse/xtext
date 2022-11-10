/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ReflectionTest extends Assert {
	
	@Test public void testGetMethodGivesCopy() throws Exception {
		Class<MyClass> clazz = MyClass.class;
		MyClass instance = new MyClass();
		Method declaredMethod = clazz.getDeclaredMethod("getString");
		assertNotNull("declaredMethod", declaredMethod);
		assertFalse("isAccessible", declaredMethod.canAccess(instance));
		declaredMethod.setAccessible(true);
		assertTrue("isAccessible", declaredMethod.canAccess(instance));
		Method secondMethod = clazz.getDeclaredMethod("getString");
		assertNotSame(declaredMethod, secondMethod);
		assertFalse("isAccessible", secondMethod.canAccess(instance));
	}

}
