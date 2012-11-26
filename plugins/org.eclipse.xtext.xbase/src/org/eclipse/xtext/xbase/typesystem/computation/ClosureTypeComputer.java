/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypes;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.DeferredTypeParameterHintCollector;
import org.eclipse.xtext.xbase.typesystem.util.ExpectationTypeParameterHintCollector;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByUnboundSubstitutor;

/**
 * Externalized strategy for closure type computation which allows for easier unit testing.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClosureTypeComputer {

	private final XClosure closure;
	private final ITypeComputationState state;
	
	private final CommonTypeComputationServices services;
	private final FunctionTypes functionTypes;
	private final ITypeExpectation expectation;
	
	private FunctionTypeReference expectedClosureType;
	private FunctionTypeReference resultClosureType;
	private JvmOperation operation;
	
	public ClosureTypeComputer(XClosure closure, ITypeExpectation expectation, ITypeComputationState state) {
		this.closure = closure;
		this.expectation = expectation;
		this.state = state;
		this.services = state.getReferenceOwner().getServices();
		this.functionTypes = services.getFunctionTypes();
	}
	
	public void computeTypes() {
		prepareComputation();
		if (operation == null || expectedClosureType == null) {
			throw new IllegalStateException("Cannot locate appropriate operation for " + closure); 
		}
		prepareResultType();
		if (resultClosureType == null) {
			throw new IllegalStateException("Cannot locate appropriate operation for " + closure); 
		}
		
		LightweightTypeReference expectedReturnType = expectedClosureType.getReturnType();
		if (expectedReturnType == null) {
			throw new IllegalStateException("expected return type may not be null");
		}
		ITypeAssigner typeAssigner = state.withRootExpectation(expectedReturnType).assignTypes();
		ITypeComputationState closureBodyTypeComputationState = getClosureBodyTypeComputationState(typeAssigner);
		ITypeComputationResult expressionResult = closureBodyTypeComputationState.computeTypes(closure.getExpression());
		
		processExpressionType(expressionResult);
		
		if (resultClosureType.getReturnType() == null)
			throw new IllegalStateException("Closure has no return type assigned");
		// TODO the hint is probably wrong - if we expect a native function type, demand conversion is not true
		expectation.acceptActualType(resultClosureType, ConformanceHint.DEMAND_CONVERSION, ConformanceHint.UNCHECKED); 
	}
	
	/**
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public void prepareComputation() {
		LightweightTypeReference expectedType = expectation.getExpectedType();
		if (expectedType == null) {
			expectedClosureType = functionTypes.createRawFunctionTypeRef(expectation.getReferenceOwner(), closure, closure.getFormalParameters().size(), false);
			operation = functionTypes.findImplementingOperation(expectedClosureType);
			initClosureType(expectedClosureType, operation);
		} else {
			operation = functionTypes.findImplementingOperation(expectedType);
			JvmType type = expectedType.getType();
			int closureParameterSize = closure.getFormalParameters().size();
			if (operation == null || operation.getParameters().size() != closureParameterSize || type == null) {
				expectedClosureType = functionTypes.createRawFunctionTypeRef(expectation.getReferenceOwner(), closure, closureParameterSize, false);
				operation = functionTypes.findImplementingOperation(expectedClosureType);
				initClosureType(expectedClosureType, operation);
			} else {
				expectedClosureType = initKnownClosureType(type, operation);
				deferredBindTypeArgument(expectedType, expectedClosureType);
			}
		}
		
	}
	
	protected void prepareResultType() {
		resultClosureType = new FunctionTypeReference(expectedClosureType.getOwner(), expectedClosureType.getType());
		for(LightweightTypeReference argument: expectedClosureType.getTypeArguments()) {
			resultClosureType.addTypeArgument(argument);
		}
	}

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public FunctionTypeReference getExpectedClosureType() {
		return expectedClosureType;
	}
	
	/**
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public FunctionTypeReference getResultClosureType() {
		return resultClosureType;
	}
	
	/**
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public JvmOperation getOperation() {
		return operation;
	}
	
	@NonNullByDefault
	protected FunctionTypeReference initKnownClosureType(JvmType type, JvmOperation operation) {
		ITypeReferenceOwner owner = expectation.getReferenceOwner();
		FunctionTypeReference result = new FunctionTypeReference(owner, type);
		OwnedConverter converter = new OwnedConverter(owner);
		TypeParameterByUnboundSubstitutor substitutor = new TypeParameterByUnboundSubstitutor(Collections.<JvmTypeParameter, LightweightMergedBoundTypeArgument>emptyMap(), owner) {
			@Override
			protected UnboundTypeReference createUnboundTypeReference(JvmTypeParameter type) {
				UnboundTypeReference result = expectation.createUnboundTypeReference(closure, type);
				return result;
			}
		};
		if (type instanceof JvmTypeParameterDeclarator) {
			List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) type).getTypeParameters();
			for(JvmTypeParameter typeParameter: typeParameters) {
				ParameterizedTypeReference parameterReference = new ParameterizedTypeReference(owner, typeParameter);
				LightweightTypeReference substituted = substitutor.substitute(parameterReference);
				result.addTypeArgument(substituted);
			}
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> definedMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(result);
			substitutor.enhanceMapping(definedMapping);
		}
		LightweightTypeReference declaredReturnType = converter.toLightweightReference(operation.getReturnType());
		for(JvmFormalParameter parameter: operation.getParameters()) {
			LightweightTypeReference lightweight = converter.toLightweightReference(parameter.getParameterType());
			LightweightTypeReference lowerBound = lightweight.getLowerBoundSubstitute();
			LightweightTypeReference substituted = substitutor.substitute(lowerBound);
			result.addParameterType(substituted);
		}
		LightweightTypeReference returnType = declaredReturnType;
		LightweightTypeReference substituted = substitutor.substitute(returnType);
		result.setReturnType(substituted);
		return result;
	}

	@NonNullByDefault
	protected void initClosureType(FunctionTypeReference result, JvmOperation operation) {
		ITypeReferenceOwner owner = result.getOwner();
		OwnedConverter converter = new OwnedConverter(owner);
		TypeParameterByUnboundSubstitutor substitutor = new TypeParameterByUnboundSubstitutor(Collections.<JvmTypeParameter, LightweightMergedBoundTypeArgument>emptyMap(), expectation.getReferenceOwner()) {
			@Override
			protected UnboundTypeReference createUnboundTypeReference(JvmTypeParameter type) {
				UnboundTypeReference result = expectation.createUnboundTypeReference(closure, type);
				return result;
			}
		};
		LightweightTypeReference declaredReturnType = converter.toLightweightReference(operation.getReturnType());
		for(JvmFormalParameter parameter: operation.getParameters()) {
			LightweightTypeReference lightweight = converter.toLightweightReference(parameter.getParameterType());
			LightweightTypeReference lowerBound = lightweight.getLowerBoundSubstitute();
			LightweightTypeReference substituted = substitutor.substitute(lowerBound);
			result.addParameterType(substituted);
			result.addTypeArgument(substituted);
		}
		LightweightTypeReference returnType = declaredReturnType;
		LightweightTypeReference substituted = substitutor.substitute(returnType);
		result.setReturnType(substituted);
		if (!returnType.isPrimitiveVoid()) {
			result.addTypeArgument(substituted);
		}
	}

	protected ITypeComputationState getClosureBodyTypeComputationState(ITypeAssigner typeAssigner) {
		List<LightweightTypeReference> operationParameterTypes = expectedClosureType.getParameterTypes();
		List<JvmFormalParameter> closureParameters = closure.getFormalParameters();
		
		// just in case we have more than 6 closure parameters
		int paramCount = Math.min(closureParameters.size(), operationParameterTypes.size());
		// TODO validate parameter count - check against operation if available
		for(int i = 0; i < paramCount; i++) {
			JvmFormalParameter closureParameter = closureParameters.get(i);
			final LightweightTypeReference operationParameterType = operationParameterTypes.get(i);
			if (closureParameter.getParameterType() != null) {
				final LightweightTypeReference closureParameterType = typeAssigner.toLightweightTypeReference(closureParameter.getParameterType());
				new DeferredTypeParameterHintCollector(expectation.getReferenceOwner()) {
					@Override
					@NonNullByDefault
					protected void addHint(UnboundTypeReference typeParameter, LightweightTypeReference reference) {
						LightweightTypeReference wrapped = reference.getWrapperTypeIfPrimitive();
						typeParameter.acceptHint(wrapped, BoundTypeArgumentSource.RESOLVED, getOrigin(), getExpectedVariance(), getActualVariance());
					}
				}.processPairedReferences(operationParameterType, closureParameterType);
				typeAssigner.assignType(closureParameter, closureParameterType);
				resultClosureType.addParameterType(closureParameterType);
			} else {
				typeAssigner.assignType(closureParameter, operationParameterType);
				resultClosureType.addParameterType(operationParameterType);
			}
		}
		for(int i = paramCount; i < closureParameters.size(); i++) {
			JvmFormalParameter closureParameter = closureParameters.get(i);
			JvmTypeReference parameterType = closureParameter.getParameterType();
			if (parameterType != null) {
				LightweightTypeReference lightweight = typeAssigner.toLightweightTypeReference(parameterType);
				typeAssigner.assignType(closureParameter, lightweight);
				resultClosureType.addParameterType(lightweight);
			} else {
				LightweightTypeReference objectType = typeAssigner.toLightweightTypeReference(services.getTypeReferences().getTypeForName(Object.class, closureParameter));
				typeAssigner.assignType(closureParameter, objectType);
				resultClosureType.addParameterType(objectType);
			}
		}
		return typeAssigner.getForkedState();
	}

	@NonNullByDefault
	protected void processExpressionType(ITypeComputationResult expressionResult) {
		LightweightTypeReference expressionResultType = expressionResult.getReturnType();
		if (expressionResultType == null || expressionResultType instanceof AnyTypeReference) {
			LightweightTypeReference returnType = expectedClosureType.getReturnType();
			if (returnType == null)
				throw new IllegalStateException("return type shall not be null");
			resultClosureType.setReturnType(returnType);
		} else {
			LightweightTypeReference expectedReturnType = expectedClosureType.getReturnType();
			if (expectedReturnType == null)
				throw new IllegalStateException("expected return type may not be null");
			if (!expressionResultType.isPrimitiveVoid())
				deferredBindTypeArgument(expectedReturnType, expressionResultType);
			if (expectedReturnType.isAssignableFrom(expressionResultType)) {
				resultClosureType.setReturnType(expressionResultType);
			} else {
				resultClosureType.setReturnType(expectedReturnType);
			}
		}
	}
	
	protected void deferredBindTypeArgument(LightweightTypeReference declared, LightweightTypeReference actual) {
		if (declared != null) { 
			ExpectationTypeParameterHintCollector collector = new ExpectationTypeParameterHintCollector(expectation.getReferenceOwner());
			collector.processPairedReferences(declared, actual);
		}
	}
	
}
