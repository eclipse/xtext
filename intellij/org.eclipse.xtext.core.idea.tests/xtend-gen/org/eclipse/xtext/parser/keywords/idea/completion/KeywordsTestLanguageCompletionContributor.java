package org.eclipse.xtext.parser.keywords.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.keywords.idea.completion.AbstractKeywordsTestLanguageCompletionContributor;
import org.eclipse.xtext.parser.keywords.idea.lang.KeywordsTestLanguageLanguage;

@SuppressWarnings("all")
public class KeywordsTestLanguageCompletionContributor extends AbstractKeywordsTestLanguageCompletionContributor {
  public KeywordsTestLanguageCompletionContributor() {
    this(KeywordsTestLanguageLanguage.INSTANCE);
  }
  
  public KeywordsTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
