/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.batch.FeatureScopes;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.IExpressionScope;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ExpressionScope implements IExpressionScope {

	private final FeatureScopes featureScopes;
	private final EObject context;
	private final List<FeatureScopeSessionToResolvedTypes> data;
	private final Anchor anchor;

	private EnumMap<Anchor, IScope> cachedFeatureScope = Maps.newEnumMap(Anchor.class);
	private IScope cachedReceiverFeatureScope;
	private XAbstractFeatureCall requestedFeatureCall;
	
	public ExpressionScope(FeatureScopes featureScopes, EObject context, Anchor anchor) {
		this.data = Lists.newArrayListWithExpectedSize(2);
		this.featureScopes = featureScopes;
		this.context = context;
		this.anchor = anchor;
	}
	
	public IExpressionScope withAnchor(final Anchor anchor) {
		if (anchor == this.anchor)
			return this;
		return new IExpressionScope() {

			@NonNull
			public IScope getFeatureScope() {
				return ExpressionScope.this.getFeatureScope(anchor);
			}

			@NonNull
			public IScope getFeatureScope(@Nullable XAbstractFeatureCall currentFeatureCall) {
				return ExpressionScope.this.getFeatureScope(currentFeatureCall, anchor);
			}

			@NonNull
			public List<String> getTypeNamePrefix() {
				return ExpressionScope.this.getTypeNamePrefix();
			}

			public boolean isPotentialTypeLiteral() {
				return ExpressionScope.this.isPotentialTypeLiteral();
			}
			
		};
	}

	@NonNull
	protected IScope getFeatureScope(Anchor anchor) {
		IScope cached = cachedFeatureScope.get(anchor);
		if (cached != null)
			return cached;
		if (anchor != Anchor.RECEIVER) {
			FeatureScopeSessionToResolvedTypes dummy = data.get(0);
			cached = new Scope(featureScopes.createSimpleFeatureCallScope(context, dummy.getSession(), dummy.getTypes()));
			cachedFeatureScope.put(anchor, cached);
			return cached;
		} else if (context instanceof XExpression) {
			FeatureScopeSessionToResolvedTypes dummy = data.get(0);
			// receiver is missing intentionally
			cached = new Scope(featureScopes.createFeatureCallScopeForReceiver(null, (XExpression) context, dummy.getSession(), dummy.getTypes()));
			cachedFeatureScope.put(anchor, cached);
			return cached;
		}
		cachedFeatureScope.put(anchor, IScope.NULLSCOPE);
		return IScope.NULLSCOPE;
	}
	
	@NonNull
	public IScope getFeatureScope(@Nullable XAbstractFeatureCall currentFeatureCall, Anchor anchor) {
		if (anchor == Anchor.RECEIVER) {
			if (currentFeatureCall == requestedFeatureCall && cachedReceiverFeatureScope != null) {
				return cachedReceiverFeatureScope;
			}
			FeatureScopeSessionToResolvedTypes dummy = data.get(0);
			IScope result = featureScopes.createFeatureCallScopeForReceiver(currentFeatureCall, (XExpression) context, dummy.getSession(), dummy.getTypes());
			this.requestedFeatureCall = currentFeatureCall;
			return cachedReceiverFeatureScope = new Scope(result);
		}
		return getFeatureScope(anchor);
	}
	
	@NonNull
	public IScope getFeatureScope() {
		return getFeatureScope(this.anchor);
	}
	
	@NonNull
	public IScope getFeatureScope(@Nullable XAbstractFeatureCall currentFeatureCall) {
		return getFeatureScope(currentFeatureCall, this.anchor);
	}
	
	public void addData(IFeatureScopeSession session, IResolvedTypes types) {
		this.cachedFeatureScope.clear();
		this.cachedReceiverFeatureScope = null;
		this.requestedFeatureCall = null;
		this.data.add(new FeatureScopeSessionToResolvedTypes(session, types));
	}
	
	public void replacePreviousData(IFeatureScopeSession session) {
		FeatureScopeSessionToResolvedTypes prev = data.remove(data.size() - 1);
		data.add(new FeatureScopeSessionToResolvedTypes(session, prev.getTypes()));
	}

	@NonNull
	public List<String> getTypeNamePrefix() {
		return Collections.emptyList();
	}

	public boolean isPotentialTypeLiteral() {
		return false;
	}
	
	public static class Scope implements IScope {

		private final IScope delegate;
		
		private List<IEObjectDescription> allElements;

		public Scope(IScope delegate) {
			this.delegate = delegate;
		}
		
		public IEObjectDescription getSingleElement(QualifiedName name) {
			return delegate.getSingleElement(name);
		}

		public Iterable<IEObjectDescription> getElements(QualifiedName name) {
			return delegate.getElements(name);
		}

		public IEObjectDescription getSingleElement(EObject object) {
			return delegate.getSingleElement(object);
		}

		public Iterable<IEObjectDescription> getElements(EObject object) {
			return delegate.getElements(object);
		}

		public Iterable<IEObjectDescription> getAllElements() {
			if (allElements == null) {
				// TODO shadowing
				List<IEObjectDescription> result = Lists.newArrayList(delegate.getAllElements());
//				System.out.println("Collecting " + result.size() + " items");
				return allElements = result;
			}
//			System.out.println("Reusing " + allElements.size() + " items");
			return allElements;
		}
		
	}

}
