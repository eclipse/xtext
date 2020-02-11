/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.validation;

import com.google.inject.Inject;
import java.util.ArrayList;
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
      this.hasNoImplicitReturns(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testVariableDeclaration() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{val x = \"foo\"}");
      this.hasNoImplicitReturns(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testForLoop() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("for (i: 1..10)");
      this.hasNoImplicitReturns(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testWhileLoop() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("while (true)");
      this.hasNoImplicitReturns(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDoWhileLoop() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("do while (true)");
      this.hasNoImplicitReturns(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testThrow() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("throw new RuntimeException()");
      this.hasNoImplicitReturns(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNumberLiteral() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("1");
      this.isImplicitReturn(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNullLiteral() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("null");
      this.isImplicitReturn(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBooleanLiteral() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("true");
      this.isImplicitReturn(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testStringLiteral() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"foo\"");
      this.isImplicitReturn(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testListLiteral() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"#[]\"");
      this.isImplicitReturn(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSetLiteral() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"#{}\"");
      this.isImplicitReturn(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFeatureCall() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"foo.length\"");
      this.isImplicitReturn(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCLosure() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("[]");
      this.isImplicitReturn(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCast() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("1 as int");
      this.isImplicitReturn(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testInstaceof() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("1 instanceof int");
      this.isImplicitReturn(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testConstructorCall() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new String");
      this.isImplicitReturn(this.expression(_builder));
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
      this.hasImplicitReturns(block, IterableExtensions.<XExpression>head(block.getExpressions()));
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
      this.hasNoImplicitReturns(this.expression(_builder));
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
      this.hasImplicitReturns(block, IterableExtensions.<XExpression>head(((XBlockExpression) _expression_1).getExpressions()));
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
      this.hasImplicitReturns(expr, expr.getThen(), expr.getElse());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIf02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("if (true) return 1 else return 2");
      this.hasNoImplicitReturns(this.expression(_builder));
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
      this.hasImplicitReturns(expr, IterableExtensions.<XCasePart>head(expr.getCases()).getThen(), expr.getDefault());
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
      this.hasImplicitReturns(expr, expr.getExpression(), IterableExtensions.<XCatchClause>head(expr.getCatchClauses()).getExpression());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTryCatch02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("try return 1 catch(Exception e) return 2");
      this.hasNoImplicitReturns(this.expression(_builder));
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
    _builder.append(expression);
    _builder.append(" to have no implicit returns, but it had ");
    _builder.append(returns);
    Assert.assertTrue(_builder.toString(), returns.isEmpty());
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
