/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.validation;

import static org.eclipse.xtext.xbase.XbasePackage.Literals.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FeatureCallValidationTest2 extends FeatureCallValidationTest {

	@Override
	@Test
	public void testOperationFeatureCall_13() throws Exception {
		XExpression expression = expression("{ var Iterable<String> x = <String[]>newArrayList('a,b'.split(',')).flatten }");
		helper.assertError(expression, XMEMBER_FEATURE_CALL, INCOMPATIBLE_TYPES, "receiver", 
				"Iterable<? extends Iterable<? extends String>>", 
				"Iterable<? extends String>[]", 
				"ArrayList<String[]>");
	}

	@Override
	@Test
	public void testOperationFeatureCall_14() throws Exception {
		XExpression expression = expression("{ var Iterable<String> x = newArrayList('a,b'.split(','), 'a,b'.split(',')).flatten }");
		helper.assertError(expression, XMEMBER_FEATURE_CALL, INCOMPATIBLE_TYPES, "receiver", 
				"Iterable<? extends Iterable<? extends String>>", 
				"Iterable<? extends String>[]", 
				"ArrayList<String[]>");
	}
	
	@Override
	@Test
	public void testBug_350934_01() throws Exception {
		XExpression expression = expression("'3'>3");
		helper.assertError(expression, XSTRING_LITERAL, INCOMPATIBLE_TYPES);
	}
	
	@Override
	@Test
	public void testBug_350934_02() throws Exception {
		XExpression expression = expression("'true'<false");
		helper.assertError(expression, XSTRING_LITERAL, INCOMPATIBLE_TYPES);
	}
	
	@Override
	@Test
	public void testBug_350934_03() throws Exception {
		XExpression expression = expression("true>=0"); 
		helper.assertError(expression, XBOOLEAN_LITERAL, INCOMPATIBLE_TYPES);
	}
	
	@Test
	public void testBug_350934_04() throws Exception {
		XExpression expression = expression("{ val z = 1bd val y = 2bi val abc = z * y }"); 
		helper.assertError(expression, XFEATURE_CALL, INCOMPATIBLE_TYPES, "BigInteger", "BigDecimal");
	}
	
	@Override
	@Test public void testOperationFeatureCall_0() throws Exception {
		XExpression expression = expression("{ var this = new testdata.Methods() staticMethod() }");
		helper.assertError(((XBlockExpression) expression).getExpressions().get(1), XFEATURE_CALL, INSTANCE_ACCESS_TO_STATIC_MEMBER);
	}
	
}
