/*******************************************************************************
 * Copyright (c) itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.TreeTestLanguageStandaloneSetup;
import org.junit.Test;

import com.google.common.collect.Iterables;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class PartialParsingPerformanceTest extends AbstractPartialParserTest {

	private static final int NUM_ELEMENTS = 100 /* 0 */;
	
	@Test public void testExpression_FirstTime() throws Exception {
		doTestExpression();
	}
	
	@Test public void testExpression_Again() throws Exception {
		doTestExpression();
	}
	
	protected void doTestExpression() throws Exception {
		with(SimpleExpressionsTestLanguageStandaloneSetup.class);
		String d = ")+d)\r\n";
		String a_b = "(a+(b*\r\n";
		StringBuffer modelBuffer = new StringBuffer(NUM_ELEMENTS * (a_b.length() + d.length()) + 1);
		for(int i=0; i<NUM_ELEMENTS; ++i) {
			modelBuffer.append(a_b);
		}
		modelBuffer.append("c");
		for(int i=0; i<NUM_ELEMENTS; ++i) {
			modelBuffer.append(d);
		}
		String model = modelBuffer.toString();
		IParseResult parseResult = getParseResult(model);
		IParseResult reparse = reparse(parseResult, model.indexOf('c'), 1, "Hugo");
		assertFalse(reparse.hasSyntaxErrors());
	}
	
	@Test public void testReference() throws Exception {
		with(ReferenceGrammarTestLanguageStandaloneSetup.class);
		StringBuffer modelBuffer = new StringBuffer();
		modelBuffer.append("spielplatz 17 {\n");
		for(int i=0; i<NUM_ELEMENTS; ++i) {
			modelBuffer.append("  kind ( Herbert");
			modelBuffer.append(i);
			modelBuffer.append(" 11 )\n");
		}
		for(int i=0; i<NUM_ELEMENTS; ++i) {
			modelBuffer.append("  erwachsener ( Hugo");
			modelBuffer.append(i);
			modelBuffer.append(" 111 )\n");
		}
		modelBuffer.append("  erwachsener ( Sven 112 )\n");
		for(int i=0; i<NUM_ELEMENTS; ++i) {
			modelBuffer.append("  spielzeug ( Schaufel ROT )\n");
		}
		modelBuffer.append("}\n");
		String model = modelBuffer.toString();
		IParseResult parseResult = getParseResult(model);
		IParseResult reparse = reparse(parseResult, model.indexOf("Sven"), 4, "Peter");
		if(reparse.hasSyntaxErrors()) {
			fail("Unexpected parse errors " + Iterables.toString(reparse.getSyntaxErrors())) ;
		}
	}
	
	@Test public void testReferenceWithErrorAtEnd() throws Exception {
		with(ReferenceGrammarTestLanguageStandaloneSetup.class);
		StringBuffer modelBuffer = new StringBuffer();
		modelBuffer.append("spielplatz 17 {\n");
		for(int i=0; i<NUM_ELEMENTS; ++i) {
			modelBuffer.append("  kind ( Herbert");
			modelBuffer.append(i);
			modelBuffer.append(" 11 )\n");
		}
		for(int i=0; i<NUM_ELEMENTS; ++i) {
			modelBuffer.append("  erwachsener ( Hugo");
			modelBuffer.append(i);
			modelBuffer.append(" 111 )\n");
		}
		modelBuffer.append("  erwachsener ( Sven 112 )\n");
		for(int i=0; i<NUM_ELEMENTS; ++i) {
			modelBuffer.append("  spielzeug ( Schaufel ROT )\n");
		}
		modelBuffer.append(" kind (Herbert " + NUM_ELEMENTS + 1 + "\n");
		modelBuffer.append("}\n");
		String model = modelBuffer.toString();
		IParseResult parseResult = getParseResultAndExpect(model, 1);
		assertEquals(1, Iterables.size(parseResult.getSyntaxErrors()));
		IParseResult reparse = reparse(parseResult, model.indexOf("Sven"), 4, "Peter");
		assertEquals(1, Iterables.size(reparse.getSyntaxErrors()));
		assertTrue(reparse.hasSyntaxErrors());
	}
	
	@Test public void testBug_255015() throws Exception {
		with(TreeTestLanguageStandaloneSetup.class);
		StringBuffer modelBuffer = new StringBuffer(NUM_ELEMENTS * 128);
		for(int i = 0; i < Math.sqrt(NUM_ELEMENTS) * 2; i++) {
			modelBuffer.append("parent (\"Teststring\") {\n");
			for (int j = 0; j < Math.sqrt(NUM_ELEMENTS) * 2; j++) {
				modelBuffer.append("  child (\"Teststring\"){};");
			}
			modelBuffer.append("};");
		}
		String model = modelBuffer.toString();
		XtextResource resource = getResourceFromString(model);
		assertFalse(resource.getParseResult().hasSyntaxErrors());
	}

}
