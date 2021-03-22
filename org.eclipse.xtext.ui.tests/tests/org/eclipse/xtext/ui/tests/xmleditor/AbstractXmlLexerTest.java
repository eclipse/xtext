/**
 * Copyright (c) 2019, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.xmleditor;

import org.eclipse.xtext.util.Strings;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public abstract class AbstractXmlLexerTest extends AbstractLexerTest {
	@Rule
	public final Timeout timeout = Timeout.seconds(2);
	
	@Override
	protected void assertLexing(CharSequence modelAsText, CharSequence expected) throws Exception {
		super.assertLexing(Strings.toPlatformLineSeparator(modelAsText), Strings.toPlatformLineSeparator(expected));
	}

	@Test
	public void test001() throws Exception {
		assertLexing("", "");
	}

	@Test
	public void test002() throws Exception {
		String model = "<a/>\n";
		String expectation =
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'a'\n" +
				"RULE_TAG_EMPTY_CLOSE '/>'\n";
		assertLexing(model, expectation);
	}

	@Test
	public void test003() throws Exception {
		String model = "<a b=\"\"/>\n";
		String expectation =
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'a'\n" +
				"RULE_WS ' '\n" +
				"RULE_ID 'b'\n" +
				"RULE_ATTR_EQ '='\n" +
				"RULE_STRING '\"\"'\n" +
				"RULE_TAG_EMPTY_CLOSE '/>'\n";
		assertLexing(model, expectation);
	}

	@Test
	public void test004() throws Exception {
		String model = "<a b=\"c\"/>\n";
		String expectation =
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'a'\n" +
				"RULE_WS ' '\n" +
				"RULE_ID 'b'\n" +
				"RULE_ATTR_EQ '='\n" +
				"RULE_STRING '\"c\"'\n" +
				"RULE_TAG_EMPTY_CLOSE '/>'\n";
		assertLexing(model, expectation);
	}

	@Test
	public void test005() throws Exception {
		String model = "<a b='c'/>\n";
		String expectation =
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'a'\n" +
				"RULE_WS ' '\n" +
				"RULE_ID 'b'\n" +
				"RULE_ATTR_EQ '='\n" +
				"RULE_STRING ''c''\n" +
				"RULE_TAG_EMPTY_CLOSE '/>'\n";
		assertLexing(model, expectation);
	}

	@Test
	public void test006() throws Exception {
		String model = "<a b=\"c\" d='e'/>\n";
		String expectation =
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'a'\n" +
				"RULE_WS ' '\n" +
				"RULE_ID 'b'\n" +
				"RULE_ATTR_EQ '='\n" +
				"RULE_STRING '\"c\"'\n" +
				"RULE_WS ' '\n" +
				"RULE_ID 'd'\n" +
				"RULE_ATTR_EQ '='\n" +
				"RULE_STRING ''e''\n" +
				"RULE_TAG_EMPTY_CLOSE '/>'\n";
		assertLexing(model, expectation);
	}

	@Test
	public void test007() throws Exception {
		String model = "<a b='c' d=\"e\"/>\n";
		String expectation =
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'a'\n" +
				"RULE_WS ' '\n" +
				"RULE_ID 'b'\n" +
				"RULE_ATTR_EQ '='\n" +
				"RULE_STRING ''c''\n" +
				"RULE_WS ' '\n" +
				"RULE_ID 'd'\n" +
				"RULE_ATTR_EQ '='\n" +
				"RULE_STRING '\"e\"'\n" +
				"RULE_TAG_EMPTY_CLOSE '/>'\n";
		assertLexing(model, expectation);
	}

	@Test
	public void test008() throws Exception {
		String model = "<a></a>\n";
		String expectation =
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'a'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_TAG_END_OPEN '</'\n" +
				"RULE_ID 'a'\n" +
				"RULE_TAG_CLOSE '>'\n";
		assertLexing(model, expectation);
	}

	@Test
	public void test009() throws Exception {
		String model = "<a b=\"c\"></a>\n";
		String expectation =
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'a'\n" +
				"RULE_WS ' '\n" +
				"RULE_ID 'b'\n" +
				"RULE_ATTR_EQ '='\n" +
				"RULE_STRING '\"c\"'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_TAG_END_OPEN '</'\n" +
				"RULE_ID 'a'\n" +
				"RULE_TAG_CLOSE '>'\n";
		assertLexing(model, expectation);
	}

	@Test
	public void test010() throws Exception {
		String model = "<a b='c'></a>\n";
		String expectation =
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'a'\n" +
				"RULE_WS ' '\n" +
				"RULE_ID 'b'\n" +
				"RULE_ATTR_EQ '='\n" +
				"RULE_STRING ''c''\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_TAG_END_OPEN '</'\n" +
				"RULE_ID 'a'\n" +
				"RULE_TAG_CLOSE '>'\n";
		assertLexing(model, expectation);
	}

	@Test
	public void test011() throws Exception {
		String model = "<a b='c' d=\"e\"></a>\n";
		String expectation =
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'a'\n" +
				"RULE_WS ' '\n" +
				"RULE_ID 'b'\n" +
				"RULE_ATTR_EQ '='\n" +
				"RULE_STRING ''c''\n" +
				"RULE_WS ' '\n" +
				"RULE_ID 'd'\n" +
				"RULE_ATTR_EQ '='\n" +
				"RULE_STRING '\"e\"'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_TAG_END_OPEN '</'\n" +
				"RULE_ID 'a'\n" +
				"RULE_TAG_CLOSE '>'\n";
		assertLexing(model, expectation);
	}

	@Test
	public void test012() throws Exception {
		String model = "<a b=\"c\" d='e'></a>\n";
		String expectation =
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'a'\n" +
				"RULE_WS ' '\n" +
				"RULE_ID 'b'\n" +
				"RULE_ATTR_EQ '='\n" +
				"RULE_STRING '\"c\"'\n" +
				"RULE_WS ' '\n" +
				"RULE_ID 'd'\n" +
				"RULE_ATTR_EQ '='\n" +
				"RULE_STRING ''e''\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_TAG_END_OPEN '</'\n" +
				"RULE_ID 'a'\n" +
				"RULE_TAG_CLOSE '>'\n";
		assertLexing(model,expectation);
	}

	@Test
	public void test013() throws Exception {
		String model = "<a>text</a>\n";
		String expectation =
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'a'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_PCDATA 'text'\n" +
				"RULE_TAG_END_OPEN '</'\n" +
				"RULE_ID 'a'\n" +
				"RULE_TAG_CLOSE '>'\n";
		assertLexing(model, expectation);
	}

	@Test
	public void test014() throws Exception {
		String model = "<a b=\"c\">text</a>\n";
		String expectation =
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'a'\n" +
				"RULE_WS ' '\n" +
				"RULE_ID 'b'\n" +
				"RULE_ATTR_EQ '='\n" +
				"RULE_STRING '\"c\"'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_PCDATA 'text'\n" +
				"RULE_TAG_END_OPEN '</'\n" +
				"RULE_ID 'a'\n" +
				"RULE_TAG_CLOSE '>'\n";
		assertLexing(model, expectation);
	}

	@Test
	public void test015() throws Exception {
		String model =
				"<a>\n" +
				"	<b>text</b>\n" +
				"</a>\n";
		String expectation =
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'a'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_PCDATA '\n" +
				"	'\n" +
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'b'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_PCDATA 'text'\n" +
				"RULE_TAG_END_OPEN '</'\n" +
				"RULE_ID 'b'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_PCDATA '\n" +
				"'\n" +
				"RULE_TAG_END_OPEN '</'\n" +
				"RULE_ID 'a'\n" +
				"RULE_TAG_CLOSE '>'\n";
		assertLexing(model, expectation);
	}

	@Test
	public void test016() throws Exception {
		String model =
				"<a>\n" +
				"	<b/>\n" +
				"</a>\n";
		String expectation =
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'a'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_PCDATA '\n" +
				"	'\n" +
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'b'\n" +
				"RULE_TAG_EMPTY_CLOSE '/>'\n" +
				"RULE_PCDATA '\n" +
				"'\n" +
				"RULE_TAG_END_OPEN '</'\n" +
				"RULE_ID 'a'\n" +
				"RULE_TAG_CLOSE '>'\n";
		assertLexing(model, expectation);
	}

	@Test
	public void test017() throws Exception {
		String model =
				"<a b=\"c\">\n" +
				"	<d e=\"f\"/>\n" +
				"</a>\n";
		String expectation =
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'a'\n" +
				"RULE_WS ' '\n" +
				"RULE_ID 'b'\n" +
				"RULE_ATTR_EQ '='\n" +
				"RULE_STRING '\"c\"'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_PCDATA '\n" +
				"	'\n" +
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'd'\n" +
				"RULE_WS ' '\n" +
				"RULE_ID 'e'\n" +
				"RULE_ATTR_EQ '='\n" +
				"RULE_STRING '\"f\"'\n" +
				"RULE_TAG_EMPTY_CLOSE '/>'\n" +
				"RULE_PCDATA '\n" +
				"'\n" +
				"RULE_TAG_END_OPEN '</'\n" +
				"RULE_ID 'a'\n" +
				"RULE_TAG_CLOSE '>'\n";
		assertLexing(model, expectation);
	}

	@Test
	public void test018() throws Exception {
		String model =
				"<a>\n" +
				"	<b>c</b>\n" +
				"	<d>e</d>\n" +
				"	<f/>\n" +
				"</a>\n";
		String expectation =
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'a'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_PCDATA '\n" +
				"	'\n" +
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'b'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_PCDATA 'c'\n" +
				"RULE_TAG_END_OPEN '</'\n" +
				"RULE_ID 'b'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_PCDATA '\n" +
				"	'\n" +
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'd'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_PCDATA 'e'\n" +
				"RULE_TAG_END_OPEN '</'\n" +
				"RULE_ID 'd'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_PCDATA '\n" +
				"	'\n" +
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'f'\n" +
				"RULE_TAG_EMPTY_CLOSE '/>'\n" +
				"RULE_PCDATA '\n" +
				"'\n" +
				"RULE_TAG_END_OPEN '</'\n" +
				"RULE_ID 'a'\n" +
				"RULE_TAG_CLOSE '>'\n";
		assertLexing(model, expectation);
	}

	@Test
	public void test019() throws Exception {
		String model =
				"<a>\n" +
				"	<b>\n" +
				"	<c/>\n" +
				"	<d>e</d>\n" +
				"	</b>\n" +
				"</a>\n";
		String expectation =
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'a'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_PCDATA '\n" +
				"	'\n" +
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'b'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_PCDATA '\n" +
				"	'\n" +
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'c'\n" +
				"RULE_TAG_EMPTY_CLOSE '/>'\n" +
				"RULE_PCDATA '\n" +
				"	'\n" +
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'd'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_PCDATA 'e'\n" +
				"RULE_TAG_END_OPEN '</'\n" +
				"RULE_ID 'd'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_PCDATA '\n" +
				"	'\n" +
				"RULE_TAG_END_OPEN '</'\n" +
				"RULE_ID 'b'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_PCDATA '\n" +
				"'\n" +
				"RULE_TAG_END_OPEN '</'\n" +
				"RULE_ID 'a'\n" +
				"RULE_TAG_CLOSE '>'\n";
		assertLexing(model, expectation);
	}

	@Test
	public void test020() throws Exception {
		String model =
				"<a>\n" +
				"	<b>\n" +
				"		<c>d</c>\n" +
				"		<d/>\n" +
				"	</b>\n" +
				"</a>\n";
		String expectation =
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'a'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_PCDATA '\n" +
				"	'\n" +
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'b'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_PCDATA '\n" +
				"		'\n" +
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'c'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_PCDATA 'd'\n" +
				"RULE_TAG_END_OPEN '</'\n" +
				"RULE_ID 'c'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_PCDATA '\n" +
				"		'\n" +
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'd'\n" +
				"RULE_TAG_EMPTY_CLOSE '/>'\n" +
				"RULE_PCDATA '\n" +
				"	'\n" +
				"RULE_TAG_END_OPEN '</'\n" +
				"RULE_ID 'b'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_PCDATA '\n" +
				"'\n" +
				"RULE_TAG_END_OPEN '</'\n" +
				"RULE_ID 'a'\n" +
				"RULE_TAG_CLOSE '>'\n";
		assertLexing(model, expectation);
	}

	@Test
	public void test021() throws Exception {
		String model =
				"<a>\n" +
				"	<b>\n" +
				"		<c>d</c>\n" +
				"		<d e='f'/>\n" +
				"		<g>h</g>\n" +
				"	</b>\n" +
				"</a>\n";
		String expectation =
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'a'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_PCDATA '\n" +
				"	'\n" +
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'b'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_PCDATA '\n" +
				"		'\n" +
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'c'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_PCDATA 'd'\n" +
				"RULE_TAG_END_OPEN '</'\n" +
				"RULE_ID 'c'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_PCDATA '\n" +
				"		'\n" +
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'd'\n" +
				"RULE_WS ' '\n" +
				"RULE_ID 'e'\n" +
				"RULE_ATTR_EQ '='\n" +
				"RULE_STRING ''f''\n" +
				"RULE_TAG_EMPTY_CLOSE '/>'\n" +
				"RULE_PCDATA '\n" +
				"		'\n" +
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'g'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_PCDATA 'h'\n" +
				"RULE_TAG_END_OPEN '</'\n" +
				"RULE_ID 'g'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_PCDATA '\n" +
				"	'\n" +
				"RULE_TAG_END_OPEN '</'\n" +
				"RULE_ID 'b'\n" +
				"RULE_TAG_CLOSE '>'\n" +
				"RULE_PCDATA '\n" +
				"'\n" +
				"RULE_TAG_END_OPEN '</'\n" +
				"RULE_ID 'a'\n" +
				"RULE_TAG_CLOSE '>'\n";
		assertLexing(model, expectation);
	}

	@Test
	public void test022() throws Exception {
		String model = "<a b=\"/>\n";
		String expectation =
				"RULE_TAG_START_OPEN '<'\n" +
				"RULE_ID 'a'\n" +
				"RULE_WS ' '\n" +
				"RULE_ID 'b'\n" +
				"RULE_ATTR_EQ '='\n" +
				"0 '\"'\n" +
				"RULE_TAG_EMPTY_CLOSE '/>'\n";
		assertLexing(model, expectation);
	}
}
