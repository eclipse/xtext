/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.testing.typesystem;

import com.google.common.annotations.Beta;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.lang.reflect.Method;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
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
    this.fireproof(input.toString());
  }
  
  public void fireproof(final String input) throws Exception {
    try {
      final EObject file = this._parseHelper.parse(input);
      final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(file);
      Assert.assertNotNull(resolvedTypes);
      if ((file != null)) {
        Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(file.eAllContents());
        for (final EObject content : _iterable) {
          boolean _matched = false;
          if (content instanceof XAbstractFeatureCall) {
            _matched=true;
            this.assertExpressionTypeIsResolved(((XExpression)content), resolvedTypes);
            XExpression _implicitReceiver = ((XAbstractFeatureCall)content).getImplicitReceiver();
            boolean _tripleNotEquals = (_implicitReceiver != null);
            if (_tripleNotEquals) {
              this.assertExpressionTypeIsResolved(((XAbstractFeatureCall)content).getImplicitReceiver(), resolvedTypes);
            }
            XExpression _implicitFirstArgument = ((XAbstractFeatureCall)content).getImplicitFirstArgument();
            boolean _tripleNotEquals_1 = (_implicitFirstArgument != null);
            if (_tripleNotEquals_1) {
              this.assertExpressionTypeIsResolved(((XAbstractFeatureCall)content).getImplicitFirstArgument(), resolvedTypes);
            }
          }
          if (!_matched) {
            if (content instanceof XClosure) {
              _matched=true;
              this.assertExpressionTypeIsResolved(((XExpression)content), resolvedTypes);
              final Consumer<JvmFormalParameter> _function = (JvmFormalParameter it) -> {
                this.assertIdentifiableTypeIsResolved(it, resolvedTypes);
              };
              ((XClosure)content).getImplicitFormalParameters().forEach(_function);
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
        error.setStackTrace(e.getStackTrace());
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
      if (!_matched) {
        Object _invoke = this._reflectExtensions.invoke(internalTypes, "getTypeData", expression, Boolean.FALSE);
        _switchResult = ((TypeData) _invoke);
      }
      final TypeData type = _switchResult;
      String _string = expression.toString();
      String _plus = ("Type is not resolved. Expression: " + _string);
      boolean _xifexpression = false;
      if ((expression instanceof XAbstractFeatureCall)) {
        _xifexpression = (((XAbstractFeatureCall)expression).isPackageFragment() || (type != null));
      } else {
        _xifexpression = (type != null);
      }
      Assert.assertTrue(_plus, _xifexpression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void assertIdentifiableTypeIsResolved(final JvmIdentifiableElement identifiable, final IResolvedTypes types) {
    String _simpleName = identifiable.getSimpleName();
    boolean _tripleEquals = (_simpleName == null);
    if (_tripleEquals) {
      return;
    }
    final LightweightTypeReference type = types.getActualType(identifiable);
    Assert.assertNotNull(identifiable.toString(), type);
    String _string = identifiable.toString();
    String _plus = (_string + " / ");
    String _plus_1 = (_plus + type);
    Assert.assertNotNull(_plus_1, type.getIdentifier());
  }
}
