/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.compiler;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

/**
 * @author Stéphane Galland - Initial Contribution
 * @author Christian Dietrich - Fixed broken test
 */
@SuppressWarnings("all")
public class InlineInXtendTest extends AbstractXtendCompilerTest {
  @Test
  public void testDataClasses_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtext.xbase.lib.Inline;");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Inline(value = \"3\", constantExpression = true)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def int fct() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return 3");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def int fct2() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return fct() + 1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Inline;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Inline(value = \"3\", constantExpression = true)");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public int fct() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return 3;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public int fct2() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("int _fct = 3;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return (_fct + 1);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
