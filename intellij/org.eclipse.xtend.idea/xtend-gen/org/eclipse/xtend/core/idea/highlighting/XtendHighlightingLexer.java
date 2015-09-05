/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.highlighting;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.lexer.LexerBase;
import com.intellij.lexer.LexerPosition;
import com.intellij.psi.tree.IElementType;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.antlr.runtime.CommonToken;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtend.ide.common.highlighting.XtendHighlightingStyles;
import org.eclipse.xtext.idea.parser.AntlrDelegatingIdeaLexer;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendHighlightingLexer extends LexerBase {
  protected static class RichTextToken {
    private int index = 0;
    
    private int[] offsets;
    
    private int[] lengths;
    
    private boolean delimiter;
    
    private IElementType tokenType;
    
    public int getTokenLength() {
      return this.lengths[this.index];
    }
    
    public int getTokenOffset() {
      return this.offsets[this.index];
    }
    
    public boolean hasNext() {
      int _length = this.offsets.length;
      int _minus = (_length - 1);
      return (this.index < _minus);
    }
    
    public boolean advance() {
      boolean _xblockexpression = false;
      {
        this.index++;
        _xblockexpression = this.delimiter = (!this.delimiter);
      }
      return _xblockexpression;
    }
    
    public IElementType getTokenType() {
      IElementType _xifexpression = null;
      if (this.delimiter) {
        _xifexpression = XtendHighlightingLexer.GUILLEMET_ELEMENT_TYPE;
      } else {
        _xifexpression = this.tokenType;
      }
      return _xifexpression;
    }
    
    public short getType() {
      short _xifexpression = (short) 0;
      if (this.delimiter) {
        _xifexpression = XtendHighlightingLexer.GUILLEMET_ELEMENT_TYPE.getIndex();
      } else {
        _xifexpression = this.tokenType.getIndex();
      }
      return _xifexpression;
    }
  }
  
  public final static IElementType GUILLEMET_ELEMENT_TYPE = new IElementType(XtendHighlightingStyles.RICH_TEXT_DELIMITER_ID, 
    XtendLanguage.INSTANCE);
  
  private final static Set<String> TOKEN_TYPE_NAMES_CONTAINING_GUILLEMETS = Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("RULE_RICH_TEXT_START", "RULE_RICH_TEXT_END", "RULE_RICH_TEXT_INBETWEEN", "RULE_COMMENT_RICH_TEXT_INBETWEEN", "RULE_COMMENT_RICH_TEXT_END"));
  
  @Inject
  private AntlrDelegatingIdeaLexer delegate;
  
  @Inject
  @Extension
  private AntlrTokenDefProvider _antlrTokenDefProvider;
  
  private XtendHighlightingLexer.RichTextToken _currentRichTextToken;
  
  @Override
  public void advance() {
    XtendHighlightingLexer.RichTextToken _currentRichTextToken = this.getCurrentRichTextToken();
    boolean _hasNext = false;
    if (_currentRichTextToken!=null) {
      _hasNext=_currentRichTextToken.hasNext();
    }
    if (_hasNext) {
      XtendHighlightingLexer.RichTextToken _currentRichTextToken_1 = this.getCurrentRichTextToken();
      _currentRichTextToken_1.advance();
    } else {
      this._currentRichTextToken = null;
      this.delegate.advance();
    }
  }
  
  public XtendHighlightingLexer.RichTextToken getCurrentRichTextToken() {
    boolean _equals = Objects.equal(this._currentRichTextToken, null);
    if (_equals) {
      CommonToken _currentToken = this.delegate.getCurrentToken();
      boolean _notEquals = (!Objects.equal(_currentToken, null));
      if (_notEquals) {
        Map<Integer, String> _tokenDefMap = this._antlrTokenDefProvider.getTokenDefMap();
        CommonToken _currentToken_1 = this.delegate.getCurrentToken();
        int _type = _currentToken_1.getType();
        final String tokenID = _tokenDefMap.get(Integer.valueOf(_type));
        boolean _contains = XtendHighlightingLexer.TOKEN_TYPE_NAMES_CONTAINING_GUILLEMETS.contains(tokenID);
        if (_contains) {
          int _tokenStart = this.delegate.getTokenStart();
          int _tokenEnd = this.delegate.getTokenEnd();
          int _tokenStart_1 = this.delegate.getTokenStart();
          int _minus = (_tokenEnd - _tokenStart_1);
          IElementType _tokenType = this.delegate.getTokenType();
          XtendHighlightingLexer.RichTextToken _createRichTextToken = this.createRichTextToken(tokenID, _tokenStart, _minus, _tokenType);
          this._currentRichTextToken = _createRichTextToken;
        }
      }
    }
    return this._currentRichTextToken;
  }
  
  @Override
  public int getState() {
    int _xifexpression = (int) 0;
    XtendHighlightingLexer.RichTextToken _currentRichTextToken = this.getCurrentRichTextToken();
    boolean _notEquals = (!Objects.equal(_currentRichTextToken, null));
    if (_notEquals) {
      XtendHighlightingLexer.RichTextToken _currentRichTextToken_1 = this.getCurrentRichTextToken();
      _xifexpression = _currentRichTextToken_1.getType();
    } else {
      _xifexpression = this.delegate.getState();
    }
    return _xifexpression;
  }
  
  @Override
  public int getTokenEnd() {
    int _xifexpression = (int) 0;
    XtendHighlightingLexer.RichTextToken _currentRichTextToken = this.getCurrentRichTextToken();
    boolean _notEquals = (!Objects.equal(_currentRichTextToken, null));
    if (_notEquals) {
      XtendHighlightingLexer.RichTextToken _currentRichTextToken_1 = this.getCurrentRichTextToken();
      int _tokenOffset = _currentRichTextToken_1.getTokenOffset();
      XtendHighlightingLexer.RichTextToken _currentRichTextToken_2 = this.getCurrentRichTextToken();
      int _tokenLength = _currentRichTextToken_2.getTokenLength();
      _xifexpression = (_tokenOffset + _tokenLength);
    } else {
      _xifexpression = this.delegate.getTokenEnd();
    }
    return _xifexpression;
  }
  
  @Override
  public int getTokenStart() {
    int _xifexpression = (int) 0;
    XtendHighlightingLexer.RichTextToken _currentRichTextToken = this.getCurrentRichTextToken();
    boolean _notEquals = (!Objects.equal(_currentRichTextToken, null));
    if (_notEquals) {
      XtendHighlightingLexer.RichTextToken _currentRichTextToken_1 = this.getCurrentRichTextToken();
      _xifexpression = _currentRichTextToken_1.getTokenOffset();
    } else {
      _xifexpression = this.delegate.getTokenStart();
    }
    return _xifexpression;
  }
  
  @Override
  public IElementType getTokenType() {
    IElementType _xifexpression = null;
    XtendHighlightingLexer.RichTextToken _currentRichTextToken = this.getCurrentRichTextToken();
    boolean _notEquals = (!Objects.equal(_currentRichTextToken, null));
    if (_notEquals) {
      XtendHighlightingLexer.RichTextToken _currentRichTextToken_1 = this.getCurrentRichTextToken();
      _xifexpression = _currentRichTextToken_1.getTokenType();
    } else {
      _xifexpression = this.delegate.getTokenType();
    }
    return _xifexpression;
  }
  
  @Override
  public void start(final CharSequence buffer, final int startOffset, final int endOffset, final int initialState) {
    this.delegate.start(buffer, startOffset, endOffset, initialState);
    this._currentRichTextToken = null;
  }
  
  @Override
  public int getBufferEnd() {
    return this.delegate.getBufferEnd();
  }
  
  @Override
  public CharSequence getBufferSequence() {
    return this.delegate.getBufferSequence();
  }
  
  @Override
  public void restore(final LexerPosition position) {
    throw new UnsupportedOperationException();
  }
  
  protected XtendHighlightingLexer.RichTextToken createRichTextToken(final String id, final int tokenOffset, final int tokenLength, final IElementType tokenType) {
    XtendHighlightingLexer.RichTextToken _richTextToken = new XtendHighlightingLexer.RichTextToken();
    final Procedure1<XtendHighlightingLexer.RichTextToken> _function = new Procedure1<XtendHighlightingLexer.RichTextToken>() {
      @Override
      public void apply(final XtendHighlightingLexer.RichTextToken it) {
        it.tokenType = tokenType;
      }
    };
    final XtendHighlightingLexer.RichTextToken result = ObjectExtensions.<XtendHighlightingLexer.RichTextToken>operator_doubleArrow(_richTextToken, _function);
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(id, "RULE_RICH_TEXT_START")) {
        _matched=true;
        result.delimiter = false;
        result.offsets = new int[] { tokenOffset, ((tokenOffset + tokenLength) - 1) };
        result.lengths = new int[] { (tokenLength - 1), 1 };
      }
    }
    if (!_matched) {
      if (Objects.equal(id, "RULE_RICH_TEXT_INBETWEEN")) {
        _matched=true;
        result.delimiter = true;
        if ((tokenLength == 2)) {
          result.offsets = new int[] { tokenOffset };
          result.lengths = new int[] { tokenLength };
        } else {
          result.offsets = new int[] { tokenOffset, (tokenOffset + 1), ((tokenOffset + tokenLength) - 1) };
          result.lengths = new int[] { 1, (tokenLength - 2), 1 };
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(id, "RULE_RICH_TEXT_END")) {
        _matched=true;
        result.delimiter = true;
        result.offsets = new int[] { tokenOffset, (tokenOffset + 1) };
        result.lengths = new int[] { 1, (tokenLength - 1) };
      }
    }
    if (!_matched) {
      if (Objects.equal(id, "RULE_COMMENT_RICH_TEXT_END")) {
        _matched=true;
        result.delimiter = true;
        result.offsets = new int[] { tokenOffset, (tokenOffset + 2) };
        result.lengths = new int[] { 2, (tokenLength - 2) };
      }
    }
    if (!_matched) {
      if (Objects.equal(id, "RULE_COMMENT_RICH_TEXT_INBETWEEN")) {
        _matched=true;
        result.delimiter = true;
        result.offsets = new int[] { tokenOffset, (tokenOffset + 2), ((tokenOffset + tokenLength) - 1) };
        result.lengths = new int[] { 2, (tokenLength - 3), 1 };
      }
    }
    if (!_matched) {
      throw new IllegalArgumentException(id);
    }
    return result;
  }
}
