package org.eclipse.xtext.parser.antlr.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.antlr.idea.completion.AbstractBug296889ExTestLanguageCompletionContributor;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug296889ExTestLanguageLanguage;

@SuppressWarnings("all")
public class Bug296889ExTestLanguageCompletionContributor extends AbstractBug296889ExTestLanguageCompletionContributor {
  public Bug296889ExTestLanguageCompletionContributor() {
    this(Bug296889ExTestLanguageLanguage.INSTANCE);
  }
  
  public Bug296889ExTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
