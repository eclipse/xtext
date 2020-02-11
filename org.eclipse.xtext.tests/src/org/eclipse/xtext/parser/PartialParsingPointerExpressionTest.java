/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import org.eclipse.xtext.parser.impl.PartialParsingPointers;
import org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguageStandaloneSetup;
import org.junit.Test;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class PartialParsingPointerExpressionTest extends AbstractPartialParsingPointerTest {
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(SimpleExpressionsTestLanguageStandaloneSetup.class);
	}
	
	@Test public void testExpression_1_1() throws Exception {
		String model = "(a+b+c)*(c/d)";
		PartialParsingPointers parsingPointers = calculatePartialParsingPointers(model, 1, 1);
		checkParseRegionPointers(parsingPointers, "(a+b+c)", "RuleCall", "Parens");
	}
		
	@Test public void testExpression_3_1() throws Exception {
		String model = "(a+b+c)*(c/d)";
		PartialParsingPointers parsingPointers = calculatePartialParsingPointers(model, 3, 1);
		checkParseRegionPointers(parsingPointers, "(a+b+c)", "RuleCall", "Parens");
	}
	
	@Test public void testExpression_5_2() throws Exception {
		String model = "(a+b+c)*(c/d)";
		PartialParsingPointers parsingPointers = calculatePartialParsingPointers(model, 5, 2);
		checkParseRegionPointers(parsingPointers, "(a+b+c)", "RuleCall", "Parens");
	}
	
	@Test public void testExpression_6_1() throws Exception {
		String model = "(a+b+c)*(c/d)";
		PartialParsingPointers parsingPointers = calculatePartialParsingPointers(model, 6, 1);
		checkParseRegionPointers(parsingPointers, "(a+b+c)", "RuleCall", "Parens");
	}
	
	@Test public void testExpression_8_2() throws Exception {
		String model = "(a+b+c)*(c/d)";
		PartialParsingPointers parsingPointers = calculatePartialParsingPointers(model, 8, 2);
		checkParseRegionPointers(parsingPointers, "(a+b+c)*(c/d)", "ParserRule", "Sequence");
	}
	
	@Test public void testExpression_9_2() throws Exception {
		String model = "(a+b+c)*(c/d)";
		PartialParsingPointers parsingPointers = calculatePartialParsingPointers(model, 9, 2);
		// actual minimal replace region is c/d but this would lead to accidental complexity 
		// in the partial parser implementation
//		checkParseRegionPointers(parsingPointers, "c/d", "RuleCall", "Addition");
		checkParseRegionPointers(parsingPointers, "(c/d)", "RuleCall", "Parens");
	}
	
	@Test public void testExpression_a_b() throws Exception {
		String model = "a b";
		PartialParsingPointers parsingPointers = calculatePartialParsingPointers(model, 1, 1);
		checkParseRegionPointers(parsingPointers, "a b", "Action", "Sequence");
	}

}
