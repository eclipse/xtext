/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ExpectedExceptionTypeComputationState extends AbstractStackedTypeComputationState {

	protected ExpectedExceptionTypeComputationState(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, AbstractTypeComputationState parent,
			List<LightweightTypeReference> exceptions) {
		super(resolvedTypes.pushExpectedExceptions(exceptions), featureScopeSession, parent);
	}
	
	@Override
	protected LightweightTypeReference acceptType(ResolvedTypes types, AbstractTypeExpectation expectation, LightweightTypeReference type, boolean returnType,
			int flags) {
		return getParent().acceptType(types, expectation, type, returnType, flags);
	}

	@Override
	protected LightweightTypeReference acceptType(XExpression alreadyHandled, ResolvedTypes types, AbstractTypeExpectation expectation,
			LightweightTypeReference type, boolean returnType, int flags) {
		return getParent().acceptType(alreadyHandled, types, expectation, type, returnType, flags);
	}

}
