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

import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.FeatureLinkHelper;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class UnresolvableFeatureCall extends AbstractUnresolvableFeature implements IFeatureLinkingCandidate {

	public UnresolvableFeatureCall(XAbstractFeatureCall featureCall, INode node, String text, ExpressionTypeComputationState state) {
		super(featureCall, node, text, state);
	}

	public XAbstractFeatureCall getFeatureCall() {
		return (XAbstractFeatureCall) getExpression();
	}
	
	@Override
	protected List<XExpression> getArguments() {
		return getFeatureCall().getExplicitArguments();
	}

	public boolean isStatic() {
		return false;
	}

	public boolean isExtension() {
		return false;
	}
	
	public EReference getReference() {
		return XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE;
	}

	public List<LightweightTypeReference> getTypeArguments() {
		XAbstractFeatureCall featureCall = getFeatureCall();
		List<JvmTypeReference> typeArguments = featureCall.getTypeArguments();
		if (typeArguments.isEmpty())
			return Collections.emptyList();
		List<LightweightTypeReference> result = Lists.newArrayList();
		for(JvmTypeReference typeArgument: typeArguments) {
			result.add(getConverter().toLightweightReference(typeArgument));
		}
		return result;
	}
	
	@Nullable
	protected XExpression getSyntacticReceiver() {
		return new FeatureLinkHelper().getSyntacticReceiver(getFeatureCall());
	}
}
