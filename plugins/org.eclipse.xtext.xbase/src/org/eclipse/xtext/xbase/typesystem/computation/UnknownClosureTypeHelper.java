/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnknownTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class UnknownClosureTypeHelper extends AbstractClosureTypeHelper {

	protected UnknownClosureTypeHelper(XClosure closure, ITypeExpectation expectation, ITypeComputationState state) {
		super(closure, expectation, state);
	}

	@Override
	protected void computeTypes() {
		ITypeAssigner typeAssigner = getState().withoutRootExpectation().assignTypes();
		ITypeComputationState closureBodyTypeComputationState = getClosureBodyTypeComputationState(typeAssigner);
		closureBodyTypeComputationState.computeTypes(getClosure().getExpression());
		
		getExpectation().acceptActualType(new UnknownTypeReference(getExpectation().getReferenceOwner()), ConformanceHint.UNCHECKED);
	}

	@Nullable
	@Override
	public FunctionTypeReference getExpectedClosureType() {
		return null;
	}

	@Nullable
	@Override
	public JvmOperation getOperation() {
		return null;
	}

	protected ITypeComputationState getClosureBodyTypeComputationState(ITypeAssigner typeAssigner) {
		ITypeComputationState result = assignParameters(typeAssigner);
		result.withinScope(getClosure());
		return result;
	}

	protected ITypeComputationState assignParameters(ITypeAssigner typeAssigner) {
		List<JvmFormalParameter> closureParameters = getClosure().getFormalParameters();
		int paramCount = closureParameters.size();
		for(int i = 0; i < paramCount; i++) {
			JvmFormalParameter closureParameter = closureParameters.get(i);
			if (closureParameter.eContainingFeature() != XbasePackage.Literals.XCLOSURE__IMPLICIT_PARAMETER && closureParameter.getParameterType() != null) {
				final LightweightTypeReference closureParameterType = typeAssigner.toLightweightTypeReference(closureParameter.getParameterType());
				typeAssigner.assignType(closureParameter, closureParameterType);
			} else {
				typeAssigner.assignType(closureParameter, new UnknownTypeReference(typeAssigner.getReferenceOwner()));
			}
		}
		ITypeComputationState result = typeAssigner.getForkedState();
		return result;
	}
}
