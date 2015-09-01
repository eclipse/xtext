/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.xtend.core.tests.macro.declaration

import com.google.inject.Inject
import org.eclipse.xtend.core.macro.ConstantExpressionsInterpreter
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtext.common.types.JvmEnumerationLiteral
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation
import org.eclipse.xtext.xbase.interpreter.ConstantExpressionEvaluationException
import org.eclipse.xtext.xbase.resource.BatchLinkableResource
import org.junit.Test
import test.Constants1

/**
 * @author Sven Efftinge
 */
class ConstantExpressionsInterpreterTest extends AbstractXtendTestCase {
	
	@Inject ConstantExpressionsInterpreter interpreter
	
	@Test def void testAnnotationValues() {
		val file = file('''
			@test.Annotation(annotation2Value=@test.Annotation2('foo'))
			class C { 
			}
		''')
		val pair = file.xtendTypes.head.annotations.head.elementValuePairs.head
		val anno = interpreter.evaluate(pair.value, pair.element.returnType) as XAnnotation
		assertEquals("test.Annotation2", anno.annotationType.identifier)
	}
	
	@Test def void testEnumLiteral_WithStaticImport() {
		val file = file('''
			import static test.Enum1.* 
			class C { 
				Enum1 testFoo = RED
			}
		''')
		val field = file.xtendTypes.head.members.filter(XtendField).head
		val blue = interpreter.evaluate(field.initialValue, field.type) as JvmEnumerationLiteral
		assertEquals("RED", blue.simpleName)
	}
	
	@Test def void testNonConstant() {
		val file = file('''
			class C { 
				public final static Class<?> REF = D.testFoo;
			}
			
			class D {
				public final static Class<?> testFoo = Object
			}
		''')
		// make sure the full resolution happened, so the constant values are set on the fields
		(file.eResource as BatchLinkableResource).resolveLazyCrossReferences(null)
		
		val field = file.xtendTypes.head.members.filter(XtendField).head
		try {
			interpreter.evaluate(field.initialValue, field.type)
			fail("exception expected")
		} catch (ConstantExpressionEvaluationException e) {
			// expected
		}
	}
	
	@Test def void testConstants_WithStaticImport() {
		val file = file('''
			import static test.Constants1.* 
			class C { 
				val someString = STRING_CONSTANT
				val someInt = INT_CONSTANT
			}
		''')
		val stringField = file.xtendTypes.head.members.filter(XtendField).head
		val intField = file.xtendTypes.head.members.filter(XtendField).get(1)
		assertEquals(Constants1.STRING_CONSTANT, interpreter.evaluate(stringField.initialValue, null))
		assertEquals(Constants1.INT_CONSTANT, interpreter.evaluate(intField.initialValue, null))
	}
	
	@Test def void testConstants_WithStaticImport_01() {
		val file = file('''
			import static test.Constants1.* 
			import static MyConstants.*
			
			class C { 
				val someString = STRING_CONSTANT+'-'+MY_CONST
			}
			class MyConstants {
				static val MY_CONST = STRING_CONSTANT
			}
		''')
		val stringField = file.xtendTypes.head.members.filter(XtendField).head
		assertEquals(Constants1.STRING_CONSTANT+'-'+Constants1.STRING_CONSTANT, interpreter.evaluate(stringField.initialValue, null))
	}
	
	@Test def void testConstants_RecursionFails() {
		val file = file('''
			import static MyConstants.*
			
			class C { 
				val someString = MY_CONST
			}
			class MyConstants {
				static val MY_CONST = STRING_CONSTANT
				static val STRING_CONSTANT = MY_CONST
			}
		''')
		val stringField = file.xtendTypes.head.members.filter(XtendField).head
		try {
			println(interpreter.evaluate(stringField.initialValue, null))
			fail('Exception expected')
		} catch (ConstantExpressionEvaluationException e) {
			// expected
		}
	}
	
