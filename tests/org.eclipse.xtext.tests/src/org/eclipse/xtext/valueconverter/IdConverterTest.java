/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.valueconverter;

import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.junit.AbstractXtextTests;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class IdConverterTest extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
		conv = (DefaultTerminalConverters) getValueConverterService();
	}

	protected DefaultTerminalConverters conv;

	public void testSimple() throws Exception {
		IValueConverter<String> valueConverter = conv.ID();
		String s = "abc";
		String value = valueConverter.toValue(s, null);
		assertEquals("abc", value);
		assertEquals(s, valueConverter.toString(value));
	}

	public void testNull() throws Exception {
		IValueConverter<String> valueConverter = conv.ID();
		try {
			valueConverter.toString(null);
			fail("Null value not detected.");
		} catch (ValueConverterException e) {
			// normal operation
			System.out.println(e.getMessage());
		}
	}

	public void testEmpty() throws Exception {
		IValueConverter<String> valueConverter = conv.ID();
		try {
			valueConverter.toString("");
			fail("Empty value not detected.");
		} catch (ValueConverterException e) {
			// normal operation
			System.out.println(e.getMessage());
		}
	}

	public void testInvalidChar1() throws Exception {
		IValueConverter<String> valueConverter = conv.ID();
		try {
			valueConverter.toString("^foo");
			fail("invalid char not detected..");
		} catch (ValueConverterException e) {
			// normal operation
			System.out.println(e.getMessage());
		}
	}

	public void testInvalidChar2() throws Exception {
		IValueConverter<String> valueConverter = conv.ID();
		try {
			valueConverter.toString("foo%bar[]");
			fail("Empty value not detected.");
		} catch (ValueConverterException e) {
			// normal operation
			System.out.println(e.getMessage());
		}
	}

	public void testInvalidChar3() throws Exception {
		IValueConverter<String> valueConverter = conv.ID();
		try {
			valueConverter.toString("0foo");
			fail("Empty value not detected.");
		} catch (ValueConverterException e) {
			// normal operation
			System.out.println(e.getMessage());
		}
	}

}
