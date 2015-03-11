package org.eclipse.xtext.resource.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.resource.idea.completion.AbstractLiveContainerBuilderIntegerationTestLanguageCompletionContributor;
import org.eclipse.xtext.resource.idea.lang.LiveContainerBuilderIntegerationTestLanguageLanguage;

@SuppressWarnings("all")
public class LiveContainerBuilderIntegerationTestLanguageCompletionContributor extends AbstractLiveContainerBuilderIntegerationTestLanguageCompletionContributor {
  public LiveContainerBuilderIntegerationTestLanguageCompletionContributor() {
    this(LiveContainerBuilderIntegerationTestLanguageLanguage.INSTANCE);
  }
  
  public LiveContainerBuilderIntegerationTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
