/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.util;

import org.eclipse.xtext.nodemodel.BidiIterable;
import org.eclipse.xtext.nodemodel.BidiIterator;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SingletonBidiIterable<T> implements BidiIterable<T> {

	public static <T> SingletonBidiIterable<T> create(T value) {
		return new SingletonBidiIterable<T>(value);
	}
	
	private final T value;
	
	public SingletonBidiIterable(T value) {
		this.value = value;
	}

	@Override
	public BidiIterator<T> iterator() {
		return SingletonBidiIterator.<T>create(value);
	}
	
	@Override
	public BidiIterable<T> reverse() {
		return this;
	}

}
