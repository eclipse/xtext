/*******************************************************************************
 * Copyright (c) itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import org.eclipse.xtext.parser.impl.PartialParsingUtil;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.testlanguages.ReferenceGrammarStandaloneSetup;
import org.eclipse.xtext.testlanguages.SimpleExpressionsStandaloneSetup;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class PartialParsingPerformanceTest extends AbstractPartialParserTest {

	private static final int NUM_ELEMENTS = 100;
	
	public void testExpression() throws Exception {
		with(SimpleExpressionsStandaloneSetup.class);
		String d = ")+d)";
		String A_B = "(a+(b*";
		StringBuffer modelBuffer = new StringBuffer(NUM_ELEMENTS * (A_B.length() + d.length()) + 1);
		for(int i=0; i<NUM_ELEMENTS; ++i) {
			modelBuffer.append(A_B);
		}
		modelBuffer.append("c");
		for(int i=0; i<NUM_ELEMENTS; ++i) {
			modelBuffer.append(d);
		}
		String model = modelBuffer.toString();
		CompositeNode rootNode = getRootNode(model);
		IParseResult reparse = PartialParsingUtil.reparse(getParser(), rootNode, model.indexOf('c'), 1, "Hugo");
		assertTrue(reparse.getParseErrors() == null || reparse.getParseErrors().isEmpty());
	}
	
	public void testReference() throws Exception {
		with(ReferenceGrammarStandaloneSetup.class);
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
		IParseResult reparse = PartialParsingUtil.reparse(getParser(), rootNode, model.indexOf("Sven"), 4, "Peter");
		if(reparse.getParseErrors() != null && !reparse.getParseErrors().isEmpty()) {
			fail("Unexpected parse error " + reparse.getParseErrors().get(0).getMessage()) ;
		}
	}
	
}
