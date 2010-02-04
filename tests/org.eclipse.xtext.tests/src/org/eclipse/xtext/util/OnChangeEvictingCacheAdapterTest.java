/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;

import junit.framework.TestCase;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class OnChangeEvictingCacheAdapterTest extends TestCase {
	String key = "foo";
	String value = "bar";
	
	public void testAdapterIsCleared() throws Exception {
		EcoreFactory factory = EcoreFactory.eINSTANCE;
		EClass eClass = factory.createEClass();
		OnChangeEvictingCacheAdapter ca = OnChangeEvictingCacheAdapter.getOrCreate(eClass);
		setValue(ca);
		EAttribute attribute = factory.createEAttribute();
		assertIsSet(ca);
		eClass.getEStructuralFeatures().add(attribute);
		assertIsNull(ca);
		setValue(ca);
		attribute.setName("Foo");
		assertIsNull(ca);
		setValue(ca);
	}

	private void assertIsSet(OnChangeEvictingCacheAdapter ca) {
		assertEquals(value, ca.get(key));
	}

	private void assertIsNull(OnChangeEvictingCacheAdapter ca) {
		assertNull(ca.get(key));
	}

	private void setValue(OnChangeEvictingCacheAdapter ca) {
		ca.set(key, value);
		assertIsSet(ca);
	}
}
