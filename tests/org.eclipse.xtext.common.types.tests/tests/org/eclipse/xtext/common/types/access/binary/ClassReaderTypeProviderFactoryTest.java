/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary;

import java.util.Map;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.common.types.access.binary.ClassReaderTypeProvider;
import org.eclipse.xtext.common.types.access.binary.ClassReaderTypeProviderFactory;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClassReaderTypeProviderFactoryTest extends Assert {

	private ClassReaderTypeProviderFactory factory;

	@Before
	public void setUp() throws Exception {
		factory = new ClassReaderTypeProviderFactory(getClass().getClassLoader());
	}
	
	@After
	public void tearDown() throws Exception {
		factory = null;
	}
	
	@Test public void testCreateTypeProvider_01() {
		ClassReaderTypeProvider typeProvider = factory.createTypeProvider();
		assertNotNull(typeProvider);
		assertNotNull(typeProvider.getResourceSet());
	}
	
	@Test public void testCreateTypeProvider_02() {
		ResourceSet resourceSet = new ResourceSetImpl();
		ClassReaderTypeProvider typeProvider = factory.createTypeProvider(resourceSet);
		assertNotNull(typeProvider);
		assertEquals(resourceSet, typeProvider.getResourceSet());
	}
	
	@Test public void testCreateTypeProvider_03() {
		ClassReaderTypeProvider typeProvider = factory.createTypeProvider();
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
		ClassReaderTypeProvider typeProvider = factory.createTypeProvider(resourceSet);
		assertSame(typeProvider, factory.findTypeProvider(resourceSet));
	}
	
}
