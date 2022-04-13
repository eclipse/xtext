/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.homeautomation.ui.tests;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractQuickfixTest;
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
public class RuleEngineQuickfixTest extends AbstractQuickfixTest {
  @Before
  public void setup() throws Exception {
    JavaProjectSetupUtil.createJavaProject(this.getProjectName());
  }

  @Test
  public void fix_invalid_rule_device_state() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Rule \'rule1\' when foo then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fire(Heater.off)");
    _builder.newLine();
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
    AbstractQuickfixTest.Quickfix _quickfix = new AbstractQuickfixTest.Quickfix("Change to \'Window.open\'", "Change to \'Window.open\'", _builder_1.toString());
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("Device Window can be open, closed");
    _builder_2.newLine();
    _builder_2.append("Device Heater can be on, off, error");
    _builder_2.newLine();
    _builder_2.newLine();
    _builder_2.append("Rule \'rule1\' when Window.closed then");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("fire(Heater.off)");
    _builder_2.newLine();
    AbstractQuickfixTest.Quickfix _quickfix_1 = new AbstractQuickfixTest.Quickfix("Change to \'Window.closed\'", "Change to \'Window.closed\'", _builder_2.toString());
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("Device Window can be open, closed");
    _builder_3.newLine();
    _builder_3.append("Device Heater can be on, off, error");
    _builder_3.newLine();
    _builder_3.newLine();
    _builder_3.append("Rule \'rule1\' when Heater.on then");
    _builder_3.newLine();
    _builder_3.append("\t");
    _builder_3.append("fire(Heater.off)");
    _builder_3.newLine();
    AbstractQuickfixTest.Quickfix _quickfix_2 = new AbstractQuickfixTest.Quickfix("Change to \'Heater.on\'", "Change to \'Heater.on\'", _builder_3.toString());
    StringConcatenation _builder_4 = new StringConcatenation();
    _builder_4.append("Device Window can be open, closed");
    _builder_4.newLine();
    _builder_4.append("Device Heater can be on, off, error");
    _builder_4.newLine();
    _builder_4.newLine();
    _builder_4.append("Rule \'rule1\' when Heater.off then");
    _builder_4.newLine();
    _builder_4.append("\t");
    _builder_4.append("fire(Heater.off)");
    _builder_4.newLine();
    AbstractQuickfixTest.Quickfix _quickfix_3 = new AbstractQuickfixTest.Quickfix("Change to \'Heater.off\'", "Change to \'Heater.off\'", _builder_4.toString());
    StringConcatenation _builder_5 = new StringConcatenation();
    _builder_5.append("Device Window can be open, closed");
    _builder_5.newLine();
    _builder_5.append("Device Heater can be on, off, error");
    _builder_5.newLine();
    _builder_5.newLine();
    _builder_5.append("Rule \'rule1\' when Heater.error then");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("fire(Heater.off)");
    _builder_5.newLine();
    AbstractQuickfixTest.Quickfix _quickfix_4 = new AbstractQuickfixTest.Quickfix("Change to \'Heater.error\'", "Change to \'Heater.error\'", _builder_5.toString());
    this.testQuickfixesOn(_builder, Diagnostic.LINKING_DIAGNOSTIC, _quickfix, _quickfix_1, _quickfix_2, _quickfix_3, _quickfix_4);
  }
}
