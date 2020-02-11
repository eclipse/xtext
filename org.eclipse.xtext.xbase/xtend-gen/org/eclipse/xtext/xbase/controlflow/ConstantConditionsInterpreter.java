/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.xtend2.lib.StringConcatenation;
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
import org.eclipse.xtext.xbase.typesystem.computation.NumberLiterals;

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
      final EvaluationResult evaluationResult = this.doEvaluate(it, this.newEvaluationContext());
      Object _rawValue = evaluationResult.getRawValue();
      if ((_rawValue instanceof Boolean)) {
        Object _rawValue_1 = evaluationResult.getRawValue();
        boolean _isCompileTimeConstant = evaluationResult.isCompileTimeConstant();
        return new BooleanResult(((Boolean) _rawValue_1), _isCompileTimeConstant);
      }
      return null;
    } catch (final Throwable _t) {
      if (_t instanceof ConstantExpressionEvaluationException) {
        return null;
      } else if (_t instanceof IllegalArgumentException) {
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
    final Number value = this.numberLiterals.numberValue(it, this.numberLiterals.getJavaType(it));
    boolean _isPrimitive = context.getResolvedTypes().getActualType(it).isPrimitive();
    return new EvaluationResult(value, _isPrimitive);
  }
  
  protected EvaluationResult _internalEvaluate(final XAbstractFeatureCall it, final EvaluationContext context) {
    final JvmIdentifiableElement feature = this.getFeature(it, context);
    if (((feature == null) || feature.eIsProxy())) {
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
            boolean _tripleNotEquals = (_actualReceiver != null);
            if (_tripleNotEquals) {
              final EvaluationResult receiver = this.doEvaluate(it.getActualReceiver(), context);
              boolean _isNotAConstant = receiver.isNotAConstant();
              if (_isNotAConstant) {
                return receiver;
              }
              final XExpression associatedExpression = this.getAssociatedExpression(((JvmField)feature));
              if ((associatedExpression != null)) {
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
                if (!_matched_1) {
                  StringConcatenation _builder = new StringConcatenation();
                  _builder.append("Invalid rawValue: ");
                  Object _rawValue_3 = receiver.getRawValue();
                  _builder.append(_rawValue_3);
                  throw new IllegalStateException(_builder.toString());
                }
                final ArrayList<Object> list = _switchResult_1;
                list.add(feature);
                return new EvaluationResult(list, false);
              }
            } else {
              final XExpression associatedExpression_1 = this.getAssociatedExpression(((JvmField)feature));
              if ((associatedExpression_1 != null)) {
                final EvaluationResult result_1 = this.evaluateAssociatedExpression(associatedExpression_1, context);
                Object _rawValue_4 = result_1.getRawValue();
                return new EvaluationResult(_rawValue_4, false);
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
        if (((!((XVariableDeclaration)feature).isWriteable()) && (((XVariableDeclaration)feature).getRight() != null))) {
          _matched=true;
          return this.evaluateAssociatedExpression(((XVariableDeclaration)feature).getRight(), context);
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
          boolean _tripleNotEquals = (_switch != null);
          if (_tripleNotEquals) {
            _matched_1=true;
            return this.doEvaluate(((XSwitchExpression)container).getSwitch(), context);
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
    if (((feature == null) || feature.eIsProxy())) {
      feature = context.getResolvedTypes().getLinkedFeature(call);
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
        final EvaluationResult arg = this.doEvaluate(it.getOperand(), context);
        final String op = it.getConcreteSyntaxFeatureName();
        EvaluationResult _switchResult = null;
        boolean _matched = false;
        if (Objects.equal(op, "-")) {
          _matched=true;
          try {
            final Object result = this.constantOperators.minus(arg.getRawValue());
            boolean _isCompileTimeConstant = arg.isCompileTimeConstant();
            return new EvaluationResult(result, _isCompileTimeConstant);
          } catch (final Throwable _t) {
            if (_t instanceof ConstantExpressionEvaluationException) {
              return EvaluationResult.NOT_A_CONSTANT;
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        }
        if (!_matched) {
          if ((Objects.equal(op, "!") && (arg.getRawValue() instanceof Boolean))) {
            _matched=true;
            Object _rawValue = arg.getRawValue();
            boolean _not = (!(((Boolean) _rawValue)).booleanValue());
            boolean _isCompileTimeConstant = arg.isCompileTimeConstant();
            _switchResult = new EvaluationResult(Boolean.valueOf(_not), _isCompileTimeConstant);
          }
        }
        if (!_matched) {
          if ((Objects.equal(op, "+") && (arg.getRawValue() instanceof Number))) {
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
    if ((this.isFromXbaseLibrary(it, context) && (it.getRightOperand() != null))) {
      final EvaluationResult left = this.doEvaluate(it.getLeftOperand(), context);
      final EvaluationResult right = this.doEvaluate(it.getRightOperand(), context);
      try {
        final String op = it.getConcreteSyntaxFeatureName();
        Object _switchResult = null;
        if (op != null) {
          switch (op) {
            case "+":
              _switchResult = this.constantOperators.plus(left.getRawValue(), right.getRawValue());
              break;
            case "-":
              _switchResult = this.constantOperators.minus(left.getRawValue(), right.getRawValue());
              break;
            case "*":
              _switchResult = this.constantOperators.multiply(left.getRawValue(), right.getRawValue());
              break;
            case "/":
              _switchResult = this.constantOperators.divide(left.getRawValue(), right.getRawValue());
              break;
            case "%":
              _switchResult = this.constantOperators.modulo(left.getRawValue(), right.getRawValue());
              break;
            case "<<":
              _switchResult = this.constantOperators.shiftLeft(left.getRawValue(), right.getRawValue());
              break;
            case ">>":
              _switchResult = this.constantOperators.shiftRight(left.getRawValue(), right.getRawValue());
              break;
            case ">>>":
              _switchResult = this.constantOperators.shiftRightUnsigned(left.getRawValue(), right.getRawValue());
              break;
            case "<":
              _switchResult = Boolean.valueOf(this.constantOperators.lessThan(left.getRawValue(), right.getRawValue()));
              break;
            case ">":
              _switchResult = Boolean.valueOf(this.constantOperators.greaterThan(left.getRawValue(), right.getRawValue()));
              break;
            case "<=":
              _switchResult = Boolean.valueOf(this.constantOperators.lessEquals(left.getRawValue(), right.getRawValue()));
              break;
            case ">=":
              _switchResult = Boolean.valueOf(this.constantOperators.greaterEquals(left.getRawValue(), right.getRawValue()));
              break;
            case "&&":
              return this.internalLogicalAnd(left.getRawValue(), right.getRawValue(), (left.isCompileTimeConstant() && right.isCompileTimeConstant()));
            case "||":
              return this.internalLogicalOr(left.getRawValue(), right.getRawValue(), (left.isCompileTimeConstant() && right.isCompileTimeConstant()));
            case "==":
            case "===":
              if ((left.isNotAConstant() || right.isNotAConstant())) {
                return EvaluationResult.NOT_A_CONSTANT;
              }
              Object _equalValue = left.equalValue(right);
              return new EvaluationResult(_equalValue, (left.isCompileTimeConstant() && right.isCompileTimeConstant()));
            case "!=":
            case "!==":
              if ((left.isNotAConstant() || right.isNotAConstant())) {
                return EvaluationResult.NOT_A_CONSTANT;
              }
              final Object result = left.equalValue(right);
              boolean _matched = false;
              if (result instanceof Boolean) {
                _matched=true;
                return new EvaluationResult(Boolean.valueOf((!((Boolean) result).booleanValue())), (left.isCompileTimeConstant() && right.isCompileTimeConstant()));
              }
              return new EvaluationResult(result, (left.isCompileTimeConstant() && right.isCompileTimeConstant()));
            default:
              return EvaluationResult.NOT_A_CONSTANT;
          }
        } else {
          return EvaluationResult.NOT_A_CONSTANT;
        }
        final Object value = _switchResult;
        return new EvaluationResult(value, (left.isCompileTimeConstant() && right.isCompileTimeConstant()));
      } catch (final Throwable _t) {
        if (_t instanceof ConstantExpressionEvaluationException) {
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
    return this.doEvaluate(expression.getTarget(), context);
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
