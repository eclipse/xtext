/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.resource;

import static org.eclipse.emf.common.util.URI.*;
import static org.junit.Assert.*;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.builder.standalone.resource.StandaloneResourceSet;
import org.eclipse.xtext.resource.XtextResource;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
public class StandaloneResourceSetTest {

	@BeforeClass
	public static void setUp() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("fake",
				new org.eclipse.emf.ecore.resource.Resource.Factory() {

					public Resource createResource(URI uri) {
						if (uri != null && "ResourceWithoutURI.fake".equals(uri.lastSegment())) {
							return new XtextResource();
						}
						return new XtextResource(uri);
					}

				});
	}

	@AfterClass
	public static void tearDown() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().remove("fake");
	}

	@Test
	public void testGetResource() {
		StandaloneResourceSet resourceSet = new StandaloneResourceSet();
		resourceSet.createResource(createURI("/org/eclipse/xtext/builder/resource/StandaloneResourceSetTest.fake"));

		Resource resource = resourceSet.getResource(createURI("/somepackage/StandaloneResourceSetTest.fake"), false);
		assertNotNull(resource);
		assertEquals("/org/eclipse/xtext/builder/resource/StandaloneResourceSetTest.fake", resource.getURI().toString());
	}

	@Test
	public void testGetResource_2() {
		StandaloneResourceSet resourceSet = new StandaloneResourceSet();
		resourceSet.createResource(createURI("/org/eclipse/xtext/builder/resource/StandaloneResourceSetTest.fake"));
		assertNull(resourceSet.getResource(createURI("/somepackage/StandaloneResourceSetTest_2.fake"), false));
	}

	@Test(expected = RuntimeException.class)
	public void testGetResource_3() {
		new StandaloneResourceSet().getResource(null, true);
	}

	@Test
	public void testGetResource_4() {
		StandaloneResourceSet resourceSet = new StandaloneResourceSet();
		resourceSet.createResource(createURI("/org/eclipse/xtext/builder/resource/ResourceWithoutURI.fake"));
		assertNull(resourceSet.getResource(createURI("/somepackage/ResourceWithoutURI.fake"), false));
	}

	@Test
	public void testGetResource_5() {
		StandaloneResourceSet resourceSet = new StandaloneResourceSet();
		URI uri = createURI("/org/eclipse/xtext/builder/resource/StandaloneResourceSetTest.fake");
		resourceSet.createResource(uri);

		Resource resource = resourceSet.getResource(uri, false);
		assertNotNull(resource);
		assertEquals("/org/eclipse/xtext/builder/resource/StandaloneResourceSetTest.fake", resource.getURI().toString());
	}

	@Test
	public void testGetResource_6() {
		StandaloneResourceSet resourceSet = new StandaloneResourceSet();
		resourceSet.createResource(createURI("/org/eclipse/xtext/builder/resource/StandaloneResourceSetTest.fake"));
		resourceSet.createResource(createURI("/org/eclipse/xtext/builder/resource/somepackage/StandaloneResourceSetTest.fake"));

		assertNull(resourceSet.getResource(createURI("/somepackage/StandaloneResourceSetTest.fake"), false));
	}

}
