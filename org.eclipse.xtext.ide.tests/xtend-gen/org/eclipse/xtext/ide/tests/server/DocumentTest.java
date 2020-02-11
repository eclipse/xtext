/**
 * Copyright (c) 2016, 2019 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import java.util.Collections;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextDocumentContentChangeEvent;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class DocumentTest {
  @Test
  public void testOffSet() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("hello world");
    _builder.newLine();
    _builder.append("foo");
    _builder.newLine();
    _builder.append("bar");
    _builder.newLine();
    String _normalize = this.normalize(_builder);
    Document _document = new Document(Integer.valueOf(1), _normalize);
    final Procedure1<Document> _function = (Document it) -> {
      Assert.assertEquals(0, it.getOffSet(this.position(0, 0)));
      Assert.assertEquals(11, it.getOffSet(this.position(0, 11)));
      try {
        it.getOffSet(this.position(0, 12));
        Assert.fail();
      } catch (final Throwable _t) {
        if (_t instanceof IndexOutOfBoundsException) {
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      Assert.assertEquals(12, it.getOffSet(this.position(1, 0)));
      Assert.assertEquals(13, it.getOffSet(this.position(1, 1)));
      Assert.assertEquals(14, it.getOffSet(this.position(1, 2)));
      Assert.assertEquals(16, it.getOffSet(this.position(2, 0)));
      Assert.assertEquals(19, it.getOffSet(this.position(2, 3)));
    };
    ObjectExtensions.<Document>operator_doubleArrow(_document, _function);
  }
  
  @Test
  public void testOffSet_empty() {
    Document _document = new Document(Integer.valueOf(1), "");
    final Procedure1<Document> _function = (Document it) -> {
      Assert.assertEquals(0, it.getOffSet(this.position(0, 0)));
      try {
        it.getOffSet(this.position(0, 12));
        Assert.fail();
      } catch (final Throwable _t) {
        if (_t instanceof IndexOutOfBoundsException) {
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    };
    ObjectExtensions.<Document>operator_doubleArrow(_document, _function);
  }
  
  @Test
  public void testUpdate_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("hello world");
    _builder.newLine();
    _builder.append("foo");
    _builder.newLine();
    _builder.append("bar");
    _builder.newLine();
    String _normalize = this.normalize(_builder);
    Document _document = new Document(Integer.valueOf(1), _normalize);
    final Procedure1<Document> _function = (Document it) -> {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("hello world");
      _builder_1.newLine();
      _builder_1.append("bar");
      _builder_1.newLine();
      TextDocumentContentChangeEvent _change = this.change(this.position(1, 0), this.position(2, 0), "");
      Assert.assertEquals(this.normalize(_builder_1), it.applyTextDocumentChanges(
        Collections.<TextDocumentContentChangeEvent>unmodifiableList(CollectionLiterals.<TextDocumentContentChangeEvent>newArrayList(_change))).getContents());
    };
    ObjectExtensions.<Document>operator_doubleArrow(_document, _function);
  }
  
  @Test
  public void testUpdate_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("hello world");
    _builder.newLine();
    _builder.append("foo");
    _builder.newLine();
    _builder.append("bar");
    _builder.newLine();
    String _normalize = this.normalize(_builder);
    Document _document = new Document(Integer.valueOf(1), _normalize);
    final Procedure1<Document> _function = (Document it) -> {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("hello world");
      _builder_1.newLine();
      _builder_1.append("future");
      _builder_1.newLine();
      _builder_1.append("bar");
      _builder_1.newLine();
      TextDocumentContentChangeEvent _change = this.change(this.position(1, 1), this.position(1, 3), "uture");
      Assert.assertEquals(this.normalize(_builder_1), it.applyTextDocumentChanges(
        Collections.<TextDocumentContentChangeEvent>unmodifiableList(CollectionLiterals.<TextDocumentContentChangeEvent>newArrayList(_change))).getContents());
    };
    ObjectExtensions.<Document>operator_doubleArrow(_document, _function);
  }
  
  @Test
  public void testUpdate_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("hello world");
    _builder.newLine();
    _builder.append("foo");
    _builder.newLine();
    _builder.append("bar");
    String _normalize = this.normalize(_builder);
    Document _document = new Document(Integer.valueOf(1), _normalize);
    final Procedure1<Document> _function = (Document it) -> {
      TextDocumentContentChangeEvent _change = this.change(this.position(0, 0), this.position(2, 3), "");
      Assert.assertEquals("", it.applyTextDocumentChanges(
        Collections.<TextDocumentContentChangeEvent>unmodifiableList(CollectionLiterals.<TextDocumentContentChangeEvent>newArrayList(_change))).getContents());
    };
    ObjectExtensions.<Document>operator_doubleArrow(_document, _function);
  }
  
  @Test
  public void testApplyTextDocumentChanges_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo");
    _builder.newLine();
    _builder.append("bar");
    _builder.newLine();
    String _normalize = this.normalize(_builder);
    TextDocumentContentChangeEvent _change = this.change(this.position(0, 3), this.position(0, 3), "b");
    TextDocumentContentChangeEvent _change_1 = this.change(this.position(0, 4), this.position(0, 4), "a");
    TextDocumentContentChangeEvent _change_2 = this.change(this.position(0, 5), this.position(0, 5), "r");
    Document _applyTextDocumentChanges = new Document(Integer.valueOf(1), _normalize).applyTextDocumentChanges(
      Collections.<TextDocumentContentChangeEvent>unmodifiableList(CollectionLiterals.<TextDocumentContentChangeEvent>newArrayList(_change, _change_1, _change_2)));
    final Procedure1<Document> _function = (Document it) -> {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("foobar");
      _builder_1.newLine();
      _builder_1.append("bar");
      _builder_1.newLine();
      Assert.assertEquals(this.normalize(_builder_1), it.getContents());
      Assert.assertEquals(2, (it.getVersion()).intValue());
    };
    ObjectExtensions.<Document>operator_doubleArrow(_applyTextDocumentChanges, _function);
  }
  
  @Test
  public void testUpdate_nonIncrementalChange() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("hello world");
    _builder.newLine();
    _builder.append("foo");
    _builder.newLine();
    _builder.append("bar");
    String _normalize = this.normalize(_builder);
    Document _document = new Document(Integer.valueOf(1), _normalize);
    final Procedure1<Document> _function = (Document it) -> {
      TextEdit _textEdit = this.textEdit(null, null, " foo ");
      Assert.assertEquals(" foo ", it.applyChanges(
        Collections.<TextEdit>unmodifiableList(CollectionLiterals.<TextEdit>newArrayList(_textEdit))).getContents());
    };
    ObjectExtensions.<Document>operator_doubleArrow(_document, _function);
  }
  
  @Test(expected = IndexOutOfBoundsException.class)
  public void testGetLineContent_negative() {
    new Document(Integer.valueOf(1), "").getLineContent((-1));
  }
  
  @Test(expected = IndexOutOfBoundsException.class)
  public void testGetLineContent_exceeds() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("aaa");
    _builder.newLine();
    _builder.append("bbb");
    _builder.newLine();
    _builder.append("ccc");
    new Document(Integer.valueOf(1), _builder.toString()).getLineContent(3);
  }
  
  @Test
  public void testGetLineContent_empty() {
    Assert.assertEquals("", new Document(Integer.valueOf(1), "").getLineContent(0));
  }
  
  @Test
  public void testGetLineContent() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("aaa");
    _builder.newLine();
    _builder.append("bbb");
    _builder.newLine();
    _builder.append("ccc");
    Assert.assertEquals("bbb", new Document(Integer.valueOf(1), _builder.toString()).getLineContent(1));
  }
  
  @Test
  public void testGetLineContent_windows_line_endings() {
    Assert.assertEquals("bbb", new Document(Integer.valueOf(1), "aaa\r\nbbb\r\nccc").getLineContent(1));
  }
  
  @Test
  public void testGetLineCount_empty() {
    Assert.assertEquals(1, new Document(Integer.valueOf(1), "").getLineCount());
  }
  
  @Test
  public void testGetLineCount_single() {
    Assert.assertEquals(1, new Document(Integer.valueOf(1), "aaa bbb ccc").getLineCount());
  }
  
  @Test
  public void testGetLineCount_multi() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("aaa");
    _builder.newLine();
    _builder.append("bbb");
    _builder.newLine();
    _builder.append("ccc");
    Assert.assertEquals(3, new Document(Integer.valueOf(1), _builder.toString()).getLineCount());
  }
  
  private TextDocumentContentChangeEvent change(final Position startPos, final Position endPos, final String newText) {
    TextDocumentContentChangeEvent _textDocumentContentChangeEvent = new TextDocumentContentChangeEvent();
    final Procedure1<TextDocumentContentChangeEvent> _function = (TextDocumentContentChangeEvent it) -> {
      if ((startPos != null)) {
        Range _range = new Range();
        final Procedure1<Range> _function_1 = (Range it_1) -> {
          it_1.setStart(startPos);
          it_1.setEnd(endPos);
        };
        Range _doubleArrow = ObjectExtensions.<Range>operator_doubleArrow(_range, _function_1);
        it.setRange(_doubleArrow);
      }
      it.setText(newText);
    };
    return ObjectExtensions.<TextDocumentContentChangeEvent>operator_doubleArrow(_textDocumentContentChangeEvent, _function);
  }
  
  private TextEdit textEdit(final Position startPos, final Position endPos, final String newText) {
    TextEdit _textEdit = new TextEdit();
    final Procedure1<TextEdit> _function = (TextEdit it) -> {
      if ((startPos != null)) {
        Range _range = new Range();
        final Procedure1<Range> _function_1 = (Range it_1) -> {
          it_1.setStart(startPos);
          it_1.setEnd(endPos);
        };
        Range _doubleArrow = ObjectExtensions.<Range>operator_doubleArrow(_range, _function_1);
        it.setRange(_doubleArrow);
      }
      it.setNewText(newText);
    };
    return ObjectExtensions.<TextEdit>operator_doubleArrow(_textEdit, _function);
  }
  
  private String normalize(final CharSequence s) {
    return s.toString().replaceAll("\r", "");
  }
  
  private Position position(final int l, final int c) {
    Position _position = new Position();
    final Procedure1<Position> _function = (Position it) -> {
      it.setLine(l);
      it.setCharacter(c);
    };
    return ObjectExtensions.<Position>operator_doubleArrow(_position, _function);
  }
}
