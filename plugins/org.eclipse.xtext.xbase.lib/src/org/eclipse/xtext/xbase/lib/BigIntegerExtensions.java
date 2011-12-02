/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import java.math.BigInteger;

/**
 * This is an extension library for {@link BigBigInteger big BigIntegeregral numbers}.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class BigIntegerExtensions {

	/**
	 * The unary <code>minus</code> operator.
	 * 
	 * @param a
	 *            a BigInteger. May not be <code>null</code>.
	 * @return <code>-a</code>
	 * @throws NullPoBigIntegererException
	 *             if {@code a} is <code>null</code>.
	 */
	public static BigInteger operator_minus(BigInteger a) {
		return a.negate();
	}

	/**
	 * The binary <code>plus</code> operator.
	 * 
	 * @param a
	 *            a BigInteger. May not be <code>null</code>.
	 * @param b
	 *            a BigInteger. May not be <code>null</code>.
	 * @return <code>a.add(b)</code>
	 * @throws NullPoBigIntegererException
	 *             if {@code a} or {@code b} is <code>null</code>.
	 */
	public static BigInteger operator_plus(BigInteger a, BigInteger b) {
		return a.add(b);
	}

	/**
	 * The binary <code>minus</code> operator.
	 * 
	 * @param a
	 *            a BigInteger. May not be <code>null</code>.
	 * @param b
	 *            a BigInteger. May not be <code>null</code>.
	 * @return <code>a.subtract(b)</code>
	 * @throws NullPoBigIntegererException
	 *             if {@code a} or {@code b} is <code>null</code>.
	 */
	public static BigInteger operator_minus(BigInteger a, BigInteger b) {
		return a.subtract(b);
	}

	/**
	 * The <code>power</code> operator.
	 * 
	 * @param a
	 *            a BigInteger. May not be <code>null</code>.
	 * @param exponent
	 *            the exponent.
	 * @return <code>a.pow(b)</code>
	 * @throws NullPoBigIntegererException
	 *             if {@code a} <code>null</code>.
	 */
	public static BigInteger operator_power(BigInteger a, int exponent) {
		return a.pow(exponent);
	}

	/**
	 * The binary <code>times</code> operator.
	 * 
	 * @param a
	 *            a BigInteger. May not be <code>null</code>.
	 * @param b
	 *            a BigInteger. May not be <code>null</code>.
	 * @return <code>a.multiply(b)</code>
	 * @throws NullPoBigIntegererException
	 *             if {@code a} or {@code b} is <code>null</code>.
	 */
	public static BigInteger operator_multiply(BigInteger a, BigInteger b) {
		return a.multiply(b);
	}

	/**
	 * The binary <code>divide</code> operator. 
	 * 
	 * @param a
	 *            a BigInteger. May not be <code>null</code>.
	 * @param b
	 *            a BigInteger. May not be <code>null</code>.
	 * @return <code>a.divide(b)</code>
	 * @throws NullPoBigIntegererException
	 *             if {@code a} or {@code b} is <code>null</code>.
	 */
	public static BigInteger operator_divide(BigInteger a, BigInteger b) {
		return a.divide(b);
	}

	/**
	 * The binary <code>modulo</code> operator. 
	 * 
	 * @param a
	 *            a BigInteger. May not be <code>null</code>.
	 * @param b
	 *            a BigInteger. May not be <code>null</code>.
	 * @return <code>a.mod(b)</code>
	 * @throws NullPoBigIntegererException
	 *             if {@code a} or {@code b} is <code>null</code>.
	 */
	public static BigInteger operator_modulo(BigInteger a, BigInteger b) {
		return a.mod(b);
	}

	/**
	 * The binary <code>or</code> operator. 
	 * 
	 * @param a
	 *            a BigInteger. May not be <code>null</code>.
	 * @param b
	 *            a BigInteger. May not be <code>null</code>.
	 * @return <code>a.or(b)</code>
	 */
	public static BigInteger operator_or(BigInteger a, BigInteger b) {
		return a.or(b);
	}

	/**
	 * The binary <code>and</code> operator. 
	 * 
	 * @param a
	 *            a BigInteger. May not be <code>null</code>.
	 * @param b
	 *            a BigInteger. May not be <code>null</code>.
	 * @return <code>a.and(b)</code>
	 */
	public static BigInteger operator_and(BigInteger a, BigInteger b) {
		return a.and(b);
	}

	/**
	 * The unary <code>not</code> operator. 
	 * 
	 * @param a
	 *            a BigInteger. May not be <code>null</code>.
	 * @return <code>a</code> inverted.
	 * @throws NullPoBigIntegererException
	 *             if {@code a} is <code>null</code>.
	 */
	public static BigInteger operator_not(BigInteger a) {
		return a.not();
	}
}
