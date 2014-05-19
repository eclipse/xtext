/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
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
			ConformanceHint... hints) {
		if (returnType) {
			getParent().acceptType(alreadyHandled, types, expectation, type, returnType, hints);
		}
		return super.acceptType(alreadyHandled, types, expectation, type, returnType, hints);
	}
}