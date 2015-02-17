package org.eclipse.xtext.lexer.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.lexer.idea.completion.AbstractIgnoreCaseLexerTestLanguageCompletionContributor;
import org.eclipse.xtext.lexer.idea.lang.IgnoreCaseLexerTestLanguageLanguage;

@SuppressWarnings("all")
public class IgnoreCaseLexerTestLanguageCompletionContributor extends AbstractIgnoreCaseLexerTestLanguageCompletionContributor {
  public IgnoreCaseLexerTestLanguageCompletionContributor() {
    this(IgnoreCaseLexerTestLanguageLanguage.INSTANCE);
  }
  
  public IgnoreCaseLexerTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
