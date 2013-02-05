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

import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.xbase.XExpression;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ValidationTests2 extends ValidationTests {

	@Override
	@Test
	public void testLocalVarWithArguments_01() throws Exception {
		XExpression expr = expression("{ val x = 'foo' x(42, 17bd) }");
		helper.assertError(expr, XFEATURE_CALL, UNRESOLVABLE_PROXY, "method", "x(int, BigDecimal)");
	}
	
	@Test public void testLocalVarWithArguments_02() throws Exception {
		XExpression expr = expression("{ val x = 'foo' x() }");
		helper.assertError(expr, XFEATURE_CALL, UNRESOLVABLE_PROXY, "method", "x()");
	}
	
	@Override
	@Test
	public void testVariableShadowing_08() throws Exception {
		super.testVariableShadowing_08();
	}
	
	@Override
	@Test
	public void testVariableShadowing_09() throws Exception {
		super.testVariableShadowing_09();
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
	
	@Override
	@Test
	public void testCast_0() throws Exception {
		super.testCast_0();
	}
	
	@Test
	public void testCastInSwitch() throws Exception {
		XExpression expression = expression("switch('foo') { String: it }");
		helper.assertWarning(expression, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, OBSOLETE_CAST, "Unnecessary cast from String to String");
		helper.assertNoError(expression, INVALID_CAST);
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
	
	@Override
	@Test
	public void testReturnExpressionInClosure_01() throws Exception {
		XExpression expression = expression("{val (String)=>String func = [x | return true] func.apply('foo')}");
		helper.assertError(expression, XCLOSURE, INCOMPATIBLE_TYPES, "(String)=>String", "(String)=>boolean");
	}

	@Test
	public void testReturnExpressionInClosure_08() throws Exception {
		XExpression expression = expression("{val (String)=>String func = [x | if (x == null) return x true] func.apply('foo')}");
		helper.assertError(expression, XCLOSURE, INCOMPATIBLE_TYPES, "(String)=>String", "(String)=>Serializable & Comparable<?>");
	}
	
}
