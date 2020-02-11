/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import java.util.Map;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JdtTypeProviderFactoryTest extends Assert {

	private MockJavaProjectProvider projectProvider;
	private JdtTypeProviderFactory factory;

	@BeforeClass public static void createMockJavaProject() throws Exception {
		MockJavaProjectProvider.setUp();
	}

	@Before
	public void setUp() throws Exception {
		projectProvider = new MockJavaProjectProvider();
		factory = new JdtTypeProviderFactory(projectProvider);
	}
	
	@Test public void testCreateTypeProvider_01() {
		try {
			factory.createTypeProvider();
			fail("Expected UnsupportedOperationException");
		} catch (UnsupportedOperationException ex) {
			// ok
		}
	}
	
	@Test public void testCreateTypeProvider_02() {
		ResourceSet resourceSet = new ResourceSetImpl();
		IJdtTypeProvider typeProvider = factory.createTypeProvider(resourceSet);
		assertNotNull(typeProvider);
		assertEquals(resourceSet, typeProvider.getResourceSet());
	}
	
	@Test public void testCreateTypeProvider_03() {
		IJdtTypeProvider typeProvider = factory.createTypeProvider(new ResourceSetImpl());
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
		IJdtTypeProvider typeProvider = factory.createTypeProvider(resourceSet);
		assertSame(typeProvider, factory.findTypeProvider(resourceSet));
	}
}
