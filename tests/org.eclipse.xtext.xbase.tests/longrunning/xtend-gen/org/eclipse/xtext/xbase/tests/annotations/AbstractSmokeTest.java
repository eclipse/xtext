/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.annotations;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.eclipse.xtext.xbase.tests.annotations.AnnotationsValidatorTest;
import org.eclipse.xtext.xbase.tests.annotations.NullValidationTestHelper;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.TypeData;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Before;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractSmokeTest extends AnnotationsValidatorTest {
  @Inject
  private IBatchTypeResolver typeResolver;
  
  @Inject
  @Extension
  private ParseHelper<EObject> _parseHelper;
  
  @Before
  public void resetTestHelper() {
    NullValidationTestHelper _nullValidationTestHelper = new NullValidationTestHelper();
    this.validator = _nullValidationTestHelper;
  }
  
  protected XAnnotation annotation(final String expression, final boolean resolve) throws Exception {
    this.assertNonSmoking(expression);
    return null;
  }
  
  public void testReferencedTypeIsNoEnum() throws Exception {
    this.annotation("@java.lang.Object(unknown = #[ new String() ])", false);
  }
  
  public abstract void assertNonSmoking(final String input) throws Exception;
  
  public void processExpression(final String expression) throws Exception {
    try {
      final EObject xExpression = this._parseHelper.parse(expression);
      final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(xExpression);
      Assert.assertNotNull(resolvedTypes);
      boolean _notEquals = (!Objects.equal(xExpression, null));
      if (_notEquals) {
        TreeIterator<EObject> _eAllContents = xExpression.eAllContents();
        Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(_eAllContents);
        for (final EObject content : _iterable) {
          boolean _matched = false;
          if (!_matched) {
            if (content instanceof XSwitchExpression) {
              _matched=true;
              this.assertExpressionTypeIsResolved(((XExpression)content), resolvedTypes);
              String _localVarName = ((XSwitchExpression)content).getLocalVarName();
              boolean _notEquals_1 = (!Objects.equal(_localVarName, null));
              if (_notEquals_1) {
                this.assertIdentifiableTypeIsResolved(((JvmIdentifiableElement)content), resolvedTypes);
              }
            }
          }
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
        final Throwable t = (Throwable)_t;
        throw new RuntimeException((("Expression was: \'" + expression) + "\""), t);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Inject
  @Extension
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
}
