/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

import java.util.NoSuchElementException;

import org.eclipse.emf.common.util.TreeIterator;

/**
 * <p>A {@link BidiIterator bidirectional} {@link TreeIterator tree iterator}. 
 * It can be used in both directions and even alternating.</p>
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface BidiTreeIterator<T> extends TreeIterator<T>, BidiIterator<T> {
	
	/**
	 * {@inheritDoc}
	 * 
	 * <p>Intermixed calls to {@link #next()} and {@link #previous()} may not lead
	 * to the very same element since the iterator does not return the parent element
	 * when its done with its children but the next sibling of the parent.</p>
	 * 
	 * @exception NoSuchElementException iteration has no next element.
	 */
	@Override
	T next();
	
	/**
	 * {@inheritDoc}
	 * 
	 * <p>Intermixed calls to {@link #next()} and {@link #previous()} may not lead
	 * to the very same element since the iterator does not return the parent element
	 * when its done with its children but the next sibling of the parent.</p>
	 * 
	 * @exception NoSuchElementException iteration has no previous element.
	 */
	@Override
	T previous();
	
}
