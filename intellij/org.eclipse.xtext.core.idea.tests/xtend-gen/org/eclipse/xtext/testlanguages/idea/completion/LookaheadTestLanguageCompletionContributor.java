package org.eclipse.xtext.testlanguages.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.testlanguages.idea.completion.AbstractLookaheadTestLanguageCompletionContributor;
import org.eclipse.xtext.testlanguages.idea.lang.LookaheadTestLanguageLanguage;

@SuppressWarnings("all")
public class LookaheadTestLanguageCompletionContributor extends AbstractLookaheadTestLanguageCompletionContributor {
  public LookaheadTestLanguageCompletionContributor() {
    this(LookaheadTestLanguageLanguage.INSTANCE);
  }
  
  public LookaheadTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
