/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.arithmetics.ui.tests.quickfix;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.arithmetics.ui.tests.ArithmeticsUiInjectorProvider;
import org.eclipse.xtext.example.arithmetics.validation.ArithmeticsValidator;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractQuickfixTest;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(ArithmeticsUiInjectorProvider.class)
@SuppressWarnings("all")
public class QuickfixTest extends AbstractQuickfixTest {
  @Test
  public void normalize_expression() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module test");
    _builder.newLine();
    _builder.append("def fun : 1+2;");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("module test");
    _builder_1.newLine();
    _builder_1.append("def fun : 3;");
    _builder_1.newLine();
    AbstractQuickfixTest.Quickfix _quickfix = new AbstractQuickfixTest.Quickfix("Replace with 3", "Replace expression with \'3\'", _builder_1.toString());
    this.testQuickfixesOn(_builder, ArithmeticsValidator.NORMALIZABLE, _quickfix);
  }
}
