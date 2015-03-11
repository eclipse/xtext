package org.eclipse.xtext.linking.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.linking.idea.completion.AbstractLangATestLanguageCompletionContributor;
import org.eclipse.xtext.linking.idea.lang.LangATestLanguageLanguage;

@SuppressWarnings("all")
public class LangATestLanguageCompletionContributor extends AbstractLangATestLanguageCompletionContributor {
  public LangATestLanguageCompletionContributor() {
    this(LangATestLanguageLanguage.INSTANCE);
  }
  
  public LangATestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
