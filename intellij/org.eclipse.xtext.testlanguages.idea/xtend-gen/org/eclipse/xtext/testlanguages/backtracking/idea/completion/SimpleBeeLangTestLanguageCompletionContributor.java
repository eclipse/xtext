package org.eclipse.xtext.testlanguages.backtracking.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.testlanguages.backtracking.idea.completion.AbstractSimpleBeeLangTestLanguageCompletionContributor;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.SimpleBeeLangTestLanguageLanguage;

@SuppressWarnings("all")
public class SimpleBeeLangTestLanguageCompletionContributor extends AbstractSimpleBeeLangTestLanguageCompletionContributor {
  public SimpleBeeLangTestLanguageCompletionContributor() {
    this(SimpleBeeLangTestLanguageLanguage.INSTANCE);
  }
  
  public SimpleBeeLangTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
