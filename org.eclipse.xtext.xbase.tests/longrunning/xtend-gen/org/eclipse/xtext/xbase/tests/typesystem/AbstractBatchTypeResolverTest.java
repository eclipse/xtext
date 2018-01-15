/**
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractTypeResolverTest;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public abstract class AbstractBatchTypeResolverTest extends AbstractTypeResolverTest<LightweightTypeReference> {
  @Override
  public LightweightTypeReference resolvesTo(final String expression, final String type) {
    try {
      final XExpression xExpression = this.expression(expression, false);
      Assert.assertTrue(xExpression.eResource().getErrors().toString(), xExpression.eResource().getErrors().isEmpty());
      Assert.assertTrue(xExpression.eResource().getWarnings().toString(), xExpression.eResource().getWarnings().isEmpty());
      final IResolvedTypes resolvedTypes = this.getTypeResolver().resolveTypes(xExpression);
      final LightweightTypeReference resolvedType = resolvedTypes.getActualType(xExpression);
      Assert.assertEquals(type, resolvedType.getSimpleName());
      Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(xExpression.eAllContents());
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
      Iterable<EObject> _iterable_1 = IteratorExtensions.<EObject>toIterable(xExpression.eAllContents());
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
            XExpression _implicitReceiver = ((XAbstractFeatureCall)content_1).getImplicitReceiver();
            boolean _tripleNotEquals = (_implicitReceiver != null);
            if (_tripleNotEquals) {
              Object _eGet_1 = ((XAbstractFeatureCall)content_1).getImplicitReceiver().eGet(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, false);
              final InternalEObject implicitFeature = ((InternalEObject) _eGet_1);
              Assert.assertNotNull(implicitFeature.toString(), feature);
              Assert.assertFalse(implicitFeature.toString(), feature.eIsProxy());
            }
          }
        }
      }
      Assert.assertTrue(this.getLinkingAndSyntaxErrors(xExpression.eResource()).toString(), IterableExtensions.isEmpty(this.getLinkingAndSyntaxErrors(xExpression.eResource())));
      Assert.assertTrue(xExpression.eResource().getWarnings().toString(), xExpression.eResource().getWarnings().isEmpty());
      return resolvedType;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public void isFunctionAndEquivalentTo(final LightweightTypeReference reference, final String type) {
    Assert.assertTrue((reference instanceof FunctionTypeReference));
    Assert.assertEquals(type, this.getEquivalent(((FunctionTypeReference) reference)));
  }
  
  public String getEquivalent(final ParameterizedTypeReference type) {
    StringConcatenation _builder = new StringConcatenation();
    String _simpleName = type.getType().getSimpleName();
    _builder.append(_simpleName);
    final Function1<LightweightTypeReference, CharSequence> _function = (LightweightTypeReference it) -> {
      return it.getSimpleName();
    };
    String _join = IterableExtensions.<LightweightTypeReference>join(type.getTypeArguments(), "<", ", ", ">", _function);
    _builder.append(_join);
    return _builder.toString();
  }
  
  public void assertExpressionTypeIsResolved(final XExpression expression, final IResolvedTypes types) {
    final LightweightTypeReference type = types.getActualType(expression);
    String _string = expression.toString();
    String _plus = ("Type is not resolved. Expression: " + _string);
    Assert.assertNotNull(_plus, type);
    String _string_1 = expression.toString();
    String _plus_1 = (_string_1 + " / ");
    String _plus_2 = (_plus_1 + type);
    Assert.assertNotNull(_plus_2, type.getIdentifier());
    final LightweightTypeReference expectedType = types.getExpectedType(expression);
    Assert.assertNotNull(expression.toString(), String.valueOf(expectedType));
  }
  
  public void assertIdentifiableTypeIsResolved(final JvmIdentifiableElement identifiable, final IResolvedTypes types) {
    final LightweightTypeReference type = types.getActualType(identifiable);
    Assert.assertNotNull(identifiable.toString(), type);
    String _string = identifiable.toString();
    String _plus = (_string + " / ");
    String _plus_1 = (_plus + type);
    Assert.assertNotNull(_plus_1, type.getIdentifier());
  }
  
  public abstract IBatchTypeResolver getTypeResolver();
  
  @Test
  public void testNull() throws Exception {
    final IResolvedTypes typeResolution = this.getTypeResolver().resolveTypes(((EObject) null));
    Assert.assertNotNull(typeResolution);
    Assert.assertEquals(IResolvedTypes.NULL, typeResolution);
  }
  
  @Test
  public void testProxy() throws Exception {
    final XFeatureCall proxy = XbaseFactory.eINSTANCE.createXFeatureCall();
    ((InternalEObject) proxy).eSetProxyURI(URI.createURI("path#fragment"));
    final IResolvedTypes typeResolution = this.getTypeResolver().resolveTypes(proxy);
    Assert.assertNotNull(typeResolution);
    Assert.assertEquals(IResolvedTypes.NULL, typeResolution);
  }
}
