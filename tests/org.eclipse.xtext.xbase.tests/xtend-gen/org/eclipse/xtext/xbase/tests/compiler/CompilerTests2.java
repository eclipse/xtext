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
    _builder_1.append("boolean _hasNext = treeIt.hasNext();");
    _builder_1.newLine();
    _builder_1.append("boolean _while = _hasNext;");
    _builder_1.newLine();
    _builder_1.append("while (_while) {");
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
    _builder_1.append("if (!_matched) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (_name instanceof CharSequence) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_matched=true;");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_switchResult = it.getName();");
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
  public void testBug410797_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{ val boolean bug = #[true, false, true].reduce[a,b|a && b] }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("final org.eclipse.xtext.xbase.lib.Functions.Function2<Boolean,Boolean,Boolean> _function = new org.eclipse.xtext.xbase.lib.Functions.Function2<Boolean,Boolean,Boolean>() {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Boolean apply(final Boolean a, final Boolean b) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("boolean _and = false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (!(a).booleanValue()) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_and = false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_and = (b).booleanValue();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return Boolean.valueOf(_and);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("final boolean bug = (boolean) org.eclipse.xtext.xbase.lib.IterableExtensions.<Boolean>reduce(java.util.Collections.<Boolean>unmodifiableList(com.google.common.collect.Lists.<Boolean>newArrayList(true, false, true)), _function);");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
}
