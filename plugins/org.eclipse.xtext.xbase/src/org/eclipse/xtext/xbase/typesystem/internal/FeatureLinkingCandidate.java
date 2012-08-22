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
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.scoping.batch.BucketedEObjectDescription;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.DeferredTypeParameterHintCollector;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameterPreservingSubstitutor;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class FeatureLinkingCandidate extends AbstractLinkingCandidate implements IFeatureLinkingCandidate {

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
	protected boolean hasExplicitArguments() {
		return getFeatureCall().isExplicitOperationCallOrBuilderSyntax();
	}
	
	@Override
	protected int compareByArityWith(AbstractLinkingCandidate right) {
		int result = super.compareByArityWith(right);
		if (result == 0) {
			boolean isExecutable = getFeature() instanceof JvmExecutable;
			if (isExecutable != right.getFeature() instanceof JvmExecutable) {
				if (getExpression() instanceof XAssignment) {
					if (isExecutable)
						return 1;
					return -1;
				} else {
					if (hasExplicitArguments()) {
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
	protected int compareByArgumentTypes(AbstractLinkingCandidate right) {
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
	public void apply() {
		XExpression receiver = getReceiver();
		if (receiver != null && receiver.eResource() == null) {
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
		return (XAbstractFeatureCall) getExpression();
	}
	
	@Override
	protected List<LightweightTypeReference> getExplicitTypeArguments() {
		return Lists.transform(getFeatureCall().getTypeArguments(), getState().getResolvedTypes().getConverter());
	}
	
	@Override
	protected void resolveArgumentType(XExpression argument, LightweightTypeReference declaredType, ITypeComputationState argumentState) {
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
			if (declaredType != null)
				resolveAgainstActualType(copiedDeclaredType, copiedReceiverType, castedArgumentState);
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
	
	public void resolveLinkingProxy() {
		resolveLinkingProxy(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, XbasePackage.XABSTRACT_FEATURE_CALL__FEATURE);
		setImplicitReceiver();
	}

	protected void setImplicitReceiver() {
		XExpression receiver = getReceiver();
		if (receiver != null && receiver.eResource() == null)
			getFeatureCall().setImplicitReceiver(receiver);
	}

}
