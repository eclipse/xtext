/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class JvmFeatureTest extends Assert {

	protected abstract JvmFeature getObjectUnderTest();

	@Test public void testGetIdentifier_01() {
		assertNull(getObjectUnderTest().getIdentifier());
		assertNull(getObjectUnderTest().getSimpleName());
		assertNull(getObjectUnderTest().getQualifiedName());
	}
	
	@Test public void testGetQualifiedName_01() {
		getObjectUnderTest().setSimpleName("featureName");
		assertEquals("featureName", getObjectUnderTest().getQualifiedName());
	}
	
	@Test public void testGetQualifiedName_02() {
		JvmGenericType outerType = TypesFactory.eINSTANCE.createJvmGenericType();
		outerType.setSimpleName("DoesNotExist");
		outerType.getMembers().add(getObjectUnderTest());
		getObjectUnderTest().setSimpleName("featureName");
		assertEquals("DoesNotExist.featureName", getObjectUnderTest().getQualifiedName());
	}
	
	@Test public void testGetQualifiedName_03() {
		JvmGenericType outerType = TypesFactory.eINSTANCE.createJvmGenericType();
		outerType.setSimpleName("DoesNotExist");
		outerType.setPackageName("java.lang");
		outerType.getMembers().add(getObjectUnderTest());
		getObjectUnderTest().setSimpleName("featureName");
		assertEquals("java.lang.DoesNotExist.featureName", getObjectUnderTest().getQualifiedName());
	}
	
	@Test public void testGetQualifiedName_04() {
		JvmGenericType outerOuterType = TypesFactory.eINSTANCE.createJvmGenericType();
		outerOuterType.setSimpleName("DoesNotExist");
		outerOuterType.setPackageName("java.lang");
		JvmGenericType outerType = TypesFactory.eINSTANCE.createJvmGenericType();
		outerOuterType.getMembers().add(outerType);
		outerType.setSimpleName("Outer");
		outerType.getMembers().add(getObjectUnderTest());
		getObjectUnderTest().setSimpleName("featureName");
		assertEquals("java.lang.DoesNotExist$Outer.featureName", getObjectUnderTest().getQualifiedName());
	}
	
	@Test public void testGetQualifiedNameWithDelimiter_01() {
		getObjectUnderTest().setSimpleName("featureName");
		assertEquals("featureName", getObjectUnderTest().getQualifiedName('.'));
	}
	
	@Test public void testGetQualifiedNameWithDelimiter_02() {
		JvmGenericType type = TypesFactory.eINSTANCE.createJvmGenericType();
		type.setSimpleName("DoesNotExist");
		type.getMembers().add(getObjectUnderTest());
		getObjectUnderTest().setSimpleName("featureName");
		assertEquals("DoesNotExist.featureName", getObjectUnderTest().getQualifiedName('.'));
	}
	
	@Test public void testGetQualifiedNameWithDelimiter_03() {
		JvmGenericType type = TypesFactory.eINSTANCE.createJvmGenericType();
		type.setSimpleName("DoesNotExist");
		type.setPackageName("java.lang");
		type.getMembers().add(getObjectUnderTest());
		getObjectUnderTest().setSimpleName("featureName");
		assertEquals("java.lang.DoesNotExist.featureName", getObjectUnderTest().getQualifiedName('.'));
	}
	
	@Test public void testGetQualifiedNameWithDelimiter_04() {
		JvmGenericType outerType = TypesFactory.eINSTANCE.createJvmGenericType();
		outerType.setSimpleName("DoesNotExist");
		outerType.setPackageName("java.lang");
		JvmGenericType type = TypesFactory.eINSTANCE.createJvmGenericType();
		outerType.getMembers().add(type);
		type.setSimpleName("Inner");
		type.getMembers().add(getObjectUnderTest());
		getObjectUnderTest().setSimpleName("featureName");
		assertEquals("java.lang.DoesNotExist.Inner.featureName", getObjectUnderTest().getQualifiedName('.'));
	}

	
}
