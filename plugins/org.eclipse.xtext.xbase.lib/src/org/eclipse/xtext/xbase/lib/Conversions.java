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
import java.util.List;
import java.util.RandomAccess;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Iterables;

/**
 * This is a library used to convert arrays to lists and vice versa in a way that keeps the identity of the
 * to-be-converted object. That is, changes in the array will be reflected by the list and changes to the list will be
 * reflected by the array for both kinds of conversion.
 * 
 * The utilities in this class should only be used by the Xbase compiler.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
@GwtIncompatible("reflection") public class Conversions {

	/**
	 * Wraps {@code object} in a list if and only if {@code object} is an array. Works for primitive and
	 * object-component types.
	 * 
	 * @param object
	 *            the object to be wrapped. May be <code>null</code>.
	 * @return a list if the given object was an array. Otherwise the unmodified given object. May return
	 *         <code>null</code> if the object was <code>null</code>.
	 */
	@Pure
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

	/**
	 * Unwraps {@code object} to extract the original array if and only if {@code object} was previously created by
	 * {@link #doWrapArray(Object)}. If the array's component type cannot be determined at runtime, {@link Object} is  
	 * used.
	 * 
	 * @param value
	 *            the object to be unwrapped. May be <code>null</code>.
	 * @return the previously wrapped array if the given value represents such. Otherwise returns the value unmodified.
	 *         May return <code>null</code> if the value was <code>null</code>.
	 */
	@Pure
	public static Object unwrapArray(Object value) {
		return unwrapArray(value, Object.class);
	}
	
	/**
	 * Unwraps {@code object} to extract the original array if and only if {@code object} was previously created by
	 * {@link #doWrapArray(Object)}.
	 * 
	 * @param value
	 *            the object to be unwrapped. May be <code>null</code>.
	 * @param componentType
	 *            the expected component type of the array. May not be <code>null</code>.
	 * @return the previously wrapped array if the given value represents such. Otherwise returns the value unmodified.
	 *         May return <code>null</code> if the value was <code>null</code>.
	 * @throws ArrayStoreException
	 *             if the expected runtime {@code componentType} does not match the actual runtime component type.
	 */
	@Pure
	public static Object unwrapArray(Object value, Class<?> componentType) {
		if (value instanceof WrappedArray<?>) {
			Object result = ((WrappedArray<?>) value).internalToArray();
			return checkComponentType(result, componentType);
		}
		if (value instanceof WrappedPrimitiveArray) {
			Object result = ((WrappedPrimitiveArray) value).internalToArray();
			return checkComponentType(result, componentType);
		}
		if (value instanceof Iterable<?>) {
			if (!componentType.isPrimitive()) {
				@SuppressWarnings({ "unchecked", "rawtypes" })
				Object result = Iterables.toArray((Iterable)value, componentType);
				return result;
			} else {
				try {
					List<?> list = IterableExtensions.toList((Iterable<?>) value);
					Object result = Array.newInstance(componentType, list.size());
					for(int i = 0; i < list.size(); i++) {
						Object element = list.get(i);
						if (element == null) {
							throw new ArrayStoreException("Cannot store <null> in primitive arrays.");
						}
						Array.set(result, i, element);
					}
					return result;
				} catch(IllegalArgumentException iae) {
					throw new ArrayStoreException("Primitive conversion failed: " + iae.getMessage());
				}
			}
		}
		return value;
	}

	/**
	 * Checks the component type of the given array against the expected component type.
	 * 
	 * @param array
	 *            the array to be checked. May not be <code>null</code>.
	 * @param expectedComponentType
	 *            the expected component type of the array. May not be <code>null</code>.
	 * @return the unchanged array.
	 * @throws ArrayStoreException
	 *             if the expected runtime {@code componentType} does not match the actual runtime component type.
	 */
	private static Object checkComponentType(Object array, Class<?> expectedComponentType) {
		Class<?> actualComponentType = array.getClass().getComponentType();
		if (!expectedComponentType.isAssignableFrom(actualComponentType)) {
			throw new ArrayStoreException(String.format(
					"The expected component type %s is not assignable from the actual type %s", 
					expectedComponentType.getCanonicalName(), actualComponentType.getCanonicalName()));
		}
		return array;
	}

	/**
	 * A list that is completely backed by an array and that provides access to that array. Only for internal use.
	 * 
	 * @param <T>
	 *            the type if the list elements.
	 */
	public static class WrappedArray<T> extends AbstractList<T> implements RandomAccess {

		/**
		 * Creates a new {@link WrappedArray} that is backed by the given {@code array}.
		 * 
		 * @param array
		 *            the to-be-wrapped array. May be <code>null</code> which will cause any method on the result object
		 *            to fail with a {@link NullPointerException}.
		 * @param <T>
		 *            the element type of the created list.
		 * @return the wrapped array. Never <code>null</code>.
		 */
		public static <T> WrappedArray<T> create(T[] array) {
			return new WrappedArray<T>(array);
		}

		private T[] array;

		/**
		 * Internal constructor for {@link WrappedArray}.
		 * 
		 * @param array
		 *            the to-be-wrapped array. May be <code>null</code> which will cause any method on the created
		 *            object to fail with a {@link NullPointerException}.
		 */
		protected WrappedArray(T[] array) {
			this.array = array;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws NullPointerException
		 *             if the wrapped array was <code>null</code>.
		 * @throws IndexOutOfBoundsException
		 *             {@inheritDoc}
		 */
		@Override
		public T get(int index) {
			return array[index];
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws NullPointerException
		 *             if the wrapped array was <code>null</code>.
		 * @throws ClassCastException
		 *             {@inheritDoc}
		 * @throws NullPointerException
		 *             {@inheritDoc}
		 * @throws IllegalArgumentException
		 *             {@inheritDoc}
		 * @throws IndexOutOfBoundsException
		 *             {@inheritDoc}
		 */
		@Override
		public T set(int index, T element) {
			T old = array[index];
			array[index] = element;
			modCount++;
			return old;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws NullPointerException
		 *             if the wrapped array was <code>null</code>.
		 */
		@Override
		public int size() {
			return array.length;
		}

		@Override
		public Object[] toArray() {
			return array.clone();
		}

		/**
		 * Returns the underlying array in an unsafe manner. That is, modification of the array will be reflected by
		 * this list and vice versa.
		 * 
		 * @return the underlying array. May be <code>null</code> if the list was {@link #create(Object[]) created} with
		 *         a null argument.
		 */
		public T[] internalToArray() {
			modCount++;
			return array;
		}

	}

	/**
	 * A list that is completely backed by an array of primitives and that provides access to that array. Only for
	 * internal use.
	 */
	public static class WrappedPrimitiveArray extends AbstractList<Object> implements RandomAccess {

		/**
		 * Creates a new {@link WrappedPrimitiveArray} that is backed by the given primitive {@code array}.
		 * 
		 * @param array
		 *            the to-be-wrapped array. May be <code>null</code> which will cause any method on the resulting
		 *            object to fail.
		 * @return the wrapped array. Never <code>null</code>.
		 */
		@Pure
		public static WrappedPrimitiveArray create(Object array) {
			return new WrappedPrimitiveArray(array);
		}

		private Object array;
		private int size;

		/**
		 * Internal constructor for {@link WrappedPrimitiveArray}.
		 * 
		 * @param array
		 *            the to-be-wrapped array. May be <code>null</code> which will cause any method on the created
		 *            object to fail with a {@link NullPointerException}.
		 */
		protected WrappedPrimitiveArray(Object array) {
			this.array = array;
			if (array != null)
				this.size = Array.getLength(array);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws NullPointerException
		 *             if the wrapped array was <code>null</code>.
		 * @throws IndexOutOfBoundsException
		 *             {@inheritDoc}
		 */
		@Override
		public Object get(int index) {
			if (array == null)
				throw new NullPointerException();
			return Array.get(array, index);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws NullPointerException
		 *             if the wrapped array was <code>null</code>.
		 * @throws ClassCastException
		 *             {@inheritDoc}
		 * @throws NullPointerException
		 *             {@inheritDoc}
		 * @throws IllegalArgumentException
		 *             {@inheritDoc}
		 * @throws IndexOutOfBoundsException
		 *             {@inheritDoc}
		 */
		@Override
		public Object set(int index, Object element) {
			if (array == null)
				throw new NullPointerException();
			Object old = get(index);
			Array.set(array, index, element);
			modCount++;
			return old;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws NullPointerException
		 *             if the wrapped array was <code>null</code>.
		 */
		@Override
		public int size() {
			if (array == null)
				throw new NullPointerException();
			return size;
		}

		/**
		 * Returns the underlying array in an unsafe manner. That is, modification of the array will be reflected by
		 * this list and vice versa.
		 * 
		 * @return the underlying array. May be <code>null</code> if the list was {@link #create(Object) created} with a
		 *         null argument.
		 */
		public Object internalToArray() {
			modCount++;
			return array;
		}

	}
}