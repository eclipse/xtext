package org.eclipse.xtext.parser.datatyperules.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.datatyperules.idea.completion.AbstractDatatypeRulesTestLanguageCompletionContributor;
import org.eclipse.xtext.parser.datatyperules.idea.lang.DatatypeRulesTestLanguageLanguage;

@SuppressWarnings("all")
public class DatatypeRulesTestLanguageCompletionContributor extends AbstractDatatypeRulesTestLanguageCompletionContributor {
  public DatatypeRulesTestLanguageCompletionContributor() {
    this(DatatypeRulesTestLanguageLanguage.INSTANCE);
  }
  
  public DatatypeRulesTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
