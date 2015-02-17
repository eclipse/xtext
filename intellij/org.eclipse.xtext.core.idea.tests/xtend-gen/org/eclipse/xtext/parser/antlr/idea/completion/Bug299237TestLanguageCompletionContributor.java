package org.eclipse.xtext.parser.antlr.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.antlr.idea.completion.AbstractBug299237TestLanguageCompletionContributor;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug299237TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug299237TestLanguageCompletionContributor extends AbstractBug299237TestLanguageCompletionContributor {
  public Bug299237TestLanguageCompletionContributor() {
    this(Bug299237TestLanguageLanguage.INSTANCE);
  }
  
  public Bug299237TestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
