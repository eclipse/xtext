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
import org.eclipse.xtext.ui.testing.AbstractFoldingTest;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(RuleEngineUiInjectorProvider.class)
@SuppressWarnings("all")
public class RuleEngineFoldingTest extends AbstractFoldingTest {
  @Test
  public void rule() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("[>Rule \'rule1\' when Window.open then");
    _builder.newLine();
    _builder.append("[>\tfire(Heater.off)<]<]");
    _builder.newLine();
    this.testFoldingRegions(_builder);
  }

  @Test
  public void rules() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("[>Rule \'rule1\' when Window.open then");
    _builder.newLine();
    _builder.append("[>\tfire(Heater.off)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<]<]");
    _builder.newLine();
    _builder.append("[>Rule \'rule2\' when Heater.on then");
    _builder.newLine();
    _builder.append("[>\tfire(Window.closed)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<]<]");
    _builder.newLine();
    _builder.append("[>Rule \'rule3\' when Window.closed then");
    _builder.newLine();
    _builder.append("[>\tfire(Heater.on)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<]<]");
    _builder.newLine();
    _builder.append("[>Rule \'rule4\' when Window.closed then");
    _builder.newLine();
    _builder.append("[>\tfire(Window.closed)<]<]");
    _builder.newLine();
    this.testFoldingRegions(_builder);
  }
}
