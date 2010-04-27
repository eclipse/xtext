/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.ecore;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ecore.XMLEncodingProvider;
import org.eclipse.xtext.resource.ClassloaderClasspathUriResolver;
import org.eclipse.xtext.resource.IClasspathUriResolver;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XMLEncodingProviderTest extends TestCase {
	
	private String packagePath;
	private IClasspathUriResolver resolver;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		packagePath = getClass().getPackage().getName().replaceAll("\\.", "/");
		resolver = new ClassloaderClasspathUriResolver();
	}

	public void testName() throws Exception {
		XMLEncodingProvider xmlEncodingProvider = new XMLEncodingProvider();
		assertEquals("UTF-8", xmlEncodingProvider.getEncoding(getURI("utf8.ecore")));
		assertEquals("ISO-8859-1", xmlEncodingProvider.getEncoding(getURI("iso-8859-1.ecore")));
		assertEquals("UTF-16", xmlEncodingProvider.getEncoding(getURI("utf16.ecore")));
	}
	
	protected URI getURI(String fileName) {
		URI classpathURI = URI.createURI("classpath:/" + packagePath + "/" + fileName);
		return resolver.resolve(this, classpathURI);
	}
}
