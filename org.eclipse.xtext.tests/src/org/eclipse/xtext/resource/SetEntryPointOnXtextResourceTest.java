/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io/) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.testlanguages.ActionTestLanguage3StandaloneSetup;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.services.ActionTestLanguage3GrammarAccess;
import org.eclipse.xtext.testlanguages.services.ReferenceGrammarTestLanguageGrammarAccess;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SetEntryPointOnXtextResourceTest extends AbstractXtextTests {
	@Test
	public void test1() throws Exception {
		with(ReferenceGrammarTestLanguageStandaloneSetup.class);
		String model = "kind (Hugo 13)";
		ParserRule kindRule = get(ReferenceGrammarTestLanguageGrammarAccess.class).getKindRule();
		XtextResource resource = createResource();
		// test 1: parse and assume there are no errors
		resource.setEntryPoint(kindRule);
		resource.load(new StringInputStream(model), Collections.emptyMap());
		Assert.assertTrue(resource.getErrors().isEmpty());
		Assert.assertEquals(kindRule, NodeModelUtils.getEntryParserRule(resource.getParseResult().getRootNode()));
		// test 2: update and assume node model does not change
		String originalNodeModel = NodeModelUtils.compactDump(resource.getParseResult().getRootNode(), false);
		resource.update(0, model.length(), " " + model + " ");
		String reparsedNodeModel = NodeModelUtils.compactDump(resource.getParseResult().getRootNode(), false);
		Assert.assertEquals(originalNodeModel, reparsedNodeModel);
		// test 3: change parser rule
		ParserRule erwachsenerRule = get(ReferenceGrammarTestLanguageGrammarAccess.class).getErwachsenerRule();
		resource.setEntryPoint(erwachsenerRule);
		resource.update(0, model.length(), "erwachsener (Peter 30)");
		Assert.assertEquals(erwachsenerRule,
				NodeModelUtils.getEntryParserRule(resource.getParseResult().getRootNode()));
	}

	@Test
	public void test2() throws Exception {
		with(ActionTestLanguage3StandaloneSetup.class);
		ParserRule rule = get(ActionTestLanguage3GrammarAccess.class).getProductionRule1Rule();
		String model = "X \"Y\" 42";
		XtextResource resource = createResource();
		resource.setEntryPoint(rule);
		resource.load(new StringInputStream(model), Collections.emptyMap());
		Assert.assertTrue(resource.getErrors().isEmpty());
		ParserRule entryRule = NodeModelUtils.getEntryParserRule(resource.getParseResult().getRootNode());
		Assert.assertEquals(rule, entryRule);
	}

	@Test
	public void test3() throws Exception {
		with(ActionTestLanguage3StandaloneSetup.class);
		ParserRule rule = get(ActionTestLanguage3GrammarAccess.class).getProductionRule2Rule();
		String model = "\"Y\" X42";
		XtextResource resource = createResource();
		resource.setEntryPoint(rule);
		resource.load(new StringInputStream(model), Collections.emptyMap());
		Assert.assertTrue(resource.getErrors().isEmpty());
		ParserRule entryRule = NodeModelUtils.getEntryParserRule(resource.getParseResult().getRootNode());
		Assert.assertEquals(rule, entryRule);
	}

	private XtextResource createResource() {
		return (XtextResource) get(IResourceFactory.class).createResource(URI.createURI("dummy." + getCurrentFileExtension()));
	}
}
