/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist;

import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.ui.contentassist.WhitespaceHelper;
import org.junit.Test;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class WhitespaceHelperTest extends AbstractXtendUITestCase {

	@Inject
	private Provider<WhitespaceHelper> whitespaceHelperProvider;

	@Test public void testOff() throws Exception {
		WhitespaceHelper w = getWhitespaceHelper("xxx|yyy", 1, false, "xxx*yy");
		assertEquals(3, w.getTotalOffset());
		assertEquals(1, w.getTotalLength());
		assertNull(w.getPrefix());
		assertNull(w.getSuffix());
	}

	@Test public void testInsertLines_0() throws Exception {
		String doubleNewLine = Strings.newLine() + Strings.newLine();
		WhitespaceHelper w = getWhitespaceHelper("xxx|yyy", 0, true, "xxx" + doubleNewLine + "*" + doubleNewLine + "yyy");
		assertEquals(3, w.getTotalOffset());
		assertEquals(0, w.getTotalLength());
		assertEquals(doubleNewLine, w.getPrefix());
		assertEquals(doubleNewLine, w.getSuffix());
	}

	@Test public void testInsertLines_1() throws Exception {
		WhitespaceHelper w = getWhitespaceHelper("xxx\n|yyy", 0, true, "xxx\n\n*\n\nyyy");
		assertEquals(4, w.getTotalOffset());
		assertEquals(0, w.getTotalLength());
		assertEquals("\n", w.getPrefix());
		assertEquals("\n\n", w.getSuffix());
	}

	@Test public void testInsertLines_2() throws Exception {
		WhitespaceHelper w = getWhitespaceHelper("xxx\n\n|yyy", 0, true, "xxx\n\n*\n\nyyy");
		assertEquals(4, w.getTotalOffset());
		assertEquals(1, w.getTotalLength());
		assertEquals("\n", w.getPrefix());
		assertEquals("\n\n", w.getSuffix());
	}

	@Test public void testInsertLines_3() throws Exception {
		WhitespaceHelper w = getWhitespaceHelper("xxx|\nyyy", 0, true, "xxx\n\n*\n\nyyy");
		assertEquals(3, w.getTotalOffset());
		assertEquals(0, w.getTotalLength());
		assertEquals("\n\n", w.getPrefix());
		assertEquals("\n", w.getSuffix());
	}

	@Test public void testInsertLines_4() throws Exception {
		WhitespaceHelper w = getWhitespaceHelper("xxx|\n\nyyy", 0, true, "xxx\n\n*\n\nyyy");
		assertEquals(3, w.getTotalOffset());
		assertEquals(0, w.getTotalLength());
		assertEquals("\n\n", w.getPrefix());
		assertNull(w.getSuffix());
	}

	@Test public void testInsertLines_5() throws Exception {
		String doubleNewLine = Strings.newLine() + Strings.newLine();
		WhitespaceHelper w = getWhitespaceHelper("xxx | yyy", 0, true, "xxx "+ doubleNewLine + "*" + doubleNewLine + "yyy");
		assertEquals(4, w.getTotalOffset());
		assertEquals(1, w.getTotalLength());
		assertEquals(doubleNewLine, w.getPrefix());
		assertEquals(doubleNewLine, w.getSuffix());
	}

	@Test public void testInsertLines_6() throws Exception {
		WhitespaceHelper w = getWhitespaceHelper("xxx\n|  yyy", 0, true, "xxx\n\n*\n\nyyy");
		assertEquals(4, w.getTotalOffset());
		assertEquals(2, w.getTotalLength());
		assertEquals("\n", w.getPrefix());
		assertEquals("\n\n", w.getSuffix());
	}

	@Test public void testInsertLines_7() throws Exception {
		WhitespaceHelper w = getWhitespaceHelper("xxx\n\n  |yyy", 0, true, "xxx\n\n*\n\nyyy");
		assertEquals(4, w.getTotalOffset());
		assertEquals(3, w.getTotalLength());
		assertEquals("\n", w.getPrefix());
		assertEquals("\n\n", w.getSuffix());
	}

	@Test public void testInsertLines_8() throws Exception {
		WhitespaceHelper w = getWhitespaceHelper("xxx|  \nyyy", 0, true, "xxx\n\n*\n\nyyy");
		assertEquals(3, w.getTotalOffset());
		assertEquals(2, w.getTotalLength());
		assertEquals("\n\n", w.getPrefix());
		assertEquals("\n", w.getSuffix());
	}

	protected WhitespaceHelper getWhitespaceHelper(String modelWithReplaceMarkup, int length,
			boolean ensureEmptyLinesAround, String expectedAfterInsert) throws Exception {
		int offset = modelWithReplaceMarkup.indexOf('|');
		String model = modelWithReplaceMarkup.replace("|", "");
		IDocument document = new Document(model);
		WhitespaceHelper whitespaceHelper = whitespaceHelperProvider.get();
		whitespaceHelper.initialize(document, offset, length, ensureEmptyLinesAround);
		applyAndCheck(whitespaceHelper, document, expectedAfterInsert);
		return whitespaceHelper;
	}

	protected void applyAndCheck(WhitespaceHelper whitespaceHelper, IDocument document, String expected)
			throws Exception {
		StringBuilder b = new StringBuilder();
		if (whitespaceHelper.getPrefix() != null)
			b.append(whitespaceHelper.getPrefix());
		b.append("*");
		if (whitespaceHelper.getSuffix() != null)
			b.append(whitespaceHelper.getSuffix());
		document.replace(whitespaceHelper.getTotalOffset(), whitespaceHelper.getTotalLength(), b.toString());
		assertEquals(expected, document.get());
	}
}
