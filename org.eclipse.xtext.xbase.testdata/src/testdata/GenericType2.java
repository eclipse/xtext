/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
