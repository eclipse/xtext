/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.controlflow;

import com.google.common.base.Objects;
import java.util.Arrays;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.controlflow.EarlyExitInterpreter;
import org.eclipse.xtext.xbase.interpreter.ConstantExpressionEvaluationException;
import org.eclipse.xtext.xbase.interpreter.Context;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ConstantConditionsInterpreter extends EarlyExitInterpreter {
  public Boolean getBooleanConstantOrNull(final XExpression it) {
    try {
      final Object constant = this.evaluate(it);
      if ((constant instanceof Boolean)) {
        return ((Boolean)constant);
      }
      return null;
    } catch (final Throwable _t) {
      if (_t instanceof ConstantExpressionEvaluationException) {
        final ConstantExpressionEvaluationException e = (ConstantExpressionEvaluationException)_t;
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  protected Object _internalEvaluate(final XNullLiteral it, final Context ctx) {
    return null;
  }
  
  protected Object evaluateBinaryOperation(final XBinaryOperation binaryOperation, final Object left, final Object right) {
    Object _xifexpression = null;
    boolean _or = false;
    boolean _equals = Objects.equal(left, null);
    if (_equals) {
      _or = true;
    } else {
      boolean _equals_1 = Objects.equal(right, null);
      _or = _equals_1;
    }
    if (_or) {
      boolean _xblockexpression = false;
      {
        final String op = binaryOperation.getConcreteSyntaxFeatureName();
        boolean _switchResult = false;
        boolean _matched = false;
        if (!_matched) {
          if (Objects.equal(op, "==")) {
            _matched=true;
          }
          if (!_matched) {
            if (Objects.equal(op, "===")) {
              _matched=true;
            }
          }
          if (_matched) {
            _switchResult = (left == right);
          }
        }
        if (!_matched) {
          if (Objects.equal(op, "!=")) {
            _matched=true;
          }
          if (!_matched) {
            if (Objects.equal(op, "!==")) {
              _matched=true;
            }
          }
          if (_matched) {
            _switchResult = (left != right);
          }
        }
        if (!_matched) {
          throw new ConstantExpressionEvaluationException(((((("Couldn\'t evaluate binary operator \'" + op) + "\' on values ") + left) + " and ") + right));
        }
        _xblockexpression = _switchResult;
      }
      _xifexpression = Boolean.valueOf(_xblockexpression);
    } else {
      _xifexpression = super.evaluateBinaryOperation(binaryOperation, left, right);
    }
    return _xifexpression;
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
    } else if (it instanceof XNullLiteral) {
      return _internalEvaluate((XNullLiteral)it, ctx);
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
    } else if (it == null) {
      return _internalEvaluate((Void)null, ctx);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, ctx).toString());
    }
  }
}
