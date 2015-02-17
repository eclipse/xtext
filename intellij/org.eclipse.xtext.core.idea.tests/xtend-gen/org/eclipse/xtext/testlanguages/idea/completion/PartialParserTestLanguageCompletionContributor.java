package org.eclipse.xtext.testlanguages.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.testlanguages.idea.completion.AbstractPartialParserTestLanguageCompletionContributor;
import org.eclipse.xtext.testlanguages.idea.lang.PartialParserTestLanguageLanguage;

@SuppressWarnings("all")
public class PartialParserTestLanguageCompletionContributor extends AbstractPartialParserTestLanguageCompletionContributor {
  public PartialParserTestLanguageCompletionContributor() {
    this(PartialParserTestLanguageLanguage.INSTANCE);
  }
  
  public PartialParserTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
