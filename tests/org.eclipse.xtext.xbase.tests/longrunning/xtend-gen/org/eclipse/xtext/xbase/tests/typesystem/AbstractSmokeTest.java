/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractTypeResolverTest;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.TypeData;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractSmokeTest extends AbstractTypeResolverTest<LightweightTypeReference> {
  @Inject
  private IBatchTypeResolver typeResolver;
  
  public LightweightTypeReference resolvesTo(final String expression, final String type) {
    try {
      this.assertNonSmoking(expression);
      return null;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void isFunctionAndEquivalentTo(final LightweightTypeReference reference, final String type) {
  }
  
  protected void handleDuplicateExpression(final CharSequence expression) {
  }
  
  public abstract void assertNonSmoking(final String input) throws Exception;
  
  public void processExpression(final String expression) throws Exception {
    try {
      String _replace = expression.replace("$$", "org::eclipse::xtext::xbase::lib::");
      final XExpression xExpression = this.expression(_replace, false);
      final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(xExpression);
      Assert.assertNotNull(resolvedTypes);
      boolean _notEquals = ObjectExtensions.operator_notEquals(xExpression, null);
      if (_notEquals) {
        TreeIterator<EObject> _eAllContents = xExpression.eAllContents();
        Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(_eAllContents);
        for (final EObject content : _iterable) {
          boolean _matched = false;
          if (!_matched) {
            if (content instanceof XSwitchExpression) {
              final XSwitchExpression _xSwitchExpression = (XSwitchExpression)content;
              _matched=true;
              this.assertExpressionTypeIsResolved(_xSwitchExpression, resolvedTypes);
              String _localVarName = _xSwitchExpression.getLocalVarName();
              boolean _notEquals_1 = ObjectExtensions.operator_notEquals(_localVarName, null);
              if (_notEquals_1) {
                this.assertIdentifiableTypeIsResolved(_xSwitchExpression, resolvedTypes);
              }
            }
          }
          if (!_matched) {
            if (content instanceof XAbstractFeatureCall) {
              final XAbstractFeatureCall _xAbstractFeatureCall = (XAbstractFeatureCall)content;
              _matched=true;
              this.assertExpressionTypeIsResolved(_xAbstractFeatureCall, resolvedTypes);
              XExpression _implicitReceiver = _xAbstractFeatureCall.getImplicitReceiver();
              boolean _notEquals_1 = ObjectExtensions.operator_notEquals(_implicitReceiver, null);
              if (_notEquals_1) {
                XExpression _implicitReceiver_1 = _xAbstractFeatureCall.getImplicitReceiver();
                this.assertExpressionTypeIsResolved(_implicitReceiver_1, resolvedTypes);
              }
            }
          }
          if (!_matched) {
            if (content instanceof XExpression) {
              final XExpression _xExpression = (XExpression)content;
              _matched=true;
              this.assertExpressionTypeIsResolved(_xExpression, resolvedTypes);
            }
          }
          if (!_matched) {
            if (content instanceof XCasePart) {
              final XCasePart _xCasePart = (XCasePart)content;
              _matched=true;
            }
          }
          if (!_matched) {
            if (content instanceof JvmIdentifiableElement) {
              final JvmIdentifiableElement _jvmIdentifiableElement = (JvmIdentifiableElement)content;
              _matched=true;
              this.assertIdentifiableTypeIsResolved(_jvmIdentifiableElement, resolvedTypes);
            }
          }
        }
      }
    } catch (final Throwable _t) {
      if (_t instanceof Throwable) {
        final Throwable t = (Throwable)_t;
        String _plus = ("Expression was: \'" + expression);
        String _plus_1 = (_plus + "\"");
        RuntimeException _runtimeException = new RuntimeException(_plus_1, t);
        throw _runtimeException;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Inject
  private ReflectExtensions _reflectExtensions;
  
  public void assertExpressionTypeIsResolved(final XExpression expression, final IResolvedTypes types) {
    try {
      final Object internalTypes = this._reflectExtensions.invoke(types, "delegate");
      Object _invoke = this._reflectExtensions.invoke(internalTypes, "getTypeData", expression, Boolean.FALSE);
      final TypeData type = ((TypeData) _invoke);
      String _string = expression.toString();
      String _plus = ("Type is not resolved. Expression: " + _string);
      Assert.assertNotNull(_plus, type);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void assertIdentifiableTypeIsResolved(final JvmIdentifiableElement identifiable, final IResolvedTypes types) {
    final LightweightTypeReference type = types.getActualType(identifiable);
    String _string = identifiable.toString();
    Assert.assertNotNull(_string, type);
    String _string_1 = identifiable.toString();
    String _plus = (_string_1 + " / ");
    String _plus_1 = (_plus + type);
    String _identifier = type.getIdentifier();
    Assert.assertNotNull(_plus_1, _identifier);
  }
  
  @Test
  public void testOverloadedOperators_11() throws Exception {
    super.testOverloadedOperators_11();
  }
  
  @Test
  public void testOverloadedOperators_13() throws Exception {
    super.testOverloadedOperators_13();
  }
  
  @Test
  public void testClosure_14() throws Exception {
    super.testClosure_14();
  }
  
  @Test
  public void testClosure_32() throws Exception {
    super.testClosure_32();
  }
  
  @Ignore("Disable block expression with 1000+ lines")
  @Test
  public void testBlockExpression_03() throws Exception {
    super.testBlockExpression_03();
  }
  
  @Ignore("Disable member feature calls with plenty of nested target expressions")
  @Test
  public void testFeatureCall_15_m() throws Exception {
    super.testFeatureCall_15_m();
  }
}
