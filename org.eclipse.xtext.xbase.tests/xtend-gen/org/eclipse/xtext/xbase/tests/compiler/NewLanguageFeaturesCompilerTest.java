/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.compiler;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.tests.compiler.AbstractOutputComparingCompilerTests;
import org.junit.Test;

/**
 * @author Miro Spoenemann - Initial contribution and API
 */
@SuppressWarnings("all")
public class NewLanguageFeaturesCompilerTest extends AbstractOutputComparingCompilerTests {
  @Test
  public void testOverride() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{ val x = #[\'a\', \'\', \'c\'].filter[!empty] }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("final org.eclipse.xtext.xbase.lib.Functions.Function1<String, Boolean> _function = new org.eclipse.xtext.xbase.lib.Functions.Function1<String, Boolean>() {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Boolean apply(final String it) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("boolean _isEmpty = it.isEmpty();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return Boolean.valueOf((!_isEmpty));");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("final Iterable<String> x = org.eclipse.xtext.xbase.lib.IterableExtensions.<String>filter(java.util.Collections.<String>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<String>newArrayList(\"a\", \"\", \"c\")), _function);");
    _builder_1.newLine();
    Pair<JavaVersion, JavaVersion> _mappedTo = Pair.<JavaVersion, JavaVersion>of(JavaVersion.JAVA6, JavaVersion.JAVA7);
    this.compilesTo(_builder, _builder_1, _mappedTo);
  }
  
  @Test
  public void testSwitchOverString() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val x = switch(\'foo\') {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("case \'a\': 1");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("case \'b\' + \'c\': 2");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("default: 3");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("int _switchResult = (int) 0;");
    _builder_1.newLine();
    _builder_1.append("final String _switchValue = \"foo\";");
    _builder_1.newLine();
    _builder_1.append("switch (_switchValue) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("case \"a\":");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("_switchResult = 1;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("break;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("case (\"b\" + \"c\"):");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("_switchResult = 2;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("break;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("default:");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("_switchResult = 3;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("break;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("final int x = _switchResult;");
    _builder_1.newLine();
    Pair<JavaVersion, JavaVersion> _mappedTo = Pair.<JavaVersion, JavaVersion>of(JavaVersion.JAVA7, JavaVersion.JAVA8);
    this.compilesTo(_builder, _builder_1, _mappedTo);
  }
  
  @Test
  public void testUnderscoreInNumericLiteral() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val x = 123_456_789");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("final int x = 123_456_789;");
    _builder_1.newLine();
    Pair<JavaVersion, JavaVersion> _mappedTo = Pair.<JavaVersion, JavaVersion>of(JavaVersion.JAVA7, JavaVersion.JAVA8);
    this.compilesTo(_builder, _builder_1, _mappedTo);
  }
  
  @Test
  public void testNewThread() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new Thread [| ]");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("final Runnable _function = () -> {");
    _builder_1.newLine();
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("Thread _thread = new Thread(_function);");
    _builder_1.newLine();
    _builder_1.append("return _thread;");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1, JavaVersion.JAVA8);
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
      _builder_1.append("final org.eclipse.xtext.xbase.lib.Procedures.Procedure0 _function = () -> {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("for (;;) {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("};");
      _builder_1.newLine();
      _builder_1.append("return _function;");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1, JavaVersion.JAVA8);
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
      _builder_1.append("for (((org.eclipse.xtext.xbase.lib.Functions.Function0<Integer>) () -> {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("return Integer.valueOf(i);");
      _builder_1.newLine();
      _builder_1.append("}).apply(), ((org.eclipse.xtext.xbase.lib.Functions.Function0<Integer>) () -> {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("return Integer.valueOf(i);");
      _builder_1.newLine();
      _builder_1.append("}).apply(); (i < 10);) {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.compilesTo(_builder, _builder_1, JavaVersion.JAVA8);
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
    _builder_1.append("final org.eclipse.xtext.xbase.lib.Functions.Function2<Boolean, Boolean, Boolean> _function = (Boolean a, Boolean b) -> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("return Boolean.valueOf(((a).booleanValue() && (b).booleanValue()));");
    _builder_1.newLine();
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("final boolean bug = (boolean) org.eclipse.xtext.xbase.lib.IterableExtensions.<Boolean>reduce(java.util.Collections.<Boolean>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Boolean>newArrayList(Boolean.valueOf(true), Boolean.valueOf(false), Boolean.valueOf(true))), _function);");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1, JavaVersion.JAVA8);
  }
  
  @Test
  public void testImplicitReferenceToMultitype() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("((null as Iterable<java.util.List<Object>>) + (null as Iterable<java.util.Set<Object>>)).forEach[ size ]");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Iterable<java.util.Collection<Object>> _plus = com.google.common.collect.Iterables.<java.util.Collection<Object>>concat(((Iterable<java.util.List<Object>>) null), ((Iterable<java.util.Set<Object>>) null));");
    _builder_1.newLine();
    _builder_1.append("final java.util.function.Consumer<java.util.Collection<Object>> _function = (java.util.Collection<Object> it) -> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("it.size();");
    _builder_1.newLine();
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("_plus.forEach(_function);");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1, JavaVersion.JAVA8);
  }
  
  @Test
  public void testImplicitReferenceToSynonym_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(null as Iterable<String[]>).forEach[ reverse ]");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("final java.util.function.Consumer<String[]> _function = (String[] it) -> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("org.eclipse.xtext.xbase.lib.ListExtensions.<String>reverse(((java.util.List<String>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(it)));");
    _builder_1.newLine();
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("((Iterable<String[]>) null).forEach(_function);");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1, JavaVersion.JAVA8);
  }
  
  @Test
  public void testBlockHasNoSuperfluousBraces_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{ var (int)=>void fun = [ int i | new Object() new Object() ] }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<Integer> _function = (Integer i) -> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("new Object();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("new Object();");
    _builder_1.newLine();
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("org.eclipse.xtext.xbase.lib.Procedures.Procedure1<? super Integer> fun = _function;");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1, JavaVersion.JAVA8);
  }
  
  @Test
  public void testExceptionOnClosure() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{val java.beans.VetoableChangeListener x = []}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("final java.beans.VetoableChangeListener _function = (java.beans.PropertyChangeEvent it) -> {");
    _builder_1.newLine();
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("final java.beans.VetoableChangeListener x = _function;");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1, JavaVersion.JAVA8);
  }
}
