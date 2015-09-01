/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.conversion

import com.google.inject.Inject
import org.eclipse.xtend.core.conversion.XtendValueConverterService
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.conversion.ValueConverterException
import org.eclipse.xtext.conversion.ValueConverterWithValueException
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class JavaIDValueConverterTest extends AbstractXtendTestCase {
	
	
	@Inject XtendValueConverterService valueConverterService
	
	@Test def void testSimple() {
		val s = "abc";
		val value = valueConverterService.toValue(s, "ID", null);
		assertEquals("abc", value);
		assertEquals(s, valueConverterService.toString(value, "ID"));
	}
	
	@Test def void testUnicode() {
		val s = "\\u0050";
		val value = valueConverterService.toValue(s, "ID", null);
		assertEquals("P", value);
		assertEquals("P", valueConverterService.toString(value, "ID"));
	}
	
	@Test def void testInvalidUnicode() {
		val s = "a\\u0060";
		try {
			valueConverterService.toValue(s, "ID", null);
		} catch(ValueConverterWithValueException e) {
			val value = e.value as String
			assertEquals("a", value)
		}
	}
	
	@Test def void testUnclosedUnicode_01() {
		val s = "a\\u006";
		try {
			valueConverterService.toValue(s, "ID", null);
		} catch(ValueConverterWithValueException e) {
			val value = e.value as String
			assertEquals("au006", value)
		}
	}
	
	@Test def void testUnclosedUnicode_02() {
		val s = "a\\u";
		try {
			valueConverterService.toValue(s, "ID", null);
		} catch(ValueConverterWithValueException e) {
			val value = e.value as String
			assertEquals("au", value)
		}
	}
	
	@Test def void testTrailingBackslash() {
		val s = "a\\";
		try {
			valueConverterService.toValue(s, "ID", null);
		} catch(ValueConverterWithValueException e) {
			val value = e.value as String
			assertEquals("a", value)
		}
	}
	
	@Test def void testEscaped() {
		val s = "class";
		val value = valueConverterService.toString(s, "ID");
		assertEquals("^class", value);
		assertEquals(s, valueConverterService.toValue(value, "ID", null));
	}

	@Test def void testNull() {
		try {
			valueConverterService.toString(null, "ID");
			fail("Null value not detected.");
		} catch (ValueConverterException e) {
			// normal operation
		}
	}

	@Test def void testEmpty() {
		try {
			valueConverterService.toString("", "ID");
			fail("Empty value not detected.");
		} catch (ValueConverterException e) {
			// normal operation
		}
	}

	@Test def void testInvalidChar1() {
		try {
			valueConverterService.toString("^foo", "ID");
			fail("invalid char not detected..");
		} catch (ValueConverterException e) {
			// normal operation
		}
	}

	@Test def void testInvalidChar2() {
		try {
			valueConverterService.toString("foo%bar[]", "ID");
			fail("Empty value not detected.");
		} catch (ValueConverterException e) {
			// normal operation
		}
	}

	@Test def void testInvalidChar3() {
		try {
			valueConverterService.toString("0foo", "ID");
			fail("Empty value not detected.");
		} catch (ValueConverterException e) {
			// normal operation
		}
	}
	
}