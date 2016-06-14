/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.ecore;

import java.nio.charset.Charset;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.ClassloaderClasspathUriResolver;
import org.eclipse.xtext.resource.IClasspathUriResolver;
import org.eclipse.xtext.resource.generic.XMLEncodingProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XMLEncodingProviderTest extends Assert {
	
	private String packagePath;
	private IClasspathUriResolver resolver;

	@Before
	public void setUp() throws Exception {
		packagePath = getClass().getPackage().getName().replaceAll("\\.", "/");
		resolver = new ClassloaderClasspathUriResolver();
	}

	@Test public void testName() throws Exception {
		XMLEncodingProvider xmlEncodingProvider = new XMLEncodingProvider();
		assertEquals("UTF-8", xmlEncodingProvider.getEncoding(getURI("utf8.ecore")));
		assertEquals("ISO-8859-1", xmlEncodingProvider.getEncoding(getURI("iso-8859-1.ecore")));
		assertEquals("UTF-16", xmlEncodingProvider.getEncoding(getURI("utf16.ecore")));
	}
	
	@Test public void testMissingFile() throws Exception {
		XMLEncodingProvider xmlEncodingProvider = new XMLEncodingProvider();
		try {
			assertEquals(Charset.defaultCharset().name(), xmlEncodingProvider.getEncoding(URI.createFileURI("missing.ecore")));
		} catch (Exception e) {
			fail("Missing file should return default encoding");
		}
	}
	
	protected URI getURI(String fileName) {
		URI classpathURI = URI.createURI("classpath:/" + packagePath + "/" + fileName);
		return resolver.resolve(this, classpathURI);
	}
}
