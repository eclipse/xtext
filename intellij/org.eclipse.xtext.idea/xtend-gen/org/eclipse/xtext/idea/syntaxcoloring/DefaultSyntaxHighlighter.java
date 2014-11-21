package org.eclipse.xtext.idea.syntaxcoloring;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.eclipse.xtext.ide.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class DefaultSyntaxHighlighter extends SyntaxHighlighterBase {
  @Inject
  private Provider<Lexer> lexerProvider;
  
  @Inject
  @Extension
  private TokenTypeProvider tokenTypeProvider;
  
  @Inject
  @Extension
  private AbstractAntlrTokenToAttributeIdMapper tokenToAttributeIdMapper;
  
  public Lexer getHighlightingLexer() {
    return this.lexerProvider.get();
  }
  
  public TextAttributesKey[] getTokenHighlights(final IElementType tokenType) {
    TextAttributesKey[] _xblockexpression = null;
    {
      int _antlrType = this.tokenTypeProvider.getAntlrType(tokenType);
      final String attribute = this.tokenToAttributeIdMapper.getId(_antlrType);
      TextAttributesKey[] _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(attribute, HighlightingStyles.NUMBER_ID)) {
          _matched=true;
          _switchResult = SyntaxHighlighterBase.pack(DefaultLanguageHighlighterColors.NUMBER);
        }
      }
      if (!_matched) {
        if (Objects.equal(attribute, HighlightingStyles.KEYWORD_ID)) {
          _matched=true;
          _switchResult = SyntaxHighlighterBase.pack(DefaultLanguageHighlighterColors.KEYWORD);
        }
      }
      if (!_matched) {
        if (Objects.equal(attribute, HighlightingStyles.STRING_ID)) {
          _matched=true;
          _switchResult = SyntaxHighlighterBase.pack(DefaultLanguageHighlighterColors.STRING);
        }
      }
      if (!_matched) {
        if (Objects.equal(attribute, HighlightingStyles.COMMENT_ID)) {
          _matched=true;
          _switchResult = SyntaxHighlighterBase.pack(DefaultLanguageHighlighterColors.BLOCK_COMMENT);
        }
      }
      if (!_matched) {
        _switchResult = SyntaxHighlighterBase.pack(HighlighterColors.TEXT);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
}
