/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.ecore;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ecore.XMLEncodingProvider;

import junit.framework.TestCase;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XMLEncodingProviderTest extends TestCase {
	
	public void testName() throws Exception {
		XMLEncodingProvider xmlEncodingProvider = new XMLEncodingProvider();
		assertEquals("UTF-8", xmlEncodingProvider.getEncoding(URI.createFileURI("resources/utf8.ecore")));
		assertEquals("ISO-8859-1", xmlEncodingProvider.getEncoding(URI.createFileURI("resources/iso-8859-1.ecore")));
		assertEquals("UTF-16", xmlEncodingProvider.getEncoding(URI.createFileURI("resources/utf16.ecore")));
	}
}
