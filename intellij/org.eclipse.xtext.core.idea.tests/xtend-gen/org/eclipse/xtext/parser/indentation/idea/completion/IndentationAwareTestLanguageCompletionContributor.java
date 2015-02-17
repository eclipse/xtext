package org.eclipse.xtext.parser.indentation.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.indentation.idea.completion.AbstractIndentationAwareTestLanguageCompletionContributor;
import org.eclipse.xtext.parser.indentation.idea.lang.IndentationAwareTestLanguageLanguage;

@SuppressWarnings("all")
public class IndentationAwareTestLanguageCompletionContributor extends AbstractIndentationAwareTestLanguageCompletionContributor {
  public IndentationAwareTestLanguageCompletionContributor() {
    this(IndentationAwareTestLanguageLanguage.INSTANCE);
  }
  
  public IndentationAwareTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
