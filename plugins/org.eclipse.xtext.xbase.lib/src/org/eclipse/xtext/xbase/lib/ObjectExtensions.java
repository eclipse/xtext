/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ObjectExtensions {
	
	public static boolean _operator_notEquals(Object a, Object b) {
		return !_operator_equals(a, b);
	}
	
	public static boolean _operator_equals(Object a, Object b) {
		if (a==b)
			return true;
		if (a==null)
			return false;
		return a.equals(b);
	}
	
	public static <T> Set<T> asSingletonSet(T value) {
		return Collections.singleton(value);
	}
	
	public static <T> List<T> asSingletonList(T value) {
		return Collections.singletonList(value);
	}
	
	public static <K, V> Map<K, V> asSingletonMap(K key, Functions.Function1<? super K, V> computation) {
		return Collections.singletonMap(key, computation.apply(key));
	}
	
}
