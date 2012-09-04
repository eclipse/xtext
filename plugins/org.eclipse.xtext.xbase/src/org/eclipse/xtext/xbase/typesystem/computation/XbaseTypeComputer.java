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

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAbstractWhileExpression;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypes;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceVisitorWithResult;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.ActualTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.ConstraintAwareTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.DeferredTypeParameterHintCollector;
import org.eclipse.xtext.xbase.typesystem.util.StandardTypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.StateAwareDeferredTypeParameterHintCollector;
import org.eclipse.xtext.xbase.typesystem.util.TypeArgumentFromComputedTypeCollector;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByConstraintSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameterAwareTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameterPreservingSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;
import org.eclipse.xtext.xbase.typing.NumberLiterals;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
public class XbaseTypeComputer implements ITypeComputer {

	@Inject
	private NumberLiterals numberLiterals;
	
	@Inject 
	private CommonTypeComputationServices services;
	
	public void computeTypes(XExpression expression, ITypeComputationState state) {
		if (expression instanceof XFeatureCall) {
			_computeTypes((XFeatureCall)expression, state);
		} else if (expression instanceof XAbstractFeatureCall) {
			_computeTypes((XAbstractFeatureCall)expression, state);
		} else if (expression instanceof XAbstractWhileExpression) {
			_computeTypes((XAbstractWhileExpression)expression, state);
		} else if (expression instanceof XBlockExpression) {
			_computeTypes((XBlockExpression)expression, state);
		} else if (expression instanceof XBooleanLiteral) {
			_computeTypes((XBooleanLiteral)expression, state);
		} else if (expression instanceof XCastedExpression) {
			_computeTypes((XCastedExpression)expression, state);
		} else if (expression instanceof XClosure) {
			_computeTypes((XClosure)expression, state);
		} else if (expression instanceof XConstructorCall) {
			_computeTypes((XConstructorCall)expression, state);
		} else if (expression instanceof XForLoopExpression) {
			_computeTypes((XForLoopExpression)expression, state);
		} else if (expression instanceof XIfExpression) {
			_computeTypes((XIfExpression)expression, state);
		} else if (expression instanceof XInstanceOfExpression) {
			_computeTypes((XInstanceOfExpression)expression, state);
		} else if (expression instanceof XNumberLiteral) {
			_computeTypes((XNumberLiteral)expression, state);
		} else if (expression instanceof XNullLiteral) {
			_computeTypes((XNullLiteral)expression, state);
		} else if (expression instanceof XReturnExpression) {
			_computeTypes((XReturnExpression)expression, state);
		} else if (expression instanceof XStringLiteral) {
			_computeTypes((XStringLiteral)expression, state);
		} else if (expression instanceof XSwitchExpression) {
			_computeTypes((XSwitchExpression)expression, state);
		} else if (expression instanceof XThrowExpression) {
			_computeTypes((XThrowExpression)expression, state);
		} else if (expression instanceof XTryCatchFinallyExpression) {
			_computeTypes((XTryCatchFinallyExpression)expression, state);
		} else if (expression instanceof XTypeLiteral) {
			_computeTypes((XTypeLiteral)expression, state);
		} else if (expression instanceof XVariableDeclaration) {
			_computeTypes((XVariableDeclaration)expression, state);
		} else { 
			throw new UnsupportedOperationException("Missing type computation for expression type: " + expression.eClass().getName() + " / " + state);
		}
	}
	
	protected LightweightTypeReference getTypeForName(Class<?> clazz, ITypeComputationState state) {
		ResourceSet resourceSet = state.getReferenceOwner().getContextResourceSet();
		JvmTypeReference typeReference = services.getTypeReferences().getTypeForName(clazz, resourceSet);
		return state.getConverter().toLightweightReference(typeReference);
	}
	
	protected void _computeTypes(XIfExpression object, ITypeComputationState state) {
		ITypeComputationState conditionExpectation = state.withExpectation(getTypeForName(Boolean.TYPE, state));
		conditionExpectation.computeTypes(object.getIf());
		// TODO instanceof may specialize the types in the nested expression
		// TODO then expression may influence the expected type of else and vice versa
		state.computeTypes(object.getThen());
		XExpression elseExpression = object.getElse();
		if (elseExpression != null) {
			state.computeTypes(object.getElse());
		} else {
			AnyTypeReference anyType = new AnyTypeReference(state.getReferenceOwner());
			state.acceptActualType(anyType);
		}
	}
	
