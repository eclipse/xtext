/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.scoping.batch.BucketedEObjectDescription;
import org.eclipse.xtext.xbase.typesystem.computation.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.DeferredTypeParameterHintCollector;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameterPreservingSubstitutor;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class FeatureLinkingCandidate extends AbstractLinkingCandidate<IFeatureLinkingCandidate> implements IFeatureLinkingCandidate {

	public FeatureLinkingCandidate(XAbstractFeatureCall featureCall, IEObjectDescription description,
			ExpressionTypeComputationState state) {
		super(featureCall, description, state);
	}

	protected LightweightTypeReference getReceiverType() {
		LightweightTypeReference receiverType = null;
		if (getDescription() instanceof BucketedEObjectDescription) {
			receiverType = ((BucketedEObjectDescription) getDescription()).getReceiverType();
		}
		return receiverType;
	}
	
	@Override
	public int compareTo(IFeatureLinkingCandidate right) {
		int result = super.compareTo(right);
		if (result == 0) {
			return result;
		}
		return result;
	}
	
	@Override
	protected int compareByArityWith(IFeatureLinkingCandidate right) {
		int result = super.compareByArityWith(right);
		if (result == 0) {
			// TODO sort according to type compatibility
			result = favorInstanceOverExtensions(right);
			if (result != 0)
				return result;
			if (right.getDeclaredParameters().size() > getDeclaredParameters().size())
				return 1;
		}
		return result;
	}
	
	private int favorInstanceOverExtensions(IFeatureLinkingCandidate right) {
		if (!isStaticOrExtension(this) && isStaticOrExtension(right))
			return -1;
		if (isStaticOrExtension(this) == isStaticOrExtension(right))
			return 0;
		return 1;
	}
	
	protected boolean isStaticOrExtension(IFeatureLinkingCandidate candidate) {
		return candidate.isStatic() || candidate.isExtension();
	}
	
	public boolean isExtension() {
		IEObjectDescription description = getDescription();
		if (description instanceof BucketedEObjectDescription) {
			return ((BucketedEObjectDescription) description).isExtensionDescription();
		}
		return false;
	}
	
	public boolean isStatic() {
		IEObjectDescription description = getDescription();
		if (description instanceof BucketedEObjectDescription) {
			return ((BucketedEObjectDescription) description).isStaticDescription();
		}
		return false;
	}
	
	@Override
	protected void resolveAgainstActualType(LightweightTypeReference declaredType, LightweightTypeReference actualType, final AbstractTypeComputationState state) {
		super.resolveAgainstActualType(declaredType, actualType, state);
		if (!isStatic() && !isExtension()) {
			DeferredTypeParameterHintCollector collector = new DeferredTypeParameterHintCollector(state.getReferenceOwner()) {
				@NonNullByDefault
				@Override
				protected TypeParameterSubstitutor<?> createTypeParameterSubstitutor(
						Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping) {
					return new UnboundTypeParameterPreservingSubstitutor(mapping, getOwner());
				}
			};
			collector.processPairedReferences(declaredType, actualType);
		}
	}

	@Override
	protected List<XExpression> getSyntacticArguments() {
		// TODO binary operation
		XAbstractFeatureCall featureCall = getFeatureCall();
		if (featureCall instanceof XMemberFeatureCall) {
			return ((XMemberFeatureCall) featureCall).getMemberCallArguments();
		} else if (featureCall instanceof XFeatureCall) {
			return ((XFeatureCall) featureCall).getFeatureCallArguments();
		}
		return featureCall.getExplicitArguments();
	}

	public XAbstractFeatureCall getFeatureCall() {
		return (XAbstractFeatureCall) getExpression();
	}
	
	@Override
	protected List<LightweightTypeReference> getExplicitTypeArguments() {
		return Lists.transform(getFeatureCall().getTypeArguments(), getState().getResolvedTypes().getConverter());
	}
	
	@Override
	protected void resolveArgumentType(XExpression argument, LightweightTypeReference declaredType, AbstractTypeComputationState argumentState) {
		if (argument == getReceiver()) {
			LightweightTypeReference receiverType = getReceiverType();
			StackedResolvedTypes resolvedTypes = getState().getResolvedTypes();
			LightweightTypeReference copiedDeclaredType = declaredType != null ? declaredType.copyInto(resolvedTypes.getReferenceOwner()) : null;
			TypeExpectation expectation = new TypeExpectation(copiedDeclaredType, argumentState, false);
			LightweightTypeReference copiedReceiverType = receiverType.copyInto(resolvedTypes.getReferenceOwner());
			// TODO should we use the result of #acceptType?
			resolvedTypes.acceptType(argument, expectation, copiedReceiverType, ConformanceHint.UNCHECKED, false);
			if (declaredType != null)
				resolveAgainstActualType(copiedDeclaredType, copiedReceiverType, argumentState);
		} else {
			super.resolveArgumentType(argument, declaredType, argumentState);
		}
	}
	
	@Override
	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getDeclaratorParameterMapping() {
		if (getDescription() instanceof BucketedEObjectDescription) {
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> result = ((BucketedEObjectDescription) getDescription()).getReceiverTypeParameterMapping();
			if (result != null)
				return result;
		}
		return Collections.emptyMap();
	}
	
	@Override
	protected LightweightTypeReference getDeclaredType(JvmIdentifiableElement feature) {
		if (feature instanceof JvmConstructor) {
			return getState().getResolvedTypes().getConverter().toLightweightReference(getState().getTypeReferences().getTypeForName(Void.TYPE, feature));
		}
		return super.getDeclaredType(feature);
	}

}
