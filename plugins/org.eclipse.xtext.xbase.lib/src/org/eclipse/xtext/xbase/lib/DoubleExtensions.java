/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

/**
 * This is an extension library for {@link Double floating point numbers}, e.g. <code>double</code> or <code>Double</code>.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DoubleExtensions {

	/**
	 * The unary <code>minus</code> operator. This is the equivalent to the unary java <code>-</code> operator.
	 * 
	 * @param a
	 *            a double.
	 * @return <code>-a</code>
	 */
	public static double operator_minus(double a) {
		return -a;
	}

	/**
	 * The unary <code>minus</code> operator. This is the equivalent to the unary java <code>-</code> operator.
	 * 
	 * @param a
	 *            a double. May not be <code>null</code>.
	 * @return <code>-a</code>
	 * @throws NullPointerException
	 *             if {@code a} is <code>null</code>.
	 */
	public static double operator_minus(Double a) {
		return -a;
	}

	/**
	 * The binary <code>plus</code> operator. This is the equivalent to the java <code>+</code> operator.
	 * 
	 * @param a
	 *            a double.
	 * @param b
	 *            a double.
	 * @return <code>a+b</code>
	 */
	public static double operator_plus(double a, double b) {
		return a + b;
	}

	/**
	 * The binary <code>plus</code> operator. This is the equivalent to the java <code>+</code> operator.
	 * 
	 * @param a
	 *            a double. May not be <code>null</code>.
	 * @param b
	 *            a number. May not be <code>null</code>.
	 * @return <code>a+b</code>
	 * @throws NullPointerException
	 *             if {@code a} or {@code b} is <code>null</code>.
	 */
	public static double operator_plus(Double a, Number b) {
		return a + b.doubleValue();
	}

	/**
	 * The binary <code>minus</code> operator. This is the equivalent to the java <code>-</code> operator.
	 * 
	 * @param a
	 *            a double.
	 * @param b
	 *            a double.
	 * @return <code>a-b</code>
	 */
	public static double operator_minus(double a, double b) {
		return a - b;
	}

	/**
	 * The binary <code>minus</code> operator. This is the equivalent to the java <code>-</code> operator.
	 * 
	 * @param a
	 *            a double. May not be <code>null</code>.
	 * @param b
	 *            a number. May not be <code>null</code>.
	 * @return <code>a-b</code>
	 * @throws NullPointerException
	 *             if {@code a} or {@code b} is <code>null</code>.
	 */
	public static double operator_minus(Double a, Number b) {
		return a - b.doubleValue();
	}

	/**
	 * The <code>power</code> operator.
	 * 
	 * @param a
	 *            a double.
	 * @param b
	 *            a double.
	 * @return <code>a ** b</code>
	 */
	public static double operator_power(double a, double b) {
		return Math.pow(a, b);
	}

	/**
	 * The <code>power</code> operator.
	 * 
	 * @param a
	 *            a double. May not be <code>null</code>.
	 * @param b
	 *            a number. May not be <code>null</code>.
	 * @return <code>a ** b</code>
	 * @throws NullPointerException
	 *             if {@code a} or {@code b} is <code>null</code>.
	 */
	public static double operator_power(Double a, Number b) {
		return Math.pow(a, b.doubleValue());
	}

	/**
	 * The binary <code>times</code> operator. This is the equivalent to the java <code>*</code> operator.
	 * 
	 * @param a
	 *            a double.
	 * @param b
	 *            a double.
	 * @return <code>a*b</code>
	 */
	public static double operator_multiply(double a, double b) {
		return a * b;
	}

	/**
	 * The binary <code>times</code> operator. This is the equivalent to the java <code>*</code> operator.
	 * 
	 * @param a
	 *            a double. May not be <code>null</code>.
	 * @param b
	 *            a number. May not be <code>null</code>.
	 * @return <code>a*b</code>
	 * @throws NullPointerException
	 *             if {@code a} or {@code b} is <code>null</code>.
	 */
	public static double operator_multiply(Double a, Number b) {
		return a * b.doubleValue();
	}

	/**
	 * The binary <code>divide</code> operator. This is the equivalent to the java <code>/</code> operator. That is, the
	 * result will be the integral result of the division, e.g. <code>operator_divide(1, 2)</code> yields <code>0</code>
	 * .
	 * 
	 * @param a
	 *            a double.
	 * @param b
	 *            a double.
	 * @return <code>a/b</code>
	 */
	public static double operator_divide(double a, double b) {
		return a / b;
	}

	/**
	 * The binary <code>divide</code> operator. This is the equivalent to the java <code>/</code> operator. That is, the
	 * result will be the integral result of the division, e.g. <code>operator_divide(1, 2)</code> yields <code>0</code>
	 * .
	 * 
	 * @param a
	 *            a double. May not be <code>null</code>.
	 * @param b
	 *            a number. May not be <code>null</code>.
	 * @return <code>a/b</code>
	 * @throws NullPointerException
	 *             if {@code a} or {@code b} is <code>null</code>.
	 */
	public static double operator_divide(Double a, Number b) {
		return a / b.doubleValue();
	}

	/**
	 * The binary <code>equals</code> operator. This is the equivalent to the java <code>==</code> operator.
	 * 
	 * @param a
	 *            a double.
	 * @param b
	 *            a double.
	 * @return <code>a==b</code>
	 */
	public static boolean operator_equals(double a, double b) {
		// TODO: should we use?
//		return Double.compare(a, b) == 0;
		return a == b;
	}

	/**
	 * The binary <code>not equals</code> operator. This is the equivalent to the java <code>!=</code> operator.
	 * 
	 * @param a
	 *            a double.
	 * @param b
	 *            a double.
	 * @return <code>a!=b</code>
	 */
	public static boolean operator_notEquals(double a, double b) {
		// TODO: should we use?
//		return Double.compare(a, b) != 0;
		return a != b;
	}

	/**
	 * The binary <code>less than</code> operator. This is the equivalent to the java <code>&lt;</code> operator.
	 * 
	 * @param a
	 *            a double.
	 * @param b
	 *            a double.
	 * @return <code>a&lt;b</code>
	 */
	public static boolean operator_lessThan(double a, double b) {
		return a < b;
	}

	/**
	 * The binary <code>less than or equals</code> operator. This is the equivalent to the java <code>&lt;=</code> operator.
	 * 
	 * @param a
	 *            a double.
	 * @param b
	 *            a double.
	 * @return <code>a&lt;=b</code>
	 */
	public static boolean operator_lessEqualsThan(double a, double b) {
		return a <= b;
	}

	/**
	 * The binary <code>greater than</code> operator. This is the equivalent to the java <code>&gt;</code> operator.
	 * 
	 * @param a
	 *            a double.
	 * @param b
	 *            a double.
	 * @return <code>a&gt;b</code>
	 */
	public static boolean operator_greaterThan(double a, double b) {
		return a > b;
	}

	/**
	 * The binary <code>greater than or equals</code> operator. This is the equivalent to the java <code>&gt;=</code> operator.
	 * 
	 * @param a
	 *            a double.
	 * @param b
	 *            a double.
	 * @return <code>a&gt;=b</code>
	 */
	public static boolean operator_greaterEqualsThan(double a, double b) {
		return a >= b;
	}
}
