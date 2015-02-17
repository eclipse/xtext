package org.eclipse.xtext.serializer.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.serializer.idea.completion.AbstractContextFinderTestLanguageCompletionContributor;
import org.eclipse.xtext.serializer.idea.lang.ContextFinderTestLanguageLanguage;

@SuppressWarnings("all")
public class ContextFinderTestLanguageCompletionContributor extends AbstractContextFinderTestLanguageCompletionContributor {
  public ContextFinderTestLanguageCompletionContributor() {
    this(ContextFinderTestLanguageLanguage.INSTANCE);
  }
  
  public ContextFinderTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
