package org.eclipse.xtext.resource.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.resource.idea.completion.AbstractLiveContainerTestLanguageCompletionContributor;
import org.eclipse.xtext.resource.idea.lang.LiveContainerTestLanguageLanguage;

@SuppressWarnings("all")
public class LiveContainerTestLanguageCompletionContributor extends AbstractLiveContainerTestLanguageCompletionContributor {
  public LiveContainerTestLanguageCompletionContributor() {
    this(LiveContainerTestLanguageLanguage.INSTANCE);
  }
  
  public LiveContainerTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
