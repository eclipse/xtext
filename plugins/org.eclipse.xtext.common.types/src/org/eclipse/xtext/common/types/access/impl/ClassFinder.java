/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClassFinder {
	
	private final ClassLoader classLoader;
	private final ClassNameUtil classNameUtil;
	
	public ClassFinder(ClassLoader classLoader) {
		this.classLoader = classLoader;
		this.classNameUtil = new ClassNameUtil();
	}

	public Class<?> forName(String name) throws ClassNotFoundException {
		try {
			return Class.forName(classNameUtil.normalizeClassName(name), false, classLoader);
		} catch(ClassNotFoundException e) {
			Class<?> result = Primitives.forName(name);
			if (result == null)
				throw e;
			return result;
		}
	}
	
}
