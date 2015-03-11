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
public class CompilerBug448221Test extends AbstractXtendCompilerTest {
  @Test
  public void test_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package sample");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("var Object[] arr = #[]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def build() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.arr.m");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def private m(Object... styles) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("0");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def private m(E e) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("switch e {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("case E.V: 0");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("enum E { V }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package sample;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public enum E {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("V;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private Object[] arr = {};");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public int build() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this.m(this.arr);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private int m(final Object... styles) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return 0;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private int m(final C.E e) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("int _switchResult = (int) 0;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (e != null) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("switch (e) {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("case V:");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("_switchResult = 0;");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("break;");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("default:");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("break;");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _switchResult;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
