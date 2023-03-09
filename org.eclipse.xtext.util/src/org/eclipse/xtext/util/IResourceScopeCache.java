/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.ImplementedBy;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(OnChangeEvictingCache.class)
public interface IResourceScopeCache {
	/**
	 * A cache associates values to the given resource under the given key.
	 * The default implementation releases any values as soon as a semantic change occurs in any EObjects contained in the given resource.
	 * 
	 * @return the cached value or what the provider returns if no cached value exists 
	 */
	<T> T get(Object key, Resource res, Provider<T> provider);
	
	void clear(Resource res);
	
	static class NullImpl implements IResourceScopeCache {
		public final static IResourceScopeCache INSTANCE = new NullImpl();
		@Override
		public <T> T get(Object key, Resource res, Provider<T> provider) {
			return provider.get();
		}
		@Override
		public void clear(Resource res) {}
	}
}
