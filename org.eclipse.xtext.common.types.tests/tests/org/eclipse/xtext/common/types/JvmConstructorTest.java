/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
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
public class JvmConstructorTest extends JvmExecutableTest {

	private JvmConstructor constructor;

	@Before
	public void setUp() throws Exception {
		constructor = TypesFactory.eINSTANCE.createJvmConstructor();
	}
	
	@Override
	protected JvmConstructor getObjectUnderTest() {
		return constructor;
	}
	
	@Override
	protected String getSimpleName() {
		return "DoesNotExist";
	}
	
	@Override
	@Test public void testGetQualifiedName_02() {
		JvmGenericType outerType = TypesFactory.eINSTANCE.createJvmGenericType();
		outerType.setSimpleName("DoesNotExist");
		outerType.getMembers().add(getObjectUnderTest());
		getObjectUnderTest().setSimpleName("DoesNotExist");
		assertEquals("DoesNotExist", getObjectUnderTest().getQualifiedName());
	}
	
	@Override
	@Test public void testGetQualifiedName_03() {
		JvmGenericType outerType = TypesFactory.eINSTANCE.createJvmGenericType();
		outerType.setSimpleName("DoesNotExist");
		outerType.setPackageName("java.lang");
		outerType.getMembers().add(getObjectUnderTest());
		getObjectUnderTest().setSimpleName("DoesNotExist");
		assertEquals("java.lang.DoesNotExist", getObjectUnderTest().getQualifiedName());
	}
	
	@Override
	@Test public void testGetQualifiedName_04() {
		JvmGenericType outerOuterType = TypesFactory.eINSTANCE.createJvmGenericType();
		outerOuterType.setSimpleName("DoesNotExist");
		outerOuterType.setPackageName("java.lang");
		JvmGenericType outerType = TypesFactory.eINSTANCE.createJvmGenericType();
		outerOuterType.getMembers().add(outerType);
		outerType.setSimpleName("Outer");
		outerType.getMembers().add(getObjectUnderTest());
		getObjectUnderTest().setSimpleName("Outer");
		assertEquals("java.lang.DoesNotExist$Outer", getObjectUnderTest().getQualifiedName());
	}
	
	@Override
	@Test public void testGetQualifiedNameWithDelimiter_02() {
		JvmGenericType type = TypesFactory.eINSTANCE.createJvmGenericType();
		type.setSimpleName("DoesNotExist");
		type.getMembers().add(getObjectUnderTest());
		getObjectUnderTest().setSimpleName("DoesNotExist");
		assertEquals("DoesNotExist", getObjectUnderTest().getQualifiedName('.'));
	}
	
	@Override
	@Test public void testGetQualifiedNameWithDelimiter_03() {
		JvmGenericType type = TypesFactory.eINSTANCE.createJvmGenericType();
		type.setSimpleName("DoesNotExist");
		type.setPackageName("java.lang");
		type.getMembers().add(getObjectUnderTest());
		getObjectUnderTest().setSimpleName("DoesNotExist");
		assertEquals("java.lang.DoesNotExist", getObjectUnderTest().getQualifiedName('.'));
	}
	
	@Override
	@Test public void testGetQualifiedNameWithDelimiter_04() {
		JvmGenericType outerType = TypesFactory.eINSTANCE.createJvmGenericType();
		outerType.setSimpleName("DoesNotExist");
		outerType.setPackageName("java.lang");
		JvmGenericType type = TypesFactory.eINSTANCE.createJvmGenericType();
		outerType.getMembers().add(type);
		type.setSimpleName("Inner");
		type.getMembers().add(getObjectUnderTest());
		getObjectUnderTest().setSimpleName("Inner");
		assertEquals("java.lang.DoesNotExist.Inner", getObjectUnderTest().getQualifiedName('.'));
	}
}
