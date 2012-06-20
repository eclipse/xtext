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
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeExpectation;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class ReturnExpectationTypeComputationState extends AbstractStackedTypeComputationState {

	protected ReturnExpectationTypeComputationState(
			ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession,
			DefaultReentrantTypeResolver reentrantTypeResolver,
			AbstractTypeComputationState parent) {
		super(resolvedTypes, featureScopeSession, reentrantTypeResolver, parent);
	}

	@Override
	public List<LightweightTypeExpectation> getImmediateExpectations(AbstractTypeComputationState actualState) {
		return getReturnExpectations(actualState);
	}

}
