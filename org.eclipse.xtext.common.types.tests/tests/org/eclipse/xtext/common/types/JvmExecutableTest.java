/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class JvmExecutableTest extends JvmFeatureTest {

	@Override
	protected abstract JvmExecutable getObjectUnderTest();
	
	protected abstract String getSimpleName();
	
	@Test public void testGetIdentifier_02() {
		getObjectUnderTest().internalSetIdentifier("java.lang.DoesNotExist." + getSimpleName() + "()");
		assertEquals("java.lang.DoesNotExist." + getSimpleName() + "()", getObjectUnderTest().getIdentifier());
		assertNull(getObjectUnderTest().getSimpleName());
		assertNull(getObjectUnderTest().getQualifiedName());
	}
	
	@Test public void testGetIdentifier_03() {
		JvmGenericType outerType = TypesFactory.eINSTANCE.createJvmGenericType();
		outerType.getMembers().add(getObjectUnderTest());
		getObjectUnderTest().internalSetIdentifier("java.lang.DoesNotExist." + getSimpleName() + "()");
		assertEquals("java.lang.DoesNotExist." + getSimpleName() + "()", getObjectUnderTest().getIdentifier());
	}
	
	@Test public void testGetIdentifier_04() {
		getObjectUnderTest().setSimpleName(getSimpleName());
		assertEquals(getSimpleName() + "()", getObjectUnderTest().getIdentifier());
	}
	
	@Test public void testGetIdentifier_05() {
		JvmGenericType type = TypesFactory.eINSTANCE.createJvmGenericType();
		type.internalSetIdentifier("java.lang.DoesNotExist");
		type.getMembers().add(getObjectUnderTest());
		getObjectUnderTest().setSimpleName(getSimpleName());
		assertEquals("java.lang.DoesNotExist." + getSimpleName() + "()", getObjectUnderTest().getIdentifier());
	}
	
	@Test public void testGetIdentifier_06() {
		JvmGenericType type = TypesFactory.eINSTANCE.createJvmGenericType();
		type.setPackageName("java.lang");
		type.setSimpleName("DoesNotExist");
		type.getMembers().add(getObjectUnderTest());
		getObjectUnderTest().setSimpleName(getSimpleName());
		JvmFormalParameter formalParameter = TypesFactory.eINSTANCE.createJvmFormalParameter();
		JvmParameterizedTypeReference typeReference = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
		typeReference.setType(type);
		formalParameter.setParameterType(typeReference);
		formalParameter.setName("paramName");
		getObjectUnderTest().getParameters().add(formalParameter);
		assertEquals("java.lang.DoesNotExist." + getSimpleName() + "(java.lang.DoesNotExist)", getObjectUnderTest().getIdentifier());
	}
	
}
