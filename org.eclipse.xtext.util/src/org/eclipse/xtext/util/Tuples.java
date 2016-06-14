/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.util.LinkedHashMap;
import java.util.Map;

public final class Tuples {
	private Tuples(){}

	public static <A,B> Pair<A,B> pair(A a, B b) {
		return create(a,b);
	}
	public static <A,B> Pair<A,B> create(A a, B b) {
		return new Pair<A, B>(a,b);
	}

	public static <A,B,C> Triple<A,B,C> create(A a, B b, C c) {
		return new Triple<A, B, C>(a,b,c);
	}

	public static <A,B> Map<A,B> toMap(Pair<A,B>...pairs) {
		Map<A, B> result = new LinkedHashMap<A, B>();
		for (Pair<A,B> pair : pairs) {
			result.put(pair.getFirst(), pair.getSecond());
		}
		return result;
	}

}
