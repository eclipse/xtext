/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
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
      Resource _eResource = xExpression.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      String _string = _errors.toString();
      Resource _eResource_1 = xExpression.eResource();
      EList<Resource.Diagnostic> _errors_1 = _eResource_1.getErrors();
      boolean _isEmpty = _errors_1.isEmpty();
      Assert.assertTrue(_string, _isEmpty);
      Resource _eResource_2 = xExpression.eResource();
      EList<Resource.Diagnostic> _warnings = _eResource_2.getWarnings();
      String _string_1 = _warnings.toString();
      Resource _eResource_3 = xExpression.eResource();
      EList<Resource.Diagnostic> _warnings_1 = _eResource_3.getWarnings();
      boolean _isEmpty_1 = _warnings_1.isEmpty();
      Assert.assertTrue(_string_1, _isEmpty_1);
      IBatchTypeResolver _typeResolver = this.getTypeResolver();
      final IResolvedTypes resolvedTypes = _typeResolver.resolveTypes(xExpression);
      final LightweightTypeReference resolvedType = resolvedTypes.getActualType(xExpression);
      String _simpleName = resolvedType.getSimpleName();
      Assert.assertEquals(type, _simpleName);
      TreeIterator<EObject> _eAllContents = xExpression.eAllContents();
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
      TreeIterator<EObject> _eAllContents_1 = xExpression.eAllContents();
      Iterable<EObject> _iterable_1 = IteratorExtensions.<EObject>toIterable(_eAllContents_1);
      for (final EObject content_1 : _iterable_1) {
        boolean _matched_1 = false;
        if (content_1 instanceof XConstructorCall) {
          _matched_1=true;
          Object _eGet = ((XConstructorCall)content_1).eGet(XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, false);
          final InternalEObject constructor = ((InternalEObject) _eGet);
          String _string_2 = ((XConstructorCall)content_1).toString();
          Assert.assertNotNull(_string_2, constructor);
          String _string_3 = ((XConstructorCall)content_1).toString();
          boolean _eIsProxy = constructor.eIsProxy();
          Assert.assertFalse(_string_3, _eIsProxy);
        }
        if (!_matched_1) {
          if (content_1 instanceof XAbstractFeatureCall) {
            _matched_1=true;
            Object _eGet = ((XAbstractFeatureCall)content_1).eGet(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, false);
            final InternalEObject feature = ((InternalEObject) _eGet);
            String _string_2 = ((XAbstractFeatureCall)content_1).toString();
            Assert.assertNotNull(_string_2, feature);
            String _string_3 = ((XAbstractFeatureCall)content_1).toString();
            boolean _eIsProxy = feature.eIsProxy();
            Assert.assertFalse(_string_3, _eIsProxy);
            XExpression _implicitReceiver = ((XAbstractFeatureCall)content_1).getImplicitReceiver();
            boolean _notEquals = (!Objects.equal(_implicitReceiver, null));
            if (_notEquals) {
              XExpression _implicitReceiver_1 = ((XAbstractFeatureCall)content_1).getImplicitReceiver();
              Object _eGet_1 = _implicitReceiver_1.eGet(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, false);
              final InternalEObject implicitFeature = ((InternalEObject) _eGet_1);
              String _string_4 = implicitFeature.toString();
              Assert.assertNotNull(_string_4, feature);
              String _string_5 = implicitFeature.toString();
              boolean _eIsProxy_1 = feature.eIsProxy();
              Assert.assertFalse(_string_5, _eIsProxy_1);
            }
          }
        }
      }
      Resource _eResource_4 = xExpression.eResource();
      Iterable<Resource.Diagnostic> _linkingAndSyntaxErrors = this.getLinkingAndSyntaxErrors(_eResource_4);
      String _string_2 = _linkingAndSyntaxErrors.toString();
      Resource _eResource_5 = xExpression.eResource();
      Iterable<Resource.Diagnostic> _linkingAndSyntaxErrors_1 = this.getLinkingAndSyntaxErrors(_eResource_5);
      boolean _isEmpty_2 = IterableExtensions.isEmpty(_linkingAndSyntaxErrors_1);
      Assert.assertTrue(_string_2, _isEmpty_2);
      Resource _eResource_6 = xExpression.eResource();
      EList<Resource.Diagnostic> _warnings_2 = _eResource_6.getWarnings();
      String _string_3 = _warnings_2.toString();
      Resource _eResource_7 = xExpression.eResource();
      EList<Resource.Diagnostic> _warnings_3 = _eResource_7.getWarnings();
      boolean _isEmpty_3 = _warnings_3.isEmpty();
      Assert.assertTrue(_string_3, _isEmpty_3);
      return resolvedType;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public void isFunctionAndEquivalentTo(final LightweightTypeReference reference, final String type) {
    Assert.assertTrue((reference instanceof FunctionTypeReference));
    String _equivalent = this.getEquivalent(((FunctionTypeReference) reference));
    Assert.assertEquals(type, _equivalent);
  }
  
  public String getEquivalent(final ParameterizedTypeReference type) {
    StringConcatenation _builder = new StringConcatenation();
    JvmType _type = type.getType();
    String _simpleName = _type.getSimpleName();
    _builder.append(_simpleName, "");
    List<LightweightTypeReference> _typeArguments = type.getTypeArguments();
    final Function1<LightweightTypeReference, CharSequence> _function = (LightweightTypeReference it) -> {
      return it.getSimpleName();
    };
    String _join = IterableExtensions.<LightweightTypeReference>join(_typeArguments, "<", ", ", ">", _function);
    _builder.append(_join, "");
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
    String _identifier = type.getIdentifier();
    Assert.assertNotNull(_plus_2, _identifier);
    final LightweightTypeReference expectedType = types.getExpectedType(expression);
    String _string_2 = expression.toString();
    String _valueOf = String.valueOf(expectedType);
    Assert.assertNotNull(_string_2, _valueOf);
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
  
  public abstract IBatchTypeResolver getTypeResolver();
  
  @Test
  public void testNull() throws Exception {
    IBatchTypeResolver _typeResolver = this.getTypeResolver();
    final IResolvedTypes typeResolution = _typeResolver.resolveTypes(((EObject) null));
    Assert.assertNotNull(typeResolution);
    Assert.assertEquals(IResolvedTypes.NULL, typeResolution);
  }
  
  @Test
  public void testProxy() throws Exception {
    final XFeatureCall proxy = XbaseFactory.eINSTANCE.createXFeatureCall();
    URI _createURI = URI.createURI("path#fragment");
    ((InternalEObject) proxy).eSetProxyURI(_createURI);
    IBatchTypeResolver _typeResolver = this.getTypeResolver();
    final IResolvedTypes typeResolution = _typeResolver.resolveTypes(proxy);
    Assert.assertNotNull(typeResolution);
    Assert.assertEquals(IResolvedTypes.NULL, typeResolution);
  }
}
