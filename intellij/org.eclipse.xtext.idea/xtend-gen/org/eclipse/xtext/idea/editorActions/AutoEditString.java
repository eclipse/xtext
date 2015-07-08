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
import org.eclipse.xtext.idea.editorActions.AutoEditStringRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class AutoEditString extends AbstractAutoEditBlock {
  private final TokenSet stringLiteralTokens;
  
  public AutoEditString(final String quote, final TokenSet stringLiteralTokens) {
    this(quote, quote, stringLiteralTokens);
  }
  
  public AutoEditString(final String openingTerminal, final String closingTerminal, final TokenSet stringLiteralTokens) {
    super(openingTerminal, closingTerminal);
    this.setShouldDeleteClosing(true);
    this.stringLiteralTokens = stringLiteralTokens;
  }
  
  @Override
  public void open(final char c, @Extension final AutoEditContext context) {
    final int newCaretOffset = context.type(c);
    boolean _shouldInsertClosingQuote = this.shouldInsertClosingQuote(newCaretOffset, context);
    if (_shouldInsertClosingQuote) {
      DocumentEx _document = context.getDocument();
      String _closingTerminal = this.getClosingTerminal();
      _document.insertString(newCaretOffset, _closingTerminal);
    }
  }
  
  @Override
  public boolean close(final char c, @Extension final AutoEditContext context) {
    int _caretOffset = context.getCaretOffset();
    final AutoEditStringRegion stringRegion = this.findRegion(_caretOffset, context);
    boolean _equals = Objects.equal(stringRegion, null);
    if (_equals) {
      return false;
    }
    TextRegion _closingTerminal = stringRegion.getClosingTerminal();
    boolean _equals_1 = Objects.equal(_closingTerminal, null);
    if (_equals_1) {
      context.type(c);
    } else {
      TextRegion _closingTerminal_1 = stringRegion.getClosingTerminal();
      int _caretOffset_1 = context.getCaretOffset();
      boolean _contains = _closingTerminal_1.contains(_caretOffset_1);
      if (_contains) {
        EditorEx _editor = context.getEditor();
        EditorModificationUtil.moveCaretRelatively(_editor, 1);
      } else {
        context.type(c);
      }
    }
    return true;
  }
  
  protected AutoEditStringRegion findRegion(final int offset, @Extension final AutoEditContext context) {
    final TextRegion openingTerminal = this.findOpeningTerminal(offset, context);
    boolean _equals = Objects.equal(openingTerminal, null);
    if (_equals) {
      return null;
    }
    int _offset = openingTerminal.getOffset();
    final TextRegion closingTerminal = this.findClosingTerminal(offset, _offset, context);
    boolean _notEquals = (!Objects.equal(closingTerminal, null));
    if (_notEquals) {
      int _offset_1 = openingTerminal.getOffset();
      boolean _greaterEqualsThan = (_offset_1 >= offset);
      if (_greaterEqualsThan) {
        return null;
      }
      int _offset_2 = closingTerminal.getOffset();
      int _length = closingTerminal.getLength();
      int _plus = (_offset_2 + _length);
      boolean _lessEqualsThan = (_plus <= offset);
      if (_lessEqualsThan) {
        return null;
      }
    }
    return new AutoEditStringRegion(openingTerminal, closingTerminal);
  }
  
  protected TextRegion findOpeningTerminal(final int offset, @Extension final AutoEditContext context) {
    Object _xblockexpression = null;
    {
      final HighlighterIterator iterator = context.createTokenIterator(offset);
      boolean _isStringLiteral = this.isStringLiteral(iterator, context);
      boolean _not = (!_isStringLiteral);
      if (_not) {
        return null;
      }
      while ((!iterator.atEnd())) {
        {
          final TextRegion openingTerminal = this.getOpeningTerminal(iterator, context);
          boolean _notEquals = (!Objects.equal(openingTerminal, null));
          if (_notEquals) {
            return openingTerminal;
          }
          iterator.retreat();
        }
      }
      _xblockexpression = null;
    }
    return ((TextRegion)_xblockexpression);
  }
  
  protected TextRegion findClosingTerminal(final int offset, final int openingTokenOffset, @Extension final AutoEditContext context) {
    Object _xblockexpression = null;
    {
      final HighlighterIterator iterator = context.createTokenIterator(offset);
      boolean _isStringLiteral = this.isStringLiteral(iterator, context);
      boolean _not = (!_isStringLiteral);
      if (_not) {
        return null;
      }
      while ((!iterator.atEnd())) {
        {
          final TextRegion closingTerminal = this.getClosingTerminal(iterator, openingTokenOffset, context);
          boolean _notEquals = (!Objects.equal(closingTerminal, null));
          if (_notEquals) {
            return closingTerminal;
          }
          iterator.advance();
        }
      }
      _xblockexpression = null;
    }
    return ((TextRegion)_xblockexpression);
  }
  
  protected TextRegion getOpeningTerminal(final HighlighterIterator iterator, @Extension final AutoEditContext context) {
    boolean _equals = Objects.equal(iterator, null);
    if (_equals) {
      return null;
    }
    int _end = iterator.getEnd();
    int _start = iterator.getStart();
    int _minus = (_end - _start);
    String _openingTerminal = this.getOpeningTerminal();
    int _length = _openingTerminal.length();
    boolean _lessThan = (_minus < _length);
    if (_lessThan) {
      return null;
    }
    int _start_1 = iterator.getStart();
    int _start_2 = iterator.getStart();
    String _openingTerminal_1 = this.getOpeningTerminal();
    int _length_1 = _openingTerminal_1.length();
    int _plus = (_start_2 + _length_1);
    String _text = context.getText(_start_1, _plus);
    String _openingTerminal_2 = this.getOpeningTerminal();
    boolean _notEquals = (!Objects.equal(_text, _openingTerminal_2));
    if (_notEquals) {
      return null;
    }
    int _start_3 = iterator.getStart();
    String _openingTerminal_3 = this.getOpeningTerminal();
    int _length_2 = _openingTerminal_3.length();
    return new TextRegion(_start_3, _length_2);
  }
  
  protected TextRegion getClosingTerminal(final HighlighterIterator iterator, final int openingTokenOffset, @Extension final AutoEditContext context) {
    boolean _equals = Objects.equal(iterator, null);
    if (_equals) {
      return null;
    }
    int _end = iterator.getEnd();
    int _minus = (_end - openingTokenOffset);
    String _openingTerminal = this.getOpeningTerminal();
    int _length = _openingTerminal.length();
    String _closingTerminal = this.getClosingTerminal();
    int _length_1 = _closingTerminal.length();
    int _plus = (_length + _length_1);
    boolean _lessThan = (_minus < _plus);
    if (_lessThan) {
      return null;
    }
    int _end_1 = iterator.getEnd();
    String _closingTerminal_1 = this.getClosingTerminal();
    int _length_2 = _closingTerminal_1.length();
    int _minus_1 = (_end_1 - _length_2);
    int _end_2 = iterator.getEnd();
    String _text = context.getText(_minus_1, _end_2);
    String _closingTerminal_2 = this.getClosingTerminal();
    boolean _notEquals = (!Objects.equal(_text, _closingTerminal_2));
    if (_notEquals) {
      return null;
    }
    int _end_3 = iterator.getEnd();
    String _closingTerminal_3 = this.getClosingTerminal();
    int _length_3 = _closingTerminal_3.length();
    int _minus_2 = (_end_3 - _length_3);
    String _closingTerminal_4 = this.getClosingTerminal();
    int _length_4 = _closingTerminal_4.length();
    return new TextRegion(_minus_2, _length_4);
  }
  
  protected boolean shouldInsertClosingQuote(final int offset, @Extension final AutoEditContext context) {
    boolean _isIdentifierPart = context.isIdentifierPart(offset);
    return (!_isIdentifierPart);
  }
  
  protected boolean isStringLiteral(final HighlighterIterator iterator, @Extension final AutoEditContext context) {
    boolean _xblockexpression = false;
    {
      boolean _atEnd = iterator.atEnd();
      if (_atEnd) {
        return false;
      }
      TokenSet _tokenSet = context.getTokenSet(iterator);
      _xblockexpression = this.isStringLiteral(_tokenSet, context);
    }
    return _xblockexpression;
  }
  
  protected boolean isStringLiteral(final TokenSet tokenSet, @Extension final AutoEditContext context) {
    return Objects.equal(tokenSet, this.stringLiteralTokens);
  }
}
