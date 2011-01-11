/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.RandomAccess;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
public class Conversions {

	public static Object doWrapArray(Object object) {
		if (object == null)
			return null;
		Class<?> arrayClass = object.getClass();
		if (arrayClass.isArray()) {
			if (arrayClass.getComponentType().isPrimitive()) {
				WrappedPrimitiveArray result = WrappedPrimitiveArray.create(object);
				return result;
			}
			WrappedArray<Object> result = WrappedArray.create((Object[]) object);
			return result;
		}
		return object;
	}
	
	public static Object unwrapArray(Object value) {
		//TODO if value is instanceof List return list. needs type information.
		if (value instanceof WrappedArray<?>)
			return ((WrappedArray<?>) value).internalToArray();
		if (value instanceof WrappedPrimitiveArray)
			return ((WrappedPrimitiveArray) value).internalToArray();
		return value;
	}

	public static class WrappedArray<T> extends AbstractList<T> implements RandomAccess {

		public static <T> WrappedArray<T> create(T[] array) {
			return new WrappedArray<T>(array);
		}

		private T[] array;

		protected WrappedArray(T[] array) {
			this.array = array;
		}

		@Override
		public T get(int index) {
			return array[index];
		}

		@Override
		public T set(int index, T element) {
			T old = array[index];
			array[index] = element;
			modCount++;
			return old;
		}

		@Override
		public int size() {
			return array.length;
		}

		@Override
		public Object[] toArray() {
			return array.clone();
		}

		public T[] internalToArray() {
			modCount++;
			return array;
		}

	}

	public static class WrappedPrimitiveArray extends AbstractList<Object> implements RandomAccess {

		public static WrappedPrimitiveArray create(Object array) {
			return new WrappedPrimitiveArray(array);
		}

		private Object array;
		private int size;

		protected WrappedPrimitiveArray(Object array) {
			this.array = array;
			this.size = Array.getLength(array);
		}

		@Override
		public Object get(int index) {
			return Array.get(array, index);
		}

		@Override
		public Object set(int index, Object element) {
			Object old = get(index);
			Array.set(array, index, element);
			modCount++;
			return old;
		}

		@Override
		public int size() {
			return size;
		}

		public Object internalToArray() {
			modCount++;
			return array;
		}

	}
}