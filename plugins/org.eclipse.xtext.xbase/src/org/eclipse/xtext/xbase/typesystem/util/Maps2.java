/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.LinkedHashMap;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;

/**
 * Provides {@link #newLinkedHashMapWithExpectedSize(int)}. Everything else should be obtained from {@link Maps}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Maps2 {

	/**
	 * Creates a {@code LinkedHashMap} instance, with a high enough "initial capacity" that it <i>should</i> hold
	 * {@code expectedSize} elements without growth. This behavior cannot be broadly guaranteed, but it is observed to
	 * be true for OpenJDK 1.6. It also can't be guaranteed that the method isn't inadvertently <i>oversizing</i> the
	 * returned map.
	 * 
	 * @param expectedSize
	 *            the number of elements you expect to add to the returned map
	 * @return a new, empty {@code LinkedHashMap} with enough capacity to hold {@code expectedSize} elements without resizing
	 * @throws IllegalArgumentException
	 *             if {@code expectedSize} is negative
	 */
	public static <K, V> LinkedHashMap<K, V> newLinkedHashMapWithExpectedSize(int expectedSize) {
		return new LinkedHashMap<K, V>(capacity(expectedSize));
	}

	/**
	 * Copied from {@link Maps#capacity(int)}.
	 */
	private static int capacity(int expectedSize) {
		if (expectedSize < 3) {
			Preconditions.checkArgument(expectedSize >= 0);
			return expectedSize + 1;
		}
		if (expectedSize < Ints.MAX_POWER_OF_TWO) {
			return expectedSize + expectedSize / 3;
		}
		return Integer.MAX_VALUE; // any large value
	}

}
