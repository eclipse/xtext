/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
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
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ExpressionTypeComputationStateWithExpectation extends TypeComputationStateWithExpectation {
	
	protected ExpressionTypeComputationStateWithExpectation(ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession,
			AbstractTypeComputationState parent, 
			/* @Nullable */ LightweightTypeReference expectation) {
		super(resolvedTypes, featureScopeSession, parent, expectation);
	}

	@Override
	protected LightweightTypeReference acceptType(XExpression alreadyHandled, ResolvedTypes types,
			AbstractTypeExpectation expectation, LightweightTypeReference type, boolean returnType,
			int flags) {
		if (returnType) {
			getParent().acceptType(alreadyHandled, types, expectation, type, returnType, flags);
		}
		return super.acceptType(alreadyHandled, types, expectation, type, returnType, flags);
	}
}