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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.DeferredTypeParameterHintCollector;
import org.eclipse.xtext.xbase.typesystem.util.FeatureLinkHelper;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class ResolvedFeature extends AbstractResolvedReference<XAbstractFeatureCall> implements IFeatureLinkingCandidate {

	private FeatureLinkHelper helper;

	public ResolvedFeature(XAbstractFeatureCall featureCall, JvmIdentifiableElement feature, FeatureLinkHelper helper, ExpressionTypeComputationState state) {
		super(featureCall, feature, state);
		this.helper = helper;
	}

	protected LightweightTypeReference getReceiverType() {
		LightweightTypeReference result = getActualType(getReceiver());
		if (result == null) {
			throw new IllegalStateException("Cannot determine type of receiver "+ getReceiver());
		}
		return result;
	}
	
	public boolean isExtension() {
//		IEObjectDescription description = getDescription();
//		if (description instanceof BucketedEObjectDescription) {
//			return ((BucketedEObjectDescription) description).isExtensionDescription();
//		}
		// TODO implement
		return false;
	}
	
	public boolean isStatic() {
		return helper.isStatic(getFeature());
	}
	
	@Override
	@Nullable
	protected LightweightTypeReference getSubstitutedExpectedType(int idx) {
		if (idx == 0 && getReceiver() != null && !getArguments().contains(getReceiver())) {
			return getReceiverType();
		}
		return super.getSubstitutedExpectedType(idx);
	}
	
	protected boolean hasExplicitArguments() {
		return getFeatureCall().isExplicitOperationCallOrBuilderSyntax();
	}
	
	@Override
	public void apply() {
		XExpression receiver = getReceiver();
		if (receiver != null) {
			StackedResolvedTypes resolvedTypes = getState().getResolvedTypes();
			TypeExpectation expectation = new TypeExpectation(null, getState(), false);
			LightweightTypeReference receiverType = getReceiverType();
			resolvedTypes.acceptType(receiver, expectation, receiverType.copyInto(resolvedTypes.getReferenceOwner()), false, ConformanceHint.UNCHECKED);
		}
		super.apply();
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
	protected List<XExpression> getSyntacticArguments() {
		// TODO binary operation
		XAbstractFeatureCall featureCall = getFeatureCall();
		if (featureCall instanceof XMemberFeatureCall) {
			return ((XMemberFeatureCall) featureCall).getMemberCallArguments();
		} else if (featureCall instanceof XFeatureCall) {
			return ((XFeatureCall) featureCall).getFeatureCallArguments();
		} else if (featureCall instanceof XAssignment) {
			XExpression value = ((XAssignment) featureCall).getValue();
			if (value == null) {
				return Collections.emptyList();
			}
			return Collections.singletonList(value);
		}
		return featureCall.getExplicitArguments();
	}

	public XAbstractFeatureCall getFeatureCall() {
		return getExpression();
	}
	
	@Override
	protected List<LightweightTypeReference> getExplicitTypeArguments() {
		return Lists.transform(getFeatureCall().getTypeArguments(), getState().getResolvedTypes().getConverter());
	}
	
	@Override
	protected void resolveArgumentType(XExpression argument, @Nullable LightweightTypeReference declaredType, ITypeComputationState argumentState) {
		if (argument == getReceiver()) {
			if (!(argumentState instanceof AbstractTypeComputationState))
				throw new IllegalArgumentException("argumentState was " + argumentState);
			AbstractTypeComputationState castedArgumentState = (AbstractTypeComputationState) argumentState;
			LightweightTypeReference receiverType = getReceiverType();
			StackedResolvedTypes resolvedTypes = getState().getResolvedTypes();
			LightweightTypeReference copiedDeclaredType = declaredType != null ? declaredType.copyInto(resolvedTypes.getReferenceOwner()) : null;
			TypeExpectation expectation = new TypeExpectation(copiedDeclaredType, castedArgumentState, false);
			LightweightTypeReference copiedReceiverType = receiverType.copyInto(resolvedTypes.getReferenceOwner());
			// TODO should we use the result of #acceptType?
			resolvedTypes.acceptType(argument, expectation, copiedReceiverType, false, ConformanceHint.UNCHECKED);
			if (copiedDeclaredType != null)
				resolveAgainstActualType(copiedDeclaredType, copiedReceiverType, castedArgumentState);
		} else {
			super.resolveArgumentType(argument, declaredType, argumentState);
		}
	}
	
	@Override
	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getDeclaratorParameterMapping() {
		Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> receiverTypeParameterMapping = Collections.emptyMap();
		if (!isStatic()) { // TODO get this one right for binary expressions (see #getReceiver)
			XExpression receiver = getReceiver();
			if (receiver != null) {
				LightweightTypeReference receiverType = getReceiverType();
				receiverTypeParameterMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(receiverType);
			}
		}
		return receiverTypeParameterMapping;
	}
		
		
//		if (getDescription() instanceof BucketedEObjectDescription) {
//			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> result = ((BucketedEObjectDescription) getDescription()).getReceiverTypeParameterMapping();
//			if (result != null)
//				return result;
//		}
		// TODO implement me
	
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
	
	@Override
	@Nullable
	protected XExpression getReceiver() {
		// TODO static functions should not have something like a 'receiver'
		// see also FeatureLinkHelper.getReceiver
//		if (isStatic())
//			return null;
		return helper.getReceiver(getExpression());
	}
	
}
