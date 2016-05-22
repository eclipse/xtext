/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.highlighting;

import com.google.inject.Inject;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.ide.common.highlighting.XtendHighlightingStyles;
import org.eclipse.xtend.ide.tests.highlighting.XtendHighlightingCalculatorTest;
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;
import org.eclipse.xtext.xbase.ide.highlighting.XbaseHighlightingStyles;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Christian Schneider - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendHighlightingCalculatorExtendedColoringTest extends AbstractXtendTestCase implements XtendHighlightingStyles {
  @Inject
  @Extension
  private XtendHighlightingCalculatorTest helper;
  
  @Before
  public void setUp() throws Exception {
    this.helper.setUp();
  }
  
  @After
  public void tearDown() throws Exception {
    this.helper.tearDown();
  }
  
  public void expectAbstractClass(final int offset, final int length) {
    this.helper.expect(offset, length, XbaseHighlightingStyles.ABSTRACT_CLASS);
  }
  
  public void expectClass(final int offset, final int length) {
    this.helper.expect(offset, length, XbaseHighlightingStyles.CLASS);
  }
  
  public void expectInterface(final int offset, final int length) {
    this.helper.expect(offset, length, XbaseHighlightingStyles.INTERFACE);
  }
  
  public void expectTypeArgument(final int offset, final int length) {
    this.helper.expectAbsolute(offset, length, XbaseHighlightingStyles.TYPE_ARGUMENT);
  }
  
  public void expectTypeVariable(final int offset, final int length) {
    this.helper.expect(offset, length, XbaseHighlightingStyles.TYPE_VARIABLE);
  }
  
  public void highlight() {
    this.helper.highlight("");
  }
  
  @Test
  public void testSimpleClass() {
    this.helper.classDefString = "class Foo";
    this.expectClass(6, 3);
    this.highlight();
  }
  
  @Test
  public void testAbstractClass() {
    this.helper.classDefString = "abstract class Foo";
    this.expectAbstractClass(15, 3);
    this.highlight();
  }
  
  @Test
  public void testSimpleInterface() {
    this.helper.classDefString = "interface Foo";
    this.expectInterface(10, 3);
    this.highlight();
  }
  
  @Test
  public void testSimpleClassWithTypeVariable() {
    this.helper.classDefString = "class Foo<Foo>";
    this.expectClass(6, 3);
    this.expectTypeVariable(10, 3);
    this.highlight();
  }
  
  @Test
  public void testAbstractClassWithTypeVariable() {
    this.helper.classDefString = "abstract class Foo<Foo>";
    this.expectAbstractClass(15, 3);
    this.expectTypeVariable(19, 3);
    this.highlight();
  }
  
  @Test
  public void testSimpleInterfaceWithTypeVariable() {
    this.helper.classDefString = "interface Foo<Foo>";
    this.expectInterface(10, 3);
    this.expectTypeVariable(14, 3);
    this.highlight();
  }
  
  @Test
  public void testThis() {
    this.helper.strictMode = true;
    final String model = "{ this }";
    this.expectClass(6, 3);
    this.helper.expectMethod(16, 3);
    this.helper.expectAbsolute(2, 4, HighlightingStyles.KEYWORD_ID);
    this.helper.highlight(model);
  }
  
  @Test
  public void testThisWithClassName() {
    this.helper.strictMode = true;
    final String model = "{ Foo.this }";
    this.expectClass(6, 3);
    this.helper.expectMethod(16, 3);
    int _prefixLength = this.helper.getPrefixLength();
    int _plus = (_prefixLength + 2);
    this.expectClass(_plus, 3);
    this.helper.expectAbsolute(6, 4, HighlightingStyles.KEYWORD_ID);
    this.helper.highlight(model);
  }
  
  @Test
  public void testSuper() {
    this.helper.strictMode = true;
    final String model = "{} } class Bar extends Foo { def foo() { super.foo }";
    this.expectClass(6, 3);
    this.helper.expectMethod(16, 3);
    int _prefixLength = this.helper.getPrefixLength();
    int _indexOf = model.indexOf("Bar");
    int _plus = (_prefixLength + _indexOf);
    this.expectClass(_plus, 3);
    int _prefixLength_1 = this.helper.getPrefixLength();
    int _indexOf_1 = model.indexOf("Foo");
    int _plus_1 = (_prefixLength_1 + _indexOf_1);
    this.expectClass(_plus_1, 3);
    int _prefixLength_2 = this.helper.getPrefixLength();
    int _indexOf_2 = model.indexOf("foo");
    int _plus_2 = (_prefixLength_2 + _indexOf_2);
    this.helper.expectMethod(_plus_2, 3);
    int _prefixLength_3 = this.helper.getPrefixLength();
    int _lastIndexOf = model.lastIndexOf("foo");
    int _plus_3 = (_prefixLength_3 + _lastIndexOf);
    this.helper.expectMethod(_plus_3, 3);
    this.helper.highlight(model);
  }
  
  @Test
  public void testSuperWithClassName() {
    this.helper.strictMode = true;
    final String model = "{} } class Bar extends Foo { def foo() { Bar.super.foo }";
    this.expectClass(6, 3);
    this.helper.expectMethod(16, 3);
    int _prefixLength = this.helper.getPrefixLength();
    int _indexOf = model.indexOf("Bar");
    int _plus = (_prefixLength + _indexOf);
    this.expectClass(_plus, 3);
    int _prefixLength_1 = this.helper.getPrefixLength();
    int _indexOf_1 = model.indexOf("Foo");
    int _plus_1 = (_prefixLength_1 + _indexOf_1);
    this.expectClass(_plus_1, 3);
    int _prefixLength_2 = this.helper.getPrefixLength();
    int _indexOf_2 = model.indexOf("foo");
    int _plus_2 = (_prefixLength_2 + _indexOf_2);
    this.helper.expectMethod(_plus_2, 3);
    int _prefixLength_3 = this.helper.getPrefixLength();
    int _lastIndexOf = model.lastIndexOf("Bar");
    int _plus_3 = (_prefixLength_3 + _lastIndexOf);
    this.expectClass(_plus_3, 3);
    int _prefixLength_4 = this.helper.getPrefixLength();
    int _lastIndexOf_1 = model.lastIndexOf("foo");
    int _plus_4 = (_prefixLength_4 + _lastIndexOf_1);
    this.helper.expectMethod(_plus_4, 3);
    this.helper.highlight(model);
  }
  
  @Test
  public void testSimpleClassConstructor() {
    final String model = "{ new Foo() }";
    this.expectClass(6, 3);
    int _prefixLength = this.helper.getPrefixLength();
    int _indexOf = model.indexOf("Foo");
    int _plus = (_prefixLength + _indexOf);
    this.expectClass(_plus, 3);
    this.helper.highlight(model);
  }
  
  @Test
  public void testSimpleClassDelegatingConstructorCall() {
    this.helper.strictMode = true;
    final String model = "{ new Foo() } new(Object o) { this }";
    this.expectClass(6, 3);
    this.helper.expectMethod(16, 3);
    int _prefixLength = this.helper.getPrefixLength();
    int _indexOf = model.indexOf("Foo");
    int _plus = (_prefixLength + _indexOf);
    this.expectClass(_plus, 3);
    int _prefixLength_1 = this.helper.getPrefixLength();
    int _indexOf_1 = model.indexOf("Object");
    int _plus_1 = (_prefixLength_1 + _indexOf_1);
    this.expectClass(_plus_1, 6);
    int _indexOf_2 = model.indexOf("o)");
    this.helper.expectAbsolute(_indexOf_2, 1, XbaseHighlightingStyles.PARAMETER_VARIABLE);
    int _indexOf_3 = model.indexOf("this");
    this.helper.expectAbsolute(_indexOf_3, 4, HighlightingStyles.KEYWORD_ID);
    this.helper.highlight(model);
  }
  
  @Test
  public void testSimpleClassDelegatingConstructorCallWithClassName() {
    this.helper.strictMode = true;
    final String model = "{ new Foo() } new(Object o) { Foo.this }";
    this.expectClass(6, 3);
    this.helper.expectMethod(16, 3);
    int _prefixLength = this.helper.getPrefixLength();
    int _indexOf = model.indexOf("Foo");
    int _plus = (_prefixLength + _indexOf);
    this.expectClass(_plus, 3);
    int _prefixLength_1 = this.helper.getPrefixLength();
    int _indexOf_1 = model.indexOf("Object");
    int _plus_1 = (_prefixLength_1 + _indexOf_1);
    this.expectClass(_plus_1, 6);
    int _indexOf_2 = model.indexOf("o)");
    this.helper.expectAbsolute(_indexOf_2, 1, XbaseHighlightingStyles.PARAMETER_VARIABLE);
    int _indexOf_3 = model.indexOf("this");
    this.helper.expectAbsolute(_indexOf_3, 4, HighlightingStyles.KEYWORD_ID);
    int _prefixLength_2 = this.helper.getPrefixLength();
    int _lastIndexOf = model.lastIndexOf("Foo");
    int _plus_2 = (_prefixLength_2 + _lastIndexOf);
    this.expectClass(_plus_2, 3);
    this.helper.highlight(model);
  }
  
  @Test
  public void testSuperClassConstructorCall() {
    this.helper.strictMode = true;
    final String model = "{} } class Bar extends Foo { new() { super }";
    this.expectClass(6, 3);
    this.helper.expectMethod(16, 3);
    int _prefixLength = this.helper.getPrefixLength();
    int _indexOf = model.indexOf("Bar");
    int _plus = (_prefixLength + _indexOf);
    this.expectClass(_plus, 3);
    int _prefixLength_1 = this.helper.getPrefixLength();
    int _indexOf_1 = model.indexOf("Foo");
    int _plus_1 = (_prefixLength_1 + _indexOf_1);
    this.expectClass(_plus_1, 3);
    this.helper.highlight(model);
  }
  
  @Test
  public void testSuperClassConstructorCallWithClassName() {
    this.helper.strictMode = true;
    final String model = "{} } class Bar extends Foo { new() { Bar.super }";
    this.expectClass(6, 3);
    this.helper.expectMethod(16, 3);
    int _prefixLength = this.helper.getPrefixLength();
    int _indexOf = model.indexOf("Bar");
    int _plus = (_prefixLength + _indexOf);
    this.expectClass(_plus, 3);
    int _prefixLength_1 = this.helper.getPrefixLength();
    int _indexOf_1 = model.indexOf("Foo");
    int _plus_1 = (_prefixLength_1 + _indexOf_1);
    this.expectClass(_plus_1, 3);
    int _prefixLength_2 = this.helper.getPrefixLength();
    int _lastIndexOf = model.lastIndexOf("Bar");
    int _plus_2 = (_prefixLength_2 + _lastIndexOf);
    this.expectClass(_plus_2, 3);
    this.helper.highlight(model);
  }
  
  @Test
  public void testAbstractClassConstructor() {
    this.helper.classDefString = "abstract class Foo";
    final String model = "{ new Foo() } new() {}";
    this.expectAbstractClass(15, 3);
    int _prefixLength = this.helper.getPrefixLength();
    int _indexOf = model.indexOf("Foo");
    int _plus = (_prefixLength + _indexOf);
    this.expectAbstractClass(_plus, 3);
    this.helper.highlight(model);
  }
  
  @Test
  public void testAbstractClassImplicitConstructor() {
    this.helper.classDefString = "abstract class Foo";
    final String model = "{ new Foo() }";
    this.expectAbstractClass(15, 3);
    int _prefixLength = this.helper.getPrefixLength();
    int _indexOf = model.indexOf("Foo");
    int _plus = (_prefixLength + _indexOf);
    this.expectAbstractClass(_plus, 3);
    this.helper.highlight(model);
  }
  
  @Test
  public void testAbstractClassAnonymousClassImplicitConstructor() {
    this.helper.classDefString = "abstract class Foo";
    final String model = "{ new Foo() {} }";
    this.expectAbstractClass(15, 3);
    int _prefixLength = this.helper.getPrefixLength();
    int _indexOf = model.indexOf("Foo");
    int _plus = (_prefixLength + _indexOf);
    this.expectAbstractClass(_plus, 3);
    this.helper.highlight(model);
  }
  
  @Test
  public void testAbstractClassAnonymousClassConstructor() {
    this.helper.classDefString = "abstract class Foo";
    final String model = "{ new Foo() {} } new() {}";
    this.expectAbstractClass(15, 3);
    int _prefixLength = this.helper.getPrefixLength();
    int _indexOf = model.indexOf("Foo");
    int _plus = (_prefixLength + _indexOf);
    this.expectAbstractClass(_plus, 3);
    this.helper.highlight(model);
  }
  
  @Test
  public void testInterfaceAnonymousClassConstructor() {
    final String model = "{ new Bar() {} } interface Bar {}";
    this.expectClass(6, 3);
    int _prefixLength = this.helper.getPrefixLength();
    int _indexOf = model.indexOf("Bar");
    int _plus = (_prefixLength + _indexOf);
    this.expectInterface(_plus, 3);
    int _prefixLength_1 = this.helper.getPrefixLength();
    int _lastIndexOf = model.lastIndexOf("Bar");
    int _plus_1 = (_prefixLength_1 + _lastIndexOf);
    this.expectInterface(_plus_1, 3);
    this.helper.highlight(model);
  }
  
  @Test
  public void testMethodParam() {
    final String model = "{} def foo(int x) {}";
    int _prefixLength = this.helper.getPrefixLength();
    int _indexOf = model.indexOf("foo");
    int _plus = (_prefixLength + _indexOf);
    this.helper.expectMethod(_plus, 3);
    int _indexOf_1 = model.indexOf("x");
    this.helper.expectAbsolute(_indexOf_1, 1, XbaseHighlightingStyles.PARAMETER_VARIABLE);
    this.helper.highlight(model);
  }
  
  @Test
  public void testMethodParamReference() {
    final String model = "{} def foo(int x) { x }";
    int _indexOf = model.indexOf("int");
    this.helper.expectAbsolute(_indexOf, 3, HighlightingStyles.KEYWORD_ID);
    int _indexOf_1 = model.indexOf("x");
    this.helper.expectAbsolute(_indexOf_1, 1, XbaseHighlightingStyles.PARAMETER_VARIABLE);
    int _lastIndexOf = model.lastIndexOf("x");
    this.helper.expectAbsolute(_lastIndexOf, 1, XbaseHighlightingStyles.PARAMETER_VARIABLE);
    this.helper.highlight(model);
  }
  
  @Test
  public void testMethodParamIt() {
    final String model = "{} def foo(int it) {}";
    int _prefixLength = this.helper.getPrefixLength();
    int _indexOf = model.indexOf("foo");
    int _plus = (_prefixLength + _indexOf);
    this.helper.expectMethod(_plus, 3);
    int _indexOf_1 = model.indexOf("it");
    this.helper.expectAbsolute(_indexOf_1, 2, HighlightingStyles.KEYWORD_ID);
    this.helper.highlight(model);
  }
  
  @Test
  public void testMethodParamItReference() {
    final String model = "{} def foo(int it) { it }";
    int _prefixLength = this.helper.getPrefixLength();
    int _indexOf = model.indexOf("foo");
    int _plus = (_prefixLength + _indexOf);
    this.helper.expectMethod(_plus, 3);
    int _indexOf_1 = model.indexOf("it");
    this.helper.expectAbsolute(_indexOf_1, 2, HighlightingStyles.KEYWORD_ID);
    int _lastIndexOf = model.lastIndexOf("it");
    this.helper.expectAbsolute(_lastIndexOf, 2, HighlightingStyles.KEYWORD_ID);
    this.helper.highlight(model);
  }
  
  @Test
  public void testLocalVariable() {
    final String model = "{ var int x = 1 println(x) }";
    int _indexOf = model.indexOf("x");
    this.helper.expectAbsolute(_indexOf, 1, XbaseHighlightingStyles.LOCAL_VARIABLE_DECLARATION);
    int _lastIndexOf = model.lastIndexOf("x");
    this.helper.expectAbsolute(_lastIndexOf, 1, XbaseHighlightingStyles.LOCAL_VARIABLE);
    this.helper.highlight(model);
  }
  
  @Test
  public void testLocalVariableIt() {
    final String model = "{ var int it = 1 println(it) }";
    int _indexOf = model.indexOf("it");
    this.helper.expectAbsolute(_indexOf, 2, HighlightingStyles.KEYWORD_ID);
    int _lastIndexOf = model.lastIndexOf("it");
    this.helper.expectAbsolute(_lastIndexOf, 2, HighlightingStyles.KEYWORD_ID);
    this.helper.highlight(model);
  }
  
  @Test
  public void testLocalFinalVariable() {
    final String model = "{ val int x = 1 println(x) }";
    int _indexOf = model.indexOf("x");
    this.helper.expectAbsolute(_indexOf, 1, XbaseHighlightingStyles.LOCAL_VARIABLE_DECLARATION);
    int _indexOf_1 = model.indexOf("x");
    this.helper.expectAbsolute(_indexOf_1, 1, XbaseHighlightingStyles.LOCAL_FINAL_VARIABLE_DECLARATION);
    int _lastIndexOf = model.lastIndexOf("x");
    this.helper.expectAbsolute(_lastIndexOf, 1, XbaseHighlightingStyles.LOCAL_VARIABLE);
    int _lastIndexOf_1 = model.lastIndexOf("x");
    this.helper.expectAbsolute(_lastIndexOf_1, 1, XbaseHighlightingStyles.LOCAL_FINAL_VARIABLE);
    this.helper.highlight(model);
  }
  
  @Test
  public void testLocalVariableTE() {
    final String model = "\'\'\' «{var int x = 1 println(x)}» \'\'\'";
    int _indexOf = model.indexOf("x");
    this.helper.expectAbsolute(_indexOf, 1, XbaseHighlightingStyles.LOCAL_VARIABLE_DECLARATION);
    int _lastIndexOf = model.lastIndexOf("x");
    this.helper.expectAbsolute(_lastIndexOf, 1, XbaseHighlightingStyles.LOCAL_VARIABLE);
    this.helper.highlight(model);
  }
  
  @Test
  public void testLocalFinalVariableTE() {
    final String model = "\'\'\' «{val int x = 1 println(x)}» \'\'\'";
    int _indexOf = model.indexOf("x");
    this.helper.expectAbsolute(_indexOf, 1, XbaseHighlightingStyles.LOCAL_VARIABLE_DECLARATION);
    int _indexOf_1 = model.indexOf("x");
    this.helper.expectAbsolute(_indexOf_1, 1, XbaseHighlightingStyles.LOCAL_FINAL_VARIABLE_DECLARATION);
    int _lastIndexOf = model.lastIndexOf("x");
    this.helper.expectAbsolute(_lastIndexOf, 1, XbaseHighlightingStyles.LOCAL_VARIABLE);
    int _lastIndexOf_1 = model.lastIndexOf("x");
    this.helper.expectAbsolute(_lastIndexOf_1, 1, XbaseHighlightingStyles.LOCAL_FINAL_VARIABLE);
    this.helper.highlight(model);
  }
  
  @Test
  public void testImplicitClosureParameter() {
    final String model = "{ [ it ] }";
    int _indexOf = model.indexOf("it");
    this.helper.expectAbsolute(_indexOf, 2, HighlightingStyles.KEYWORD_ID);
    this.helper.highlight(model);
  }
  
  @Test
  public void testClosureParameterIt() {
    final String model = "{ [ it | println(it) ] }";
    int _indexOf = model.indexOf("it");
    this.helper.expectAbsolute(_indexOf, 2, HighlightingStyles.KEYWORD_ID);
    int _indexOf_1 = model.indexOf("println");
    this.helper.expectAbsolute(_indexOf_1, 7, XbaseHighlightingStyles.METHOD);
    int _indexOf_2 = model.indexOf("println");
    this.helper.expectAbsolute(_indexOf_2, 7, XbaseHighlightingStyles.STATIC_METHOD_INVOCATION);
    int _lastIndexOf = model.lastIndexOf("it");
    this.helper.expectAbsolute(_lastIndexOf, 2, HighlightingStyles.KEYWORD_ID);
    this.helper.highlight(model);
  }
  
  @Test
  public void testClosureParameter() {
    final String model = "{ [ int x | x ] }";
    int _indexOf = model.indexOf("int");
    this.helper.expectAbsolute(_indexOf, 3, HighlightingStyles.KEYWORD_ID);
    int _indexOf_1 = model.indexOf("x");
    this.helper.expectAbsolute(_indexOf_1, 1, XbaseHighlightingStyles.PARAMETER_VARIABLE);
    int _lastIndexOf = model.lastIndexOf("x");
    this.helper.expectAbsolute(_lastIndexOf, 1, XbaseHighlightingStyles.PARAMETER_VARIABLE);
    this.helper.highlight(model);
  }
  
  @Test
  public void testLoopParameter() {
    final String model = "{ for(i: 0..42) { } }";
    int _indexOf = model.indexOf("i");
    this.helper.expectAbsolute(_indexOf, 1, XbaseHighlightingStyles.LOCAL_VARIABLE_DECLARATION);
    int _indexOf_1 = model.indexOf("i");
    this.helper.expectAbsolute(_indexOf_1, 1, XbaseHighlightingStyles.LOCAL_FINAL_VARIABLE_DECLARATION);
    this.helper.highlight(model);
  }
  
  @Test
  public void testTELoopParameter() {
    final String model = "\'\'\' «FOR i: 0..42» «ENDFOR» \'\'\'";
    int _indexOf = model.indexOf("i");
    this.helper.expectAbsolute(_indexOf, 1, XbaseHighlightingStyles.LOCAL_VARIABLE_DECLARATION);
    int _indexOf_1 = model.indexOf("i");
    this.helper.expectAbsolute(_indexOf_1, 1, XbaseHighlightingStyles.LOCAL_FINAL_VARIABLE_DECLARATION);
    this.helper.highlight(model);
  }
  
  @Test
  public void testSwitchParameter() {
    final String model = "{ switch( i: 0..47) { default: { } } }";
    int _indexOf = model.indexOf("i:");
    this.helper.expectAbsolute(_indexOf, 1, XbaseHighlightingStyles.LOCAL_VARIABLE_DECLARATION);
    int _indexOf_1 = model.indexOf("i:");
    this.helper.expectAbsolute(_indexOf_1, 1, XbaseHighlightingStyles.LOCAL_FINAL_VARIABLE_DECLARATION);
    this.helper.highlight(model);
  }
}
