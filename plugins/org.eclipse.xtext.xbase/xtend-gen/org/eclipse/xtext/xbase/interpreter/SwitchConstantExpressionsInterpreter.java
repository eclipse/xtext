/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.interpreter;

import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
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
    return this.numberLiterals.numberValue(it, Integer.class);
  }
  
  protected Object _internalEvaluate(final XAbstractFeatureCall it, final Context ctx) {
    JvmIdentifiableElement _feature = it.getFeature();
    final JvmIdentifiableElement feature = _feature;
    boolean _matched = false;
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
          return ((JvmField)feature).getConstantValue();
        }
        XExpression _associatedExpression = this._iLogicalContainerProvider.getAssociatedExpression(feature);
        return this.internalEvaluate(_associatedExpression, ctx);
      }
    }
    if (!_matched) {
      if (feature instanceof XVariableDeclaration) {
        _matched=true;
        XExpression _right = ((XVariableDeclaration)feature).getRight();
        return this.internalEvaluate(_right, ctx);
      }
    }
    JvmIdentifiableElement _feature_1 = it.getFeature();
    String _simpleName = _feature_1.getSimpleName();
    String _plus = ("Couldn\'t resolve feature " + _simpleName);
    throw new UnresolvableFeatureException(_plus, it);
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
