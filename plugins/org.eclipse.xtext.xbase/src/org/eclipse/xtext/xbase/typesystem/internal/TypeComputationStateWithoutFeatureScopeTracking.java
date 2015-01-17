/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeComputationStateWithoutFeatureScopeTracking extends AbstractStackedTypeComputationState {

	protected TypeComputationStateWithoutFeatureScopeTracking(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession,
			AbstractTypeComputationState parent) {
		super(resolvedTypes, featureScopeSession, parent);
	}
	
	@Override
	protected ExpressionAwareStackedResolvedTypes doComputeTypes(XExpression expression) {
		IFeatureScopeTracker orig = resolvedTypes.shared.featureScopeTracker;
		try {
			resolvedTypes.shared.featureScopeTracker = IFeatureScopeTracker.NULL;
			return super.doComputeTypes(expression);
		} finally {
			resolvedTypes.shared.featureScopeTracker = orig;
		}
	}

}
