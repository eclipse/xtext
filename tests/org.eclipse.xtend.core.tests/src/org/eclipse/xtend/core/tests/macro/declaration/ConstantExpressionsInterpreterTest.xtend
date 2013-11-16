package org.eclipse.xtend.core.tests.macro.declaration

import com.google.inject.Inject
import org.eclipse.xtend.core.macro.ConstantExpressionsInterpreter
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.xbase.XBlockExpression
import org.junit.Test

class ConstantExpressionsInterpreterTest extends AbstractXtendTestCase {
	
	@Inject ConstantExpressionsInterpreter interpreter
	
	@Test def void testBooleanLiteral() {
		val function = function('@test.Annotation(booleanValue=true) def void testFoo() {}')
		assertTrue(interpreter.evaluate(function.annotations.head.elementValuePairs.head.value).result as Boolean)
	}
	
	@Test def void testStringLiteral() {
		val function = function('@Foo("foo") def void testFoo() {}')
		assertEquals('foo', interpreter.evaluate(function.annotations.head.value).result)
	}
	
	@Test def void testStringAdditionLiteral() {
		val function = function('@Foo(("foo" + "bar")) def void testFoo() {}')
		assertEquals('foobar', interpreter.evaluate(function.annotations.head.value).result)
	}
	
	@Test def void testStringArrayLiteral() {
		val function = function('@test.Annotation(stringArrayValue=#["foo","bar"]) def void testFoo() {}')
		assertEquals('bar', (interpreter.evaluate(function.annotations.head.elementValuePairs.head.value).result as String[]).get(1))
	}
	
	@Test def void testStringArrayLiteral_01() {
		val function = function('@test.Annotation(stringArrayValue=#["foo","b"+"a"+"r"]) def void testFoo() {}')
		assertEquals('bar', (interpreter.evaluate(function.annotations.head.elementValuePairs.head.value).result as String[]).get(1))
	}
	
	@Test def void testNumberLiteral_long() {
		val function = function('def long testFoo() { 1 }')
		val numberLiteral = (function.expression as XBlockExpression).expressions.head
		val value = interpreter.evaluate(numberLiteral).result
		assertEquals(typeof(Long), value.class)
	}
	
	@Test def void testNumberLiteral_double() {
		val function = function('def double testFoo() { 1 }')
		val numberLiteral = (function.expression as XBlockExpression).expressions.head
		val value = interpreter.evaluate(numberLiteral).result
		assertEquals(typeof(Double), value.class)
	}
	
	@Test def void testNumberLiteral_float() {
		val function = function('def float testFoo() { 1 }')
		val numberLiteral = (function.expression as XBlockExpression).expressions.head
		val value = interpreter.evaluate(numberLiteral).result
		assertEquals(typeof(Float), value.class)
	}
}