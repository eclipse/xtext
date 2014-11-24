package org.eclipse.xtext.idea.parser;

import com.google.inject.Inject;
import java.util.HashSet;
import org.antlr.runtime.TokenSource;
import org.antlr.runtime.TokenStream;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.idea.parser.PsiXtextTokenStream;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public abstract class AbstractXtextPsiParser /* implements PsiParser  */{
  @Inject
  @Accessors(AccessorType.PROTECTED_GETTER)
  private ITokenDefProvider tokenDefProvider;
  
  @Inject
  @Accessors(AccessorType.PROTECTED_GETTER)
  private TokenTypeProvider tokenTypeProvider;
  
  public Object parse(final /* IElementType */Object root, final /* PsiBuilder */Object builder) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field tokenTypeMap is undefined for the type AbstractXtextPsiParser"
      + "\ndebugMode cannot be resolved"
      + "\nmark cannot be resolved"
      + "\ncreateParser cannot be resolved"
      + "\ncreateTokenStream cannot be resolved"
      + "\n=> cannot be resolved"
      + "\nparse cannot be resolved"
      + "\ndone cannot be resolved"
      + "\ntreeBuilt cannot be resolved");
  }
  
  protected abstract AbstractPsiAntlrParser createParser(final /* PsiBuilder */Object builder, final TokenStream tokenStream);
  
  protected PsiXtextTokenStream createTokenStream(final /* PsiBuilder */Object builder) {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from HashSet<Object> to String[]"
      + "\ncreateTokenSource cannot be resolved");
  }
  
  protected abstract TokenSource createTokenSource(final /* PsiBuilder */Object builder);
  
  protected HashSet<Object> getInitialHiddenTokens() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method whitespaceTokens is undefined for the type AbstractXtextPsiParser"
      + "\nThe method commentTokens is undefined for the type AbstractXtextPsiParser"
      + "\ntypes cannot be resolved"
      + "\nmap cannot be resolved"
      + "\ntypes cannot be resolved"
      + "\nmap cannot be resolved");
  }
  
  @Pure
  protected ITokenDefProvider getTokenDefProvider() {
    return this.tokenDefProvider;
  }
  
  @Pure
  protected TokenTypeProvider getTokenTypeProvider() {
    return this.tokenTypeProvider;
  }
}
