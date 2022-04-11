/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro;

import org.eclipse.xtend.core.compiler.batch.XtendCompilerTester;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.IAcceptor;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class CompilationStrategyBlankLineTest extends AbstractActiveAnnotationTest {
  @Test
  public void testTrimEmptyLines() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtend.core.tests.macro.ArtificialMethods");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@ArtificialMethods");
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IAcceptor<XtendCompilerTester.CompilationResult> _function = (XtendCompilerTester.CompilationResult it) -> {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("import java.math.BigDecimal;");
      _builder_1.newLine();
      _builder_1.append("import java.util.ArrayList;");
      _builder_1.newLine();
      _builder_1.append("import java.util.List;");
      _builder_1.newLine();
      _builder_1.append("import org.eclipse.xtend.core.tests.macro.ArtificialMethods;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("@ArtificialMethods");
      _builder_1.newLine();
      _builder_1.append("@SuppressWarnings(\"all\")");
      _builder_1.newLine();
      _builder_1.append("public class A {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public void blank() {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public void blank_1() {");
      _builder_1.newLine();
      _builder_1.append("    \t\t\t\t");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public void blank_2() {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public void blank_3() {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public void blank_4() {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("int foo = 42;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public void blank_5() {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("int foo = 42;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public void blank_6() {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("int foo = 42;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public void blank_7() {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("List<? extends Object> list = new ArrayList<BigDecimal>();");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      Assert.assertEquals(_builder_1.toString(), it.getGeneratedCode("A"));
    };
    this._xtendCompilerTester.compile(_builder, _function);
  }
}
