/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeAssigner;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class ExpressionTypeComputationState extends AbstractStackedTypeComputationState {

	private final XExpression expression;

	protected ExpressionTypeComputationState(TypeResolution typeResolution,	
			DefaultReentrantTypeResolver reentrantTypeResolver, AbstractTypeComputationState parent,
			XExpression expression) {
		super(typeResolution, reentrantTypeResolver, parent);
		this.expression = expression;
	}

	@Override
	protected void acceptType(AbstractTypeExpectation expectation, JvmTypeReference type, ConformanceHint conformanceHint, boolean returnType) {
		getTypeResolution().acceptType(expression, expectation, type, conformanceHint, returnType);
	}

	@Override
	protected ExpressionTypeComputationState createExpressionComputationState(XExpression expression,
			StackedTypeResolution typeResolution) {
		return new ChildExpressionTypeComputationState(typeResolution, getResolver(), this, expression);
	}
	
	@Override
	public ITypeAssigner assignTypes() {
		final ExpressionTypeCheckpointComputationState state = new ExpressionTypeCheckpointComputationState(getTypeResolution(), getResolver(), this, expression);
		return createTypeAssigner(state);
	}
	
	@Override
	public ITypeComputationState withTypeCheckpoint() {
		return new ExpressionTypeCheckpointComputationState(getTypeResolution(), getResolver(), this, expression);
	}
	
	protected XExpression getExpression() {
		return expression;
	}
	
}
