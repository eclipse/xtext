package org.eclipse.xtext.parser.antlr.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.antlr.idea.completion.AbstractBug296889TestLanguageCompletionContributor;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug296889TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug296889TestLanguageCompletionContributor extends AbstractBug296889TestLanguageCompletionContributor {
  public Bug296889TestLanguageCompletionContributor() {
    this(Bug296889TestLanguageLanguage.INSTANCE);
  }
  
  public Bug296889TestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
