/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PrimitiveTypeFactoryTest extends Assert implements ITypeFactory<Class<?>, JvmType> {

	private PrimitiveTypeFactory provider;

	@Before
	public void setUp() throws Exception {
		provider = new PrimitiveTypeFactory();
	}
	
	@Test public void testByte() {
		assertEquals("byte", createType(Byte.TYPE).getIdentifier());
	}
	
	@Test public void testShort() {
		assertEquals("short", createType(Short.TYPE).getIdentifier());
	}
	
	@Test public void testInt() {
		assertEquals("int", createType(Integer.TYPE).getIdentifier());
	}
	
	@Test public void testLong() {
		assertEquals("long", createType(Long.TYPE).getIdentifier());
	}
	
	@Test public void testFloat() {
		assertEquals("float", createType(Float.TYPE).getIdentifier());
	}
	
	@Test public void testDouble() {
		assertEquals("double", createType(Double.TYPE).getIdentifier());
	}
	
	@Test public void testChar() {
		assertEquals("char", createType(Character.TYPE).getIdentifier());
	}
	
	@Test public void testBoolean() {
		assertEquals("boolean", createType(Boolean.TYPE).getIdentifier());
	}
	
	@Test public void testVoid() {
		assertTrue(provider.createType(Void.TYPE) instanceof org.eclipse.xtext.common.types.JvmVoid);
	}

	@Override
	public JvmType createType(Class<?> clazz) {
		JvmType result = provider.createType(clazz);
		assertTrue(result instanceof JvmPrimitiveType);
		return result;
	}
}
