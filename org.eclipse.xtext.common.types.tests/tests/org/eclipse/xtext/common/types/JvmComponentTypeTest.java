/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class JvmComponentTypeTest extends Assert {

	protected abstract JvmComponentType getObjectUnderTest();
	
	@Test public void testGetArrayType_01() {
		JvmComponentType objectUnderTest = getObjectUnderTest();
		assertFalse(objectUnderTest.eIsSet(TypesPackage.Literals.JVM_COMPONENT_TYPE__ARRAY_TYPE));
		assertNull(objectUnderTest.eGet(TypesPackage.Literals.JVM_COMPONENT_TYPE__ARRAY_TYPE, false));
		assertNull(objectUnderTest.eGet(TypesPackage.Literals.JVM_COMPONENT_TYPE__ARRAY_TYPE, true));
		JvmArrayType arrayType = objectUnderTest.getArrayType();
		assertNotNull(arrayType);
		assertTrue(objectUnderTest.eIsSet(TypesPackage.Literals.JVM_COMPONENT_TYPE__ARRAY_TYPE));
		assertSame(arrayType, objectUnderTest.eGet(TypesPackage.Literals.JVM_COMPONENT_TYPE__ARRAY_TYPE, false));
		assertSame(arrayType, objectUnderTest.eGet(TypesPackage.Literals.JVM_COMPONENT_TYPE__ARRAY_TYPE, true));
	}
	
	@Test public void testGetArrayType_02() {
		List<EObject> allObjects = Lists.newArrayList(EcoreUtil2.eAll(getObjectUnderTest()));
		assertEquals(Collections.singletonList(getObjectUnderTest()), allObjects);
	}
	
	@Test public void testGetArrayType_03() {
		JvmArrayType arrayType = getObjectUnderTest().getArrayType();
		List<EObject> allObjects = Lists.newArrayList(EcoreUtil2.eAll(getObjectUnderTest()));
		assertEquals(Lists.newArrayList(getObjectUnderTest(), arrayType), allObjects);
	}
}
