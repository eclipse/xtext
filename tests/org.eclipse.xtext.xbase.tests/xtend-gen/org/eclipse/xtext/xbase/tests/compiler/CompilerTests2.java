/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.compiler;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.tests.compiler.AbstractOutputComparingCompilerTests;
import org.junit.Test;

@SuppressWarnings("all")
public class CompilerTests2 extends AbstractOutputComparingCompilerTests {
  @Test
  public void testVariableDeclaration() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val x = 42");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("final int x = 42;");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testVariableDeclaration1() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val a = \'foo\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val x = a");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("final String a = \"foo\";");
    _builder_1.newLine();
    _builder_1.append("final String x = a;");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testVariableDeclaration2() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val x = \'foo\'.toUpperCase");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("final String x = \"foo\".toUpperCase();");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testBug367144() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo::bar::SubOfClassWithStatics::MY_STATIC_FIELD");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("return foo.bar.SubOfClassWithStatics.MY_STATIC_FIELD;");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testBug367144_1() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo::bar::SubOfClassWithStatics::MY_STATIC_METHOD");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("String _MY_STATIC_METHOD = foo.bar.SubOfClassWithStatics.MY_STATIC_METHOD();");
    _builder_1.newLine();
    _builder_1.append("return _MY_STATIC_METHOD;");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testBug371321_1() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'foo\'.length");
    _builder.newLine();
    _builder.append("} catch (RuntimeException assert) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("assert.printStackTrace");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("int _xtrycatchfinallyexpression = (int) 0;");
    _builder_1.newLine();
    _builder_1.append("try {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("int _length = \"foo\".length();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("_xtrycatchfinallyexpression = _length;");
    _builder_1.newLine();
    _builder_1.append("} catch (final Throwable _t) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("if (_t instanceof RuntimeException) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final RuntimeException assert_ = (RuntimeException)_t;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("assert_.printStackTrace();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("} else {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("throw org.eclipse.xtext.xbase.lib.Exceptions.sneakyThrow(_t);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("return _xtrycatchfinallyexpression;");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testBug371321_2() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for (assert : \'foo\'.toCharArray) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(assert)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("char[] _charArray = \"foo\".toCharArray();");
    _builder_1.newLine();
    _builder_1.append("for (final char assert_ : _charArray) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("org.eclipse.xtext.xbase.lib.InputOutput.<Character>println(Character.valueOf(assert_));");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testNewThread() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new Thread [| ]");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("final org.eclipse.xtext.xbase.lib.Procedures.Procedure0 _function = new org.eclipse.xtext.xbase.lib.Procedures.Procedure0() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("public void apply() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("Thread _thread = new Thread(new Runnable() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("public void run() {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_function.apply();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("});");
    _builder_1.newLine();
    _builder_1.append("return _thread;");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
}
