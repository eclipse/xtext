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
	
	public ClassFinder(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	public Class<?> forName(String name) throws ClassNotFoundException {
		try {
			return Class.forName(normalizeClassName(name), false, classLoader);
		} catch(ClassNotFoundException e) {
			Class<?> result = Primitives.forName(name);
			if (result == null)
				throw e;
			return result;
		}
	}
	
	public String normalizeClassName(String className) {
		if (className.charAt(0) == '[' || className.charAt(className.length() - 1)!=']') 
			// assume a valid name if we have the default array notation
			return className;
		String tempClassName = className;
		int idx = tempClassName.length() - 1;
		StringBuilder result = new StringBuilder(className.length());
		while(tempClassName.charAt(idx) == ']') {
			result.append('[');
			idx-=2;
		}
		tempClassName = tempClassName.substring(0, idx + 1);
		if (Boolean.TYPE.getName().equals(tempClassName)) {
			result.append('Z');
		} else if (Byte.TYPE.getName().equals(tempClassName)) {
			result.append('B');
		} else if (Character.TYPE.getName().equals(tempClassName)) {
			result.append('C');
		} else if (Double.TYPE.getName().equals(tempClassName)) {
			result.append('D');
		} else if (Float.TYPE.getName().equals(tempClassName)) {
			result.append('F');
		} else if (Integer.TYPE.getName().equals(tempClassName)) {
			result.append('I');
		} else if (Long.TYPE.getName().equals(tempClassName)) {
			result.append('J');
		} else if (Short.TYPE.getName().equals(tempClassName)) {
			result.append('S');
		} else {
			result.append('L');
			result.append(tempClassName);
			result.append(';');
		}
		return result.toString();
	}
	
	
}
