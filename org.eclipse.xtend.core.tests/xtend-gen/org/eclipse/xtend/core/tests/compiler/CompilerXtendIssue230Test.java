/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
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
 * @author Christian Dietrich - Initial contribution and API
 */
@SuppressWarnings("all")
public class CompilerXtendIssue230Test extends AbstractXtendCompilerTest {
  @Test
  public void testIssue230() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package b;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.annotations.Accessors;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend2.lib.StringConcatenation;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.xbase.lib.Pure;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"all\")");
    _builder.newLine();
    _builder.append("public class MyTest {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("@Accessors");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public static class A1 {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("private String name;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("@Pure");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public String getName() {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("return this.name;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public void setName(final String name) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("this.name = name;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("@Accessors");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public static class A2 {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("private String name;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("@Pure");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public String getName() {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("return this.name;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public void setName(final String name) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("this.name = name;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public CharSequence doItWithNumber(final Object n) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("StringConcatenation _builder = new StringConcatenation();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("if ((n instanceof MyTest.A1)) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("_builder.append(\"A1: \");");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("_builder.append(((MyTest.A1)n).name);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("_builder.newLineIfNotEmpty();");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if ((n instanceof MyTest.A2)) {");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("_builder.append(\"A2: \");");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("_builder.append(((MyTest.A2)n).name);");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("_builder.newLineIfNotEmpty();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("_builder.append(\"Else: \");");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("_builder.append(n);");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("_builder.newLineIfNotEmpty();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return _builder;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertCompilesTo("\n\t\tpackage b\n\t\t\n\t\timport org.eclipse.xtend.lib.annotations.Accessors\n\t\t\n\t\tclass MyTest {\n\t\t\t\n\t\t\t@Accessors\n\t\t\tstatic class A1 {String name}\n\t\t\t@Accessors\n\t\t\tstatic class A2 {String name}\n\t\t\t\n\t\t\tdef doItWithNumber(Object n) \'\'\'\n\t\t\t«IF n instanceof A1»\n\t\t\t\tA1: «n.name»\n\t\t\t«ELSEIF n instanceof A2»\n\t\t\t\tA2: «n.name»\n\t\t\t«ELSE»\n\t\t\t\tElse: «n»\n\t\t\t«ENDIF»\n\t\t\t\'\'\'\n\t\t}\n\t\t", _builder);
  }
}
