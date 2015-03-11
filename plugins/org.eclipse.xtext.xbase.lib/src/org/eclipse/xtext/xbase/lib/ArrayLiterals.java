/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import com.google.common.annotations.GwtCompatible;

/**
 * Factory methods for arrays.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.4
 */
@GwtCompatible
public class ArrayLiterals {

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
