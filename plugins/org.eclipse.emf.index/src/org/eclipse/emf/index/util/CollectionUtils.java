package org.eclipse.emf.index.util;

import java.util.ArrayList;
import java.util.Collection;

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

}
