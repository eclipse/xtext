/*******************************************************************************
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAbstractWhileExpression;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBasicForLoopExpression;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XListLiteral;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSetLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XSynchronizedExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputationArgument;
import org.eclipse.xtext.xbase.typesystem.override.BottomResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedExecutable;
import org.eclipse.xtext.xbase.typesystem.override.OverrideTester;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.ExtendedEarlyExitComputer;
import org.eclipse.xtext.xbase.validation.IssueCodes;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * Base implementation for the {@link ITypeComputer}. The interface contract 
 * fully applies to this class.
 * 
 * This implementation handles all expression that are defined in Xbase.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Moritz Eysholdt - Support for checked exceptions
 * @author Eva Poell - support for try with resources
 */
public class XbaseTypeComputer extends AbstractTypeComputer implements ITypeComputer {

	@Inject
	private NumberLiterals numberLiterals;
	
	@Inject
	private CollectionLiteralsTypeComputer collectionLiterals;
	
	@Inject
	private OverrideTester overrideTester;
	
	@Override
	public void computeTypes(XExpression expression, ITypeComputationState state) {
		if (expression instanceof XAssignment) {
			_computeTypes((XAssignment)expression, state);
		} else if (expression instanceof XAbstractFeatureCall) {
			_computeTypes((XAbstractFeatureCall)expression, state);
		} else if (expression instanceof XDoWhileExpression) {
			_computeTypes((XDoWhileExpression)expression, state);
		} else if (expression instanceof XWhileExpression) {
			_computeTypes((XWhileExpression)expression, state);
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
		} else if (expression instanceof XBasicForLoopExpression) {
			_computeTypes((XBasicForLoopExpression)expression, state);
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
		} else if (expression instanceof XSynchronizedExpression) {
			_computeTypes((XSynchronizedExpression)expression, state);
		} else {
			throw new UnsupportedOperationException("Missing type computation for expression type: " + expression.eClass().getName() + " / " + state);
		}
	}

	protected static abstract class BranchExpressionProcessor {
		protected boolean earlyExit = true;
		protected boolean allVoid = true;
		protected boolean allPrimitive = true;
		protected boolean resultProcessed = false;
		protected boolean nonNullResultProcessed = false;
		private final ITypeComputationState state;
		private final XExpression expression;
		
		public BranchExpressionProcessor(ITypeComputationState state, XExpression expression) {
			this.state = state;
			this.expression = expression;
		}
		
		public void process(ITypeComputationResult result) {
			resultProcessed = true;
			if (result.getConformanceFlags() != 0 /* equivalent to getActualExpressionType != null */) {
				nonNullResultProcessed = true;
			}
			LightweightTypeReference expressionReturnType = result.getReturnType();
			if (expressionReturnType != null) {
				boolean isExit = (result.getCheckedConformanceFlags() & ConformanceFlags.NO_IMPLICIT_RETURN) != 0;
				if (earlyExit && isExit && !expressionReturnType.isPrimitiveVoid()) {
					earlyExit = false;
				}
				if (allPrimitive && isExit && !expressionReturnType.isPrimitive()) {
					allPrimitive = false;
				}
				if (allVoid || allPrimitive) {
					LightweightTypeReference expressionType = result.getActualExpressionType();
					if (allVoid && !(expressionType != null && expressionType.isPrimitiveVoid())) {
						allVoid = false;
					}
					if (allPrimitive && !(expressionType != null && expressionType.isPrimitive() || expressionReturnType.isPrimitive())) {
						allPrimitive = false;
					}
				}
			}
		}
		
		public void commit() {
			if (!nonNullResultProcessed) {
				AnyTypeReference anyType = state.getReferenceOwner().newAnyTypeReference();
				state.acceptActualType(anyType);
			}
			if (!resultProcessed) {
				return;
			}
			if (earlyExit || allVoid || allPrimitive) {
				for(ITypeExpectation expectation: state.getExpectations()) {
					if (earlyExit && allVoid) {
						if (!expectation.isVoidTypeAllowed()) {
							AnyTypeReference anyType = state.getReferenceOwner().newAnyTypeReference();
							expectation.acceptActualType(anyType, ConformanceFlags.UNCHECKED);
							allPrimitive = false;
						}
					} else if (!expectation.isVoidTypeAllowed() && expectation.getExpectedType() == null) {
						if (!allPrimitive || allVoid) {
							AnyTypeReference anyType = state.getReferenceOwner().newAnyTypeReference();
							expectation.acceptActualType(anyType, ConformanceFlags.UNCHECKED);
						}
						allPrimitive = false;
					}
					if (expectation.isVoidTypeAllowed() && (earlyExit || allVoid)) {
						allPrimitive = false;
					}
				}
				
				if (!state.isIgnored(IssueCodes.NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE) && allPrimitive) {
					AbstractDiagnostic diagnostic = new DiagnosticOnFirstKeyword(
							state.getSeverity(IssueCodes.NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE),
							IssueCodes.NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE, 
							getMessage(),
							expression,
							null);
					state.addDiagnostic(diagnostic);
				}
				return;
			} else {
				AnyTypeReference anyType = state.getReferenceOwner().newAnyTypeReference();
				state.acceptActualType(anyType);
			}
		}

		protected abstract String getMessage();
	}
	
	protected void _computeTypes(XIfExpression object, ITypeComputationState state) {
		ITypeComputationState conditionExpectation = state.withExpectation(getRawTypeForName(Boolean.TYPE, state));
		XExpression condition = object.getIf();
		conditionExpectation.computeTypes(condition);
		
		// TODO then expression may influence the expected type of else and vice versa
		XExpression thenExpression = getThen(object);
		ITypeComputationState thenState = reassignCheckedType(condition, thenExpression, state);
		ITypeComputationResult thenResult = thenState.computeTypes(thenExpression);
		XExpression elseExpression = getElse(object);
		if (elseExpression != null) {
			state.computeTypes(elseExpression);
		} else {
			BranchExpressionProcessor processor = new BranchExpressionProcessor(state, object) {
				@Override
				protected String getMessage() {
					return "Missing else branch for conditional expression with primitive type";
				}
			};
			processor.process(thenResult);
			processor.commit();
		}
	}

