/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parser;

import org.eclipse.xtext.parsetree.reconstr.SerializationErrorTestLanguageStandaloneSetup;
import org.eclipse.xtext.parsetree.reconstr.serializationerror.Model;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.smoketest.processors.PartialParsingProcessor;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug410560Test extends AbstractXtextTests {
	@Override
	public boolean shouldTestSerializer(XtextResource resource) {
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=361355
		return false;
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(SerializationErrorTestLanguageStandaloneSetup.class);
	}

	@Test
	public void testParsingWithoutIndent_01() throws Exception {
		Model model = (Model) getModel("{}");
		Assert.assertNotNull(model);
		Assert.assertNull(model.getTest());
	}

	@Test
	public void testParsingWithoutIndent_02() throws Exception {
		Model model = (Model) getModel("({})");
		Assert.assertNotNull(model);
		Assert.assertNull(model.getTest());
	}

	@Test
	public void testParsingWithIndent_01() throws Exception {
		Model model = (Model) getModel("{tworequired a b}");
		Assert.assertNotNull(model);
		Assert.assertNotNull(model.getTest());
	}

	@Test
	public void testParsingWithIndent_02() throws Exception {
		Model model = (Model) getModel("({tworequired a b})");
		Assert.assertNotNull(model);
		Assert.assertNotNull(model.getTest());
	}

	@Test
	public void testPartialParsingChangeIndent() throws Exception {
		String modelAsString = "({tworequired a b})";
		Model model = (Model) getModel(modelAsString);
		XtextResource res = ((XtextResource) model.eResource());
		res.update(modelAsString.indexOf("a"), 1, "b");
		Assert.assertSame(model, res.getContents().get(0));
	}

	@Test
	public void testPartialParsingRemoveIndent() throws Exception {
		String modelAsString = "({ tworequired a b })";
		Model model = (Model) getModel(modelAsString);
		XtextResource res = ((XtextResource) model.eResource());
		res.update(modelAsString.indexOf("t"), "tworequired a b".length(), " ");
		Assert.assertSame(model, res.getContents().get(0));
	}

	@Test
	public void testPartialParsingRemoveNestedIndent() throws Exception {
		String modelAsString = "({{ tworequired a b }})";
		Model model = (Model) getModel(modelAsString);
		XtextResource res = ((XtextResource) model.eResource());
		res.update(modelAsString.indexOf("t"), "tworequired a b".length(), " ");
		Assert.assertSame(model, res.getContents().get(0));
	}

	@Test
	public void testPartialParsingRemoveNestedIndent_01() throws Exception {
		String modelAsString = "({{ tworequired a b }})";
		get(PartialParsingProcessor.class).processFile(modelAsString, modelAsString, modelAsString.indexOf("t"),
				"tworequired a b".length(), " ");
	}
}
