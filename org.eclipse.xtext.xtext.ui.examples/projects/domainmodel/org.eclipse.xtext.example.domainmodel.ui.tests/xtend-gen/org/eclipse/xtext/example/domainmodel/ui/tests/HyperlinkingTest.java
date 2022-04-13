/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.domainmodel.ui.tests;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractHyperlinkingTest;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(DomainmodelUiInjectorProvider.class)
@SuppressWarnings("all")
public class HyperlinkingTest extends AbstractHyperlinkingTest {
  @Before
  public void setup() throws Exception {
    JavaProjectSetupUtil.createJavaProject(this.getProjectName());
  }

  @Test
  public void hyperlink_on_java_import_statement() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import ");
    _builder.append(this.c);
    _builder.append("java.util.Date");
    _builder.append(this.c);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("entity Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("date : Date");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasHyperlinkTo(_builder, "java.util.Date");
  }

  @Test
  public void hyperlink_on_java_member_type() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.newLine();
    _builder.append("entity Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("date : ");
    _builder.append(this.c, "\t");
    _builder.append("Date");
    _builder.append(this.c, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.hasHyperlinkTo(_builder, "java.util.Date");
  }

  @Test
  public void hyperlink_on_entity_import_statement() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import ");
    _builder.append(this.c);
    _builder.append("foopackage.Foo");
    _builder.append(this.c);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package foopackage {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("entity Foo {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("entity Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("foo : Foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasHyperlinkTo(_builder, "foopackage.Foo");
  }

  @Test
  public void hyperlink_javadoc_link_to_java_type() {
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
    _builder.append("entity Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("date : Date");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasHyperlinkTo(_builder, "java.util.Date");
  }

  @Test
  public void hyperlink_on_entity_member_type() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity Foo {}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("entity Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("foo : ");
    _builder.append(this.c, "\t");
    _builder.append("Foo");
    _builder.append(this.c, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.hasHyperlinkTo(_builder, "Foo");
  }

  @Test
  public void hyperlink_on_entity_member_type_in_package() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import foopackage.Foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("package foopackage {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("entity Foo {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("entity Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("foo : ");
    _builder.append(this.c, "\t");
    _builder.append("foopackage.Foo");
    _builder.append(this.c, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.hasHyperlinkTo(_builder, "foopackage.Foo");
  }

  @Test
  public void hyperlink_javadoc_link_to_entity_type() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* {@link ");
    _builder.append(this.c, " ");
    _builder.append("Foo");
    _builder.append(this.c, " ");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("entity Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("date : Date");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasHyperlinkTo(_builder, "Foo");
  }
}
