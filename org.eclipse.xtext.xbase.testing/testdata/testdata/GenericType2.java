/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package testdata;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.3
 */
public class GenericType2<T extends Number> {
	
	private T[] array;
	
	@SafeVarargs
	public GenericType2(T... values) {
		this.array = values;
	}
	
	public T[] getArray() {
		return array;
	}
	
}
