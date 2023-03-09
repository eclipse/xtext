/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FollowUpError extends AbstractUnresolvableReference implements IFeatureLinkingCandidate {

	public FollowUpError(XAbstractFeatureCall featureCall, ExpressionTypeComputationState state) {
		super(featureCall, state);
	}
	
	@Override
	public void applyToModel(IResolvedTypes resolvedTypes) {
		Resource resource = getExpression().eResource();
		if (resource instanceof LazyLinkingResource) {
			LazyLinkingResource lazyLinkingResource = (LazyLinkingResource) resource;
			EObject referenced = (InternalEObject) getExpression().eGet(getReference(), false);
			lazyLinkingResource.markUnresolvable(referenced);
		}
	}

	@Override
	public XAbstractFeatureCall getFeatureCall() {
		return (XAbstractFeatureCall) getExpression();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	protected List<XExpression> getArguments() {
		return getFeatureCall().getExplicitArguments();
	}

	@Override
	public boolean isStatic() {
		return false;
	}

	@Override
	public boolean isExtension() {
		return false;
	}
	
	@Override
	public boolean isTypeLiteral() {
		return false;
	}
	
	public EReference getReference() {
		return XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE;
	}

	@Override
	public List<LightweightTypeReference> getTypeArguments() {
		XAbstractFeatureCall featureCall = getFeatureCall();
		List<JvmTypeReference> typeArguments = featureCall.getTypeArguments();
		if (typeArguments.isEmpty())
			return Collections.emptyList();
		List<LightweightTypeReference> result = Lists.newArrayList();
		for(JvmTypeReference typeArgument: typeArguments) {
			result.add(getState().getReferenceOwner().toLightweightTypeReference(typeArgument));
		}
		return result;
	}
	
	/* @Nullable */
	protected XExpression getSyntacticReceiver() {
		return new FeatureLinkHelper().getSyntacticReceiver(getFeatureCall());
	}

}
