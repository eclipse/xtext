/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.validation;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.util.XExpressionHelper;
import org.eclipse.xtext.xbase.validation.NotResolvedFeatureException;

/**
 * Checks whether a given XExpression is a a constant expression.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class ConstantExpressionValidator {
  @Inject
  @Extension
  private TypeReferences _typeReferences;
  
  @Inject
  @Extension
  private Primitives _primitives;
  
  @Inject
  @Extension
  private XExpressionHelper _xExpressionHelper;
  
  @Inject
  @Extension
  private ILogicalContainerProvider _iLogicalContainerProvider;
  
  protected boolean _isConstant(final XExpression expression) {
    return false;
  }
  
  protected boolean _isConstant(final XStringLiteral expression) {
    return true;
  }
  
  protected boolean _isConstant(final XTypeLiteral expression) {
    return true;
  }
  
  protected boolean _isConstant(final XNumberLiteral expression) {
    return true;
  }
  
  protected boolean _isConstant(final XBooleanLiteral expression) {
    return true;
  }
  
  protected boolean _isConstant(final XCastedExpression expression) {
    boolean _or = false;
    JvmTypeReference _type = expression.getType();
    boolean _isPrimitive = this._primitives.isPrimitive(_type);
    if (_isPrimitive) {
      _or = true;
    } else {
      JvmTypeReference _type_1 = expression.getType();
      boolean _is = this._typeReferences.is(_type_1, String.class);
      _or = _is;
    }
    return _or;
  }
  
  protected boolean _isConstant(final XAbstractFeatureCall expression) {
    JvmIdentifiableElement _feature = expression.getFeature();
    final JvmIdentifiableElement feature = _feature;
    boolean _matched = false;
    if (feature instanceof JvmEnumerationLiteral) {
      _matched=true;
      return true;
    }
    if (!_matched) {
      if (feature instanceof JvmField) {
        _matched=true;
        boolean _isSetConstant = ((JvmField)feature).isSetConstant();
        if (_isSetConstant) {
          return ((JvmField)feature).isConstant();
        }
        boolean _and = false;
        boolean _isStatic = ((JvmField)feature).isStatic();
        if (!_isStatic) {
          _and = false;
        } else {
          boolean _isFinal = ((JvmField)feature).isFinal();
          _and = _isFinal;
        }
        final boolean potentiallyConstant = _and;
        if (potentiallyConstant) {
          Resource _eResource = ((JvmField)feature).eResource();
          if ((_eResource instanceof TypeResource)) {
            return true;
          } else {
            XExpression _associatedExpression = this._iLogicalContainerProvider.getAssociatedExpression(feature);
            return this.isConstantExpression(_associatedExpression);
          }
        }
        return false;
      }
    }
    if (!_matched) {
      if (feature instanceof JvmOperation) {
        _matched=true;
        final JvmAnnotationReference annotationReference = this._xExpressionHelper.findInlineAnnotation(expression);
        boolean _equals = Objects.equal(annotationReference, null);
        if (_equals) {
          return false;
        }
        EList<JvmAnnotationValue> _values = annotationReference.getValues();
        Iterable<JvmBooleanAnnotationValue> _filter = Iterables.<JvmBooleanAnnotationValue>filter(_values, JvmBooleanAnnotationValue.class);
        final Function1<JvmBooleanAnnotationValue, Boolean> _function = new Function1<JvmBooleanAnnotationValue, Boolean>() {
          @Override
          public Boolean apply(final JvmBooleanAnnotationValue it) {
            boolean _and = false;
            String _valueName = it.getValueName();
            boolean _equals = Objects.equal(_valueName, "constantExpression");
            if (!_equals) {
              _and = false;
            } else {
              EList<Boolean> _values = it.getValues();
              Boolean _head = IterableExtensions.<Boolean>head(_values);
              boolean _booleanValue = _head.booleanValue();
              _and = _booleanValue;
            }
            return Boolean.valueOf(_and);
          }
        };
        boolean _exists = IterableExtensions.<JvmBooleanAnnotationValue>exists(_filter, _function);
        if (_exists) {
          boolean _xifexpression = false;
          XExpression _actualReceiver = expression.getActualReceiver();
          boolean _equals_1 = Objects.equal(_actualReceiver, null);
          if (_equals_1) {
            _xifexpression = true;
          } else {
            XExpression _actualReceiver_1 = expression.getActualReceiver();
            _xifexpression = this.isConstant(_actualReceiver_1);
          }
          final boolean receiverConstant = _xifexpression;
          boolean _and = false;
          if (!receiverConstant) {
            _and = false;
          } else {
            EList<XExpression> _actualArguments = expression.getActualArguments();
            final Function1<XExpression, Boolean> _function_1 = new Function1<XExpression, Boolean>() {
              @Override
              public Boolean apply(final XExpression it) {
                return Boolean.valueOf(ConstantExpressionValidator.this.isConstant(it));
              }
            };
            boolean _forall = IterableExtensions.<XExpression>forall(_actualArguments, _function_1);
            _and = _forall;
          }
          return _and;
        }
      }
    }
    if (!_matched) {
      if (feature instanceof XVariableDeclaration) {
        _matched=true;
        boolean _and = false;
        boolean _isWriteable = ((XVariableDeclaration)feature).isWriteable();
        boolean _not = (!_isWriteable);
        if (!_not) {
          _and = false;
        } else {
          XExpression _right = ((XVariableDeclaration)feature).getRight();
          boolean _isConstantExpression = this.isConstantExpression(_right);
          _and = _isConstantExpression;
        }
        return _and;
      }
    }
    if (!_matched) {
      if (feature instanceof XSwitchExpression) {
        _matched=true;
        XExpression _switch = ((XSwitchExpression)feature).getSwitch();
        return this.isConstantExpression(_switch);
      }
    }
    if (!_matched) {
      if (feature instanceof EObject) {
        boolean _eIsProxy = feature.eIsProxy();
        if (_eIsProxy) {
          _matched=true;
          throw new NotResolvedFeatureException();
        }
      }
    }
    return false;
  }
  
  protected boolean _isConstantExpression(final Void it) {
    return false;
  }
  
  protected boolean _isConstantExpression(final XExpression it) {
    return this.isConstant(it);
  }
  
  protected boolean _isConstantExpression(final XAbstractFeatureCall it) {
    boolean _switchResult = false;
    JvmIdentifiableElement _feature = it.getFeature();
    boolean _matched = false;
    if (_feature instanceof JvmEnumerationLiteral) {
      _matched=true;
      _switchResult = false;
    }
    if (!_matched) {
      _switchResult = this.isConstant(it);
    }
    return _switchResult;
  }
  
  public boolean isConstant(final XExpression expression) {
    if (expression instanceof XAbstractFeatureCall) {
      return _isConstant((XAbstractFeatureCall)expression);
    } else if (expression instanceof XBooleanLiteral) {
      return _isConstant((XBooleanLiteral)expression);
    } else if (expression instanceof XCastedExpression) {
      return _isConstant((XCastedExpression)expression);
    } else if (expression instanceof XNumberLiteral) {
      return _isConstant((XNumberLiteral)expression);
    } else if (expression instanceof XStringLiteral) {
      return _isConstant((XStringLiteral)expression);
    } else if (expression instanceof XTypeLiteral) {
      return _isConstant((XTypeLiteral)expression);
    } else if (expression != null) {
      return _isConstant(expression);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(expression).toString());
    }
  }
  
  public boolean isConstantExpression(final XExpression it) {
    if (it instanceof XAbstractFeatureCall) {
      return _isConstantExpression((XAbstractFeatureCall)it);
    } else if (it != null) {
      return _isConstantExpression(it);
    } else if (it == null) {
      return _isConstantExpression((Void)null);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
