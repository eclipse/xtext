/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.IExternalContentSupport.IExternalContentProvider;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ExternalContentSupportTest extends AbstractXtextTests implements IExternalContentSupport.IExternalContentProvider {

	private Map<URI, String> uriToContent;
	private ExternalContentSupport support;
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
		uriToContent = Maps.newHashMap();
		support = new ExternalContentSupport();
	}
	
	@Override
	public void tearDown() throws Exception {
		uriToContent = null;
		support = null;
		super.tearDown();
	}

	@Override
	public String getContent(URI uri) {
		return uriToContent.get(uri);
	}

	@Override
	public boolean hasContent(URI uri) {
		return uriToContent.containsKey(uri);
	}
	
	@Override
	public IExternalContentProvider getActualContentProvider() {
		return this;
	}
	
	@Test public void testConfigureConverter() {
		URIConverter converter = new ExtensibleURIConverterImpl();
		support.configureConverter(converter, this);
		checkConverter(converter);
	}
	
	@Test public void testConfigureResourceSet() {
		XtextResourceSet resourceSet = get(XtextResourceSet.class);
		support.configureResourceSet(resourceSet, this);
		checkConverter(resourceSet.getURIConverter());
	}
	
	private void checkConverter(URIConverter wrapped) {
		assertNotNull(wrapped);
		for(URIHandler handler: wrapped.getURIHandlers()) {
			assertTrue(handler instanceof ExternalContentSupport.ExternalContentAwareURIHandler);
		}
	}
	
	@Test public void testGetResource_01() {
		XtextResourceSet resourceSet = get(XtextResourceSet.class);
		resourceSet.setClasspathURIContext(getClass());
		support.configureResourceSet(resourceSet, this);
		Resource resource = resourceSet.getResource(URI.createURI("classpath:/org/eclipse/xtext/Xtext.xtext"), true);
		assertNotNull(resource);
		assertEquals(1, resource.getContents().size());
		assertEquals("org.eclipse.xtext.Xtext", ((Grammar) resource.getContents().get(0)).getName());
	}
	
	@Test public void testGetResource_02() {
		String grammarInstead = "grammar org.foo.bar with org.eclipse.xtext.common.Terminals\n" +
				"generate something 'http://something'\n" +
				"Model: name=ID;";
		XtextResourceSet resourceSet = get(XtextResourceSet.class);
		resourceSet.setClasspathURIContext(getClass());
		URI normalized = resourceSet.getURIConverter().normalize(URI.createURI("classpath:/org/eclipse/xtext/Xtext.xtext"));
		uriToContent.put(normalized, grammarInstead);
		support.configureResourceSet(resourceSet, this);
		Resource resource = resourceSet.getResource(normalized, true);
		assertNotNull(resource);
		assertEquals(1, resource.getContents().size());
		assertEquals("org.foo.bar", ((Grammar) resource.getContents().get(0)).getName());
	}
	
	@Test public void testGetResource_03() {
		String grammarInstead = "grammar org.foo.bar with org.eclipse.xtext.common.Terminals\n" +
				"generate something 'http://something'\n" +
				"Model: name=ID;";
		XtextResourceSet resourceSet = get(XtextResourceSet.class);
		resourceSet.setClasspathURIContext(getClass());
		URI original = URI.createURI("classpath:/org/eclipse/xtext/Xtext.xtext");
		URI normalized = resourceSet.getURIConverter().normalize(original);
		uriToContent.put(normalized, grammarInstead);
		support.configureResourceSet(resourceSet, this);
		Resource resource = resourceSet.getResource(original, true);
		assertNotNull(resource);
		assertEquals(1, resource.getContents().size());
		assertEquals("org.foo.bar", ((Grammar) resource.getContents().get(0)).getName());
	}
	
	@Test public void testCreateResource_01() throws IOException {
		XtextResourceSet resourceSet = get(XtextResourceSet.class);
		resourceSet.setClasspathURIContext(getClass());
		support.configureResourceSet(resourceSet, this);
		Resource resource = resourceSet.createResource(URI.createURI("classpath:/org/eclipse/xtext/Xtext.xtext"));
		assertNotNull(resource);
		assertFalse(resource.isLoaded());
		resource.load(Collections.emptyMap());
		assertEquals(1, resource.getContents().size());
		assertEquals("org.eclipse.xtext.Xtext", ((Grammar) resource.getContents().get(0)).getName());
	}
	
	@Test public void testCreateResource_02() throws IOException {
		String grammarInstead = "grammar org.foo.bar with org.eclipse.xtext.common.Terminals\n" +
				"generate something 'http://something'\n" +
				"Model: name=ID;";
		XtextResourceSet resourceSet = get(XtextResourceSet.class);
		resourceSet.setClasspathURIContext(getClass());
		URI normalized = resourceSet.getURIConverter().normalize(URI.createURI("classpath:/org/eclipse/xtext/Xtext.xtext"));
		uriToContent.put(normalized, grammarInstead);
		support.configureResourceSet(resourceSet, this);
		Resource resource = resourceSet.createResource(normalized);
		assertNotNull(resource);
		assertFalse(resource.isLoaded());
		resource.load(Collections.emptyMap());
		assertEquals(1, resource.getContents().size());
		assertEquals("org.foo.bar", ((Grammar) resource.getContents().get(0)).getName());
	}
	
	@Test public void testCreateResource_03() throws IOException {
		String grammarInstead = "grammar org.foo.bar with org.eclipse.xtext.common.Terminals\n" +
				"generate something 'http://something'\n" +
				"Model: name=ID;";
		XtextResourceSet resourceSet = get(XtextResourceSet.class);
		resourceSet.setClasspathURIContext(getClass());
		URI original = URI.createURI("classpath:/org/eclipse/xtext/Xtext.xtext");
		URI normalized = resourceSet.getURIConverter().normalize(original);
		uriToContent.put(normalized, grammarInstead);
		support.configureResourceSet(resourceSet, this);
		Resource resource = resourceSet.createResource(original);
		assertNotNull(resource);
		assertFalse(resource.isLoaded());
		resource.load(Collections.emptyMap());
		assertEquals(1, resource.getContents().size());
		assertEquals("org.foo.bar", ((Grammar) resource.getContents().get(0)).getName());
	}

}
