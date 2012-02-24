/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.converison;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ValueConverterTest  extends AbstractXbaseTestCase {

	@Inject
	private IValueConverterService valueConverterService;
	
	@Test public void testINTValueConversion() throws Exception {
		Object value = valueConverterService.toValue("123_456", "INT", null);
		assertTrue(value instanceof Integer);
		assertEquals(123456, ((Integer)value).intValue());
	}
}
