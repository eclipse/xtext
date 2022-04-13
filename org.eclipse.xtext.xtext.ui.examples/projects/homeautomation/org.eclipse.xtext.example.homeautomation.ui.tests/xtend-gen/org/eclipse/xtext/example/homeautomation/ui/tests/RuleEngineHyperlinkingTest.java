/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.homeautomation.ui.tests;

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
@InjectWith(RuleEngineUiInjectorProvider.class)
@SuppressWarnings("all")
public class RuleEngineHyperlinkingTest extends AbstractHyperlinkingTest {
  @Before
  public void setup() throws Exception {
    JavaProjectSetupUtil.createJavaProject(this.getProjectName());
  }

  @Test
  public void hyperlink_on_rule_when_part() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \'rule1\' when ");
    _builder.append(this.c);
    _builder.append("Window.open");
    _builder.append(this.c);
    _builder.append(" then");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("fire(Heater.off)");
    _builder.newLine();
    this.hasHyperlinkTo(_builder, "Window.open");
  }

  @Test
  public void hyperlink_on_device_name_in_rule_then_part() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \'rule1\' when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fire(");
    _builder.append(this.c, "\t");
    _builder.append("Heater");
    _builder.append(this.c, "\t");
    _builder.append(".off)");
    _builder.newLineIfNotEmpty();
    this.hasHyperlinkTo(_builder, "Heater");
  }

  @Test
  public void hyperlink_on_device_state_in_rule_then_part() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \'rule1\' when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fire(Heater.");
    _builder.append(this.c, "\t");
    _builder.append("off");
    _builder.append(this.c, "\t");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    this.hasHyperlinkTo(_builder, "Heater.off");
  }

  @Test
  public void hyperlink_on_link_in_javadoc1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* If the {@link ");
    _builder.append(this.c, " ");
    _builder.append("Window");
    _builder.append(this.c, " ");
    _builder.append("} is open, the {@link Heater} should be turned off.");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("Rule \'rule1\' when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fire(Heater.off)");
    _builder.newLine();
    this.hasHyperlinkTo(_builder, "Window");
  }

  @Test
  public void hyperlink_on_link_in_javadoc2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* If the {@link Window} is open, the {@link ");
    _builder.append(this.c, " ");
    _builder.append("Heater");
    _builder.append(this.c, " ");
    _builder.append("} should be turned off.");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("Rule \'rule1\' when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fire(Heater.off)");
    _builder.newLine();
    this.hasHyperlinkTo(_builder, "Heater");
  }

  @Test
  public void hyperlink_on_link_in_javadoc3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* {@link ");
    _builder.append(this.c, " ");
    _builder.append("java.util.List");
    _builder.append(this.c, " ");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    this.hasHyperlinkTo(_builder, "java.util.List");
  }
}
