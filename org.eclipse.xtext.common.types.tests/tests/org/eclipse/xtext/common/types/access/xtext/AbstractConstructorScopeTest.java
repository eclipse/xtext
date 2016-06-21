/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.xtext;

import java.util.AbstractList;
import java.util.List;

import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.eclipse.xtext.util.Strings;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractConstructorScopeTest extends Assert {

	@BeforeClass public static void createMockJavaProject() throws Exception {
//		MockJavaProjectProvider.setUp();
	}
	
	@Test public void testGetOuterScope_01() {
		assertSame(IScope.NULLSCOPE, ((AbstractScope)getConstructorScope()).getParent());
	}
	
	@Test public void testGetElementByName_01() {
		IEObjectDescription objectElement = getConstructorScope().getSingleElement(QualifiedName.create(Object.class.getName()));
		assertNotNull(objectElement);
		assertFalse(objectElement.getEObjectOrProxy().eIsProxy());
		assertEquals(TypesPackage.Literals.JVM_CONSTRUCTOR, objectElement.getEClass());
		assertEquals(QualifiedName.create("java.lang.Object"), objectElement.getName());
	}
	
	@Test public void testGetElementByName_02() {
		IEObjectDescription objectElement = getConstructorScope().getSingleElement(QualifiedName.create(Object.class.getName() + "SuperClass"));
		assertNull(objectElement);
	}
	
	@Test public void testGetElementByName_03() {
		IEObjectDescription objectElement = getConstructorScope().getSingleElement(QualifiedName.create(int.class.getName()));
		assertNull(objectElement);
	}
	
	@Test public void testGetElementByName_04() {
		IEObjectDescription objectElement = getConstructorScope().getSingleElement(QualifiedName.create(AbstractList.class.getName()));
		assertNotNull(objectElement);
	}
	
	@Test public void testGetElementByName_05() {
		IEObjectDescription objectElement = getConstructorScope().getSingleElement(QualifiedName.create(List.class.getName()));
		assertNull(objectElement);
	}
	
	@Test public void testGetElementByName_06() {
		IEObjectDescription hashMapEntry = getConstructorScope().getSingleElement(QualifiedName.create("java", "util", "Hashtable$Entry"));
		assertNotNull(hashMapEntry);
		assertFalse(hashMapEntry.getEObjectOrProxy().eIsProxy());
		assertEquals(TypesPackage.Literals.JVM_CONSTRUCTOR, hashMapEntry.getEClass());
		assertEquals(QualifiedName.create("java", "util", "Hashtable$Entry"), hashMapEntry.getName());
	}
	
	@Test public void testGetElementByName_07() {
		IEObjectDescription hashMapEntry = getConstructorScope().getSingleElement(QualifiedName.create("java", "util", "Hashtable", "Entry"));
		assertNotNull(hashMapEntry);
		assertFalse(hashMapEntry.getEObjectOrProxy().eIsProxy());
		assertEquals(TypesPackage.Literals.JVM_CONSTRUCTOR, hashMapEntry.getEClass());
		assertEquals(QualifiedName.create("java", "util", "Hashtable", "Entry"), hashMapEntry.getName());
	}
	
	@Test public void testGetElementsByName_01() {
		Iterable<IEObjectDescription> descriptions = getConstructorScope().getElements(QualifiedName.create("java", "util", "Hashtable$Entry"));
		IEObjectDescription hashMapEntry = Iterables.getOnlyElement(descriptions);
		assertNotNull(hashMapEntry);
		assertFalse(hashMapEntry.getEObjectOrProxy().eIsProxy());
		assertEquals(TypesPackage.Literals.JVM_CONSTRUCTOR, hashMapEntry.getEClass());
		assertEquals(QualifiedName.create("java", "util", "Hashtable$Entry"), hashMapEntry.getName());
	}
	
	@Test public void testGetElementsByName_02() {
		Iterable<IEObjectDescription> descriptions = getConstructorScope().getElements(QualifiedName.create("java", "util", "Hashtable", "Entry"));
		IEObjectDescription hashMapEntry = Iterables.getOnlyElement(descriptions);
		assertNotNull(hashMapEntry);
		assertFalse(hashMapEntry.getEObjectOrProxy().eIsProxy());
		assertEquals(TypesPackage.Literals.JVM_CONSTRUCTOR, hashMapEntry.getEClass());
		assertEquals(QualifiedName.create("java", "util", "Hashtable", "Entry"), hashMapEntry.getName());
	}
	
	@Test public void testGetElementsByName_03() {
		List<String> segments = Strings.split("org.eclipse.xtext.common.types.testSetups.NestedParameterizedTypes.WrappedCollection.WrappedIterator", '.');
		QualifiedName qualifiedName = QualifiedName.create(segments);
		Iterable<IEObjectDescription> descriptions = getConstructorScope().getElements(qualifiedName);
		for(IEObjectDescription description: descriptions) {
			assertEquals(qualifiedName, description.getName());
		}
		assertEquals(3, Iterables.size(descriptions));
	}
	
	@Test public void testGetElementsByName_04() {
		List<String> segments = Strings.split("org.eclipse.xtext.common.types.testSetups.NestedParameterizedTypes$WrappedCollection$WrappedIterator", '.');
		QualifiedName qualifiedName = QualifiedName.create(segments);
		Iterable<IEObjectDescription> descriptions = getConstructorScope().getElements(qualifiedName);
		for(IEObjectDescription description: descriptions) {
			assertEquals(qualifiedName, description.getName());
		}
		assertEquals(3, Iterables.size(descriptions));
	}
	
	@Test public void testGetElementByInstance_01() {
		JvmConstructor constructor = TypesFactory.eINSTANCE.createJvmConstructor();
		JvmGenericType type = TypesFactory.eINSTANCE.createJvmGenericType();
		type.setPackageName("java.lang");
		type.setSimpleName("Object");
		constructor.setSimpleName("Object");
		type.getMembers().add(constructor);
		IEObjectDescription element = getConstructorScope().getSingleElement(constructor);
		assertNotNull(element);
		assertEquals(new IQualifiedNameConverter.DefaultImpl().toQualifiedName("java.lang.Object"), element.getName());
		assertEquals(new IQualifiedNameConverter.DefaultImpl().toQualifiedName("java.lang.Object"), element.getQualifiedName());
	}
	
	@Test public void testGetElementByInstance_02() {
		JvmVoid voidType = TypesFactory.eINSTANCE.createJvmVoid();
		IEObjectDescription element = getConstructorScope().getSingleElement(voidType);
		assertNull(element);
	}
	
	@Test public void testGetElementByInstance_03() {
		JvmAnnotationReference annotationReference = TypesFactory.eINSTANCE.createJvmAnnotationReference();
		IEObjectDescription element = getConstructorScope().getSingleElement(annotationReference);
		assertNull(element);
	}
	
	@Test public void testGetElementByInstance_04() {
		QualifiedName qualifiedName = QualifiedName.create("java", "util", "Hashtable", "Entry");
		IEObjectDescription hashMapEntry = getConstructorScope().getSingleElement(qualifiedName);
		JvmConstructor constructor = (JvmConstructor) hashMapEntry.getEObjectOrProxy();
		IEObjectDescription element = getConstructorScope().getSingleElement(constructor);
		assertNotNull(element);
		assertEquals(qualifiedName, element.getName());
	}
	
	@Test public void testGetElementsByInstance_04() {
		QualifiedName qualifiedName = QualifiedName.create("java", "util", "Hashtable", "Entry");
		IEObjectDescription hashMapEntry = getConstructorScope().getSingleElement(qualifiedName);
		JvmConstructor constructor = (JvmConstructor) hashMapEntry.getEObjectOrProxy();
		Iterable<IEObjectDescription> descriptions = getConstructorScope().getElements(constructor);
		List<IEObjectDescription> list = Lists.newArrayList(descriptions);
		assertEquals(2, list.size());
		assertEquals(qualifiedName, list.get(0).getName());
		QualifiedName qualifiedNameWithDollar = QualifiedName.create("java", "util", "Hashtable$Entry");
		assertEquals(qualifiedNameWithDollar, list.get(1).getName());
	}
	
	protected abstract IScope getConstructorScope();

}
