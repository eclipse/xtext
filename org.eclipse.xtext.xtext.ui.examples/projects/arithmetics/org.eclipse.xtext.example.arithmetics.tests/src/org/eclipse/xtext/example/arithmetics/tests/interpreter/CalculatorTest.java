/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.arithmetics.tests.interpreter;

import java.math.BigDecimal;

import org.eclipse.xtext.example.arithmetics.arithmetics.Expression;
import org.eclipse.xtext.example.arithmetics.arithmetics.Module;
import org.eclipse.xtext.example.arithmetics.arithmetics.Statement;
import org.eclipse.xtext.example.arithmetics.interpreter.Calculator;
import org.eclipse.xtext.example.arithmetics.tests.ArithmeticsInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(ArithmeticsInjectorProvider.class)
public class CalculatorTest {
	@Inject
	private ParseHelper<Module> parseHelper;

	@Inject
	private Calculator calculator;

	@Test
	public void testSimple() throws Exception {
		evaluatesTo("1 + 2 + 3", 6);
		evaluatesTo("1 + 2 - 3", 0);
		evaluatesTo("1 * 2 + 3", 5);
		evaluatesTo("1 - 2 - 3", -4);
		evaluatesTo("1 / 2 * 3", 1.5);
	}

	@Test
	public void testFunction() throws Exception {
		evaluatesTo("multiply(2,multiply(2, 3));\ndef multiply(a, b) : a * b;\n", 12.0);
	}

	private void evaluatesTo(CharSequence content, double expected) throws Exception {
		Module module = parseHelper.parse("module test " + content);
		Statement firstStatement = module.getStatements().get(0);
		Iterable<Expression> expressions = Iterables.filter(firstStatement.eContents(), Expression.class);
		Expression expression = Iterables.getFirst(expressions, null);
		BigDecimal result = calculator.evaluate(expression);
		Assert.assertEquals(expected, result.doubleValue(), 0.0001);
	}
}
