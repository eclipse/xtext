/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import com.google.common.annotations.GwtCompatible;

/**
 * Factory methods for arrays.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Stephane Galland - Add operations on 2-dimension arrays.
 * @since 2.4
 */
@GwtCompatible
public class ArrayLiterals {

	/**
	 * @param size0
	 *            the first size for the array to be created
	 * @param size1
	 *            the second size for the array to be created
	 * @return an array of the given sizes
	 * @since 2.16
	 */
	@Pure
	@Inline("new $4[$1][$2]")
	public static <T> T[][] newArrayOfSize(int size0, int size1) {
		throw new UnsupportedOperationException(
				"This method relies on the inlined compilation (see @Inline annotation), and cannot be used from Java or with an uncustomized interpreter."); //$NON-NLS-1$
	}

	/**
	 * @param size
	 *            the size for the array to be created
	 * @return an array of the given size
	 * @since 2.4
	 */
	@Pure
	@Inline("new $3[$1]")
	public static <T> T[] newArrayOfSize(int size) {
		throw new UnsupportedOperationException(
				"This method relies on the inlined compilation (see @Inline annotation), and cannot be used from Java or with an uncustomized interpreter.");
	}

	/**
	 * @param size0
	 *            the first size for the array to be created
	 * @param size1
	 *            the second size for the array to be created
	 * @return an array of the given sizes
	 * @since 2.16
	 */
	@Pure
	@Inline("new char[$1][$2]")
	public static char[][] newCharArrayOfSize(int size0, int size1) {
		return new char[size0][size1];
	}

	/**
	 * @param size
	 *            the size for the array to be created
	 * @return an array of the given size
	 * @since 2.4
	 */
	@Pure
	@Inline("new char[$1]")
	public static char[] newCharArrayOfSize(int size) {
		return new char[size];
	}

	/**
	 * @param size0
	 *            the first size for the array to be created
	 * @param size1
	 *            the second size for the array to be created
	 * @return an array of the given sizes
	 * @since 2.16
	 */
	@Pure
	@Inline("new int[$1][$2]")
	public static int[][] newIntArrayOfSize(int size0, int size1) {
		return new int[size0][size1];
	}

	/**
	 * @param size
	 *            the size for the array to be created
	 * @return an array of the given size
	 * @since 2.4
	 */
	@Pure
	@Inline("new int[$1]")
	public static int[] newIntArrayOfSize(int size) {
		return new int[size];
	}

	/**
	 * @param size0
	 *            the first size for the array to be created
	 * @param size1
	 *            the second size for the array to be created
	 * @return an array of the given sizes
	 * @since 2.16
	 */
	@Pure
	@Inline("new boolean[$1][$2]")
	public static boolean[][] newBooleanArrayOfSize(int size0, int size1) {
		return new boolean[size0][size1];
	}

	/**
	 * @param size
	 *            the size for the array to be created
	 * @return an array of the given size
	 * @since 2.4
	 */
	@Pure
	@Inline("new boolean[$1]")
	public static boolean[] newBooleanArrayOfSize(int size) {
		return new boolean[size];
	}

	/**
	 * @param size0
	 *            the first size for the array to be created
	 * @param size1
	 *            the second size for the array to be created
	 * @return an array of the given sizes
	 * @since 2.16
	 */
	@Pure
	@Inline("new short[$1][$2]")
	public static short[][] newShortArrayOfSize(int size0, int size1) {
		return new short[size0][size1];
	}

	/**
	 * @param size
	 *            the size for the array to be created
	 * @return an array of the given size
	 * @since 2.4
	 */
	@Pure
	@Inline("new short[$1]")
	public static short[] newShortArrayOfSize(int size) {
		return new short[size];
	}

	/**
	 * @param size0
	 *            the first size for the array to be created
	 * @param size1
	 *            the second size for the array to be created
	 * @return an array of the given sizes
	 * @since 2.16
	 */
	@Pure
	@Inline("new long[$1][$2]")
	public static long[][] newLongArrayOfSize(int size0, int size1) {
		return new long[size0][size1];
	}

	/**
	 * @param size
	 *            the size for the array to be created
	 * @return an array of the given size
	 * @since 2.4
	 */
	@Pure
	@Inline("new long[$1]")
	public static long[] newLongArrayOfSize(int size) {
		return new long[size];
	}

	/**
	 * @param size0
	 *            the first size for the array to be created
	 * @param size1
	 *            the second size for the array to be created
	 * @return an array of the given sizes
	 * @since 2.16
	 */
	@Pure
	@Inline("new float[$1][$2]")
	public static float[][] newFloatArrayOfSize(int size0, int size1) {
		return new float[size0][size1];
	}

	/**
	 * @param size
	 *            the size for the array to be created
	 * @return an array of the given size
	 * @since 2.4
	 */
	@Pure
	@Inline("new float[$1]")
	public static float[] newFloatArrayOfSize(int size) {
		return new float[size];
	}

	/**
	 * @param size0
	 *            the first size for the array to be created
	 * @param size1
	 *            the second size for the array to be created
	 * @return an array of the given sizes
	 * @since 2.16
	 */
	@Pure
	@Inline("new double[$1][$2]")
	public static double[][] newDoubleArrayOfSize(int size0, int size1) {
		return new double[size0][size1];
	}

	/**
	 * @param size
	 *            the size for the array to be created
	 * @return an array of the given size
	 * @since 2.4
	 */
	@Pure
	@Inline("new double[$1]")
	public static double[] newDoubleArrayOfSize(int size) {
		return new double[size];
	}


	/**
	 * @param size0
	 *            the first size for the array to be created
	 * @param size1
	 *            the second size for the array to be created
	 * @return an array of the given sizes
	 * @since 2.16
	 */
	@Pure
	@Inline("new byte[$1][$2]")
	public static byte[][] newByteArrayOfSize(int size0, int size1) {
		return new byte[size0][size1];
	}

	/**
	 * @param size
	 *            the size for the array to be created
	 * @return an array of the given size
	 * @since 2.4
	 */
	@Pure
	@Inline("new byte[$1]")
	public static byte[] newByteArrayOfSize(int size) {
		return new byte[size];
	}
}
