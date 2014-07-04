/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AppliedFeatureLinkingCandidate implements IFeatureLinkingCandidate {

	private final IFeatureLinkingCandidate delegate;

	protected AppliedFeatureLinkingCandidate(IFeatureLinkingCandidate delegate) {
		this.delegate = delegate;
	}
	
	public void applyToComputationState() {
		// nothing to do
	}

	public void applyToModel(IResolvedTypes resolvedTypes) {
		// nothing to do
	}
	
	public boolean validate(IAcceptor<? super AbstractDiagnostic> result) {
		// nothing to do
		return true;
	}

	public ILinkingCandidate getPreferredCandidate(ILinkingCandidate other) {
		return this;
	}

	/* @Nullable */
	public JvmIdentifiableElement getFeature() {
		return delegate.getFeature();
	}

	public List<LightweightTypeReference> getTypeArguments() {
		return delegate.getTypeArguments();
	}
	
	public XExpression getExpression() {
		return delegate.getExpression();
	}

	public XAbstractFeatureCall getFeatureCall() {
		return delegate.getFeatureCall();
	}

	public boolean isStatic() {
		return delegate.isStatic();
	}

	public boolean isExtension() {
		return delegate.isExtension();
	}
	
	public boolean isTypeLiteral() {
		return delegate.isTypeLiteral();
	}

}