	protected void _computeTypes(XSwitchExpression object, ITypeComputationState state) {
		ITypeComputationState switchExpressionState = state.withNonVoidExpectation();
		ITypeComputationResult computedType = switchExpressionState.computeTypes(object.getSwitch());
		ITypeComputationState allCasePartsState = state;
		if (object.getLocalVarName() != null) {
			allCasePartsState = allCasePartsState.assignType(object, computedType.getActualExpressionType());
		}
		// TODO case expressions may influence the expected type of other cases
		for(XCasePart casePart: object.getCases()) {
			// assign the type for the switch expression if possible and use that one for the remaining things
			ITypeComputationState casePartState = allCasePartsState.withTypeCheckpoint();
			if (casePart.getTypeGuard() != null) {
				JvmIdentifiableElement refinable = null;
				if (object.getLocalVarName() != null) {
					refinable = getRefinableCandidate(object, casePartState);
				} else {
					refinable = getRefinableCandidate(object.getSwitch(), casePartState);
				}
				if (refinable != null) {
					casePartState.reassignType(refinable, casePartState.getConverter().toLightweightReference(casePart.getTypeGuard()));
				}
			}
			if (casePart.getCase() != null) {
				// boolean or object / primitive
				ITypeComputationState caseState = casePartState.withNonVoidExpectation(); 
				caseState.computeTypes(casePart.getCase());
			}
			casePartState.computeTypes(casePart.getThen());
		}
		XExpression defaultCase = object.getDefault();
		if (defaultCase != null) {
			allCasePartsState.computeTypes(object.getDefault());
		} else {
			AnyTypeReference anyType = new AnyTypeReference(state.getReferenceOwner());
			state.acceptActualType(anyType);
		}
	}
	
	protected void _computeTypes(XBlockExpression object, ITypeComputationState state) {
		for (ITypeExpectation expectation: state.getImmediateExpectations()) {
			LightweightTypeReference expectedType = expectation.getExpectedType();
			if (expectedType != null && expectedType.isPrimitiveVoid()) {
				List<XExpression> expressions = object.getExpressions();
				if (!expressions.isEmpty()) {
					for(XExpression expression: expressions) {
						ITypeComputationState expressionState = state.withoutImmediateExpectation(); // no expectation
						expressionState.computeTypes(expression);
						if (expression instanceof XVariableDeclaration) {
							state.addLocalToCurrentScope((XVariableDeclaration)expression);
						}
					}
				}
				expectation.acceptActualType(getPrimitiveVoid(state), ConformanceHint.CHECKED, ConformanceHint.SUCCESS);
			} else {
				List<XExpression> expressions = object.getExpressions();
				if (!expressions.isEmpty()) {
					for(XExpression expression: expressions.subList(0, expressions.size() - 1)) {
						ITypeComputationState expressionState = state.withoutImmediateExpectation();
						expressionState.computeTypes(expression);
						if (expression instanceof XVariableDeclaration) {
							state.addLocalToCurrentScope((XVariableDeclaration)expression);
						}
					}
					state.computeTypes(IterableExtensions.last(expressions));
				} else {
					expectation.acceptActualType(new AnyTypeReference(expectation.getReferenceOwner()), ConformanceHint.UNCHECKED);
				}
			}
		}
	}

	protected void _computeTypes(XVariableDeclaration object, ITypeComputationState state) {
		JvmTypeReference declaredType = object.getType();
		LightweightTypeReference lightweightTypeReference = declaredType != null ? state.getConverter().toLightweightReference(declaredType) : null;
		ITypeComputationState initializerState = lightweightTypeReference != null ? state.withExpectation(lightweightTypeReference) : state.withNonVoidExpectation();
		ITypeComputationResult computedType = initializerState.computeTypes(object.getRight());
		// TODO keep information about the actual type 
		state.assignType(object, lightweightTypeReference != null ? lightweightTypeReference : computedType.getActualExpressionType());
		LightweightTypeReference primitiveVoid = getPrimitiveVoid(state);
		state.acceptActualType(primitiveVoid);
	}

	protected void _computeTypes(final XConstructorCall constructorCall, ITypeComputationState state) {
		List<? extends IConstructorLinkingCandidate> candidates = state.getLinkingCandidates(constructorCall);
		IConstructorLinkingCandidate best = getBestCandidate(candidates);
		best.apply();
	}
	
