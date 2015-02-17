package org.eclipse.xtext.testlanguages.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.testlanguages.idea.completion.AbstractReferenceGrammarTestLanguageCompletionContributor;
import org.eclipse.xtext.testlanguages.idea.lang.ReferenceGrammarTestLanguageLanguage;

@SuppressWarnings("all")
public class ReferenceGrammarTestLanguageCompletionContributor extends AbstractReferenceGrammarTestLanguageCompletionContributor {
  public ReferenceGrammarTestLanguageCompletionContributor() {
    this(ReferenceGrammarTestLanguageLanguage.INSTANCE);
  }
  
  public ReferenceGrammarTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
