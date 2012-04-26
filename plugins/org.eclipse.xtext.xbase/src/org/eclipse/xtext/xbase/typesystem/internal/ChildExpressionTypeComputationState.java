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
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class ChildExpressionTypeComputationState extends ExpressionTypeComputationState {

	protected ChildExpressionTypeComputationState(TypeResolution typeResolution,
			DefaultReentrantTypeResolver reentrantTypeResolver, 
			ExpressionTypeComputationState parent,
			XExpression expression) {
		super(typeResolution, reentrantTypeResolver, parent, expression);
	}
	
	@Override
	public List<ITypeExpectation> getImmediateExpectations(AbstractTypeComputationState actualState) {
		List<ITypeExpectation> parents = getParent().getImmediateExpectations();
		return wrapExpectations(parents, actualState, false);
	}

	@Override
	public List<ITypeExpectation> getReturnExpectations(AbstractTypeComputationState actualState) {
		List<ITypeExpectation> parents = getParent().getReturnExpectations();
		return wrapExpectations(parents, actualState, true);
	}
	
	protected List<ITypeExpectation> wrapExpectations(List<ITypeExpectation> parents, AbstractTypeComputationState actualState, boolean returnType) {
		List<ITypeExpectation> result = Lists.newArrayListWithCapacity(parents.size());
		for(ITypeExpectation delegate: parents) {
			result.add(new DelegatingTypeExpectation((AbstractTypeExpectation) delegate, actualState, returnType));
		}
		return result;
	}
}
