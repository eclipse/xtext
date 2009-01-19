/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
	 * @param amount
	 */
	void incOffset(int amount);

	/**
	 * Random access to modify the offset. Can be set independently from the
	 * length of the char sequence.
	 * @param offset
	 */
	void setOffset(int offset);
	
}
