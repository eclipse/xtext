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
import com.google.inject.Provider;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.eclipse.xtend.core.idea.highlighting.XtendHighlightingLexer;
import org.eclipse.xtend.ide.common.highlighting.XtendHighlightingStyles;
import org.eclipse.xtext.ide.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.idea.highlighting.IdeaHighlightingAttributesProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendSyntaxHighlighter extends SyntaxHighlighterBase {
  @Inject
  private Provider<XtendHighlightingLexer> lexerProvider;
  
  @Inject
  private IdeaHighlightingAttributesProvider textAttributeProvider;
  
  @Inject
  @Extension
  private TokenTypeProvider _tokenTypeProvider;
  
  @Inject
  @Extension
  private AbstractAntlrTokenToAttributeIdMapper _abstractAntlrTokenToAttributeIdMapper;
  
  @Override
  public Lexer getHighlightingLexer() {
    return this.lexerProvider.get();
  }
  
  @Override
  public TextAttributesKey[] getTokenHighlights(final IElementType tokenType) {
    String _xifexpression = null;
    boolean _equals = Objects.equal(tokenType, XtendHighlightingLexer.GUILLEMET_ELEMENT_TYPE);
    if (_equals) {
      _xifexpression = XtendHighlightingStyles.RICH_TEXT_DELIMITER_ID;
    } else {
      int _antlrType = this._tokenTypeProvider.getAntlrType(tokenType);
      _xifexpression = this._abstractAntlrTokenToAttributeIdMapper.getId(_antlrType);
    }
    final String attribute = _xifexpression;
    TextAttributesKey _textAttributesKey = this.textAttributeProvider.getTextAttributesKey(attribute);
    return SyntaxHighlighterBase.pack(_textAttributesKey);
  }
}
