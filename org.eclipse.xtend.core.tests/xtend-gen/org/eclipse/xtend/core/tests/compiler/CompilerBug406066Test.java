/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
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
 * @author Karsten Thoms - Initial contribution and API
 */
@SuppressWarnings("all")
public class CompilerBug406066Test extends AbstractXtendCompilerTest {
  @Test
  public void testBug406066_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Error {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static err(Integer i) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("i.toString");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Error {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public static String err(final Integer i) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return i.toString();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testBug406066_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Error {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static err(Integer i) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("i.toString");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val java.lang.Error e = new AssertionError()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Error {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public static void err(final Integer i) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("i.toString();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final java.lang.Error e = new AssertionError();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testBug406066_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Error2 {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static err(Integer i) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("i.toString");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val Error e = new AssertionError()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Error2 {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public static void err(final Integer i) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("i.toString();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final Error e = new AssertionError();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
