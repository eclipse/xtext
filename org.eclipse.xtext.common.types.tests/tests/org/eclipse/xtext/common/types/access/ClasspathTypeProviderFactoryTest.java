/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access;

import java.util.Map;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClasspathTypeProviderFactoryTest extends Assert {

	private ClasspathTypeProviderFactory factory;

	@Before
	public void setUp() throws Exception {
		factory = new ClasspathTypeProviderFactory(getClass().getClassLoader(), null);
	}
	
	@After
	public void tearDown() throws Exception {
		factory = null;
	}
	
	@Test public void testCreateTypeProvider_01() {
		ClasspathTypeProvider typeProvider = factory.createTypeProvider();
		assertNotNull(typeProvider);
		assertNotNull(typeProvider.getResourceSet());
	}
	
	@Test public void testCreateTypeProvider_02() {
		ResourceSet resourceSet = new ResourceSetImpl();
		ClasspathTypeProvider typeProvider = factory.createTypeProvider(resourceSet);
		assertNotNull(typeProvider);
		assertEquals(resourceSet, typeProvider.getResourceSet());
	}
	
	@Test public void testCreateTypeProvider_03() {
		ClasspathTypeProvider typeProvider = factory.createTypeProvider();
		ResourceSet resourceSet = typeProvider.getResourceSet();
		Map<String, Object> map = resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap();
		assertEquals(typeProvider, map.get(URIHelperConstants.PROTOCOL));
	}
	
	@Test public void testFindTypeProvider_01() {
		ResourceSet resourceSet = new ResourceSetImpl();
		assertNull(factory.findTypeProvider(resourceSet));
	}
	
	@Test public void testFindTypeProvider_02() {
		ResourceSet resourceSet = new ResourceSetImpl();
		ClasspathTypeProvider typeProvider = factory.createTypeProvider(resourceSet);
		assertSame(typeProvider, factory.findTypeProvider(resourceSet));
	}
	
}
