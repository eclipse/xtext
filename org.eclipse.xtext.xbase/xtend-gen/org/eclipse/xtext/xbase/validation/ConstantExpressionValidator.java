/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.validation;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
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
    return (this._primitives.isPrimitive(expression.getType()) || this._typeReferences.is(expression.getType(), String.class));
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
        final boolean potentiallyConstant = (((JvmField)feature).isStatic() && ((JvmField)feature).isFinal());
        if (potentiallyConstant) {
          Resource _eResource = ((JvmField)feature).eResource();
          if ((_eResource instanceof TypeResource)) {
            return true;
          } else {
            return this.isConstantExpression(this._iLogicalContainerProvider.getAssociatedExpression(feature));
          }
        }
        return false;
      }
    }
    if (!_matched) {
      if (feature instanceof JvmOperation) {
        _matched=true;
        final JvmAnnotationReference annotationReference = this._xExpressionHelper.findInlineAnnotation(expression);
        if ((annotationReference == null)) {
          return false;
        }
        final Function1<JvmBooleanAnnotationValue, Boolean> _function = (JvmBooleanAnnotationValue it) -> {
          return Boolean.valueOf((Objects.equal(it.getValueName(), "constantExpression") && IterableExtensions.<Boolean>head(it.getValues()).booleanValue()));
        };
        boolean _exists = IterableExtensions.<JvmBooleanAnnotationValue>exists(Iterables.<JvmBooleanAnnotationValue>filter(annotationReference.getValues(), JvmBooleanAnnotationValue.class), _function);
        if (_exists) {
          boolean _xifexpression = false;
          XExpression _actualReceiver = expression.getActualReceiver();
          boolean _tripleEquals = (_actualReceiver == null);
          if (_tripleEquals) {
            _xifexpression = true;
          } else {
            _xifexpression = this.isConstant(expression.getActualReceiver());
          }
          final boolean receiverConstant = _xifexpression;
          return (receiverConstant && IterableExtensions.<XExpression>forall(expression.getActualArguments(), ((Function1<XExpression, Boolean>) (XExpression it) -> {
            return Boolean.valueOf(this.isConstant(it));
          })));
        }
      }
    }
    if (!_matched) {
      if (feature instanceof XVariableDeclaration) {
        _matched=true;
        return ((!((XVariableDeclaration)feature).isWriteable()) && this.isConstantExpression(((XVariableDeclaration)feature).getRight()));
      }
    }
    if (!_matched) {
      if (feature instanceof XSwitchExpression) {
        _matched=true;
        return this.isConstantExpression(((XSwitchExpression)feature).getSwitch());
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
