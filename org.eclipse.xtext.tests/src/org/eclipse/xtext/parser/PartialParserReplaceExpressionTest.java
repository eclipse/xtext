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

import org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguageStandaloneSetup;
import org.junit.Test;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class PartialParserReplaceExpressionTest extends AbstractPartialParserReplaceTest {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(SimpleExpressionsTestLanguageStandaloneSetup.class);
	}
	
	@Test public void testExpression_2_2() throws Exception {
		String model = "(a+b+c)*(c/d)";
		replaceAndReparse(model, 2, 2, "+hugo+egon", "(a+hugo+egon+c)");
	}
	
	@Test public void testExpression_8_5() throws Exception {
		String model = "(a+b+c)*(c/d)";
		replaceAndReparse(model, 8, 5, "egon", "(a+b+c)*egon");
	}
	
	@Test public void testExpression_1_2() throws Exception {
		String model = "(a+b+c)*(c/d)";
		replaceAndReparse(model, 1, 2, "", "(b+c)");
	}

	@Test public void testExpression_6_3() throws Exception {
		String model = "(a+b+c)*(c/d)";
		replaceAndReparse(model, 6, 3, "*", "(a+b+c*c/d)");
	}
	
	@Test public void testExpression_3_1_1() throws Exception {
		String model = "(a+b+c)*(c/d)";
		replaceAndReparse(model, 3, 1, "(x+y+z)", "(a+(x+y+z)+c)");
	}
	
	@Test public void testExpression_a_b() throws Exception {
		String model = "a b";
		replaceAndReparse(model, 1, 1, "+", "a+b");
	}
	
	@Test public void testExpression_3_1_2() throws Exception {
		String model = "(a+b+c)*(c/d)";
		replaceAndReparse(model, 3, 1, "x)+(b", "(a+x)+(b+c)");
	}
	
	@Test public void testExpressionWithComment_0() throws Exception {
		String model = "a//b\n+c";
		replaceAndReparse(model, 1, 1, "", "a/b\n+c");
	}

}

