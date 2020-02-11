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

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationResult;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class ConstructorBodyComputationState extends AbstractLogicalContainerAwareRootComputationState {

	public ConstructorBodyComputationState(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmConstructor constructor) {
		super(resolvedTypes.pushExpectedExceptions(constructor), featureScopeSession, constructor);
		for(JvmFormalParameter parameter: constructor.getParameters()) {
			addLocalToCurrentScope(parameter);
		}
	}
	
	@Override
	protected List<AbstractTypeExpectation> getExpectations(AbstractTypeComputationState actualState, boolean returnType) {
		LightweightTypeReference voidType = getExpectedType();
		AbstractTypeExpectation result = returnType ? new TypeExpectation(voidType, actualState, returnType) : new RootTypeExpectation(voidType, actualState);
		return Collections.singletonList(result);
	}
	
	@Override
	protected LightweightTypeReference getExpectedType() {
		return getResolvedTypes().getReferenceOwner().toLightweightTypeReference(getTypeReferences().getTypeForName(Void.TYPE, getMember()));
	}
	
	@Override
	protected ITypeComputationResult createNoTypeResult() {
		return new NoTypeResult(getMember(), resolvedTypes.getReferenceOwner());
	}

}
