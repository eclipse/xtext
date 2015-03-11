package org.eclipse.xtext.parser.antlr.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.antlr.idea.completion.AbstractBug289524ExTestLanguageCompletionContributor;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289524ExTestLanguageLanguage;

@SuppressWarnings("all")
public class Bug289524ExTestLanguageCompletionContributor extends AbstractBug289524ExTestLanguageCompletionContributor {
  public Bug289524ExTestLanguageCompletionContributor() {
    this(Bug289524ExTestLanguageLanguage.INSTANCE);
  }
  
  public Bug289524ExTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
