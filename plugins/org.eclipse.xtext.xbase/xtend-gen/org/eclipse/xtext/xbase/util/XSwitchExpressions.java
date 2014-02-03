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
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.validation.ConstantExpressionValidator;

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
  private ConstantExpressionValidator _constantExpressionValidator;
  
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
      boolean _isType = switchType.isType(Integer.TYPE);
      if (_isType) {
        return true;
      }
      boolean _isType_1 = switchType.isType(Enum.class);
      if (_isType_1) {
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
      boolean _isConstant = this.isConstant(casePart);
      boolean _not = (!_isConstant);
      if (_not) {
        return false;
      }
      @Extension
      final IResolvedTypes resolvedTypes = this._iBatchTypeResolver.resolveTypes(it);
      XExpression _case = casePart.getCase();
      final LightweightTypeReference caseType = resolvedTypes.getActualType(_case);
      boolean _equals = Objects.equal(caseType, null);
      if (_equals) {
        return false;
      }
      XExpression _switch = it.getSwitch();
      final LightweightTypeReference switchType = resolvedTypes.getActualType(_switch);
      boolean _isAssignableFrom = switchType.isAssignableFrom(caseType);
      boolean _not_1 = (!_isAssignableFrom);
      if (_not_1) {
        return false;
      }
      _xblockexpression = (true);
    }
    return _xblockexpression;
  }
  
  public boolean isConstant(final XCasePart casePart) {
    final XExpression case_ = casePart.getCase();
    boolean _equals = Objects.equal(case_, null);
    if (_equals) {
      return false;
    }
    return this._constantExpressionValidator.isConstant(case_);
  }
}
