/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.parser;

import com.google.common.base.Objects;
import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.psi.tree.IElementType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.idea.lang.CreateElementType;
import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.idea.parser.PsiTokenStream;
import org.eclipse.xtext.idea.parser.PsiTokenStreamState;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class PsiXtextTokenStream extends XtextTokenStream implements PsiTokenStream {
  private boolean afterSeek;
  
  private final PsiBuilder builder;
  
  private final List<PsiTokenStreamState> states;
  
  private final Map<Integer, Integer> psiToOriginalMarkers;
  
  private String errorMessage;
  
  private IElementType tokenType;
  
  public PsiXtextTokenStream(final PsiBuilder builder, final TokenSource tokenSource, final ITokenDefProvider tokenDefProvider) {
    super(tokenSource, tokenDefProvider);
    this.builder = builder;
    this.afterSeek = false;
    ArrayList<PsiTokenStreamState> _newArrayList = CollectionLiterals.<PsiTokenStreamState>newArrayList();
    this.states = _newArrayList;
    HashMap<Integer, Integer> _newHashMap = CollectionLiterals.<Integer, Integer>newHashMap();
    this.psiToOriginalMarkers = _newHashMap;
  }
  
  @Override
  public void reportError(final Function0<? extends String> reporter) {
    boolean _equals = Objects.equal(this.errorMessage, null);
    if (_equals) {
      String _apply = reporter.apply();
      this.errorMessage = _apply;
    }
  }
  
  @Override
  public IElementType remapToken(final IElementType tokenType) {
    IElementType _xblockexpression = null;
    {
      final IElementType currentTokenType = this.tokenType;
      this.tokenType = tokenType;
      _xblockexpression = currentTokenType;
    }
    return _xblockexpression;
  }
  
  @Override
  public void appendAllTokens() {
    while ((!this.builder.eof())) {
      this.consume();
    }
    boolean _notEquals = (!Objects.equal(this.errorMessage, null));
    if (_notEquals) {
      this.builder.error(this.errorMessage);
      this.errorMessage = null;
    }
  }
  
  @Override
  public void consume() {
    if (this.afterSeek) {
      super.consume();
    } else {
      final int rawTokenIndex = this.builder.rawTokenIndex();
      if ((rawTokenIndex < this.p)) {
        final int n = (this.p - rawTokenIndex);
        for (int i = 0; (i < n); i++) {
          this.advanceLexer(null);
        }
      }
      super.consume();
      this.advanceLexer(this.tokenType);
    }
  }
  
  protected void advanceLexer(final IElementType tokenType) {
    boolean _eof = this.builder.eof();
    if (_eof) {
      return;
    }
    int _rawTokenIndex = this.builder.rawTokenIndex();
    final Token token = this.get(_rawTokenIndex);
    int _channel = token.getChannel();
    final boolean hidden = (_channel == BaseRecognizer.HIDDEN);
    IElementType _xifexpression = null;
    boolean _equals = Objects.equal(tokenType, null);
    if (_equals) {
      _xifexpression = this.builder.getTokenType();
    } else {
      _xifexpression = tokenType;
    }
    final IElementType currentTokenType = _xifexpression;
    final CreateElementType.CreateCallback _function = new CreateElementType.CreateCallback() {
      @Override
      public void onCreate(final ASTNode it) {
        it.<Boolean>putUserData(IASTNodeAwareNodeModelBuilder.HIDDEN_KEY, Boolean.valueOf(hidden));
      }
    };
    CreateElementType _createElementType = new CreateElementType(currentTokenType, _function);
    this.builder.remapCurrentToken(_createElementType);
    final String errorMessage = this.getErrorMessage(token);
    boolean _notEquals = (!Objects.equal(errorMessage, null));
    if (_notEquals) {
      final PsiBuilder.Marker errorMarker = this.builder.mark();
      this.builder.advanceLexer();
      errorMarker.error(errorMessage);
    } else {
      this.builder.advanceLexer();
    }
  }
  
  protected String getErrorMessage(final Token token) {
    if (((token.getChannel() != BaseRecognizer.HIDDEN) && (!Objects.equal(this.errorMessage, null)))) {
      final String result = this.errorMessage;
      this.errorMessage = null;
      return result;
    }
    int _type = token.getType();
    boolean _equals = (_type == Token.INVALID_TOKEN_TYPE);
    if (_equals) {
      return this.getLexerErrorMessage(token);
    }
    return null;
  }
  
  @Override
  public int mark() {
    int _xblockexpression = (int) 0;
    {
      final int psiMarker = this.markPsi();
      int _mark = super.mark();
      this.psiToOriginalMarkers.put(Integer.valueOf(psiMarker), Integer.valueOf(_mark));
      _xblockexpression = psiMarker;
    }
    return _xblockexpression;
  }
  
  protected int markPsi() {
    int _xblockexpression = (int) 0;
    {
      PsiBuilder.Marker _mark = this.builder.mark();
      PsiTokenStreamState _psiTokenStreamState = new PsiTokenStreamState(this.errorMessage, this.tokenType, _mark);
      this.states.add(_psiTokenStreamState);
      _xblockexpression = this.getLastPsiMarker();
    }
    return _xblockexpression;
  }
  
  protected int getLastPsiMarker() {
    int _size = this.states.size();
    return (_size - 1);
  }
  
  @Override
  public void release(final int psiMarker) {
    Integer _get = this.psiToOriginalMarkers.get(Integer.valueOf(psiMarker));
    super.release((_get).intValue());
    final PsiTokenStreamState state = this.states.get(psiMarker);
    IElementType _tokenType = state.getTokenType();
    this.tokenType = _tokenType;
    String _errorMessage = state.getErrorMessage();
    this.errorMessage = _errorMessage;
    PsiBuilder.Marker _marker = state.getMarker();
    _marker.drop();
  }
  
  @Override
  public void rewind() {
    super.rewind();
    int _lastPsiMarker = this.getLastPsiMarker();
    this.rewind(_lastPsiMarker);
    this.mark();
    this.afterSeek = false;
  }
  
  @Override
  public void rewind(final int psiMarker) {
    Integer _get = this.psiToOriginalMarkers.get(Integer.valueOf(psiMarker));
    super.rewind((_get).intValue());
    final PsiTokenStreamState state = this.states.get(psiMarker);
    IElementType _tokenType = state.getTokenType();
    this.tokenType = _tokenType;
    String _errorMessage = state.getErrorMessage();
    this.errorMessage = _errorMessage;
    PsiBuilder.Marker _marker = state.getMarker();
    _marker.rollbackTo();
    this.afterSeek = false;
  }
  
  @Override
  public void seek(final int index) {
    super.seek(index);
    this.afterSeek = true;
  }
}
