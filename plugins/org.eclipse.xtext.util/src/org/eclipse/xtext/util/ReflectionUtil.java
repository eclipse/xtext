/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

/**
 * @author koehnlein - Initial contribution and API
 */
public class ReflectionUtil {

	public static Class<?> getObjectType(Class<?> clazzA) {
		if (clazzA != null && clazzA.isPrimitive()) {
			if (clazzA == Boolean.TYPE) {
				return Boolean.class;
			} else if (clazzA == Integer.TYPE) {
				return Integer.class;
			} else if (clazzA == Float.TYPE) {
				return Float.class;
			} else if (clazzA == Byte.TYPE) {
				return Byte.class;
			} else if (clazzA == Character.TYPE) {
				return Character.class;
			} else if (clazzA == Double.TYPE) {
				return Double.class;
			} else if (clazzA == Short.TYPE) {
				return Short.class;
			} else if (clazzA == Long.TYPE) {
				return Long.class;
			}
		}
		return clazzA;
	}

}
