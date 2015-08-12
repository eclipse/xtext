package org.eclipse.xtext.parser.parameters.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.parameters.idea.completion.AbstractNoParametersTestLanguageCompletionContributor;
import org.eclipse.xtext.parser.parameters.idea.lang.NoParametersTestLanguageLanguage;

@SuppressWarnings("all")
public class NoParametersTestLanguageCompletionContributor extends AbstractNoParametersTestLanguageCompletionContributor {
  public NoParametersTestLanguageCompletionContributor() {
    this(NoParametersTestLanguageLanguage.INSTANCE);
  }
  
  public NoParametersTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
