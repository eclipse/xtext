/**
 * Copyright (c) 2012, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import static com.google.common.collect.Iterables.*;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.junit.typesystem.PublicReentrantTypeResolver;
import org.eclipse.xtext.xbase.junit.typesystem.PublicResolvedTypes;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.internal.ExpressionBasedRootTypeComputationState;
import org.eclipse.xtext.xbase.typesystem.internal.ExpressionTypeComputationState;
import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.TypeData;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeComputationStateTest extends AbstractXbaseTestCase implements ITypeComputer {
	@Inject
	private PublicReentrantTypeResolver resolver;

	@Inject
	private ReflectExtensions reflectExtensions;

	@Test
	public void testChildrenAddEntryForParent() throws Exception {
		resolver.setTypeComputer(this);
		XExpression expression = expression("{ null }");
		resolver.initializeFrom(expression);
		PublicResolvedTypes resolution = new PublicResolvedTypes(resolver);
		AnyTypeReference any = resolution.getReferenceOwner().newAnyTypeReference();
		new ExpressionBasedRootTypeComputationState(resolution, resolver.getBatchScopeProvider().newSession(expression.eResource()),
				expression, any).computeTypes();
		assertEquals(any.toString(), resolution.getActualType(expression).toString());
		assertEquals(any.toString(), resolution.getActualType(((XNullLiteral) getFirst(expression.eContents(), null))).toString());
	}

	@Test
	public void testTypeOnlyRegisteredOnce_01() throws Exception {
		resolver.setTypeComputer(this);
		XExpression expression = expression("{ null }");
		resolver.initializeFrom(expression);
		PublicResolvedTypes resolution = new PublicResolvedTypes(resolver);
		AnyTypeReference any = resolution.getReferenceOwner().newAnyTypeReference();
		new ExpressionBasedRootTypeComputationState(resolution, resolver.getBatchScopeProvider().newSession(expression.eResource()),
				expression, any).computeTypes();
		Map<XExpression, List<TypeData>> expressionTypes = resolution.basicGetExpressionTypes();
		List<TypeData> typesForNullLiteral = expressionTypes.get(getFirst(((XBlockExpression) expression).getExpressions(), null));
		assertEquals(typesForNullLiteral.toString(), 1, size(filter(typesForNullLiteral, it -> it.isReturnType())));
		assertEquals(typesForNullLiteral.toString(), 1, size(filter(typesForNullLiteral, it -> !it.isReturnType())));
		List<TypeData> typesForBlock = expressionTypes.get(expression);
		assertEquals(typesForBlock.toString(), 1, size(filter(typesForBlock, it -> it.isReturnType())));
		assertEquals(typesForBlock.toString(), 1, size(filter(typesForBlock, it -> !it.isReturnType())));
	}

	@Test
	public void testTypeOnlyRegisteredOnce_02() throws Exception {
		XMemberFeatureCall expression = ((XMemberFeatureCall) expression("1.toString"));
		resolver.initializeFrom(expression);
		PublicResolvedTypes resolution = new PublicResolvedTypes(resolver);
		AnyTypeReference any = resolution.getReferenceOwner().newAnyTypeReference();
		new ExpressionBasedRootTypeComputationState(resolution, resolver.getBatchScopeProvider().newSession(expression.eResource()),
				expression, any).computeTypes();
		Map<XExpression, List<TypeData>> expressionTypes = resolution.basicGetExpressionTypes();
		TreeIterator<EObject> allContents = expression.eAllContents();
		while (allContents.hasNext()) {
			EObject o = allContents.next();
			List<TypeData> types = expressionTypes.get(o);
			assertEquals(types.toString(), 1, size(filter(types, it -> !it.isReturnType())));
		}
	}

	@Ignore("TODO FixMe")
	@Test
	public void testTypeOnlyRegisteredOnce_03() throws Exception {
		XMemberFeatureCall expression = ((XMemberFeatureCall) expression("<String>newArrayList.map[toUpperCase]"));
		resolver.initializeFrom(expression);
		PublicResolvedTypes resolution = new PublicResolvedTypes(resolver);
		AnyTypeReference any = resolution.getReferenceOwner().newAnyTypeReference();
		new ExpressionBasedRootTypeComputationState(resolution, resolver.getBatchScopeProvider().newSession(expression.eResource()),
				expression, any).computeTypes();
		Map<XExpression, List<TypeData>> expressionTypes = resolution.basicGetExpressionTypes();
		TreeIterator<EObject> allContents = expression.eAllContents();
		while (allContents.hasNext()) {
			EObject o = allContents.next();
			List<TypeData> typesForMemberFeatureCall = expressionTypes.get((o));
			assertEquals(o + " " + typesForMemberFeatureCall.toString(), 1,
					IterableExtensions.size(filter(typesForMemberFeatureCall, it -> it.isReturnType())));
			assertEquals(typesForMemberFeatureCall.toString(), 1,
					IterableExtensions.size(filter(typesForMemberFeatureCall, it -> !it.isReturnType())));
		}
	}

	@Test
	public void testTypeOnlyRegisteredOnce_04() throws Exception {
		XNumberLiteral expression = ((XNumberLiteral) expression("1"));
		resolver.initializeFrom(expression);
		PublicResolvedTypes resolution = new PublicResolvedTypes(resolver);
		AnyTypeReference any = resolution.getReferenceOwner().newAnyTypeReference();
		new ExpressionBasedRootTypeComputationState(resolution, resolver.getBatchScopeProvider().newSession(expression.eResource()),
				expression, any).computeTypes();
		Map<XExpression, List<TypeData>> expressionTypes = resolution.basicGetExpressionTypes();
		TreeIterator<EObject> allContents = expression.eAllContents();
		while (allContents.hasNext()) {
			EObject o = allContents.next();
			List<TypeData> types = expressionTypes.get((o));
			assertEquals(types.toString(), 1, size(filter(types, it -> !it.isReturnType())));
		}
	}

	@Override
	public void computeTypes(XExpression expression, ITypeComputationState state) {
		try {
			assertTrue("state is instanceof ExpressionTypeComputationState", (state instanceof ExpressionTypeComputationState));
			ITypeExpectation firstExpectation = getFirst(state.getExpectations(), null);
			Assert.assertNotNull(firstExpectation);
			LightweightTypeReference expectedType = firstExpectation.getExpectedType();
			if (expression instanceof XNullLiteral) {
				ExpressionTypeComputationState casted = ((ExpressionTypeComputationState) state);
				ResolvedTypes resolution = reflectExtensions.get(casted, "resolvedTypes");
				ResolvedTypes parentResolution = reflectExtensions
						.get(reflectExtensions.<ExpressionTypeComputationState> get(casted, "parent"), "resolvedTypes");
				assertNull(parentResolution.getActualType(((XExpression) ((XNullLiteral) expression).eContainer())));
				state.acceptActualType(expectedType);
				assertNull(parentResolution.getActualType(expression));
				assertEquals(expectedType.getIdentifier(), resolution.getActualType(expression).getIdentifier());
				assertNull(parentResolution.getActualType(((XExpression) ((XNullLiteral) expression).eContainer())));
			} else {
				assertTrue((expression instanceof XBlockExpression));
				XNullLiteral nullLiteral = ((XNullLiteral) getFirst(expression.eContents(), null));
				state.computeTypes(nullLiteral);
				ResolvedTypes res = reflectExtensions.get(state, "resolvedTypes");
				assertEquals(expectedType.getIdentifier(), res.getActualType(nullLiteral).getIdentifier());
			}
		} catch (IllegalAccessException | SecurityException | NoSuchFieldException | IllegalArgumentException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}
}
