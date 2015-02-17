package org.eclipse.xtext.parser.antlr.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.antlr.idea.completion.AbstractBug289524TestLanguageCompletionContributor;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289524TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug289524TestLanguageCompletionContributor extends AbstractBug289524TestLanguageCompletionContributor {
  public Bug289524TestLanguageCompletionContributor() {
    this(Bug289524TestLanguageLanguage.INSTANCE);
  }
  
  public Bug289524TestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
