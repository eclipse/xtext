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
public class CompilerBug440902Test extends AbstractXtendCompilerTest {
  @Test
  public void test_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C implements I {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def String m2(Object o) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m.toString() // unresolveable");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throw new RuntimeException()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface I {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def String m()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C implements I {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String m2(final Object o) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("String _m = this.m();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _m.toString();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String m() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("throw new RuntimeException();");
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
    _builder.append("class C implements I {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throw new RuntimeException()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface I {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def String m()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C implements I {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String m() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("throw new RuntimeException();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
