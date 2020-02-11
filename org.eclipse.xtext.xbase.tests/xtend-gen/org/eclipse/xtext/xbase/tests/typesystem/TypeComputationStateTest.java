/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer;
import org.eclipse.xtext.xbase.typesystem.internal.ExpressionBasedRootTypeComputationState;
import org.eclipse.xtext.xbase.typesystem.internal.ExpressionTypeComputationState;
import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.TypeData;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
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
      final AnyTypeReference any = resolution.getReferenceOwner().newAnyTypeReference();
      IFeatureScopeSession _newSession = this.resolver.getBatchScopeProvider().newSession(expression.eResource());
      new ExpressionBasedRootTypeComputationState(resolution, _newSession, expression, any).computeTypes();
      Assert.assertEquals(any.toString(), resolution.getActualType(expression).toString());
      EObject _head = IterableExtensions.<EObject>head(expression.eContents());
      Assert.assertEquals(any.toString(), resolution.getActualType(((XNullLiteral) _head)).toString());
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
      final AnyTypeReference any = resolution.getReferenceOwner().newAnyTypeReference();
      IFeatureScopeSession _newSession = this.resolver.getBatchScopeProvider().newSession(expression.eResource());
      new ExpressionBasedRootTypeComputationState(resolution, _newSession, expression, any).computeTypes();
      final Map<XExpression, List<TypeData>> expressionTypes = resolution.basicGetExpressionTypes();
      final List<TypeData> typesForNullLiteral = expressionTypes.get(IterableExtensions.<XExpression>head(((XBlockExpression) expression).getExpressions()));
      final Function1<TypeData, Boolean> _function = (TypeData it) -> {
        return Boolean.valueOf(it.isReturnType());
      };
      Assert.assertEquals(typesForNullLiteral.toString(), 1, IterableExtensions.size(IterableExtensions.<TypeData>filter(typesForNullLiteral, _function)));
      final Function1<TypeData, Boolean> _function_1 = (TypeData it) -> {
        boolean _isReturnType = it.isReturnType();
        return Boolean.valueOf((!_isReturnType));
      };
      Assert.assertEquals(typesForNullLiteral.toString(), 1, IterableExtensions.size(IterableExtensions.<TypeData>filter(typesForNullLiteral, _function_1)));
      final List<TypeData> typesForBlock = expressionTypes.get(expression);
      final Function1<TypeData, Boolean> _function_2 = (TypeData it) -> {
        return Boolean.valueOf(it.isReturnType());
      };
      Assert.assertEquals(typesForBlock.toString(), 1, IterableExtensions.size(IterableExtensions.<TypeData>filter(typesForBlock, _function_2)));
      final Function1<TypeData, Boolean> _function_3 = (TypeData it) -> {
        boolean _isReturnType = it.isReturnType();
        return Boolean.valueOf((!_isReturnType));
      };
      Assert.assertEquals(typesForBlock.toString(), 1, IterableExtensions.size(IterableExtensions.<TypeData>filter(typesForBlock, _function_3)));
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
      final AnyTypeReference any = resolution.getReferenceOwner().newAnyTypeReference();
      IFeatureScopeSession _newSession = this.resolver.getBatchScopeProvider().newSession(expression.eResource());
      new ExpressionBasedRootTypeComputationState(resolution, _newSession, expression, any).computeTypes();
      final Map<XExpression, List<TypeData>> expressionTypes = resolution.basicGetExpressionTypes();
      final Procedure1<EObject> _function = (EObject it) -> {
        final List<TypeData> types = expressionTypes.get(((XExpression) it));
        final Function1<TypeData, Boolean> _function_1 = (TypeData it_1) -> {
          boolean _isReturnType = it_1.isReturnType();
          return Boolean.valueOf((!_isReturnType));
        };
        Assert.assertEquals(types.toString(), 1, IterableExtensions.size(IterableExtensions.<TypeData>filter(types, _function_1)));
      };
      IteratorExtensions.<EObject>forEach(expression.eAllContents(), _function);
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
      final AnyTypeReference any = resolution.getReferenceOwner().newAnyTypeReference();
      IFeatureScopeSession _newSession = this.resolver.getBatchScopeProvider().newSession(expression.eResource());
      new ExpressionBasedRootTypeComputationState(resolution, _newSession, expression, any).computeTypes();
      final Map<XExpression, List<TypeData>> expressionTypes = resolution.basicGetExpressionTypes();
      final Procedure1<EObject> _function = (EObject it) -> {
        final List<TypeData> typesForMemberFeatureCall = expressionTypes.get(((XExpression) it));
        String _plus = (it + " ");
        String _string = typesForMemberFeatureCall.toString();
        String _plus_1 = (_plus + _string);
        final Function1<TypeData, Boolean> _function_1 = (TypeData it_1) -> {
          return Boolean.valueOf(it_1.isReturnType());
        };
        Assert.assertEquals(_plus_1, 1, IterableExtensions.size(IterableExtensions.<TypeData>filter(typesForMemberFeatureCall, _function_1)));
        final Function1<TypeData, Boolean> _function_2 = (TypeData it_1) -> {
          boolean _isReturnType = it_1.isReturnType();
          return Boolean.valueOf((!_isReturnType));
        };
        Assert.assertEquals(typesForMemberFeatureCall.toString(), 1, IterableExtensions.size(IterableExtensions.<TypeData>filter(typesForMemberFeatureCall, _function_2)));
      };
      IteratorExtensions.<EObject>forEach(expression.eAllContents(), _function);
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
      final AnyTypeReference any = resolution.getReferenceOwner().newAnyTypeReference();
      IFeatureScopeSession _newSession = this.resolver.getBatchScopeProvider().newSession(expression.eResource());
      new ExpressionBasedRootTypeComputationState(resolution, _newSession, expression, any).computeTypes();
      final Map<XExpression, List<TypeData>> expressionTypes = resolution.basicGetExpressionTypes();
      final Procedure1<EObject> _function = (EObject it) -> {
        final List<TypeData> types = expressionTypes.get(((XExpression) it));
        final Function1<TypeData, Boolean> _function_1 = (TypeData it_1) -> {
          boolean _isReturnType = it_1.isReturnType();
          return Boolean.valueOf((!_isReturnType));
        };
        Assert.assertEquals(types.toString(), 1, IterableExtensions.size(IterableExtensions.<TypeData>filter(types, _function_1)));
      };
      IteratorExtensions.<EObject>forEach(expression.eAllContents(), _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public void computeTypes(final XExpression expression, final ITypeComputationState state) {
    try {
      Assert.assertTrue("state is instanceof ExpressionTypeComputationState", (state instanceof ExpressionTypeComputationState));
      final LightweightTypeReference expectedType = IterableExtensions.head(state.getExpectations()).getExpectedType();
      if ((expression instanceof XNullLiteral)) {
        final ExpressionTypeComputationState casted = ((ExpressionTypeComputationState) state);
        final ResolvedTypes resolution = this._reflectExtensions.<ResolvedTypes>get(casted, "resolvedTypes");
        final ResolvedTypes parentResolution = this._reflectExtensions.<ResolvedTypes>get(this._reflectExtensions.<ExpressionTypeComputationState>get(casted, "parent"), "resolvedTypes");
        EObject _eContainer = ((XNullLiteral)expression).eContainer();
        Assert.assertNull(parentResolution.getActualType(((XExpression) _eContainer)));
        state.acceptActualType(expectedType);
        Assert.assertNull(parentResolution.getActualType(expression));
        Assert.assertEquals(expectedType.getIdentifier(), resolution.getActualType(expression).getIdentifier());
        EObject _eContainer_1 = ((XNullLiteral)expression).eContainer();
        Assert.assertNull(parentResolution.getActualType(((XExpression) _eContainer_1)));
      } else {
        Assert.assertTrue((expression instanceof XBlockExpression));
        EObject _head = IterableExtensions.<EObject>head(expression.eContents());
        final XNullLiteral nullLiteral = ((XNullLiteral) _head);
        state.computeTypes(nullLiteral);
        final ResolvedTypes resolution_1 = this._reflectExtensions.<ResolvedTypes>get(state, "resolvedTypes");
        Assert.assertEquals(expectedType.getIdentifier(), resolution_1.getActualType(nullLiteral).getIdentifier());
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
