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
	
	public void testCanonicalName_01() {
		assertNull(arrayType.getCanonicalName());
	}
	
	public void testCanonicalName_02() {
		JvmPrimitiveType primitiveType = TypesFactory.eINSTANCE.createJvmPrimitiveType();
		primitiveType.setName("int");
		JvmParameterizedTypeReference componentType = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
		componentType.setType(primitiveType);
		arrayType.setComponentType(componentType);
		assertEquals("int[]", arrayType.getCanonicalName());
	}
	
	public void testCanonicalName_03() {
		JvmPrimitiveType primitiveType = TypesFactory.eINSTANCE.createJvmPrimitiveType();
		primitiveType.setName("int");
		JvmParameterizedTypeReference componentType = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
		componentType.setType(primitiveType);
		JvmArrayType arrayType = TypesFactory.eINSTANCE.createJvmArrayType();
		arrayType.setComponentType(componentType);
		componentType = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
		componentType.setType(arrayType);
		this.arrayType.setComponentType(componentType);
		assertEquals("int[][]", this.arrayType.getCanonicalName());
	}
	
	public void testGetDimension_01() {
		JvmPrimitiveType primitiveType = TypesFactory.eINSTANCE.createJvmPrimitiveType();
		primitiveType.setName("int");
		JvmParameterizedTypeReference componentType = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
		componentType.setType(primitiveType);
		arrayType.setComponentType(componentType);
		assertEquals(1, arrayType.getDimensions());
	}
	
	public void testGetDimension_02() {
		JvmPrimitiveType primitiveType = TypesFactory.eINSTANCE.createJvmPrimitiveType();
		primitiveType.setName("int");
		JvmParameterizedTypeReference componentType = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
		componentType.setType(primitiveType);
		JvmArrayType arrayType = TypesFactory.eINSTANCE.createJvmArrayType();
		arrayType.setComponentType(componentType);
		componentType = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
		componentType.setType(arrayType);
		this.arrayType.setComponentType(componentType);
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
