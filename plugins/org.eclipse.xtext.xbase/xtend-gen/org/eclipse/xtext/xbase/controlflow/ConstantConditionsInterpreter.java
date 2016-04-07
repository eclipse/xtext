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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
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
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.controlflow.BooleanResult;
import org.eclipse.xtext.xbase.controlflow.EvaluationContext;
import org.eclipse.xtext.xbase.controlflow.EvaluationResult;
import org.eclipse.xtext.xbase.controlflow.IConstantEvaluationResult;
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
  private ILogicalContainerProvider logicalContainerProvider;
  
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
      final EvaluationResult evaluationResult = this.doEvaluate(it, _newEvaluationContext);
      Object _rawValue = evaluationResult.getRawValue();
      if ((_rawValue instanceof Boolean)) {
        Object _rawValue_1 = evaluationResult.getRawValue();
        boolean _isCompileTimeConstant = evaluationResult.isCompileTimeConstant();
        return new BooleanResult(((Boolean) _rawValue_1), _isCompileTimeConstant);
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
  
  public EvaluationContext newEvaluationContext() {
    return this.evaluationContextProvider.get();
  }
  
  protected EvaluationResult doEvaluate(final XExpression expression, final EvaluationContext context) {
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
  
  public IConstantEvaluationResult<Object> evaluate(final XExpression expression, final EvaluationContext context) {
    return this.doEvaluate(expression, context);
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
    final JvmIdentifiableElement feature = this.getFeature(it, context);
    boolean _or = false;
    boolean _equals = Objects.equal(feature, null);
    if (_equals) {
      _or = true;
    } else {
      boolean _eIsProxy = feature.eIsProxy();
      _or = _eIsProxy;
    }
    if (_or) {
      return EvaluationResult.NOT_A_CONSTANT;
    }
    boolean _matched = false;
    if (feature instanceof JvmType) {
      boolean _isTypeLiteral = it.isTypeLiteral();
      boolean _not = (!_isTypeLiteral);
      if (_not) {
        _matched=true;
        ThisReference _thisReference = new ThisReference(((JvmType)feature));
        return new EvaluationResult(_thisReference, false);
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
        return new EvaluationResult(feature, false);
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
              final EvaluationResult receiver = this.doEvaluate(_actualReceiver_1, context);
              boolean _isNotAConstant = receiver.isNotAConstant();
              if (_isNotAConstant) {
                return receiver;
              }
              final XExpression associatedExpression = this.getAssociatedExpression(((JvmField)feature));
              boolean _notEquals_1 = (!Objects.equal(associatedExpression, null));
              if (_notEquals_1) {
                final EvaluationResult result = this.evaluateAssociatedExpression(associatedExpression, context);
                Object _rawValue = result.getRawValue();
                if ((_rawValue instanceof ThisReference)) {
                  return EvaluationResult.NOT_A_CONSTANT;
                }
                Object _rawValue_1 = result.getRawValue();
                return new EvaluationResult(_rawValue_1, false);
              } else {
                ArrayList<Object> _switchResult_1 = null;
                Object _rawValue_2 = receiver.getRawValue();
                final Object v = _rawValue_2;
                boolean _matched_1 = false;
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
              final XExpression associatedExpression_1 = this.getAssociatedExpression(((JvmField)feature));
              boolean _notEquals_2 = (!Objects.equal(associatedExpression_1, null));
              if (_notEquals_2) {
                final EvaluationResult result_1 = this.evaluateAssociatedExpression(associatedExpression_1, context);
                Object _rawValue_3 = result_1.getRawValue();
                return new EvaluationResult(_rawValue_3, false);
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
        if (container instanceof XSwitchExpression) {
          XExpression _switch = ((XSwitchExpression)container).getSwitch();
          boolean _notEquals = (!Objects.equal(_switch, null));
          if (_notEquals) {
            _matched_1=true;
            XExpression _switch_1 = ((XSwitchExpression)container).getSwitch();
            return this.doEvaluate(_switch_1, context);
          }
        }
        return new EvaluationResult(feature, false);
      }
    }
    return EvaluationResult.NOT_A_CONSTANT;
  }
  
  public JvmIdentifiableElement getFeature(final XAbstractFeatureCall call, final EvaluationContext context) {
    Object _eGet = call.eGet(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, false);
    JvmIdentifiableElement feature = ((JvmIdentifiableElement) _eGet);
    boolean _or = false;
    boolean _equals = Objects.equal(feature, null);
    if (_equals) {
      _or = true;
    } else {
      boolean _eIsProxy = feature.eIsProxy();
      _or = _eIsProxy;
    }
    if (_or) {
      IResolvedTypes _resolvedTypes = context.getResolvedTypes();
      JvmIdentifiableElement _linkedFeature = _resolvedTypes.getLinkedFeature(call);
      feature = _linkedFeature;
    }
    return feature;
  }
  
  public XExpression getAssociatedExpression(final JvmField field) {
    final Resource resource = field.eResource();
    if ((resource instanceof StorageAwareResource)) {
      boolean _isLoadedFromStorage = ((StorageAwareResource)resource).isLoadedFromStorage();
      if (_isLoadedFromStorage) {
        return null;
      }
    }
    return this.logicalContainerProvider.getAssociatedExpression(field);
  }
  
  public EvaluationResult evaluateAssociatedExpression(final XExpression it, final EvaluationContext context) {
    EvaluationResult _switchResult = null;
    boolean _matched = false;
    if (it instanceof XAbstractFeatureCall) {
      JvmIdentifiableElement _feature = ((XAbstractFeatureCall)it).getFeature();
      if ((_feature instanceof JvmEnumerationLiteral)) {
        _matched=true;
        final EvaluationResult arg = this.doEvaluate(it, context);
        Object _rawValue = arg.getRawValue();
        return new EvaluationResult(_rawValue, false);
      }
    }
    if (!_matched) {
      _switchResult = this.doEvaluate(it, context);
    }
    return _switchResult;
  }
  
  protected EvaluationResult _internalEvaluate(final XNullLiteral it, final EvaluationContext context) {
    return new EvaluationResult(null, true);
  }
  
  private boolean isFromXbaseLibrary(final XAbstractFeatureCall it, final EvaluationContext context) {
    boolean _xblockexpression = false;
    {
      final JvmIdentifiableElement feature = this.getFeature(it, context);
      boolean _switchResult = false;
      boolean _matched = false;
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
      if (!_matched) {
        _switchResult = false;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  protected EvaluationResult _internalEvaluate(final XUnaryOperation it, final EvaluationContext context) {
    EvaluationResult _xifexpression = null;
    boolean _isFromXbaseLibrary = this.isFromXbaseLibrary(it, context);
    if (_isFromXbaseLibrary) {
      EvaluationResult _xblockexpression = null;
      {
        XExpression _operand = it.getOperand();
        final EvaluationResult arg = this.doEvaluate(_operand, context);
        final String op = it.getConcreteSyntaxFeatureName();
        EvaluationResult _switchResult = null;
        boolean _matched = false;
        if (Objects.equal(op, "-")) {
          _matched=true;
          try {
            Object _rawValue = arg.getRawValue();
            final Object result = this.constantOperators.minus(_rawValue);
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
        if (!_matched) {
          boolean _and = false;
          boolean _equals = Objects.equal(op, "!");
          if (!_equals) {
            _and = false;
          } else {
            Object _rawValue_1 = arg.getRawValue();
            _and = (_rawValue_1 instanceof Boolean);
          }
          if (_and) {
            _matched=true;
            Object _rawValue_2 = arg.getRawValue();
            boolean _not = (!(((Boolean) _rawValue_2)).booleanValue());
            boolean _isCompileTimeConstant_1 = arg.isCompileTimeConstant();
            _switchResult = new EvaluationResult(Boolean.valueOf(_not), _isCompileTimeConstant_1);
          }
        }
        if (!_matched) {
          boolean _and_1 = false;
          boolean _equals_1 = Objects.equal(op, "+");
          if (!_equals_1) {
            _and_1 = false;
          } else {
            Object _rawValue_3 = arg.getRawValue();
            _and_1 = (_rawValue_3 instanceof Number);
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
    boolean _and = false;
    boolean _isFromXbaseLibrary = this.isFromXbaseLibrary(it, context);
    if (!_isFromXbaseLibrary) {
      _and = false;
    } else {
      XExpression _rightOperand = it.getRightOperand();
      boolean _notEquals = (!Objects.equal(_rightOperand, null));
      _and = _notEquals;
    }
    if (_and) {
      XExpression _leftOperand = it.getLeftOperand();
      final EvaluationResult left = this.doEvaluate(_leftOperand, context);
      XExpression _rightOperand_1 = it.getRightOperand();
      final EvaluationResult right = this.doEvaluate(_rightOperand_1, context);
      try {
        final String op = it.getConcreteSyntaxFeatureName();
        Object _switchResult = null;
        boolean _matched = false;
        if (Objects.equal(op, "+")) {
          _matched=true;
          Object _rawValue = left.getRawValue();
          Object _rawValue_1 = right.getRawValue();
          _switchResult = this.constantOperators.plus(_rawValue, _rawValue_1);
        }
        if (!_matched) {
          if (Objects.equal(op, "-")) {
            _matched=true;
            Object _rawValue_2 = left.getRawValue();
            Object _rawValue_3 = right.getRawValue();
            _switchResult = this.constantOperators.minus(_rawValue_2, _rawValue_3);
          }
        }
        if (!_matched) {
          if (Objects.equal(op, "*")) {
            _matched=true;
            Object _rawValue_4 = left.getRawValue();
            Object _rawValue_5 = right.getRawValue();
            _switchResult = this.constantOperators.multiply(_rawValue_4, _rawValue_5);
          }
        }
        if (!_matched) {
          if (Objects.equal(op, "/")) {
            _matched=true;
            Object _rawValue_6 = left.getRawValue();
            Object _rawValue_7 = right.getRawValue();
            _switchResult = this.constantOperators.divide(_rawValue_6, _rawValue_7);
          }
        }
        if (!_matched) {
          if (Objects.equal(op, "%")) {
            _matched=true;
            Object _rawValue_8 = left.getRawValue();
            Object _rawValue_9 = right.getRawValue();
            _switchResult = this.constantOperators.modulo(_rawValue_8, _rawValue_9);
          }
        }
        if (!_matched) {
          if (Objects.equal(op, "<<")) {
            _matched=true;
            Object _rawValue_10 = left.getRawValue();
            Object _rawValue_11 = right.getRawValue();
            _switchResult = this.constantOperators.shiftLeft(_rawValue_10, _rawValue_11);
          }
        }
        if (!_matched) {
          if (Objects.equal(op, ">>")) {
            _matched=true;
            Object _rawValue_12 = left.getRawValue();
            Object _rawValue_13 = right.getRawValue();
            _switchResult = this.constantOperators.shiftRight(_rawValue_12, _rawValue_13);
          }
        }
        if (!_matched) {
          if (Objects.equal(op, ">>>")) {
            _matched=true;
            Object _rawValue_14 = left.getRawValue();
            Object _rawValue_15 = right.getRawValue();
            _switchResult = this.constantOperators.shiftRightUnsigned(_rawValue_14, _rawValue_15);
          }
        }
        if (!_matched) {
          if (Objects.equal(op, "<")) {
            _matched=true;
            Object _rawValue_16 = left.getRawValue();
            Object _rawValue_17 = right.getRawValue();
            _switchResult = Boolean.valueOf(this.constantOperators.lessThan(_rawValue_16, _rawValue_17));
          }
        }
        if (!_matched) {
          if (Objects.equal(op, ">")) {
            _matched=true;
            Object _rawValue_18 = left.getRawValue();
            Object _rawValue_19 = right.getRawValue();
            _switchResult = Boolean.valueOf(this.constantOperators.greaterThan(_rawValue_18, _rawValue_19));
          }
        }
        if (!_matched) {
          if (Objects.equal(op, "<=")) {
            _matched=true;
            Object _rawValue_20 = left.getRawValue();
            Object _rawValue_21 = right.getRawValue();
            _switchResult = Boolean.valueOf(this.constantOperators.lessEquals(_rawValue_20, _rawValue_21));
          }
        }
        if (!_matched) {
          if (Objects.equal(op, ">=")) {
            _matched=true;
            Object _rawValue_22 = left.getRawValue();
            Object _rawValue_23 = right.getRawValue();
            _switchResult = Boolean.valueOf(this.constantOperators.greaterEquals(_rawValue_22, _rawValue_23));
          }
        }
        if (!_matched) {
          if (Objects.equal(op, "&&")) {
            _matched=true;
            Object _rawValue_24 = left.getRawValue();
            Object _rawValue_25 = right.getRawValue();
            boolean _and_1 = false;
            boolean _isCompileTimeConstant = left.isCompileTimeConstant();
            if (!_isCompileTimeConstant) {
              _and_1 = false;
            } else {
              boolean _isCompileTimeConstant_1 = right.isCompileTimeConstant();
              _and_1 = _isCompileTimeConstant_1;
            }
            return this.internalLogicalAnd(_rawValue_24, _rawValue_25, _and_1);
          }
        }
        if (!_matched) {
          if (Objects.equal(op, "||")) {
            _matched=true;
            Object _rawValue_26 = left.getRawValue();
            Object _rawValue_27 = right.getRawValue();
            boolean _and_2 = false;
            boolean _isCompileTimeConstant_2 = left.isCompileTimeConstant();
            if (!_isCompileTimeConstant_2) {
              _and_2 = false;
            } else {
              boolean _isCompileTimeConstant_3 = right.isCompileTimeConstant();
              _and_2 = _isCompileTimeConstant_3;
            }
            return this.internalLogicalOr(_rawValue_26, _rawValue_27, _and_2);
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
            boolean _and_3 = false;
            boolean _isCompileTimeConstant_4 = left.isCompileTimeConstant();
            if (!_isCompileTimeConstant_4) {
              _and_3 = false;
            } else {
              boolean _isCompileTimeConstant_5 = right.isCompileTimeConstant();
              _and_3 = _isCompileTimeConstant_5;
            }
            return new EvaluationResult(_equalValue, _and_3);
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
            if (result instanceof Boolean) {
              _matched_1=true;
              boolean _and_4 = false;
              boolean _isCompileTimeConstant_6 = left.isCompileTimeConstant();
              if (!_isCompileTimeConstant_6) {
                _and_4 = false;
              } else {
                boolean _isCompileTimeConstant_7 = right.isCompileTimeConstant();
                _and_4 = _isCompileTimeConstant_7;
              }
              return new EvaluationResult(Boolean.valueOf((!((Boolean) result).booleanValue())), _and_4);
            }
            boolean _and_4 = false;
            boolean _isCompileTimeConstant_6 = left.isCompileTimeConstant();
            if (!_isCompileTimeConstant_6) {
              _and_4 = false;
            } else {
              boolean _isCompileTimeConstant_7 = right.isCompileTimeConstant();
              _and_4 = _isCompileTimeConstant_7;
            }
            return new EvaluationResult(result, _and_4);
          }
        }
        if (!_matched) {
          return EvaluationResult.NOT_A_CONSTANT;
        }
        final Object value = _switchResult;
        boolean _and_5 = false;
        boolean _isCompileTimeConstant_8 = left.isCompileTimeConstant();
        if (!_isCompileTimeConstant_8) {
          _and_5 = false;
        } else {
          boolean _isCompileTimeConstant_9 = right.isCompileTimeConstant();
          _and_5 = _isCompileTimeConstant_9;
        }
        return new EvaluationResult(value, _and_5);
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
    return this.doEvaluate(_target, context);
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
    return new EvaluationResult(it, false);
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
  protected ILogicalContainerProvider getLogicalContainerProvider() {
    return this.logicalContainerProvider;
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
