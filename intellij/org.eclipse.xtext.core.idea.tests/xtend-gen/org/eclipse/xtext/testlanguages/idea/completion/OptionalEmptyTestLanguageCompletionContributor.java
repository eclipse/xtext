package org.eclipse.xtext.testlanguages.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.testlanguages.idea.completion.AbstractOptionalEmptyTestLanguageCompletionContributor;
import org.eclipse.xtext.testlanguages.idea.lang.OptionalEmptyTestLanguageLanguage;

@SuppressWarnings("all")
public class OptionalEmptyTestLanguageCompletionContributor extends AbstractOptionalEmptyTestLanguageCompletionContributor {
  public OptionalEmptyTestLanguageCompletionContributor() {
    this(OptionalEmptyTestLanguageLanguage.INSTANCE);
  }
  
  public OptionalEmptyTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
