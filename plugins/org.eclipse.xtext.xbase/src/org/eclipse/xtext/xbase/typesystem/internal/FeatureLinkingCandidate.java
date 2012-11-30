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

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.DeferredTypeParameterHintCollector;
import org.eclipse.xtext.xbase.typesystem.util.FeatureLinkHelper;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class FeatureLinkingCandidate extends AbstractPendingLinkingCandidate<XAbstractFeatureCall> implements IFeatureLinkingCandidate {

	public FeatureLinkingCandidate(XAbstractFeatureCall featureCall, IIdentifiableElementDescription description,
			ExpressionTypeComputationState state) {
		super(featureCall, description, state);
	}

	@Override
	protected List<XExpression> getArguments() {
		boolean isStatic = isStatic();
		XExpression syntacticReceiver = getSyntacticReceiver();
		List<XExpression> syntacticArguments = getSyntacticArguments();
		if (isStatic) {
			if (syntacticReceiver != null) {
				return createArgumentList(syntacticReceiver, syntacticArguments);
			}
			XExpression implicitFirstArgument = getImplicitFirstArgument();
			if (implicitFirstArgument != null) {
				return createArgumentList(implicitFirstArgument, syntacticArguments);
			}
		} else {
			XExpression implicitReceiver = getImplicitReceiver();
			if (implicitReceiver != null && syntacticReceiver != null) {
				return createArgumentList(syntacticReceiver, syntacticArguments);
			}
			XExpression implicitFirstArgument = getImplicitFirstArgument();
			if (implicitFirstArgument != null) {
				return createArgumentList(implicitFirstArgument, syntacticArguments);
			}
		}
		return syntacticArguments;
	}

	protected List<XExpression> createArgumentList(XExpression head, List<XExpression> tail) {
		// TODO investigate in optimized List impls like HEAD, syntacticArguments
		List<XExpression> result = Lists.newArrayListWithExpectedSize(tail.size() + 1);
		result.add(head);
		for(XExpression expression: tail) {
			// addAll will convert the tail to an array, first
			result.add(expression);
		}
		return result;
	}
	
	protected List<XExpression> getSyntacticArguments() {
		return new FeatureLinkHelper().getSyntacticArguments(getFeatureCall());
	}
	
	public boolean isExtension() {
		return description.isExtension();
	}
	
	@Override
	protected boolean hasReceiver() {
		return !isStatic();
	}
	
	public boolean isStatic() {
		return description.isStatic();
	}
	
	@Override
	protected EnumSet<ConformanceHint> getConformanceHints(int idx) {
		if (idx == 0 && !isStatic()) {
			return EnumSet.of(ConformanceHint.CHECKED, ConformanceHint.SUCCESS);
		}
		return super.getConformanceHints(idx);
	}
	
	@Override
	@Nullable
	protected LightweightTypeReference getSubstitutedExpectedType(int idx) {
		if (idx == 0 && !isStatic()) {
			return getReceiverType();
		}
		return super.getSubstitutedExpectedType(idx);
	}
	
	protected boolean isExplicitOperationCall() {
		return getFeatureCall().isExplicitOperationCallOrBuilderSyntax();
	}
	
	@Override
	protected int compareByArityWith(AbstractPendingLinkingCandidate<?> right) {
		int result = super.compareByArityWith(right);
		if (result == 0) {
			boolean isExecutable = getFeature() instanceof JvmExecutable;
			if (isExecutable != right.getFeature() instanceof JvmExecutable) {
				if (getExpression() instanceof XAssignment) {
					if (isExecutable)
						return 1;
					return -1;
				} else {
					if (isExplicitOperationCall()) {
						if (isExecutable)
							return -1;
						return 1;
					} else {
						if (isExecutable)
							return 1;
						return -1;
					}
				}
			}
		}
		return result;
	}
	
	@Override
	protected int compareByArgumentTypes(AbstractPendingLinkingCandidate<?> right) {
		int result = super.compareByArgumentTypes(right);
		if (result != 0 || !(right instanceof FeatureLinkingCandidate))
			return result;
		FeatureLinkingCandidate casted = (FeatureLinkingCandidate) right;
		if (isExtension() != casted.isExtension()) {
			if (isExtension())
				return 1;
			return -1;
		}
		return result;
	}
	
	@Override
	protected void preApply() {
		applyImplicitReceiver();
		super.preApply();
		XExpression implicitFirstArgument = getImplicitFirstArgument();
		if (implicitFirstArgument != null) {
			new ImplicitFirstArgument(getFeatureCall(), (XAbstractFeatureCall) implicitFirstArgument, getState()).apply();
		}
	}
	
	protected void applyImplicitReceiver() {
		XExpression implicitReceiver = getImplicitReceiver();
		if (implicitReceiver != null) {
			ResolvedTypes resolvedTypes = getState().getResolvedTypes();
			LightweightTypeReference receiverType = getImplicitReceiverType();
			TypeExpectation expectation = new TypeExpectation(null, getState(), false);
			if (receiverType == null) {
				throw new IllegalStateException("Cannot determine the receiver's type");
			}
			resolvedTypes.acceptType(implicitReceiver, expectation, receiverType.copyInto(resolvedTypes.getReferenceOwner()), false, ConformanceHint.UNCHECKED);
			if (implicitReceiver instanceof XAbstractFeatureCall) {
				new ImplicitReceiver(getFeatureCall(), (XAbstractFeatureCall) implicitReceiver, getState()).apply();
			} else {
				throw new IllegalStateException("unexpected implicit receiver, was: " + implicitReceiver);
			}
		}
	}

	@Override
	protected void resolveAgainstActualType(LightweightTypeReference declaredType, LightweightTypeReference actualType, final AbstractTypeComputationState state) {
		super.resolveAgainstActualType(declaredType, actualType, state);
		if (!isStatic() && !isExtension()) {
			DeferredTypeParameterHintCollector collector = new DeferredTypeParameterHintCollector(state.getReferenceOwner());
			collector.processPairedReferences(declaredType, actualType);
		}
	}

	public XAbstractFeatureCall getFeatureCall() {
		return getExpression();
	}
	
	@Override
	protected List<LightweightTypeReference> getSyntacticTypeArguments() {
		return Lists.transform(getFeatureCall().getTypeArguments(), getState().getResolvedTypes().getConverter());
	}
	
	@Override
	protected void resolveArgumentType(XExpression argument, @Nullable LightweightTypeReference declaredType, ITypeComputationState argumentState) {
		if (argument == getSyntacticReceiver()) {
			LightweightTypeReference receiverType = getSyntacticReceiverType();
			if (receiverType != null) {
				resolveKnownArgumentType(argument, receiverType, declaredType, argumentState);
			}
		} else if (argument == description.getImplicitFirstArgument()) {
			LightweightTypeReference argumentType = getImplicitFirstArgumentType();
			if (argumentType != null) {
				resolveKnownArgumentType(argument, argumentType, declaredType, argumentState);
			}
		} else {
			super.resolveArgumentType(argument, declaredType, argumentState);
		}
	}

	// TODO some code is duplicated in ResolvedFeature - extract delegator
	protected void resolveKnownArgumentType(XExpression argument, LightweightTypeReference knownType,
			@Nullable LightweightTypeReference declaredType, ITypeComputationState argumentState) {
		if (!(argumentState instanceof AbstractTypeComputationState))
			throw new IllegalArgumentException("argumentState was " + argumentState);
		AbstractTypeComputationState castedArgumentState = (AbstractTypeComputationState) argumentState;
		ResolvedTypes resolvedTypes = getState().getResolvedTypes();
		LightweightTypeReference copiedDeclaredType = declaredType != null ? declaredType.copyInto(resolvedTypes.getReferenceOwner()) : null;
		TypeExpectation expectation = new TypeExpectation(copiedDeclaredType, castedArgumentState, false);
		LightweightTypeReference copiedReceiverType = knownType.copyInto(resolvedTypes.getReferenceOwner());
		// TODO should we use the result of #acceptType?
		resolvedTypes.acceptType(argument, expectation, copiedReceiverType, false, ConformanceHint.UNCHECKED);
		if (copiedDeclaredType != null)
			resolveAgainstActualType(copiedDeclaredType, copiedReceiverType, castedArgumentState);
	}
	
	@Override
	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getDeclaratorParameterMapping() {
		if (isStatic())
			return super.getDeclaratorParameterMapping();
		if (getImplicitReceiver() != null)
			return description.getImplicitReceiverTypeParameterMapping();
		return description.getSyntacticReceiverTypeParameterMapping();
	}
	
	@Nullable
	protected XExpression getReceiver() {
		if (isStatic())
			return null;
		XExpression result = getImplicitReceiver();
		if (result != null)
			return result;
		return getSyntacticReceiver();
	}
	
	@Nullable
	protected LightweightTypeReference getReceiverType() {
		if (isStatic())
			return null;
		LightweightTypeReference result;
		if (getImplicitReceiver() != null)
			result = getImplicitReceiverType();
		else
			result = getSyntacticReceiverType();
		return result;
	}
	
	@Nullable
	protected XExpression getImplicitReceiver() {
		return description.getImplicitReceiver();
	}
	
	@Nullable
	protected LightweightTypeReference getImplicitReceiverType() {
		return description.getImplicitReceiverType();
	}
	
	@Nullable
	protected XExpression getSyntacticReceiver() {
		return description.getSyntacticReceiver();
	}
	
	@Nullable
	protected LightweightTypeReference getSyntacticReceiverType() {
		return description.getSyntacticReceiverType();
	}
	
	@Nullable
	protected XExpression getImplicitFirstArgument() {
		return description.getImplicitFirstArgument();
	}
	
	@Nullable
	protected LightweightTypeReference getImplicitFirstArgumentType() {
		return description.getImplicitFirstArgumentType();
	}
	
	@Override
	protected LightweightTypeReference getDeclaredType(JvmIdentifiableElement feature) {
		if (feature instanceof JvmConstructor) {
			return getState().getConverter().toLightweightReference(getState().getTypeReferences().getTypeForName(Void.TYPE, feature));
		}
		/*
		 * The actual result type is Class<? extends |X|> where |X| is the erasure of 
		 * the static type of the expression on which getClass is called. For example, 
		 * no cast is required in this code fragment:
		 *   Number n = 0;
		 *   Class<? extends Number> c = n.getClass();
		 */
		if (feature instanceof JvmOperation && feature.getSimpleName().equals("getClass")) {
			JvmOperation getClassOperation = (JvmOperation) feature;
			if (getClassOperation.getParameters().isEmpty() && "java.lang.Object".equals(getClassOperation.getDeclaringType().getIdentifier())) {
				LightweightTypeReference receiverType = getReceiverType();
				if (receiverType == null) {
					throw new IllegalStateException("Cannot determine the receiver's type");
				}
				List<JvmType> rawTypes = receiverType.getRawTypes();
				if (rawTypes.isEmpty()) {
					return super.getDeclaredType(feature);
				}
				ParameterizedTypeReference result = new ParameterizedTypeReference(receiverType.getOwner(), getClassOperation.getReturnType().getType());
				WildcardTypeReference wildcard = new WildcardTypeReference(receiverType.getOwner());
				wildcard.addUpperBound(new ParameterizedTypeReference(receiverType.getOwner(), rawTypes.get(0)));
				result.addTypeArgument(wildcard);
				return result;
			}
		}
		return super.getDeclaredType(feature);
	}
	
	public void resolveLinkingProxy() {
		resolveLinkingProxy(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, XbasePackage.XABSTRACT_FEATURE_CALL__FEATURE);
	}

}