	/**
	 * If the condition is a {@link XInstanceOfExpression type check}, the checked expression
	 * will be automatically casted in the returned state.
	 */
	protected ITypeComputationState reassignCheckedType(XExpression condition, /* @Nullable */ XExpression guardedExpression, ITypeComputationState state) {
		if (condition instanceof XInstanceOfExpression) {
			XInstanceOfExpression instanceOfExpression = (XInstanceOfExpression) condition;
			JvmTypeReference castedType = instanceOfExpression.getType();
			if (castedType != null) {
				state = state.withTypeCheckpoint(guardedExpression);
				JvmIdentifiableElement refinable = getRefinableCandidate(instanceOfExpression.getExpression(), state);
				if (refinable != null) {
					state.reassignType(refinable, state.getReferenceOwner().toLightweightTypeReference(castedType));
				}
			}
		}
		return state;
	}

	/**
	 * Only for testing purpose.
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	/* @Nullable */
	protected XExpression getElse(XIfExpression ifExpression) {
		return ifExpression.getElse();
	}

	/**
	 * Only for testing purpose.
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	/* @Nullable */
	protected XExpression getThen(XIfExpression ifExpression) {
		return ifExpression.getThen();
	}
	
	protected LightweightTypeReference normalizedMultiType(ITypeReferenceOwner referenceOwner, JvmTypeReference ref) {
		LightweightTypeReference result = referenceOwner.toLightweightTypeReference(ref);
		if (result.isSynonym()) {
			List<LightweightTypeReference> components = result.getMultiTypeComponents();
			result = referenceOwner.getServices().getTypeConformanceComputer().getCommonSuperType(components, referenceOwner);
		}
		return result;
	}
	
	@SuppressWarnings("null")
	protected void _computeTypes(XSwitchExpression object, ITypeComputationState state) {
		ITypeComputationState switchExpressionState = getSwitchExpressionState(object, state); 
		ITypeComputationResult computedType = switchExpressionState.computeTypes(object.getSwitch());
		
		ITypeComputationState allCasePartsState = state;
		LightweightTypeReference expressionType = computedType.getActualExpressionType();
		
		JvmFormalParameter declaredParam = object.getDeclaredParam();
		if (declaredParam != null) {
			if (declaredParam.getParameterType() == null) {
				allCasePartsState = allCasePartsState.assignType(declaredParam, expressionType);
			} else {
				LightweightTypeReference parameterType = state.getReferenceOwner().toLightweightTypeReference(declaredParam.getParameterType());
				allCasePartsState = allCasePartsState.assignType(declaredParam, parameterType);
			}
		}
		allCasePartsState.withinScope(object);

		JvmType potentialEnumType = expressionType != null ? expressionType.getType() : null;
		boolean isEnum = potentialEnumType instanceof JvmEnumerationType;
		Set<JvmEnumerationLiteral> uncheckedEnumLiterals = null;
		if (isEnum) {
			uncheckedEnumLiterals = new HashSet<JvmEnumerationLiteral>(((JvmEnumerationType) potentialEnumType).getLiterals());
		}
		BranchExpressionProcessor branchExpressionProcessor = object.getDefault() == null ? new BranchExpressionProcessor(state, object) {
				@Override
				protected String getMessage() {
					return "Missing default branch for switch expression with primitive type";
				}
		}: null;
		
		LightweightTypeReference thenTypeReference = null;
		// TODO case expressions may influence the expected type of other cases
		List<XCasePart> cases = getCases(object);
		for(int i = 0; i < cases.size(); i++) {
			XCasePart casePart = cases.get(i);
			// assign the type for the switch expression if possible and use that one for the remaining things
			ITypeComputationState casePartState = allCasePartsState.withTypeCheckpoint(casePart);
			boolean localIsEnum = isEnum;
			JvmType localPotentialEnumType = potentialEnumType;
			if (casePart.getTypeGuard() != null) {
				JvmIdentifiableElement refinable = getRefinableCandidate(object, casePartState);
				if (refinable != null) {
					ITypeReferenceOwner referenceOwner = casePartState.getReferenceOwner();
					LightweightTypeReference lightweightReference = normalizedMultiType(referenceOwner, casePart.getTypeGuard());
					casePartState.reassignType(refinable, lightweightReference);
					if (thenTypeReference == null) {
						thenTypeReference = lightweightReference;
					} else {
						List<LightweightTypeReference> types = Lists.newArrayList(thenTypeReference, lightweightReference);
						thenTypeReference = getCommonSuperType(types, thenTypeReference.getOwner());
						if (thenTypeReference == null) {
							thenTypeReference = lightweightReference;
						}
					}
				}
				if (!localIsEnum) {
					JvmType typeGuard = casePart.getTypeGuard().getType();
					if (typeGuard instanceof JvmEnumerationType) {
						localIsEnum = true; 
						localPotentialEnumType = typeGuard;
					}
					if (typeGuard instanceof JvmTypeParameter) {
						state.addDiagnostic(new EObjectDiagnosticImpl(
								Severity.ERROR,
								IssueCodes.INVALID_USE_OF_TYPE_PARAMETER,
								"Cannot perform type switch against type parameter "+typeGuard.getSimpleName()+". Use its erasure Object instead since further generic type information will be erased at runtime.",
								casePart.getTypeGuard(),
								null,
								-1,
								new String[] { 
								}));
					}
				}
			}
			// boolean or object / primitive
			ITypeComputationState caseState = casePartState.withNonVoidExpectation();
			if (localIsEnum) {
				assert potentialEnumType != null;
				caseState.addImports(new EnumLiteralImporter((JvmDeclaredType) localPotentialEnumType));
			}
			caseState.withinScope(casePart);
			if (casePart.getCase() != null) {
				caseState.computeTypes(casePart.getCase());
				if (uncheckedEnumLiterals != null && casePart.getCase() instanceof XAbstractFeatureCall) {
					List<? extends IFeatureLinkingCandidate> candidates = state.getLinkingCandidates((XAbstractFeatureCall) casePart.getCase());
					if (candidates.size() == 1) {
						JvmIdentifiableElement feature = candidates.get(0).getFeature();
						if (feature instanceof JvmEnumerationLiteral) {
							uncheckedEnumLiterals.remove(feature);
						}
					}
				}
			}
			XExpression then = casePart.getThen();
			if (then != null || (i == cases.size() - 1 && thenTypeReference != null)) {
				ITypeComputationState thenState = allCasePartsState.withTypeCheckpoint(casePart);
				if (thenTypeReference != null) {
					JvmIdentifiableElement refinable = getRefinableCandidate(object, thenState);
					if (refinable != null) {
						thenState.reassignType(refinable, thenTypeReference);
						thenTypeReference = null;
					}
				}
				thenState.afterScope(casePart);
				ITypeComputationResult thenResult = thenState.computeTypes(then);
				if (branchExpressionProcessor != null) {
					branchExpressionProcessor.process(thenResult);
				}
			} else {
				allCasePartsState.afterScope(casePart);
			}
		}
		XExpression defaultCase = object.getDefault();
		if (defaultCase != null) {
			allCasePartsState.computeTypes(object.getDefault());
		} else if (branchExpressionProcessor != null && !(isEnum && uncheckedEnumLiterals.isEmpty())) {
			branchExpressionProcessor.commit();
		}
	}
	
