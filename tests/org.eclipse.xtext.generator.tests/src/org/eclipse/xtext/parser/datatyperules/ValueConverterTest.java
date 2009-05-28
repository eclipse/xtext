/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.datatyperules;

import java.math.BigDecimal;

import junit.framework.TestCase;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ValueConverterTest extends TestCase {

	private IValueConverter<BigDecimal> valueConverter;

	@Override
	protected void setUp() throws Exception {
		valueConverter = new DatatypeRulesTestLanguageValueConverters().Fraction();
	}

	public void testSimpleToObject() throws ValueConverterException {
		String s = "123";
		BigDecimal bd = valueConverter.toValue(s, null);
		BigDecimal expected = new BigDecimal("123");
		assertEquals(expected, bd);
	}

	public void testFractionObject() throws ValueConverterException {
		String s = "123/246";
		BigDecimal bd = valueConverter.toValue(s, null);
		BigDecimal expected = new BigDecimal("0.5");
		assertEquals(expected, bd);
	}

	public void testZeroDenominator() throws ValueConverterException {
		String s = "123/0";
		try {
			valueConverter.toValue(s, null);
			fail("expected ArithmeticException");
		} catch(ArithmeticException ae) {
			// expected
		}
	}

	public void testSimpleToString() {
		String expected = "123";
		BigDecimal bd = BigDecimal.valueOf(123);
		assertEquals(expected, valueConverter.toString(bd));
	}

	public void testFractionToString_01() {
		String expected = "5/10";
		BigDecimal bd = new BigDecimal("0.5");
		assertEquals(expected, valueConverter.toString(bd));
	}

	public void testFractionToString_02() {
		String expected = "1557/1000";
		BigDecimal bd = new BigDecimal("1.557");
		assertEquals(expected, valueConverter.toString(bd));
	}
}
