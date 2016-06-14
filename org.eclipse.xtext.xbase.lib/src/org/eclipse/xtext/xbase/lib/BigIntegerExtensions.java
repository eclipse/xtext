/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import java.math.BigInteger;

import com.google.common.annotations.GwtCompatible;


/**
 * This is an extension library for {@link BigInteger big integral numbers}.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@GwtCompatible public class BigIntegerExtensions {

	/**
	 * The unary <code>minus</code> operator.
	 * 
	 * @param a
	 *            a BigInteger. May not be <code>null</code>.
	 * @return <code>-a</code>
	 * @throws NullPointerException
	 *             if {@code a} is <code>null</code>.
	 */
	@Inline(value="$1.negate()")
	@Pure
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
	 * @throws NullPointerException
	 *             if {@code a} or {@code b} is <code>null</code>.
	 */
	@Inline(value="$1.add($2)")
	@Pure
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
	 * @throws NullPointerException
	 *             if {@code a} or {@code b} is <code>null</code>.
	 */
	@Inline(value="$1.subtract($2)")
	@Pure
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
	 * @throws NullPointerException
	 *             if {@code a} <code>null</code>.
	 */
	@Inline(value="$1.pow($2)")
	@Pure
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
	 * @throws NullPointerException
	 *             if {@code a} or {@code b} is <code>null</code>.
	 */
	@Inline(value="$1.multiply($2)")
	@Pure
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
	 * @throws NullPointerException
	 *             if {@code a} or {@code b} is <code>null</code>.
	 */
	@Inline(value="$1.divide($2)")
	@Pure
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
	 * @throws NullPointerException
	 *             if {@code a} or {@code b} is <code>null</code>.
	 */
	@Inline(value="$1.mod($2)")
	@Pure
	public static BigInteger operator_modulo(BigInteger a, BigInteger b) {
		return a.mod(b);
	}
}
