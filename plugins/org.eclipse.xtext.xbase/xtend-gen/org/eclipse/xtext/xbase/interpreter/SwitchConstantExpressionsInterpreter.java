/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.interpreter;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.interpreter.AbstractConstantExpressionsInterpreter;
import org.eclipse.xtext.xbase.interpreter.Context;
import org.eclipse.xtext.xbase.interpreter.UnresolvableFeatureException;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.typesystem.computation.NumberLiterals;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class SwitchConstantExpressionsInterpreter extends AbstractConstantExpressionsInterpreter {
  @Inject
  @Extension
  private ILogicalContainerProvider _iLogicalContainerProvider;
  
  @Inject
  @Extension
  private NumberLiterals numberLiterals;
  
  public Object evaluate(final XExpression it) {
    return this.internalEvaluate(it, null);
  }
  
  protected Object _internalEvaluate(final XNumberLiteral it, final Context ctx) {
    Class<? extends Number> _javaType = this.numberLiterals.getJavaType(it);
    return this.numberLiterals.numberValue(it, _javaType);
  }
  
  protected Object _internalEvaluate(final XAbstractFeatureCall it, final Context ctx) {
    JvmIdentifiableElement _feature = it.getFeature();
    final JvmIdentifiableElement feature = _feature;
    boolean _matched = false;
    if (!_matched) {
      if (feature instanceof JvmType) {
        _matched=true;
        return this.toTypeReference(((JvmType)feature), 0);
      }
    }
    if (!_matched) {
      if (feature instanceof JvmEnumerationLiteral) {
        _matched=true;
        return feature;
      }
    }
    if (!_matched) {
      if (feature instanceof JvmField) {
        _matched=true;
        boolean _isSetConstant = ((JvmField)feature).isSetConstant();
        if (_isSetConstant) {
          boolean _isConstant = ((JvmField)feature).isConstant();
          if (_isConstant) {
            return ((JvmField)feature).getConstantValue();
          }
        } else {
          boolean _isFinal = ((JvmField)feature).isFinal();
          if (_isFinal) {
            final XExpression associatedExpression = this._iLogicalContainerProvider.getAssociatedExpression(feature);
            boolean _notEquals = (!Objects.equal(associatedExpression, null));
            if (_notEquals) {
              return this.evaluateAssociatedExpression(associatedExpression, ctx);
            }
          }
        }
      }
    }
    if (!_matched) {
      if (feature instanceof XVariableDeclaration) {
        boolean _and = false;
        boolean _isWriteable = ((XVariableDeclaration)feature).isWriteable();
        boolean _not = (!_isWriteable);
        if (!_not) {
          _and = false;
        } else {
          XExpression _right = ((XVariableDeclaration)feature).getRight();
          boolean _notEquals = (!Objects.equal(_right, null));
          _and = _notEquals;
        }
        if (_and) {
          _matched=true;
          XExpression _right_1 = ((XVariableDeclaration)feature).getRight();
          return this.evaluateAssociatedExpression(_right_1, ctx);
        }
      }
    }
    if (!_matched) {
      if (feature instanceof XSwitchExpression) {
        XExpression _switch = ((XSwitchExpression)feature).getSwitch();
        boolean _notEquals = (!Objects.equal(_switch, null));
        if (_notEquals) {
          _matched=true;
          XExpression _switch_1 = ((XSwitchExpression)feature).getSwitch();
          return this.internalEvaluate(_switch_1, ctx);
        }
      }
    }
    JvmIdentifiableElement _feature_1 = it.getFeature();
    String _simpleName = _feature_1.getSimpleName();
    String _plus = ("Couldn\'t resolve feature " + _simpleName);
    throw new UnresolvableFeatureException(_plus, it);
  }
  
  public Object evaluateAssociatedExpression(final XExpression it, final Context ctx) {
    Object _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (it instanceof XAbstractFeatureCall) {
        JvmIdentifiableElement _feature = ((XAbstractFeatureCall)it).getFeature();
        if ((_feature instanceof JvmEnumerationLiteral)) {
          _matched=true;
          throw this.notConstantExpression(it);
        }
      }
    }
    if (!_matched) {
      _switchResult = this.internalEvaluate(it, ctx);
    }
    return _switchResult;
  }
  
  public Object internalEvaluate(final XExpression it, final Context ctx) {
    if (it instanceof XBinaryOperation) {
      return _internalEvaluate((XBinaryOperation)it, ctx);
    } else if (it instanceof XUnaryOperation) {
      return _internalEvaluate((XUnaryOperation)it, ctx);
    } else if (it instanceof XAbstractFeatureCall) {
      return _internalEvaluate((XAbstractFeatureCall)it, ctx);
    } else if (it instanceof XBooleanLiteral) {
      return _internalEvaluate((XBooleanLiteral)it, ctx);
    } else if (it instanceof XCastedExpression) {
      return _internalEvaluate((XCastedExpression)it, ctx);
    } else if (it instanceof XNumberLiteral) {
      return _internalEvaluate((XNumberLiteral)it, ctx);
    } else if (it instanceof XStringLiteral) {
      return _internalEvaluate((XStringLiteral)it, ctx);
    } else if (it instanceof XTypeLiteral) {
      return _internalEvaluate((XTypeLiteral)it, ctx);
    } else if (it instanceof XAnnotation) {
      return _internalEvaluate((XAnnotation)it, ctx);
    } else if (it != null) {
      return _internalEvaluate(it, ctx);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, ctx).toString());
    }
  }
}
