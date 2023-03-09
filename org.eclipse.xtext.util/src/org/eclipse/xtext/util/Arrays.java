/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Arrays {

	private Arrays() {}
	
	public static <T> boolean contains(T[] array, T value) {
		if (array == null || array.length == 0)
			return false;
		return java.util.Arrays.asList(array).contains(value);
	}
	
}
