/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.linking.importedURI.ImportedURIPackage;
import org.eclipse.xtext.linking.importedURI.Main;
import org.eclipse.xtext.linking.importedURI.Type;
import org.eclipse.xtext.linking.lazy.SyntheticLinkingSupport;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.junit.Test;

/**
 * @author kosyakov - Initial contribution and API
 */
public class Bug437669Test extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(ImportUriTestLanguageStandaloneSetup.class);
	}

	@Test
	public void testResolved() {
		Type type = resolve("Foo");
		Resource resource = type.eResource();
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());

		Type resolvedType = type.getExtends();
		assertNotNull(resolvedType);
		assertFalse(resolvedType.eIsProxy());
		assertEquals("Foo", resolvedType.getName());
	}

	@Test
	public void testUnresolved() {
		Type type = resolve("BlaBlaBla");
		Resource resource = type.eResource();
		assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());

		Diagnostic diagnostic = (Diagnostic) resource.getErrors().get(0);
		assertEquals(-1, diagnostic.getLine());
		assertEquals(0, diagnostic.getOffset());
		assertEquals(1, diagnostic.getLength());
		assertEquals("Couldn't resolve reference to Type 'BlaBlaBla'.", diagnostic.getMessage());
	}

	private Type resolve(String text) {
		XtextResourceSet resourceSet = get(XtextResourceSet.class);
		resourceSet.setClasspathURIContext(getClass().getClassLoader());

		URI uri = URI.createURI("classpath:/org/eclipse/xtext/linking/02.importuritestlanguage");
		Resource resource = resourceSet.getResource(uri, true);
		Main main = (Main) resource.getContents().get(0);
		Type type = main.getTypes().get(0);
		
		SyntheticLinkingSupport syntheticLinkingSupport = get(SyntheticLinkingSupport.class);
		syntheticLinkingSupport.createAndSetProxy(type, ImportedURIPackage.Literals.TYPE__EXTENDS, text);

		EcoreUtil.resolveAll(resourceSet);
		return type;
	}

}