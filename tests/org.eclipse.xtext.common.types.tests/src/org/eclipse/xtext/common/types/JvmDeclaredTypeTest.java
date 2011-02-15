/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
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
public abstract class JvmDeclaredTypeTest extends TestCase {

	protected abstract JvmDeclaredType getObjectUnderTest();

	public void testGetIdentifier_01() {
		assertNull(getObjectUnderTest().getIdentifier());
		assertNull(getObjectUnderTest().getSimpleName());
		assertNull(getObjectUnderTest().getQualifiedName());
		assertNull(getObjectUnderTest().getPackageName());
	}
	
	public void testGetIdentifier_02() {
		getObjectUnderTest().internalSetIdentifier("java.lang.DoesNotExist");
		assertEquals("java.lang.DoesNotExist", getObjectUnderTest().getIdentifier());
		assertNull(getObjectUnderTest().getSimpleName());
		assertNull(getObjectUnderTest().getQualifiedName());
		assertNull(getObjectUnderTest().getPackageName());
	}
	
	public void testGetIdentifier_03() {
		JvmGenericType outerType = TypesFactory.eINSTANCE.createJvmGenericType();
		outerType.getMembers().add(getObjectUnderTest());
		getObjectUnderTest().internalSetIdentifier("java.lang.DoesNotExist$Something");
		assertEquals("java.lang.DoesNotExist$Something", getObjectUnderTest().getIdentifier());
	}
	
	public void testGetIdentifier_04() {
		getObjectUnderTest().setPackageName("java.lang");
		getObjectUnderTest().setSimpleName("DoesNotExist");
		assertEquals("java.lang.DoesNotExist", getObjectUnderTest().getIdentifier());
	}
	
	public void testGetIdentifier_05() {
		JvmGenericType outerType = TypesFactory.eINSTANCE.createJvmGenericType();
		outerType.internalSetIdentifier("java.lang.DoesNotExist");
		outerType.getMembers().add(getObjectUnderTest());
		getObjectUnderTest().setSimpleName("Something");
		assertEquals("java.lang.DoesNotExist$Something", getObjectUnderTest().getIdentifier());
	}
	
	public void testGetQualifiedName_01() {
		getObjectUnderTest().setSimpleName("SimpleName");
		assertEquals("SimpleName", getObjectUnderTest().getQualifiedName());
	}
	
	public void testGetQualifiedName_02() {
		getObjectUnderTest().setPackageName("java.lang");
		assertNull(getObjectUnderTest().getQualifiedName());
	}
	
	public void testGetQualifiedName_03() {
		JvmGenericType outerType = TypesFactory.eINSTANCE.createJvmGenericType();
		outerType.setSimpleName("DoesNotExist");
		outerType.getMembers().add(getObjectUnderTest());
		getObjectUnderTest().setSimpleName("SimpleName");
		assertEquals("DoesNotExist$SimpleName", getObjectUnderTest().getQualifiedName());
	}
	
	public void testGetQualifiedName_04() {
		JvmGenericType outerType = TypesFactory.eINSTANCE.createJvmGenericType();
		outerType.setSimpleName("DoesNotExist");
		outerType.setPackageName("java.lang");
		outerType.getMembers().add(getObjectUnderTest());
		getObjectUnderTest().setSimpleName("SimpleName");
		getObjectUnderTest().setPackageName("ignored");
		assertEquals("java.lang.DoesNotExist$SimpleName", getObjectUnderTest().getQualifiedName());
	}
	
	public void testGetQualifiedName_05() {
		JvmGenericType outerOuterType = TypesFactory.eINSTANCE.createJvmGenericType();
		outerOuterType.setSimpleName("DoesNotExist");
		outerOuterType.setPackageName("java.lang");
		JvmGenericType outerType = TypesFactory.eINSTANCE.createJvmGenericType();
		outerOuterType.getMembers().add(outerType);
		outerType.setSimpleName("Outer");
		outerType.getMembers().add(getObjectUnderTest());
		getObjectUnderTest().setSimpleName("SimpleName");
		assertEquals("java.lang.DoesNotExist$Outer$SimpleName", getObjectUnderTest().getQualifiedName());
	}
	
	public void testGetQualifiedNameWithDelimiter_01() {
		getObjectUnderTest().setSimpleName("SimpleName");
		assertEquals("SimpleName", getObjectUnderTest().getQualifiedName('.'));
	}
	
	public void testGetQualifiedNameWithDelimiter_02() {
		getObjectUnderTest().setPackageName("java.lang");
		assertNull(getObjectUnderTest().getQualifiedName('.'));
	}
	
	public void testGetQualifiedNameWithDelimiter_03() {
		JvmGenericType outerType = TypesFactory.eINSTANCE.createJvmGenericType();
		outerType.setSimpleName("DoesNotExist");
		outerType.getMembers().add(getObjectUnderTest());
		getObjectUnderTest().setSimpleName("SimpleName");
		assertEquals("DoesNotExist.SimpleName", getObjectUnderTest().getQualifiedName('.'));
	}
	
	public void testGetQualifiedNameWithDelimiter_04() {
		JvmGenericType outerType = TypesFactory.eINSTANCE.createJvmGenericType();
		outerType.setSimpleName("DoesNotExist");
		outerType.setPackageName("java.lang");
		outerType.getMembers().add(getObjectUnderTest());
		getObjectUnderTest().setSimpleName("SimpleName");
		getObjectUnderTest().setPackageName("ignored");
		assertEquals("java.lang.DoesNotExist.SimpleName", getObjectUnderTest().getQualifiedName('.'));
	}
	
	public void testGetQualifiedNameWithDelimiter_05() {
		JvmGenericType outerOuterType = TypesFactory.eINSTANCE.createJvmGenericType();
		outerOuterType.setSimpleName("DoesNotExist");
		outerOuterType.setPackageName("java.lang");
		JvmGenericType outerType = TypesFactory.eINSTANCE.createJvmGenericType();
		outerOuterType.getMembers().add(outerType);
		outerType.setSimpleName("Outer");
		outerType.getMembers().add(getObjectUnderTest());
		getObjectUnderTest().setSimpleName("SimpleName");
		assertEquals("java.lang.DoesNotExist.Outer.SimpleName", getObjectUnderTest().getQualifiedName('.'));
	}
	
}
