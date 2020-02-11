/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.ISynchronizable;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * A batch type resolver that uses the resource scope cache to 
 * return a cached result of the computed types.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CachingBatchTypeResolver extends AbstractBatchTypeResolver {

	@Inject
	private OnChangeEvictingCache cache;
	
	@Inject
	private DefaultBatchTypeResolver delegate;
	
	@Override
	/* @NonNull */
	protected IResolvedTypes doResolveTypes(final /* @Nullable */ EObject object, final /* @Nullable */ CancelIndicator monitor) {
		// TODO: remove when we switch to an Xtend scope provider without artificial feature calls  
		EObject nonArtificialObject = object;
		if(object.eResource() == null && object instanceof XAbstractFeatureCall) {
			nonArtificialObject = ((XAbstractFeatureCall) object).getFeature();
		}
		// TODO
		final Resource resource = nonArtificialObject.eResource();
		final LazyResolvedTypes result = cache.get(CachingBatchTypeResolver.class, resource, new Provider<LazyResolvedTypes>() {
			@Override
			public LazyResolvedTypes get() {
				final IReentrantTypeResolver resolver = delegate.getTypeResolver(object);
				return new LazyResolvedTypes(resolver, resource);
			}
		});
		cache.execWithoutCacheClear(resource, new IUnitOfWork.Void<Resource>() {
			@Override
			public void process(Resource state) throws Exception {
				// trigger the actual resolution after the thing was cached
				result.resolveTypes(monitor == null ? CancelIndicator.NullImpl : monitor); 
			}
		});
		return result;
	}
	
	protected static class LazyResolvedTypes extends ForwardingResolvedTypes {

		private final IReentrantTypeResolver resolver;

		private final Resource resource;
		
		private volatile IResolvedTypes delegate;
		
		public LazyResolvedTypes(IReentrantTypeResolver resolver, Resource resource) {
			this.resolver = resolver;
			this.resource = resource;
		}

		protected IResolvedTypes resolveTypes(CancelIndicator monitor) {
			if (this.delegate == null) {
				synchronized (getLock()) {
					if (this.delegate == null) {
						IResolvedTypes result = resolver.reentrantResolve(monitor);
						this.delegate = result;
						return result;
					}
				}
			}
			return delegate;
		}
			
		@Override
		protected IResolvedTypes delegate() {
			return delegate;
		}
		
		protected Object getLock() {
			if (resource instanceof ISynchronizable<?>) {
				return ((ISynchronizable<?>) resource).getLock();
			}
			return resource;
		}
	}
}
