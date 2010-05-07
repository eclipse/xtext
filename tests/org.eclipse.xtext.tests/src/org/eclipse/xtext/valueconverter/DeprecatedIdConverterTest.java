/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.valueconverter;

import junit.framework.TestCase;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.common.services.DefaultTerminalConverters.IDValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;

import com.google.common.collect.ImmutableSet;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public class DeprecatedIdConverterTest extends TestCase {
	
	private IDValueConverter idConverter;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		idConverter = new DefaultTerminalConverters.IDValueConverter(ImmutableSet.of("zonk", "foo"));
	}


	public void testSimple() throws Exception {
		String s = "abc";
		String value = idConverter.toValue(s, null);
		assertEquals("abc", value);
		assertEquals(s, idConverter.toString(value));
	}

	public void testEscaped() throws Exception {
		String s = "zonk";
		String value = idConverter.toString(s);
		assertEquals("^zonk", value);
		assertEquals(s, idConverter.toValue(value, null));
	}
	
	public void testNull() throws Exception {
		try {
			idConverter.toString(null);
			fail("Null value not detected.");
		} catch (ValueConverterException e) {
			// normal operation
//			System.out.println(e.getMessage());
		}
	}

	public void testEmpty() throws Exception {
		try {
			idConverter.toString("");
			fail("Empty value not detected.");
		} catch (ValueConverterException e) {
			// normal operation
//			System.out.println(e.getMessage());
		}
	}

	public void testInvalidChar1() throws Exception {
		try {
			idConverter.toString("^foo");
			fail("invalid char not detected..");
		} catch (ValueConverterException e) {
			// normal operation
//			System.out.println(e.getMessage());
		}
	}

	public void testInvalidChar2() throws Exception {
		try {
			idConverter.toString("foo%bar[]");
			fail("Empty value not detected.");
		} catch (ValueConverterException e) {
			// normal operation
//			System.out.println(e.getMessage());
		}
	}

	public void testInvalidChar3() throws Exception {
		try {
			idConverter.toString("0foo");
			fail("Empty value not detected.");
		} catch (ValueConverterException e) {
			// normal operation
//			System.out.println(e.getMessage());
		}
	}

}
