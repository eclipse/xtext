package org.eclipse.xtext.parser.antlr.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.antlr.idea.completion.AbstractBug443221TestLanguageCompletionContributor;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug443221TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug443221TestLanguageCompletionContributor extends AbstractBug443221TestLanguageCompletionContributor {
  public Bug443221TestLanguageCompletionContributor() {
    this(Bug443221TestLanguageLanguage.INSTANCE);
  }
  
  public Bug443221TestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
