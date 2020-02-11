/**
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.linking;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.tests.linking.AbstractXbaseLinkingTest;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class BatchLinkingTest extends AbstractXbaseLinkingTest {
  @Inject
  private IBatchTypeResolver typeResolver;
  
  private boolean failOnUnresolvedProxy = true;
  
  @Before
  public void init() {
    this.failOnUnresolvedProxy = true;
  }
  
  @Override
  public XExpression expression(final CharSequence string, final boolean resolve) throws Exception {
    this.failOnUnresolvedProxy = resolve;
    final XExpression result = super.expression(string, false);
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(result);
    Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(result.eAllContents());
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
    if (this.failOnUnresolvedProxy) {
      Iterable<EObject> _iterable_1 = IteratorExtensions.<EObject>toIterable(result.eAllContents());
      for (final EObject content_1 : _iterable_1) {
        boolean _matched_1 = false;
        if (content_1 instanceof XConstructorCall) {
          _matched_1=true;
          Object _eGet = ((XConstructorCall)content_1).eGet(XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, false);
          final InternalEObject constructor = ((InternalEObject) _eGet);
          Assert.assertNotNull(((XConstructorCall)content_1).toString(), constructor);
          Assert.assertFalse(((XConstructorCall)content_1).toString(), constructor.eIsProxy());
        }
        if (!_matched_1) {
          if (content_1 instanceof XAbstractFeatureCall) {
            _matched_1=true;
            Object _eGet = ((XAbstractFeatureCall)content_1).eGet(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, false);
            final InternalEObject feature = ((InternalEObject) _eGet);
            Assert.assertNotNull(((XAbstractFeatureCall)content_1).toString(), feature);
            Assert.assertFalse(((XAbstractFeatureCall)content_1).toString(), feature.eIsProxy());
          }
        }
      }
    }
    return result;
  }
  
  public void assertExpressionTypeIsResolved(final XExpression expression, final IResolvedTypes types) {
    final LightweightTypeReference type = types.getActualType(expression);
    Assert.assertNotNull(expression.toString(), type);
    String _string = expression.toString();
    String _plus = (_string + " / ");
    String _plus_1 = (_plus + type);
    Assert.assertNotNull(_plus_1, type.getIdentifier());
  }
  
  public void assertIdentifiableTypeIsResolved(final JvmIdentifiableElement identifiable, final IResolvedTypes types) {
    final LightweightTypeReference type = types.getActualType(identifiable);
    Assert.assertNotNull(identifiable.toString(), type);
    String _string = identifiable.toString();
    String _plus = (_string + " / ");
    String _plus_1 = (_plus + type);
    Assert.assertNotNull(_plus_1, type.getIdentifier());
  }
  
  @Test
  @Override
  public void testMemberCallOnMultiTypeWithUnresolvableArgument_01() throws Exception {
    try {
      this.failOnUnresolvedProxy = false;
      super.testMemberCallOnMultiTypeWithUnresolvableArgument_01();
    } finally {
      this.failOnUnresolvedProxy = true;
    }
  }
}
