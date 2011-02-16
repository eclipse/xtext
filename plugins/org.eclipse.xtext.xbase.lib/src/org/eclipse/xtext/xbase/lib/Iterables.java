/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Iterables {

	/**
	 * @return the first element from the iterable for which the given predicate returns <code>true</code>, returns null
	 *         if no element matches the predicate or the iterable is empty.
	 */
	// TODO in order to allow the following use case, the extension should look like
//	public static <T> T find(Iterable<T> iterable, Functions.Function1<? super T, Boolean> predicate) {
	// Predicate<Object> notNull = Predicates.notNull();
	// Iterable<String> strings = ..
	// String s = find(strings, notNull);
	public static <T> T find(Iterable<? extends T> iterable, Functions.Function1<T, Boolean> predicate) {
		for (T t : iterable) {
			if (predicate.apply(t))
				return t;
		}
		return null;
	}
}
