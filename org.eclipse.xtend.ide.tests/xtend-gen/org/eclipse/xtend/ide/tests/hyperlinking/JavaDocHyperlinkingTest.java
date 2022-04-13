/**
 * Copyright (c) 2018, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.hyperlinking;

import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.xtend.ide.tests.XtendIDEInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractHyperlinkingTest;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XtendIDEInjectorProvider.class)
@SuppressWarnings("all")
public class JavaDocHyperlinkingTest extends AbstractHyperlinkingTest {
  @Before
  public void setup() {
    try {
      JavaProjectSetupUtil.createJavaProject(this.getProjectName());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void import_statement() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import ");
    _builder.append(this.c);
    _builder.append("java.util.Date");
    _builder.append(this.c);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Date date");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasHyperlinkToJavaDate(_builder);
  }

  @Test
  public void member_type() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* {@link java.util.Date}");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(this.c, "\t");
    _builder.append("Date");
    _builder.append(this.c, "\t");
    _builder.append(" date");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.hasHyperlinkToJavaDate(_builder);
  }

  @Test
  public void multi_line_comment_link() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* {@link ");
    _builder.append(this.c, " ");
    _builder.append("Date");
    _builder.append(this.c, " ");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasHyperlinkToJavaDate(_builder);
  }

  @Test
  public void multi_line_comment_see() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @see ");
    _builder.append(this.c, " ");
    _builder.append("Date");
    _builder.append(this.c, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasHyperlinkToJavaDate(_builder);
  }

  @Test
  public void javadoc_link_no_hyperlink_if_the_type_cannot_be_resolved() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* {@link ");
    _builder.append(this.c, " ");
    _builder.append("Date");
    _builder.append(this.c, " ");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasNoHyperlink(_builder);
  }

  @Test
  public void javadoc_see_no_hyperlink_if_the_type_cannot_be_resolved() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @see ");
    _builder.append(this.c, " ");
    _builder.append("Date");
    _builder.append(this.c, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasNoHyperlink(_builder);
  }

  @Test
  public void javadoc_link01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* {@link ");
    _builder.append(this.c, " ");
    _builder.append("java.util.Date");
    _builder.append(this.c, " ");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Date date");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasHyperlinkToJavaDate(_builder);
  }

  @Test
  public void javadoc_link02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* {@link ");
    _builder.append(this.c, " ");
    _builder.append("java.util.Date");
    _builder.append(this.c, " ");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* {@link java.lang.StringBuffer}");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasHyperlinkToJavaDate(_builder);
  }

  @Test
  public void javadoc_link03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* {@link java.lang.StringBuffer}");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* {@link ");
    _builder.append(this.c, " ");
    _builder.append("java.util.Date");
    _builder.append(this.c, " ");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasHyperlinkToJavaDate(_builder);
  }

  @Test
  public void javadoc_link04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* {@link ");
    _builder.append(this.c, " ");
    _builder.append("Date");
    _builder.append(this.c, " ");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Date date");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasHyperlinkToJavaDate(_builder);
  }

  @Test
  public void javadoc_link05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* {@link ");
    _builder.append(this.c, "\t ");
    _builder.append("Date");
    _builder.append(this.c, "\t ");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val a = 1");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasHyperlinkToJavaDate(_builder);
  }

  @Test
  public void javadoc_link06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Date date");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* {@link ");
    _builder.append(this.c, " ");
    _builder.append("Date");
    _builder.append(this.c, " ");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    this.hasHyperlinkToJavaDate(_builder);
  }

  @Test
  public void javadoc_link07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* {@link ");
    _builder.append(this.c, " ");
    _builder.append("Date");
    _builder.append(this.c, " ");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    this.hasHyperlinkToJavaDate(_builder);
  }

  @Test
  public void javadoc_see01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @see ");
    _builder.append(this.c, " ");
    _builder.append("java.util.Date");
    _builder.append(this.c, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Date date");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasHyperlinkToJavaDate(_builder);
  }

  @Test
  public void javadoc_see02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @see ");
    _builder.append(this.c, " ");
    _builder.append("java.util.Date");
    _builder.append(this.c, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* @see java.lang.StringBuffer");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasHyperlinkToJavaDate(_builder);
  }

  @Test
  public void javadoc_see03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @see java.lang.StringBuffer");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @see ");
    _builder.append(this.c, " ");
    _builder.append("java.util.Date");
    _builder.append(this.c, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasHyperlinkToJavaDate(_builder);
  }

  @Test
  public void javadoc_see04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @see ");
    _builder.append(this.c, " ");
    _builder.append("Date");
    _builder.append(this.c, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Date date");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasHyperlinkToJavaDate(_builder);
  }

  @Test
  public void javadoc_see05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* @see ");
    _builder.append(this.c, "\t ");
    _builder.append("Date");
    _builder.append(this.c, "\t ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val a = 1");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasHyperlinkToJavaDate(_builder);
  }

  @Test
  public void javadoc_see06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Date date");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @see ");
    _builder.append(this.c, " ");
    _builder.append("Date");
    _builder.append(this.c, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    this.hasHyperlinkToJavaDate(_builder);
  }

  @Test
  public void javadoc_see07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @see ");
    _builder.append(this.c, " ");
    _builder.append("Date");
    _builder.append(this.c, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    this.hasHyperlinkToJavaDate(_builder);
  }

  private void hasHyperlinkToJavaDate(final CharSequence it) {
    this.hasHyperlinkTo(it, "java.util.Date");
  }

  private void hasNoHyperlink(final CharSequence it) {
    this.noHyperlinkIsOffered(this.hyperlinkingOn(this.dslFile(it), this.hyperlinkRegion(it).getOffset()));
  }

  private void noHyperlinkIsOffered(final IHyperlink[] hyperlinks) {
    Assert.assertNull(hyperlinks);
  }
}
