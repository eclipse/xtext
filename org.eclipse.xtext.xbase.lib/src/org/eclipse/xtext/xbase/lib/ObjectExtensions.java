/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import java.util.Objects;

import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.common.annotations.GwtCompatible;

/**
 * This is an extension library for all {@link Object objects}.
 */
@GwtCompatible public class ObjectExtensions {

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
	@Pure
	@Inline(value="(!$3.equals($1, $2))", imported=Objects.class)
	public static boolean operator_notEquals(Object a, Object b) {
		return !Objects.equals(a, b);
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
	@Pure
	@Inline(value="$3.equals($1, $2)", imported=Objects.class)
	public static boolean operator_equals(Object a, Object b) {
		return Objects.equals(a, b);
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
	@Pure
	@Inline(value = "($1 == $2)", constantExpression = true)
	public static boolean identityEquals(Object a, Object b) {
		return a == b;
	}

	/**
	 * The <code>identity equals</code> operator. This is the equivalent to Java's <code>==</code>
	 * operator.
	 * 
	 * @param a
	 *            an object.
	 * @param b
	 *            another object.
	 * @return Java's <code>a == b</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value = "($1 == $2)", constantExpression = true)
	public static boolean operator_tripleEquals(Object a, Object b) {
		return a == b;
	}
	
	/**
	 * The <code>identity not equals</code> operator. This is the equivalent to Java's <code>!=</code>
	 * operator.
	 * 
	 * @param a
	 *            an object.
	 * @param b
	 *            another object.
	 * @return Java's <code>a != b</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value = "($1 != $2)", constantExpression = true)
	public static boolean operator_tripleNotEquals(Object a, Object b) {
		return a != b;
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
	@Pure
	@Inline(value="$3.$4of($1, $2)", imported=Pair.class)
	public static <A, B> Pair<A, B> operator_mappedTo(A a, B b) {
		return Pair.of(a, b);
	}
	
	/**
	 * The <code>doubleArrow</code> operator is used as a 'with'- or 'let'-operation.
	 * It allows to bind an object to a local scope in order to do something on it.
	 * 
	 * Example:
	 * <code>
	 *   new Person =&gt; [
	 *     firstName = 'Han'
	 *     lastName = 'Solo'
	 *   ]
	 * </code>
	 * 
	 * @param object
	 *            an object. Can be <code>null</code>.
	 * @param block
	 *            the block to execute with the given object. Must not be <code>null</code>.
	 * @return the reference to object.
	 * @since 2.3
	 */
	public static <T> T operator_doubleArrow(T object, Procedure1<? super T> block) {
		block.apply(object);
		return object;
	}
	
	/**
	 * The binary <code>+</code> operator that concatenates two strings.
	 * 
	 * @param a
	 *            an {@link Object}.
	 * @param b
	 *            a {@link String}.
	 * @return <code>a + b</code>
	 * @since 2.3
	 */
	@Pure /* not guaranteed pure , since toString() is invoked on the argument a*/
	@Inline("($1 + $2)")
	public static String operator_plus(Object a, String b) {
		return a + b;
	}
	
	/**
	 * The elvis operator <code>?:</code> is a short hand notation for
	 * providing default value in case an expression evaluates to <code>null</code>.
	 * 
	 * Not that the Xtend compiler will inline calls to this not call this method with a short-circuit semantic.
	 * That is the second argument is only evaluated if the first one evaluates to <code>null</code>.
	 * 
	 * Example:
	 * <code>person.name?:'Hans'</code>
	 * 
	 * @param first
	 *            an {@link Object}. Might be <code>null</code>.
	 * @param second
	 *            an {@link Object}. Might be <code>null</code>.
	 * 
	 * @return a reference to <code>first</code> if <code>first != null </code>, <code>second<code> otherwise, 
	 * @since 2.3
	 */
	@Pure
	public static <T> T operator_elvis(T first, T second) {
		if (first != null)
			return first;
		return second;
	}
	
	
}
