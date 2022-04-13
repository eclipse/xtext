/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.compiler;

import org.eclipse.xtend.core.tests.SingletonGeneratorConfigRuntimeInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.junit.Test;

/**
 * Tests for <a href="https://github.com/eclipse/xtext-xtend/issues/484">https://github.com/eclipse/xtext-xtend/issues/484</a>
 * 
 * @author Michael Keppler - Initial contribution and API
 */
@InjectWith(SingletonGeneratorConfigRuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class CompilerBugDispatchWithOverrideTest extends AbstractXtendCompilerTest {
  @Test
  public void testDispatchWithOverrideJava6HasAnnotation() {
    final GeneratorConfig generatorConfig = this.generatorConfigProvider.get(null);
    generatorConfig.setJavaSourceVersion(JavaVersion.JAVA6);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Something extends AbstractSomething {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override dispatch void m(String x) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class AbstractSomething {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected def dispatch void m(String x) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected def dispatch void m(Integer x) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Arrays;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Something extends AbstractSomething {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("protected void _m(final String x) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void m(final Object x) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (x instanceof Integer) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_m((Integer)x);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else if (x instanceof String) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_m((String)x);");
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
    _builder_1.append("Arrays.<Object>asList(x).toString());");
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
  public void testDispatchWithOverrideJava5HasNoAnnotation() {
    final GeneratorConfig generatorConfig = this.generatorConfigProvider.get(null);
    generatorConfig.setJavaSourceVersion(JavaVersion.JAVA5);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Something extends AbstractSomething {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override dispatch void m(String x) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class AbstractSomething {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected def dispatch void m(String x) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected def dispatch void m(Integer x) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Arrays;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Something extends AbstractSomething {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("protected void _m(final String x) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void m(final Object x) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (x instanceof Integer) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_m((Integer)x);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else if (x instanceof String) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_m((String)x);");
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
    _builder_1.append("Arrays.<Object>asList(x).toString());");
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
