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
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractReturnTypeTest;
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
public abstract class AbstractBatchReturnTypeTest extends AbstractReturnTypeTest<LightweightTypeReference> {
  @Override
  public LightweightTypeReference resolvesTo(final String expression, final String type) {
    try {
      final String replacedExpressionText = expression.replace("$$", "org::eclipse::xtext::xbase::lib::");
      final XExpression xExpression = this.expression(replacedExpressionText, false);
      Assert.assertTrue(xExpression.eResource().getErrors().toString(), xExpression.eResource().getErrors().isEmpty());
      Assert.assertTrue(xExpression.eResource().getWarnings().toString(), xExpression.eResource().getWarnings().isEmpty());
      final IResolvedTypes resolvedTypes = this.getTypeResolver().resolveTypes(xExpression);
      final LightweightTypeReference resolvedType = resolvedTypes.getReturnType(xExpression);
      Assert.assertEquals(replacedExpressionText, type, resolvedType.getSimpleName());
      Assert.assertTrue(this.getLinkingAndSyntaxErrors(xExpression.eResource()).toString(), IterableExtensions.isEmpty(this.getLinkingAndSyntaxErrors(xExpression.eResource())));
      Assert.assertTrue(xExpression.eResource().getWarnings().toString(), xExpression.eResource().getWarnings().isEmpty());
      return resolvedType;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void doResolvesTo(final String expression, final String type) {
    try {
      final XExpression parsedExpression = this.expression(expression, false);
      final IResolvedTypes resolvedTypes = this.getTypeResolver().resolveTypes(parsedExpression);
      final LightweightTypeReference resolvedType = resolvedTypes.getReturnType(parsedExpression);
      Assert.assertEquals(expression, type, resolvedType.getSimpleName());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean hasReturnExpression(final XExpression expression) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (expression instanceof XReturnExpression) {
      _matched=true;
      _switchResult = true;
    }
    if (!_matched) {
      if (expression instanceof XThrowExpression) {
        _matched=true;
        _switchResult = true;
      }
    }
    if (!_matched) {
      if (expression instanceof XClosure) {
        _matched=true;
        _switchResult = false;
      }
    }
    if (!_matched) {
      final Function1<EObject, Boolean> _function = (EObject content) -> {
        boolean _switchResult_1 = false;
        boolean _matched_1 = false;
        if (content instanceof XExpression) {
          _matched_1=true;
          _switchResult_1 = this.hasReturnExpression(((XExpression)content));
        }
        if (!_matched_1) {
          _switchResult_1 = false;
        }
        return Boolean.valueOf(_switchResult_1);
      };
      _switchResult = IterableExtensions.<EObject>exists(expression.eContents(), _function);
    }
    return _switchResult;
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
