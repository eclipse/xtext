/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.compiler;

import compound.IntCompoundExtensions;
import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class CompoundAssignmentOperatorCompilerTest extends AbstractXtendCompilerTest {
  @Before
  public void setupCompiler() {
    Class<? extends CompoundAssignmentOperatorCompilerTest> _class = this.getClass();
    this.compiler.addClassPathOfClass(_class);
    this.compiler.addClassPathOfClass(IntCompoundExtensions.class);
    Class<? extends CompoundAssignmentOperatorCompilerTest> _class_1 = this.getClass();
    ClassLoader _classLoader = _class_1.getClassLoader();
    this.compiler.setParentClassLoader(_classLoader);
  }
  
  @Test
  public void test_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static extension compound.IntCompoundExtensions.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("var i = 2");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("i += i *= 2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public int foo() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("int _xblockexpression = (int) 0;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("int i = 2;");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("int _multiplyAssign = i *= 2;");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_xblockexpression = (i += _multiplyAssign);");
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
  public void test_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static extension compound.IntCompoundExtensions.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("var i = 2");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("i *= i += 2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public int foo() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("int _xblockexpression = (int) 0;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("int i = 2;");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("int _add = i += 2;");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_xblockexpression = (i *= _add);");
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
}
