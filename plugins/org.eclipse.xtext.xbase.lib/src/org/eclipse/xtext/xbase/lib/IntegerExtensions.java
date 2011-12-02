/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import java.util.Iterator;

/**
 * This is an extension library for {@link Integer integral numbers}, e.g. <code>int</code> or <code>Integer</code>.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein - Primitive versions
 */
public class IntegerExtensions {

	/**
	 * The unary <code>minus</code> operator. This is the equivalent to the unary java <code>-</code> operator.
	 * 
	 * @param a
	 *            an integer.
	 * @return <code>-a</code>
	 */
	public static int operator_minus(int a) {
		return -a;
	}

	/**
	 * The unary <code>minus</code> operator. This is the equivalent to the unary java <code>-</code> operator.
	 * 
	 * @param a
	 *            an integer. May not be <code>null</code>.
	 * @return <code>-a</code>
	 * @throws NullPointerException
	 *             if {@code a} is <code>null</code>.
	 */
	public static int operator_minus(Integer a) {
		return -a;
	}

	/**
	 * The binary <code>plus</code> operator. This is the equivalent to the java <code>+</code> operator.
	 * 
	 * @param a
	 *            an integer.
	 * @param b
	 *            an integer.
	 * @return <code>a+b</code>
	 */
	public static int operator_plus(int a, int b) {
		return a + b;
	}

	/**
	 * The binary <code>plus</code> operator. This is the equivalent to the java <code>+</code> operator.
	 * 
	 * @param a
	 *            an integer. May not be <code>null</code>.
	 * @param b
	 *            a number. May not be <code>null</code>.
	 * @return <code>a+b</code>
	 * @throws NullPointerException
	 *             if {@code a} or {@code b} is <code>null</code>.
	 */
	public static int operator_plus(Integer a, Number b) {
		return a + b.intValue();
	}

	/**
	 * The binary <code>minus</code> operator. This is the equivalent to the java <code>-</code> operator.
	 * 
	 * @param a
	 *            an integer.
	 * @param b
	 *            an integer.
	 * @return <code>a-b</code>
	 */
	public static int operator_minus(int a, int b) {
		return a - b;
	}

	/**
	 * The binary <code>minus</code> operator. This is the equivalent to the java <code>-</code> operator.
	 * 
	 * @param a
	 *            an integer. May not be <code>null</code>.
	 * @param b
	 *            a number. May not be <code>null</code>.
	 * @return <code>a-b</code>
	 * @throws NullPointerException
	 *             if {@code a} or {@code b} is <code>null</code>.
	 */
	public static int operator_minus(Integer a, Number b) {
		return a - b.intValue();
	}

	/**
	 * The <code>power</code> operator.
	 * 
	 * @param a
	 *            an integer.
	 * @param b
	 *            an integer.
	 * @return <code>a ** b</code>
	 */
	public static int operator_power(int a, int b) {
		return (int) Math.pow(a, b);
	}

	/**
	 * The <code>power</code> operator.
	 * 
	 * @param a
	 *            an integer. May not be <code>null</code>.
	 * @param b
	 *            a number. May not be <code>null</code>.
	 * @return <code>a ** b</code>
	 * @throws NullPointerException
	 *             if {@code a} or {@code b} is <code>null</code>.
	 */
	public static int operator_power(Integer a, Number b) {
		return (int) Math.pow(a, b.intValue());
	}

	/**
	 * The binary <code>times</code> operator. This is the equivalent to the java <code>*</code> operator.
	 * 
	 * @param a
	 *            an integer.
	 * @param b
	 *            an integer.
	 * @return <code>a*b</code>
	 */
	public static int operator_multiply(int a, int b) {
		return a * b;
	}

	/**
	 * The binary <code>times</code> operator. This is the equivalent to the java <code>*</code> operator.
	 * 
	 * @param a
	 *            an integer. May not be <code>null</code>.
	 * @param b
	 *            a number. May not be <code>null</code>.
	 * @return <code>a*b</code>
	 * @throws NullPointerException
	 *             if {@code a} or {@code b} is <code>null</code>.
	 */
	public static int operator_multiply(Integer a, Number b) {
		return a * b.intValue();
	}

