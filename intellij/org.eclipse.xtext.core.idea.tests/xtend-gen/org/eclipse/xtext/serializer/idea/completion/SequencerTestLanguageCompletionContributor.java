package org.eclipse.xtext.serializer.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.serializer.idea.completion.AbstractSequencerTestLanguageCompletionContributor;
import org.eclipse.xtext.serializer.idea.lang.SequencerTestLanguageLanguage;

@SuppressWarnings("all")
public class SequencerTestLanguageCompletionContributor extends AbstractSequencerTestLanguageCompletionContributor {
  public SequencerTestLanguageCompletionContributor() {
    this(SequencerTestLanguageLanguage.INSTANCE);
  }
  
  public SequencerTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
