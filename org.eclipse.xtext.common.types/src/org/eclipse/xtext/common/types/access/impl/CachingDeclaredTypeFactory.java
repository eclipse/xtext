/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.binary.BinaryClass;

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
public class CachingDeclaredTypeFactory implements ITypeFactory<BinaryClass, JvmDeclaredType> {

	private static final Logger log = Logger.getLogger(CachingDeclaredTypeFactory.class);

	private final DeclaredTypeFactory delegate;

	private final Map<String, JvmDeclaredType> typeCache = new ConcurrentHashMap<String, JvmDeclaredType>();
	
	private final JvmDeclaredType nullValue = TypesFactory.eINSTANCE.createJvmGenericType();

	public CachingDeclaredTypeFactory(DeclaredTypeFactory delegate) {
		this.delegate = delegate;
	}
	
	@Override
	public JvmDeclaredType createType(BinaryClass clazz) {
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

	private JvmDeclaredType get(BinaryClass clazz) {
		String name = clazz.getName();
		JvmDeclaredType cachedResult = typeCache.get(name);
		if (cachedResult == null) {
			cachedResult = load(clazz);
			if (cachedResult == null) {
				typeCache.put(name, nullValue);
			} else {
				typeCache.put(name, cachedResult);
			}
		} else if (cachedResult == nullValue) {
			return null;
		}
		return cachedResult;
	}

	private JvmDeclaredType load(BinaryClass key) {
		if (log.isDebugEnabled())
			log.debug("Hit:" + key.getName());
		return delegate.createType(key);
	}
	
}
