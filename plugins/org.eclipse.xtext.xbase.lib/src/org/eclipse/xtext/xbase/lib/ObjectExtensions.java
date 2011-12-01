/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

/**
 * This is an extension library for all {@link Object objects}.
 */
public class ObjectExtensions {

	/**
	 * The <code>equals not</code> operator. This is the equivalent to a negated, null-safe
	 * {@link Object#equals(Object)} method.
	 * 
	 * @param a
	 *            an object.
	 * @param b
	 *            another object.
	 * @return <code>true</code> if {@code a} and {@code b} are not equal.
	 */
	public static boolean operator_notEquals(Object a, Object b) {
		return !operator_equals(a, b);
	}

	/**
	 * The <code>equals</code> operator. This is the equivalent to a null-safe invocation of
	 * {@link Object#equals(Object)}.
	 * 
	 * @param a
	 *            an object.
	 * @param b
	 *            another object.
	 * @return <code>true</code> if {@code a} and {@code b} are equal.
	 */
	public static boolean operator_equals(Object a, Object b) {
		if (a == b)
			return true;
		if (a == null)
			return false;
		return a.equals(b);
	}
	
	/**
	 * Returns <code>true</code> if {@code a} and {@code b} are identical (the same instance)
	 * or both <code>null</code>. This is the equivalent to Java's <code>==</code>
	 * operator.
	 * 
	 * @param a
	 *            an object.
	 * @param b
	 *            another object.
	 * @return Java's <code>a == b</code>
	 */
	public static boolean identityEquals(Object a, Object b) {
		return a == b;
	}

	/**
	 * The <code>mappedTo</code> operator yields a {@link Pair} with {@code a} as the {@link Pair#getKey() key} and
	 * {@code b} as its {@link Pair#getValue() value}.
	 * 
	 * @param a
	 *            an object.
	 * @param b
	 *            another object.
	 * @return a {@link Pair}. Never <code>null</code>.
	 */
	public static <A, B> Pair<A, B> operator_mappedTo(A a, B b) {
		return new Pair<A, B>(a, b);
	}

}
