/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.compiler;

import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class CompilerBug406549Test extends AbstractXtendCompilerTest {
  @Test
  public void testBug406549_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Test<T> {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def m(T t){}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("new Test<Object>().m(1L)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Test<T extends Object> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Object m(final T t) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return null;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void n() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Test<Object> _test = new Test<Object>();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("_test.m(Long.valueOf(1L));");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testBug406549_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Test<T> {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def m(){}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def void m(T a, T b) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("this => [");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("new Test<T>().m(a, b)");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.ObjectExtensions;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Test<T extends Object> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Object m() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return null;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void m(final T a, final T b) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final Procedure1<Test<T>> _function = new Procedure1<Test<T>>() {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("public void apply(final Test<T> it) {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("Test<T> _test = new Test<T>();");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("_test.m(a, b);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("ObjectExtensions.<Test<T>>operator_doubleArrow(this, _function);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testBug406549_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Test<T> {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def m(T a, T b){}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("new StringBuilder => [");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("new Test<Object>().m(it, new Long(0))");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.ObjectExtensions;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Test<T extends Object> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Object m(final T a, final T b) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return null;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public StringBuilder m() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("StringBuilder _stringBuilder = new StringBuilder();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final Procedure1<StringBuilder> _function = new Procedure1<StringBuilder>() {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("public void apply(final StringBuilder it) {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("Test<Object> _test = new Test<Object>();");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("Long _long = new Long(0);");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("_test.m(it, _long);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return ObjectExtensions.<StringBuilder>operator_doubleArrow(_stringBuilder, _function);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testBug406549_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Test<T> {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def m(T a, T b){}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("new Test<Object>().m(null, new Long(0))");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Test<T extends Object> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Object m(final T a, final T b) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return null;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Object m() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Test<Object> _test = new Test<Object>();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Long _long = new Long(0);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _test.m(null, _long);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testBug406549_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Test<T> {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def m(T a, T b){}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("new Test().m(\'\', new Long(0))");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Test<T extends Object> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Object m(final T a, final T b) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return null;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Object m() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Test<Object> _test = new Test<Object>();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Long _long = new Long(0);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _test.m(\"\", _long);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
