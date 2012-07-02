/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
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
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeAssigner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeComputationResult;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeComputationState;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeExpectation;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceVisitorWithResult;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.ActualTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentMerger;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.ConstraintAwareTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByConstraintSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameterPreservingSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;
import org.eclipse.xtext.xbase.typing.NumberLiterals;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, is @Singleton actually necessary?
 */
@Singleton
public class XbaseTypeComputer extends AbstractTypeComputer {

	@Inject
	private FunctionTypes functionTypes;

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
	public void computeTypes(XExpression expression, LightweightTypeComputationState state) {
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
	
	protected void _computeTypes(XIfExpression object, LightweightTypeComputationState state) {
		LightweightTypeComputationState conditionExpectation = state.fork().withExpectation(getTypeReferences().getTypeForName(Boolean.TYPE, object));
		conditionExpectation.computeTypes(object.getIf());
		// TODO instanceof may specialize the types in the nested expression
		// TODO then expression may influence the expected type of else and vice versa
		state.computeTypes(object.getThen());
		XExpression elseExpression = object.getElse();
		if (elseExpression != null) {
			state.computeTypes(object.getElse());
		} else {
			JvmAnyTypeReference anyType = getTypeReferences().createAnyTypeReference(object);
			state.acceptActualType(anyType);
		}
	}
	
	protected void _computeTypes(XSwitchExpression object, LightweightTypeComputationState state) {
		LightweightTypeComputationState switchExpressionState = state.fork().withNonVoidExpectation();
		ITypeComputationResult computedType = switchExpressionState.computeTypes(object.getSwitch());
		LightweightTypeComputationState allCasePartsState = state;
		if (object.getLocalVarName() != null) {
			allCasePartsState = allCasePartsState.assignType(object, computedType.getActualExpressionType());
		}
		// TODO case expressions may influence the expected type of other cases
		for(XCasePart casePart: object.getCases()) {
			// assign the type for the switch expression if possible and use that one for the remaining things
			LightweightTypeComputationState casePartState = allCasePartsState.fork().withTypeCheckpoint();
			if (object.getLocalVarName() != null) {
				casePartState.reassignType(object, casePart.getTypeGuard());
			} else {
				casePartState.reassignType(object.getSwitch(), casePart.getTypeGuard());
			}
			if (casePart.getCase() != null) {
				// boolean or object / primitive
				LightweightTypeComputationState caseState = casePartState.fork().withNonVoidExpectation(); 
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
	
	protected void _computeTypes(XBlockExpression object, LightweightTypeComputationState state) {
		List<XExpression> expressions = object.getExpressions();
		if (!expressions.isEmpty()) {
			for(XExpression expression: expressions.subList(0, expressions.size() - 1)) {
				LightweightTypeComputationState expressionState = state.fork().withoutImmediateExpectation(); // no expectation
				expressionState.computeTypes(expression);
				if (expression instanceof XVariableDeclaration) {
					state.addLocalToCurrentScope((XVariableDeclaration)expression);
				}
			}
			state.computeTypes(IterableExtensions.last(expressions));
		} else {
			// TODO is that actually 'any' if non void expectation?
			JvmTypeReference primitiveVoid = getPrimitiveVoid(object);
			state.acceptActualType(primitiveVoid);
		}
	}

	protected void _computeTypes(XVariableDeclaration object, LightweightTypeComputationState state) {
		JvmTypeReference declaredType = object.getType();
		LightweightTypeComputationState initializerState = declaredType != null ? state.fork().withExpectation(declaredType) : state.fork().withNonVoidExpectation();
		ITypeComputationResult computedType = initializerState.computeTypes(object.getRight());
		// TODO keep information about the actual type 
		state.assignType(object, declaredType != null ? declaredType : computedType.getActualExpressionType());
		JvmTypeReference primitiveVoid = getPrimitiveVoid(object);
		state.acceptActualType(primitiveVoid);
	}

	protected void _computeTypes(final XConstructorCall constructorCall, LightweightTypeComputationState state) {
		List<IConstructorLinkingCandidate> candidates = state.getLinkingCandidates(constructorCall);
		IConstructorLinkingCandidate best = getBestCandidate(candidates);
		best.apply();
	}
	
	protected void _computeTypes(XBooleanLiteral object, LightweightTypeComputationState state) {
		JvmTypeReference bool = getTypeReferences().getTypeForName(Boolean.TYPE, object);
		state.acceptActualType(bool);
	}

	protected void _computeTypes(XNullLiteral object, LightweightTypeComputationState state) {
		JvmAnyTypeReference any = getTypeReferences().createAnyTypeReference(object);
		state.acceptActualType(any);
	}

	protected void _computeTypes(XNumberLiteral object, LightweightTypeComputationState state) {
		// TODO evaluate expectation if no specific suffix is given
		JvmTypeReference result = getTypeReferences().getTypeForName(numberLiterals.getJavaType(object), object);
		state.acceptActualType(result);
	}

	protected void _computeTypes(XStringLiteral object, LightweightTypeComputationState state) {
		// TODO evaluate expectation to allow string literals with length == 1 to appear like a char or a Character
		JvmTypeReference result = getTypeReferences().getTypeForName(String.class, object);
		state.acceptActualType(result);
	}
	
	protected List<JvmTypeParameter> collectAllTypeParameters(LightweightTypeReference closureType,
			JvmOperation operation) {
		List<JvmType> rawTypes = closureType.getRawTypes();
		List<JvmTypeParameter> allTypeParameters = Lists.newArrayList();
		for(JvmType rawType: rawTypes) {
			if (rawType instanceof JvmTypeParameterDeclarator) {
				allTypeParameters.addAll(((JvmTypeParameterDeclarator) rawType).getTypeParameters());
			}
		}
		allTypeParameters.addAll(operation.getTypeParameters());
		return allTypeParameters;
	}
	
	protected void _computeTypes(XClosure object, LightweightTypeComputationState state) {
		for(LightweightTypeExpectation expectation: state.getImmediateExpectations()) {
			List<JvmFormalParameter> closureParameters = object.getFormalParameters();
			LightweightTypeReference closureType = expectation.internalGetExpectedType();
			JvmOperation operation = null;
			if (closureType == null) {
				// TODO - closure has no expected type - has to be function or procedure
				closureType = functionTypes.createRawFunctionTypeRef(state.getReferenceOwner(), object, closureParameters.size(), false);
				operation = functionTypes.findImplementingOperation(closureType);
			} else {
				operation = functionTypes.findImplementingOperation(closureType);
				if (operation == null) {
					closureType = functionTypes.createRawFunctionTypeRef(state.getReferenceOwner(), object, closureParameters.size(), false);
					operation = functionTypes.findImplementingOperation(closureType);
				}
			}
			if (operation == null || closureType == null) {
				throw new IllegalStateException("Cannot locate appropriate operation for " + object); 
			}
			
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping = getTypeParameterMapping(
					object, closureType, operation, state);
			UnboundTypeParameterPreservingSubstitutor substitutor = state.createSubstitutor(typeParameterMapping);
			LightweightTypeReference declaredReturnType = getSubstitutedClosureReturnType(operation, substitutor, state);
			LightweightTypeAssigner typeAssigner = state.fork().withExpectation(declaredReturnType).assignTypes();
			LightweightTypeComputationState closureBodyTypeComputationState = getClosureBodyTypeComputationState(
					closureParameters, substitutor, operation.getParameters(), typeAssigner);
			LightweightTypeComputationResult expressionResult = closureBodyTypeComputationState.computeTypes(object.getExpression());
			List<LightweightTypeReference> closureParameterTypes = getClosureParameterTypes(closureParameters, expressionResult, expectation.getConverter());
			LightweightTypeReference expressionResultType = getClosureBodyType(declaredReturnType, expressionResult);
			LightweightTypeReference substitutedClosureType = substitutor.substitute(closureType);
			LightweightTypeReference result = createFunctionTypeReference(expectation.getReferenceOwner(), substitutedClosureType, closureParameterTypes, expressionResultType);
			expectation.acceptActualType(result, ConformanceHint.DEMAND_CONVERSION);
		}
	}

	protected LightweightTypeReference createFunctionTypeReference(TypeReferenceOwner owner, LightweightTypeReference closureType,
			List<LightweightTypeReference> parameterTypes, LightweightTypeReference expressionResultType) {
		LightweightTypeReference result = functionTypes.createFunctionTypeRef(owner, closureType, parameterTypes, expressionResultType);
		return result;
	}

	protected LightweightTypeReference getClosureBodyType(LightweightTypeReference declaredReturnType,
			LightweightTypeComputationResult expressionResult) {
		LightweightTypeReference expressionResultType = expressionResult.internalGetActualExpressionType();
		if (expressionResultType == null || expressionResultType instanceof AnyTypeReference) {
			expressionResultType = declaredReturnType;
		}
		return expressionResultType;
	}

	protected List<LightweightTypeReference> getClosureParameterTypes(List<JvmFormalParameter> closureParameters,
			LightweightTypeComputationResult expressionResult, OwnedConverter state) {
		List<LightweightTypeReference> closureParameterTypes = Lists.newArrayListWithCapacity(closureParameters.size());
		for(JvmFormalParameter parameter: closureParameters) {
			closureParameterTypes.add(state.toLightweightReference(expressionResult.getActualType(parameter)));
		}
		return closureParameterTypes;
	}

	protected LightweightTypeComputationState getClosureBodyTypeComputationState(
			List<JvmFormalParameter> closureParameters, UnboundTypeParameterPreservingSubstitutor substitutor,
			List<JvmFormalParameter> operationParameters, LightweightTypeAssigner typeAssigner) {
		int paramCount = Math.min(closureParameters.size(), operationParameters.size());
		// TODO validate parameter count - check against operation if available
		for(int i = 0; i < paramCount; i++) {
			JvmFormalParameter closureParameter = closureParameters.get(i);
			JvmTypeReference declaredParameterType = operationParameters.get(i).getParameterType();
			LightweightTypeReference lightweightParameterType = typeAssigner.toLightweightTypeReference(declaredParameterType);
			LightweightTypeReference resolvedDeclaredType = substitutor.substitute(lightweightParameterType);
			JvmTypeReference closureParameterType = closureParameter.getParameterType();
			typeAssigner.assignType(closureParameter, closureParameterType != null ? typeAssigner.toLightweightTypeReference(closureParameter.getParameterType()) : null, resolvedDeclaredType);
		}
		for(int i = paramCount; i < closureParameters.size(); i++) {
			JvmFormalParameter closureParameter = closureParameters.get(i);
			JvmTypeReference parameterType = closureParameter.getParameterType();
			if (parameterType != null) {
				typeAssigner.assignType(closureParameter, parameterType);
			} else {
				typeAssigner.assignType(closureParameter, services.getTypeReferences().getTypeForName(Object.class, closureParameter));
			}
		}
		return typeAssigner.getForkedState();
	}

	protected LightweightTypeReference getSubstitutedClosureReturnType(JvmOperation operation,
			UnboundTypeParameterPreservingSubstitutor substitutor, LightweightTypeComputationState state) {
		LightweightTypeReference result = substitutor.substitute(state.toLightweightTypeReference(operation.getReturnType()));
		return result;
	}

	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getTypeParameterMapping(XClosure object,
			LightweightTypeReference closureType, JvmOperation operation, LightweightTypeComputationState state) {
		List<JvmTypeParameter> allTypeParameters = collectAllTypeParameters(closureType, operation);
		ListMultimap<JvmTypeParameter, LightweightBoundTypeArgument> typeParameterMapping = getClosureTypeParameterMapping(
				closureType, operation, allTypeParameters, state);
		
		Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> expectedTypeParameterMapping = Maps.newLinkedHashMap();
		for(JvmTypeParameter typeParameter: allTypeParameters) {
			List<LightweightBoundTypeArgument> boundInformation = typeParameterMapping.get(typeParameter);
			if (boundInformation.isEmpty()) {
				UnboundTypeReference unboundTypeReference = state.createUnboundTypeReference(object, typeParameter);
				// TODO use VarianceInfo.IN / .OUT respectively if direct arg in operation
				LightweightMergedBoundTypeArgument boundTypeArgument = new LightweightMergedBoundTypeArgument(unboundTypeReference, VarianceInfo.INVARIANT);
				expectedTypeParameterMapping.put(typeParameter, boundTypeArgument);
			} else {
				LightweightMergedBoundTypeArgument boundTypeArgument = typeArgumentMerger.merge(typeParameterMapping.get(typeParameter), state.getReferenceOwner());
				expectedTypeParameterMapping.put(typeParameter, boundTypeArgument);
			}
		}
		return expectedTypeParameterMapping;
	}

	protected ListMultimap<JvmTypeParameter, LightweightBoundTypeArgument> getClosureTypeParameterMapping(
			LightweightTypeReference closureType, JvmOperation operation, List<JvmTypeParameter> allTypeParameters, LightweightTypeComputationState state) {
		ActualTypeArgumentCollector typeArgumentCollector = state.createTypeArgumentCollector(allTypeParameters, BoundTypeArgumentSource.INFERRED);
		JvmParameterizedTypeReference operationTypeDeclarator = services.getTypeReferences().createTypeRef(operation.getDeclaringType());
		LightweightTypeReference lightweightTypeReference = state.toLightweightTypeReference(operationTypeDeclarator);
		typeArgumentCollector.populateTypeParameterMapping(lightweightTypeReference, closureType);
		ListMultimap<JvmTypeParameter, LightweightBoundTypeArgument> typeParameterMapping = typeArgumentCollector.rawGetTypeParameterMapping();
		return typeParameterMapping;
	}
	
	protected void _computeTypes(XCastedExpression object, LightweightTypeComputationState state) {
		JvmTypeReference objectType = getTypeReferences().getTypeForName(Object.class, object);
		state.fork().withExpectation(objectType).computeTypes(object.getTarget());
		state.acceptActualType(object.getType());
	}

	protected void _computeTypes(final XForLoopExpression object, final LightweightTypeComputationState state) {
		JvmFormalParameter declaredParam = object.getDeclaredParam();
		LightweightTypeReference parameterType = null;
		if (declaredParam.getParameterType() != null) {
			parameterType = state.toLightweightTypeReference(declaredParam.getParameterType());
			LightweightTypeReference iterable = null;
			if (parameterType.isPrimitive()) {
				iterable = new ArrayTypeReference(state.getReferenceOwner(), parameterType);
			} else {
				ParameterizedTypeReference reference = new ParameterizedTypeReference(state.getReferenceOwner(), getTypeReferences().findDeclaredType(Iterable.class, object));
				WildcardTypeReference wildcard = new WildcardTypeReference(state.getReferenceOwner());
				wildcard.addUpperBound(parameterType);
				reference.addTypeArgument(wildcard);
				iterable = reference;
			}
			// TODO add synonymes automatically
			LightweightTypeComputationState iterableState = state.fork().withExpectation(iterable);
			iterableState.computeTypes(object.getForExpression());
			
		} else {
			JvmTypeReference iterable = getTypeReferences().getTypeForName(Iterable.class, object, getTypeReferences().wildCard());
			// TODO add synonymes automatically
			LightweightTypeComputationState iterableState = state.fork().withExpectation(iterable); 
			LightweightTypeComputationResult forExpressionResult = iterableState.computeTypes(object.getForExpression());
			LightweightTypeReference forExpressionType = forExpressionResult.internalGetActualExpressionType();
			parameterType = forExpressionType.accept(new TypeReferenceVisitorWithResult<LightweightTypeReference>() {
				@Override
				public LightweightTypeReference doVisitParameterizedTypeReference(@NonNull ParameterizedTypeReference reference) {
					DeclaratorTypeArgumentCollector typeArgumentCollector = new ConstraintAwareTypeArgumentCollector(state.getReferenceOwner());
					Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping = typeArgumentCollector.getTypeParameterMapping(reference);
					TypeParameterSubstitutor<?> substitutor = new TypeParameterByConstraintSubstitutor(typeParameterMapping, state.getReferenceOwner());
					JvmGenericType iterable = (JvmGenericType) getTypeReferences().findDeclaredType(Iterable.class, object);
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
		LightweightTypeComputationState eachState = state.fork().withoutImmediateExpectation().assignType(declaredParam, parameterType);
		eachState.computeTypes(object.getEachExpression());
		
		JvmTypeReference primitiveVoid = getPrimitiveVoid(object);
		state.acceptActualType(primitiveVoid);
	}

	protected void _computeTypes(XAbstractWhileExpression object, LightweightTypeComputationState state) {
		LightweightTypeComputationState conditionExpectation = state.fork().withExpectation(getTypeReferences().getTypeForName(Boolean.TYPE, object));
		conditionExpectation.computeTypes(object.getPredicate());
		// TODO reassign type if instanceof clause is present and cannot be ignored due to binary boolean operations
		state.fork().withoutImmediateExpectation().computeTypes(object.getBody());
		
		JvmTypeReference primitiveVoid = getPrimitiveVoid(object);
		state.acceptActualType(primitiveVoid);
	}

	protected void _computeTypes(XTypeLiteral object, LightweightTypeComputationState state) {
		JvmParameterizedTypeReference typeRef = services.getTypesFactory().createJvmParameterizedTypeReference();
		typeRef.setType(object.getType());
		state.acceptActualType(getTypeReferences().getTypeForName(Class.class, object, typeRef));
	}
	
	protected void _computeTypes(XInstanceOfExpression object, LightweightTypeComputationState state) {
		LightweightTypeComputationState expressionState = state.fork().withExpectation(getTypeReferences().getTypeForName(Object.class, object));
		expressionState.computeTypes(object.getExpression());
		JvmTypeReference bool = getTypeReferences().getTypeForName(Boolean.TYPE, object);
		state.acceptActualType(bool);
	}

	protected void _computeTypes(XThrowExpression object, LightweightTypeComputationState state) {
		JvmTypeReference throwable = getTypeReferences().getTypeForName(Throwable.class, object);
		LightweightTypeComputationState expressionState = state.fork().withExpectation(throwable);
		expressionState.computeTypes(object.getExpression());
		state.acceptActualType(getPrimitiveVoid(object));
	}

	protected void _computeTypes(XReturnExpression object, LightweightTypeComputationState state) {
		LightweightTypeComputationState expressionState = state.fork().withReturnExpectation();
		expressionState.computeTypes(object.getExpression());
		state.acceptActualType(getPrimitiveVoid(object));
	}
	
	protected JvmTypeReference getPrimitiveVoid(XExpression object) {
		return getTypeReferences().getTypeForName(Void.TYPE, object);
	}

	protected void _computeTypes(XTryCatchFinallyExpression object, LightweightTypeComputationState state) {
		state.computeTypes(object.getExpression());
		for (XCatchClause catchClause : object.getCatchClauses()) {
			JvmFormalParameter catchClauseParam = catchClause.getDeclaredParam();
			LightweightTypeComputationState catchClauseState = state.assignType(catchClauseParam, catchClauseParam.getParameterType());
			catchClauseState.computeTypes(catchClause.getExpression());
		}
		// TODO validate / handle return / throw in finally block
		state.fork().withoutImmediateExpectation().computeTypes(object.getFinallyExpression());
	}
	
	protected void _computeTypes(final XAbstractFeatureCall featureCall, LightweightTypeComputationState state) {
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

	public JvmIdentifiableElement getRefinableCandidate(XExpression object, LightweightTypeComputationState state) {
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
	
//	protected void _computeTypes(final XAssignment context, LightweightTypeComputationState state) {
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
