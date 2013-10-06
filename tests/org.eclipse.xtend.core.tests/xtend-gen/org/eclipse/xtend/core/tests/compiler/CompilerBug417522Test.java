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
public class CompilerBug417522Test extends AbstractXtendCompilerTest {
  @Test
  public void test_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.lang.annotation.Annotation");
    _builder.newLine();
    _builder.append("class Bug {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def demo(Instance<Bug> instance) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("instance.select(Bug)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface Instance<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def Instance<T> select(Annotation qualifiers);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def <U extends T> Instance<U> select(Class<U> subtype);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Bug {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Instance<Bug> demo(final Instance<Bug> instance) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Instance<Bug> _select = instance.<Bug>select(Bug.class);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _select;");
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
    _builder.append("import java.lang.annotation.Annotation");
    _builder.newLine();
    _builder.append("class Bug {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def demo(Instance<Bug> instance) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("instance.select(Sub)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class Sub extends Bug {}");
    _builder.newLine();
    _builder.append("interface Instance<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def Instance<T> select(Annotation qualifiers);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def <U extends T> Instance<U> select(Class<U> subtype);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Bug {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Instance<Sub> demo(final Instance<Bug> instance) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Instance<Sub> _select = instance.<Sub>select(Sub.class);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _select;");
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
    _builder.append("import java.lang.annotation.Annotation");
    _builder.newLine();
    _builder.append("class Bug {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("var Instance<Bug> instance");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def demo() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("instance.select(Bug)");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("instance.select()");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("instance.select(#[])");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("instance.select(Bug, #[])");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface Instance<T> {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def Instance<T> select(Annotation... qualifiers);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def <U extends T> Instance<U> select(Class<U> subtype, Annotation... qualifiers);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.lang.annotation.Annotation;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Bug {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private Instance<Bug> instance;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Instance<Bug> demo() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Instance<Bug> _xblockexpression = null;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("this.instance.<Bug>select(Bug.class);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("this.instance.select();");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("this.instance.select(new Annotation[] {});");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("Instance<Bug> _select = this.instance.<Bug>select(Bug.class, new Annotation[] {});");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_xblockexpression = (_select);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _xblockexpression;");
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
    _builder.append("import java.lang.annotation.Annotation");
    _builder.newLine();
    _builder.append("class Bug {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def demo(Instance<Bug> instance) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("instance.select(Sub)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface Sub extends Iterable<Bug> {}");
    _builder.newLine();
    _builder.append("interface Instance<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def Instance<T> select(Annotation qualifiers);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def <U extends Iterable<T>> Instance<U> select(Class<U> subtype);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Bug {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Instance<Sub> demo(final Instance<Bug> instance) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Instance<Sub> _select = instance.<Sub>select(Sub.class);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _select;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
