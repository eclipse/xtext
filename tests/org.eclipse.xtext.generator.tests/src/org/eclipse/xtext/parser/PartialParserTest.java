/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import org.eclipse.xtext.parser.impl.PartialParsingPointers;
import org.eclipse.xtext.parser.impl.PartialParsingUtil;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.testlanguages.LookaheadLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.SimpleExpressionsStandaloneSetup;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class PartialParserTest extends AbstractPartialParserTest {

	public void testExpression() throws Exception {
		with(SimpleExpressionsStandaloneSetup.class);
		String model = "(a+b+c)*(c/d)";
		parseAndCompareAllSubstrings(model);
	}

	public void testLookahead() throws Exception {
		with(LookaheadLanguageStandaloneSetup.class);
		String model = "bar a foo bar c b d foo bar b c";
		parseAndCompareAllSubstrings(model);
	}
	
	private void parseAndCompareAllSubstrings(String model) throws Exception {
		CompositeNode rootNode = getRootNode(model);
		for (int i = 0; i < model.length()-1; ++i) {
			for(int j=1; j+i<model.length(); ++j) {
				partiallyParseAndCompare(rootNode, i, j);
			}
		}
	}

	private void partiallyParseAndCompare(CompositeNode rootNode, int offset, int length) throws Exception {
		PartialParsingPointers parsingPointers = PartialParsingUtil.calculatePartialParsingPointers(rootNode, offset, length);
		String entryRuleName = parsingPointers.findEntryRuleName();
		IParseResult parseResult = ((AbstractParser) getParser()).parse(entryRuleName, new StringInputStream(parsingPointers.findReparseRegion()), getASTFactory());
		comparator.assertSameStructure(parsingPointers.getDefaultReplaceRootNode(), parseResult.getRootNode());
		comparator.assertSameStructure(parsingPointers.findASTReplaceElement(), parseResult.getRootASTElement());
		assertEquals(parsingPointers.getDefaultReplaceRootNode().serialize(), parseResult.getRootNode().serialize());
	}
}
