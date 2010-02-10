/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.lexer;

import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.lexer.ignoreCaseTestLanguage.Model;
import org.eclipse.xtext.resource.XtextResource;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public class IgnoreCaseTest extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(IgnoreCaseLexerTestLanguageStandaloneSetup.class);
	}
	
	public void testLowercase() throws Exception {
		XtextResource resource = getResourceFromString("case case");
		Model model = (Model) resource.getContents().get(0);
		assertNotNull(model);
		assertEquals("case", model.getValue());
	}

	public void testUppercase() throws Exception {
		XtextResource resource = getResourceFromString("CASE CASE");
		Model model = (Model) resource.getContents().get(0);
		assertNotNull(model);
		assertEquals("CASE", model.getValue());
	}

	public void testMixedCase() throws Exception {
		XtextResource resource = getResourceFromString("CaSe cAsE");
		Model model = (Model) resource.getContents().get(0);
		assertNotNull(model);
		assertEquals("cAsE", model.getValue());
	}

}
