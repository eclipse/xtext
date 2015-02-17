package org.eclipse.xtext.testlanguages.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.testlanguages.idea.completion.AbstractSimpleExpressionsTestLanguageCompletionContributor;
import org.eclipse.xtext.testlanguages.idea.lang.SimpleExpressionsTestLanguageLanguage;

@SuppressWarnings("all")
public class SimpleExpressionsTestLanguageCompletionContributor extends AbstractSimpleExpressionsTestLanguageCompletionContributor {
  public SimpleExpressionsTestLanguageCompletionContributor() {
    this(SimpleExpressionsTestLanguageLanguage.INSTANCE);
  }
  
  public SimpleExpressionsTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
