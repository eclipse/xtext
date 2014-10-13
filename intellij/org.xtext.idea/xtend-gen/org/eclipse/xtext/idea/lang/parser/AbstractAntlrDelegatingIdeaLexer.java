package org.eclipse.xtext.idea.lang.parser;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.lexer.LexerBase;
import com.intellij.psi.tree.IElementType;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.Token;
import org.eclipse.xtext.generator.idea.TokenTypeProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public abstract class AbstractAntlrDelegatingIdeaLexer extends LexerBase {
  private Lexer internalLexer;
  
  private CommonToken token;
  
  private CharSequence buffer;
  
  private int startOffset;
  
  private int endOffset;
  
  @Inject
  private TokenTypeProvider tokenTypeProvider;
  
  public void start(final CharSequence buffer, final int startOffset, final int endOffset, final int initialState) {
    this.buffer = buffer;
    this.startOffset = startOffset;
    this.endOffset = endOffset;
    CharSequence _subSequence = buffer.subSequence(startOffset, endOffset);
    final String text = _subSequence.toString();
    Lexer _createAntlrLexer = this.createAntlrLexer(text);
    this.internalLexer = _createAntlrLexer;
  }
  
  public abstract Lexer createAntlrLexer(final String string);
  
  public int getState() {
    int _xifexpression = (int) 0;
    boolean _notEquals = (!Objects.equal(this.token, null));
    if (_notEquals) {
      _xifexpression = this.token.getType();
    } else {
      _xifexpression = 0;
    }
    return _xifexpression;
  }
  
  public IElementType getTokenType() {
    this.locateToken();
    boolean _equals = Objects.equal(this.token, null);
    if (_equals) {
      return null;
    }
    final int type = this.token.getType();
    return this.tokenTypeProvider.getIElementType(type);
  }
  
  public int getTokenStart() {
    this.locateToken();
    int _startIndex = this.token.getStartIndex();
    return (this.startOffset + _startIndex);
  }
  
  public int getTokenEnd() {
    this.locateToken();
    int _stopIndex = this.token.getStopIndex();
    int _plus = (this.startOffset + _stopIndex);
    return (_plus + 1);
  }
  
  public void advance() {
    this.locateToken();
    this.token = null;
  }
  
  public CharSequence getBufferSequence() {
    return this.buffer;
  }
  
  public int getBufferEnd() {
    return this.endOffset;
  }
  
  public void locateToken() {
    boolean _equals = Objects.equal(this.token, null);
    if (_equals) {
      try {
        Token _nextToken = this.internalLexer.nextToken();
        this.token = ((CommonToken) _nextToken);
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          e.printStackTrace();
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      boolean _equals_1 = Objects.equal(this.token, Token.EOF_TOKEN);
      if (_equals_1) {
        this.token = null;
      }
    }
  }
}
