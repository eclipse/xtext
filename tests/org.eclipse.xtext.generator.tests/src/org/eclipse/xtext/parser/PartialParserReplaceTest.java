/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.parser.impl.PartialParsingPointers;
import org.eclipse.xtext.parser.impl.PartialParsingUtil;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.SyntaxError;
import org.eclipse.xtext.testlanguages.LookaheadLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.SimpleExpressionsStandaloneSetup;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class PartialParserReplaceTest extends AbstractPartialParserTest {

	public void testExpression() throws Exception {
		with(SimpleExpressionsStandaloneSetup.class);
		String model = "(a+b+c)*(c/d)";
		replaceAndReparse(model, 2, 2, "+hugo+egon", "a+hugo+egon+c");
		replaceAndReparse(model, 8, 5, "egon", "egon");
		replaceAndReparse(model, 1, 2, "", "b+c");
		replaceAndReparse(model, 6, 3, "*", "(a+b+c*c/d)");
		replaceAndReparse(model, 3, 1, "(x+y+z)", "(x+y+z)");
		
		replaceAndReparse("a b", 1,1,"+","a+b");
		// TODO: breaking case
		replaceAndReparse(model, 3, 1, "x)+(b", "x)+(b");
		
	}

	public void testLookahead() throws Exception {
		with(LookaheadLanguageStandaloneSetup.class);
		String model = "foo bar b c";
		replaceAndReparse(model, 10, 1, "d", " d");
		replaceAndReparse(model, 8, 1, "b", "foo bar b c");
		replaceAndReparse(model, 0, model.length(), "", "");
	}

	private void replaceAndReparse(String model, int offset, int length, String change, String expectedReparseRegion)
			throws Exception {
		CompositeNode rootNode = getRootNode(model);
		PartialParsingPointers parsingPointers = PartialParsingUtil.calculatePartialParsingPointers(rootNode, offset,
				length);
		String reparseRegion = PartialParsingUtil.insertChangeIntoReplaceRegion(parsingPointers
				.getDefaultReplaceRootNode(), offset, length, change);
		assertEquals(expectedReparseRegion, reparseRegion);
		IParseResult partiallyReparse = PartialParsingUtil.reparse(getParser(), rootNode, offset, length,
				change);
		EList<SyntaxError> errors = partiallyReparse.getRootNode().allSyntaxErrors();
		for (SyntaxError syntaxError : errors) {
			System.out.println(model+offset+length+change+":"+syntaxError.getMessage());
		}
		assertTrue(partiallyReparse.getRootNode().allSyntaxErrors().isEmpty());
		String expectedReparseModel = model.substring(0, offset) + change + model.substring(offset + length);
		assertEquals(expectedReparseModel, partiallyReparse.getRootNode().serialize());
	}
}
