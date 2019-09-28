/**
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.arithmetics.tests.interpreter;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.math.BigDecimal;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.arithmetics.arithmetics.Expression;
import org.eclipse.xtext.example.arithmetics.arithmetics.Statement;
import org.eclipse.xtext.example.arithmetics.interpreter.Calculator;
import org.eclipse.xtext.example.arithmetics.tests.ArithmeticsInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(ArithmeticsInjectorProvider.class)
@SuppressWarnings("all")
public class CalculatorTest {
  @Inject
  @Extension
  private ParseHelper<org.eclipse.xtext.example.arithmetics.arithmetics.Module> _parseHelper;
  
  @Inject
  @Extension
  private Calculator _calculator;
  
  @Test
  public void testSimple() {
    this.evaluatesTo("1 + 2 + 3", 6);
    this.evaluatesTo("1 + 2 - 3", 0);
    this.evaluatesTo("1 * 2 + 3", 5);
    this.evaluatesTo("1 - 2 - 3", (-4));
    this.evaluatesTo("1 / 2 * 3", 1.5);
  }
  
  @Test
  public void testFunction() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("multiply(2,multiply(2, 3));");
    _builder.newLine();
    _builder.append("def multiply(a, b) : a * b;");
    _builder.newLine();
    this.evaluatesTo(_builder, 12.0);
  }
  
  private void evaluatesTo(final CharSequence content, final double expected) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("module test ");
      _builder.append(content);
      final org.eclipse.xtext.example.arithmetics.arithmetics.Module module = this._parseHelper.parse(_builder);
      final Expression expression = IterableExtensions.<Expression>head(Iterables.<Expression>filter(IterableExtensions.<Statement>head(module.getStatements()).eContents(), Expression.class));
      final BigDecimal result = this._calculator.evaluate(expression);
      Assert.assertEquals(expected, result.doubleValue(), 0.0001);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
