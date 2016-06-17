/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.grammarAccess;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractGrammarElementFinder;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ElementFinderTest extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	private AbstractGrammarElementFinder grammarFinder() {
		final String file = "classpath:/org/eclipse/xtext/generator/grammarAccess/ElementFinderTestLanguage.xtext";
		XtextResourceSet rs = get(XtextResourceSet.class);
		rs.setClasspathURIContext(getClass());
		final Resource r = rs.getResource(URI.createURI(file), true);
		return new AbstractGrammarElementFinder() {
			@Override
			public Grammar getGrammar() {
				return (Grammar) r.getContents().get(0);
			}
		};
	}

	@Test public void testKeywords() {
		assertEquals(3, grammarFinder().findKeywords("myKeyword", "myKeyword2").size());
	}

	@Test public void testKeywordsFromSuperGrammar() {
		assertEquals(1, grammarFinder().findKeywords("superKeyword").size());
	}

	@Test public void testKeywordPairs() {
		assertEquals(3, grammarFinder().findKeywordPairs("begin", "end").size());
	}

	@Test public void testFindRuleCalls() {
		AbstractGrammarElementFinder f = grammarFinder();
		AbstractRule r = GrammarUtil.findRuleForName(f.getGrammar(), "FinderKeywords");
		assertEquals(2, f.findRuleCalls(r).size());
	}

	@Test public void testFindCrossReferences() {
		AbstractGrammarElementFinder f = grammarFinder();
		AbstractRule r = GrammarUtil.findRuleForName(f.getGrammar(), "FQN");
		assertNotNull(r);
		assertEquals(1, f.findCrossReferences(r).size());

		EClass type = (EClass) GrammarUtil.findRuleForName(f.getGrammar(), "Type").getType().getClassifier();
		assertNotNull(type);
		assertEquals(1, f.findCrossReferences(type).size());
	}
}
