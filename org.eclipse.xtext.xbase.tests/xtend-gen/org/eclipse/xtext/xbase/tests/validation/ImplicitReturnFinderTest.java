/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.validation;

import com.google.inject.Inject;
import java.util.ArrayList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XSynchronizedExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.validation.ImplicitReturnFinder;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
@SuppressWarnings("all")
public class ImplicitReturnFinderTest extends AbstractXbaseTestCase {
  @Inject
  @Extension
  private ImplicitReturnFinder finder;
  
  @Test
  public void testReturn() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("return");
      XExpression _expression = this.expression(_builder);
      this.hasNoImplicitReturns(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testVariableDeclaration() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{val x = \"foo\"}");
      XExpression _expression = this.expression(_builder);
      this.hasNoImplicitReturns(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testForLoop() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("for (i: 1..10)");
      XExpression _expression = this.expression(_builder);
      this.hasNoImplicitReturns(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testWhileLoop() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("while (true)");
      XExpression _expression = this.expression(_builder);
      this.hasNoImplicitReturns(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDoWhileLoop() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("do while (true)");
      XExpression _expression = this.expression(_builder);
      this.hasNoImplicitReturns(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testThrow() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("throw new RuntimeException()");
      XExpression _expression = this.expression(_builder);
      this.hasNoImplicitReturns(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNumberLiteral() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("1");
      XExpression _expression = this.expression(_builder);
      this.isImplicitReturn(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNullLiteral() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("null");
      XExpression _expression = this.expression(_builder);
      this.isImplicitReturn(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBooleanLiteral() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("true");
      XExpression _expression = this.expression(_builder);
      this.isImplicitReturn(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testStringLiteral() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"foo\"");
      XExpression _expression = this.expression(_builder);
      this.isImplicitReturn(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testListLiteral() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"#[]\"");
      XExpression _expression = this.expression(_builder);
      this.isImplicitReturn(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSetLiteral() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"#{}\"");
      XExpression _expression = this.expression(_builder);
      this.isImplicitReturn(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFeatureCall() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"foo.length\"");
      XExpression _expression = this.expression(_builder);
      this.isImplicitReturn(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCLosure() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("[]");
      XExpression _expression = this.expression(_builder);
      this.isImplicitReturn(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCast() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("1 as int");
      XExpression _expression = this.expression(_builder);
      this.isImplicitReturn(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testInstaceof() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("1 instanceof int");
      XExpression _expression = this.expression(_builder);
      this.isImplicitReturn(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testConstructorCall() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new String");
      XExpression _expression = this.expression(_builder);
      this.isImplicitReturn(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBlock01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{1}");
      XExpression _expression = this.expression(_builder);
      final XBlockExpression block = ((XBlockExpression) _expression);
      EList<XExpression> _expressions = block.getExpressions();
      XExpression _head = IterableExtensions.<XExpression>head(_expressions);
      this.hasImplicitReturns(block, _head);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBlock02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("val x = \"foo\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      XExpression _expression = this.expression(_builder);
      this.hasNoImplicitReturns(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSynchronized() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("synchronized (this) {1}");
      XExpression _expression = this.expression(_builder);
      final XSynchronizedExpression block = ((XSynchronizedExpression) _expression);
      XExpression _expression_1 = block.getExpression();
      EList<XExpression> _expressions = ((XBlockExpression) _expression_1).getExpressions();
      XExpression _head = IterableExtensions.<XExpression>head(_expressions);
      this.hasImplicitReturns(block, _head);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIf01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("if (true) 1 else 2");
      XExpression _expression = this.expression(_builder);
      final XIfExpression expr = ((XIfExpression) _expression);
      XExpression _then = expr.getThen();
      XExpression _else = expr.getElse();
      this.hasImplicitReturns(expr, _then, _else);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIf02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("if (true) return 1 else return 2");
      XExpression _expression = this.expression(_builder);
      this.hasNoImplicitReturns(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSwitch01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch (this) case String: 1 default: 2");
      XExpression _expression = this.expression(_builder);
      final XSwitchExpression expr = ((XSwitchExpression) _expression);
      EList<XCasePart> _cases = expr.getCases();
      XCasePart _head = IterableExtensions.<XCasePart>head(_cases);
      XExpression _then = _head.getThen();
      XExpression _default = expr.getDefault();
      this.hasImplicitReturns(expr, _then, _default);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSwitch02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch (this) case String: return 1 default: return 2");
      XExpression _expression = this.expression(_builder);
      final XSwitchExpression expr = ((XSwitchExpression) _expression);
      this.hasNoImplicitReturns(expr);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTryCatch() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("try 1 catch(Exception e) 2");
      XExpression _expression = this.expression(_builder);
      final XTryCatchFinallyExpression expr = ((XTryCatchFinallyExpression) _expression);
      XExpression _expression_1 = expr.getExpression();
      EList<XCatchClause> _catchClauses = expr.getCatchClauses();
      XCatchClause _head = IterableExtensions.<XCatchClause>head(_catchClauses);
      XExpression _expression_2 = _head.getExpression();
      this.hasImplicitReturns(expr, _expression_1, _expression_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTryCatch02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("try return 1 catch(Exception e) return 2");
      XExpression _expression = this.expression(_builder);
      this.hasNoImplicitReturns(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void hasNoImplicitReturns(final XExpression expression) {
    final ArrayList<XExpression> returns = CollectionLiterals.<XExpression>newArrayList();
    final ImplicitReturnFinder.Acceptor _function = (XExpression it) -> {
      returns.add(it);
    };
    this.finder.findImplicitReturns(expression, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Expected ");
    _builder.append(expression, "");
    _builder.append(" to have no implicit returns, but it had ");
    _builder.append(returns, "");
    boolean _isEmpty = returns.isEmpty();
    Assert.assertTrue(_builder.toString(), _isEmpty);
  }
  
  public void hasImplicitReturns(final XExpression expression, final XExpression... expectedReturns) {
    final ArrayList<Object> returns = CollectionLiterals.<Object>newArrayList();
    final ImplicitReturnFinder.Acceptor _function = (XExpression it) -> {
      returns.add(it);
    };
    this.finder.findImplicitReturns(expression, _function);
    Assert.assertArrayEquals(expectedReturns, ((Object[])Conversions.unwrapArray(returns, Object.class)));
  }
  
  public void isImplicitReturn(final XExpression expression) {
    this.hasImplicitReturns(expression, expression);
  }
}
