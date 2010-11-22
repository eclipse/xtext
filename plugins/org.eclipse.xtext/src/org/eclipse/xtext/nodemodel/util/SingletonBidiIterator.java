/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.util;

import java.util.NoSuchElementException;

import org.eclipse.xtext.nodemodel.BidiIterator;

import com.google.common.collect.UnmodifiableIterator;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SingletonBidiIterator<T> extends UnmodifiableIterator<T> implements BidiIterator<T> {

	private boolean doneNext;
	private boolean donePrevious;
	private final T value;

	public static <T> BidiIterator<T> create(T t) {
		return new SingletonBidiIterator<T>(t);
	}
	
	private SingletonBidiIterator(T value) {
		this.value = value;
		doneNext = false;
		donePrevious = false;
	}

	public boolean hasNext() {
		return !doneNext;
	}

	public T next() {
		if (doneNext) {
			throw new NoSuchElementException();
		}
		doneNext = true;
		donePrevious = false;
		return value;
	}

	public boolean hasPrevious() {
		return !donePrevious;
	}

	public T previous() {
		if (donePrevious) {
			throw new NoSuchElementException();
		}
		donePrevious = true;
		doneNext = false;
		return value;
	}
}
