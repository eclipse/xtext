/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureNames;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.DeferredTypeParameterHintCollector;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByUnboundSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;

import com.google.common.collect.Lists;

/**
 * Strategy to compute types for lambda expression that do have an expected type.
 * 
 * @see ClosureWithoutExpectationHelper
 * @noinstantiate This class is not intended to be instantiated by clients.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class ClosureWithExpectationHelper extends AbstractClosureTypeHelper {

	private final JvmOperation operation;

	private FunctionTypeReference expectedClosureType;
	private FunctionTypeReference resultClosureType;

	private boolean validParameterTypes = true;

	protected ClosureWithExpectationHelper(XClosure closure, JvmOperation operation, ITypeExpectation expectation, ITypeComputationState state) {
		super(closure, expectation, state);
		this.operation = operation;
		if (operation == null || expectation.getExpectedType() == null) {
			throw new IllegalStateException("Cannot locate appropriate operation for " + getClosure());
		}
		prepareComputation();
	}

	@Override
	public JvmOperation getOperation() {
		return operation;
	}

	@Override
	public FunctionTypeReference getExpectedClosureType() {
		return expectedClosureType;
	}

	@Override
	protected void computeTypes() {
		prepareResultType();
		if (resultClosureType == null) {
			throw new IllegalStateException("Cannot locate appropriate operation for " + getClosure());
		}

		LightweightTypeReference expectedReturnType = expectedClosureType.getReturnType();
		if (expectedReturnType == null) {
			throw new IllegalStateException("expected return type may not be null");
		}
		ITypeAssigner typeAssigner = getState().withRootExpectation(expectedReturnType).assignTypes();
		ITypeComputationState closureBodyTypeComputationState = getClosureBodyTypeComputationState(typeAssigner);
		ITypeComputationResult expressionResult = closureBodyTypeComputationState.computeTypes(getClosure().getExpression());

		ConformanceHint hint = processExpressionType(expressionResult);

		if (resultClosureType.getReturnType() == null)
			throw new IllegalStateException("Closure has no return type assigned");
		if (!validParameterTypes || hint == ConformanceHint.INCOMPATIBLE) {
			if (hint == null)
				markIncompatibleParameterList();
			else if (validParameterTypes)
				markCompatibleParameterList();
			else
				markIncompatible();
		} else if (hint == ConformanceHint.LAMBDA_RAW_COMPATIBLE) {
			markRawCompatible();
		} else {
			markUncheckedValid();
		}
	}

	protected void markUncheckedValid() {
		getExpectation().acceptActualType(resultClosureType, ConformanceHint.UNCHECKED);
	}

	protected void markIncompatibleParameterList() {
		getExpectation().acceptActualType(resultClosureType, ConformanceHint.CHECKED, ConformanceHint.INCOMPATIBLE, ConformanceHint.SEALED);
	}
	
	protected void markCompatibleParameterList() {
		getExpectation().acceptActualType(resultClosureType, ConformanceHint.CHECKED, ConformanceHint.LAMBDA_PARAMETER_COMPATIBLE, ConformanceHint.SEALED);
	}

	protected void markIncompatible() {
		getExpectation().acceptActualType(resultClosureType, ConformanceHint.CHECKED, ConformanceHint.INCOMPATIBLE, ConformanceHint.PROPAGATED_TYPE,
				ConformanceHint.SEALED);
	}

	protected void markRawCompatible() {
		getExpectation().acceptActualType(resultClosureType, ConformanceHint.CHECKED, ConformanceHint.LAMBDA_RAW_COMPATIBLE, ConformanceHint.PROPAGATED_TYPE,
				ConformanceHint.SEALED);
	}

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 */
	protected void prepareComputation() {
		LightweightTypeReference expectedType = getExpectation().getExpectedType();
		if (expectedType == null) {
			throw new IllegalStateException();
		}
		JvmType type = expectedType.getType();
		if (type == null) {
			throw new IllegalStateException();
		}
		expectedClosureType = initKnownClosureType(type, operation);
		deferredBindTypeArgument(expectedType, expectedClosureType, BoundTypeArgumentSource.INFERRED_CONSTRAINT);
	}

	protected void prepareResultType() {
		resultClosureType = new FunctionTypeReference(expectedClosureType.getOwner(), expectedClosureType.getType());
		for (LightweightTypeReference argument : expectedClosureType.getTypeArguments()) {
			resultClosureType.addTypeArgument(argument);
		}
	}

	protected FunctionTypeReference initKnownClosureType(JvmType type, JvmOperation operation) {
		ITypeReferenceOwner owner = getExpectation().getReferenceOwner();
		FunctionTypeReference result = new FunctionTypeReference(owner, type);
		OwnedConverter converter = new OwnedConverter(owner);
		TypeParameterByUnboundSubstitutor substitutor = new TypeParameterByUnboundSubstitutor(
				Collections.<JvmTypeParameter, LightweightMergedBoundTypeArgument> emptyMap(), owner) {
			@Override
			protected UnboundTypeReference createUnboundTypeReference(JvmTypeParameter type) {
				UnboundTypeReference result = getExpectation().createUnboundTypeReference(getClosure(), type);
				return result;
			}
		};
		if (type instanceof JvmTypeParameterDeclarator) {
			List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) type).getTypeParameters();
			for (JvmTypeParameter typeParameter : typeParameters) {
				ParameterizedTypeReference parameterReference = new ParameterizedTypeReference(owner, typeParameter);
				LightweightTypeReference substituted = substitutor.substitute(parameterReference);
				result.addTypeArgument(substituted);
			}
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> definedMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(result);
			substitutor.enhanceMapping(definedMapping);
		}
		LightweightTypeReference declaredReturnType = converter.toLightweightReference(operation.getReturnType());
		for (JvmFormalParameter parameter : operation.getParameters()) {
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

	protected ITypeComputationState getClosureBodyTypeComputationState(ITypeAssigner typeAssigner) {
		List<LightweightTypeReference> operationParameterTypes = expectedClosureType.getParameterTypes();
		List<JvmFormalParameter> closureParameters = getClosure().getFormalParameters();

		validParameterTypes = closureParameters.size() == operationParameterTypes.size();

		// just in case we have more than 6 closure parameters
		int paramCount = Math.min(closureParameters.size(), operationParameterTypes.size());
		// TODO validate parameter count - check against operation if available
		for (int i = 0; i < paramCount; i++) {
			JvmFormalParameter closureParameter = closureParameters.get(i);
			final LightweightTypeReference operationParameterType = operationParameterTypes.get(i);
			if (closureParameter.eContainingFeature() != XbasePackage.Literals.XCLOSURE__IMPLICIT_PARAMETER && closureParameter.getParameterType() != null) {
				final LightweightTypeReference closureParameterType = typeAssigner.toLightweightTypeReference(closureParameter.getParameterType());
				new DeferredTypeParameterHintCollector(getExpectation().getReferenceOwner()) {
					@Override
					protected void addHint(UnboundTypeReference typeParameter, LightweightTypeReference reference) {
						LightweightTypeReference wrapped = reference.getWrapperTypeIfPrimitive();
						typeParameter.acceptHint(wrapped, BoundTypeArgumentSource.RESOLVED, getOrigin(), getExpectedVariance(), getActualVariance());
					}
				}.processPairedReferences(operationParameterType, closureParameterType);
				typeAssigner.assignType(closureParameter, closureParameterType);
				resultClosureType.addParameterType(closureParameterType);
				if (validParameterTypes && !operationParameterType.isAssignableFrom(closureParameterType)) {
					validParameterTypes = false;
				}
			} else {
				LightweightTypeReference partiallyResolved = new TypeParameterSubstitutor<Object>(
						Collections.<JvmTypeParameter, LightweightMergedBoundTypeArgument> emptyMap(), typeAssigner.getReferenceOwner()) {
					@Override
					protected Object createVisiting() {
						return new Object();
					}

					@Override
					protected LightweightTypeReference doVisitUnboundTypeReference(UnboundTypeReference reference, Object param) {
						if (reference.internalIsResolved()) {
							return super.doVisitUnboundTypeReference(reference, param);
						} else {
							List<LightweightBoundTypeArgument> hints = reference.getAllHints();
							for (LightweightBoundTypeArgument hint : hints) {
								if (hint.getSource() == BoundTypeArgumentSource.INFERRED) {
									reference.tryResolve();
									if (reference.internalIsResolved()) {
										return reference.accept(this, param);
									}
								}
							}
						}
						return reference;
					}

					@Override
					public LightweightTypeReference substitute(LightweightTypeReference original) {
						return original.accept(this, createVisiting());
					}
				}.substitute(operationParameterType);
				typeAssigner.assignType(closureParameter, partiallyResolved);
				resultClosureType.addParameterType(partiallyResolved);
			}
		}
		for (int i = paramCount; i < closureParameters.size(); i++) {
			JvmFormalParameter closureParameter = closureParameters.get(i);
			JvmTypeReference parameterType = closureParameter.getParameterType();
			if (parameterType != null) {
				LightweightTypeReference lightweight = typeAssigner.toLightweightTypeReference(parameterType);
				typeAssigner.assignType(closureParameter, lightweight);
				resultClosureType.addParameterType(lightweight);
			} else {
				LightweightTypeReference objectType = typeAssigner.toLightweightTypeReference(getServices().getTypeReferences().getTypeForName(Object.class,
						closureParameter));
				typeAssigner.assignType(closureParameter, objectType);
				resultClosureType.addParameterType(objectType);
			}
		}
		ITypeComputationState result = typeAssigner.getForkedState();
		LightweightTypeReference expectedType = getExpectation().getExpectedType();
		if (expectedType == null) {
			throw new IllegalStateException();
		}
		JvmType knownType = expectedType.getType();
		if (knownType != null && knownType instanceof JvmGenericType) {
			result.assignType(IFeatureNames.SELF, knownType, expectedType);
		}
		List<JvmTypeReference> exceptions = operation.getExceptions();
		if (exceptions.isEmpty())
			return result;
		List<LightweightTypeReference> expectedExceptions = Lists.newArrayListWithCapacity(exceptions.size());
		for (JvmTypeReference exception : exceptions) {
			expectedExceptions.add(typeAssigner.toLightweightTypeReference(exception));
		}
		return result.withExpectedExceptions(expectedExceptions);
	}

	/**
	 * Returns <code>true</code> if the expression result is definitely incompatible to the expected type.
	 */
	@Nullable
	protected ConformanceHint processExpressionType(ITypeComputationResult expressionResult) {
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
			if (!expressionResultType.isPrimitiveVoid()) {
				if (expectedReturnType.isPrimitiveVoid()) {
					resultClosureType.setReturnType(expectedReturnType);
					if (isImplicitReturn(expressionResult.getExpression())) {
						return null;
					} else {
						return ConformanceHint.INCOMPATIBLE;
					}
				} else {
					deferredBindTypeArgument(expectedReturnType, expressionResultType, BoundTypeArgumentSource.INFERRED);
				}
			}
			if (expectedReturnType.isAssignableFrom(expressionResultType)) {
				resultClosureType.setReturnType(expressionResultType);
			} else if (expectedReturnType.isPrimitiveVoid()) {
				resultClosureType.setReturnType(expectedReturnType);
				return ConformanceHint.INCOMPATIBLE;
			} else {
				resultClosureType.setReturnType(expectedReturnType);
				return ConformanceHint.LAMBDA_RAW_COMPATIBLE;
			}
		}
		return null;
	}

	protected boolean isImplicitReturn(@Nullable XExpression expression) {
		if (expression == null) {
			return true;
		}
		if (expression.eClass() == XbasePackage.Literals.XRETURN_EXPRESSION) {
			return false;
		}
		TreeIterator<EObject> contents = expression.eAllContents();
		while (contents.hasNext()) {
			EObject next = contents.next();
			if (next.eClass() == XbasePackage.Literals.XRETURN_EXPRESSION) {
				return false;
			}
			if (next.eClass() == XbasePackage.Literals.XCLOSURE) {
				contents.prune();
			}
		}
		return true;
	}
}
