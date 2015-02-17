package org.eclipse.xtext.parser.terminalrules.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.terminalrules.idea.completion.AbstractBug317840TestLanguageCompletionContributor;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug317840TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug317840TestLanguageCompletionContributor extends AbstractBug317840TestLanguageCompletionContributor {
  public Bug317840TestLanguageCompletionContributor() {
    this(Bug317840TestLanguageLanguage.INSTANCE);
  }
  
  public Bug317840TestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
