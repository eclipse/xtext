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
public class CompilerBug418364Test extends AbstractXtendCompilerTest {
  @Test
  public void test_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m(R r, String[] args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("r.setInput(args)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class G<E,I> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void setInput(I i) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class R extends G {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void m(final R r, final String[] args) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("r.setInput(args);");
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
    _builder.append("def m(R r) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("r.setInput(#[])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class G<E,I> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void setInput(I i) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class R extends G {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Collections;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void m(final R r) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("r.setInput(Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList()));");
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
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m(R r) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("r.setInput(#[])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class G<E,I extends String> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void setInput(Iterable<I> i) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class R extends G {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Collections;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void m(final R r) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("r.setInput(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList()));");
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
    _builder.append("def m(R r) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("r.setInput(#[])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class G<E,I> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void setInput(Iterable<I> i) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class G2<T extends Number> extends G<String, T> {}");
    _builder.newLine();
    _builder.append("class R extends G2 {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Collections;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void m(final R r) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("r.setInput(Collections.<Number>unmodifiableList(CollectionLiterals.<Number>newArrayList()));");
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
    _builder.append("def m(R r) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("r.setInput(#[])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class G<E,I> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void setInput(I i) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class G2<T extends Number> extends G<String, Iterable<T>> {}");
    _builder.newLine();
    _builder.append("class R extends G2 {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Collections;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void m(final R r) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("r.setInput(Collections.<Number>unmodifiableList(CollectionLiterals.<Number>newArrayList()));");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
