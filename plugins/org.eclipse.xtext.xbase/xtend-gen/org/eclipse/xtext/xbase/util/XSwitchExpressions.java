/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.util;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.interpreter.ConstantExpressionEvaluationException;
import org.eclipse.xtext.xbase.interpreter.SwitchConstantExpressionsInterpreter;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XSwitchExpressions {
  @Inject
  @Extension
  private IBatchTypeResolver _iBatchTypeResolver;
  
  @Inject
  @Extension
  private SwitchConstantExpressionsInterpreter _switchConstantExpressionsInterpreter;
  
  public boolean isJavaSwitchExpression(final XSwitchExpression it) {
    boolean _xblockexpression = false;
    {
      @Extension
      final IResolvedTypes resolvedTypes = this._iBatchTypeResolver.resolveTypes(it);
      XExpression _switch = it.getSwitch();
      final LightweightTypeReference switchType = resolvedTypes.getActualType(_switch);
      boolean _equals = Objects.equal(switchType, null);
      if (_equals) {
        return false;
      }
      boolean _isSubtypeOf = switchType.isSubtypeOf(Integer.TYPE);
      if (_isSubtypeOf) {
        return true;
      }
      boolean _isSubtypeOf_1 = switchType.isSubtypeOf(Enum.class);
      if (_isSubtypeOf_1) {
        return true;
      }
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  public boolean isJavaCaseExpression(final XSwitchExpression it, final XCasePart casePart) {
    boolean _xblockexpression = false;
    {
      JvmTypeReference _typeGuard = casePart.getTypeGuard();
      boolean _notEquals = (!Objects.equal(_typeGuard, null));
      if (_notEquals) {
        return false;
      }
      final XExpression case_ = casePart.getCase();
      boolean _equals = Objects.equal(case_, null);
      if (_equals) {
        return false;
      }
      @Extension
      final IResolvedTypes resolvedTypes = this._iBatchTypeResolver.resolveTypes(it);
      final LightweightTypeReference caseType = resolvedTypes.getActualType(case_);
      boolean _equals_1 = Objects.equal(caseType, null);
      if (_equals_1) {
        return false;
      }
      XExpression _switch = it.getSwitch();
      final LightweightTypeReference switchType = resolvedTypes.getActualType(_switch);
      boolean _isAssignableFrom = switchType.isAssignableFrom(caseType);
      boolean _not = (!_isAssignableFrom);
      if (_not) {
        return false;
      }
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  public boolean isConstant(final XExpression it) {
    boolean _equals = Objects.equal(it, null);
    if (_equals) {
      return false;
    }
    try {
      this._switchConstantExpressionsInterpreter.evaluate(it);
      return true;
    } catch (final Throwable _t) {
      if (_t instanceof ConstantExpressionEvaluationException) {
        final ConstantExpressionEvaluationException e = (ConstantExpressionEvaluationException)_t;
        return false;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
