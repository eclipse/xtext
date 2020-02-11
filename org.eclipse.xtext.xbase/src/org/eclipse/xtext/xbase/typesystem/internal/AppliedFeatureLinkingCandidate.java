/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
	
	@Override
	public void applyToComputationState() {
		// nothing to do
	}

	@Override
	public void applyToModel(IResolvedTypes resolvedTypes) {
		// nothing to do
	}
	
	@Override
	public boolean validate(IAcceptor<? super AbstractDiagnostic> result) {
		// nothing to do
		return true;
	}

	@Override
	public ILinkingCandidate getPreferredCandidate(ILinkingCandidate other) {
		return this;
	}

	/* @Nullable */
	@Override
	public JvmIdentifiableElement getFeature() {
		return delegate.getFeature();
	}

	@Override
	public List<LightweightTypeReference> getTypeArguments() {
		return delegate.getTypeArguments();
	}
	
	@Override
	public XExpression getExpression() {
		return delegate.getExpression();
	}

	@Override
	public XAbstractFeatureCall getFeatureCall() {
		return delegate.getFeatureCall();
	}

	@Override
	public boolean isStatic() {
		return delegate.isStatic();
	}

	@Override
	public boolean isExtension() {
		return delegate.isExtension();
	}
	
	@Override
	public boolean isTypeLiteral() {
		return delegate.isTypeLiteral();
	}

}
