/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ResolvedImplicitReceiver extends ImplicitReceiver {
	
	public ResolvedImplicitReceiver(XAbstractFeatureCall featureCall, XAbstractFeatureCall implicitReceiver,
			ExpressionTypeComputationState state) {
		super(featureCall, implicitReceiver, state);
	}

	@Override
	public void applyToComputationState() {
		ResolvedTypes resolvedTypes = getState().getResolvedTypes();
		
		LightweightTypeReference actualType = resolvedTypes.getActualType(getFeature());
		if (actualType == null)
			throw new IllegalStateException("Cannot determine actual type of already resolved implicit receiver");
		LightweightTypeReference expectedReceiverType = new FeatureLinkHelper().getExpectedReceiverType(getOwner().getFeature(), actualType);
		if (expectedReceiverType != null)
			expectedReceiverType = expectedReceiverType.copyInto(resolvedTypes.getReferenceOwner());
		TypeExpectation expectation = new TypeExpectation(expectedReceiverType, getState(), false);
		resolvedTypes.acceptType(getFeatureCall(), expectation, actualType.copyInto(resolvedTypes.getReferenceOwner()), false, ConformanceFlags.UNCHECKED);
		super.applyToComputationState();
	}
	
	@Override
	public void applyToModel(IResolvedTypes resolvedTypes) {
		// nothing to do
	}

}
