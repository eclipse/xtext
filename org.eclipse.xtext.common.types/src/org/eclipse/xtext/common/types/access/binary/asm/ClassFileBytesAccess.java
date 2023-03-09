/*******************************************************************************
 * Copyright (c) 2014, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary.asm;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.xtext.common.types.access.binary.BinaryClass;

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
 * @author Arne Deutsch - Introduce hack to work with Java 10 and ASM 6.0
 */
public class ClassFileBytesAccess {

	/**
	 * A map of binary class names to the struct of information.
	 */
	private final Map<String, byte[]> cache;
	
	private final byte[] notAvailable = new byte[0];

	public ClassFileBytesAccess() {
		this.cache = createCache();
	}

	protected HashMap<String, byte[]> createCache() {
		return Maps.newHashMap();
	}
	
	protected Map<String, byte[]> getCache() {
		return cache;
	}
	
	public byte[] getBytes(BinaryClass clazz)  {
		String className = clazz.getName();
		Map<String, byte[]> cache = getCache();
		byte[] result = cache.get(className);
		if (result != null) {
			return result != notAvailable ? result : null;
		}
		result = clazz.getBytes();
		
		cache.put(className, result != null ? result : notAvailable);
		return result;
	}
	
}
