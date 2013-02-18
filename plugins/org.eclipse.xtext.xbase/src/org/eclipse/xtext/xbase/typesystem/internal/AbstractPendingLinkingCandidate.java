/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByConstraintSubstitutor;
import org.eclipse.xtext.xbase.validation.IssueCodes;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO Javadoc
 */
@NonNullByDefault
public abstract class AbstractPendingLinkingCandidate<Expression extends XExpression> extends AbstractLinkingCandidate<Expression> { 
	
	protected final IIdentifiableElementDescription description;
	private final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping;
	
	protected AbstractPendingLinkingCandidate(Expression expression, IIdentifiableElementDescription description,
			ExpressionTypeComputationState state) {
		super(expression, state);
		this.description = description;
		this.typeParameterMapping = initializeTypeParameterMapping();
	}
	
	@Override
	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getTypeParameterMapping() {
		return typeParameterMapping;
	}
	
	protected abstract String getFeatureTypeName();
	
	public boolean validate(IAcceptor<? super AbstractDiagnostic> result) {
		// TODO improve messages
		if (!isVisible()) {
			String message = "The " + getFeatureTypeName() + " " + getFeature().getSimpleName() + " is not visible";
			AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(
					Severity.ERROR, 
					IssueCodes.FEATURE_NOT_VISIBLE, 
					message, 
					getExpression(), 
					XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, -1, null);
			result.accept(diagnostic);
			return false;
		} else if (getArityMismatch() != 0) {
			String message = "Invalid number of arguments. Expected " + getFeature().getSimpleName();
			AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(
					Severity.ERROR, 
					IssueCodes.INVALID_NUMBER_OF_ARGUMENTS, 
					message, 
					getExpression(), 
					XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, -1, null);
			result.accept(diagnostic);
			return false;
		} else if (getTypeArityMismatch() != 0) {
			String message = "Invalid number of type arguments. Expected " + getFeature().getSimpleName();
			AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(
					Severity.ERROR, 
					IssueCodes.INVALID_NUMBER_OF_TYPE_ARGUMENTS, 
					message, 
					getExpression(), 
					XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, -1, null);
			result.accept(diagnostic);
			return false;
		} else {
			// TODO use early exit computation
			List<XExpression> arguments = getSyntacticArguments();
			for(int i = 0; i < arguments.size(); i++) {
				XExpression argument = arguments.get(i);
				if (isDefiniteEarlyExit(argument)) {
					XExpression errorOn = getExpression();
					if (i < arguments.size() - 1) {
						errorOn = arguments.get(i + 1);
					}
					String message = "Unreachable code.";
					AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(
							Severity.ERROR, 
							IssueCodes.UNREACHABLE_CODE, 
							message, 
							errorOn, 
							null, 
							-1, null);
					result.accept(diagnostic);
					return false;
				}
			}
		}
		return true;
	}
	
	protected boolean isDefiniteEarlyExit(XExpression expression) {
		// TODO this needs some serious refinement
		return expression instanceof XReturnExpression || expression instanceof XThrowExpression;
	}
	
	protected List<XExpression> getSyntacticArguments() {
		return getArguments();
	}

	@Override
	public ILinkingCandidate getPreferredCandidate(ILinkingCandidate other) {
		if (other instanceof AbstractPendingLinkingCandidate) {
			AbstractPendingLinkingCandidate<?> right = (AbstractPendingLinkingCandidate<?>) other;
			int arityCompareResult = compareByArityWith(right);
			if (arityCompareResult != 0) {
				if (arityCompareResult <= 0) {
					return getThis();
				}
				return other;
			}
			boolean visible = isVisible();
			if (visible != right.isVisible()) {
				if (visible)
					return getThis();
				return other;
			}
			int typeArityCompareResult = compareByArity(getTypeArityMismatch(), right.getTypeArityMismatch());
			if (typeArityCompareResult != 0) {
				if (typeArityCompareResult <= 0) {
					return getThis();
				}
				return other;
			}
			int argumentTypeCompareResult = compareByArgumentTypes(right);
			if (argumentTypeCompareResult != 0) {
				if (argumentTypeCompareResult <= 0) {
					return getThis();
				}
				return other;
			}
			int typeArgumentCompareResult = compareByTypeArguments(right);
			if (typeArgumentCompareResult != 0) {
				if (typeArgumentCompareResult <= 0) {
					return getThis();
				}
				return other;
			}
			if(this.isVarArgs() && !right.isVarArgs()) {
				return right;
			}
			return getThis();
		}
		throw new IllegalArgumentException("other was " + other);
	}
	
	protected abstract ILinkingCandidate getThis();
	
	protected boolean isVisible() {
		return description.isVisible();
	}

