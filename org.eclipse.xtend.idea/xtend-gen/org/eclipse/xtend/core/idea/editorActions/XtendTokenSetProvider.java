/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.editorActions;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.intellij.openapi.editor.ex.EditorEx;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import org.eclipse.xtend.core.idea.highlighting.XtendHighlightingLexer;
import org.eclipse.xtend.core.idea.parser.antlr.internal.PsiInternalXtendParser;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.editorActions.DefaultTokenSetProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
@SuppressWarnings("all")
public class XtendTokenSetProvider extends DefaultTokenSetProvider {
  @Accessors
  private final TokenSet richStringLiteralTokens;
  
  @Accessors
  private final TokenSet richStringCommentTokens;
  
  @Inject
  public XtendTokenSetProvider(final TokenTypeProvider tokenTypeProvider) {
    this.richStringLiteralTokens = TokenSet.create(
      tokenTypeProvider.getIElementType(PsiInternalXtendParser.RULE_RICH_TEXT), 
      tokenTypeProvider.getIElementType(PsiInternalXtendParser.RULE_RICH_TEXT_START), 
      tokenTypeProvider.getIElementType(PsiInternalXtendParser.RULE_RICH_TEXT_END), 
      tokenTypeProvider.getIElementType(PsiInternalXtendParser.RULE_RICH_TEXT_INBETWEEN), 
      XtendHighlightingLexer.GUILLEMET_ELEMENT_TYPE);
    this.richStringCommentTokens = TokenSet.create(
      tokenTypeProvider.getIElementType(PsiInternalXtendParser.RULE_COMMENT_RICH_TEXT_INBETWEEN), 
      tokenTypeProvider.getIElementType(PsiInternalXtendParser.RULE_COMMENT_RICH_TEXT_END));
  }
  
  @Override
  public TokenSet getTokenSet(final IElementType tokenType) {
    TokenSet _xblockexpression = null;
    {
      boolean _contains = this.richStringLiteralTokens.contains(tokenType);
      if (_contains) {
        return this.richStringLiteralTokens;
      }
      boolean _contains_1 = this.richStringCommentTokens.contains(tokenType);
      if (_contains_1) {
        return this.richStringCommentTokens;
      }
      _xblockexpression = super.getTokenSet(tokenType);
    }
    return _xblockexpression;
  }
  
  @Override
  public boolean isStartOfLine(final TokenSet tokenSet, final EditorEx editor, final int offset) {
    boolean _xifexpression = false;
    boolean _equals = Objects.equal(tokenSet, this.richStringLiteralTokens);
    if (_equals) {
      boolean _xblockexpression = false;
      {
        final String text = this.getBeginningOfLine(editor, offset).trim();
        _xblockexpression = (text.isEmpty() || text.equals("\'\'\'"));
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = super.isStartOfLine(tokenSet, editor, offset);
    }
    return _xifexpression;
  }
  
  @Override
  public boolean isEndOfLine(final TokenSet tokenSet, final EditorEx editor, final int offset) {
    boolean _xifexpression = false;
    boolean _equals = Objects.equal(tokenSet, this.richStringLiteralTokens);
    if (_equals) {
      boolean _xblockexpression = false;
      {
        final String text = this.getEndOfLine(editor, offset).trim();
        _xblockexpression = (text.isEmpty() || text.equals("\'\'\'"));
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = super.isEndOfLine(tokenSet, editor, offset);
    }
    return _xifexpression;
  }
  
  @Pure
  public TokenSet getRichStringLiteralTokens() {
    return this.richStringLiteralTokens;
  }
  
  @Pure
  public TokenSet getRichStringCommentTokens() {
    return this.richStringCommentTokens;
  }
}
