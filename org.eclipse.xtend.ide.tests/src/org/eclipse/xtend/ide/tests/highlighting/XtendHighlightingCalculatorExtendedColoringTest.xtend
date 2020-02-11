/*******************************************************************************
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.highlighting

import com.google.inject.Inject
import org.eclipse.xtend.ide.common.highlighting.XtendHighlightingStyles
import org.eclipse.xtend.ide.tests.AbstractXtendTestCase
import org.junit.After
import org.junit.Before
import org.junit.Test

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
	def void testAbstractClass() {
		classDefString = "abstract class Foo"
		expectAbstractClass(15, 3)
		
		highlight()
	}
	
	@Test
	def void testSimpleInterface() {
		classDefString = "interface Foo"
		expectInterface(10, 3)
		
		highlight()
	}
	
	@Test
	def void testSimpleClassWithTypeVariable() {
		classDefString = "class Foo<Foo>"
		expectClass(6, 3)
		expectTypeVariable(10, 3)
		
		highlight()
	}
	
	@Test
	def void testAbstractClassWithTypeVariable() {
		classDefString = "abstract class Foo<Foo>"
		expectAbstractClass(15, 3)
		expectTypeVariable(19, 3)
		
		highlight()
	}
	
	@Test
	def void testSimpleInterfaceWithTypeVariable() {
		classDefString = "interface Foo<Foo>"
		expectInterface(10, 3)
		expectTypeVariable(14, 3)
		
		highlight()
	}
	
	@Test
	def void testExtendedInterfaceWithTypeVariable() {
		classDefString = "interface Foo<Foo> extends Iterable<Foo>"
		expectInterface(10, 3)
		expectTypeVariable(14, 3)
		expectInterface(classDefString.indexOf('Iterable'), 8)
		expectTypeVariable(classDefString.lastIndexOf('Foo'), 3)
		
		highlight()
	}
	
	@Test
	def void testExtendedInterfaceWithTypeArg() {
		classDefString = "interface Foo extends Iterable<Object>"
		expectInterface(10, 3)
		expectInterface(classDefString.indexOf('Iterable'), 8)
		expectClass(classDefString.indexOf('Object'), 6)
		expect(classDefString.indexOf('Object'), 6, TYPE_ARGUMENT)
		
		highlight()
	}
	
	@Test
	def void testThis() {
		helper.strictMode = true
		val model = "{ this }"
		expectClass(6, 3)
		expectMethod(16, 3)
		expectAbsolute(2, 4, KEYWORD_ID)
		
		highlight(model)
	}
	
	@Test
	def void testThisWithClassName() {
		helper.strictMode = true
		val model = "{ Foo.this }"
		expectClass(6, 3)
		expectMethod(16, 3)
		expectClass(prefixLength + 2, 3)
		expectAbsolute(6, 4, KEYWORD_ID)
		
		highlight(model)
	}
	
	@Test
	def void testSuper() {
		helper.strictMode = true
		val model = "{} } class Bar extends Foo { def foo() { super.foo }"
		expectClass(6, 3)
		expectMethod(16, 3)
		expectClass(prefixLength + model.indexOf('Bar'), 3)
		expectClass(prefixLength + model.indexOf('Foo'), 3)
		expectMethod(prefixLength + model.indexOf('foo'), 3)
		expectMethod(prefixLength + model.lastIndexOf('foo'), 3)
		// 'super' is a grammar keyword, so it colored via lexical highlighting
		//  and, hence, a coloring must not be triggered by the semantic highlighting 
		
		highlight(model)
	}
	
	@Test
	def void testSuperWithClassName() {
		helper.strictMode = true
		val model = "{} } class Bar extends Foo { def foo() { Bar.super.foo }"
		expectClass(6, 3)
		expectMethod(16, 3)
		expectClass(prefixLength + model.indexOf('Bar'), 3)
		expectClass(prefixLength + model.indexOf('Foo'), 3)
		expectMethod(prefixLength + model.indexOf('foo'), 3)
		expectClass(prefixLength + model.lastIndexOf('Bar'), 3)
		expectMethod(prefixLength + model.lastIndexOf('foo'), 3)
		// 'super' is a grammar keyword, so it colored via lexical highlighting
		//  and, hence, a coloring must not be triggered by the semantic highlighting 
		
		highlight(model)
	}
	
	@Test
	def void testSimpleClassConstructor() {
		val model = "{ new Foo() }"
		expectClass(6, 3)
		expectClass(prefixLength + model.indexOf("Foo"), 3)
		
		highlight(model)
	}
	
	@Test
	def void testSimpleClassDelegatingConstructorCall() {
		helper.strictMode = true
		val model = "{ new Foo() } new(Object o) { this }"
		expectClass(6, 3)
		expectMethod(16, 3)
		expectClass(prefixLength + model.indexOf("Foo"), 3)
		expectClass(prefixLength + model.indexOf("Object"), 6)
		expectAbsolute(model.indexOf("o)"), 1, PARAMETER_VARIABLE)
		expectAbsolute(model.indexOf("this"), 4, KEYWORD_ID)
		
		highlight(model)
	}
	
	@Test
	def void testSimpleClassDelegatingConstructorCallWithClassName() {
		helper.strictMode = true
		val model = "{ new Foo() } new(Object o) { Foo.this }"
		expectClass(6, 3)
		expectMethod(16, 3)
		expectClass(prefixLength + model.indexOf("Foo"), 3)
		expectClass(prefixLength + model.indexOf("Object"), 6)
		expectAbsolute(model.indexOf("o)"), 1, PARAMETER_VARIABLE)
		expectAbsolute(model.indexOf("this"), 4, KEYWORD_ID)
		expectClass(prefixLength + model.lastIndexOf("Foo"), 3)
		
		highlight(model)
	}
	
	@Test
	def void testSuperClassConstructorCall() {
		helper.strictMode = true
		val model = "{} } class Bar extends Foo { new() { super }"
		expectClass(6, 3)
		expectMethod(16, 3)
		expectClass(prefixLength + model.indexOf('Bar'), 3)
		expectClass(prefixLength + model.indexOf('Foo'), 3)
		// 'super' is a grammar keyword, so it colored via lexical highlighting
		//  and, hence, a coloring must not be triggered by the semantic highlighting 
		
		highlight(model)
	}
	
	@Test
	def void testSuperClassConstructorCallWithClassName() {
		helper.strictMode = true
		val model = "{} } class Bar extends Foo { new() { Bar.super }"
		expectClass(6, 3)
		expectMethod(16, 3)
		expectClass(prefixLength + model.indexOf('Bar'), 3)
		expectClass(prefixLength + model.indexOf('Foo'), 3)
		expectClass(prefixLength + model.lastIndexOf('Bar'), 3)
		// 'super' is a grammar keyword, so it colored via lexical highlighting
		//  and, hence, a coloring must not be triggered by the semantic highlighting 
		
		highlight(model)
	}
		@Test
	def void testAbstractClassConstructor() {
		classDefString = "abstract class Foo"
		val model = "{ new Foo() } new() {}"
		expectAbstractClass(15, 3)
		expectAbstractClass(prefixLength + model.indexOf("Foo"), 3)
		
		highlight(model)
	}
	
	@Test
	def void testAbstractClassImplicitConstructor() {
		classDefString = "abstract class Foo"
		val model = "{ new Foo() }"
		expectAbstractClass(15, 3)
		expectAbstractClass(prefixLength + model.indexOf("Foo"), 3)
		
		highlight(model)
	}
	
	@Test
	def void testAbstractClassAnonymousClassImplicitConstructor() {
		classDefString = "abstract class Foo"
		val model = "{ new Foo() {} }"
		expectAbstractClass(15, 3)
		expectAbstractClass(prefixLength + model.indexOf("Foo"), 3)
		
		highlight(model)
	}
	
	@Test
	def void testAbstractClassAnonymousClassConstructor() {
		classDefString = "abstract class Foo"
		val model = "{ new Foo() {} } new() {}"
		expectAbstractClass(15, 3)
		expectAbstractClass(prefixLength + model.indexOf("Foo"), 3)
		
		highlight(model)
	}
	
	@Test
	def void testInterfaceAnonymousClassConstructor() {
		val model = "{ new Bar() {} } interface Bar {}"
		expectClass(6, 3)
		expectInterface(prefixLength + model.indexOf("Bar"), 3)
		expectInterface(prefixLength + model.lastIndexOf("Bar"), 3)
		
		highlight(model)
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
		expectAbsolute(model.indexOf('x'), 1, LOCAL_VARIABLE_DECLARATION)
		expectAbsolute(model.indexOf('x'), 1, LOCAL_FINAL_VARIABLE_DECLARATION)
		expectAbsolute(model.lastIndexOf('x'), 1, LOCAL_VARIABLE)
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
		expectAbsolute(model.indexOf('x'), 1, LOCAL_VARIABLE_DECLARATION)
		expectAbsolute(model.indexOf('x'), 1, LOCAL_FINAL_VARIABLE_DECLARATION)
		expectAbsolute(model.lastIndexOf('x'), 1, LOCAL_VARIABLE)
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
		expectAbsolute(model.indexOf("println"), 7, METHOD)
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
		expectAbsolute(model.indexOf('i'), 1, LOCAL_VARIABLE_DECLARATION)
		expectAbsolute(model.indexOf('i'), 1, LOCAL_FINAL_VARIABLE_DECLARATION)
		highlight(model)
	}
	
	@Test
	def void testTELoopParameter() {
		val model = "''' «FOR i: 0..42» «ENDFOR» '''"
		expectAbsolute(model.indexOf('i'), 1, LOCAL_VARIABLE_DECLARATION)
		expectAbsolute(model.indexOf('i'), 1, LOCAL_FINAL_VARIABLE_DECLARATION)
		highlight(model)
	}
	
	@Test
	def void testSwitchParameter() {
		val model = "{ switch( i: 0..47) { default: { } } }"
		expectAbsolute(model.indexOf('i:'), 1, LOCAL_VARIABLE_DECLARATION)
		expectAbsolute(model.indexOf('i:'), 1, LOCAL_FINAL_VARIABLE_DECLARATION)
		highlight(model)
	}
	
	@Test
	def void testMethodCallWithTypeArg() {
		val model = "{ <Object>newArrayList() }"
		expectAbsolute(model.indexOf('Object'), 6, CLASS)
		expectAbsolute(model.indexOf('Object'), 6, TYPE_ARGUMENT)
		expectAbsolute(model.indexOf('newArrayList'), 12, METHOD)
		expectAbsolute(model.indexOf('newArrayList'), 12, STATIC_METHOD_INVOCATION)
		highlight(model)
	}
	
	@Test
	def void testFieldDeclWithTypeArg() {
		val model = "{ } Iterable<Object> foo"
		expectAbsolute(model.indexOf('Iterable'), 8, INTERFACE)
		expectAbsolute(model.indexOf('Object'), 6, CLASS)
		expectAbsolute(model.indexOf('Object'), 6, TYPE_ARGUMENT)
		expectAbsolute(model.indexOf('foo'), 3, FIELD)
		highlight(model)
	}
		
	@Test
	def void testConstructorCallWithTypeArg() {
		val model = "{ new Iterable<Object>{} }"
		expectAbsolute(model.indexOf('Iterable'), 8, INTERFACE)
		expectAbsolute(model.indexOf('Object'), 6, CLASS)
		expectAbsolute(model.indexOf('Object'), 6, TYPE_ARGUMENT)
		highlight(model)
	}
}