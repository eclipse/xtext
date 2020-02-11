/**
 * Copyright (c) 2016, 2019 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server;

import org.eclipse.lsp4j.DidChangeTextDocumentParams;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextDocumentContentChangeEvent;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.11
 */
@Data
@SuppressWarnings("all")
public class Document {
  private final Integer version;
  
  private final String contents;
  
  private final boolean printSourceOnError;
  
  public Document(final Integer version, final String contents) {
    this(version, contents, true);
  }
  
  /**
   * @since 2.15
   */
  public Document(final Integer version, final String contents, final boolean printSourceOnError) {
    this.version = version;
    this.contents = contents;
    this.printSourceOnError = printSourceOnError;
  }
  
  public int getOffSet(final Position position) throws IndexOutOfBoundsException {
    final int l = this.contents.length();
    final char NL = '\n';
    int line = 0;
    int column = 0;
    for (int i = 0; (i < l); i++) {
      {
        final char ch = this.contents.charAt(i);
        if (((position.getLine() == line) && (position.getCharacter() == column))) {
          return i;
        }
        if ((ch == NL)) {
          line++;
          column = 0;
        } else {
          column++;
        }
      }
    }
    if (((position.getLine() == line) && (position.getCharacter() == column))) {
      return l;
    }
    String _string = position.toString();
    String _xifexpression = null;
    if (this.printSourceOnError) {
      _xifexpression = "";
    } else {
      _xifexpression = (" text was : " + this.contents);
    }
    String _plus = (_string + _xifexpression);
    throw new IndexOutOfBoundsException(_plus);
  }
  
  public Position getPosition(final int offset) throws IndexOutOfBoundsException {
    final int l = this.contents.length();
    if (((offset < 0) || (offset > l))) {
      String _xifexpression = null;
      if (this.printSourceOnError) {
        _xifexpression = "";
      } else {
        _xifexpression = (" text was : " + this.contents);
      }
      String _plus = (Integer.valueOf(offset) + _xifexpression);
      throw new IndexOutOfBoundsException(_plus);
    }
    final char NL = '\n';
    int line = 0;
    int column = 0;
    for (int i = 0; (i < l); i++) {
      {
        final char ch = this.contents.charAt(i);
        if ((i == offset)) {
          return new Position(line, column);
        }
        if ((ch == NL)) {
          line++;
          column = 0;
        } else {
          column++;
        }
      }
    }
    return new Position(line, column);
  }
  
  /**
   * Returns with the text for a certain line without the trailing end line marker. Throws an {@link IndexOutOfBoundsException} if the zero-based {@code lineNumber}
   * argument is negative or exceeds the number of lines in the document.
   */
  public String getLineContent(final int lineNumber) throws IndexOutOfBoundsException {
    if ((lineNumber < 0)) {
      String _xifexpression = null;
      if (this.printSourceOnError) {
        _xifexpression = "";
      } else {
        _xifexpression = (" text was : " + this.contents);
      }
      String _plus = (Integer.valueOf(lineNumber) + _xifexpression);
      throw new IndexOutOfBoundsException(_plus);
    }
    final char NL = '\n';
    final char LF = '\r';
    final int l = this.contents.length();
    final StringBuilder lineContent = new StringBuilder();
    int line = 0;
    for (int i = 0; (i < l); i++) {
      {
        if ((line > lineNumber)) {
          return lineContent.toString();
        }
        final char ch = this.contents.charAt(i);
        if ((((line == lineNumber) && (ch != NL)) && (ch != LF))) {
          lineContent.append(ch);
        }
        if ((ch == NL)) {
          line++;
        }
      }
    }
    if ((line < lineNumber)) {
      String _xifexpression_1 = null;
      if (this.printSourceOnError) {
        _xifexpression_1 = "";
      } else {
        _xifexpression_1 = (" text was : " + this.contents);
      }
      String _plus_1 = (Integer.valueOf(lineNumber) + _xifexpression_1);
      throw new IndexOutOfBoundsException(_plus_1);
    }
    return lineContent.toString();
  }
  
  /**
   * Get the number of lines in the document. Empty document has line count: {@code 1}.
   */
  public int getLineCount() {
    int _line = this.getPosition(this.contents.length()).getLine();
    return (_line + 1);
  }
  
