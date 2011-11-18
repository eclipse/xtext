/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import java.util.Iterator;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class IteratorExtensions {

	/**
	 * Wraps an {@link Iterator} in an {@link Iterable}.
	 * @param iterator - the {@link Iterator} to wrap in an {@link Iterable}
	 * @return an {@link Iterable} providing the given {@link Iterator}
	 */
	public static <T> Iterable<T> toIterable(final Iterator<T> iterator) {
		return new Iterable<T>() {
			public Iterator<T> iterator() {
				return iterator;
			}
		};
	}
}
