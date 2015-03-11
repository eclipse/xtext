package org.eclipse.xtext.generator.grammarAccess.idea.completion;

import org.eclipse.xtext.generator.grammarAccess.idea.completion.AbstractGrammarAccessTestLanguageCompletionContributor;
import org.eclipse.xtext.generator.grammarAccess.idea.lang.GrammarAccessTestLanguageLanguage;
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

@SuppressWarnings("all")
public class GrammarAccessTestLanguageCompletionContributor extends AbstractGrammarAccessTestLanguageCompletionContributor {
  public GrammarAccessTestLanguageCompletionContributor() {
    this(GrammarAccessTestLanguageLanguage.INSTANCE);
  }
  
  public GrammarAccessTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
