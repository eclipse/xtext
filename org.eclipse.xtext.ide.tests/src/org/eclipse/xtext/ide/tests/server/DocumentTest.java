/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextDocumentContentChangeEvent;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.xtext.ide.server.Document;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * @author efftinge - Initial contribution and API
 */
public class DocumentTest {
	@Test
	public void testOffSet() {
		String model =
				"hello world\n" +
				"foo\n" +
				"bar\n";
		Document document = new Document(1, model);
		Assert.assertEquals(0, document.getOffSet(position(0, 0)));
		Assert.assertEquals(11, document.getOffSet(position(0, 11)));
		try {
			document.getOffSet(position(0, 12));
			Assert.fail();
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
		Assert.assertEquals(12, document.getOffSet(position(1, 0)));
		Assert.assertEquals(13, document.getOffSet(position(1, 1)));
		Assert.assertEquals(14, document.getOffSet(position(1, 2)));
		Assert.assertEquals(16, document.getOffSet(position(2, 0)));
		Assert.assertEquals(19, document.getOffSet(position(2, 3)));
	}

	@Test
	public void testOffSet_empty() {
		Document document = new Document(1, "");
		Assert.assertEquals(0, document.getOffSet(position(0, 0)));
		try {
			document.getOffSet(position(0, 12));
			Assert.fail();
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
	}

	@Test
	public void testUpdate_01() {
		String model =
				"hello world\n" +
				"foo\n" +
				"bar\n";
		Document document = new Document(1, model);
		String expectedModelAfterChange =
				"hello world\n" +
				"bar\n";
		Assert.assertEquals(expectedModelAfterChange,
				document.applyTextDocumentChanges(Lists.newArrayList(change(position(1, 0), position(2, 0), "")))
						.getContents());
	}

	@Test
	public void testUpdate_02() {
		String model =
				"hello world\n" +
				"foo\n" +
				"bar\n";
		Document document = new Document(1, model);
		String expectedModelAfterChange =
				"hello world\n" +
				"future\n" +
				"bar\n";
		Assert.assertEquals(expectedModelAfterChange,
				document.applyTextDocumentChanges(Lists.newArrayList(change(position(1, 1), position(1, 3), "uture")))
						.getContents());
	}

	@Test
	public void testUpdate_03() {
		String model =
				"hello world\n" +
				"foo\n" +
				"bar";
		Document document = new Document(1, model);
		Assert.assertEquals("",
				document.applyTextDocumentChanges(Lists.newArrayList(change(position(0, 0), position(2, 3), "")))
						.getContents());
	}

	@Test
	public void testApplyTextDocumentChanges_04() {
		String model =
				"foo\n" +
				"bar\n";
		Document changedDocument = new Document(1, model)
				.applyTextDocumentChanges(Lists.newArrayList(change(position(0, 3), position(0, 3), "b"),
						change(position(0, 4), position(0, 4), "a"), change(position(0, 5), position(0, 5), "r")));
		String expectedModelAfterChange =
				"foobar\n" +
				"bar\n";
		Assert.assertEquals(expectedModelAfterChange, changedDocument.getContents());
		Assert.assertEquals(2, changedDocument.getVersion().intValue());
	}

	@Test
	public void testUpdate_nonIncrementalChange() {
		String model =
				"hello world\n" +
				"foo\n" +
				"bar";
		Document document = new Document(1, model);
		Assert.assertEquals(" foo ",
				document.applyChanges(Lists.newArrayList(textEdit(null, null, " foo "))).getContents());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetLineContent_negative() {
		new Document(1, "").getLineContent(-1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetLineContent_exceeds() {
		String model =
				"aaa\n" +
				"bbb\n" +
				"ccc";
		new Document(1, model).getLineContent(3);
	}

	@Test
	public void testGetLineContent_empty() {
		Assert.assertEquals("", new Document(1, "").getLineContent(0));
	}

	@Test
	public void testGetLineContent() {
		String model =
				"aaa\n" +
				"bbb\n" +
				"ccc";
		Assert.assertEquals("bbb", new Document(1, model).getLineContent(1));
	}

	@Test
	public void testGetLineContent_windows_line_endings() {
		String model =
				"aaa\r\n" +
				"bbb\r\n" +
				"ccc";
		Assert.assertEquals("bbb", new Document(1, model).getLineContent(1));
	}

	@Test
	public void testGetLineCount_empty() {
		Assert.assertEquals(1, new Document(1, "").getLineCount());
	}

	@Test
	public void testGetLineCount_single() {
		Assert.assertEquals(1, new Document(1, "aaa bbb ccc").getLineCount());
	}

	@Test
	public void testGetLineCount_multi() {
		String model =
				"aaa\n" +
				"bbb\n" +
				"ccc";
		Assert.assertEquals(3, new Document(1, model).getLineCount());
	}

	private TextDocumentContentChangeEvent change(Position startPos, Position endPos, String newText) {
		TextDocumentContentChangeEvent textDocumentContentChangeEvent = new TextDocumentContentChangeEvent();
		if (startPos != null) {
			textDocumentContentChangeEvent.setRange(new Range(startPos, endPos));
		}
		textDocumentContentChangeEvent.setText(newText);
		return textDocumentContentChangeEvent;
	}

	private TextEdit textEdit(Position startPos, Position endPos, String newText) {
		TextEdit textEdit = new TextEdit();
		if (startPos != null) {
			textEdit.setRange(new Range(startPos, endPos));
		}
		textEdit.setNewText(newText);
		return textEdit;
	}

	private Position position(int l, int c) {
		return new Position(l, c);
	}
}
