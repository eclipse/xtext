/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PrimitiveTypeFactoryTest extends TestCase implements ITypeFactory<Class<?>> {

	private PrimitiveTypeFactory provider;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		provider = new PrimitiveTypeFactory();
	}
	
	public void testByte() {
		assertEquals("byte", createType(Byte.TYPE).getIdentifier());
	}
	
	public void testShort() {
		assertEquals("short", createType(Short.TYPE).getIdentifier());
	}
	
	public void testInt() {
		assertEquals("int", createType(Integer.TYPE).getIdentifier());
	}
	
	public void testLong() {
		assertEquals("long", createType(Long.TYPE).getIdentifier());
	}
	
	public void testFloat() {
		assertEquals("float", createType(Float.TYPE).getIdentifier());
	}
	
	public void testDouble() {
		assertEquals("double", createType(Double.TYPE).getIdentifier());
	}
	
	public void testChar() {
		assertEquals("char", createType(Character.TYPE).getIdentifier());
	}
	
	public void testBoolean() {
		assertEquals("boolean", createType(Boolean.TYPE).getIdentifier());
	}
	
	public void testVoid() {
		assertTrue(provider.createType(Void.TYPE) instanceof org.eclipse.xtext.common.types.JvmVoid);
	}

	public JvmType createType(Class<?> clazz) {
		JvmType result = provider.createType(clazz);
		assertTrue(result instanceof JvmPrimitiveType);
		return result;
	}
}
