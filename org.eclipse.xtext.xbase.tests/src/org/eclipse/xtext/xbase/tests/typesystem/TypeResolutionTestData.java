/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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

	public interface NestedList<T> extends List<List<T>> {}

	public static <T> List<T> fixedToList(Iterable<T> iter) { return null; }
	public static <T> List<T> brokenToList(Iterable<? extends T> iter) { return null; }
	public static <T> List<T> brokenToList2(Iterable<? super T> iter) { return null; }
	
	public static <T> void copyIntoList(Iterable<T> from, List<? super T> to) {}
	public static <T extends Serializable> void constrainedCopyIntoList(Iterable<T> from, List<? super T> to) {}
	public static <T> List<T> copyAndReturnAsList(Iterable<T> from, List<? super T> to) { return null; }
	public static <T extends Serializable> List<T> constrainedCopyAndReturnAsList(Iterable<T> from, List<? super T> to) { return null; }
	
	public static <T, R> Iterable<R> copyIntoMap(Iterable<T> from, Map<? super T, ? extends R> to) { return null; }
	public static <T, R extends T> Iterable<R> constrainedCopyIntoMap(Iterable<T> from, Map<? super T, ? extends R> to) { return null; }
	public static <T, R extends CharSequence & Serializable> Iterable<R> constrainedCopyIntoMap2(Iterable<T> from, Map<? super T, ? extends R> to) { return null; }

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
	
	public interface ListFunction1<T, R> {
		List<R> apply(List<T> in);
	}
	
	public interface ListFunction2<T, R> {
		List<R> apply(List<? super T> in);
	}
	
	public interface ListFunction3<T, R> {
		List<R> apply(List<? extends T> in);
	}
	
	public interface ListFunction4<T, R> {
		List<? extends R> apply(List<T> in);
	}
	
	public interface ListFunction5<T, R> {
		List<? super R> apply(List<T> in);
	}
	
}
