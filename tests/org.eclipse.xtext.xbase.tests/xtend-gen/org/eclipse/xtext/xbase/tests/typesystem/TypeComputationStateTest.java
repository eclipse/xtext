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
      String _string = any.toString();
      LightweightTypeReference _actualType = resolution.getActualType(expression);
      String _string_1 = _actualType.toString();
      Assert.assertEquals(_string, _string_1);
      String _string_2 = any.toString();
      EList<EObject> _eContents = expression.eContents();
      EObject _head = IterableExtensions.<EObject>head(_eContents);
      LightweightTypeReference _actualType_1 = resolution.getActualType(((XNullLiteral) _head));
      String _string_3 = _actualType_1.toString();
      Assert.assertEquals(_string_2, _string_3);
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
      String _string = typesForNullLiteral.toString();
      final Function1<TypeData, Boolean> _function = (TypeData it) -> {
        return Boolean.valueOf(it.isReturnType());
      };
      Iterable<TypeData> _filter = IterableExtensions.<TypeData>filter(typesForNullLiteral, _function);
      int _size = IterableExtensions.size(_filter);
      Assert.assertEquals(_string, 1, _size);
      String _string_1 = typesForNullLiteral.toString();
      final Function1<TypeData, Boolean> _function_1 = (TypeData it) -> {
        boolean _isReturnType = it.isReturnType();
        return Boolean.valueOf((!_isReturnType));
      };
      Iterable<TypeData> _filter_1 = IterableExtensions.<TypeData>filter(typesForNullLiteral, _function_1);
      int _size_1 = IterableExtensions.size(_filter_1);
      Assert.assertEquals(_string_1, 1, _size_1);
      final List<TypeData> typesForBlock = expressionTypes.get(expression);
      String _string_2 = typesForBlock.toString();
      final Function1<TypeData, Boolean> _function_2 = (TypeData it) -> {
        return Boolean.valueOf(it.isReturnType());
      };
      Iterable<TypeData> _filter_2 = IterableExtensions.<TypeData>filter(typesForBlock, _function_2);
      int _size_2 = IterableExtensions.size(_filter_2);
      Assert.assertEquals(_string_2, 1, _size_2);
      String _string_3 = typesForBlock.toString();
      final Function1<TypeData, Boolean> _function_3 = (TypeData it) -> {
        boolean _isReturnType = it.isReturnType();
        return Boolean.valueOf((!_isReturnType));
      };
      Iterable<TypeData> _filter_3 = IterableExtensions.<TypeData>filter(typesForBlock, _function_3);
      int _size_3 = IterableExtensions.size(_filter_3);
      Assert.assertEquals(_string_3, 1, _size_3);
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
        String _string = types.toString();
        final Function1<TypeData, Boolean> _function_1 = (TypeData it_1) -> {
          boolean _isReturnType = it_1.isReturnType();
          return Boolean.valueOf((!_isReturnType));
        };
        Iterable<TypeData> _filter = IterableExtensions.<TypeData>filter(types, _function_1);
        int _size = IterableExtensions.size(_filter);
        Assert.assertEquals(_string, 1, _size);
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
        final Function1<TypeData, Boolean> _function_1 = (TypeData it_1) -> {
          return Boolean.valueOf(it_1.isReturnType());
        };
        Iterable<TypeData> _filter = IterableExtensions.<TypeData>filter(typesForMemberFeatureCall, _function_1);
        int _size = IterableExtensions.size(_filter);
        Assert.assertEquals(_plus_1, 1, _size);
        String _string_1 = typesForMemberFeatureCall.toString();
        final Function1<TypeData, Boolean> _function_2 = (TypeData it_1) -> {
          boolean _isReturnType = it_1.isReturnType();
          return Boolean.valueOf((!_isReturnType));
        };
        Iterable<TypeData> _filter_1 = IterableExtensions.<TypeData>filter(typesForMemberFeatureCall, _function_2);
        int _size_1 = IterableExtensions.size(_filter_1);
        Assert.assertEquals(_string_1, 1, _size_1);
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
        String _string = types.toString();
        final Function1<TypeData, Boolean> _function_1 = (TypeData it_1) -> {
          boolean _isReturnType = it_1.isReturnType();
          return Boolean.valueOf((!_isReturnType));
        };
        Iterable<TypeData> _filter = IterableExtensions.<TypeData>filter(types, _function_1);
        int _size = IterableExtensions.size(_filter);
        Assert.assertEquals(_string, 1, _size);
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
        EObject _eContainer = ((XNullLiteral)expression).eContainer();
        LightweightTypeReference _actualType = parentResolution.getActualType(((XExpression) _eContainer));
        Assert.assertNull(_actualType);
        state.acceptActualType(expectedType);
        LightweightTypeReference _actualType_1 = parentResolution.getActualType(expression);
        Assert.assertNull(_actualType_1);
        String _identifier = expectedType.getIdentifier();
        LightweightTypeReference _actualType_2 = resolution.getActualType(expression);
        String _identifier_1 = _actualType_2.getIdentifier();
        Assert.assertEquals(_identifier, _identifier_1);
        EObject _eContainer_1 = ((XNullLiteral)expression).eContainer();
        LightweightTypeReference _actualType_3 = parentResolution.getActualType(((XExpression) _eContainer_1));
        Assert.assertNull(_actualType_3);
      } else {
        Assert.assertTrue((expression instanceof XBlockExpression));
        EList<EObject> _eContents = expression.eContents();
        EObject _head_1 = IterableExtensions.<EObject>head(_eContents);
        final XNullLiteral nullLiteral = ((XNullLiteral) _head_1);
        state.computeTypes(nullLiteral);
        final ResolvedTypes resolution_1 = this._reflectExtensions.<ResolvedTypes>get(state, "resolvedTypes");
        String _identifier_2 = expectedType.getIdentifier();
        LightweightTypeReference _actualType_4 = resolution_1.getActualType(nullLiteral);
        String _identifier_3 = _actualType_4.getIdentifier();
        Assert.assertEquals(_identifier_2, _identifier_3);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
