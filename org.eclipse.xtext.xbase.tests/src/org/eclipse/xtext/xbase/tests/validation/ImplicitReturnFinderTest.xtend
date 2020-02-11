/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.validation

import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import com.google.inject.Inject
import org.eclipse.xtext.xbase.validation.ImplicitReturnFinder
import org.junit.Test
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XIfExpression
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression
import org.eclipse.xtext.xbase.XSwitchExpression
import org.eclipse.xtext.xbase.XSynchronizedExpression

/**
 * @author Stefan Oehme - Initial contribution and API
 */
class ImplicitReturnFinderTest extends AbstractXbaseTestCase {

	@Inject
	extension ImplicitReturnFinder finder

	@Test
	def void testReturn() {
		'''return'''.expression.hasNoImplicitReturns
	}
	
	@Test
	def void testVariableDeclaration() {
		'''{val x = "foo"}'''.expression.hasNoImplicitReturns
	}

	@Test
	def void testForLoop() {
		'''for (i: 1..10)'''.expression.hasNoImplicitReturns
	}

	@Test
	def void testWhileLoop() {
		'''while (true)'''.expression.hasNoImplicitReturns
	}

	@Test
	def void testDoWhileLoop() {
		'''do while (true)'''.expression.hasNoImplicitReturns
	}

	@Test
	def void testThrow() {
		'''throw new RuntimeException()'''.expression.hasNoImplicitReturns
	}

	@Test
	def void testNumberLiteral() {
		'''1'''.expression.implicitReturn
	}

	@Test
	def void testNullLiteral() {
		'''null'''.expression.implicitReturn
	}

	@Test
	def void testBooleanLiteral() {
		'''true'''.expression.implicitReturn
	}

	@Test
	def void testStringLiteral() {
		'''"foo"'''.expression.implicitReturn
	}

	@Test
	def void testListLiteral() {
		'''"#[]"'''.expression.implicitReturn
	}

	@Test
	def void testSetLiteral() {
		'''"#{}"'''.expression.implicitReturn
	}

	@Test
	def void testFeatureCall() {
		'''"foo.length"'''.expression.implicitReturn
	}

	@Test
	def void testCLosure() {
		'''[]'''.expression.implicitReturn
	}

	@Test
	def void testCast() {
		'''1 as int'''.expression.implicitReturn
	}

	@Test
	def void testInstaceof() {
		'''1 instanceof int'''.expression.implicitReturn
	}

	@Test
	def void testConstructorCall() {
		'''new String'''.expression.implicitReturn
	}

	@Test
	def void testBlock01() {
		val block = '''{1}'''.expression as XBlockExpression
		block.hasImplicitReturns(block.expressions.head)
	}

	@Test
	def void testBlock02() {
		'''{
			val x = "foo"
			return 1
		}'''.expression.hasNoImplicitReturns
	}

	@Test
	def void testSynchronized() {
		val block = '''synchronized (this) {1}'''.expression as XSynchronizedExpression
		block.hasImplicitReturns((block.expression as XBlockExpression).expressions.head)
	}

	@Test
	def void testIf01() {
		val expr = '''if (true) 1 else 2'''.expression as XIfExpression
		expr.hasImplicitReturns(expr.then, expr.^else)
	}

	@Test
	def void testIf02() {
		'''if (true) return 1 else return 2'''.expression.hasNoImplicitReturns
	}

	@Test
	def void testSwitch01() {
		val expr = '''switch (this) case String: 1 default: 2'''.expression as XSwitchExpression
		expr.hasImplicitReturns(expr.cases.head.then, expr.^default)
	}

	@Test
	def void testSwitch02() {
		val expr = '''switch (this) case String: return 1 default: return 2'''.expression as XSwitchExpression
		expr.hasNoImplicitReturns
	}
	
	@Test
	def void testTryCatch() {
		val expr = '''try 1 catch(Exception e) 2'''.expression as XTryCatchFinallyExpression
		expr.hasImplicitReturns(expr.expression, expr.catchClauses.head.expression)
	}

	@Test
	def void testTryCatch02() {
		'''try return 1 catch(Exception e) return 2'''.expression.hasNoImplicitReturns
	}

	def void hasNoImplicitReturns(XExpression expression) {
		val returns = newArrayList
		expression.findImplicitReturns[returns.add(it)]
		assertTrue('''Expected «expression» to have no implicit returns, but it had «returns»''', returns.empty)
	}

	def void hasImplicitReturns(XExpression expression, XExpression... expectedReturns) {
		val returns = newArrayList
		expression.findImplicitReturns[returns.add(it)]
		assertArrayEquals(expectedReturns, returns)
	}
	
	def void isImplicitReturn(XExpression expression) {
		hasImplicitReturns(expression, expression)
	}
}
