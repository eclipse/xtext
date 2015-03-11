/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import java.util.Map;

/**
 * Utility to find binary artifacts from their source names, e.g find classes
 * for type names like {@code java.lang.String[]} rather than {@code [Ljava/lang/String;}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractClassFinder<C> {
	
	protected static final ClassNotFoundException CACHED_EXCEPTION = new ClassNotFoundException(); 
	
	private final ClassLoader classLoader;
	private final ClassNameUtil classNameUtil;
	private final C nullValue;
	private final Map<String, C> cache; 
	
	protected AbstractClassFinder(ClassLoader classLoader, C nullValue, Map<String, C> cache) {
		this.classLoader = classLoader;
		this.nullValue = nullValue;
		this.cache = cache;
		this.classNameUtil = new ClassNameUtil();
	}
	
	public C forName(String name) throws ClassNotFoundException {
		C result = cache.get(name);
		if (result != null) {
			if (result == nullValue)
				throw CACHED_EXCEPTION;
			return result;
		}

		try {
			result = forName(classNameUtil.normalizeClassName(name), classLoader);
			cache.put(name, result);
			return result;
		} catch(ClassNotFoundException e) {
			cache.put(name, nullValue);
			throw e;
		}
	}

	 protected abstract C forName(String name, ClassLoader classLoader) throws ClassNotFoundException ;
	
}

