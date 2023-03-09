/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

/**
 * An iterable over a tree structure that is capable of being iterated 
 * in both directions - forwards and backwards. The {@link BidiTreeIterator tree iterator}
 * returned by {@link #iterator()} is capable to prune some parts of the tree
 * if clients are not interested in descending into them.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface BidiTreeIterable<E> extends BidiIterable<E> {

	/**
	 * Returns a tree iterator that can be used forwards and backwards.
	 * @return an iterator. Never returns <code>null</code>.
	 */
	@Override
	BidiTreeIterator<E> iterator();
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	BidiTreeIterable<E> reverse();

}
