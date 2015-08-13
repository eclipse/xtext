package org.eclipse.xtext.parser.parameters.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.parameters.idea.completion.AbstractParametersTestLanguageExCompletionContributor;
import org.eclipse.xtext.parser.parameters.idea.lang.ParametersTestLanguageExLanguage;

@SuppressWarnings("all")
public class ParametersTestLanguageExCompletionContributor extends AbstractParametersTestLanguageExCompletionContributor {
  public ParametersTestLanguageExCompletionContributor() {
    this(ParametersTestLanguageExLanguage.INSTANCE);
  }
  
  public ParametersTestLanguageExCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
