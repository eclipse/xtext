/*******************************************************************************
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.IExpressionScope;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.IAmbiguousLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.ForwardingObject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class ForwardingResolvedTypes extends ForwardingObject implements IResolvedTypes {

	@Override
	protected abstract IResolvedTypes delegate();
	
	/* @Nullable */
	@Override
	public LightweightTypeReference getActualType(XExpression expression) {
		return delegate().getActualType(expression);
	}
	
	@Override
	public Collection<ILinkingCandidate> getFollowUpErrors() {
		return delegate().getFollowUpErrors();
	}
	
	@Override
	public Collection<IAmbiguousLinkingCandidate> getAmbiguousLinkingCandidates() {
		return delegate().getAmbiguousLinkingCandidates();
	}
	
	@Override
	public boolean isRefinedType(XExpression expression) {
		return delegate().isRefinedType(expression);
	}
	
	/* @Nullable */
	@Override
	public LightweightTypeReference getReturnType(XExpression expression) {
		return delegate().getReturnType(expression);
	}
	
	/* @Nullable */
	@Override
	public LightweightTypeReference getReturnType(XExpression expression, boolean onlyExplicitReturn) {
		return delegate().getReturnType(expression, onlyExplicitReturn);
	}
	
	/* @Nullable */
	@Override
	public LightweightTypeReference getExpectedReturnType(XExpression expression) {
		return delegate().getExpectedReturnType(expression);
	}

	/* @Nullable */
	@Override
	public LightweightTypeReference getActualType(JvmIdentifiableElement identifiable) {
		return delegate().getActualType(identifiable);
	}
	
	@Override
	public List<LightweightTypeReference> getThrownExceptions(XExpression obj) {
		return delegate().getThrownExceptions(obj);
	}

	/* @Nullable */
	@Override
	public LightweightTypeReference getExpectedType(XExpression expression) {
		return delegate().getExpectedType(expression);
	}

	@Override
	public List<LightweightTypeReference> getActualTypeArguments(XExpression expression) {
		return delegate().getActualTypeArguments(expression);
	}

	@Override
	public Collection<AbstractDiagnostic> getQueuedDiagnostics() {
		return delegate().getQueuedDiagnostics();
	}
	
	@Override
	public boolean isVoidTypeAllowed(XExpression expression) {
		return delegate().isVoidTypeAllowed(expression);
	}

	/* @Nullable */
	@Override
	public JvmIdentifiableElement getLinkedFeature(/* @Nullable */ XAbstractFeatureCall featureCall) {
		return delegate().getLinkedFeature(featureCall);
	}
	
	/* @Nullable */
	@Override
	public IFeatureLinkingCandidate getLinkingCandidate(/* @Nullable */ XAbstractFeatureCall featureCall) {
		return delegate().getLinkingCandidate(featureCall);
	}
	
	/* @Nullable */
	@Override
	public JvmIdentifiableElement getLinkedFeature(/* @Nullable */ XConstructorCall constructorCall) {
		return delegate().getLinkedFeature(constructorCall);
	}
	
	/* @Nullable */
	@Override
	public IConstructorLinkingCandidate getLinkingCandidate(/* @Nullable */ XConstructorCall constructorCall) {
		return delegate().getLinkingCandidate(constructorCall);
	}
	
	@Override
	public IExpressionScope getExpressionScope(EObject context, IExpressionScope.Anchor anchor) {
		return delegate().getExpressionScope(context, anchor);
	}
	
	@Override
	public boolean hasExpressionScope(EObject context, IExpressionScope.Anchor anchor) {
		return delegate().hasExpressionScope(context, anchor);
	}
	
}
