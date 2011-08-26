/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.conversion;

import org.eclipse.xtext.conversion.ValueConverterWithValueException;
import org.eclipse.xtext.xtend2.conversion.CommentRichTextEndValueConverter;
import org.eclipse.xtext.xtend2.conversion.CommentRichTextInBetweenValueConverter;
import org.eclipse.xtext.xtend2.conversion.RichTextEndValueConverter;
import org.eclipse.xtext.xtend2.conversion.RichTextInBetweenValueConverter;
import org.eclipse.xtext.xtend2.conversion.RichTextStartValueConverter;
import org.eclipse.xtext.xtend2.conversion.RichTextValueConverter;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RichTextValueConverterTest extends AbstractXtend2TestCase {

	public void testRichText() {
		String text = "''' foobar '''";
		String expectation = " foobar ";
		RichTextValueConverter converter = get(RichTextValueConverter.class);
		String value = converter.toValue(text, null);
		assertEquals(expectation, value);
	}
	
	public void testIncompleteRichText_01() {
		String text = "'''foobar   ''";
		String expectation = "foobar   ";
		doTestIncompleteRichString(text, expectation);
	}

	public void testIncompleteRichText_02() {
		String text = "'''foobar   '";
		String expectation = "foobar   ";
		doTestIncompleteRichString(text, expectation);
	}
	
	public void testIncompleteRichText_03() {
		String text = "'''foobar   ";
		String expectation = "foobar   ";
		doTestIncompleteRichString(text, expectation);
	}
	
	public void testIncompleteRichText_04() {
		String text = "'''''";
		String expectation = "";
		doTestIncompleteRichString(text, expectation);
	}
	
	public void testIncompleteRichText_05() {
		String text = "''''";
		String expectation = "";
		doTestIncompleteRichString(text, expectation);
	}
	
	public void testIncompleteRichText_06() {
		String text = "'''";
		String expectation = "";
		doTestIncompleteRichString(text, expectation);
	}
	
	protected void doTestIncompleteRichString(String text, String expectation) {
		RichTextValueConverter converter = get(RichTextValueConverter.class);
		try {
			converter.toValue(text, null);
			fail("Expected ValueConverterWithValueException");
		} catch(ValueConverterWithValueException e) {
			String value = (String) e.getValue();
			assertEquals(expectation, value);
		}
	}
	
	public void testRichTextInBetween() {
		String text = "» foobar  «";
		String expectation = " foobar  ";
		RichTextInBetweenValueConverter converter = get(RichTextInBetweenValueConverter.class);
		String value = converter.toValue(text, null);
		assertEquals(expectation, value);
	}
	
	public void testRichTextStart() {
		String text = "''' foobar«";
		String expectation = " foobar";
		RichTextStartValueConverter converter = get(RichTextStartValueConverter.class);
		String value = converter.toValue(text, null);
		assertEquals(expectation, value);
	}
	
	public void testRichTextEnd() {
		String text = "»foobar   '''";
		String expectation = "foobar   ";
		RichTextEndValueConverter converter = get(RichTextEndValueConverter.class);
		String value = converter.toValue(text, null);
		assertEquals(expectation, value);
	}
	
	public void testIncompleteRichTextEnd_01() {
		String text = "»foobar   ''";
		String expectation = "foobar   ";
		doTestIncompleteRichStringEnd(text, expectation);
	}

	public void testIncompleteRichTextEnd_02() {
		String text = "»foobar   '";
		String expectation = "foobar   ";
		doTestIncompleteRichStringEnd(text, expectation);
	}
	
	public void testIncompleteRichTextEnd_03() {
		String text = "»foobar   ";
		String expectation = "foobar   ";
		doTestIncompleteRichStringEnd(text, expectation);
	}
	
	public void testIncompleteRichTextEnd_04() {
		String text = "»''";
		String expectation = "";
		doTestIncompleteRichStringEnd(text, expectation);
	}
	
	public void testIncompleteRichTextEnd_05() {
		String text = "»'";
		String expectation = "";
		doTestIncompleteRichStringEnd(text, expectation);
	}
	
	public void testIncompleteRichTextEnd_06() {
		String text = "»";
		String expectation = "";
		doTestIncompleteRichStringEnd(text, expectation);
	}
	
	protected void doTestIncompleteRichStringEnd(String text, String expectation) {
		RichTextEndValueConverter converter = get(RichTextEndValueConverter.class);
		try {
			converter.toValue(text, null);
			fail("Expected ValueConverterWithValueException");
		} catch(ValueConverterWithValueException e) {
			String value = (String) e.getValue();
			assertEquals(expectation, value);
		}
	}
	
	public void testCommentRichTextInBetween_01() {
		String text = "«« comment\ncontent\nmoreContent«";
		String expectation = "content\nmoreContent";
		CommentRichTextInBetweenValueConverter converter = get(CommentRichTextInBetweenValueConverter.class);
		String value = converter.toValue(text, null);
		assertEquals(expectation, value);
	}
	
	public void testCommentRichTextInBetween_02() {
		String text = "«« comment\n«";
		String expectation = "";
		CommentRichTextInBetweenValueConverter converter = get(CommentRichTextInBetweenValueConverter.class);
		String value = converter.toValue(text, null);
		assertEquals(expectation, value);
	}
	
	public void testCommentRichTextEnd_01() {
		String text = "«« comment\ncontent'''";
		String expectation = "content";
		CommentRichTextEndValueConverter converter = get(CommentRichTextEndValueConverter.class);
		String value = converter.toValue(text, null);
		assertEquals(expectation, value);
	}
	
	public void testCommentRichTextEnd_02() {
		String text = "«« comment\n'''";
		String expectation = "";
		CommentRichTextEndValueConverter converter = get(CommentRichTextEndValueConverter.class);
		String value = converter.toValue(text, null);
		assertEquals(expectation, value);
	}
}
