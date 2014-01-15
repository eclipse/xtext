/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.internal.compiler.classfmt.ClassFileReader;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFormatException;

import com.google.common.collect.Maps;

/**
 * This helper caches a small in-memory representation of the structure
 * of a class. Rather than reading the same bytes repeatedly from disk
 * or parsing them again and again, a small struct with the necessary
 * information is cached.
 * 
 * <p>It is not expected to be used concurrently.</p>
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class ClassFileReaderAccess {

	/**
	 * A map of binary class names to the struct of information.
	 */
	private final Map<String, ClassFileReader> cache;

	public ClassFileReaderAccess() {
		this.cache = createCache();
	}

	protected HashMap<String, ClassFileReader> createCache() {
		return Maps.newHashMap();
	}
	
	protected Map<String, ClassFileReader> getCache() {
		return cache;
	}
	
	public ClassFileReader getClassFileReader(BinaryClass clazz) throws ClassFormatException {
		String className = clazz.getName();
		Map<String, ClassFileReader> cache = getCache();
		ClassFileReader result = cache.get(className);
		if (result != null) {
			return result;
		}
		result = new ClassFileReader(clazz.getBytes(), className.toCharArray(), true /* release byte array afterwards */);
		cache.put(className, result);
		return result;
	}
	
}
