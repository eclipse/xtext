package org.eclipse.xtext.linking.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.linking.idea.completion.AbstractBug289059TestLanguageCompletionContributor;
import org.eclipse.xtext.linking.idea.lang.Bug289059TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug289059TestLanguageCompletionContributor extends AbstractBug289059TestLanguageCompletionContributor {
  public Bug289059TestLanguageCompletionContributor() {
    this(Bug289059TestLanguageLanguage.INSTANCE);
  }
  
  public Bug289059TestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
