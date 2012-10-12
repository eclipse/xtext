/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO Javadoc, toString
 */
@NonNullByDefault
public class ChildExpressionTypeCheckpointComputationState extends ExpressionTypeCheckpointComputationState {

	protected ChildExpressionTypeCheckpointComputationState(ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession, DefaultReentrantTypeResolver reentrantTypeResolver,
			ExpressionTypeComputationState parent, XExpression expression) {
		super(resolvedTypes, featureScopeSession, reentrantTypeResolver, parent, expression);
	}
	
	@Override
	protected LightweightTypeReference acceptType(ResolvedTypes resolvedTypes, AbstractTypeExpectation expectation,
			LightweightTypeReference type, boolean returnType, ConformanceHint... hints) {
		LightweightTypeReference actualType = super.acceptType(resolvedTypes, expectation, type, returnType, hints);
		getParent().acceptType(resolvedTypes, expectation, actualType, returnType, hints);
		return actualType;
	}
	
	@Override
	public TypeAssigner assignTypes() {
		final ExpressionTypeCheckpointComputationState state = new ChildExpressionTypeCheckpointComputationState(
				getResolvedTypes(), getFeatureScopeSession(), getResolver(), this, expression);
		return createTypeAssigner(state);
	}
	
	@Override
	public AbstractTypeComputationState withTypeCheckpoint() {
		return new ChildExpressionTypeCheckpointComputationState(getResolvedTypes(), getFeatureScopeSession(), getResolver(), this, expression);
	}

	@Override
	protected ExpressionTypeComputationState createExpressionComputationState(XExpression expression,
			StackedResolvedTypes typeResolution) {
		return new ChildExpressionTypeComputationState(typeResolution, getFeatureScopeSession(), getResolver(), this, expression);
	}
}
