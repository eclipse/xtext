package org.eclipse.xtext.idea.syntaxcoloring;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.xtext.ide.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class DefaultSyntaxHighlighter /* implements SyntaxHighlighterBase  */{
  @Inject
  private /* Provider<Lexer> */Object lexerProvider;
  
  @Inject
  @Extension
  private TokenTypeProvider tokenTypeProvider;
  
  @Inject
  @Extension
  private AbstractAntlrTokenToAttributeIdMapper tokenToAttributeIdMapper;
  
  public Lexer getHighlightingLexer() {
    return this.lexerProvider.get();
  }
  
  public Object getTokenHighlights(final /* IElementType */Object tokenType) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method pack is undefined for the type DefaultSyntaxHighlighter"
      + "\nThe method or field DefaultLanguageHighlighterColors is undefined for the type DefaultSyntaxHighlighter"
      + "\nThe method pack is undefined for the type DefaultSyntaxHighlighter"
      + "\nThe method or field DefaultLanguageHighlighterColors is undefined for the type DefaultSyntaxHighlighter"
      + "\nThe method pack is undefined for the type DefaultSyntaxHighlighter"
      + "\nThe method or field DefaultLanguageHighlighterColors is undefined for the type DefaultSyntaxHighlighter"
      + "\nThe method pack is undefined for the type DefaultSyntaxHighlighter"
      + "\nThe method or field DefaultLanguageHighlighterColors is undefined for the type DefaultSyntaxHighlighter"
      + "\nThe method pack is undefined for the type DefaultSyntaxHighlighter"
      + "\nThe method or field HighlighterColors is undefined for the type DefaultSyntaxHighlighter"
      + "\nantlrType cannot be resolved"
      + "\nid cannot be resolved"
      + "\nNUMBER cannot be resolved"
      + "\nKEYWORD cannot be resolved"
      + "\nSTRING cannot be resolved"
      + "\nBLOCK_COMMENT cannot be resolved"
      + "\nTEXT cannot be resolved");
  }
}
