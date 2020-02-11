/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationResult;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class ExpressionBasedRootTypeComputationState extends AbstractRootTypeComputationState {

	private final XExpression expression;
	private final LightweightTypeReference expectedType;

	public ExpressionBasedRootTypeComputationState(ResolvedTypes resolvedTypes, 
			IFeatureScopeSession featureScopeSession, XExpression expression) {
		this(resolvedTypes, featureScopeSession, expression, null);
	}
	
	public ExpressionBasedRootTypeComputationState(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, XExpression expression, 
			/* @Nullable */ LightweightTypeReference expectedType) {
		super(resolvedTypes, featureScopeSession);
		this.expression = expression;
		this.expectedType = expectedType;
	}

	@Override
	protected List<AbstractTypeExpectation> getExpectations(AbstractTypeComputationState actualState, boolean returnType) {
		AbstractTypeExpectation result = null;
		if (expectedType != null) {
			result = returnType ? new TypeExpectation(expectedType, actualState, returnType) : new RootTypeExpectation(expectedType, actualState);
		} else {
			result = returnType ? new NoExpectation(actualState, returnType) : new RootNoExpectation(actualState, true);
		}
		return Collections.singletonList(result);
	}
	
	@Override
	protected XExpression getRootExpression() {
		return expression;
	}
	
	@Override
	/* @Nullable */
	protected LightweightTypeReference getExpectedType() {
		return expectedType;
	}
	
	@Override
	protected ITypeComputationResult createNoTypeResult() {
		return new NoTypeResult(null, resolvedTypes.getReferenceOwner());
	}

}
