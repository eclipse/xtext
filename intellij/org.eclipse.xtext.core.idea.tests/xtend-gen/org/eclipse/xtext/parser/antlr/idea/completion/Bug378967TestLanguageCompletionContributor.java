package org.eclipse.xtext.parser.antlr.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.antlr.idea.completion.AbstractBug378967TestLanguageCompletionContributor;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug378967TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug378967TestLanguageCompletionContributor extends AbstractBug378967TestLanguageCompletionContributor {
  public Bug378967TestLanguageCompletionContributor() {
    this(Bug378967TestLanguageLanguage.INSTANCE);
  }
  
  public Bug378967TestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
