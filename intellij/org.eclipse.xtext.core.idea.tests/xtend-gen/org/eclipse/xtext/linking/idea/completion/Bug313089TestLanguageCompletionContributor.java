package org.eclipse.xtext.linking.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.linking.idea.completion.AbstractBug313089TestLanguageCompletionContributor;
import org.eclipse.xtext.linking.idea.lang.Bug313089TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug313089TestLanguageCompletionContributor extends AbstractBug313089TestLanguageCompletionContributor {
  public Bug313089TestLanguageCompletionContributor() {
    this(Bug313089TestLanguageLanguage.INSTANCE);
  }
  
  public Bug313089TestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
