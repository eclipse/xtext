/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.editorActions;

import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.EditorModificationUtil;
import com.intellij.openapi.editor.ex.DocumentEx;
import com.intellij.openapi.editor.ex.EditorEx;
import com.intellij.openapi.editor.highlighter.EditorHighlighter;
import com.intellij.openapi.editor.highlighter.HighlighterIterator;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.idea.editorActions.TokenSetProvider;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@Accessors
@FinalFieldsConstructor
@SuppressWarnings("all")
public class AutoEditContext {
  private final EditorEx editor;
  
  private final TokenSetProvider tokenSetProivder;
  
  public int getCaretOffset() {
    CaretModel _caretModel = this.editor.getCaretModel();
    return _caretModel.getOffset();
  }
  
  public DocumentEx getDocument() {
    return this.editor.getDocument();
  }
  
  public TokenSet getTokenSet(final int offset) {
    return this.tokenSetProivder.getTokenSet(this.editor, offset);
  }
  
  public TokenSet getTokenSet(final HighlighterIterator iterator) {
    IElementType _tokenType = iterator.getTokenType();
    return this.getTokenSet(_tokenType);
  }
  
  public TokenSet getTokenSet(final IElementType tokenType) {
    return this.tokenSetProivder.getTokenSet(tokenType);
  }
  
  public HighlighterIterator createTokenIterator(final int offset) {
    EditorHighlighter _highlighter = this.editor.getHighlighter();
    return _highlighter.createIterator(offset);
  }
  
  public boolean isSameLine(final int offset, final int offset2) {
    int _lineNumber = this.getLineNumber(offset);
    int _lineNumber_1 = this.getLineNumber(offset2);
    return (_lineNumber == _lineNumber_1);
  }
  
  public int getLineNumber(final int offset) {
    DocumentEx _document = this.getDocument();
    return _document.getLineNumber(offset);
  }
  
  public String getText(final int startOffset, final int endOffset) {
    DocumentEx _document = this.getDocument();
    TextRange _textRange = new TextRange(startOffset, endOffset);
    return _document.getText(_textRange);
  }
  
  public boolean isStartOfLine(final int offset) {
    return this.tokenSetProivder.isStartOfLine(this.editor, offset);
  }
  
  public boolean isEndOfLine(final int offset) {
    return this.tokenSetProivder.isEndOfLine(this.editor, offset);
  }
  
  public int type(final char c) {
    String _valueOf = String.valueOf(c);
    return EditorModificationUtil.insertStringAtCaret(this.editor, _valueOf, true, true);
  }
  
  public int count(final String searchMe, final String toFind) {
    final int length = toFind.length();
    int count = 0;
    int index = searchMe.indexOf(toFind);
    while ((index > (-1))) {
      {
        count++;
        int _indexOf = searchMe.indexOf(toFind, (index + length));
        index = _indexOf;
      }
    }
    return count;
  }
  
  public boolean isIdentifierPart(final int offset) {
    boolean _xifexpression = false;
    DocumentEx _document = this.getDocument();
    int _textLength = _document.getTextLength();
    boolean _greaterThan = (_textLength > offset);
    if (_greaterThan) {
      DocumentEx _document_1 = this.getDocument();
      CharSequence _charsSequence = _document_1.getCharsSequence();
      char _charAt = _charsSequence.charAt(offset);
      _xifexpression = Character.isJavaIdentifierPart(_charAt);
    }
    return _xifexpression;
  }
  
  public String newLine(final String content) {
    return ("\n" + content);
  }
  
  public AutoEditContext(final EditorEx editor, final TokenSetProvider tokenSetProivder) {
    super();
    this.editor = editor;
    this.tokenSetProivder = tokenSetProivder;
  }
  
  @Pure
  public EditorEx getEditor() {
    return this.editor;
  }
  
  @Pure
  public TokenSetProvider getTokenSetProivder() {
    return this.tokenSetProivder;
  }
}
