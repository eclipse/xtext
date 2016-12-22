/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.junit.typesystem.PublicReentrantTypeResolver;
import org.eclipse.xtext.xbase.junit.typesystem.PublicResolvedTypes;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.eclipse.xtext.xbase.scoping.batch.IBatchScopeProvider;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.internal.ExpressionBasedRootTypeComputationState;
import org.eclipse.xtext.xbase.typesystem.internal.ExpressionTypeComputationState;
import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.TypeData;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class TypeComputationStateTest extends AbstractXbaseTestCase implements ITypeComputer {
  @Inject
  private PublicReentrantTypeResolver resolver;
  
  @Inject
  @Extension
  private ReflectExtensions _reflectExtensions;
  
  @Test
  public void testChildrenAddEntryForParent() {
    try {
      this.resolver.setTypeComputer(this);
      final XExpression expression = this.expression("{ null }");
      this.resolver.initializeFrom(expression);
      final PublicResolvedTypes resolution = new PublicResolvedTypes(this.resolver);
      ITypeReferenceOwner _referenceOwner = resolution.getReferenceOwner();
      final AnyTypeReference any = _referenceOwner.newAnyTypeReference();
      IBatchScopeProvider _batchScopeProvider = this.resolver.getBatchScopeProvider();
      Resource _eResource = expression.eResource();
      IFeatureScopeSession _newSession = _batchScopeProvider.newSession(_eResource);
      ExpressionBasedRootTypeComputationState _expressionBasedRootTypeComputationState = new ExpressionBasedRootTypeComputationState(resolution, _newSession, expression, any);
      _expressionBasedRootTypeComputationState.computeTypes();
      Assert.assertEquals(any.toString(), resolution.getActualType(expression).toString());
      Assert.assertEquals(any.toString(), resolution.getActualType(((XNullLiteral) IterableExtensions.<EObject>head(expression.eContents()))).toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTypeOnlyRegisteredOnce_01() {
    try {
      this.resolver.setTypeComputer(this);
      final XExpression expression = this.expression("{ null }");
      this.resolver.initializeFrom(expression);
      final PublicResolvedTypes resolution = new PublicResolvedTypes(this.resolver);
      ITypeReferenceOwner _referenceOwner = resolution.getReferenceOwner();
      final AnyTypeReference any = _referenceOwner.newAnyTypeReference();
      IBatchScopeProvider _batchScopeProvider = this.resolver.getBatchScopeProvider();
      Resource _eResource = expression.eResource();
      IFeatureScopeSession _newSession = _batchScopeProvider.newSession(_eResource);
      ExpressionBasedRootTypeComputationState _expressionBasedRootTypeComputationState = new ExpressionBasedRootTypeComputationState(resolution, _newSession, expression, any);
      _expressionBasedRootTypeComputationState.computeTypes();
      final Map<XExpression, List<TypeData>> expressionTypes = resolution.basicGetExpressionTypes();
      EList<XExpression> _expressions = ((XBlockExpression) expression).getExpressions();
      XExpression _head = IterableExtensions.<XExpression>head(_expressions);
      final List<TypeData> typesForNullLiteral = expressionTypes.get(_head);
      Assert.assertEquals(typesForNullLiteral.toString(), 1, IterableExtensions.size(IterableExtensions.<TypeData>filter(typesForNullLiteral, ((Function1<TypeData, Boolean>) (TypeData it) -> {
        return Boolean.valueOf(it.isReturnType());
      }))));
      Assert.assertEquals(typesForNullLiteral.toString(), 1, IterableExtensions.size(IterableExtensions.<TypeData>filter(typesForNullLiteral, ((Function1<TypeData, Boolean>) (TypeData it) -> {
        boolean _isReturnType = it.isReturnType();
        return Boolean.valueOf((!_isReturnType));
      }))));
      final List<TypeData> typesForBlock = expressionTypes.get(expression);
      Assert.assertEquals(typesForBlock.toString(), 1, IterableExtensions.size(IterableExtensions.<TypeData>filter(typesForBlock, ((Function1<TypeData, Boolean>) (TypeData it) -> {
        return Boolean.valueOf(it.isReturnType());
      }))));
      Assert.assertEquals(typesForBlock.toString(), 1, IterableExtensions.size(IterableExtensions.<TypeData>filter(typesForBlock, ((Function1<TypeData, Boolean>) (TypeData it) -> {
        boolean _isReturnType = it.isReturnType();
        return Boolean.valueOf((!_isReturnType));
      }))));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTypeOnlyRegisteredOnce_02() {
    try {
      XExpression _expression = this.expression("1.toString");
      final XMemberFeatureCall expression = ((XMemberFeatureCall) _expression);
      this.resolver.initializeFrom(expression);
      final PublicResolvedTypes resolution = new PublicResolvedTypes(this.resolver);
      ITypeReferenceOwner _referenceOwner = resolution.getReferenceOwner();
      final AnyTypeReference any = _referenceOwner.newAnyTypeReference();
      IBatchScopeProvider _batchScopeProvider = this.resolver.getBatchScopeProvider();
      Resource _eResource = expression.eResource();
      IFeatureScopeSession _newSession = _batchScopeProvider.newSession(_eResource);
      ExpressionBasedRootTypeComputationState _expressionBasedRootTypeComputationState = new ExpressionBasedRootTypeComputationState(resolution, _newSession, expression, any);
      _expressionBasedRootTypeComputationState.computeTypes();
      final Map<XExpression, List<TypeData>> expressionTypes = resolution.basicGetExpressionTypes();
      TreeIterator<EObject> _eAllContents = expression.eAllContents();
      final Procedure1<EObject> _function = (EObject it) -> {
        final List<TypeData> types = expressionTypes.get(((XExpression) it));
        Assert.assertEquals(types.toString(), 1, IterableExtensions.size(IterableExtensions.<TypeData>filter(types, ((Function1<TypeData, Boolean>) (TypeData it_1) -> {
          boolean _isReturnType = it_1.isReturnType();
          return Boolean.valueOf((!_isReturnType));
        }))));
      };
      IteratorExtensions.<EObject>forEach(_eAllContents, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Ignore("TODO FixMe")
  @Test
  public void testTypeOnlyRegisteredOnce_03() {
    try {
      XExpression _expression = this.expression("<String>newArrayList.map[toUpperCase]");
      final XMemberFeatureCall expression = ((XMemberFeatureCall) _expression);
      this.resolver.initializeFrom(expression);
      final PublicResolvedTypes resolution = new PublicResolvedTypes(this.resolver);
      ITypeReferenceOwner _referenceOwner = resolution.getReferenceOwner();
      final AnyTypeReference any = _referenceOwner.newAnyTypeReference();
      IBatchScopeProvider _batchScopeProvider = this.resolver.getBatchScopeProvider();
      Resource _eResource = expression.eResource();
      IFeatureScopeSession _newSession = _batchScopeProvider.newSession(_eResource);
      ExpressionBasedRootTypeComputationState _expressionBasedRootTypeComputationState = new ExpressionBasedRootTypeComputationState(resolution, _newSession, expression, any);
      _expressionBasedRootTypeComputationState.computeTypes();
      final Map<XExpression, List<TypeData>> expressionTypes = resolution.basicGetExpressionTypes();
      TreeIterator<EObject> _eAllContents = expression.eAllContents();
      final Procedure1<EObject> _function = (EObject it) -> {
        final List<TypeData> typesForMemberFeatureCall = expressionTypes.get(((XExpression) it));
        String _plus = (it + " ");
        String _string = typesForMemberFeatureCall.toString();
        String _plus_1 = (_plus + _string);
        Assert.assertEquals(_plus_1, 1, IterableExtensions.size(IterableExtensions.<TypeData>filter(typesForMemberFeatureCall, ((Function1<TypeData, Boolean>) (TypeData it_1) -> {
          return Boolean.valueOf(it_1.isReturnType());
        }))));
        Assert.assertEquals(typesForMemberFeatureCall.toString(), 1, IterableExtensions.size(IterableExtensions.<TypeData>filter(typesForMemberFeatureCall, ((Function1<TypeData, Boolean>) (TypeData it_1) -> {
          boolean _isReturnType = it_1.isReturnType();
          return Boolean.valueOf((!_isReturnType));
        }))));
      };
      IteratorExtensions.<EObject>forEach(_eAllContents, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTypeOnlyRegisteredOnce_04() {
    try {
      XExpression _expression = this.expression("1");
      final XNumberLiteral expression = ((XNumberLiteral) _expression);
      this.resolver.initializeFrom(expression);
      final PublicResolvedTypes resolution = new PublicResolvedTypes(this.resolver);
      ITypeReferenceOwner _referenceOwner = resolution.getReferenceOwner();
      final AnyTypeReference any = _referenceOwner.newAnyTypeReference();
      IBatchScopeProvider _batchScopeProvider = this.resolver.getBatchScopeProvider();
      Resource _eResource = expression.eResource();
      IFeatureScopeSession _newSession = _batchScopeProvider.newSession(_eResource);
      ExpressionBasedRootTypeComputationState _expressionBasedRootTypeComputationState = new ExpressionBasedRootTypeComputationState(resolution, _newSession, expression, any);
      _expressionBasedRootTypeComputationState.computeTypes();
      final Map<XExpression, List<TypeData>> expressionTypes = resolution.basicGetExpressionTypes();
      TreeIterator<EObject> _eAllContents = expression.eAllContents();
      final Procedure1<EObject> _function = (EObject it) -> {
        final List<TypeData> types = expressionTypes.get(((XExpression) it));
        Assert.assertEquals(types.toString(), 1, IterableExtensions.size(IterableExtensions.<TypeData>filter(types, ((Function1<TypeData, Boolean>) (TypeData it_1) -> {
          boolean _isReturnType = it_1.isReturnType();
          return Boolean.valueOf((!_isReturnType));
        }))));
      };
      IteratorExtensions.<EObject>forEach(_eAllContents, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public void computeTypes(final XExpression expression, final ITypeComputationState state) {
    try {
      Assert.assertTrue("state is instanceof ExpressionTypeComputationState", (state instanceof ExpressionTypeComputationState));
      List<? extends ITypeExpectation> _expectations = state.getExpectations();
      ITypeExpectation _head = IterableExtensions.head(_expectations);
      final LightweightTypeReference expectedType = _head.getExpectedType();
      if ((expression instanceof XNullLiteral)) {
        final ExpressionTypeComputationState casted = ((ExpressionTypeComputationState) state);
        final ResolvedTypes resolution = this._reflectExtensions.<ResolvedTypes>get(casted, "resolvedTypes");
        ExpressionTypeComputationState _get = this._reflectExtensions.<ExpressionTypeComputationState>get(casted, "parent");
        final ResolvedTypes parentResolution = this._reflectExtensions.<ResolvedTypes>get(_get, "resolvedTypes");
        Assert.assertNull(parentResolution.getActualType(((XExpression) ((XNullLiteral)expression).eContainer())));
        state.acceptActualType(expectedType);
        Assert.assertNull(parentResolution.getActualType(expression));
        Assert.assertEquals(expectedType.getIdentifier(), resolution.getActualType(expression).getIdentifier());
        Assert.assertNull(parentResolution.getActualType(((XExpression) ((XNullLiteral)expression).eContainer())));
      } else {
        Assert.assertTrue((expression instanceof XBlockExpression));
        EList<EObject> _eContents = expression.eContents();
        EObject _head_1 = IterableExtensions.<EObject>head(_eContents);
        final XNullLiteral nullLiteral = ((XNullLiteral) _head_1);
        state.computeTypes(nullLiteral);
        final ResolvedTypes resolution_1 = this._reflectExtensions.<ResolvedTypes>get(state, "resolvedTypes");
        Assert.assertEquals(expectedType.getIdentifier(), resolution_1.getActualType(nullLiteral).getIdentifier());
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
