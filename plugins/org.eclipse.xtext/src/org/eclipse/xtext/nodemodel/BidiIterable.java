/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

/**
 * An iterable that is capable of being iterated in both directions - forwards and backwards.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface BidiIterable<T> extends Iterable<T> {

	/**
	 * Returns an iterator that can be used forwards and backwards.
	 * @return an iterator. Never returns <code>null</code>.
	 */
	BidiIterator<T> iterator();
	
}
