/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.xtext;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractTypeScopeTest extends Assert {

	@BeforeClass public static void createMockJavaProject() throws Exception {
//		MockJavaProjectProvider.setUp();
	}

	@Test public void testGetOuterScope_01() {
		assertSame(IScope.NULLSCOPE, ((AbstractScope)getTypeScope()).getParent());
	}
	
	@Test public void testGetElementByName_01() {
		IEObjectDescription objectElement = getTypeScope().getSingleElement(QualifiedName.create(Object.class.getName()));
		assertNotNull(objectElement);
		assertFalse(objectElement.getEObjectOrProxy().eIsProxy());
		assertEquals("java.lang.Object", objectElement.getName().toString());
	}
	
	@Test public void testGetElementByName_02() {
		IEObjectDescription objectElement = getTypeScope().getSingleElement(QualifiedName.create(Object.class.getName() + "SuperClass"));
		assertNull(objectElement);
	}
	
	@Test public void testGetElementByName_03() {
		IEObjectDescription objectElement = getTypeScope().getSingleElement(QualifiedName.create(int.class.getName()));
		assertNotNull(objectElement);
		assertFalse(objectElement.getEObjectOrProxy().eIsProxy());
		assertEquals(QualifiedName.create("int"), objectElement.getName());
	}
	
	@Test public void testGetElementByName_04() {
		IEObjectDescription mapEntry = getTypeScope().getSingleElement(QualifiedName.create("java", "util", "Map", "Entry"));
		assertNotNull(mapEntry);
		assertFalse(mapEntry.getEObjectOrProxy().eIsProxy());
		assertEquals(QualifiedName.create("java", "util", "Map", "Entry"), mapEntry.getName());
	}
	
	@Test public void testGetElementByName_05() {
		IEObjectDescription mapEntry = getTypeScope().getSingleElement(QualifiedName.create("java", "util", "Map$Entry"));
		assertNotNull(mapEntry);
		assertFalse(mapEntry.getEObjectOrProxy().eIsProxy());
		assertEquals(QualifiedName.create("java", "util", "Map$Entry"), mapEntry.getName());
	}
	
	@Test public void testGetElementByInstance_01() {
		JvmVoid voidType = TypesFactory.eINSTANCE.createJvmVoid();
		IEObjectDescription element = getTypeScope().getSingleElement(voidType);
		assertNotNull(element);
		assertEquals(voidType.getIdentifier(), element.getName().toString());
	}
	
	@Test public void testGetElementByInstance_02() {
		JvmAnnotationReference annotationReference = TypesFactory.eINSTANCE.createJvmAnnotationReference();
		IEObjectDescription element = getTypeScope().getSingleElement(annotationReference);
		assertNull(element);
	}
	
	@Test public void testGetElementByInstance_03() {
		IEObjectDescription mapEntryDescription = getTypeScope().getSingleElement(QualifiedName.create("java", "util", "Map$Entry"));
		EObject mapEntry = mapEntryDescription.getEObjectOrProxy();
		IEObjectDescription lookupDescription = getTypeScope().getSingleElement(mapEntry);
		assertNotNull(lookupDescription);
		assertEquals(QualifiedName.create("java", "util", "Map", "Entry"), lookupDescription.getName());
	}
	
	@Test public void testGetElementsByInstance_01() {
		IEObjectDescription mapEntryDescription = getTypeScope().getSingleElement(QualifiedName.create("java", "util", "Map$Entry"));
		EObject mapEntry = mapEntryDescription.getEObjectOrProxy();
		Iterable<IEObjectDescription> lookupDescriptions = getTypeScope().getElements(mapEntry);
		List<IEObjectDescription> list = Lists.newArrayList(lookupDescriptions);
		assertEquals(2, list.size());
		assertEquals(QualifiedName.create("java", "util", "Map", "Entry"), list.get(0).getName());
		assertEquals(QualifiedName.create("java", "util", "Map$Entry"), list.get(1).getName());
	}
	
	protected abstract IScope getTypeScope();
	
}
