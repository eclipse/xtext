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
import java.util.Set;

import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.AbstractTypeReferenceVisitor;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.RawTypeHelper;
import org.eclipse.xtext.common.types.util.TypeReferences;
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
import org.eclipse.xtext.xbase.typesystem.util.AbstractReentrantTypeReferenceProvider;
import org.eclipse.xtext.xbase.typesystem.util.ActualTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentMerger;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.MergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameterPreservingSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameters;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;
import org.eclipse.xtext.xbase.typing.Closures;
import org.eclipse.xtext.xbase.typing.NumberLiterals;
import org.eclipse.xtext.xtype.XComputedTypeReference;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
@Singleton
public class XbaseTypeComputer extends AbstractTypeComputer {

	@Inject
	private Closures closures;

	@Inject
	private NumberLiterals numberLiterals;
	
	@Inject
	private Primitives primitives;
	
	@Inject 
	private CommonTypeComputationServices services;
	
	@Inject
	private RawTypeHelper rawTypeHelper;
	
	@Inject
	private BoundTypeArgumentMerger typeArgumentMerger;
	
	protected TypeReferences getTypeReferences() {
		return services.getTypeReferences();
	}
	
	@Override
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
			super.computeTypes(expression, state);
		}
	}
	
	protected void _computeTypes(XIfExpression object, ITypeComputationState state) {
		ITypeComputationState conditionExpectation = state.fork().withExpectation(getTypeReferences().getTypeForName(Boolean.TYPE, object));
		conditionExpectation.computeTypes(object.getIf());
		// TODO instanceof may specialize the types
		state.computeTypes(object.getThen());
		XExpression elseExpression = object.getElse();
		if (elseExpression != null) {
			state.computeTypes(object.getElse());
		} else {
			JvmAnyTypeReference anyType = getTypeReferences().createAnyTypeReference(object);
			state.acceptActualType(anyType);
		}
	}
	
	protected void _computeTypes(XSwitchExpression object, ITypeComputationState state) {
		ITypeComputationState switchExpressionState = state.fork().withNonVoidExpectation();
		ITypeComputationResult computedType = switchExpressionState.computeTypes(object.getSwitch());
		ITypeComputationState allCasePartsState = state;
		if (object.getLocalVarName() != null) {
			allCasePartsState = allCasePartsState.assignType(object, computedType.getActualExpressionType());
		}
		for(XCasePart casePart: object.getCases()) {
			// assign the type for the switch expression if possible and use that one for the remaining things
			ITypeComputationState casePartState = allCasePartsState.fork().withTypeCheckpoint();
			if (object.getLocalVarName() != null) {
				casePartState.reassignType(object, casePart.getTypeGuard());
			} else {
				casePartState.reassignType(object.getSwitch(), casePart.getTypeGuard());
			}
			if (casePart.getCase() != null) {
				// boolean or object / primitive
				ITypeComputationState caseState = casePartState.fork().withNonVoidExpectation(); 
				caseState.computeTypes(casePart.getCase());
			}
			casePartState.computeTypes(casePart.getThen());
		}
		XExpression defaultCase = object.getDefault();
		if (defaultCase != null) {
			allCasePartsState.computeTypes(object.getDefault());
		} else {
			JvmAnyTypeReference anyType = getTypeReferences().createAnyTypeReference(object);
			state.acceptActualType(anyType);
		}
	}
	
	protected void _computeTypes(XBlockExpression object, ITypeComputationState state) {
		List<XExpression> expressions = object.getExpressions();
		if (!expressions.isEmpty()) {
			for(XExpression expression: expressions.subList(0, expressions.size() - 1)) {
				ITypeComputationState expressionState = state.fork().withoutImmediateExpectation(); // no expectation
				expressionState.computeTypes(expression);
				if (expression instanceof XVariableDeclaration) {
					state.addLocalToCurrentScope((XVariableDeclaration)expression);
				}
			}
			state.computeTypes(IterableExtensions.last(expressions));
		}
	}

	protected void _computeTypes(XVariableDeclaration object, ITypeComputationState state) {
		JvmTypeReference declaredType = object.getType();
		ITypeComputationState initializerState = declaredType != null ? state.fork().withExpectation(declaredType) : state.fork().withNonVoidExpectation();
		ITypeComputationResult computedType = initializerState.computeTypes(object.getRight());
		// TODO keep information about the actual type 
		state.assignType(object, declaredType != null ? declaredType : computedType.getActualExpressionType());
		JvmTypeReference primitiveVoid = getPrimitiveVoid(object);
		state.acceptActualType(primitiveVoid);
	}

	protected void _computeTypes(final XConstructorCall constructorCall, ITypeComputationState state) {
		List<IConstructorLinkingCandidate> candidates = state.getLinkingCandidates(constructorCall);
		IConstructorLinkingCandidate best = getBestCandidate(candidates);
		best.apply();
	}
	
	protected void _computeTypes(XBooleanLiteral object, ITypeComputationState state) {
		JvmTypeReference bool = getTypeReferences().getTypeForName(Boolean.TYPE, object);
		state.acceptActualType(bool);
	}

	protected void _computeTypes(XNullLiteral object, ITypeComputationState state) {
		JvmAnyTypeReference any = getTypeReferences().createAnyTypeReference(object);
		state.acceptActualType(any);
	}

	protected void _computeTypes(XNumberLiteral object, ITypeComputationState state) {
		// TODO evaluate expectation if no specific suffix is given
		JvmTypeReference result = getTypeReferences().getTypeForName(numberLiterals.getJavaType(object), object);
		state.acceptActualType(result);
	}

	protected void _computeTypes(XStringLiteral object, ITypeComputationState state) {
		// TODO evaluate expectation to allow string literals with length == 1 to appear like a char or a Character
		JvmTypeReference result = getTypeReferences().getTypeForName(String.class, object);
		state.acceptActualType(result);
	}

	protected void _computeTypes(final XClosure object, final ITypeComputationState state) {
		for(ITypeExpectation expectation: state.getImmediateExpectations()) {
			JvmTypeReference expectedClosureType = expectation.getExpectedType();
			Map<JvmTypeParameter, MergedBoundTypeArgument> expectedTypeParameterMapping = Collections.emptyMap();
			// TODO - closure has no expected type - has to be function or procedure
			ITypeComputationState closureBodyState = state;
			JvmOperation operation = null;
			List<JvmFormalParameter> operationParameters = Collections.emptyList();
			final JvmTypeReference operationReturnType;
			TypeParameterSubstitutor substitutor = null;
			if (expectedClosureType != null) {
				operation = closures.findImplementingOperation(expectedClosureType, object.eResource());
				if (operation != null) {
					List<JvmType> rawTypes = rawTypeHelper.getAllRawTypes(expectedClosureType, object.eResource());
					List<JvmTypeParameter> allTypeParameters = Lists.newArrayList();
					for(JvmType rawType: rawTypes) {
						if (rawType instanceof JvmTypeParameterDeclarator) {
							allTypeParameters.addAll(((JvmTypeParameterDeclarator) rawType).getTypeParameters());
						}
					}
					allTypeParameters.addAll(operation.getTypeParameters());
					ActualTypeArgumentCollector typeArgumentCollector = new ActualTypeArgumentCollector(allTypeParameters, services);
					JvmParameterizedTypeReference operationTypeDeclarator = services.getTypeReferences().createTypeRef(operation.getDeclaringType());
					typeArgumentCollector.populateTypeParameterMapping(operationTypeDeclarator, expectedClosureType);
					ListMultimap<JvmTypeParameter, BoundTypeArgument> typeParameterMapping = typeArgumentCollector.getTypeParameterMapping();
					expectedTypeParameterMapping = Maps.newLinkedHashMap();
					for(JvmTypeParameter typeParamter: typeParameterMapping.keySet()) {
						MergedBoundTypeArgument boundTypeArgument = typeArgumentMerger.merge(typeParameterMapping.get(typeParamter));
						if (boundTypeArgument != null)
							expectedTypeParameterMapping.put(typeParamter, boundTypeArgument);
					}
					operationParameters = operation.getParameters();
					JvmTypeReference declaredReturnType = operation.getReturnType();
					substitutor = new UnboundTypeParameterPreservingSubstitutor(expectedTypeParameterMapping, services);
					operationReturnType = substitutor.substitute(declaredReturnType);
					if (operationReturnType == null) {
						throw new IllegalStateException();
					}
					closureBodyState = closureBodyState.fork().withExpectation(operationReturnType);
				} else {
					operationReturnType = null;
				}
			} else {
				operationReturnType = null;
			}
			if (substitutor == null)
				substitutor = new TypeParameterSubstitutor(expectedTypeParameterMapping, services);
			ITypeAssigner typeAssigner = closureBodyState.assignTypes();
			List<JvmFormalParameter> closureParameters = object.getFormalParameters();
			int paramCount = Math.min(closureParameters.size(), operationParameters.size());
			// TODO validate parameter count - check against operation if available
			for(int i = 0; i < paramCount; i++) {
				JvmFormalParameter closureParameter = closureParameters.get(i);
				JvmTypeReference declaredParameterType = operationParameters.get(i).getParameterType();
				JvmTypeReference resolvedDeclaredType = substitutor.substitute(declaredParameterType);
				typeAssigner.assignType(closureParameter, closureParameter.getParameterType(), resolvedDeclaredType);
			}
			final JvmTypeReference[] closureType = new JvmTypeReference[1];
			for(int i = paramCount; i < closureParameters.size(); i++) {
				JvmFormalParameter closureParameter = closureParameters.get(i);
				JvmTypeReference parameterType = closureParameter.getParameterType();
				if (parameterType != null) {
					typeAssigner.assignType(closureParameter, parameterType);
				} else {
					XComputedTypeReference computedParameterType = services.getXtypeFactory().createXComputedTypeReference();
					final int parameterIndex = i;
					computedParameterType.setTypeProvider(new AbstractReentrantTypeReferenceProvider() {
						@Override
						protected JvmTypeReference doGetTypeReference() {
							JvmTypeReference computedClosureType = closureType[0];
							if (computedClosureType == null) {
								return null;
							}
							JvmOperation operation = closures.findImplementingOperation(computedClosureType, object.eResource());
							if (operation == null) {
								return null;
							}
							JvmFormalParameter operationParameter = operation.getParameters().get(parameterIndex);
							JvmTypeReference operationParameterType = operationParameter.getParameterType();
							return operationParameterType;
						}
					});
					typeAssigner.assignType(closureParameter, computedParameterType);
				}
			}
			ITypeComputationResult expressionResult = typeAssigner.getForkedState().computeTypes(object.getExpression());
			if (expectedClosureType == null || operationReturnType == null) {
				final List<JvmTypeReference> closureParameterTypes = Lists.newArrayListWithCapacity(closureParameters.size());
				for(JvmFormalParameter parameter: closureParameters) {
					closureParameterTypes.add(expressionResult.getActualType(parameter));
				}
				JvmTypeReference expressionResultType = expressionResult.getActualExpressionType();
				expressionResultType = new TypeParameterSubstitutor(Collections.<JvmTypeParameter, MergedBoundTypeArgument>emptyMap(), services) {
					@Override
					public JvmTypeReference doVisitAnyTypeReference(JvmAnyTypeReference reference, Set<JvmTypeParameter> visited) {
						return operationReturnType;
					}
					@Override
					protected JvmTypeReference handleNullReference(Set<JvmTypeParameter> visited) {
						return operationReturnType;
					}
					@Override
					public JvmTypeReference doVisitComputedTypeReference(XComputedTypeReference reference, Set<JvmTypeParameter> visited) {
						if (closureParameterTypes.contains(reference)) {
							return reference;
						}
						return super.doVisitComputedTypeReference(reference, visited);
					}
				}.visit(expressionResultType, Sets.<JvmTypeParameter>newHashSet());
				if (expressionResultType == null) {
					expressionResultType = services.getTypeReferences().getTypeForName(Object.class, object);
				}
				closureType[0] = closures.createFunctionTypeRef(object, closureParameterTypes, expressionResultType, true);	
				expectation.acceptActualType(closureType[0], ConformanceHint.DEMAND_CONVERSION);
			} else {
				JvmTypeReference closureBodyType = expressionResult.getActualExpressionType();
				JvmType rawReturnType = operationReturnType.getType();
				if (rawReturnType instanceof JvmTypeParameter) {
					if (closureBodyType instanceof XComputedTypeReference && UnboundTypeParameters.isUnboundTypeParameter((XComputedTypeReference) closureBodyType)) {
						substitutor.enhanceMapping(Collections.singletonMap((JvmTypeParameter)rawReturnType, 
								new MergedBoundTypeArgument(closureBodyType, VarianceInfo.INVARIANT)));
					} else {
						substitutor.enhanceMapping(Collections.singletonMap((JvmTypeParameter)rawReturnType, 
								new MergedBoundTypeArgument(primitives.asWrapperTypeIfPrimitive(closureBodyType), VarianceInfo.INVARIANT)));
					}
				} else {
					substitutor.enhanceMapping(new DeclaratorTypeArgumentCollector().getTypeParameterMapping(closureBodyType));
				}
				JvmType expectedRawType = expectedClosureType.getType();
				closureType[0] = substitutor.substitute(services.getTypeReferences().createTypeRef(expectedRawType));
				expectation.acceptActualType(closureType[0], ConformanceHint.DEMAND_CONVERSION);
			}
		}
	}

	protected void _computeTypes(XCastedExpression object, ITypeComputationState state) {
		JvmTypeReference objectType = getTypeReferences().getTypeForName(Object.class, object);
		state.fork().withExpectation(objectType).computeTypes(object.getTarget());
		state.acceptActualType(object.getType());
	}

	protected void _computeTypes(final XForLoopExpression object, ITypeComputationState state) {
		JvmFormalParameter declaredParam = object.getDeclaredParam();
		JvmTypeReference parameterType = declaredParam.getParameterType();
		if (parameterType != null) {
			JvmTypeReference iterable = null;
			if (primitives.isPrimitive(parameterType)) {
				iterable = getTypeReferences().createArrayType(parameterType);
			} else {
				iterable = getTypeReferences().getTypeForName(Iterable.class, object, parameterType);
			}
			// TODO add synonymes automatically
			ITypeComputationState iterableState = state.fork().withExpectation(iterable);
			iterableState.computeTypes(object.getForExpression());
			
		} else {
			JvmTypeReference iterable = getTypeReferences().getTypeForName(Iterable.class, object, getTypeReferences().wildCard());
			// TODO add synonymes automatically
			ITypeComputationState iterableState = state.fork().withExpectation(iterable); 
			ITypeComputationResult forExpressionResult = iterableState.computeTypes(object.getForExpression());
			JvmTypeReference forExpressionType = forExpressionResult.getActualExpressionType();
			parameterType = new AbstractTypeReferenceVisitor.InheritanceAware<JvmTypeReference>() {
				@Override
				public JvmTypeReference doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference) {
					DeclaratorTypeArgumentCollector typeArgumentCollector = new DeclaratorTypeArgumentCollector();
					Map<JvmTypeParameter, MergedBoundTypeArgument> typeParameterMapping = typeArgumentCollector.getTypeParameterMapping(reference);
					TypeParameterSubstitutor substitutor = new TypeParameterSubstitutor(typeParameterMapping, services);
					JvmTypeReference iterableWithTypeParam = getTypeReferences().getTypeForName(Iterable.class, object);
					JvmTypeReference substitutedIterable = substitutor.substitute(iterableWithTypeParam);
					if (substitutedIterable instanceof JvmParameterizedTypeReference) {
						return ((JvmParameterizedTypeReference) substitutedIterable).getArguments().get(0);
					}
					// TODO use error type instead of JvmUnknownTypeReference
					return services.getTypesFactory().createJvmUnknownTypeReference();
				}
				@Override
				public JvmTypeReference doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference) {
					return reference.getComponentType();
				}
			}.visit(forExpressionType);
		}
		
		ITypeComputationState eachState = state.fork().withoutImmediateExpectation().assignType(declaredParam, parameterType);
		eachState.computeTypes(object.getEachExpression());
		
		JvmTypeReference primitiveVoid = getPrimitiveVoid(object);
		state.acceptActualType(primitiveVoid);
	}

	protected void _computeTypes(XAbstractWhileExpression object, ITypeComputationState state) {
		ITypeComputationState conditionExpectation = state.fork().withExpectation(getTypeReferences().getTypeForName(Boolean.TYPE, object));
		conditionExpectation.computeTypes(object.getPredicate());
		// TODO reassign type if instanceof clause is present and cannot be ignored due to binary boolean operations
		state.fork().withoutImmediateExpectation().computeTypes(object.getBody());
		
		JvmTypeReference primitiveVoid = getPrimitiveVoid(object);
		state.acceptActualType(primitiveVoid);
	}

	protected void _computeTypes(XTypeLiteral object, ITypeComputationState state) {
		JvmParameterizedTypeReference typeRef = services.getTypesFactory().createJvmParameterizedTypeReference();
		typeRef.setType(object.getType());
		state.acceptActualType(getTypeReferences().getTypeForName(Class.class, object, typeRef));
	}
	
	protected void _computeTypes(XInstanceOfExpression object, ITypeComputationState state) {
		ITypeComputationState expressionState = state.fork().withExpectation(getTypeReferences().getTypeForName(Object.class, object));
		expressionState.computeTypes(object.getExpression());
		JvmTypeReference bool = getTypeReferences().getTypeForName(Boolean.TYPE, object);
		state.acceptActualType(bool);
	}

	protected void _computeTypes(XThrowExpression object, ITypeComputationState state) {
		JvmTypeReference throwable = getTypeReferences().getTypeForName(Throwable.class, object);
		ITypeComputationState expressionState = state.fork().withExpectation(throwable);
		expressionState.computeTypes(object.getExpression());
		state.acceptActualType(getPrimitiveVoid(object));
	}

	protected void _computeTypes(XReturnExpression object, ITypeComputationState state) {
		ITypeComputationState expressionState = state.fork().withReturnExpectation();
		expressionState.computeTypes(object.getExpression());
		state.acceptActualType(getPrimitiveVoid(object));
	}
	
	protected JvmTypeReference getPrimitiveVoid(XExpression object) {
		return getTypeReferences().getTypeForName(Void.TYPE, object);
	}

	protected void _computeTypes(XTryCatchFinallyExpression object, ITypeComputationState state) {
		state.computeTypes(object.getExpression());
		for (XCatchClause catchClause : object.getCatchClauses()) {
			JvmFormalParameter catchClauseParam = catchClause.getDeclaredParam();
			ITypeComputationState catchClauseState = state.assignType(catchClauseParam, catchClauseParam.getParameterType());
			catchClauseState.computeTypes(catchClause.getExpression());
		}
		// TODO validate / handle return / throw in finally block
		state.fork().withoutImmediateExpectation().computeTypes(object.getFinallyExpression());
	}
	
	protected void _computeTypes(final XAbstractFeatureCall featureCall, ITypeComputationState state) {
		List<IFeatureLinkingCandidate> candidates = state.getLinkingCandidates(featureCall);
		IFeatureLinkingCandidate best = getBestCandidate(candidates);
		best.apply();
	}
	
	protected <Candidate extends ILinkingCandidate<Candidate>> Candidate getBestCandidate(List<Candidate> candidates) {
		Candidate result = candidates.get(0);
		for(int i = 1; i < candidates.size(); i++) {
			Candidate candidate = candidates.get(i);
			if (result.compareTo(candidate) > 0)
				result = candidate;
		}
		return result;
	}

	public JvmIdentifiableElement getRefinableCandidate(XExpression object, ITypeComputationState state) {
		if (object instanceof XSwitchExpression) {
			return (XSwitchExpression) object;
		}
		if (object instanceof XFeatureCall) {
			List<IFeatureLinkingCandidate> candidates = state.getLinkingCandidates((XFeatureCall)object);
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
