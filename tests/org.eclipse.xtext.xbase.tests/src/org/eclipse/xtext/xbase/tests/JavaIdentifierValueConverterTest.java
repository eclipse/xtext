/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.xbase.conversion.JavaIdentifierValueConverter;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JavaIdentifierValueConverterTest extends AbstractXbaseTestCase {

	@Inject
	private DefaultTerminalConverters valueConverterService;
	
	@Inject
	private JavaIdentifierValueConverter valueConverter;
	
	@Inject
	private XbaseGrammarAccess grammarAccess;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		valueConverter.setRule(grammarAccess.getIDRule());
	}
	
	public void testGuiceBinding() throws Exception {
		assertTrue(valueConverterService.ID() instanceof JavaIdentifierValueConverter);
	}
	
	public void testToString() {
		assertValidToString("‰ˆ¸ﬂƒ÷‹", "‰ˆ¸ﬂƒ÷‹");
		assertValidToString("‡ÈËÍ…»¿", "‡ÈËÍ…»¿");
		assertValidToString("case", "^case");
		assertValidToString("$A", "$A");		
		assertValidToString("B$A", "B$A");		
		assertInvalidToString("3aaa");
		assertInvalidToString("%");
	}
	
	public void testToValue() throws Exception {
		assertValidToValue("‰ˆ¸ﬂƒ÷‹", "‰ˆ¸ﬂƒ÷‹");
		assertValidToValue("‡ÈËÍ…»¿", "‡ÈËÍ…»¿");
		assertValidToValue("^case", "case");
		assertValidToValue("\u00c4", "ƒ");
		assertValidToValue("$A", "$A");		
		assertValidToValue("B$A", "B$A");		
		assertInvalidToValue("3aaa");
		assertInvalidToValue("%");
	}
	
	protected void assertValidToString(String value, String expectedString) {
		assertEquals(valueConverter.toString(value), expectedString);
	}

	protected void assertInvalidToString(String value) {
		try {
			String string = valueConverter.toString(value);
			fail("Expected ValueConverterException but got '" + string + "'");
		} catch (ValueConverterException e) {
			// expected exception
		}
	}
	protected void assertValidToValue(String string, String expectedValue) throws Exception {
		assertEquals(valueConverter.toValue(string, null), expectedValue);
	}

	protected void assertInvalidToValue(String string) throws Exception {
		try {
			String value = valueConverter.toValue(string, null);
			fail("Expected ValueConverterException but got '" + value + "'");
		} catch (ValueConverterException e) {
			// expected exception
		}
	}
}
