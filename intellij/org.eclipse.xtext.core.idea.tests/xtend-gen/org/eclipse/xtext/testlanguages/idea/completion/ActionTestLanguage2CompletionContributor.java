package org.eclipse.xtext.testlanguages.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.testlanguages.idea.completion.AbstractActionTestLanguage2CompletionContributor;
import org.eclipse.xtext.testlanguages.idea.lang.ActionTestLanguage2Language;

@SuppressWarnings("all")
public class ActionTestLanguage2CompletionContributor extends AbstractActionTestLanguage2CompletionContributor {
  public ActionTestLanguage2CompletionContributor() {
    this(ActionTestLanguage2Language.INSTANCE);
  }
  
  public ActionTestLanguage2CompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
