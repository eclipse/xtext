/*******************************************************************************
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import java.util.Objects;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
/**
 * An extension library for arrays, to be used with Xtend. It allows to use an array without converting it to a list
 * first.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Stephane Galland - Add operations on 2-dimension arrays.
 * @since 2.4
 */
@GwtCompatible
public class ArrayExtensions {

	/**
	 * @param array
	 *            the array
	 * @param index
	 *            the index the value should be set at
	 * @param value
	 *            the value to set at the given index
	 * @return the new value
	 * @since 2.4
	 */
	@Inline("$1[$2] = $3")
	public static <T, E extends T> T set(T[] array, int index, E value) {
		array[index] = value;
		return value;
	}

	/**
	 * @param array
	 *            the array
	 * @param index
	 *            the index
	 * @return the value at the given index
	 */
	@Pure
	@Inline("$1[$2]")
	public static <T> T get(T[] array, int index) {
		return array[index];
	}

	/**
	 * Clones the array. @see {@link Object#clone}
	 * 
	 * @param array
	 *            the array
	 * @return the cloned array
	 * @since 2.5
	 */
	@Pure
	@Inline("$1.clone()")
	@GwtIncompatible("clone")
	public static <T> T[] clone(T[] array) {
		return array.clone();
	}

	// BEGIN generated code
	
	/**
	 * @param array
	 *            the array
	 * @return the length of the given array
	 */
	@Pure
	@Inline("$1.length")
	public static int length(Object[] array) {
		return array.length;
	}
	
	/**
	 * Returns a hash code value for the given array.
	 * 
	 * @param array
	 *            the array
	 * @return the hash code
	 * @since 2.5
	 */
	@Pure
	@Inline("$1.hashCode()")
	public static int hashCode(Object[] array) {
		return array.hashCode();
	}
	
	/**
	 * Returns whether the array and the given other object are identical.
	 *
	 * Delegates to {@link Object#equals(Object)}
	 * 
	 * @param array
	 *            the array
	 * @param other
	 *            the other element to compare to
	 * @return whether the two given argument are identical 
	 * @since 2.5
	 */
	@Pure
	@Inline("$1.equals($2)")
	public static boolean equals(Object[] array, Object other) {
		return array.equals(other);
	}
	
