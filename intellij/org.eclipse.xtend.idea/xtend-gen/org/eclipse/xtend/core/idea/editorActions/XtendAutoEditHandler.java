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
import com.intellij.openapi.editor.ex.EditorEx;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import java.util.Collections;
import org.eclipse.xtend.core.idea.editorActions.AutoEditRichString;
import org.eclipse.xtend.core.idea.editorActions.AutoEditRichStringBlock;
import org.eclipse.xtend.core.idea.parser.antlr.internal.PsiInternalXtendParser;
import org.eclipse.xtext.idea.editorActions.AbstractAutoEditBlock;
import org.eclipse.xtext.idea.editorActions.AbstractIndentableAutoEditBlock;
import org.eclipse.xtext.idea.editorActions.AutoEditMultiLineBlock;
import org.eclipse.xtext.idea.editorActions.AutoEditString;
import org.eclipse.xtext.idea.editorActions.DefaultAutoEditHandler;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendAutoEditHandler extends DefaultAutoEditHandler {
  private TokenSet slCommentTokens;
  
  private TokenSet richStringLiteralTokens;
  
  @Override
  protected Iterable<AbstractAutoEditBlock> getQuotes() {
    AutoEditRichString _autoEditRichString = new AutoEditRichString(this.richStringLiteralTokens);
    AutoEditString _autoEditString = new AutoEditString("\"");
    AutoEditString _autoEditString_1 = new AutoEditString("\'");
    return Collections.<AbstractAutoEditBlock>unmodifiableList(CollectionLiterals.<AbstractAutoEditBlock>newArrayList(_autoEditRichString, _autoEditString, _autoEditString_1));
  }
  
  @Inject
  public void setTokenTypeProvider(final TokenTypeProvider tokenTypeProvider) {
    IElementType _iElementType = tokenTypeProvider.getIElementType(PsiInternalXtendParser.RULE_RICH_TEXT);
    IElementType _iElementType_1 = tokenTypeProvider.getIElementType(PsiInternalXtendParser.RULE_RICH_TEXT_START);
    IElementType _iElementType_2 = tokenTypeProvider.getIElementType(PsiInternalXtendParser.RULE_RICH_TEXT_END);
    IElementType _iElementType_3 = tokenTypeProvider.getIElementType(PsiInternalXtendParser.RULE_RICH_TEXT_INBETWEEN);
    IElementType _iElementType_4 = tokenTypeProvider.getIElementType(PsiInternalXtendParser.RULE_COMMENT_RICH_TEXT_END);
    IElementType _iElementType_5 = tokenTypeProvider.getIElementType(PsiInternalXtendParser.RULE_COMMENT_RICH_TEXT_INBETWEEN);
    TokenSet _create = TokenSet.create(_iElementType, _iElementType_1, _iElementType_2, _iElementType_3, _iElementType_4, _iElementType_5);
    this.richStringLiteralTokens = _create;
    IElementType _iElementType_6 = tokenTypeProvider.getIElementType(PsiInternalXtendParser.RULE_SL_COMMENT);
    TokenSet _create_1 = TokenSet.create(_iElementType_6);
    this.slCommentTokens = _create_1;
  }
  
  @Override
  protected Iterable<AbstractIndentableAutoEditBlock> getBlocks(final TokenSet tokenSet) {
    Iterable<AbstractIndentableAutoEditBlock> _xblockexpression = null;
    {
      boolean _equals = Objects.equal(tokenSet, this.richStringLiteralTokens);
      if (_equals) {
        AutoEditRichStringBlock _autoEditRichStringBlock = new AutoEditRichStringBlock("{", "}");
        AutoEditMultiLineBlock _autoEditMultiLineBlock = new AutoEditMultiLineBlock("«", "»");
        final Procedure1<AutoEditMultiLineBlock> _function = new Procedure1<AutoEditMultiLineBlock>() {
          @Override
          public void apply(final AutoEditMultiLineBlock it) {
            it.setShouldDeleteClosing(true);
            it.setShouldInsertClosingTerminalBeforeDigit(true);
            it.setShouldInsertClosingTerminalBeforeSpecialCharacters(true);
          }
        };
        AutoEditMultiLineBlock _doubleArrow = ObjectExtensions.<AutoEditMultiLineBlock>operator_doubleArrow(_autoEditMultiLineBlock, _function);
        return Collections.<AbstractIndentableAutoEditBlock>unmodifiableList(CollectionLiterals.<AbstractIndentableAutoEditBlock>newArrayList(_autoEditRichStringBlock, _doubleArrow));
      }
      _xblockexpression = super.getBlocks(tokenSet);
    }
    return _xblockexpression;
  }
  
  @Override
  public TokenSet getTokenSet(final IElementType tokenType) {
    TokenSet _xblockexpression = null;
    {
      boolean _contains = this.richStringLiteralTokens.contains(tokenType);
      if (_contains) {
        return this.richStringLiteralTokens;
      }
      _xblockexpression = super.getTokenSet(tokenType);
    }
    return _xblockexpression;
  }
  
  @Override
  protected TokenSet getSingleLineCommentTokens() {
    return this.slCommentTokens;
  }
  
  @Override
  public boolean isStartOfLine(final TokenSet tokenSet, final EditorEx editor, final int offset) {
    boolean _xifexpression = false;
    boolean _equals = Objects.equal(tokenSet, this.richStringLiteralTokens);
    if (_equals) {
      boolean _xblockexpression = false;
      {
        String _beginningOfLine = this.getBeginningOfLine(editor, offset);
        final String text = _beginningOfLine.trim();
        boolean _or = false;
        boolean _isEmpty = text.isEmpty();
        if (_isEmpty) {
          _or = true;
        } else {
          boolean _equals_1 = text.equals("\'\'\'");
          _or = _equals_1;
        }
        _xblockexpression = _or;
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
        String _endOfLine = this.getEndOfLine(editor, offset);
        final String text = _endOfLine.trim();
        boolean _or = false;
        boolean _isEmpty = text.isEmpty();
        if (_isEmpty) {
          _or = true;
        } else {
          boolean _equals_1 = text.equals("\'\'\'");
          _or = _equals_1;
        }
        _xblockexpression = _or;
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = super.isEndOfLine(tokenSet, editor, offset);
    }
    return _xifexpression;
  }
}