	/**
	 * @param object used for dispatching
	 */
	protected void _computeTypes(XBooleanLiteral object, ITypeComputationState state) {
		LightweightTypeReference bool = getTypeForName(Boolean.TYPE, state);
		state.acceptActualType(bool);
	}

	/**
	 * @param object used for dispatching
	 */
	protected void _computeTypes(XNullLiteral object, ITypeComputationState state) {
		state.acceptActualType(new AnyTypeReference(state.getReferenceOwner()));
	}

	protected void _computeTypes(XNumberLiteral object, ITypeComputationState state) {
		// TODO evaluate expectation if no specific suffix is given
		LightweightTypeReference result = getTypeForName(numberLiterals.getJavaType(object), state);
		state.acceptActualType(result);
	}

	/**
	 * @param object used for dispatching
	 */
	protected void _computeTypes(XStringLiteral object, ITypeComputationState state) {
		// TODO evaluate expectation to allow string literals with length == 1 to appear like a char or a Character
		LightweightTypeReference result = getTypeForName(String.class, state);
		state.acceptActualType(result);
	}
	
	protected void _computeTypes(XClosure object, ITypeComputationState state) {
		FunctionTypes functionTypes = services.getFunctionTypes();
		for(ITypeExpectation expectation: state.getImmediateExpectations()) {
			List<JvmFormalParameter> closureParameters = object.getFormalParameters();
			LightweightTypeReference closureType = expectation.getExpectedType();
			JvmOperation operation = null;
			if (closureType == null) {
				// TODO - closure has no expected type - has to be function or procedure
				closureType = functionTypes.createRawFunctionTypeRef(expectation.getReferenceOwner(), object, closureParameters.size(), false);
				operation = functionTypes.findImplementingOperation(closureType);
				initClosureType((FunctionTypeReference) closureType, operation);
			} else {
				operation = functionTypes.findImplementingOperation(closureType);
				if (operation == null) {
					closureType = functionTypes.createRawFunctionTypeRef(expectation.getReferenceOwner(), object, closureParameters.size(), false);
					operation = functionTypes.findImplementingOperation(closureType);
					initClosureType((FunctionTypeReference) closureType, operation);
				}
			}
			if (operation == null || closureType == null) {
				throw new IllegalStateException("Cannot locate appropriate operation for " + object); 
			}
			
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping = getTypeParameterMapping(
					object, closureType, operation, expectation);
			UnboundTypeParameterPreservingSubstitutor substitutor = new UnboundTypeParameterPreservingSubstitutor(typeParameterMapping, state.getReferenceOwner());
			LightweightTypeReference declaredReturnType = getSubstitutedClosureReturnType(operation, substitutor, state);
			ITypeAssigner typeAssigner = state.withRootExpectation(declaredReturnType).assignTypes();
			ITypeComputationState closureBodyTypeComputationState = getClosureBodyTypeComputationState(
					closureParameters, substitutor, operation.getParameters(), typeAssigner);
			ITypeComputationResult expressionResult = closureBodyTypeComputationState.computeTypes(object.getExpression());
			List<LightweightTypeReference> closureParameterTypes = getClosureParameterTypes(operation, typeParameterMapping, closureParameters, expressionResult, closureBodyTypeComputationState);
			LightweightTypeReference expressionResultType = getClosureBodyType(declaredReturnType, expressionResult, closureBodyTypeComputationState);
			TypeParameterSubstitutor<?> closureTypeSubstitutor = new TypeParameterSubstitutor<Integer>(typeParameterMapping, closureBodyTypeComputationState.getReferenceOwner()) {
				@Override
				@NonNull
				protected Integer createVisiting() {
					return 0;
				}
				
				@NonNullByDefault
				@Override
				protected LightweightTypeReference visitTypeArgument(LightweightTypeReference reference,
						Integer visiting) {
					return reference.accept(this, visiting + 1);	
				}
				
				@NonNullByDefault
				@Override
				protected LightweightTypeReference doVisitWildcardTypeReference(WildcardTypeReference reference,
						Integer visiting) {
					if (visiting == 1) {
						LightweightTypeReference lowerBound = reference.getLowerBound();
						if (lowerBound != null) {
							return lowerBound.accept(this, visiting);
						} else {
							LightweightTypeReference upperBound = reference.getUpperBoundSubstitute();
							return upperBound.accept(this, visiting);
						}
					} else {
						return super.doVisitWildcardTypeReference(reference, visiting);
					}
				}

				@NonNullByDefault
				@Override
				protected LightweightTypeReference doVisitParameterizedTypeReference(
						ParameterizedTypeReference reference, Integer visiting) {
					if (visiting > 1) {
						return super.doVisitParameterizedTypeReference(reference, visiting);
					}
					JvmType type = reference.getType();
					if (type instanceof JvmTypeParameter) {
						LightweightTypeReference boundTypeArgument = getBoundTypeArgument(reference, (JvmTypeParameter) type, visiting);
						if (boundTypeArgument != null)
							return boundTypeArgument;
					}
					ParameterizedTypeReference result = new ParameterizedTypeReference(getOwner(), reference.getType());
					if (type instanceof JvmGenericType) {
						List<JvmTypeParameter> typeParameters = ((JvmGenericType) type).getTypeParameters();
						List<LightweightTypeReference> typeArguments = reference.getTypeArguments();
						for(int i = 0; i < typeArguments.size(); i++) {
							if (i < typeParameters.size()) {
								JvmTypeParameter typeParameter = typeParameters.get(i);
								LightweightMergedBoundTypeArgument boundTypeArgument = getTypeParameterMapping().get(typeParameter);
								if (boundTypeArgument != null && boundTypeArgument.getVariance() == VarianceInfo.INVARIANT) {
									result.addTypeArgument(visitTypeArgument(boundTypeArgument.getTypeReference(), visiting));
								} else {
									LightweightTypeReference argument = typeArguments.get(i);
									result.addTypeArgument(visitTypeArgument(argument, visiting));
								}
							} else {
								LightweightTypeReference argument = typeArguments.get(i);
								result.addTypeArgument(visitTypeArgument(argument, visiting));
							}
						}
					} else {
						for(LightweightTypeReference argument: reference.getTypeArguments()) {
							result.addTypeArgument(visitTypeArgument(argument, visiting));
						}
					}
					return result;
				}
				
				@NonNullByDefault
				@Override
				public LightweightTypeReference doVisitUnboundTypeReference(UnboundTypeReference reference, Integer param) {
					return reference.copyInto(getOwner());
				}
			};
			LightweightTypeReference substitutedClosureType = closureTypeSubstitutor.substitute(closureType);
			LightweightTypeReference result = createFunctionTypeReference(expectation.getReferenceOwner(), substitutedClosureType, closureParameterTypes, expressionResultType);
			// TODO the hint is probably wrong - if we expect a native function type, demand conversion is not true
			expectation.acceptActualType(result, ConformanceHint.DEMAND_CONVERSION, ConformanceHint.UNCHECKED); 
		}
	}

