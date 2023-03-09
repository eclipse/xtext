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

import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class TypeComputationStateWithExpectation extends AbstractStackedTypeComputationState {

	private final LightweightTypeReference expectedType;

	protected TypeComputationStateWithExpectation(
			ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession,
			AbstractTypeComputationState parent,
			/* @Nullable */ LightweightTypeReference typeReference) {
		super(resolvedTypes, featureScopeSession, parent);
		this.expectedType = typeReference;
	}

	@Override
	public List<AbstractTypeExpectation> getExpectations(AbstractTypeComputationState actualState) {
		AbstractTypeExpectation result = createTypeExpectation(expectedType, actualState, false);
		return Collections.singletonList(result);
	}
	
	protected AbstractTypeExpectation createTypeExpectation(/* @Nullable */ LightweightTypeReference expectedType, AbstractTypeComputationState actualState, boolean returnType) {
		AbstractTypeExpectation result = null;
		if (expectedType != null) {
			LightweightTypeReference copied = expectedType.copyInto(actualState.getReferenceOwner());
			result = new TypeExpectation(copied, actualState, returnType);
		} else {
			result = new NoExpectation(actualState, returnType);
		}
		return result;
	}
	
	protected LightweightTypeReference getExpectedType() {
		return expectedType;
	}
	
}
