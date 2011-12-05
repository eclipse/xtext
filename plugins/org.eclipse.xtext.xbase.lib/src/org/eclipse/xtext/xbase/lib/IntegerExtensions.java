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
	 * The bitwise inclusive <code>or</code> operation. This is the equivalent to the java <code>|</code> operator.
	 * 
	 * @param a
	 *            an integer.
	 * @param b
	 *            an integer.
	 * @return <code>a|b</code>
	 */
	public static int bitwiseOr(int a, int b) {
		return a | b;
	}

	/**
	 * The bitwise inclusive <code>or</code> operation. This is the equivalent to the java <code>|</code> operator.
	 * 
	 * @param a
	 *            an integer. May not be <code>null</code>.
	 * @param b
	 *            a number. May not be <code>null</code>.
	 * @return <code>a|b</code>
	 * @throws NullPointerException
	 *             if {@code a} or {@code b} is <code>null</code>.
	 */
	public static int bitwiseOr(Integer a, Number b) {
		return a | b.intValue();
	}
	
	/**
	 * The bitwise exclusive <code>or</code> operation. This is the equivalent to the java <code>^</code> operator.
	 * 
	 * @param a
	 *            an integer.
	 * @param b
	 *            an integer.
	 * @return <code>a^b</code>
	 */
	public static int bitwiseXor(int a, int b) {
		return a ^ b;
	}

	/**
	 * The bitwise exclusive <code>or</code> operation. This is the equivalent to the java <code>^</code> operator.
	 * 
	 * @param a
	 *            an integer. May not be <code>null</code>.
	 * @param b
	 *            a number. May not be <code>null</code>.
	 * @return <code>a^b</code>
	 * @throws NullPointerException
	 *             if {@code a} or {@code b} is <code>null</code>.
	 */
	public static int bitwiseXor(Integer a, Number b) {
		return a ^ b.intValue();
	}

	/**
	 * The bitwise <code>and</code> operation. This is the equivalent to the java <code>&</code> operator.
	 * 
	 * @param a
	 *            an integer.
	 * @param b
	 *            an integer.
	 * @return <code>a&b</code>
	 */
	public static int bitwiseAnd(int a, int b) {
		return a & b;
	}

	/**
	 * The bitwise <code>and</code> operation. This is the equivalent to the java <code>&</code> operator.
	 * 
	 * @param a
	 *            an integer. May not be <code>null</code>.
	 * @param b
	 *            a number. May not be <code>null</code>.
	 * @return <code>a&b</code>
	 */
	public static int bitwiseAnd(Integer a, Number b) {
		return a & b.intValue();
	}

	/**
	 * The bitwise complement operation. This is the equivalent to the java <code>~</code> operator.
	 * 
	 * @param a
	 *            an integer.
	 * @return the bitwise complement of <code>a</code>.
	 */
	public static int bitwiseNot(int a) {
		return ~a;
	}

	/**
	 * The bitwise complement operation. This is the equivalent to the java <code>~</code> operator.
	 * 
	 * @param a
	 *            an integer. May not be <code>null</code>.
	 * @return the bitwise complement of <code>a</code>.
	 * @throws NullPointerException
	 *             if {@code a} is <code>null</code>.
	 */
	public static int bitwiseNot(Integer a) {
		return ~a;
	}

	/**
	 * The binary <code>signed left shift</code> operator. This is the equivalent to the java <code>&lt;&lt;</code> operator.
	 * Fills in a zero as the least significant bit.
	 * 
	 * @param a
	 *            an integer.
	 * @param distance 
	 *            the number of times to shift.
	 * @return <code>a&lt;&lt;distance</code>
	 */
	public static int shiftLeft(int a, int distance) {
		return a << distance;
	}

	/**
	 * The binary <code>signed right sift</code> operator. This is the equivalent to the java <code>&gt;&gt;</code> operator.
	 * Shifts in the value of the sign bit as the leftmost bit, thus preserving the sign of the initial value.
	 * 
	 * @param a
	 *            an integer.
	 * @param distance 
	 *            the number of times to shift.
	 * @return <code>a&gt;&gt;distance</code>
	 */
	public static int shiftRight(int a, int distance) {
		return a >> distance;
	}

	/**
	 * The binary <code>unsigned right shift</code> operator. This is the equivalent to the java <code>&gt;&gt;&gt;</code> operator.
	 * Shifts in zeros into as leftmost bits, thus always yielding a positive integer.
	 * 
	 * @param a
	 *            an integer.
	 * @param distance
	 *            the number of times to shift.
	 * @return <code>a&gt;&gt;&gt;distance</code>
	 */
	public static int shiftRightUnsigned(int a, int distance) {
		return a >>> distance;
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
