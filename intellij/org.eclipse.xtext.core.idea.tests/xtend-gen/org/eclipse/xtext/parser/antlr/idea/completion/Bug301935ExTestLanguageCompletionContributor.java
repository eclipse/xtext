package org.eclipse.xtext.parser.antlr.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.antlr.idea.completion.AbstractBug301935ExTestLanguageCompletionContributor;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug301935ExTestLanguageLanguage;

@SuppressWarnings("all")
public class Bug301935ExTestLanguageCompletionContributor extends AbstractBug301935ExTestLanguageCompletionContributor {
  public Bug301935ExTestLanguageCompletionContributor() {
    this(Bug301935ExTestLanguageLanguage.INSTANCE);
  }
  
  public Bug301935ExTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
