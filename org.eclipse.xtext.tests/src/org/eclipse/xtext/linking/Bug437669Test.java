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
import org.eclipse.xtext.linking.importedURI.ImportedURIPackage;
import org.eclipse.xtext.linking.importedURI.Main;
import org.eclipse.xtext.linking.importedURI.Type;
import org.eclipse.xtext.linking.lazy.SyntheticLinkingSupport;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.util.LineAndColumn;
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
	public void testUnresolved_01() {
		Type type = resolve("BlaBlaBla");
		Resource resource = type.eResource();
		assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());

		Diagnostic diagnostic = (Diagnostic) resource.getErrors().get(0);
		assertEquals(0, diagnostic.getOffset());
		assertEquals(1, diagnostic.getLength());
		assertEquals(1, diagnostic.getLine());
		assertEquals(1, diagnostic.getColumn());
		assertEquals("Couldn't resolve reference to Type 'BlaBlaBla'.", diagnostic.getMessage());
	}

	@Test
	public void testUnresolved_02() {
		Type type = getContext();
		INode nameNode = NodeModelUtils.findNodesForFeature(type, ImportedURIPackage.Literals.TYPE__NAME).get(0);
		resolve(type, "BlaBlaBla", nameNode.getOffset(), nameNode.getLength());
		Resource resource = type.eResource();
		assertEquals(resource.getErrors().toString(), 1, resource.getErrors().size());
		
		LineAndColumn lineAndColumn = NodeModelUtils.getLineAndColumn(nameNode, nameNode.getOffset());

		Diagnostic diagnostic = (Diagnostic) resource.getErrors().get(0);
		assertEquals(nameNode.getOffset(), diagnostic.getOffset());
		assertEquals(nameNode.getLength(), diagnostic.getLength());
		assertEquals(lineAndColumn.getLine(), diagnostic.getLine());
		assertEquals(lineAndColumn.getColumn(), diagnostic.getColumn());
		assertEquals("Couldn't resolve reference to Type 'BlaBlaBla'.", diagnostic.getMessage());
	}

	protected Type resolve(String text) {
		Type type = getContext();
		return resolve(type, text);
	}
	
	protected Type resolve(Type type, String text) {
		SyntheticLinkingSupport syntheticLinkingSupport = get(SyntheticLinkingSupport.class);
		syntheticLinkingSupport.createAndSetProxy(type, ImportedURIPackage.Literals.TYPE__EXTENDS, text);
		EcoreUtil.resolveAll(type.eResource().getResourceSet());
		return type;
	}
	
	protected Type resolve(Type type, String text, int offset, int length) {
		SyntheticLinkingSupport syntheticLinkingSupport = get(SyntheticLinkingSupport.class);
		syntheticLinkingSupport.createAndSetProxy(type, ImportedURIPackage.Literals.TYPE__EXTENDS, text, offset, length);
		EcoreUtil.resolveAll(type.eResource().getResourceSet());
		return type;
	}
	
	protected Type getContext() {
		XtextResourceSet resourceSet = get(XtextResourceSet.class);
		resourceSet.setClasspathURIContext(getClass().getClassLoader());

		URI uri = URI.createURI("classpath:/org/eclipse/xtext/linking/02.importuritestlanguage");
		Resource resource = resourceSet.getResource(uri, true);
		Main main = (Main) resource.getContents().get(0);
		return main.getTypes().get(0);
	}

}