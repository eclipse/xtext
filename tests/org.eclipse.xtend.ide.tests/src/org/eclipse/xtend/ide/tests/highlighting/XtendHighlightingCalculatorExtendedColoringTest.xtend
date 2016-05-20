/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.highlighting

import com.google.inject.Inject
import org.eclipse.xtend.ide.common.highlighting.XtendHighlightingStyles
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.eclipse.xtend.core.tests.AbstractXtendTestCase

/**
 * @author Christian Schneider - Initial contribution and API
 */
class XtendHighlightingCalculatorExtendedColoringTest extends AbstractXtendTestCase implements XtendHighlightingStyles {

	@Inject
	extension XtendHighlightingCalculatorTest helper
	
	@Before
	def void setUp() throws Exception {
		helper.setUp()
	}
	
	@After
	def void tearDown() throws Exception {
		helper.tearDown()
	}

	def void expectAbstractClass(int offset, int length) {
		expect(offset, length, ABSTRACT_CLASS)
	}
	
	def void expectClass(int offset, int length) {
		expect(offset, length, CLASS)
	}
	
	def void expectInterface(int offset, int length) {
		expect(offset, length, INTERFACE)
	}
	
	def void expectTypeArgument(int offset, int length) {
		expectAbsolute(offset, length, TYPE_ARGUMENT)
	}

	def void expectTypeVariable(int offset, int length) {
		expect(offset, length, TYPE_VARIABLE)
	}
	
	def highlight() {
		highlight('')
	}
	
	@Test
	def void testSimpleClass() {
		classDefString = "class Foo"
		expectClass(6, 3)
		
		highlight()
	}
	
	@Test
	def void testSimpleInterface() {
		classDefString = "interface Foo"
		expectInterface(10, 3)
		
		highlight()
	}
	
	@Test
	def void testSimpleTypeWithTypeVariable() {
		classDefString = "class Foo<Foo>"
		expectClass(6, 3)
		expectTypeVariable(10, 3)
		
		highlight()
	}
	
	@Test
	def void testMethodParam() {
		val model = "{} def foo(int x) {}"
		expectMethod(prefixLength + model.indexOf('foo'), 3)
		expectAbsolute(model.indexOf("x"), 1, PARAMETER_VARIABLE)

		highlight(model)
	}
	
	@Test
	def void testMethodParamReference() {
		val model = "{} def foo(int x) { x }"
		expectAbsolute(model.indexOf("int"), 3, KEYWORD_ID)
		expectAbsolute(model.indexOf("x"), 1, PARAMETER_VARIABLE)
		expectAbsolute(model.lastIndexOf("x"), 1, PARAMETER_VARIABLE)

		highlight(model)
	}
	
	@Test
	def void testMethodParamIt() {
		val model = "{} def foo(int it) {}"
		expectMethod(prefixLength + model.indexOf('foo'), 3)
		expectAbsolute(model.indexOf("it"), 2, KEYWORD_ID)

		highlight(model)
	}
	
	@Test
	def void testMethodParamItReference() {
		val model = "{} def foo(int it) { it }"
		expectMethod(prefixLength + model.indexOf('foo'), 3)
		expectAbsolute(model.indexOf("it"), 2, KEYWORD_ID)
		expectAbsolute(model.lastIndexOf("it"), 2, KEYWORD_ID)

		highlight(model)
	}
	
	@Test
	def void testLocalVariable() {
		val model = "{ var int x = 1 println(x) }"
		expectAbsolute(model.indexOf('x'), 1, LOCAL_VARIABLE_DECLARATION)
		expectAbsolute(model.lastIndexOf('x'), 1, LOCAL_VARIABLE)
		highlight(model)
	}
	
	@Test
	def void testLocalVariableIt() {
		val model = "{ var int it = 1 println(it) }"
		expectAbsolute(model.indexOf('it'), 2, KEYWORD_ID)
		expectAbsolute(model.lastIndexOf('it'), 2, KEYWORD_ID)
		highlight(model)
	}
	
	@Test
	def void testLocalFinalVariable() {
		val model = "{ val int x = 1 println(x) }"
		expectAbsolute(model.indexOf('x'), 1, LOCAL_FINAL_VARIABLE_DECLARATION)
		expectAbsolute(model.lastIndexOf('x'), 1, LOCAL_FINAL_VARIABLE)
		highlight(model)
	}
	
	@Test
	def void testLocalVariableTE() {
		val model = "''' «{var int x = 1 println(x)}» '''"
		expectAbsolute(model.indexOf('x'), 1, LOCAL_VARIABLE_DECLARATION)
		expectAbsolute(model.lastIndexOf('x'), 1, LOCAL_VARIABLE)
		highlight(model)
	}
	
	@Test
	def void testLocalFinalVariableTE() {
		val model = "''' «{val int x = 1 println(x)}» '''"
		expectAbsolute(model.indexOf('x'), 1, LOCAL_FINAL_VARIABLE_DECLARATION)
		expectAbsolute(model.lastIndexOf('x'), 1, LOCAL_FINAL_VARIABLE)
		highlight(model)
	}
	
	@Test
	def void testImplicitClosureParameter() {
		val model = "{ [ it ] }"
		expectAbsolute(model.indexOf("it"), 2, KEYWORD_ID)
		highlight(model)
	}
	
	@Test
	def void testClosureParameterIt() {
		val model = "{ [ it | println(it) ] }"
		expectAbsolute(model.indexOf("it"), 2, KEYWORD_ID)
		expectAbsolute(model.indexOf("println"), 7, STATIC_METHOD_INVOCATION)
		expectAbsolute(model.lastIndexOf("it"), 2, KEYWORD_ID)
		highlight(model)
	}
	
	@Test
	def void testClosureParameter() {
		val model = "{ [ int x | x ] }"
		expectAbsolute(model.indexOf('int'), 3, KEYWORD_ID)
		expectAbsolute(model.indexOf('x'), 1, PARAMETER_VARIABLE)
		expectAbsolute(model.lastIndexOf('x'), 1, PARAMETER_VARIABLE)
		highlight(model)
	}
	
	@Test
	def void testLoopParameter() {
		val model = "{ for(i: 0..42) { } }"
		expectAbsolute(model.indexOf('i'), 1, LOCAL_FINAL_VARIABLE_DECLARATION)
		highlight(model)
	}
	
	@Test
	def void testTELoopParameter() {
		val model = "''' «FOR i: 0..42» «ENDFOR» '''"
		expectAbsolute(model.indexOf('i'), 1, LOCAL_FINAL_VARIABLE_DECLARATION)
		highlight(model)
	}
	
	@Test
	def void testSwitchParameter() {
		val model = "{ switch( i: 0..47) { default: { } } }"
		expectAbsolute(model.indexOf('i:'), 1, LOCAL_FINAL_VARIABLE_DECLARATION)
		highlight(model)
	}
}