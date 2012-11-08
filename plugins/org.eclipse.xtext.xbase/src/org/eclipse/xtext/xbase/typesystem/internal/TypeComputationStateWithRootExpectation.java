/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class TypeComputationStateWithRootExpectation extends TypeComputationStateWithExpectation {

	protected TypeComputationStateWithRootExpectation(
			ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession,
			DefaultReentrantTypeResolver reentrantTypeResolver,
			AbstractTypeComputationState parent,
			@Nullable LightweightTypeReference typeReference) {
		super(resolvedTypes, featureScopeSession, reentrantTypeResolver, parent, typeReference);
	}
	
	@Override
	public List<AbstractTypeExpectation> getReturnExpectations(AbstractTypeComputationState actualState, boolean asActualExpectation) {
		AbstractTypeExpectation result = createTypeExpectation(getExpectedType(), actualState, !asActualExpectation);
		return Collections.singletonList(result);
	}
	
	@Override
	protected ExpressionTypeComputationState createExpressionComputationState(XExpression expression,
			StackedResolvedTypes typeResolution) {
		return new RootExpressionTypeComputationState(typeResolution, getFeatureScopeSession(), getResolver(), this, expression, getExpectedType());
	}
	
	@Override
	public TypeAssigner assignTypes() {
		TypeCheckpointComputationState state = new TypeCheckpointComputationState(getResolvedTypes(), getFeatureScopeSession(), getResolver(), this) {
			@Override
			protected ExpressionTypeComputationState createExpressionComputationState(XExpression expression,
					StackedResolvedTypes typeResolution) {
				return new RootExpressionTypeComputationState(typeResolution, getFeatureScopeSession(), getResolver(), this, expression, getExpectedType());
			}
		};
		return createTypeAssigner(state);
	}
	
}
