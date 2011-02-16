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

import junit.framework.TestCase;

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

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractConstructorScopeTest extends TestCase {

	public void testGetOuterScope_01() {
		assertSame(IScope.NULLSCOPE, ((AbstractScope)getConstructorScope()).getParent());
	}
	
	public void testGetElementByName_01() {
		IEObjectDescription objectElement = getConstructorScope().getSingleElement(QualifiedName.create(Object.class.getName()));
		assertNotNull(objectElement);
		assertFalse(objectElement.getEObjectOrProxy().eIsProxy());
		assertEquals(TypesPackage.Literals.JVM_CONSTRUCTOR, objectElement.getEClass());
		assertEquals(QualifiedName.create("java.lang.Object"), objectElement.getName());
	}
	
	public void testGetElementByName_02() {
		IEObjectDescription objectElement = getConstructorScope().getSingleElement(QualifiedName.create(Object.class.getName() + "SuperClass"));
		assertNull(objectElement);
	}
	
	public void testGetElementByName_03() {
		IEObjectDescription objectElement = getConstructorScope().getSingleElement(QualifiedName.create(int.class.getName()));
		assertNull(objectElement);
	}
	
	public void testGetElementByName_04() {
		IEObjectDescription objectElement = getConstructorScope().getSingleElement(QualifiedName.create(AbstractList.class.getName()));
		assertNotNull(objectElement);
	}
	
	public void testGetElementByName_05() {
		IEObjectDescription objectElement = getConstructorScope().getSingleElement(QualifiedName.create(List.class.getName()));
		assertNull(objectElement);
	}
	
	public void testGetElementByInstance_01() {
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
	
	public void testGetElementByInstance_02() {
		JvmVoid voidType = TypesFactory.eINSTANCE.createJvmVoid();
		IEObjectDescription element = getConstructorScope().getSingleElement(voidType);
		assertNull(element);
	}
	
	public void testGetElementByInstance_03() {
		JvmAnnotationReference annotationReference = TypesFactory.eINSTANCE.createJvmAnnotationReference();
		IEObjectDescription element = getConstructorScope().getSingleElement(annotationReference);
		assertNull(element);
	}
	
	protected abstract IScope getConstructorScope();

}
