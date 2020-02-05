/*******************************************************************************
 * Copyright (c) 2010, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Iterables;
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Bytes;
import com.google.common.primitives.Chars;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Floats;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import com.google.common.primitives.Shorts;

/**
 * This is a library used to convert arrays to lists and vice versa in a way that keeps the identity of the
 * to-be-converted object. That is, changes in the array will be reflected by the list and changes to the list will be
 * reflected by the array for both kinds of conversion.
 * 
 * The utilities in this class should only be used by the Xbase compiler.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 * @author Facundo Etchezar - Initial implementation of the type-specific primitive array wrappers
 */
@GwtIncompatible("reflection")
public final class Conversions {

	private Conversions() {
		throw new RuntimeException("Can't create instances of this class");
	}

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
		if (object == null) {
			// Nothing to wrap.
			return null;
		}

		Class<?> arrayClass = object.getClass();

		if (!arrayClass.isArray()) {
			// Can't wrap something that isn't an array.
			return object;
		}

		if (!arrayClass.getComponentType().isPrimitive()) {
			// Not a primitive, return generic wrapped object array.
			return WrappedArray.create((Object[]) object);
		}

		// Now check for each primitive type individually, and return the appropriate wrapper.

		// These are probably the most used types, check for them first:
		if (object instanceof int[]) {
			return WrappedIntegerArray.create((int[]) object);
		}

		if (object instanceof long[]) {
			return WrappedLongArray.create((long[]) object);
		}

		if (object instanceof float[]) {
			return WrappedFloatArray.create((float[]) object);
		}

		if (object instanceof double[]) {
			return WrappedDoubleArray.create((double[]) object);
		}

		// Now check for the slightly less used types:
		if (object instanceof byte[]) {
			return WrappedByteArray.create((byte[]) object);
		}

		if (object instanceof short[]) {
			return WrappedShortArray.create((short[]) object);
		}

		if (object instanceof boolean[]) {
			return WrappedBooleanArray.create((boolean[]) object);
		}

		if (object instanceof char[]) {
			return WrappedCharacterArray.create((char[]) object);
		}

		// Unrecognized type.
		throw new ArrayStoreException("Unrecognised type: " + arrayClass.getCanonicalName());
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
		// This is the generic object array check.
		if (value instanceof WrappedArray<?>) {
			Object result = ((WrappedArray<?>) value).internalToArray();
			return checkComponentType(result, componentType);
		}
		// And now for the primitive arrays.
		if (value instanceof WrappedIntegerArray) {
			Object result = ((WrappedIntegerArray) value).internalToArray();
			return checkComponentType(result, componentType);
		}

		if (value instanceof WrappedLongArray) {
			Object result = ((WrappedLongArray) value).internalToArray();
			return checkComponentType(result, componentType);
		}

		if (value instanceof WrappedFloatArray) {
			Object result = ((WrappedFloatArray) value).internalToArray();
			return checkComponentType(result, componentType);
		}

		if (value instanceof WrappedDoubleArray) {
			Object result = ((WrappedDoubleArray) value).internalToArray();
			return checkComponentType(result, componentType);
		}

		if (value instanceof WrappedByteArray) {
			Object result = ((WrappedByteArray) value).internalToArray();
			return checkComponentType(result, componentType);
		}

		if (value instanceof WrappedShortArray) {
			Object result = ((WrappedShortArray) value).internalToArray();
			return checkComponentType(result, componentType);
		}

		if (value instanceof WrappedBooleanArray) {
			Object result = ((WrappedBooleanArray) value).internalToArray();
			return checkComponentType(result, componentType);
		}

		if (value instanceof WrappedCharacterArray) {
			Object result = ((WrappedCharacterArray) value).internalToArray();
			return checkComponentType(result, componentType);
		}

		if (!(value instanceof Iterable<?>)) {
			// Nothing to unwrap.
			return value;
		}

