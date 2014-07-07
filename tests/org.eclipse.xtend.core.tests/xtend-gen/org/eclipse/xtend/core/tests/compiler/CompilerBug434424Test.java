/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
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
public class CompilerBug434424Test extends AbstractXtendCompilerTest {
  @Test
  public void test_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def String m(CharSequence c) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val int i = m(\'\')");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return String.valueOf(i)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static int m(String s) { return 1 }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String m(final CharSequence c) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final int i = C.m(\"\");");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return String.valueOf(i);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public static int m(final String s) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return 1;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void test_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def String m(String c) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return m(\'\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void m(CharSequence s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String m(final String c) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this.m(\"\");");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public static void m(final CharSequence s) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void test_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static C.D.d");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def int m(D it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("d(\'\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static class D {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("def String d(CharSequence c) {}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("def static int d(String s) { 0 }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public static class D {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("public String d(final CharSequence c) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return null;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("public static int d(final String s) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return 0;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public int m(final C.D it) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return C.D.d(\"\");");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void test_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n(String s) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("s+s");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void +(String s1, String s2) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void n(final String s) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("C.operator_plus(s, s);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public static void operator_plus(final String s1, final String s2) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void test_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static String string");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def String getString() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("string");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private static String string;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String getString() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return C.string;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void test_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static m(String s) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Class.forName(s)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Exceptions;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public static Class<?> m(final String s) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("try {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return Class.forName(s);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} catch (Throwable _e) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("throw Exceptions.sneakyThrow(_e);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void test_07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static extension Ext.*");
    _builder.newLine();
    _builder.append("class Client {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def m(C c) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("c.m(\'\')");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("static def m(String s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class Ext {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("static def m(C c, String s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Client {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Object m(final C c) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return Ext.m(c, \"\");");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void test_08() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static extension Ext.*");
    _builder.newLine();
    _builder.append("class Client {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def static m(C c) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("c.m(\'\')");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("static def m(String s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class Ext {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("static def m(C c, String s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Client {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public static Object m(final C c) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return Ext.m(c, \"\");");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void test_09() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Client {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("extension Ext");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def m(C c) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("c.m(\'\')");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("static def m(String s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class Ext {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def m(C c, String s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Extension;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Client {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Extension");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private Ext _ext;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Object m(final C c) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this._ext.m(c, \"\");");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
