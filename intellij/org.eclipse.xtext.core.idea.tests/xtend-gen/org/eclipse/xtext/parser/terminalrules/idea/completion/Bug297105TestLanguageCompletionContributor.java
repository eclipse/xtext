package org.eclipse.xtext.parser.terminalrules.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.terminalrules.idea.completion.AbstractBug297105TestLanguageCompletionContributor;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug297105TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug297105TestLanguageCompletionContributor extends AbstractBug297105TestLanguageCompletionContributor {
  public Bug297105TestLanguageCompletionContributor() {
    this(Bug297105TestLanguageLanguage.INSTANCE);
  }
  
  public Bug297105TestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
