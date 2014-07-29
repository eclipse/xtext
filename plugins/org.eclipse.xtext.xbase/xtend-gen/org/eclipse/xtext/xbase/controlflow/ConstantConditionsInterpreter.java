/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.controlflow;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.controlflow.BooleanResult;
import org.eclipse.xtext.xbase.controlflow.EvaluationResult;
import org.eclipse.xtext.xbase.interpreter.ConstantExpressionEvaluationException;
import org.eclipse.xtext.xbase.interpreter.ConstantOperators;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.scoping.XImportSectionNamespaceScopeProvider;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.NumberLiterals;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * Interpreter for expressions at development time that uses the static linking
 * information and hardcoded logic to apply binary operations on well known types.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Accessors(AccessorType.PROTECTED_GETTER)
@SuppressWarnings("all")
public class ConstantConditionsInterpreter {
  @Inject
  @Extension
  private ILogicalContainerProvider _iLogicalContainerProvider;
  
  @Inject
  @Extension
  private NumberLiterals numberLiterals;
  
  @Inject
  private IBatchTypeResolver typeResolver;
  
  @Inject
  private ConstantOperators constantOperators;
  
  public BooleanResult getBooleanConstantOrNull(final XExpression it) {
    try {
      final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(it);
      final EvaluationResult evaluationResult = this.internalEvaluate(it, resolvedTypes);
      Object _value = evaluationResult.getValue();
      if ((_value instanceof Boolean)) {
        Object _value_1 = evaluationResult.getValue();
        boolean _isCompileTimeConstant = evaluationResult.isCompileTimeConstant();
        return new BooleanResult(((Boolean) _value_1), _isCompileTimeConstant);
      }
      return null;
    } catch (final Throwable _t) {
      if (_t instanceof ConstantExpressionEvaluationException) {
        final ConstantExpressionEvaluationException e = (ConstantExpressionEvaluationException)_t;
        return null;
      } else if (_t instanceof IllegalArgumentException) {
        final IllegalArgumentException e_1 = (IllegalArgumentException)_t;
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  protected EvaluationResult _internalEvaluate(final XExpression expression, final IResolvedTypes resolvedTypes) {
    return EvaluationResult.NOT_A_CONSTANT;
  }
  
  protected EvaluationResult _internalEvaluate(final Void nullValue, final IResolvedTypes resolvedTypes) {
    throw new ConstantExpressionEvaluationException("null");
  }
  
  protected EvaluationResult _internalEvaluate(final XNumberLiteral it, final IResolvedTypes resolvedTypes) {
    Class<? extends Number> _javaType = this.numberLiterals.getJavaType(it);
    final Number value = this.numberLiterals.numberValue(it, _javaType);
    LightweightTypeReference _actualType = resolvedTypes.getActualType(it);
    boolean _isPrimitive = _actualType.isPrimitive();
    return new EvaluationResult(value, _isPrimitive);
  }
  
  protected EvaluationResult _internalEvaluate(final XAbstractFeatureCall it, final IResolvedTypes resolvedTypes) {
    JvmIdentifiableElement _feature = it.getFeature();
    final JvmIdentifiableElement feature = _feature;
    boolean _matched = false;
    if (!_matched) {
      if (feature instanceof JvmType) {
        _matched=true;
      }
      if (!_matched) {
        if (feature instanceof JvmEnumerationLiteral) {
          _matched=true;
        }
      }
      if (_matched) {
        return new EvaluationResult(feature, true);
      }
    }
    if (!_matched) {
      if (feature instanceof JvmField) {
        _matched=true;
        boolean _isSetConstant = ((JvmField)feature).isSetConstant();
        if (_isSetConstant) {
          boolean _isConstant = ((JvmField)feature).isConstant();
          if (_isConstant) {
            Object _constantValue = ((JvmField)feature).getConstantValue();
            return new EvaluationResult(_constantValue, true);
          }
        } else {
          boolean _isFinal = ((JvmField)feature).isFinal();
          if (_isFinal) {
            final XExpression associatedExpression = this._iLogicalContainerProvider.getAssociatedExpression(feature);
            boolean _notEquals = (!Objects.equal(associatedExpression, null));
            if (_notEquals) {
              final EvaluationResult result = this.evaluateAssociatedExpression(associatedExpression, resolvedTypes);
              Object _value = result.getValue();
              return new EvaluationResult(_value, false);
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
          return this.evaluateAssociatedExpression(_right_1, resolvedTypes);
        }
      }
    }
    if (!_matched) {
      if (feature instanceof JvmFormalParameter) {
        _matched=true;
        EObject _eContainer = ((JvmFormalParameter)feature).eContainer();
        final EObject container = _eContainer;
        boolean _matched_1 = false;
        if (!_matched_1) {
          if (container instanceof XSwitchExpression) {
            XExpression _switch = ((XSwitchExpression)container).getSwitch();
            boolean _notEquals = (!Objects.equal(_switch, null));
            if (_notEquals) {
              _matched_1=true;
              XExpression _switch_1 = ((XSwitchExpression)container).getSwitch();
              return this.internalEvaluate(_switch_1, resolvedTypes);
            }
          }
        }
        return new EvaluationResult(feature, false);
      }
    }
    return EvaluationResult.NOT_A_CONSTANT;
  }
  
  public EvaluationResult evaluateAssociatedExpression(final XExpression it, final IResolvedTypes resolvedTypes) {
    EvaluationResult _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (it instanceof XAbstractFeatureCall) {
        JvmIdentifiableElement _feature = ((XAbstractFeatureCall)it).getFeature();
        if ((_feature instanceof JvmEnumerationLiteral)) {
          _matched=true;
          final EvaluationResult arg = this.internalEvaluate(it, resolvedTypes);
          Object _value = arg.getValue();
          return new EvaluationResult(_value, false);
        }
      }
    }
    if (!_matched) {
      _switchResult = this.internalEvaluate(it, resolvedTypes);
    }
    return _switchResult;
  }
  
  protected EvaluationResult _internalEvaluate(final XNullLiteral it, final IResolvedTypes resolvedTypes) {
    return new EvaluationResult(null, true);
  }
  
  private boolean isFromXbaseLibrary(final XAbstractFeatureCall it) {
    boolean _xblockexpression = false;
    {
      final JvmIdentifiableElement feature = it.getFeature();
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(feature, null));
      if (!_notEquals) {
        _and = false;
      } else {
        boolean _eIsProxy = feature.eIsProxy();
        _and = _eIsProxy;
      }
      if (_and) {
        throw new IllegalArgumentException("proxy");
      }
      boolean _switchResult = false;
      boolean _matched = false;
      if (!_matched) {
        if (feature instanceof JvmMember) {
          _matched=true;
          JvmDeclaredType _declaringType = null;
          if (((JvmMember)feature)!=null) {
            _declaringType=((JvmMember)feature).getDeclaringType();
          }
          String _packageName = null;
          if (_declaringType!=null) {
            _packageName=_declaringType.getPackageName();
          }
          String _string = XImportSectionNamespaceScopeProvider.XBASE_LIB.toString();
          _switchResult = Objects.equal(_packageName, _string);
        }
      }
      if (!_matched) {
        _switchResult = false;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  protected EvaluationResult _internalEvaluate(final XUnaryOperation it, final IResolvedTypes resolvedTypes) {
    EvaluationResult _xifexpression = null;
    boolean _isFromXbaseLibrary = this.isFromXbaseLibrary(it);
    if (_isFromXbaseLibrary) {
      EvaluationResult _xblockexpression = null;
      {
        XExpression _operand = it.getOperand();
        final EvaluationResult arg = this.internalEvaluate(_operand, resolvedTypes);
        final String op = it.getConcreteSyntaxFeatureName();
        EvaluationResult _switchResult = null;
        boolean _matched = false;
        if (!_matched) {
          if (Objects.equal(op, "-")) {
            _matched=true;
            try {
              Object _value = arg.getValue();
              final Object result = this.constantOperators.minus(_value);
              boolean _isCompileTimeConstant = arg.isCompileTimeConstant();
              return new EvaluationResult(result, _isCompileTimeConstant);
            } catch (final Throwable _t) {
              if (_t instanceof ConstantExpressionEvaluationException) {
                final ConstantExpressionEvaluationException e = (ConstantExpressionEvaluationException)_t;
                return EvaluationResult.NOT_A_CONSTANT;
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
          }
        }
        if (!_matched) {
          boolean _and = false;
          boolean _equals = Objects.equal(op, "!");
          if (!_equals) {
            _and = false;
          } else {
            Object _value_1 = arg.getValue();
            _and = (_value_1 instanceof Boolean);
          }
          if (_and) {
            _matched=true;
            boolean _isCompileTimeConstant_1 = arg.isCompileTimeConstant();
            _switchResult = new EvaluationResult(Boolean.valueOf((!(((Boolean) arg.getValue())).booleanValue())), _isCompileTimeConstant_1);
          }
        }
        if (!_matched) {
          boolean _and_1 = false;
          boolean _equals_1 = Objects.equal(op, "+");
          if (!_equals_1) {
            _and_1 = false;
          } else {
            Object _value_2 = arg.getValue();
            _and_1 = (_value_2 instanceof Number);
          }
          if (_and_1) {
            _matched=true;
            _switchResult = arg;
          }
        }
        if (!_matched) {
          _switchResult = EvaluationResult.NOT_A_CONSTANT;
        }
        _xblockexpression = _switchResult;
      }
      _xifexpression = _xblockexpression;
    } else {
      return EvaluationResult.NOT_A_CONSTANT;
    }
    return _xifexpression;
  }
  
  protected EvaluationResult _internalEvaluate(final XBinaryOperation it, final IResolvedTypes resolvedTypes) {
    boolean _isFromXbaseLibrary = this.isFromXbaseLibrary(it);
    if (_isFromXbaseLibrary) {
      XExpression _leftOperand = it.getLeftOperand();
      final EvaluationResult left = this.internalEvaluate(_leftOperand, resolvedTypes);
      XExpression _rightOperand = it.getRightOperand();
      final EvaluationResult right = this.internalEvaluate(_rightOperand, resolvedTypes);
      try {
        final String op = it.getConcreteSyntaxFeatureName();
        Object _switchResult = null;
        boolean _matched = false;
        if (!_matched) {
          if (Objects.equal(op, "+")) {
            _matched=true;
            Object _value = left.getValue();
            Object _value_1 = right.getValue();
            _switchResult = this.constantOperators.plus(_value, _value_1);
          }
        }
        if (!_matched) {
          if (Objects.equal(op, "-")) {
            _matched=true;
            Object _value_2 = left.getValue();
            Object _value_3 = right.getValue();
            _switchResult = this.constantOperators.minus(_value_2, _value_3);
          }
        }
        if (!_matched) {
          if (Objects.equal(op, "*")) {
            _matched=true;
            Object _value_4 = left.getValue();
            Object _value_5 = right.getValue();
            _switchResult = this.constantOperators.multiply(_value_4, _value_5);
          }
        }
        if (!_matched) {
          if (Objects.equal(op, "/")) {
            _matched=true;
            Object _value_6 = left.getValue();
            Object _value_7 = right.getValue();
            _switchResult = this.constantOperators.divide(_value_6, _value_7);
          }
        }
        if (!_matched) {
          if (Objects.equal(op, "%")) {
            _matched=true;
            Object _value_8 = left.getValue();
            Object _value_9 = right.getValue();
            _switchResult = this.constantOperators.modulo(_value_8, _value_9);
          }
        }
        if (!_matched) {
          if (Objects.equal(op, "<<")) {
            _matched=true;
            Object _value_10 = left.getValue();
            Object _value_11 = right.getValue();
            _switchResult = this.constantOperators.shiftLeft(_value_10, _value_11);
          }
        }
        if (!_matched) {
          if (Objects.equal(op, ">>")) {
            _matched=true;
            Object _value_12 = left.getValue();
            Object _value_13 = right.getValue();
            _switchResult = this.constantOperators.shiftRight(_value_12, _value_13);
          }
        }
        if (!_matched) {
          if (Objects.equal(op, ">>>")) {
            _matched=true;
            Object _value_14 = left.getValue();
            Object _value_15 = right.getValue();
            _switchResult = this.constantOperators.shiftRightUnsigned(_value_14, _value_15);
          }
        }
        if (!_matched) {
          if (Objects.equal(op, "<")) {
            _matched=true;
            Object _value_16 = left.getValue();
            Object _value_17 = right.getValue();
            _switchResult = Boolean.valueOf(this.constantOperators.lessThan(_value_16, _value_17));
          }
        }
        if (!_matched) {
          if (Objects.equal(op, ">")) {
            _matched=true;
            Object _value_18 = left.getValue();
            Object _value_19 = right.getValue();
            _switchResult = Boolean.valueOf(this.constantOperators.greaterThan(_value_18, _value_19));
          }
        }
        if (!_matched) {
          if (Objects.equal(op, "<=")) {
            _matched=true;
            Object _value_20 = left.getValue();
            Object _value_21 = right.getValue();
            _switchResult = Boolean.valueOf(this.constantOperators.lessEquals(_value_20, _value_21));
          }
        }
        if (!_matched) {
          if (Objects.equal(op, ">=")) {
            _matched=true;
            Object _value_22 = left.getValue();
            Object _value_23 = right.getValue();
            _switchResult = Boolean.valueOf(this.constantOperators.greaterEquals(_value_22, _value_23));
          }
        }
        if (!_matched) {
          if (Objects.equal(op, "&&")) {
            _matched=true;
            Object _value_24 = left.getValue();
            Object _value_25 = right.getValue();
            boolean _and = false;
            boolean _isCompileTimeConstant = left.isCompileTimeConstant();
            if (!_isCompileTimeConstant) {
              _and = false;
            } else {
              boolean _isCompileTimeConstant_1 = right.isCompileTimeConstant();
              _and = _isCompileTimeConstant_1;
            }
            return this.internalLogicalAnd(_value_24, _value_25, _and);
          }
        }
        if (!_matched) {
          if (Objects.equal(op, "||")) {
            _matched=true;
            Object _value_26 = left.getValue();
            Object _value_27 = right.getValue();
            boolean _and_1 = false;
            boolean _isCompileTimeConstant_2 = left.isCompileTimeConstant();
            if (!_isCompileTimeConstant_2) {
              _and_1 = false;
            } else {
              boolean _isCompileTimeConstant_3 = right.isCompileTimeConstant();
              _and_1 = _isCompileTimeConstant_3;
            }
            return this.internalLogicalOr(_value_26, _value_27, _and_1);
          }
        }
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
            boolean _equalValue = left.equalValue(right);
            boolean _and_2 = false;
            boolean _isCompileTimeConstant_4 = left.isCompileTimeConstant();
            if (!_isCompileTimeConstant_4) {
              _and_2 = false;
            } else {
              boolean _isCompileTimeConstant_5 = right.isCompileTimeConstant();
              _and_2 = _isCompileTimeConstant_5;
            }
            return new EvaluationResult(Boolean.valueOf(_equalValue), _and_2);
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
            boolean _equalValue_1 = left.equalValue(right);
            boolean _not = (!_equalValue_1);
            boolean _and_3 = false;
            boolean _isCompileTimeConstant_6 = left.isCompileTimeConstant();
            if (!_isCompileTimeConstant_6) {
              _and_3 = false;
            } else {
              boolean _isCompileTimeConstant_7 = right.isCompileTimeConstant();
              _and_3 = _isCompileTimeConstant_7;
            }
            return new EvaluationResult(Boolean.valueOf(_not), _and_3);
          }
        }
        if (!_matched) {
          return EvaluationResult.NOT_A_CONSTANT;
        }
        final Object value = _switchResult;
        boolean _and_4 = false;
        boolean _isCompileTimeConstant_8 = left.isCompileTimeConstant();
        if (!_isCompileTimeConstant_8) {
          _and_4 = false;
        } else {
          boolean _isCompileTimeConstant_9 = right.isCompileTimeConstant();
          _and_4 = _isCompileTimeConstant_9;
        }
        return new EvaluationResult(value, _and_4);
      } catch (final Throwable _t) {
        if (_t instanceof ConstantExpressionEvaluationException) {
          final ConstantExpressionEvaluationException e = (ConstantExpressionEvaluationException)_t;
          return EvaluationResult.NOT_A_CONSTANT;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } else {
      return EvaluationResult.NOT_A_CONSTANT;
    }
  }
  
  protected EvaluationResult _internalLogicalAnd(final Object left, final Object right, final boolean compileTimeConstant) {
    return EvaluationResult.NOT_A_CONSTANT;
  }
  
  protected EvaluationResult _internalLogicalAnd(final Boolean left, final Boolean right, final boolean compileTimeConstant) {
    return new EvaluationResult(Boolean.valueOf(((left).booleanValue() && (right).booleanValue())), compileTimeConstant);
  }
  
  protected EvaluationResult _internalLogicalAnd(final Boolean left, final Object right, final boolean compileTimeConstant) {
    if ((!(left).booleanValue())) {
      return new EvaluationResult(Boolean.FALSE, compileTimeConstant);
    }
    return EvaluationResult.NOT_A_CONSTANT;
  }
  
  protected EvaluationResult _internalLogicalAnd(final Boolean left, final Void right, final boolean compileTimeConstant) {
    if ((!(left).booleanValue())) {
      return new EvaluationResult(Boolean.FALSE, compileTimeConstant);
    }
    return EvaluationResult.NOT_A_CONSTANT;
  }
  
  protected EvaluationResult _internalLogicalAnd(final Object left, final Boolean right, final boolean compileTimeConstant) {
    if ((!(right).booleanValue())) {
      return new EvaluationResult(Boolean.FALSE, compileTimeConstant);
    }
    return EvaluationResult.NOT_A_CONSTANT;
  }
  
  protected EvaluationResult _internalLogicalAnd(final Void left, final Boolean right, final boolean compileTimeConstant) {
    return EvaluationResult.NOT_A_CONSTANT;
  }
  
  protected EvaluationResult _internalLogicalOr(final Object left, final Object right, final boolean compileTimeConstant) {
    return EvaluationResult.NOT_A_CONSTANT;
  }
  
  protected EvaluationResult _internalLogicalOr(final Boolean left, final Boolean right, final boolean compileTimeConstant) {
    return new EvaluationResult(Boolean.valueOf(((left).booleanValue() || (right).booleanValue())), compileTimeConstant);
  }
  
  protected EvaluationResult _internalLogicalOr(final Boolean left, final Object right, final boolean compileTimeConstant) {
    if ((left).booleanValue()) {
      return new EvaluationResult(Boolean.TRUE, compileTimeConstant);
    }
    return EvaluationResult.NOT_A_CONSTANT;
  }
  
  protected EvaluationResult _internalLogicalOr(final Boolean left, final Void right, final boolean compileTimeConstant) {
    if ((left).booleanValue()) {
      return new EvaluationResult(Boolean.TRUE, compileTimeConstant);
    }
    return EvaluationResult.NOT_A_CONSTANT;
  }
  
  protected EvaluationResult _internalLogicalOr(final Object left, final Boolean right, final boolean compileTimeConstant) {
    if ((right).booleanValue()) {
      return new EvaluationResult(Boolean.TRUE, compileTimeConstant);
    }
    return EvaluationResult.NOT_A_CONSTANT;
  }
  
  protected EvaluationResult _internalLogicalOr(final Void left, final Boolean right, final boolean compileTimeConstant) {
    return EvaluationResult.NOT_A_CONSTANT;
  }
  
  protected EvaluationResult _internalEvaluate(final XCastedExpression expression, final IResolvedTypes resolvedTypes) {
    XExpression _target = expression.getTarget();
    return this.internalEvaluate(_target, resolvedTypes);
  }
  
  protected EvaluationResult _internalEvaluate(final XStringLiteral it, final IResolvedTypes resolvedTypes) {
    String _value = it.getValue();
    return new EvaluationResult(_value, true);
  }
  
  protected EvaluationResult _internalEvaluate(final XBooleanLiteral it, final IResolvedTypes resolvedTypes) {
    boolean _isIsTrue = it.isIsTrue();
    return new EvaluationResult(Boolean.valueOf(_isIsTrue), true);
  }
  
  protected EvaluationResult _internalEvaluate(final XTypeLiteral it, final IResolvedTypes resolvedTypes) {
    return new EvaluationResult(it, true);
  }
  
  public EvaluationResult internalEvaluate(final XExpression it, final IResolvedTypes resolvedTypes) {
    if (it instanceof XBinaryOperation) {
      return _internalEvaluate((XBinaryOperation)it, resolvedTypes);
    } else if (it instanceof XUnaryOperation) {
      return _internalEvaluate((XUnaryOperation)it, resolvedTypes);
    } else if (it instanceof XAbstractFeatureCall) {
      return _internalEvaluate((XAbstractFeatureCall)it, resolvedTypes);
    } else if (it instanceof XBooleanLiteral) {
      return _internalEvaluate((XBooleanLiteral)it, resolvedTypes);
    } else if (it instanceof XCastedExpression) {
      return _internalEvaluate((XCastedExpression)it, resolvedTypes);
    } else if (it instanceof XNullLiteral) {
      return _internalEvaluate((XNullLiteral)it, resolvedTypes);
    } else if (it instanceof XNumberLiteral) {
      return _internalEvaluate((XNumberLiteral)it, resolvedTypes);
    } else if (it instanceof XStringLiteral) {
      return _internalEvaluate((XStringLiteral)it, resolvedTypes);
    } else if (it instanceof XTypeLiteral) {
      return _internalEvaluate((XTypeLiteral)it, resolvedTypes);
    } else if (it != null) {
      return _internalEvaluate(it, resolvedTypes);
    } else if (it == null) {
      return _internalEvaluate((Void)null, resolvedTypes);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, resolvedTypes).toString());
    }
  }
  
  public EvaluationResult internalLogicalAnd(final Object left, final Object right, final boolean compileTimeConstant) {
    if (left instanceof Boolean
         && right instanceof Boolean) {
      return _internalLogicalAnd((Boolean)left, (Boolean)right, compileTimeConstant);
    } else if (left instanceof Boolean
         && right == null) {
      return _internalLogicalAnd((Boolean)left, (Void)null, compileTimeConstant);
    } else if (left instanceof Boolean
         && right != null) {
      return _internalLogicalAnd((Boolean)left, right, compileTimeConstant);
    } else if (left == null
         && right instanceof Boolean) {
      return _internalLogicalAnd((Void)null, (Boolean)right, compileTimeConstant);
    } else if (left != null
         && right instanceof Boolean) {
      return _internalLogicalAnd(left, (Boolean)right, compileTimeConstant);
    } else if (left != null
         && right != null) {
      return _internalLogicalAnd(left, right, compileTimeConstant);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(left, right, compileTimeConstant).toString());
    }
  }
  
  public EvaluationResult internalLogicalOr(final Object left, final Object right, final boolean compileTimeConstant) {
    if (left instanceof Boolean
         && right instanceof Boolean) {
      return _internalLogicalOr((Boolean)left, (Boolean)right, compileTimeConstant);
    } else if (left instanceof Boolean
         && right == null) {
      return _internalLogicalOr((Boolean)left, (Void)null, compileTimeConstant);
    } else if (left instanceof Boolean
         && right != null) {
      return _internalLogicalOr((Boolean)left, right, compileTimeConstant);
    } else if (left == null
         && right instanceof Boolean) {
      return _internalLogicalOr((Void)null, (Boolean)right, compileTimeConstant);
    } else if (left != null
         && right instanceof Boolean) {
      return _internalLogicalOr(left, (Boolean)right, compileTimeConstant);
    } else if (left != null
         && right != null) {
      return _internalLogicalOr(left, right, compileTimeConstant);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(left, right, compileTimeConstant).toString());
    }
  }
  
  @Pure
  protected ILogicalContainerProvider get_iLogicalContainerProvider() {
    return this._iLogicalContainerProvider;
  }
  
  @Pure
  protected NumberLiterals getNumberLiterals() {
    return this.numberLiterals;
  }
  
  @Pure
  protected IBatchTypeResolver getTypeResolver() {
    return this.typeResolver;
  }
  
  @Pure
  protected ConstantOperators getConstantOperators() {
    return this.constantOperators;
  }
}
