/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package testdata;

import java.util.Collection;
import java.util.List;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("unused")
public class OverloadedMethods<V> {

	public int usedConstructor = 0; 
	
	public OverloadedMethods() {
	}
	
	public OverloadedMethods(Collection<V> collection, Iterable<? extends V> iterable) {
		usedConstructor = 1;
	}
	
	public OverloadedMethods(Iterable<? extends V> iterable, Collection<V> collection) {
		usedConstructor = 2;
	}
	
	public OverloadedMethods(List<V> list, List<V> otherList) {
		usedConstructor = 3;
	}
	
	public OverloadedMethods(Iterable<? extends V> iterable, Iterable<? extends V> otherIterable) {
		usedConstructor = 4;
	}
	
	public String overloadedInt(int i) {
		return "overloadedInt(int)";
	}
	
	public String overloadedInt(Integer i) {
		return "overloadedInt(Integer)";
	}
	
	public <T> String overloaded(Collection<T> collection, Iterable<? extends T> iterable) {
		return "overloaded(Collection,Iterable)";
	}
	
	public <T> String overloaded(Iterable<? extends T> iterable, Collection<T> collection) {
		return "overloaded(Iterable,Collection)";
	}
	
	public <T> String overloaded(List<T> list, List<T> otherList) {
		return "overloaded(List,List)";
	}
	
	/**
	 * @since 2.4
	 */
	public <T> String overloaded(Object object, Object otherObject) {
		return "overloaded(Object,Object)";
	}
	
	public <T> String overloaded(Iterable<? extends T> iterable, Iterable<? extends T> otherIterable) {
		return "overloaded(Iterable,Iterable)";
	}
	
	public String overloaded2(Collection<V> collection, Iterable<? extends V> iterable) {
		return "overloaded2(Collection,Iterable)";
	}
	
	public String overloaded2(Iterable<? extends V> iterable, Collection<V> collection) {
		return "overloaded2(Iterable,Collection)";
	}
	
	public String overloaded2(List<V> list, List<V> otherList) {
		return "overloaded2(List,List)";
	}
	
	public String overloaded2(Iterable<? extends V> iterable, Iterable<? extends V> otherIterable) {
		return "overloaded2(Iterable,Iterable)";
	}
	
	public <T> String overloaded3(List<T> list, List<T> otherList) {
		return "overloaded(List,List)";
	}
	
	/**
	 * @since 2.3
	 */
	public static <T1> int overloadedTypeParameters(String s) { return 1; }
	/**
	 * @since 2.3
	 */
	public static <T1, T2> long overloadedTypeParameters(Object o) { return 1L; }
	
	/**
	 * @since 2.3
	 */
	public static long overloadedVarArgs(Object o1, Object o2) { return 1L; }

	/**
	 * @since 2.3
	 */
	public static int overloadedVarArgs(String... s) { return s.length; }
	
	/**
	 * @since 2.4
	 */
	public static <K> String addAllOverloaded(Collection<? super K> collection, Iterable<K> elements) {
		return OverloadedMethods.addAllExtends(collection, elements);
	}
	
	/**
	 * @since 2.4
	 */
	public static <K> String addAllOverloaded(Iterable<K> elements, Collection<? super K> collection) {
		return addAllExtends(collection, elements);
	}
	
	/**
	 * @since 2.4
	 */
	public static <K> boolean addAllOverloaded(Collection<? super K> collection, Collection<K> elements) {
		return collection.addAll(elements);
	}
	
	/**
	 * @since 2.4
	 */
	public static <K> String addAllSuperExtends(Collection<? super K> collection, Iterable<? extends K> elements) {
		return OverloadedMethods.addAllExtends(collection, elements);
	}
	
	/**
	 * @since 2.4
	 */
	public static <K> Collection<K> addAllSuperExtends2(Collection<? super K> collection, Iterable<? extends K> elements) {
		return null;
	}
	
	private static  <T> String addAllExtends(Collection<T> collection, Iterable<? extends T> elements) {
		return "addAll(Collection,Iterable)";
	}
	
}
