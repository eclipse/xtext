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
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmFormalParameter;
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
      final LightweightTypeReference switchType = this.getSwitchVariableType(it);
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
      _xblockexpression = (false);
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
      final LightweightTypeReference switchType = this.getSwitchVariableType(it);
      boolean _isAssignableFrom = switchType.isAssignableFrom(caseType);
      boolean _not = (!_isAssignableFrom);
      if (_not) {
        return false;
      }
      _xblockexpression = (true);
    }
    return _xblockexpression;
  }
  
  public LightweightTypeReference getSwitchVariableType(final XSwitchExpression it) {
    @Extension
    final IResolvedTypes resolvedTypes = this._iBatchTypeResolver.resolveTypes(it);
    final JvmFormalParameter declaredParam = it.getDeclaredParam();
    boolean _equals = Objects.equal(declaredParam, null);
    if (_equals) {
      XExpression _switch = it.getSwitch();
      return resolvedTypes.getActualType(_switch);
    }
    final LightweightTypeReference paramType = resolvedTypes.getActualType(declaredParam);
    LightweightTypeReference _elvis = null;
    if (paramType != null) {
      _elvis = paramType;
    } else {
      XExpression _switch_1 = it.getSwitch();
      LightweightTypeReference _actualType = resolvedTypes.getActualType(_switch_1);
      _elvis = _actualType;
    }
    return _elvis;
  }
  
  public boolean isConstant(final XCasePart casePart) {
    final XExpression case_ = casePart.getCase();
    boolean _equals = Objects.equal(case_, null);
    if (_equals) {
      return false;
    }
    try {
      this._switchConstantExpressionsInterpreter.evaluate(case_);
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
  
  public XExpression getThen(final XCasePart casePart, final XSwitchExpression switchExpression) {
    final XExpression then = casePart.getThen();
    boolean _notEquals = (!Objects.equal(then, null));
    if (_notEquals) {
      return then;
    }
    EList<XCasePart> _cases = switchExpression.getCases();
    final int casePartIndex = _cases.indexOf(casePart);
    if ((casePartIndex == (-1))) {
      return null;
    }
    EList<XCasePart> _cases_1 = switchExpression.getCases();
    final int count = _cases_1.size();
    if ((casePartIndex == (count - 1))) {
      return switchExpression.getDefault();
    }
    if (((casePartIndex + 1) < count)) {
      EList<XCasePart> _cases_2 = switchExpression.getCases();
      XCasePart _get = _cases_2.get((casePartIndex + 1));
      return this.getThen(_get, switchExpression);
    }
    return null;
  }
}
