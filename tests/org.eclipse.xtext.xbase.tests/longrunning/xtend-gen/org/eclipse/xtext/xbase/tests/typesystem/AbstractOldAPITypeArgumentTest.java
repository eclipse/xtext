/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.impl.FeatureCallToJavaMapping;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractTypeArgumentTest;
import org.eclipse.xtext.xbase.tests.typesystem.FeatureCallRequest;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.junit.Assert;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public abstract class AbstractOldAPITypeArgumentTest extends AbstractTypeArgumentTest {
  @Inject
  private ILogicalContainerProvider logicalContainerProvider;
  
  @Inject
  private FeatureCallToJavaMapping featureCallToJavaMapping;
  
  protected void resolveTypes(final XExpression expression) {
  }
  
  protected void hasTypeArguments(final XExpression expression, final String... typeArguments) {
    boolean _matched = false;
    if (!_matched) {
      if (expression instanceof XAbstractFeatureCall) {
        _matched=true;
        this.hasTypeArguments(((XAbstractFeatureCall)expression), typeArguments);
      }
    }
    if (!_matched) {
      if (expression instanceof XConstructorCall) {
        _matched=true;
        this.hasTypeArguments(((XConstructorCall)expression), typeArguments);
      }
    }
    if (!_matched) {
      Assert.fail(("Unexpected expression: " + expression));
    }
  }
  
  public void hasTypeArguments(final XAbstractFeatureCall call, final String... typeArguments) {
    JvmIdentifiableElement _feature = call.getFeature();
    final JvmExecutable executable = ((JvmExecutable) _feature);
    final EList<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) executable).getTypeParameters();
    int _size = ((List<String>)Conversions.doWrapArray(typeArguments)).size();
    int _size_1 = typeParameters.size();
    Assert.assertEquals(_size, _size_1);
    final XExpression receiver = this.featureCallToJavaMapping.getActualReceiver(call);
    JvmTypeReference _xifexpression = null;
    boolean _notEquals = (!Objects.equal(receiver, null));
    if (_notEquals) {
      ITypeProvider _typeProvider = this.getTypeProvider();
      JvmTypeReference _type = _typeProvider.getType(receiver);
      _xifexpression = _type;
    }
    final JvmTypeReference receiverType = _xifexpression;
    ITypeProvider _typeProvider_1 = this.getTypeProvider();
    final JvmTypeReference expectedType = _typeProvider_1.getExpectedType(call);
    final List<JvmTypeReference> argumentTypes = CollectionLiterals.<JvmTypeReference>newArrayList();
    List<XExpression> _actualArguments = this.featureCallToJavaMapping.getActualArguments(call);
    for (final XExpression argument : _actualArguments) {
      ITypeProvider _typeProvider_2 = this.getTypeProvider();
      JvmTypeReference _type_1 = _typeProvider_2.getType(argument);
      argumentTypes.add(_type_1);
    }
    TypeArgumentContextProvider _typeArgumentContextProvider = this.getTypeArgumentContextProvider();
    FeatureCallRequest _featureCallRequest = new FeatureCallRequest(call, executable, receiverType, expectedType, argumentTypes, this.logicalContainerProvider);
    final ITypeArgumentContext typeArgumentContext = _typeArgumentContextProvider.getTypeArgumentContext(_featureCallRequest);
    final ArrayList<JvmTypeReference> actualTypeArguments = CollectionLiterals.<JvmTypeReference>newArrayList();
    final Procedure1<JvmTypeParameter> _function = new Procedure1<JvmTypeParameter>() {
      public void apply(final JvmTypeParameter it) {
        JvmTypeReference _boundArgument = typeArgumentContext.getBoundArgument(it);
        actualTypeArguments.add(_boundArgument);
      }
    };
    IterableExtensions.<JvmTypeParameter>forEach(typeParameters, _function);
    this.assertTypeArguments(typeArguments, actualTypeArguments);
  }
  
  public void assertTypeArguments(final String[] typeArguments, final List<JvmTypeReference> actualTypeArguments) {
    final Procedure2<String,Integer> _function = new Procedure2<String,Integer>() {
      public void apply(final String typeArgument, final Integer i) {
        final JvmTypeReference actualTypeArgument = actualTypeArguments.get((i).intValue());
        Assert.assertNotNull(typeArgument, actualTypeArgument);
        String _simpleName = actualTypeArgument.getSimpleName();
        Assert.assertEquals(typeArgument, _simpleName);
      }
    };
    IterableExtensions.<String>forEach(((Iterable<String>)Conversions.doWrapArray(typeArguments)), _function);
  }
  
  public void hasTypeArguments(final XConstructorCall call, final String... typeArguments) {
    ITypeProvider _typeProvider = this.getTypeProvider();
    JvmTypeReference _type = _typeProvider.getType(call);
    final JvmParameterizedTypeReference producedType = ((JvmParameterizedTypeReference) _type);
    final EList<JvmTypeReference> actualTypeArguments = producedType.getArguments();
    this.assertTypeArguments(typeArguments, actualTypeArguments);
  }
  
  protected abstract ITypeProvider getTypeProvider();
  
  protected abstract TypeArgumentContextProvider getTypeArgumentContextProvider();
}
