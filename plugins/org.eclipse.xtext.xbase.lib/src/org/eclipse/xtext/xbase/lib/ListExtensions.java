/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.internal.FunctionDelegate;
import org.eclipse.xtext.xbase.lib.internal.KeyComparator;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Lists;

/**
 * This is an extension library for {@link List lists}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
/* To be discussed:
 * List#binarySearch(Comparator<T>)
 * List#binarySearchBy(T->Comparable<?>)
 * List#reverseView should return a list and not an iterable
 * List#tail -> List
 * List#take -> List
 * List#drop -> List
 */
@GwtCompatible public class ListExtensions {

	/**
	 * Sorts the specified list itself into ascending order, according to the natural ordering of its elements.
	 * 
	 * @param list
	 *            the list to be sorted. May not be <code>null</code>.
	 * @return the sorted list itself.
	 * @see Collections#sort(List)
	 */
	public static <T extends Comparable<? super T>> List<T> sortInplace(List<T> list) {
		Collections.sort(list);
		return list;
	}

	/**
	 * Sorts the specified list itself according to the order induced by the specified comparator.
	 * 
	 * @param list
	 *            the list to be sorted. May not be <code>null</code>.
	 * @param comparator
	 *            the comparator to be used. May be <code>null</code> to indicate that the natural ordering of the
	 *            elements should be used.
	 * @return the sorted list itself.
	 * @see Collections#sort(List, Comparator)
	 * @see #sortInplace(List)
	 * @see #sortInplaceBy(List, org.eclipse.xtext.xbase.lib.Functions.Function1)
	 */
	public static <T> List<T> sortInplace(List<T> list, Comparator<? super T> comparator) {
		Collections.sort(list, comparator);
		return list;
	}

	/**
	 * Sorts the specified list itself according to the order induced by applying a key function to each element which
	 * yields a comparable criteria.
	 * 
	 * @param list
	 *            the list to be sorted. May not be <code>null</code>.
	 * @param key
	 *            the key function to-be-used. May not be <code>null</code>.
	 * @return the sorted list itself.
	 * @see Collections#sort(List)
	 */
	public static <T, C extends Comparable<? super C>> List<T> sortInplaceBy(List<T> list,
			final Functions.Function1<? super T, C> key) {
		if (key == null)
			throw new NullPointerException("key");
		Collections.sort(list, new KeyComparator<T, C>(key));
		return list;
	}

	/**
	 * Provides a reverse view on the given list which is especially useful to traverse a list backwards in a for-each
	 * loop. The list itself is not modified by calling this method.
	 * 
	 * @param list
	 *            the list whose elements should be traversed in reverse. May not be <code>null</code>.
	 * @return a list with the same elements as the given list, in reverse
	 */
	@Pure
	public static <T> List<T> reverseView(List<T> list) {
		return Lists.reverse(list);
	}

	/**
	 * Reverses the order of the elements in the specified list. The list itself will be modified.
	 * 
	 * @param list
	 *            the list whose elements are to be reversed.
	 * @return the list itself
	 * @throws UnsupportedOperationException
	 *             if the specified list or its list-iterator does not support the <tt>set</tt> method.
	 */
	public static <T> List<T> reverse(List<T> list) {
		Collections.reverse(list);
		return list;
	}

	/**
	 * Returns a list that performs the given {@code transformation} for each element of {@code original} when
	 * requested. The mapping is done lazily. That is, subsequent iterations of the elements in the list will
	 * repeatedly apply the transformation. The returned list is a transformed view of {@code original}; changes to
	 * {@code original} will be reflected in the returned list and vice versa (e.g. invocations of {@link List#remove(int)}).
	 * 
	 * 
	 * @param original
	 *            the original list. May not be <code>null</code>.
	 * @param transformation
	 *            the transformation. May not be <code>null</code>.
	 * @return a list that effectively contains the results of the transformation. Never <code>null</code>.
	 */
	@Pure
	public static <T, R> List<R> map(List<T> original, Function1<? super T, ? extends R> transformation) {
		return Lists.transform(original, new FunctionDelegate<T, R>(transformation));
	}

}
