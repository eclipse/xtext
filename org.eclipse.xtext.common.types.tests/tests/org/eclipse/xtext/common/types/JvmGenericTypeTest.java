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

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmGenericTypeTest extends JvmDeclaredTypeTest {

	private JvmGenericType genericType;

	@Before
	public void setUp() throws Exception {
		genericType = TypesFactory.eINSTANCE.createJvmGenericType();
	}
	
	@Override
	protected JvmGenericType getObjectUnderTest() {
		return genericType;
	}
	
	@Test public void testIsInstantiateable_01() {
		assertTrue(genericType.isInstantiateable());
	}

	@Test public void testIsInstantiateable_02() {
		genericType.setAbstract(true);
		assertFalse(genericType.isInstantiateable());
	}
	
	@Test public void testIsInstantiateable_03() {
		genericType.setInterface(true);
		assertFalse(genericType.isInstantiateable());
	}
	
	@Test public void testGetExtendedInterfaces_01() {
		Iterable<JvmTypeReference> interfaces = genericType.getExtendedInterfaces();
		assertNotNull(interfaces);
		assertTrue(Iterables.isEmpty(interfaces));
	}
	
	private JvmTypeReference createReferenceTo(JvmType type) {
		JvmParameterizedTypeReference result = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
		result.setType(type);
		return result;
	}
	
	@Test public void testGetExtendedInterfaces_02() {
		JvmGenericType interfaceType = TypesFactory.eINSTANCE.createJvmGenericType();
		interfaceType.setInterface(true);
		genericType.getSuperTypes().add(createReferenceTo(interfaceType));
		Iterable<JvmTypeReference> interfaces = genericType.getExtendedInterfaces();
		assertSame(interfaceType, Iterables.getOnlyElement(interfaces).getType());
	}
	
	@Test public void testGetExtendedInterfaces_03() {
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
			@Override
			public JvmType apply(JvmTypeReference from) {
				return from.getType();
			}
		}), Lists.newArrayList(firstInterfaceType, secondInterfaceType)));
	}
	
	@Test public void testGetExtendedInterfaces_04() {
		Iterable<JvmTypeReference> interfaces = genericType.getExtendedInterfaces();
		JvmGenericType interfaceType = TypesFactory.eINSTANCE.createJvmGenericType();
		genericType.getSuperTypes().add(createReferenceTo(interfaceType));
		assertSame(interfaces, genericType.getExtendedInterfaces());
		assertTrue(Iterables.isEmpty(interfaces));
		interfaceType.setInterface(true);
		assertSame(interfaces, genericType.getExtendedInterfaces());
		assertSame(interfaceType, Iterables.getOnlyElement(interfaces).getType());
	}
	
	@Test public void testGetExtendedClasses_01() {
		JvmTypeReference clazz = genericType.getExtendedClass();
		assertNull(clazz);
	}
	
	@Test public void testGetExtendedClasses_02() {
		JvmGenericType classType = TypesFactory.eINSTANCE.createJvmGenericType();
		classType.setInterface(false);
		genericType.getSuperTypes().add(createReferenceTo(classType));
		JvmTypeReference clazz = genericType.getExtendedClass();
		assertSame(classType, clazz.getType());
	}
	
	@Test public void testGetExtendedClasses_03() {
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
	
	@Test public void testGetExtendedClasses_04() {
		JvmGenericType superType = TypesFactory.eINSTANCE.createJvmGenericType();
		genericType.getSuperTypes().add(createReferenceTo(superType));
		assertSame(superType, genericType.getExtendedClass().getType());
		superType.setInterface(true);
		assertNull(genericType.getExtendedClass());
	}
	
	@Test public void testGetDeclaredConstructors_01() {
		JvmConstructor constructor = TypesFactory.eINSTANCE.createJvmConstructor();
		JvmField field = TypesFactory.eINSTANCE.createJvmField();
		JvmOperation operation = TypesFactory.eINSTANCE.createJvmOperation();
		genericType.getMembers().add(field);
		genericType.getMembers().add(constructor);
		genericType.getMembers().add(operation);
		assertEquals(constructor, Iterables.getOnlyElement(genericType.getDeclaredConstructors()));
	}
}
