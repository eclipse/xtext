/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.keywords;

import org.eclipse.xtext.parser.keywords.services.KeywordsTestLanguageGrammarAccess;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class GrammarAccessTest extends AbstractXtextTests {

	private KeywordsTestLanguageGrammarAccess grammarAccess;

	private KeywordsTestLanguageGrammarAccess.ModelElements modelElements;
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(KeywordsTestLanguageStandaloneSetup.class);
		this.grammarAccess = get(KeywordsTestLanguageGrammarAccess.class);
		this.modelElements = grammarAccess.getModelAccess();
	}

	@Test public void testKeywordValues() {
		assertEquals("foo\\bar", modelElements.getFirstFooBarKeyword_0_0().getValue());
		assertEquals("foo\\", modelElements.getSecondFooKeyword_1_0().getValue());
		assertEquals("\\bar", modelElements.getThirdBarKeyword_2_0().getValue());
		assertEquals("\\", modelElements.getForthBackslashKeyword_3_0().getValue());
		assertEquals("\"a\"", modelElements.getFifthAKeyword_4_0().getValue());
		assertEquals("'b'", modelElements.getSixthBKeyword_5_0().getValue());
		assertEquals("'c'", modelElements.getSeventhCKeyword_6_0().getValue());
		assertEquals("\"d\"", modelElements.getEighthDKeyword_7_0().getValue());
	}
}
