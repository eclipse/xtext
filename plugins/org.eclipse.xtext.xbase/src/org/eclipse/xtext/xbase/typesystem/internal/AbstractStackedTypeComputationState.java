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
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.computation.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public abstract class AbstractStackedTypeComputationState extends AbstractTypeComputationState {

	private final AbstractTypeComputationState parent;

	protected AbstractStackedTypeComputationState(TypeResolution typeResolution,
			DefaultReentrantTypeResolver reentrantTypeResolver, AbstractTypeComputationState parent) {
		super(typeResolution, reentrantTypeResolver);
		this.parent = parent;
		parent.addForkedState(this);
	}
	
	protected AbstractTypeComputationState getParent() {
		return parent;
	}
	
	@Override
	public List<ITypeExpectation> getImmediateExpectations(AbstractTypeComputationState actualState) {
		return getParent().getImmediateExpectations(actualState);
	}
	
	@Override
	public List<ITypeExpectation> getReturnExpectations(AbstractTypeComputationState actualState) {
		return getParent().getReturnExpectations(actualState);
	}
	
	@Override
	protected void acceptType(AbstractTypeExpectation expectation, JvmTypeReference type,
			ConformanceHint conformanceHint, boolean returnType) {
		getParent().acceptType(expectation, type, conformanceHint, returnType);
	}

}
