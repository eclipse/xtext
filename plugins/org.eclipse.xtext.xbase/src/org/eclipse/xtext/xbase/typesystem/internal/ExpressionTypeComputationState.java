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
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class ExpressionTypeComputationState extends AbstractStackedTypeComputationState {

	private final XExpression expression;

	protected ExpressionTypeComputationState(StackedResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession,
			DefaultReentrantTypeResolver reentrantTypeResolver, 
			AbstractTypeComputationState parent,
			XExpression expression) {
		super(resolvedTypes, featureScopeSession, reentrantTypeResolver, parent);
		this.expression = expression;
	}

	@Override
	protected LightweightTypeReference acceptType(ResolvedTypes resolvedTypes, AbstractTypeExpectation expectation, LightweightTypeReference type, boolean returnType, ConformanceHint... hints) {
		return resolvedTypes.acceptType(expression, expectation, type, returnType, hints);
	}

	@Override
	protected ExpressionTypeComputationState createExpressionComputationState(XExpression expression,
			StackedResolvedTypes typeResolution) {
		return new ChildExpressionTypeComputationState(typeResolution, getFeatureScopeSession(), getResolver(), this, expression);
	}
	
	@Override
	public TypeAssigner assignTypes() {
		final ExpressionTypeCheckpointComputationState state = new ExpressionTypeCheckpointComputationState(
				getResolvedTypes(), getFeatureScopeSession(), getResolver(), this, expression);
		return createTypeAssigner(state);
	}
	
	@Override
	public AbstractTypeComputationState withTypeCheckpoint() {
		return new ChildExpressionTypeCheckpointComputationState(getResolvedTypes(), getFeatureScopeSession(), getResolver(), this, expression);
	}
	
	protected XExpression getExpression() {
		return expression;
	}
	
	@Override
	protected StackedResolvedTypes getResolvedTypes() {
		return (StackedResolvedTypes) super.getResolvedTypes();
	}
	
}