	/**
	 * Returns whether the array contains the given element.
	 * 
	 * More formally, returns <tt>true</tt> if and only if this array contains
	 * at least one element <tt>e</tt> such that
	 * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
	 *
	 * @param array 
	 * 			the array to test
	 * @param o 
	 * 			element whose presence in this array is to be tested
	 * @return <tt>true</tt> if this array contains the specified element
	 */
	@Pure
	public static boolean contains(Object[] array, Object o) {
		for (int i = 0; i < array.length; i++) {
			if (Objects.equals(array[i], o)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index
	 *            the index
	 * @return the value at the given index
	 */
	@Pure
	@Inline("$1[$2]")
	public static boolean get(boolean[] array, int index) {
		return array[index];
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index
	 *            the index the value should be set at
	 * @param value
	 *            the value to set at the given index
	 * @return the new value
	 */
	@Inline("$1[$2] = $3")
	public static boolean set(boolean[] array, int index, boolean value) {
		array[index] = value;
		return value;
	}
	
	/**
	 * @param array
	 *            the array
	 * @return the length of the given array
	 */
	@Pure
	@Inline("$1.length")
	public static int length(boolean[] array) {
		return array.length;
	}
	
	/**
	 * Returns a hash code value for the given array.
	 * 
	 * @param array
	 *            the array
	 * @return the hash code
	 * @since 2.5
	 */
	@Pure
	@Inline("$1.hashCode()")
	public static int hashCode(boolean[] array) {
		return array.hashCode();
	}
	
	/**
	 * Returns whether the array and the given other object are identical.
	 *
	 * Delegates to {@link Object#equals(Object)}
	 * 
	 * @param array
	 *            the array
	 * @param other
	 *            the other element to compare to
	 * @return whether the two given argument are identical 
	 * @since 2.5
	 */
	@Pure
	@Inline("$1.equals($2)")
	public static boolean equals(boolean[] array, Object other) {
		return array.equals(other);
	}
	
	/**
	 * Clones the array. @see {@link Object#clone}
	 * 
	 * @param array
	 *            the array
	 * @return the cloned array
	 * @since 2.5
	 */
	@Pure
	@Inline("$1.clone()")
	@GwtIncompatible("clone")
	public static boolean[] clone(boolean[] array) {
		return array.clone();
	}
	
	/**
	 * Returns whether the array contains the given value. More formally,
	 * returns <tt>true</tt> if and only if this array contains at least one
	 * element <tt>e</tt> such that <tt>value==e</tt>.
	 *
	 * @param array 
	 * 			the array to test
	 * @param value 
	 * 			value whose presence in this array is to be tested
	 * @return <tt>true</tt> if this array contains the specified element
	 */
	@Pure
	public static boolean contains(boolean[] array, boolean value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index
	 *            the index
	 * @return the value at the given index
	 */
	@Pure
	@Inline("$1[$2]")
	public static double get(double[] array, int index) {
		return array[index];
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index
	 *            the index the value should be set at
	 * @param value
	 *            the value to set at the given index
	 * @return the new value
	 */
	@Inline("$1[$2] = $3")
	public static double set(double[] array, int index, double value) {
		array[index] = value;
		return value;
	}
	
	/**
	 * @param array
	 *            the array
	 * @return the length of the given array
	 */
	@Pure
	@Inline("$1.length")
	public static int length(double[] array) {
		return array.length;
	}
	
	/**
	 * Returns a hash code value for the given array.
	 * 
	 * @param array
	 *            the array
	 * @return the hash code
	 * @since 2.5
	 */
	@Pure
	@Inline("$1.hashCode()")
	public static int hashCode(double[] array) {
		return array.hashCode();
	}
	
	/**
	 * Returns whether the array and the given other object are identical.
	 *
	 * Delegates to {@link Object#equals(Object)}
	 * 
	 * @param array
	 *            the array
	 * @param other
	 *            the other element to compare to
	 * @return whether the two given argument are identical 
	 * @since 2.5
	 */
	@Pure
	@Inline("$1.equals($2)")
	public static boolean equals(double[] array, Object other) {
		return array.equals(other);
	}
	
	/**
	 * Clones the array. @see {@link Object#clone}
	 * 
	 * @param array
	 *            the array
	 * @return the cloned array
	 * @since 2.5
	 */
	@Pure
	@Inline("$1.clone()")
	@GwtIncompatible("clone")
	public static double[] clone(double[] array) {
		return array.clone();
	}
	
	/**
	 * Returns whether the array contains the given value.
	 * 
	 * More formally, returns <tt>true</tt> if and only if this array contains
	 * at least one element <tt>e</tt> such that
	 * <tt>java.lang.Double.compare(o,&nbsp;e)&nbsp;==&nbsp;0)</tt>.
	 * 
	 * @param array 
	 * 			the array to test
	 * @param value 
	 * 			value whose presence in this array is to be tested
	 * @return <tt>true</tt> if this array contains the specified element
	 */
	@Pure
	public static boolean contains(double[] array, double value) {
		for (int i = 0; i < array.length; i++) {
			if (Double.compare(array[i], value) == 0) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index
	 *            the index
	 * @return the value at the given index
	 */
	@Pure
	@Inline("$1[$2]")
	public static float get(float[] array, int index) {
		return array[index];
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index
	 *            the index the value should be set at
	 * @param value
	 *            the value to set at the given index
	 * @return the new value
	 */
	@Inline("$1[$2] = $3")
	public static float set(float[] array, int index, float value) {
		array[index] = value;
		return value;
	}
	
	/**
	 * @param array
	 *            the array
	 * @return the length of the given array
	 */
	@Pure
	@Inline("$1.length")
	public static int length(float[] array) {
		return array.length;
	}
	
	/**
	 * Returns a hash code value for the given array.
	 * 
	 * @param array
	 *            the array
	 * @return the hash code
	 * @since 2.5
	 */
	@Pure
	@Inline("$1.hashCode()")
	public static int hashCode(float[] array) {
		return array.hashCode();
	}
	
	/**
	 * Returns whether the array and the given other object are identical.
	 *
	 * Delegates to {@link Object#equals(Object)}
	 * 
	 * @param array
	 *            the array
	 * @param other
	 *            the other element to compare to
	 * @return whether the two given argument are identical 
	 * @since 2.5
	 */
	@Pure
	@Inline("$1.equals($2)")
	public static boolean equals(float[] array, Object other) {
		return array.equals(other);
	}
	
	/**
	 * Clones the array. @see {@link Object#clone}
	 * 
	 * @param array
	 *            the array
	 * @return the cloned array
	 * @since 2.5
	 */
	@Pure
	@Inline("$1.clone()")
	@GwtIncompatible("clone")
	public static float[] clone(float[] array) {
		return array.clone();
	}
	
	/**
	 * Returns whether the array contains the given value.
	 * 
	 * More formally, returns <tt>true</tt> if and only if this array contains
	 * at least one element <tt>e</tt> such that
	 * <tt>java.lang.Float.compare(o,&nbsp;e)&nbsp;==&nbsp;0)</tt>.
	 *
	 * @param array 
	 * 			the array to test
	 * @param value 
	 * 			value whose presence in this array is to be tested
	 * @return <tt>true</tt> if this array contains the specified element
	 */
	@Pure
	public static boolean contains(float[] array, float value) {
		for (int i = 0; i < array.length; i++) {
			if (Float.compare(array[i], value) == 0) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index
	 *            the index
	 * @return the value at the given index
	 */
	@Pure
	@Inline("$1[$2]")
	public static long get(long[] array, int index) {
		return array[index];
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index
	 *            the index the value should be set at
	 * @param value
	 *            the value to set at the given index
	 * @return the new value
	 */
	@Inline("$1[$2] = $3")
	public static long set(long[] array, int index, long value) {
		array[index] = value;
		return value;
	}
	
	/**
	 * @param array
	 *            the array
	 * @return the length of the given array
	 */
	@Pure
	@Inline("$1.length")
	public static int length(long[] array) {
		return array.length;
	}
	
	/**
	 * Returns a hash code value for the given array.
	 * 
	 * @param array
	 *            the array
	 * @return the hash code
	 * @since 2.5
	 */
	@Pure
	@Inline("$1.hashCode()")
	public static int hashCode(long[] array) {
		return array.hashCode();
	}
	
	/**
	 * Returns whether the array and the given other object are identical.
	 *
	 * Delegates to {@link Object#equals(Object)}
	 * 
	 * @param array
	 *            the array
	 * @param other
	 *            the other element to compare to
	 * @return whether the two given argument are identical 
	 * @since 2.5
	 */
	@Pure
	@Inline("$1.equals($2)")
	public static boolean equals(long[] array, Object other) {
		return array.equals(other);
	}
	
	/**
	 * Clones the array. @see {@link Object#clone}
	 * 
	 * @param array
	 *            the array
	 * @return the cloned array
	 * @since 2.5
	 */
	@Pure
	@Inline("$1.clone()")
	@GwtIncompatible("clone")
	public static long[] clone(long[] array) {
		return array.clone();
	}
	
	/**
	 * Returns whether the array contains the given value.
	 * 
	 * More formally, returns <tt>true</tt> if and only if this array contains
	 * at least one element <tt>e</tt> such that
	 * <tt>(value&nbsp;==&nbsp;e)</tt>.
	 *
	 * @param array 
	 * 			the array to test
	 * @param value 
	 * 			element whose presence in this array is to be tested
	 * @return <tt>true</tt> if this array contains the specified element
	 */
	@Pure
	public static boolean contains(long[] array, long value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index
	 *            the index
	 * @return the value at the given index
	 */
	@Pure
	@Inline("$1[$2]")
	public static int get(int[] array, int index) {
		return array[index];
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index
	 *            the index the value should be set at
	 * @param value
	 *            the value to set at the given index
	 * @return the new value
	 */
	@Inline("$1[$2] = $3")
	public static int set(int[] array, int index, int value) {
		array[index] = value;
		return value;
	}
	
	/**
	 * @param array
	 *            the array
	 * @return the length of the given array
	 */
	@Pure
	@Inline("$1.length")
	public static int length(int[] array) {
		return array.length;
	}
	
	/**
	 * Returns a hash code value for the given array.
	 * 
	 * @param array
	 *            the array
	 * @return the hash code
	 * @since 2.5
	 */
	@Pure
	@Inline("$1.hashCode()")
	public static int hashCode(int[] array) {
		return array.hashCode();
	}
	
	/**
	 * Returns whether the array and the given other object are identical.
	 *
	 * Delegates to {@link Object#equals(Object)}
	 * 
	 * @param array
	 *            the array
	 * @param other
	 *            the other element to compare to
	 * @return whether the two given argument are identical 
	 * @since 2.5
	 */
	@Pure
	@Inline("$1.equals($2)")
	public static boolean equals(int[] array, Object other) {
		return array.equals(other);
	}
	
	/**
	 * Clones the array. @see {@link Object#clone}
	 * 
	 * @param array
	 *            the array
	 * @return the cloned array
	 * @since 2.5
	 */
	@Pure
	@Inline("$1.clone()")
	@GwtIncompatible("clone")
	public static int[] clone(int[] array) {
		return array.clone();
	}
	
	/**
	 * Returns whether the array contains the given value.
	 * 
	 * More formally, returns <tt>true</tt> if and only if this array contains
	 * at least one element <tt>e</tt> such that
	 * <tt>(value&nbsp;==&nbsp;e)</tt>.
	 *
	 * @param array 
	 * 			the array to test
	 * @param value 
	 * 			value whose presence in this array is to be tested
	 * @return <tt>true</tt> if this array contains the specified element
	 */
	@Pure
	public static boolean contains(int[] array, int value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index
	 *            the index
	 * @return the value at the given index
	 */
	@Pure
	@Inline("$1[$2]")
	public static char get(char[] array, int index) {
		return array[index];
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index
	 *            the index the value should be set at
	 * @param value
	 *            the value to set at the given index
	 * @return the new value
	 */
	@Inline("$1[$2] = $3")
	public static char set(char[] array, int index, char value) {
		array[index] = value;
		return value;
	}
	
	/**
	 * @param array
	 *            the array
	 * @return the length of the given array
	 */
	@Pure
	@Inline("$1.length")
	public static int length(char[] array) {
		return array.length;
	}
	
	/**
	 * Returns a hash code value for the given array.
	 * 
	 * @param array
	 *            the array
	 * @return the hash code
	 * @since 2.5
	 */
	@Pure
	@Inline("$1.hashCode()")
	public static int hashCode(char[] array) {
		return array.hashCode();
	}
	
	/**
	 * Returns whether the array and the given other object are identical.
	 *
	 * Delegates to {@link Object#equals(Object)}
	 * 
	 * @param array
	 *            the array
	 * @param other
	 *            the other element to compare to
	 * @return whether the two given argument are identical 
	 * @since 2.5
	 */
	@Pure
	@Inline("$1.equals($2)")
	public static boolean equals(char[] array, Object other) {
		return array.equals(other);
	}
	
	/**
	 * Clones the array. @see {@link Object#clone}
	 * 
	 * @param array
	 *            the array
	 * @return the cloned array
	 * @since 2.5
	 */
	@Pure
	@Inline("$1.clone()")
	@GwtIncompatible("clone")
	public static char[] clone(char[] array) {
		return array.clone();
	}
	
	/**
	 * Returns whether the array contains the given value.
	 * 
	 * More formally, returns <tt>true</tt> if and only if this array contains
	 * at least one element <tt>e</tt> such that
	 * <tt>(value&nbsp;==&nbsp;e)</tt>.
	 *
	 * @param array 
	 * 			the array to test
	 * @param value 
	 * 			value whose presence in this array is to be tested
	 * @return <tt>true</tt> if this array contains the specified element
	 */
	@Pure
	public static boolean contains(char[] array, char value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index
	 *            the index
	 * @return the value at the given index
	 */
	@Pure
	@Inline("$1[$2]")
	public static short get(short[] array, int index) {
		return array[index];
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index
	 *            the index the value should be set at
	 * @param value
	 *            the value to set at the given index
	 * @return the new value
	 */
	@Inline("$1[$2] = $3")
	public static short set(short[] array, int index, short value) {
		array[index] = value;
		return value;
	}
	
	/**
	 * @param array
	 *            the array
	 * @return the length of the given array
	 */
	@Pure
	@Inline("$1.length")
	public static int length(short[] array) {
		return array.length;
	}
	
	/**
	 * Returns a hash code value for the given array.
	 * 
	 * @param array
	 *            the array
	 * @return the hash code
	 * @since 2.5
	 */
	@Pure
	@Inline("$1.hashCode()")
	public static int hashCode(short[] array) {
		return array.hashCode();
	}
	
	/**
	 * Returns whether the array and the given other object are identical.
	 *
	 * Delegates to {@link Object#equals(Object)}
	 * 
	 * @param array
	 *            the array
	 * @param other
	 *            the other element to compare to
	 * @return whether the two given argument are identical 
	 * @since 2.5
	 */
	@Pure
	@Inline("$1.equals($2)")
	public static boolean equals(short[] array, Object other) {
		return array.equals(other);
	}
	
	/**
	 * Clones the array. @see {@link Object#clone}
	 * 
	 * @param array
	 *            the array
	 * @return the cloned array
	 * @since 2.5
	 */
	@Pure
	@Inline("$1.clone()")
	@GwtIncompatible("clone")
	public static short[] clone(short[] array) {
		return array.clone();
	}
	
	/**
	 * Returns whether the array contains the given value.
	 * 
	 * More formally, returns <tt>true</tt> if and only if this array contains
	 * at least one element <tt>e</tt> such that
	 * <tt>(value&nbsp;==&nbsp;e)</tt>.
	 *
	 * @param array 
	 * 			the array to test
	 * @param value 
	 * 			value whose presence in this array is to be tested
	 * @return <tt>true</tt> if this array contains the specified element
	 */
	@Pure
	public static boolean contains(short[] array, short value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index
	 *            the index
	 * @return the value at the given index
	 */
	@Pure
	@Inline("$1[$2]")
	public static byte get(byte[] array, int index) {
		return array[index];
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index
	 *            the index the value should be set at
	 * @param value
	 *            the value to set at the given index
	 * @return the new value
	 */
	@Inline("$1[$2] = $3")
	public static byte set(byte[] array, int index, byte value) {
		array[index] = value;
		return value;
	}
	
	/**
	 * @param array
	 *            the array
	 * @return the length of the given array
	 */
	@Pure
	@Inline("$1.length")
	public static int length(byte[] array) {
		return array.length;
	}
	
	/**
	 * Returns a hash code value for the given array.
	 * 
	 * @param array
	 *            the array
	 * @return the hash code
	 * @since 2.5
	 */
	@Pure
	@Inline("$1.hashCode()")
	public static int hashCode(byte[] array) {
		return array.hashCode();
	}
	
	/**
	 * Returns whether the array and the given other object are identical.
	 *
	 * Delegates to {@link Object#equals(Object)}
	 * 
	 * @param array
	 *            the array
	 * @param other
	 *            the other element to compare to
	 * @return whether the two given argument are identical 
	 * @since 2.5
	 */
	@Pure
	@Inline("$1.equals($2)")
	public static boolean equals(byte[] array, Object other) {
		return array.equals(other);
	}
	
	/**
	 * Clones the array. @see {@link Object#clone}
	 * 
	 * @param array
	 *            the array
	 * @return the cloned array
	 * @since 2.5
	 */
	@Pure
	@Inline("$1.clone()")
	@GwtIncompatible("clone")
	public static byte[] clone(byte[] array) {
		return array.clone();
	}
	
	/**
	 * Returns whether the array contains the given value.
	 * 
	 * More formally, returns <tt>true</tt> if and only if this array contains
	 * at least one element <tt>e</tt> such that
	 * <tt>(value&nbsp;==&nbsp;e)</tt>.
	 *
	 * @param array 
	 * 			the array to test
	 * @param value 
	 * 			value whose presence in this array is to be tested
	 * @return <tt>true</tt> if this array contains the specified element
	 */
	@Pure
	public static boolean contains(byte[] array, byte value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) {
				return true;
			}
		}
		return false;
	}
// END generated code

	/**
	 * @param array
	 *            the array
	 * @param index0
	 *            the first index
	 * @param index1
	 *            the second index
	 * @return the value at the given index
	 * @since 2.16
	 */
	@Pure
	@Inline("$1[$2][$3]")
	public static <T> T get(T[][] array, int index0, int index1) {
		return array[index0][index1];
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index0
	 *            the first index the value should be set at
	 * @param index1
	 *            the second index the value should be set at
	 * @param value
	 *            the value to set at the given indexes
	 * @return the new value
	 * @since 2.16
	 */
	@Inline("$1[$2][$3] = $4")
	public static <T, E extends T> T set(T[][] array, int index0, int index1, E value) {
		array[index0][index1] = value;
		return value;
	}

	/**
	 * @param array
	 *            the array
	 * @param index0
	 *            the first index
	 * @param index1
	 *            the second index
	 * @return the value at the given indexes
	 * @since 2.16
	 */
	@Pure
	@Inline("$1[$2][$3]")
	public static boolean get(boolean[][] array, int index0, int index1) {
		return array[index0][index1];
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index0
	 *            the first index the value should be set at
	 * @param index1
	 *            the second index the value should be set at
	 * @param value
	 *            the value to set at the given indexes
	 * @return the new value
	 * @since 2.16
	 */
	@Inline("$1[$2][$3] = $4")
	public static boolean set(boolean[][] array, int index0, int index1, boolean value) {
		array[index0][index1] = value;
		return value;
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index0
	 *            the first index
	 * @param index1
	 *            the second index
	 * @return the value at the given indexes
	 * @since 2.16
	 */
	@Pure
	@Inline("$1[$2][$3]")
	public static double get(double[][] array, int index0, int index1) {
		return array[index0][index1];
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index0
	 *            the first index the value should be set at
	 * @param index1
	 *            the second index the value should be set at
	 * @param value
	 *            the value to set at the given indexex
	 * @return the new value
	 * @since 2.16
	 */
	@Inline("$1[$2][$3] = $4")
	public static double set(double[][] array, int index0, int index1, double value) {
		array[index0][index1] = value;
		return value;
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index0
	 *            the first index
	 * @param index1
	 *            the first index
	 * @return the value at the given indexes
	 * @since 2.16
	 */
	@Pure
	@Inline("$1[$2][$3]")
	public static float get(float[][] array, int index0, int index1) {
		return array[index0][index1];
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index0
	 *            the first index the value should be set at
	 * @param index1
	 *            the second index the value should be set at
	 * @param value
	 *            the value to set at the given indexes
	 * @return the new value
	 * @since 2.16
	 */
	@Inline("$1[$2][$3] = $4")
	public static float set(float[][] array, int index0, int index1, float value) {
		array[index0][index1] = value;
		return value;
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index0
	 *            the first index
	 * @param index1
	 *            the second index
	 * @return the value at the given indexes
	 * @since 2.16
	 */
	@Pure
	@Inline("$1[$2][$3]")
	public static long get(long[][] array, int index0, int index1) {
		return array[index0][index1];
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index0
	 *            the first index the value should be set at
	 * @param index1
	 *            the second index the value should be set at
	 * @param value
	 *            the value to set at the given indexes
	 * @return the new value
	 * @since 2.16
	 */
	@Inline("$1[$2][$3] = $4")
	public static long set(long[][] array, int index0, int index1, long value) {
		array[index0][index1] = value;
		return value;
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index0
	 *            the first index
	 * @param index1
	 *            the second index
	 * @return the value at the given indexes
	 * @since 2.16
	 */
	@Pure
	@Inline("$1[$2]")
	public static int get(int[][] array, int index0, int index1) {
		return array[index0][index1];
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index0
	 *            the first index the value should be set at
	 * @param index1
	 *            the second index the value should be set at
	 * @param value
	 *            the value to set at the given index
	 * @return the new value
	 * @since 2.16
	 */
	@Inline("$1[$2][$3] = $4")
	public static int set(int[][] array, int index0, int index1, int value) {
		array[index0][index1] = value;
		return value;
	}
		
	/**
	 * @param array
	 *            the array
	 * @param index0
	 *            the first index
	 * @param index1
	 *            the second index
	 * @return the value at the given indexes
	 * @since 2.16
	 */
	@Pure
	@Inline("$1[$2][$3]")
	public static char get(char[][] array, int index0, int index1) {
		return array[index0][index1];
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index0
	 *            the first index the value should be set at
	 * @param index1
	 *            the second index the value should be set at
	 * @param value
	 *            the value to set at the given indexes
	 * @return the new value
	 * @since 2.16
	 */
	@Inline("$1[$2][$3] = $4")
	public static char set(char[][] array, int index0, int index1, char value) {
		array[index0][index1] = value;
		return value;
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index0
	 *            the first index
	 * @param index1
	 *            the second index
	 * @return the value at the given indexes
	 * @since 2.16
	 */
	@Pure
	@Inline("$1[$2][$3]")
	public static short get(short[][] array, int index0, int index1) {
		return array[index0][index1];
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index0
	 *            the first index the value should be set at
	 * @param index1
	 *            the second index the value should be set at
	 * @param value
	 *            the value to set at the given indexes
	 * @return the new value
	 * @since 2.16
	 */
	@Inline("$1[$2][$3] = $4")
	public static short set(short[][] array, int index0, int index1, short value) {
		array[index0][index1] = value;
		return value;
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index0
	 *            the first index
	 * @param index1
	 *            the second index
	 * @return the value at the given indexes
	 * @since 2.16
	 */
	@Pure
	@Inline("$1[$2][$3]")
	public static byte get(byte[][] array, int index0, int index1) {
		return array[index0][index1];
	}
	
	/**
	 * @param array
	 *            the array
	 * @param index0
	 *            the first index the value should be set at
	 * @param index1
	 *            the second index the value should be set at
	 * @param value
	 *            the value to set at the given indexes
	 * @return the new value
	 * @since 2.16
	 */
	@Inline("$1[$2][$3] = $4")
	public static byte set(byte[][] array, int index0, int index1, byte value) {
		array[index0][index1] = value;
		return value;
	}

}
