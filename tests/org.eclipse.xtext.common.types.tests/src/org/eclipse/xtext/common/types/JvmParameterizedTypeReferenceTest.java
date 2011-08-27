/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
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
public class JvmParameterizedTypeReferenceTest extends TestCase {

	private JvmParameterizedTypeReference parameterizedType;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		parameterizedType = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
	}
	
	public void testGetIdentifier_01() {
		assertNull(parameterizedType.getIdentifier());
	}
	
	public void testGetIdentifier_02() {
		JvmPrimitiveType primitiveType = TypesFactory.eINSTANCE.createJvmPrimitiveType();
		primitiveType.setSimpleName("int");
		parameterizedType.setType(primitiveType);
		assertEquals("int", parameterizedType.getIdentifier());
	}
	
	public void testGetIdentifier_03() {
		JvmGenericType genericType = TypesFactory.eINSTANCE.createJvmGenericType();
		genericType.internalSetIdentifier("java.util.List");
		parameterizedType.setType(genericType);
		assertEquals("java.util.List", parameterizedType.getIdentifier());
	}
	
	public void testGetIdentifier_04() {
		JvmGenericType genericType = TypesFactory.eINSTANCE.createJvmGenericType();
		genericType.internalSetIdentifier("java.util.List");
		parameterizedType.setType(genericType);
		JvmParameterizedTypeReference argumentReference = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
		JvmGenericType argumentType = TypesFactory.eINSTANCE.createJvmGenericType();
		argumentType.internalSetIdentifier("java.lang.String");
		argumentReference.setType(argumentType);
		parameterizedType.getArguments().add(argumentReference);
		assertEquals("java.util.List<java.lang.String>", parameterizedType.getIdentifier());
	}
	
	public void testGetIdentifier_05() {
		JvmPrimitiveType primitiveType = TypesFactory.eINSTANCE.createJvmPrimitiveType();
		primitiveType.setSimpleName("int");
		JvmArrayType arrayType = TypesFactory.eINSTANCE.createJvmArrayType();
		arrayType.setComponentType(primitiveType);
		primitiveType.setArrayType(arrayType);
		parameterizedType.setType(arrayType);
		assertEquals("int[]", parameterizedType.getIdentifier());
	}
}
