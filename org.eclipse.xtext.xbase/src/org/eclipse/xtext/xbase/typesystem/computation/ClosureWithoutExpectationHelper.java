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
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureNames;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypes;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.DeferredTypeParameterHintCollector;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByUnboundSubstitutor;

/**
 * Strategy to compute types for lambda expression that do not have an expected type
 * or that have an expected type which is not a SAM type.
 * 
 * The type of the lamdba's body expression is computed without any constraints. After
 * the fact it is used to determine whether the lambda is a procedure or a function. 
 * 
 * @see ClosureWithExpectationHelper
 * @noinstantiate This class is not intended to be instantiated by clients.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClosureWithoutExpectationHelper extends AbstractClosureTypeHelper {

	private List<JvmFormalParameter> implicitParameters;
	private final FunctionTypes functionTypes;
	
	protected ClosureWithoutExpectationHelper(XClosure closure, ITypeExpectation expectation, ITypeComputationState state) {
		super(closure, expectation, state);
		this.functionTypes = getServices().getFunctionTypes();
	}
	
	@Override
	protected void computeTypes() {
		FunctionTypeReference incompleteClosureType = getFunctionTypeReference(true);
		
		ITypeAssigner typeAssigner = getState().withoutRootExpectation().assignTypes();
		ITypeComputationState closureBodyTypeComputationState = getClosureBodyTypeComputationState(typeAssigner, incompleteClosureType);
		ITypeComputationResult expressionResult = closureBodyTypeComputationState.computeTypes(getClosure().getExpression());
		
		FunctionTypeReference resultClosureType = processExpressionType(incompleteClosureType, expressionResult);
		getExpectation().acceptActualType(resultClosureType, ConformanceFlags.UNCHECKED);
	}
	
	@Override
	public FunctionTypeReference getExpectedClosureType() {
		return getFunctionTypeReference(true);
	}
	
	@Override
	public JvmOperation getOperation() {
		JvmOperation result = functionTypes.findImplementingOperation(getExpectedClosureType());
		if (result == null) {
			throw new IllegalStateException();
		}
		return result;
	}
	
	/**
	 * @noreference This method is not intended to be referenced by clients.
	 */
	protected FunctionTypeReference getFunctionTypeReference(boolean isProcedure) {
		XClosure closure = getClosure();
		ITypeReferenceOwner referenceOwner = getExpectation().getReferenceOwner();
		if (closure.isExplicitSyntax()) {
			int parameters = closure.getDeclaredFormalParameters().size();
			FunctionTypeReference result = functionTypes.createRawFunctionTypeRef(referenceOwner, closure, parameters, isProcedure);
			initClosureType(result, isProcedure);
			return result;	
		} else {
			FunctionTypeReference result = functionTypes.createRawFunctionTypeRef(referenceOwner, closure, 1, isProcedure);
			initClosureType(result, isProcedure);
			return result;
		}
	}
	
	protected void initClosureType(FunctionTypeReference result, boolean isProcedure) {
		ITypeReferenceOwner owner = result.getOwner();
		TypeParameterByUnboundSubstitutor substitutor = new TypeParameterByUnboundSubstitutor(Collections.<JvmTypeParameter, LightweightMergedBoundTypeArgument>emptyMap(), owner) {
			@Override
			protected UnboundTypeReference createUnboundTypeReference(JvmTypeParameter type) {
				UnboundTypeReference result = getExpectation().createUnboundTypeReference(getClosure(), type);
				return result;
			}
		};
		JvmGenericType type = (JvmGenericType) result.getType();
		List<JvmTypeParameter> typeParameters = type.getTypeParameters();
		int max = type.getTypeParameters().size();
		if (!isProcedure)
			max--;
		for(int i = 0; i < max; i++) {
			JvmTypeParameter typeParameter = typeParameters.get(i);
			LightweightTypeReference parameterType = owner.newParameterizedTypeReference(typeParameter);
			LightweightTypeReference substituted = substitutor.substitute(parameterType);
			result.addTypeArgument(substituted);
		}
		if (!isProcedure) {
			JvmTypeParameter typeParameter = typeParameters.get(max);
			LightweightTypeReference parameterType = owner.toLightweightTypeReference(typeParameter);
			LightweightTypeReference substituted = substitutor.substitute(parameterType);
			result.addTypeArgument(substituted);
		}
	}

	protected ITypeComputationState getClosureBodyTypeComputationState(ITypeAssigner typeAssigner, FunctionTypeReference incompleteClosureType) {
		ITypeComputationState result = assignParameters(typeAssigner, incompleteClosureType);
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
	
	protected ITypeComputationState assignParameters(ITypeAssigner typeAssigner, FunctionTypeReference incompleteClosureType) {
		List<LightweightTypeReference> operationParameterTypes = incompleteClosureType.getTypeArguments();
		XClosure closure = getClosure();
		boolean explicit = closure.isExplicitSyntax();
		if (explicit || !closure.getImplicitFormalParameters().isEmpty()) {
			List<JvmFormalParameter> closureParameters;
			if (explicit) {
				closureParameters = closure.getDeclaredFormalParameters();
			} else {
				closureParameters = closure.getImplicitFormalParameters();	
			}
			// just in case we have more than 6 closure parameters
			int paramCount = Math.min(closureParameters.size(), operationParameterTypes.size());
			// TODO validate parameter count - check against operation if available
			for(int i = 0; i < paramCount; i++) {
				JvmFormalParameter closureParameter = closureParameters.get(i);
				final LightweightTypeReference operationParameterType = operationParameterTypes.get(i);
				if (explicit && closureParameter.getParameterType() != null) {
					final LightweightTypeReference closureParameterType = typeAssigner.toLightweightTypeReference(closureParameter.getParameterType());
					new DeferredTypeParameterHintCollector(getExpectation().getReferenceOwner()) {
						@Override
						protected void addHint(UnboundTypeReference typeParameter, LightweightTypeReference reference) {
							LightweightTypeReference wrapped = reference.getWrapperTypeIfPrimitive();
							typeParameter.acceptHint(wrapped, BoundTypeArgumentSource.RESOLVED, getOrigin(), getExpectedVariance(), getActualVariance());
						}
					}.processPairedReferences(operationParameterType, closureParameterType);
					typeAssigner.assignType(closureParameter, closureParameterType);
					incompleteClosureType.addParameterType(closureParameterType);
				} else {
					typeAssigner.assignType(closureParameter, operationParameterType);
					incompleteClosureType.addParameterType(operationParameterType);
				}
			}
			for(int i = paramCount; i < closureParameters.size(); i++) {
				JvmFormalParameter closureParameter = closureParameters.get(i);
				JvmTypeReference parameterType = closureParameter.getParameterType();
				if (parameterType != null) {
					LightweightTypeReference lightweight = typeAssigner.toLightweightTypeReference(parameterType);
					typeAssigner.assignType(closureParameter, lightweight);
				} else {
					LightweightTypeReference objectType = typeAssigner.toLightweightTypeReference(getServices().getTypeReferences().getTypeForName(Object.class, closureParameter));
					typeAssigner.assignType(closureParameter, objectType);
				}
			}
			ITypeComputationState result = typeAssigner.getForkedState();
			return result;
		} else {
			if (operationParameterTypes.size() != 1) {
				throw new IllegalStateException();
			}
			JvmFormalParameter implicitParameter = TypesFactory.eINSTANCE.createJvmFormalParameter();
			implicitParameter.setName(IFeatureNames.IT.getFirstSegment());
			implicitParameters = Collections.singletonList(implicitParameter);
			LightweightTypeReference operationParameterType = operationParameterTypes.get(0);
			typeAssigner.assignType(implicitParameter, operationParameterType);
			incompleteClosureType.addParameterType(operationParameterType);
			ITypeComputationState result = typeAssigner.getForkedState();
			return result;
		}
	}

	protected FunctionTypeReference processExpressionType(FunctionTypeReference incompleteClosureType, ITypeComputationResult expressionResult) {
		LightweightTypeReference expressionResultType = expressionResult.getReturnType();
		if (expressionResultType == null || !expressionResultType.isPrimitiveVoid()) {
			FunctionTypeReference result = getFunctionTypeReference(false);
			LightweightTypeReference expectedReturnType = result.getTypeArguments().get(result.getTypeArguments().size() - 1);
			if (expressionResultType != null && !expressionResultType.isAny()) {
				result.setReturnType(expressionResultType);
				deferredBindTypeArgument(expectedReturnType, expressionResultType, BoundTypeArgumentSource.INFERRED);
			} else {
				LightweightTypeReference objectTypeReference = incompleteClosureType.getOwner().newReferenceToObject();
				result.setReturnType(objectTypeReference);
				deferredBindTypeArgument(expectedReturnType, objectTypeReference, BoundTypeArgumentSource.INFERRED);
			}
			List<LightweightTypeReference> incompleteParameterTypes = incompleteClosureType.getParameterTypes();
			for(int i = 0; i < incompleteParameterTypes.size(); i++) {
				result.addParameterType(incompleteParameterTypes.get(i));
			}
			List<LightweightTypeReference> incompleteTypeArguments = incompleteClosureType.getTypeArguments();
			List<LightweightTypeReference> resultTypeArguments = result.getTypeArguments();
			for(int i = 0; i < incompleteTypeArguments.size(); i++) {
				deferredBindTypeArgument(resultTypeArguments.get(i), incompleteTypeArguments.get(i), BoundTypeArgumentSource.INFERRED);
			}
			return result;
		} else {
			incompleteClosureType.setReturnType(expressionResultType);
			return incompleteClosureType;
		}
	}
	
}
