package org.eclipse.xtext.parser.antlr.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.antlr.idea.completion.AbstractBug301935TestLanguageCompletionContributor;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug301935TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug301935TestLanguageCompletionContributor extends AbstractBug301935TestLanguageCompletionContributor {
  public Bug301935TestLanguageCompletionContributor() {
    this(Bug301935TestLanguageLanguage.INSTANCE);
  }
  
  public Bug301935TestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
