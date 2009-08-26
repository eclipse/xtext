/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.impl;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractParsetreeUtilTest extends TestCase {

	private char[] separator;

	@Override
	protected void setUp() {
		separator = getSeparator();
	}
	
	protected void checkLineCount(int expected, String text) {
		assertEquals(text, expected, ParsetreeUtil.countLines(text, separator));
	}
	
	public void testCountLines_01() {
		checkLineCount(0, "foo");
		checkLineCount(0, "");
	}
	
	public void testCountLines_02() {
		checkLineCount(0, "foo\r");
		checkLineCount(0, "\r");
	}
	
	public void testCountLines_03() {
		checkLineCount(0, "foo\rbar");
		checkLineCount(0, "\rbar");
	}
	
	public void testCountLines_04() {
		checkLineCount(1, "foo\r\n");
		checkLineCount(1, "\r\n");
		checkLineCount(1, "\r\nbar");
	}
	
	public void testCountLines_05() {
		checkLineCount(1, "foo\n");
		checkLineCount(1, "\n");
		checkLineCount(1, "\nbar");
	}
	
	public void testCountLines_06() {
		checkLineCount(1, "foo\n\r");
		checkLineCount(1, "\n\r");
		checkLineCount(1, "\n\rbar");
	}
	
	protected abstract char[] getSeparator();
	
	public static class Windows extends AbstractParsetreeUtilTest {
		@Override
		protected char[] getSeparator() {
			return "\r\n".toCharArray();
		}
	}
	
	public static class LinuxAndMac extends AbstractParsetreeUtilTest {
		@Override
		protected char[] getSeparator() {
			return "\n".toCharArray();
		}
	}
}
