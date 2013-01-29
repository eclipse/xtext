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

import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.util.internal.Stopwatches.StoppedTask;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClassFinder {
	
	private final ClassLoader classLoader;
	private final ClassNameUtil classNameUtil;
	
	private final StoppedTask forNameTask = Stopwatches.forTask("ClassFinder.forName");
	
	public ClassFinder(ClassLoader classLoader) {
		this.classLoader = classLoader;
		this.classNameUtil = new ClassNameUtil();
	}
	
	private Map<String, Class<?>> cache = newHashMapWithExpectedSize(500);

	public Class<?> forName(String name) throws ClassNotFoundException {
		try {
			forNameTask.start();
			if (name.length() <= "boolean".length() && name.indexOf('.') == -1) {
				Class<?> result = Primitives.forName(name);
				if (result != null)
					return result;
			}
			
			if (cache.containsKey(name)) {
				Class<?> result = cache.get(name);
				if (result == null)
					throw new ClassNotFoundException(name);
				return result;
			}
			Class<?> result = Class.forName(classNameUtil.normalizeClassName(name), false, classLoader);
			cache.put(name, result);
			return result;
		} catch(ClassNotFoundException e) {
			Class<?> result = Primitives.forName(name);
			if (result == null) {
				cache.put(name, null);
				throw e;
			}
			return result;
		} finally {
			forNameTask.stop();
		}
	}
	
}
