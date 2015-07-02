/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.editorActions;

import com.google.inject.Inject;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import org.eclipse.xtend.core.idea.parser.antlr.internal.PsiInternalXtendParser;
import org.eclipse.xtext.idea.editorActions.DefaultAutoEditHandler;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendAutoEditHandler extends DefaultAutoEditHandler {
  private TokenSet slCommentTokens;
  
  private TokenSet stringLiteralTokens;
  
  @Inject
  public void setRichStringLiteralTokens(final TokenTypeProvider tokenTypeProvider) {
    IElementType _iElementType = tokenTypeProvider.getIElementType(PsiInternalXtendParser.RULE_RICH_TEXT);
    IElementType _iElementType_1 = tokenTypeProvider.getIElementType(PsiInternalXtendParser.RULE_RICH_TEXT_START);
    IElementType _iElementType_2 = tokenTypeProvider.getIElementType(PsiInternalXtendParser.RULE_RICH_TEXT_END);
    IElementType _iElementType_3 = tokenTypeProvider.getIElementType(PsiInternalXtendParser.RULE_RICH_TEXT_INBETWEEN);
    IElementType _iElementType_4 = tokenTypeProvider.getIElementType(PsiInternalXtendParser.RULE_COMMENT_RICH_TEXT_END);
    IElementType _iElementType_5 = tokenTypeProvider.getIElementType(PsiInternalXtendParser.RULE_COMMENT_RICH_TEXT_INBETWEEN);
    final TokenSet richStringLiteralTokens = TokenSet.create(_iElementType, _iElementType_1, _iElementType_2, _iElementType_3, _iElementType_4, _iElementType_5);
    TokenSet _stringLiteralTokens = tokenTypeProvider.getStringLiteralTokens();
    TokenSet _orSet = TokenSet.orSet(_stringLiteralTokens, richStringLiteralTokens);
    this.stringLiteralTokens = _orSet;
    IElementType _iElementType_6 = tokenTypeProvider.getIElementType(PsiInternalXtendParser.RULE_SL_COMMENT);
    TokenSet _create = TokenSet.create(_iElementType_6);
    this.slCommentTokens = _create;
  }
  
  @Override
  protected TokenSet getSingleLineCommentTokens() {
    return this.slCommentTokens;
  }
  
  @Override
  protected TokenSet getStringLiteralTokens() {
    return this.stringLiteralTokens;
  }
}
