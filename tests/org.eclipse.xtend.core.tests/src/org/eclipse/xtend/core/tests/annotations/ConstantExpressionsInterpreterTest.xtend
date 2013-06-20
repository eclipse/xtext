package org.eclipse.xtend.core.tests.annotations

import com.google.inject.Inject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.xbase.annotations.interpreter.ConstantExpressionsInterpreter
import org.junit.Test
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner
import org.eclipse.xtext.xbase.typesystem.references.UnknownTypeReference

class ConstantExpressionsInterpreterTest extends AbstractXtendTestCase {
	
	@Inject ConstantExpressionsInterpreter interpreter
	
	@Inject CommonTypeComputationServices services
	
	@Test def void testBooleanLiteral() {
		val function = function('@Foo(true) def void testFoo() {}')
		assertTrue(interpreter.evaluate(function.annotations.head.value, null) as Boolean)
	}
	
	@Test def void testStringLiteral() {
		val function = function('@Foo("foo") def void testFoo() {}')
		assertEquals('foo', interpreter.evaluate(function.annotations.head.value, null))
	}
	
	@Test def void testStringAdditionLiteral() {
		val function = function('@Foo(("foo" + "bar")) def void testFoo() {}')
		assertEquals('foobar', interpreter.evaluate(function.annotations.head.value, null))
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
	
	@Test def void testNumberLiteral_long() {
		val function = function('def void testFoo() { 1 }')
		val numberLiteral = (function.expression as XBlockExpression).expressions.head
		val owner = new StandardTypeReferenceOwner(services, function)
		val pseudo = new UnknownTypeReference(owner, 'long')
		val value = interpreter.evaluate(numberLiteral, pseudo)
		assertEquals(typeof(Long), value.class)
	}
	
	@Test def void testNumberLiteral_double() {
		val function = function('def void testFoo() { 1 }')
		val numberLiteral = (function.expression as XBlockExpression).expressions.head
		val owner = new StandardTypeReferenceOwner(services, function)
		val pseudo = new UnknownTypeReference(owner, 'double')
		val value = interpreter.evaluate(numberLiteral, pseudo)
		assertEquals(typeof(Double), value.class)
	}
	
	@Test def void testNumberLiteral_float() {
		val function = function('def void testFoo() { 1 }')
		val numberLiteral = (function.expression as XBlockExpression).expressions.head
		val owner = new StandardTypeReferenceOwner(services, function)
		val pseudo = new UnknownTypeReference(owner, 'float')
		val value = interpreter.evaluate(numberLiteral, pseudo)
		assertEquals(typeof(Float), value.class)
	}
}