/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.highlighting;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.eclipse.xtext.ide.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.idea.highlighting.IdeaHighlightingAttributesProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class DefaultSyntaxHighlighter extends SyntaxHighlighterBase {
  @Inject
  private Provider<Lexer> lexerProvider;
  
  @Inject
  private IdeaHighlightingAttributesProvider textAttributeProvider;
  
  @Inject
  @Extension
  private TokenTypeProvider tokenTypeProvider;
  
  @Inject
  @Extension
  private AbstractAntlrTokenToAttributeIdMapper tokenToAttributeIdMapper;
  
  @Override
  public Lexer getHighlightingLexer() {
    return this.lexerProvider.get();
  }
  
  @Override
  public TextAttributesKey[] getTokenHighlights(final IElementType tokenType) {
    int _antlrType = this.tokenTypeProvider.getAntlrType(tokenType);
    final String attribute = this.tokenToAttributeIdMapper.getId(_antlrType);
    TextAttributesKey _textAttributesKey = this.textAttributeProvider.getTextAttributesKey(attribute);
    return SyntaxHighlighterBase.pack(_textAttributesKey);
  }
}