	protected boolean isVarArgs() {
		return getFeature() instanceof JvmExecutable && ((JvmExecutable)getFeature()).isVarArgs();
	}
	
	protected boolean isExtension() {
		return false;
	}
	
	protected int compareByArgumentTypes(AbstractPendingLinkingCandidate<?> right) {
		initializeArgumentTypeComputation();
		right.initializeArgumentTypeComputation();
		
		int result = compareByArgumentTypes(right, false);
		if (result != 0)
			return result;
		result = compareDeclaredParameterTypes(right);
		if (result != 0)
			return result;
		// subsequent parameters may have altered the bound type arguments
		// TODO this is more of a workaround than a real solution
		// actually the order of added hints and their sources should take care of that case
		// in a way that UnboundTypeConformance returns false for invalid combinations
		result = compareByArgumentTypes(right, true);
		if (result != 0)
			return result;
		return result;
	}
	
	protected int compareByTypeArguments(AbstractPendingLinkingCandidate<?> right) {
		initializeArgumentTypeComputation();
		right.initializeArgumentTypeComputation();
		
		int leftFailures = getTypeArgumentConformanceFailures();
		int rightFailures = right.getTypeArgumentConformanceFailures();
		if (leftFailures != rightFailures) {
			if (leftFailures < rightFailures)
				return -1;
			return 1;
		}
		return 0;
	}

	protected int getTypeArgumentConformanceFailures() {
		List<LightweightTypeReference> typeArguments = getTypeArguments();
		List<JvmTypeParameter> typeParameters = getDeclaredTypeParameters();
		int max = Math.min(typeArguments.size(), typeParameters.size());
		int failures = 0;
		TypeParameterByConstraintSubstitutor substitutor = new TypeParameterByConstraintSubstitutor(getDeclaratorParameterMapping(), getState().getReferenceOwner());
		for(int i = 0; i < max; i++) {
			LightweightTypeReference argument = typeArguments.get(i);
			JvmTypeParameter declaration = typeParameters.get(i);
			LightweightTypeReference substitute = substitutor.substitute(declaration);
			if (!substitute.isAssignableFrom(argument)) {
				failures++;
			}
		}
		return failures;
	}
	
	protected int compareByArgumentTypes(AbstractPendingLinkingCandidate<?> right, boolean recompute) {
		int upTo = Math.max(arguments.getArgumentCount(), right.arguments.getArgumentCount());
		int leftBoxing = 0;
		int rightBoxing = 0;
		int leftDemand = 0;
		int rightDemand = 0;
		for(int i = 0; i < upTo; i++) {
			EnumSet<ConformanceHint> leftConformance = getConformanceHints(i, recompute);
			EnumSet<ConformanceHint> rightConformance = right.getConformanceHints(i, recompute);
			int hintCompareResult = compareByArgumentTypes(right, i, leftConformance, rightConformance);
			if (hintCompareResult != 0)
				return hintCompareResult;
			if (leftConformance.contains(ConformanceHint.DEMAND_CONVERSION)) {
				leftDemand++;
			}
			if (rightConformance.contains(ConformanceHint.DEMAND_CONVERSION)) {
				rightDemand++;
			}
			if (leftConformance.contains(ConformanceHint.BOXING) || leftConformance.contains(ConformanceHint.UNBOXING)) {
				leftBoxing++;
			}
			if (rightConformance.contains(ConformanceHint.BOXING) || rightConformance.contains(ConformanceHint.UNBOXING)) {
				rightBoxing++;
			}
		}
		return compareByArgumentTypes(right, leftBoxing, rightBoxing, leftDemand, rightDemand);
	}

	protected int compareByArgumentTypes(AbstractPendingLinkingCandidate<?> right, int argumentIndex, EnumSet<ConformanceHint> leftConformance, EnumSet<ConformanceHint> rightConformance) {
		int hintCompareResult = ConformanceHint.compareHints(leftConformance, rightConformance);
		return hintCompareResult;
	}

	protected int compareByArgumentTypes(AbstractPendingLinkingCandidate<?> right, int leftBoxing, int rightBoxing, int leftDemand, int rightDemand) {
		if (leftDemand != rightDemand) {
			if (leftDemand < rightDemand)
				return -1;
			return 1;
		}
		if (leftBoxing != rightBoxing) {
			if (leftBoxing < rightBoxing)
				return -1;
			return 1;
		}
		return 0;
	}
	
