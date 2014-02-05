/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

import org.eclipse.emf.ecore.EObject;
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

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class CompoundReentrantTypeResolver extends AbstractList<IResolvedTypes> implements IReentrantTypeResolver, IResolvedTypes, RandomAccess {

	private List<AbstractRootedReentrantTypeResolver> resolvers = Lists.newArrayList();
	private IResolvedTypes[] delegates;
	private boolean sealed = false;
	private int next;
	
	protected void addResolver(AbstractRootedReentrantTypeResolver resolver) {
		if (sealed)
			throw new IllegalStateException();
		resolvers.add(resolver);
	}
	
	public void initializeFrom(EObject root) {
		throw new IllegalStateException();
	}
	
	public IResolvedTypes reentrantResolve() {
		if (!sealed) {
			sealed = true;
			delegates = new IResolvedTypes[resolvers.size()];
		} else {
			next = next + 1;
		}
		while(next < delegates.length) {
			int next = this.next;
			if (delegates[next] == null)
				delegates[next] = resolvers.get(next).reentrantResolve();
			this.next++;
		}
		return this;
	}
	
	protected IResolvedTypes getDelegate(int idx) {
		if (!sealed) {
			reentrantResolve();
		}
		if (idx < delegates.length) {
			IResolvedTypes result = delegates[idx];
			if (result == null) {
				if (next != idx) {
					return delegates[idx] = resolvers.get(idx).reentrantResolve();
				}
				return IResolvedTypes.NULL;
			}
			return result;
		}
		throw new IndexOutOfBoundsException("Index: "+idx+", Size: "+delegates.length);
	}

	public Collection<AbstractDiagnostic> getQueuedDiagnostics() {
		List<AbstractDiagnostic> result = Lists.newArrayList();
		for(IResolvedTypes delegate: this) {
			result.addAll(delegate.getQueuedDiagnostics());
		}
		return result;
	}
	
	public boolean isRefinedType(XExpression expression) {
		IResolvedTypes delegate = getDelegate(expression);
		return delegate.isRefinedType(expression);
	}
	
	public Collection<ILinkingCandidate> getFollowUpErrors() {
		List<ILinkingCandidate> result = Lists.newArrayList();
		for(IResolvedTypes delegate: this) {
			result.addAll(delegate.getFollowUpErrors());
		}
		return result;
	}

	@Nullable
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

	@Nullable
	public LightweightTypeReference getReturnType(XExpression expression) {
		IResolvedTypes delegate = getDelegate(expression);
		return delegate.getReturnType(expression);
	}

	@Nullable
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

	@Nullable
	public LightweightTypeReference getExpectedType(XExpression expression) {
		IResolvedTypes delegate = getDelegate(expression);
		return delegate.getExpectedType(expression);
	}
	
	public List<LightweightTypeReference> getThrownExceptions(XExpression obj) {
		IResolvedTypes delegate = getDelegate(obj);
		return delegate.getThrownExceptions(obj);
	}

	public boolean isVoidTypeAllowed(XExpression expression) {
		IResolvedTypes delegate = getDelegate(expression);
		return delegate.isVoidTypeAllowed(expression);
	}

	@Nullable
	public LightweightTypeReference getExpectedReturnType(XExpression expression) {
		IResolvedTypes delegate = getDelegate(expression);
		return delegate.getExpectedReturnType(expression);
	}

	public List<LightweightTypeReference> getActualTypeArguments(XExpression expression) {
		IResolvedTypes delegate = getDelegate(expression);
		return delegate.getActualTypeArguments(expression);
	}

	@Nullable
	public JvmIdentifiableElement getLinkedFeature(@Nullable XAbstractFeatureCall featureCall) {
		if (featureCall == null)
			return null;
		IResolvedTypes delegate = getDelegate(featureCall);
		return delegate.getLinkedFeature(featureCall);
	}
	
	@Nullable
	public JvmIdentifiableElement getLinkedFeature(@Nullable XConstructorCall constructorCall) {
		if (constructorCall == null)
			return null;
		IResolvedTypes delegate = getDelegate(constructorCall);
		return delegate.getLinkedFeature(constructorCall);
	}
	
	@Nullable
	public IFeatureLinkingCandidate getLinkingCandidate(@Nullable XAbstractFeatureCall featureCall) {
		if (featureCall == null)
			return null;
		IResolvedTypes delegate = getDelegate(featureCall);
		return delegate.getLinkingCandidate(featureCall);
	}
	
	@Nullable
	public IConstructorLinkingCandidate getLinkingCandidate(@Nullable XConstructorCall constructorCall) {
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