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
 */
public class IntegerExtensions {

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

		public IntIterator(int start, int upTo) {
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

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

}
