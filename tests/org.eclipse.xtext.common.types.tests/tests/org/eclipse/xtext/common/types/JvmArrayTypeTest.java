/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmArrayTypeTest extends TestCase {

	private JvmArrayType arrayType;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		arrayType = TypesFactory.eINSTANCE.createJvmArrayType();
	}	
	
	public void testGetIdentifier_01() {
		assertNull(arrayType.getIdentifier());
	}
	
	public void testGetIdentifier_02() {
		JvmPrimitiveType primitiveType = TypesFactory.eINSTANCE.createJvmPrimitiveType();
		primitiveType.setSimpleName("int");
		arrayType.setComponentType(primitiveType);
		assertEquals("int[]", arrayType.getIdentifier());
	}
	
	public void testGetIdentifier_03() {
		JvmPrimitiveType primitiveType = TypesFactory.eINSTANCE.createJvmPrimitiveType();
		primitiveType.setSimpleName("int");
		JvmArrayType arrayType = TypesFactory.eINSTANCE.createJvmArrayType();
		arrayType.setComponentType(primitiveType);
		this.arrayType.setComponentType(arrayType);
		assertEquals("int[][]", this.arrayType.getIdentifier());
	}
	
	public void testGetDimension_01() {
		JvmPrimitiveType primitiveType = TypesFactory.eINSTANCE.createJvmPrimitiveType();
		primitiveType.setSimpleName("int");
		arrayType.setComponentType(primitiveType);
		assertEquals(1, arrayType.getDimensions());
	}
	
	public void testGetDimension_02() {
		JvmPrimitiveType primitiveType = TypesFactory.eINSTANCE.createJvmPrimitiveType();
		primitiveType.setSimpleName("int");
		JvmArrayType arrayType = TypesFactory.eINSTANCE.createJvmArrayType();
		arrayType.setComponentType(primitiveType);
		this.arrayType.setComponentType(arrayType);
		assertEquals(2, this.arrayType.getDimensions());
	}
	
	public void testGetDimension_03() {
		JvmArrayType arrayType = TypesFactory.eINSTANCE.createJvmArrayType();
		try {
			arrayType.getDimensions();
			fail("Expected NPE");
		} catch(NullPointerException e) {
			// ok
		}
	}
	
}
