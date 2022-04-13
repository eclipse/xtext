/**
 * Copyright (c) 2018, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.homeautomation.ui.tests;

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
@InjectWith(RuleEngineUiInjectorProvider.class)
@SuppressWarnings("all")
public class RuleEngineHighlightingTest extends AbstractHighlightingTest {
  @Inject
  @Extension
  private XbaseHighlightingConfiguration _xbaseHighlightingConfiguration;

  @Before
  public void setup() throws Exception {
    JavaProjectSetupUtil.createJavaProject(this.getProjectName());
  }

  @Test
  public void device_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    this.testHighlighting(_builder, "Device", this._xbaseHighlightingConfiguration.keywordTextStyle());
  }

  @Test
  public void can_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    this.testHighlighting(_builder, "can", this._xbaseHighlightingConfiguration.keywordTextStyle());
  }

  @Test
  public void be_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    this.testHighlighting(_builder, "be", this._xbaseHighlightingConfiguration.keywordTextStyle());
  }

  @Test
  public void rule_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \'rule1\' when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fire(Heater.off)");
    _builder.newLine();
    this.testHighlighting(_builder, "Rule", this._xbaseHighlightingConfiguration.keywordTextStyle());
  }

  @Test
  public void when_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \'rule1\' when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fire(Heater.off)");
    _builder.newLine();
    this.testHighlighting(_builder, "when", this._xbaseHighlightingConfiguration.keywordTextStyle());
  }

  @Test
  public void then_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \'rule1\' when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fire(Heater.off)");
    _builder.newLine();
    this.testHighlighting(_builder, "then", this._xbaseHighlightingConfiguration.keywordTextStyle());
  }

  @Test
  public void switch_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \"Save energy\" when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("switch new java.util.Random().nextInt");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("case 1,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("case 2:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("fire(Heater.off)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("default:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("fire(Heater.on)");
    _builder.newLine();
    this.testHighlighting(_builder, "switch", this._xbaseHighlightingConfiguration.keywordTextStyle());
  }

  @Test
  public void case_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \"Save energy\" when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("switch new java.util.Random().nextInt");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("case 1,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("case 2:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("fire(Heater.off)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("default:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("fire(Heater.on)");
    _builder.newLine();
    this.testHighlighting(_builder, "case", this._xbaseHighlightingConfiguration.keywordTextStyle());
  }

  @Test
  public void default_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \"Save energy\" when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("switch new java.util.Random().nextInt");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("case 1,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("case 2:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("fire(Heater.off)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("default:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("fire(Heater.on)");
    _builder.newLine();
    this.testHighlighting(_builder, "default", this._xbaseHighlightingConfiguration.keywordTextStyle());
  }

  @Test
  public void number() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \"Save energy\" when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("switch new java.util.Random().nextInt");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("case 1,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("case 2:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("fire(Heater.off)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("default:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("fire(Heater.on)");
    _builder.newLine();
    this.testHighlighting(_builder, "1", this._xbaseHighlightingConfiguration.numberTextStyle());
  }

  @Test
  public void punctuation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \'rule1\' when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fire(Heater.off)");
    _builder.newLine();
    this.testHighlighting(_builder, ".", this._xbaseHighlightingConfiguration.punctuationTextStyle());
  }

  @Test
  public void single_quoted_rule_description() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \'rule1\' when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fire(Heater.off)");
    _builder.newLine();
    this.testHighlighting(_builder, "rule1", this._xbaseHighlightingConfiguration.stringTextStyle());
  }

  @Test
  public void double_quoted_rule_description() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \"rule1\" when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fire(Heater.off)");
    _builder.newLine();
    this.testHighlighting(_builder, "rule1", this._xbaseHighlightingConfiguration.stringTextStyle());
  }

  @Test
  public void fire_method_invocation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \"rule1\" when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fire(Heater.off)");
    _builder.newLine();
    this.testHighlighting(_builder, "fire", this._xbaseHighlightingConfiguration.staticMethodInvocation());
  }

  @Test
  public void device_state_access() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \"rule1\" when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fire(Heater.off)");
    _builder.newLine();
    this.testHighlighting(_builder, "off", this._xbaseHighlightingConfiguration.staticField());
  }

  @Test
  public void single_line_comment() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// A language for home automation systems.");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \"rule1\" when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fire(Heater.off)");
    _builder.newLine();
    this.testHighlighting(_builder, "A language for home automation systems", this._xbaseHighlightingConfiguration.commentTextStyle());
  }

  @Test
  public void multi_line_comment() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* A language for home automation systems");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* supporting indentation-based code blocks");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* similar to Python.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("/*");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* A language for home automation systems");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* supporting indentation-based code blocks");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* similar to Python.");
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
    _builder.append("Device Window can be open, closed");
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
    _builder.append("Device Window can be open, closed");
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
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    this.testHighlighting(_builder, "XXX", this._xbaseHighlightingConfiguration.taskTextStyle());
  }

  @Override
  protected int getStartPosition(final String content, final String text) {
    return content.lastIndexOf(text);
  }
}
