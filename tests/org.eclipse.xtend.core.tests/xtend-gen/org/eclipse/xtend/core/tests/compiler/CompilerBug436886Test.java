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
public class CompilerBug436886Test extends AbstractXtendCompilerTest {
  @Test
  public void test_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Test {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new((Super)=>boolean lambda) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def method() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new Test [   ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// Type mismatch: cannot convert from (Super & I)=>boolean to (Super)=>boolean");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("switch it {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("Foo: true");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("Bar: true");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("default: false");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface I {}");
    _builder.newLine();
    _builder.append("class Super {}");
    _builder.newLine();
    _builder.append("class Foo extends Super implements I {}");
    _builder.newLine();
    _builder.append("class Bar extends Super implements I {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Functions.Function1;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Test {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Test(final Function1<? super Super, ? extends Boolean> lambda) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Test method() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final Function1<Super, Boolean> _function = new Function1<Super, Boolean>() {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("public Boolean apply(final Super it) {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("boolean _switchResult = false;");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("boolean _matched = false;");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("if (it instanceof Foo) {");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("_matched=true;");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("_switchResult = true;");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("if (!_matched) {");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("if (it instanceof Bar) {");
    _builder_1.newLine();
    _builder_1.append("            ");
    _builder_1.append("_matched=true;");
    _builder_1.newLine();
    _builder_1.append("            ");
    _builder_1.append("_switchResult = true;");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("if (!_matched) {");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("_switchResult = false;");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("return Boolean.valueOf(_switchResult);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return new Test(_function);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
