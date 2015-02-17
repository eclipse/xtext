package org.eclipse.xtext.validation.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.validation.idea.completion.AbstractConcreteSyntaxValidationTestLanguageCompletionContributor;
import org.eclipse.xtext.validation.idea.lang.ConcreteSyntaxValidationTestLanguageLanguage;

@SuppressWarnings("all")
public class ConcreteSyntaxValidationTestLanguageCompletionContributor extends AbstractConcreteSyntaxValidationTestLanguageCompletionContributor {
  public ConcreteSyntaxValidationTestLanguageCompletionContributor() {
    this(ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE);
  }
  
  public ConcreteSyntaxValidationTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
