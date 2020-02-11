/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.linking;

import java.util.Arrays;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SimpleAttributeResolverTest extends Assert {

	private EcoreFactory factory;
	
	private SimpleAttributeResolver<EObject, String> nameResolver;
	
	@SuppressWarnings("rawtypes")
	private SimpleAttributeResolver<EObject, EList> superClassResolver;

	@Before
	public void setUp() throws Exception {
		factory = EcoreFactory.eINSTANCE;
		nameResolver = SimpleAttributeResolver.newResolver(String.class, "name");
		superClassResolver = SimpleAttributeResolver.newResolver(EList.class, "eSuperTypes");
	}
	
	@Test public void testGetNullValue() {
		String value = nameResolver.getValue(null);
		assertNull(value);
	}
	
	@Test public void testGetNameValue() {
		EClass clazz = factory.createEClass();
		clazz.setName("ClassName");
		String name = nameResolver.getValue(clazz);
		assertEquals("ClassName", name);
	}
	
	@Test public void testGetNameValueTwice() {
		EClass clazz = factory.createEClass();
		clazz.setName("ClassName");
		assertEquals(0, clazz.eAdapters().size());
		String name = nameResolver.getValue(clazz);
		assertEquals(1, clazz.eAdapters().size());
		clazz.setName("ClassName2");
		assertEquals(0, clazz.eAdapters().size());
		name = nameResolver.getValue(clazz);
		assertEquals("ClassName2", name);
	}
	
	@Test public void testGetUnknownValue() {
		EFactory fact = factory.createEFactory();
		String name = nameResolver.getValue(fact);
		assertNull(name);
	}
	
	@Test public void testGetNameMatches() {
		EClass clazzMatch = factory.createEClass();
		EClass clazzNoMatch = factory.createEClass();
		clazzMatch.setName("ClassName");
		clazzNoMatch.setName("NoMatchClassName");
		Iterable<EObject> res = nameResolver.getMatches(Arrays.<EObject>asList(clazzMatch, clazzNoMatch), "ClassName");
		assertNotNull("res", res);
		Iterator<EObject> iter = res.iterator();
		assertTrue(iter.hasNext());
		assertEquals(clazzMatch, iter.next());
		assertFalse(iter.hasNext());
	}
	
	@Test public void testGetListValue() {
		EClass clazz = factory.createEClass();
		assertNotNull(clazz.getESuperTypes());
		EList<?> superTypes = superClassResolver.getValue(clazz);
		assertNull("superTypes", superTypes);
	}
	
}
