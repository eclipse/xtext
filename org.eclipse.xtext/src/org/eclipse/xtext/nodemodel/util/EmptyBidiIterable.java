/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.util;

import org.eclipse.xtext.nodemodel.BidiIterable;
import org.eclipse.xtext.nodemodel.BidiIterator;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EmptyBidiIterable<T> implements BidiIterable<T> {

	private static EmptyBidiIterable<?> INSTANCE = new EmptyBidiIterable<Object>();
	
	@SuppressWarnings("unchecked")
	public static <T> EmptyBidiIterable<T> instance() {
		return (EmptyBidiIterable<T>) INSTANCE;
	}

	@Override
	public BidiIterator<T> iterator() {
		return EmptyBidiIterator.instance();
	}
	
	@Override
	public BidiIterable<T> reverse() {
		return instance();
	}

}
