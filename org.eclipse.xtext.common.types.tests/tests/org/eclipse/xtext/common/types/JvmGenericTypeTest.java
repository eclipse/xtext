/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import java.util.List;

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

	@Test public void testSetClassToExtendsUpdatesSuperTypes() {
		JvmTypeReference classToExtend = createTypeReference();
		genericType.setClassToExtend(classToExtend);
		assertNotNull(genericType.getClassToExtend());
		assertSame(classToExtend, genericType.getSuperTypes().get(0));
		// if we unset the class to extend...
		genericType.setClassToExtend(null);
		assertNull(genericType.getClassToExtend());
		// ... it must also be removed from supertypes
		assertEquals(0, genericType.getSuperTypes().size());
	}

	@Test public void testUpdateSuperTypesSetsClassToExtend() {
		JvmTypeReference classToExtend = createTypeReference();
		JvmTypeReference anotherType = createTypeReference();
		genericType.setClassToExtend(classToExtend);
		assertNotNull(genericType.getClassToExtend());
		assertSame(classToExtend, genericType.getSuperTypes().get(0));

		genericType.getSuperTypes().add(anotherType);
		assertEquals(2, genericType.getSuperTypes().size());
		// if we remove a super type that is not the class to extend...
		genericType.getSuperTypes().remove(anotherType);
		assertEquals(1, genericType.getSuperTypes().size());
		// ... the extended class is still there
		assertNotNull(genericType.getClassToExtend());
		// ... otherwise ...
		genericType.getSuperTypes().clear();
		// ... the class to extend is unset as well ...
		assertNull(genericType.getClassToExtend());
	}

	@Test public void testUpdateInterfacesToImplementUpdatesSuperTypes() {
		JvmTypeReference interface1 = createTypeReference();
		JvmTypeReference interface2 = createTypeReference();
		genericType.getInterfacesToImplement().addAll(List.of(interface1, interface2));
		assertEquals(2, genericType.getInterfacesToImplement().size());
		var superTypes = genericType.getSuperTypes();
		assertEquals(genericType.getInterfacesToImplement(), superTypes);
		// call it twice to make sure it doesn't change
		var superTypes2 = genericType.getSuperTypes();
		assertEquals(genericType.getInterfacesToImplement(), superTypes2);
		// remove from interface to implement ...
		genericType.getInterfacesToImplement().remove(0);
		assertEquals(1, genericType.getInterfacesToImplement().size());
		// ... and the interface must be removed from supertypes as well
		assertEquals(genericType.getInterfacesToImplement(), genericType.getSuperTypes());
	}

	@Test public void testUpdateSuperTypesUpdatesInterfacesToImplement() {
		JvmTypeReference interface1 = createTypeReference();
		JvmTypeReference interface2 = createTypeReference();
		JvmTypeReference anotherType = createTypeReference();
		genericType.getInterfacesToImplement().addAll(List.of(interface1, interface2));
		assertEquals(2, genericType.getInterfacesToImplement().size());
		var superTypes = genericType.getSuperTypes();
		assertEquals(genericType.getInterfacesToImplement(), superTypes);

		genericType.getSuperTypes().add(anotherType);
		assertEquals(3, genericType.getSuperTypes().size());
		// if we remove a super type that is not an interface to implement...
		genericType.getSuperTypes().remove(anotherType);
		assertEquals(2, genericType.getSuperTypes().size());
		// ... the interface to implement is still there
		assertEquals(2, genericType.getInterfacesToImplement().size());
		// ... otherwise ...
		genericType.getSuperTypes().clear();
		// ... the interface to implement is removed as well ...
		assertEquals(0, genericType.getInterfacesToImplement().size());
	}

	@Test public void testUpdateInterfacesToExtendUpdatesSuperTypes() {
		JvmTypeReference interface1 = createTypeReference();
		JvmTypeReference interface2 = createTypeReference();
		genericType.getInterfacesToExtend().addAll(List.of(interface1, interface2));
		assertEquals(2, genericType.getInterfacesToExtend().size());
		var superTypes = genericType.getSuperTypes();
		assertEquals(genericType.getInterfacesToExtend(), superTypes);
		// call it twice to make sure it doesn't change
		var superTypes2 = genericType.getSuperTypes();
		assertEquals(genericType.getInterfacesToExtend(), superTypes2);
		// remove from interface to extend ...
		genericType.getInterfacesToExtend().remove(0);
		assertEquals(1, genericType.getInterfacesToExtend().size());
		// ... and the interface must be removed from supertypes as well
		assertEquals(genericType.getInterfacesToExtend(), genericType.getSuperTypes());
	}

	@Test public void testUpdateSuperTypesUpdatesInterfacesToExtend() {
		JvmTypeReference interface1 = createTypeReference();
		JvmTypeReference interface2 = createTypeReference();
		JvmTypeReference anotherType = createTypeReference();
		genericType.getInterfacesToExtend().addAll(List.of(interface1, interface2));
		assertEquals(2, genericType.getInterfacesToExtend().size());
		var superTypes = genericType.getSuperTypes();
		assertEquals(genericType.getInterfacesToExtend(), superTypes);

		genericType.getSuperTypes().add(anotherType);
		assertEquals(3, genericType.getSuperTypes().size());
		// if we remove a super type that is not an interface to extend...
		genericType.getSuperTypes().remove(anotherType);
		assertEquals(2, genericType.getSuperTypes().size());
		// ... the interface to implement is still there
		assertEquals(2, genericType.getInterfacesToExtend().size());
		// ... otherwise ...
		genericType.getSuperTypes().clear();
		// ... the interface to extend is removed as well ...
		assertEquals(0, genericType.getInterfacesToExtend().size());
	}

	private JvmTypeReference createTypeReference() {
		return createReferenceTo(TypesFactory.eINSTANCE.createJvmGenericType());
	}

	private JvmTypeReference createReferenceTo(JvmType type) {
		JvmParameterizedTypeReference result = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
		result.setType(type);
		return result;
	}
}
