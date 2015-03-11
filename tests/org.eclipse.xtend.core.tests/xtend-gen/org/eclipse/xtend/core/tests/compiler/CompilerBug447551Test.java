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
public class CompilerBug447551Test extends AbstractXtendCompilerTest {
  @Test
  public void test_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public val E e = E.copy");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static def D copy() { null }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class E extends D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static def E copy() { null }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public final E e = E.copy();");
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
    _builder.append("public val E e = E.copy");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static def <T> D<T> copy() { null }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class E<T> extends D<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static def <T> E<T> copy() { null }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public final E e = E.<Object>copy();");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void test_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public val E<String> e = E.copy(newArrayList)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static def <T> D<T> copy(Iterable<T> it) { null }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class E<T> extends D<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static def <T> E<T> copy(Iterable<T> it) { null }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public final E<String> e = E.<String>copy(CollectionLiterals.<String>newArrayList());");
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
    _builder.append("public val e = E.copy(newArrayList)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static def <T> D<T> copy(Iterable<T> it) { null }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class E<T> extends D<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static def <T> E<T> copy(Iterable<T> it) { null }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public final E<Object> e = E.<Object>copy(CollectionLiterals.<Object>newArrayList());");
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
    _builder.append("public val e = E.copy(newArrayList)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static class D<T> {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("static def <T> D<T> copy(Iterable<T> it) throws java.io.IOException { null }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static class E<T> extends D<T> {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("static def <T> E<T> copy(Iterable<T> it) throws java.io.IOException { null }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.io.IOException;");
    _builder_1.newLine();
    _builder_1.append("import java.util.ArrayList;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Exceptions;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Functions.Function0;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public static class D<T extends Object> {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("public static <T extends Object> C.D<T> copy(final Iterable<T> it) throws IOException {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return null;");
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
    _builder_1.append("public static class E<T extends Object> extends C.D<T> {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("public static <T extends Object> C.E<T> copy(final Iterable<T> it) throws IOException {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return null;");
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
    _builder_1.append("public final C.E<Object> e = new Function0<C.E<Object>>() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("public C.E<Object> apply() {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("try {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList();");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("C.E<Object> _copy = C.E.<Object>copy(_newArrayList);");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("return _copy;");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("} catch (Throwable _e) {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("throw Exceptions.sneakyThrow(_e);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}.apply();");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