	@NonNullByDefault
	protected void initClosureType(FunctionTypeReference result, JvmOperation operation) {
		ITypeReferenceOwner owner = result.getOwner();
		OwnedConverter converter = new OwnedConverter(owner);
		StandardTypeParameterSubstitutor substitutor = new StandardTypeParameterSubstitutor(
				Collections.<JvmTypeParameter, LightweightMergedBoundTypeArgument>emptyMap(), owner);
		LightweightTypeReference declaredReturnType = converter.toLightweightReference(operation.getReturnType());
		for(JvmFormalParameter parameter: operation.getParameters()) {
			LightweightTypeReference lightweight = substitutor.substitute(converter.toLightweightReference(parameter.getParameterType()));
			LightweightTypeReference lowerBound = services.getLightweightTypeReferences().getLowerBoundOrInvariant(lightweight);
			if (lowerBound == null) {
				throw new IllegalStateException("TODO implement me: Object as lower bound");
			}
			result.addParameterType(lowerBound);
			result.addTypeArgument(lowerBound);
		}
		LightweightTypeReference returnType = substitutor.substitute(declaredReturnType);
		result.setReturnType(returnType);
		if (!returnType.isPrimitiveVoid()) {
			result.addTypeArgument(returnType);
		}
	}

	protected LightweightTypeReference createFunctionTypeReference(ITypeReferenceOwner owner, LightweightTypeReference closureType,
			List<LightweightTypeReference> parameterTypes, LightweightTypeReference expressionResultType) {
		LightweightTypeReference result = services.getFunctionTypes().createFunctionTypeRef(owner, closureType, parameterTypes, expressionResultType);
		return result;
	}

