/*******************************************************************************
 * Copyright (c) 2014, 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
		
		// XXX This is a hack to be able to work with ASM 6.0 which is not Java 10 compatible. As ASM 6.1 is buggy
		// and ASM 6.1.1 not yet released we check if the loaded class is compiled with Java 10. If so we modify the
		// major version byte from 54 (Java 10) to 53 (Java 9). The the byte codes between both versions are otherwise
		// unchanged this is not critical.
		// TODO remove hack as soon as ASM 6.1.1 is included in eclipse and we can remove backwards compatibility with
		// eclipse oxygen 3a and probabably eclipse photon
		
		// START HACK
		if (result[7] == 54) {
			result[7] = 53;
		}
		// END HACK
		
		cache.put(className, result != null ? result : notAvailable);
		return result;
	}
	
}
