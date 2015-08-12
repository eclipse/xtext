package org.eclipse.xtext.parser.parameters.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.parameters.idea.completion.AbstractTwoParametersTestLanguageCompletionContributor;
import org.eclipse.xtext.parser.parameters.idea.lang.TwoParametersTestLanguageLanguage;

@SuppressWarnings("all")
public class TwoParametersTestLanguageCompletionContributor extends AbstractTwoParametersTestLanguageCompletionContributor {
  public TwoParametersTestLanguageCompletionContributor() {
    this(TwoParametersTestLanguageLanguage.INSTANCE);
  }
  
  public TwoParametersTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
