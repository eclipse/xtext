/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.xtext;

import junit.framework.TestCase;

import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractTypeScopeTest extends TestCase {

	public void testGetOuterScope_01() {
		assertSame(IScope.NULLSCOPE, ((AbstractScope)getTypeScope()).getParent());
	}
	
	public void testGetElementByName_01() {
		IEObjectDescription objectElement = getTypeScope().getSingleElement(QualifiedName.create(Object.class.getName()));
		assertNotNull(objectElement);
		assertFalse(objectElement.getEObjectOrProxy().eIsProxy());
		assertEquals("java.lang.Object", objectElement.getName().toString());
	}
	
	public void testGetElementByName_02() {
		IEObjectDescription objectElement = getTypeScope().getSingleElement(QualifiedName.create(Object.class.getName() + "SuperClass"));
		assertNull(objectElement);
	}
	
	public void testGetElementByName_03() {
		IEObjectDescription objectElement = getTypeScope().getSingleElement(QualifiedName.create(int.class.getName()));
		assertNotNull(objectElement);
		assertFalse(objectElement.getEObjectOrProxy().eIsProxy());
		assertEquals(QualifiedName.create("int"), objectElement.getName());
	}
	
	public void testGetElementByInstance_01() {
		JvmVoid voidType = TypesFactory.eINSTANCE.createJvmVoid();
		IEObjectDescription element = getTypeScope().getSingleElement(voidType);
		assertNotNull(element);
		assertEquals(voidType.getIdentifier(), element.getName().toString());
	}
	
	public void testGetElementByInstance_02() {
		JvmAnnotationReference annotationReference = TypesFactory.eINSTANCE.createJvmAnnotationReference();
		IEObjectDescription element = getTypeScope().getSingleElement(annotationReference);
		assertNull(element);
	}
	
	protected abstract IScope getTypeScope();
	
}
