/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import static com.google.common.collect.Lists.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAbstractWhileExpression;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XCollectionLiteral;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XListLiteral;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSetLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputationArgument;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceResult;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceVisitorWithResult;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.ConstraintAwareTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameterPreservingSubstitutor;

import com.google.inject.Inject;

/**
 * Base implementation for the {@link ITypeComputer}. The interface contract 
 * fully applies to this class.
 * 
 * This implementation handles all expression that are defined in Xbase.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class XbaseTypeComputer implements ITypeComputer {

	@Inject
	private NumberLiterals numberLiterals;
	
	@Inject 
	private CommonTypeComputationServices services;
	
	public void computeTypes(XExpression expression, ITypeComputationState state) {
		if (expression instanceof XAssignment) {
			_computeTypes((XAssignment)expression, state);
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
		} else if (expression instanceof XListLiteral) {
			_computeTypes((XListLiteral)expression, state);
		} else if (expression instanceof XSetLiteral) {
			_computeTypes((XSetLiteral)expression, state);
		} else { 
			throw new UnsupportedOperationException("Missing type computation for expression type: " + expression.eClass().getName() + " / " + state);
		}
	}

	protected LightweightTypeReference getTypeForName(Class<?> clazz, ITypeComputationState state) {
		ResourceSet resourceSet = state.getReferenceOwner().getContextResourceSet();
		JvmTypeReference typeReference = services.getTypeReferences().getTypeForName(clazz, resourceSet);
		if (typeReference == null)
			throw new IllegalStateException("Cannot find type " + clazz.getCanonicalName());
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
		XExpression thenExpression = getThen(object);
		ITypeComputationResult thenResult = state.computeTypes(thenExpression);
		XExpression elseExpression = getElse(object);
		if (elseExpression != null) {
			state.computeTypes(elseExpression);
		} else {
			LightweightTypeReference expressionReturnType = thenResult.getReturnType();
			if (expressionReturnType != null && expressionReturnType.isPrimitiveVoid()) {
				for(ITypeExpectation expectation: state.getExpectations()) {
					if (!expectation.isVoidTypeAllowed()) {
						AnyTypeReference anyType = new AnyTypeReference(state.getReferenceOwner());
						expectation.acceptActualType(anyType, ConformanceHint.UNCHECKED);
					}
				}
				return;
			}
			AnyTypeReference anyType = new AnyTypeReference(state.getReferenceOwner());
			state.acceptActualType(anyType);
		}
	}

	/**
	 * Only for testing purpose.
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	@Nullable
	protected XExpression getElse(XIfExpression ifExpression) {
		return ifExpression.getElse();
	}

	/**
	 * Only for testing purpose.
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	@Nullable
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
		boolean casesAreVoid = true;
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
			ITypeComputationResult thenResult = casePartState.computeTypes(casePart.getThen());
			if (casesAreVoid) {
				LightweightTypeReference expressionReturnType = thenResult.getReturnType();
				if (expressionReturnType == null || !expressionReturnType.isPrimitiveVoid()) {
					casesAreVoid = false;
				}
			}
		}
		XExpression defaultCase = object.getDefault();
		if (defaultCase != null) {
			allCasePartsState.computeTypes(object.getDefault());
		} else {
			if (casesAreVoid) {
				for(ITypeExpectation expectation: state.getExpectations()) {
					if (!expectation.isVoidTypeAllowed()) {
						AnyTypeReference anyType = new AnyTypeReference(state.getReferenceOwner());
						expectation.acceptActualType(anyType, ConformanceHint.UNCHECKED);
					}
				}
				return;
			}
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
					XExpression lastExpression = IterableExtensions.last(expressions);
					state.computeTypes(lastExpression);
					// add the last expression to the scope, too in order validate for duplicate names, even
					// though the variable declaration could be removed automatically to keep only the side effect
					// of the initializer
					if (lastExpression instanceof XVariableDeclaration) {
						state.addLocalToCurrentScope((XVariableDeclaration) lastExpression);
					}
				} else {
					expectation.acceptActualType(new AnyTypeReference(expectation.getReferenceOwner()), ConformanceHint.UNCHECKED);
				}
			}
		}
	}

	protected void _computeTypes(XVariableDeclaration object, ITypeComputationState state) {
		JvmTypeReference declaredType = object.getType();
		LightweightTypeReference lightweightTypeReference = declaredType != null ? state.getConverter().toLightweightReference(declaredType) : null;
		/*
		 * Allow recursive closure bodies, e.g.
		 * 
		 * val (Integer)=>BigInteger fib = [ idx |
		 * 		if (idx < 2) {
		 * 			BigInteger::ONE
		 * 		} else {
		 * 			fib.apply(idx - 1) + fib.apply(idx - 2)
		 * 		}
		 * 	]
		 * 
		 * Actually this should be even smarter, but it's not possible to decide whether 'apply' is called on the closure
		 * before it is produced if the closure is not assigned to the local variable directly.
		 * 
		 * TODO Do we need an annotation to mark functions as not eagerly called, e.g. @Lazy
		 * 
		 * This would allow 
		 * 
		 * val (Integer)=>BigInteger fib = [ idx |
		 * 		if (idx < 2) {
		 * 			BigInteger::ONE
		 * 		} else {
		 * 			fib.apply(idx - 1) + fib.apply(idx - 2)
		 * 		}
		 * 	].memoize()
		 * 
		 * where memoize() is an extension method like in
		 * http://pragprog.com/magazines/2013-01/using-memoization-in-groovy
		 */
		if (lightweightTypeReference != null && object.getRight() instanceof XClosure) {
			ITypeComputationState initializerState = state.assignType(object, lightweightTypeReference).withExpectation(lightweightTypeReference);
			initializerState.computeTypes(object.getRight());
		} else {
			ITypeComputationState initializerState = lightweightTypeReference != null ? state.withExpectation(lightweightTypeReference) : state.withNonVoidExpectation();
			ITypeComputationResult computedType = initializerState.computeTypes(object.getRight());
			/* 
			 * TODO keep information about the actual type, e.g. automatic cast insertion should be possible for
			 * 
			 * val Object o = ""
			 * o.substring(1)
			 */
			state.assignType(object, lightweightTypeReference != null ? lightweightTypeReference : computedType.getActualExpressionType(), false);
		}
		LightweightTypeReference primitiveVoid = getPrimitiveVoid(state);
		state.acceptActualType(primitiveVoid);
	}

	protected void _computeTypes(final XConstructorCall constructorCall, ITypeComputationState state) {
		List<? extends IConstructorLinkingCandidate> candidates = state.getLinkingCandidates(constructorCall);
		ILinkingCandidate best = getBestCandidate(candidates);
		best.applyToComputationState();
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
		if (object.getValue().length() != 1) {
			LightweightTypeReference result = getTypeForName(String.class, state);
			state.acceptActualType(result);
		} else {
			for(ITypeExpectation expectation: state.getExpectations()) {
				LightweightTypeReference expectedType = expectation.getExpectedType();
				if (expectedType != null) {
					if (expectedType.isType(Character.TYPE) || expectedType.isType(Character.class)) {
						LightweightTypeReference charType = getTypeForName(Character.TYPE, state);
						expectation.acceptActualType(charType, ConformanceHint.CHECKED, ConformanceHint.SUCCESS, ConformanceHint.DEMAND_CONVERSION);
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
	
	protected void _computeTypes(XListLiteral object, ITypeComputationState state) {
		JvmGenericType list = (JvmGenericType) services.getTypeReferences().findDeclaredType(List.class, object);
		computeCollectionLiteralTypes(object, list, state);
	}
	
	protected void _computeTypes(XSetLiteral object, ITypeComputationState state) {
		JvmGenericType set = (JvmGenericType) services.getTypeReferences().findDeclaredType(Set.class, object);
		computeCollectionLiteralTypes(object, set, state);
	}
	
	protected void computeCollectionLiteralTypes(XCollectionLiteral literal, JvmGenericType collectionType, ITypeComputationState state) {
		for(ITypeExpectation expectation: state.getExpectations()) {
			List<LightweightTypeReference> collectionTypeCandidates = newArrayList();
			LightweightTypeReference elementTypeExpectation = null;
			LightweightTypeReference expectedType = expectation.getExpectedType();
			if(expectedType != null) {
				if(expectedType.isArray()) {
					elementTypeExpectation = expectedType.getComponentType();
					for(XExpression element: literal.getElements()) 
						state.withExpectation(elementTypeExpectation).computeTypes(element);
					expectation.acceptActualType(expectedType, ConformanceHint.UNCHECKED);
					return; 
				} else if(expectedType.isSubtypeOf(Collection.class) &&
						!expectedType.getTypeArguments().isEmpty()) {
					elementTypeExpectation = expectedType.getTypeArguments().get(0).getInvariantBoundSubstitute();
				}
			}
			if(!literal.getElements().isEmpty()) {
				for(XExpression element: literal.getElements()) {
					ITypeComputationResult elementType = state.withExpectation(elementTypeExpectation).computeTypes(element);
					if(!elementType.getActualExpressionType().isAny()) {
						ParameterizedTypeReference collectionTypeCandidate = new ParameterizedTypeReference(state.getReferenceOwner(), collectionType);
						collectionTypeCandidate.addTypeArgument(elementType.getActualExpressionType().getWrapperTypeIfPrimitive());
						collectionTypeCandidates.add(collectionTypeCandidate);
					}
				}
			}
			if(!collectionTypeCandidates.isEmpty()) {
				LightweightTypeReference commonListType = services.getTypeConformanceComputer().getCommonSuperType(collectionTypeCandidates);
				expectation.acceptActualType(commonListType, ConformanceHint.UNCHECKED);
			} else {
				ParameterizedTypeReference unboundCollectionType = new ParameterizedTypeReference(state.getReferenceOwner(), collectionType);
				unboundCollectionType.addTypeArgument(expectation.createUnboundTypeReference(literal, collectionType.getTypeParameters().get(0)));
				expectation.acceptActualType(unboundCollectionType, ConformanceHint.UNCHECKED);
			}
		}
	}
	
	protected void _computeTypes(XClosure object, ITypeComputationState state) {
		for(ITypeExpectation expectation: state.getExpectations()) {
			new ClosureTypeComputer(object, expectation, state).computeTypes();
		}
	}

	protected void _computeTypes(XCastedExpression object, ITypeComputationState state) {
		// TODO: should we hold on the previously known expression?
		/* 
		 * ('foo' as CharSequence) as NullPointerException
		 * In this case, we know - even though it's CharSequence on the Java side - 
		 * that the type of ('foo' as CharSequence) is still a String
		 * which is not conformant to NPE. The subsequent cast will always fail at
		 * runtime. This could be detected.
		 * 
		 * It could be interesting to have a subtype of MultiTypeReference, e.g. CastedTypeReference
		 * that still knows about the original type. This would be similar to a nested switch
		 * with the difference, that we want to know which type to use on the Java side in order
		 * to disambiguate overloaded methods:
		 * 
		 * m(Object o) {} // 1
		 * m(String s) {}
		 * 
		 * {
		 *   val o = '' as Object
		 *   m('' as Object) // calls 1
		 *   o.substring(1) // valid, too - compiler could insert the cast back to String
		 * }
		 */
		state.withNonVoidExpectation().computeTypes(object.getTarget());
		JvmTypeReference type = object.getType();
		if (type != null)
			state.acceptActualType(state.getConverter().toLightweightReference(type));
	}

	protected void _computeTypes(final XForLoopExpression object, final ITypeComputationState state) {
		JvmFormalParameter declaredParam = object.getDeclaredParam();
		ITypeComputationState eachState = state.withoutExpectation();
		if (declaredParam != null) {
			LightweightTypeReference parameterType = computeForLoopParameterType(object, state);
			eachState = eachState.assignType(declaredParam, parameterType);
		}
		eachState.computeTypes(object.getEachExpression());
		
		LightweightTypeReference primitiveVoid = getPrimitiveVoid(state);
		state.acceptActualType(primitiveVoid);
	}

	@Nullable
	protected LightweightTypeReference computeForLoopParameterType(final XForLoopExpression object,
			final ITypeComputationState state) {
		JvmFormalParameter declaredParam = object.getDeclaredParam();
		LightweightTypeReference parameterType = getDeclaredParameterType(declaredParam, state);
		if (parameterType != null && !parameterType.isPrimitiveVoid()) {
			LightweightTypeReference iterableOrArray = null;
			if (parameterType.isPrimitive()) {
				iterableOrArray = new ArrayTypeReference(state.getReferenceOwner(), parameterType);
			} else {
				ParameterizedTypeReference reference = new ParameterizedTypeReference(state.getReferenceOwner(), services.getTypeReferences().findDeclaredType(Iterable.class, object));
				WildcardTypeReference wildcard = new WildcardTypeReference(state.getReferenceOwner());
				wildcard.addUpperBound(parameterType);
				reference.addTypeArgument(wildcard);
				iterableOrArray = reference;
			}
			final CompoundTypeReference withSynonyms = new CompoundTypeReference(iterableOrArray.getOwner(), true);
			withSynonyms.addComponent(iterableOrArray);
			services.getSynonymTypesProvider().collectSynonymTypes(iterableOrArray, new SynonymTypesProvider.Acceptor() {
				@Override
				protected boolean accept(LightweightTypeReference synonym, Set<ConformanceHint> hints) {
					if (synonym.isType(List.class)) {
						List<LightweightTypeReference> superTypes = synonym.getAllSuperTypes();
						for(LightweightTypeReference superType: superTypes) {
							if (superType.isType(Iterable.class)) {
								if (superType.getTypeArguments().size() == 1) {
									LightweightTypeReference argument = superType.getTypeArguments().get(0);
									if (argument.isWildcard()) {
										withSynonyms.addComponent(superType);
										return true;
									} else {
										JvmType rawSuperType = superType.getType();
										if (rawSuperType == null) {
											withSynonyms.addComponent(superType);
											return true;
										}
										ParameterizedTypeReference parameterized = new ParameterizedTypeReference(superType.getOwner(), rawSuperType);
										WildcardTypeReference wildcard = new WildcardTypeReference(superType.getOwner());
										wildcard.addUpperBound(argument);
										parameterized.addTypeArgument(wildcard);
										withSynonyms.addComponent(parameterized);
										return true;
									}
								} else {
									withSynonyms.addComponent(superType);
									return true;
								}
							}
						}
					} else {
						withSynonyms.addComponent(synonym);
					}
					return true;
				}
			});
			ITypeComputationState iterableState = state.withExpectation(withSynonyms);
			ITypeComputationResult forExpressionResult = iterableState.computeTypes(object.getForExpression());
			LightweightTypeReference forExpressionType = forExpressionResult.getActualExpressionType();
			if (forExpressionType!= null) {
				if (forExpressionType.isAny()) {
					iterableState.refineExpectedType(object.getForExpression(), iterableOrArray);
				} else if (forExpressionType.isResolved()) {
					TypeConformanceResult assignability = iterableOrArray.internalIsAssignableFrom(forExpressionType, new TypeConformanceComputationArgument());
					if (assignability.isConformant() && !assignability.getConformanceHints().contains(ConformanceHint.RAWTYPE_CONVERSION))
						iterableState.refineExpectedType(object.getForExpression(), forExpressionType);
					else {
						ArrayTypeReference array = forExpressionType.tryConvertToArray();
						if (array != null) {
							if (parameterType.isAssignableFrom(array.getComponentType())) {
								iterableState.refineExpectedType(object.getForExpression(), forExpressionType);
							}
						}
					}
				}
			}
		} else {
			WildcardTypeReference wildcard = new WildcardTypeReference(state.getReferenceOwner());
			JvmGenericType iterableType = (JvmGenericType) services.getTypeReferences().findDeclaredType(Iterable.class, object);
			ParameterizedTypeReference iterable = new ParameterizedTypeReference(state.getReferenceOwner(), iterableType);
			UnboundTypeReference unbound = state.createUnboundTypeReference(object, iterableType.getTypeParameters().get(0));
			wildcard.addUpperBound(unbound);
			iterable.addTypeArgument(wildcard);
			// TODO do we have to add synonyms, too?
			ITypeComputationState iterableState = state.withExpectation(iterable); 
			ITypeComputationResult forExpressionResult = iterableState.computeTypes(object.getForExpression());
			LightweightTypeReference forExpressionType = forExpressionResult.getActualExpressionType();
			if (forExpressionType != null) {
				if (forExpressionType.isResolved() && !forExpressionType.isAny() && (iterable.isAssignableFrom(forExpressionType) || forExpressionType.isArray())) {
					iterableState.refineExpectedType(object.getForExpression(), forExpressionType);
				}
				parameterType = forExpressionType.accept(new TypeReferenceVisitorWithResult<LightweightTypeReference>() {
					@Override
					public LightweightTypeReference doVisitParameterizedTypeReference(ParameterizedTypeReference reference) {
						DeclaratorTypeArgumentCollector typeArgumentCollector = new ConstraintAwareTypeArgumentCollector(state.getReferenceOwner());
						Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping = typeArgumentCollector.getTypeParameterMapping(reference);
						TypeParameterSubstitutor<?> substitutor = new UnboundTypeParameterPreservingSubstitutor(typeParameterMapping, state.getReferenceOwner());
						JvmGenericType iterable = (JvmGenericType) services.getTypeReferences().findDeclaredType(Iterable.class, object);
						ParameterizedTypeReference substituteMe = new ParameterizedTypeReference(state.getReferenceOwner(), iterable.getTypeParameters().get(0));
						LightweightTypeReference substitutedArgument = substitutor.substitute(substituteMe).getUpperBoundSubstitute();
						if (substitutedArgument.getType() instanceof JvmTypeParameter && 
								!(state.getReferenceOwner().getDeclaredTypeParameters().contains(substitutedArgument.getType()))) {
							return substitutedArgument.getRawTypeReference();
						}
						return substitutedArgument;
					}
					@Override
					protected LightweightTypeReference doVisitAnyTypeReference(AnyTypeReference reference) {
						return reference;
					}
					@Override
					public LightweightTypeReference doVisitArrayTypeReference(ArrayTypeReference reference) {
						return reference.getComponentType();
					}
				});
			}
		}
		return parameterType;
	}

	@Nullable
	protected LightweightTypeReference getDeclaredParameterType(JvmFormalParameter declaredParam, final ITypeComputationState state) {
		JvmTypeReference parameterType = declaredParam.getParameterType();
		if (parameterType == null)
			return null;
		return state.getConverter().toLightweightReference(parameterType);
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
		JvmType type = object.getType();
		if (type == null) {
			return;
		}
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
		state.acceptActualType(getPrimitiveVoid(state), ConformanceHint.NO_IMPLICIT_RETURN);
	}

	protected void _computeTypes(XReturnExpression object, ITypeComputationState state) {
		ITypeComputationState expressionState = state.withReturnExpectation();
		expressionState.computeTypes(object.getExpression());
		state.acceptActualType(getPrimitiveVoid(state), ConformanceHint.NO_IMPLICIT_RETURN);
	}
	
	protected void _computeTypes(XTryCatchFinallyExpression object, ITypeComputationState state) {
		state.computeTypes(object.getExpression());
		for (XCatchClause catchClause : object.getCatchClauses()) {
			JvmFormalParameter catchClauseParam = catchClause.getDeclaredParam();
			JvmTypeReference parameterType = catchClauseParam.getParameterType();
			LightweightTypeReference lightweightReference = parameterType != null 
					? state.getConverter().toLightweightReference(parameterType)
					: new AnyTypeReference(state.getReferenceOwner());
			ITypeComputationState catchClauseState = state.assignType(catchClauseParam, lightweightReference);
			catchClauseState.computeTypes(catchClause.getExpression());
		}
		// TODO validate / handle return / throw in finally block
		state.withoutExpectation().computeTypes(object.getFinallyExpression());
	}
	
	protected void _computeTypes(final XAssignment assignment, ITypeComputationState state) {
		List<? extends IFeatureLinkingCandidate> candidates = state.getLinkingCandidates(assignment);
		ILinkingCandidate best = getBestCandidate(candidates);
		JvmIdentifiableElement feature = best.getFeature();
		if (feature != null && mustDiscardRefinement(feature)) {
			state.discardReassignedTypes(feature);
		}
		best.applyToComputationState();
	}
	
	protected void _computeTypes(final XAbstractFeatureCall featureCall, ITypeComputationState state) {
		List<? extends IFeatureLinkingCandidate> candidates = state.getLinkingCandidates(featureCall);
		ILinkingCandidate best = getBestCandidate(candidates);
		best.applyToComputationState();
	}
	
	protected ILinkingCandidate getBestCandidate(List<? extends ILinkingCandidate> candidates) {
		ILinkingCandidate result = candidates.get(0);
		for(int i = 1; i < candidates.size(); i++) {
			ILinkingCandidate candidate = candidates.get(i);
			result = result.getPreferredCandidate(candidate);
		}
		return result;
	}

	@Nullable
	protected JvmIdentifiableElement getRefinableCandidate(XExpression object, ITypeComputationState state) {
		if (object instanceof XSwitchExpression) {
			return (XSwitchExpression) object;
		}
		if (object instanceof XFeatureCall) {
			List<? extends IFeatureLinkingCandidate> candidates = state.getLinkingCandidates((XFeatureCall)object);
			if (candidates.size() == 1) {
				JvmIdentifiableElement linkedFeature = candidates.get(0).getFeature();
				if (isRefinableFeature(linkedFeature)) {
					return linkedFeature;
				}
			}
		}
		return null;
	}

	protected boolean isRefinableFeature(@Nullable JvmIdentifiableElement feature) {
		return feature instanceof XVariableDeclaration || feature instanceof JvmFormalParameter || feature instanceof JvmField;
	}
	
	protected boolean mustDiscardRefinement(JvmIdentifiableElement feature) {
		if (feature instanceof XVariableDeclaration) {
			return ((XVariableDeclaration) feature).isWriteable();
		}
		if (feature instanceof JvmField) {
			return !((JvmField) feature).isFinal();
		}
		return false;
	}
	
}
