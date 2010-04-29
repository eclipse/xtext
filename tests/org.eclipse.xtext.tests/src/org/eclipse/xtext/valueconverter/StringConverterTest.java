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
 * @author koehnlein - Initial contribution and API
 */
public class StringConverterTest extends AbstractXtextTests {

	public void testEscapeChars() throws Exception {
		IValueConverter<String> valueConverter = new DefaultTerminalConverters().STRING();
		String s = "\"\\t\\n\\r\\f\\b\"";
		String value = valueConverter.toValue(s, null);
		assertEquals("\t\n\r\f\b", value);
		assertEquals(s, valueConverter.toString(value));
	}

	public void testUnicode() throws Exception {
		IValueConverter<String> valueConverter = new DefaultTerminalConverters().STRING();
		try {
			valueConverter.toValue("'\\u0000'", null);
			fail("Illegal escape chr not detected");
		} catch (ValueConverterException e) {
			// normal operation
		}
		String legalString = "\"\\\\u0000\"";
		String value = valueConverter.toValue(legalString, null);
		assertEquals("\\u0000", value);
		assertEquals(legalString, valueConverter.toString(value));
	}

	public void testNull() throws Exception {
		IValueConverter<String> valueConverter = new DefaultTerminalConverters().STRING();
		try {
			valueConverter.toString(null);
			fail("Null value not detected.");
		} catch (ValueConverterException e) {
			// normal operation
//			System.out.println(e.getMessage());
		}
	}

}
