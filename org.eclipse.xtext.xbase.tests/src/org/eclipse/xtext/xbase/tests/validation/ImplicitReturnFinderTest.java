/**
 * Copyright (c) 2014, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XSynchronizedExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.validation.ImplicitReturnFinder;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
public class ImplicitReturnFinderTest extends AbstractXbaseTestCase {
	@Inject
	private ImplicitReturnFinder finder;

	@Test
	public void testReturn() throws Exception {
		hasNoImplicitReturns(expression("return"));
	}

	@Test
	public void testVariableDeclaration() throws Exception {
		hasNoImplicitReturns(expression("{val x = \'foo\'}"));
	}

	@Test
	public void testForLoop() throws Exception {
		hasNoImplicitReturns(expression("for (i: 1..10)"));
	}

	@Test
	public void testWhileLoop() throws Exception {
		hasNoImplicitReturns(expression("while (true)"));
	}

	@Test
	public void testDoWhileLoop() throws Exception {
		hasNoImplicitReturns(expression("do while (true)"));
	}

	@Test
	public void testThrow() throws Exception {
		hasNoImplicitReturns(expression("throw new RuntimeException()"));
	}

	@Test
	public void testNumberLiteral() throws Exception {
		isImplicitReturn(expression("1"));
	}

	@Test
	public void testNullLiteral() throws Exception {
		isImplicitReturn(expression("null"));
	}

	@Test
	public void testBooleanLiteral() throws Exception {
		isImplicitReturn(expression("true"));
	}

	@Test
	public void testStringLiteral() throws Exception {
		isImplicitReturn(expression("\'foo\'"));
	}

	@Test
	public void testListLiteral() throws Exception {
		isImplicitReturn(expression("\'#[]\'"));
	}

	@Test
	public void testSetLiteral() throws Exception {
		isImplicitReturn(expression("\'#{}\'"));
	}

	@Test
	public void testFeatureCall() throws Exception {
		isImplicitReturn(expression("\'foo.length\'"));
	}

	@Test
	public void testCLosure() throws Exception {
		isImplicitReturn(expression("[]"));
	}

	@Test
	public void testCast() throws Exception {
		isImplicitReturn(expression("1 as int"));
	}

	@Test
	public void testInstaceof() throws Exception {
		isImplicitReturn(expression("1 instanceof int"));
	}

	@Test
	public void testConstructorCall() throws Exception {
		isImplicitReturn(expression("new String"));
	}

	@Test
	public void testBlock01() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{1}");
		hasImplicitReturns(block, Iterables.getFirst(block.getExpressions(), null));
	}

	@Test
	public void testBlock02() throws Exception {
		hasNoImplicitReturns(expression("{ val x = \'foo\' return 1 }"));
	}

	@Test
	public void testSynchronized() throws Exception {
		XSynchronizedExpression block = (XSynchronizedExpression) expression("synchronized (this) {1}");
		hasImplicitReturns(block, Iterables.getFirst(((XBlockExpression) block.getExpression()).getExpressions(), null));
	}

	@Test
	public void testIf01() throws Exception {
		XIfExpression expr = (XIfExpression) expression("if (true) 1 else 2");
		hasImplicitReturns(expr, expr.getThen(), expr.getElse());
	}

	@Test
	public void testIf02() throws Exception {
		hasNoImplicitReturns(expression("if (true) return 1 else return 2"));
	}

	@Test
	public void testSwitch01() throws Exception {
		XSwitchExpression expr = (XSwitchExpression) expression("switch (this) case String: 1 default: 2");
		XCasePart firstCase = Iterables.getFirst(expr.getCases(), null);
		Assert.assertNotNull(firstCase);
		hasImplicitReturns(expr, firstCase.getThen(), expr.getDefault());
	}

	@Test
	public void testSwitch02() throws Exception {
		XSwitchExpression expr = (XSwitchExpression) expression("switch (this) case String: return 1 default: return 2");
		hasNoImplicitReturns(expr);
	}

	@Test
	public void testTryCatch() throws Exception {
		XTryCatchFinallyExpression expr = (XTryCatchFinallyExpression) expression("try 1 catch(Exception e) 2");
		XCatchClause firstCatchClause = Iterables.getFirst(expr.getCatchClauses(), null);
		Assert.assertNotNull(firstCatchClause);
		hasImplicitReturns(expr, expr.getExpression(), firstCatchClause.getExpression());
	}

	@Test
	public void testTryCatch02() throws Exception {
		hasNoImplicitReturns(expression("try return 1 catch(Exception e) return 2"));
	}

	public void hasNoImplicitReturns(XExpression expression) {
		List<XExpression> returns = new ArrayList<>();
		finder.findImplicitReturns(expression, it -> returns.add(it));
		Assert.assertTrue("Expected «expression» to have no implicit returns, but it had «returns»", returns.isEmpty());
	}

	public void hasImplicitReturns(XExpression expression, XExpression... expectedReturns) {
		List<Object> returns = new ArrayList<>();
		finder.findImplicitReturns(expression, it -> returns.add(it));
		Assert.assertArrayEquals(expectedReturns, returns.toArray());
	}

	public void isImplicitReturn(XExpression expression) {
		hasImplicitReturns(expression, expression);
	}
}
