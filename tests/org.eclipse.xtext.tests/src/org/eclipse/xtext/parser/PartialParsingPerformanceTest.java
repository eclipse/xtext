/*******************************************************************************
 * Copyright (c) itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.TreeTestLanguageStandaloneSetup;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class PartialParsingPerformanceTest extends AbstractPartialParserTest {

	private static final int NUM_ELEMENTS = 100;
	
	public void testExpression() throws Exception {
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
		CompositeNode rootNode = getRootNode(model);
		IParseResult reparse = partialParser.reparse(getAntlrParser(), rootNode, model.indexOf('c'), 1, "Hugo");
		assertTrue(reparse.getParseErrors() == null || reparse.getParseErrors().isEmpty());
	}
	
	public void testReference() throws Exception {
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
		CompositeNode rootNode = getRootNode(model);
		IParseResult reparse = partialParser.reparse(getAntlrParser(), rootNode, model.indexOf("Sven"), 4, "Peter");
		if(reparse.getParseErrors() != null && !reparse.getParseErrors().isEmpty()) {
			fail("Unexpected parse error " + reparse.getParseErrors().get(0).getMessage()) ;
		}
	}
	
	public void testReferenceWithErrorAtEnd() throws Exception {
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
		CompositeNode rootNode = getRootNodeAndExpect(model, 1);
		IParseResult reparse = partialParser.reparse(getAntlrParser(), rootNode, model.indexOf("Sven"), 4, "Peter");
		assertEquals(1, reparse.getParseErrors().size());
	}
	
	public void testBug_255015() throws Exception {
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
		assertEquals(0, resource.getParseResult().getParseErrors().size());
	}

}
