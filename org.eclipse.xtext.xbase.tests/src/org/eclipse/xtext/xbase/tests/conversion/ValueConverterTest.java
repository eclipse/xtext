/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.conversion;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sebastian Zarnekow - Added a bunch of test cases
 */
public class ValueConverterTest extends AbstractXbaseTestCase {

	@Inject
	private IValueConverterService valueConverterService;
	
	@Test public void testToValueQualifiedNameInStaticImport() {
		Object value = valueConverterService.toValue("java.lang.String.", "QualifiedNameInStaticImport", null);
		assertEquals("java.lang.String", value);
	}
	
	@Test public void testToStringQualifiedNameInStaticImport() {
		String string = valueConverterService.toString("java.lang.String", "QualifiedNameInStaticImport");
		assertEquals("java.lang.String.", string);
	}
	
	@Test public void testIntWithUnderscore() throws Exception {
		Object value = valueConverterService.toValue("123_456", "INT", null);
		assertTrue(value instanceof Integer);
		assertEquals(123456, ((Integer)value).intValue());
	}
	
	@Test public void testIntOnlyUnderscores() throws Exception {
		try {
			valueConverterService.toValue("___", "INT", null);
			fail("Expected exception");
		} catch(ValueConverterException e) {
			assertTrue(e.getMessage(), e.getMessage().contains("'___'"));
		}
	}
	
	@Test public void testSimple() throws Exception {
		String s = "42";
		Integer value = (Integer) valueConverterService.toValue(s, "INT", null);
		assertEquals(new Integer(42), value);
		assertEquals(s, valueConverterService.toString(value, "INT"));
	}

	@Test public void testZero() throws Exception {
		String s = "0";
		Integer value = (Integer) valueConverterService.toValue(s, "INT", null);
		assertEquals(Integer.valueOf(0), value);
		assertEquals(s, valueConverterService.toString(value, "INT"));
	}

	@Test public void testNegative() throws Exception {
		try {
			valueConverterService.toString(-42, "INT");
			fail("Negative value not detected.");
		} catch (ValueConverterException e) {
			assertTrue(e.getMessage(), e.getMessage().contains("may not be negative"));
			assertTrue(e.getMessage(), e.getMessage().contains("value: -42"));
		}
	}

	@Test public void testNullString() throws Exception {
		try {
			valueConverterService.toValue(null, "INT", null);
			fail("Null string not detected.");
		} catch (ValueConverterException e) {
			assertTrue(e.getMessage(), e.getMessage().contains("empty string"));
		}
	}
	
	@Test public void testNullValue() throws Exception {
		try {
			valueConverterService.toString(null, "INT");
			fail("Null value not detected.");
		} catch (ValueConverterException e) {
			assertTrue(e.getMessage(), e.getMessage().contains("may not be null"));
		}
	}
	
	@Test public void testLargeInteger() throws Exception {
		String valueAsString = Integer.toString(Integer.MAX_VALUE) + "42";
		try {
			valueConverterService.toValue(valueAsString, "INT", null);
			fail("Expected exception");
		} catch(ValueConverterException e) {
			assertTrue(e.getMessage(), e.getMessage().contains(valueAsString));
		}
		
	}

}