	@NonNullByDefault
	protected LightweightTypeReference getClosureBodyType(LightweightTypeReference declaredReturnType,
			ITypeComputationResult expressionResult, final ITypeComputationState state) {
		LightweightTypeReference expressionResultType = expressionResult.getActualExpressionType();
		if (expressionResultType == null || expressionResultType instanceof AnyTypeReference) {
			expressionResultType = declaredReturnType;
		} else {
			deferredBindTypeArgument(declaredReturnType, expressionResultType, state);
		}
		return expressionResultType;
	}
	
	protected void deferredBindTypeArgument(LightweightTypeReference declaredReturnType, LightweightTypeReference type, ITypeComputationState state) {
		if (declaredReturnType != null) { 
			DeferredTypeParameterHintCollector collector = new StateAwareDeferredTypeParameterHintCollector(state.getReferenceOwner());
			collector.processPairedReferences(declaredReturnType, type);
		}
	}
	
	protected List<LightweightTypeReference> getClosureParameterTypes(JvmOperation operation, Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping, List<JvmFormalParameter> closureParameters,
			ITypeComputationResult expressionResult, ITypeComputationState state) {
		List<LightweightTypeReference> closureParameterTypes = Lists.newArrayListWithCapacity(closureParameters.size());
		int max = Math.min(operation.getParameters().size(), closureParameters.size());
		for(int i = 0; i < max; i++) {
			JvmFormalParameter closureParameter = closureParameters.get(i);
			JvmFormalParameter operationParameter = operation.getParameters().get(i);
			LightweightTypeReference closureParameterType = expressionResult.getActualType(closureParameter);
			LightweightTypeReference operationParameterType = expressionResult.getActualType(operationParameter);
			resolveAgainstActualType(operationParameterType, closureParameterType, closureParameter.getParameterType() != null, typeParameterMapping, state);
			closureParameterTypes.add(closureParameterType);
		}
		for(int i = max; i < closureParameters.size(); i++) {
			JvmFormalParameter parameter = closureParameters.get(i);
			closureParameterTypes.add(expressionResult.getActualType(parameter));
		}
		return closureParameterTypes;
	}
	
	protected void resolveAgainstActualType(LightweightTypeReference declaredType, LightweightTypeReference actualType, boolean explictActualType, Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping, final ITypeComputationState state) {
		// TODO this(..) and super(..) for generic types
		if (!typeParameterMapping.isEmpty()) {
			List<JvmTypeParameter> typeParameters = Lists.newArrayList(typeParameterMapping.keySet());
			TypeArgumentFromComputedTypeCollector.resolveAgainstActualType(declaredType, actualType, typeParameters, typeParameterMapping, explictActualType ? BoundTypeArgumentSource.RESOLVED : BoundTypeArgumentSource.EXPECTATION, state.getReferenceOwner());
		}
	}

	protected ITypeComputationState getClosureBodyTypeComputationState(
			List<JvmFormalParameter> closureParameters, UnboundTypeParameterPreservingSubstitutor substitutor,
			List<JvmFormalParameter> operationParameters, ITypeAssigner typeAssigner) {
		int paramCount = Math.min(closureParameters.size(), operationParameters.size());
		// TODO validate parameter count - check against operation if available
		for(int i = 0; i < paramCount; i++) {
			JvmFormalParameter closureParameter = closureParameters.get(i);
			JvmTypeReference declaredParameterType = operationParameters.get(i).getParameterType();
			LightweightTypeReference lightweightParameterType = typeAssigner.toLightweightTypeReference(declaredParameterType);
			LightweightTypeReference expectedType = substitutor.substitute(lightweightParameterType);
			JvmTypeReference actualDeclaredType = closureParameter.getParameterType();
			if (actualDeclaredType != null) {
				typeAssigner.assignType(closureParameter, typeAssigner.toLightweightTypeReference(closureParameter.getParameterType()), expectedType);
			} else {
				typeAssigner.assignType(closureParameter, expectedType);
			}
		}
		for(int i = paramCount; i < closureParameters.size(); i++) {
			JvmFormalParameter closureParameter = closureParameters.get(i);
			JvmTypeReference parameterType = closureParameter.getParameterType();
			if (parameterType != null) {
				typeAssigner.assignType(closureParameter, typeAssigner.toLightweightTypeReference(parameterType));
			} else {
				typeAssigner.assignType(closureParameter, typeAssigner.toLightweightTypeReference(services.getTypeReferences().getTypeForName(Object.class, closureParameter)));
			}
		}
		return typeAssigner.getForkedState();
	}