		if (!componentType.isPrimitive()) {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			Object result = Iterables.toArray((Iterable) value, componentType);
			return result;
		}

		try {
			List<?> list = IterableExtensions.toList((Iterable<?>) value);
			Object result = Array.newInstance(componentType, list.size());
			for (int i = 0; i < list.size(); i++) {
				Object element = list.get(i);
				if (element == null) {
					throw new ArrayStoreException("Cannot store <null> in primitive arrays.");
				}
				Array.set(result, i, element);
			}
			return result;
		} catch (IllegalArgumentException iae) {
			throw new ArrayStoreException("Primitive conversion failed: " + iae.getMessage());
		}
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
			throw new ArrayStoreException(
					String.format("The expected component type %s is not assignable from the actual type %s",
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
	public static final class WrappedArray<T> extends AbstractList<T> implements RandomAccess {

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
	public static final class WrappedByteArray extends AbstractList<Byte> implements RandomAccess {

		/**
		 * Creates a new {@link WrappedByteArray} that is backed by the given primitive {@code array}.
		 *
		 * @param array
		 *            the to-be-wrapped array. May be <code>null</code> which will cause any method on the resulting
		 *            object to fail.
		 * @return the wrapped array. Never <code>null</code>.
		 */
		@Pure
		public static WrappedByteArray create(byte[] array) {
			return new WrappedByteArray(array);
		}

		private final byte[] array;

		/**
		 * Internal constructor for {@link WrappedByteArray}.
		 *
		 * @param array
		 *            the to-be-wrapped array. May be <code>null</code> which will cause any method on the created
		 *            object to fail with a {@link NullPointerException}.
		 */
		protected WrappedByteArray(byte[] array) {
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
		public Byte get(int index) {
			return Byte.valueOf(array[index]);
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
		public Byte set(int index, Byte element) {
			modCount++;
			byte old = array[index];
			array[index] = element.byteValue();
			return Byte.valueOf(old);
		}

		/**
		 * {@inheritDoc}
		 *
		 * @throws NullPointerException
		 *             if the wrapped array was <code>null</code>.
		 */
		@Override
		public int indexOf(Object o) {
			// Will make the method fail if array is null.
			if (size() < 1) {
				return -1;
			}
			if (o instanceof Byte) {
				return Bytes.indexOf(array, ((Byte) o).byteValue());
			}
			return -1;
		}

		/**
		 * {@inheritDoc}
		 *
		 * @throws NullPointerException
		 *             if the wrapped array was <code>null</code>.
		 */
		@Override
		public int lastIndexOf(Object o) {
			// Will make the method fail if array is null.
			if (size() < 1) {
				return -1;
			}
			if (o instanceof Byte) {
				return Bytes.lastIndexOf(array, ((Byte) o).byteValue());
			}
			return -1;
		}

		/**
		 * {@inheritDoc}
		 *
		 * @throws NullPointerException
		 *             if the wrapped array was <code>null</code>.
		 */
		@Override
		public boolean contains(Object o) {
			// Will make the method fail if array is null.
			if (size() < 1) {
				return false;
			}
			if (o instanceof Byte) {
				return Bytes.contains(array, ((Byte) o).byteValue());
			}
			return false;
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

		/**
		 * Returns the underlying array in an unsafe manner. That is, modification of the array will be reflected by
		 * this list and vice versa.
		 *
		 * @return the underlying array. May be <code>null</code> if the list was {@link #create(byte[]) created} with a
		 *         null argument.
		 */
		public byte[] internalToArray() {
			modCount++;
			return array;
		}
	}

	/**
	 * A list that is completely backed by an array of primitives and that provides access to that array. Only for
	 * internal use.
	 */
	public static final class WrappedShortArray extends AbstractList<Short> implements RandomAccess {

		/**
		 * Creates a new {@link WrappedShortArray} that is backed by the given primitive {@code array}.
		 *
		 * @param array
		 *            the to-be-wrapped array. May be <code>null</code> which will cause any method on the resulting
		 *            object to fail.
		 * @return the wrapped array. Never <code>null</code>.
		 */
		@Pure
		public static WrappedShortArray create(short[] array) {
			return new WrappedShortArray(array);
		}

		private final short[] array;

		/**
		 * Internal constructor for {@link WrappedShortArray}.
		 *
		 * @param array
		 *            the to-be-wrapped array. May be <code>null</code> which will cause any method on the created
		 *            object to fail with a {@link NullPointerException}.
		 */
		protected WrappedShortArray(short[] array) {
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
		public Short get(int index) {
			return Short.valueOf(array[index]);
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
		public Short set(int index, Short element) {
			modCount++;
			short old = array[index];
			array[index] = element.shortValue();
			return Short.valueOf(old);
		}

		/**
		 * {@inheritDoc}
		 *
		 * @throws NullPointerException
		 *             if the wrapped array was <code>null</code>.
		 */
		@Override
		public int indexOf(Object o) {
			// Will make the method fail if array is null.
			if (size() < 1) {
				return -1;
			}
			if (o instanceof Short) {
				return Shorts.indexOf(array, ((Short) o).shortValue());
			}
			return -1;
		}

		/**
		 * {@inheritDoc}
		 *
		 * @throws NullPointerException
		 *             if the wrapped array was <code>null</code>.
		 */
		@Override
		public int lastIndexOf(Object o) {
			// Will make the method fail if array is null.
			if (size() < 1) {
				return -1;
			}
			if (o instanceof Short) {
				return Shorts.lastIndexOf(array, ((Short) o).shortValue());
			}
			return -1;
		}

		/**
		 * {@inheritDoc}
		 *
		 * @throws NullPointerException
		 *             if the wrapped array was <code>null</code>.
		 */
		@Override
		public boolean contains(Object o) {
			// Will make the method fail if array is null.
			if (size() < 1) {
				return false;
			}
			if (o instanceof Short) {
				return Shorts.contains(array, ((Short) o).shortValue());
			}
			return false;
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

		/**
		 * Returns the underlying array in an unsafe manner. That is, modification of the array will be reflected by
		 * this list and vice versa.
		 *
		 * @return the underlying array. May be <code>null</code> if the list was {@link #create(short[]) created} with
		 *         a null argument.
		 */
		public short[] internalToArray() {
			modCount++;
			return array;
		}
	}

	/**
	 * A list that is completely backed by an array of primitives and that provides access to that array. Only for
	 * internal use.
	 */
	public static final class WrappedIntegerArray extends AbstractList<Integer> implements RandomAccess {

		/**
		 * Creates a new {@link WrappedIntegerArray} that is backed by the given primitive {@code array}.
		 *
		 * @param array
		 *            the to-be-wrapped array. May be <code>null</code> which will cause any method on the resulting
		 *            object to fail.
		 * @return the wrapped array. Never <code>null</code>.
		 */
		@Pure
		public static WrappedIntegerArray create(int[] array) {
			return new WrappedIntegerArray(array);
		}

		private final int[] array;

		/**
		 * Internal constructor for {@link WrappedIntegerArray}.
		 *
		 * @param array
		 *            the to-be-wrapped array. May be <code>null</code> which will cause any method on the created
		 *            object to fail with a {@link NullPointerException}.
		 */
		protected WrappedIntegerArray(int[] array) {
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
		public Integer get(int index) {
			return Integer.valueOf(array[index]);
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
		public Integer set(int index, Integer element) {
			modCount++;
			int old = array[index];
			array[index] = element.intValue();
			return Integer.valueOf(old);
		}

		/**
		 * {@inheritDoc}
		 *
		 * @throws NullPointerException
		 *             if the wrapped array was <code>null</code>.
		 */
		@Override
		public int indexOf(Object o) {
			// Will make the method fail if array is null.
			if (size() < 1) {
				return -1;
			}
			if (o instanceof Integer) {
				return Ints.indexOf(array, ((Integer) o).intValue());
			}
			return -1;
		}

		/**
		 * {@inheritDoc}
		 *
		 * @throws NullPointerException
		 *             if the wrapped array was <code>null</code>.
		 */
		@Override
		public int lastIndexOf(Object o) {
			// Will make the method fail if array is null.
			if (size() < 1) {
				return -1;
			}
			if (o instanceof Integer) {
				return Ints.lastIndexOf(array, ((Integer) o).intValue());
			}
			return -1;
		}

		/**
		 * {@inheritDoc}
		 *
		 * @throws NullPointerException
		 *             if the wrapped array was <code>null</code>.
		 */
		@Override
		public boolean contains(Object o) {
			// Will make the method fail if array is null.
			if (size() < 1) {
				return false;
			}
			if (o instanceof Integer) {
				return Ints.contains(array, ((Integer) o).intValue());
			}
			return false;
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

		/**
		 * Returns the underlying array in an unsafe manner. That is, modification of the array will be reflected by
		 * this list and vice versa.
		 *
		 * @return the underlying array. May be <code>null</code> if the list was {@link #create(int[]) created} with a
		 *         null argument.
		 */
		public int[] internalToArray() {
			modCount++;
			return array;
		}
	}

	/**
	 * A list that is completely backed by an array of primitives and that provides access to that array. Only for
	 * internal use.
	 */
	public static final class WrappedLongArray extends AbstractList<Long> implements RandomAccess {

		/**
		 * Creates a new {@link WrappedLongArray} that is backed by the given primitive {@code array}.
		 *
		 * @param array
		 *            the to-be-wrapped array. May be <code>null</code> which will cause any method on the resulting
		 *            object to fail.
		 * @return the wrapped array. Never <code>null</code>.
		 */
		@Pure
		public static WrappedLongArray create(long[] array) {
			return new WrappedLongArray(array);
		}

		private final long[] array;

		/**
		 * Internal constructor for {@link WrappedLongArray}.
		 *
		 * @param array
		 *            the to-be-wrapped array. May be <code>null</code> which will cause any method on the created
		 *            object to fail with a {@link NullPointerException}.
		 */
		protected WrappedLongArray(long[] array) {
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
		public Long get(int index) {
			return Long.valueOf(array[index]);
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
		public Long set(int index, Long element) {
			modCount++;
			long old = array[index];
			array[index] = element.longValue();
			return Long.valueOf(old);
		}

		/**
		 * {@inheritDoc}
		 *
		 * @throws NullPointerException
		 *             if the wrapped array was <code>null</code>.
		 */
		@Override
		public int indexOf(Object o) {
			// Will make the method fail if array is null.
			if (size() < 1) {
				return -1;
			}
			if (o instanceof Long) {
				return Longs.indexOf(array, ((Long) o).longValue());
			}
			return -1;
		}

		/**
		 * {@inheritDoc}
		 *
		 * @throws NullPointerException
		 *             if the wrapped array was <code>null</code>.
		 */
		@Override
		public int lastIndexOf(Object o) {
			// Will make the method fail if array is null.
			if (size() < 1) {
				return -1;
			}
			if (o instanceof Long) {
				return Longs.lastIndexOf(array, ((Long) o).longValue());
			}
			return -1;
		}

		/**
		 * {@inheritDoc}
		 *
		 * @throws NullPointerException
		 *             if the wrapped array was <code>null</code>.
		 */
		@Override
		public boolean contains(Object o) {
			// Will make the method fail if array is null.
			if (size() < 1) {
				return false;
			}
			if (o instanceof Long) {
				return Longs.contains(array, ((Long) o).longValue());
			}
			return false;
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

		/**
		 * Returns the underlying array in an unsafe manner. That is, modification of the array will be reflected by
		 * this list and vice versa.
		 *
		 * @return the underlying array. May be <code>null</code> if the list was {@link #create(long[]) created} with a
		 *         null argument.
		 */
		public long[] internalToArray() {
			modCount++;
			return array;
		}
	}

	/**
	 * A list that is completely backed by an array of primitives and that provides access to that array. Only for
	 * internal use.
	 */
	public static final class WrappedFloatArray extends AbstractList<Float> implements RandomAccess {

		/**
		 * Creates a new {@link WrappedFloatArray} that is backed by the given primitive {@code array}.
		 *
		 * @param array
		 *            the to-be-wrapped array. May be <code>null</code> which will cause any method on the resulting
		 *            object to fail.
		 * @return the wrapped array. Never <code>null</code>.
		 */
		@Pure
		public static WrappedFloatArray create(float[] array) {
			return new WrappedFloatArray(array);
		}

		private final float[] array;

		/**
		 * Internal constructor for {@link WrappedFloatArray}.
		 *
		 * @param array
		 *            the to-be-wrapped array. May be <code>null</code> which will cause any method on the created
		 *            object to fail with a {@link NullPointerException}.
		 */
		protected WrappedFloatArray(float[] array) {
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
		public Float get(int index) {
			return Float.valueOf(array[index]);
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
		public Float set(int index, Float element) {
			modCount++;
			float old = array[index];
			array[index] = element.floatValue();
			return Float.valueOf(old);
		}

		/**
		 * {@inheritDoc}
		 *
		 * @throws NullPointerException
		 *             if the wrapped array was <code>null</code>.
		 */
		@Override
		public int indexOf(Object o) {
			// Will make the method fail if array is null.
			if (size() < 1) {
				return -1;
			}
			if (o instanceof Float) {
				return Floats.indexOf(array, ((Float) o).floatValue());
			}
			return -1;
		}

		/**
		 * {@inheritDoc}
		 *
		 * @throws NullPointerException
		 *             if the wrapped array was <code>null</code>.
		 */
		@Override
		public int lastIndexOf(Object o) {
			// Will make the method fail if array is null.
			if (size() < 1) {
				return -1;
			}
			if (o instanceof Float) {
				return Floats.lastIndexOf(array, ((Float) o).floatValue());
			}
			return -1;
		}

		/**
		 * {@inheritDoc}
		 *
		 * @throws NullPointerException
		 *             if the wrapped array was <code>null</code>.
		 */
		@Override
		public boolean contains(Object o) {
			// Will make the method fail if array is null.
			if (size() < 1) {
				return false;
			}
			if (o instanceof Float) {
				return Floats.contains(array, ((Float) o).floatValue());
			}
			return false;
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

		/**
		 * Returns the underlying array in an unsafe manner. That is, modification of the array will be reflected by
		 * this list and vice versa.
		 *
		 * @return the underlying array. May be <code>null</code> if the list was {@link #create(float[]) created} with
		 *         a null argument.
		 */
		public float[] internalToArray() {
			modCount++;
			return array;
		}
	}

	/**
	 * A list that is completely backed by an array of primitives and that provides access to that array. Only for
	 * internal use.
	 */
	public static final class WrappedDoubleArray extends AbstractList<Double> implements RandomAccess {

		/**
		 * Creates a new {@link WrappedDoubleArray} that is backed by the given primitive {@code array}.
		 *
		 * @param array
		 *            the to-be-wrapped array. May be <code>null</code> which will cause any method on the resulting
		 *            object to fail.
		 * @return the wrapped array. Never <code>null</code>.
		 */
		@Pure
		public static WrappedDoubleArray create(double[] array) {
			return new WrappedDoubleArray(array);
		}

		private final double[] array;

		/**
		 * Internal constructor for {@link WrappedDoubleArray}.
		 *
		 * @param array
		 *            the to-be-wrapped array. May be <code>null</code> which will cause any method on the created
		 *            object to fail with a {@link NullPointerException}.
		 */
		protected WrappedDoubleArray(double[] array) {
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
		public Double get(int index) {
			return Double.valueOf(array[index]);
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
		public Double set(int index, Double element) {
			modCount++;
			double old = array[index];
			array[index] = element.doubleValue();
			return Double.valueOf(old);
		}

		/**
		 * {@inheritDoc}
		 *
		 * @throws NullPointerException
		 *             if the wrapped array was <code>null</code>.
		 */
		@Override
		public int indexOf(Object o) {
			// Will make the method fail if array is null.
			if (size() < 1) {
				return -1;
			}
			if (o instanceof Double) {
				return Doubles.indexOf(array, ((Double) o).doubleValue());
			}
			return -1;
		}

		/**
		 * {@inheritDoc}
		 *
		 * @throws NullPointerException
		 *             if the wrapped array was <code>null</code>.
		 */
		@Override
		public int lastIndexOf(Object o) {
			// Will make the method fail if array is null.
			if (size() < 1) {
				return -1;
			}
			if (o instanceof Double) {
				return Doubles.lastIndexOf(array, ((Double) o).doubleValue());
			}
			return -1;
		}

		/**
		 * {@inheritDoc}
		 *
		 * @throws NullPointerException
		 *             if the wrapped array was <code>null</code>.
		 */
		@Override
		public boolean contains(Object o) {
			// Will make the method fail if array is null.
			if (size() < 1) {
				return false;
			}
			if (o instanceof Double) {
				return Doubles.contains(array, ((Double) o).doubleValue());
			}
			return false;
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

		/**
		 * Returns the underlying array in an unsafe manner. That is, modification of the array will be reflected by
		 * this list and vice versa.
		 *
		 * @return the underlying array. May be <code>null</code> if the list was {@link #create(double[]) created} with
		 *         a null argument.
		 */
		public double[] internalToArray() {
			modCount++;
			return array;
		}
	}

	/**
	 * A list that is completely backed by an array of primitives and that provides access to that array. Only for
	 * internal use.
	 */
	public static final class WrappedCharacterArray extends AbstractList<Character> implements RandomAccess {

		/**
		 * Creates a new {@link WrappedCharacterArray} that is backed by the given primitive {@code array}.
		 *
		 * @param array
		 *            the to-be-wrapped array. May be <code>null</code> which will cause any method on the resulting
		 *            object to fail.
		 * @return the wrapped array. Never <code>null</code>.
		 */
		@Pure
		public static WrappedCharacterArray create(char[] array) {
			return new WrappedCharacterArray(array);
		}

		private final char[] array;

		/**
		 * Internal constructor for {@link WrappedCharacterArray}.
		 *
		 * @param array
		 *            the to-be-wrapped array. May be <code>null</code> which will cause any method on the created
		 *            object to fail with a {@link NullPointerException}.
		 */
		protected WrappedCharacterArray(char[] array) {
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
		public Character get(int index) {
			return Character.valueOf(array[index]);
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
		public Character set(int index, Character element) {
			modCount++;
			char old = array[index];
			array[index] = element.charValue();
			return Character.valueOf(old);
		}

		/**
		 * {@inheritDoc}
		 *
		 * @throws NullPointerException
		 *             if the wrapped array was <code>null</code>.
		 */
		@Override
		public int indexOf(Object o) {
			// Will make the method fail if array is null.
			if (size() < 1) {
				return -1;
			}
			if (o instanceof Character) {
				return Chars.indexOf(array, ((Character) o).charValue());
			}
			return -1;
		}

		/**
		 * {@inheritDoc}
		 *
		 * @throws NullPointerException
		 *             if the wrapped array was <code>null</code>.
		 */
		@Override
		public int lastIndexOf(Object o) {
			// Will make the method fail if array is null.
			if (size() < 1) {
				return -1;
			}
			if (o instanceof Character) {
				return Chars.lastIndexOf(array, ((Character) o).charValue());
			}
			return -1;
		}

		/**
		 * {@inheritDoc}
		 *
		 * @throws NullPointerException
		 *             if the wrapped array was <code>null</code>.
		 */
		@Override
		public boolean contains(Object o) {
			// Will make the method fail if array is null.
			if (size() < 1) {
				return false;
			}
			if (o instanceof Character) {
				return Chars.contains(array, ((Character) o).charValue());
			}
			return false;
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

		/**
		 * Returns the underlying array in an unsafe manner. That is, modification of the array will be reflected by
		 * this list and vice versa.
		 *
		 * @return the underlying array. May be <code>null</code> if the list was {@link #create(char[]) created} with a
		 *         null argument.
		 */
		public char[] internalToArray() {
			modCount++;
			return array;
		}
	}

	/**
	 * A list that is completely backed by an array of primitives and that provides access to that array. Only for
	 * internal use.
	 */
	public static final class WrappedBooleanArray extends AbstractList<Boolean> implements RandomAccess {

		/**
		 * Creates a new {@link WrappedBooleanArray} that is backed by the given primitive {@code array}.
		 *
		 * @param array
		 *            the to-be-wrapped array. May be <code>null</code> which will cause any method on the resulting
		 *            object to fail.
		 * @return the wrapped array. Never <code>null</code>.
		 */
		@Pure
		public static WrappedBooleanArray create(boolean[] array) {
			return new WrappedBooleanArray(array);
		}

		private final boolean[] array;

		/**
		 * Internal constructor for {@link WrappedBooleanArray}.
		 *
		 * @param array
		 *            the to-be-wrapped array. May be <code>null</code> which will cause any method on the created
		 *            object to fail with a {@link NullPointerException}.
		 */
		protected WrappedBooleanArray(boolean[] array) {
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
		public Boolean get(int index) {
			return Boolean.valueOf(array[index]);
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
		public Boolean set(int index, Boolean element) {
			modCount++;
			boolean old = array[index];
			array[index] = element.booleanValue();
			return Boolean.valueOf(old);
		}

		/**
		 * {@inheritDoc}
		 *
		 * @throws NullPointerException
		 *             if the wrapped array was <code>null</code>.
		 */
		@Override
		public int indexOf(Object o) {
			// Will make the method fail if array is null.
			if (size() < 1) {
				return -1;
			}
			if (o instanceof Boolean) {
				return Booleans.indexOf(array, ((Boolean) o).booleanValue());
			}
			return -1;
		}

		/**
		 * {@inheritDoc}
		 *
		 * @throws NullPointerException
		 *             if the wrapped array was <code>null</code>.
		 */
		@Override
		public int lastIndexOf(Object o) {
			// Will make the method fail if array is null.
			if (size() < 1) {
				return -1;
			}
			if (o instanceof Boolean) {
				return Booleans.lastIndexOf(array, ((Boolean) o).booleanValue());
			}
			return -1;
		}

		/**
		 * {@inheritDoc}
		 *
		 * @throws NullPointerException
		 *             if the wrapped array was <code>null</code>.
		 */
		@Override
		public boolean contains(Object o) {
			// Will make the method fail if array is null.
			if (size() < 1) {
				return false;
			}
			if (o instanceof Boolean) {
				return Booleans.contains(array, ((Boolean) o).booleanValue());
			}
			return false;
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

		/**
		 * Returns the underlying array in an unsafe manner. That is, modification of the array will be reflected by
		 * this list and vice versa.
		 *
		 * @return the underlying array. May be <code>null</code> if the list was {@link #create(boolean[]) created}
		 *         with a null argument.
		 */
		public boolean[] internalToArray() {
			modCount++;
			return array;
		}
	}
}