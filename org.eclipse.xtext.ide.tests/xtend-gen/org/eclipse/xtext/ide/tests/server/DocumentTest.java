/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import java.util.Collections;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
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
    Document _document = new Document(1, _normalize);
    final Procedure1<Document> _function = (Document it) -> {
      Position _position = this.position(0, 0);
      int _offSet = it.getOffSet(_position);
      Assert.assertEquals(0, _offSet);
      Position _position_1 = this.position(0, 11);
      int _offSet_1 = it.getOffSet(_position_1);
      Assert.assertEquals(11, _offSet_1);
      try {
        Position _position_2 = this.position(0, 12);
        it.getOffSet(_position_2);
        Assert.fail();
      } catch (final Throwable _t) {
        if (_t instanceof IndexOutOfBoundsException) {
          final IndexOutOfBoundsException e = (IndexOutOfBoundsException)_t;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      Position _position_3 = this.position(1, 0);
      int _offSet_2 = it.getOffSet(_position_3);
      Assert.assertEquals(12, _offSet_2);
      Position _position_4 = this.position(1, 1);
      int _offSet_3 = it.getOffSet(_position_4);
      Assert.assertEquals(13, _offSet_3);
      Position _position_5 = this.position(1, 2);
      int _offSet_4 = it.getOffSet(_position_5);
      Assert.assertEquals(14, _offSet_4);
      Position _position_6 = this.position(2, 0);
      int _offSet_5 = it.getOffSet(_position_6);
      Assert.assertEquals(16, _offSet_5);
      Position _position_7 = this.position(2, 3);
      int _offSet_6 = it.getOffSet(_position_7);
      Assert.assertEquals(19, _offSet_6);
    };
    ObjectExtensions.<Document>operator_doubleArrow(_document, _function);
  }
  
  @Test
  public void testOffSet_empty() {
    Document _document = new Document(1, "");
    final Procedure1<Document> _function = (Document it) -> {
      Position _position = this.position(0, 0);
      int _offSet = it.getOffSet(_position);
      Assert.assertEquals(0, _offSet);
      try {
        Position _position_1 = this.position(0, 12);
        it.getOffSet(_position_1);
        Assert.fail();
      } catch (final Throwable _t) {
        if (_t instanceof IndexOutOfBoundsException) {
          final IndexOutOfBoundsException e = (IndexOutOfBoundsException)_t;
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
    Document _document = new Document(1, _normalize);
    final Procedure1<Document> _function = (Document it) -> {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("hello world");
      _builder_1.newLine();
      _builder_1.append("bar");
      _builder_1.newLine();
      String _normalize_1 = this.normalize(_builder_1);
      Position _position = this.position(1, 0);
      Position _position_1 = this.position(2, 0);
      TextEdit _change = this.change(_position, _position_1, "");
      Document _applyChanges = it.applyChanges(
        Collections.<TextEdit>unmodifiableList(CollectionLiterals.<TextEdit>newArrayList(_change)));
      String _contents = _applyChanges.getContents();
      Assert.assertEquals(_normalize_1, _contents);
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
    Document _document = new Document(1, _normalize);
    final Procedure1<Document> _function = (Document it) -> {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("hello world");
      _builder_1.newLine();
      _builder_1.append("future");
      _builder_1.newLine();
      _builder_1.append("bar");
      _builder_1.newLine();
      String _normalize_1 = this.normalize(_builder_1);
      Position _position = this.position(1, 1);
      Position _position_1 = this.position(1, 3);
      TextEdit _change = this.change(_position, _position_1, "uture");
      Document _applyChanges = it.applyChanges(
        Collections.<TextEdit>unmodifiableList(CollectionLiterals.<TextEdit>newArrayList(_change)));
      String _contents = _applyChanges.getContents();
      Assert.assertEquals(_normalize_1, _contents);
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
    Document _document = new Document(1, _normalize);
    final Procedure1<Document> _function = (Document it) -> {
      Position _position = this.position(0, 0);
      Position _position_1 = this.position(2, 3);
      TextEdit _change = this.change(_position, _position_1, "");
      Document _applyChanges = it.applyChanges(
        Collections.<TextEdit>unmodifiableList(CollectionLiterals.<TextEdit>newArrayList(_change)));
      String _contents = _applyChanges.getContents();
      Assert.assertEquals("", _contents);
    };
    ObjectExtensions.<Document>operator_doubleArrow(_document, _function);
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
    Document _document = new Document(1, _normalize);
    final Procedure1<Document> _function = (Document it) -> {
      TextEdit _change = this.change(null, null, " foo ");
      Document _applyChanges = it.applyChanges(
        Collections.<TextEdit>unmodifiableList(CollectionLiterals.<TextEdit>newArrayList(_change)));
      String _contents = _applyChanges.getContents();
      Assert.assertEquals(" foo ", _contents);
    };
    ObjectExtensions.<Document>operator_doubleArrow(_document, _function);
  }
  
  private TextEdit change(final Position startPos, final Position endPos, final String newText) {
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
    String _string = s.toString();
    return _string.replaceAll("\r", "");
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