	protected LightweightTypeReference getSubstitutedClosureReturnType(JvmOperation operation,
			UnboundTypeParameterPreservingSubstitutor substitutor, ITypeComputationState state) {
		LightweightTypeReference result = substitutor.substitute(state.getConverter().toLightweightReference(operation.getReturnType()));
		return result;
	}

	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getTypeParameterMapping(XClosure object,
			LightweightTypeReference closureType, JvmOperation operation, ITypeExpectation expectation) {
		List<JvmTypeParameter> allTypeParameters = services.getFunctionTypes().collectAllTypeParameters(closureType, operation);
		ListMultimap<JvmTypeParameter, LightweightBoundTypeArgument> typeParameterMapping = getClosureTypeParameterMapping(
				closureType, operation, allTypeParameters, expectation);
		
		Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> expectedTypeParameterMapping = Maps.newLinkedHashMap();
		for(JvmTypeParameter typeParameter: allTypeParameters) {
			List<LightweightBoundTypeArgument> boundInformation = typeParameterMapping.get(typeParameter);
			LightweightMergedBoundTypeArgument boundTypeArgument = null;
			if (boundInformation.isEmpty()) {
				UnboundTypeReference unboundTypeReference = expectation.createUnboundTypeReference(object, typeParameter);
				// TODO use VarianceInfo.IN / .OUT respectively if direct arg in operation
				boundTypeArgument = new LightweightMergedBoundTypeArgument(unboundTypeReference, VarianceInfo.INVARIANT);
				expectedTypeParameterMapping.put(typeParameter, boundTypeArgument);
			} else {
				boundTypeArgument = services.getBoundTypeArgumentMerger().merge(typeParameterMapping.get(typeParameter), expectation.getReferenceOwner());
				expectedTypeParameterMapping.put(typeParameter, boundTypeArgument);
			}
			if (boundTypeArgument != null) {
				LightweightTypeReference typeReference = boundTypeArgument.getTypeReference();
				if (typeReference instanceof UnboundTypeReference) {
					((UnboundTypeReference) typeReference).acceptHint(boundTypeArgument.getVariance());
				}
			}
		}
		return expectedTypeParameterMapping;
	}

	protected ListMultimap<JvmTypeParameter, LightweightBoundTypeArgument> getClosureTypeParameterMapping(
			LightweightTypeReference closureType, JvmOperation operation, List<JvmTypeParameter> allTypeParameters, ITypeExpectation expectation) {
		ActualTypeArgumentCollector typeArgumentCollector = new UnboundTypeParameterAwareTypeArgumentCollector(allTypeParameters, BoundTypeArgumentSource.INFERRED, expectation.getReferenceOwner());
		return services.getFunctionTypes().getFunctionTypeParameterMapping(closureType, operation, typeArgumentCollector, expectation.getReferenceOwner());
	}
	
	protected void _computeTypes(XCastedExpression object, ITypeComputationState state) {
		LightweightTypeReference objectType = getTypeForName(Object.class, state);
		state.withExpectation(objectType).computeTypes(object.getTarget());
		state.acceptActualType(state.getConverter().toLightweightReference(object.getType()));
	}

