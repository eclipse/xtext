/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

/**
 * An extension library for arrays, to be used with Xtend. It allows to use an array without converting it to a list
 * first.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.4
 */
public class ArrayExtensions {

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
	 * @param array
	 *            the array
	 * @param index
	 *            the index the value should be set at
	 * @param value
	 *            the value to set at the given index
	 */
	@Inline("$1[$2] = $3")
	public static <T> void set(T[] array, int index, T value) {
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
	 * @return the length of the given array
	 */
	@Pure
	@Inline("$1.length")
	public static int length(short[] array) {
		return array.length;
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
	 * @return the length of the given array
	 */
	@Pure
	@Inline("$1.length")
	public static int length(char[] array) {
		return array.length;
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
	 * @return the length of the given array
	 */
	@Pure
	@Inline("$1.length")
	public static int length(int[] array) {
		return array.length;
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
	 * @return the length of the given array
	 */
	@Pure
	@Inline("$1.length")
	public static int length(long[] array) {
		return array.length;
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
	 * @return the length of the given array
	 */
	@Pure
	@Inline("$1.length")
	public static int length(float[] array) {
		return array.length;
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
	 * @return the length of the given array
	 */
	@Pure
	@Inline("$1.length")
	public static int length(double[] array) {
		return array.length;
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
	 * @return the length of the given array
	 */
	@Pure
	@Inline("$1.length")
	public static int length(boolean[] array) {
		return array.length;
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
	 * @param index
	 *            the index
	 * @return the value at the given index
	 */
	@Pure
	@Inline("$1[$2]")
	public static boolean get(boolean[] array, int index) {
		return array[index];
	}
}
