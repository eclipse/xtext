/**
 * Copyright (c) 2014, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.interpreter;

import com.google.inject.Inject;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.access.impl.ClassFinder;
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
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.typesystem.computation.NumberLiterals;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class SwitchConstantExpressionsInterpreter extends AbstractConstantExpressionsInterpreter {
  private static class SwitchContext extends Context {
    private boolean validationMode;

    public SwitchContext(final JvmTypeReference expectedType, final ClassFinder classFinder, final Map<String, JvmIdentifiableElement> visibleFeatures, final Set<XExpression> alreadyEvaluating) {
      super(expectedType, classFinder, visibleFeatures, alreadyEvaluating);
    }
  }

  @Inject
  @Extension
  private ILogicalContainerProvider _iLogicalContainerProvider;

  @Inject
  @Extension
  private NumberLiterals numberLiterals;

  public Object evaluate(final XExpression it) {
    HashSet<XExpression> _newHashSet = CollectionLiterals.<XExpression>newHashSet();
    Context _context = new Context(null, null, null, _newHashSet);
    return this.evaluate(it, _context);
  }

  public Object evaluate(final XExpression it, final boolean validationMode) {
    Object _xblockexpression = null;
    {
      HashSet<XExpression> _newHashSet = CollectionLiterals.<XExpression>newHashSet();
      final SwitchConstantExpressionsInterpreter.SwitchContext ctx = new SwitchConstantExpressionsInterpreter.SwitchContext(null, null, null, _newHashSet);
      ctx.validationMode = validationMode;
      _xblockexpression = this.evaluate(it, ctx);
    }
    return _xblockexpression;
  }

  protected Object _internalEvaluate(final XNumberLiteral it, final Context ctx) {
    return this.numberLiterals.numberValue(it, this.numberLiterals.getJavaType(it));
  }

  protected Object _internalEvaluate(final XAbstractFeatureCall it, final Context ctx) {
    JvmIdentifiableElement _feature = it.getFeature();
    final JvmIdentifiableElement feature = _feature;
    boolean _matched = false;
    if (feature instanceof JvmType) {
      _matched=true;
      return this.toTypeReference(((JvmType)feature), 0);
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
          if ((((JvmField)feature).isFinal() && (((JvmField)feature).isStatic() || ((ctx instanceof SwitchConstantExpressionsInterpreter.SwitchContext) && ((SwitchConstantExpressionsInterpreter.SwitchContext) ctx).validationMode)))) {
            final XExpression associatedExpression = this._iLogicalContainerProvider.getAssociatedExpression(feature);
            if ((associatedExpression != null)) {
              return this.evaluateAssociatedExpression(associatedExpression, ctx);
            }
          }
        }
      }
    }
    if (!_matched) {
      if (feature instanceof XVariableDeclaration) {
        if (((!((XVariableDeclaration)feature).isWriteable()) && (((XVariableDeclaration)feature).getRight() != null))) {
          _matched=true;
          return this.evaluateAssociatedExpression(((XVariableDeclaration)feature).getRight(), ctx);
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
            return this.evaluate(((XSwitchExpression)container).getSwitch(), ctx);
          }
        }
      }
    }
    String _simpleName = it.getFeature().getSimpleName();
    String _plus = ("Couldn\'t resolve feature " + _simpleName);
    throw new UnresolvableFeatureException(_plus, it);
  }

  public Object evaluateAssociatedExpression(final XExpression it, final Context ctx) {
    Object _switchResult = null;
    boolean _matched = false;
    if (it instanceof XAbstractFeatureCall) {
      JvmIdentifiableElement _feature = ((XAbstractFeatureCall)it).getFeature();
      if ((_feature instanceof JvmEnumerationLiteral)) {
        _matched=true;
        throw this.notConstantExpression(it);
      }
    }
    if (!_matched) {
      _switchResult = this.evaluate(it, ctx);
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
    } else if (it == null) {
      return _internalEvaluate((Void)null, ctx);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, ctx).toString());
    }
  }
}
