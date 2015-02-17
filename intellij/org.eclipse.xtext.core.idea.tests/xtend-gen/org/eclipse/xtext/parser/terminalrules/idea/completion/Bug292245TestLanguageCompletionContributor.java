package org.eclipse.xtext.parser.terminalrules.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.terminalrules.idea.completion.AbstractBug292245TestLanguageCompletionContributor;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug292245TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug292245TestLanguageCompletionContributor extends AbstractBug292245TestLanguageCompletionContributor {
  public Bug292245TestLanguageCompletionContributor() {
    this(Bug292245TestLanguageLanguage.INSTANCE);
  }
  
  public Bug292245TestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
