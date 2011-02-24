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
import org.eclipse.xtext.xbase.lib.IterableExtensions.FunctionDelegate;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * To be discussed:
 * List#binarySearch(Comparator<T>)
 * List#binarySearchBy(T->Comparable<?>)
 * List#reverseView should return a list and not an iterable
 * List#tail -> List
 * List#take -> List
 * List#drop -> List
 */
public class ListExtensions {

	public static <T extends Comparable<? super T>> List<T> sort(List<T> list) {
		Collections.sort(list);
		return list;
	}
	
	public static <T> List<T> sort(List<T> list, Comparator<? super T> comparator) {
		Collections.sort(list, comparator);
		return list;
	}
	
	public static <T, C extends Comparable<? super C>> List<T> sortBy(List<T> list, final Functions.Function1<T, C> key) {
		Comparator<T> comparator = new Comparator<T>() {
			public int compare(T o1, T o2) {
				C left = key.apply(o1);
				C right = key.apply(o2);
				return left.compareTo(right);
			}
		};
		Collections.sort(list, comparator);
		return list;
	}
	
	public static <T> Iterable<T> reverseView(List<T> list) {
		return Iterables.reverse(list);
	}
	
	public static <T> List<T> reverse(List<T> list) {
		Collections.reverse(list);
		return list;
	}
	
	public static final <T, R> List<R> map(List<T> list, Function1<? super T, R> transformation) {
		return Lists.transform(list, new FunctionDelegate<T, R>(transformation));
	}
	
}
