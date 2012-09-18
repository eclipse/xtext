/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.ForwardingObject;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * A batch type resolver that uses the resource scope cache to 
 * return a cached result of the computed types.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CachingBatchTypeResolver implements IBatchTypeResolver {

	@Inject
	private IResourceScopeCache cache;
	
	@Inject
	private DefaultBatchTypeResolver delegate;
	
	@NonNull
	public IResolvedTypes resolveTypes(@Nullable EObject object) {
		if (object == null || object.eIsProxy()) {
			return IResolvedTypes.NULL;
		}
		Resource resource = object.eResource();
		final EObject entryPoint = delegate.getEntryPoint(object);
		LazyResolvedTypes result = cache.get(Tuples.create(CachingBatchTypeResolver.class, entryPoint), resource, new Provider<LazyResolvedTypes>() {
			public LazyResolvedTypes get() {
				return new LazyResolvedTypes(entryPoint);
			}
		});
		result.delegate(); // trigger the actual resolution after the thing was cached
		return result;
	}
	
	@NonNullByDefault
	protected class LazyResolvedTypes extends ForwardingObject implements IResolvedTypes {

		private EObject entryPoint;

		private volatile IResolvedTypes delegate;
		
		public LazyResolvedTypes(EObject entryPoint) {
			this.entryPoint = entryPoint;
		}

		@Override
		protected IResolvedTypes delegate() {
			if (this.delegate == null) {
				synchronized (this) {
					if (this.delegate == null) {
						IResolvedTypes result = CachingBatchTypeResolver.this.delegate.resolveTypes(entryPoint);
						this.delegate = result;
						return result;
					}
				}
			}
			return delegate;
		}
		
		public List<Diagnostic> getQueuedDiagnostics() {
			return delegate().getQueuedDiagnostics();
		}

		@Nullable
		public LightweightTypeReference getActualType(XExpression expression) {
			return delegate().getActualType(expression);
		}

		@Nullable
		public LightweightTypeReference getReturnType(XExpression expression) {
			return delegate().getReturnType(expression);
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
		
	}

}
