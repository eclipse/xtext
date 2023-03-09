/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmInnerTypeReferenceTest extends JvmParameterizedTypeReferenceTest {

	private JvmInnerTypeReference innerType;

	@Override
	@Before
	public void setUp() throws Exception {
		parameterizedType = TypesFactory.eINSTANCE.createJvmInnerTypeReference();
		innerType = TypesFactory.eINSTANCE.createJvmInnerTypeReference();
	}
	
	@Test public void testGetIdentifier_06() {
		innerType.setOuter(parameterizedType);
		assertNull(innerType.getIdentifier());
	}
	
	@Test public void testGetIdentifier_07() {
		JvmPrimitiveType primitiveType = TypesFactory.eINSTANCE.createJvmPrimitiveType();
		primitiveType.setSimpleName("int");
		innerType.setType(primitiveType);
		innerType.setOuter(parameterizedType);
		assertEquals("int", innerType.getIdentifier());
	}
	
	@Test public void testGetIdentifier_08() {
		JvmGenericType map = TypesFactory.eINSTANCE.createJvmGenericType();
		map.internalSetIdentifier("java.util.Map");
		parameterizedType.setType(map);
		JvmGenericType entry = TypesFactory.eINSTANCE.createJvmGenericType();
		entry.setSimpleName("Entry");
		map.getMembers().add(entry);
		parameterizedType.setType(map);
		innerType.setOuter(parameterizedType);
		innerType.setType(entry);
		assertEquals("java.util.Map$Entry", innerType.getIdentifier());
	}
	
	@Test public void testGetIdentifier_09() {
		JvmGenericType map = TypesFactory.eINSTANCE.createJvmGenericType();
		map.internalSetIdentifier("java.util.Map");
		parameterizedType.setType(map);
		JvmGenericType entry = TypesFactory.eINSTANCE.createJvmGenericType();
		entry.setSimpleName("Entry");
		map.getMembers().add(entry);
		parameterizedType.setType(map);
		innerType.setOuter(parameterizedType);
		innerType.setType(entry);
		JvmParameterizedTypeReference argumentReference = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
		JvmGenericType argumentType = TypesFactory.eINSTANCE.createJvmGenericType();
		argumentType.internalSetIdentifier("java.lang.String");
		argumentReference.setType(argumentType);
		parameterizedType.getArguments().add(argumentReference);
		assertEquals("java.util.Map<java.lang.String>$Entry", innerType.getIdentifier());
	}
}
