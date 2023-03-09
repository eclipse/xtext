/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.InferredTypeIndicator;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationResult;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class OperationBodyComputationState extends AbstractLogicalContainerAwareRootComputationState {

	public OperationBodyComputationState(ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession,
			JvmOperation operation) {
		super(resolvedTypes.pushExpectedExceptions(operation), featureScopeSession, operation);
		for(JvmFormalParameter parameter: operation.getParameters()) {
			addLocalToCurrentScope(parameter);
		}
	}

	@Override
	protected List<AbstractTypeExpectation> getExpectations(AbstractTypeComputationState actualState, boolean returnType) {
		LightweightTypeReference type = getExpectedType();
		AbstractTypeExpectation result;
		if (type != null) {
			result = returnType ? new TypeExpectation(type, actualState, returnType) : new RootTypeExpectation(type, actualState);
		} else {
			result = returnType ? new NoExpectation(actualState, returnType) : new RootNoExpectation(actualState, true);
		}
		return Collections.singletonList(result);
	}
	
	@Override
	/* @Nullable */
	protected LightweightTypeReference getExpectedType() {
		JvmOperation operation = (JvmOperation) getMember();
		LightweightTypeReference expectedType = ((LogicalContainerAwareReentrantTypeResolver)getResolver()).getReturnTypeOfOverriddenOperation(operation, resolvedTypes, getFeatureScopeSession());
		if (expectedType != null) {
			InferredTypeIndicator.resolveTo(operation.getReturnType(), expectedType.toJavaCompliantTypeReference());
			return expectedType;
		}
		return getResolvedTypes().getExpectedTypeForAssociatedExpression(getMember(), getNonNullRootExpression());
	}
	
	@Override
	protected ITypeComputationResult createNoTypeResult() {
		JvmOperation operation = (JvmOperation) getMember();
		LightweightTypeReference expectedType = ((LogicalContainerAwareReentrantTypeResolver)getResolver()).getReturnTypeOfOverriddenOperation(operation, resolvedTypes, getFeatureScopeSession());
		if (expectedType != null) {
			InferredTypeIndicator.resolveTo(operation.getReturnType(), expectedType.toJavaCompliantTypeReference());
		}
		return new NoTypeResult(getMember(), resolvedTypes.getReferenceOwner());
	}
}
