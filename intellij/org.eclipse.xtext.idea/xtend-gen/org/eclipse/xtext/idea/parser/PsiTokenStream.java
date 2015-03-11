package org.eclipse.xtext.idea.parser;

import com.intellij.psi.tree.IElementType;
import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public interface PsiTokenStream extends TokenStream {
  public abstract int getCurrentLookAhead();
  
  public abstract void reportError(final Function0<? extends String> reporter);
  
  public abstract IElementType remapToken(final IElementType tokenType);
  
  public abstract void appendAllTokens();
}
