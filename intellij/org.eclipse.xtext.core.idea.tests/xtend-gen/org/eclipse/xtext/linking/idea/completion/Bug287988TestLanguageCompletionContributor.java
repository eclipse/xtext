package org.eclipse.xtext.linking.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.linking.idea.completion.AbstractBug287988TestLanguageCompletionContributor;
import org.eclipse.xtext.linking.idea.lang.Bug287988TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug287988TestLanguageCompletionContributor extends AbstractBug287988TestLanguageCompletionContributor {
  public Bug287988TestLanguageCompletionContributor() {
    this(Bug287988TestLanguageLanguage.INSTANCE);
  }
  
  public Bug287988TestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
