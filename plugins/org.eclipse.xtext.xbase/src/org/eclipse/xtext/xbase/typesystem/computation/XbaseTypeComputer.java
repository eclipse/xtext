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

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
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
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceVisitorWithResult;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.ConstraintAwareTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByConstraintSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;

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
	
	protected LightweightTypeReference getPrimitiveVoid(ITypeComputationState state) {
		return getTypeForName(Void.TYPE, state);
	}
	
	protected void _computeTypes(XIfExpression object, ITypeComputationState state) {
		ITypeComputationState conditionExpectation = state.withExpectation(getTypeForName(Boolean.TYPE, state));
		conditionExpectation.computeTypes(object.getIf());
		// TODO instanceof may specialize the types in the nested expression
		// TODO then expression may influence the expected type of else and vice versa
		state.computeTypes(getThen(object));
		XExpression elseExpression = getElse(object);
		if (elseExpression != null) {
			state.computeTypes(elseExpression);
		} else {
			AnyTypeReference anyType = new AnyTypeReference(state.getReferenceOwner());
			state.acceptActualType(anyType);
		}
	}

	/**
	 * Only for testing purpose.
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	protected XExpression getElse(XIfExpression ifExpression) {
		return ifExpression.getElse();
	}

	/**
	 * Only for testing purpose.
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	protected XExpression getThen(XIfExpression ifExpression) {
		return ifExpression.getThen();
	}
	
	protected void _computeTypes(XSwitchExpression object, ITypeComputationState state) {
		ITypeComputationState switchExpressionState = state.withNonVoidExpectation();
		ITypeComputationResult computedType = switchExpressionState.computeTypes(object.getSwitch());
		ITypeComputationState allCasePartsState = state;
		if (object.getLocalVarName() != null) {
			allCasePartsState = allCasePartsState.assignType(object, computedType.getActualExpressionType());
		}
		// TODO case expressions may influence the expected type of other cases
		for(XCasePart casePart: getCases(object)) {
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

	/**
	 * Only for testing purpose.
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	protected List<XCasePart> getCases(XSwitchExpression switchExpression) {
		return switchExpression.getCases();
	}
	
	protected void _computeTypes(XBlockExpression object, ITypeComputationState state) {
		for (ITypeExpectation expectation: state.getExpectations()) {
			LightweightTypeReference expectedType = expectation.getExpectedType();
			if (expectedType != null && expectedType.isPrimitiveVoid()) {
				List<XExpression> expressions = object.getExpressions();
				if (!expressions.isEmpty()) {
					for(XExpression expression: expressions) {
						ITypeComputationState expressionState = state.withoutExpectation(); // no expectation
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
						ITypeComputationState expressionState = state.withoutExpectation();
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
		if (object.getValue().length() != 1) {
			LightweightTypeReference result = getTypeForName(String.class, state);
			state.acceptActualType(result);
		} else {
			for(ITypeExpectation expectation: state.getExpectations()) {
				LightweightTypeReference expectedType = expectation.getExpectedType();
				if (expectedType != null) {
					if (expectedType.isType(Character.TYPE) || expectedType.isType(Character.class)) {
						LightweightTypeReference charType = getTypeForName(Character.TYPE, state);
						expectation.acceptActualType(charType, ConformanceHint.UNCHECKED, ConformanceHint.DEMAND_CONVERSION);
					} else {
						LightweightTypeReference type = getTypeForName(String.class, state);
						expectation.acceptActualType(type, ConformanceHint.UNCHECKED);
					}
				} else {
					LightweightTypeReference type = getTypeForName(String.class, state);
					expectation.acceptActualType(type, ConformanceHint.UNCHECKED);
				}
			}
		}
	}
	
	protected void _computeTypes(XClosure object, ITypeComputationState state) {
		for(ITypeExpectation expectation: state.getExpectations()) {
			new ClosureTypeComputer(object, expectation, state).computeTypes();
		}
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
			if (forExpressionType.isResolved() && iterable.isAssignableFrom(forExpressionType)) {
				iterableState.refineExpectedType(object.getForExpression(), forExpressionType);
			}
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
		ITypeComputationState eachState = state.withoutExpectation().assignType(declaredParam, parameterType);
		eachState.computeTypes(object.getEachExpression());
		
		LightweightTypeReference primitiveVoid = getPrimitiveVoid(state);
		state.acceptActualType(primitiveVoid);
	}

	protected void _computeTypes(XAbstractWhileExpression object, ITypeComputationState state) {
		ITypeComputationState conditionExpectation = state.withExpectation(getTypeForName(Boolean.TYPE, state));
		conditionExpectation.computeTypes(object.getPredicate());
		// TODO reassign type if instanceof clause is present and cannot be ignored due to binary boolean operations
		state.withoutExpectation().computeTypes(object.getBody());
		
		LightweightTypeReference primitiveVoid = getPrimitiveVoid(state);
		state.acceptActualType(primitiveVoid);
	}

	protected void _computeTypes(XTypeLiteral object, ITypeComputationState state) {
		LightweightTypeReference clazz = new ParameterizedTypeReference(state.getReferenceOwner(), object.getType());
		for (int i = 0; i < object.getArrayDimensions().size(); i++) {
			clazz = new ArrayTypeReference(clazz.getOwner(), clazz);
		}
		if (object.getArrayDimensions().isEmpty()) {
			if (clazz.isPrimitiveVoid()) {
				JvmType voidType = services.getTypeReferences().findDeclaredType(Void.class, object);
				clazz = new ParameterizedTypeReference(state.getReferenceOwner(), voidType);
			} else {
				clazz = clazz.getWrapperTypeIfPrimitive();
			}
		}
		JvmType clazzType = services.getTypeReferences().findDeclaredType(Class.class, object);
		ParameterizedTypeReference result = new ParameterizedTypeReference(state.getReferenceOwner(), clazzType);
		result.addTypeArgument(clazz);
		state.acceptActualType(result);
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
	
	protected void _computeTypes(XTryCatchFinallyExpression object, ITypeComputationState state) {
		state.computeTypes(object.getExpression());
		for (XCatchClause catchClause : object.getCatchClauses()) {
			JvmFormalParameter catchClauseParam = catchClause.getDeclaredParam();
			LightweightTypeReference lightweightReference = state.getConverter().toLightweightReference(catchClauseParam.getParameterType());
			ITypeComputationState catchClauseState = state.assignType(catchClauseParam, lightweightReference);
			catchClauseState.computeTypes(catchClause.getExpression());
		}
		// TODO validate / handle return / throw in finally block
		state.withoutExpectation().computeTypes(object.getFinallyExpression());
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
