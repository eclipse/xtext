package org.eclipse.xtext.parser.terminalrules.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.terminalrules.idea.completion.AbstractHiddenTerminalsTestLanguageCompletionContributor;
import org.eclipse.xtext.parser.terminalrules.idea.lang.HiddenTerminalsTestLanguageLanguage;

@SuppressWarnings("all")
public class HiddenTerminalsTestLanguageCompletionContributor extends AbstractHiddenTerminalsTestLanguageCompletionContributor {
  public HiddenTerminalsTestLanguageCompletionContributor() {
    this(HiddenTerminalsTestLanguageLanguage.INSTANCE);
  }
  
  public HiddenTerminalsTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