	/**
	 * The binary <code>divide</code> operator. This is the equivalent to the java <code>/</code> operator. That is, the
	 * result will be the integral result of the division, e.g. <code>operator_divide(1, 2)</code> yields <code>0</code>
	 * .
	 * 
	 * @param a
	 *            an integer.
	 * @param b
	 *            an integer.
	 * @return <code>a/b</code>
	 */
	public static int operator_divide(int a, int b) {
		return a / b;
	}

	/**
	 * The binary <code>divide</code> operator. This is the equivalent to the java <code>/</code> operator. That is, the
	 * result will be the integral result of the division, e.g. <code>operator_divide(1, 2)</code> yields <code>0</code>
	 * .
	 * 
	 * @param a
	 *            an integer. May not be <code>null</code>.
	 * @param b
	 *            a number. May not be <code>null</code>.
	 * @return <code>a/b</code>
	 * @throws NullPointerException
	 *             if {@code a} or {@code b} is <code>null</code>.
	 */
	public static int operator_divide(Integer a, Number b) {
		return a / b.intValue();
	}

	/**
	 * The binary <code>modulo</code> operator. This is the equivalent to the java <code>%</code> operator.
	 * 
	 * @param a
	 *            an integer.
	 * @param b
	 *            an integer.
	 * @return <code>a%b</code>
	 */
	public static int operator_modulo(int a, int b) {
		return a % b;
	}

	/**
	 * The binary <code>modulo</code> operator. This is the equivalent to the java <code>%</code> operator.
	 * 
	 * @param a
	 *            an integer. May not be <code>null</code>.
	 * @param b
	 *            a number. May not be <code>null</code>.
	 * @return <code>a%b</code>
	 * @throws NullPointerException
	 *             if {@code a} or {@code b} is <code>null</code>.
	 */
	public static int operator_modulo(Integer a, Number b) {
		return a % b.intValue();
	}

	/**
	 * The binary <code>or</code> operator. This is the equivalent to the java <code>|</code> operator.
	 * 
	 * @param a
	 *            an integer.
	 * @param b
	 *            an integer.
	 * @return <code>a|b</code>
	 */
	public static int operator_or(int a, int b) {
		return a | b;
	}

	/**
	 * The binary <code>or</code> operator. This is the equivalent to the java <code>|</code> operator.
	 * 
	 * @param a
	 *            an integer. May not be <code>null</code>.
	 * @param b
	 *            a number. May not be <code>null</code>.
	 * @return <code>a|b</code>
	 */
	public static int operator_or(Integer a, Number b) {
		return a | b.intValue();
	}

	/**
	 * The binary <code>and</code> operator. This is the equivalent to the java <code>&</code> operator.
	 * 
	 * @param a
	 *            an integer.
	 * @param b
	 *            an integer.
	 * @return <code>a&b</code>
	 */
	public static int operator_and(int a, int b) {
		return a & b;
	}

	/**
	 * The binary <code>and</code> operator. This is the equivalent to the java <code>&</code> operator.
	 * 
	 * @param a
	 *            an integer. May not be <code>null</code>.
	 * @param b
	 *            a number. May not be <code>null</code>.
	 * @return <code>a&b</code>
	 */
	public static int operator_and(Integer a, Number b) {
		return a & b.intValue();
	}

	/**
	 * The binary <code>equals</code> operator. This is the equivalent to the java <code>==</code> operator.
	 * 
	 * @param a
	 *            an integer.
	 * @param b
	 *            an integer.
	 * @return <code>a==b</code>
	 */
	public static boolean operator_equals(int a, int b) {
		return a == b;
	}

	/**
	 * The binary <code>not equals</code> operator. This is the equivalent to the java <code>!=</code> operator.
	 * 
	 * @param a
	 *            an integer.
	 * @param b
	 *            an integer.
	 * @return <code>a!=b</code>
	 */
	public static boolean operator_notEquals(int a, int b) {
		return a != b;
	}

