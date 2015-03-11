package org.eclipse.xtext.xtext.ecoreInference.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.xtext.ecoreInference.idea.completion.AbstractUnassignedRuleCallTestLanguageCompletionContributor;
import org.eclipse.xtext.xtext.ecoreInference.idea.lang.UnassignedRuleCallTestLanguageLanguage;

@SuppressWarnings("all")
public class UnassignedRuleCallTestLanguageCompletionContributor extends AbstractUnassignedRuleCallTestLanguageCompletionContributor {
  public UnassignedRuleCallTestLanguageCompletionContributor() {
    this(UnassignedRuleCallTestLanguageLanguage.INSTANCE);
  }
  
  public UnassignedRuleCallTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
