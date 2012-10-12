/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Arrays;
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
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

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

	@Override
	public boolean isPreferredOver(ILinkingCandidate other) {
		if (other instanceof AbstractPendingLinkingCandidate) {
			AbstractPendingLinkingCandidate<?> right = (AbstractPendingLinkingCandidate<?>) other;
			boolean visible = isVisible();
			if (visible != right.isVisible()) {
				if (visible)
					return true;
				return false;
			}
			int arityCompareResult = compareByArityWith(right);
			if (arityCompareResult != 0)
				return arityCompareResult <= 0;
			int typeArityCompareResult = compareByArity(getTypeArityMismatch(), right.getTypeArityMismatch());
			if (typeArityCompareResult != 0)
				return typeArityCompareResult <= 0;
			int argumentTypeCompareResult = compareByArgumentTypes(right);
			if (argumentTypeCompareResult != 0)
				return argumentTypeCompareResult <= 0;
			return true;
		}
		throw new IllegalArgumentException("other was " + other);
	}
	
	protected boolean isVisible() {
		return description.isVisible();
	}
	
	protected int compareByArgumentTypes(AbstractPendingLinkingCandidate<?> right) {
		initializeArgumentTypeComputation();
		right.initializeArgumentTypeComputation();
		
		int upTo = Math.min(arguments.getArgumentSize(), right.arguments.getArgumentSize());
		int leftBoxing = 0;
		int rightBoxing = 0;
		for(int i = 0; i < upTo; i++) {
			EnumSet<ConformanceHint> leftConformance = getConformanceHints(i);
			EnumSet<ConformanceHint> rightConformance = right.getConformanceHints(i);
			int hintCompareResult = ConformanceHint.compareHints(leftConformance, rightConformance);
			if (hintCompareResult != 0)
				return hintCompareResult;
			if (leftConformance.contains(ConformanceHint.BOXING) || leftConformance.contains(ConformanceHint.UNBOXING)) {
				leftBoxing++;
			}
			if (rightConformance.contains(ConformanceHint.BOXING) || rightConformance.contains(ConformanceHint.UNBOXING)) {
				rightBoxing++;
			}
		}
		if (leftBoxing != rightBoxing) {
			if (leftBoxing < rightBoxing)
				return -1;
			return 1;
		}
		int result = compareDeclaredArgumentTypes(right);
		if (result != 0)
			return result;
		return result;
	}
	
	protected int compareByConformanceHints(EnumSet<ConformanceHint> leftConformance, EnumSet<ConformanceHint> rightConformance) {
		for(ConformanceHint hint: Arrays.asList(ConformanceHint.DEMAND_CONVERSION, ConformanceHint.SYNONYM, ConformanceHint.VAR_ARG, 
				ConformanceHint.BOXING, ConformanceHint.UNBOXING, ConformanceHint.PRIMITIVE_WIDENING)) {
			boolean leftContains = leftConformance.contains(hint);
			boolean rightContains = rightConformance.contains(hint);
			if (leftContains != rightContains) {
				if (leftContains)
					return 1;
				return -1;
			}
		}
		return 0;
	}
	
	protected int compareByConformanceHint(EnumSet<ConformanceHint> leftConformance, EnumSet<ConformanceHint> rightConformance, ConformanceHint unexpectedHint) {
		boolean leftContains = leftConformance.contains(unexpectedHint);
		boolean rightContains = rightConformance.contains(unexpectedHint);
		if (leftContains != rightContains) {
			if (leftContains)
				return 1;
			return -1;
		}
		return 0;
	}
	
	protected EnumSet<ConformanceHint> getConformanceHints(int idx) {
		while(!arguments.isProcessed(idx)) {
			computeArgumentType(arguments.getNextUnprocessedNextArgument());
		}
		XExpression argument = arguments.getArgument(idx);
		return getState().getStackedResolvedTypes().getConformanceHints(argument);
	}

	protected int compareDeclaredArgumentTypes(AbstractPendingLinkingCandidate<?> right) {
		int result = 0;
		int upTo = Math.min(arguments.getArgumentSize(), right.arguments.getArgumentSize());
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
		if (Math.abs(leftArityMismatch) < Math.abs(rightArityMismatch))
			return -1;
		if (Math.abs(leftArityMismatch) > Math.abs(rightArityMismatch))
			return 1;
		if (leftArityMismatch > 0)
			return -1;
		if (rightArityMismatch > 0)
			return 1;
		return 0;
	}
	
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
