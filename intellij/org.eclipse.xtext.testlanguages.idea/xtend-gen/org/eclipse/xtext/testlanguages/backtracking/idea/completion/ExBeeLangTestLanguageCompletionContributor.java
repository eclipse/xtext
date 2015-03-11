package org.eclipse.xtext.testlanguages.backtracking.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.testlanguages.backtracking.idea.completion.AbstractExBeeLangTestLanguageCompletionContributor;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.ExBeeLangTestLanguageLanguage;

@SuppressWarnings("all")
public class ExBeeLangTestLanguageCompletionContributor extends AbstractExBeeLangTestLanguageCompletionContributor {
  public ExBeeLangTestLanguageCompletionContributor() {
    this(ExBeeLangTestLanguageLanguage.INSTANCE);
  }
  
  public ExBeeLangTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
