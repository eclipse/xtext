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
public class CompilerBug438483Test extends AbstractXtendCompilerTest {
  @Test
  public void test_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static extension TestExt.$");
    _builder.newLine();
    _builder.append("class TestStdExt {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def test() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val t = $(5,false)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class TestExt {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static $(int a, boolean b) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new Pair<Integer, Boolean>(a,b)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Pair;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class TestStdExt {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void test() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final Pair<Integer, Boolean> t = TestExt.$(5, false);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
