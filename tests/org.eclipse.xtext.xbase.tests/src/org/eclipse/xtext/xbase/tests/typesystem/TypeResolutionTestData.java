/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @TODO move to TypeResolutionStateTest
 */
public class TypeResolutionTestData {

	interface NestedList<T> extends List<List<T>> {}

	static <T> List<T> fixedToList(Iterable<T> iter) { return null; }
	static <T> List<T> brokenToList(Iterable<? extends T> iter) { return null; }
	static <T> List<T> brokenToList2(Iterable<? super T> iter) { return null; }
	
	static <T> void copyIntoList(Iterable<T> from, List<? super T> to) {}
	static <T extends Serializable> void constrainedCopyIntoList(Iterable<T> from, List<? super T> to) {}
	static <T> List<T> copyAndReturnAsList(Iterable<T> from, List<? super T> to) { return null; }
	static <T extends Serializable> List<T> constrainedCopyAndReturnAsList(Iterable<T> from, List<? super T> to) { return null; }
	
	static <T, R> Iterable<R> copyIntoMap(Iterable<T> from, Map<? super T, ? extends R> to) { return null; }
	static <T, R extends T> Iterable<R> constrainedCopyIntoMap(Iterable<T> from, Map<? super T, ? extends R> to) { return null; }
	static <T, R extends CharSequence & Serializable> Iterable<R> constrainedCopyIntoMap2(Iterable<T> from, Map<? super T, ? extends R> to) { return null; }

	public static int overloaded(List<? extends CharSequence> list, Object o) {
		return 1;
	}
	public static long overloaded(List<CharSequence> list, String s) {
		return 1;
	}
	public static <T> int overloadedWithTypeParam(List<? extends T> list, Object o) {
		return 1;
	}
	public static <T> long overloadedWithTypeParam(List<T> list, String s) {
		return 1;
	}
	
	interface ListFunction1<T, R> {
		List<R> apply(List<T> in);
	}
	
	interface ListFunction2<T, R> {
		List<R> apply(List<? super T> in);
	}
	
	interface ListFunction3<T, R> {
		List<R> apply(List<? extends T> in);
	}
	
	interface ListFunction4<T, R> {
		List<? extends R> apply(List<T> in);
	}
	
	interface ListFunction5<T, R> {
		List<? super R> apply(List<T> in);
	}
	
}
