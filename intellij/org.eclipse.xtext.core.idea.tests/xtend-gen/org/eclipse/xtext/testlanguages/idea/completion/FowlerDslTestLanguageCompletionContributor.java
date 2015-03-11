package org.eclipse.xtext.testlanguages.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.testlanguages.idea.completion.AbstractFowlerDslTestLanguageCompletionContributor;
import org.eclipse.xtext.testlanguages.idea.lang.FowlerDslTestLanguageLanguage;

@SuppressWarnings("all")
public class FowlerDslTestLanguageCompletionContributor extends AbstractFowlerDslTestLanguageCompletionContributor {
  public FowlerDslTestLanguageCompletionContributor() {
    this(FowlerDslTestLanguageLanguage.INSTANCE);
  }
  
  public FowlerDslTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
