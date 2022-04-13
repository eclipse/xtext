/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.homeautomation.ui.tests;

import org.eclipse.jface.text.Region;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractHoverTest;
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
public class RuleEngineHoverTest extends AbstractHoverTest {
  @Before
  public void setup() throws Exception {
    JavaProjectSetupUtil.createJavaProject(this.getProjectName());
  }

  @Test
  public void hover_over_device_name() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Device Window");
    this.hasHoverOver(_builder, "Window", _builder_1.toString());
  }

  @Test
  public void hover_over_device_state() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("State open");
    this.hasHoverOver(_builder, "open", _builder_1.toString());
  }

  @Test
  public void hover_over_fire_expression() {
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
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("void Hover.fire(Object event)");
    this.hasHoverOver(_builder, "fire", _builder_1.toString());
  }

  @Test
  public void hover_over_link_in_javadoc1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* If the {@link Window} is open, the {@link Heater} should be turned off.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("Rule \'rule1\' when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fire(Heater.off)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Device Window");
    this.hasHoverInJavadoc(_builder, "Window", _builder_1.toString());
  }

  @Test
  public void hover_over_link_in_javadoc2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    _builder.append("Device Heater can be on, off, error");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* If the {@link Window} is open, the {@link Heater} should be turned off.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("Rule \'rule1\' when Window.open then");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fire(Heater.off)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Device Heater");
    this.hasHoverInJavadoc(_builder, "Heater", _builder_1.toString());
  }

  @Test
  public void hover_over_link_in_javadoc3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* {@link java.util.List}");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("Device Window can be open, closed");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("An ordered collection (also known as a <i>sequence</i>");
    this.hasHoverInJavadoc(_builder, "java.util.List", _builder_1.toString());
  }

  private void hasHoverInJavadoc(final CharSequence it, final String hoverText, final String hoverContent) {
    final int startOfJavadoc = it.toString().indexOf("/**");
    int _indexOf = it.toString().indexOf(hoverText, startOfJavadoc);
    int _length = hoverText.length();
    final Region hoverRegion = new Region(_indexOf, _length);
    this.hasHoverOver(it, hoverRegion, hoverContent);
  }
}
