/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access;

import java.util.Map;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.common.types.access.impl.ClassURIHelper;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClasspathTypeProviderFactoryTest extends TestCase {

	private ClasspathTypeProviderFactory factory;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		factory = new ClasspathTypeProviderFactory(getClass().getClassLoader());
	}
	
	@Override
	protected void tearDown() throws Exception {
		factory = null;
		super.tearDown();
	}
	
	public void testCreateTypeProvider_01() {
		ClasspathTypeProvider typeProvider = factory.createTypeProvider();
		assertNotNull(typeProvider);
		assertNotNull(typeProvider.getResourceSet());
	}
	
	public void testCreateTypeProvider_02() {
		ResourceSet resourceSet = new ResourceSetImpl();
		ClasspathTypeProvider typeProvider = factory.createTypeProvider(resourceSet);
		assertNotNull(typeProvider);
		assertEquals(resourceSet, typeProvider.getResourceSet());
	}
	
	public void testCreateTypeProvider_03() {
		ClasspathTypeProvider typeProvider = factory.createTypeProvider();
		ResourceSet resourceSet = typeProvider.getResourceSet();
		Map<String, Object> map = resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap();
		assertEquals(typeProvider, map.get(ClassURIHelper.PROTOCOL));
	}
	
	public void testFindTypeProvider_01() {
		ResourceSet resourceSet = new ResourceSetImpl();
		assertNull(factory.findTypeProvider(resourceSet));
	}
	
	public void testFindTypeProvider_02() {
		ResourceSet resourceSet = new ResourceSetImpl();
		ClasspathTypeProvider typeProvider = factory.createTypeProvider(resourceSet);
		assertSame(typeProvider, factory.findTypeProvider(resourceSet));
	}
	
}
