/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.computation.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationResult;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public abstract class AbstractRootTypeComputationState extends AbstractTypeComputationState {
	
	protected AbstractRootTypeComputationState(ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession,
			DefaultReentrantTypeResolver reentrantTypeResolver) {
		super(resolvedTypes, featureScopeSession, reentrantTypeResolver);
	}
	
	public ITypeComputationResult computeTypes() {
		XExpression rootExpression = getRootExpression();
		return computeTypes(rootExpression);
	}
	
	@Nullable
	protected abstract XExpression getRootExpression();
	
	@Override
	protected JvmTypeReference acceptType(AbstractTypeExpectation expectation, JvmTypeReference type, ConformanceHint conformanceHint, boolean returnType) {
		return getResolvedTypes().acceptType(getRootExpression(), expectation, type, conformanceHint, returnType);
	}
	
	@Override
	protected final List<ITypeExpectation> getReturnExpectations(AbstractTypeComputationState actualState) {
		return getExpectations(actualState, true);
	}
	
	@Override
	protected final List<ITypeExpectation> getImmediateExpectations(AbstractTypeComputationState actualState) {
		return getExpectations(actualState, false);
	}
	
	protected abstract List<ITypeExpectation> getExpectations(AbstractTypeComputationState actualState, boolean returnType);
	
}
