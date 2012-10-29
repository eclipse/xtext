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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.junit.typesystem.PublicReentrantTypeResolver;
import org.eclipse.xtext.xbase.junit.typesystem.PublicResolvedTypes;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.eclipse.xtext.xbase.scoping.batch.IBatchScopeProvider;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.tests.typesystem.XbaseNewTypeSystemInjectorProvider;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.internal.ExpressionTypeComputationState;
import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.RootExpressionComputationState;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(value = XtextRunner.class)
@InjectWith(value = XbaseNewTypeSystemInjectorProvider.class)
@SuppressWarnings("all")
public class TypeComputationStateTest extends AbstractXbaseTestCase implements ITypeComputer {
  @Inject
  private PublicReentrantTypeResolver resolver;
  
  @Inject
  private ReflectExtensions _reflectExtensions;
  
  @Test
  public void testChildrenAddEntryForParent() {
    try {
      this.resolver.setTypeComputer(this);
      final XExpression expression = this.expression("{ null }");
      PublicResolvedTypes _publicResolvedTypes = new PublicResolvedTypes(this.resolver);
      final PublicResolvedTypes resolution = _publicResolvedTypes;
      ITypeReferenceOwner _referenceOwner = resolution.getReferenceOwner();
      AnyTypeReference _anyTypeReference = new AnyTypeReference(_referenceOwner);
      final AnyTypeReference any = _anyTypeReference;
      IBatchScopeProvider _batchScopeProvider = this.resolver.getBatchScopeProvider();
      Resource _eResource = expression.eResource();
      IFeatureScopeSession _newSession = _batchScopeProvider.newSession(_eResource);
      RootExpressionComputationState _rootExpressionComputationState = new RootExpressionComputationState(resolution, _newSession, expression, this.resolver, any);
      _rootExpressionComputationState.computeTypes();
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
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void computeTypes(final XExpression expression, final ITypeComputationState state) {
    try {
      Assert.assertTrue("state is instanceof ExpressionTypeComputationState", (state instanceof ExpressionTypeComputationState));
      List<? extends ITypeExpectation> _immediateExpectations = state.getImmediateExpectations();
      ITypeExpectation _head = IterableExtensions.head(_immediateExpectations);
      final LightweightTypeReference expectedType = _head.getExpectedType();
      Assert.assertTrue((expression instanceof XBlockExpression));
      EList<EObject> _eContents = expression.eContents();
      EObject _head_1 = IterableExtensions.<EObject>head(_eContents);
      final XNullLiteral nullLiteral = ((XNullLiteral) _head_1);
      state.computeTypes(nullLiteral);
      final ResolvedTypes resolution = this._reflectExtensions.<ResolvedTypes>get(state, "resolvedTypes");
      String _identifier = expectedType.getIdentifier();
      LightweightTypeReference _actualType = resolution.getActualType(nullLiteral);
      String _identifier_1 = _actualType.getIdentifier();
      Assert.assertEquals(_identifier, _identifier_1);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
