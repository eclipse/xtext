/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.interpreter;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.interpreter.ConstantExpressionEvaluationException;
import org.eclipse.xtext.xbase.interpreter.SwitchConstantExpressionsInterpreter;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class SwitchConstantExpressionsInterpreterTest extends AbstractXbaseTestCase {
  @Inject
  private SwitchConstantExpressionsInterpreter interpreter;
  
  @Test
  public void testXNumberLiteral() {
    Pair<String, String> _mappedTo = Pair.<String, String>of("int", "1");
    this.evaluatesTo(_mappedTo, Integer.valueOf(1));
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("short", "1 as short");
    this.evaluatesTo(_mappedTo_1, Integer.valueOf(1));
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("byte", "1 as byte");
    this.evaluatesTo(_mappedTo_2, Integer.valueOf(1));
    Pair<String, String> _mappedTo_3 = Pair.<String, String>of("char", "1 as char");
    this.evaluatesTo(_mappedTo_3, Integer.valueOf(1));
  }
  
  @Test
  public void testXVariableDeclarationCall() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val foo = 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val bar = foo");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      final XBlockExpression blockExpression = ((XBlockExpression) _expression);
      EList<XExpression> _expressions = blockExpression.getExpressions();
      XExpression _get = _expressions.get(1);
      final XVariableDeclaration variableDeclaration = ((XVariableDeclaration) _get);
      this.evaluatesTo(variableDeclaration, Integer.valueOf(1));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJvmFieldCall() {
    this.evaluatesTo("interpreter.Foo.FOO", Integer.valueOf(1));
  }
  
  @Test(expected = ConstantExpressionEvaluationException.class)
  public void testNullArgument() {
    try {
      final XExpression brokenExpression = this.expression("1 !=", false);
      this.interpreter.evaluate(brokenExpression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJvmEnumerationLiteral() {
    final Procedure1<Object> _function = (Object it) -> {
      String _simpleName = ((JvmEnumerationLiteral) it).getSimpleName();
      Assert.assertEquals("NEW", _simpleName);
    };
    this.evaluatesTo("Thread.State.NEW", _function);
  }
  
  @Test
  public void testXUnaryOperation() {
    this.evaluatesTo("-1", Integer.valueOf((-1)));
  }
  
  @Test
  public void testXBinaryOperation() {
    this.evaluatesTo("(1 + (2 - 3) * (4 / 4))", Integer.valueOf(0));
  }
  
  protected void evaluatesTo(final String expression, final Object expectation) {
    Pair<String, String> _mappedTo = Pair.<String, String>of(null, expression);
    this.evaluatesTo(_mappedTo, expectation);
  }
  
  protected void evaluatesTo(final String expression, final Procedure1<? super Object> assertions) {
    Pair<String, String> _mappedTo = Pair.<String, String>of(null, expression);
    this.evaluatesTo(_mappedTo, assertions);
  }
  
  protected void evaluatesTo(final Pair<String, String> typeAndExpression, final Object expectation) {
    final Procedure1<Object> _function = (Object it) -> {
      Assert.assertEquals(expectation, it);
    };
    this.evaluatesTo(typeAndExpression, _function);
  }
  
  protected void evaluatesTo(final Pair<String, String> typeAndExpression, final Procedure1<? super Object> assertions) {
    try {
      final String type = typeAndExpression.getKey();
      final String expression = typeAndExpression.getValue();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val");
      {
        boolean _notEquals = (!Objects.equal(type, null));
        if (_notEquals) {
          _builder.append(" ");
          _builder.append(type, "\t");
        }
      }
      _builder.append(" testFoo = ");
      _builder.append(expression, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      final String charSequence = _builder.toString();
      XExpression _expression = this.expression(charSequence, true);
      final XBlockExpression blockExpression = ((XBlockExpression) _expression);
      EList<XExpression> _expressions = blockExpression.getExpressions();
      XExpression _head = IterableExtensions.<XExpression>head(_expressions);
      final XVariableDeclaration variableDeclaration = ((XVariableDeclaration) _head);
      this.evaluatesTo(variableDeclaration, assertions);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void evaluatesTo(final XVariableDeclaration it, final Object expectation) {
    final Procedure1<Object> _function = (Object it_1) -> {
      Assert.assertEquals(expectation, it_1);
    };
    this.evaluatesTo(it, _function);
  }
  
  protected void evaluatesTo(final XVariableDeclaration it, final Procedure1<? super Object> assertions) {
    XExpression _right = it.getRight();
    final Object value = this.interpreter.evaluate(_right);
    assertions.apply(value);
  }
}
