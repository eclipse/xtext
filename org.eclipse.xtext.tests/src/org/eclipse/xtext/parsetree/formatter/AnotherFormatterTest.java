/**
 * Copyright (c) 2019, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parsetree.formatter;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.formatting.INodeModelFormatter;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage2.Root;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;

/**
 * @author dietrich - Initial contribution and API
 */
public class AnotherFormatterTest extends AbstractXtextTests {
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(FormatterTestLanguage2StandaloneSetup.class);
	}

	@Test
	public void loadModel() throws Exception {
		ParseHelper<Root> parseHelper = getInjector().getInstance(Key.get(new TypeLiteral<ParseHelper<Root>>() {}));
		INodeModelFormatter formatter = getInjector().getInstance(INodeModelFormatter.class);
		ArrayList<String> lines = Lists.newArrayList(
			"test sample {", 
			"	// just a comment",
			"\t}",
			""
		);
		Root root = parseHelper.parse(Joiner.on(System.lineSeparator()).join(lines));
		Assert.assertNotNull(root);
		EList<Resource.Diagnostic> errors = root.eResource().getErrors();
		Assert.assertTrue("Unexpected errors: " + Joiner.on(", ").join(errors), errors.isEmpty());
		ICompositeNode rootNode = ((XtextResource) root.eResource()).getParseResult().getRootNode();
		ArrayList<String> expectedLines = Lists.newArrayList(
			"test sample {",
			"",
			"// just a comment",
			"}"
		);
		String expected = Joiner.on(System.lineSeparator())
				.join(expectedLines);
		INodeModelFormatter.IFormattedRegion formattedRegion = formatter.format(rootNode, rootNode.getTotalOffset(),
				rootNode.getTotalLength());
		Assert.assertEquals(expected, formattedRegion.getFormattedText());
		formattedRegion = formatter.format(rootNode, rootNode.getTotalOffset(), rootNode.getTotalLength());
		Assert.assertEquals(expected, formattedRegion.getFormattedText());
	}
}
