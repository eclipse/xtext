/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package testdata;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class GenericType1<T> {
	public void add(T t) {
		
	}
	
	public T get() {
		return null;
	}
	
	{
		new GenericType1<String>().add("foo");
		new GenericType1().add("foo");
	}
}
