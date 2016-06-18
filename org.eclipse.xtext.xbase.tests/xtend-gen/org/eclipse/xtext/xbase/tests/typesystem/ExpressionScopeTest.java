/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
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
    IScope _featureScope = scope.getFeatureScope();
    QualifiedName _create = QualifiedName.create(name);
    this.assertContains(_featureScope, _create);
  }
  
  protected void assertContains(final IScope scope, final QualifiedName name) {
    final Iterable<IEObjectDescription> elements = scope.getAllElements();
    final String toString = elements.toString();
    IEObjectDescription _singleElement = scope.getSingleElement(name);
    Assert.assertNotNull(toString, _singleElement);
    Iterable<IEObjectDescription> _elements = scope.getElements(name);
    boolean _isEmpty = IterableExtensions.isEmpty(_elements);
    Assert.assertFalse(toString, _isEmpty);
    final Function1<IEObjectDescription, Boolean> _function = (IEObjectDescription it) -> {
      QualifiedName _name = it.getName();
      return Boolean.valueOf(Objects.equal(_name, name));
    };
    boolean _exists = IterableExtensions.<IEObjectDescription>exists(elements, _function);
    Assert.assertTrue(toString, _exists);
  }
  
  protected void containsNot(final IExpressionScope scope, final String name) {
    IScope _featureScope = scope.getFeatureScope();
    QualifiedName _create = QualifiedName.create(name);
    this.assertContainsNot(_featureScope, _create);
  }
  
  protected void assertContainsNot(final IScope scope, final QualifiedName name) {
    final Iterable<IEObjectDescription> elements = scope.getAllElements();
    final String toString = elements.toString();
    IEObjectDescription _singleElement = scope.getSingleElement(name);
    Assert.assertNull(toString, _singleElement);
    Iterable<IEObjectDescription> _elements = scope.getElements(name);
    boolean _isEmpty = IterableExtensions.isEmpty(_elements);
    Assert.assertTrue(toString, _isEmpty);
    final Function1<IEObjectDescription, Boolean> _function = (IEObjectDescription it) -> {
      QualifiedName _name = it.getName();
      return Boolean.valueOf(Objects.equal(_name, name));
    };
    boolean _exists = IterableExtensions.<IEObjectDescription>exists(elements, _function);
    Assert.assertFalse(toString, _exists);
  }
  
  @Test
  public void testGetExpressionScope_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{ var x = 1 }");
      XExpression _expression = this.expression(_builder, false);
      final XBlockExpression block = ((XBlockExpression) _expression);
      IResolvedTypes _resolveTypes = this._iBatchTypeResolver.resolveTypes(block);
      final IExpressionScope expressionScope = _resolveTypes.getExpressionScope(block, IExpressionScope.Anchor.AFTER);
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
      IResolvedTypes _resolveTypes = this._iBatchTypeResolver.resolveTypes(block);
      final IExpressionScope expressionScope = _resolveTypes.getExpressionScope(block, IExpressionScope.Anchor.BEFORE);
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
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      final XExpression varDecl = IterableExtensions.<XExpression>head(_expressions);
      IResolvedTypes _resolveTypes = this._iBatchTypeResolver.resolveTypes(varDecl);
      final IExpressionScope expressionScope = _resolveTypes.getExpressionScope(varDecl, IExpressionScope.Anchor.AFTER);
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
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      final XExpression varDecl = IterableExtensions.<XExpression>head(_expressions);
      IResolvedTypes _resolveTypes = this._iBatchTypeResolver.resolveTypes(varDecl);
      final IExpressionScope expressionScope = _resolveTypes.getExpressionScope(varDecl, IExpressionScope.Anchor.BEFORE);
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
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      final XExpression varDecl = IterableExtensions.<XExpression>head(_expressions);
      IResolvedTypes _resolveTypes = this._iBatchTypeResolver.resolveTypes(varDecl);
      final IExpressionScope expressionScope = _resolveTypes.getExpressionScope(varDecl, IExpressionScope.Anchor.AFTER);
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
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      final XExpression varDecl = IterableExtensions.<XExpression>head(_expressions);
      IResolvedTypes _resolveTypes = this._iBatchTypeResolver.resolveTypes(varDecl);
      final IExpressionScope expressionScope = _resolveTypes.getExpressionScope(varDecl, IExpressionScope.Anchor.BEFORE);
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
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      XExpression _head = IterableExtensions.<XExpression>head(_expressions);
      final XExpression varInit = ((XVariableDeclaration) _head).getRight();
      IResolvedTypes _resolveTypes = this._iBatchTypeResolver.resolveTypes(varInit);
      final IExpressionScope expressionScope = _resolveTypes.getExpressionScope(varInit, IExpressionScope.Anchor.BEFORE);
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
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      XExpression _head = IterableExtensions.<XExpression>head(_expressions);
      final XExpression varInit = ((XVariableDeclaration) _head).getRight();
      IResolvedTypes _resolveTypes = this._iBatchTypeResolver.resolveTypes(varInit);
      final IExpressionScope expressionScope = _resolveTypes.getExpressionScope(varInit, IExpressionScope.Anchor.BEFORE);
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
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      XExpression _head = IterableExtensions.<XExpression>head(_expressions);
      final XExpression varInit = ((XVariableDeclaration) _head).getRight();
      IResolvedTypes _resolveTypes = this._iBatchTypeResolver.resolveTypes(varInit);
      final IExpressionScope expressionScope = _resolveTypes.getExpressionScope(varInit, IExpressionScope.Anchor.BEFORE);
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
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      final XExpression varDecl = IterableExtensions.<XExpression>head(_expressions);
      IResolvedTypes _resolveTypes = this._iBatchTypeResolver.resolveTypes(varDecl);
      final IExpressionScope expressionScope = _resolveTypes.getExpressionScope(varDecl, IExpressionScope.Anchor.BEFORE);
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
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      XExpression _last = IterableExtensions.<XExpression>last(_expressions);
      final XIfExpression ifExpr = ((XIfExpression) _last);
      XExpression _then = ifExpr.getThen();
      final XBlockExpression block = ((XBlockExpression) _then);
      IResolvedTypes _resolveTypes = this._iBatchTypeResolver.resolveTypes(block);
      final IExpressionScope expressionScope = _resolveTypes.getExpressionScope(block, IExpressionScope.Anchor.BEFORE);
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
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      XExpression _last = IterableExtensions.<XExpression>last(_expressions);
      final XIfExpression ifExpr = ((XIfExpression) _last);
      XExpression _then = ifExpr.getThen();
      final XBlockExpression block = ((XBlockExpression) _then);
      IResolvedTypes _resolveTypes = this._iBatchTypeResolver.resolveTypes(block);
      final IExpressionScope expressionScope = _resolveTypes.getExpressionScope(block, IExpressionScope.Anchor.BEFORE);
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
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      XExpression _last = IterableExtensions.<XExpression>last(_expressions);
      final XIfExpression ifExpr = ((XIfExpression) _last);
      XExpression _then = ifExpr.getThen();
      final XBlockExpression block = ((XBlockExpression) _then);
      EList<XExpression> _expressions_1 = block.getExpressions();
      final XExpression assignment = IterableExtensions.<XExpression>head(_expressions_1);
      IResolvedTypes _resolveTypes = this._iBatchTypeResolver.resolveTypes(assignment);
      final IExpressionScope expressionScope = _resolveTypes.getExpressionScope(assignment, IExpressionScope.Anchor.AFTER);
      this.containsNot(expressionScope, "charAt");
      this.contains(expressionScope, "it");
      this.containsNot(expressionScope, "operator_lessThan");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
