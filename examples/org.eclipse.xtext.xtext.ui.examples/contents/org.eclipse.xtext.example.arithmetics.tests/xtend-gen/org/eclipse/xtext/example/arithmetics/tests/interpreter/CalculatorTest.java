/**
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.arithmetics.tests.interpreter;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.math.BigDecimal;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.arithmetics.arithmetics.Expression;
import org.eclipse.xtext.example.arithmetics.arithmetics.Module;
import org.eclipse.xtext.example.arithmetics.arithmetics.Statement;
import org.eclipse.xtext.example.arithmetics.interpreter.Calculator;
import org.eclipse.xtext.example.arithmetics.tests.ArithmeticsInjectorProvider;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(ArithmeticsInjectorProvider.class)
@SuppressWarnings("all")
public class CalculatorTest {
  @Inject
  private ParseHelper<Module> parseHelper;
  
  @Inject
  private Calculator calculator;
  
  @Test
  public void testSimple() throws Exception {
    this.check(6, "1 + 2 + 3");
    this.check(0, "1 + 2 - 3");
    this.check(5, "1 * 2 + 3");
    this.check((-4), "1 - 2 - 3");
    this.check(1.5, "1 / 2 * 3");
  }
  
  @Test
  public void testFunction() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("multiply(2,multiply(2, 3));");
      _builder.newLine();
      _builder.append("def multiply(a, b) : a * b;");
      _builder.newLine();
      this.check(12.0, _builder.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void check(final double expected, final String expression) throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module test ");
    _builder.append(expression, "");
    final Module module = this.parseHelper.parse(_builder);
    EList<Statement> _statements = module.getStatements();
    Statement _head = IterableExtensions.<Statement>head(_statements);
    EList<EObject> _eContents = _head.eContents();
    Iterable<Expression> _filter = Iterables.<Expression>filter(_eContents, Expression.class);
    Expression _head_1 = IterableExtensions.<Expression>head(_filter);
    BigDecimal result = this.calculator.evaluate(_head_1);
    double _doubleValue = result.doubleValue();
    Assert.assertEquals(expected, _doubleValue, 0.0001);
  }
}
