/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureNames;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnknownTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class UnknownClosureTypeHelper extends AbstractClosureTypeHelper {

	private List<JvmFormalParameter> implicitParameters;
	
	protected UnknownClosureTypeHelper(XClosure closure, ITypeExpectation expectation, ITypeComputationState state) {
		super(closure, expectation, state);
	}

	@Override
	protected void computeTypes() {
		ITypeAssigner typeAssigner = getState().withoutRootExpectation().assignTypes();
		ITypeComputationState closureBodyTypeComputationState = getClosureBodyTypeComputationState(typeAssigner);
		closureBodyTypeComputationState.computeTypes(getClosure().getExpression());
		
		getExpectation().acceptActualType(getExpectation().getReferenceOwner().newUnknownTypeReference(), ConformanceFlags.UNCHECKED);
	}

	/* @Nullable */
	@Override
	public FunctionTypeReference getExpectedClosureType() {
		return null;
	}

	/* @Nullable */
	@Override
	public JvmOperation getOperation() {
		return null;
	}

	protected ITypeComputationState getClosureBodyTypeComputationState(ITypeAssigner typeAssigner) {
		ITypeComputationState result = assignParameters(typeAssigner);
		result.withinScope(getClosure());
		return result;
	}
	
	@Override
	public List<JvmFormalParameter> getParameters() {
		XClosure closure = getClosure();
		if (closure.isExplicitSyntax()) {
			return closure.getDeclaredFormalParameters();
		}
		if (implicitParameters != null)
			return implicitParameters;
		return closure.getImplicitFormalParameters();
	}
	
	protected ITypeComputationState assignParameters(ITypeAssigner typeAssigner) {
		XClosure closure = getClosure();
		if (closure.isExplicitSyntax() || !closure.getImplicitFormalParameters().isEmpty()) {
			List<JvmFormalParameter> closureParameters = closure.getFormalParameters();
			int paramCount = closureParameters.size();
			for(int i = 0; i < paramCount; i++) {
				JvmFormalParameter closureParameter = closureParameters.get(i);
				if (closureParameter.getParameterType() != null) {
					final LightweightTypeReference closureParameterType = typeAssigner.toLightweightTypeReference(closureParameter.getParameterType());
					typeAssigner.assignType(closureParameter, closureParameterType);
				} else {
					UnknownTypeReference unknownType = typeAssigner.getReferenceOwner().newUnknownTypeReference();
					typeAssigner.assignType(closureParameter, unknownType);
				}
			}
			ITypeComputationState result = typeAssigner.getForkedState();
			return result;
		} else {
			JvmFormalParameter implicitParameter = TypesFactory.eINSTANCE.createJvmFormalParameter();
			implicitParameter.setName(IFeatureNames.IT.getFirstSegment());
			implicitParameters = Collections.singletonList(implicitParameter);
			typeAssigner.assignType(implicitParameter, typeAssigner.getReferenceOwner().newUnknownTypeReference());
			ITypeComputationState result = typeAssigner.getForkedState();
			return result;
		}
	}
}
