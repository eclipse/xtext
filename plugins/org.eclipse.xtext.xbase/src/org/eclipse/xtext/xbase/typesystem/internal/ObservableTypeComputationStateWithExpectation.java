/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.internal.ObservableTypeExpectation.Observer;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class ObservableTypeComputationStateWithExpectation extends TypeComputationStateWithExpectation {

	private final Observer observer;

	public ObservableTypeComputationStateWithExpectation(
			ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession,
			DefaultReentrantTypeResolver reentrantTypeResolver,
			AbstractTypeComputationState parent,
			JvmTypeReference typeReference,
			ObservableTypeExpectation.Observer observer) {
		super(resolvedTypes, featureScopeSession, reentrantTypeResolver, parent, typeReference);
		this.observer = observer;
	}

	@Override
	protected AbstractTypeExpectation createTypeExpectation(@Nullable JvmTypeReference expectedType,
			AbstractTypeComputationState actualState, boolean returnType) {
		return new ObservableTypeExpectation(expectedType, actualState, returnType, observer);
	}

}
