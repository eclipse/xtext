/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package testdata;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.4
 */
@SuppressWarnings("unused")
public class MethodOverrides4 extends MethodOverrides3<List<String>> {
	@Override
	public <T extends CharSequence> String m1(T t) {
		return "m1(t)";
	}

	@Override
	public <T extends Iterable<CharSequence>> String m2(T t) {
		return "m2(t)";
	}

	@SuppressWarnings("unchecked")
	@Override
	public String m3(CharSequence t) {
		return "m3(t)";
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> m4(@SuppressWarnings("rawtypes") Iterable t) {
		return null;
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
	
	protected <T extends CharSequence> String privateM1(CharSequence t) {
		return "m1(t)";
	}
	
	@Override
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
	//FIXME
	public static <T extends Serializable> Iterable<T> staticM5(T t) {
		return null;
	}
	
	private void withVarArgs(String[] s) {}
	private void withArray(String... s) {}
	
	private <T extends Iterable<CharSequence>> void sameErasure1(T iterable) {}
	private <T extends CharSequence> void sameErasure2(Iterable<T> iterable) {}
	private <T, V extends T> void sameErasure3() {}
}
