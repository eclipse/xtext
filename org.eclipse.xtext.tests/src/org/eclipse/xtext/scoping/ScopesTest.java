/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.scoping;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class ScopesTest extends Assert {
	
	private QualifiedName FOO = QualifiedName.create("Foo");
	private QualifiedName BAR = QualifiedName.create("Bar");
	
	@Test public void testSimple() throws Exception {
		EAttribute attr = EcoreFactory.eINSTANCE.createEAttribute();
		attr.setName("Foo");
		EAttribute attr2 = EcoreFactory.eINSTANCE.createEAttribute();
		attr2.setName("Bar");
		
		ArrayList<EAttribute> list = new ArrayList<EAttribute>();
		list.add(attr);
		list.add(attr2);
		
		Iterable<IEObjectDescription> iterable = Scopes.scopedElementsFor(list);
		Iterator<IEObjectDescription> iterator = iterable.iterator();
		assertEquals(FOO, iterator.next().getName());
		assertEquals(BAR, iterator.next().getName());
	}
	
	@Test public void testWithNull() throws Exception {
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
		assertEquals(FOO, iterator.next().getName());
		assertEquals(BAR, iterator.next().getName());
		assertFalse(iterator.hasNext());
	}
	
	@Test public void testWithDifferentElements() throws Exception {
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
		assertEquals(FOO, next.getName());
		assertEquals(attr,next.getEObjectOrProxy());
		next = iterator.next();
		assertEquals(BAR, next.getName());
		assertEquals(datatype,next.getEObjectOrProxy());
		assertFalse(iterator.hasNext());
	}
	
	@Test public void testEmptyIterable() throws Exception {
		ArrayList<EAttribute> list = new ArrayList<EAttribute>();
		Iterable<IEObjectDescription> iterable = Scopes.scopedElementsFor(list);
		assertFalse(iterable.iterator().hasNext());
	}
}
