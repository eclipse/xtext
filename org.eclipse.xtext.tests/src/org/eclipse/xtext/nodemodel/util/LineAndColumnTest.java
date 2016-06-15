/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.util;

import org.eclipse.xtext.nodemodel.impl.InternalNodeModelUtils;
import org.eclipse.xtext.util.LineAndColumn;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LineAndColumnTest {

	public static class AccessibleNodeModelUtils extends InternalNodeModelUtils {
		public static int[] computeLineBreaks(String text) {
			return InternalNodeModelUtils.computeLineBreaks(text);					
		}
		public static LineAndColumn getLineAndColumn(String text, int[] lineBreaks, int offset) {
			return InternalNodeModelUtils.getLineAndColumn(text, lineBreaks, offset);
		}
	}
	
	protected void assertLineAndColumn(String text, int offset, int line, int column) {
		doAssertLineAndColumn(text, offset, line, column);
		doAssertLineAndColumn("abc\n" + text, offset + 4, line + 1, column);
		doAssertLineAndColumn("abc\r\n" + text, offset + 5, line + 1, column);
	}
	
	protected void doAssertLineAndColumn(String text, int offset, int line, int column) {
		int[] lineBreaks = AccessibleNodeModelUtils.computeLineBreaks(text);
		LineAndColumn lineAndColumn = AccessibleNodeModelUtils.getLineAndColumn(text, lineBreaks, offset);
		Assert.assertEquals("line", line, lineAndColumn.getLine());
		Assert.assertEquals("column", column, lineAndColumn.getColumn());
		
		LineAndColumn offsetZero = AccessibleNodeModelUtils.getLineAndColumn(text, lineBreaks, 0);
		Assert.assertEquals("line", 1, offsetZero.getLine());
		Assert.assertEquals("column", 1, offsetZero.getColumn());
	}
	
	@Test
	public void testEmptyText() {
		assertLineAndColumn("", 0, 1, 1);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testExceedsOffset() {
		assertLineAndColumn("", 1, -1, -1);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testNegativeOffset() {
		assertLineAndColumn("", -1, -1, -1);
	}
	
	@Test
	public void testSingleCharText() {
		assertLineAndColumn("a", 0, 1, 1);
		assertLineAndColumn("a", 1, 1, 2);
	}

	@Test
	public void testTwoCharsText() {
		assertLineAndColumn("ab", 0, 1, 1);
		assertLineAndColumn("ab", 1, 1, 2);
		assertLineAndColumn("ab", 2, 1, 3);
	}
	
	@Test
	public void testPointsToLineBreak() {
		assertLineAndColumn("\n", 0, 1, 1);
		assertLineAndColumn("\r\n", 0, 1, 1);
	}
	
	@Test
	public void testPointsToBackslashNInWindowsLineBreak() {
		assertLineAndColumn("\r\n", 1, 1, 2);
		assertLineAndColumn("a\r\n", 2, 1, 3);
		assertLineAndColumn("a\r\n", 3, 2, 1);
	}
	
}
