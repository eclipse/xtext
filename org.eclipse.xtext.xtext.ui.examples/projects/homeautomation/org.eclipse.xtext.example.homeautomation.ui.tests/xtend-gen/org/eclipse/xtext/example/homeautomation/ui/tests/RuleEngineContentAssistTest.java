/**
 * Copyright (c) 2018, 2024 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtext.ui.testing.AbstractContentAssistTest;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(RuleEngineUiInjectorProvider.class)
@SuppressWarnings("all")
public class RuleEngineContentAssistTest extends AbstractContentAssistTest {
  @Test
  public void empty() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(this.c);
    _builder.newLineIfNotEmpty();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Device");
    _builder_1.newLine();
    this.assertContentAssistant(_builder, 
      new String[] { "Device", "Rule" }, "Device", _builder_1.toString());
  }

  @Test
  public void rule_device_state() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \'rule1\' when ");
    _builder.append(this.c);
    _builder.newLineIfNotEmpty();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Device Window can be open, closed");
    _builder_1.newLine();
    _builder_1.append("Device Heater can be on, off, error");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("Rule \'rule1\' when Window.open");
    _builder_1.newLine();
    this.assertContentAssistant(_builder, 
      new String[] { "Window.open", "Window.closed", "Heater.on", "Heater.off", "Heater.error" }, "Window.open", _builder_1.toString());
  }

  @Test
  public void rule_device_state_with_prefix() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \'rule1\' when Win");
    _builder.append(this.c);
    _builder.newLineIfNotEmpty();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Device Window can be open, closed");
    _builder_1.newLine();
    _builder_1.append("Device Heater can be on, off, error");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("Rule \'rule1\' when Window.open");
    _builder_1.newLine();
    this.assertContentAssistant(_builder, 
      new String[] { "Window.open", "Window.closed" }, "Window.open", _builder_1.toString());
  }

  @Test
  public void rule_then_part() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \'rule1\' when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(this.c, "\t");
    _builder.newLineIfNotEmpty();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Device Window can be open, closed");
    _builder_1.newLine();
    _builder_1.append("Device Heater can be on, off, error");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("Rule \'rule1\' when Window.open then");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("switch");
    _builder_1.newLine();
    this.assertContentAssistant(_builder, 
      new String[] { "do", "false", "for", "if", "new", "null", "return", "switch", "synchronized", "throw", "true", "try", "typeof", "val", "var", "while" }, "switch", _builder_1.toString());
  }

  @Test
  public void rule_then_part_with_prefix() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \'rule1\' when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fire(Heater.o");
    _builder.append(this.c, "\t");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Device Window can be open, closed");
    _builder_1.newLine();
    _builder_1.append("Device Heater can be on, off, error");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("Rule \'rule1\' when Window.open then");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("fire(Heater.off)");
    _builder_1.newLine();
    this.assertContentAssistant(_builder, 
      new String[] { "on", "off" }, "off", _builder_1.toString());
  }
}
