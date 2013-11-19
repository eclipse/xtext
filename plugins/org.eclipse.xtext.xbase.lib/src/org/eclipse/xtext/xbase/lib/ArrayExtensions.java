/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import java.util.Arrays;

import com.google.common.annotations.GwtCompatible;

/**
 * An extension library for arrays, to be used with Xtend. It allows to use an array without converting it to a list
 * first.
 * 
 * @author Sven Efftinge - Initial contribution and API
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
	 * @since 2.4
	 */
	@Inline("$1[$2] = $3")
	public static <T, E extends T> void set(T[] array, int index, E value) {
		array[index] = value;
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
	 * Returns whether the array and the given other object are equal.
	 * 
	 * Delegates to {@link Arrays#equals(Object[], Object[])}
	 * 
	 * @param array
	 *            the array
	 * @param other
	 *            the other element to compare to
	 * @return the hash code
	 * @since 2.5
	 */
	@Pure
	@Inline("$1.equals($2)")
	public static boolean equals(Object[] array, Object other) {
		return array.equals(other);
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
	 */
	@Inline("$1[$2] = $3")
	public static void set(boolean[] array, int index, boolean value) {
		array[index] = value;
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
	 * Returns whether the array and the given other object are equal.
	 * 
	 * Delegates to {@link Arrays#equals(boolean[], boolean[])}
	 * 
	 * @param array
	 *            the array
	 * @param other
	 *            the other element to compare to
	 * @return the hash code
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
	public static boolean[] clone(boolean[] array) {
		return array.clone();
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
	 */
	@Inline("$1[$2] = $3")
	public static void set(double[] array, int index, double value) {
		array[index] = value;
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
	 * Returns whether the array and the given other object are equal.
	 * 
	 * Delegates to {@link Arrays#equals(double[], double[])}
	 * 
	 * @param array
	 *            the array
	 * @param other
	 *            the other element to compare to
	 * @return the hash code
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
	public static double[] clone(double[] array) {
		return array.clone();
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
	 */
	@Inline("$1[$2] = $3")
	public static void set(float[] array, int index, float value) {
		array[index] = value;
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
	 * Returns whether the array and the given other object are equal.
	 * 
	 * Delegates to {@link Arrays#equals(float[], float[])}
	 * 
	 * @param array
	 *            the array
	 * @param other
	 *            the other element to compare to
	 * @return the hash code
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
	public static float[] clone(float[] array) {
		return array.clone();
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
	 */
	@Inline("$1[$2] = $3")
	public static void set(long[] array, int index, long value) {
		array[index] = value;
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
	 * Returns whether the array and the given other object are equal.
	 * 
	 * Delegates to {@link Arrays#equals(long[], long[])}
	 * 
	 * @param array
	 *            the array
	 * @param other
	 *            the other element to compare to
	 * @return the hash code
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
	public static long[] clone(long[] array) {
		return array.clone();
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
	 */
	@Inline("$1[$2] = $3")
	public static void set(int[] array, int index, int value) {
		array[index] = value;
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
	 * Returns whether the array and the given other object are equal.
	 * 
	 * Delegates to {@link Arrays#equals(int[], int[])}
	 * 
	 * @param array
	 *            the array
	 * @param other
	 *            the other element to compare to
	 * @return the hash code
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
	public static int[] clone(int[] array) {
		return array.clone();
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
	 */
	@Inline("$1[$2] = $3")
	public static void set(char[] array, int index, char value) {
		array[index] = value;
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
	 * Returns whether the array and the given other object are equal.
	 * 
	 * Delegates to {@link Arrays#equals(char[], char[])}
	 * 
	 * @param array
	 *            the array
	 * @param other
	 *            the other element to compare to
	 * @return the hash code
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
	public static char[] clone(char[] array) {
		return array.clone();
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
	 */
	@Inline("$1[$2] = $3")
	public static void set(short[] array, int index, short value) {
		array[index] = value;
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
	 * Returns whether the array and the given other object are equal.
	 * 
	 * Delegates to {@link Arrays#equals(short[], short[])}
	 * 
	 * @param array
	 *            the array
	 * @param other
	 *            the other element to compare to
	 * @return the hash code
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
	public static short[] clone(short[] array) {
		return array.clone();
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
	 */
	@Inline("$1[$2] = $3")
	public static void set(byte[] array, int index, byte value) {
		array[index] = value;
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
	 * Returns whether the array and the given other object are equal.
	 * 
	 * Delegates to {@link Arrays#equals(byte[], byte[])}
	 * 
	 * @param array
	 *            the array
	 * @param other
	 *            the other element to compare to
	 * @return the hash code
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
	public static byte[] clone(byte[] array) {
		return array.clone();
	}
// END generated code
}
