/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.interpreter

import com.google.inject.Inject
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.junit.Test
import org.eclipse.xtext.xbase.interpreter.SwitchConstantExpressionsInterpreter
import org.eclipse.xtext.common.types.JvmEnumerationLiteral

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class SwitchConstantExpressionsInterpreterTest extends AbstractXbaseTestCase {
	
	@Inject SwitchConstantExpressionsInterpreter interpreter
	
	@Test def void testXNumberLiteral() {
		('int'->'1').evaluatesTo(1)
		('short'->'1 as short').evaluatesTo(1)
		('byte'->'1 as byte').evaluatesTo(1)
		('char'->'1 as char').evaluatesTo(1)
	}
	
	@Test def void testXVariableDeclarationCall() {
		val blockExpression = expression('''
		{
			val foo = 1
			val bar = foo
		}
		''') as XBlockExpression
		val variableDeclaration = blockExpression.expressions.get(1) as XVariableDeclaration
		variableDeclaration.evaluatesTo(1)
	}
	
	@Test def void testJvmFieldCall() {
		'interpreter.Foo.FOO'.evaluatesTo(1)
	}
	
	@Test def void testJvmEnumerationLiteral() {
		'Thread.State.NEW'.evaluatesTo[
			assertEquals("NEW", (it as JvmEnumerationLiteral).simpleName)
		] 
	}
	
	@Test def void testXUnaryOperation() {
		'-1'.evaluatesTo(-1)
	}
	
	@Test def void testXBinaryOperation() {
		'(1 + (2 - 3) * (4 / 4))'.evaluatesTo(0)
	}
	
	protected def void evaluatesTo(String expression, Object expectation) {
		evaluatesTo(null->expression, expectation)
	}
	protected def void evaluatesTo(String expression, (Object)=>void assertions) {
		evaluatesTo(null->expression, assertions)
	}
	protected def void evaluatesTo(Pair<String,String> typeAndExpression, Object expectation) {
		evaluatesTo(typeAndExpression) [assertEquals(expectation, it)]
	}
	protected def void evaluatesTo(Pair<String,String> typeAndExpression, (Object)=>void assertions) {
		val type = typeAndExpression.key
		val expression = typeAndExpression.value
		val charSequence = '''
		{
			val«IF type != null» «type»«ENDIF» testFoo = «expression»
		}
		'''
		val blockExpression = expression(charSequence, true) as XBlockExpression
		val variableDeclaration = blockExpression.expressions.head as XVariableDeclaration
		variableDeclaration.evaluatesTo(assertions)
	}
	protected def void evaluatesTo(XVariableDeclaration it,Object expectation) {
		evaluatesTo[assertEquals(expectation, it)]
	}
	protected def void evaluatesTo(XVariableDeclaration it, (Object)=>void assertions) {
		val value = interpreter.evaluate(right)
		assertions.apply(value)
	}
}