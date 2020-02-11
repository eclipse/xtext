/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.text.MessageFormat;

/**
 * @author Jan Koehnlein - Initial contribution and API
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

	/**
	 * Copied from com.google.inject.internal.MoreTypes.getRawType(Type)
	 * @since 2.8
	 */
	public static Class<?> getRawType(Type type) {
		if (type instanceof Class<?>) {
			// type is a normal class.
			return (Class<?>) type;

		} else if (type instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) type;

			// I'm not exactly sure why getRawType() returns Type instead of Class.
			// Neal isn't either but suspects some pathological case related
			// to nested classes exists.
			Type rawType = parameterizedType.getRawType();
			if (!(rawType instanceof Class)) {
				String message = MessageFormat.format("Expected a Class, but <{0}> is of type {1}", type, type.getClass()
						.getName());
				throw new IllegalArgumentException(message);
			}
			return (Class<?>) rawType;

		} else if (type instanceof GenericArrayType) {
			Type componentType = ((GenericArrayType) type).getGenericComponentType();
			return Array.newInstance(getRawType(componentType), 0).getClass();

		} else if (type instanceof TypeVariable) {
			// we could use the variable's bounds, but that'll won't work if there are multiple.
			// having a raw type that's more general than necessary is okay  
			return Object.class;

		} else {
			throw new IllegalArgumentException("Expected a Class, ParameterizedType, or " + "GenericArrayType, but <"
					+ type + "> is of type " + type.getClass().getName());
		}
	}
}
