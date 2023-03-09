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

import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationResult;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API 
 * TODO JavaDoc, toString
 */
public class AnnotationValueTypeComputationState extends AbstractRootTypeComputationState {

	private final JvmAnnotationValue annotationValue;
	private final XExpression expression;

	public AnnotationValueTypeComputationState(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession,
			JvmAnnotationValue annotationValue, XExpression expression) {
		super(resolvedTypes, featureScopeSession);
		this.annotationValue = annotationValue;
		this.expression = expression;
	}

	@Override
	protected List<AbstractTypeExpectation> getExpectations(AbstractTypeComputationState actualState, boolean returnType) {
		LightweightTypeReference type = getExpectedType();
		AbstractTypeExpectation result = returnType ? new TypeExpectation(type, actualState, returnType) : new RootTypeExpectation(type, actualState);
		return Collections.singletonList(result);
	}

	@Override
	/* @Nullable */
	protected LightweightTypeReference getExpectedType() {
		JvmOperation operation = annotationValue.getOperation();
		LightweightTypeReference result = getResolvedTypes().getActualType(operation);
		if (result != null && result.isArray()) {
			return result.getComponentType();
		}
		return result;
	}

	@Override
	protected XExpression getRootExpression() {
		return expression;
	}
	
	@Override
	protected ITypeComputationResult createNoTypeResult() {
		return new NoTypeResult(annotationValue, resolvedTypes.getReferenceOwner());
	}
}
