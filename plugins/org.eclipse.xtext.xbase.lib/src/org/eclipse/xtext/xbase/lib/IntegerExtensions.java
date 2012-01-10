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
	 * The <code>upTo</code> operator yields an iterable of integral numbers from and including {@code a} up to and including {@code b} if {@code b}
	 * is larger than {@code a} or otherwise from {@code a} down to {@code b}. If {@code a} == {@code b} the iterable returns just one element.
	 * 
	 * @param a
	 * @param b
	 * @return an iterable of integral numbers. Never <code>null</code>.
	 */
	public static Iterable<Integer> operator_upTo(final int a, final int b) {
		return new Iterable<Integer>() {
			public Iterator<Integer> iterator() {
				return new IntIterator(a, b);
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
		 * Creates a new {@link IntIterator} from {@code start} to {@code upTo}. The iterator will iterate backwards if
		 * upTo is smaller than the start index.
		 * 
		 * @param start
		 *            the start value (inclusive).
		 * @param upTo
		 *            the end value (inclusive).
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
				return current <= upTo;
			else
				return current >= upTo;
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

	// BEGIN generated code
	/**
	 * The unary <code>minus</code> operator. This is the equivalent to the Java's <code>-</code> function.
	 * 
	 * @param a  an integer.
	 * @return   <code>-a</code>
	 */
	public static int operator_minus(int a) {
		return -a;
	}
	
	/**
	 * The binary <code>plus</code> operator. This is the equivalent to the Java <code>+</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a double.
	 * @return   <code>a+b</code>
	 */
	public static double operator_plus(int a, double b) {
		return a + b;
	}
	
	/**
	 * The binary <code>minus</code> operator. This is the equivalent to the Java <code>-</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a double.
	 * @return   <code>a-b</code>
	 */
	public static double operator_minus(int a, double b) {
		return a - b;
	}
	
	/**
	 * The binary <code>multiply</code> operator. This is the equivalent to the Java <code>*</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a double.
	 * @return   <code>a*b</code>
	 */
	public static double operator_multiply(int a, double b) {
		return a * b;
	}
	
	/**
	 * The binary <code>divide</code> operator. This is the equivalent to the Java <code>/</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a double.
	 * @return   <code>a/b</code>
	 */
	public static double operator_divide(int a, double b) {
		return a / b;
	}
	
	/**
	 * The binary <code>modulo</code> operator. This is the equivalent to the Java <code>%</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a double.
	 * @return   <code>a%b</code>
	 */
	public static double operator_modulo(int a, double b) {
		return a % b;
	}
	
	/**
	 * The binary <code>lessThan</code> operator. This is the equivalent to the Java <code>&lt;</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a double.
	 * @return   <code>a&lt;b</code>
	 */
	public static boolean operator_lessThan(int a, double b) {
		return a < b;
	}
	
	/**
	 * The binary <code>lessEqualsThan</code> operator. This is the equivalent to the Java <code>&lt;=</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a double.
	 * @return   <code>a&lt;=b</code>
	 */
	public static boolean operator_lessEqualsThan(int a, double b) {
		return a <= b;
	}
	
	/**
	 * The binary <code>greaterThan</code> operator. This is the equivalent to the Java <code>&gt;</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a double.
	 * @return   <code>a&gt;b</code>
	 */
	public static boolean operator_greaterThan(int a, double b) {
		return a > b;
	}
	
	/**
	 * The binary <code>greaterEqualsThan</code> operator. This is the equivalent to the Java <code>&gt;=</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a double.
	 * @return   <code>a&gt;=b</code>
	 */
	public static boolean operator_greaterEqualsThan(int a, double b) {
		return a >= b;
	}
	
	/**
	 * The binary <code>equals</code> operator. This is the equivalent to the Java <code>==</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a double.
	 * @return   <code>a==b</code>
	 */
	public static boolean operator_equals(int a, double b) {
		return a == b;
	}
	
	/**
	 * The binary <code>notEquals</code> operator. This is the equivalent to the Java <code>!=</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a double.
	 * @return   <code>a!=b</code>
	 */
	public static boolean operator_notEquals(int a, double b) {
		return a != b;
	}
	
	/**
	 * The binary <code>power</code> operator. This is the equivalent to the Java's <code>Math.pow()</code> function.
	 * 
	 * @param a  an integer.
	 * @param b  a double.
	 * @return   <code>Math.pow(a, b)</code>
	 */
	public static double operator_power(int a, double b) {
		return Math.pow(a, b);
	}
	
	/**
	 * The binary <code>plus</code> operator. This is the equivalent to the Java <code>+</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a float.
	 * @return   <code>a+b</code>
	 */
	public static float operator_plus(int a, float b) {
		return a + b;
	}
	
	/**
	 * The binary <code>minus</code> operator. This is the equivalent to the Java <code>-</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a float.
	 * @return   <code>a-b</code>
	 */
	public static float operator_minus(int a, float b) {
		return a - b;
	}
	
	/**
	 * The binary <code>multiply</code> operator. This is the equivalent to the Java <code>*</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a float.
	 * @return   <code>a*b</code>
	 */
	public static float operator_multiply(int a, float b) {
		return a * b;
	}
	
	/**
	 * The binary <code>divide</code> operator. This is the equivalent to the Java <code>/</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a float.
	 * @return   <code>a/b</code>
	 */
	public static float operator_divide(int a, float b) {
		return a / b;
	}
	
	/**
	 * The binary <code>modulo</code> operator. This is the equivalent to the Java <code>%</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a float.
	 * @return   <code>a%b</code>
	 */
	public static float operator_modulo(int a, float b) {
		return a % b;
	}
	
	/**
	 * The binary <code>lessThan</code> operator. This is the equivalent to the Java <code>&lt;</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a float.
	 * @return   <code>a&lt;b</code>
	 */
	public static boolean operator_lessThan(int a, float b) {
		return a < b;
	}
	
	/**
	 * The binary <code>lessEqualsThan</code> operator. This is the equivalent to the Java <code>&lt;=</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a float.
	 * @return   <code>a&lt;=b</code>
	 */
	public static boolean operator_lessEqualsThan(int a, float b) {
		return a <= b;
	}
	
	/**
	 * The binary <code>greaterThan</code> operator. This is the equivalent to the Java <code>&gt;</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a float.
	 * @return   <code>a&gt;b</code>
	 */
	public static boolean operator_greaterThan(int a, float b) {
		return a > b;
	}
	
	/**
	 * The binary <code>greaterEqualsThan</code> operator. This is the equivalent to the Java <code>&gt;=</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a float.
	 * @return   <code>a&gt;=b</code>
	 */
	public static boolean operator_greaterEqualsThan(int a, float b) {
		return a >= b;
	}
	
	/**
	 * The binary <code>equals</code> operator. This is the equivalent to the Java <code>==</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a float.
	 * @return   <code>a==b</code>
	 */
	public static boolean operator_equals(int a, float b) {
		return a == b;
	}
	
	/**
	 * The binary <code>notEquals</code> operator. This is the equivalent to the Java <code>!=</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a float.
	 * @return   <code>a!=b</code>
	 */
	public static boolean operator_notEquals(int a, float b) {
		return a != b;
	}
	
	/**
	 * The binary <code>power</code> operator. This is the equivalent to the Java's <code>Math.pow()</code> function.
	 * 
	 * @param a  an integer.
	 * @param b  a float.
	 * @return   <code>Math.pow(a, b)</code>
	 */
	public static double operator_power(int a, float b) {
		return Math.pow(a, b);
	}
	
	/**
	 * The binary <code>plus</code> operator. This is the equivalent to the Java <code>+</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a long.
	 * @return   <code>a+b</code>
	 */
	public static long operator_plus(int a, long b) {
		return a + b;
	}
	
	/**
	 * The binary <code>minus</code> operator. This is the equivalent to the Java <code>-</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a long.
	 * @return   <code>a-b</code>
	 */
	public static long operator_minus(int a, long b) {
		return a - b;
	}
	
	/**
	 * The binary <code>multiply</code> operator. This is the equivalent to the Java <code>*</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a long.
	 * @return   <code>a*b</code>
	 */
	public static long operator_multiply(int a, long b) {
		return a * b;
	}
	
	/**
	 * The binary <code>divide</code> operator. This is the equivalent to the Java <code>/</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a long.
	 * @return   <code>a/b</code>
	 */
	public static long operator_divide(int a, long b) {
		return a / b;
	}
	
	/**
	 * The binary <code>modulo</code> operator. This is the equivalent to the Java <code>%</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a long.
	 * @return   <code>a%b</code>
	 */
	public static long operator_modulo(int a, long b) {
		return a % b;
	}
	
	/**
	 * The binary <code>lessThan</code> operator. This is the equivalent to the Java <code>&lt;</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a long.
	 * @return   <code>a&lt;b</code>
	 */
	public static boolean operator_lessThan(int a, long b) {
		return a < b;
	}
	
	/**
	 * The binary <code>lessEqualsThan</code> operator. This is the equivalent to the Java <code>&lt;=</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a long.
	 * @return   <code>a&lt;=b</code>
	 */
	public static boolean operator_lessEqualsThan(int a, long b) {
		return a <= b;
	}
	
	/**
	 * The binary <code>greaterThan</code> operator. This is the equivalent to the Java <code>&gt;</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a long.
	 * @return   <code>a&gt;b</code>
	 */
	public static boolean operator_greaterThan(int a, long b) {
		return a > b;
	}
	
	/**
	 * The binary <code>greaterEqualsThan</code> operator. This is the equivalent to the Java <code>&gt;=</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a long.
	 * @return   <code>a&gt;=b</code>
	 */
	public static boolean operator_greaterEqualsThan(int a, long b) {
		return a >= b;
	}
	
	/**
	 * The binary <code>equals</code> operator. This is the equivalent to the Java <code>==</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a long.
	 * @return   <code>a==b</code>
	 */
	public static boolean operator_equals(int a, long b) {
		return a == b;
	}
	
	/**
	 * The binary <code>notEquals</code> operator. This is the equivalent to the Java <code>!=</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a long.
	 * @return   <code>a!=b</code>
	 */
	public static boolean operator_notEquals(int a, long b) {
		return a != b;
	}
	
	/**
	 * The binary <code>power</code> operator. This is the equivalent to the Java's <code>Math.pow()</code> function.
	 * 
	 * @param a  an integer.
	 * @param b  a long.
	 * @return   <code>Math.pow(a, b)</code>
	 */
	public static double operator_power(int a, long b) {
		return Math.pow(a, b);
	}
	
	/**
	 * The binary <code>plus</code> operator. This is the equivalent to the Java <code>+</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  an integer.
	 * @return   <code>a+b</code>
	 */
	public static int operator_plus(int a, int b) {
		return a + b;
	}
	
	/**
	 * The binary <code>minus</code> operator. This is the equivalent to the Java <code>-</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  an integer.
	 * @return   <code>a-b</code>
	 */
	public static int operator_minus(int a, int b) {
		return a - b;
	}
	
	/**
	 * The binary <code>multiply</code> operator. This is the equivalent to the Java <code>*</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  an integer.
	 * @return   <code>a*b</code>
	 */
	public static int operator_multiply(int a, int b) {
		return a * b;
	}
	
	/**
	 * The binary <code>divide</code> operator. This is the equivalent to the Java <code>/</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  an integer.
	 * @return   <code>a/b</code>
	 */
	public static int operator_divide(int a, int b) {
		return a / b;
	}
	
	/**
	 * The binary <code>modulo</code> operator. This is the equivalent to the Java <code>%</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  an integer.
	 * @return   <code>a%b</code>
	 */
	public static int operator_modulo(int a, int b) {
		return a % b;
	}
	
	/**
	 * The binary <code>lessThan</code> operator. This is the equivalent to the Java <code>&lt;</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  an integer.
	 * @return   <code>a&lt;b</code>
	 */
	public static boolean operator_lessThan(int a, int b) {
		return a < b;
	}
	
	/**
	 * The binary <code>lessEqualsThan</code> operator. This is the equivalent to the Java <code>&lt;=</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  an integer.
	 * @return   <code>a&lt;=b</code>
	 */
	public static boolean operator_lessEqualsThan(int a, int b) {
		return a <= b;
	}
	
	/**
	 * The binary <code>greaterThan</code> operator. This is the equivalent to the Java <code>&gt;</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  an integer.
	 * @return   <code>a&gt;b</code>
	 */
	public static boolean operator_greaterThan(int a, int b) {
		return a > b;
	}
	
	/**
	 * The binary <code>greaterEqualsThan</code> operator. This is the equivalent to the Java <code>&gt;=</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  an integer.
	 * @return   <code>a&gt;=b</code>
	 */
	public static boolean operator_greaterEqualsThan(int a, int b) {
		return a >= b;
	}
	
	/**
	 * The binary <code>equals</code> operator. This is the equivalent to the Java <code>==</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  an integer.
	 * @return   <code>a==b</code>
	 */
	public static boolean operator_equals(int a, int b) {
		return a == b;
	}
	
	/**
	 * The binary <code>notEquals</code> operator. This is the equivalent to the Java <code>!=</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  an integer.
	 * @return   <code>a!=b</code>
	 */
	public static boolean operator_notEquals(int a, int b) {
		return a != b;
	}
	
	/**
	 * The binary <code>power</code> operator. This is the equivalent to the Java's <code>Math.pow()</code> function.
	 * 
	 * @param a  an integer.
	 * @param b  an integer.
	 * @return   <code>Math.pow(a, b)</code>
	 */
	public static double operator_power(int a, int b) {
		return Math.pow(a, b);
	}
	
	/**
	 * The binary <code>plus</code> operator. This is the equivalent to the Java <code>+</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a character.
	 * @return   <code>a+b</code>
	 */
	public static int operator_plus(int a, char b) {
		return a + b;
	}
	
	/**
	 * The binary <code>minus</code> operator. This is the equivalent to the Java <code>-</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a character.
	 * @return   <code>a-b</code>
	 */
	public static int operator_minus(int a, char b) {
		return a - b;
	}
	
	/**
	 * The binary <code>multiply</code> operator. This is the equivalent to the Java <code>*</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a character.
	 * @return   <code>a*b</code>
	 */
	public static int operator_multiply(int a, char b) {
		return a * b;
	}
	
	/**
	 * The binary <code>divide</code> operator. This is the equivalent to the Java <code>/</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a character.
	 * @return   <code>a/b</code>
	 */
	public static int operator_divide(int a, char b) {
		return a / b;
	}
	
	/**
	 * The binary <code>modulo</code> operator. This is the equivalent to the Java <code>%</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a character.
	 * @return   <code>a%b</code>
	 */
	public static int operator_modulo(int a, char b) {
		return a % b;
	}
	
	/**
	 * The binary <code>lessThan</code> operator. This is the equivalent to the Java <code>&lt;</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a character.
	 * @return   <code>a&lt;b</code>
	 */
	public static boolean operator_lessThan(int a, char b) {
		return a < b;
	}
	
	/**
	 * The binary <code>lessEqualsThan</code> operator. This is the equivalent to the Java <code>&lt;=</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a character.
	 * @return   <code>a&lt;=b</code>
	 */
	public static boolean operator_lessEqualsThan(int a, char b) {
		return a <= b;
	}
	
	/**
	 * The binary <code>greaterThan</code> operator. This is the equivalent to the Java <code>&gt;</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a character.
	 * @return   <code>a&gt;b</code>
	 */
	public static boolean operator_greaterThan(int a, char b) {
		return a > b;
	}
	
	/**
	 * The binary <code>greaterEqualsThan</code> operator. This is the equivalent to the Java <code>&gt;=</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a character.
	 * @return   <code>a&gt;=b</code>
	 */
	public static boolean operator_greaterEqualsThan(int a, char b) {
		return a >= b;
	}
	
	/**
	 * The binary <code>equals</code> operator. This is the equivalent to the Java <code>==</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a character.
	 * @return   <code>a==b</code>
	 */
	public static boolean operator_equals(int a, char b) {
		return a == b;
	}
	
	/**
	 * The binary <code>notEquals</code> operator. This is the equivalent to the Java <code>!=</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a character.
	 * @return   <code>a!=b</code>
	 */
	public static boolean operator_notEquals(int a, char b) {
		return a != b;
	}
	
	/**
	 * The binary <code>power</code> operator. This is the equivalent to the Java's <code>Math.pow()</code> function.
	 * 
	 * @param a  an integer.
	 * @param b  a character.
	 * @return   <code>Math.pow(a, b)</code>
	 */
	public static double operator_power(int a, char b) {
		return Math.pow(a, b);
	}
	
	/**
	 * The binary <code>plus</code> operator. This is the equivalent to the Java <code>+</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a short.
	 * @return   <code>a+b</code>
	 */
	public static int operator_plus(int a, short b) {
		return a + b;
	}
	
	/**
	 * The binary <code>minus</code> operator. This is the equivalent to the Java <code>-</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a short.
	 * @return   <code>a-b</code>
	 */
	public static int operator_minus(int a, short b) {
		return a - b;
	}
	
	/**
	 * The binary <code>multiply</code> operator. This is the equivalent to the Java <code>*</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a short.
	 * @return   <code>a*b</code>
	 */
	public static int operator_multiply(int a, short b) {
		return a * b;
	}
	
	/**
	 * The binary <code>divide</code> operator. This is the equivalent to the Java <code>/</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a short.
	 * @return   <code>a/b</code>
	 */
	public static int operator_divide(int a, short b) {
		return a / b;
	}
	
	/**
	 * The binary <code>modulo</code> operator. This is the equivalent to the Java <code>%</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a short.
	 * @return   <code>a%b</code>
	 */
	public static int operator_modulo(int a, short b) {
		return a % b;
	}
	
	/**
	 * The binary <code>lessThan</code> operator. This is the equivalent to the Java <code>&lt;</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a short.
	 * @return   <code>a&lt;b</code>
	 */
	public static boolean operator_lessThan(int a, short b) {
		return a < b;
	}
	
	/**
	 * The binary <code>lessEqualsThan</code> operator. This is the equivalent to the Java <code>&lt;=</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a short.
	 * @return   <code>a&lt;=b</code>
	 */
	public static boolean operator_lessEqualsThan(int a, short b) {
		return a <= b;
	}
	
	/**
	 * The binary <code>greaterThan</code> operator. This is the equivalent to the Java <code>&gt;</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a short.
	 * @return   <code>a&gt;b</code>
	 */
	public static boolean operator_greaterThan(int a, short b) {
		return a > b;
	}
	
	/**
	 * The binary <code>greaterEqualsThan</code> operator. This is the equivalent to the Java <code>&gt;=</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a short.
	 * @return   <code>a&gt;=b</code>
	 */
	public static boolean operator_greaterEqualsThan(int a, short b) {
		return a >= b;
	}
	
	/**
	 * The binary <code>equals</code> operator. This is the equivalent to the Java <code>==</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a short.
	 * @return   <code>a==b</code>
	 */
	public static boolean operator_equals(int a, short b) {
		return a == b;
	}
	
	/**
	 * The binary <code>notEquals</code> operator. This is the equivalent to the Java <code>!=</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a short.
	 * @return   <code>a!=b</code>
	 */
	public static boolean operator_notEquals(int a, short b) {
		return a != b;
	}
	
	/**
	 * The binary <code>power</code> operator. This is the equivalent to the Java's <code>Math.pow()</code> function.
	 * 
	 * @param a  an integer.
	 * @param b  a short.
	 * @return   <code>Math.pow(a, b)</code>
	 */
	public static double operator_power(int a, short b) {
		return Math.pow(a, b);
	}
	
	/**
	 * The binary <code>plus</code> operator. This is the equivalent to the Java <code>+</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a byte.
	 * @return   <code>a+b</code>
	 */
	public static int operator_plus(int a, byte b) {
		return a + b;
	}
	
	/**
	 * The binary <code>minus</code> operator. This is the equivalent to the Java <code>-</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a byte.
	 * @return   <code>a-b</code>
	 */
	public static int operator_minus(int a, byte b) {
		return a - b;
	}
	
	/**
	 * The binary <code>multiply</code> operator. This is the equivalent to the Java <code>*</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a byte.
	 * @return   <code>a*b</code>
	 */
	public static int operator_multiply(int a, byte b) {
		return a * b;
	}
	
	/**
	 * The binary <code>divide</code> operator. This is the equivalent to the Java <code>/</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a byte.
	 * @return   <code>a/b</code>
	 */
	public static int operator_divide(int a, byte b) {
		return a / b;
	}
	
	/**
	 * The binary <code>modulo</code> operator. This is the equivalent to the Java <code>%</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a byte.
	 * @return   <code>a%b</code>
	 */
	public static int operator_modulo(int a, byte b) {
		return a % b;
	}
	
	/**
	 * The binary <code>lessThan</code> operator. This is the equivalent to the Java <code>&lt;</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a byte.
	 * @return   <code>a&lt;b</code>
	 */
	public static boolean operator_lessThan(int a, byte b) {
		return a < b;
	}
	
	/**
	 * The binary <code>lessEqualsThan</code> operator. This is the equivalent to the Java <code>&lt;=</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a byte.
	 * @return   <code>a&lt;=b</code>
	 */
	public static boolean operator_lessEqualsThan(int a, byte b) {
		return a <= b;
	}
	
	/**
	 * The binary <code>greaterThan</code> operator. This is the equivalent to the Java <code>&gt;</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a byte.
	 * @return   <code>a&gt;b</code>
	 */
	public static boolean operator_greaterThan(int a, byte b) {
		return a > b;
	}
	
	/**
	 * The binary <code>greaterEqualsThan</code> operator. This is the equivalent to the Java <code>&gt;=</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a byte.
	 * @return   <code>a&gt;=b</code>
	 */
	public static boolean operator_greaterEqualsThan(int a, byte b) {
		return a >= b;
	}
	
	/**
	 * The binary <code>equals</code> operator. This is the equivalent to the Java <code>==</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a byte.
	 * @return   <code>a==b</code>
	 */
	public static boolean operator_equals(int a, byte b) {
		return a == b;
	}
	
	/**
	 * The binary <code>notEquals</code> operator. This is the equivalent to the Java <code>!=</code> operator.
	 * 
	 * @param a  an integer.
	 * @param b  a byte.
	 * @return   <code>a!=b</code>
	 */
	public static boolean operator_notEquals(int a, byte b) {
		return a != b;
	}
	
	/**
	 * The binary <code>power</code> operator. This is the equivalent to the Java's <code>Math.pow()</code> function.
	 * 
	 * @param a  an integer.
	 * @param b  a byte.
	 * @return   <code>Math.pow(a, b)</code>
	 */
	public static double operator_power(int a, byte b) {
		return Math.pow(a, b);
	}
	
	// END generated code



}
