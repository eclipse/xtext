/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import java.math.BigDecimal;
import java.math.MathContext;

import com.google.common.annotations.GwtCompatible;


/**
 * This is an extension library for {@link BigDecimal big decimal numbers}.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@GwtCompatible public class BigDecimalExtensions {

	/**
	 * The unary <code>minus</code> operator. 
	 * 
	 * @param a
	 *            a BigDecimal. May not be <code>null</code>.
	 * @return <code>-a</code>
	 * @throws NullPointerException
	 *             if {@code a} is <code>null</code>.
	 */
	@Pure
	@Inline(value="$1.negate()")
	public static BigDecimal operator_minus(BigDecimal a) {
		return a.negate();
	}

	/**
	 * The binary <code>plus</code> operator. 
	 * 
	 * @param a
	 *            a BigDecimal. May not be <code>null</code>.
	 * @param b
	 *            a BigDecimal. May not be <code>null</code>.
	 * @return <code>a.add(b)</code>
	 * @throws NullPointerException
	 *             if {@code a} or {@code b} is <code>null</code>.
	 */
	@Pure
	@Inline(value="$1.add($2)")
	public static BigDecimal operator_plus(BigDecimal a, BigDecimal b) {
		return a.add(b);
	}

	/**
	 * The binary <code>minus</code> operator.
	 * 
	 * @param a
	 *            a BigDecimal. May not be <code>null</code>.
	 * @param b
	 *            a BigDecimal. May not be <code>null</code>.
	 * @return <code>a.subtract(b)</code>
	 * @throws NullPointerException
	 *             if {@code a} or {@code b} is <code>null</code>.
	 */
	@Pure
	@Inline(value="$1.subtract($2)")
	public static BigDecimal operator_minus(BigDecimal a, BigDecimal b) {
		return a.subtract(b);
	}

	/**
	 * The <code>power</code> operator.
	 * 
	 * @param a
	 *            a BigDecimal. May not be <code>null</code>.
	 * @param exponent
	 *            the exponent.
	 * @return <code>a.pow(b)</code>
	 * @throws NullPointerException
	 *             if {@code a} is <code>null</code>.
	 */
	@Pure
	@Inline(value="$1.pow($2)")
	public static BigDecimal operator_power(BigDecimal a, int exponent) {
		return a.pow(exponent);
	}

	/**
	 * The binary <code>times</code> operator. 
	 * 
	 * @param a
	 *            a BigDecimal. May not be <code>null</code>.
	 * @param b
	 *            a BigDecimal. May not be <code>null</code>.
	 * @return <code>a.multiply(b)</code>
	 * @throws NullPointerException
	 *             if {@code a} or {@code b} is <code>null</code>.
	 */
	@Pure
	@Inline(value="$1.multiply($2)")
	public static BigDecimal operator_multiply(BigDecimal a, BigDecimal b) {
		return a.multiply(b);
	}

	/**
	 * The binary <code>divide</code> operator. 
	 * 
	 * @param a
	 *            a BigDecimal. May not be <code>null</code>.
	 * @param b
	 *            a BigDecimal. May not be <code>null</code>.
	 * @return <code>a.divide(b, MathContext.DECIMAL128)</code>
	 * @throws NullPointerException
	 *             if {@code a} or {@code b} is <code>null</code>.
	 */
	@Pure
	@Inline(value="$1.divide($2, $3.DECIMAL128)", imported=MathContext.class)
	public static BigDecimal operator_divide(BigDecimal a, BigDecimal b) {
		return a.divide(b, MathContext.DECIMAL128);
	}
}
