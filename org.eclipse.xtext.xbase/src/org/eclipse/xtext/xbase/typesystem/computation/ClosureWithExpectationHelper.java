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
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureNames;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.ConstraintVisitingInfo;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.DeferredTypeParameterHintCollector;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByConstraintSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByUnboundSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;

import com.google.common.collect.Lists;

/**
 * Strategy to compute types for lambda expression that do have an expected type.
 * 
 * @see ClosureWithoutExpectationHelper
 * @noinstantiate This class is not intended to be instantiated by clients.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClosureWithExpectationHelper extends AbstractClosureTypeHelper {

	private final JvmOperation operation;
	
	private List<JvmFormalParameter> implicitParameters;
	private FunctionTypeReference expectedClosureType;
	private FunctionTypeReference resultClosureType;

	private boolean validParameterTypes = true;
	private boolean preferredSugar = false;

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

		int flags = processExpressionType(expressionResult);

		if (resultClosureType.getReturnType() == null)
			throw new IllegalStateException("Closure has no return type assigned");
		if (!validParameterTypes || flags == ConformanceFlags.INCOMPATIBLE) {
			if (flags == ConformanceFlags.NONE)
				markIncompatibleParameterList();
			else if (validParameterTypes)
				markCompatibleParameterList();
			else
				markIncompatible();
		} else if (flags == ConformanceFlags.LAMBDA_RAW_COMPATIBLE) {
			markRawCompatible();
		} else if (flags == ConformanceFlags.LAMBDA_VOID_COMPATIBLE) {
			markVoidCompatible();
		} else {
			markUncheckedValid();
		}
	}
	
	private void acceptActualType(int flags) {
		getExpectation().acceptActualType(resultClosureType, flags | ConformanceFlags.LAMBDA_WITH_EXPECTATION);
	}

	protected void markUncheckedValid() {
		if (preferredSugar) {
			acceptActualType(ConformanceFlags.UNCHECKED | ConformanceFlags.PREFERRED_LAMBDA_SUGAR);
		} else {
			acceptActualType(ConformanceFlags.UNCHECKED);
		}
	}

	protected void markIncompatibleParameterList() {
		if (preferredSugar) {
			acceptActualType(ConformanceFlags.CHECKED | ConformanceFlags.INCOMPATIBLE | ConformanceFlags.SEALED | ConformanceFlags.PREFERRED_LAMBDA_SUGAR);
		} else {
			acceptActualType(ConformanceFlags.CHECKED | ConformanceFlags.INCOMPATIBLE | ConformanceFlags.SEALED);
		}
	}

	protected void markCompatibleParameterList() {
		if (preferredSugar) {
			acceptActualType(ConformanceFlags.CHECKED | ConformanceFlags.LAMBDA_PARAMETER_COMPATIBLE | ConformanceFlags.SEALED | ConformanceFlags.PREFERRED_LAMBDA_SUGAR);
		} else {
			acceptActualType(ConformanceFlags.CHECKED | ConformanceFlags.LAMBDA_PARAMETER_COMPATIBLE | ConformanceFlags.SEALED);
		}
	}

	protected void markIncompatible() {
		if (preferredSugar) {
			acceptActualType(ConformanceFlags.CHECKED | ConformanceFlags.INCOMPATIBLE | ConformanceFlags.PROPAGATED_TYPE | ConformanceFlags.SEALED | ConformanceFlags.PREFERRED_LAMBDA_SUGAR);
		} else {
			acceptActualType(ConformanceFlags.CHECKED | ConformanceFlags.INCOMPATIBLE | ConformanceFlags.PROPAGATED_TYPE | ConformanceFlags.SEALED);
		}
	}

	protected void markRawCompatible() {
		if (preferredSugar) {
			acceptActualType(ConformanceFlags.CHECKED | ConformanceFlags.LAMBDA_RAW_COMPATIBLE |
					ConformanceFlags.PROPAGATED_TYPE | ConformanceFlags.SEALED | ConformanceFlags.PREFERRED_LAMBDA_SUGAR);
		} else {
			acceptActualType(ConformanceFlags.CHECKED | ConformanceFlags.LAMBDA_RAW_COMPATIBLE |
					ConformanceFlags.PROPAGATED_TYPE | ConformanceFlags.SEALED);
		}
	}

	protected void markVoidCompatible() {
		if (preferredSugar) {
			acceptActualType(ConformanceFlags.CHECKED_SUCCESS | ConformanceFlags.LAMBDA_VOID_COMPATIBLE |
					ConformanceFlags.PROPAGATED_TYPE | ConformanceFlags.SEALED | ConformanceFlags.PREFERRED_LAMBDA_SUGAR);
		} else {
			acceptActualType(ConformanceFlags.CHECKED_SUCCESS | ConformanceFlags.LAMBDA_VOID_COMPATIBLE |
					ConformanceFlags.PROPAGATED_TYPE | ConformanceFlags.SEALED);
		}
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
		} else if (type instanceof JvmTypeParameter) {
			type = operation.getDeclaringType();
		}
		expectedClosureType = initKnownClosureType(type, operation);
		deferredBindTypeArgument(expectedType, expectedClosureType, BoundTypeArgumentSource.INFERRED_CONSTRAINT);
	}

	protected void prepareResultType() {
		resultClosureType = expectedClosureType.getOwner().newFunctionTypeReference(expectedClosureType.getType());
		for (LightweightTypeReference argument : expectedClosureType.getTypeArguments()) {
			resultClosureType.addTypeArgument(argument);
		}
	}

	protected FunctionTypeReference initKnownClosureType(JvmType type, final JvmOperation operation) {
		ITypeReferenceOwner owner = getExpectation().getReferenceOwner();
		FunctionTypeReference result = owner.newFunctionTypeReference(type);
		TypeParameterByUnboundSubstitutor substitutor = new TypeParameterByUnboundSubstitutor(
				Collections.<JvmTypeParameter, LightweightMergedBoundTypeArgument> emptyMap(), owner) {
			@Override
			protected LightweightTypeReference getUnmappedSubstitute(ParameterizedTypeReference reference, JvmTypeParameter type,
					ConstraintVisitingInfo visiting) {
				if (type.getDeclarator() == operation) {
					return reference.copyInto(getOwner());
				}
				LightweightTypeReference result = createUnboundTypeReference(type);
				if (result == null) {
					result = new TypeParameterByConstraintSubstitutor(getTypeParameterMapping(), getOwner()).substitute(type);
				}
				return result;
			}
			
			@Override
			protected UnboundTypeReference createUnboundTypeReference(JvmTypeParameter type) {
				UnboundTypeReference result = getExpectation().createUnboundTypeReference(getClosure(), type);
				return result;
			}
		};
		if (type instanceof JvmTypeParameterDeclarator) {
			List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) type).getTypeParameters();
			for (JvmTypeParameter typeParameter : typeParameters) {
				LightweightTypeReference typeParameterReference = owner.newParameterizedTypeReference(typeParameter);
				LightweightTypeReference substituted = substitutor.substitute(typeParameterReference);
				result.addTypeArgument(substituted);
			}
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> definedMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(result);
			substitutor.enhanceMapping(definedMapping);
		}
		LightweightTypeReference declaredReturnType = owner.toLightweightTypeReference(operation.getReturnType());
		for (JvmFormalParameter parameter : operation.getParameters()) {
			LightweightTypeReference lightweight = owner.toLightweightTypeReference(parameter.getParameterType());
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
		ITypeComputationState result = assignParameters(typeAssigner);
		LightweightTypeReference expectedType = getExpectation().getExpectedType();
		if (expectedType == null) {
			throw new IllegalStateException();
		}
		JvmType knownType = expectedType.getType();
		if (knownType != null && knownType instanceof JvmGenericType) {
			result.assignType(IFeatureNames.SELF, knownType, expectedType);
		}
		List<JvmTypeReference> exceptions = operation.getExceptions();
		if (exceptions.isEmpty()) {
			result.withinScope(getClosure());
			return result;
		}
		List<LightweightTypeReference> expectedExceptions = Lists.newArrayListWithCapacity(exceptions.size());
		for (JvmTypeReference exception : exceptions) {
			expectedExceptions.add(typeAssigner.toLightweightTypeReference(exception));
		}
		result.withinScope(getClosure());
		return result.withExpectedExceptions(expectedExceptions);
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
		List<LightweightTypeReference> operationParameterTypes = expectedClosureType.getParameterTypes();
		XClosure closure = getClosure();
		List<JvmFormalParameter> closureParameters;
		boolean explicit = closure.isExplicitSyntax();
		if (explicit) {
			closureParameters = closure.getDeclaredFormalParameters();
		} else if (closure.getImplicitFormalParameters().isEmpty()) {
			implicitParameters = Lists.newArrayListWithCapacity(operationParameterTypes.size());
			for(int i = 0; i < operationParameterTypes.size(); i++) {
				JvmFormalParameter parameter = TypesFactory.eINSTANCE.createJvmFormalParameter();
				if (operationParameterTypes.size() == 1) {
					parameter.setName(IFeatureNames.IT.getFirstSegment());
					preferredSugar = true;
				} else {
					parameter.setName("$" + i);
				}
				implicitParameters.add(parameter);
			}
			closureParameters = implicitParameters;
		} else {
			closureParameters = closure.getImplicitFormalParameters();
			if (closureParameters.size() == 1) {
				preferredSugar = true;
			}
		}
		
		Object skippedHandle = null;
		LightweightTypeReference returnType = expectedClosureType.getReturnType();
		if (returnType.getKind() == LightweightTypeReference.KIND_UNBOUND_TYPE_REFERENCE) {
			skippedHandle = ((UnboundTypeReference) returnType).getHandle();
		}
		validParameterTypes = closureParameters.size() == operationParameterTypes.size();

		// just in case we have more than 6 closure parameters
		int paramCount = Math.min(closureParameters.size(), operationParameterTypes.size());
		boolean returnTypeIsArg = false;
		for (int i = 0; i < paramCount; i++) {
			JvmFormalParameter closureParameter = closureParameters.get(i);
			final LightweightTypeReference operationParameterType = operationParameterTypes.get(i);
			if (operationParameterType.getKind() == LightweightTypeReference.KIND_UNBOUND_TYPE_REFERENCE) {
				UnboundTypeReference casted = (UnboundTypeReference)operationParameterType;
				boolean isSkippedHandle = casted.getHandle().equals(skippedHandle);
				if (!isSkippedHandle && !casted.internalIsResolved() && casted.hasSignificantHints()) {
					casted.acceptHint(VarianceInfo.IN);
				}
				if (isSkippedHandle) {
					returnTypeIsArg = true;
				}
			}
			if (explicit && closureParameter.getParameterType() != null) {
				final LightweightTypeReference closureParameterType = typeAssigner.toLightweightTypeReference(closureParameter.getParameterType());
				new DeferredTypeParameterHintCollector(getExpectation().getReferenceOwner()) {
					@Override
					protected void addHint(UnboundTypeReference typeParameter, LightweightTypeReference reference) {
						LightweightTypeReference wrapped = reference.getWrapperTypeIfPrimitive();
						typeParameter.acceptHint(wrapped, BoundTypeArgumentSource.RESOLVED, getOrigin(), getExpectedVariance(), getActualVariance());
						LightweightTypeReference typeParameterReference = reference.getOwner().newParameterizedTypeReference(typeParameter.getTypeParameter());
						if (validParameterTypes && !typeParameterReference.getRawTypeReference().isAssignableFrom(reference)) {
							validParameterTypes = false;
						}
					}
				}.processPairedReferences(operationParameterType, closureParameterType);
				typeAssigner.assignType(closureParameter, closureParameterType);
				resultClosureType.addParameterType(closureParameterType);
				if (validParameterTypes && !closureParameterType.isAssignableFrom(operationParameterType)) {
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
								BoundTypeArgumentSource source = hint.getSource();
								if (source == BoundTypeArgumentSource.INFERRED || source == BoundTypeArgumentSource.EXPECTATION || source == BoundTypeArgumentSource.INFERRED_CONSTRAINT) {
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
		if (skippedHandle != null && !returnTypeIsArg) {
			((UnboundTypeReference) returnType).acceptHint(VarianceInfo.OUT);	
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
		return result;
	}

	/**
	 * Returns an indicator how compatible the expression type result is to the expected type.
	 * Either
	 * <ul>
	 * <li>{@link ConformanceFlags#NONE},</li>
	 * <li>{@link ConformanceFlags#INCOMPATIBLE}, or</li>
	 * <li>{@link ConformanceFlags#LAMBDA_RAW_COMPATIBLE}</li>
	 * <li>{@link ConformanceFlags#LAMBDA_VOID_COMPATIBLE}</li>
	 * </ul>
	 */
	protected int processExpressionType(ITypeComputationResult expressionResult) {
		LightweightTypeReference expressionResultType = expressionResult.getReturnType();
		if (expressionResultType == null || expressionResultType instanceof AnyTypeReference) {
			LightweightTypeReference returnType = expectedClosureType.getReturnType();
			if (returnType == null)
				throw new IllegalStateException("return type shall not be null");
			resultClosureType.setReturnType(returnType);
			if (validParameterTypes && returnType.isPrimitiveVoid()) {
				return ConformanceFlags.INCOMPATIBLE;
			}
		} else {
			LightweightTypeReference expectedReturnType = expectedClosureType.getReturnType();
			if (expectedReturnType == null)
				throw new IllegalStateException("expected return type may not be null");
			if (!expressionResultType.isPrimitiveVoid()) {
				if (expectedReturnType.isPrimitiveVoid()) {
					resultClosureType.setReturnType(expectedReturnType);
					if (isImplicitReturn(expressionResult)) {
						return ConformanceFlags.NONE;
					} else {
						return ConformanceFlags.INCOMPATIBLE;
					}
				} else {
					deferredBindTypeArgument(expectedReturnType, expressionResultType, BoundTypeArgumentSource.INFERRED);
				}
			} else if (expectedReturnType.isPrimitiveVoid()) {
				resultClosureType.setReturnType(expressionResultType);
				if (validParameterTypes && isImplicitReturn(expressionResult)) {
					return ConformanceFlags.LAMBDA_VOID_COMPATIBLE;
				}
				return ConformanceFlags.NONE;
			}
			if (expectedReturnType.isAssignableFrom(expressionResultType)) {
				resultClosureType.setReturnType(expressionResultType);
			} else if (expectedReturnType.isPrimitiveVoid()) {
				resultClosureType.setReturnType(expectedReturnType);
				return ConformanceFlags.INCOMPATIBLE;
			} else {
				resultClosureType.setReturnType(expectedReturnType);
				return ConformanceFlags.LAMBDA_RAW_COMPATIBLE;
			}
		}
		return ConformanceFlags.NONE;
	}

	protected boolean isImplicitReturn(ITypeComputationResult expressionResult) {
		int flags = expressionResult.getConformanceFlags();
		if ((ConformanceFlags.NO_IMPLICIT_RETURN & flags) != 0) {
			return false;
		}
		XExpression expression = expressionResult.getExpression();
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
