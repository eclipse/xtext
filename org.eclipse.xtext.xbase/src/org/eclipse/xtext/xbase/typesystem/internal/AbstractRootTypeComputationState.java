/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationResult;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public abstract class AbstractRootTypeComputationState extends AbstractTypeComputationState {
	
	protected AbstractRootTypeComputationState(ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession) {
		super(resolvedTypes, featureScopeSession);
	}
	
	public ITypeComputationResult computeTypes() {
		XExpression rootExpression = getRootExpression();
		if (rootExpression == null)
			return createNoTypeResult();
		return computeTypes(rootExpression);
	}
	
	protected abstract ITypeComputationResult createNoTypeResult();
	
	/* @Nullable */
	protected abstract XExpression getRootExpression();
	
	protected XExpression getNonNullRootExpression() {
		XExpression result = getRootExpression();
		if (result == null)
			throw new IllegalStateException("root expression was null");
		return result;
	}
	
	/* @Nullable */
	protected abstract LightweightTypeReference getExpectedType();
	
	@Override
	protected LightweightTypeReference acceptType(ResolvedTypes types, AbstractTypeExpectation expectation, LightweightTypeReference type, boolean returnType, int flags) {
		return types.acceptType(getNonNullRootExpression(), expectation, type, returnType, flags);
	}
	
	@Override
	protected LightweightTypeReference acceptType(XExpression alreadyHandled, ResolvedTypes types, AbstractTypeExpectation expectation, LightweightTypeReference type, boolean returnType, int flags) {
		if (alreadyHandled != getRootExpression())
			return types.acceptType(getNonNullRootExpression(), expectation, type, returnType, flags);
		return type;
	}
	
	@Override
	protected final List<AbstractTypeExpectation> getReturnExpectations(AbstractTypeComputationState actualState, boolean asActualExpectation) {
		return getExpectations(actualState, !asActualExpectation);
	}
	
	@Override
	protected final List<AbstractTypeExpectation> getExpectations(AbstractTypeComputationState actualState) {
		return getExpectations(actualState, false);
	}
	
	protected abstract List<AbstractTypeExpectation> getExpectations(AbstractTypeComputationState actualState, boolean returnType);
	
	@Override
	protected ExpressionTypeComputationState createExpressionComputationState(XExpression expression,
			StackedResolvedTypes typeResolution) {
		return new RootExpressionTypeComputationState(typeResolution, getFeatureScopeSession(), this, expression, getExpectedType());
	}
	
	@Override
	public TypeAssigner assignTypes() {
		TypeCheckpointComputationState state = new TypeCheckpointComputationState(getResolvedTypes(), getFeatureScopeSession(), this) {
			@Override
			protected ExpressionTypeComputationState createExpressionComputationState(XExpression expression,
					StackedResolvedTypes typeResolution) {
				return new RootExpressionTypeComputationState(typeResolution, getFeatureScopeSession(), this, expression, getExpectedType());
			}
		};
		return createTypeAssigner(state);
	}
	
}
