/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.editorActions;

import com.google.common.base.Objects;
import com.intellij.openapi.editor.EditorModificationUtil;
import com.intellij.openapi.editor.ex.DocumentEx;
import com.intellij.openapi.editor.ex.EditorEx;
import com.intellij.openapi.editor.highlighter.HighlighterIterator;
import com.intellij.psi.tree.TokenSet;
import org.eclipse.xtext.idea.editorActions.AbstractAutoEditBlock;
import org.eclipse.xtext.idea.editorActions.AutoEditContext;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class AutoEditString extends AbstractAutoEditBlock {
  public AutoEditString(final String quote) {
    this(quote, quote);
  }
  
  public AutoEditString(final String openingTerminal, final String closingTerminal) {
    super(openingTerminal, closingTerminal);
    this.setShouldDeleteClosing(true);
  }
  
  @Override
  public void open(final char c, @Extension final AutoEditContext context) {
    context.type(c);
  }
  
  @Override
  public boolean close(final char c, @Extension final AutoEditContext context) {
    int _caretOffset = context.getCaretOffset();
    boolean _isStringLiteral = this.isStringLiteral(_caretOffset, context);
    if (_isStringLiteral) {
      String _closingTerminal = this.getClosingTerminal();
      boolean _isAtTerminal = this.isAtTerminal(_closingTerminal, context);
      if (_isAtTerminal) {
        EditorEx _editor = context.getEditor();
        EditorModificationUtil.moveCaretRelatively(_editor, 1);
        return true;
      }
      return false;
    }
    boolean _shouldInsertClosingQuote = this.shouldInsertClosingQuote(context);
    if (_shouldInsertClosingQuote) {
      final int offset = context.type(c);
      DocumentEx _document = context.getDocument();
      String _closingTerminal_1 = this.getClosingTerminal();
      _document.insertString(offset, _closingTerminal_1);
      return true;
    }
    return false;
  }
  
  protected boolean shouldInsertClosingQuote(@Extension final AutoEditContext context) {
    int _caretOffset = context.getCaretOffset();
    boolean _isIdentifierPart = context.isIdentifierPart(_caretOffset);
    if (_isIdentifierPart) {
      return false;
    }
    boolean _and = false;
    String _openingTerminal = this.getOpeningTerminal();
    String _closingTerminal = this.getClosingTerminal();
    boolean _equals = Objects.equal(_openingTerminal, _closingTerminal);
    if (!_equals) {
      _and = false;
    } else {
      DocumentEx _document = context.getDocument();
      String _text = _document.getText();
      String _openingTerminal_1 = this.getOpeningTerminal();
      int _count = context.count(_text, _openingTerminal_1);
      int _modulo = (_count % 2);
      boolean _notEquals = (_modulo != 0);
      _and = _notEquals;
    }
    if (_and) {
      return false;
    }
    return true;
  }
  
  protected boolean isStringLiteral(final int offset, @Extension final AutoEditContext context) {
    boolean _xblockexpression = false;
    {
      boolean _or = false;
      if ((offset == 0)) {
        _or = true;
      } else {
        DocumentEx _document = context.getDocument();
        int _textLength = _document.getTextLength();
        boolean _equals = (_textLength == offset);
        _or = _equals;
      }
      if (_or) {
        return false;
      }
      TokenSet _tokenSet = context.getTokenSet(offset);
      _xblockexpression = this.isStringLiteral(_tokenSet, context);
    }
    return _xblockexpression;
  }
  
  protected boolean isStringLiteral(final TokenSet tokenSet, @Extension final AutoEditContext context) {
    TokenSet _stringLiteralTokens = context.getStringLiteralTokens();
    return Objects.equal(tokenSet, _stringLiteralTokens);
  }
  
  protected boolean isAtTerminal(final String terminal, @Extension final AutoEditContext context) {
    final int terminalLength = terminal.length();
    final int caretOffset = context.getCaretOffset();
    final HighlighterIterator iterator = context.createTokenIterator(caretOffset);
    boolean _atEnd = iterator.atEnd();
    if (_atEnd) {
      return false;
    }
    final int start = iterator.getStart();
    final int end = iterator.getEnd();
    if (((end - start) < terminalLength)) {
      return false;
    }
    if ((end == caretOffset)) {
      return false;
    }
    final int caretShift = (terminalLength - (end - caretOffset));
    int _xifexpression = (int) 0;
    if ((caretShift > 0)) {
      _xifexpression = (caretOffset - caretShift);
    } else {
      _xifexpression = caretOffset;
    }
    final int beginOffset = _xifexpression;
    String _text = context.getText(beginOffset, (beginOffset + terminalLength));
    return Objects.equal(_text, terminal);
  }
}
