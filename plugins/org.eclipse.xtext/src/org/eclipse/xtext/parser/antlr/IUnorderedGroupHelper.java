/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import org.eclipse.xtext.UnorderedGroup;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(IUnorderedGroupHelper.Null.class)
public interface IUnorderedGroupHelper {

	/**
	 * Invoke when the group is entered in the parser. Access to any other querying 
	 * method is answered optimistically.
	 */
	void enter(UnorderedGroup group);

	/**
	 * Leave the group. May not be called before enter.
	 */
	void leave(UnorderedGroup group);

	/**
	 * Predicate to answer the question whether the given
	 * alternative may be used. 
	 */
	boolean canSelect(UnorderedGroup group, int index);

	/**
	 * Announce the usage of the given alternative.
	 */
	void select(UnorderedGroup group, int index);

	/**
	 * Finish the previously selected alternative.
	 */
	void returnFromSelection(UnorderedGroup group);

	/**
	 * Query for remaining mandatory alternatives.
	 */
	boolean canLeave(UnorderedGroup group);

	public static class Null implements IUnorderedGroupHelper {

		public void enter(UnorderedGroup group) {
			throw new UnsupportedOperationException();
		}

		public void leave(UnorderedGroup group) {
			throw new UnsupportedOperationException();
		}

		public boolean canSelect(UnorderedGroup group, int index) {
			throw new UnsupportedOperationException();
		}

		public void select(UnorderedGroup group, int index) {
			throw new UnsupportedOperationException();
		}

		public void returnFromSelection(UnorderedGroup group) {
			throw new UnsupportedOperationException();
		}

		public boolean canLeave(UnorderedGroup group) {
			throw new UnsupportedOperationException();
		}
		
	}
}