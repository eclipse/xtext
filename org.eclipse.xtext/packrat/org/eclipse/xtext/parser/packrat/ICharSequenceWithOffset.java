/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat;

/**
 * A character sequence, that can be used as a kind of an enumerator via
 * its offset state.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ICharSequenceWithOffset extends CharSequence {

	/**
	 * Retrieves the current state of the offset property. 
	 * @return the current offset.
	 */
	int getOffset();
	
	/**
	 * Increments the offset by one.
	 */
	void incOffset();
	
	/**
	 * Increments the offset by the given amount. Can be used to decrement
	 * the offset.
	 * @param amount the number of offset that should be shifted.
	 */
	void incOffset(int amount);

	/**
	 * Random access to modify the offset. Can be set independently from the
	 * length of the char sequence.
	 * @param offset the new offset.
	 */
	void setOffset(int offset);
	
}
