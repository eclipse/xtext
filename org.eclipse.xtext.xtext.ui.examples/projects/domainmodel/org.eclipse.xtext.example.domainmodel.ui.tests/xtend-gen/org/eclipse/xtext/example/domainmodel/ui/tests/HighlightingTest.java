/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.domainmodel.ui.tests;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractHighlightingTest;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.ui.highlighting.XbaseHighlightingConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(DomainmodelUiInjectorProvider.class)
@SuppressWarnings("all")
public class HighlightingTest extends AbstractHighlightingTest {
  @Inject
  @Extension
  private XbaseHighlightingConfiguration _xbaseHighlightingConfiguration;

  @Before
  public void setup() throws Exception {
    JavaProjectSetupUtil.createJavaProject(this.getProjectName());
  }

  @Test
  public void package_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package P {}");
    _builder.newLine();
    this.testHighlighting(_builder, "package", this._xbaseHighlightingConfiguration.keywordTextStyle());
  }

  @Test
  public void entity_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity E {}");
    _builder.newLine();
    this.testHighlighting(_builder, "entity", this._xbaseHighlightingConfiguration.keywordTextStyle());
  }

  @Test
  public void extends_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity A {}");
    _builder.newLine();
    _builder.append("entity B extends A {}");
    _builder.newLine();
    this.testHighlighting(_builder, "extends", this._xbaseHighlightingConfiguration.keywordTextStyle());
  }

  @Test
  public void op_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op m() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.testHighlighting(_builder, "op", this._xbaseHighlightingConfiguration.keywordTextStyle());
  }

  @Test
  public void import_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("entity E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("adresse : List<String>");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.testHighlighting(_builder, "import", this._xbaseHighlightingConfiguration.keywordTextStyle());
  }

  @Test
  public void int_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op m(int b) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.testHighlighting(_builder, "int", this._xbaseHighlightingConfiguration.keywordTextStyle());
  }

  @Test
  public void boolean_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op m(boolean b) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.testHighlighting(_builder, "boolean", this._xbaseHighlightingConfiguration.keywordTextStyle());
  }

  @Test
  public void if_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op m(boolean b) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (b) 1 else 2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.testHighlighting(_builder, "if", this._xbaseHighlightingConfiguration.keywordTextStyle());
  }

  @Test
  public void else_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op m(boolean b) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (b) 1 else 2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.testHighlighting(_builder, "else", this._xbaseHighlightingConfiguration.keywordTextStyle());
  }

  @Test
  public void return_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op m(boolean b) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return if (b) 1 else 2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.testHighlighting(_builder, "return", this._xbaseHighlightingConfiguration.keywordTextStyle());
  }

  @Test
  public void instanceof_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op m(A a) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (a instanceof B) 1 else 2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("entity B extends A {}");
    _builder.newLine();
    this.testHighlighting(_builder, "instanceof", this._xbaseHighlightingConfiguration.keywordTextStyle());
  }

  @Test
  public void single_line_comment() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// A language to model domain-model elements");
    _builder.newLine();
    _builder.append("entity E {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.testHighlighting(_builder, "A language to model domain-model elements", this._xbaseHighlightingConfiguration.commentTextStyle());
  }

  @Test
  public void multi_line_comment() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* A language to model domain-model elements.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Each entity can have properties, operations");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* and relations to each other.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("entity E {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("/*");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* A language to model domain-model elements.");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* Each entity can have properties, operations");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* and relations to each other.");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("*/");
    _builder_1.newLine();
    this.testHighlighting(_builder, _builder_1.toString(), this._xbaseHighlightingConfiguration.commentTextStyle());
  }

  @Test
  public void javadoc_comment() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* A language to model domain-model elements.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Each entity can have properties, operations");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* and relations to each other.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("entity E {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* A language to model domain-model elements.");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* Each entity can have properties, operations");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* and relations to each other.");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("*/");
    _builder_1.newLine();
    this.testHighlighting(_builder, _builder_1.toString(), this._xbaseHighlightingConfiguration.commentTextStyle());
  }

  @Test
  public void fixme_task_in_comment() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* FIXME");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("entity E {}");
    _builder.newLine();
    this.testHighlighting(_builder, "FIXME", this._xbaseHighlightingConfiguration.taskTextStyle());
  }

  @Test
  public void todo_task_in_comment() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* TODO");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("entity E {}");
    _builder.newLine();
    this.testHighlighting(_builder, "TODO", this._xbaseHighlightingConfiguration.taskTextStyle());
  }

  @Test
  public void xxx_task_in_comment() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* XXX");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("entity E {}");
    _builder.newLine();
    this.testHighlighting(_builder, "XXX", this._xbaseHighlightingConfiguration.taskTextStyle());
  }

  @Test
  public void single_quoted_string() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("a : String");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("a = \'foo\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.testHighlighting(_builder, "\'foo\'", this._xbaseHighlightingConfiguration.stringTextStyle());
  }

  @Test
  public void double_quoted_string() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("a : String");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("a = \"foo\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.testHighlighting(_builder, "\"foo\"", this._xbaseHighlightingConfiguration.stringTextStyle());
  }

  @Test
  public void number_literal() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("a : int");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("a = 100");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.testHighlighting(_builder, "100", this._xbaseHighlightingConfiguration.numberTextStyle());
  }
}
