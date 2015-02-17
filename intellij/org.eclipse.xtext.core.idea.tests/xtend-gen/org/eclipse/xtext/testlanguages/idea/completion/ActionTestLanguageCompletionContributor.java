package org.eclipse.xtext.testlanguages.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.testlanguages.idea.completion.AbstractActionTestLanguageCompletionContributor;
import org.eclipse.xtext.testlanguages.idea.lang.ActionTestLanguageLanguage;

@SuppressWarnings("all")
public class ActionTestLanguageCompletionContributor extends AbstractActionTestLanguageCompletionContributor {
  public ActionTestLanguageCompletionContributor() {
    this(ActionTestLanguageLanguage.INSTANCE);
  }
  
  public ActionTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
