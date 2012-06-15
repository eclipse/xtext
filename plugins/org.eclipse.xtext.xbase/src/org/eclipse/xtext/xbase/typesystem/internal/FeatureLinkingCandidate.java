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

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.scoping.batch.BucketedEObjectDescription;
import org.eclipse.xtext.xbase.typesystem.computation.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.util.DeferredTypeParameterHintCollector;
import org.eclipse.xtext.xbase.typesystem.util.MergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;

import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class FeatureLinkingCandidate extends AbstractLinkingCandidateWithTypeParameter<IFeatureLinkingCandidate> implements IFeatureLinkingCandidate {

	public FeatureLinkingCandidate(XAbstractFeatureCall featureCall, IEObjectDescription description,
			ExpressionTypeComputationState state) {
		super(featureCall, description, state);
	}

	protected JvmTypeReference getReceiverType() {
		JvmTypeReference receiverType = null;
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
	protected void resolveAgainstActualType(JvmTypeReference declaredType, JvmTypeReference actualType) {
		super.resolveAgainstActualType(declaredType, actualType);
		if (!isStatic() && !isExtension()) {
			DeferredTypeParameterHintCollector collector = new DeferredTypeParameterHintCollector(getState().getServices());
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
	protected List<JvmTypeReference> getTypeArguments() {
		return getFeatureCall().getTypeArguments();
	}
	
	@Override
	protected StackedResolvedTypes resolveArgumentType(XExpression argument, JvmTypeReference declaredType, AbstractTypeComputationState argumentState) {
		if (argument == getReceiver()) {
			JvmTypeReference receiverType = getReceiverType();
			StackedResolvedTypes resolvedTypes = new ExpressionAwareStackedResolvedTypes(getState().getResolvedTypes(), argument);
			resolvedTypes.acceptType(argument, null, receiverType, ConformanceHint.UNCHECKED, false);
			if (declaredType != null)
				resolveAgainstActualType(declaredType, receiverType);
			return resolvedTypes;
		} else {
			return super.resolveArgumentType(argument, declaredType, argumentState);
		}
	}
	
	@Override
	protected Map<JvmTypeParameter, MergedBoundTypeArgument> getDeclaratorParameterMapping() {
		if (getDescription() instanceof BucketedEObjectDescription) {
			Map<JvmTypeParameter, MergedBoundTypeArgument> result = ((BucketedEObjectDescription) getDescription()).getReceiverTypeParameterMapping();
			if (result != null)
				return result;
		}
		return Collections.emptyMap();
	}
	
	@Override
	protected Map<JvmTypeParameter, MergedBoundTypeArgument> getFeatureTypeParameterMapping() {
		JvmIdentifiableElement feature = getFeature();
		if (feature instanceof JvmTypeParameterDeclarator) {
			List<JvmTypeReference> typeArguments = getFeatureCall().getTypeArguments();
			List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) feature).getTypeParameters();
			if (!typeArguments.isEmpty()) {
				Map<JvmTypeParameter, MergedBoundTypeArgument> result = Maps.newLinkedHashMap();
				int max = Math.min(typeArguments.size(), typeParameters.size());
				for(int i = 0; i < max; i++) {
					result.put(typeParameters.get(i), new MergedBoundTypeArgument(typeArguments.get(i), VarianceInfo.INVARIANT));
				}
				// TODO computed type references for the remaining type parameters
				return result;
			}
		}
		return super.getFeatureTypeParameterMapping();
	}
	
	@Override
	protected JvmTypeReference getDeclaredType(JvmIdentifiableElement feature) {
		if (feature instanceof JvmConstructor) {
			return getState().getTypeReferences().getTypeForName(Void.TYPE, feature);
		}
		return super.getDeclaredType(feature);
	}

}
