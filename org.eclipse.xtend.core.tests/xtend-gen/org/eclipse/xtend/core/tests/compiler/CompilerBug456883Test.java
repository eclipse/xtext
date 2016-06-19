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
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class CompilerBug456883Test extends AbstractXtendCompilerTest {
  @Test
  public void test_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.ArrayList");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class XtendCompilationError {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("new ArrayList() => [");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("val finalValue = 1");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("add(");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("new Object() {");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("override toString() {");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("return \"\" + finalValue // ERROR");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("})");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.ArrayList;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.ObjectExtensions;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class XtendCompilationError {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public XtendCompilationError() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("ArrayList<Object> _arrayList = new ArrayList<Object>();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final Procedure1<ArrayList<Object>> _function = new Procedure1<ArrayList<Object>>() {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("public void apply(final ArrayList<Object> it) {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("final int finalValue = 1;");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("it.add(");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("new Object() {");
    _builder_1.newLine();
    _builder_1.append("            ");
    _builder_1.append("public String toString() {");
    _builder_1.newLine();
    _builder_1.append("              ");
    _builder_1.append("return (\"\" + Integer.valueOf(finalValue));");
    _builder_1.newLine();
    _builder_1.append("            ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("});");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("ObjectExtensions.<ArrayList<Object>>operator_doubleArrow(_arrayList, _function);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
