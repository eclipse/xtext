/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;

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
	private OnChangeEvictingCache cache;
	
	@Inject
	private DefaultBatchTypeResolver delegate;
	
	@NonNull
	public IResolvedTypes resolveTypes(final @Nullable EObject object) {
		if (object == null || object.eIsProxy()) {
			return IResolvedTypes.NULL;
		}
		Resource resource = object.eResource();
		final LazyResolvedTypes result = cache.get(CachingBatchTypeResolver.class, resource, new Provider<LazyResolvedTypes>() {
			public LazyResolvedTypes get() {
				final IReentrantTypeResolver resolver = delegate.getTypeResolver(object);
				return new LazyResolvedTypes(resolver);
			}
		});
		cache.execWithoutCacheClear(resource, new IUnitOfWork.Void<Resource>() {
			@Override
			public void process(Resource state) throws Exception {
				result.delegate(); // trigger the actual resolution after the thing was cached
			}
		});
		return result;
	}
	
	@NonNull
	public IScope getFeatureScope(@Nullable XAbstractFeatureCall featureCall) {
		return delegate.getFeatureScope(featureCall);
	}
	
	@NonNullByDefault
	protected static class LazyResolvedTypes extends ForwardingResolvedTypes {

		private final IReentrantTypeResolver resolver;

		private volatile IResolvedTypes delegate;
		
		public LazyResolvedTypes(IReentrantTypeResolver resolver) {
			this.resolver = resolver;
		}

		@Override
		protected IResolvedTypes delegate() {
			if (this.delegate == null) {
				synchronized (this) {
					if (this.delegate == null) {
						IResolvedTypes result = resolver.reentrantResolve();
						this.delegate = result;
						return result;
					}
				}
			}
			return delegate;
		}
		
	}

}
