/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import java.util.Map;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class GenericTypeTest extends TestCase {

	private GenericType genericType;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		genericType = TypesFactory.eINSTANCE.createGenericType();
	}
	
	public void testCanonicalName_01() {
		assertNull(genericType.getCanonicalName());
	}
	
	public void testCanonicalName_02() {
		genericType.setFullyQualifiedName("java.util.List");
		assertEquals("java.util.List", genericType.getCanonicalName());
	}
	
	public void testCanonicalName_03() {
		GenericType outerType = TypesFactory.eINSTANCE.createGenericType();
		outerType.getMembers().add(genericType);
		genericType.setFullyQualifiedName("java.util.List.ListElement");
		assertEquals("java.util.List.ListElement", genericType.getCanonicalName());
	}
	
	public void testCanonicalName_04() {
		TypeParameter typeParameter = TypesFactory.eINSTANCE.createTypeParameter();
		typeParameter.setName("T");
		genericType.setFullyQualifiedName("java.util.List");
		genericType.getTypeParameters().add(typeParameter);
		assertEquals("java.util.List", genericType.getCanonicalName());
	}
	
	public void testCanonicalName_05() {
		TypeParameter typeParameter1 = TypesFactory.eINSTANCE.createTypeParameter();
		typeParameter1.setName("T1");
		TypeParameter typeParameter2 = TypesFactory.eINSTANCE.createTypeParameter();
		typeParameter2.setName("T2");
		genericType.setFullyQualifiedName("java.util.List");
		genericType.getTypeParameters().add(typeParameter1);
		genericType.getTypeParameters().add(typeParameter2);
		assertEquals("java.util.List", genericType.getCanonicalName());
	}
	
	public void testGetSimpleName_01() {
		genericType.setFullyQualifiedName(Map.Entry.class.getName());
		assertEquals("Entry", genericType.getSimpleName());
	}
	
	public void testGetSimpleName_02() {
		assertNull(genericType.getSimpleName());
	}
	
	public void testGetSimpleName_03() {
		genericType.setFullyQualifiedName(Map.class.getName());
		assertEquals("Map", genericType.getSimpleName());
	}
	
	public void testGetSimpleName_04() {
		genericType.setFullyQualifiedName("Something$Entry");
		assertEquals("Entry", genericType.getSimpleName());
	}
	
	public void testGetSimpleName_05() {
		genericType.setFullyQualifiedName("Something");
		assertEquals("Something", genericType.getSimpleName());
	}
	
	public void testGetPackageName_01() {
		genericType.setFullyQualifiedName(Map.Entry.class.getName());
		assertEquals("java.util", genericType.getPackageName());
	}
	
	public void testGetPackageName_02() {
		assertNull(genericType.getPackageName());
	}
	
	public void testGetPackageName_03() {
		genericType.setFullyQualifiedName(Map.class.getName());
		assertEquals("java.util", genericType.getPackageName());
	}
	
	public void testGetPackageName_04() {
		genericType.setFullyQualifiedName("Something$Entry");
		assertEquals("", genericType.getPackageName());
	}
	
	public void testGetPackageName_05() {
		genericType.setFullyQualifiedName("Something");
		assertEquals("", genericType.getPackageName());
	}
	
	public void testIsInstantiateable_01() {
		assertTrue(genericType.isInstantiateable());
	}

	public void testIsInstantiateable_02() {
		genericType.setAbstract(true);
		assertFalse(genericType.isInstantiateable());
	}
	
	public void testIsInstantiateable_03() {
		genericType.setInterface(true);
		assertFalse(genericType.isInstantiateable());
	}
	
	public void testGetExtendedInterfaces_01() {
		Iterable<Type> interfaces = genericType.getExtendedInterfaces();
		assertNotNull(interfaces);
		assertTrue(Iterables.isEmpty(interfaces));
	}
	
	public void testGetExtendedInterfaces_02() {
		GenericType interfaceType = TypesFactory.eINSTANCE.createGenericType();
		interfaceType.setInterface(true);
		genericType.getSuperTypes().add(interfaceType);
		Iterable<Type> interfaces = genericType.getExtendedInterfaces();
		assertSame(interfaceType, Iterables.getOnlyElement(interfaces));
	}
	
	public void testGetExtendedInterfaces_03() {
		GenericType firstInterfaceType = TypesFactory.eINSTANCE.createGenericType();
		GenericType secondInterfaceType = TypesFactory.eINSTANCE.createGenericType();
		GenericType classType = TypesFactory.eINSTANCE.createGenericType();
		firstInterfaceType.setInterface(true);
		secondInterfaceType.setInterface(true);
		classType.setInterface(false);
		genericType.getSuperTypes().add(firstInterfaceType);
		genericType.getSuperTypes().add(secondInterfaceType);
		genericType.getSuperTypes().add(classType);
		Iterable<Type> interfaces = genericType.getExtendedInterfaces();
		assertEquals(2, Iterables.size(interfaces));
		assertTrue(Iterables.elementsEqual(interfaces, Lists.newArrayList(firstInterfaceType, secondInterfaceType)));
	}
	
	public void testGetExtendedInterfaces_04() {
		Iterable<Type> interfaces = genericType.getExtendedInterfaces();
		GenericType interfaceType = TypesFactory.eINSTANCE.createGenericType();
		genericType.getSuperTypes().add(interfaceType);
		assertSame(interfaces, genericType.getExtendedInterfaces());
		assertTrue(Iterables.isEmpty(interfaces));
		interfaceType.setInterface(true);
		assertSame(interfaces, genericType.getExtendedInterfaces());
		assertSame(interfaceType, Iterables.getOnlyElement(interfaces));
	}
	
	public void testGetExtendedInterfaces_05() {
		GenericType interfaceType = TypesFactory.eINSTANCE.createGenericType();
		interfaceType.setInterface(true);
		ParameterizedType parameterizedType = TypesFactory.eINSTANCE.createParameterizedType();
		parameterizedType.setRawType(interfaceType);
		genericType.getSuperTypes().add(parameterizedType);
		Iterable<Type> interfaces = genericType.getExtendedInterfaces();
		assertSame(parameterizedType, Iterables.getOnlyElement(interfaces));
	}
	
	public void testGetExtendedClasses_01() {
		Iterable<Type> classes = genericType.getExtendedClasses();
		assertNotNull(classes);
		assertTrue(Iterables.isEmpty(classes));
	}
	
	public void testGetExtendedClasses_02() {
		GenericType classType = TypesFactory.eINSTANCE.createGenericType();
		classType.setInterface(false);
		genericType.getSuperTypes().add(classType);
		Iterable<Type> classes = genericType.getExtendedClasses();
		assertSame(classType, Iterables.getOnlyElement(classes));
	}
	
	public void testGetExtendedClasses_03() {
		GenericType firstInterfaceType = TypesFactory.eINSTANCE.createGenericType();
		GenericType secondInterfaceType = TypesFactory.eINSTANCE.createGenericType();
		GenericType classType = TypesFactory.eINSTANCE.createGenericType();
		firstInterfaceType.setInterface(true);
		secondInterfaceType.setInterface(true);
		classType.setInterface(false);
		genericType.getSuperTypes().add(firstInterfaceType);
		genericType.getSuperTypes().add(secondInterfaceType);
		genericType.getSuperTypes().add(classType);
		Iterable<Type> classes = genericType.getExtendedClasses();
		assertSame(classType, Iterables.getOnlyElement(classes));
	}
	
	public void testGetExtendedClasses_04() {
		Iterable<Type> classes = genericType.getExtendedClasses();
		GenericType superType = TypesFactory.eINSTANCE.createGenericType();
		genericType.getSuperTypes().add(superType);
		assertSame(classes, genericType.getExtendedInterfaces());
		assertSame(superType, Iterables.getOnlyElement(classes));
		superType.setInterface(true);
		assertSame(classes, genericType.getExtendedInterfaces());
		assertTrue(Iterables.isEmpty(classes));
	}
	
	public void testGetExtendedClasses_05() {
		GenericType superType = TypesFactory.eINSTANCE.createGenericType();
		superType.setInterface(true);
		ParameterizedType parameterizedType = TypesFactory.eINSTANCE.createParameterizedType();
		parameterizedType.setRawType(superType);
		genericType.getSuperTypes().add(parameterizedType);
		Iterable<Type> classes = genericType.getExtendedClasses();
		assertTrue(Iterables.isEmpty(classes));
		superType.setInterface(false);
		assertSame(parameterizedType, Iterables.getOnlyElement(classes));
	}
}
