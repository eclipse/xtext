package org.eclipse.xtext.testlanguages.backtracking.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.testlanguages.backtracking.idea.completion.AbstractBeeLangTestLanguageCompletionContributor;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.BeeLangTestLanguageLanguage;

@SuppressWarnings("all")
public class BeeLangTestLanguageCompletionContributor extends AbstractBeeLangTestLanguageCompletionContributor {
  public BeeLangTestLanguageCompletionContributor() {
    this(BeeLangTestLanguageLanguage.INSTANCE);
  }
  
  public BeeLangTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
