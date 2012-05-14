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
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
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
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;

import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class FeatureLinkingCandidate extends AbstractLinkingCandidate implements IFeatureLinkingCandidate {

	public FeatureLinkingCandidate(XAbstractFeatureCall featureCall, IEObjectDescription description,
			AbstractTypeComputationState state) {
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
	protected StackedResolvedTypes resolveArgumentType(XExpression argument, JvmTypeReference declaredType, AbstractTypeComputationState argumentState) {
		if (argument == getReceiver()) {
			JvmTypeReference receiverType = getReceiverType();
			StackedResolvedTypes resolvedTypes = new StackedResolvedTypes(getState().getResolvedTypes());
			resolvedTypes.acceptType(argument, null, receiverType, ConformanceHint.UNCHECKED, false);
			if (declaredType != null)
				resolveAgainstActualType(declaredType, receiverType);
			return resolvedTypes;
		} else {
			return super.resolveArgumentType(argument, declaredType, argumentState);
		}
	}
	
	@Override
	protected Map<JvmTypeParameter, JvmTypeReference> getDeclaratorParameterMapping() {
		JvmIdentifiableElement feature = getFeature();
		boolean staticFeature = false;
		if (feature instanceof JvmOperation) {
			staticFeature = ((JvmOperation) feature).isStatic();  
		} else if (feature instanceof JvmField) {
			staticFeature = ((JvmField) feature).isStatic();
		}
		// TODO cache the type parameters per receiver
		Map<JvmTypeParameter, JvmTypeReference> declaratorParameterMapping = staticFeature 
				? Collections.<JvmTypeParameter, JvmTypeReference>emptyMap() 
				: new DeclaratorTypeArgumentCollector().getTypeParameterMapping(getReceiverType());
		return declaratorParameterMapping;
	}
	
	@Override
	protected Map<JvmTypeParameter, JvmTypeReference> getFeatureTypeParameterMapping() {
		JvmIdentifiableElement feature = getFeature();
		if (feature instanceof JvmTypeParameterDeclarator) {
			List<JvmTypeReference> typeArguments = getFeatureCall().getTypeArguments();
			List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) feature).getTypeParameters();
			if (!typeArguments.isEmpty()) {
				int max = Math.min(typeArguments.size(), typeParameters.size());
				Map<JvmTypeParameter, JvmTypeReference> result = Maps.newHashMapWithExpectedSize(max);
				for(int i = 0; i < max; i++) {
					result.put(typeParameters.get(i), typeArguments.get(i));
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
