package org.eclipse.xtext.enumrules.idea.completion;

import org.eclipse.xtext.enumrules.idea.completion.AbstractEnumRulesTestLanguageCompletionContributor;
import org.eclipse.xtext.enumrules.idea.lang.EnumRulesTestLanguageLanguage;
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

@SuppressWarnings("all")
public class EnumRulesTestLanguageCompletionContributor extends AbstractEnumRulesTestLanguageCompletionContributor {
  public EnumRulesTestLanguageCompletionContributor() {
    this(EnumRulesTestLanguageLanguage.INSTANCE);
  }
  
  public EnumRulesTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
