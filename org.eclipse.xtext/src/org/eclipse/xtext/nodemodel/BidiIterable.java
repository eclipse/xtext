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
 * An iterable that is capable of being iterated in both directions - forwards and backwards.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface BidiIterable<T> extends Iterable<T> {

	/**
	 * Returns an iterator that can be used forwards and backwards.
	 * @return an iterator. Never returns <code>null</code>.
	 */
	@Override
	BidiIterator<T> iterator();
	
	/**
	 * <p>Returns a reverse version of this iterable that can be used 
	 * forwards and backwards. In other words, an iterator provided by
	 * the reverse iterable will delegate its {@link BidiIterator#hasNext() hasNext()}
	 * and {@link BidiIterator#next() next()} invocations to 
	 * {@link BidiIterator#hasPrevious()} and {@link BidiIterator#previous()}
	 * respectively.</p> 
	 * 
	 * <p>This allows clients to iterate backwards by means of the enhanced 
	 * for-loop:</p>
	 * <pre>
	 * for(T t: iterable.reverse()) {
	 *   // do something with t
	 * }
	 * </pre>
	 * 
	 * @return the reversed iterable. Never returns <code>null</code>.
	 */
	BidiIterable<T> reverse();
	
}
