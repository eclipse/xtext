/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractStringsCountLinesTest extends Assert {

	private char[] separator;

	@Before
	public void setUp() {
		separator = getSeparator();
	}
	
	protected void checkLineCount(int expected, String text) {
		assertEquals(text, expected, Strings.countLines(text, separator));
	}
	
	@Test public void testCountLines_01() {
		checkLineCount(0, "foo");
		checkLineCount(0, "");
	}
	
	@Test public void testCountLines_02() {
		checkLineCount(0, "foo\r");
		checkLineCount(0, "\r");
	}
	
	@Test public void testCountLines_03() {
		checkLineCount(0, "foo\rbar");
		checkLineCount(0, "\rbar");
	}
	
	@Test public void testCountLines_04() {
		checkLineCount(1, "foo\r\n");
		checkLineCount(1, "\r\n");
		checkLineCount(1, "\r\nbar");
	}
	
	@Test public void testCountLines_05() {
		checkLineCount(1, "foo\n");
		checkLineCount(1, "\n");
		checkLineCount(1, "\nbar");
	}
	
	@Test public void testCountLines_06() {
		checkLineCount(1, "foo\n\r");
		checkLineCount(1, "\n\r");
		checkLineCount(1, "\n\rbar");
	}
	
	protected abstract char[] getSeparator();
}
