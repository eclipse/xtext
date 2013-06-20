/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import static com.google.common.collect.Maps.*;

import java.util.Map;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClassFinder {
	
	private static final Class<?> NULL_CLASS;

	static
	{
		class Null
		{
			
		}
		NULL_CLASS = Null.class;
	}
	
	private static final ClassNotFoundException CACHED_EXCEPTION = new ClassNotFoundException(); 
	
	private final ClassLoader classLoader;
	private final ClassNameUtil classNameUtil;
	
	public ClassFinder(ClassLoader classLoader) {
		this.classLoader = classLoader;
		this.classNameUtil = new ClassNameUtil();
	}
	
	private Map<String, Class<?>> cache = newHashMapWithExpectedSize(500);
	
	{
		for (Class<?> primitiveType : Primitives.ALL_PRIMITIVE_TYPES) {
			cache.put(primitiveType.getName(), primitiveType);
		}
	}

	public Class<?> forName(String name) throws ClassNotFoundException {
		Class<?> result = cache.get(name);
		if (result != null) {
			if (result == NULL_CLASS)
				throw CACHED_EXCEPTION;
			return result;
		}

		try {
			result = Class.forName(classNameUtil.normalizeClassName(name), false, classLoader);
			cache.put(name, result);
			return result;
		} catch(ClassNotFoundException e) {
			cache.put(name, NULL_CLASS);
			throw e;
		}
	}
	
}
