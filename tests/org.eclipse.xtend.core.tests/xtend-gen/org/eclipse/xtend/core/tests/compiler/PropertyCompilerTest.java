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
public class PropertyCompilerTest extends AbstractXtendCompilerTest {
  @Test
  public void compileProperty() {
    final GeneratorConfig generatorConfig = this.generatorConfigProvider.get(null);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Property");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("boolean generateExpressions = true");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package foo;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Bar {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private boolean _generateExpressions = true;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public boolean isGenerateExpressions() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this._generateExpressions;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void setGenerateExpressions(final boolean generateExpressions) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("this._generateExpressions = generateExpressions;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1, generatorConfig);
  }
  
  @Test
  public void compileReadonlyPropertyWithoutType() {
    final GeneratorConfig generatorConfig = this.generatorConfigProvider.get(null);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Property");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val string = \'\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private final String _string = \"\";");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String getString() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this._string;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1, generatorConfig);
  }
  
  @Test
  public void compilePropertyWithoutType() {
    final GeneratorConfig generatorConfig = this.generatorConfigProvider.get(null);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Property");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("var string = \'\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private String _string = \"\";");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String getString() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this._string;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void setString(final String string) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("this._string = string;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1, generatorConfig);
  }
  
  @Test
  public void compilePropertyWithTypeParameter() {
    final GeneratorConfig generatorConfig = this.generatorConfigProvider.get(null);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Property");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("var T t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C<T extends Object> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private T _t;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public T getT() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this._t;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void setT(final T t) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("this._t = t;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1, generatorConfig);
  }
  
  @Test
  public void compilePropertyWithoutTypeButTypeParameter() {
    final GeneratorConfig generatorConfig = this.generatorConfigProvider.get(null);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Property");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("var iterable = null as Iterable<T>");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C<T extends Object> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private Iterable<T> _iterable = ((Iterable<T>) null);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Iterable<T> getIterable() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this._iterable;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void setIterable(final Iterable<T> iterable) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("this._iterable = iterable;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1, generatorConfig);
  }
}
