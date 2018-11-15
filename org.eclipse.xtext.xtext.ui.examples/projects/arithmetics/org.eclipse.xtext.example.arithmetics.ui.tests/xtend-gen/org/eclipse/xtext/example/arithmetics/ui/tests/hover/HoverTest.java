/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.arithmetics.ui.tests.hover;

import org.eclipse.jface.text.Region;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.arithmetics.ui.tests.ArithmeticsUiInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractHoverTest;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(ArithmeticsUiInjectorProvider.class)
@SuppressWarnings("all")
public class HoverTest extends AbstractHoverTest {
  @Test
  public void hover_over_function_call() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module arithmetics");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* A mathematical constant.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* It is approximately equal to 3.14.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("def pi: 3.14");
    _builder.newLine();
    _builder.newLine();
    _builder.append("pi * 4;");
    _builder.newLine();
    final String text = _builder.toString();
    final String hoverText = "pi";
    int _lastIndexOf = text.lastIndexOf(hoverText);
    int _length = hoverText.length();
    final Region hoverRegion = new Region(_lastIndexOf, _length);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("A mathematical constant.");
    _builder_1.newLine();
    _builder_1.append("It is approximately equal to 3.14.");
    this.hasHoverOver(text, hoverRegion, _builder_1.toString());
  }
}
