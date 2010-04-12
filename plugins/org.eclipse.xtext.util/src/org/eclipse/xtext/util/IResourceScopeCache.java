/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
	
	static class NullImpl implements IResourceScopeCache {
		public final static IResourceScopeCache INSTANCE = new NullImpl();
		public <T> T get(Object key, Resource res, Provider<T> provider) {
			return provider.get();
		}
	}
}
