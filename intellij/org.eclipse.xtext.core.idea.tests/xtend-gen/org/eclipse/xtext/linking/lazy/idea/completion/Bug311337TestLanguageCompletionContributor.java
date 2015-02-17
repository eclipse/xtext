package org.eclipse.xtext.linking.lazy.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.linking.lazy.idea.completion.AbstractBug311337TestLanguageCompletionContributor;
import org.eclipse.xtext.linking.lazy.idea.lang.Bug311337TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug311337TestLanguageCompletionContributor extends AbstractBug311337TestLanguageCompletionContributor {
  public Bug311337TestLanguageCompletionContributor() {
    this(Bug311337TestLanguageLanguage.INSTANCE);
  }
  
  public Bug311337TestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
