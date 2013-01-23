/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.compiler;

import org.eclipse.xtend.core.tests.NewTypeSystemRuntimeInjectorProvider;
import org.eclipse.xtend.core.tests.compiler.AbstractCompilerTest;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = NewTypeSystemRuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class CompilerTest2 extends AbstractCompilerTest {
  @Test
  public void testBug343096_01() throws Exception {
    String _plus = ("package x class Y {" + 
      "def <T> bug343096() {\n");
    String _plus_1 = (_plus + 
      "  [T t|switch t {\n");
    String _plus_2 = (_plus_1 + 
      "    case t : bug343096\n");
    String _plus_3 = (_plus_2 + 
      "  }]");
    String _plus_4 = (_plus_3 + 
      "}}");
    this.compileJavaCode("x.Y", _plus_4);
  }
  
  @Test
  public void testBug343096_02() throws Exception {
    String _canonicalName = Function1.class.getCanonicalName();
    this.invokeAndExpect2(_canonicalName, 
      "def <T> bug343096() {\n\t\t\t\t  [T t|switch t { \n\t\t\t\t    case t : bug343096 \n\t\t\t\t  }].getClass.interfaces.head.canonicalName \n\t\t\t\t}", "bug343096");
  }
  
  @Test
  public void testBug343096_03() throws Exception {
    String _canonicalName = Object.class.getCanonicalName();
    this.invokeAndExpect2(_canonicalName, 
      "def <T> String bug343096() {\n\t\t\t\t  [T t|switch t { \n\t\t\t\t    case t : bug343096 \n\t\t\t\t  }].getClass.superclass.canonicalName \n\t\t\t\t}", "bug343096");
  }
  
  @Test
  @Ignore(value = "TODO deferred typing of local vars which are currently \'any\'")
  public void testBug_350932_13() throws Exception {
    super.testBug_350932_13();
  }
  
  @Test
  @Ignore(value = "TODO deferred typing of local vars which are currently \'any\'")
  public void testBug_350932_14() throws Exception {
    super.testBug_350932_14();
  }
  
  @Test
  @Ignore(value = "TODO use the type expectation to bind type arguments")
  public void testBug_352849_02() throws Exception {
    super.testBug_352849_02();
  }
  
  @Test
  @Ignore(value = "TODO Currently there is no way to refer to computed types in the jvm model inferer")
  public void testData_03() throws Exception {
    super.testData_03();
  }
  
  @Test
  public void testEscapeCharacterForReservedNames() throws Exception {
    final String code = "package x class Z {\n\t\t\t  def Object create(Object x) {\n\t\t\t    create(x)\n\t\t\t  }\n\t\t\t}";
    final String javaCode = this.compileToJavaCode(code);
    this.javaCompiler.compileToClass("x.Z", javaCode);
  }
  
  @Test
  public void testEscapeCharacterForReservedNames_02() throws Exception {
    final String code = "package x class Z {\n\t\t\t  def create(Object x) {\n\t\t\t    create(x)\n\t\t\t  }\n\t\t\t}";
    final String javaCode = this.compileToJavaCode(code);
    this.javaCompiler.compileToClass("x.Z", javaCode);
  }
}
