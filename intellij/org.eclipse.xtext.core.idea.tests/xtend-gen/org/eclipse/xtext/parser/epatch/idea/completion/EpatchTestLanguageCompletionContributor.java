package org.eclipse.xtext.parser.epatch.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.epatch.idea.completion.AbstractEpatchTestLanguageCompletionContributor;
import org.eclipse.xtext.parser.epatch.idea.lang.EpatchTestLanguageLanguage;

@SuppressWarnings("all")
public class EpatchTestLanguageCompletionContributor extends AbstractEpatchTestLanguageCompletionContributor {
  public EpatchTestLanguageCompletionContributor() {
    this(EpatchTestLanguageLanguage.INSTANCE);
  }
  
  public EpatchTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
