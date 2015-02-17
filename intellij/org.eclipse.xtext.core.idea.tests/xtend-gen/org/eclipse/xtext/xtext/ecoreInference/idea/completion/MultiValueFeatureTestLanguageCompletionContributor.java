package org.eclipse.xtext.xtext.ecoreInference.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.xtext.ecoreInference.idea.completion.AbstractMultiValueFeatureTestLanguageCompletionContributor;
import org.eclipse.xtext.xtext.ecoreInference.idea.lang.MultiValueFeatureTestLanguageLanguage;

@SuppressWarnings("all")
public class MultiValueFeatureTestLanguageCompletionContributor extends AbstractMultiValueFeatureTestLanguageCompletionContributor {
  public MultiValueFeatureTestLanguageCompletionContributor() {
    this(MultiValueFeatureTestLanguageLanguage.INSTANCE);
  }
  
  public MultiValueFeatureTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
