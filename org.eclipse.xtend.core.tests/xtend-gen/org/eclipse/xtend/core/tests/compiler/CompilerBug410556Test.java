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
public class CompilerBug410556Test extends AbstractXtendCompilerTest {
  @Test
  public void testConstructorTypeParameter_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new bug413824.ConstructorTypeParameter(\'\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import bug413824.ConstructorTypeParameter;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void m() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("new <String>ConstructorTypeParameter(\"\");");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testConstructorTypeParameter_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Integer i, String s) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new bug413824.ConstructorAndClassTypeParameter(i, s)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import bug413824.ConstructorAndClassTypeParameter;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void m(final Integer i, final String s) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("new <String>ConstructorAndClassTypeParameter<Integer>(i, s);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void test_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class BugTypeInference<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(Class<T> c) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void main(String[] args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new BugTypeInference(Object)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class BugTypeInference<T extends Object> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public BugTypeInference(final Class<T> c) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public static void main(final String[] args) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("new BugTypeInference<Object>(Object.class);");
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
    _builder.append("class BugTypeInference<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(Class<T> c) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void main(String[] args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val b = new BugTypeInference(Object)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("b.toString");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class BugTypeInference<T extends Object> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public BugTypeInference(final Class<T> c) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public static void main(final String[] args) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final BugTypeInference<Object> b = new BugTypeInference<Object>(Object.class);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("b.toString();");
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
    _builder.append("class BugTypeInference<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(Class<T> c) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void main(String[] args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val BugTypeInference<Iterable<String>> b = new BugTypeInference(Iterable)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("b.toString");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class BugTypeInference<T extends Object> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public BugTypeInference(final Class<T> c) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public static void main(final String[] args) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final BugTypeInference<Iterable<String>> b = new BugTypeInference(Iterable.class);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("b.toString();");
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
    _builder.append("class BugTypeInference<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(Class<T> c) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void main(String[] args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val b = new BugTypeInference(typeof(Object).getClass)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("b.toString");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class BugTypeInference<T extends Object> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public BugTypeInference(final Class<T> c) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public static void main(final String[] args) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Class<? extends Class> _class = Object.class.getClass();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final BugTypeInference<? extends Class> b = new BugTypeInference(_class);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("b.toString();");
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
    _builder.append("class BugTypeInference<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(Class<T> c) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void main(String[] args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val b = new BugTypeInference(Iterable)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("b.toString");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class BugTypeInference<T extends Object> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public BugTypeInference(final Class<T> c) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public static void main(final String[] args) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final BugTypeInference<Iterable> b = new BugTypeInference<Iterable>(Iterable.class);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("b.toString();");
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
    _builder.append("class BugTypeInference<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(Class<T> c) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void main(String[] args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val BugTypeInference<Class> b = new BugTypeInference(typeof(Object).getClass)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("b.toString");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class BugTypeInference<T extends Object> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public BugTypeInference(final Class<T> c) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public static void main(final String[] args) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Class<? extends Class> _class = Object.class.getClass();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final BugTypeInference<Class> b = new BugTypeInference(_class);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("b.toString();");
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
    _builder.append("class BugTypeInference<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(Class<T> c) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void main(String[] args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val BugTypeInference b = new BugTypeInference(typeof(Object).getClass)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("b.toString");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class BugTypeInference<T extends Object> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public BugTypeInference(final Class<T> c) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public static void main(final String[] args) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Class<? extends Class> _class = Object.class.getClass();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final BugTypeInference b = new BugTypeInference(_class);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("b.toString();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
