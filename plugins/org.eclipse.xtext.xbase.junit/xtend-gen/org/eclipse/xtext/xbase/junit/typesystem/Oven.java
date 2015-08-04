/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.junit.typesystem;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.lang.reflect.Method;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.CompoundReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.RootResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.TypeData;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.ComparisonFailure;

/**
 * Utility to check a given expression for exceptions and integrity
 * after it was processed by the {@link IBatchTypeResolver}
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Beta
@Singleton
@SuppressWarnings("all")
public class Oven extends Assert {
  @Inject
  private IBatchTypeResolver typeResolver;
  
  @Inject
  @Extension
  private ReflectExtensions _reflectExtensions;
  
  @Inject
  @Extension
  private ParseHelper<EObject> _parseHelper;
  
  public void fireproof(final CharSequence input) throws Exception {
    String _string = input.toString();
    this.fireproof(_string);
  }
  
  public void fireproof(final String input) throws Exception {
    try {
      final EObject file = this._parseHelper.parse(input);
      final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(file);
      Assert.assertNotNull(resolvedTypes);
      boolean _notEquals = (!Objects.equal(file, null));
      if (_notEquals) {
        TreeIterator<EObject> _eAllContents = file.eAllContents();
        Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(_eAllContents);
        for (final EObject content : _iterable) {
          boolean _matched = false;
          if (!_matched) {
            if (content instanceof XAbstractFeatureCall) {
              _matched=true;
              this.assertExpressionTypeIsResolved(((XExpression)content), resolvedTypes);
              XExpression _implicitReceiver = ((XAbstractFeatureCall)content).getImplicitReceiver();
              boolean _notEquals_1 = (!Objects.equal(_implicitReceiver, null));
              if (_notEquals_1) {
                XExpression _implicitReceiver_1 = ((XAbstractFeatureCall)content).getImplicitReceiver();
                this.assertExpressionTypeIsResolved(_implicitReceiver_1, resolvedTypes);
              }
              XExpression _implicitFirstArgument = ((XAbstractFeatureCall)content).getImplicitFirstArgument();
              boolean _notEquals_2 = (!Objects.equal(_implicitFirstArgument, null));
              if (_notEquals_2) {
                XExpression _implicitFirstArgument_1 = ((XAbstractFeatureCall)content).getImplicitFirstArgument();
                this.assertExpressionTypeIsResolved(_implicitFirstArgument_1, resolvedTypes);
              }
            }
          }
          if (!_matched) {
            if (content instanceof XClosure) {
              _matched=true;
              this.assertExpressionTypeIsResolved(((XExpression)content), resolvedTypes);
              EList<JvmFormalParameter> _implicitFormalParameters = ((XClosure)content).getImplicitFormalParameters();
              final Procedure1<JvmFormalParameter> _function = new Procedure1<JvmFormalParameter>() {
                @Override
                public void apply(final JvmFormalParameter it) {
                  Oven.this.assertIdentifiableTypeIsResolved(it, resolvedTypes);
                }
              };
              IterableExtensions.<JvmFormalParameter>forEach(_implicitFormalParameters, _function);
            }
          }
          if (!_matched) {
            if (content instanceof XExpression) {
              _matched=true;
              this.assertExpressionTypeIsResolved(((XExpression)content), resolvedTypes);
            }
          }
          if (!_matched) {
            if (content instanceof JvmIdentifiableElement) {
              _matched=true;
              this.assertIdentifiableTypeIsResolved(((JvmIdentifiableElement)content), resolvedTypes);
            }
          }
        }
      }
    } catch (final Throwable _t) {
      if (_t instanceof Throwable) {
        final Throwable e = (Throwable)_t;
        String _message = e.getMessage();
        final ComparisonFailure error = new ComparisonFailure(_message, input, "");
        StackTraceElement[] _stackTrace = e.getStackTrace();
        error.setStackTrace(_stackTrace);
        throw error;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void assertExpressionTypeIsResolved(final XExpression expression, final IResolvedTypes types) {
    try {
      final Object internalTypes = this._reflectExtensions.invoke(types, "delegate");
      TypeData _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (internalTypes instanceof CompoundReentrantTypeResolver) {
          _matched=true;
          TypeData _xblockexpression = null;
          {
            final Method method = CompoundReentrantTypeResolver.class.getDeclaredMethod("getDelegate", XExpression.class);
            method.setAccessible(true);
            final Object delegate = method.invoke(internalTypes, expression);
            TypeData _xifexpression = null;
            if ((delegate instanceof RootResolvedTypes)) {
              Object _invoke = this._reflectExtensions.invoke(delegate, "getTypeData", expression, Boolean.FALSE);
              _xifexpression = ((TypeData) _invoke);
            }
            _xblockexpression = _xifexpression;
          }
          _switchResult = _xblockexpression;
        }
      }
      if (!_matched) {
        Object _invoke = this._reflectExtensions.invoke(internalTypes, "getTypeData", expression, Boolean.FALSE);
        _switchResult = ((TypeData) _invoke);
      }
      final TypeData type = _switchResult;
      String _string = expression.toString();
      String _plus = ("Type is not resolved. Expression: " + _string);
      boolean _xifexpression = false;
      if ((expression instanceof XAbstractFeatureCall)) {
        boolean _or = false;
        boolean _isPackageFragment = ((XAbstractFeatureCall)expression).isPackageFragment();
        if (_isPackageFragment) {
          _or = true;
        } else {
          boolean _notEquals = (!Objects.equal(type, null));
          _or = _notEquals;
        }
        _xifexpression = _or;
      } else {
        _xifexpression = (!Objects.equal(type, null));
      }
      Assert.assertTrue(_plus, _xifexpression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void assertIdentifiableTypeIsResolved(final JvmIdentifiableElement identifiable, final IResolvedTypes types) {
    String _simpleName = identifiable.getSimpleName();
    boolean _equals = Objects.equal(_simpleName, null);
    if (_equals) {
      return;
    }
    final LightweightTypeReference type = types.getActualType(identifiable);
    String _string = identifiable.toString();
    Assert.assertNotNull(_string, type);
    String _string_1 = identifiable.toString();
    String _plus = (_string_1 + " / ");
    String _plus_1 = (_plus + type);
    String _identifier = type.getIdentifier();
    Assert.assertNotNull(_plus_1, _identifier);
  }
}
