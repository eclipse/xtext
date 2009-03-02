/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.keywords;

import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.parser.keywords.services.KeywordsTestLanguageGrammarAccess;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class GrammarAccessTest extends AbstractXtextTests {

	private KeywordsTestLanguageGrammarAccess grammarAccess;

	private KeywordsTestLanguageGrammarAccess.ModelElements modelElements;
	@Override
	protected void setUp() throws Exception {
		with(KeywordsTestLanguageStandaloneSetup.class);
		this.grammarAccess = get(KeywordsTestLanguageGrammarAccess.class);
		this.modelElements = grammarAccess.prModel();
	}

	public void testKeywordValues() {
		assertEquals("foo\\bar", modelElements.ele00KeywordFooBar().getValue());
		assertEquals("foo\\", modelElements.ele10KeywordFoo().getValue());
		assertEquals("\\bar", modelElements.ele20KeywordBar().getValue());
		assertEquals("\\", modelElements.ele30KeywordReverseSolidus().getValue());
	}
}
