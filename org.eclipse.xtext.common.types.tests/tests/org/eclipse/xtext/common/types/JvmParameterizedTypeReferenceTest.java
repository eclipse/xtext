/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
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
public class JvmParameterizedTypeReferenceTest extends Assert {

	protected JvmParameterizedTypeReference parameterizedType;

	@Before
	public void setUp() throws Exception {
		parameterizedType = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
	}
	
	@Test public void testGetIdentifier_01() {
		assertNull(parameterizedType.getIdentifier());
	}
	
	@Test public void testGetIdentifier_02() {
		JvmPrimitiveType primitiveType = TypesFactory.eINSTANCE.createJvmPrimitiveType();
		primitiveType.setSimpleName("int");
		parameterizedType.setType(primitiveType);
		assertEquals("int", parameterizedType.getIdentifier());
	}
	
	@Test public void testGetIdentifier_03() {
		JvmGenericType genericType = TypesFactory.eINSTANCE.createJvmGenericType();
		genericType.internalSetIdentifier("java.util.List");
		parameterizedType.setType(genericType);
		assertEquals("java.util.List", parameterizedType.getIdentifier());
	}
	
	@Test public void testGetIdentifier_04() {
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
	
	@Test public void testGetIdentifier_05() {
		JvmPrimitiveType primitiveType = TypesFactory.eINSTANCE.createJvmPrimitiveType();
		primitiveType.setSimpleName("int");
		JvmArrayType arrayType = TypesFactory.eINSTANCE.createJvmArrayType();
		arrayType.setComponentType(primitiveType);
		primitiveType.setArrayType(arrayType);
		parameterizedType.setType(arrayType);
		assertEquals("int[]", parameterizedType.getIdentifier());
	}
}
