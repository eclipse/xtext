/**
 * Copyright (c) 2014, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.interpreter;

import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.interpreter.ConstantExpressionEvaluationException;
import org.eclipse.xtext.xbase.interpreter.SwitchConstantExpressionsInterpreter;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
public class SwitchConstantExpressionsInterpreterTest extends AbstractXbaseTestCase {
	@Inject
	private SwitchConstantExpressionsInterpreter interpreter;

	@Test
	public void testXNumberLiteral() throws Exception {
		evaluatesTo(Pair.of("int", "1"), 1);
		evaluatesTo(Pair.of("short", "1 as short"), 1);
		evaluatesTo(Pair.of("byte", "1 as byte"), 1);
		evaluatesTo(Pair.of("char", "1 as char"), 1);
	}

	@Test
	public void testXVariableDeclarationCall() throws Exception {
		XBlockExpression blockExpression = (XBlockExpression) expression("{ val foo = 1 val bar = foo }");
		XVariableDeclaration variableDeclaration = (XVariableDeclaration) blockExpression.getExpressions().get(1);
		evaluatesTo(variableDeclaration, 1);
	}

	@Test
	public void testJvmFieldCall() throws Exception {
		evaluatesTo("interpreter.Foo.FOO", 1);
	}

	@Test(expected = ConstantExpressionEvaluationException.class)
	public void testNullArgument() throws Exception {
		XExpression brokenExpression = expression("1 !=", false);
		interpreter.evaluate(brokenExpression);
	}

	@Test
	public void testJvmEnumerationLiteral() throws Exception {
		evaluatesTo("Thread.State.NEW", o -> Assert.assertEquals("NEW", ((JvmEnumerationLiteral) o).getSimpleName()));
	}

	@Test
	public void testXUnaryOperation() throws Exception {
		evaluatesTo("-1", -1);
	}

	@Test
	public void testXBinaryOperation() throws Exception {
		evaluatesTo("(1 + (2 - 3) * (4 / 4))", 0);
	}

	protected void evaluatesTo(String expression, Object expectation) throws Exception {
		evaluatesTo(Pair.of(null, expression), expectation);
	}

	protected void evaluatesTo(String expression, Procedure1<? super Object> assertions) throws Exception {
		evaluatesTo(Pair.of(null, expression), assertions);
	}

	protected void evaluatesTo(Pair<String, String> typeAndExpression, Object expectation) throws Exception {
		evaluatesTo(typeAndExpression, o -> Assert.assertEquals(expectation, o));
	}

	protected void evaluatesTo(Pair<String, String> typeAndExpression, Procedure1<? super Object> assertions) throws Exception {
		String type = typeAndExpression.getKey();
		String expression = typeAndExpression.getValue();
		StringBuilder builder = new StringBuilder();
		// @formatter:off
		builder.append("{\n");
		builder.append("    val");
		if (type != null) {
			builder.append(" ");
			builder.append(type);
		}
		builder.append(" testFoo = ");
		builder.append(expression);
		builder.append("\n");
		builder.append("}\n");
		// @formatter:on
		String charSequence = builder.toString();
		XBlockExpression blockExpression = (XBlockExpression) expression(charSequence, true);
		XVariableDeclaration variableDeclaration = (XVariableDeclaration) Iterables.getFirst(blockExpression.getExpressions(), null);
		Assert.assertNotNull(variableDeclaration);
		evaluatesTo(variableDeclaration, assertions);
	}

	protected void evaluatesTo(XVariableDeclaration it, Object expectation) throws Exception {
		evaluatesTo(it, o -> Assert.assertEquals(expectation, o));
	}

	protected void evaluatesTo(XVariableDeclaration it, Procedure1<? super Object> assertions) throws Exception {
		Object value = interpreter.evaluate(it.getRight());
		assertions.apply(value);
	}
}
