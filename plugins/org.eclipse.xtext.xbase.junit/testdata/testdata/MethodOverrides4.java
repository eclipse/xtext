/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package testdata;

import java.util.List;
import java.util.Map;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.4
 */
public class MethodOverrides4 extends MethodOverrides3<List<String>> {
	@Override
	public <T extends CharSequence> String m1(T t) {
		return "m1(t)";
	}

	@Override
	public <T extends Iterable<CharSequence>> String m2(T t) {
		return "m2(t)";
	}

	@Override
	public String m3(CharSequence t) {
		return "m3(t)";
	}

	@Override
	public String m4(@SuppressWarnings("rawtypes") Iterable t) {
		return "m4(t)";
	}

	@Override
	public String m5(List<String> m5) {
		return "";
	}

	@Override
	<T1 extends CharSequence> void m6() {
	}

	@Override
	<T1 extends Comparable<T1>, V1 extends T1, K1 extends List<V1>> void m7(T1[] p1, List<? super V1[]> p2, Comparable<? extends K1> p3, Map<List<String>, Iterable<List<String>>> p4) {
	}
	
	@Override
	<T1 extends Comparable<T1>, V1 extends T1, K1 extends List<V1>> void m7() {
	}

	@Override
	<T extends Object & Cloneable & CharSequence, E extends Enum<? super E>> void m8() {
	}
	
	@Override
	<T extends List<String>> void m9() {
	}
}