	@Test def void testOperators() {
		assertEvaluatesTo( 1 === 2 , '1'->'int', '2'->'int', '===')
		assertEvaluatesTo( true , '1'->'int', '1'->'byte', '===')
		assertEvaluatesTo( true , '1'->'int', '1'->'float', '===')
		assertEvaluatesTo( true , '1'->'int', '1'->'long', '===')
		assertEvaluatesTo( true , '1'->'int', '1'->'double', '===')
		
		assertEvaluatesTo( true , '1'->'int', '1'->'byte', '<=')
		assertEvaluatesTo( true , '1'->'int', '1'->'float', '<=')
		assertEvaluatesTo( true , '1'->'int', '1'->'long', '<=')
		assertEvaluatesTo( true , '1'->'int', '1'->'double', '<=')
		
		assertEvaluatesTo( true , '1'->'int', '1'->'byte', '>=')
		assertEvaluatesTo( true , '1'->'int', '1'->'float', '>=')
		assertEvaluatesTo( true , '1'->'int', '1'->'long', '>=')
		assertEvaluatesTo( true , '1'->'int', '1'->'double', '>=')
		
		assertEvaluatesTo( false , '1'->'int', '1'->'byte', '!==')
		assertEvaluatesTo( false , '1'->'int', '1'->'float', '!==')
		assertEvaluatesTo( false , '1'->'int', '1'->'long', '!==')
		assertEvaluatesTo( false , '1'->'int', '1'->'double', '!==')
		
		assertEvaluatesTo( false , '1'->'int', '1'->'byte', '<')
		assertEvaluatesTo( false , '1'->'int', '1'->'float', '<')
		assertEvaluatesTo( false , '1'->'int', '1'->'long', '<')
		assertEvaluatesTo( false , '1'->'int', '1'->'double', '<')
		
		assertEvaluatesTo( false , '1'->'int', '1'->'byte', '>')
		assertEvaluatesTo( false , '1'->'int', '1'->'float', '>')
		assertEvaluatesTo( false , '1'->'int', '1'->'long', '>')
		assertEvaluatesTo( false , '1'->'int', '1'->'double', '>')
	}
	
	@Test def void testOperatorsWithExpectation() {
		('boolean'->'1 + 1').evaluatesTo(2)
		('boolean'->'1 - 1').evaluatesTo(0)
		('boolean'->'1 * 1').evaluatesTo(1)
		('boolean'->'1 / 1').evaluatesTo(1)
		('boolean'->'1 % 1').evaluatesTo(0)
		('boolean'->'1 < 1').evaluatesTo(false)
		('boolean'->'1 <= 1').evaluatesTo(true)
		('boolean'->'1 > 1').evaluatesTo(false)
		('boolean'->'1 >= 1').evaluatesTo(true)
		('boolean'->'1 == 1').evaluatesTo(true)
		('boolean'->'1 != 1').evaluatesTo(false)
		('boolean'->'1 === 1').evaluatesTo(true)
		('boolean'->'1 !== 1').evaluatesTo(false)
	}
	
	protected def void assertEvaluatesTo(Object expectation, Pair<String,String> left, Pair<String,String> right, String op) {
		val file = file('''
			import static MyConstants.*
			
			class C { 
				static val result = A «op» B
			}
			class MyConstants {
				static val «left.value» A = «left.key» as «left.value»
				static val «right.value» B = «right.key» as «right.value»
			}
		''')
		val stringField = file.xtendTypes.head.members.filter(XtendField).head
		assertEquals(expectation, interpreter.evaluate(stringField.initialValue, null))
	}
	
	@Test def void testEnumLiteral() {
		'test.Enum1.YELLOW'.evaluatesTo [
			assertEquals("YELLOW", (it as JvmEnumerationLiteral).simpleName)
		] 
		'#[test.Enum1.YELLOW,test.Enum1.RED]'.evaluatesTo [
			assertEquals("YELLOW", (it as JvmEnumerationLiteral[]).get(0).simpleName)
		] 
	}
	
