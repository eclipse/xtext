/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.common.services;

import junit.framework.TestCase;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class DefaultTerminalConverterTest extends TestCase {
	public void testINT() throws Exception {
		IValueConverter<Integer> valueConverter = new DefaultTerminalConverters().INT();
		try {
			valueConverter.toValue("", null);
			fail("exception epxected");
		} catch (ValueConverterException e) {
			// expected
		}
		try {
			valueConverter.toValue("  ", null);
			fail("exception epxected");
		} catch (ValueConverterException e) {
			// expected
		}
		try {
			valueConverter.toValue("foo", null);
			fail("exception epxected");
		} catch (ValueConverterException e) {
			// expected
		}
		assertEquals(42,(int) valueConverter.toValue("42", null));
	}
}
