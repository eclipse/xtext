/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <p>A bidirectional iterator. It can be used in both directions and even alternating.</p>
 * <p>It is similar to a {@link java.util.ListIterator ListIterator} besides that it does not
 * support the index-based operations {@link java.util.ListIterator#previousIndex() previousIndex} and
 * {@link java.util.ListIterator#nextIndex() nextIndex} or the mutating operations 
 * {@link java.util.ListIterator#set(Object) set} and
 * {@link java.util.ListIterator#add(Object) add}.</p>
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface BidiIterator<T> extends Iterator<T> {

	/**
     * Returns <tt>true</tt> if this bidi iterator has more elements when
     * traversing in the reverse direction.  (In other words, returns
     * <tt>true</tt> if <tt>previous</tt> would return an element rather than
     * throwing an exception.)
     *
     * @return <tt>true</tt> if the bidi iterator has more elements when
     *	       traversing in the reverse direction.
     */
	boolean hasPrevious();
	
	/**
     * Returns the previous element.  This method may be called
     * repeatedly to iterate backwards, or intermixed with
     * calls to <tt>next</tt> to go back and forth.  (Note that alternating
     * calls to <tt>next</tt> and <tt>previous</tt> will return the same
     * element repeatedly.)
     *
     * @return the previous element.
     * 
     * @exception NoSuchElementException if the iteration has no previous
     *            element.
     */
	T previous();
	
}
