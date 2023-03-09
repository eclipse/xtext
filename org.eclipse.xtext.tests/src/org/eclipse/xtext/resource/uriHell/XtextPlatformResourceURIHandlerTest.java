/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.uriHell;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.resource.XtextPlatformResourceURIHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextPlatformResourceURIHandlerTest extends Assert {

	private XtextPlatformResourceURIHandler uriHandler;
	
	@Before
	public void setUp() {
		uriHandler = new XtextPlatformResourceURIHandler();
		uriHandler.setResourceSet(new ResourceSetImpl());
	}
	
	@Test
	public void testMavenStyleResolution() {
		URI baseURI = URI.createURI("platform:/resource/org.eclipse.xtext/src/main/org/eclipse/xtext/Xtext.ecore");
		URI relativeTo = URI.createURI("platform:/resource/org.eclipse.emf.ecore/model/Ecore.ecore");
		
		uriHandler.setBaseURI(baseURI);
		URI relativeURI = uriHandler.deresolve(relativeTo);
		assertEquals("../../../../../../org.eclipse.emf.ecore/model/Ecore.ecore", relativeURI.toString());
		
		URI packagedBaseURI = URI.createURI("platform:/resource/org.eclipse.xtext/org/eclipse/xtext/Xtext.ecore");
		uriHandler.setBaseURI(packagedBaseURI);
		URI resolved = uriHandler.resolve(relativeURI);
		assertEquals(relativeTo, resolved);
	}
	
	@Test
	public void testSourceToModelResolution() {
		URI baseURI = URI.createURI("platform:/resource/org.eclipse.xtext/src/org/eclipse/xtext/Xtext.ecore");
		URI relativeTo = URI.createURI("platform:/resource/org.eclipse.emf.ecore/model/Ecore.ecore");
		
		uriHandler.setBaseURI(baseURI);
		URI relativeURI = uriHandler.deresolve(relativeTo);
		assertEquals("../../../../../org.eclipse.emf.ecore/model/Ecore.ecore", relativeURI.toString());
		
		URI packagedBaseURI = URI.createURI("platform:/resource/org.eclipse.xtext/org/eclipse/xtext/Xtext.ecore");
		uriHandler.setBaseURI(packagedBaseURI);
		URI resolved = uriHandler.resolve(relativeURI);
		assertEquals(relativeTo, resolved);
	}
	
	@Test
	public void testSourceToSourceResolution() {
		URI baseURI = URI.createURI("platform:/resource/org.eclipse.xtext/src/org/eclipse/xtext/Xtext.ecore");
		URI relativeTo = URI.createURI("platform:/resource/org.eclipse.xtext.tests/src/org/eclipse/xtext/tests/MyModel.ecore");
		
		uriHandler.setBaseURI(baseURI);
		URI relativeURI = uriHandler.deresolve(relativeTo);
		assertEquals("../../../../../org.eclipse.xtext.tests/src/org/eclipse/xtext/tests/MyModel.ecore", relativeURI.toString());
		
		URI packagedBaseURI = URI.createURI("platform:/resource/org.eclipse.xtext/org/eclipse/xtext/Xtext.ecore");
		URI packagedReferencedURI = URI.createURI("platform:/resource/org.eclipse.xtext.tests/org/eclipse/xtext/tests/MyModel.ecore");
		uriHandler.setBaseURI(packagedBaseURI);
		URI resolved = uriHandler.resolve(relativeURI);
		assertEquals(packagedReferencedURI.toString(), resolved.toString());
	}
	
	@Test
	public void testDontDeresolvePackageNamesEvenThoughTheyLookLikeRelativeURIs() {
		EPackageRegistryImpl registry = new EPackageRegistryImpl(uriHandler.getResourceSet().getPackageRegistry());
		uriHandler.getResourceSet().setPackageRegistry(registry);
		registry.put("foo.bar", EcorePackage.eINSTANCE);

		uriHandler.setBaseURI(URI.createURI("platform:/resource/org.eclipse.xtext/src/org/eclipse/xtext/Xtext.ecore"));
		assertEquals("foo.bar", uriHandler.resolve(URI.createURI("foo.bar")).toString());
		assertEquals("/foo.bar", uriHandler.resolve(URI.createURI("/foo.bar")).toString());
		assertEquals("foo.bar#/baz", uriHandler.resolve(URI.createURI("foo.bar#/baz")).toString());
		assertEquals("/foo.bar#/baz", uriHandler.resolve(URI.createURI("/foo.bar#/baz")).toString());
	}
	
}
