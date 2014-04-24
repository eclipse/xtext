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
public class CompilerBugInheritedDispatchTest extends AbstractXtendCompilerTest {
  @Test
  public void test_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class D extends C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch void m(Integer o) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch void m(CharSequence o) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class C extends B {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch void m(Number o) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class B extends A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch void m(String o) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch void m(Object o) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Arrays;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class D extends C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("protected void _m(final Integer o) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("protected void _m(final CharSequence o) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void m(final Object o) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (o instanceof Integer) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_m((Integer)o);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else if (o instanceof Number) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_m((Number)o);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else if (o instanceof String) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_m((String)o);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else if (o instanceof CharSequence) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_m((CharSequence)o);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else if (o != null) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_m(o);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("throw new IllegalArgumentException(\"Unhandled parameter types: \" +");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("Arrays.<Object>asList(o).toString());");
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