	protected EnumSet<ConformanceHint> getConformanceHints(int idx, boolean recompute) {
		while(!arguments.isProcessed(idx)) {
			computeArgumentType(arguments.getNextUnprocessedArgumentSlot());
		}
		if (idx >= arguments.getArgumentCount()) {
			return EnumSet.of(ConformanceHint.SUCCESS, ConformanceHint.CHECKED); 
		}
		XExpression argument = arguments.getArgument(idx);
		if (argument == null) {
			return EnumSet.of(ConformanceHint.INCOMPATIBLE);
		}
		return getState().getStackedResolvedTypes().getConformanceHints(argument, recompute);
	}

	protected int compareDeclaredParameterTypes(AbstractPendingLinkingCandidate<?> right) {
		int result = 0;
		int upTo = Math.min(arguments.getArgumentCount(), right.arguments.getArgumentCount());
		for(int i = 0; i < upTo; i++) {
			LightweightTypeReference expectedArgumentType = getSubstitutedExpectedType(i);
			LightweightTypeReference rightExpectedArgumentType = right.getSubstitutedExpectedType(i);
			if (expectedArgumentType == null) {
				if (rightExpectedArgumentType != null)
					return 1;
			} else {
				if (rightExpectedArgumentType == null) {
					return -1;
				}
				if (expectedArgumentType.isAssignableFrom(rightExpectedArgumentType)) {
					if (!rightExpectedArgumentType.isAssignableFrom(expectedArgumentType))
						result++;
				} else if (rightExpectedArgumentType.isAssignableFrom(expectedArgumentType)) {
					result--;
				}
			}
		}
		return result;
	}
	
	protected int compareByArityWith(AbstractPendingLinkingCandidate<?> right) {
		int arityCompareResult = compareByArity(getArityMismatch(), right.getArityMismatch());
		return arityCompareResult;
	}

	protected int compareByArity(int leftArityMismatch, int rightArityMismatch) {
		if (leftArityMismatch != rightArityMismatch) {
			if (leftArityMismatch == 0)
				return -1;
			if (rightArityMismatch == 0)
				return 1;
			if (Math.abs(leftArityMismatch) < Math.abs(rightArityMismatch))
				return -1;
			if (Math.abs(leftArityMismatch) > Math.abs(rightArityMismatch))
				return 1;
			if (leftArityMismatch > 0)
				return -1;
			if (rightArityMismatch > 0)
				return 1;
		}
		return 0;
	}
	
	/**
	 * Returns the mismatch of actually given arguments and declared parameters.
	 * Receivers and staticness of the feature is taken into account, too. The mismatch
	 * may either be negative or positive.
	 */
	public int getArityMismatch() {
		JvmIdentifiableElement identifiable = getFeature();
		if (identifiable instanceof JvmExecutable) {
			return getArityMismatch((JvmExecutable) identifiable, getArguments());
		} else if (getExpression() instanceof XAssignment) {
			return getArguments().size() - 1;
		} else {
			return getArguments().size();
		}
	}
	
	public int getTypeArityMismatch() {
		List<LightweightTypeReference> syntacticTypeArguments = getSyntacticTypeArguments();
		if (syntacticTypeArguments.size() == 0)
			return 0;
		return getDeclaredTypeParameters().size() - syntacticTypeArguments.size();
	}
	
	protected void resolveLinkingProxy(EReference structuralFeature, int featureId) {
		InternalEObject internalView = (InternalEObject) getExpression();
		JvmIdentifiableElement newFeature = getFeature();
		if (newFeature.eIsProxy()) {
			newFeature = (JvmIdentifiableElement) internalView.eResolveProxy((InternalEObject) newFeature);
		}
		EObject oldFeature = (EObject) internalView.eGet(structuralFeature, false);
		if (oldFeature == null || !(oldFeature.eIsProxy())) {
			throw new IllegalStateException("Feature was already resolved to " + oldFeature);
		}
		if (internalView.eNotificationRequired()) {
			boolean wasDeliver = internalView.eDeliver();
			internalView.eSetDeliver(false);
			internalView.eSet(structuralFeature, newFeature);
			internalView.eSetDeliver(wasDeliver);
			if (newFeature != oldFeature) {
				internalView.eNotify(new ENotificationImpl(internalView, Notification.RESOLVE, featureId, oldFeature, newFeature));
			}
		} else {
			internalView.eSet(structuralFeature, newFeature);
		}
	}
	
	protected int getArityMismatch(JvmExecutable executable, List<XExpression> arguments) {
		int fixedArityParamCount = executable.getParameters().size();
		if (executable.isVarArgs()) {
			fixedArityParamCount--;
			if (arguments.size() >= fixedArityParamCount) {
				return 0;
			}
		}
		return fixedArityParamCount - arguments.size();
	}
	
	@Override
	public JvmIdentifiableElement getFeature() {
		return description.getElementOrProxy();
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [" + description.toString() + "]";
	}
}
