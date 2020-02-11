/*******************************************************************************
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.util.CancelIndicator;
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

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * TODO JavaDoc, toString
 */
public class CompoundReentrantTypeResolver extends AbstractList<IResolvedTypes> implements IReentrantTypeResolver, IResolvedTypes, RandomAccess {

	private List<AbstractRootedReentrantTypeResolver> resolvers = Lists.newArrayList();
	private IResolvedTypes[] delegates;
	private boolean sealed = false;
	private int next;
	private CancelIndicator monitor;
	private Set<EObject> allRootedExpressions;
	
	public CompoundReentrantTypeResolver(Set<EObject> allRootedExpressions) {
		this.allRootedExpressions = allRootedExpressions;
	}

	protected void addResolver(AbstractRootedReentrantTypeResolver resolver) {
		if (sealed)
			throw new IllegalStateException();
		resolvers.add(resolver);
		resolver.setAllRootedExpressions(allRootedExpressions);
	}
	
	@Override
	public void initializeFrom(EObject root) {
		throw new IllegalStateException();
	}
	
	@Override
	public IResolvedTypes reentrantResolve(CancelIndicator monitor) {
		try {
			this.monitor = monitor;
			if (!sealed) {
				sealed = true;
				delegates = new IResolvedTypes[resolvers.size()];
			} else {
				next = next + 1;
			}
			while(next < delegates.length) {
				int next = this.next;
				if (delegates[next] == null)
					delegates[next] = resolvers.get(next).reentrantResolve(monitor);
				this.next++;
			}
			return this;
		} catch(OperationCanceledError e) {
			handleCancelation();
			throw e;
		}
	}

	private void handleCancelation() {
		allRootedExpressions.clear();
		sealed = false;
		next = 0;
		Arrays.fill(delegates, IResolvedTypes.NULL);
	}
	
	protected CancelIndicator getMonitor() {
		return monitor != null ? monitor : CancelIndicator.NullImpl;
	}
	
	protected IResolvedTypes getDelegate(int idx) {
		if (!sealed) {
			reentrantResolve(getMonitor());
		}
		if (idx < delegates.length) {
			IResolvedTypes result = delegates[idx];
			if (result == null) {
				if (next != idx) {
					return delegates[idx] = resolvers.get(idx).reentrantResolve(getMonitor());
				}
				return IResolvedTypes.NULL;
			}
			return result;
		}
		throw new IndexOutOfBoundsException("Index: "+idx+", Size: "+delegates.length);
	}

	@Override
	public Collection<AbstractDiagnostic> getQueuedDiagnostics() {
		List<AbstractDiagnostic> result = Lists.newArrayList();
		for(IResolvedTypes delegate: this) {
			result.addAll(delegate.getQueuedDiagnostics());
		}
		return result;
	}
	
	@Override
	public boolean isRefinedType(XExpression expression) {
		IResolvedTypes delegate = getDelegate(expression);
		return delegate.isRefinedType(expression);
	}
	
	@Override
	public Collection<ILinkingCandidate> getFollowUpErrors() {
		List<ILinkingCandidate> result = Lists.newArrayList();
		for(IResolvedTypes delegate: this) {
			result.addAll(delegate.getFollowUpErrors());
		}
		return result;
	}
	
	@Override
	public Collection<IAmbiguousLinkingCandidate> getAmbiguousLinkingCandidates() {
		List<IAmbiguousLinkingCandidate> result = Lists.newArrayList();
		for(IResolvedTypes delegate: this) {
			result.addAll(delegate.getAmbiguousLinkingCandidates());
		}
		return result;
	}

	/* @Nullable */
	@Override
	public LightweightTypeReference getActualType(XExpression expression) {
		IResolvedTypes delegate = getDelegate(expression);
		return delegate.getActualType(expression);
	}

	protected IResolvedTypes getDelegate(XExpression expression) {
		for(int i = 0; i < resolvers.size(); i++) {
			AbstractRootedReentrantTypeResolver resolver = resolvers.get(i);
			if (resolver.isHandled(expression)) {
				return getDelegate(i);
			}
		}
		return IResolvedTypes.NULL;
	}
	
