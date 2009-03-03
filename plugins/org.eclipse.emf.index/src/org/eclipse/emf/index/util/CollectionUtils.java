/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class CollectionUtils {

	public static <T> Collection<T> copyOrNull(Collection<T> source) {
		if(source == null) return null;
		return new ArrayList<T>(source); 
	}
	
	public static <T> Collection<T> addIfNotNull(Collection<T> c, T element) {
		if (element != null)
			c.add(element);
		return c;
	}

	public static <T> Collection<T> addAllIfNotNull(Collection<T> c, Collection<T> elements) {
		if (elements != null)
			c.addAll(elements);
		return c;
	}

	public static <T> Collection<T> union(Collection<T> a, Collection<T> b) {
		if (a == null) {
			if (b == null) {
				return null;
			}
			return b;
		}
		return addAllIfNotNull(a, b);
	}

	public static <T> boolean isNotEmpty(Collection<T> c) {
		return c != null && !c.isEmpty();
	}

	public static <T> boolean isEmpty(Collection<T> c) {
		return c == null || c.isEmpty();
	}

	public static <T,U> boolean equalsNullSafe(Map<T,U> one, Map<T,U> two) {
		if(one == null && two == null) 
			return true;
		if(one==null || two==null) 
			return false;
		return one.equals(two);
	}
	
	public static <T> T findEquivalent(List<T> list, T object) {
		int index = list.indexOf(object);
		return (index<0) ? null : list.get(index); 
	}
	
}