	protected ITypeComputationState getSwitchExpressionState(XSwitchExpression expr, ITypeComputationState state) {
		JvmFormalParameter param = expr.getDeclaredParam();
		if (param == null) {
			return state.withNonVoidExpectation();
		}
		JvmTypeReference parameterType = param.getParameterType();
		if (parameterType == null) {
			return state.withNonVoidExpectation();
		}
		LightweightTypeReference expectation = state.getReferenceOwner().toLightweightTypeReference(parameterType);
		return state.withExpectation(expectation);
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
		List<XExpression> children = object.getExpressions();
		if (children.isEmpty()) {
			for (ITypeExpectation expectation: state.getExpectations()) {
				LightweightTypeReference expectedType = expectation.getExpectedType();
				if (expectedType != null && expectedType.isPrimitiveVoid()) {
					expectation.acceptActualType(expectedType, ConformanceFlags.CHECKED_SUCCESS);
				} else {
					expectation.acceptActualType(expectation.getReferenceOwner().newAnyTypeReference(), ConformanceFlags.UNCHECKED);
				}
			}
		} else {
			state.withinScope(object);
			for(int i = 0; i < children.size() - 1; i++) {
				XExpression expression = children.get(i);
				ITypeComputationState expressionState = state.withoutExpectation(); // no expectation
				expressionState.computeTypes(expression);
				addLocalToCurrentScope(expression, state);
			}
			XExpression lastExpression = children.get(children.size() - 1);
			for (ITypeExpectation expectation: state.getExpectations()) {
				LightweightTypeReference expectedType = expectation.getExpectedType();
				if (expectedType != null && expectedType.isPrimitiveVoid()) {
					ITypeComputationState expressionState = state.withoutExpectation(); // no expectation
					expressionState.computeTypes(lastExpression);
					addLocalToCurrentScope(lastExpression, state);
					expectation.acceptActualType(getPrimitiveVoid(state), ConformanceFlags.CHECKED_SUCCESS);
				} else {
					state.computeTypes(lastExpression);
					// add the last expression to the scope, too in order validate for duplicate names, even
					// though the variable declaration could be removed automatically to keep only the side effect
					// of the initializer
					addLocalToCurrentScope(lastExpression, state);
				}
			}
		}
	}

	/**
	 * If the expression is a variable declaration, then add it to the current scope;
	 * DSLs introducing new containers for variable declarations should override this method
	 * and explicitly add nested variable declarations.
	 * @since 2.9
	 */
	protected void addLocalToCurrentScope(XExpression expression, ITypeComputationState state) {
		if (expression instanceof XVariableDeclaration) {
			addLocalToCurrentScope((XVariableDeclaration)expression, state);
		}
	}

	protected void addLocalToCurrentScope(XVariableDeclaration localVariable, ITypeComputationState state) {
		state.addLocalToCurrentScope(localVariable);
		state.rewriteScope(localVariable);
	}

