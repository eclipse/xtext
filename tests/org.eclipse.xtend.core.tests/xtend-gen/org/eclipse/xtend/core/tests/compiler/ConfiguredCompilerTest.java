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
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ConfiguredCompilerTest extends AbstractXtendCompilerTest {
  @Test
  public void compileWithConfiguration() {
    final GeneratorConfig generatorConfig = this.generatorConfigProvider.get(null);
    generatorConfig.setGenerateSyntheticSuppressWarnings(false);
    generatorConfig.setGenerateExpressions(false);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* javadoc");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("1 + 1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package foo;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* javadoc");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("public class Bar {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public int foo() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("throw new UnsupportedOperationException(\"foo is not implemented\");");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1, generatorConfig);
  }
  
  @Test
  public void testAnnotationWithValueArray_01() {
    final GeneratorConfig generatorConfig = this.generatorConfigProvider.get(null);
    generatorConfig.setGenerateSyntheticSuppressWarnings(false);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@SuppressWarnings(#[ \'abc\', \'efg\' ])");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings({ \"abc\", \"efg\" })");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1, generatorConfig);
  }
  
  @Test
  public void testAnnotationWithValueArray_02() {
    final GeneratorConfig generatorConfig = this.generatorConfigProvider.get(null);
    generatorConfig.setGenerateSyntheticSuppressWarnings(false);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@SuppressWarnings(\'abc\', \'efg\')");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings({ \"abc\", \"efg\" })");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1, generatorConfig);
  }
  
  @Test
  public void compileWithConfiguration_2() {
    final GeneratorConfig generatorConfig = this.generatorConfigProvider.get(null);
    generatorConfig.setGenerateSyntheticSuppressWarnings(true);
    generatorConfig.setGenerateExpressions(false);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* javadoc");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"unused\")");
    _builder.newLine();
    _builder.append("class Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("1 + 1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package foo;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* javadoc");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Bar {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public int foo() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("throw new UnsupportedOperationException(\"foo is not implemented\");");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1, generatorConfig);
  }
  
  @Test
  public void compileWithConfiguration_3() {
    final GeneratorConfig generatorConfig = this.generatorConfigProvider.get(null);
    generatorConfig.setGenerateSyntheticSuppressWarnings(true);
    generatorConfig.setGenerateExpressions(false);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* javadoc");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"unused\")");
    _builder.newLine();
    _builder.append("class Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("1 + 1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package foo;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* javadoc");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("@Deprecated");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Bar {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public int foo() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("throw new UnsupportedOperationException(\"foo is not implemented\");");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1, generatorConfig);
  }
}
