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
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.interpreter.ConstantExpressionEvaluationException;
import org.eclipse.xtext.xbase.interpreter.ConstantOperators;
import org.eclipse.xtext.xbase.interpreter.Context;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class AbstractConstantExpressionsInterpreter {
  @Inject
  private ConstantOperators constantOperators;
  
  protected Object _internalEvaluate(final XExpression expression, final Context ctx) {
    throw this.notConstantExpression(expression);
  }
  
  public ConstantExpressionEvaluationException notConstantExpression(final XExpression expression) {
    String _text = null;
    if (expression!=null) {
      _text=this.toText(expression);
    }
    String _plus = ("Not a constant expression : \'" + _text);
    String _plus_1 = (_plus + "\'");
    return new ConstantExpressionEvaluationException(_plus_1, expression);
  }
  
  protected Object _internalEvaluate(final XCastedExpression expression, final Context ctx) {
    XExpression _target = expression.getTarget();
    return this.internalEvaluate(_target, ctx);
  }
  
  protected Object _internalEvaluate(final XStringLiteral it, final Context ctx) {
    return it.getValue();
  }
  
  protected Object _internalEvaluate(final XBooleanLiteral it, final Context ctx) {
    return Boolean.valueOf(it.isIsTrue());
  }
  
  protected Object _internalEvaluate(final XAnnotation literal, final Context ctx) {
    return literal;
  }
  
  protected Object _internalEvaluate(final XTypeLiteral it, final Context ctx) {
    JvmType _type = it.getType();
    EList<String> _arrayDimensions = it.getArrayDimensions();
    int _size = _arrayDimensions.size();
    return this.toTypeReference(_type, _size);
  }
  
  protected JvmTypeReference toTypeReference(final JvmType type, final int arrayDimensions) {
    boolean _equals = Objects.equal(type, null);
    if (_equals) {
      return null;
    }
    JvmParameterizedTypeReference _createJvmParameterizedTypeReference = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
    final Procedure1<JvmParameterizedTypeReference> _function = new Procedure1<JvmParameterizedTypeReference>() {
      public void apply(final JvmParameterizedTypeReference it) {
        it.setType(type);
      }
    };
    JvmTypeReference resultTypeRef = ObjectExtensions.<JvmParameterizedTypeReference>operator_doubleArrow(_createJvmParameterizedTypeReference, _function);
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, arrayDimensions, true);
    for (final Integer i : _doubleDotLessThan) {
      {
        final JvmGenericArrayTypeReference arrayRef = TypesFactory.eINSTANCE.createJvmGenericArrayTypeReference();
        arrayRef.setComponentType(resultTypeRef);
        resultTypeRef = arrayRef;
      }
    }
    return resultTypeRef;
  }
  
  protected Object _internalEvaluate(final XBinaryOperation it, final Context ctx) {
    Object _xblockexpression = null;
    {
      XExpression _leftOperand = it.getLeftOperand();
      final Object left = this.internalEvaluate(_leftOperand, ctx);
      XExpression _rightOperand = it.getRightOperand();
      final Object right = this.internalEvaluate(_rightOperand, ctx);
      final String op = it.getConcreteSyntaxFeatureName();
      Object _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(op, "+")) {
          _matched=true;
          _switchResult = this.constantOperators.plus(left, right);
        }
      }
      if (!_matched) {
        if (Objects.equal(op, "-")) {
          _matched=true;
          _switchResult = this.constantOperators.minus(left, right);
        }
      }
      if (!_matched) {
        if (Objects.equal(op, "*")) {
          _matched=true;
          _switchResult = this.constantOperators.multiply(left, right);
        }
      }
      if (!_matched) {
        if (Objects.equal(op, "/")) {
          _matched=true;
          _switchResult = this.constantOperators.divide(left, right);
        }
      }
      if (!_matched) {
        if (Objects.equal(op, "%")) {
          _matched=true;
          _switchResult = this.constantOperators.modulo(left, right);
        }
      }
      if (!_matched) {
        if (Objects.equal(op, "<")) {
          _matched=true;
          _switchResult = Boolean.valueOf(this.constantOperators.lessThan(left, right));
        }
      }
      if (!_matched) {
        if (Objects.equal(op, ">")) {
          _matched=true;
          _switchResult = Boolean.valueOf(this.constantOperators.greaterThan(left, right));
        }
      }
      if (!_matched) {
        if (Objects.equal(op, "<=")) {
          _matched=true;
          _switchResult = Boolean.valueOf(this.constantOperators.lessEquals(left, right));
        }
      }
      if (!_matched) {
        if (Objects.equal(op, ">=")) {
          _matched=true;
          _switchResult = Boolean.valueOf(this.constantOperators.greaterEquals(left, right));
        }
      }
      if (!_matched) {
        if (Objects.equal(op, "===")) {
          _matched=true;
          _switchResult = Boolean.valueOf(this.constantOperators.same(left, right));
        }
      }
      if (!_matched) {
        if (Objects.equal(op, "!==")) {
          _matched=true;
          _switchResult = Boolean.valueOf(this.constantOperators.notSame(left, right));
        }
      }
      if (!_matched) {
        if (Objects.equal(op, "==")) {
          _matched=true;
          _switchResult = Boolean.valueOf(this.constantOperators.same(left, right));
        }
      }
      if (!_matched) {
        if (Objects.equal(op, "!=")) {
          _matched=true;
          _switchResult = Boolean.valueOf(this.constantOperators.notSame(left, right));
        }
      }
      if (!_matched) {
        throw new ConstantExpressionEvaluationException(((((("Couldn\'t evaluate binary operator \'" + op) + "\' on values ") + left) + " and ") + right));
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  protected Object _internalEvaluate(final XUnaryOperation it, final Context ctx) {
    Object _xblockexpression = null;
    {
      XExpression _operand = it.getOperand();
      final Object value = this.internalEvaluate(_operand, ctx);
      final String op = it.getConcreteSyntaxFeatureName();
      Object _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(op, "-")) {
          _matched=true;
          _switchResult = this.constantOperators.minus(value);
        }
      }
      if (!_matched) {
        boolean _and = false;
        boolean _equals = Objects.equal(op, "!");
        if (!_equals) {
          _and = false;
        } else {
          _and = (value instanceof Boolean);
        }
        if (_and) {
          _matched=true;
          _switchResult = Boolean.valueOf((!(((Boolean) value)).booleanValue()));
        }
      }
      if (!_matched) {
        boolean _and_1 = false;
        boolean _equals_1 = Objects.equal(op, "+");
        if (!_equals_1) {
          _and_1 = false;
        } else {
          _and_1 = (value instanceof Number);
        }
        if (_and_1) {
          _matched=true;
          _switchResult = value;
        }
      }
      if (!_matched) {
        throw new ConstantExpressionEvaluationException(((("Couldn\'t evaluate unary operator \'" + value) + "\' on value ") + value));
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  protected String toText(final XExpression expression) {
    ICompositeNode _node = NodeModelUtils.getNode(expression);
    return _node.getText();
  }
  
  public Object internalEvaluate(final XExpression it, final Context ctx) {
    if (it instanceof XBinaryOperation) {
      return _internalEvaluate((XBinaryOperation)it, ctx);
    } else if (it instanceof XUnaryOperation) {
      return _internalEvaluate((XUnaryOperation)it, ctx);
    } else if (it instanceof XBooleanLiteral) {
      return _internalEvaluate((XBooleanLiteral)it, ctx);
    } else if (it instanceof XCastedExpression) {
      return _internalEvaluate((XCastedExpression)it, ctx);
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
