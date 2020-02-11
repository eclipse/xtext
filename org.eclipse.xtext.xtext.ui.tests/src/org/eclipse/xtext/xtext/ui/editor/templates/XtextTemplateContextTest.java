/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.templates;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateBuffer;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.jface.text.templates.TemplateException;
import org.eclipse.xtext.ui.editor.templates.XtextTemplateContext;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextTemplateContextTest extends Assert {

	private final String NL = System.lineSeparator();

	private Document document;
	private Position position;
	private XtextTemplateContext testMe;

	@Before
	public void setUp() throws Exception {
		document = new Document();
		position = new Position(0);
		testMe = new XtextTemplateContext(new TemplateContextType(), document, position, null, null);
	}

	@After
	public void tearDown() {
		document = null;
		position = null;
		testMe = null;
	}

	@Test
	public void testEmptyDocAndEmptyTemplate() {
		assertTemplateBuffer("", "", 0, "");
	}

	@Test
	public void testBadLocation() {
		assertTemplateBuffer("", "", 1, "");
		assertTemplateBuffer("foo\nbar", "\t", 2, "foo\nbar");
	}

	@Test
	public void testSingleLineTemplate() {
		assertTemplateBuffer("foo", "\t", 1, "foo");
		assertTemplateBuffer("foo", "\t\n", 1, "foo");
	}

	@Test
	public void testMultiLineTemplate() {
		assertTemplateBuffer("foo" + NL + "\tbar", "\t", 1, "foo\nbar");
		assertTemplateBuffer("foo" + NL + "\tbar", "\t", 1, "foo\r\nbar");
		assertTemplateBuffer("foo" + NL + "\tbar", "\t", 1, "foo\rbar");
		assertTemplateBuffer("foo\n\tbar", "\t\n", 1, "foo\nbar");
		assertTemplateBuffer("foo\n\tbar", "\t\n", 1, "foo\r\nbar");
		assertTemplateBuffer("foo\n\tbar", "\t\n", 1, "foo\rbar");
	}

	@Test
	public void testMultiLineTemplateWithPrecedingText() {
		assertTemplateBuffer("foo" + NL + "\tbar", "\tzonk", 5, "foo\nbar");
		assertTemplateBuffer("foo" + NL + "\tbar", "\tzonk", 5, "foo\r\nbar");
		assertTemplateBuffer("foo" + NL + "\tbar", "\tzonk", 5, "foo\rbar");
		assertTemplateBuffer("foo\r\n\tbar", "\tzonk\r\n", 5, "foo\nbar");
		assertTemplateBuffer("foo\r\n\tbar", "\tzonk\r\n", 5, "foo\r\nbar");
		assertTemplateBuffer("foo\r\n\tbar", "\tzonk\r\n", 5, "foo\rbar");
	}

	@Test
	public void testTrailingLineBreak() {
		assertTemplateBuffer("foo" + NL + "\t  ", "\t  ", 3, "foo\n");
		assertTemplateBuffer("foo" + NL + "\t  ", "\t  ", 3, "foo\r\n");
		assertTemplateBuffer("foo" + NL + "\t  ", "\t  ", 3, "foo\r");
		assertTemplateBuffer("foo\r  ", "\t\r  ", 3, "foo\n");
		assertTemplateBuffer("foo\r  ", "\t\r  ", 3, "foo\r\n");
		assertTemplateBuffer("foo\r  ", "\t\r  ", 3, "foo\r");
	}

	protected void assertTemplateBuffer(String expectation, String document, int offset, String pattern) {
		Template template = new Template("", "", "", pattern, false);
		this.document.set(document);
		this.position.setOffset(offset);
		try {
			TemplateBuffer buffer = testMe.evaluate(template);
			assertEquals(expectation, buffer.getString());
		} catch (BadLocationException e) {
			e.printStackTrace();
			fail("Unexpected bad location expection: " + e);
		} catch (TemplateException e) {
			e.printStackTrace();
			fail("Unexpected template expection: " + e);
		}
	}

}
