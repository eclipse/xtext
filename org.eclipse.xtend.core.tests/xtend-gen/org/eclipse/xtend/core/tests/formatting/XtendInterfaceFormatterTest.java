/**
 * Copyright (c) 2013, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.formatting;

import java.util.function.Consumer;
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.formatter.AbstractFormatterTest;
import org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(RuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class XtendInterfaceFormatterTest extends AbstractFormatterTest {
  @Test
  public void formatField01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnformattedEqualsFormatted(_builder);
  }

  @Test
  public void formatField02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int foo");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int baz");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnformattedEqualsFormatted(_builder);
  }

  @Test
  public void formatFieldInit01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int foo = 1 + 1");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnformattedEqualsFormatted(_builder);
  }

  @Test
  public void formatFieldInit02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int foo = 1 + 1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int baz = 1 + 1");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnformattedEqualsFormatted(_builder);
  }

  @Test
  public void formatFieldVal() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val int foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnformattedEqualsFormatted(_builder);
  }

  @Test
  public void formatFieldFinal() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("final int foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnformattedEqualsFormatted(_builder);
  }

  @Test
  public void formatFieldPublicFinal() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public final int foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnformattedEqualsFormatted(_builder);
  }

  @Test
  public void formatFieldStatic02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static int bar");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnformattedEqualsFormatted(_builder);
  }

  @Test
  public void formatFieldStatic03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static int bar");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnformattedEqualsFormatted(_builder);
  }

  @Test
  public void formatFieldStaticVal() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static val int foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnformattedEqualsFormatted(_builder);
  }

  @Test
  public void formatFieldStaticFinal() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final int foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnformattedEqualsFormatted(_builder);
  }

  @Test
  public void formatFieldPublicStaticFinal() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static final int foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnformattedEqualsFormatted(_builder);
  }

  @Test
  public void formatMethod01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnformattedEqualsFormatted(_builder);
  }

  @Test
  public void formatMethod02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("interface bar");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Consumer<MapBasedPreferenceValues> _function = (MapBasedPreferenceValues it) -> {
      it.<Boolean>put(XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(true));
    };
    this.assertUnformattedEqualsFormatted(_builder, _function);
  }

  @Test
  public void formatMethod03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("interface bar");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("abstract def baz()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Consumer<MapBasedPreferenceValues> _function = (MapBasedPreferenceValues it) -> {
      it.<Boolean>put(XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(true));
    };
    this.assertUnformattedEqualsFormatted(_builder, _function);
  }

  @Test
  public void formatMethod04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("interface bar");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public abstract def baz()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Consumer<MapBasedPreferenceValues> _function = (MapBasedPreferenceValues it) -> {
      it.<Boolean>put(XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(true));
    };
    this.assertUnformattedEqualsFormatted(_builder, _function);
  }

  @Test
  public void formatMethod1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz(String x)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnformattedEqualsFormatted(_builder);
  }

  @Test
  public void formatMethod2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz(String x, String y)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnformattedEqualsFormatted(_builder);
  }

  @Test
  public void formatMethod3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz(String p1, String p2, String p3, String p4, String p5, String p6,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String p7, String p8, String p9, String p10, String p11, String p12,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String p13, String p14)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Consumer<MapBasedPreferenceValues> _function = (MapBasedPreferenceValues it) -> {
      it.<Integer>put(FormatterPreferenceKeys.maxLineWidth, Integer.valueOf(80));
    };
    this.assertUnformattedEqualsFormatted(_builder, _function);
  }

  @Test
  public void formatMethod4() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("abstract interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo()");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnformattedEqualsFormatted(_builder);
  }

  @Test
  public void formatMethodMultiline() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz(String x, String y");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(")");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package foo");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("interface bar {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def baz(");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("String x,");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("String y");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertFormattedTo(_builder, _builder_1);
  }

  @Test
  public void formatMethodAnnotation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Deprecated def baz()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnformattedEqualsFormatted(_builder);
  }
}
