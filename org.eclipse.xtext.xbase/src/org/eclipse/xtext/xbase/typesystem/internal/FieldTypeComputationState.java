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

import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationResult;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API 
 * TODO JavaDoc, toString
 */
public class FieldTypeComputationState extends AbstractLogicalContainerAwareRootComputationState {

	public FieldTypeComputationState(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession,
			JvmField field) {
		super(resolvedTypes, featureScopeSession, field);
	}

	@Override
	protected List<AbstractTypeExpectation> getExpectations(AbstractTypeComputationState actualState, boolean returnType) {
		LightweightTypeReference type = getExpectedType();
		AbstractTypeExpectation result = returnType 
				? new TypeExpectation(type, actualState, returnType)
				: new RootTypeExpectation(type, actualState);
		return Collections.singletonList(result);
	}

	@Override
	/* @Nullable */
	protected LightweightTypeReference getExpectedType() {
		return getResolvedTypes().getExpectedTypeForAssociatedExpression(getMember(), getNonNullRootExpression());
	}
	
	@Override
	protected ITypeComputationResult createNoTypeResult() {
		return new NoTypeResult(getMember(), resolvedTypes.getReferenceOwner());
	}
	
	@Override
	protected ExpressionTypeComputationState createExpressionComputationState(XExpression expression, StackedResolvedTypes typeResolution) {
		return new RootExpressionTypeComputationStateWithNonVoidExpectation(typeResolution, getFeatureScopeSession(), this, expression, getExpectedType());
		
	}
}
