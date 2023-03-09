/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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

	@Override
	public boolean hasNext() {
		return !doneNext;
	}

	@Override
	public T next() {
		if (doneNext) {
			throw new NoSuchElementException();
		}
		doneNext = true;
		donePrevious = false;
		return value;
	}

	@Override
	public boolean hasPrevious() {
		return !donePrevious;
	}

	@Override
	public T previous() {
		if (donePrevious) {
			throw new NoSuchElementException();
		}
		donePrevious = true;
		doneNext = false;
		return value;
	}
}
