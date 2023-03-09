/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
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
public class Wrapper<T> {
	
	private T value;
	
	public static <T> Wrapper<T> wrap(T value) {
		return new Wrapper<T>(value);
	}
	
	public static <T> Wrapper<T> forType(Class<T> type) {
		return new Wrapper<T>();
	}
	
	public Wrapper() {
		this(null);
	}
	
	public Wrapper(T value) {
		this.value = value;
	}
	
	public T get() {
		return value;
	}
	
	public void set(T value) {
		this.value = value;
	}
	
	/**
	 * @since 2.9
	 */
	public boolean isEmpty() {
		return value == null;
	}
	
	@Override
	public String toString() {
		return "Wrapper of ("+value+")";
	}

}
