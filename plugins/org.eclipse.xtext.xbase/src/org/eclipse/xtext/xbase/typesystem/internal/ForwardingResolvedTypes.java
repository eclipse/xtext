/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collection;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.ForwardingObject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public abstract class ForwardingResolvedTypes extends ForwardingObject implements IResolvedTypes {

	@Override
	protected abstract IResolvedTypes delegate();
	
	@Nullable
	public LightweightTypeReference getActualType(XExpression expression) {
		return delegate().getActualType(expression);
	}
	
	public Collection<ILinkingCandidate> getFollowUpErrors() {
		return delegate().getFollowUpErrors();
	}
	
	public boolean isRefinedType(XExpression expression) {
		return delegate().isRefinedType(expression);
	}
	
	@Nullable
	public LightweightTypeReference getReturnType(XExpression expression) {
		return delegate().getReturnType(expression);
	}
	
	@Nullable
	public LightweightTypeReference getExpectedReturnType(XExpression expression) {
		return delegate().getExpectedReturnType(expression);
	}

	@Nullable
	public LightweightTypeReference getActualType(JvmIdentifiableElement identifiable) {
		return delegate().getActualType(identifiable);
	}

	@Nullable
	public LightweightTypeReference getExpectedType(XExpression expression) {
		return delegate().getExpectedType(expression);
	}

	public List<LightweightTypeReference> getActualTypeArguments(XExpression expression) {
		return delegate().getActualTypeArguments(expression);
	}

	public Collection<AbstractDiagnostic> getQueuedDiagnostics() {
		return delegate().getQueuedDiagnostics();
	}
	
	public boolean isVoidTypeAllowed(XExpression expression) {
		return delegate().isVoidTypeAllowed(expression);
	}

	@Nullable
	public JvmIdentifiableElement getLinkedFeature(@Nullable XAbstractFeatureCall featureCall) {
		return delegate().getLinkedFeature(featureCall);
	}
	
	@Nullable
	public IFeatureLinkingCandidate getLinkingCandidate(@Nullable XAbstractFeatureCall featureCall) {
		return delegate().getLinkingCandidate(featureCall);
	}
	
	@Nullable
	public JvmIdentifiableElement getLinkedFeature(@Nullable XConstructorCall constructorCall) {
		return delegate().getLinkedFeature(constructorCall);
	}
	
	@Nullable
	public IConstructorLinkingCandidate getLinkingCandidate(@Nullable XConstructorCall constructorCall) {
		return delegate().getLinkingCandidate(constructorCall);
	}
}
