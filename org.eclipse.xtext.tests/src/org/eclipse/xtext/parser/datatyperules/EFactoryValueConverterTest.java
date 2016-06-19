/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.datatyperules;

import java.math.BigDecimal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.EFactoryValueConverter;
import org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.CompositeModel;
import org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.Model;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class EFactoryValueConverterTest extends AbstractXtextTests{

	private static final double TEST_DOUBLE_VALUE = -1.3234434E27;
	
	@Test public void testEFactoryValueConverter() throws Exception {
		EFactoryValueConverter eDoubleConverter = new EFactoryValueConverter(EcorePackage.Literals.EDOUBLE);
		String doubleAsString = eDoubleConverter.toString(TEST_DOUBLE_VALUE);
		assertEquals(Double.toString(TEST_DOUBLE_VALUE), doubleAsString);
		Object value = eDoubleConverter.toValue(doubleAsString, null);
		assertTrue(value instanceof Double);
		assertEquals(((Double)value).doubleValue(), TEST_DOUBLE_VALUE, 0.0001);
	}
	
	@Test public void testEBigDecimalConversion() throws Exception {
		EFactoryValueConverter converter = new EFactoryValueConverter(EcorePackage.Literals.EBIG_DECIMAL);
		BigDecimal value = (BigDecimal) converter.toValue(".5", null);
		assertNotNull(value);
		assertEquals(new BigDecimal("0.5"), value);
	}
	
	@Test public void testImplicitEFactoryValueConverter() throws Exception {
		with(DatatypeRulesTestLanguageStandaloneSetup.class);
		EObject model = getModel("a.b.c.d * -2.5E-23 ;");
		assertTrue(model instanceof CompositeModel);
		assertFalse(((CompositeModel)model).getModel().isEmpty());
		model = ((CompositeModel)model).getModel().get(0);
		double myDouble = ((Model) model).getDouble();
		assertEquals(-2.5E-23, myDouble, 0.0001);
	}
	
	@Test public void testEmptyString() {
		EFactoryValueConverter eIntConverter = new EFactoryValueConverter(EcorePackage.Literals.EINT);
		try {
			eIntConverter.toValue("", null);
			fail("EInt converter should not convert empty string");
		} catch(ValueConverterException e) {
			// expected result
		}
		try {
			EFactoryValueConverter eIntegerConverter = new EFactoryValueConverter(EcorePackage.Literals.EINTEGER_OBJECT);
			eIntegerConverter.toValue("", null);
			fail("EInteger converter should not convert empty string");
		} catch(ValueConverterException e) {
			// expected result
			assertTrue(e.getCause() instanceof NumberFormatException);
		}
	}
	
	@Test public void testNullString() {
		EFactoryValueConverter eIntConverter = new EFactoryValueConverter(EcorePackage.Literals.EINT);
		try {
			eIntConverter.toValue(null, null);
			fail("EInt converter should not convert empty string");
		} catch(ValueConverterException e) {
			// expected result
		}
		EFactoryValueConverter eIntegerConverter = new EFactoryValueConverter(EcorePackage.Literals.EINTEGER_OBJECT);
		assertNull(eIntegerConverter.toValue(null, null));
	}
	
}
