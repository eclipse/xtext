/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.arithmetics.ui.tests.hyperlinking;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.arithmetics.ui.tests.ArithmeticsUiInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractHyperlinkingTest;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(ArithmeticsUiInjectorProvider.class)
@SuppressWarnings("all")
public class HyperlinkingTest extends AbstractHyperlinkingTest {
  @Test
  public void hyperlink_on_function_call() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module arithmetics");
    _builder.newLine();
    _builder.newLine();
    _builder.append("def pi: 3.14;");
    _builder.newLine();
    _builder.append(this.c);
    _builder.append("pi");
    _builder.append(this.c);
    _builder.append(" * 4;");
    _builder.newLineIfNotEmpty();
    this.hasHyperlinkTo(_builder, "arithmetics.pi");
  }
  
  @Test
  public void hyperlink_on_parameter() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module m1");
    _builder.newLine();
    _builder.newLine();
    _builder.append("def multiply(a, b) : a * ");
    _builder.append(this.c);
    _builder.append("b");
    _builder.append(this.c);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("multiply(2,3);");
    _builder.newLine();
    this.hasHyperlinkTo(_builder, "m1.multiply.b");
  }
}
