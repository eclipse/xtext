/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import java.util.Iterator;

import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class JvmDeclaredTypeTest extends JvmComponentTypeTest {

	@Override
	protected abstract JvmDeclaredType getObjectUnderTest();

	@Test public void testGetIdentifier_01() {
		assertNull(getObjectUnderTest().getIdentifier());
		assertNull(getObjectUnderTest().getSimpleName());
		assertNull(getObjectUnderTest().getQualifiedName());
		assertNull(getObjectUnderTest().getPackageName());
	}
	
	@Test public void testGetIdentifier_02() {
		getObjectUnderTest().internalSetIdentifier("java.lang.DoesNotExist");
		assertEquals("java.lang.DoesNotExist", getObjectUnderTest().getIdentifier());
		assertNull(getObjectUnderTest().getSimpleName());
		assertNull(getObjectUnderTest().getQualifiedName());
		assertNull(getObjectUnderTest().getPackageName());
	}
	
	@Test public void testGetIdentifier_03() {
		JvmGenericType outerType = TypesFactory.eINSTANCE.createJvmGenericType();
		outerType.getMembers().add(getObjectUnderTest());
		getObjectUnderTest().internalSetIdentifier("java.lang.DoesNotExist$Something");
		assertEquals("java.lang.DoesNotExist$Something", getObjectUnderTest().getIdentifier());
	}
	
	@Test public void testGetIdentifier_04() {
		getObjectUnderTest().setPackageName("java.lang");
		getObjectUnderTest().setSimpleName("DoesNotExist");
		assertEquals("java.lang.DoesNotExist", getObjectUnderTest().getIdentifier());
	}
	
	@Test public void testGetIdentifier_05() {
		JvmGenericType outerType = TypesFactory.eINSTANCE.createJvmGenericType();
		outerType.internalSetIdentifier("java.lang.DoesNotExist");
		outerType.getMembers().add(getObjectUnderTest());
		getObjectUnderTest().setSimpleName("Something");
		assertEquals("java.lang.DoesNotExist$Something", getObjectUnderTest().getIdentifier());
	}
	
	@Test public void testGetQualifiedName_01() {
		getObjectUnderTest().setSimpleName("SimpleName");
		assertEquals("SimpleName", getObjectUnderTest().getQualifiedName());
	}
	
	@Test public void testGetQualifiedName_02() {
		getObjectUnderTest().setPackageName("java.lang");
		assertNull(getObjectUnderTest().getQualifiedName());
	}
	
	@Test public void testGetQualifiedName_03() {
		JvmGenericType outerType = TypesFactory.eINSTANCE.createJvmGenericType();
		outerType.setSimpleName("DoesNotExist");
		outerType.getMembers().add(getObjectUnderTest());
		getObjectUnderTest().setSimpleName("SimpleName");
		assertEquals("DoesNotExist$SimpleName", getObjectUnderTest().getQualifiedName());
	}
	
	@Test public void testGetQualifiedName_04() {
		JvmGenericType outerType = TypesFactory.eINSTANCE.createJvmGenericType();
		outerType.setSimpleName("DoesNotExist");
		outerType.setPackageName("java.lang");
		outerType.getMembers().add(getObjectUnderTest());
		getObjectUnderTest().setSimpleName("SimpleName");
		getObjectUnderTest().setPackageName("ignored");
		assertEquals("java.lang.DoesNotExist$SimpleName", getObjectUnderTest().getQualifiedName());
	}
	
	@Test public void testGetQualifiedName_05() {
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
	
	@Test public void testGetQualifiedNameWithDelimiter_01() {
		getObjectUnderTest().setSimpleName("SimpleName");
		assertEquals("SimpleName", getObjectUnderTest().getQualifiedName('.'));
	}
	
	@Test public void testGetQualifiedNameWithDelimiter_02() {
		getObjectUnderTest().setPackageName("java.lang");
		assertNull(getObjectUnderTest().getQualifiedName('.'));
	}
	
	@Test public void testGetQualifiedNameWithDelimiter_03() {
		JvmGenericType outerType = TypesFactory.eINSTANCE.createJvmGenericType();
		outerType.setSimpleName("DoesNotExist");
		outerType.getMembers().add(getObjectUnderTest());
		getObjectUnderTest().setSimpleName("SimpleName");
		assertEquals("DoesNotExist.SimpleName", getObjectUnderTest().getQualifiedName('.'));
	}
	
	@Test public void testGetQualifiedNameWithDelimiter_04() {
		JvmGenericType outerType = TypesFactory.eINSTANCE.createJvmGenericType();
		outerType.setSimpleName("DoesNotExist");
		outerType.setPackageName("java.lang");
		outerType.getMembers().add(getObjectUnderTest());
		getObjectUnderTest().setSimpleName("SimpleName");
		getObjectUnderTest().setPackageName("ignored");
		assertEquals("java.lang.DoesNotExist.SimpleName", getObjectUnderTest().getQualifiedName('.'));
	}
	
	@Test public void testGetQualifiedNameWithDelimiter_05() {
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
	
	@Test public void testFindFeaturesByName_01() {
		JvmDeclaredType type = getObjectUnderTest();
		JvmOperation operation = TypesFactory.eINSTANCE.createJvmOperation();
		operation.setSimpleName("foo");
		type.getMembers().add(operation);
		Iterable<JvmFeature> iterable = type.findAllFeaturesByName("foo");
		Iterator<JvmFeature> iterator = iterable.iterator();
		assertTrue(iterator.hasNext());
		assertSame(operation, iterator.next());
		assertFalse(iterator.hasNext());
	}
	
	@Test public void testFindFeaturesByName_02() {
		JvmDeclaredType type = getObjectUnderTest();
		JvmOperation operation = TypesFactory.eINSTANCE.createJvmOperation();
		operation.setSimpleName("foo");
		type.getMembers().add(operation);
		type.findAllFeaturesByName("foo");
		operation.setSimpleName("bar");
		Iterable<JvmFeature> iterable = type.findAllFeaturesByName("bar");
		Iterator<JvmFeature> iterator = iterable.iterator();
		assertTrue(iterator.hasNext());
		assertSame(operation, iterator.next());
		assertFalse(iterator.hasNext());
	}
	
	@Test public void testFindFeaturesByName_03() {
		JvmDeclaredType type = getObjectUnderTest();
		JvmGenericType superType = TypesFactory.eINSTANCE.createJvmGenericType();
		ResourceImpl resource = new ResourceImpl();
		resource.getContents().add(type);
		resource.getContents().add(superType);
		JvmOperation operation = TypesFactory.eINSTANCE.createJvmOperation();
		operation.setSimpleName("foo");
		superType.getMembers().add(operation);
		JvmParameterizedTypeReference reference = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
		reference.setType(superType);
		type.getSuperTypes().add(reference);
		Iterable<JvmFeature> iterable = type.findAllFeaturesByName("foo");
		Iterator<JvmFeature> iterator = iterable.iterator();
		assertTrue(iterator.hasNext());
		assertSame(operation, iterator.next());
		assertFalse(iterator.hasNext());
	}
	
	@Test public void testFindFeaturesByName_04() {
		JvmDeclaredType type = getObjectUnderTest();
		JvmGenericType superType = TypesFactory.eINSTANCE.createJvmGenericType();
		ResourceImpl resource = new ResourceImpl();
		resource.getContents().add(type);
		resource.getContents().add(superType);
		JvmOperation operation = TypesFactory.eINSTANCE.createJvmOperation();
		operation.setSimpleName("foo");
		superType.getMembers().add(operation);
		JvmParameterizedTypeReference reference = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
		reference.setType(superType);
		type.getSuperTypes().add(reference);
		type.findAllFeaturesByName("foo");
		operation.setSimpleName("bar");
		Iterable<JvmFeature> iterable = type.findAllFeaturesByName("bar");
		Iterator<JvmFeature> iterator = iterable.iterator();
		assertTrue(iterator.hasNext());
		assertSame(operation, iterator.next());
		assertFalse(iterator.hasNext());
	}
	
	@Test public void testGetAllFeatures_01() {
		JvmDeclaredType type = getObjectUnderTest();
		JvmOperation operation = TypesFactory.eINSTANCE.createJvmOperation();
		type.getMembers().add(operation);
		Iterable<JvmFeature> iterable = type.getAllFeatures();
		Iterator<JvmFeature> iterator = iterable.iterator();
		assertTrue(iterator.hasNext());
		assertSame(operation, iterator.next());
		assertFalse(iterator.hasNext());
	}
	
	@Test public void testGetAllFeatures_02() {
		JvmDeclaredType type = getObjectUnderTest();
		type.getAllFeatures();
		JvmOperation operation = TypesFactory.eINSTANCE.createJvmOperation();
		type.getMembers().add(operation);
		Iterable<JvmFeature> iterable = type.getAllFeatures();
		Iterator<JvmFeature> iterator = iterable.iterator();
		assertTrue(iterator.hasNext());
		assertSame(operation, iterator.next());
		assertFalse(iterator.hasNext());
	}
	
	@Test public void testGetAllFeatures_03() {
		JvmDeclaredType type = getObjectUnderTest();
		JvmGenericType superType = TypesFactory.eINSTANCE.createJvmGenericType();
		ResourceImpl resource = new ResourceImpl();
		resource.getContents().add(type);
		resource.getContents().add(superType);
		JvmOperation operation = TypesFactory.eINSTANCE.createJvmOperation();
		superType.getMembers().add(operation);
		JvmParameterizedTypeReference reference = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
		reference.setType(superType);
		type.getSuperTypes().add(reference);
		Iterable<JvmFeature> iterable = type.getAllFeatures();
		Iterator<JvmFeature> iterator = iterable.iterator();
		assertTrue(iterator.hasNext());
		assertSame(operation, iterator.next());
		assertFalse(iterator.hasNext());
	}
	
	@Test public void testGetAllFeatures_04() {
		JvmDeclaredType type = getObjectUnderTest();
		JvmGenericType superType = TypesFactory.eINSTANCE.createJvmGenericType();
		ResourceImpl resource = new ResourceImpl();
		resource.getContents().add(type);
		resource.getContents().add(superType);
		type.getAllFeatures();
		JvmOperation operation = TypesFactory.eINSTANCE.createJvmOperation();
		superType.getMembers().add(operation);
		JvmParameterizedTypeReference reference = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
		reference.setType(superType);
		type.getSuperTypes().add(reference);
		Iterable<JvmFeature> iterable = type.getAllFeatures();
		Iterator<JvmFeature> iterator = iterable.iterator();
		assertTrue(iterator.hasNext());
		assertSame(operation, iterator.next());
		assertFalse(iterator.hasNext());
	}
	
}
