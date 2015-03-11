package org.eclipse.xtext.serializer.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.serializer.idea.completion.AbstractHiddenTokenSequencerTestLanguageCompletionContributor;
import org.eclipse.xtext.serializer.idea.lang.HiddenTokenSequencerTestLanguageLanguage;

@SuppressWarnings("all")
public class HiddenTokenSequencerTestLanguageCompletionContributor extends AbstractHiddenTokenSequencerTestLanguageCompletionContributor {
  public HiddenTokenSequencerTestLanguageCompletionContributor() {
    this(HiddenTokenSequencerTestLanguageLanguage.INSTANCE);
  }
  
  public HiddenTokenSequencerTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
