/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextTemplateContextTest extends TestCase {

	private Document document;
	private Position position;
	private XtextTemplateContext testMe;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		document = new Document();
		position = new Position(0);
		testMe = new XtextTemplateContext(new TemplateContextType(), document, position, null, null);
	}
	
	public void testEmptyDocAndEmptyTemplate() {
		assertTemplateBuffer("", "", 0, "");
	}
	
	public void testBadLocation() {
		assertTemplateBuffer("", "", 1, "");
		assertTemplateBuffer("foo\nbar", "\t", 2, "foo\nbar");
	}
	
	public void testSingleLineTemplate() {
		assertTemplateBuffer("foo", "\t", 1, "foo");
	}
	
	public void testMultiLineTemplate() {
		assertTemplateBuffer("foo\n\tbar", "\t", 1, "foo\nbar");
		assertTemplateBuffer("foo\r\n\tbar", "\t", 1, "foo\r\nbar");
		assertTemplateBuffer("foo\r\tbar", "\t", 1, "foo\rbar");
	}
	
	public void testMultiLineTemplateWithPrecedingText() {
		assertTemplateBuffer("foo\n\tbar", "\tzonk", 5, "foo\nbar");
		assertTemplateBuffer("foo\r\n\tbar", "\tzonk", 5, "foo\r\nbar");
		assertTemplateBuffer("foo\r\tbar", "\tzonk", 5, "foo\rbar");
	}
	
	public void testTrailingLineBreak() {
		assertTemplateBuffer("foo\n\t  ", "\t  ", 3, "foo\n");
		assertTemplateBuffer("foo\r\n\t  ", "\t  ", 3, "foo\r\n");
		assertTemplateBuffer("foo\r\t  ", "\t  ", 3, "foo\r");
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
