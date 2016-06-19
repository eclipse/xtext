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
public class CompilerBug452821Test extends AbstractXtendCompilerTest {
  @Test
  public void test_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class AnonymousClassTest {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def test() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("new Exception(\"\") {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("var String field");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class AnonymousClassTest {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Exception test() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("abstract class __AnonymousClassTest_1 extends Exception {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("__AnonymousClassTest_1(final String arg0) {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("super(arg0);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("String field;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return new __AnonymousClassTest_1(\"\") {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
