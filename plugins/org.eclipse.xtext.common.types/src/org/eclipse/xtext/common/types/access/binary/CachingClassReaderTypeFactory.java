/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.impl.ITypeFactory;

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
public class CachingClassReaderTypeFactory implements ITypeFactory<BinaryClass> {

	private static final Logger log = Logger.getLogger(ClassReaderTypeFactory.class);

	private final ClassReaderTypeFactory delegate;

	private final Map<String, JvmType> typeCache = Maps.newHashMap();

	public CachingClassReaderTypeFactory(ClassReaderTypeFactory delegate) {
		this.delegate = delegate;
	}
	
	public JvmType createType(BinaryClass clazz) {
		try {
			JvmType cachedResult = get(clazz);
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

	private JvmType get(BinaryClass clazz) {
		String name = clazz.getName();
		JvmType cachedResult = typeCache.get(name);
		if (cachedResult == null) {
			cachedResult = load(clazz);
			typeCache.put(name, cachedResult);
		}
		return cachedResult;
	}

	private JvmType load(BinaryClass key) {
		if (log.isDebugEnabled())
			log.debug("Hit:" + key.getName());
		return delegate.createType(key);
	}
	
}
