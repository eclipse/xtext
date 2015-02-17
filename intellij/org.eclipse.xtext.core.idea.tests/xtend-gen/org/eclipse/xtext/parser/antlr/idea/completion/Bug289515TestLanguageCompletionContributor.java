package org.eclipse.xtext.parser.antlr.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.antlr.idea.completion.AbstractBug289515TestLanguageCompletionContributor;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289515TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug289515TestLanguageCompletionContributor extends AbstractBug289515TestLanguageCompletionContributor {
  public Bug289515TestLanguageCompletionContributor() {
    this(Bug289515TestLanguageLanguage.INSTANCE);
  }
  
  public Bug289515TestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