	protected void _computeTypes(final XForLoopExpression object, final ITypeComputationState state) {
		JvmFormalParameter declaredParam = object.getDeclaredParam();
		LightweightTypeReference parameterType = null;
		if (declaredParam.getParameterType() != null) {
			parameterType = state.getConverter().toLightweightReference(declaredParam.getParameterType());
			LightweightTypeReference iterable = null;
			if (parameterType.isPrimitive()) {
				iterable = new ArrayTypeReference(state.getReferenceOwner(), parameterType);
			} else {
				ParameterizedTypeReference reference = new ParameterizedTypeReference(state.getReferenceOwner(), services.getTypeReferences().findDeclaredType(Iterable.class, object));
				WildcardTypeReference wildcard = new WildcardTypeReference(state.getReferenceOwner());
				wildcard.addUpperBound(parameterType);
				reference.addTypeArgument(wildcard);
				iterable = reference;
			}
			// TODO add synonyms automatically
			ITypeComputationState iterableState = state.withExpectation(iterable);
			iterableState.computeTypes(object.getForExpression());
			
		} else {
			WildcardTypeReference wildcard = new WildcardTypeReference(state.getReferenceOwner());
			wildcard.addUpperBound(getTypeForName(Object.class, state));
			ParameterizedTypeReference iterable = new ParameterizedTypeReference(state.getReferenceOwner(), services.getTypeReferences().findDeclaredType(Iterable.class, object));
			iterable.addTypeArgument(wildcard);
			// TODO add synonyms automatically
			ITypeComputationState iterableState = state.withExpectation(iterable); 
			ITypeComputationResult forExpressionResult = iterableState.computeTypes(object.getForExpression());
			LightweightTypeReference forExpressionType = forExpressionResult.getActualExpressionType();
			parameterType = forExpressionType.accept(new TypeReferenceVisitorWithResult<LightweightTypeReference>() {
				@Override
				public LightweightTypeReference doVisitParameterizedTypeReference(@NonNull ParameterizedTypeReference reference) {
					DeclaratorTypeArgumentCollector typeArgumentCollector = new ConstraintAwareTypeArgumentCollector(state.getReferenceOwner());
					Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping = typeArgumentCollector.getTypeParameterMapping(reference);
					TypeParameterSubstitutor<?> substitutor = new TypeParameterByConstraintSubstitutor(typeParameterMapping, state.getReferenceOwner());
					JvmGenericType iterable = (JvmGenericType) services.getTypeReferences().findDeclaredType(Iterable.class, object);
					ParameterizedTypeReference substituteMe = new ParameterizedTypeReference(state.getReferenceOwner(), iterable.getTypeParameters().get(0));
					LightweightTypeReference substitutedArgument = substitutor.substitute(substituteMe);
					return substitutedArgument;
				}
				@Override
				public LightweightTypeReference doVisitArrayTypeReference(@NonNull ArrayTypeReference reference) {
					return reference.getComponentType();
				}
			});
		}
		if (parameterType == null) {
			throw new IllegalStateException("Should not be possible");
		}
		ITypeComputationState eachState = state.withoutImmediateExpectation().assignType(declaredParam, parameterType);
		eachState.computeTypes(object.getEachExpression());
		
		LightweightTypeReference primitiveVoid = getPrimitiveVoid(state);
		state.acceptActualType(primitiveVoid);
	}

	protected void _computeTypes(XAbstractWhileExpression object, ITypeComputationState state) {
		ITypeComputationState conditionExpectation = state.withExpectation(getTypeForName(Boolean.TYPE, state));
		conditionExpectation.computeTypes(object.getPredicate());
		// TODO reassign type if instanceof clause is present and cannot be ignored due to binary boolean operations
		state.withoutImmediateExpectation().computeTypes(object.getBody());
		
		LightweightTypeReference primitiveVoid = getPrimitiveVoid(state);
		state.acceptActualType(primitiveVoid);
	}

	protected void _computeTypes(XTypeLiteral object, ITypeComputationState state) {
		JvmParameterizedTypeReference typeRef = services.getTypesFactory().createJvmParameterizedTypeReference();
		typeRef.setType(object.getType());
		JvmTypeReference result = typeRef;
		for (int i = 0; i < object.getArrayDimensions().size(); i++) {
			JvmGenericArrayTypeReference arrayType = services.getTypesFactory().createJvmGenericArrayTypeReference();
			arrayType.setComponentType(result);
			result = arrayType;
		}
		JvmTypeReference classType = services.getTypeReferences().getTypeForName(Class.class, object, result);
		LightweightTypeReference lightweightReference = state.getConverter().toLightweightReference(classType);
		state.acceptActualType(lightweightReference);
	}
	
	protected void _computeTypes(XInstanceOfExpression object, ITypeComputationState state) {
		ITypeComputationState expressionState = state.withExpectation(getTypeForName(Object.class, state));
		expressionState.computeTypes(object.getExpression());
		LightweightTypeReference bool = getTypeForName(Boolean.TYPE, state);
		state.acceptActualType(bool);
	}

