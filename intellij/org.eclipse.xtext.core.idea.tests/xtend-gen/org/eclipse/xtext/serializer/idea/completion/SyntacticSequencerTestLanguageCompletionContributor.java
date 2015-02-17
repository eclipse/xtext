package org.eclipse.xtext.serializer.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.serializer.idea.completion.AbstractSyntacticSequencerTestLanguageCompletionContributor;
import org.eclipse.xtext.serializer.idea.lang.SyntacticSequencerTestLanguageLanguage;

@SuppressWarnings("all")
public class SyntacticSequencerTestLanguageCompletionContributor extends AbstractSyntacticSequencerTestLanguageCompletionContributor {
  public SyntacticSequencerTestLanguageCompletionContributor() {
    this(SyntacticSequencerTestLanguageLanguage.INSTANCE);
  }
  
  public SyntacticSequencerTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
