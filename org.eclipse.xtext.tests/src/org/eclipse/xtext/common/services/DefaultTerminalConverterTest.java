/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.common.services;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.INTValueConverter;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultTerminalConverterTest extends Assert {
	
	@Test public void testINT() throws Exception {
		IValueConverter<Integer> valueConverter = new INTValueConverter();
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
		try {
			valueConverter.toValue(null, null);
			fail("exception epxected");
		} catch (ValueConverterException e) {
			// expected
		}
		assertEquals(42,(int) valueConverter.toValue("42", null));
	}
}
