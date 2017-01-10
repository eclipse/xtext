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
	
	private T t;
	
	public GenericType1(T t) {
		this.t = t;
	}
	
	public GenericType1() {
	}
	
	public boolean operator_add(T t) {
		boolean result = this.t == null;
		this.t = t;
		return result;
	}
	
	public T get() {
		return t;
	}
	
	public void set(T t) {
		this.t = t;
	}
}
