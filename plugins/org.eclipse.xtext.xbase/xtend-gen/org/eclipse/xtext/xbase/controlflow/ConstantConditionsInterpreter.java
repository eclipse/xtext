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
import com.google.inject.Provider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
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
import org.eclipse.xtext.xbase.controlflow.EvaluationContext;
import org.eclipse.xtext.xbase.controlflow.EvaluationResult;
import org.eclipse.xtext.xbase.controlflow.ThisReference;
import org.eclipse.xtext.xbase.interpreter.ConstantExpressionEvaluationException;
import org.eclipse.xtext.xbase.interpreter.ConstantOperators;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.scoping.XImportSectionNamespaceScopeProvider;
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
  private ConstantOperators constantOperators;
  
  @Accessors(AccessorType.NONE)
  @Inject
  private Provider<EvaluationContext> evaluationContextProvider;
  
  public BooleanResult getBooleanConstantOrNull(final XExpression it) {
    try {
      EvaluationContext _newEvaluationContext = this.newEvaluationContext();
      final EvaluationResult evaluationResult = this.evaluate(it, _newEvaluationContext);
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
  
  protected EvaluationContext newEvaluationContext() {
    return this.evaluationContextProvider.get();
  }
  
  public EvaluationResult evaluate(final XExpression expression, final EvaluationContext context) {
    boolean _tryNext = context.tryNext(expression);
    if (_tryNext) {
      try {
        return this.internalEvaluate(expression, context);
      } finally {
        context.done(expression);
      }
    } else {
      return EvaluationResult.NOT_A_CONSTANT;
    }
  }
  
  protected EvaluationResult _internalEvaluate(final XExpression expression, final EvaluationContext context) {
    return EvaluationResult.NOT_A_CONSTANT;
  }
  
  protected EvaluationResult _internalEvaluate(final Void nullValue, final EvaluationContext context) {
    throw new ConstantExpressionEvaluationException("null");
  }
  
  protected EvaluationResult _internalEvaluate(final XNumberLiteral it, final EvaluationContext context) {
    Class<? extends Number> _javaType = this.numberLiterals.getJavaType(it);
    final Number value = this.numberLiterals.numberValue(it, _javaType);
    IResolvedTypes _resolvedTypes = context.getResolvedTypes();
    LightweightTypeReference _actualType = _resolvedTypes.getActualType(it);
    boolean _isPrimitive = _actualType.isPrimitive();
    return new EvaluationResult(value, _isPrimitive);
  }
  
  protected EvaluationResult _internalEvaluate(final XAbstractFeatureCall it, final EvaluationContext context) {
    final JvmIdentifiableElement feature = it.getFeature();
    boolean _eIsProxy = feature.eIsProxy();
    if (_eIsProxy) {
      return EvaluationResult.NOT_A_CONSTANT;
    }
    boolean _matched = false;
    if (!_matched) {
      if (feature instanceof JvmType) {
        boolean _isTypeLiteral = it.isTypeLiteral();
        boolean _not = (!_isTypeLiteral);
        if (_not) {
          _matched=true;
          ThisReference _thisReference = new ThisReference(((JvmType)feature));
          return new EvaluationResult(_thisReference, false);
        }
      }
    }
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
            XExpression _actualReceiver = it.getActualReceiver();
            boolean _notEquals = (!Objects.equal(_actualReceiver, null));
            if (_notEquals) {
              XExpression _actualReceiver_1 = it.getActualReceiver();
              final EvaluationResult receiver = this.evaluate(_actualReceiver_1, context);
              boolean _isNotAConstant = receiver.isNotAConstant();
              if (_isNotAConstant) {
                return receiver;
              }
              final XExpression associatedExpression = this._iLogicalContainerProvider.getAssociatedExpression(feature);
              boolean _notEquals_1 = (!Objects.equal(associatedExpression, null));
              if (_notEquals_1) {
                final EvaluationResult result = this.evaluateAssociatedExpression(associatedExpression, context);
                Object _value = result.getValue();
                if ((_value instanceof ThisReference)) {
                  return EvaluationResult.NOT_A_CONSTANT;
                }
                Object _value_1 = result.getValue();
                return new EvaluationResult(_value_1, false);
              } else {
                ArrayList<Object> _switchResult_1 = null;
                Object _value_2 = receiver.getValue();
                final Object v = _value_2;
                boolean _matched_1 = false;
                if (!_matched_1) {
                  if (v instanceof JvmIdentifiableElement) {
                    _matched_1=true;
                  }
                  if (!_matched_1) {
                    if (v instanceof ThisReference) {
                      _matched_1=true;
                    }
                  }
                  if (_matched_1) {
                    _switchResult_1 = CollectionLiterals.<Object>newArrayList(v);
                  }
                }
                if (!_matched_1) {
                  if (v instanceof List) {
                    _matched_1=true;
                    _switchResult_1 = new ArrayList<Object>(((Collection<?>)v));
                  }
                }
                final ArrayList<Object> list = _switchResult_1;
                list.add(feature);
                return new EvaluationResult(list, false);
              }
            } else {
              final XExpression associatedExpression_1 = this._iLogicalContainerProvider.getAssociatedExpression(feature);
              boolean _notEquals_2 = (!Objects.equal(associatedExpression_1, null));
              if (_notEquals_2) {
                final EvaluationResult result_1 = this.evaluateAssociatedExpression(associatedExpression_1, context);
                Object _value_3 = result_1.getValue();
                return new EvaluationResult(_value_3, false);
              } else {
                ArrayList<JvmField> _newArrayList = CollectionLiterals.<JvmField>newArrayList(((JvmField)feature));
                return new EvaluationResult(_newArrayList, false);
              }
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
          return this.evaluateAssociatedExpression(_right_1, context);
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
              return this.evaluate(_switch_1, context);
            }
          }
        }
        return new EvaluationResult(feature, false);
      }
    }
    return EvaluationResult.NOT_A_CONSTANT;
  }
  
  public EvaluationResult evaluateAssociatedExpression(final XExpression it, final EvaluationContext context) {
    EvaluationResult _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (it instanceof XAbstractFeatureCall) {
        JvmIdentifiableElement _feature = ((XAbstractFeatureCall)it).getFeature();
        if ((_feature instanceof JvmEnumerationLiteral)) {
          _matched=true;
          final EvaluationResult arg = this.evaluate(it, context);
          Object _value = arg.getValue();
          return new EvaluationResult(_value, false);
        }
      }
    }
    if (!_matched) {
      _switchResult = this.evaluate(it, context);
    }
    return _switchResult;
  }
  
  protected EvaluationResult _internalEvaluate(final XNullLiteral it, final EvaluationContext context) {
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
  
  protected EvaluationResult _internalEvaluate(final XUnaryOperation it, final EvaluationContext context) {
    EvaluationResult _xifexpression = null;
    boolean _isFromXbaseLibrary = this.isFromXbaseLibrary(it);
    if (_isFromXbaseLibrary) {
      EvaluationResult _xblockexpression = null;
      {
        XExpression _operand = it.getOperand();
        final EvaluationResult arg = this.evaluate(_operand, context);
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
  
  protected EvaluationResult _internalEvaluate(final XBinaryOperation it, final EvaluationContext context) {
    boolean _isFromXbaseLibrary = this.isFromXbaseLibrary(it);
    if (_isFromXbaseLibrary) {
      XExpression _leftOperand = it.getLeftOperand();
      final EvaluationResult left = this.evaluate(_leftOperand, context);
      XExpression _rightOperand = it.getRightOperand();
      final EvaluationResult right = this.evaluate(_rightOperand, context);
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
            boolean _or = false;
            boolean _isNotAConstant = left.isNotAConstant();
            if (_isNotAConstant) {
              _or = true;
            } else {
              boolean _isNotAConstant_1 = right.isNotAConstant();
              _or = _isNotAConstant_1;
            }
            if (_or) {
              return EvaluationResult.NOT_A_CONSTANT;
            }
            Object _equalValue = left.equalValue(right);
            boolean _and_2 = false;
            boolean _isCompileTimeConstant_4 = left.isCompileTimeConstant();
            if (!_isCompileTimeConstant_4) {
              _and_2 = false;
            } else {
              boolean _isCompileTimeConstant_5 = right.isCompileTimeConstant();
              _and_2 = _isCompileTimeConstant_5;
            }
            return new EvaluationResult(_equalValue, _and_2);
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
            boolean _or_1 = false;
            boolean _isNotAConstant_2 = left.isNotAConstant();
            if (_isNotAConstant_2) {
              _or_1 = true;
            } else {
              boolean _isNotAConstant_3 = right.isNotAConstant();
              _or_1 = _isNotAConstant_3;
            }
            if (_or_1) {
              return EvaluationResult.NOT_A_CONSTANT;
            }
            final Object result = left.equalValue(right);
            boolean _matched_1 = false;
            if (!_matched_1) {
              if (result instanceof Boolean) {
                _matched_1=true;
                boolean _and_3 = false;
                boolean _isCompileTimeConstant_6 = left.isCompileTimeConstant();
                if (!_isCompileTimeConstant_6) {
                  _and_3 = false;
                } else {
                  boolean _isCompileTimeConstant_7 = right.isCompileTimeConstant();
                  _and_3 = _isCompileTimeConstant_7;
                }
                return new EvaluationResult(Boolean.valueOf((!((Boolean) result).booleanValue())), _and_3);
              }
            }
            boolean _and_3 = false;
            boolean _isCompileTimeConstant_6 = left.isCompileTimeConstant();
            if (!_isCompileTimeConstant_6) {
              _and_3 = false;
            } else {
              boolean _isCompileTimeConstant_7 = right.isCompileTimeConstant();
              _and_3 = _isCompileTimeConstant_7;
            }
            return new EvaluationResult(result, _and_3);
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
  
  protected EvaluationResult _internalEvaluate(final XCastedExpression expression, final EvaluationContext context) {
    XExpression _target = expression.getTarget();
    return this.evaluate(_target, context);
  }
  
  protected EvaluationResult _internalEvaluate(final XStringLiteral it, final EvaluationContext context) {
    String _value = it.getValue();
    return new EvaluationResult(_value, true);
  }
  
  protected EvaluationResult _internalEvaluate(final XBooleanLiteral it, final EvaluationContext context) {
    boolean _isIsTrue = it.isIsTrue();
    return new EvaluationResult(Boolean.valueOf(_isIsTrue), true);
  }
  
  protected EvaluationResult _internalEvaluate(final XTypeLiteral it, final EvaluationContext context) {
    return new EvaluationResult(it, true);
  }
  
  public EvaluationResult internalEvaluate(final XExpression it, final EvaluationContext context) {
    if (it instanceof XBinaryOperation) {
      return _internalEvaluate((XBinaryOperation)it, context);
    } else if (it instanceof XUnaryOperation) {
      return _internalEvaluate((XUnaryOperation)it, context);
    } else if (it instanceof XAbstractFeatureCall) {
      return _internalEvaluate((XAbstractFeatureCall)it, context);
    } else if (it instanceof XBooleanLiteral) {
      return _internalEvaluate((XBooleanLiteral)it, context);
    } else if (it instanceof XCastedExpression) {
      return _internalEvaluate((XCastedExpression)it, context);
    } else if (it instanceof XNullLiteral) {
      return _internalEvaluate((XNullLiteral)it, context);
    } else if (it instanceof XNumberLiteral) {
      return _internalEvaluate((XNumberLiteral)it, context);
    } else if (it instanceof XStringLiteral) {
      return _internalEvaluate((XStringLiteral)it, context);
    } else if (it instanceof XTypeLiteral) {
      return _internalEvaluate((XTypeLiteral)it, context);
    } else if (it != null) {
      return _internalEvaluate(it, context);
    } else if (it == null) {
      return _internalEvaluate((Void)null, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, context).toString());
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
  protected ConstantOperators getConstantOperators() {
    return this.constantOperators;
  }
}