	/**
	 * The binary <code>less than</code> operator. This is the equivalent to the java <code>&lt;</code> operator.
	 * 
	 * @param a
	 *            an integer.
	 * @param b
	 *            an integer.
	 * @return <code>a&lt;b</code>
	 */
	public static boolean operator_lessThan(int a, int b) {
		return a < b;
	}

	/**
	 * The binary <code>less than or equals</code> operator. This is the equivalent to the java <code>&lt;=</code> operator.
	 * 
	 * @param a
	 *            an integer.
	 * @param b
	 *            an integer.
	 * @return <code>a&lt;=b</code>
	 */
	public static boolean operator_lessEqualsThan(int a, int b) {
		return a <= b;
	}

	/**
	 * The binary <code>greater than</code> operator. This is the equivalent to the java <code>&gt;</code> operator.
	 * 
	 * @param a
	 *            an integer.
	 * @param b
	 *            an integer.
	 * @return <code>a&gt;b</code>
	 */
	public static boolean operator_greaterThan(int a, int b) {
		return a > b;
	}

	/**
	 * The binary <code>greater than or equals</code> operator. This is the equivalent to the java <code>&gt;=</code> operator.
	 * 
	 * @param a
	 *            an integer.
	 * @param b
	 *            an integer.
	 * @return <code>a&gt;=b</code>
	 */
	public static boolean operator_greaterEqualsThan(int a, int b) {
		return a >= b;
	}

	/**
	 * The unary <code>not</code> operator. Inverts all bits of the given integer.
	 * 
	 * @param a
	 *            an integer.
	 * @return <code>a</code> inverted.
	 */
	public static int operator_not(int a) {
		return a ^ -1;
	}

	/**
	 * The unary <code>not</code> operator. Inverts all bits of the given integer.
	 * 
	 * @param a
	 *            an integer. May not be <code>null</code>.
	 * @return <code>a</code> inverted.
	 * @throws NullPointerException
	 *             if {@code a} is <code>null</code>.
	 */
	public static int operator_not(Integer a) {
		return a ^ -1;
	}

	/**
	 * The <code>upTo</code> operator yields an iterable of integral numbers from {@code a} up to {@code b} if {@code b}
	 * is larger than {@code a} or otherwise from {@code a} down to {@code b}.
	 * 
	 * @param a
	 *            an integer. May not be <code>null</code>.
	 * @param b
	 *            a number. May not be <code>null</code>.
	 * @return an iterable of integral numbers. Never <code>null</code>.
	 * @throws NullPointerException
	 *             if {@code a} or {@code b} is <code>null</code>.
	 */
	public static Iterable<Integer> operator_upTo(final Integer a, Number b) {
		if (a == null)
			throw new NullPointerException("a");
		final int upTo = b.intValue() + 1;
		return new Iterable<Integer>() {
			public Iterator<Integer> iterator() {
				return new IntIterator(a, upTo);
			}
		};
	}

	/**
	 * Implementation of an iterator for integers.
	 */
	protected static class IntIterator implements Iterator<Integer> {
		private int current;
		private int upTo;
		private boolean increases;

		/**
		 * Creates a new {@link IntIterator} from {@code start} to {@code upTo}. The iterator will iterator backwards if
		 * upTo is smaller than the start index.
		 * 
		 * @param start
		 *            the start value (inclusive).
		 * @param upTo
		 *            the end value (exclusive).
		 * 
		 */
		protected IntIterator(int start, int upTo) {
			super();
			this.current = start;
			this.upTo = upTo;
			this.increases = start < upTo;
		}

		public boolean hasNext() {
			if (increases)
				return current < upTo;
			else
				return current > upTo;
		}

		public Integer next() {
			if (increases)
				return current++;
			else
				return current--;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @throws UnsupportedOperationException
		 *             Always throws an {@link UnsupportedOperationException} since this iterator does not support
		 *             removal.
		 */
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

}
