/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmArrayTypeTest extends Assert {

	private JvmArrayType arrayType;

	@Before
	public void setUp() throws Exception {
		arrayType = TypesFactory.eINSTANCE.createJvmArrayType();
	}	
	
	@Test public void testGetIdentifier_01() {
		assertNull(arrayType.getIdentifier());
	}
	
	@Test public void testGetIdentifier_02() {
		JvmPrimitiveType primitiveType = TypesFactory.eINSTANCE.createJvmPrimitiveType();
		primitiveType.setSimpleName("int");
		arrayType.setComponentType(primitiveType);
		assertEquals("int[]", arrayType.getIdentifier());
	}
	
	@Test public void testGetIdentifier_03() {
		JvmPrimitiveType primitiveType = TypesFactory.eINSTANCE.createJvmPrimitiveType();
		primitiveType.setSimpleName("int");
		JvmArrayType arrayType = TypesFactory.eINSTANCE.createJvmArrayType();
		arrayType.setComponentType(primitiveType);
		this.arrayType.setComponentType(arrayType);
		assertEquals("int[][]", this.arrayType.getIdentifier());
	}
	
	@Test public void testGetDimension_01() {
		JvmPrimitiveType primitiveType = TypesFactory.eINSTANCE.createJvmPrimitiveType();
		primitiveType.setSimpleName("int");
		arrayType.setComponentType(primitiveType);
		assertEquals(1, arrayType.getDimensions());
	}
	
	@Test public void testGetDimension_02() {
		JvmPrimitiveType primitiveType = TypesFactory.eINSTANCE.createJvmPrimitiveType();
		primitiveType.setSimpleName("int");
		JvmArrayType arrayType = TypesFactory.eINSTANCE.createJvmArrayType();
		arrayType.setComponentType(primitiveType);
		this.arrayType.setComponentType(arrayType);
		assertEquals(2, this.arrayType.getDimensions());
	}
	
	@Test public void testGetDimension_03() {
		JvmArrayType arrayType = TypesFactory.eINSTANCE.createJvmArrayType();
		try {
			arrayType.getDimensions();
			fail("Expected NPE");
		} catch(NullPointerException e) {
			// ok
		}
	}
	
}
