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
 * @author Holger Schill - Initial contribution and API
 */
@SuppressWarnings("all")
public class CompilerBug431332Test extends AbstractXtendCompilerTest {
  @Test
  public void testInnerClassRef() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class TestOuterClazz {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val bug = new testclazzes.TestOuterClazz.Nested");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class TestOuterClazz {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private final testclazzes.TestOuterClazz.Nested bug = new testclazzes.TestOuterClazz.Nested();");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testInnerClassRef_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Clazz {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val bug = new testclazzes.TestOuterClazz.Nested");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import testclazzes.TestOuterClazz;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Clazz {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private final TestOuterClazz.Nested bug = new TestOuterClazz.Nested();");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
