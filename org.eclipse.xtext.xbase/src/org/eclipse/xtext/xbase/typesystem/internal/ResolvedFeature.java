/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.util.Wrapper;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.arguments.IFeatureCallArgumentSlot;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.computation.SynonymTypesProvider;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputationArgument;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.DeferredTypeParameterHintCollector;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ResolvedFeature extends AbstractResolvedReference<XAbstractFeatureCall> implements IFeatureLinkingCandidate {

	private FeatureLinkHelper helper;

	public ResolvedFeature(
			XAbstractFeatureCall featureCall,
			JvmIdentifiableElement feature,
			FeatureLinkHelper helper,
			ITypeExpectation expectation,
			ExpressionTypeComputationState state) {
		super(featureCall, feature, expectation, state);
		this.helper = helper;
	}
	
	@Override
	public ILinkingCandidate getPreferredCandidate(ILinkingCandidate other) {
		return this;
	}

	@Override
	/* @Nullable */
	protected LightweightTypeReference getSubstitutedExpectedType(int idx) {
		if (idx == 0 && getReceiver() != null) {
			return getReceiverType();
		}
		return super.getSubstitutedExpectedType(idx);
	}
	
	@Override
	public void applyToComputationState() {
		XExpression receiver = getImplicitReceiver();
		if (receiver != null) {
			ResolvedTypes resolvedTypes = getState().getResolvedTypes();
			LightweightTypeReference receiverType = getImplicitReceiverType();
			if (receiverType == null) {
				throw new IllegalStateException("Cannot determine type of receiver "+ receiver);
			}
			TypeExpectation expectation = new TypeExpectation(null, getState(), false);
			resolvedTypes.acceptType(receiver, expectation, receiverType.copyInto(resolvedTypes.getReferenceOwner()), false, ConformanceFlags.UNCHECKED);
		} 
		getState().markAsRefinedTypeIfNecessary(this);
		discardRefinementTypeIfReassigned();
		
		XExpression actualReceiver = getReceiver();
		if (actualReceiver != null) {
			LightweightTypeReference receiverType = getReceiverType();
			if (receiverType == null) {
				throw new IllegalStateException("Cannot determine receiver's type");
			}
			JvmIdentifiableElement feature = getFeature();
			if (feature instanceof JvmFeature) {
				JvmDeclaredType declaringType = ((JvmFeature) feature).getDeclaringType();
				final LightweightTypeReference declaringTypeReference = receiverType.getOwner().newParameterizedTypeReference(declaringType);
				final TypeConformanceComputationArgument rawConformanceCheck = new TypeConformanceComputationArgument(true, false, false, false, false, false);
				if (!declaringTypeReference.isAssignableFrom(receiverType, rawConformanceCheck)) {
					final Wrapper<LightweightTypeReference> expectedReceiverTypeWrapper = Wrapper.wrap(null); 
					CommonTypeComputationServices services = receiverType.getOwner().getServices();
					SynonymTypesProvider synonymProvider = services.getSynonymTypesProvider();
					synonymProvider.collectSynonymTypes(receiverType, new SynonymTypesProvider.Acceptor() {
						@Override
						protected boolean accept(LightweightTypeReference synonym, int flags) {
							if (declaringTypeReference.isAssignableFrom(synonym, rawConformanceCheck)) {
								expectedReceiverTypeWrapper.set(synonym);
								return false;
							}
							return true;
						}
					});
					LightweightTypeReference expectedReceiverType = expectedReceiverTypeWrapper.get();
					if (expectedReceiverType != null) {
						getState().refineExpectedType(actualReceiver, expectedReceiverType);
					}
				}
			}
		}
		super.applyToComputationState();
	}
	
	@Override
	protected boolean isRawTypeContext() {
		LightweightTypeReference receiverType = getReceiverType();
		if(receiverType != null && receiverType.isRawType()) {
			return true;
		}
		return false;
	}
	
	@Override
	protected void resolveAgainstActualType(LightweightTypeReference declaredType, LightweightTypeReference actualType, final AbstractTypeComputationState state) {
		super.resolveAgainstActualType(declaredType, actualType, state);
		if (!isStatic() && !isExtension()) {
			DeferredTypeParameterHintCollector collector = new DeferredTypeParameterHintCollector(state.getReferenceOwner());
			collector.processPairedReferences(declaredType, actualType);
		}
	}
	
	@Override
	protected List<XExpression> getArguments() {
		return getFeatureCall().getActualArguments();
	}

	@Override
	public XAbstractFeatureCall getFeatureCall() {
		return getExpression();
	}
	
	@Override
	protected List<JvmTypeReference> getPlainSyntacticTypeArguments() {
		return getFeatureCall().getTypeArguments();
	}
	
	@Override
	protected void computeVarArgumentType(IFeatureCallArgumentSlot slot, TypeParameterSubstitutor<?> substitutor) {
		if (isExtension()) {
			List<XExpression> arguments = slot.getArgumentExpressions();
			if (arguments.size() == 1) {
				XExpression singleArgument = arguments.get(0);
				if (singleArgument == getSyntacticReceiver() || singleArgument == getImplicitFirstArgument()) {
					computeFixedArityArgumentType(slot, substitutor);
					return;
				}
			}
		}
		super.computeVarArgumentType(slot, substitutor);
	}
	
	@Override
	protected void resolveArgumentType(XExpression argument, /* @Nullable */ LightweightTypeReference declaredType, ITypeComputationState argumentState) {
		if (argument == getSyntacticReceiver()) {
			LightweightTypeReference receiverType = getSyntacticReceiverType();
			if (receiverType == null) {
				throw new IllegalStateException("Cannot determine the receiver's type");
			}
			resolveKnownArgumentType(argument, receiverType, declaredType, argumentState);
		} else if (argument == getImplicitFirstArgument()) {
			LightweightTypeReference argumentType = getImplicitFirstArgumentType();
			if (argumentType == null) {
				throw new IllegalStateException("Cannot determine the implicit argument's type");
			}
			resolveKnownArgumentType(argument, argumentType, declaredType, argumentState);
		} else {
			super.resolveArgumentType(argument, declaredType, argumentState);
		}
	}
	
	protected void resolveKnownArgumentType(XExpression argument, LightweightTypeReference knownType,
			/* @Nullable */ LightweightTypeReference declaredType, ITypeComputationState argumentState) {
		if (!(argumentState instanceof AbstractTypeComputationState))
			throw new IllegalArgumentException("argumentState was " + argumentState);
		AbstractTypeComputationState castedArgumentState = (AbstractTypeComputationState) argumentState;
		ResolvedTypes resolvedTypes = getState().getResolvedTypes();
		LightweightTypeReference copiedDeclaredType = declaredType != null ? declaredType.copyInto(resolvedTypes.getReferenceOwner()) : null;
		TypeExpectation expectation = new TypeExpectation(copiedDeclaredType, castedArgumentState, false);
		LightweightTypeReference copiedReceiverType = knownType.copyInto(resolvedTypes.getReferenceOwner());
		// TODO should we use the result of #acceptType?
		resolvedTypes.acceptType(argument, expectation, copiedReceiverType, false, ConformanceFlags.UNCHECKED);
		if (copiedDeclaredType != null)
			resolveAgainstActualType(copiedDeclaredType, copiedReceiverType, castedArgumentState);
	}
	
	@Override
	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getDeclaratorParameterMapping() {
		final Wrapper<Map<JvmTypeParameter, LightweightMergedBoundTypeArgument>> receiverTypeParameterMapping = Wrapper.wrap(Collections.<JvmTypeParameter, LightweightMergedBoundTypeArgument>emptyMap());
		XExpression receiver = getReceiver();
		if (receiver != null) {
			LightweightTypeReference receiverType = getReceiverType();
			if (receiverType == null) {
				throw new IllegalStateException("Cannot determine type of receiver "+ getReceiver());
			}
			JvmIdentifiableElement feature = getFeature();
			if (feature instanceof JvmFeature) {
				JvmDeclaredType declaringType = ((JvmFeature) feature).getDeclaringType();
				final LightweightTypeReference declaringTypeReference = receiverType.getOwner().newParameterizedTypeReference(declaringType);
				final TypeConformanceComputationArgument rawConformanceCheck = new TypeConformanceComputationArgument(true, false, false, false, false, false);
				if (declaringTypeReference.isAssignableFrom(receiverType, rawConformanceCheck)) {
					receiverTypeParameterMapping.set(new DeclaratorTypeArgumentCollector().getTypeParameterMapping(receiverType));
				} else {
					CommonTypeComputationServices services = receiverType.getOwner().getServices();
					SynonymTypesProvider synonymProvider = services.getSynonymTypesProvider();
					synonymProvider.collectSynonymTypes(receiverType, new SynonymTypesProvider.Acceptor() {
						
						@Override
						protected boolean accept(LightweightTypeReference synonym, int hints) {
							if (declaringTypeReference.isAssignableFrom(synonym, rawConformanceCheck)) {
								receiverTypeParameterMapping.set(new DeclaratorTypeArgumentCollector().getTypeParameterMapping(synonym));
								return false;
							}
							return true;
						}
					});
				}
				
			} else {
				receiverTypeParameterMapping.set(new DeclaratorTypeArgumentCollector().getTypeParameterMapping(receiverType));
			}
		}
		return receiverTypeParameterMapping.get();
	}
	
	@Override
	protected LightweightTypeReference getDeclaredType(JvmIdentifiableElement feature) {
		if (feature instanceof JvmConstructor) {
			return getState().getReferenceOwner().newReferenceTo(Void.TYPE);
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
					throw new IllegalStateException("Cannot determine type of receiver "+ getReceiver());
				}
				List<JvmType> rawTypes = receiverType.getRawTypes();
				if (rawTypes.isEmpty()) {
					return super.getDeclaredType(feature);
				}
				ITypeReferenceOwner owner = receiverType.getOwner();
				ParameterizedTypeReference result = owner.newParameterizedTypeReference(((JvmOperation) feature).getReturnType().getType());
				WildcardTypeReference wildcard = owner.newWildcardTypeReference();
				wildcard.addUpperBound(owner.toPlainTypeReference(rawTypes.get(0)));
				result.addTypeArgument(wildcard);
				return result;
			}
		}
		return super.getDeclaredType(feature);
	}
	
	/* @Nullable */
	protected XExpression getImplicitReceiver() {
		return getExpression().getImplicitReceiver();
	}
	
	/* @Nullable */
	protected LightweightTypeReference getImplicitReceiverType() {
		LightweightTypeReference result = getActualType(getImplicitReceiver());
		return result;
	}
	
	/* @Nullable */
	protected XExpression getImplicitFirstArgument() {
		return getExpression().getImplicitFirstArgument();
	}
	
	/* @Nullable */
	protected LightweightTypeReference getImplicitFirstArgumentType() {
		LightweightTypeReference result = getActualType(getImplicitFirstArgument());
		return result;
	}
	
	/* @Nullable */
	protected XExpression getReceiver() {
		return getFeatureCall().getActualReceiver();
	}
	
	/* @Nullable */
	protected LightweightTypeReference getReceiverType() {
		LightweightTypeReference result = getActualType(getReceiver());
		return result;
	}
	
	/* @Nullable */
	protected XExpression getSyntacticReceiver() {
		return helper.getSyntacticReceiver(getFeatureCall());
	}
	
	/* @Nullable */
	protected LightweightTypeReference getSyntacticReceiverType() {
		LightweightTypeReference result = getActualType(getSyntacticReceiver());
		return result;
	}
	
	/**
	 * For testing purpose
	 */
	protected List<XExpression> getSyntacticArguments() {
		return helper.getSyntacticArguments(getFeatureCall());
	}
	
	@Override
	public boolean isExtension() {
		return getFeatureCall().isExtension();
	}
	
	@Override
	protected boolean hasReceiver() {
		return !isStatic();
	}
	
	@Override
	public boolean isStatic() {
		return getFeatureCall().isStatic();
	}
	
	@Override
	public boolean isTypeLiteral() {
		XAbstractFeatureCall featureCall = getFeatureCall();
		return featureCall.isTypeLiteral();
	}
}
