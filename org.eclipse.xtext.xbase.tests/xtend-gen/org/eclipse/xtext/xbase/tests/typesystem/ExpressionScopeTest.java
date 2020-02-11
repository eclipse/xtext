/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.tests.XbaseInjectorProviderWithScopeTracking;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IExpressionScope;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(XbaseInjectorProviderWithScopeTracking.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class ExpressionScopeTest extends AbstractXbaseTestCase {
  @Inject
  @Extension
  private IBatchTypeResolver _iBatchTypeResolver;
  
  protected void contains(final IExpressionScope scope, final String name) {
    this.assertContains(scope.getFeatureScope(), QualifiedName.create(name));
  }
  
  protected void assertContains(final IScope scope, final QualifiedName name) {
    final Iterable<IEObjectDescription> elements = scope.getAllElements();
    final String toString = elements.toString();
    Assert.assertNotNull(toString, scope.getSingleElement(name));
    Assert.assertFalse(toString, IterableExtensions.isEmpty(scope.getElements(name)));
    final Function1<IEObjectDescription, Boolean> _function = (IEObjectDescription it) -> {
      QualifiedName _name = it.getName();
      return Boolean.valueOf(Objects.equal(_name, name));
    };
    Assert.assertTrue(toString, IterableExtensions.<IEObjectDescription>exists(elements, _function));
  }
  
  protected void containsNot(final IExpressionScope scope, final String name) {
    this.assertContainsNot(scope.getFeatureScope(), QualifiedName.create(name));
  }
  
  protected void assertContainsNot(final IScope scope, final QualifiedName name) {
    final Iterable<IEObjectDescription> elements = scope.getAllElements();
    final String toString = elements.toString();
    Assert.assertNull(toString, scope.getSingleElement(name));
    Assert.assertTrue(toString, IterableExtensions.isEmpty(scope.getElements(name)));
    final Function1<IEObjectDescription, Boolean> _function = (IEObjectDescription it) -> {
      QualifiedName _name = it.getName();
      return Boolean.valueOf(Objects.equal(_name, name));
    };
    Assert.assertFalse(toString, IterableExtensions.<IEObjectDescription>exists(elements, _function));
  }
  
  @Test
  public void testGetExpressionScope_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{ var x = 1 }");
      XExpression _expression = this.expression(_builder, false);
      final XBlockExpression block = ((XBlockExpression) _expression);
      final IExpressionScope expressionScope = this._iBatchTypeResolver.resolveTypes(block).getExpressionScope(block, IExpressionScope.Anchor.AFTER);
      this.containsNot(expressionScope, "x");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testGetExpressionScope_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{ var x = 1 }");
      XExpression _expression = this.expression(_builder, false);
      final XBlockExpression block = ((XBlockExpression) _expression);
      final IExpressionScope expressionScope = this._iBatchTypeResolver.resolveTypes(block).getExpressionScope(block, IExpressionScope.Anchor.BEFORE);
      this.containsNot(expressionScope, "x");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testGetExpressionScope_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{ var x = 1 }");
      XExpression _expression = this.expression(_builder, false);
      final XExpression varDecl = IterableExtensions.<XExpression>head(((XBlockExpression) _expression).getExpressions());
      final IExpressionScope expressionScope = this._iBatchTypeResolver.resolveTypes(varDecl).getExpressionScope(varDecl, IExpressionScope.Anchor.AFTER);
      this.contains(expressionScope, "x");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testGetExpressionScope_04() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{ var x = 1 }");
      XExpression _expression = this.expression(_builder, false);
      final XExpression varDecl = IterableExtensions.<XExpression>head(((XBlockExpression) _expression).getExpressions());
      final IExpressionScope expressionScope = this._iBatchTypeResolver.resolveTypes(varDecl).getExpressionScope(varDecl, IExpressionScope.Anchor.BEFORE);
      this.containsNot(expressionScope, "x");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testMemberOnIt_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{ var it = \"\" }");
      XExpression _expression = this.expression(_builder, false);
      final XExpression varDecl = IterableExtensions.<XExpression>head(((XBlockExpression) _expression).getExpressions());
      final IExpressionScope expressionScope = this._iBatchTypeResolver.resolveTypes(varDecl).getExpressionScope(varDecl, IExpressionScope.Anchor.AFTER);
      this.contains(expressionScope, "charAt");
      this.contains(expressionScope, "it");
      this.contains(expressionScope, "operator_lessThan");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testMemberOnIt_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{ var it = \"\" }");
      XExpression _expression = this.expression(_builder, false);
      final XExpression varDecl = IterableExtensions.<XExpression>head(((XBlockExpression) _expression).getExpressions());
      final IExpressionScope expressionScope = this._iBatchTypeResolver.resolveTypes(varDecl).getExpressionScope(varDecl, IExpressionScope.Anchor.BEFORE);
      this.containsNot(expressionScope, "charAt");
      this.containsNot(expressionScope, "it");
      this.containsNot(expressionScope, "operator_lessThan");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testMemberOnIt_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{ var (int)=>int it = [] }");
      XExpression _expression = this.expression(_builder, false);
      XExpression _head = IterableExtensions.<XExpression>head(((XBlockExpression) _expression).getExpressions());
      final XExpression varInit = ((XVariableDeclaration) _head).getRight();
      final IExpressionScope expressionScope = this._iBatchTypeResolver.resolveTypes(varInit).getExpressionScope(varInit, IExpressionScope.Anchor.BEFORE);
      this.contains(expressionScope, "it");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testMemberOnIt_04() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{ var it = [] }");
      XExpression _expression = this.expression(_builder, false);
      XExpression _head = IterableExtensions.<XExpression>head(((XBlockExpression) _expression).getExpressions());
      final XExpression varInit = ((XVariableDeclaration) _head).getRight();
      final IExpressionScope expressionScope = this._iBatchTypeResolver.resolveTypes(varInit).getExpressionScope(varInit, IExpressionScope.Anchor.BEFORE);
      this.containsNot(expressionScope, "it");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testMemberOnIt_05() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{ var (int)=>int it = null }");
      XExpression _expression = this.expression(_builder, false);
      XExpression _head = IterableExtensions.<XExpression>head(((XBlockExpression) _expression).getExpressions());
      final XExpression varInit = ((XVariableDeclaration) _head).getRight();
      final IExpressionScope expressionScope = this._iBatchTypeResolver.resolveTypes(varInit).getExpressionScope(varInit, IExpressionScope.Anchor.BEFORE);
      this.containsNot(expressionScope, "it");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDefaultStaticMethods_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{ var it = \"\" }");
      XExpression _expression = this.expression(_builder, false);
      final XExpression varDecl = IterableExtensions.<XExpression>head(((XBlockExpression) _expression).getExpressions());
      final IExpressionScope expressionScope = this._iBatchTypeResolver.resolveTypes(varDecl).getExpressionScope(varDecl, IExpressionScope.Anchor.BEFORE);
      this.contains(expressionScope, "newArrayList");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testReassignedType_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{ var it = new Object() if (it instanceof String) {} }");
      XExpression _expression = this.expression(_builder, false);
      XExpression _last = IterableExtensions.<XExpression>last(((XBlockExpression) _expression).getExpressions());
      final XIfExpression ifExpr = ((XIfExpression) _last);
      XExpression _then = ifExpr.getThen();
      final XBlockExpression block = ((XBlockExpression) _then);
      final IExpressionScope expressionScope = this._iBatchTypeResolver.resolveTypes(block).getExpressionScope(block, IExpressionScope.Anchor.BEFORE);
      this.contains(expressionScope, "charAt");
      this.contains(expressionScope, "it");
      this.contains(expressionScope, "operator_lessThan");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testReassignedType_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{ var it = new Object() if (it instanceof String) { it = new Object() } }");
      XExpression _expression = this.expression(_builder, false);
      XExpression _last = IterableExtensions.<XExpression>last(((XBlockExpression) _expression).getExpressions());
      final XIfExpression ifExpr = ((XIfExpression) _last);
      XExpression _then = ifExpr.getThen();
      final XBlockExpression block = ((XBlockExpression) _then);
      final IExpressionScope expressionScope = this._iBatchTypeResolver.resolveTypes(block).getExpressionScope(block, IExpressionScope.Anchor.BEFORE);
      this.contains(expressionScope, "charAt");
      this.contains(expressionScope, "it");
      this.contains(expressionScope, "operator_lessThan");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testReassignedType_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{ var it = new Object() if (it instanceof String) { it = new Object() } }");
      XExpression _expression = this.expression(_builder, false);
      XExpression _last = IterableExtensions.<XExpression>last(((XBlockExpression) _expression).getExpressions());
      final XIfExpression ifExpr = ((XIfExpression) _last);
      XExpression _then = ifExpr.getThen();
      final XBlockExpression block = ((XBlockExpression) _then);
      final XExpression assignment = IterableExtensions.<XExpression>head(block.getExpressions());
      final IExpressionScope expressionScope = this._iBatchTypeResolver.resolveTypes(assignment).getExpressionScope(assignment, IExpressionScope.Anchor.AFTER);
      this.containsNot(expressionScope, "charAt");
      this.contains(expressionScope, "it");
      this.containsNot(expressionScope, "operator_lessThan");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
