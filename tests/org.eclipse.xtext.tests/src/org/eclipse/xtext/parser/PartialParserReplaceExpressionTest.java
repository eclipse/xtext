/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguageStandaloneSetup;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class PartialParserReplaceExpressionTest extends AbstractPartialParserReplaceTest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(SimpleExpressionsTestLanguageStandaloneSetup.class);
	}
	
	public void testExpression_2_2() throws Exception {
		String model = "(a+b+c)*(c/d)";
		replaceAndReparse(model, 2, 2, "+hugo+egon", "(a+hugo+egon+c)");
	}
	
	public void testExpression_8_5() throws Exception {
		String model = "(a+b+c)*(c/d)";
		replaceAndReparse(model, 8, 5, "egon", "(a+b+c)*egon");
	}
	
	public void testExpression_1_2() throws Exception {
		String model = "(a+b+c)*(c/d)";
		replaceAndReparse(model, 1, 2, "", "(b+c)");
	}

	public void testExpression_6_3() throws Exception {
		String model = "(a+b+c)*(c/d)";
		replaceAndReparse(model, 6, 3, "*", "(a+b+c*c/d)");
	}
	
	public void testExpression_3_1_1() throws Exception {
		String model = "(a+b+c)*(c/d)";
		replaceAndReparse(model, 3, 1, "(x+y+z)", "(a+(x+y+z)+c)");
	}
	
	public void testExpression_a_b() throws Exception {
		String model = "a b";
		replaceAndReparse(model, 1, 1, "+", "a+b");
	}
	
	public void testExpression_3_1_2() throws Exception {
		String model = "(a+b+c)*(c/d)";
		replaceAndReparse(model, 3, 1, "x)+(b", "(a+x)+(b+c)");
	}
}
