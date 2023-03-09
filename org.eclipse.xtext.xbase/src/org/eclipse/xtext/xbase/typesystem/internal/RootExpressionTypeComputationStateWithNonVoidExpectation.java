/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class RootExpressionTypeComputationStateWithNonVoidExpectation extends RootExpressionTypeComputationState {

	protected RootExpressionTypeComputationStateWithNonVoidExpectation(StackedResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession,
			AbstractTypeComputationState parent, XExpression expression, /* @Nullable */ LightweightTypeReference expectedType) {
		super(resolvedTypes, featureScopeSession, parent, expression, expectedType);
	}
	
	@Override
	protected AbstractTypeExpectation createTypeExpectation(/* @Nullable */ LightweightTypeReference expectedType, AbstractTypeComputationState actualState, boolean voidAllowed, boolean returnType) {
		return super.createTypeExpectation(expectedType, actualState, false, returnType);
	}

}
