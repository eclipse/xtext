package org.eclipse.xtext.parser.parameters.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.parameters.idea.completion.AbstractParametersTestLanguageCompletionContributor;
import org.eclipse.xtext.parser.parameters.idea.lang.ParametersTestLanguageLanguage;

@SuppressWarnings("all")
public class ParametersTestLanguageCompletionContributor extends AbstractParametersTestLanguageCompletionContributor {
  public ParametersTestLanguageCompletionContributor() {
    this(ParametersTestLanguageLanguage.INSTANCE);
  }
  
  public ParametersTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
