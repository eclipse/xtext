/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

/**
 * Normalizes human readable source type names to their binary represenation.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClassNameUtil {
	
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
