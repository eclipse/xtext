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
	
	public void testCanonicalName_01() {
		assertNull(parameterizedType.getCanonicalName());
	}
	
	public void testCanonicalName_02() {
		JvmPrimitiveType primitiveType = TypesFactory.eINSTANCE.createJvmPrimitiveType();
		primitiveType.setName("int");
		parameterizedType.setType(primitiveType);
		assertEquals("int", parameterizedType.getCanonicalName());
	}
	
	public void testCanonicalName_03() {
		JvmGenericType genericType = TypesFactory.eINSTANCE.createJvmGenericType();
		genericType.setFullyQualifiedName("java.util.List");
		parameterizedType.setType(genericType);
		assertEquals("java.util.List", parameterizedType.getCanonicalName());
	}
	
	public void testCanonicalName_04() {
		JvmGenericType genericType = TypesFactory.eINSTANCE.createJvmGenericType();
		genericType.setFullyQualifiedName("java.util.List");
		parameterizedType.setType(genericType);
		JvmReferenceTypeArgument argument = TypesFactory.eINSTANCE.createJvmReferenceTypeArgument();
		JvmParameterizedTypeReference argumentReference = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
		JvmGenericType argumentType = TypesFactory.eINSTANCE.createJvmGenericType();
		argumentType.setFullyQualifiedName("java.lang.String");
		argumentReference.setType(argumentType);
		argument.setTypeReference(argumentReference);
		parameterizedType.getArguments().add(argument);
		assertEquals("java.util.List<java.lang.String>", parameterizedType.getCanonicalName());
	}
	
	public void testCanonicalName_05() {
		JvmPrimitiveType primitiveType = TypesFactory.eINSTANCE.createJvmPrimitiveType();
		primitiveType.setName("int");
		JvmArrayType arrayType = TypesFactory.eINSTANCE.createJvmArrayType();
		JvmParameterizedTypeReference componentTypeRef = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
		componentTypeRef.setType(primitiveType);
		arrayType.setComponentType(componentTypeRef);
		primitiveType.setArrayType(arrayType);
		parameterizedType.setType(arrayType);
		assertEquals("int[]", parameterizedType.getCanonicalName());
	}
}
