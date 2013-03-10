package org.eclipse.xtend.core.tests.annotations

import com.google.inject.Inject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.xbase.annotations.interpreter.ConstantExpressionsInterpreter
import org.junit.Test
import org.eclipse.xtext.common.types.JvmType

class ConstantExpressionsInterpreterTest extends AbstractXtendTestCase {
	
	@Inject ConstantExpressionsInterpreter interpreter
	
	@Test def void testBooleanLiteral() {
		val function = function('@Foo(true) def void testFoo() {}')
		assertTrue(interpreter.evaluate(function.annotations.head.value, null) as Boolean)
	}
	
	@Test def void testStringLiteral() {
		val function = function('@Foo("foo") def void testFoo() {}')
		assertEquals('foo', interpreter.evaluate(function.annotations.head.value, null))
	}
	
	@Test def void testStringArrayLiteral() {
		val function = function('@Foo(#["foo","bar"]) def void testFoo() {}')
		assertEquals('bar', (interpreter.evaluate(function.annotations.head.value, null) as String[]).get(1))
	}
	
	@Test def void testStringArrayLiteral_01() {
		val function = function('@Foo(#["foo"+"bar","bar"]) def void testFoo() {}')
		assertEquals('bar', (interpreter.evaluate(function.annotations.head.value, null) as String[]).get(1))
	}
	
	@Test def void testTypeLiteral() {
		val function = function('@Foo(typeof(String)) def void testFoo() {}')
		assertEquals('String', (interpreter.evaluate(function.annotations.head.value, null) as JvmType).simpleName)
	}
}