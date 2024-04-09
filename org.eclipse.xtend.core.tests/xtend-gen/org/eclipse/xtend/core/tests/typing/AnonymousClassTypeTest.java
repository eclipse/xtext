/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.typing;

import com.google.inject.Inject;
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
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(this.function(_builder.toString()));
      final IResolvedTypes resolvedTypes = this._iBatchTypeResolver.resolveTypes(operation.eResource());
      Assert.assertEquals("Runnable", resolvedTypes.getActualType(operation).toString());
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
      final IResolvedTypes resolvedTypes = this._iBatchTypeResolver.resolveTypes(operation.eResource());
      Assert.assertEquals("Runnable", resolvedTypes.getActualType(operation).toString());
      XExpression _expression = function.getExpression();
      final XExpression variable = IterableExtensions.<XExpression>lastOrNull(((XBlockExpression) _expression).getExpressions());
      final LightweightTypeReference variableType = resolvedTypes.getActualType(variable);
      Assert.assertEquals("__Foo_1", variableType.toString());
      Assert.assertTrue(variableType.isSubtypeOf(Runnable.class));
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
      final IResolvedTypes resolvedTypes = this._iBatchTypeResolver.resolveTypes(operation.eResource());
      Assert.assertEquals("Iterable<String>", resolvedTypes.getActualType(operation).toString());
      XExpression _expression = function.getExpression();
      XExpression _head = IterableExtensions.<XExpression>head(((XBlockExpression) _expression).getExpressions());
      final AnonymousClass anonymousClass = ((AnonymousClass) _head);
      XtendMember _lastOrNull = IterableExtensions.<XtendMember>lastOrNull(anonymousClass.getMembers());
      final JvmOperation overriding = this._iXtendJvmAssociations.getDirectlyInferredOperation(((XtendFunction) _lastOrNull));
      Assert.assertEquals("Iterator<String>", resolvedTypes.getActualType(overriding).toString());
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
      final IResolvedTypes resolvedTypes = this._iBatchTypeResolver.resolveTypes(operation.eResource());
      Assert.assertEquals("Iterable<T>", resolvedTypes.getActualType(operation).toString());
      XExpression _expression = function.getExpression();
      XExpression _head = IterableExtensions.<XExpression>head(((XBlockExpression) _expression).getExpressions());
      final AnonymousClass anonymousClass = ((AnonymousClass) _head);
      XtendMember _lastOrNull = IterableExtensions.<XtendMember>lastOrNull(anonymousClass.getMembers());
      final JvmOperation overriding = this._iXtendJvmAssociations.getDirectlyInferredOperation(((XtendFunction) _lastOrNull));
      Assert.assertEquals("Iterator<T>", resolvedTypes.getActualType(overriding).toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
