/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.findusages;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.intellij.lang.cacheBuilder.SimpleWordsScanner;
import com.intellij.lang.cacheBuilder.WordOccurrence;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lexer.Lexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import com.intellij.util.Processor;
import org.eclipse.xtext.idea.findusages.WordsScannerProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.xbase.idea.parser.OperatorTokenTypeProvider;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XbaseWordsScanner implements WordsScanner {
  @Singleton
  public static class XbaseWordsScannerProvider implements WordsScannerProvider {
    @Inject
    private Provider<XbaseWordsScanner> provider;
    
    @Override
    public WordsScanner get() {
      return this.provider.get();
    }
  }
  
  @Inject
  private Lexer lexer;
  
  @Inject
  private TokenTypeProvider tokenTypeProvider;
  
  @Inject
  private OperatorTokenTypeProvider operatorTokenTypeProvider;
  
  private final SimpleWordsScanner simpleWordsScanner = new SimpleWordsScanner();
  
  @Override
  public void processWords(final CharSequence fileText, final Processor<WordOccurrence> processor) {
    this.lexer.start(fileText);
    while ((!Objects.equal(this.lexer.getTokenType(), null))) {
      {
        this.scanOperator(processor);
        this.scanWords(processor);
        this.lexer.advance();
      }
    }
  }
  
  protected void scanOperator(final Processor<WordOccurrence> processor) {
    boolean _isOperator = this.isOperator();
    boolean _not = (!_isOperator);
    if (_not) {
      return;
    }
    final int start = this.lexer.getTokenStart();
    int end = this.lexer.getTokenEnd();
    this.lexer.advance();
    while (this.isOperator()) {
      {
        int _tokenEnd = this.lexer.getTokenEnd();
        end = _tokenEnd;
        this.lexer.advance();
      }
    }
    CharSequence _bufferSequence = this.lexer.getBufferSequence();
    final WordOccurrence occurrence = new WordOccurrence(_bufferSequence, start, end, WordOccurrence.Kind.CODE);
    processor.process(occurrence);
  }
  
  protected boolean isOperator() {
    TokenSet _operatorTokens = this.operatorTokenTypeProvider.getOperatorTokens();
    IElementType _tokenType = this.lexer.getTokenType();
    return _operatorTokens.contains(_tokenType);
  }
  
  protected void scanWords(final Processor<WordOccurrence> processor) {
    IElementType _tokenType = this.lexer.getTokenType();
    boolean _equals = Objects.equal(_tokenType, null);
    if (_equals) {
      return;
    }
    final WordOccurrence.Kind kind = this.getOccurrenceKind();
    final int tokenStart = this.lexer.getTokenStart();
    CharSequence _tokenSequence = this.lexer.getTokenSequence();
    final Processor<WordOccurrence> _function = new Processor<WordOccurrence>() {
      @Override
      public boolean process(final WordOccurrence occurrence) {
        boolean _xblockexpression = false;
        {
          CharSequence _bufferSequence = XbaseWordsScanner.this.lexer.getBufferSequence();
          int _start = occurrence.getStart();
          int _plus = (tokenStart + _start);
          int _end = occurrence.getEnd();
          int _plus_1 = (tokenStart + _end);
          occurrence.init(_bufferSequence, _plus, _plus_1, kind);
          _xblockexpression = processor.process(occurrence);
        }
        return _xblockexpression;
      }
    };
    this.simpleWordsScanner.processWords(_tokenSequence, _function);
  }
  
  protected WordOccurrence.Kind getOccurrenceKind() {
    boolean _isComments = this.isComments();
    if (_isComments) {
      return WordOccurrence.Kind.COMMENTS;
    }
    boolean _isLiterals = this.isLiterals();
    if (_isLiterals) {
      return WordOccurrence.Kind.LITERALS;
    }
    return WordOccurrence.Kind.CODE;
  }
  
  protected boolean isComments() {
    TokenSet _commentTokens = this.tokenTypeProvider.getCommentTokens();
    IElementType _tokenType = this.lexer.getTokenType();
    return _commentTokens.contains(_tokenType);
  }
  
  protected boolean isLiterals() {
    TokenSet _stringLiteralTokens = this.tokenTypeProvider.getStringLiteralTokens();
    IElementType _tokenType = this.lexer.getTokenType();
    return _stringLiteralTokens.contains(_tokenType);
  }
}