	protected void _computeTypes(XThrowExpression object, ITypeComputationState state) {
		LightweightTypeReference throwable = getTypeForName(Throwable.class, state);
		ITypeComputationState expressionState = state.withExpectation(throwable);
		expressionState.computeTypes(object.getExpression());
		state.acceptActualType(getPrimitiveVoid(state));
	}

	protected void _computeTypes(XReturnExpression object, ITypeComputationState state) {
		ITypeComputationState expressionState = state.withReturnExpectation();
		expressionState.computeTypes(object.getExpression());
		state.acceptActualType(getPrimitiveVoid(state));
	}
	
	protected LightweightTypeReference getPrimitiveVoid(ITypeComputationState state) {
		return getTypeForName(Void.TYPE, state);
	}

	protected void _computeTypes(XTryCatchFinallyExpression object, ITypeComputationState state) {
		state.computeTypes(object.getExpression());
		for (XCatchClause catchClause : object.getCatchClauses()) {
			JvmFormalParameter catchClauseParam = catchClause.getDeclaredParam();
			LightweightTypeReference lightweightReference = state.getConverter().toLightweightReference(catchClauseParam.getParameterType());
			ITypeComputationState catchClauseState = state.assignType(catchClauseParam, lightweightReference);
			catchClauseState.computeTypes(catchClause.getExpression());
		}
		// TODO validate / handle return / throw in finally block
		state.withoutImmediateExpectation().computeTypes(object.getFinallyExpression());
	}
	
	protected void _computeTypes(final XAbstractFeatureCall featureCall, ITypeComputationState state) {
		List<? extends IFeatureLinkingCandidate> candidates = state.getLinkingCandidates(featureCall);
		IFeatureLinkingCandidate best = getBestCandidate(candidates);
		best.apply();
	}
	
	protected <Candidate extends ILinkingCandidate> Candidate getBestCandidate(List<? extends Candidate> candidates) {
		Candidate result = candidates.get(0);
		for(int i = 1; i < candidates.size(); i++) {
			Candidate candidate = candidates.get(i);
			if (!result.isPreferredOver(candidate))
				result = candidate;
		}
		return result;
	}

	protected JvmIdentifiableElement getRefinableCandidate(XExpression object, ITypeComputationState state) {
		if (object instanceof XSwitchExpression) {
			return (XSwitchExpression) object;
		}
		if (object instanceof XFeatureCall) {
			List<? extends IFeatureLinkingCandidate> candidates = state.getLinkingCandidates((XFeatureCall)object);
			if (candidates.size() == 1) {
				JvmIdentifiableElement linkedFeature = candidates.get(0).getFeature();
				if (linkedFeature instanceof XVariableDeclaration || linkedFeature instanceof JvmFormalParameter || linkedFeature instanceof JvmField) {
					return linkedFeature;
				}
			}
		}
		return null;
	}
	
	// TODO implement this thing
	// keep in mind, that the following may happen:
	/* 
	 * switch(mutableValue) {
	 *   SomeType: if (condition) mutableValue = instanceOfAnotherType else mutableValue.doStuffOnSomeType
	 * }
	 */
	
//	protected void _computeTypes(final XAssignment context, ITypeComputationState state) {
//		_computeTypes((XAbstractFeatureCall) context, state);
//		state.discardReassignedTypes(context.getAssignable());
//	}

//	/**
//	 * @param expr the casted expression that is the container of the child whose expected type should be computed. May not be <code>null</code>.
//	 * @param reference the feature that describes the child whose type is expected
//	 * @param index the feature index 
//	 * @param rawType <code>true</code> if we are only interested in the raw type
//	 */
//	protected JvmTypeReference _expectedType(XCastedExpression expr, EReference reference, int index, boolean rawType) {
//		// SE: This was previously explicitly set to null :
//		// "return null; // no expectations!"
//		// Unfortunately there was no comment explaining why this was the case also no test besides the one which explicitly tested this was failing so I changed it back.
//		// return expr.getType();
//		// SZ: reverted the change
//		// the following xtend thing can be casted but will fail if the expected type is taken from the cast expression
//		// def <T extends Integer> addFunction() {\n" + 
//		//	    [T a,T b|a+b] as (T,T)=>T\n" + 
//		// }
//		// if the closure expects T to be the return type
//		// the check for the implicit return of int (a + b) will fail
//		// since T result =/= Integer
//		return null;
//	}
}
