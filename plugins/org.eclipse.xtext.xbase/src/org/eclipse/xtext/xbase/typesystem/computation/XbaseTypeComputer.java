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

import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.AbstractTypeReferenceVisitor;
import org.eclipse.xtext.common.types.util.Primitives;
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
import org.eclipse.xtext.xbase.typesystem.internal.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.internal.TypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typing.Closures;
import org.eclipse.xtext.xbase.typing.NumberLiterals;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class XbaseTypeComputer extends AbstractTypeComputer {

	@Inject
	private TypesFactory typesFactory;

	@Inject
	private Closures closures;

	@Inject
	private NumberLiterals numberLiterals;
	
	@Inject
	private Primitives primitives;
	
	@Inject 
	private TypeReferences typeReferences;
	
	protected TypeReferences getTypeReferences() {
		return typeReferences;
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
		// assign the type for the switch expression if possible and use that one for the remaining things
		for(XCasePart casePart: object.getCases()) {
			ITypeComputationState casePartState = allCasePartsState.fork().withTypeCheckpoint();
			if (object.getLocalVarName() != null) {
				casePartState.reassignType(object, casePart.getTypeGuard());
			} else {
				casePartState.reassignType(object.getSwitch(), casePart.getTypeGuard());
			}
			if (casePart.getCase() != null) {
				ITypeComputationState caseState = casePartState.fork().withNonVoidExpectation(); // object or boolean
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

	protected void _computeTypes(XBlockExpression object, ITypeComputationState state) {
		List<XExpression> expressions = object.getExpressions();
		if (!expressions.isEmpty()) {
			for(XExpression expression: expressions.subList(0, expressions.size() - 1)) {
				ITypeComputationState expressionState = state.fork().withoutImmediateExpectation(); // no expectation
				expressionState.computeTypes(expression);
			}
			state.computeTypes(IterableExtensions.last(expressions));
		}
	}

	protected void _computeTypes(XVariableDeclaration object, ITypeComputationState state) {
		ITypeComputationState initializerState = state.fork().withExpectation(object.getType());
		ITypeComputationResult computedType = initializerState.computeTypes(object.getRight());
		state.assignType(object, computedType.getActualExpressionType());
		JvmTypeReference primitiveVoid = getPrimitiveVoid(object);
		state.acceptActualType(primitiveVoid);
	}

	protected void _computeTypes(final XConstructorCall constructorCall, ITypeComputationState state) {
		List<IConstructorLinkingCandidate> candidates = state.getLinkingCandidates(constructorCall);
		IConstructorLinkingCandidate best = getBestConstructorCandidate(candidates);
		best.apply();
	}
	
	protected IConstructorLinkingCandidate getBestConstructorCandidate(List<IConstructorLinkingCandidate> candidates) {
		IConstructorLinkingCandidate result = candidates.get(0);
		for(int i = 1; i < candidates.size(); i++) {
			result = getBetterCandidate(result, candidates.get(i));
		}
		return result;
	}

	protected IConstructorLinkingCandidate getBetterCandidate(IConstructorLinkingCandidate left,
			IConstructorLinkingCandidate right) {
		int leftArityMismatch = getArityMismatch(left);
		int rightArityMismatch = getArityMismatch(right);
		if (leftArityMismatch != rightArityMismatch) {
			if (leftArityMismatch == 0)
				return left;
			if (rightArityMismatch == 0)
				return right;
		}
		return left;
	}
	
	protected int getArityMismatch(IConstructorLinkingCandidate candidate) {
		JvmConstructor constructor = candidate.getConstructor();
		int fixedArityParamCount = constructor.getParameters().size();
		if (constructor.isVarArgs()) {
			fixedArityParamCount--;
			if (candidate.getArguments().size() >= fixedArityParamCount) {
				return 0;
			}
		}
		return fixedArityParamCount - candidate.getArguments().size();
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
		// TODO evaluate expectation, inline from numberLiterals?
		JvmTypeReference result = getTypeReferences().getTypeForName(numberLiterals.getJavaType(object), object);
		state.acceptActualType(result);
	}

	protected void _computeTypes(XStringLiteral object, ITypeComputationState state) {
		// TODO evaluate expecation to allow string literals with length == 1 to appear like a char or a Character
		JvmTypeReference result = getTypeReferences().getTypeForName(String.class, object);
		state.acceptActualType(result);
	}

	protected void _computeTypes(final XClosure object, ITypeComputationState state) {
		for(ITypeExpectation expectation: state.getImmediateExpectations()) {
			JvmTypeReference type = expectation.getExpectedType();
			// TODO - closure has no expected type - has to be function or procedure
			ITypeComputationState forked = state.fork().withoutExpectation();
			JvmOperation operation = null;
			List<JvmFormalParameter> operationParameters = Collections.emptyList();
			if (type != null) {
				operation = closures.findImplementingOperation(type, object.eResource());
				if (operation != null) {
					forked = forked.fork().withExpectation(operation.getReturnType());
					operationParameters = operation.getParameters();
				}
			}
			ITypeAssigner typeAssigner = forked.assignTypes();
			List<JvmFormalParameter> closureParameters = object.getFormalParameters();
			int paramCount = Math.min(closureParameters.size(), operationParameters.size());
			// TODO validate parameter count - check against operation if available
			for(int i = 0; i < paramCount; i++) {
				JvmFormalParameter closureParameter = closureParameters.get(i);
				typeAssigner.assignType(closureParameter, closureParameter.getParameterType(), operationParameters.get(i).getParameterType());
			}
			for(int i = paramCount; i < closureParameters.size(); i++) {
				JvmFormalParameter closureParameter = closureParameters.get(i);
				typeAssigner.assignType(closureParameter, closureParameter.getParameterType());
			}
			ITypeComputationResult expressionResult = typeAssigner.getForkedState().computeTypes(object.getExpression());
			JvmTypeReference closureType = null;
			if (type != null) {
				closureType = expressionResult.resolve(type);
			} else {
				List<JvmTypeReference> closureParameterTypes = Lists.newArrayListWithCapacity(closureParameters.size());
				for(JvmFormalParameter parameter: closureParameters) {
					closureParameterTypes.add(expressionResult.getActualType(parameter));
				}
				closureType = closures.createFunctionTypeRef(object, closureParameterTypes, expressionResult.getActualExpressionType(), true);	
			}
			expectation.acceptActualType(closureType, ConformanceHint.DEMAND_CONVERSION);
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
			ITypeComputationState iterableState = state.fork().withExpectation(iterable); // will add synonymes automatically
			iterableState.computeTypes(object.getForExpression());
			
		} else {
			JvmTypeReference iterable = getTypeReferences().getTypeForName(Iterable.class, object, getTypeReferences().wildCard());
			ITypeComputationState iterableState = state.fork().withExpectation(iterable); // will add synonymes automatically
			ITypeComputationResult forExpressionResult = iterableState.computeTypes(object.getForExpression());
			JvmTypeReference forExpressionType = forExpressionResult.getActualExpressionType();
			parameterType = new AbstractTypeReferenceVisitor.InheritanceAware<JvmTypeReference>() {
				@Override
				public JvmTypeReference doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference) {
					DeclaratorTypeArgumentCollector typeArgumentCollector = new DeclaratorTypeArgumentCollector();
					typeArgumentCollector.visit(reference);
					Map<JvmTypeParameter, JvmTypeReference> typeParameterMapping = typeArgumentCollector.getTypeParameterMapping();
					TypeParameterSubstitutor substitutor = new TypeParameterSubstitutor(typeParameterMapping, typesFactory);
					JvmTypeReference iterableWithTypeParam = getTypeReferences().getTypeForName(Iterable.class, object);
					JvmTypeReference substitutedIterable = substitutor.substitute(iterableWithTypeParam);
					if (substitutedIterable instanceof JvmParameterizedTypeReference) {
						return ((JvmParameterizedTypeReference) substitutedIterable).getArguments().get(0);
					}
					return typesFactory.createJvmUnknownTypeReference();
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
		// TODO reassign type if instanceof clause is present and cannot be ignored
		state.fork().withoutImmediateExpectation().computeTypes(object.getBody());
		
		JvmTypeReference primitiveVoid = getPrimitiveVoid(object);
		state.acceptActualType(primitiveVoid);
	}

	protected void _computeTypes(XTypeLiteral object, ITypeComputationState state) {
		JvmParameterizedTypeReference typeRef = typesFactory.createJvmParameterizedTypeReference();
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
		IFeatureLinkingCandidate best = getBestFeatureCandidate(candidates);
		best.apply();
	}
	
	protected IFeatureLinkingCandidate getBestFeatureCandidate(List<IFeatureLinkingCandidate> candidates) {
		IFeatureLinkingCandidate result = candidates.get(0);
		for(int i = 1; i < candidates.size(); i++) {
			result = getBetterCandidate(result, candidates.get(i));
		}
		return result;
	}

	protected IFeatureLinkingCandidate getBetterCandidate(IFeatureLinkingCandidate left, @SuppressWarnings("unused") IFeatureLinkingCandidate right) {
		return left;
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

}
