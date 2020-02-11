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
 * Factory for {@link IMarker} instances.
 * {@link IMarker}s are used to store a parse state and to handle 
 * alternatives and rejoin them.
 * Subsequent calls to {@link IMarkerFactory#mark()} create kind of child
 * markers.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IMarkerFactory {

	/**
	 * Creates a new marker.
	 * @return the created marker.
	 */
	IMarker mark();
	
	/**
	 * Represents a nestable parser state
	 * @author Sebastian Zarnekow - Initial contribution and API
	 */
	interface IMarker {
		/**
		 * Discard all recorded information. Rolls
		 * the parser's state back as it was before it was marked.
		 * The marker cannot be used any longer after a rollback.
		 */
		void rollback();
		
		/**
		 * Commit all recorded information. You cannot use a marker
		 * any longer, if you commit it's data.
		 */
		void commit();
		
		/**
		 * Commit all recorded information. You can reuse a marker
		 * flushed marker. The flushed data cannot be rolled back
		 * by this marker.
		 */
		void flush();
		
		/**
		 * Create another marker for the very same original state of
		 * the parser. A fork can be understood as an alternative branch
		 * in the decision tree. Before you commit or flush any of the
		 * alternatives, you have to ensure that they are rejoined.
		 * Otherwise will the commit be rejected.
		 */
		IMarker fork();
		
		/**
		 * Join the forked marker and keep this one as the better one.
		 * Will discard all recorded information of the forked marker and
		 * reset the parsers state to this marker.
		 */
		IMarker join(IMarker forkedMarker);
	}
	
}
