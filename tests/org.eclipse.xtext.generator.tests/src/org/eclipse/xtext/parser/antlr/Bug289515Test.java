/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.parser.antlr.bug289515Test.Model;
import org.eclipse.xtext.parser.antlr.services.Bug289515TestLanguageGrammarAccess;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug289515Test extends AbstractXtextTests {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(Bug289515TestLanguageStandaloneSetup.class);
	}
	
	public void testParser_01() throws Exception {
		assertModelValue("1%", "%");
	}
	
	public void testParser_02() throws Exception {
		assertModelValue("2%", "%");
	}

	public void testParser_03() throws Exception {
		assertModelValue("3\\%", "\\%");
	}
	
	public void testParser_04() throws Exception {
		assertModelValue("4\\%", "\\%");
	}
	
	public void testParser_05() throws Exception {
		assertModelValue("5%%", "%%");
	}
	
	public void testParser_06() throws Exception {
		assertModelValue("6%%", "%%");
	}
	
	public void testGrammarAccess_01() {
		Bug289515TestLanguageGrammarAccess access = get(Bug289515TestLanguageGrammarAccess.class);
		assertEquals("%", access.getModelAccess().getValuePercentSignKeyword_0_1_0().getValue());
	}
	
	public void testGrammarAccess_02() {
		Bug289515TestLanguageGrammarAccess access = get(Bug289515TestLanguageGrammarAccess.class);
		assertEquals("%", access.getModelAccess().getValuePercentSignKeyword_1_1_0().getValue());
	}
	
	public void testGrammarAccess_03() {
		Bug289515TestLanguageGrammarAccess access = get(Bug289515TestLanguageGrammarAccess.class);
		assertEquals("\\%", access.getModelAccess().getValueReverseSolidusPercentSignKeyword_2_1_0().getValue());
	}
	
	public void testGrammarAccess_04() {
		Bug289515TestLanguageGrammarAccess access = get(Bug289515TestLanguageGrammarAccess.class);
		assertEquals("\\%", access.getModelAccess().getValueReverseSolidusPercentSignKeyword_3_1_0().getValue());
	}
	
	public void testGrammarAccess_05() {
		Bug289515TestLanguageGrammarAccess access = get(Bug289515TestLanguageGrammarAccess.class);
		assertEquals("%%", access.getModelAccess().getValuePercentSignPercentSignKeyword_4_1_0().getValue());
	}
	
	public void testGrammarAccess_06() {
		Bug289515TestLanguageGrammarAccess access = get(Bug289515TestLanguageGrammarAccess.class);
		assertEquals("%%", access.getModelAccess().getValuePercentSignPercentSignKeyword_4_1_0().getValue());
	}
	
	protected void assertModelValue(String model, String expectation) throws Exception {
		Model parsedModel = (Model) getModel(model);
		assertEquals(expectation, parsedModel.getValue());
	}

}