	protected IResolvedTypes getDelegate(EObject object) {
		for(int i = 0; i < resolvers.size(); i++) {
			AbstractRootedReentrantTypeResolver resolver = resolvers.get(i);
			if (resolver.isHandled(object)) {
				return getDelegate(i);
			}
		}
		return IResolvedTypes.NULL;
	}
	
	@Override
	public IExpressionScope getExpressionScope(EObject context, IExpressionScope.Anchor anchor) {
		IResolvedTypes delegate = getDelegate(context);
		return delegate.getExpressionScope(context, anchor);
	}
	
	@Override
	public boolean hasExpressionScope(EObject context, IExpressionScope.Anchor anchor) {
		IResolvedTypes delegate = getDelegate(context);
		return delegate.hasExpressionScope(context, anchor);
	}
	
	/* @Nullable */
	@Override
	public LightweightTypeReference getReturnType(XExpression expression) {
		IResolvedTypes delegate = getDelegate(expression);
		return delegate.getReturnType(expression);
	}
	
	/* @Nullable */
	@Override
	public LightweightTypeReference getReturnType(XExpression expression, boolean onlyExplicitReturn) {
		IResolvedTypes delegate = getDelegate(expression);
		return delegate.getReturnType(expression, onlyExplicitReturn);
	}

	/* @Nullable */
	@Override
	public LightweightTypeReference getActualType(JvmIdentifiableElement identifiable) {
		for(int i = 0; i < resolvers.size(); i++) {
			AbstractRootedReentrantTypeResolver resolver = resolvers.get(i);
			if (resolver.isHandled(identifiable)) {
				IResolvedTypes delegate = getDelegate(i);
				return delegate.getActualType(identifiable);
			}
		}
		return null;
	}

	/* @Nullable */
	@Override
	public LightweightTypeReference getExpectedType(XExpression expression) {
		IResolvedTypes delegate = getDelegate(expression);
		return delegate.getExpectedType(expression);
	}
	
	@Override
	public List<LightweightTypeReference> getThrownExceptions(XExpression obj) {
		IResolvedTypes delegate = getDelegate(obj);
		return delegate.getThrownExceptions(obj);
	}

	@Override
	public boolean isVoidTypeAllowed(XExpression expression) {
		IResolvedTypes delegate = getDelegate(expression);
		return delegate.isVoidTypeAllowed(expression);
	}

	/* @Nullable */
	@Override
	public LightweightTypeReference getExpectedReturnType(XExpression expression) {
		IResolvedTypes delegate = getDelegate(expression);
		return delegate.getExpectedReturnType(expression);
	}

	@Override
	public List<LightweightTypeReference> getActualTypeArguments(XExpression expression) {
		IResolvedTypes delegate = getDelegate(expression);
		return delegate.getActualTypeArguments(expression);
	}

	/* @Nullable */
	@Override
	public JvmIdentifiableElement getLinkedFeature(/* @Nullable */ XAbstractFeatureCall featureCall) {
		if (featureCall == null)
			return null;
		IResolvedTypes delegate = getDelegate(featureCall);
		return delegate.getLinkedFeature(featureCall);
	}
	
	/* @Nullable */
	@Override
	public JvmIdentifiableElement getLinkedFeature(/* @Nullable */ XConstructorCall constructorCall) {
		if (constructorCall == null)
			return null;
		IResolvedTypes delegate = getDelegate(constructorCall);
		return delegate.getLinkedFeature(constructorCall);
	}
	
	/* @Nullable */
	@Override
	public IFeatureLinkingCandidate getLinkingCandidate(/* @Nullable */ XAbstractFeatureCall featureCall) {
		if (featureCall == null)
			return null;
		IResolvedTypes delegate = getDelegate(featureCall);
		return delegate.getLinkingCandidate(featureCall);
	}
	
	/* @Nullable */
	@Override
	public IConstructorLinkingCandidate getLinkingCandidate(/* @Nullable */ XConstructorCall constructorCall) {
		if (constructorCall == null)
			return null;
		IResolvedTypes delegate = getDelegate(constructorCall);
		return delegate.getLinkingCandidate(constructorCall);
	}

	@Override
	public IResolvedTypes get(int index) {
		return getDelegate(index);
	}

	@Override
	public int size() {
		return resolvers.size();
	}
	
}
