package org.eclipse.xtext.enumrules.idea.completion;

import org.eclipse.xtext.enumrules.idea.completion.AbstractMultiRuleEnumTestLanguageCompletionContributor;
import org.eclipse.xtext.enumrules.idea.lang.MultiRuleEnumTestLanguageLanguage;
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

@SuppressWarnings("all")
public class MultiRuleEnumTestLanguageCompletionContributor extends AbstractMultiRuleEnumTestLanguageCompletionContributor {
  public MultiRuleEnumTestLanguageCompletionContributor() {
    this(MultiRuleEnumTestLanguageLanguage.INSTANCE);
  }
  
  public MultiRuleEnumTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
