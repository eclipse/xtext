package org.eclipse.xtext.parsetree.reconstr.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parsetree.reconstr.idea.completion.AbstractBug302128TestLanguageCompletionContributor;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.Bug302128TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug302128TestLanguageCompletionContributor extends AbstractBug302128TestLanguageCompletionContributor {
  public Bug302128TestLanguageCompletionContributor() {
    this(Bug302128TestLanguageLanguage.INSTANCE);
  }
  
  public Bug302128TestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
