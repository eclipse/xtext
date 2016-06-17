/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.valueconverter;

import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.INTValueConverter;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class INTValueConverterTest extends AbstractXtextTests {

	private INTValueConverter valueConverter;
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
		valueConverter = get(INTValueConverter.class);
		valueConverter.setRule(GrammarUtil.findRuleForName(getGrammarAccess().getGrammar(), "INT"));
	}
	
	@Test public void testSimple() throws Exception {
		String s = "42";
		Integer value = valueConverter.toValue(s, null);
		assertEquals(new Integer(42), value);
		assertEquals(s, valueConverter.toString(value));
	}

	@Test public void testZero() throws Exception {
		String s = "0";
		Integer value = valueConverter.toValue(s, null);
		assertEquals(new Integer(0), value);
		assertEquals(s, valueConverter.toString(value));
	}

	@Test public void testNegative() throws Exception {
		try {
			valueConverter.toString(-42);
			fail("Negative value not detected.");
		} catch (ValueConverterException e) {
			// expected
		}
	}

	@Test public void testNullString() throws Exception {
		try {
			valueConverter.toValue(null, null);
			fail("Null string not detected.");
		} catch (ValueConverterException e) {
			// expected
		}
	}
	
	@Test public void testNullValue() throws Exception {
		try {
			valueConverter.toString(null);
			fail("Null value not detected.");
		} catch (ValueConverterException e) {
			// expected
		}
	}
	
	@Test public void testLargeInteger() throws Exception {
		String valueAsString = Integer.toString(Integer.MAX_VALUE) + "42";
		try {
			valueConverter.toValue(valueAsString, null);
			fail("Expected exception");
		} catch(ValueConverterException e) {
			// expected
		}
		
	}

}
