/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.validation;

import static org.eclipse.xtext.xbase.XbasePackage.Literals.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.tests.typesystem.XbaseNewTypeSystemInjectorProvider;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XbaseNewTypeSystemInjectorProvider.class)
public class ValidationTests2 extends ValidationTests {

	@Override
	@Test @Ignore("TODO To be implemented")
	public void testLocalVarWithArguments() throws Exception {
		super.testLocalVarWithArguments();
	}

	@Override
	@Test @Ignore("TODO To be implemented")
	public void testVariableShadowing_00() throws Exception {
		super.testVariableShadowing_00();
	}

	@Override
	@Test @Ignore("TODO To be implemented")
	public void testVariableShadowing_01() throws Exception {
		super.testVariableShadowing_01();
	}

	@Override
	@Test @Ignore("TODO To be implemented")
	public void testVariableShadowing_03() throws Exception {
		super.testVariableShadowing_03();
	}

	@Override
	@Test @Ignore("TODO To be implemented")
	public void testVariableShadowing_04() throws Exception {
		super.testVariableShadowing_04();
	}

	@Override
	@Test @Ignore("TODO To be implemented")
	public void testVariableShadowing_05() throws Exception {
		super.testVariableShadowing_05();
	}

	@Override
	@Test @Ignore("TODO To be implemented")
	public void testVariableShadowing_06() throws Exception {
		super.testVariableShadowing_06();
	}

	@Override
	@Test @Ignore("TODO To be implemented")
	public void testVariableShadowing_07() throws Exception {
		super.testVariableShadowing_07();
	}
	
	@Override
	@Test
	public void testInstanceOf_0() throws Exception {
		XExpression expression = expression("'foo' instanceof String");
		helper.assertWarning(expression, XINSTANCE_OF_EXPRESSION, OBSOLETE_INSTANCEOF, "already", "String");
		helper.assertNoError(expression, INVALID_INSTANCEOF);
	}

	@Override
	@Test
	public void testVoidInReturnExpression_02() throws Exception {
		XExpression expression = expression("return if (true) while(false) ('foo'+'bar').length");
		helper.assertError(expression, XWHILE_EXPRESSION, INCOMPATIBLE_TYPES);
		helper.assertNoIssues(expression, XIF_EXPRESSION);
	}
	
	@Override
	@Test public void testVoidInReturnExpression_03() throws Exception {
		XExpression expression = expression("return if (true) while(false) ('foo'+'bar').length else 'zonk'");
		helper.assertError(expression, XWHILE_EXPRESSION, INCOMPATIBLE_TYPES);
		helper.assertNoIssues(expression, XIF_EXPRESSION);
		helper.assertNoIssues(expression, XSTRING_LITERAL);
	}
	
	@Override
	@Test public void testVoidInReturnExpression_05() throws Exception {
		XExpression expression = expression("return if (true) while(false) ('foo'+'bar').length else null");
		helper.assertError(expression, XWHILE_EXPRESSION, INCOMPATIBLE_TYPES);
		helper.assertNoIssues(expression, XIF_EXPRESSION);
		helper.assertNoIssues(expression, XNULL_LITERAL);
	}
	
	@Test @Ignore("TODO To be implemented - should be a control flow problem")
	@Override
	public void testInvalidEarlyExit_02() throws Exception {
		super.testInvalidEarlyExit_02();
	}
	
	@Test @Ignore("TODO To be implemented - should be a control flow problem")
	@Override
	public void testInvalidEarlyExit_04() throws Exception {
		super.testInvalidEarlyExit_04();
	}

	@Override
	@Test @Ignore("TODO To be implemented")
	public void testReturnExpressionInClosure_01() throws Exception {
		super.testReturnExpressionInClosure_01();
	}

	@Override
	@Test @Ignore("TODO To be implemented")
	public void testExceptionInClosure_01() throws Exception {
		super.testExceptionInClosure_01();
	}

	@Override
	@Test @Ignore("TODO To be implemented")
	public void testExceptionInClosure_03() throws Exception {
		super.testExceptionInClosure_03();
	}

	@Override
	@Test @Ignore("TODO To be implemented")
	public void testExceptionInClosure_04() throws Exception {
		super.testExceptionInClosure_04();
	}
	
}
