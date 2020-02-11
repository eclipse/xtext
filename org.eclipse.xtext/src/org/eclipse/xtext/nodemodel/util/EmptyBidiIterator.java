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
public class EmptyBidiIterator<T> extends UnmodifiableIterator<T> implements BidiIterator<T> {

	private static EmptyBidiIterator<?> INSTANCE = new EmptyBidiIterator<Object>();
	
	@SuppressWarnings("unchecked")
	public static <T> BidiIterator<T> instance() {
		return (BidiIterator<T>) INSTANCE;
	}
	
	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public T next() {
		throw new NoSuchElementException();
	}

	@Override
	public boolean hasPrevious() {
		return false;
	}

	@Override
	public T previous() {
		throw new NoSuchElementException();
	}

}
