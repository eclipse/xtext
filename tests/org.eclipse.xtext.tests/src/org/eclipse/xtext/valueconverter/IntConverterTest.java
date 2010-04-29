/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.valueconverter;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.junit.AbstractXtextTests;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class IntConverterTest extends AbstractXtextTests {

	public void testSimple() throws Exception {
		IValueConverter<Integer> valueConverter = new DefaultTerminalConverters().INT();
		String s = "42";
		Integer value = valueConverter.toValue(s, null);
		assertEquals(new Integer(42), value);
		assertEquals(s, valueConverter.toString(value));
	}

	public void testZero() throws Exception {
		IValueConverter<Integer> valueConverter = new DefaultTerminalConverters().INT();
		String s = "0";
		Integer value = valueConverter.toValue(s, null);
		assertEquals(new Integer(0), value);
		assertEquals(s, valueConverter.toString(value));
	}

	public void testNegative() throws Exception {
		IValueConverter<Integer> valueConverter = new DefaultTerminalConverters().INT();
		try {
			valueConverter.toString(-42);
			fail("Negative value not detected.");
		} catch (ValueConverterException e) {
			// normal operation
//			System.out.println(e.getMessage());
		}
	}

	public void testNull() throws Exception {
		IValueConverter<Integer> valueConverter = new DefaultTerminalConverters().INT();
		try {
			valueConverter.toString(null);
			fail("Negative value not detected.");
		} catch (ValueConverterException e) {
			// normal operation
//			System.out.println(e.getMessage());
		}
	}

}
