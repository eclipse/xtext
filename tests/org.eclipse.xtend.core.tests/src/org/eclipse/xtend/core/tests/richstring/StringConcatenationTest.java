/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.richstring;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StringConcatenationTest extends Assert {

	private String lineDelimiter = "\n";
	
	@Test public void testImplementsCharSequence_01() {
		CharSequence testMe = new StringConcatenation(lineDelimiter);
		assertEquals("", testMe.toString());
		assertEquals(0, testMe.length());
		try {
			testMe.charAt(0);
			fail("expected IndexOutOfBoundsException");
		} catch(IndexOutOfBoundsException e) {
			// ok
		}
		assertEquals("", testMe.subSequence(0, 0));
		try {
			testMe.subSequence(-1, 0);
			fail("expected IndexOutOfBoundsException");
		} catch(IndexOutOfBoundsException e) {
			// ok
		}
		try {
			testMe.subSequence(1, 1);
			fail("expected IndexOutOfBoundsException");
		} catch(IndexOutOfBoundsException e) {
			// ok
		}
		try {
			testMe.subSequence(0, -1);
			fail("expected IndexOutOfBoundsException");
		} catch(IndexOutOfBoundsException e) {
			// ok
		}
	}
	
	@Test public void testImplementsCharSequence_02() {
		StringConcatenation testMe = new StringConcatenation(lineDelimiter);
		testMe.append("abc");
		assertEquals("abc", testMe.toString());
		assertEquals(3, testMe.length());
		assertEquals('a', testMe.charAt(0));
		assertEquals("", testMe.subSequence(0, 0));
		try {
			testMe.subSequence(-1, 0);
			fail("expected IndexOutOfBoundsException");
		} catch(IndexOutOfBoundsException e) {
			// ok
		}
		assertEquals("", testMe.subSequence(1, 1));
		assertEquals("b", testMe.subSequence(1, 2));
		try {
			testMe.subSequence(1, -1);
			fail("expected IndexOutOfBoundsException");
		} catch(IndexOutOfBoundsException e) {
			// ok
		}
	}
	
	@Test public void testAppend_01() {
		StringConcatenation testMe = new StringConcatenation(lineDelimiter);
		testMe.append("abc");
		testMe.append("abc");
		assertEquals("abcabc", testMe.toString());
	}
	
	@Test public void testAppend_02() {
		StringConcatenation testMe = new StringConcatenation(lineDelimiter);
		testMe.append("abc");
		testMe.newLine();
		testMe.append("abc");
		assertEquals("abc\nabc", testMe.toString());
	}
	
	@Test public void testAppend_03() {
		StringConcatenation testMe = new StringConcatenation(lineDelimiter);
		testMe.newLineIfNotEmpty();
		testMe.append("abc");
		testMe.newLineIfNotEmpty();
		testMe.append("abc");
		assertEquals("abc\nabc", testMe.toString());
	}
	
	@Test public void testAppend_04() {
		StringConcatenation testMe = new StringConcatenation(lineDelimiter);
		testMe.append("abc");
		testMe.newLineIfNotEmpty();
		testMe.append(" ");
		testMe.append("\t");
		testMe.newLineIfNotEmpty();
		testMe.newLineIfNotEmpty();
		testMe.append("abc");
		assertEquals("abc\nabc", testMe.toString());
	}
	
	@Test public void testAppend_05() {
		StringConcatenation testMe = new StringConcatenation(lineDelimiter);
		testMe.append("abc");
		testMe.newLineIfNotEmpty();
		testMe.append(" ");
		testMe.append("\t");
		testMe.newLine();
		testMe.newLineIfNotEmpty();
		testMe.append("abc");
		assertEquals("abc\n \t\nabc", testMe.toString());
	}
	
	@Test public void testAppend_06() {
		StringConcatenation testMe = new StringConcatenation(lineDelimiter);
		testMe.append("abc");
		testMe.newLineIfNotEmpty();
		testMe.append(" ");
		testMe.append("\t");
		testMe.newLineIfNotEmpty();
		testMe.newLine();
		testMe.append("abc");
		assertEquals("abc\n\nabc", testMe.toString());
	}
	
	@Test public void testAppend_07() {
		StringConcatenation testMe = new StringConcatenation(lineDelimiter);
		testMe.append("abc");
		testMe.newLineIfNotEmpty();
		testMe.append(" ");
		assertEquals("abc\n", testMe.toString());
	}

	@Test public void testAppendMultiLine_01() {
		StringConcatenation testMe = new StringConcatenation(lineDelimiter);
		testMe.append("abc\ndef");
		assertEquals("abc\ndef", testMe.toString());
	}
	
	@Test public void testAppendMultiLine_02() {
		StringConcatenation testMe = new StringConcatenation(lineDelimiter);
		testMe.append("abc\rdef");
		assertEquals("abc\ndef", testMe.toString());
	}
	
	@Test public void testAppendMultiLine_03() {
		StringConcatenation testMe = new StringConcatenation(lineDelimiter);
		testMe.append("abc\r\ndef");
		assertEquals("abc\ndef", testMe.toString());
	}
	
	@Test public void testAppendMultiLine_04() {
		StringConcatenation testMe = new StringConcatenation("\r");
		testMe.append("abc\r\ndef");
		assertEquals("abc\rdef", testMe.toString());
	}
	

	@Test public void testAppendIndented_01() {
		StringConcatenation testMe = new StringConcatenation(lineDelimiter);
		testMe.append("abc\ndef", " ");
		assertEquals("abc\n def", testMe.toString());
	}
	
	@Test public void testAppendIndented_02() {
		StringConcatenation testMe = new StringConcatenation(lineDelimiter);
		StringConcatenation appendMe = new StringConcatenation("\r");
		appendMe.append("abc\ndef\nghi");
		appendMe.newLine();
		testMe.append(appendMe, "\t");
		assertEquals("abc\n\tdef\n\tghi\n", testMe.toString());
	}
	
	@Test public void testAppendIndented_03() {
		StringConcatenation testMe = new StringConcatenation(lineDelimiter);
		StringConcatenation appendMe = new StringConcatenation("\r");
		appendMe.append("abc\ndef\nghi");
		appendMe.newLine();
		appendMe.append("  ");
		testMe.append(appendMe, "\t");
		assertEquals("abc\n\tdef\n\tghi\n", testMe.toString());
	}
	
}
