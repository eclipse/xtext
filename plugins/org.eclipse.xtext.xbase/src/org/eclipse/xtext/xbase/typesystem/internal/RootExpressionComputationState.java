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
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class RootExpressionComputationState extends AbstractRootTypeComputationState {

	private final XExpression expression;
	private final JvmTypeReference expectedType;

	public RootExpressionComputationState(ResolvedTypes resolvedTypes, 
			IFeatureScopeSession featureScopeSession, XExpression expression,
			DefaultReentrantTypeResolver defaultReentrantTypeResolver) {
		this(resolvedTypes, featureScopeSession, expression, defaultReentrantTypeResolver, null);
	}
	
	public RootExpressionComputationState(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, XExpression expression,
			DefaultReentrantTypeResolver defaultReentrantTypeResolver, @Nullable JvmTypeReference expectedType) {
		super(resolvedTypes, featureScopeSession, defaultReentrantTypeResolver);
		this.expression = expression;
		this.expectedType = expectedType;
	}

	@Override
	protected List<ITypeExpectation> getExpectations(AbstractTypeComputationState actualState, boolean returnType) {
		ITypeExpectation result = null;
		if (expectedType != null) {
			result = returnType ? new TypeExpectation(expectedType, actualState, returnType) : new RootTypeExpectation(expectedType, actualState);
		} else {
			result = returnType ? new NoExpectation(actualState, returnType) : new RootNoExpectation(actualState);
		}
		return Collections.singletonList(result);
	}
	
	@Override
	protected XExpression getRootExpression() {
		return expression;
	}

}
