/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.scoping;

import java.util.ArrayList;
import java.util.Iterator;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class ScopesTest extends TestCase {
	
	public void testSimple() throws Exception {
		EAttribute attr = EcoreFactory.eINSTANCE.createEAttribute();
		attr.setName("Foo");
		EAttribute attr2 = EcoreFactory.eINSTANCE.createEAttribute();
		attr2.setName("Bar");
		
		ArrayList<EAttribute> list = new ArrayList<EAttribute>();
		list.add(attr);
		list.add(attr2);
		
		Iterable<IEObjectDescription> iterable = Scopes.scopedElementsFor(list);
		Iterator<IEObjectDescription> iterator = iterable.iterator();
		assertEquals("Foo", iterator.next().getName());
		assertEquals("Bar", iterator.next().getName());
	}
	
	public void testWithNull() throws Exception {
		EAttribute attr = EcoreFactory.eINSTANCE.createEAttribute();
		attr.setName("Foo");
		EAttribute attr2 = EcoreFactory.eINSTANCE.createEAttribute();
		attr2.setName("Bar");
		
		ArrayList<EAttribute> list = new ArrayList<EAttribute>();
		list.add(attr);
		list.add(EcoreFactory.eINSTANCE.createEAttribute());
		list.add(attr2);
		
		Iterable<IEObjectDescription> iterable = Scopes.scopedElementsFor(list);
		Iterator<IEObjectDescription> iterator = iterable.iterator();
		assertEquals("Foo", iterator.next().getName());
		assertEquals("Bar", iterator.next().getName());
		assertFalse(iterator.hasNext());
	}
	
	public void testWithDifferentElements() throws Exception {
		EAttribute attr = EcoreFactory.eINSTANCE.createEAttribute();
		attr.setName("Foo");
		EDataType datatype = EcoreFactory.eINSTANCE.createEDataType();
		datatype.setName("Bar");
		
		ArrayList<EObject> list = new ArrayList<EObject>();
		list.add(attr);
		list.add(EcoreFactory.eINSTANCE.createEObject());
		list.add(datatype);
		
		Iterable<IEObjectDescription> iterable = Scopes.scopedElementsFor(list);
		Iterator<IEObjectDescription> iterator = iterable.iterator();
		IEObjectDescription next = iterator.next();
		assertEquals("Foo", next.getName());
		assertEquals(attr,next.getEObjectOrProxy());
		next = iterator.next();
		assertEquals("Bar", next.getName());
		assertEquals(datatype,next.getEObjectOrProxy());
		assertFalse(iterator.hasNext());
	}
	
	public void testEmptyIterable() throws Exception {
		ArrayList<EAttribute> list = new ArrayList<EAttribute>();
		Iterable<IEObjectDescription> iterable = Scopes.scopedElementsFor(list);
		assertFalse(iterable.iterator().hasNext());
	}
}
