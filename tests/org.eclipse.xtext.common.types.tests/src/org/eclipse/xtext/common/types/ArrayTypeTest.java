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
public class ArrayTypeTest extends TestCase {

	private ArrayType arrayType;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		arrayType = TypesFactory.eINSTANCE.createArrayType();
	}	
	
	public void testCanonicalName_01() {
		assertNull(arrayType.getCanonicalName());
	}
	
	public void testCanonicalName_02() {
		PrimitiveType primitiveType = TypesFactory.eINSTANCE.createPrimitiveType();
		primitiveType.setName("int");
		arrayType.setComponentType(primitiveType);
		assertEquals("int[]", arrayType.getCanonicalName());
	}
	
	public void testCanonicalName_03() {
		PrimitiveType primitiveType = TypesFactory.eINSTANCE.createPrimitiveType();
		primitiveType.setName("int");
		ArrayType arrayType = TypesFactory.eINSTANCE.createArrayType();
		arrayType.setComponentType(primitiveType);
		this.arrayType.setComponentType(arrayType);
		assertEquals("int[][]", this.arrayType.getCanonicalName());
	}
	
}
