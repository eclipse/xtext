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
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractTypeScopeTest extends TestCase {

	public void testGetOuterScope_01() {
		assertSame(IScope.NULLSCOPE, getTypeScope().getOuterScope());
	}
	
	public void testGetElementByName_01() {
		IEObjectDescription objectElement = getTypeScope().getContentByName(Object.class.getName());
		assertNotNull(objectElement);
		assertFalse(objectElement.getEObjectOrProxy().eIsProxy());
		assertEquals("java.lang.Object", objectElement.getName());
	}
	
	public void testGetElementByName_02() {
		IEObjectDescription objectElement = getTypeScope().getContentByName(Object.class.getName() + "Foo");
		assertNull(objectElement);
	}
	
	public void testGetElementByInstance_01() {
		JvmVoid voidType = TypesFactory.eINSTANCE.createJvmVoid();
		IEObjectDescription element = getTypeScope().getContentByEObject(voidType);
		assertNotNull(element);
		assertEquals(voidType.getCanonicalName(), element.getName());
	}
	
	public void testGetElementByInstance_02() {
		JvmAnnotationReference annotationReference = TypesFactory.eINSTANCE.createJvmAnnotationReference();
		IEObjectDescription element = getTypeScope().getContentByEObject(annotationReference);
		assertNull(element);
	}
	
	protected abstract IScope getTypeScope();
	
}