  public String getSubstring(final Range range) {
    final int start = this.getOffSet(range.getStart());
    final int end = this.getOffSet(range.getEnd());
    return this.contents.substring(start, end);
  }
  
  /**
   * As opposed to {@link TextEdit}[] the positions in the edits of a
   * {@link DidChangeTextDocumentParams} refer to the state after applying the preceding edits. See
   * https://microsoft.github.io/language-server-protocol/specification#textedit-1 and
   * https://github.com/microsoft/vscode/issues/23173#issuecomment-289378160 for details.
   * 
   * @return a new document with an incremented version and the text document changes applied.
   * @since 2.18
   */
  public Document applyTextDocumentChanges(final Iterable<? extends TextDocumentContentChangeEvent> changes) {
    Document currentDocument = this;
    Integer _xifexpression = null;
    if ((currentDocument.version != null)) {
      _xifexpression = Integer.valueOf(((currentDocument.version).intValue() + 1));
    } else {
      _xifexpression = null;
    }
    final Integer newVersion = _xifexpression;
    for (final TextDocumentContentChangeEvent change : changes) {
      {
        String _xifexpression_1 = null;
        Range _range = change.getRange();
        boolean _tripleEquals = (_range == null);
        if (_tripleEquals) {
          _xifexpression_1 = change.getText();
        } else {
          String _xblockexpression = null;
          {
            final int start = currentDocument.getOffSet(change.getRange().getStart());
            final int end = currentDocument.getOffSet(change.getRange().getEnd());
            String _substring = currentDocument.contents.substring(0, start);
            String _text = change.getText();
            String _plus = (_substring + _text);
            String _substring_1 = currentDocument.contents.substring(end);
            _xblockexpression = (_plus + _substring_1);
          }
          _xifexpression_1 = _xblockexpression;
        }
        final String newContent = _xifexpression_1;
        Document _document = new Document(newVersion, newContent, this.printSourceOnError);
        currentDocument = _document;
      }
    }
    return currentDocument;
  }
  
  /**
   * Only use for testing.
   * 
   * All positions in the {@link TextEdit}s refer to the same original document (this).
   */
  public Document applyChanges(final Iterable<? extends TextEdit> changes) {
    String newContent = this.contents;
    for (final TextEdit change : changes) {
      Range _range = change.getRange();
      boolean _tripleEquals = (_range == null);
      if (_tripleEquals) {
        newContent = change.getNewText();
      } else {
        final int start = this.getOffSet(change.getRange().getStart());
        final int end = this.getOffSet(change.getRange().getEnd());
        String _substring = newContent.substring(0, start);
        String _newText = change.getNewText();
        String _plus = (_substring + _newText);
        String _substring_1 = newContent.substring(end);
        String _plus_1 = (_plus + _substring_1);
        newContent = _plus_1;
      }
    }
    Integer _xifexpression = null;
    if ((this.version != null)) {
      _xifexpression = Integer.valueOf(((this.version).intValue() + 1));
    } else {
      _xifexpression = null;
    }
    return new Document(_xifexpression, newContent);
  }
  
  /**
   * @since 2.15
   */
  @Pure
  public boolean isPrintSourceOnError() {
    return this.printSourceOnError;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.version== null) ? 0 : this.version.hashCode());
    result = prime * result + ((this.contents== null) ? 0 : this.contents.hashCode());
    return prime * result + (this.printSourceOnError ? 1231 : 1237);
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Document other = (Document) obj;
    if (this.version == null) {
      if (other.version != null)
        return false;
    } else if (!this.version.equals(other.version))
      return false;
    if (this.contents == null) {
      if (other.contents != null)
        return false;
    } else if (!this.contents.equals(other.contents))
      return false;
    if (other.printSourceOnError != this.printSourceOnError)
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("version", this.version);
    b.add("contents", this.contents);
    b.add("printSourceOnError", this.printSourceOnError);
    return b.toString();
  }
  
  @Pure
  public Integer getVersion() {
    return this.version;
  }
  
  @Pure
  public String getContents() {
    return this.contents;
  }
}