	@Test def void testConstantsReference() {
		'test.Constants1.STRING_CONSTANT'.evaluatesTo(Constants1.STRING_CONSTANT)
		'test.Constants1.INT_CONSTANT'.evaluatesTo(Constants1.INT_CONSTANT)
	}
	
	@Test def void testBooleanLiteral() {
		'true'.evaluatesTo(true)
		'false'.evaluatesTo(false)
		'true && true'.evaluatesTo(true)
		'true && false'.evaluatesTo(false)
		'false && true'.evaluatesTo(false)
		'false && false'.evaluatesTo(false)
		'true || true'.evaluatesTo(true)
		'true || false'.evaluatesTo(true)
		'false || true'.evaluatesTo(true)
		'false || false'.evaluatesTo(false)
		'!true'.evaluatesTo(false)
		'!false'.evaluatesTo(true)
		'42 > 5'.evaluatesTo(true)
		'42 >= 5'.evaluatesTo(true)
		'42 === 5'.evaluatesTo(false)
		'42 !== 5'.evaluatesTo(true)
		'42 < 5'.evaluatesTo(false)
		'42 <= 5'.evaluatesTo(false)
	}
	
	@Test def void testStringLiteral() {
		'"foo"'.evaluatesTo('foo')
		'"fo"+"o"'.evaluatesTo('foo')
		'"fo"+2'.evaluatesTo('fo2')
	}
	
	@Test def void testStringArrayLiteral() {
		'#["foo","bar"]'.evaluatesTo [
			assertEquals('bar', (it as String[]).get(1))
		]
		'#["foo","b"+"a"+"r"]'.evaluatesTo[
			assertEquals('bar', (it as String[]).get(1))
		]
	}
	
	@Test def void testClassLiteral() {
		val assertion = [
			assertTrue(it instanceof JvmTypeReference)
			assertEquals('java.lang.String', (it as JvmTypeReference).identifier)
		]
		'typeof(String)'.evaluatesTo(assertion) 
		'String'.evaluatesTo(assertion) 
		'java.lang.String'.evaluatesTo(assertion) 
	}
	
	@Test def void testClassLiteralArray() {
		val assertion = [
			assertTrue(it instanceof JvmTypeReference[])
			assertEquals('java.lang.String', (it as JvmTypeReference[]).get(0).identifier)
			assertEquals('java.lang.Class', (it as JvmTypeReference[]).get(1).identifier)
		]
		'#[typeof(String), typeof(Class)]'.evaluatesTo(assertion) 
		'#[String,Class]'.evaluatesTo(assertion) 
		'#[java.lang.String, java.lang.Class]'.evaluatesTo(assertion) 
		'#[typeof(String), Class]'.evaluatesTo(assertion) 
	}
	
	@Test def void testNumberLiteralWithExpectation() {
		('float'->'1').evaluatesTo(1f)
		('double'->'1').evaluatesTo(1d)
		('long'->'1').evaluatesTo(1l)
	}
	
	@Test def void testError() {
		'1.intValue'.evaluatesWithException[]
		'String.name'.evaluatesWithException[]
		'if (true) 2 else 3'.evaluatesWithException[]
		'for (x : 1..3) { println("foo") }'.evaluatesWithException[]
	}
	
	protected def void evaluatesWithException(String expression, (ConstantExpressionEvaluationException)=>void exceptionAssertions) {
		val function = function('def void testFoo() { '+expression+' }')
		val expr = (function.expression as XBlockExpression).expressions.head
		try {
			interpreter.evaluate(expr, null)
			fail('exception expected')
		} catch (ConstantExpressionEvaluationException e) {
			exceptionAssertions.apply(e)
		}
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
		val function = function('def '+(type?:'void')+' testFoo() { '+expression+' }')
		val expr = (function.expression as XBlockExpression).expressions.head
		val value = interpreter.evaluate(expr, if (type!=null) function.returnType)
		assertions.apply(value)
	}
}