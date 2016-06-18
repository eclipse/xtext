/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.compiler;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.tests.compiler.AbstractOutputComparingCompilerTests;
import org.junit.Test;

@SuppressWarnings("all")
public class CompilerTests2 extends AbstractOutputComparingCompilerTests {
  /**
   * https://bugs.eclipse.org/bugs/show_bug.cgi?id=424279
   */
  @Test
  public void testBug_424279() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val treeIt = <CharSequence>newArrayList.iterator;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("while (treeIt.hasNext) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val o = treeIt.next;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (o instanceof java.util.List<?>) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return o;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return o;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("java.util.ArrayList<CharSequence> _newArrayList = org.eclipse.xtext.xbase.lib.CollectionLiterals.<CharSequence>newArrayList();");
    _builder_1.newLine();
    _builder_1.append("final java.util.Iterator<CharSequence> treeIt = _newArrayList.iterator();");
    _builder_1.newLine();
    _builder_1.append("while (treeIt.hasNext()) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final CharSequence o = treeIt.next();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if ((o instanceof java.util.List<?>)) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return o;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return o;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("return null;");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testAbstractIterator() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("var com.google.common.collect.AbstractIterator<String> iter = [| return self.endOfData ]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return iter");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("final com.google.common.collect.AbstractIterator<String> _function = new com.google.common.collect.AbstractIterator<String>() {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("protected String computeNext() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this.endOfData();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("com.google.common.collect.AbstractIterator<String> iter = _function;");
    _builder_1.newLine();
    _builder_1.append("return iter;");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
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
    _builder_1.append("_xtrycatchfinallyexpression = \"foo\".length();");
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
    _builder_1.append("return Integer.valueOf(_xtrycatchfinallyexpression);");
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
    _builder_1.append("final Runnable _function = new Runnable() {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void run() {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("Thread _thread = new Thread(_function);");
    _builder_1.newLine();
    _builder_1.append("return _thread;");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testForLoop_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for(int i: 1..2) { i.toString }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("org.eclipse.xtext.xbase.lib.IntegerRange _upTo = new org.eclipse.xtext.xbase.lib.IntegerRange(1, 2);");
    _builder_1.newLine();
    _builder_1.append("for (final int i : _upTo) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("Integer.valueOf(i).toString();");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testForLoop_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for(Integer i: 1..2) { i.toString }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("org.eclipse.xtext.xbase.lib.IntegerRange _upTo = new org.eclipse.xtext.xbase.lib.IntegerRange(1, 2);");
    _builder_1.newLine();
    _builder_1.append("for (final Integer i : _upTo) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("i.toString();");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testForLoop_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for(i: 1..2) { i.toString }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("org.eclipse.xtext.xbase.lib.IntegerRange _upTo = new org.eclipse.xtext.xbase.lib.IntegerRange(1, 2);");
    _builder_1.newLine();
    _builder_1.append("for (final Integer i : _upTo) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("i.toString();");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testForLoop_04() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for(i: null as int[]) { i.toString }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("for (final int i : ((int[]) null)) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("Integer.valueOf(i).toString();");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testForLoop_05() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for(i: null as Integer[]) { i.toString }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("for (final Integer i : ((Integer[]) null)) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("i.toString();");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testForLoop_06() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for(Integer i: null as int[]) { i.toString }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("for (final Integer i : ((int[]) null)) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("i.toString();");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testForLoop_07() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for(int i: null as Integer[]) { i.toString }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("for (final int i : ((Integer[]) null)) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("Integer.valueOf(i).toString();");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testForLoop_08() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for(Integer i: null as int[]) { i.toString }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("for (final Integer i : ((int[]) null)) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("i.toString();");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testForLoop_09() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for(int i: null as Integer[]) { i.toString }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("for (final int i : ((Integer[]) null)) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("Integer.valueOf(i).toString();");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testForLoop_10() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for(int i: newArrayList) { i.toString }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("java.util.ArrayList<Integer> _newArrayList = org.eclipse.xtext.xbase.lib.CollectionLiterals.<Integer>newArrayList();");
    _builder_1.newLine();
    _builder_1.append("for (final int i : _newArrayList) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("Integer.valueOf(i).toString();");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testForLoop_11() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for(Integer i: newArrayList) { i.toString }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("java.util.ArrayList<Integer> _newArrayList = org.eclipse.xtext.xbase.lib.CollectionLiterals.<Integer>newArrayList();");
    _builder_1.newLine();
    _builder_1.append("for (final Integer i : _newArrayList) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("i.toString();");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testForLoop_12() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for(double d: <Integer>newArrayList) { d.toString }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("java.util.ArrayList<Integer> _newArrayList = org.eclipse.xtext.xbase.lib.CollectionLiterals.<Integer>newArrayList();");
    _builder_1.newLine();
    _builder_1.append("for (final double d : _newArrayList) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("Double.valueOf(d).toString();");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testForLoop_13() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for(double d: null as int[]) { d.toString }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("for (final double d : ((int[]) null)) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("Double.valueOf(d).toString();");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testForLoop_14() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for(double d: null as Integer[]) { d.toString }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("for (final double d : ((Integer[]) null)) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("Double.valueOf(d).toString();");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testNullSafe_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(\'foo\'.toUpperCase as CharSequence)?.subSequence(0,2)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("String _upperCase = \"foo\".toUpperCase();");
    _builder_1.newLine();
    _builder_1.append("CharSequence _subSequence = null;");
    _builder_1.newLine();
    _builder_1.append("if (((CharSequence) _upperCase)!=null) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("_subSequence=((CharSequence) _upperCase).subSequence(0, 2);");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("return _subSequence;");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testSwitch() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val it = String");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("switch name {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("CharSequence : name");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("default : \'noname\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("String _xblockexpression = null;");
    _builder_1.newLine();
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("final Class<String> it = String.class;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("String _switchResult = null;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("String _name = it.getName();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("boolean _matched = false;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("if (_name instanceof CharSequence) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("_matched=true;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("_switchResult = it.getName();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("if (!_matched) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("_switchResult = \"noname\";");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("_xblockexpression = _switchResult;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("return _xblockexpression;");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testSwitchScopes_Bug470586_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val list = #[\"1\", \"2\"]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("list.forEach[");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val res = switch it {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CharSequence : it");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("list.forEach[");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("println(it)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("final java.util.List<String> list = java.util.Collections.<String>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<String>newArrayList(\"1\", \"2\"));");
      _builder_1.newLine();
      _builder_1.append("final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<String> _function = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<String>() {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public void apply(final String it) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("String _switchResult = null;");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("boolean _matched = false;");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("if (it instanceof CharSequence) {");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("_matched=true;");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("_switchResult = it;");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("final String res = _switchResult;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("};");
      _builder_1.newLine();
      _builder_1.append("org.eclipse.xtext.xbase.lib.IterableExtensions.<String>forEach(list, _function);");
      _builder_1.newLine();
      _builder_1.append("final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<String> _function_1 = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<String>() {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public void apply(final String it) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("org.eclipse.xtext.xbase.lib.InputOutput.<String>println(it);");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("};");
      _builder_1.newLine();
      _builder_1.append("org.eclipse.xtext.xbase.lib.IterableExtensions.<String>forEach(list, _function_1);");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSwitchScopes_Bug470586_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val list = #[\"1\", \"2\"]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("list.forEach[");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val res = switch it {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CharSequence : it");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("default : \'\'");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("list.forEach[");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("println(it)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("final java.util.List<String> list = java.util.Collections.<String>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<String>newArrayList(\"1\", \"2\"));");
      _builder_1.newLine();
      _builder_1.append("final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<String> _function = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<String>() {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public void apply(final String it) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("String _switchResult = null;");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("boolean _matched = false;");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("if (it instanceof CharSequence) {");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("_matched=true;");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("_switchResult = it;");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("if (!_matched) {");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("_switchResult = \"\";");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("final String res = _switchResult;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("};");
      _builder_1.newLine();
      _builder_1.append("org.eclipse.xtext.xbase.lib.IterableExtensions.<String>forEach(list, _function);");
      _builder_1.newLine();
      _builder_1.append("final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<String> _function_1 = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<String>() {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public void apply(final String it) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("org.eclipse.xtext.xbase.lib.InputOutput.<String>println(it);");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("};");
      _builder_1.newLine();
      _builder_1.append("org.eclipse.xtext.xbase.lib.IterableExtensions.<String>forEach(list, _function_1);");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSwitchScopes_Bug470586_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val list = #[\"1\", \"2\"]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("list.forEach[");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val res = switch it {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("String, CharSequence : it");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("default : \'\'");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("list.forEach[");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("println(it)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("final java.util.List<String> list = java.util.Collections.<String>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<String>newArrayList(\"1\", \"2\"));");
      _builder_1.newLine();
      _builder_1.append("final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<String> _function = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<String>() {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public void apply(final String it) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("String _switchResult = null;");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("boolean _matched = false;");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("if (it instanceof String) {");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("_matched=true;");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("if (!_matched) {");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("if (it instanceof CharSequence) {");
      _builder_1.newLine();
      _builder_1.append("        ");
      _builder_1.append("_matched=true;");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("if (_matched) {");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("_switchResult = it;");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("if (!_matched) {");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("_switchResult = \"\";");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("final String res = _switchResult;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("};");
      _builder_1.newLine();
      _builder_1.append("org.eclipse.xtext.xbase.lib.IterableExtensions.<String>forEach(list, _function);");
      _builder_1.newLine();
      _builder_1.append("final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<String> _function_1 = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<String>() {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public void apply(final String it) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("org.eclipse.xtext.xbase.lib.InputOutput.<String>println(it);");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("};");
      _builder_1.newLine();
      _builder_1.append("org.eclipse.xtext.xbase.lib.IterableExtensions.<String>forEach(list, _function_1);");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFallThroughSwitch() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch x : 1 {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case 1,");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case 2:");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\'lalala\'");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("String _switchResult = null;");
      _builder_1.newLine();
      _builder_1.append("final int x = 1;");
      _builder_1.newLine();
      _builder_1.append("switch (x) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("case 1:");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("case 2:");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_switchResult = \"lalala\";");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("break;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _switchResult;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFallThroughSwitch_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch x : \'lalala\' {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case \'a\',");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case \'b\',");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case \'c\':");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\'lalala\'");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("String _switchResult = null;");
      _builder_1.newLine();
      _builder_1.append("final String x = \"lalala\";");
      _builder_1.newLine();
      _builder_1.append("boolean _matched = false;");
      _builder_1.newLine();
      _builder_1.append("if (com.google.common.base.Objects.equal(x, \"a\")) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_matched=true;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("if (!_matched) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("if (com.google.common.base.Objects.equal(x, \"b\")) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_matched=true;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("if (!_matched) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("if (com.google.common.base.Objects.equal(x, \"c\")) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_matched=true;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("if (_matched) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_switchResult = \"lalala\";");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _switchResult;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFallThroughSwitch_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch x : 1 {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case 1,");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case 2,");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("default:");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\'lalala\'");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("String _switchResult = null;");
      _builder_1.newLine();
      _builder_1.append("final int x = 1;");
      _builder_1.newLine();
      _builder_1.append("switch (x) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("case 1:");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("case 2:");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("default:");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_switchResult = \"lalala\";");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("break;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _switchResult;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFallThroughSwitch_4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch x : \'lalala\' {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case \'a\',");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case \'b\',");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("default:");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\'lalala\'");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("String _switchResult = null;");
      _builder_1.newLine();
      _builder_1.append("final String x = \"lalala\";");
      _builder_1.newLine();
      _builder_1.append("boolean _matched = false;");
      _builder_1.newLine();
      _builder_1.append("if (com.google.common.base.Objects.equal(x, \"a\")) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_matched=true;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("if (!_matched) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("if (com.google.common.base.Objects.equal(x, \"b\")) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_matched=true;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("if (_matched) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_switchResult = \"lalala\";");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("if (!_matched) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_switchResult = \"lalala\";");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _switchResult;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFallThroughSwitch_5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch x : 1 {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case 1:");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\'blabla\'");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case 2,");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("default:");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\'lalala\'");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("String _switchResult = null;");
      _builder_1.newLine();
      _builder_1.append("final int x = 1;");
      _builder_1.newLine();
      _builder_1.append("switch (x) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("case 1:");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_switchResult = \"blabla\";");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("break;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("case 2:");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("default:");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_switchResult = \"lalala\";");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("break;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _switchResult;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFallThroughSwitch_6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch x : new Object {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("String case \'a\':");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\'blabla\'");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Integer case 1,");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case 2,");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("default:");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\'lalala\'");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("String _switchResult = null;");
      _builder_1.newLine();
      _builder_1.append("Object _object = new Object();");
      _builder_1.newLine();
      _builder_1.append("final Object x = _object;");
      _builder_1.newLine();
      _builder_1.append("boolean _matched = false;");
      _builder_1.newLine();
      _builder_1.append("if (x instanceof String) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("if (com.google.common.base.Objects.equal(x, \"a\")) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_matched=true;");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_switchResult = \"blabla\";");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("if (!_matched) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("if (x instanceof Integer) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("if (com.google.common.base.Objects.equal(x, 1)) {");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("_matched=true;");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("if (!_matched) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("if (com.google.common.base.Objects.equal(x, 2)) {");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("_matched=true;");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("if (_matched) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_switchResult = \"lalala\";");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("if (!_matched) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_switchResult = \"lalala\";");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _switchResult;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFallThroughSwitch_7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch x : \'lalala\' as Object { ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("String, Integer case 1: 0");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Integer, default: 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("int _switchResult = (int) 0;");
      _builder_1.newLine();
      _builder_1.append("final Object x = ((Object) \"lalala\");");
      _builder_1.newLine();
      _builder_1.append("boolean _matched = false;");
      _builder_1.newLine();
      _builder_1.append("if (x instanceof String) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_matched=true;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("if (!_matched) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("if (x instanceof Integer) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("if (com.google.common.base.Objects.equal(x, 1)) {");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("_matched=true;");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("if (_matched) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_switchResult = 0;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("if (!_matched) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("if (x instanceof Integer) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_matched=true;");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_switchResult = 1;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("if (!_matched) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_switchResult = 1;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _switchResult;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFallThroughSwitch_8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch x : 1 as Object {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Integer,");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Double: x");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Number _switchResult = null;");
      _builder_1.newLine();
      _builder_1.append("final Object x = ((Object) Integer.valueOf(1));");
      _builder_1.newLine();
      _builder_1.append("boolean _matched = false;");
      _builder_1.newLine();
      _builder_1.append("if (x instanceof Integer) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_matched=true;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("if (!_matched) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("if (x instanceof Double) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_matched=true;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("if (_matched) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_switchResult = ((Number)x);");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return ((Number)_switchResult);");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEmptySwitch() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch 1 {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Object _switchResult = null;");
      _builder_1.newLine();
      _builder_1.append("final int _switchValue = 1;");
      _builder_1.newLine();
      _builder_1.append("switch (_switchValue) {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _switchResult;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEmptySwitch_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch 1 {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("default: {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Object _switchResult = null;");
      _builder_1.newLine();
      _builder_1.append("final int _switchValue = 1;");
      _builder_1.newLine();
      _builder_1.append("switch (_switchValue) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("default:");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_switchResult = null;");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("break;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _switchResult;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEmptySwitch_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch Object {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Object _switchResult = null;");
      _builder_1.newLine();
      _builder_1.append("final Class<Object> Object = Object.class;");
      _builder_1.newLine();
      _builder_1.append("boolean _matched = false;");
      _builder_1.newLine();
      _builder_1.append("return _switchResult;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEmptySwitch_4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch Object {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("default: {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Object _switchResult = null;");
      _builder_1.newLine();
      _builder_1.append("final Class<Object> Object = Object.class;");
      _builder_1.newLine();
      _builder_1.append("boolean _matched = false;");
      _builder_1.newLine();
      _builder_1.append("if (!_matched) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_switchResult = null;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _switchResult;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEmptySwitch_5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch Thread.State.NEW {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Object _switchResult = null;");
      _builder_1.newLine();
      _builder_1.append("final Thread.State _switchValue = Thread.State.NEW;");
      _builder_1.newLine();
      _builder_1.append("if (_switchValue != null) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("switch (_switchValue) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("default:");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("break;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _switchResult;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEmptySwitch_6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch Thread.State.NEW {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("default: {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Object _switchResult = null;");
      _builder_1.newLine();
      _builder_1.append("final Thread.State _switchValue = Thread.State.NEW;");
      _builder_1.newLine();
      _builder_1.append("if (_switchValue != null) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("switch (_switchValue) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("default:");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("_switchResult = null;");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("break;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("} else {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_switchResult = null;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _switchResult;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEmptySwitch_7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch Thread.State x : Thread.State.NEW {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("default: {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Object _switchResult = null;");
      _builder_1.newLine();
      _builder_1.append("final Thread.State x = Thread.State.NEW;");
      _builder_1.newLine();
      _builder_1.append("if (x != null) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("switch (x) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("default:");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("_switchResult = null;");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("break;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("} else {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_switchResult = null;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _switchResult;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEmptySwitch_8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch (Thread.State x : Thread.State.NEW) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("default: {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Object _switchResult = null;");
      _builder_1.newLine();
      _builder_1.append("final Thread.State x = Thread.State.NEW;");
      _builder_1.newLine();
      _builder_1.append("if (x != null) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("switch (x) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("default:");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("_switchResult = null;");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("break;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("} else {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_switchResult = null;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _switchResult;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEmptySwitch_9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch Object x : Thread.State.NEW {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("default: {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Object _switchResult = null;");
      _builder_1.newLine();
      _builder_1.append("final Object x = Thread.State.NEW;");
      _builder_1.newLine();
      _builder_1.append("boolean _matched = false;");
      _builder_1.newLine();
      _builder_1.append("if (!_matched) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_switchResult = null;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _switchResult;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEmptySwitch_10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch (Object x : Thread.State.NEW) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("default: {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Object _switchResult = null;");
      _builder_1.newLine();
      _builder_1.append("final Object x = Thread.State.NEW;");
      _builder_1.newLine();
      _builder_1.append("boolean _matched = false;");
      _builder_1.newLine();
      _builder_1.append("if (!_matched) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_switchResult = null;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _switchResult;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBasicForLoop_0() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("for (var i = 0; i < 10; i = i + 1) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("for (int i = 0; (i < 10); i = (i + 1)) {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBasicForLoop_toJavaWhile_0() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("for (var i = if (true) { 1 }; i < 10; i = i + 1) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("int _xifexpression = (int) 0;");
      _builder_1.newLine();
      _builder_1.append("if (true) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_xifexpression = 1;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("int i = _xifexpression;");
      _builder_1.newLine();
      _builder_1.append("boolean _while = (i < 10);");
      _builder_1.newLine();
      _builder_1.append("while (_while) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("i = (i + 1);");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_while = (i < 10);");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBasicForLoop_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("for (;;) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("for (;;) {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBasicForLoop_toJavaWhile_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("for (for (;;) {};;) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("for (;;) {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("boolean _while = true;");
      _builder_1.newLine();
      _builder_1.append("while (_while) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_while = true;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBasicForLoop_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("for (val i = 0; i < 10;) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (i == 2) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return true;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("for (final int i = 0; (i < 10);) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("if ((i == 2)) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return Boolean.valueOf(true);");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBasicForLoop_toJavaWhile_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("for (val i = #[if(true) {1} else {2}]; i.head < 10;) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (i.head == 2) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return true;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("int _xifexpression = (int) 0;");
      _builder_1.newLine();
      _builder_1.append("if (true) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_xifexpression = 1;");
      _builder_1.newLine();
      _builder_1.append("} else {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_xifexpression = 2;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("final java.util.List<Integer> i = java.util.Collections.<Integer>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Integer>newArrayList(Integer.valueOf(_xifexpression)));");
      _builder_1.newLine();
      _builder_1.append("Integer _head = org.eclipse.xtext.xbase.lib.IterableExtensions.<Integer>head(i);");
      _builder_1.newLine();
      _builder_1.append("boolean _lessThan = ((_head).intValue() < 10);");
      _builder_1.newLine();
      _builder_1.append("boolean _while = _lessThan;");
      _builder_1.newLine();
      _builder_1.append("while (_while) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("Integer _head_1 = org.eclipse.xtext.xbase.lib.IterableExtensions.<Integer>head(i);");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("boolean _equals = ((_head_1).intValue() == 2);");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("if (_equals) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return Boolean.valueOf(true);");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("Integer _head_2 = org.eclipse.xtext.xbase.lib.IterableExtensions.<Integer>head(i);");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("boolean _lessThan_1 = ((_head_2).intValue() < 10);");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_while = _lessThan_1;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return null;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBasicForLoop_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("for (val i = 0; i < 10;) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return true");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("for (final int i = 0; (i < 10);) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("return Boolean.valueOf(true);");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBasicForLoop_4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("for (var i = 1; i < 10;) {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("for (val i = 1;;) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("for (int i = 1; (i < 10);) {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("for (final int i = 1;;) {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBasicForLoop_5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("for (var i = 1;i < 10;) {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("for (val i = 1;;) {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("for (int i = 1; (i < 10);) {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("for (final int i = 1;;) {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBasicForLoop_6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (true) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("for (;;) {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("if (true) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("for (;;) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBasicForLoop_7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("try {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("for (;;) {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} finally {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("try {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("for (;;) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("} finally {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBasicForLoop_8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("[| for (;;) {} ]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("final org.eclipse.xtext.xbase.lib.Procedures.Procedure0 _function = new org.eclipse.xtext.xbase.lib.Procedures.Procedure0() {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public void apply() {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("for (;;) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("};");
      _builder_1.newLine();
      _builder_1.append("return _function;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBasicForLoop_9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("for (;;) {}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("for (;;) {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBasicForLoop_10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val i = 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("for ([| i ].apply, [| i ].apply; i < 10;) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("final int i = 0;");
      _builder_1.newLine();
      _builder_1.append("for (new org.eclipse.xtext.xbase.lib.Functions.Function0<Integer>() {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public Integer apply() {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return Integer.valueOf(i);");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}.apply(), new org.eclipse.xtext.xbase.lib.Functions.Function0<Integer>() {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public Integer apply() {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return Integer.valueOf(i);");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}.apply(); (i < 10);) {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBasicForLoop_11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("for (val i = 0, val j = 0; i < 10;) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("final int i = 0;");
      _builder_1.newLine();
      _builder_1.append("final int j = 0;");
      _builder_1.newLine();
      _builder_1.append("boolean _while = (i < 10);");
      _builder_1.newLine();
      _builder_1.append("while (_while) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_while = (i < 10);");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBasicForLoop_12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("for (var i = 0; i != 10; i += 1) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("int i = 0;");
      _builder_1.newLine();
      _builder_1.append("boolean _while = (i != 10);");
      _builder_1.newLine();
      _builder_1.append("while (_while) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int _i = i;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("i = (_i + 1);");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_while = (i != 10);");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testWhileLoopWithConstantCondition_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("while (newArrayList(\'\').empty || 2 == (1 << 1)) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return \'\'");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("while ((org.eclipse.xtext.xbase.lib.CollectionLiterals.<String>newArrayList(\"\").isEmpty() || (2 == (1 << 1)))) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("return \"\";");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return null;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testWhileLoopWithConstantCondition_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("while (2 == (1 << 1)) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return \'\'");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("while ((2 == (1 << 1))) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("return \"\";");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSynchronizedBlock_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val x = new Integer(1)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("synchronized(x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Object _xblockexpression = null;");
      _builder_1.newLine();
      _builder_1.append("{");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("final Integer x = new Integer(1);");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("Object _xsynchronizedexpression = null;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("synchronized (x) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_xsynchronizedexpression = null;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_xblockexpression = _xsynchronizedexpression;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _xblockexpression;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSynchronizedBlock_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val x = new Integer(1)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val y = synchronized(x) 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("final Integer x = new Integer(1);");
      _builder_1.newLine();
      _builder_1.append("int _xsynchronizedexpression = (int) 0;");
      _builder_1.newLine();
      _builder_1.append("synchronized (x) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_xsynchronizedexpression = 1;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("final int y = _xsynchronizedexpression;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSynchronizedBlock_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val x = new Integer(1)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val y = synchronized(x) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("val i = 1");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("val j = 2");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("i + j");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("final Integer x = new Integer(1);");
      _builder_1.newLine();
      _builder_1.append("int _xsynchronizedexpression = (int) 0;");
      _builder_1.newLine();
      _builder_1.append("synchronized (x) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int _xblockexpression = (int) 0;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("{");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("final int i = 1;");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("final int j = 2;");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_xblockexpression = (i + j);");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_xsynchronizedexpression = _xblockexpression;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("final int y = _xsynchronizedexpression;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug410797_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{ val boolean bug = #[true, false, true].reduce[a,b|a && b] }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("final org.eclipse.xtext.xbase.lib.Functions.Function2<Boolean, Boolean, Boolean> _function = new org.eclipse.xtext.xbase.lib.Functions.Function2<Boolean, Boolean, Boolean>() {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Boolean apply(final Boolean a, final Boolean b) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return Boolean.valueOf(((a).booleanValue() && (b).booleanValue()));");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("final boolean bug = (boolean) org.eclipse.xtext.xbase.lib.IterableExtensions.<Boolean>reduce(java.util.Collections.<Boolean>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Boolean>newArrayList(Boolean.valueOf(true), Boolean.valueOf(false), Boolean.valueOf(true))), _function);");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testBug434224_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val bar = new Object");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (bar instanceof Byte) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("bar as char");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("char _xblockexpression = (char) 0;");
      _builder_1.newLine();
      _builder_1.append("{");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("final Object bar = new Object();");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("char _xifexpression = (char) 0;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("if ((bar instanceof Byte)) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_xifexpression = ((char) ((Byte) bar).byteValue());");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_xblockexpression = _xifexpression;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _xblockexpression;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug434224_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch bar : new Object {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Byte: bar as char");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("char _switchResult = (char) 0;");
      _builder_1.newLine();
      _builder_1.append("Object _object = new Object();");
      _builder_1.newLine();
      _builder_1.append("final Object bar = _object;");
      _builder_1.newLine();
      _builder_1.append("boolean _matched = false;");
      _builder_1.newLine();
      _builder_1.append("if (bar instanceof Byte) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_matched=true;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_switchResult = ((char) ((Byte) bar).byteValue());");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _switchResult;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug433573_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val Number element = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if(element instanceof Double) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val Iterable<? extends Number> i = #[element]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("final Number element = null;");
      _builder_1.newLine();
      _builder_1.append("if ((element instanceof Double)) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("final Iterable<? extends Number> i = java.util.Collections.<Number>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Number>newArrayList(element));");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug433573_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val Number element = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch element {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Double: {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("val Iterable<? extends Number> i = #[element]");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("final Number element = null;");
      _builder_1.newLine();
      _builder_1.append("boolean _matched = false;");
      _builder_1.newLine();
      _builder_1.append("if (element instanceof Double) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_matched=true;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("final Iterable<? extends Number> i = java.util.Collections.<Number>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Number>newArrayList(element));");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug433573_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val Number element = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if(element instanceof Double) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val Iterable<? extends Number> i = #{element}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("final Number element = null;");
      _builder_1.newLine();
      _builder_1.append("if ((element instanceof Double)) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("final Iterable<? extends Number> i = java.util.Collections.<Number>unmodifiableSet(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Number>newHashSet(element));");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug433573_04() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val Number element = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch element {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Double: {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("val Iterable<? extends Number> i = #{element}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("final Number element = null;");
      _builder_1.newLine();
      _builder_1.append("boolean _matched = false;");
      _builder_1.newLine();
      _builder_1.append("if (element instanceof Double) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_matched=true;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("final Iterable<? extends Number> i = java.util.Collections.<Number>unmodifiableSet(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Number>newHashSet(element));");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug433573_05() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val Object element = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if(element instanceof Double) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val Iterable<? extends Number> i = #[element]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("final Object element = null;");
      _builder_1.newLine();
      _builder_1.append("if ((element instanceof Double)) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("final Iterable<? extends Number> i = java.util.Collections.<Number>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Number>newArrayList(((Number)element)));");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug433573_06() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val Object element = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch element {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Double: {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("val Iterable<? extends Number> i = #[element]");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("final Object element = null;");
      _builder_1.newLine();
      _builder_1.append("boolean _matched = false;");
      _builder_1.newLine();
      _builder_1.append("if (element instanceof Double) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_matched=true;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("final Iterable<? extends Number> i = java.util.Collections.<Number>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Number>newArrayList(((Number)element)));");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug433573_07() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val Object element = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if(element instanceof Double) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val Iterable<? extends Number> i = #{element}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("final Object element = null;");
      _builder_1.newLine();
      _builder_1.append("if ((element instanceof Double)) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("final Iterable<? extends Number> i = java.util.Collections.<Number>unmodifiableSet(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Number>newHashSet(((Number)element)));");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug433573_08() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val Object element = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch element {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Double: {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("val Iterable<? extends Number> i = #{element}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("final Object element = null;");
      _builder_1.newLine();
      _builder_1.append("boolean _matched = false;");
      _builder_1.newLine();
      _builder_1.append("if (element instanceof Double) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_matched=true;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("final Iterable<? extends Number> i = java.util.Collections.<Number>unmodifiableSet(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Number>newHashSet(((Number)element)));");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug466974_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var i = 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Math.max( i = i + 1, if (i == 1) { 1 } else { 2 })");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("int _xblockexpression = (int) 0;");
      _builder_1.newLine();
      _builder_1.append("{");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int i = 0;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int _i = i = (i + 1);");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int _xifexpression = (int) 0;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("if ((i == 1)) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_xifexpression = 1;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("} else {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_xifexpression = 2;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_xblockexpression = Math.max(_i, _xifexpression);");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _xblockexpression;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug466974_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var i = 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Math.max(if (i == 1) { 1 } else { 2 }, i = i + 1)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("int _xblockexpression = (int) 0;");
      _builder_1.newLine();
      _builder_1.append("{");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int i = 0;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int _xifexpression = (int) 0;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("if ((i == 1)) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_xifexpression = 1;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("} else {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_xifexpression = 2;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_xblockexpression = Math.max(_xifexpression, i = (i + 1));");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _xblockexpression;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug466974_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var i = 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Math.max({ i = i + 1 }, if (i == 1) { 1 } else { 2 })");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("int _xblockexpression = (int) 0;");
      _builder_1.newLine();
      _builder_1.append("{");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int i = 0;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int _i = i = (i + 1);");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int _xifexpression = (int) 0;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("if ((i == 1)) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_xifexpression = 1;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("} else {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_xifexpression = 2;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_xblockexpression = Math.max(_i, _xifexpression);");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _xblockexpression;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug466974_04() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var i = 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Math.max(if (i == 1) { 1 } else { 2 }, { i = i + 1 })");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("int _xblockexpression = (int) 0;");
      _builder_1.newLine();
      _builder_1.append("{");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int i = 0;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int _xifexpression = (int) 0;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("if ((i == 1)) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_xifexpression = 1;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("} else {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_xifexpression = 2;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_xblockexpression = Math.max(_xifexpression, i = (i + 1));");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _xblockexpression;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug466974_05() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var i = 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("{i = i + 1}.compareTo(if (i == 1) { 1 } else { 2 })");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("int _xblockexpression = (int) 0;");
      _builder_1.newLine();
      _builder_1.append("{");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int i = 0;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int _i = i = (i + 1);");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int _xifexpression = (int) 0;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("if ((i == 1)) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_xifexpression = 1;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("} else {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_xifexpression = 2;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_xblockexpression = Integer.valueOf(_i).compareTo(Integer.valueOf(_xifexpression));");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _xblockexpression;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug466974_06() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var i = 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("{if (i == 1) { 1 } else { 2 }}.compareTo(i = i + 1)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("int _xblockexpression = (int) 0;");
      _builder_1.newLine();
      _builder_1.append("{");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int i = 0;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int _xifexpression = (int) 0;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("if ((i == 1)) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_xifexpression = 1;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("} else {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_xifexpression = 2;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_xblockexpression = Integer.valueOf(_xifexpression).compareTo(Integer.valueOf(i = (i + 1)));");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _xblockexpression;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug466974_07() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var i = 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("{{i = i + 1}}.compareTo(if (i == 1) { 1 } else { 2 })");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("int _xblockexpression = (int) 0;");
      _builder_1.newLine();
      _builder_1.append("{");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int i = 0;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int _i = i = (i + 1);");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int _xifexpression = (int) 0;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("if ((i == 1)) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_xifexpression = 1;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("} else {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_xifexpression = 2;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_xblockexpression = Integer.valueOf(_i).compareTo(Integer.valueOf(_xifexpression));");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _xblockexpression;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug466974_08() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var i = 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("{if (i == 1) { 1 } else { 2 }}.compareTo({i = i + 1})");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("int _xblockexpression = (int) 0;");
      _builder_1.newLine();
      _builder_1.append("{");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int i = 0;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int _xifexpression = (int) 0;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("if ((i == 1)) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_xifexpression = 1;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("} else {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_xifexpression = 2;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_xblockexpression = Integer.valueOf(_xifexpression).compareTo(Integer.valueOf(i = (i + 1)));");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _xblockexpression;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug466974_09() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var i = 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Math.max(i = i + 1, 2)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("int _xblockexpression = (int) 0;");
      _builder_1.newLine();
      _builder_1.append("{");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int i = 0;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_xblockexpression = Math.max(i = (i + 1), 2);");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _xblockexpression;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug466974_10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var i = 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("{i = i + 1}.compareTo(2)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("int _xblockexpression = (int) 0;");
      _builder_1.newLine();
      _builder_1.append("{");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int i = 0;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_xblockexpression = Integer.valueOf(i = (i + 1)).compareTo(Integer.valueOf(2));");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _xblockexpression;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug489037_NestedAssignment_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var i = 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var j = 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("j=i=0;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("int _xblockexpression = (int) 0;");
      _builder_1.newLine();
      _builder_1.append("{");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int i = 0;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int j = 0;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_xblockexpression = j = (i = 0);");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _xblockexpression;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug489037_NestedAssignment_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var i = 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var n = 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("n=i=(if (i==0) 1 else 2)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("int _xblockexpression = (int) 0;");
      _builder_1.newLine();
      _builder_1.append("{");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int i = 0;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int n = 1;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int _xifexpression = (int) 0;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("if ((i == 0)) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_xifexpression = 1;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("} else {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("_xifexpression = 2;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int _i = (i = _xifexpression);");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_xblockexpression = n = _i;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _xblockexpression;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug489037_NestedAssignment_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var i = 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var n = 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("n=i=switch(i) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("default: 2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("int _xblockexpression = (int) 0;");
      _builder_1.newLine();
      _builder_1.append("{");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int i = 0;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int n = 1;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int _switchResult = (int) 0;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("switch (i) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("default:");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("_switchResult = 2;");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("break;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("int _i = (i = _switchResult);");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("_xblockexpression = n = _i;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("return _xblockexpression;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
