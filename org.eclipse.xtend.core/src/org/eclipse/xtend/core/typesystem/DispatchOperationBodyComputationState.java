/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.typesystem;

import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.InferredTypeIndicator;
import org.eclipse.xtext.xbase.typesystem.internal.OperationBodyComputationState;
import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DispatchOperationBodyComputationState extends OperationBodyComputationState {

	private JvmOperation dispatcher;
	private LightweightTypeReference inheritedExpectedType;

	public DispatchOperationBodyComputationState(
			ResolvedTypes resolvedTypes, 
			IFeatureScopeSession featureScopeSession,
			JvmOperation operation,
			JvmOperation dispatcher,
			/* @Nullable */ LightweightTypeReference inheritedExpectedType) {
		super(resolvedTypes, featureScopeSession, operation);
		this.dispatcher = dispatcher;
		this.inheritedExpectedType = inheritedExpectedType;
	}
	
	@Override
	/* @Nullable */
	protected LightweightTypeReference getExpectedType() {
		LightweightTypeReference expectedType = super.getExpectedType();
		if (expectedType != null) {
			return expectedType;
		}
		if (dispatcher != null) {
			JvmOperation operation = (JvmOperation) getMember();
			if (!InferredTypeIndicator.isInferred(dispatcher.getReturnType())) {
				LightweightTypeReference result = getResolvedTypes().getActualType(dispatcher);
				if (result != null)
					InferredTypeIndicator.resolveTo(operation.getReturnType(), result.toJavaCompliantTypeReference());
				return result;
			}
		}
		return inheritedExpectedType;
	}

}
