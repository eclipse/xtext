package org.eclipse.xtext.lexer.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.lexer.idea.completion.AbstractBacktrackingLexerTestLanguageCompletionContributor;
import org.eclipse.xtext.lexer.idea.lang.BacktrackingLexerTestLanguageLanguage;

@SuppressWarnings("all")
public class BacktrackingLexerTestLanguageCompletionContributor extends AbstractBacktrackingLexerTestLanguageCompletionContributor {
  public BacktrackingLexerTestLanguageCompletionContributor() {
    this(BacktrackingLexerTestLanguageLanguage.INSTANCE);
  }
  
  public BacktrackingLexerTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