	protected void _computeTypes(XVariableDeclaration object, ITypeComputationState state) {
		JvmTypeReference declaredType = object.getType();
		LightweightTypeReference lightweightTypeReference = declaredType != null ? state.getReferenceOwner().toLightweightTypeReference(declaredType) : null;
		boolean isTryWithResources = (object.eContainingFeature() == XbasePackage.Literals.XTRY_CATCH_FINALLY_EXPRESSION__RESOURCES);
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
			ITypeComputationState initializerState;
			if (isTryWithResources) {
				initializerState = (lightweightTypeReference != null)
						? state.withExpectation(lightweightTypeReference)
						: state.withExpectation(getRawTypeForName(AutoCloseable.class, state));
			}
			else
				initializerState = (lightweightTypeReference != null)
						? state.withExpectation(lightweightTypeReference)
						: state.withNonVoidExpectation();
		
			initializerState.withinScope(object);
			ITypeComputationResult computedType = initializerState.computeTypes(object.getRight());
			/* 
			 * TODO keep information about the actual type, e.g. automatic cast insertion should be possible for
			 * 
			 * val Object o = ""
			 * o.substring(1)
			 */
			LightweightTypeReference variableType = null;
			if (lightweightTypeReference != null) {
				variableType = lightweightTypeReference;
			} else {
				variableType = computedType.getActualExpressionType();
			}
			if (variableType != null) {
				if (variableType.isPrimitiveVoid()) {
					variableType = variableType.getOwner().newUnknownTypeReference();
				}
				if (object.getRight() != null) {
					ExtendedEarlyExitComputer earlyExitComputer = state.getReferenceOwner().getServices().getEarlyExitComputer();
					if (earlyExitComputer.isDefiniteEarlyExit(computedType.getExpression())) {
						AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(
								Severity.ERROR,
								IssueCodes.UNREACHABLE_CODE, 
								"Dead code: The variable " + object.getSimpleName() + " will never be assigned.",
								object,
								XbasePackage.Literals.XVARIABLE_DECLARATION__NAME,
								-1,
								null);
						state.addDiagnostic(diagnostic);
					}
					if (isTryWithResources) {
						// Check if resource implements AutoCloseable
						if (!variableType.isSubtypeOf(AutoCloseable.class)) {
							AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(Severity.ERROR,
									IssueCodes.INVALID_TRY_RESOURCE_TYPE,
									"The resource \'" + object.getSimpleName() + "\' of type "
											+ variableType.getSimpleName() + " does not implement java.lang.AutoCloseable.",
									object,
									XbasePackage.Literals.XVARIABLE_DECLARATION__TYPE,
									-1,
									null);
							state.addDiagnostic(diagnostic);
						} else {
						// Check if resource throws exception in close method
						// and if user (instead of compiler) should handle it
							if (!state.isIgnored(IssueCodes.UNHANDLED_EXCEPTION)) {
								JvmOperation closeMethod = findCloseMethod(variableType);
								// Process all exceptions
								if (closeMethod != null) {
									IResolvedExecutable resolvedCloseMethod = new BottomResolvedOperation(closeMethod, variableType, overrideTester);
									List<LightweightTypeReference> thrownExceptions = resolvedCloseMethod.getResolvedExceptions();
									for(LightweightTypeReference exception: thrownExceptions) {
										// check against expected exceptions
										validateUnhandledException(exception, object, 
												XbasePackage.Literals.XVARIABLE_DECLARATION__NAME, state,
												(type)->"Unhandled exception type " + type.getSimpleName() + " thrown by automatic close() invocation on " + object.getSimpleName());
									}
								}
							}
						}
					}
				}
			}
			state.assignType(object, variableType, false);
		}
		LightweightTypeReference primitiveVoid = getPrimitiveVoid(state);
		state.acceptActualType(primitiveVoid);
	}

	/**
	 * @since 2.18
	 */
	protected JvmOperation findCloseMethod(LightweightTypeReference resourceType) {
		// Find the real close method,
		// which is an operation without arguments.
		// There can only be one close method with that signature.
		for(JvmType rawType: resourceType.getRawTypes()) {
			if (rawType instanceof JvmDeclaredType) {
				Iterable<JvmFeature> candidates = ((JvmDeclaredType) rawType).findAllFeaturesByName("close");
				for(JvmFeature candidate: candidates) {
					if (candidate instanceof JvmOperation
							&& ((JvmOperation) candidate).getParameters().isEmpty()) {
						return (JvmOperation) candidate;
					}
				}
			}
		}
		return null;
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
		LightweightTypeReference bool = getRawTypeForName(Boolean.TYPE, state);
		state.acceptActualType(bool);
	}

	/**
	 * @param object used for dispatching
	 */
	protected void _computeTypes(XNullLiteral object, ITypeComputationState state) {
		state.acceptActualType(state.getReferenceOwner().newAnyTypeReference());
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
		if (object.getValue() != null && object.getValue().length() != 1) {
			LightweightTypeReference result = getRawTypeForName(String.class, state);
			state.acceptActualType(result);
		} else {
			for(ITypeExpectation expectation: state.getExpectations()) {
				LightweightTypeReference expectedType = expectation.getExpectedType();
				if (expectedType != null) {
					if (expectedType.isType(Character.TYPE) || expectedType.isType(Character.class)) {
						expectation.acceptActualType(expectedType, ConformanceFlags.CHECKED_SUCCESS | ConformanceFlags.DEMAND_CONVERSION | ConformanceFlags.SEALED);
					} else {
						LightweightTypeReference type = getRawTypeForName(String.class, state);
						expectation.acceptActualType(type, ConformanceFlags.UNCHECKED);
					}
				} else {
					LightweightTypeReference type = getRawTypeForName(String.class, state);
					expectation.acceptActualType(type, ConformanceFlags.UNCHECKED);
				}
			}
		}
	}
	
	protected void _computeTypes(XListLiteral literal, ITypeComputationState state) {
		collectionLiterals.computeType(literal, state);
	}

	protected void _computeTypes(XSetLiteral literal, ITypeComputationState state) {
		collectionLiterals.computeType(literal, state);
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
		 *   m(o) // calls 1
		 *   o.substring(1) // valid, too - compiler could insert the cast back to String
		 * }
		 */
		JvmTypeReference type = object.getType();
		if (type != null) {
			state.withNonVoidExpectation().computeTypes(object.getTarget());
			state.acceptActualType(state.getReferenceOwner().toLightweightTypeReference(type));
		} else {
			state.computeTypes(object.getTarget());
		}
	}
	
	protected void _computeTypes(final XBasicForLoopExpression object, final ITypeComputationState state) {
		for(XExpression initExpression : object.getInitExpressions()) {
			ITypeComputationState expressionState = state.withoutExpectation();
			expressionState.computeTypes(initExpression);
			addLocalToCurrentScope(initExpression, state);
		}
		state.withinScope(object);
		XExpression expression = object.getExpression();
		if (expression != null) {
			LightweightTypeReference booleanType = getRawTypeForName(Boolean.TYPE, state);
			ITypeComputationState conditionExpectation = state.withExpectation(booleanType);
			conditionExpectation.computeTypes(expression);
		}
		
		XExpression eachExpression = object.getEachExpression();
		ITypeComputationState stateWithoutExpectation = state.withoutExpectation();
		ITypeComputationState eachExpressionState = reassignCheckedType(expression, eachExpression, stateWithoutExpectation);
		eachExpressionState.computeTypes(eachExpression);
		
		for (XExpression updateExpression : object.getUpdateExpressions()) {
			eachExpressionState.computeTypes(updateExpression);
		}
		
		LightweightTypeReference primitiveVoid = getPrimitiveVoid(state);
		state.acceptActualType(primitiveVoid);
	}

	protected void _computeTypes(final XForLoopExpression object, final ITypeComputationState state) {
		JvmFormalParameter declaredParam = object.getDeclaredParam();
		ITypeComputationState eachState = state.withoutExpectation();
		if (declaredParam != null) {
			LightweightTypeReference parameterType = computeForLoopParameterType(object, state);
			eachState = assignType(declaredParam, parameterType, eachState);
			eachState.withinScope(object);
		}
		eachState.computeTypes(object.getEachExpression());
		
		LightweightTypeReference primitiveVoid = getPrimitiveVoid(state);
		state.acceptActualType(primitiveVoid);
	}

	protected ITypeComputationState assignType(JvmFormalParameter param, /* @Nullable */ LightweightTypeReference type, ITypeComputationState state) {
		return state.assignType(param, type);
	}

	/* @Nullable */
	protected LightweightTypeReference computeForLoopParameterType(final XForLoopExpression object,
			final ITypeComputationState state) {
		JvmFormalParameter declaredParam = object.getDeclaredParam();
		LightweightTypeReference parameterType = getDeclaredParameterType(declaredParam, state);
		final JvmGenericType iterableType = findDeclaredType(Iterable.class, state.getReferenceOwner());
		
		if (parameterType != null && !parameterType.isPrimitiveVoid()) {
			final CompoundTypeReference withSynonyms = state.getReferenceOwner().newCompoundTypeReference(true);
			LightweightTypeReference iterableOrArray = getAndEnhanceIterableOrArrayFromComponent(parameterType, iterableType, withSynonyms);
			
			ITypeComputationState iterableState = state.withExpectation(withSynonyms);
			ITypeComputationResult forExpressionResult = iterableState.computeTypes(object.getForExpression());
			LightweightTypeReference forExpressionType = forExpressionResult.getActualExpressionType();
			if (forExpressionType!= null) {
				if (forExpressionType.isAny() || forExpressionType.isUnknown()) {
					iterableState.refineExpectedType(object.getForExpression(), iterableOrArray);
				} else if (forExpressionType.isResolved()) {
					int assignability = iterableOrArray.internalIsAssignableFrom(forExpressionType, TypeConformanceComputationArgument.DEFAULT);
					if ((assignability & ConformanceFlags.SUCCESS) != 0 && (assignability & ConformanceFlags.RAW_TYPE_CONVERSION) == 0)
						iterableState.refineExpectedType(object.getForExpression(), forExpressionType);
					else {
						ArrayTypeReference array = forExpressionType.tryConvertToArray();
						if (array != null) {
							LightweightTypeReference arrayComponentType = array.getComponentType();
							if (parameterType.isAssignableFrom(arrayComponentType)) {
								iterableState.refineExpectedType(object.getForExpression(), forExpressionType);
							} else {
								LightweightTypeReference rawArrayComponentType = arrayComponentType.getRawTypeReference();
								AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(
										Severity.ERROR, 
										IssueCodes.INCOMPATIBLE_TYPES, 
										String.format("Type mismatch: cannot convert from element type %s to %s", rawArrayComponentType.getHumanReadableName(), parameterType.getHumanReadableName()), 
										object, 
										XbasePackage.Literals.XFOR_LOOP_EXPRESSION__FOR_EXPRESSION, -1, null);
								state.addDiagnostic(diagnostic);
							}
						}
					}
				}
			}
		} else {
			ITypeReferenceOwner owner = state.getReferenceOwner();
			LightweightTypeReference iterable = null;
			if (iterableType == null) {
				iterable = owner.newUnknownTypeReference(Iterable.class.getName());
			} else {
				WildcardTypeReference wildcard = owner.newWildcardTypeReference();
				ParameterizedTypeReference iterableTypeRef = owner.newParameterizedTypeReference(iterableType);
				UnboundTypeReference unbound = state.createUnboundTypeReference(object, iterableType.getTypeParameters().get(0));
				wildcard.addUpperBound(unbound);
				iterableTypeRef.addTypeArgument(wildcard);
				iterable = iterableTypeRef;
				// TODO do we have to add synonyms, too?
			}
			ITypeComputationState iterableState = state.withExpectation(iterable); 
			ITypeComputationResult forExpressionResult = iterableState.computeTypes(object.getForExpression());
			LightweightTypeReference forExpressionType = forExpressionResult.getActualExpressionType();
			if (forExpressionType != null) {
				if (!forExpressionType.isAny() && (iterable.isAssignableFrom(forExpressionType) || forExpressionType.isArray())) {
					iterableState.refineExpectedType(object.getForExpression(), forExpressionType);
				}
				parameterType = getElementOrComponentType(forExpressionType, state.getReferenceOwner());
			}
		}
		return parameterType;
	}

	protected LightweightTypeReference getAndEnhanceIterableOrArrayFromComponent(LightweightTypeReference parameterType, JvmGenericType iterableType,
			final CompoundTypeReference compoundResult) {
		if (parameterType.isUnknown()) {
			compoundResult.addComponent(parameterType);
			return parameterType;
		}
		ITypeReferenceOwner owner = compoundResult.getOwner();
		LightweightTypeReference iterableOrArray = null;
		LightweightTypeReference addAsArrayComponentAndIterable = null;
		if (parameterType.isPrimitive()) {
			iterableOrArray = owner.newArrayTypeReference(parameterType);
			compoundResult.addComponent(iterableOrArray);
			addAsArrayComponentAndIterable = parameterType.getWrapperTypeIfPrimitive();
		} else if (parameterType.isAny()) {
			addAsArrayComponentAndIterable = parameterType.getOwner().newReferenceToObject();
		} else {
			addAsArrayComponentAndIterable = parameterType;
		}
		if (iterableType != null) {
			ParameterizedTypeReference reference = owner.newParameterizedTypeReference(iterableType);
			WildcardTypeReference wildcard = owner.newWildcardTypeReference();
			wildcard.addUpperBound(addAsArrayComponentAndIterable);
			reference.addTypeArgument(wildcard);
			compoundResult.addComponent(reference);
			if (iterableOrArray == null) {
				iterableOrArray = reference;
				LightweightTypeReference potentialPrimitive = addAsArrayComponentAndIterable.getPrimitiveIfWrapperType();
				if (potentialPrimitive != addAsArrayComponentAndIterable) {
					compoundResult.addComponent(owner.newArrayTypeReference(potentialPrimitive));
				}
			}
			compoundResult.addComponent(owner.newArrayTypeReference(addAsArrayComponentAndIterable));
		} else if (iterableOrArray == null) { // no JRE on the CP
			if (addAsArrayComponentAndIterable != null) {
				iterableOrArray = owner.newArrayTypeReference(addAsArrayComponentAndIterable);
				compoundResult.addComponent(iterableOrArray);
			} else {
				compoundResult.addComponent(parameterType);
				return parameterType;
			}
		}
		return iterableOrArray;
	}

	/**
	 * Delegates to {@link ElementOrComponentTypeComputer#compute(LightweightTypeReference, ITypeReferenceOwner)}.
	 * Clients may override.
	 */
	/* @Nullable */
	protected LightweightTypeReference getElementOrComponentType(LightweightTypeReference iterableOrArray, ITypeReferenceOwner owner) {
		return ElementOrComponentTypeComputer.compute(iterableOrArray, owner);
	}

	/* @Nullable */
	protected LightweightTypeReference getDeclaredParameterType(JvmFormalParameter declaredParam, final ITypeComputationState state) {
		JvmTypeReference parameterType = declaredParam.getParameterType();
		if (parameterType == null)
			return null;
		return state.getReferenceOwner().toLightweightTypeReference(parameterType);
	}

	protected void _computeTypes(XWhileExpression object, ITypeComputationState state) {
		computeWhileLoopBody(object, state, true);
		
		LightweightTypeReference primitiveVoid = getPrimitiveVoid(state);
		state.acceptActualType(primitiveVoid);
	}

	protected ITypeComputationResult computeWhileLoopBody(XAbstractWhileExpression object, ITypeComputationState state, boolean autocast) {
		ITypeComputationState conditionExpectation = state.withExpectation(getRawTypeForName(Boolean.TYPE, state));
		XExpression predicate = object.getPredicate();
		conditionExpectation.computeTypes(predicate);
		XExpression body = object.getBody();
		ITypeComputationState bodyState = autocast ? reassignCheckedType(predicate, body, state.withoutExpectation()) : state.withoutExpectation();
		return bodyState.computeTypes(body);
	}

	/**
	 * Since we are sure that the loop body is executed at least once, the early exit information
	 * of the loop body expression can be used for the outer expression.
	 */
	protected void _computeTypes(XDoWhileExpression object, ITypeComputationState state) {
		ITypeComputationResult loopBodyResult = computeWhileLoopBody(object, state, false);
		boolean noImplicitReturn = (loopBodyResult.getConformanceFlags() & ConformanceFlags.NO_IMPLICIT_RETURN) != 0;
		LightweightTypeReference primitiveVoid = getPrimitiveVoid(state);
		if (noImplicitReturn)
			state.acceptActualType(primitiveVoid, ConformanceFlags.NO_IMPLICIT_RETURN | ConformanceFlags.UNCHECKED);
		else
			state.acceptActualType(primitiveVoid);
	}

	protected void _computeTypes(XTypeLiteral object, ITypeComputationState state) {
		JvmType type = object.getType();
		if (type == null) {
			return;
		}
		checkTypeParameterNotAllowedAsLiteral(object, type, state);
		ITypeReferenceOwner owner = state.getReferenceOwner();
		LightweightTypeReference clazz = owner.newParameterizedTypeReference(type);
		for (int i = 0; i < object.getArrayDimensions().size(); i++) {
			clazz = owner.newArrayTypeReference(clazz);
		}
		if (object.getArrayDimensions().isEmpty()) {
			if (clazz.isPrimitiveVoid()) {
				clazz = state.getReferenceOwner().newReferenceTo(Void.class);
			} else {
				clazz = clazz.getWrapperTypeIfPrimitive();
			}
		}
		LightweightTypeReference result = owner.newReferenceTo(Class.class);
		if (result instanceof ParameterizedTypeReference) {
			ParameterizedTypeReference parameterizedTypeReference = (ParameterizedTypeReference) result;
			parameterizedTypeReference.addTypeArgument(clazz);
		}
		state.acceptActualType(result);
	}
	
	private void checkTypeParameterNotAllowedAsLiteral(EObject ctx, JvmType type, ITypeComputationState state) {
		if (type instanceof JvmTypeParameter) {
			state.addDiagnostic(new EObjectDiagnosticImpl(
					Severity.ERROR,
					IssueCodes.INVALID_USE_OF_TYPE_PARAMETER,
					"Illegal class literal for the type parameter " + type.getSimpleName()+".",
					ctx,
					null,
					-1,
					new String[] { 
					}));
		}
	}

	protected void _computeTypes(XInstanceOfExpression object, ITypeComputationState state) {
		ITypeComputationState expressionState = state.withExpectation(state.getReferenceOwner().newReferenceToObject());
		expressionState.computeTypes(object.getExpression());
		JvmTypeReference type = object.getType();
		if (isReferenceToTypeParameter(type)) {
			LightweightTypeReference lightweightReference = state.getReferenceOwner().toLightweightTypeReference(type);
			LightweightTypeReference rawTypeRef = lightweightReference.getRawTypeReference();
			state.addDiagnostic(new EObjectDiagnosticImpl(
					Severity.ERROR,
					IssueCodes.INVALID_USE_OF_TYPE_PARAMETER,
					"Cannot perform instanceof check against type parameter "+lightweightReference.getHumanReadableName()+". Use its erasure "+rawTypeRef.getHumanReadableName()+" instead since further generic type information will be erased at runtime.",
					object.getType(),
					null,
					-1,
					new String[] { 
					}));
		}
		LightweightTypeReference bool = getRawTypeForName(Boolean.TYPE, state);
		state.acceptActualType(bool);
	}

	private boolean isReferenceToTypeParameter(JvmTypeReference type) {
		if (type != null) {
			if (type.getType() instanceof JvmTypeParameter) {
				return true;
			}
			if (type instanceof JvmGenericArrayTypeReference) {
				return isReferenceToTypeParameter(((JvmGenericArrayTypeReference) type).getComponentType());
			}
		}
		return false;
	}

	protected void _computeTypes(XThrowExpression object, ITypeComputationState state) {
		LightweightTypeReference throwable = getRawTypeForName(Throwable.class, state);
		ITypeComputationState expressionState = state.withExpectation(throwable);
		ITypeComputationResult types = expressionState.computeTypes(object.getExpression());
		
		state.acceptActualType(getPrimitiveVoid(state), ConformanceFlags.NO_IMPLICIT_RETURN | ConformanceFlags.THROWN_EXCEPTION);
		
		LightweightTypeReference thrownException = types.getActualExpressionType();
		if (thrownException != null && !thrownException.isUnknown()) {
			validateUnhandledException(thrownException, object, XbasePackage.Literals.XTHROW_EXPRESSION__EXPRESSION, state, 
					(type)->"Unhandled exception type " + type.getSimpleName());
		}
	}

	/**
	 * Checks if the given thrownexcpetion is handled (as in "taken care of by compiler").
	 * 
	 * @param thrownException the exception to validate
	 * @param object the object in which context the exception should be validated
	 * @param feature which causes the exception
	 * @param state bearing the expected exceptions
	 * @param message function to specify the exception message
	 * 
	 * @since 2.18
	 */
	protected void validateUnhandledException(
			LightweightTypeReference thrownException,
			XExpression object,
			EStructuralFeature feature,
			ITypeComputationState state,
			Function<? super JvmType, ? extends String> message) {
		if (!state.isIgnored(IssueCodes.UNHANDLED_EXCEPTION) && thrownException.isSubtypeOf(Throwable.class)
				&& !thrownException.isSubtypeOf(RuntimeException.class) && !thrownException.isSubtypeOf(Error.class)) {
			boolean declarationFound = false;
			for (LightweightTypeReference declaredException : state.getExpectedExceptions())
				if (declaredException.isAssignableFrom(thrownException)) {
					declarationFound = true;
					break;
				}
			if (!declarationFound) {
				JvmType exceptionType = thrownException.getNamedType().getType();
				state.addDiagnostic(new EObjectDiagnosticImpl(
						state.getSeverity(IssueCodes.UNHANDLED_EXCEPTION),
						IssueCodes.UNHANDLED_EXCEPTION,
						message.apply(exceptionType),
						object,
						feature,
						-1,
						new String[] { 
							EcoreUtil.getURI(exceptionType).toString(),
							EcoreUtil.getURI(object).toString()
						}));
			}
		}
	}

	protected void _computeTypes(XReturnExpression object, ITypeComputationState state) {
		XExpression returnValue = object.getExpression();
		ITypeComputationState expressionState = state.withReturnExpectation();

		checkValidReturn(object, state);
		
		LightweightTypeReference primitiveVoid = getPrimitiveVoid(state);
		if (returnValue != null) {
			checkValidReturnExpression(returnValue, expressionState);
			state.acceptActualType(primitiveVoid, ConformanceFlags.NO_IMPLICIT_RETURN);
		} else {
			state.acceptActualType(primitiveVoid, ConformanceFlags.EXPLICIT_VOID_RETURN);
			state.acceptActualType(primitiveVoid, ConformanceFlags.NO_IMPLICIT_RETURN);
		}
	}

	protected void checkValidReturn(XReturnExpression object, ITypeComputationState state) {
		// if the expectation comes from a method's return type
		// then it is legal, thus we must check if the return is
		// contained in a throw expression
		if (hasThrowableExpectation(state) &&
				EcoreUtil2.getContainerOfType(object, XThrowExpression.class) != null) {
			state.addDiagnostic(new EObjectDiagnosticImpl(
					Severity.ERROR,
					IssueCodes.INVALID_RETURN,
					"Invalid return inside throw.",
					object,
					null,
					-1,
					new String[] { 
					}));
		}
	}

	protected boolean hasThrowableExpectation(ITypeComputationState state) {
		List<? extends ITypeExpectation> expectations = state.getExpectations();
		for (ITypeExpectation typeExpectation : expectations) {
			LightweightTypeReference expected = typeExpectation.getExpectedType();
			if (expected != null && expected.isType(Throwable.class))
				return true;
		}
		return false;
	}

	protected void checkValidReturnExpression(XExpression returnValue, ITypeComputationState expressionState) {
		ITypeComputationResult result = expressionState.computeTypes(returnValue);
		LightweightTypeReference actualType = result.getActualExpressionType();
		int conformanceFlags = result.getConformanceFlags();
		if (actualType.isPrimitiveVoid() && (conformanceFlags & ConformanceFlags.NO_IMPLICIT_RETURN) != 0) {
			String message = "Invalid return's expression.";
			if (returnValue instanceof XReturnExpression) {
				// when the return's expression is directory a return
				// we provide a more detailed error
				message = "Return cannot be nested.";
			}
			expressionState.addDiagnostic(new EObjectDiagnosticImpl(
					Severity.ERROR,
					IssueCodes.INVALID_RETURN,
					message,
					returnValue,
					null,
					-1,
					new String[] { 
					}));
		}
	}
	
	protected void _computeTypes(XTryCatchFinallyExpression object, ITypeComputationState state) {
		List<LightweightTypeReference> caughtExceptions = Lists.newArrayList();
		ITypeReferenceOwner referenceOwner = state.getReferenceOwner();
		
		// Caught Exceptions
		for (XCatchClause catchClause : object.getCatchClauses()) {
			if (catchClause.getDeclaredParam() != null && catchClause.getDeclaredParam().getParameterType() != null)
				caughtExceptions.add(referenceOwner.toLightweightTypeReference(catchClause.getDeclaredParam().getParameterType()));
		}
		
		// Resources
		List <XVariableDeclaration> resources = object.getResources();
		for (XVariableDeclaration resDecl : resources) {
			ITypeComputationState resourceState = state.withExpectedExceptions(caughtExceptions).withoutExpectation(); // no expectation
			resourceState.computeTypes(resDecl);
			addLocalToCurrentScope(resDecl, state);
		}
		state.withinScope(object);
		
		// Body of TryCatchExpression
		state.withExpectedExceptions(caughtExceptions).computeTypes(object.getExpression());

		// CatchClause
		for (XCatchClause catchClause : object.getCatchClauses()) {
			JvmFormalParameter catchClauseParam = catchClause.getDeclaredParam();
			JvmTypeReference parameterType = catchClauseParam.getParameterType();
			LightweightTypeReference lightweightReference = parameterType != null 
					? normalizedMultiType(referenceOwner, parameterType)
					: referenceOwner.newAnyTypeReference();
			if (lightweightReference.isSynonym()) {
				lightweightReference = getCommonSuperType(lightweightReference.getMultiTypeComponents(), referenceOwner);
			}
			ITypeComputationState catchClauseState = assignType(catchClauseParam, lightweightReference, state);
			catchClauseState.withinScope(catchClause);
			catchClauseState.computeTypes(catchClause.getExpression());
		}
		// FinallyClause
		// TODO validate / handle return / throw in finally block
		state.withoutExpectation().computeTypes(object.getFinallyExpression());
	}
	
	protected void _computeTypes(XSynchronizedExpression expr, ITypeComputationState state) {
		ITypeComputationState paramState = state.withExpectation(state.getReferenceOwner().newReferenceToObject());
		ITypeComputationResult paramType = paramState.computeTypes(expr.getParam());
		LightweightTypeReference actualParamType = paramType.getActualExpressionType();
		if (actualParamType != null && (actualParamType.isPrimitive() || actualParamType.isAny())) {
			state.addDiagnostic(new EObjectDiagnosticImpl(
					Severity.ERROR,
					IssueCodes.INCOMPATIBLE_TYPES,
					actualParamType.getHumanReadableName() +  " is not a valid type's argument for the synchronized expression.",
					expr.getParam(),
					null,
					-1,
					new String[] { 
					}));
		}
		state.computeTypes(expr.getExpression());
	}
	
	protected void _computeTypes(final XAssignment assignment, ITypeComputationState state) {
		List<? extends IFeatureLinkingCandidate> candidates = state.getLinkingCandidates(assignment);
		ILinkingCandidate best = getBestCandidate(candidates);
		best.applyToComputationState();
	}
	
	protected void _computeTypes(final XAbstractFeatureCall featureCall, ITypeComputationState state) {
		List<? extends IFeatureLinkingCandidate> candidates = state.getLinkingCandidates(featureCall);
		IFeatureLinkingCandidate best = (IFeatureLinkingCandidate) getBestCandidate(candidates);
		if (best.isTypeLiteral()) {
			checkTypeParameterNotAllowedAsLiteral(featureCall, (JvmType) best.getFeature(), state);
		}
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

	/* @Nullable */
	protected JvmIdentifiableElement getRefinableCandidate(XExpression object, ITypeComputationState state) {
		if (object instanceof XSwitchExpression) {
			XSwitchExpression switchExpression = (XSwitchExpression) object;
			JvmFormalParameter declaredParam = switchExpression.getDeclaredParam();
			if (declaredParam != null) {
				return declaredParam;
			}
			return getRefinableCandidate(switchExpression.getSwitch(), state);
		}
		if (object instanceof XFeatureCall) {
			List<? extends IFeatureLinkingCandidate> candidates = state.getLinkingCandidates((XFeatureCall)object);
			if (candidates.size() == 1) {
				JvmIdentifiableElement linkedFeature = candidates.get(0).getFeature();
				if (isRefinableFeature(linkedFeature)) {
					return linkedFeature;
				}
			}
		} else if (object instanceof XMemberFeatureCall) {
			List<? extends IFeatureLinkingCandidate> candidates = state.getLinkingCandidates((XMemberFeatureCall)object);
			if (candidates.size() == 1) {
				JvmIdentifiableElement linkedFeature = candidates.get(0).getFeature();
				if (isRefinableFeature(linkedFeature)) {
					XExpression receiver = ((XMemberFeatureCall) object).getMemberCallTarget();
					if (receiver instanceof XAbstractFeatureCall) {
						List<? extends IFeatureLinkingCandidate> receiverCandidates = state.getLinkingCandidates((XAbstractFeatureCall)receiver);
						if (receiverCandidates.size() == 1) {
							IFeatureLinkingCandidate receiverCandidate = receiverCandidates.get(0);
							if (receiverCandidate.getFeature() instanceof JvmType && !receiverCandidate.isTypeLiteral()) {
								return linkedFeature;
							}
						}
					}
				}
			}
		}
		return null;
	}

	protected boolean isRefinableFeature(/* @Nullable */ JvmIdentifiableElement feature) {
		return feature instanceof XVariableDeclaration
				|| feature instanceof XSwitchExpression
				|| feature instanceof JvmFormalParameter 
				|| feature instanceof JvmField;
	}
	
}
