/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package testdata;

import java.util.List;
import java.util.Map;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.4
 */
@SuppressWarnings("unused")
public class MethodOverrides3<V extends Iterable<String>> {
	public <T extends CharSequence> String m1(T t) {
		return "m1(t)";
	}

	public <T extends Iterable<CharSequence>> String m2(T t) {
		return "m2(t)";
	}

	public <T extends CharSequence> T m3(T t) {
		return t;
	}

	public <T extends Iterable<CharSequence>> T m4(T t) {
		return t;
	}

	public String m5(V v) {
		return "m5(t)";
	}

	<T extends CharSequence> void m6() {
	}

	<T extends Comparable<T>, Y extends T, K extends List<Y>> void m7(T[] p1, List<? super Y[]> p2, Comparable<? extends K> p3, Map<V, Iterable<V>> p4) {
	}
	<T extends Comparable<T>, Y extends T, K extends List<Y>> void m7() {
	}

	<T extends Object & CharSequence & Cloneable, Y extends Enum<? super Y>> void m8() {
	}
	
	<T extends V> void m9() {
	}

	private <T extends CharSequence> String privateM1(T t) {
		return "m1(t)";
	}
	
	public <T> String m10(Iterable<String> t, Iterable<String> it) {
		return "m4(t)";
	}
	
	public static <T extends CharSequence> String staticM1(T t) {
		return "m1(t)";
	}
	
	public static <T extends Iterable<CharSequence>> String staticM2(T t) {
		return "m2(t)";
	}

	public static <T extends CharSequence> String staticM3(T t) {
		return "m3(t)";
	}

	public static <T extends Iterable<CharSequence>> String staticM4(T t) {
		return "m4(t)";
	}
	
	public static <T extends CharSequence> Iterable<T> staticM5() {
		return null;
	}
	
	private void withVarArgs(String... s) {}
	private void withArray(String[] s) {}
	
	private void sameErasure1(Iterable<String> iterable) {}
	private <T extends Number> void sameErasure2(Iterable<T> iterable) {}
	private <T, K> void sameErasure3() {}
	
}
