/**
 * Copyright (c) 2019, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.xmleditor;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.ui.tests.xmleditor.simplexml.XmlDocument;
import org.eclipse.xtext.ui.tests.xmleditor.tests.XmlInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(XmlInjectorProvider.class)
public class XmlParsingTest {
	@Inject
	private ParseHelper<XmlDocument> parseHelper;

	@Inject
	private ValidationTestHelper validationTestHelper;

	@Test
	public void test001() throws Exception {
		XmlDocument model = parseHelper.parse("");
		validationTestHelper.assertNoErrors(model);
	}

	@Test
	public void test002() throws Exception {
		XmlDocument model = parseHelper.parse("<a/>");
		validationTestHelper.assertNoErrors(model);
	}

	@Test
	public void test003() throws Exception {
		XmlDocument model = parseHelper.parse("<a b=''/>");
		validationTestHelper.assertNoErrors(model);
	}

	@Test
	public void test004() throws Exception {
		XmlDocument model = parseHelper.parse("<a b='c'/>");
		validationTestHelper.assertNoErrors(model);
	}

	@Test
	public void test005() throws Exception {
		XmlDocument model = parseHelper.parse("<a b='c'/>");
		validationTestHelper.assertNoErrors(model);
	}

	@Test
	public void test006() throws Exception {
		XmlDocument model = parseHelper.parse("<a b=\"c\" d='e'/>");
		validationTestHelper.assertNoErrors(model);
	}

	@Test
	public void test007() throws Exception {
		XmlDocument model = parseHelper.parse("<a b='c' d=\"e\"/>");
		validationTestHelper.assertNoErrors(model);
	}

	@Test
	public void test008() throws Exception {
		XmlDocument model = parseHelper.parse("<a></a>");
		validationTestHelper.assertNoErrors(model);
	}

	@Test
	public void test009() throws Exception {
		XmlDocument model = parseHelper.parse("<a b=\"c\"></a>");
		validationTestHelper.assertNoErrors(model);
	}

	@Test
	public void test010() throws Exception {
		XmlDocument model = parseHelper.parse("<a b='c'></a>");
		validationTestHelper.assertNoErrors(model);
	}

	@Test
	public void test011() throws Exception {
		XmlDocument model = parseHelper.parse("<a b='c' d=\"e\"></a>");
		validationTestHelper.assertNoErrors(model);
	}

	@Test
	public void test012() throws Exception {
		XmlDocument model = parseHelper.parse("<a b=\"c\" d='e'></a>");
		validationTestHelper.assertNoErrors(model);
	}

	@Test
	public void test013() throws Exception {
		XmlDocument model = parseHelper.parse("<a>text</a>");
		validationTestHelper.assertNoErrors(model);
	}

	@Test
	public void test014() throws Exception {
		XmlDocument model = parseHelper.parse("<a b=\"c\">text</a>");
		validationTestHelper.assertNoErrors(model);
	}

	@Test
	public void test015() throws Exception {
		XmlDocument model = parseHelper.parse(
				"<a>\n" +
				"	<b>text</b>\n" +
				"</a>\n");
		validationTestHelper.assertNoErrors(model);
	}

	@Test
	public void test016() throws Exception {
		XmlDocument model = parseHelper.parse(
				"<a>\n" +
				"	<b/>\n" +
				"</a>\n");
		validationTestHelper.assertNoErrors(model);
	}

	@Test
	public void test017() throws Exception {
		XmlDocument model = parseHelper.parse(
				"<a b='c'>\n" +
				"	<d e='f'/>\n" +
				"</a>\n");
		validationTestHelper.assertNoErrors(model);
	}

	@Test
	public void test018() throws Exception {
		XmlDocument model = parseHelper.parse(
				"<a>\n" +
				"	<b>c</b>\n" +
				"	<d>e</d>\n" +
				"	<f/>\n" +
				"</a>\n");
		validationTestHelper.assertNoErrors(model);
	}

	@Test
	public void test019() throws Exception {
		XmlDocument model = parseHelper.parse(
				"<a>\n" +
				"	<b>\n" +
				"	<c/>\n" +
				"	<d>e</d>\n" +
				"	</b>\n" +
				"</a>\n");
		validationTestHelper.assertNoErrors(model);
	}

	@Test
	public void test020() throws Exception {
		XmlDocument model = parseHelper.parse(
				"<a>\n" +
				"	<b>\n" +
				"		<c>d</c>\n" +
				"		<d/>\n" +
				"	</b>\n" +
				"</a>\n");
		validationTestHelper.assertNoErrors(model);
	}

	@Test
	public void test021() throws Exception {
		XmlDocument model = parseHelper.parse(
				"<a>\n" +
				"	<b>\n" +
				"		<c>d</c>\n" +
				"		<d e='f'/>\n" +
				"		<g>h</g>\n" +
				"	</b>\n" +
				"</a>\n");
		validationTestHelper.assertNoErrors(model);
	}
}
