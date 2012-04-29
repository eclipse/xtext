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
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class TypeComputationStateWithExpectation extends AbstractStackedTypeComputationState {

	private final JvmTypeReference expectedType;

	protected TypeComputationStateWithExpectation(
			ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession,
			DefaultReentrantTypeResolver reentrantTypeResolver,
			AbstractTypeComputationState parent,
			@Nullable JvmTypeReference typeReference) {
		super(resolvedTypes, featureScopeSession, reentrantTypeResolver, parent);
		this.expectedType = typeReference;
	}

	@Override
	public List<ITypeExpectation> getImmediateExpectations(AbstractTypeComputationState actualState) {
		ITypeExpectation result = createTypeExpectation(expectedType, actualState, false);
		return Collections.singletonList(result);
	}

}
