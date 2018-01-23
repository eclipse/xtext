/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.tests.interpreter

import com.google.inject.Inject
import org.eclipse.xtext.example.arithmetics.arithmetics.Expression
import org.eclipse.xtext.example.arithmetics.arithmetics.Module
import org.eclipse.xtext.example.arithmetics.interpreter.Calculator
import org.eclipse.xtext.example.arithmetics.tests.ArithmeticsInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(ArithmeticsInjectorProvider)
class CalculatorTest {
	
	@Inject
	ParseHelper<Module> parseHelper
	
	@Inject
	Calculator calculator
	
	@Test def void testSimple() throws Exception {
		check(6, "1 + 2 + 3")
		check(0, "1 + 2 - 3")
		check(5, "1 * 2 + 3")
		check(-4, "1 - 2 - 3")
		check(1.5, "1 / 2 * 3")
	}
	
	@Test def void testFunction() {
		check(12.0, '''
			multiply(2,multiply(2, 3));
			def multiply(a, b) : a * b;
		''')
	}

	def protected void check(double expected, String expression) throws Exception {
		val module = parseHelper.parse('''module test «expression»''')
		var result = calculator.evaluate(module.statements.head.eContents.filter(Expression).head)
		assertEquals(expected, result.doubleValue, 0.0001)
	}

}