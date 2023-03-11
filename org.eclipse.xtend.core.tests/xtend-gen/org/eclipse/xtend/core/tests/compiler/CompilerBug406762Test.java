/**
 * Copyright (c) 2016 TypeFox.io (http://www.typefox.io) and others.
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
 * @author Lorenzo Bettini - Initial contribution and API
 */
@SuppressWarnings("all")
public class CompilerBug406762Test extends AbstractXtendCompilerTest {
  @Test
  public void testMyExceptionReturnsThisAsThrowable() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Bug {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static final class MyException extends Exception {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("override synchronized Throwable fillInStackTrace() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return this;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Bug {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private static final class MyException extends Exception {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("public synchronized Throwable fillInStackTrace() {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return this;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }

  @Test
  public void testMyExceptionImpicitlyReturnsThisAsThrowable() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Bug {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static final class MyException extends Exception {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("override synchronized Throwable fillInStackTrace() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("this");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Bug {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private static final class MyException extends Exception {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("public synchronized Throwable fillInStackTrace() {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return this;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
