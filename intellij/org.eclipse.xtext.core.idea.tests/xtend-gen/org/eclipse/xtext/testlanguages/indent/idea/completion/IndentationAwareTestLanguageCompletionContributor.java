package org.eclipse.xtext.testlanguages.indent.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.testlanguages.indent.idea.completion.AbstractIndentationAwareTestLanguageCompletionContributor;
import org.eclipse.xtext.testlanguages.indent.idea.lang.IndentationAwareTestLanguageLanguage;

@SuppressWarnings("all")
public class IndentationAwareTestLanguageCompletionContributor extends AbstractIndentationAwareTestLanguageCompletionContributor {
  public IndentationAwareTestLanguageCompletionContributor() {
    this(IndentationAwareTestLanguageLanguage.INSTANCE);
  }
  
  public IndentationAwareTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
