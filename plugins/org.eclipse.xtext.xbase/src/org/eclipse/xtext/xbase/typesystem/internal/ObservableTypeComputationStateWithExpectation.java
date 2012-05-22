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
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.internal.ObservableTypeExpectation.Observer;
import org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class ObservableTypeComputationStateWithExpectation extends AbstractStackedTypeComputationState {

	private final IJvmTypeReferenceProvider expectedType;
	
	private final Observer observer;

	public ObservableTypeComputationStateWithExpectation(
			ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession,
			DefaultReentrantTypeResolver reentrantTypeResolver,
			AbstractTypeComputationState parent,
			IJvmTypeReferenceProvider expectedType,
			ObservableTypeExpectation.Observer observer) {
		super(resolvedTypes, featureScopeSession, reentrantTypeResolver, parent);
		this.expectedType = expectedType;
		this.observer = observer;
	}

	@Override
	public List<ITypeExpectation> getImmediateExpectations(AbstractTypeComputationState actualState) {
		ITypeExpectation result = createTypeExpectation(expectedType, actualState, false);
		return Collections.singletonList(result);
	}

	protected AbstractTypeExpectation createTypeExpectation(IJvmTypeReferenceProvider expectedType,
			AbstractTypeComputationState actualState, boolean returnType) {
		return new ObservableTypeExpectation(expectedType, actualState, returnType, observer);
	}

}
