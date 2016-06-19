/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.lexer;

import org.eclipse.xtext.lexer.ignoreCaseTestLanguage.Model;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Heiko Behrens - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class IgnoreCaseTest extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(IgnoreCaseLexerTestLanguageStandaloneSetup.class);
	}

	@Override
	protected boolean shouldTestSerializer(XtextResource resource) {
		return false;
	}

	@Test public void testLowercase() throws Exception {
		XtextResource resource = getResourceFromString("case case");
		Model model = (Model) resource.getContents().get(0);
		assertNotNull(model);
		assertEquals("case", model.getValue());
	}

	@Test public void testUppercase() throws Exception {
		XtextResource resource = getResourceFromString("CASE CASE");
		Model model = (Model) resource.getContents().get(0);
		assertNotNull(model);
		assertEquals("CASE", model.getValue());
	}

	@Test public void testMixedCase() throws Exception {
		XtextResource resource = getResourceFromString("CaSe cAsE");
		Model model = (Model) resource.getContents().get(0);
		assertNotNull(model);
		assertEquals("cAsE", model.getValue());
	}

	@Test public void testSerializeLowercase() throws Exception {
		Model model = getModel("case case");
		String serialized = serialize(model);
		assertEquals("case case", serialized);
	}

	@Test public void testSerializeUppercase() throws Exception {
		Model model = getModel("CASE CASE");
		String serialized = serialize(model);
		assertEquals("CASE CASE", serialized);
	}

	@Test public void testSerializeMixedCase() throws Exception {
		Model model = getModel("CaSe CaSe");
		String serialized = serialize(model);
		assertEquals("CaSe CaSe", serialized);
	}

	@Test public void testSerializeInvertedMixedCase() throws Exception {
		Model model = getModel("cAsE cAsE");
		String serialized = serialize(model);
		assertEquals("cAsE cAsE", serialized);
	}

	@Override
	public Model getModel(String model) throws Exception {
		return (Model) super.getModel(model);
	}
}
