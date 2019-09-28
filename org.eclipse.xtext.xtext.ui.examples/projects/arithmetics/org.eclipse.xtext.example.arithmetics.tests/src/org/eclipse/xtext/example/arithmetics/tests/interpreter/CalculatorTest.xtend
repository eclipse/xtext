/*******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
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

	@Inject extension ParseHelper<Module>
	@Inject extension Calculator

	@Test def void testSimple() {
		"1 + 2 + 3".evaluatesTo(6)
		"1 + 2 - 3".evaluatesTo(0)
		"1 * 2 + 3".evaluatesTo(5)
		"1 - 2 - 3".evaluatesTo(-4)
		"1 / 2 * 3".evaluatesTo(1.5)
	}

	@Test def void testFunction() {
		'''
			multiply(2,multiply(2, 3));
			def multiply(a, b) : a * b;
		'''.evaluatesTo(12.0)
	}

	private def evaluatesTo(CharSequence content, double expected) {
		val module = '''module test «content»'''.parse
		val expression = module.statements.head.eContents.filter(Expression).head
		val result = expression.evaluate
		assertEquals(expected, result.doubleValue, 0.0001)
	}

}