/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.keywords;

import org.eclipse.xtext.parser.keywords.services.KeywordsTestLanguageGrammarAccess;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class GrammarAccessTest extends TestCase {

	private KeywordsTestLanguageGrammarAccess grammarAccess;
	
	private KeywordsTestLanguageGrammarAccess.ModelElements modelElements;
	@Override
	protected void setUp() {
		this.grammarAccess = KeywordsTestLanguageGrammarAccess.INSTANCE;
		this.modelElements = grammarAccess.prModel();
	}
	
	public void testKeywordValues() {
		assertEquals("foo\\bar", modelElements.ele0000KeywordFooBar().getValue());
		assertEquals("foo\\", modelElements.ele0010KeywordFoo().getValue());
		assertEquals("\\bar", modelElements.ele010KeywordBar().getValue());
		assertEquals("\\", modelElements.ele10KeywordReverseSolidus().getValue());
	}
}
