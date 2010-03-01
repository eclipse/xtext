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
public class ParameterizedTypeReferenceTest extends TestCase {

	private ParameterizedTypeReference parameterizedType;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		parameterizedType = TypesFactory.eINSTANCE.createParameterizedTypeReference();
	}
	
	public void testCanonicalName_01() {
		assertNull(parameterizedType.getCanonicalName());
	}
	
	public void testCanonicalName_02() {
		PrimitiveType primitiveType = TypesFactory.eINSTANCE.createPrimitiveType();
		primitiveType.setName("int");
		parameterizedType.setType(primitiveType);
		assertEquals("int", parameterizedType.getCanonicalName());
	}
	
	public void testCanonicalName_03() {
		GenericType genericType = TypesFactory.eINSTANCE.createGenericType();
		genericType.setFullyQualifiedName("java.util.List");
		parameterizedType.setType(genericType);
		assertEquals("java.util.List", parameterizedType.getCanonicalName());
	}
	
	public void testCanonicalName_04() {
		GenericType genericType = TypesFactory.eINSTANCE.createGenericType();
		genericType.setFullyQualifiedName("java.util.List");
		parameterizedType.setType(genericType);
		ReferenceTypeArgument argument = TypesFactory.eINSTANCE.createReferenceTypeArgument();
		ParameterizedTypeReference argumentReference = TypesFactory.eINSTANCE.createParameterizedTypeReference();
		GenericType argumentType = TypesFactory.eINSTANCE.createGenericType();
		argumentType.setFullyQualifiedName("java.lang.String");
		argumentReference.setType(argumentType);
		argument.setTypeReference(argumentReference);
		parameterizedType.getArguments().add(argument);
		assertEquals("java.util.List<java.lang.String>", parameterizedType.getCanonicalName());
	}
	
	public void testCanonicalName_05() {
		PrimitiveType primitiveType = TypesFactory.eINSTANCE.createPrimitiveType();
		primitiveType.setName("int");
		ArrayType arrayType = TypesFactory.eINSTANCE.createArrayType();
		ParameterizedTypeReference componentTypeRef = TypesFactory.eINSTANCE.createParameterizedTypeReference();
		componentTypeRef.setType(primitiveType);
		arrayType.setComponentType(componentTypeRef);
		primitiveType.setArrayType(arrayType);
		parameterizedType.setType(arrayType);
		assertEquals("int[]", parameterizedType.getCanonicalName());
	}
}
