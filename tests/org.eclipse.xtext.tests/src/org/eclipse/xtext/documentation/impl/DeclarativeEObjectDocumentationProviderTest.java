/*******************************************************************************
 * Copyright (c) 2010 Christoph Kulla
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Christoph Kulla - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.documentation.impl;

import org.eclipse.xtext.dummy.DummyTestLanguageStandaloneSetup;
import org.eclipse.xtext.dummy.dummyLang.Element;
import org.eclipse.xtext.dummy.dummyLang.Model;
import org.eclipse.xtext.junit.AbstractXtextTests;

/**
 * @author Christoph Kulla - Initial contribution and API
 */
public class DeclarativeEObjectDocumentationProviderTest extends AbstractXtextTests {

	final String document = "element A;";

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(DummyTestLanguageStandaloneSetup.class);
	}
	
	public void test () throws Exception {
		Model model = (Model) getModel (document);
		model.getElements().get(0);
		DeclarativeEObjectDocumentationProvider provider = new DeclarativeEObjectDocumentationProvider() {
			@SuppressWarnings("unused")
			protected String _documentation(Element element) {
				return element.getName();
			}			
		};
		assertEquals("A", provider.getDocumentation(model.getElements().get(0)));
	}

	public void testNull () throws Exception {
		Model model = (Model) getModel (document);
		model.getElements().get(0);
		DeclarativeEObjectDocumentationProvider provider = new DeclarativeEObjectDocumentationProvider();
		assertEquals(null, provider.getDocumentation(model.getElements().get(0)));
	}

	public void testDefaultDocumentation () throws Exception {
		final String expected = "getDefaultDocumentation() called";
		Model model = (Model) getModel (document);
		model.getElements().get(0);
		DeclarativeEObjectDocumentationProvider provider = new DeclarativeEObjectDocumentationProvider() {

			@Override
			protected String getDefaultDocumentation() {
				return expected;
			}
			
		};
		assertEquals(expected, provider.getDocumentation(model.getElements().get(0)));
	}

}
