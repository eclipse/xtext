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
 * TODO JavaDoc, toString
 */
public class TypeCheckpointComputationState extends AbstractStackedTypeComputationState {

	protected TypeCheckpointComputationState(ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession,
			AbstractTypeComputationState parent) {
		super(resolvedTypes.pushReassigningTypes(), featureScopeSession, parent);
	}
	
	@Override
	protected LightweightTypeReference acceptType(ResolvedTypes types, AbstractTypeExpectation expectation,
			LightweightTypeReference type, boolean returnType, ConformanceHint... hints) {
		return getParent().acceptType(types, expectation, type, returnType, hints);
	}
	
	@Override
	protected LightweightTypeReference acceptType(XExpression alreadyHandled, ResolvedTypes types,
			AbstractTypeExpectation expectation, LightweightTypeReference type, boolean returnType,
			ConformanceHint... hints) {
		return getParent().acceptType(alreadyHandled, types, expectation, type, returnType, hints);
	}

}
