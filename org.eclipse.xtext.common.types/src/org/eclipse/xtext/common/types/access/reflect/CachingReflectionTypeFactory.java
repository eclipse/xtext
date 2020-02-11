/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.reflect;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;

import com.google.common.collect.Maps;

/**
 * It caches the {@link JvmDeclaredType} per {@link Class}.
 * 
 * The mechanism is based on the assumption that the same class loader is used during the lifetime of the type factory.
 * The cached {@link JvmDeclaredType type} is not contained in a resource / resource set and contains proxies. If a
 * client requests a type, the cached instance is EcoreUtil.copied and the copy is delivered.
 * 
 * This class is mainly useful for unit tests where the number of
 * used resource sets is rather big compared to the number of loaded types,
 * e.g. the evaluation tests with about 500 test cases will request the
 * extension types at least 500 times thus caching those types greatly reduces the execution time.
 * 
 * Real world use cases like the command line compiler for Xtend will usually not benefit from cached
 * {@link JvmType types} since only one resource set is involved which maintains an index of resolved
 * types.  
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CachingReflectionTypeFactory extends ReflectionTypeFactory {

	private static final Logger log = Logger.getLogger(CachingReflectionTypeFactory.class);

	private final ReflectionTypeFactory delegate;

	private final Map<Class<?>, JvmDeclaredType> typeCache = Maps.newHashMap();

	public CachingReflectionTypeFactory(ReflectionTypeFactory delegate) {
		super(delegate.getUriHelper());
		this.delegate = delegate;
	}

	@Override
	public JvmDeclaredType createType(Class<?> clazz) {
		try {
			JvmDeclaredType cachedResult = get(clazz);
			// the cached result contains proxies and is not 
			// contained in a resource set. clone it since the
			// client of #createClass will usually put the result
			// into a resource and perform proxy resolution afterwards
			// in the context of a single resource set.
			return EcoreUtil2.cloneWithProxies(cachedResult);
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				log.debug(e.getMessage(), e);
			}
			return delegate.createType(clazz);
		}
	}

	private JvmDeclaredType get(Class<?> key) {
		JvmDeclaredType cachedResult = typeCache.get(key);
		if (cachedResult == null) {
			cachedResult = load(key);
			typeCache.put(key, cachedResult);
		}
		return cachedResult;
	}

	private JvmDeclaredType load(Class<?> key) {
		if (log.isDebugEnabled())
			log.debug("Hit:" + key.getCanonicalName());
		return delegate.createType(key);
	}
	
}
