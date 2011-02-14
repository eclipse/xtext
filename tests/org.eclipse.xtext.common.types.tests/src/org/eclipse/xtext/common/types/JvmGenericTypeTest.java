/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import java.util.Map;

import org.eclipse.xtext.common.types.impl.JvmGenericTypeImpl;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmGenericTypeTest extends TestCase {

	private JvmGenericTypeImpl genericType;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		genericType = (JvmGenericTypeImpl) TypesFactory.eINSTANCE.createJvmGenericType();
	}
	
//	public void testCanonicalName_01() {
//		assertNull(genericType.getCanonicalName(), genericType.getCanonicalName());
//	}
//	
//	public void testCanonicalName_02() {
//		genericType.setCanonicalName("java.util.List");
//		assertEquals("java.util.List", genericType.getCanonicalName());
//	}
//	
//	public void testCanonicalName_03() {
//		JvmGenericType outerType = TypesFactory.eINSTANCE.createJvmGenericType();
//		outerType.getMembers().add(genericType);
//		genericType.setCanonicalName("java.util.List.ListElement");
//		assertEquals("java.util.List.ListElement", genericType.getCanonicalName());
//	}
//	
//	public void testCanonicalName_04() {
//		JvmTypeParameter typeParameter = TypesFactory.eINSTANCE.createJvmTypeParameter();
//		typeParameter.setName("T");
//		genericType.setCanonicalName("java.util.List");
//		genericType.getTypeParameters().add(typeParameter);
//		assertEquals("java.util.List", genericType.getCanonicalName());
//	}
//	
//	public void testCanonicalName_05() {
//		JvmTypeParameter typeParameter1 = TypesFactory.eINSTANCE.createJvmTypeParameter();
//		typeParameter1.setName("T1");
//		JvmTypeParameter typeParameter2 = TypesFactory.eINSTANCE.createJvmTypeParameter();
//		typeParameter2.setName("T2");
//		genericType.setCanonicalName("java.util.List");
//		genericType.getTypeParameters().add(typeParameter1);
//		genericType.getTypeParameters().add(typeParameter2);
//		assertEquals("java.util.List", genericType.getCanonicalName());
//	}
//	
//	public void testGetSimpleName_01() {
//		genericType.setCanonicalName(Map.Entry.class.getName());
//		assertEquals("Entry", genericType.getSimpleName());
//	}
//	
//	public void testGetSimpleName_02() {
//		assertNull(genericType.getSimpleName());
//	}
//	
//	public void testGetSimpleName_03() {
//		genericType.setCanonicalName(Map.class.getName());
//		assertEquals("Map", genericType.getSimpleName());
//	}
//	
//	public void testGetSimpleName_04() {
//		genericType.setCanonicalName("Something$Entry");
//		assertEquals("Entry", genericType.getSimpleName());
//	}
//	
//	public void testGetSimpleName_05() {
//		genericType.setCanonicalName("Something");
//		assertEquals("Something", genericType.getSimpleName());
//	}
//	
//	public void testGetPackageName_01() {
//		genericType.setCanonicalName(Map.Entry.class.getName());
//		assertEquals("java.util", genericType.getPackageName());
//	}
//	
//	public void testGetPackageName_02() {
//		assertNull(genericType.getPackageName());
//	}
//	
//	public void testGetPackageName_03() {
//		genericType.setCanonicalName(Map.class.getName());
//		assertEquals("java.util", genericType.getPackageName());
//	}
//	
//	public void testGetPackageName_04() {
//		genericType.setCanonicalName("Something$Entry");
//		assertEquals("", genericType.getPackageName());
//	}
//	
//	public void testGetPackageName_05() {
//		genericType.setCanonicalName("Something");
//		assertEquals("", genericType.getPackageName());
//	}
	
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
		Iterable<JvmTypeReference> interfaces = genericType.getExtendedInterfaces();
		assertNotNull(interfaces);
		assertTrue(Iterables.isEmpty(interfaces));
	}
	
	private JvmTypeReference createReferenceTo(JvmType type) {
		JvmParameterizedTypeReference result = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
		result.setType(type);
		return result;
	}
	
	public void testGetExtendedInterfaces_02() {
		JvmGenericType interfaceType = TypesFactory.eINSTANCE.createJvmGenericType();
		interfaceType.setInterface(true);
		genericType.getSuperTypes().add(createReferenceTo(interfaceType));
		Iterable<JvmTypeReference> interfaces = genericType.getExtendedInterfaces();
		assertSame(interfaceType, Iterables.getOnlyElement(interfaces).getType());
	}
	
	public void testGetExtendedInterfaces_03() {
		JvmGenericType firstInterfaceType = TypesFactory.eINSTANCE.createJvmGenericType();
		JvmGenericType secondInterfaceType = TypesFactory.eINSTANCE.createJvmGenericType();
		JvmGenericType classType = TypesFactory.eINSTANCE.createJvmGenericType();
		firstInterfaceType.setInterface(true);
		secondInterfaceType.setInterface(true);
		classType.setInterface(false);
		genericType.getSuperTypes().add(createReferenceTo(firstInterfaceType));
		genericType.getSuperTypes().add(createReferenceTo(secondInterfaceType));
		genericType.getSuperTypes().add(createReferenceTo(classType));
		Iterable<JvmTypeReference> interfaces = genericType.getExtendedInterfaces();
		assertEquals(2, Iterables.size(interfaces));
		assertTrue(Iterables.elementsEqual(Iterables.transform(interfaces, new Function<JvmTypeReference, JvmType>() {
			public JvmType apply(JvmTypeReference from) {
				return from.getType();
			}
		}), Lists.newArrayList(firstInterfaceType, secondInterfaceType)));
	}
	
	public void testGetExtendedInterfaces_04() {
		Iterable<JvmTypeReference> interfaces = genericType.getExtendedInterfaces();
		JvmGenericType interfaceType = TypesFactory.eINSTANCE.createJvmGenericType();
		genericType.getSuperTypes().add(createReferenceTo(interfaceType));
		assertSame(interfaces, genericType.getExtendedInterfaces());
		assertTrue(Iterables.isEmpty(interfaces));
		interfaceType.setInterface(true);
		assertSame(interfaces, genericType.getExtendedInterfaces());
		assertSame(interfaceType, Iterables.getOnlyElement(interfaces).getType());
	}
	
	public void testGetExtendedClasses_01() {
		JvmTypeReference clazz = genericType.getExtendedClass();
		assertNull(clazz);
	}
	
	public void testGetExtendedClasses_02() {
		JvmGenericType classType = TypesFactory.eINSTANCE.createJvmGenericType();
		classType.setInterface(false);
		genericType.getSuperTypes().add(createReferenceTo(classType));
		JvmTypeReference clazz = genericType.getExtendedClass();
		assertSame(classType, clazz.getType());
	}
	
	public void testGetExtendedClasses_03() {
		JvmGenericType firstInterfaceType = TypesFactory.eINSTANCE.createJvmGenericType();
		JvmGenericType secondInterfaceType = TypesFactory.eINSTANCE.createJvmGenericType();
		JvmGenericType classType = TypesFactory.eINSTANCE.createJvmGenericType();
		firstInterfaceType.setInterface(true);
		secondInterfaceType.setInterface(true);
		classType.setInterface(false);
		genericType.getSuperTypes().add(createReferenceTo(firstInterfaceType));
		genericType.getSuperTypes().add(createReferenceTo(secondInterfaceType));
		genericType.getSuperTypes().add(createReferenceTo(classType));
		JvmTypeReference clazz = genericType.getExtendedClass();
		assertSame(classType, clazz.getType());
	}
	
	public void testGetExtendedClasses_04() {
		JvmGenericType superType = TypesFactory.eINSTANCE.createJvmGenericType();
		genericType.getSuperTypes().add(createReferenceTo(superType));
		assertSame(superType, genericType.getExtendedClass().getType());
		superType.setInterface(true);
		assertNull(genericType.getExtendedClass());
	}
	
	public void testGetDeclaredConstructors_01() {
		JvmConstructor constructor = TypesFactory.eINSTANCE.createJvmConstructor();
		JvmField field = TypesFactory.eINSTANCE.createJvmField();
		JvmOperation operation = TypesFactory.eINSTANCE.createJvmOperation();
		genericType.getMembers().add(field);
		genericType.getMembers().add(constructor);
		genericType.getMembers().add(operation);
		assertEquals(constructor, Iterables.getOnlyElement(genericType.getDeclaredConstructors()));
	}
}
