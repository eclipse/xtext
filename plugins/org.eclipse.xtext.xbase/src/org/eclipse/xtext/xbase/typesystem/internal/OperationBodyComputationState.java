/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class OperationBodyComputationState extends AbstractLogicalContainerAwareRootComputationState {

	public OperationBodyComputationState(ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession,
			JvmOperation operation,
			LogicalContainerAwareReentrantTypeResolver reentrantTypeResolver) {
		super(resolvedTypes, featureScopeSession, operation, reentrantTypeResolver);
	}

	@Override
	protected List<AbstractTypeExpectation> getExpectations(AbstractTypeComputationState actualState, boolean returnType) {
		LightweightTypeReference type = getExpectedType();
		AbstractTypeExpectation result;
		if (type != null) {
			result = returnType ? new TypeExpectation(type, actualState, returnType) : new RootTypeExpectation(type, actualState);
		} else {
			result = returnType ? new NoExpectation(actualState, returnType) : new RootNoExpectation(actualState);
		}
		return Collections.singletonList(result);
	}
	
	@Override
	@Nullable
	protected LightweightTypeReference getExpectedType() {
		return getResolvedTypes().getActualType(getMember());
	}
}
