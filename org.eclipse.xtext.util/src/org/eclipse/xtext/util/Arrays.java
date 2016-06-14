/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
