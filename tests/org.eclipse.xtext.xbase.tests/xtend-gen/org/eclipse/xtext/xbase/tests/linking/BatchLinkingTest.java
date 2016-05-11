/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.linking;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.TreeIterator;
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
    TreeIterator<EObject> _eAllContents = result.eAllContents();
    Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(_eAllContents);
    for (final EObject content : _iterable) {
      boolean _matched = false;
      if (content instanceof XAbstractFeatureCall) {
        _matched=true;
        this.assertExpressionTypeIsResolved(((XExpression)content), resolvedTypes);
        XExpression _implicitReceiver = ((XAbstractFeatureCall)content).getImplicitReceiver();
        boolean _notEquals = (!Objects.equal(_implicitReceiver, null));
        if (_notEquals) {
          XExpression _implicitReceiver_1 = ((XAbstractFeatureCall)content).getImplicitReceiver();
          this.assertExpressionTypeIsResolved(_implicitReceiver_1, resolvedTypes);
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
      TreeIterator<EObject> _eAllContents_1 = result.eAllContents();
      Iterable<EObject> _iterable_1 = IteratorExtensions.<EObject>toIterable(_eAllContents_1);
      for (final EObject content_1 : _iterable_1) {
        boolean _matched_1 = false;
        if (content_1 instanceof XConstructorCall) {
          _matched_1=true;
          Object _eGet = ((XConstructorCall)content_1).eGet(XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, false);
          final InternalEObject constructor = ((InternalEObject) _eGet);
          String _string = ((XConstructorCall)content_1).toString();
          Assert.assertNotNull(_string, constructor);
          String _string_1 = ((XConstructorCall)content_1).toString();
          boolean _eIsProxy = constructor.eIsProxy();
          Assert.assertFalse(_string_1, _eIsProxy);
        }
        if (!_matched_1) {
          if (content_1 instanceof XAbstractFeatureCall) {
            _matched_1=true;
            Object _eGet = ((XAbstractFeatureCall)content_1).eGet(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, false);
            final InternalEObject feature = ((InternalEObject) _eGet);
            String _string = ((XAbstractFeatureCall)content_1).toString();
            Assert.assertNotNull(_string, feature);
            String _string_1 = ((XAbstractFeatureCall)content_1).toString();
            boolean _eIsProxy = feature.eIsProxy();
            Assert.assertFalse(_string_1, _eIsProxy);
          }
        }
      }
    }
    return result;
  }
  
  public void assertExpressionTypeIsResolved(final XExpression expression, final IResolvedTypes types) {
    final LightweightTypeReference type = types.getActualType(expression);
    String _string = expression.toString();
    Assert.assertNotNull(_string, type);
    String _string_1 = expression.toString();
    String _plus = (_string_1 + " / ");
    String _plus_1 = (_plus + type);
    String _identifier = type.getIdentifier();
    Assert.assertNotNull(_plus_1, _identifier);
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
