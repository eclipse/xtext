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

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public abstract class AbstractImplicitFeature implements IFeatureLinkingCandidate {

	private final XAbstractFeatureCall featureCall;
	private final XAbstractFeatureCall implicit;
	private final ExpressionTypeComputationState state;

	protected AbstractImplicitFeature(XAbstractFeatureCall featureCall, XAbstractFeatureCall implicit, ExpressionTypeComputationState state) {
		this.featureCall = featureCall;
		this.implicit = implicit;
		this.state = state;
	}
	
	protected ExpressionTypeComputationState getState() {
		return state;
	}
	
	public void apply() {
		state.getResolvedTypes().acceptLinkingInformation(implicit, this);
	}
	
	protected XAbstractFeatureCall getOwner() {
		return featureCall;
	}

	public boolean isPreferredOver(ILinkingCandidate other) {
		return true;
	}

	public JvmIdentifiableElement getFeature() {
		return implicit.getFeature();
	}

	public List<LightweightTypeReference> getTypeArguments() {
		return Collections.emptyList();
	}

	public XAbstractFeatureCall getFeatureCall() {
		return implicit;
	}

	public boolean isStatic() {
		return false;
	}

	public boolean isExtension() {
		return false;
	}

}
