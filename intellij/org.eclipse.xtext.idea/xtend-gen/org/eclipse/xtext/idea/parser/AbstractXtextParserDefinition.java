package org.eclipse.xtext.idea.parser;

import com.google.inject.Inject;
import javax.inject.Provider;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public abstract class AbstractXtextParserDefinition /* implements ParserDefinition  */{
  @Inject
  private /* Provider<Lexer> */Object lexerProvider;
  
  @Inject
  private TokenTypeProvider tokenTypeProvider;
  
  @Inject
  private /* Provider<PsiParser> */Object psiParserProvider;
  
  @Inject
  @Accessors(AccessorType.PROTECTED_GETTER)
  private IElementTypeProvider elementTypeProvider;
  
  /* @NotNull
   */public /* Lexer */Object createLexer(final /* Project */Object project) {
    return this.lexerProvider.get();
  }
  
  public /* IFileElementType */Object getFileNodeType() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getFileType is undefined for the type AbstractXtextParserDefinition");
  }
  
  /* @NotNull
   */public /* TokenSet */Object getWhitespaceTokens() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field TokenSet is undefined for the type AbstractXtextParserDefinition"
      + "\nEMPTY cannot be resolved");
  }
  
  /* @NotNull
   */public /* TokenSet */Object getCommentTokens() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field TokenSet is undefined for the type AbstractXtextParserDefinition"
      + "\nEMPTY cannot be resolved");
  }
  
  /* @NotNull
   */public /* TokenSet */Object getStringLiteralElements() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getStringLiteralTokens is undefined for the type AbstractXtextParserDefinition");
  }
  
  /* @NotNull
   */public /* PsiParser */Object createParser(final /* Project */Object project) {
    return this.psiParserProvider.get();
  }
  
  public /* SpaceRequirements */Object spaceExistanceTypeBetweenTokens(final /* ASTNode */Object left, final /* ASTNode */Object right) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field LanguageUtil is undefined for the type AbstractXtextParserDefinition"
      + "\ncanStickTokensTogetherByLexer cannot be resolved");
  }
  
  public Object createElement(final /* ASTNode */Object node) {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiEObjectReference cannot be resolved."
      + "\nPsiEObjectImpl cannot be resolved."
      + "\nelementType cannot be resolved"
      + "\ncrossReference cannot be resolved");
  }
  
  protected boolean isCrossReference(final /* IElementType */Object type) {
    throw new Error("Unresolved compilation problems:"
      + "\ngrammarElement cannot be resolved");
  }
  
  @Pure
  protected IElementTypeProvider getElementTypeProvider() {
    return this.elementTypeProvider;
  }
}
