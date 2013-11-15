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
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class AnnotationValueCompilerTest extends AbstractXtendCompilerTest {
  @Test
  public void testAnnotationValues_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.append("@test.Annotation(");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("booleanValue = true,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("intValue = 1,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("longValue = 42,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("stringValue = \'foo\',");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("booleanArrayValue = #[true],");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("intArrayValue = #[1],");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("longArrayValue = #[42],");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("stringArrayValue = #[\'foo\'],");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("typeValue = String,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("typeArrayValue = #[String],");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("annotation2Value = @test.Annotation2(\'foo\'),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("annotation2ArrayValue = #[@test.Annotation2(\'foo\')]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(") class Bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package foo;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import test.Annotation;");
    _builder_1.newLine();
    _builder_1.append("import test.Annotation2;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@Annotation(booleanValue = true, intValue = 1, longValue = 42, stringValue = \"foo\", booleanArrayValue = true, intArrayValue = 1, longArrayValue = 42, stringArrayValue = \"foo\", typeValue = String.class, typeArrayValue = String.class, annotation2Value = @Annotation2(\"foo\"), annotation2ArrayValue = @Annotation2(\"foo\"))");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Bar {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testAnnotationValues_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.append("@test.Annotation(");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("intValue = 1 + 4 + 6 * 42 - 4 / 45,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("longValue = 42 + 4 + 6 * 42 - 4 / 45,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("stringValue = \'foo\' + \'baz\',");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("booleanArrayValue = #[true, false],");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("intArrayValue = #[ -1, 34 + 45, 2 - 6 ],");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("longArrayValue = #[42, 5 * -3],");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("stringArrayValue = #[\'foo\', \'bla\' + \'buzz\'],");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("typeValue = String,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("typeArrayValue = #[String, Integer],");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("annotation2Value = @test.Annotation2(\'foo\' + \'wuppa\'),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("annotation2ArrayValue = #[@test.Annotation2(\'foo\'), @test.Annotation2(\'foo\'+\'wuppa\')]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(") class Bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package foo;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import test.Annotation;");
    _builder_1.newLine();
    _builder_1.append("import test.Annotation2;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@Annotation(intValue = (((1 + 4) + (6 * 42)) - (4 / 45)), longValue = (((42 + 4) + (6 * 42)) - (4 / 45)), stringValue = (\"foo\" + \"baz\"), booleanArrayValue = { true, false }, intArrayValue = { (-1), (34 + 45), (2 - 6) }, longArrayValue = { 42, (5 * (-3)) }, stringArrayValue = { \"foo\", (\"bla\" + \"buzz\") }, typeValue = String.class, typeArrayValue = { String.class, Integer.class }, annotation2Value = @Annotation2((\"foo\" + \"wuppa\")), annotation2ArrayValue = { @Annotation2(\"foo\"), @Annotation2((\"foo\" + \"wuppa\")) })");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Bar {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testAnnotationValues_constants() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.append("@test.Annotation(");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("intValue = test.Constants1.INT_CONSTANT + 4 + test.Constants1.INT_CONSTANT / 45");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(") class Bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package foo;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import test.Annotation;");
    _builder_1.newLine();
    _builder_1.append("import test.Constants1;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@Annotation(intValue = ((Constants1.INT_CONSTANT + 4) + (Constants1.INT_CONSTANT / 45)))");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Bar {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testAnnotationValues_enums() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.append("@test.Annotation(");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("enumValue = test.Enum1.RED,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("enumArrayValue = #[test.Enum1.RED, test.Enum1.BLUE]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(") class Bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package foo;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import test.Annotation;");
    _builder_1.newLine();
    _builder_1.append("import test.Enum1;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@Annotation(enumValue = Enum1.RED, enumArrayValue = { Enum1.RED, Enum1.BLUE })");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Bar {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
