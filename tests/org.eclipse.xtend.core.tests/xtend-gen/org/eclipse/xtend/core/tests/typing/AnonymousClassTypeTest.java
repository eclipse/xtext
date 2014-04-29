/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.typing;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class AnonymousClassTypeTest extends AbstractXtendTestCase {
  @Inject
  @Extension
  private IBatchTypeResolver _iBatchTypeResolver;
  
  @Inject
  @Extension
  private IXtendJvmAssociations _iXtendJvmAssociations;
  
  @Test
  public void testPlainAnonymous() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new Runnable() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("override run() {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendFunction _function = this.function(_builder.toString());
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(_function);
      Resource _eResource = operation.eResource();
      final IResolvedTypes resolvedTypes = this._iBatchTypeResolver.resolveTypes(_eResource);
      LightweightTypeReference _actualType = resolvedTypes.getActualType(operation);
      String _string = _actualType.toString();
      Assert.assertEquals("Runnable", _string);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAnonymousWithAdditionalMember() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val foo = new Runnable() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("int bar");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("override run() {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("foo");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFunction function = this.function(_builder.toString());
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(function);
      Resource _eResource = operation.eResource();
      final IResolvedTypes resolvedTypes = this._iBatchTypeResolver.resolveTypes(_eResource);
      LightweightTypeReference _actualType = resolvedTypes.getActualType(operation);
      String _string = _actualType.toString();
      Assert.assertEquals("Runnable", _string);
      XExpression _expression = function.getExpression();
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      final XExpression variable = IterableExtensions.<XExpression>last(_expressions);
      final LightweightTypeReference variableType = resolvedTypes.getActualType(variable);
      String _string_1 = variableType.toString();
      Assert.assertEquals("__Foo_0", _string_1);
      boolean _isSubtypeOf = variableType.isSubtypeOf(Runnable.class);
      Assert.assertTrue(_isSubtypeOf);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testOverriddenMethodTypeArgumentInference() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new Iterable<String>() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("override iterator() {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFunction function = this.function(_builder.toString());
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(function);
      Resource _eResource = operation.eResource();
      final IResolvedTypes resolvedTypes = this._iBatchTypeResolver.resolveTypes(_eResource);
      LightweightTypeReference _actualType = resolvedTypes.getActualType(operation);
      String _string = _actualType.toString();
      Assert.assertEquals("Iterable<String>", _string);
      XExpression _expression = function.getExpression();
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      XExpression _head = IterableExtensions.<XExpression>head(_expressions);
      final AnonymousClass anonymousClass = ((AnonymousClass) _head);
      EList<XtendMember> _members = anonymousClass.getMembers();
      XtendMember _last = IterableExtensions.<XtendMember>last(_members);
      final JvmOperation overriding = this._iXtendJvmAssociations.getDirectlyInferredOperation(((XtendFunction) _last));
      LightweightTypeReference _actualType_1 = resolvedTypes.getActualType(overriding);
      String _string_1 = _actualType_1.toString();
      Assert.assertEquals("Iterator<String>", _string_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testOverriddenMethodTypeArgumentInference_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def <T> foo() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new Iterable<T>() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("override iterator() {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFunction function = this.function(_builder.toString());
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(function);
      Resource _eResource = operation.eResource();
      final IResolvedTypes resolvedTypes = this._iBatchTypeResolver.resolveTypes(_eResource);
      LightweightTypeReference _actualType = resolvedTypes.getActualType(operation);
      String _string = _actualType.toString();
      Assert.assertEquals("Iterable<T>", _string);
      XExpression _expression = function.getExpression();
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      XExpression _head = IterableExtensions.<XExpression>head(_expressions);
      final AnonymousClass anonymousClass = ((AnonymousClass) _head);
      EList<XtendMember> _members = anonymousClass.getMembers();
      XtendMember _last = IterableExtensions.<XtendMember>last(_members);
      final JvmOperation overriding = this._iXtendJvmAssociations.getDirectlyInferredOperation(((XtendFunction) _last));
      LightweightTypeReference _actualType_1 = resolvedTypes.getActualType(overriding);
      String _string_1 = _actualType_1.toString();
      Assert.assertEquals("Iterator<T>", _string_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
