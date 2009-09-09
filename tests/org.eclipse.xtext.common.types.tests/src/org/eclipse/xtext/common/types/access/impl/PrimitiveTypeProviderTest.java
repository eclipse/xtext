/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.eclipse.xtext.common.types.PrimitiveType;
import org.eclipse.xtext.common.types.Type;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PrimitiveTypeProviderTest extends TestCase implements IClasspathTypeProvider {

	private PrimitiveTypeProvider provider;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		provider = new PrimitiveTypeProvider();
	}
	
	public void testByte() {
		assertEquals("byte", createType(Byte.TYPE).getCanonicalName());
	}
	
	public void testShort() {
		assertEquals("short", createType(Short.TYPE).getCanonicalName());
	}
	
	public void testInt() {
		assertEquals("int", createType(Integer.TYPE).getCanonicalName());
	}
	
	public void testLong() {
		assertEquals("long", createType(Long.TYPE).getCanonicalName());
	}
	
	public void testFloat() {
		assertEquals("float", createType(Float.TYPE).getCanonicalName());
	}
	
	public void testDouble() {
		assertEquals("double", createType(Double.TYPE).getCanonicalName());
	}
	
	public void testChar() {
		assertEquals("char", createType(Character.TYPE).getCanonicalName());
	}
	
	public void testBoolean() {
		assertEquals("boolean", createType(Boolean.TYPE).getCanonicalName());
	}
	
	public void testVoid() {
		assertTrue(provider.createType(Void.TYPE) instanceof org.eclipse.xtext.common.types.Void);
	}

	public <T> Type createType(Class<T> clazz) {
		Type result = provider.createType(clazz);
		assertTrue(result instanceof PrimitiveType);
		return result;
	}
}
